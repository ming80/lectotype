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
	private String model;	//�ͺ� Model	
	private String supplyPower;	//��Դ��ѹ Supply Power.v	
	private String powerConnection;	//��Դ�ӿ� Power Conn.	
	private String airConnection;	//���ӿڳߴ� Air Conn.	
	private String explosionProof;	//�����ȼ�   Exp. Class	
	
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
		//1������Ϊ��
		//���ͺ��Ѵ���
		SolenoidService service = new SolenoidService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchSolenoid(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");
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
		//1������Ϊ��
		//�˽����Ѵ���
		SolenoidService service = new SolenoidService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchSolenoid(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");		
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
