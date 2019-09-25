package com.mavin.egifting.model;

public class CampaignTemplateSku {

	private String id;
	private String applicationSkuId;
	private String campaignTemplateId;
	private long createDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicationSkuId() {
		return applicationSkuId;
	}

	public void setApplicationSkuId(String applicationSkuId) {
		this.applicationSkuId = applicationSkuId;
	}

	public String getCampaignTemplateId() {
		return campaignTemplateId;
	}

	public void setCampaignTemplateId(String campaignTemplateId) {
		this.campaignTemplateId = campaignTemplateId;
	}

	public long getCreateDttm() {
		return createDttm;
	}

	public void setCreateDttm(long createDttm) {
		this.createDttm = createDttm;
	}

	@Override
	public String toString() {
		return "CampaignTemplateSku [id=" + id + ", applicationSkuId=" + applicationSkuId + ", campaignTemplateId="
				+ campaignTemplateId + ", createDttm=" + createDttm + "]";
	}

}
