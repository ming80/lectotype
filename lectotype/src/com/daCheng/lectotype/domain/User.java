package com.daCheng.lectotype.domain;

public class User {
	private String id;
	private String name;
	private String password;
	private int role;
	
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_TECHNICIAN = 2;
	public static final int ROLE_SALESMAN = 3;
	
	private User(){		
	}
	
	public User(String id,String name,String password,int role){
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is null!");
		if(name == null || name.trim().equals(""))
			throw new IllegalArgumentException("name is null!");
		if(password == null || password.trim().equals(""))
			throw new IllegalArgumentException("password is null!");
		if(role <1 || role > 3)
			throw new IllegalArgumentException("role error!");
		
		this.id = id;
		this.name = name;
		this.password = password;		
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getRole() {
		return role;
	}
}
