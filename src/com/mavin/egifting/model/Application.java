package com.mavin.egifting.model;

public class Application {

	private String id;
	private String name;
	private String callbackApi;
	private String websiteUrl;
	private String itunesUrl;
	private String googleAppStoreUrl;
	private String status;
	private long createDttm;
	private long updateDttm;

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

	public String getCallbackApi() {
		return callbackApi;
	}

	public void setCallbackApi(String callbackApi) {
		this.callbackApi = callbackApi;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getItunesUrl() {
		return itunesUrl;
	}

	public void setItunesUrl(String itunesUrl) {
		this.itunesUrl = itunesUrl;
	}

	public String getGoogleAppStoreUrl() {
		return googleAppStoreUrl;
	}

	public void setGoogleAppStoreUrl(String googleAppStoreUrl) {
		this.googleAppStoreUrl = googleAppStoreUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Application [id=" + id + ", name=" + name + ", callbackApi=" + callbackApi + ", websiteUrl="
				+ websiteUrl + ", itunesUrl=" + itunesUrl + ", googleAppStoreUrl=" + googleAppStoreUrl + ", status="
				+ status + ", createDttm=" + createDttm + ", updateDttm=" + updateDttm + "]";
	}

}
