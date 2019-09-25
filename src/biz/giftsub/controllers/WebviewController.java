package biz.giftsub.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import biz.giftsub.models.Campaign;
import biz.giftsub.models.Gift;
import biz.giftsub.models.Organization;
import biz.giftsub.models.Sale;
import biz.giftsub.models.WebviewCampaign;
import biz.giftsub.models.WebviewCampaignDetails;
import biz.giftsub.models.WebviewOrganizationDetails;
import biz.giftsub.models.WebviewSale;
import biz.giftsub.services.CampaignService;
import biz.giftsub.services.OrganizationService;
import biz.giftsub.services.SaleService;

@ComponentScan
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:9000"})
@RequestMapping("/webview/v1")
public class WebviewController {

    @Autowired
    CampaignService campaignService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
	SaleService saleService;

    Logger logger = Logger.getLogger(WebviewController.class);

	@RequestMapping(value = "/campaigns/{organizationPath}", method = RequestMethod.GET)
    public WebviewCampaign getCampaign(@PathVariable String organizationPath, HttpServletResponse response) {
		Organization organization = organizationService.getOrganizationByPath(organizationPath);
		if (null == organization) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		Campaign campaign = campaignService.getActiveCampaignFromOrganizationPath(organizationPath);
		if (null == campaign) {
			campaign = new Campaign();
			campaign.setId("NO_ACTIVE"); // hard-coded handshake with front-end
		}
        WebviewCampaign w = copyFromOrganizationAndCampaignToWebviewCampaign(organization, campaign);
        return w;
    }

	@RequestMapping(value = "/sales/{saleId}", method = RequestMethod.GET)
	public WebviewSale getSale(@PathVariable String saleId) {
		Sale sale = saleService.getSale(saleId);
		Organization org = organizationService.getOrganizationByCampaignId(sale.getCampaignId());
		WebviewSale wvSale = copyFromSaleAndOrgToWebviewSale(sale, org);
		return wvSale;
	}

	@RequestMapping(value = "/sales", method = RequestMethod.POST)
	public WebviewSale createSale(@RequestBody WebviewSale wvSale) {
		Sale sale = copyFromWebviewSaleToSale(wvSale);
		Sale successfulSale = saleService.createSale(sale);
		WebviewSale wvSuccessfulSale = copyFromSaleAndOrgToWebviewSale(successfulSale, null);
		return wvSuccessfulSale;
	}

	@RequestMapping(value = "/sales/{saleId}/claimedemail", method = RequestMethod.PUT)
	public WebviewSale updateClaimedEmail(@PathVariable String saleId, @RequestBody WebviewSale wvSale) {
		Sale sale = saleService.updateClaimedEmail(saleId, wvSale.getClaimedEmail());
		WebviewSale updatedSale = copyFromSaleAndOrgToWebviewSale(sale, null);
		return updatedSale;
	}

	@RequestMapping(value = "/sales/{saleId}/otp", method = RequestMethod.PUT)
	public WebviewSale activateOtp(@PathVariable String saleId, @RequestBody WebviewSale wvSale, HttpServletResponse response) {
		Sale sale = saleService.activateOtp(saleId, wvSale.getOtp());
		if (null == sale) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		WebviewSale updatedSale = copyFromSaleAndOrgToWebviewSale(sale, null);
		return updatedSale;
	}

    private WebviewOrganizationDetails copyFromOrganizationToWebviewOrganizationDetails(Organization org) {
    	if (null == org)
    		return null;

    	WebviewOrganizationDetails orgDetails = new WebviewOrganizationDetails();
		BeanUtils.copyProperties(org, orgDetails);
		return orgDetails;
	}

	private WebviewCampaign copyFromOrganizationAndCampaignToWebviewCampaign(Organization org, Campaign c) {
    	WebviewCampaign w = new WebviewCampaign();
    	WebviewOrganizationDetails orgDetails = copyFromOrganizationToWebviewOrganizationDetails(org);
    	WebviewCampaignDetails campaignDetails = new WebviewCampaignDetails();
		BeanUtils.copyProperties(c, campaignDetails);
		if (!Strings.isNullOrEmpty(c.getGift1Name())) addCampaignGiftToWebviewCampaignDetails(c.getGift1Name(), c.getGift1Price(), campaignDetails); 
		if (!Strings.isNullOrEmpty(c.getGift2Name())) addCampaignGiftToWebviewCampaignDetails(c.getGift2Name(), c.getGift2Price(), campaignDetails); 
		if (!Strings.isNullOrEmpty(c.getGift3Name())) addCampaignGiftToWebviewCampaignDetails(c.getGift3Name(), c.getGift3Price(), campaignDetails); 
		w.setOrganization(orgDetails);
		w.setCampaign(campaignDetails);
		return w;
	}

	private void addCampaignGiftToWebviewCampaignDetails(String giftName, BigDecimal giftPrice, WebviewCampaignDetails w) {
    	List<Gift> giftList = (null != w.getGifts()) ? w.getGifts() : new ArrayList<Gift>();
    	Gift gift = new Gift();
    	gift.setName(giftName);
    	gift.setPrice(giftPrice);
		giftList.add(gift);
		w.setGifts(giftList);
	}

	private Sale copyFromWebviewSaleToSale(WebviewSale w) {
		Sale s = new Sale();
		BeanUtils.copyProperties(w, s);
		s.setId(w.getSaleId());
		s.setSenderMessage(w.getMessage());
		return s;
	}

	private WebviewSale copyFromSaleAndOrgToWebviewSale(Sale s, Organization o) {
		WebviewSale w = new WebviewSale();
		WebviewOrganizationDetails orgDetails = copyFromOrganizationToWebviewOrganizationDetails(o);
		BeanUtils.copyProperties(s, w);
		w.setSaleId(s.getId());
		w.setMessage(s.getSenderMessage());
		w.setOrganization(orgDetails);
		return w;
	}

}
