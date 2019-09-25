package biz.giftsub.models;

public class DashboardEdges {
	private String from;
	private String to;
	
	public DashboardEdges(String fromNode, String toNode) {
		from = fromNode;
		to = toNode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

}
