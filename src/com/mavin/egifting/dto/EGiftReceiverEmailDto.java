package com.mavin.egifting.dto;

public class EGiftReceiverEmailDto extends EmailDto {

	private String receiverName;
	private String senderName;
	private String campaignSkuName;
	private String message;
	private String logoImageUrl;
	private String claimButtonUrl;

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getCampaignSkuName() {
		return campaignSkuName;
	}

	public void setCampaignSkuName(String campaignSkuName) {
		this.campaignSkuName = campaignSkuName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogoImageUrl() {
		return logoImageUrl;
	}

	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}

	public String getClaimButtonUrl() {
		return claimButtonUrl;
	}

	public void setClaimButtonUrl(String claimButtonUrl) {
		this.claimButtonUrl = claimButtonUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EGiftReceiverEmailDto [receiverName=").append(receiverName).append(", senderName=")
				.append(senderName).append(", campaignSkuName=").append(campaignSkuName).append(", message=")
				.append(message).append(", logoImageUrl=").append(logoImageUrl).append(", claimButtonUrl=")
				.append(claimButtonUrl).append("]");
		return builder.toString();
	}

}
