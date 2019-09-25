package com.mavin.egifting.model;

public class WebviewAnalytics {

	private String id;
	private String cookieGuid;
	private String campaignId;
	private long senderLandingPageDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCookieGuid() {
		return cookieGuid;
	}

	public void setCookieGuid(String cookieGuid) {
		this.cookieGuid = cookieGuid;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public long getSenderLandingPageDate() {
		return senderLandingPageDate;
	}

	public void setSenderLandingPageDate(long senderLandingPageDate) {
		this.senderLandingPageDate = senderLandingPageDate;
	}

	@Override
	public String toString() {
		return "WebviewAnalytics [id=" + id + ", cookieGuid=" + cookieGuid + ", campaignId=" + campaignId
				+ ", senderLandingPageDate=" + senderLandingPageDate + "]";
	}

}
