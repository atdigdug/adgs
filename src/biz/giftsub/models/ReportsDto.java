package biz.giftsub.models;

import java.math.BigDecimal;

public class ReportsDto {
	private long epoch;
	private int integerData;
	private BigDecimal bigDecimalData;
	
	// funnel-specific
	private int totalSales;
	private int totalEmailsOpened;
	private int totalClaims;
	
	// network graph
	private String fromNode;
	private String toNode;

	public long getEpoch() {
		return epoch;
	}
	public void setEpoch(long epoch) {
		this.epoch = epoch;
	}
	public int getIntegerData() {
		return integerData;
	}
	public void setIntegerData(int integerData) {
		this.integerData = integerData;
	}
	public BigDecimal getBigDecimalData() {
		return bigDecimalData;
	}
	public void setBigDecimalData(BigDecimal bigDecimalData) {
		this.bigDecimalData = bigDecimalData;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public int getTotalEmailsOpened() {
		return totalEmailsOpened;
	}
	public void setTotalEmailsOpened(int totalEmailsOpened) {
		this.totalEmailsOpened = totalEmailsOpened;
	}
	public int getTotalClaims() {
		return totalClaims;
	}
	public void setTotalClaims(int totalClaims) {
		this.totalClaims = totalClaims;
	}
	public String getFromNode() {
		return fromNode;
	}
	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}
	public String getToNode() {
		return toNode;
	}
	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

}
