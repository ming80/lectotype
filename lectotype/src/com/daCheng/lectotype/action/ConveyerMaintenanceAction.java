package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.service.ConveyerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ConveyerMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//型号 Model	
	private String outputSignal;	//输出信号 Output Sig.mA	
	private String connectionSize;	//接口尺寸  Conn. Size	
	private String explosionProof;	//防爆等级  Exp. Class
	
	public String deleteConveyer(){
		ConveyerService service = new ConveyerService();
		service.deleteConveyer(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addConveyer(){
		ConveyerService service = new ConveyerService();
		
		Conveyer conveyer = new Conveyer(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.outputSignal,
				this.connectionSize,
				this.explosionProof);
		
		service.addConveyer(conveyer);
		
		return Action.SUCCESS;
	}
	
	public void validateAddConveyer(){
		//1个不能为空
		//此型号已存在
		ConveyerService service = new ConveyerService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchConveyer(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updateConveyer(){
		ConveyerService service = new ConveyerService();
		
		Conveyer conveyer = new Conveyer(this.id,
				this.model.trim().replace(" ", ""),
				this.outputSignal,
				this.connectionSize,
				this.explosionProof);
		
		service.updateConveyer(conveyer);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateConveyer(){
		//1个不能为空
		//此介质已存在
		ConveyerService service = new ConveyerService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchConveyer(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOutputSignal(String outputSignal) {
		this.outputSignal = outputSignal;
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
