package com.daCheng.lectotype.domain;

public class LimitSwitch {
	private String model;	//型号 Model	
	private String jointModel;	//接点型式  Joint Model	
	private String connectionSize;	//接口尺寸  Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getJointModel() {
		return jointModel;
	}
	
	public void setJointModel(String jointModel) {
		this.jointModel = jointModel;
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
