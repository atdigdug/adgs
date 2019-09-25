package com.mavin.egifting.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.model.WebviewAnalytics;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class WebviewAnalyticsServiceTest {

	@Autowired
	WebviewAnalyticsService webviewAnalyticsService;
	
	@Test
	public void testWebviewAnalyticsCrud() {
		WebviewAnalytics webviewAnalytics = new WebviewAnalytics();
		webviewAnalytics.setCookieGuid(UUID.randomUUID().toString());
		webviewAnalytics.setSenderLandingPageDate(System.currentTimeMillis());
		
		webviewAnalytics = webviewAnalyticsService.createWebviewAnalytics(webviewAnalytics);
		assertNotNull(webviewAnalytics);
		assertNotNull(webviewAnalytics.getId());
		
	}

}
