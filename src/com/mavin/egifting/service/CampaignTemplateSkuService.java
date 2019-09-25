package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.CampaignTemplateSkuMapper;
import com.mavin.egifting.model.CampaignTemplateSku;

@Component
public class CampaignTemplateSkuService {

	Logger logger = Logger.getLogger(CampaignTemplateSkuService.class);

	@Autowired
	CampaignTemplateSkuMapper campaignTemplateSkuMapper;
	
	public List<CampaignTemplateSku> createCampaignTemplateSkus(List<CampaignTemplateSku> campaignTemplateSkus) {
		logger.info("Entering createCampaignTemplateSkus() - " + campaignTemplateSkus);
		for (CampaignTemplateSku campaignTemplateSku : campaignTemplateSkus)
			createCampaignTemplateSku(campaignTemplateSku);
		logger.info("Exiting createCampaignTemplateSkus() - " + campaignTemplateSkus);
		return campaignTemplateSkus;
	}

	public CampaignTemplateSku createCampaignTemplateSku(CampaignTemplateSku campaignTemplateSku) {

		logger.info("Entering createCampaignTemplateSku() - " + campaignTemplateSku);

		Preconditions.checkNotNull(campaignTemplateSku);
		Preconditions.checkArgument(Strings.isNullOrEmpty(campaignTemplateSku.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplateSku.getApplicationSkuId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplateSku.getCampaignTemplateId()));

		campaignTemplateSku.setId(UUID.randomUUID().toString());
		campaignTemplateSku.setCreateDttm(System.currentTimeMillis());

		int rows = campaignTemplateSkuMapper.insertCampaignTemplateSku(campaignTemplateSku);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template Sku");
			return null;
		}

		logger.info("Exiting createCampaignTemplateSku() - " + campaignTemplateSku);

		return campaignTemplateSku;
	}

	public CampaignTemplateSku getCampaignTemplateSkuById(String campaignTemplateSkuId) {
		logger.info("Entering getCampaignTemplateSkuById() - " + campaignTemplateSkuId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignTemplateSkuId));
		CampaignTemplateSku campaignTemplateSku = campaignTemplateSkuMapper.findCampaignTemplateSkuById(campaignTemplateSkuId);
		logger.info("Exiting getCampaignTemplateSkuById() - " + campaignTemplateSku);
		return campaignTemplateSku;
	}

	public List<CampaignTemplateSku> getAllCampaignTemplateSkus() {
		logger.info("Entering getAllCampaignTemplateSkus()");
		List<CampaignTemplateSku> campaignTemplateSkus = campaignTemplateSkuMapper.findCampaignTemplateSkus();
		logger.info("Exiting getAllCampaignTemplateSkus() - " + campaignTemplateSkus);
		return campaignTemplateSkus;
	}
	
	public List<CampaignTemplateSku> getByCampaignTemplateId(String campaignTemplateId) {
		logger.info("Entering getByCampaignTemplateId()");
		List<CampaignTemplateSku> campaignTemplateSkus = campaignTemplateSkuMapper.findByCampaignTemplateId(campaignTemplateId);
		logger.info("Exiting getByCampaignTemplateId() - " + campaignTemplateSkus);
		return campaignTemplateSkus;
	}
	
	public int deleteCampaignTemplateSkus(List<CampaignTemplateSku> campaignTemplateSkus) {
		logger.info("Entering deleteCampaignTemplateSkus()");
		int rowsDeleted = 0;
		for (CampaignTemplateSku campaignTemplateSku : campaignTemplateSkus) {
			int rows = deleteCampaignTemplateSku(campaignTemplateSku.getId());
			rowsDeleted += rows;
		}
		logger.info("Exiting deleteCampaignTemplateSkus() - " + rowsDeleted);
		return rowsDeleted;
	}
	
	public int deleteCampaignTemplateSku(String campaignTemplateSkuId) {
		logger.info("Entering deleteCampaignTemplateSku()");
		int rowsDeleted = campaignTemplateSkuMapper.deleteCampaignTemplateSku(campaignTemplateSkuId); 
		logger.info("Exiting deleteCampaignTemplateSku() - " + rowsDeleted);
		return rowsDeleted;
	}

}
