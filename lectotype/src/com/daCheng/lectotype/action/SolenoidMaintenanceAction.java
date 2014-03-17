package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Positioner;
import com.daCheng.lectotype.domain.Solenoid;
import com.daCheng.lectotype.service.PositionerService;
import com.daCheng.lectotype.service.SolenoidService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SolenoidMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//型号 Model	
	private String supplyPower;	//电源电压 Supply Power.v	
	private String powerConnection;	//电源接口 Power Conn.	
	private String airConnection;	//气接口尺寸 Air Conn.	
	private String explosionProof;	//防爆等级   Exp. Class	
	
	public String deleteSolenoid(){
		SolenoidService service = new SolenoidService();
		service.deleteSolenoid(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addSolenoid(){
		SolenoidService service = new SolenoidService();
		
		Solenoid solenoid = new Solenoid(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.supplyPower,
				this.powerConnection,
				this.airConnection,
				this.explosionProof);
		
		service.addSolenoid(solenoid);
		
		return Action.SUCCESS;
	}
	
	public void validateAddSolenoid(){
		//1个不能为空
		//此型号已存在
		SolenoidService service = new SolenoidService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchSolenoid(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updateSolenoid(){
		SolenoidService service = new SolenoidService();
		
		Solenoid solenoid = new Solenoid(this.id,
				this.model.trim().replace(" ", ""),
				this.supplyPower,
				this.powerConnection,
				this.airConnection,
				this.explosionProof);
		
		service.updateSolenoid(solenoid);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateSolenoid(){
		//1个不能为空
		//此介质已存在
		SolenoidService service = new SolenoidService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchSolenoid(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
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
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}
}
