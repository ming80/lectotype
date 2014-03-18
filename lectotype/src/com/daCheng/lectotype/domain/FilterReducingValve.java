package com.daCheng.lectotype.domain;

public class FilterReducingValve {
	private String id;
	private String model;//ÐÍºÅ Model	
	private String connection;//½Ó¿Ú Conn.
	
	private FilterReducingValve(){		
	}
	
	public FilterReducingValve(String id,String model,String connection){
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is empty!");
//		if(model == null || model.trim().equals(""))
//			throw new IllegalArgumentException("model is empty!");
		
		this.id = id;
		this.model = model;
		this.connection = connection;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getConnection() {
		return connection;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

}
