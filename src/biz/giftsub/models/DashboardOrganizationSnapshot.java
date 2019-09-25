package biz.giftsub.models;

import java.math.BigDecimal;

public class DashboardOrganizationSnapshot {
	private String id;
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
