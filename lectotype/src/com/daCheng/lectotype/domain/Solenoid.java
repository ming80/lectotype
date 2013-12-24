package com.daCheng.lectotype.domain;

public class Solenoid {
	private String model;	//型号 Model	
	private String supplyPower;	//电源电压 Supply Power.v	
	private String powerConnection;	//电源接口 Power Conn.	
	private String airConnection;	//气接口尺寸 Air Conn.	
	private String explosionProof;	//防爆等级   Exp. Class	
	
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
