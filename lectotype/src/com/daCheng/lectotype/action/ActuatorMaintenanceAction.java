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
	private String model;	//�ͺ�
	private String action;	//������ʽ
	private String springRange;	//���ɷ�Χ
	private String airPressure;	//����ѹ��
	private String airConnection;	//��Դ��ͷ
	
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
		//1������Ϊ��
		//���ͺ��Ѵ���
		ActuatorService service = new ActuatorService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchActuator(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");
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
		//1������Ϊ��
		//�˽����Ѵ���
		ActuatorService service = new ActuatorService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchActuator(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");		
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
