package biz.giftsub.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import biz.giftsub.enums.CampaignStatus;
import biz.giftsub.utils.GiftUtilDateTime;

public class Campaign {
	private String id;
	private String organizationId;
	private String name;
	private long startDate;
	private long endDate;
	private Timestamp startTimestamp;
	private Timestamp endTimestamp;
	private CampaignStatus status;
	private String webText;
	private String emailText;
	private String emailSubject;
	private String gift1Name;
	private BigDecimal gift1Price;
	private String gift2Name;
	private BigDecimal gift2Price;
	private String gift3Name;
	private BigDecimal gift3Price;
	private long createDttm;
	private long updateDttm;
	private Timestamp createTimestamp;
	private Timestamp updateTimestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStartDate() {
		startDate = GiftUtilDateTime.returnBestEpoch(startDate, startTimestamp);
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		endDate = GiftUtilDateTime.returnBestEpoch(endDate, endTimestamp);
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartTimestamp() {
		startTimestamp = GiftUtilDateTime.returnBestTimestamp(startTimestamp, startDate);
		return startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Timestamp getEndTimestamp() {
		endTimestamp = GiftUtilDateTime.returnBestTimestamp(endTimestamp, endDate);
		return endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public CampaignStatus getStatus() {
		return status;
	}

	public void setStatus(CampaignStatus status) {
		this.status = status;
	}

	public String getWebText() {
		return webText;
	}

	public void setWebText(String webText) {
		this.webText = webText;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getGift1Name() {
		return gift1Name;
	}

	public void setGift1Name(String gift1Name) {
		this.gift1Name = gift1Name;
	}

	public BigDecimal getGift1Price() {
		return gift1Price;
	}

	public void setGift1Price(BigDecimal gift1Price) {
		this.gift1Price = gift1Price;
	}

	public String getGift2Name() {
		return gift2Name;
	}

	public void setGift2Name(String gift2Name) {
		this.gift2Name = gift2Name;
	}

	public BigDecimal getGift2Price() {
		return gift2Price;
	}

	public void setGift2Price(BigDecimal gift2Price) {
		this.gift2Price = gift2Price;
	}

	public String getGift3Name() {
		return gift3Name;
	}

	public void setGift3Name(String gift3Name) {
		this.gift3Name = gift3Name;
	}

	public BigDecimal getGift3Price() {
		return gift3Price;
	}

	public void setGift3Price(BigDecimal gift3Price) {
		this.gift3Price = gift3Price;
	}

	public long getCreateDttm() {
		createDttm = GiftUtilDateTime.returnBestEpoch(createDttm, createTimestamp);
		return createDttm;
	}

	public void setCreateDttm(long createDttm) {
		this.createDttm = createDttm;
	}

	public long getUpdateDttm() {
		updateDttm = GiftUtilDateTime.returnBestEpoch(updateDttm, updateTimestamp);
		return updateDttm;
	}

	public void setUpdateDttm(long updateDttm) {
		this.updateDttm = updateDttm;
	}

	public Timestamp getCreateTimestamp() {
		createTimestamp = GiftUtilDateTime.returnBestTimestamp(createTimestamp, createDttm);
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Timestamp getUpdateTimestamp() {
		updateTimestamp = GiftUtilDateTime.returnBestTimestamp(updateTimestamp, updateDttm);
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

}
