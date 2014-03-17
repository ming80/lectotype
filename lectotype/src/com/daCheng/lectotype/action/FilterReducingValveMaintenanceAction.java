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
	private String model;//�ͺ� Model	
	private String connection;//�ӿ� Conn.
	
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
		//1������Ϊ��
		//���ͺ��Ѵ���
		FilterReducingValveService service = new FilterReducingValveService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchFilterReducingValve(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");
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
		//1������Ϊ��
		//�˽����Ѵ���
		FilterReducingValveService service = new FilterReducingValveService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchFilterReducingValve(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");		
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
