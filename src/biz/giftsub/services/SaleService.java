package biz.giftsub.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

import biz.giftsub.daos.SaleMapper;
import biz.giftsub.models.Email;
import biz.giftsub.models.Organization;
import biz.giftsub.models.Sale;

@Component
public class SaleService {

	@Autowired
	SaleMapper saleMapper;
	@Autowired
	EmailService emailService;
	@Autowired
	OrganizationService organizationService;

	public Sale createSale(Sale sale) {
		sale.setId(UUID.randomUUID().toString());
		sale.setSaleEpoch(System.currentTimeMillis());
		sale.setPaymentId("DEADBEEF-" + UUID.randomUUID().toString());
		int rows = saleMapper.insertSale(sale);
		if (1 != rows) {
			return null;
		}

		Organization org = organizationService.getOrganizationByCampaignId(sale.getCampaignId());
		Email email = copyFromSaleAndOrgToEmail(sale, org);
		email = setDefaultEmailParams(email);
		email.setTemplateName("Receiver.ftl");
		emailService.sendEmail(email);

		return sale;
	}

	public Sale getSale(String saleId) {
		Sale sale = saleMapper.getSale(saleId);
		return sale;
	}

	public Sale updateClaimedEmail(String saleId, String claimedEmail) {
		Preconditions.checkNotNull(claimedEmail);
		Sale sale = new Sale();
		sale.setId(saleId);
		sale.setClaimedEmail(claimedEmail);
		sale.setOtp(generateOtp());
		int rows = saleMapper.updateSaleClaimedEmail(sale);
		if (1 != rows) {
			return null;
		}

		sale = getSale(saleId);
		Organization org = organizationService.getOrganizationByCampaignId(sale.getCampaignId());
		Email email = copyFromSaleAndOrgToEmail(sale, org);
		email = setDefaultEmailParams(email);

		// Must override recipient email with claimed email
		email.setToEmail(claimedEmail);

		email.setTemplateName("ActivateOtp.ftl");
		emailService.sendEmail(email);

		return sale;
	}

	private String generateOtp() {
		return Integer.toString((int) (Math.random() * 899999) + 100000);
	}

	public Sale activateOtp(String saleId, String otp) {
		Preconditions.checkNotNull(otp);
		Sale sale = getSale(saleId);
		if (otp.equalsIgnoreCase(sale.getOtp())) {
			int rows = saleMapper.updateSaleActivateOtp(sale);
			if (1 != rows) {
				return null;
			}
			return sale;
		} else {
			return null;
		}
	}

	private Email setDefaultEmailParams(Email email) {
		email.setFromEmail("gift@giftsub.biz");
		return email;
	}

	private Email copyFromSaleAndOrgToEmail(Sale sale, Organization org) {
		Email email = new Email();
		email.setFromEmail(sale.getSenderEmail());
		email.setToEmail(sale.getRecipientEmail());
		email.setEmailSubject("GiftSub gift");
		email.setOrganization(org.getName());
		email.setRecipientName(sale.getRecipientName());
		email.setSenderName(sale.getSenderName());
		email.setGiftName(sale.getGiftName());
		email.setGiftPrice(sale.getGiftPrice().toString());
		email.setMessage(sale.getSenderMessage());
		email.setOtp(sale.getOtp());
		email.setSaleId(sale.getId());
		return email;
	}

}
