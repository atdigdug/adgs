package com.mavin.egifting.model;

public class CampaignTemplateDetails {

	private String id;
	private String campaignTemplateId;
	private String senderWebText;
	private String senderWebEmail;
	private String recipientWebText;
	private String recipientWebEmail;
	private String webLogo;
	private String emailLogo;

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

	public String getSenderWebText() {
		return senderWebText;
	}

	public void setSenderWebText(String senderWebText) {
		this.senderWebText = senderWebText;
	}

	public String getSenderWebEmail() {
		return senderWebEmail;
	}

	public void setSenderWebEmail(String senderWebEmail) {
		this.senderWebEmail = senderWebEmail;
	}

	public String getRecipientWebText() {
		return recipientWebText;
	}

	public void setRecipientWebText(String recipientWebText) {
		this.recipientWebText = recipientWebText;
	}

	public String getRecipientWebEmail() {
		return recipientWebEmail;
	}

	public void setRecipientWebEmail(String recipientWebEmail) {
		this.recipientWebEmail = recipientWebEmail;
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

	@Override
	public String toString() {
		return "CampaignTemplateDetails [id=" + id + ", campaignTemplateId=" + campaignTemplateId + ", senderWebText="
				+ senderWebText + ", senderWebEmail=" + senderWebEmail + ", recipientWebText=" + recipientWebText
				+ ", recipientWebEmail=" + recipientWebEmail + ", webLogo=" + webLogo + ", emailLogo=" + emailLogo
				+ "]";
	}

}
