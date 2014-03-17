package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Positioner;
import com.daCheng.lectotype.service.PositionerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PositionerMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//型号
	private String inputSignal;	//输入信号
	private String airPressure;	//供气压力
	private String signalConnection;	//信号接口
	private String airConnectionSize;	//气接口尺寸
	private String explosionProof;	//防爆等级
	
	public String deletePositioner(){
		PositionerService service = new PositionerService();
		service.deletePositioner(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addPositioner(){
		PositionerService service = new PositionerService();
		
		Positioner positioner = new Positioner(UUID.randomUUID().toString(),
				this.model.trim().replace(" ", ""),
				this.inputSignal,
				this.airPressure,
				this.signalConnection,
				this.airConnectionSize,
				this.explosionProof);
		
		service.addPositioner(positioner);
		
		return Action.SUCCESS;
	}
	
	public void validateAddPositioner(){
		//1个不能为空
		//此型号已存在
		PositionerService service = new PositionerService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchPositioner(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");
	}
	
	public String updatePositioner(){
		PositionerService service = new PositionerService();
		
		Positioner positioner = new Positioner(this.id,
				this.model.trim().replace(" ", ""),
				this.inputSignal,
				this.airPressure,
				this.signalConnection,
				this.airConnectionSize,
				this.explosionProof);
		
		service.updatePositioner(positioner);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdatePositioner(){
		//1个不能为空
		//此介质已存在
		PositionerService service = new PositionerService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","型号不能为空!");
		else if(service.hasSuchPositioner(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "此型号已存在!");		
	}
	
	public void setId(String id){
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setInputSignal(String inputSignal) {
		this.inputSignal = inputSignal;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public void setSignalConnection(String signalConnection) {
		this.signalConnection = signalConnection;
	}

	public void setAirConnectionSize(String airConnectionSize) {
		this.airConnectionSize = airConnectionSize;
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
