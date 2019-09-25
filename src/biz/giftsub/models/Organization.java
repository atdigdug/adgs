package biz.giftsub.models;

import java.math.BigDecimal;

public class Organization {
	private String id;
	private String name;
	private String textColor;
	private String backgroundColor;
	private String path;
	private int giftsSold;
	private BigDecimal revenue;
	private int totalCampaigns;
	private String activeCampaignId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getGiftsSold() {
		return giftsSold;
	}
	public void setGiftsSold(int giftsSold) {
		this.giftsSold = giftsSold;
	}
	public BigDecimal getRevenue() {
		return revenue;
	}
	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}
	public int getTotalCampaigns() {
		return totalCampaigns;
	}
	public void setTotalCampaigns(int totalCampaigns) {
		this.totalCampaigns = totalCampaigns;
	}
	public String getActiveCampaignId() {
		return activeCampaignId;
	}
	public void setActiveCampaignId(String activeCampaignId) {
		this.activeCampaignId = activeCampaignId;
	}

}
