package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.CampaignSkuMapper;
import com.mavin.egifting.model.CampaignSku;

@Component
public class CampaignSkuService {

	Logger logger = Logger.getLogger(CampaignSkuService.class);

	@Autowired
	CampaignSkuMapper campaignSkuMapper;

	public CampaignSku createCampaignSku(CampaignSku campaignSku) {

		logger.info("Entering createCampaignSku() - " + campaignSku);

		Preconditions.checkNotNull(campaignSku);
		Preconditions.checkArgument(Strings.isNullOrEmpty(campaignSku.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignSku.getCampaignId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignSku.getCampaignTemplateSkuId()));

		campaignSku.setId(UUID.randomUUID().toString());
		campaignSku.setCreateDttm(System.currentTimeMillis());

		int rows = campaignSkuMapper.insertCampaignSku(campaignSku);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create Campaign Sku");
			return null;
		}

		logger.info("Exiting createCampaignSku() - " + campaignSku);

		return campaignSku;
	}

	public CampaignSku getCampaignSku(String campaignSkuId) {
		logger.info("Entering getCampaignSku() - " + campaignSkuId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignSkuId));
		CampaignSku campaignSku = campaignSkuMapper.findCampaignSkuById(campaignSkuId);
		logger.info("Exiting getCampaignSku() - " + campaignSku);
		return campaignSku;
	}

	public List<CampaignSku> getAllCampaignSkus() {
		logger.info("Entering getAllCampaignSkus()");
		List<CampaignSku> campaignSkus = campaignSkuMapper.findCampaignSkus();
		logger.info("Exiting getAllCampaignSkus() - " + campaignSkus);
		return campaignSkus;
	}
	
	public List<CampaignSku> getByCampaignId(String campaignId) {
		logger.info("Entering getByCampaignId()");
		List<CampaignSku> campaignSkus = campaignSkuMapper.findByCampaignId(campaignId);
		logger.info("Exiting getByCampaignId() - " + campaignSkus);
		return campaignSkus;
	}
}
