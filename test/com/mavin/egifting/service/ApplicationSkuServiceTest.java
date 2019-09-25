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
import com.mavin.egifting.model.ApplicationSku;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class ApplicationSkuServiceTest {

	@Autowired
	ApplicationService applicationService;
	@Autowired
	ApplicationSkuService applicationSkuService;

	@Test
	public void testApplicationSkuCrud() {
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

		ApplicationSku applicationSku = new ApplicationSku();
		applicationSku.setName("UT - Application Sku Name");
		applicationSku.setApplictionId(application.getId());
		applicationSku.setPrice(new BigDecimal("10.32"));
		applicationSku.setSkuId(UUID.randomUUID().toString());
		applicationSku.setStatus("active");

		applicationSku = applicationSkuService.createApplicationSku(applicationSku);

		assertNotNull(applicationSku);
		assertNotNull(applicationSku.getId());
		assertEquals("active", applicationSku.getStatus());

		applicationSku.setStatus("inactive");
		applicationSku = applicationSkuService.updateApplicationSku(applicationSku);
		assertNotNull(applicationSku);
		assertNotNull(applicationSku.getId());
		assertEquals("inactive", applicationSku.getStatus());

		applicationSku = applicationSkuService.getApplicationSkuById(applicationSku.getId());
		assertNotNull(applicationSku);
		assertNotNull(applicationSku.getId());
		assertEquals("inactive", applicationSku.getStatus());

		List<ApplicationSku> applicationSkus = applicationSkuService.getAllApplicationSkus();
		assertNotNull(applicationSkus);
		assertTrue(applicationSkus.size() > 0);

	}

}
