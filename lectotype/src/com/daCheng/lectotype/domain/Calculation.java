package com.daCheng.lectotype.domain;

public class Calculation {
	private String Kvmax;	//计算Kvmax
	private String Kvnor;
	private String Kvmin;//计算Kvmin
	private String selectedKv;//选用Kv
	private String adjustableRatio;//可调比
	private String flowCharacteristic;//流量特性
	private String Kmax;//阀开度Kmax
	private String Knor;
	private String Kmin;//阀开度Kmin
	private String nominalPressure;//公称压力
	private String noiseLevel;//噪声估算
	private String closeOpen;//气开/气关
	
	public String getKvmax() {
		return Kvmax;
	}
	
	public void setKvmax(String kvmax) {
		Kvmax = kvmax;
	}
	
	public String getKvnor() {
		return Kvnor;
	}

	public void setKvnor(String kvnor) {
		Kvnor = kvnor;
	}
	
	public String getKvmin() {
		return Kvmin;
	}
	
	public void setKvmin(String kvmin) {
		Kvmin = kvmin;
	}
	
	public String getSelectedKv() {
		return selectedKv;
	}
	
	public void setSelectedKv(String selectedKv) {
		this.selectedKv = selectedKv;
	}
	
	public String getAdjustableRatio() {
		return adjustableRatio;
	}
	
	public void setAdjustableRatio(String adjustableRatio) {
		this.adjustableRatio = adjustableRatio;
	}
	
	public String getFlowCharacteristic() {
		return flowCharacteristic;
	}
	
	public void setFlowCharacteristic(String flowCharacteristic) {
		this.flowCharacteristic = flowCharacteristic;
	}
	
	public String getKmax() {
		return Kmax;
	}
	
	public void setKmax(String kmax) {
		Kmax = kmax;
	}
	
	public String getKnor() {
		return Knor;
	}

	public void setKnor(String knor) {
		Knor = knor;
	}	
	
	public String getKmin() {
		return Kmin;
	}
	
	public void setKmin(String kmin) {
		Kmin = kmin;
	}
	
	public String getNominalPressure() {
		return nominalPressure;
	}
	
	public void setNominalPressure(String nominalPressure) {
		this.nominalPressure = nominalPressure;
	}
	
	public String getNoiseLevel() {
		return noiseLevel;
	}
	
	public void setNoiseLevel(String noiseLevel) {
		this.noiseLevel = noiseLevel;
	}
	
	public String getCloseOpen() {
		return closeOpen;
	}
	
	public void setCloseOpen(String closeOpen) {
		this.closeOpen = closeOpen;
	}
}
