package com.daCheng.lectotype.domain;

public class Actuator {
	private String model;	//�ͺ�
	private String action;	//������ʽ
	private String springRange;	//���ɷ�Χ
	private String airPressure;	//����ѹ��
	private String airConnection;	//��Դ��ͷ
	
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
