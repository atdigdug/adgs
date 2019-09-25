package com.mavin.egifting.model;

public class DashboardUserPermissions {

	private String id;
	private String dashboardUserId;
	private String applicationId;
	private String permission;
	private long createDttm;
	private long updateDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDashboardUserId() {
		return dashboardUserId;
	}

	public void setDashboardUserId(String dashboardUserId) {
		this.dashboardUserId = dashboardUserId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
		return "DashboardUserPermissions [id=" + id + ", dashboardUserId=" + dashboardUserId + ", applicationId="
				+ applicationId + ", permission=" + permission + ", createDttm=" + createDttm + ", updateDttm="
				+ updateDttm + "]";
	}

}
