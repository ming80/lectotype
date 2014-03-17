package com.daCheng.lectotype.domain;

public class Conveyer {
	private String id;
	private String model;	//型号 Model	
	private String outputSignal;	//输出信号 Output Sig.mA	
	private String connectionSize;	//接口尺寸 Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class	
	
	private Conveyer(){		
	}
	
	public Conveyer(String id,
			String model,	//型号 Model	
			String outputSignal,	//输出信号 Output Sig.mA	
			String connectionSize,	//接口尺寸  Conn. Size	
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
