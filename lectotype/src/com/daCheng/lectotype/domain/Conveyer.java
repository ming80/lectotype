package com.daCheng.lectotype.domain;

public class Conveyer {
	private String model;	//型号 Model	
	private String outputSignal;	//输出信号 Output Sig.mA	
	private String connectionSize;	//接口尺寸 Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class	
	
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
