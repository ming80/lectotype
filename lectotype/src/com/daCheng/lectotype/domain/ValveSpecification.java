package com.daCheng.lectotype.domain;

public class ValveSpecification {
	private String id;
	private String projectName;	//项目名称
	private String tagNo;	//位号
	private String quantity;	//数量
	private String service;	//用途
	private String remarks;	//备注
	
	private ProcessParameter processPara;	//工艺参数
	private Calculation calculation;	//计算
	private SelectedModel selectedModel;	//调节阀选型
	private Actuator actuator;	//执行机构
	private Accessory accessory;	//附件
	
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getTagNo() {
		return tagNo;
	}
	
	public void setTagNo(String tagNo) {
		this.tagNo = tagNo;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public ProcessParameter getProcessPara() {
		return processPara;
	}
	
	public void setProcessPara(ProcessParameter processPara) {
		this.processPara = processPara;
	}
	
	public Calculation getCalculation() {
		return calculation;
	}
	
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}
	
	public SelectedModel getSelectedModel() {
		return selectedModel;
	}
	
	public void setSelectedModel(SelectedModel selectedModel) {
		this.selectedModel = selectedModel;
	}
	
	public Actuator getActuator() {
		return actuator;
	}
	
	public void setActuator(Actuator actuator) {
		this.actuator = actuator;
	}
	
	public Accessory getAccessory() {
		return accessory;
	}
	
	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setID(String id) {
		id = id;
	}
	
	
	
	
}
