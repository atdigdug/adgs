package com.mavin.egifting.dto;

public class TransactionDto {

    private String id;

    // Foreign Keys
    private String campaignId;
    private String campaignTemplateSKUId;
    private String applicationCodeProviderId;
    private String paymentProviderId;

    private String senderName;
    private String senderEmail;
    private String recipientName;
    private String recipientEmail;
    private String recipientActivatedEmail;

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

    public String getCampaignTemplateSKUId() {
        return campaignTemplateSKUId;
    }

    public void setCampaignTemplateSKUId(String campaignTemplateSKUId) {
        this.campaignTemplateSKUId = campaignTemplateSKUId;
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

    public String getRecipientActivatedEmail() {
        return recipientActivatedEmail;
    }

    public void setRecipientActivatedEmail(String recipientActivatedEmail) {
        this.recipientActivatedEmail = recipientActivatedEmail;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", campaignTemplateSKUId='" + campaignTemplateSKUId + '\'' +
                ", applicationCodeProviderId='" + applicationCodeProviderId + '\'' +
                ", paymentProviderId='" + paymentProviderId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", recipientActivatedEmail='" + recipientActivatedEmail + '\'' +
                '}';
    }
}
