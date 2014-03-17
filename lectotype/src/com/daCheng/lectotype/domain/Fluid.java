package com.daCheng.lectotype.domain;

public class Fluid {
	private String id;
	private String name;	//介质名称
	private String state;	//介质状态
	private String density;	//密度
	private String sg;	//比重
	
	private Fluid(){}
	
	public Fluid(String id,
				String name,
				String state,
				String density, 
				String sg){
		
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
		if(name == null || name.trim().equals(""))
			throw new IllegalArgumentException("name is empty!");
		if(state == null || state.trim().equals(""))
			throw new IllegalArgumentException("state is empty!");
		
		this.id = id;
		this.name = name;
		this.state = state;
		this.density = density;
		this.sg = sg;		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return state;
	}
	
	public String getDensity() {
		return density;
	}
	
	public String getSg() {
		return sg;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDensity(String density) {
		this.density = density;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}
}
