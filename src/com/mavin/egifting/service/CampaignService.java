package com.mavin.egifting.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.mavin.egifting.utils.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.ApplicationMapper;
import com.mavin.egifting.dao.ApplicationSkuMapper;
import com.mavin.egifting.dao.CampaignMapper;
import com.mavin.egifting.dao.CampaignSkuMapper;
import com.mavin.egifting.dao.CampaignTemplateMapper;
import com.mavin.egifting.dao.CampaignTemplateSkuMapper;
import com.mavin.egifting.model.Application;
import com.mavin.egifting.model.ApplicationSku;
import com.mavin.egifting.model.Campaign;
import com.mavin.egifting.model.CampaignSku;
import com.mavin.egifting.model.CampaignTemplate;
import com.mavin.egifting.model.CampaignTemplateSku;
import com.mavin.egifting.utils.StringUtils;

@Component
public class CampaignService {

	Logger logger = Logger.getLogger(CampaignService.class);

	// These are the fields copied over from campaign template to campaign
	private static final String CAMPAIGN_TEMPLATE_ATTRIBUTES = "senderWebText, senderEmailSubject, senderEmailBody, recipientWebText, "
			+ "recipientEmailSubject, recipientEmailBody, webLogo, emailLogo";
	// There are the fields that are copied over from application sku to campaign sku
	private static final String APPLICATION_SKU_ATTRIBUTES = "skuId, name, price";

	@Autowired
	CampaignMapper campaignMapper;
	@Autowired
	CampaignTemplateMapper campaignTemplateMapper;
	@Autowired
	CampaignTemplateSkuMapper campaignTemplateSkuMapper;
	@Autowired
	ApplicationSkuMapper applicationSkuMapper;
	@Autowired
	CampaignSkuMapper campaignSkuMapper;
	@Autowired
	ApplicationMapper applicationMapper;

	public Campaign createCampaign(Campaign campaign) {

		logger.info("Entering createCampaign() - " + campaign);
		Preconditions.checkNotNull(campaign);
		Preconditions.checkArgument(Strings.isNullOrEmpty(campaign.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getCampaignTemplateId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getName()));

		campaign.setId(UUID.randomUUID().toString());
		campaign.setCreateDttm(System.currentTimeMillis());
		campaign.setUpdateDttm(System.currentTimeMillis());
		campaign.setStatus(Status.ACTIVE.toString());

		CampaignTemplate campaignTemplate = campaignTemplateMapper
				.findCampaignTemplateById(campaign.getCampaignTemplateId());
		copyCampaignTemplateData(campaignTemplate, campaign);
		copyApplicationData(campaignTemplate.getApplicationId(), campaign);

		int rows = campaignMapper.insertCampaign(campaign);
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign");
			return null;
		}

		copyCampaignTemplateSkuRecords(campaign.getCampaignTemplateId(), campaign.getId());

		logger.info("Exiting createCampaign() - " + campaign);
		return campaign;
	}

	public Campaign updateCampaign(Campaign campaign) {
		logger.info("Entering updateCampaign() - " + campaign);

		Preconditions.checkNotNull(campaign);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaign.getName()));

		campaign.setUpdateDttm(System.currentTimeMillis());

		int rows = campaignMapper.updateCampaign(campaign);
		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create campaign template");
			return null;
		}
		logger.info("Exiting updateCampaign() - " + campaign);
		return campaign;
	}

	public Campaign getCampaignById(String campaignId) {
		logger.info("Entering getCampaignById() - " + campaignId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignId));
		Campaign campaign = campaignMapper.findCampaignById(campaignId);
		logger.info("Exiting getCampaignById() - " + campaign);
		return campaign;
	}

	public List<Campaign> getAllCampaigns() {
		logger.info("Entering getAllCampaigns()");
		List<Campaign> campaigns = campaignMapper.findAllCampaigns();
		logger.info("Exiting getAllCampaigns() - " + campaigns);
		return campaigns;
	}
	
	public List<Campaign> getByCampaignTemplateId(String campaignTemplateId) {
		logger.info("Entering getByCampaignTemplateId()");
		List<Campaign> campaigns = campaignMapper.findByCampaignTemplateId(campaignTemplateId);
		List<Campaign> filtered = campaigns.stream()
				.filter(campaign -> Status.ACTIVE.toString().equalsIgnoreCase(campaign.getStatus()))
				.collect(Collectors.toList());
		logger.info("Exiting getByCampaignTemplateId() - " + filtered);
		return filtered;
	}

	protected static Collection<String> getCampaignTemplateAttributes() {
		return Splitter.on(',').trimResults().splitToList(CAMPAIGN_TEMPLATE_ATTRIBUTES);
	}

	protected static Collection<String> getApplicationSkuAttributes() {
		return Splitter.on(',').trimResults().splitToList(APPLICATION_SKU_ATTRIBUTES);
	}

	private void copyCampaignTemplateData(CampaignTemplate campaignTemplate, Campaign campaign) {
		StringUtils.copyProperties(campaignTemplate, campaign, getCampaignTemplateAttributes());
	}

	private void copyApplicationData(String applicationId, Campaign campaign) {
		Application application = applicationMapper.findApplicationById(applicationId);
		campaign.setApplicationName(application.getName());
		campaign.setCallbackApi(application.getCallbackApi());
		campaign.setWebsiteUrl(application.getWebsiteUrl());
		campaign.setItunesUrl(application.getItunesUrl());
		campaign.setGoogleAppStoreUrl(application.getGoogleAppStoreUrl());
	}

	private void copyCampaignTemplateSkuRecords(String campaignTemplateId, String campaignId) {
		List<CampaignTemplateSku> campaignTemplateSkus = campaignTemplateSkuMapper
				.findByCampaignTemplateId(campaignTemplateId);

		if (campaignTemplateSkus == null || campaignTemplateSkus.size() == 0)
			return;

		for (CampaignTemplateSku campaignTemplateSku : campaignTemplateSkus) {
			ApplicationSku applicationSku = applicationSkuMapper
					.findApplicationSkuById(campaignTemplateSku.getApplicationSkuId());
			CampaignSku campaignSku = new CampaignSku();
			campaignSku.setId(UUID.randomUUID().toString());
			campaignSku.setCreateDttm(System.currentTimeMillis());
			campaignSku.setCampaignId(campaignId);
			campaignSku.setCampaignTemplateSkuId(campaignTemplateSku.getId());
			StringUtils.copyProperties(applicationSku, campaignSku, getApplicationSkuAttributes());
			campaignSkuMapper.insertCampaignSku(campaignSku);
		}

	}
}
