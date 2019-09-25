package biz.giftsub.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import biz.giftsub.utils.GiftUtilDateTime;

public class Sale {
	private String id;
	private String campaignId;
	private String giftName;
	private BigDecimal giftPrice;
	private String senderName;
	private String senderEmail;
	private String recipientName;
	private String recipientEmail;
	private String senderMessage;
	private String claimedEmail;
	private long saleEpoch;
	private Timestamp saleTimestamp;
	private String paymentId;
	private String otp;

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
	public String getSenderMessage() {
		return senderMessage;
	}
	public void setSenderMessage(String senderMessage) {
		this.senderMessage = senderMessage;
	}
	public String getClaimedEmail() {
		return claimedEmail;
	}
	public void setClaimedEmail(String claimedEmail) {
		this.claimedEmail = claimedEmail;
	}
	public long getSaleEpoch() {
		saleEpoch = GiftUtilDateTime.returnBestEpoch(saleEpoch, saleTimestamp);
		return saleEpoch;
	}
	public void setSaleEpoch(long saleEpoch) {
		this.saleEpoch = saleEpoch;
	}
	public Timestamp getSaleTimestamp() {
		saleTimestamp = GiftUtilDateTime.returnBestTimestamp(saleTimestamp, saleEpoch);
		return saleTimestamp;
	}
	public void setSaleTimestamp(Timestamp saleTimestamp) {
		this.saleTimestamp = saleTimestamp;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

}
