package com.mavin.egifting.model;

public class CampaignTemplate {

	private String id;
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
	private long createDttm;
	private long updateDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "CampaignTemplate [id=" + id + ", applicationId=" + applicationId + ", name=" + name + ", senderWebText="
				+ senderWebText + ", senderEmailSubject=" + senderEmailSubject + ", senderEmailBody=" + senderEmailBody
				+ ", recipientWebText=" + recipientWebText + ", recipientEmailSubject=" + recipientEmailSubject
				+ ", recipientEmailBody=" + recipientEmailBody + ", webLogo=" + webLogo + ", emailLogo=" + emailLogo
				+ ", createDttm=" + createDttm + ", updateDttm=" + updateDttm + "]";
	}

}
