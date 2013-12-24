package com.daCheng.lectotype.domain;

public class Positioner {
	private String model;	//型号
	private String inputSignal;	//输入信号
	private String airPressure;	//供气压力
	private String signalConnection;	//信号接口
	private String airConnectionSize;	//气接口尺寸
	private String explosionProof;	//防爆等级
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getInputSignal() {
		return inputSignal;
	}
	
	public void setInputSignal(String inputSignal) {
		this.inputSignal = inputSignal;
	}
	
	public String getAirPressure() {
		return airPressure;
	}
	
	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}
	
	public String getSignalConnection() {
		return signalConnection;
	}
	
	public void setSignalConnection(String signalConnection) {
		this.signalConnection = signalConnection;
	}
	
	public String getAirConnectionSize() {
		return airConnectionSize;
	}
	
	public void setAirConnectionSize(String airConnectionSize) {
		this.airConnectionSize = airConnectionSize;
	}
	
	public String getExplosionProof() {
		return explosionProof;
	}
	
	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}
	
	
}
