package biz.giftsub.models;

public class DashboardNodes {
	private String id;
	private String label;
	
	public DashboardNodes(String nodeId, String nodeLabel) {
		id = nodeId;
		label = nodeLabel;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
