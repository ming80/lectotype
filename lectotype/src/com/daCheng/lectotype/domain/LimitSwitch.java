package com.daCheng.lectotype.domain;

public class LimitSwitch {
	private String id;
	private String model;	//型号 Model	
	private String jointModel;	//接点型式  Joint Model	
	private String connectionSize;	//接口尺寸  Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class	
	
	private LimitSwitch(){		
	}
	
	public LimitSwitch(String id,
			String model,	//型号 Model	
			String jointModel,	//接点型式  Joint Model	
			String connectionSize,	//接口尺寸  Conn. Size	
			String explosionProof){	
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
		if(model == null || model.trim().equals(""))
			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.jointModel = jointModel;
		this.connectionSize = connectionSize;
		this.explosionProof = explosionProof;
	}
	
	public String getId(){
		return id;
	}
	
	public String getModel() {
		return model;
	}

	public String getJointModel() {
		return jointModel;
	}

	public String getConnectionSize() {
		return connectionSize;
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

	public void setJointModel(String jointModel) {
		this.jointModel = jointModel;
	}

	public void setConnectionSize(String connectionSize) {
		this.connectionSize = connectionSize;
	}

	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}

}
