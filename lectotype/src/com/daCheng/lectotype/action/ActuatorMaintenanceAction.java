package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Actuator;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.service.ActuatorService;
import com.daCheng.lectotype.service.FluidService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ActuatorMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//型号
	private String action;	//动作形式
	private String springRange;	//弹簧范围
	private String airPressure;	//供气压力
	private String airConnection;	//气源接头
	
	public String deleteActuator(){
		ActuatorService service = new ActuatorService();
		service.deleteActuator(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addActuator(){
		ActuatorService service = new ActuatorService();
		
		Actuator actuator = new Actuator(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.action,
				this.springRange,
				this.airPressure,
				this.airConnection);
		
		service.addActuator(actuator);
		
		return Action.SUCCESS;
	}
	
	public void validateAddActuator(){
		//1个不能为空
		//此型号已存在
		ActuatorService service = new ActuatorService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchActuator(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updateActuator(){
		ActuatorService service = new ActuatorService();
		
		Actuator actuator = new Actuator(this.id,
				this.model.trim().replace(" ", ""),
				this.action,
				this.springRange,
				this.airPressure,
				this.airConnection);
		
		service.updateActuator(actuator);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateActuator(){
		//1个不能为空
		//此介质已存在
		ActuatorService service = new ActuatorService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchActuator(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setSpringRange(String springRange) {
		this.springRange = springRange;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public void setAirConnection(String airConnection) {
		this.airConnection = airConnection;
	}
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}
}
