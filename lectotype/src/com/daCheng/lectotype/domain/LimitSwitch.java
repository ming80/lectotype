package com.daCheng.lectotype.domain;

public class LimitSwitch {
	private String id;
	private String model;	//�ͺ� Model	
	private String jointModel;	//�ӵ���ʽ  Joint Model	
	private String connectionSize;	//�ӿڳߴ�  Conn. Size	
	private String explosionProof;	//�����ȼ�  Exp. Class	
	
	private LimitSwitch(){		
	}
	
	public LimitSwitch(String id,
			String model,	//�ͺ� Model	
			String jointModel,	//�ӵ���ʽ  Joint Model	
			String connectionSize,	//�ӿڳߴ�  Conn. Size	
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

}
