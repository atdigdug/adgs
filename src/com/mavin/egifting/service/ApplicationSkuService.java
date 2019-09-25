package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.ApplicationSkuMapper;
import com.mavin.egifting.model.ApplicationSku;

@Component
public class ApplicationSkuService {

	Logger logger = Logger.getLogger(ApplicationSkuService.class);

	@Autowired
	ApplicationSkuMapper applicationSkuMapper;

	public ApplicationSku createApplicationSku(ApplicationSku applicationSku) {

		logger.info("Entering createApplicationSku() - " + applicationSku);

		Preconditions.checkNotNull(applicationSku);
		Preconditions.checkArgument(Strings.isNullOrEmpty(applicationSku.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationSku.getApplictionId()));

		applicationSku.setId(UUID.randomUUID().toString());
		applicationSku.setCreateDttm(System.currentTimeMillis());
		applicationSku.setUpdateDttm(System.currentTimeMillis());

		int rows = applicationSkuMapper.insertApplicationSku(applicationSku);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create Application Sku");
			return null;
		}

		logger.info("Exiting createApplicationSku() - " + applicationSku);

		return applicationSku;
	}

	public ApplicationSku updateApplicationSku(ApplicationSku applicationSku) {
		logger.info("Entering updateApplicationSku() - " + applicationSku);

		Preconditions.checkNotNull(applicationSku);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationSku.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationSku.getApplictionId()));

		applicationSku.setUpdateDttm(System.currentTimeMillis());

		int rows = applicationSkuMapper.updateApplicationSku(applicationSku);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}
		logger.info("Exiting updateApplicationSku() - " + applicationSku);
		return applicationSku;
	}

	public ApplicationSku getApplicationSkuById(String applicationSkuId) {
		logger.info("Entering getApplicationSkuById() - " + applicationSkuId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationSkuId));
		ApplicationSku applicationSku = applicationSkuMapper.findApplicationSkuById(applicationSkuId);
		logger.info("Exiting getApplicationSkuById() - " + applicationSku);
		return applicationSku;
	}

	public List<ApplicationSku> getAllApplicationSkus() {
		logger.info("Entering getAllApplicationSkus()");
		List<ApplicationSku> applicationSkus = applicationSkuMapper.findApplicationSkus();
		logger.info("Exiting getAllApplicationSkus() - " + applicationSkus);
		return applicationSkus;
	}
	
	public List<ApplicationSku> getByApplicationId(String applicationId) {
		logger.info("Entering getByApplicationId()");
		List<ApplicationSku> applicationSkus = applicationSkuMapper.findByApplcationId(applicationId);
		logger.info("Exiting getByApplicationId() - " + applicationSkus);
		return applicationSkus;
	}
}
