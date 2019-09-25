package com.mavin.egifting.model;

public class Campaign {
	private String id;
	private String campaignTemplateId;
	private String applicationId;
	private String name;
	private String senderWebText;
	private String senderEmailSubject;
	private String senderEmailBody;
	private String recipientWebText;
	private String recipientEmailSubject;
	private String recipientEmailBody;
	private String webLogo;
	private String emailLogo;
	private String applicationName;
	private String callbackApi;
	private String websiteUrl;
	private String itunesUrl;
	private String googleAppStoreUrl;
	private String status;
	private long startDate;
	private long endDate;
	private long createDttm;
	private long updateDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCampaignTemplateId() {
		return campaignTemplateId;
	}

	public void setCampaignTemplateId(String campaignTemplateId) {
		this.campaignTemplateId = campaignTemplateId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenderWebText() {
		return senderWebText;
	}

	public void setSenderWebText(String senderWebText) {
		this.senderWebText = senderWebText;
	}

	public String getSenderEmailSubject() {
		return senderEmailSubject;
	}

	public void setSenderEmailSubject(String senderEmailSubject) {
		this.senderEmailSubject = senderEmailSubject;
	}

	public String getSenderEmailBody() {
		return senderEmailBody;
	}

	public void setSenderEmailBody(String senderEmailBody) {
		this.senderEmailBody = senderEmailBody;
	}

	public String getRecipientWebText() {
		return recipientWebText;
	}

	public void setRecipientWebText(String recipientWebText) {
		this.recipientWebText = recipientWebText;
	}

	public String getRecipientEmailSubject() {
		return recipientEmailSubject;
	}

	public void setRecipientEmailSubject(String recipientEmailSubject) {
		this.recipientEmailSubject = recipientEmailSubject;
	}

	public String getRecipientEmailBody() {
		return recipientEmailBody;
	}

	public void setRecipientEmailBody(String recipientEmailBody) {
		this.recipientEmailBody = recipientEmailBody;
	}

	public String getWebLogo() {
		return webLogo;
	}

	public void setWebLogo(String webLogo) {
		this.webLogo = webLogo;
	}

	public String getEmailLogo() {
		return emailLogo;
	}

	public void setEmailLogo(String emailLogo) {
		this.emailLogo = emailLogo;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getCallbackApi() {
		return callbackApi;
	}

	public void setCallbackApi(String callbackApi) {
		this.callbackApi = callbackApi;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getItunesUrl() {
		return itunesUrl;
	}

	public void setItunesUrl(String itunesUrl) {
		this.itunesUrl = itunesUrl;
	}

	public String getGoogleAppStoreUrl() {
		return googleAppStoreUrl;
	}

	public void setGoogleAppStoreUrl(String googleAppStoreUrl) {
		this.googleAppStoreUrl = googleAppStoreUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public long getCreateDttm() {
		return createDttm;
	}

	public void setCreateDttm(long createDttm) {
		this.createDttm = createDttm;
	}

	public long getUpdateDttm() {
		return updateDttm;
	}

	public void setUpdateDttm(long updateDttm) {
		this.updateDttm = updateDttm;
	}

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", campaignTemplateId=" + campaignTemplateId + ", applicationId=" + applicationId
				+ ", name=" + name + ", senderWebText=" + senderWebText + ", senderEmailSubject=" + senderEmailSubject
				+ ", senderEmailBody=" + senderEmailBody + ", recipientWebText=" + recipientWebText
				+ ", recipientEmailSubject=" + recipientEmailSubject + ", recipientEmailBody=" + recipientEmailBody
				+ ", webLogo=" + webLogo + ", emailLogo=" + emailLogo + ", applicationName=" + applicationName
				+ ", callbackApi=" + callbackApi + ", websiteUrl=" + websiteUrl + ", itunesUrl=" + itunesUrl
				+ ", googleAppStoreUrl=" + googleAppStoreUrl + ", status=" + status + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", createDttm=" + createDttm + ", updateDttm=" + updateDttm + "]";
	}

}
