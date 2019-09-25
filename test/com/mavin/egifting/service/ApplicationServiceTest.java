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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class ApplicationServiceTest {

	@Autowired
	ApplicationService applicationService;

	@Test
	public void testApplicationCrud() {
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

		assertEquals("active", application.getStatus());
		application.setStatus("inactive");
		application = applicationService.updateApplication(application);

		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("inactive", application.getStatus());

		application = applicationService.getApplicationById(application.getId());
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("inactive", application.getStatus());

		List<Application> applications = applicationService.getAllApplications();
		assertNotNull(applications);
		assertTrue(applications.size() > 0);
	}

}
