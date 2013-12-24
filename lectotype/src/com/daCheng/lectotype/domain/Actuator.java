package com.daCheng.lectotype.domain;

public class Actuator {
	private String model;	//型号
	private String action;	//动作形式
	private String springRange;	//弹簧范围
	private String airPressure;	//供气压力
	private String airConnection;	//气源接头
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getSpringRange() {
		return springRange;
	}
	
	public void setSpringRange(String springRange) {
		this.springRange = springRange;
	}
	
	public String getAirPressure() {
		return airPressure;
	}
	
	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}
	
	public String getAirConnection() {
		return airConnection;
	}
	
	public void setAirConnection(String airConnection) {
		this.airConnection = airConnection;
	}
}
