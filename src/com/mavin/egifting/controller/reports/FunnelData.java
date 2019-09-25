package com.mavin.egifting.controller.reports;

public class FunnelData {

	private int value;
	private String name;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FunnelData [value=" + value + ", name=" + name + "]";
	}

}
