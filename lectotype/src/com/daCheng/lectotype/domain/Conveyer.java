package com.daCheng.lectotype.domain;

public class Conveyer {
	private String id;
	private String model;	//�ͺ� Model	
	private String outputSignal;	//����ź� Output Sig.mA	
	private String connectionSize;	//�ӿڳߴ� Conn. Size	
	private String explosionProof;	//�����ȼ�  Exp. Class	
	
	private Conveyer(){		
	}
	
	public Conveyer(String id,
			String model,	//�ͺ� Model	
			String outputSignal,	//����ź� Output Sig.mA	
			String connectionSize,	//�ӿڳߴ�  Conn. Size	
			String explosionProof){	
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
		if(model == null || model.trim().equals(""))
			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.outputSignal = outputSignal;
		this.connectionSize = connectionSize;
		this.explosionProof = explosionProof;
	}
	
	public String getId(){
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getOutputSignal() {
		return outputSignal;
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

	public void setOutputSignal(String outputSignal) {
		this.outputSignal = outputSignal;
	}

	public void setConnectionSize(String connectionSize) {
		this.connectionSize = connectionSize;
	}

	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}

}
