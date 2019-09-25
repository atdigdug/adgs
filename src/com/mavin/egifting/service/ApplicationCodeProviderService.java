package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.ApplicationCodeProviderMapper;
import com.mavin.egifting.model.ApplicationCodeProvider;

@Component
public class ApplicationCodeProviderService {

	Logger logger = Logger.getLogger(ApplicationCodeProviderService.class);

	@Autowired
	ApplicationCodeProviderMapper applicationCodeProviderMapper;

	public ApplicationCodeProvider createApplicationCodeProvider(ApplicationCodeProvider applicationCodeProvider) {

		logger.info("Entering createApplicationCodeProvider() - " + applicationCodeProvider);

		Preconditions.checkNotNull(applicationCodeProvider);
		Preconditions.checkArgument(Strings.isNullOrEmpty(applicationCodeProvider.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationCodeProvider.getApplicationId()));

		applicationCodeProvider.setId(UUID.randomUUID().toString());
		applicationCodeProvider.setCreateDttm(System.currentTimeMillis());
		applicationCodeProvider.setUpdateDttm(System.currentTimeMillis());

		int rows = applicationCodeProviderMapper.insertApplicationCodeProvider(applicationCodeProvider);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create Application Code Provider");
			return null;
		}

		logger.info("Exiting createApplicationCodeProvider() - " + applicationCodeProvider);

		return applicationCodeProvider;
	}

	public ApplicationCodeProvider updateApplicationCodeProvider(ApplicationCodeProvider applicationCodeProvider) {
		logger.info("Entering updateApplicationCodeProvider() - " + applicationCodeProvider);

		Preconditions.checkNotNull(applicationCodeProvider);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationCodeProvider.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationCodeProvider.getApplicationId()));

		applicationCodeProvider.setUpdateDttm(System.currentTimeMillis());

		int rows = applicationCodeProviderMapper.updateApplicationCodeProvider(applicationCodeProvider);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to update Application Code Provider");
			return null;
		}
		logger.info("Exiting updateApplicationCodeProvider() - " + applicationCodeProvider);
		return applicationCodeProvider;
	}

	public ApplicationCodeProvider getApplicationCodeProviderById(String applicationCodeProviderId) {
		logger.info("Entering getApplicationById() - " + applicationCodeProviderId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationCodeProviderId));
		ApplicationCodeProvider applicationCodeProvier = applicationCodeProviderMapper
				.findApplicationCodeProviderById(applicationCodeProviderId);
		logger.info("Exiting getApplicationById() - " + applicationCodeProvier);
		return applicationCodeProvier;
	}

	public List<ApplicationCodeProvider> getAllApplicationCodeProviders() {
		logger.info("Entering getAllApplications()");
		List<ApplicationCodeProvider> applicationCodeProviders = applicationCodeProviderMapper
				.findApplicationCodeProviders();
		logger.info("Exiting getAllApplications() - " + applicationCodeProviders);
		return applicationCodeProviders;
	}

}
