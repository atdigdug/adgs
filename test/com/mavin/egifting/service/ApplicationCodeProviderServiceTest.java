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
import com.mavin.egifting.model.ApplicationCodeProvider;
import com.mavin.egifting.utils.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class ApplicationCodeProviderServiceTest {

	@Autowired
	ApplicationService applicationService;
	@Autowired
	ApplicationCodeProviderService applicationCodeProviderService;
	
	@Test
	public void testApplicationCodeProviderCrud() {
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
		
		ApplicationCodeProvider acp = new ApplicationCodeProvider();
		acp.setApplicationId(application.getId());
		acp.setCode("Application Code");
		acp.setStatus(Status.ACTIVE.toString());
		acp.setValidUntilDate(System.currentTimeMillis());
		
		acp = applicationCodeProviderService.createApplicationCodeProvider(acp);
		assertNotNull(acp);
		assertNotNull(acp.getId());
		assertEquals(Status.ACTIVE.toString(), acp.getStatus());
		
		acp.setStatus(Status.INACTIVE.toString());
		acp = applicationCodeProviderService.updateApplicationCodeProvider(acp);
		assertNotNull(acp);
		assertNotNull(acp.getId());
		assertEquals(Status.INACTIVE.toString(), acp.getStatus());
		
		acp = applicationCodeProviderService.getApplicationCodeProviderById(acp.getId());
		assertNotNull(acp);
		assertNotNull(acp.getId());
		assertEquals(Status.INACTIVE.toString(), acp.getStatus());
		
		List<ApplicationCodeProvider> acps = applicationCodeProviderService.getAllApplicationCodeProviders();
		assertNotNull(acps);
		assertTrue(acps.size() > 0);
	}

}
