package com.daCheng.lectotype.domain;

public class ProcessParameter {
	private String pipeSizeAndMaterial;	//管道尺寸/材质
	private String fluidState;	//介质类型
	private String fluidName;	//介质名称
	private String density;	//密度
	private String flowUnit;	//流量单位
	private String Qmax;	//最大流量
	private String Qnor;	//正常流量
	private String Qmin;	//最小流量
	               
	private String operationTemperature;	//操作温度
	private String pressureUnit;	//压力单位
	private String upstreamPressure;	//阀前压力
	private String downstreamPressure;	//阀后压力
	private String differentialPressure;	//关闭时压差
	private String dynamicViscosity;	//运动粘度
	private String compressFactor;	//压缩系数
	private String vaporPressure;	//汽化压力
	private String criticalPressure;	//临界压力
	
	public String getPipeSizeAndMaterial() {
		return pipeSizeAndMaterial;
	}
	
	public void setPipeSizeAndMaterial(String pipeSizeAndMaterial) {
		this.pipeSizeAndMaterial = pipeSizeAndMaterial;
	}
	
	public String getFluidState() {
		return fluidState;
	}
	
	public void setFluidState(String fluidState) {
		this.fluidState = fluidState;
	}
	
	public String getFluidName() {
		return fluidName;
	}
	
	public void setFluidName(String fluidName) {
		this.fluidName = fluidName;
	}
	
	public String getDensity() {
		return density;
	}
	
	public void setDensity(String density) {
		this.density = density;
	}
	
	public String getFlowUnit() {
		return flowUnit;
	}
	
	public void setFlowUnit(String flowUnit) {
		this.flowUnit = flowUnit;
	}
	
	public String getQmax() {
		return Qmax;
	}
	
	public void setQmax(String qmax) {
		Qmax = qmax;
	}
	
	public String getQnor() {
		return Qnor;
	}
	
	public void setQnor(String qnor) {
		Qnor = qnor;
	}
	
	public String getQmin() {
		return Qmin;
	}
	
	public void setQmin(String qmin) {
		Qmin = qmin;
	}
	
	public String getOperationTemperature() {
		return operationTemperature;
	}
	                                           
	public void setOperationTemperature(String operationTemperature) {
		this.operationTemperature = operationTemperature;
	}
	
	public String getPressureUnit() {
		return pressureUnit;
	}
	                                   
	public void setPressureUnit(String pressureUnit) {
		this.pressureUnit = pressureUnit;
	}                       
	
	public String getUpstreamPressure() {
		return upstreamPressure;
	}
	
	public void setUpstreamPressure(String upstreamPressure) {
		this.upstreamPressure = upstreamPressure;
	}
	
	public String getDownstreamPressure() {
		return downstreamPressure;
	}
	
	public void setDownstreamPressure(String downstreamPressure) {
		this.downstreamPressure = downstreamPressure;
	}
	
	public String getDifferentialPressure() {
		return differentialPressure;
	}
	
	public void setDifferentialPressure(String differentialPressure) {
		this.differentialPressure = differentialPressure;
	}
	
	public String getDynamicViscosity() {
		return dynamicViscosity;
	}
	
	public void setDynamicViscosity(String dynamicViscosity) {
		this.dynamicViscosity = dynamicViscosity;
	}
	
	public String getCompressFactor() {
		return compressFactor;
	}
	
	public void setCompressFactor(String compressFactor) {
		this.compressFactor = compressFactor;
	}
	
	public String getVaporPressure() {
		return vaporPressure;
	}
	
	public void setVaporPressure(String vaporPressure) {
		this.vaporPressure = vaporPressure;
	}
	
	public String getCriticalPressure() {
		return criticalPressure;
	}
	
	public void setCriticalPressure(String criticalPressure) {
		this.criticalPressure = criticalPressure;
	}	
}
