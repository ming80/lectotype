package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.service.ConveyerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ConveyerMaintenanceAction extends ActionSupport{
	private String id;
	private String model;	//�ͺ� Model	
	private String outputSignal;	//����ź� Output Sig.mA	
	private String connectionSize;	//�ӿڳߴ�  Conn. Size	
	private String explosionProof;	//�����ȼ�  Exp. Class
	
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
		//1������Ϊ��
		//���ͺ��Ѵ���
		ConveyerService service = new ConveyerService();
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchConveyer(this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");
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
		//1������Ϊ��
		//�˽����Ѵ���
		ConveyerService service = new ConveyerService();		
		
		if(isEmptyString(this.model))
			this.addFieldError("model","�ͺŲ���Ϊ��!");
		else if(service.hasSuchConveyer(this.id,this.model.trim().replace(" ", "")))
			this.addFieldError("model", "���ͺ��Ѵ���!");		
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
