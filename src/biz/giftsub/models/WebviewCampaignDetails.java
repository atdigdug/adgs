package biz.giftsub.models;

import java.util.List;

public class WebviewCampaignDetails {
	private String id;
	private List<Gift> gifts;
	private String webText;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Gift> getGifts() {
		return gifts;
	}

	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}

	public String getWebText() {
		return webText;
	}

	public void setWebText(String webText) {
		this.webText = webText;
	}

}
