package biz.giftsub.models;

import java.math.BigDecimal;

public class WebviewSale {
	private String saleId;
	private String campaignId;
	private int giftIndex;
	private String giftName;
	private BigDecimal giftPrice;
	private String senderName;
	private String senderEmail;
	private String recipientName;
	private String recipientEmail;
	private String message;
	private String claimedEmail;
	private String otp;
	private WebviewOrganizationDetails organization;

	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public int getGiftIndex() {
		return giftIndex;
	}
	public void setGiftIndex(int giftIndex) {
		this.giftIndex = giftIndex;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public BigDecimal getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(BigDecimal giftPrice) {
		this.giftPrice = giftPrice;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClaimedEmail() {
		return claimedEmail;
	}
	public void setClaimedEmail(String claimedEmail) {
		this.claimedEmail = claimedEmail;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public WebviewOrganizationDetails getOrganization() {
		return organization;
	}
	public void setOrganization(WebviewOrganizationDetails organization) {
		this.organization = organization;
	}

}

