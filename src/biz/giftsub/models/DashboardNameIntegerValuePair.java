package biz.giftsub.models;

public class DashboardNameIntegerValuePair {
	private String name;
	private int value;
	
	public DashboardNameIntegerValuePair(String n, int v) {
		name = n;
		value = v;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
