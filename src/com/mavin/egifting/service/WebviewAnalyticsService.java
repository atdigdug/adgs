package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.WebviewAnalyticsMapper;
import com.mavin.egifting.model.WebviewAnalytics;

@Component
public class WebviewAnalyticsService {

	Logger logger = Logger.getLogger(WebviewAnalyticsService.class);

	@Autowired
	WebviewAnalyticsMapper webviewAnalyticsMapper;

	public WebviewAnalytics createWebviewAnalytics(WebviewAnalytics webviewAnalytics) {
		logger.info("Entering createWebviewAnalytics() - " + webviewAnalytics);
		Preconditions.checkNotNull(webviewAnalytics);
		Preconditions.checkArgument(Strings.isNullOrEmpty(webviewAnalytics.getId()));
		webviewAnalytics.setId(UUID.randomUUID().toString());

		int rows = webviewAnalyticsMapper.insertWebviewAnalytics(webviewAnalytics);
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create Web view analytics");
			return null;
		}
		logger.info("Exiting createWebviewAnalytics() - " + webviewAnalytics);
		return webviewAnalytics;
	}

	public WebviewAnalytics updateWebviewAnalytics(WebviewAnalytics webviewAnalytics) {
		logger.info("Entering updateWebviewAnalytics() - " + webviewAnalytics);
		Preconditions.checkNotNull(webviewAnalytics);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(webviewAnalytics.getId()));
		int rows = webviewAnalyticsMapper.updateWebviewAnalytics(webviewAnalytics);
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to update Web view analytics");
			return null;
		}
		logger.info("Exiting updateWebviewAnalytics() - " + webviewAnalytics);
		return webviewAnalytics;
	}

	public WebviewAnalytics getWebviewAnalyticsById(String webviewAnalyticsId) {
		logger.info("Entering getWebviewAnalyticsById() - " + webviewAnalyticsId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(webviewAnalyticsId));
		WebviewAnalytics webViewAnalytics = webviewAnalyticsMapper.findWebviewAnalyticsById(webviewAnalyticsId);
		logger.info("Exiting getWebviewAnalyticsById() - " + webViewAnalytics);
		return webViewAnalytics;
	}

	public List<WebviewAnalytics> getAllWebviewAnalytics() {
		logger.info("Entering webviewAnalyticsMapper()");
		List<WebviewAnalytics> allWebViewAnalytics = webviewAnalyticsMapper.findAllWebviewAnalytics();
		logger.info("Exiting webviewAnalyticsMapper() - " + allWebViewAnalytics);
		return allWebViewAnalytics;
	}
}
