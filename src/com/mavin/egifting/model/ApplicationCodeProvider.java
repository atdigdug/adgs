package com.mavin.egifting.model;

public class ApplicationCodeProvider {

	private String id;
	private String code;
	private String applicationId;
	private long validUntilDate;
	private String status;
	private long createDttm;
	private long updateDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public long getValidUntilDate() {
		return validUntilDate;
	}

	public void setValidUntilDate(long validUntilDate) {
		this.validUntilDate = validUntilDate;
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
		return "ApplicationCodeProvider [id=" + id + ", code=" + code + ", applicationId=" + applicationId
				+ ", validUntilDate=" + validUntilDate + ", status=" + status + ", createDttm=" + createDttm
				+ ", updateDttm=" + updateDttm + "]";
	}
}
