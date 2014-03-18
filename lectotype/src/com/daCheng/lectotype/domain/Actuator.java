package com.daCheng.lectotype.domain;

public class Actuator {
	private String id;
	private String model;	//型号
	private String action;	//动作形式
	private String springRange;	//弹簧范围
	private String airPressure;	//供气压力
	private String airConnection;	//气源接头
	
	private Actuator(){}
	
	public Actuator(String id,String model,String action,
			String springRange,String airPressure,String airConnection){
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
//		if(model == null || model.trim().equals(""))
//			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.action = action;
		this.springRange = springRange;
		this.airPressure = airPressure;	
		this.airConnection = airConnection;
	}
	
	public String getId(){
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getSpringRange() {
		return springRange;
	}
	
	public String getAirPressure() {
		return airPressure;
	}
	
	public String getAirConnection() {
		return airConnection;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setSpringRange(String springRange) {
		this.springRange = springRange;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public void setAirConnection(String airConnection) {
		this.airConnection = airConnection;
	}
}
