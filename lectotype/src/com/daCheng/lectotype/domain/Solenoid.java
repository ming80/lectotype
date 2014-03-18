package com.daCheng.lectotype.domain;

public class Solenoid {
	private String id;
	private String model;	//�ͺ� Model	
	private String supplyPower;	//��Դ��ѹ Supply Power.v	
	private String powerConnection;	//��Դ�ӿ� Power Conn.	
	private String airConnection;	//���ӿڳߴ� Air Conn.	
	private String explosionProof;	//�����ȼ�   Exp. Class	
	
	private Solenoid(){}
	
	public Solenoid(String id,
			String model,	//�ͺ� Model	
	 		String supplyPower,	//��Դ��ѹ Supply Power.v	
	 		String powerConnection,	//��Դ�ӿ� Power Conn.	
	 		String airConnection,	//���ӿڳߴ� Air Conn.	
	 		String explosionProof){
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
//		if(model == null || model.trim().equals(""))
//			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.supplyPower = supplyPower;
		this.powerConnection = powerConnection;
		this.airConnection = airConnection;
		this.explosionProof = explosionProof;
	}
	
	public String getId() {
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getSupplyPower() {
		return supplyPower;
	}
	
	public String getPowerConnection() {
		return powerConnection;
	}
	
	public String getAirConnection() {
		return airConnection;
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

	public void setSupplyPower(String supplyPower) {
		this.supplyPower = supplyPower;
	}

	public void setPowerConnection(String powerConnection) {
		this.powerConnection = powerConnection;
	}

	public void setAirConnection(String airConnection) {
		this.airConnection = airConnection;
	}

	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}
}
