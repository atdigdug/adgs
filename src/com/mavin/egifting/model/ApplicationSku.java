package com.mavin.egifting.model;

import java.math.BigDecimal;

public class ApplicationSku {

	private String id;
	private String applictionId;
	private String skuId;
	private String name;
	private BigDecimal price;
	private String status;
	private long createDttm;
	private long updateDttm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplictionId() {
		return applictionId;
	}

	public void setApplictionId(String applictionId) {
		this.applictionId = applictionId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
		return "ApplicationSku [id=" + id + ", applictionId=" + applictionId + ", skuId=" + skuId + ", name=" + name
				+ ", price=" + price + ", status=" + status + ", createDttm=" + createDttm + ", updateDttm="
				+ updateDttm + "]";
	}

}
