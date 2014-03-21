package com.daCheng.lectotype.domain;

public class Calculation {
	private String Kvmax;	//����Kvmax
	private String Kvnor;
	private String Kvmin;//����Kvmin
	private String selectedKv;//ѡ��Kv
	private String adjustableRatio;//�ɵ���
	private String flowCharacteristic;//��������
	private String Kmax;//������Kmax
	private String Knor;
	private String Kmin;//������Kmin
	private String nominalPressure;//����ѹ��
	private String noiseLevel;//��������
	private String closeOpen;//����/����
	
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
