package com.daCheng.lectotype.domain;

public class Accessory {
	private Positioner positioner;
	private Solenoid solenoid;
	private LimitSwitch limitSwitch;
	private Conveyer conveyer;
	private FilterReducingValve filterReducingValve;	
	private boolean handWheel;
	
	public Positioner getPositioner() {
		return positioner;
	}
	
	public void setPositioner(Positioner positioner) {
		this.positioner = positioner;
	}
	
	public Solenoid getSolenoid() {
		return solenoid;
	}
	
	public void setSolenoid(Solenoid solenoid) {
		this.solenoid = solenoid;
	}
	
	public LimitSwitch getLimitSwitch() {
		return limitSwitch;
	}
	
	public void setLimitSwitch(LimitSwitch limitSwitch) {
		this.limitSwitch = limitSwitch;
	}
	
	public Conveyer getConveyer() {
		return conveyer;
	}
	
	public void setConveyer(Conveyer conveyer) {
		this.conveyer = conveyer;
	}
	
	public FilterReducingValve getFilterReducingValve() {
		return filterReducingValve;
	}
	
	public void setFilterReducingValve(FilterReducingValve filterReducingValve) {
		this.filterReducingValve = filterReducingValve;
	}
	
	public boolean isHandWheel() {
		return handWheel;
	}
	
	public void setHandWheel(boolean handWheel) {
		this.handWheel = handWheel;
	}
}
