package com.daCheng.lectotype.domain;

public class Solenoid {
	private String model;	//�ͺ� Model	
	private String supplyPower;	//��Դ��ѹ Supply Power.v	
	private String powerConnection;	//��Դ�ӿ� Power Conn.	
	private String airConnection;	//���ӿڳߴ� Air Conn.	
	private String explosionProof;	//�����ȼ�   Exp. Class	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSupplyPower() {
		return supplyPower;
	}
	
	public void setSupplyPower(String supplyPower) {
		this.supplyPower = supplyPower;
	}
	
	public String getPowerConnection() {
		return powerConnection;
	}
	
	public void setPowerConnection(String powerConnection) {
		this.powerConnection = powerConnection;
	}
	
	public String getAirConnection() {
		return airConnection;
	}
	
	public void setAirConnection(String airConnection) {
		this.airConnection = airConnection;
	}
	
	public String getExplosionProof() {
		return explosionProof;
	}
	
	public void setExplosionProof(String explosionProof) {
		this.explosionProof = explosionProof;
	}

}
