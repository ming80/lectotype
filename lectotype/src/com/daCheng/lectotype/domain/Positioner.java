package com.daCheng.lectotype.domain;

public class Positioner {
	private String id;
	private String model;	//型号
	private String inputSignal;	//输入信号
	private String airPressure;	//供气压力
	private String signalConnection;	//信号接口
	private String airConnectionSize;	//气接口尺寸
	private String explosionProof;	//防爆等级
	
	private Positioner(){		
	}
	
	public Positioner(String id,
			String model,	//型号
			String inputSignal,	//输入信号
			String airPressure,	//供气压力
			String signalConnection,	//信号接口
			String airConnectionSize,	//气接口尺寸
			String explosionProof){
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
		if(model == null || model.trim().equals(""))
			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.inputSignal = inputSignal;
		this.airPressure = airPressure;
		this.signalConnection = signalConnection;
		this.airConnectionSize = airConnectionSize;
		this.explosionProof = explosionProof;
	}
	
	public String getId(){
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getInputSignal() {
		return inputSignal;
	}
	
	public String getAirPressure() {
		return airPressure;
	}
	
	public String getSignalConnection() {
		return signalConnection;
	}
	
	public String getAirConnectionSize() {
		return airConnectionSize;
	}
	
	public String getExplosionProof() {
		return explosionProof;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setInputSignal(String inputSignal) {
		this.inputSignal = inputSignal;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public void setSignalConnection(String signalConnection) {
		this.signalConnection = signalConnection;
	}

	public void setAirConnectionSize(String airConnectionSize) {
		this.airConnectionSize = airConnectionSize;
	}

	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}	
	
}
