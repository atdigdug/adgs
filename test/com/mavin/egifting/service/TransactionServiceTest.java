package com.mavin.egifting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.model.Application;
import com.mavin.egifting.model.ApplicationCodeProvider;
import com.mavin.egifting.model.ApplicationSku;
import com.mavin.egifting.model.Campaign;
import com.mavin.egifting.model.CampaignSku;
import com.mavin.egifting.model.CampaignTemplate;
import com.mavin.egifting.model.CampaignTemplateSku;
import com.mavin.egifting.model.Transaction;
import com.mavin.egifting.utils.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class TransactionServiceTest {

	@Autowired
	ApplicationService applicationService;
	@Autowired
	ApplicationSkuService applicationSkuService;
	@Autowired
	CampaignTemplateService campaignTemplateService;
	@Autowired
	CampaignTemplateSkuService campaignTemplateSkuService;
	@Autowired
	CampaignService campaignService;
	@Autowired
	ApplicationCodeProviderService applicationCodeProviderService;
	@Autowired
	CampaignSkuService campaignSkuService;
	@Autowired
	TransactionService transactionService;

	@Test
	public void testTransactionCrud() {

		Application application = new Application();
		application.setName("UT - Application Name");
		application.setWebsiteUrl("http://website/url");
		application.setCallbackApi("http://callback/api");
		application.setGoogleAppStoreUrl("http://google/appstore/url");
		application.setItunesUrl("http://itunes/url");
		application.setStatus("active");
		application = applicationService.createApplication(application);

		ApplicationSku applicationSku = new ApplicationSku();
		applicationSku.setName("UT - Application Sku Name");
		applicationSku.setApplictionId(application.getId());
		applicationSku.setPrice(new BigDecimal("10.32"));
		applicationSku.setSkuId(UUID.randomUUID().toString());
		applicationSku.setStatus("active");
		applicationSku = applicationSkuService.createApplicationSku(applicationSku);

		CampaignTemplate campaignTemplate = new CampaignTemplate();
		campaignTemplate.setApplicationId(application.getId());
		campaignTemplate.setEmailLogo("http://email/logo");
		campaignTemplate.setName("UT - Campaign Template Name");
		campaignTemplate.setRecipientEmailBody(
				"In the beginning, the universe was created. This has made a lot of people very angry and been widely regarded as a bad move.");
		campaignTemplate.setRecipientEmailSubject("Douglas Adams");
		campaignTemplate.setRecipientWebText("All this happened, more or less.");
		campaignTemplate
				.setSenderEmailBody("It was a bright cold day in April, and the clocks were striking thirteen. ");
		campaignTemplate.setSenderEmailSubject("George Orwell");
		campaignTemplate.setSenderWebText("I am an invisible man");
		campaignTemplate.setWebLogo("http://weblogo/url");
		campaignTemplate = campaignTemplateService.createCampaignTemplate(campaignTemplate);

		CampaignTemplateSku campaignTemplateSku = new CampaignTemplateSku();
		campaignTemplateSku.setApplicationSkuId(applicationSku.getId());
		campaignTemplateSku.setCampaignTemplateId(campaignTemplate.getId());
		campaignTemplateSku = campaignTemplateSkuService.createCampaignTemplateSku(campaignTemplateSku);

		Campaign campaign = new Campaign();
		campaign.setApplicationId(application.getId());
		campaign.setCampaignTemplateId(campaignTemplate.getId());
		campaign.setName("UT - Campaign Name");
		campaign = campaignService.createCampaign(campaign);

		List<CampaignSku> campaignSkus = campaignSkuService.getByCampaignId(campaign.getId());

		ApplicationCodeProvider acp = new ApplicationCodeProvider();
		acp.setApplicationId(application.getId());
		acp.setCode("Application Code");
		acp.setStatus(Status.ACTIVE.toString());
		acp.setValidUntilDate(System.currentTimeMillis());
		acp = applicationCodeProviderService.createApplicationCodeProvider(acp);

		Transaction transaction = new Transaction();
		transaction.setApplicationCodeProviderId(acp.getId());
		transaction.setCampaignId(campaign.getId());
		transaction.setCampaignSkuId(campaignSkus.get(0).getId());
		transaction.setPaymentProviderId(UUID.randomUUID().toString());
		transaction.setRecipientActivatedEmail("Recipient Activated Email Column");
		transaction.setRecipientActivationSuccessDate(System.currentTimeMillis());
		transaction.setRecipientClickedEmailLinkDate(System.currentTimeMillis());
		transaction.setRecipientEmail("Reciepient Email");
		transaction.setRecipientName("Recipient Name");
		transaction.setSenderEmail("Sender Email");
		transaction.setSenderName("Sender Name");
		transaction.setSenderPaymentDate(System.currentTimeMillis());
		transaction.setSenderPaymentStatus(Status.PENDING.toString());

		transaction = transactionService.createTransaction(transaction);
		assertNotNull(transaction);
		assertNotNull(transaction.getId());
		assertEquals(Status.PENDING.toString(), transaction.getSenderPaymentStatus());

		transaction.setSenderPaymentStatus(Status.ACTIVE.toString());

		transaction = transactionService.updateTransaction(transaction);
		assertNotNull(transaction);
		assertNotNull(transaction.getId());
		assertEquals(Status.ACTIVE.toString(), transaction.getSenderPaymentStatus());

		transaction = transactionService.getTransactionById(transaction.getId());
		assertNotNull(transaction);
		assertNotNull(transaction.getId());
		assertEquals(Status.ACTIVE.toString(), transaction.getSenderPaymentStatus());

		List<Transaction> transactions = transactionService.getAllTransactions();
		assertNotNull(transactions);
		assertTrue(transactions.size() > 0);
	}
}
