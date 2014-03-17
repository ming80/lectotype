package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.service.ConveyerService;
import com.daCheng.lectotype.service.FilterReducingValveService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FilterReducingValveMaintenanceAction extends ActionSupport{
	private String id;
	private String model;//型号 Model	
	private String connection;//接口 Conn.
	
	public String deleteFilterReducingValve(){
		FilterReducingValveService service = new FilterReducingValveService();
		service.deleteFilterReducingValve(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addFilterReducingValve(){
		FilterReducingValveService service = new FilterReducingValveService();
		
		FilterReducingValve filterReducingValve = new FilterReducingValve(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.connection);
		
		service.addFilterReducingValve(filterReducingValve);
		
		return Action.SUCCESS;
	}
	
	public void validateAddFilterReducingValve(){
		//1个不能为空
		//此型号已存在
		FilterReducingValveService service = new FilterReducingValveService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchFilterReducingValve(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updateFilterReducingValve(){
		FilterReducingValveService service = new FilterReducingValveService();
		
		FilterReducingValve filterReducingValve = new FilterReducingValve(this.id,
				this.model.trim().replace(" ", ""),
				this.connection);
		
		service.updateFilterReducingValve(filterReducingValve);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateFilterReducingValve(){
		//1个不能为空
		//此介质已存在
		FilterReducingValveService service = new FilterReducingValveService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchFilterReducingValve(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}


}
