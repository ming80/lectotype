package com.daCheng.lectotype.domain;

public class SelectedModel {
	private String id;
	private String name;	//名称
	private String model;	//型号
	private String diameterNominal;	//公称通径
	private String seatDiameter;	//阀座直径
	private String nominalPressure;	//公称压力
	private String flowOpenClose;	//流开/流闭
	private String airFail;	//失气位置
	private String flowCharacter;	//流量特性
	private String bodyMaterial;	//阀体材质
	private String seatMaterial;	//阀座材质
	private String plugMaterial;	//阀芯材质
	private String packing;	//填料
	private String bonnetType;	//上阀盖型式
	private String connectionFlange;	//连接法兰
	private String leakageClass;	//泄露等级
	
	private SelectedModel(){}
	
	public SelectedModel(String id,
			String name,
			String model,
			String diameterNominal,
			String seatDiameter,
			String nominalPressure,
			String flowOpenClose,
			String airFail,
			String flowCharacter,
			String bodyMaterial,
			String seatMaterial,
			String plugMaterial,
			String packing,
			String bonnetType,
			String connectionFlange,
			String leakageClass){
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
		if(name == null || name.trim().equals(""))
			throw new IllegalArgumentException("name is empty!");
		
		this.id = id;
		this.name = name;
		this.model = model;
		this.diameterNominal = diameterNominal;
		this.seatDiameter = seatDiameter;
		this.nominalPressure = nominalPressure;
		this.flowOpenClose = flowOpenClose;
		this.airFail = airFail;
		this.flowCharacter = flowCharacter;
		this.bodyMaterial = bodyMaterial;
		this.seatMaterial = seatMaterial;
		this.plugMaterial = plugMaterial;
		this.packing = packing;
		this.bonnetType = bonnetType;
		this.connectionFlange = connectionFlange;
		this.leakageClass = leakageClass;
	}
	
	public String getName() {
		return name;
	}
		
	public String getModel() {
		return model;
	}
		
	public String getDiameterNominal() {
		return diameterNominal;
	}
		
	public String getSeatDiameter() {
		return seatDiameter;
	}
	
	public String getNominalPressure() {
		return nominalPressure;
	}
	
	public String getFlowOpenClose() {
		return flowOpenClose;
	}
	
	public String getAirFail() {
		return airFail;
	}
	
	public String getFlowCharacter() {
		return flowCharacter;
	}
	
	public String getBodyMaterial() {
		return bodyMaterial;
	}
	
	public String getSeatMaterial() {
		return seatMaterial;
	}
	
	public String getPlugMaterial() {
		return plugMaterial;
	}
	
	public String getPacking() {
		return packing;
	}
	
	public String getBonnetType() {
		return bonnetType;
	}
	
	public String getConnectionFlange() {
		return connectionFlange;
	}
	
	public String getLeakageClass() {
		return leakageClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
}
