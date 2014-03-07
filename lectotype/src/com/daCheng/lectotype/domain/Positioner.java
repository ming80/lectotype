package com.daCheng.lectotype.domain;

public class Positioner {
	private String id;
	private String model;	//�ͺ�
	private String inputSignal;	//�����ź�
	private String airPressure;	//����ѹ��
	private String signalConnection;	//�źŽӿ�
	private String airConnectionSize;	//���ӿڳߴ�
	private String explosionProof;	//�����ȼ�
	
	private Positioner(){		
	}
	
	public Positioner(String id,
			String model,	//�ͺ�
			String inputSignal,	//�����ź�
			String airPressure,	//����ѹ��
			String signalConnection,	//�źŽӿ�
			String airConnectionSize,	//���ӿڳߴ�
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
	
}
