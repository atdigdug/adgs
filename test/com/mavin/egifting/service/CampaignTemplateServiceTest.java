package com.mavin.egifting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.model.Application;
import com.mavin.egifting.model.CampaignTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class CampaignTemplateServiceTest {

	@Autowired
	ApplicationService applicationService;
	@Autowired
	CampaignTemplateService campaignTemplateService;
	
	@Test
	public void testCampaignTemplateCrud() {
		Application application = new Application();
		application.setName("UT - Application Name");
		application.setWebsiteUrl("http://website/url");
		application.setCallbackApi("http://callback/api");
		application.setGoogleAppStoreUrl("http://google/appstore/url");
		application.setItunesUrl("http://itunes/url");
		application.setStatus("active");

		application = applicationService.createApplication(application);
		assertNotNull(application);
		assertNotNull(application.getId());
		
		CampaignTemplate campaignTemplate = new CampaignTemplate();
		campaignTemplate.setApplicationId(application.getId());
		campaignTemplate.setEmailLogo("http://email/logo");
		campaignTemplate.setName("UT - Campaign Template Name");
		campaignTemplate.setRecipientEmailBody("In the beginning, the universe was created. This has made a lot of people very angry and been widely regarded as a bad move.");
		campaignTemplate.setRecipientEmailSubject("Douglas Adams");
		campaignTemplate.setRecipientWebText("All this happened, more or less.");
		campaignTemplate.setSenderEmailBody("It was a bright cold day in April, and the clocks were striking thirteen. ");
		campaignTemplate.setSenderEmailSubject("George Orwell");
		campaignTemplate.setSenderWebText("I am an invisible man");
		campaignTemplate.setWebLogo("http://weblogo/url");
		
		campaignTemplate = campaignTemplateService.createCampaignTemplate(campaignTemplate);
		assertNotNull(campaignTemplate);
		assertNotNull(campaignTemplate.getId());
		assertEquals("George Orwell", campaignTemplate.getSenderEmailSubject());
		
		campaignTemplate.setSenderEmailSubject("1984");
		campaignTemplate = campaignTemplateService.updateCampaignTemplate(campaignTemplate);
		assertNotNull(campaignTemplate);
		assertNotNull(campaignTemplate.getId());
		assertEquals("1984", campaignTemplate.getSenderEmailSubject());
		
		campaignTemplate = campaignTemplateService.getCampaignTemplateById(campaignTemplate.getId());
		assertNotNull(campaignTemplate);
		assertNotNull(campaignTemplate.getId());
		assertEquals("1984", campaignTemplate.getSenderEmailSubject());
		
		List<CampaignTemplate> campaignTemplates = campaignTemplateService.getAllCampaignTemplates();
		assertNotNull(campaignTemplates);
		assertTrue(campaignTemplates.size() > 0);
		
	}

}
