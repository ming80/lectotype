package com.daCheng.lectotype.action;

import java.util.Date;

import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.service.ValveSpecificationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ValveSpecificationAddingAction extends ActionSupport{
	private ValveSpecification valveSpecification;
	private boolean isSeccessful;
	private String msg;
	
	public String execute(){
		ValveSpecificationService service = new ValveSpecificationService();
		String id = "" + new Date().getTime();
		
		if(service.hasSuchValveSpecification(id)){
			this.isSeccessful = false;
			this.msg = "此选型表已存在,id:" + id;	
			return Action.ERROR;
		}
		
		valveSpecification.setId(id);
		service.addValveSpecification(valveSpecification);
		this.isSeccessful = true;
		return Action.SUCCESS;
			
	}
	
	public void setValveSpecification(ValveSpecification valveSpecification){
		this.valveSpecification = valveSpecification;
	}

	public ValveSpecification getValveSpecification() {
		return valveSpecification;
	}
}
