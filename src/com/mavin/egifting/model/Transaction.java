package com.mavin.egifting.model;

public class Transaction {

	private String id;
	private String campaignId;
	private String senderName;
	private String senderEmail;
	private String recipientName;
	private String recipientEmail;
	private String campaignSkuId;
	private String applicationCodeProviderId;
	private String paymentProviderId;
	private String recipientActivatedEmail;
	private String senderPaymentStatus;
	private long recipientClickedEmailLinkDate;
	private long recipientActivationSuccessDate;
	private long senderPaymentDate;
	private long createDttm;
	private long updateDttm;

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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getCampaignSkuId() {
		return campaignSkuId;
	}

	public void setCampaignSkuId(String campaignSkuId) {
		this.campaignSkuId = campaignSkuId;
	}

	public String getApplicationCodeProviderId() {
		return applicationCodeProviderId;
	}

	public void setApplicationCodeProviderId(String applicationCodeProviderId) {
		this.applicationCodeProviderId = applicationCodeProviderId;
	}

	public String getPaymentProviderId() {
		return paymentProviderId;
	}

	public void setPaymentProviderId(String paymentProviderId) {
		this.paymentProviderId = paymentProviderId;
	}

	public String getRecipientActivatedEmail() {
		return recipientActivatedEmail;
	}

	public void setRecipientActivatedEmail(String recipientActivatedEmail) {
		this.recipientActivatedEmail = recipientActivatedEmail;
	}

	public String getSenderPaymentStatus() {
		return senderPaymentStatus;
	}

	public void setSenderPaymentStatus(String senderPaymentStatus) {
		this.senderPaymentStatus = senderPaymentStatus;
	}

	public long getRecipientClickedEmailLinkDate() {
		return recipientClickedEmailLinkDate;
	}

	public void setRecipientClickedEmailLinkDate(long recipientClickedEmailLinkDate) {
		this.recipientClickedEmailLinkDate = recipientClickedEmailLinkDate;
	}

	public long getRecipientActivationSuccessDate() {
		return recipientActivationSuccessDate;
	}

	public void setRecipientActivationSuccessDate(long recipientActivationSuccessDate) {
		this.recipientActivationSuccessDate = recipientActivationSuccessDate;
	}

	public long getSenderPaymentDate() {
		return senderPaymentDate;
	}

	public void setSenderPaymentDate(long senderPaymentDate) {
		this.senderPaymentDate = senderPaymentDate;
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
		return "Transaction [id=" + id + ", campaignId=" + campaignId + ", senderName=" + senderName + ", senderEmail="
				+ senderEmail + ", recipientName=" + recipientName + ", recipientEmail=" + recipientEmail
				+ ", campaignSkuId=" + campaignSkuId + ", applicationCodeProviderId=" + applicationCodeProviderId
				+ ", paymentProviderId=" + paymentProviderId + ", recipientActivatedEmail=" + recipientActivatedEmail
				+ ", senderPaymentStatus=" + senderPaymentStatus + ", recipientClickedEmailLinkDate="
				+ recipientClickedEmailLinkDate + ", recipientActivationSuccessDate=" + recipientActivationSuccessDate
				+ ", senderPaymentDate=" + senderPaymentDate + ", createDttm=" + createDttm + ", updateDttm="
				+ updateDttm + "]";
	}

}
