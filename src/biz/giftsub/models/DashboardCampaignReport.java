package biz.giftsub.models;

import java.math.BigDecimal;
import java.util.List;

public class DashboardCampaignReport {
	private List<Long> xAxisDataInEpochs;
	private List<Integer> seriesDataInIntegers;
	private List<BigDecimal> seriesDataInBigDecimal;
	private List<DashboardNameIntegerValuePair> nameIntegerValuePairs;
	private int seriesMaxInInteger;
	private List<String> legend;
	private List<DashboardNodes> nodes;
	private List<DashboardEdges> edges;

	public List<Long> getxAxisDataInEpochs() {
		return xAxisDataInEpochs;
	}
	public void setxAxisDataInEpochs(List<Long> xAxisDataInEpochs) {
		this.xAxisDataInEpochs = xAxisDataInEpochs;
	}
	public List<Integer> getSeriesDataInIntegers() {
		return seriesDataInIntegers;
	}
	public void setSeriesDataInIntegers(List<Integer> seriesDataInIntegers) {
		this.seriesDataInIntegers = seriesDataInIntegers;
	}
	public List<BigDecimal> getSeriesDataInBigDecimal() {
		return seriesDataInBigDecimal;
	}
	public void setSeriesDataInBigDecimal(List<BigDecimal> seriesDataInBigDecimal) {
		this.seriesDataInBigDecimal = seriesDataInBigDecimal;
	}
	public List<DashboardNameIntegerValuePair> getNameIntegerValuePairs() {
		return nameIntegerValuePairs;
	}
	public void setNameIntegerValuePairs(List<DashboardNameIntegerValuePair> nameIntegerValuePairs) {
		this.nameIntegerValuePairs = nameIntegerValuePairs;
	}
	public int getSeriesMaxInInteger() {
		return seriesMaxInInteger;
	}
	public void setSeriesMaxInInteger(int seriesMaxInInteger) {
		this.seriesMaxInInteger = seriesMaxInInteger;
	}
	public List<String> getLegend() {
		return legend;
	}
	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
	public List<DashboardNodes> getNodes() {
		return nodes;
	}
	public void setNodes(List<DashboardNodes> nodes) {
		this.nodes = nodes;
	}
	public List<DashboardEdges> getEdges() {
		return edges;
	}
	public void setEdges(List<DashboardEdges> edges) {
		this.edges = edges;
	}

}
