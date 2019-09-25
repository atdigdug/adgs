package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.ApplicationMapper;
import com.mavin.egifting.model.Application;

@Component
public class ApplicationService {

	Logger logger = Logger.getLogger(ApplicationService.class);
	
	@Autowired
	ApplicationMapper applicationMapper;
	
	public Application createApplication(Application application) {

		logger.info("Entering createApplication() - " + application);

		Preconditions.checkNotNull(application);
		Preconditions.checkArgument(Strings.isNullOrEmpty(application.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(application.getName()));

		application.setId(UUID.randomUUID().toString());
		application.setCreateDttm(System.currentTimeMillis());
		application.setUpdateDttm(System.currentTimeMillis());

		int rows = applicationMapper.insertApplication(application);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}

		logger.info("Exiting createApplication() - " + application);

		return application;
	}
	
	public Application updateApplication(Application application) {
		logger.info("Entering updateApplication() - " + application);
		
		Preconditions.checkNotNull(application);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(application.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(application.getName()));
		
		application.setUpdateDttm(System.currentTimeMillis());
		
		int rows = applicationMapper.updateApplication(application);
		
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}
		logger.info("Exiting updateApplication() - " + application);
		return application;
	}

	public Application getApplicationById(String applicationId) {
		logger.info("Entering getApplicationById() - " + applicationId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(applicationId));
		Application application = applicationMapper.findApplicationById(applicationId);
		logger.info("Exiting getApplicationById() - " + application);
		return application;
	}

	public List<Application> getAllApplications() {
		logger.info("Entering getAllApplications()");
		List<Application> applications = applicationMapper.findApplications();
		logger.info("Exiting getAllApplications() - " + applications);
		return applications;
	}
}
