package biz.giftsub.models;

public class WebviewCampaign {
	private WebviewOrganizationDetails organization;
	private WebviewCampaignDetails campaign;
	
	public WebviewOrganizationDetails getOrganization() {
		return organization;
	}
	public void setOrganization(WebviewOrganizationDetails organization) {
		this.organization = organization;
	}
	public WebviewCampaignDetails getCampaign() {
		return campaign;
	}
	public void setCampaign(WebviewCampaignDetails campaign) {
		this.campaign = campaign;
	}
}
