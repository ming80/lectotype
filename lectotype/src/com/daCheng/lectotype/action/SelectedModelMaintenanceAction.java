package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.SelectedModel;
import com.daCheng.lectotype.service.SelectedModelService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SelectedModelMaintenanceAction extends ActionSupport{
	private String id;
	private String name;	//����
	private String model;	//�ͺ�
	private String diameterNominal;	//����ͨ��
	private String seatDiameter;	//����ֱ��
	private String nominalPressure;	//����ѹ��
	private String flowOpenClose;	//����/����
	private String airFail;	//ʧ��λ��
	private String flowCharacter;	//��������
	private String bodyMaterial;	//�������
	private String seatMaterial;	//��������
	private String plugMaterial;	//��о����
	private String packing;	//����
	private String bonnetType;	//�Ϸ�����ʽ
	private String connectionFlange;	//���ӷ���
	private String leakageClass;	//й¶�ȼ�
	
	public String deleteSelectedModel(){
		SelectedModelService service = new SelectedModelService();
		service.deleteSelectedModel(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addSelectedModel(){
		SelectedModelService service = new SelectedModelService();
		
		SelectedModel selectedModel = new SelectedModel(UUID.randomUUID().toString(),
				this.name.trim().replace(" ", ""),
				this.model,
				this.diameterNominal,
				this.seatDiameter,
				this.nominalPressure,
				this.flowOpenClose,
				this.airFail,
				this.flowCharacter,
				this.bodyMaterial,
				this.seatMaterial,
				this.plugMaterial,
				this.packing,
				this.bonnetType,
				this.connectionFlange,
				this.leakageClass);
		
		service.addSelectedModel(selectedModel);
		
		return Action.SUCCESS;
	}
	
	public void validateAddSelectedModel(){
		//���Ʋ���Ϊ��		
		//�˷��������Ѵ���		
		//����/����ֻ����'��'��'��'
		//ʧ��λ��ֻ����'��'��'��'
		//��������ֻ����...
		SelectedModelService service = new SelectedModelService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","���Ʋ���Ϊ��!");
		else if(service.hasSuchSelectedModel(this.name.trim().replace(" ", "")))
			this.addFieldError("name", "�˷��������Ѵ���!");
			
		if(!isLegalFlowOpenClose())
			addFieldError("flowOpenClose","��ѡ������/����!");
		
		if(!isLegalAirFail())
			addFieldError("airFail","��ѡ��ʧ��λ��!");	
		
		if(!isLegalFlowCharacter())
			addFieldError("flowCharacter","��ѡ����������!");	
	}
	
	public String updateSelectedModel(){
		SelectedModelService service = new SelectedModelService();
		
		SelectedModel selectedModel = new SelectedModel(this.id,
				this.name.trim().replace(" ", ""),
				this.model,
				this.diameterNominal,
				this.seatDiameter,
				this.nominalPressure,
				this.flowOpenClose,
				this.airFail,
				this.flowCharacter,
				this.bodyMaterial,
				this.seatMaterial,
				this.plugMaterial,
				this.packing,
				this.bonnetType,
				this.connectionFlange,
				this.leakageClass);
		
		service.updateSelectedModel(selectedModel);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateSelectedModel(){
		//���Ʋ���Ϊ��		
		//�˷��������Ѵ���		
		//����/����ֻ����'��'��'��'
		//ʧ��λ��ֻ����'��'��'��'
		//��������ֻ����...
		SelectedModelService service = new SelectedModelService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","���Ʋ���Ϊ��!");
		else if(service.hasSuchSelectedModel(this.id,this.name.trim().replace(" ", "")))
			this.addFieldError("name", "�˷��������Ѵ���!");
			
		if(!isLegalFlowOpenClose())
			addFieldError("flowOpenClose","��ѡ������/����!");
		
		if(!isLegalAirFail())
			addFieldError("airFail","��ѡ��ʧ��λ��!");	
		
		if(!isLegalFlowCharacter())
			addFieldError("flowCharacter","��ѡ����������!");	
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setDiameterNominal(String diameterNominal) {
		this.diameterNominal = diameterNominal;
	}

	public void setSeatDiameter(String seatDiameter) {
		this.seatDiameter = seatDiameter;
	}

	public void setNominalPressure(String nominalPressure) {
		this.nominalPressure = nominalPressure;
	}

	public void setFlowOpenClose(String flowOpenClose) {
		this.flowOpenClose = flowOpenClose;
	}

	public void setAirFail(String airFail) {
		this.airFail = airFail;
	}

	public void setFlowCharacter(String flowCharacter) {
		this.flowCharacter = flowCharacter;
	}

	public void setBodyMaterial(String bodyMaterial) {
		this.bodyMaterial = bodyMaterial;
	}

	public void setSeatMaterial(String seatMaterial) {
		this.seatMaterial = seatMaterial;
	}

	public void setPlugMaterial(String plugMaterial) {
		this.plugMaterial = plugMaterial;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public void setBonnetType(String bonnetType) {
		this.bonnetType = bonnetType;
	}

	public void setConnectionFlange(String connectionFlange) {
		this.connectionFlange = connectionFlange;
	}

	public void setLeakageClass(String leakageClass) {
		this.leakageClass = leakageClass;
	}

	private boolean isLegalFlowOpenClose(){
		if(isEmptyString(this.flowOpenClose))
			return false;
		if(this.flowOpenClose.trim().equals("open"))
			return true;
		if(this.flowOpenClose.trim().equals("close"))
			return true;
		return false;	
	}
	
	private boolean isLegalAirFail(){
		if(isEmptyString(this.airFail))
			return false;
		if(this.airFail.trim().equals("open"))
			return true;
		if(this.airFail.trim().equals("close"))
			return true;
		return false;	
	}
	
	private boolean isLegalFlowCharacter(){
		if(isEmptyString(this.flowCharacter))
			return false;
		if(this.flowCharacter.trim().equals("equalPercentage"))
			return true;
		if(this.flowCharacter.trim().equals("linear"))
			return true;
		if(this.flowCharacter.trim().equals("quickOpening"))
			return true;
		if(this.flowCharacter.trim().equals("squareRoot"))
			return true;
		if(this.flowCharacter.trim().equals("modifiedParabolic"))
			return true;
		return false;	
	}
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}	
}
