package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.service.LimitSwitchService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LimitSwitchMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//型号 Model	
	private String jointModel;	//接点型式  Joint Model	
	private String connectionSize;	//接口尺寸  Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class
	
	public String deleteLimitSwitch(){
		LimitSwitchService service = new LimitSwitchService();
		service.deleteLimitSwitch(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addLimitSwitch(){
		LimitSwitchService service = new LimitSwitchService();
		
		LimitSwitch limitSwitch = new LimitSwitch(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.jointModel,
				this.connectionSize,
				this.explosionProof);
		
		service.addLimitSwitch(limitSwitch);
		
		return Action.SUCCESS;
	}
	
	public void validateAddLimitSwitch(){
		//1个不能为空
		//此型号已存在
		LimitSwitchService service = new LimitSwitchService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchLimitSwitch(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updateLimitSwitch(){
		LimitSwitchService service = new LimitSwitchService();
		
		LimitSwitch limitSwitch = new LimitSwitch(this.id,
				this.model.trim().replace(" ", ""),
				this.jointModel,
				this.connectionSize,
				this.explosionProof);
		
		service.updateLimitSwitch(limitSwitch);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateLimitSwitch(){
		//1个不能为空
		//此介质已存在
		LimitSwitchService service = new LimitSwitchService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchLimitSwitch(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
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
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}


}
