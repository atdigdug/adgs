package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.CampaignTemplateMapper;
import com.mavin.egifting.model.CampaignTemplate;

@Component
public class CampaignTemplateService {

	Logger logger = Logger.getLogger(CampaignTemplateService.class);

	@Autowired
	CampaignTemplateMapper campaignTemplateMapper;

	public CampaignTemplate createCampaignTemplate(CampaignTemplate campaignTemplate) {

		logger.info("Entering createCampaignTemplate() - " + campaignTemplate);

		Preconditions.checkNotNull(campaignTemplate);
		Preconditions.checkArgument(Strings.isNullOrEmpty(campaignTemplate.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplate.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplate.getName()));

		campaignTemplate.setId(UUID.randomUUID().toString());
		campaignTemplate.setCreateDttm(System.currentTimeMillis());
		campaignTemplate.setUpdateDttm(System.currentTimeMillis());

		int rows = campaignTemplateMapper.insertCampaignTemplate(campaignTemplate);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}

		logger.info("Exiting createCampaignTemplate() - " + campaignTemplate);

		return campaignTemplate;
	}
	
	public CampaignTemplate updateCampaignTemplate(CampaignTemplate campaignTemplate) {
		logger.info("Entering updateCampaignTemplate() - " + campaignTemplate);
		
		Preconditions.checkNotNull(campaignTemplate);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplate.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplate.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplate.getName()));
		
		campaignTemplate.setUpdateDttm(System.currentTimeMillis());
		
		int rows = campaignTemplateMapper.updateCampaignTemplate(campaignTemplate);
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}
		logger.info("Exiting updateCampaignTemplate() - " + campaignTemplate);
		return campaignTemplate;
	}

	public CampaignTemplate getCampaignTemplateById(String campaignTemplateId) {
		logger.info("Entering getCampaignTemplateById() - " + campaignTemplateId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplateId));
		CampaignTemplate campaignTemplate = campaignTemplateMapper.findCampaignTemplateById(campaignTemplateId);
		logger.info("Exiting getCampaignTemplateById() - " + campaignTemplate);
		return campaignTemplate;
	}

	public List<CampaignTemplate> getAllCampaignTemplates() {
		logger.info("Entering getAllCampaignTemplates()");
		List<CampaignTemplate> campaignTemplates = campaignTemplateMapper.findAllCampaignTemplates();
		logger.info("Exiting getCampaignTemplateById() - " + campaignTemplates);
		return campaignTemplates;
	}
	
	public List<CampaignTemplate> getByApplicationId(String applicationId) {
		logger.info("Entering getByApplicationId()");
		List<CampaignTemplate> campaignTemplates = campaignTemplateMapper.findByApplicationId(applicationId);
		logger.info("Exiting getByApplicationId() - " + campaignTemplates);
		return campaignTemplates;
	}
}
