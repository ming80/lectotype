package com.daCheng.lectotype.domain;

public class Conveyer {
	private String model;	//�ͺ� Model	
	private String outputSignal;	//����ź� Output Sig.mA	
	private String connectionSize;	//�ӿڳߴ� Conn. Size	
	private String explosionProof;	//�����ȼ�  Exp. Class	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getOutputSignal() {
		return outputSignal;
	}
	
	public void setOutputSignal(String outputSignal) {
		this.outputSignal = outputSignal;
	}
	
	public String getConnectionSize() {
		return connectionSize;
	}
	
	public void setConnectionSize(String connectionSize) {
		this.connectionSize = connectionSize;
	}
	
	public String getExplosionProof() {
		return explosionProof;
	}
	
	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}

}
