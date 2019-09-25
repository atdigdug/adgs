package com.mavin.egifting.model;

import java.math.BigDecimal;

public class CampaignSku {

	private String id;
	private String campaignId;
	private String campaignTemplateSkuId;
	private String skuId;
	private String name;
	private BigDecimal price;
	private long createDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignTemplateSkuId() {
		return campaignTemplateSkuId;
	}

	public void setCampaignTemplateSkuId(String campaignTemplateSkuId) {
		this.campaignTemplateSkuId = campaignTemplateSkuId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getCreateDttm() {
		return createDttm;
	}

	public void setCreateDttm(long createDttm) {
		this.createDttm = createDttm;
	}

	@Override
	public String toString() {
		return "CampaignSku [id=" + id + ", campaignId=" + campaignId + ", campaignTemplateSkuId="
				+ campaignTemplateSkuId + ", skuId=" + skuId + ", name=" + name + ", price=" + price
				+ ", createDttm=" + createDttm + "]";
	}

}
