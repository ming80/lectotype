package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.User;
import com.daCheng.lectotype.service.FluidService;
import com.daCheng.lectotype.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserMaintenanceAction extends ActionSupport{
	private String id;
	private String name;
	private String password;
	private String repeatPassword;
	private String role;
	
	public String deleteUser(){
		UserService service = new UserService();
		service.delete(this.id);
		
		return Action.SUCCESS;
	}
	
	private int getRole(String role){
		if("admin".equals(this.role))
			return User.ROLE_ADMIN;
		if("technician".equals(this.role))
			return User.ROLE_TECHNICIAN;
		return User.ROLE_SALESMAN;
	}
	
	public String addUser(){
		UserService service = new UserService();		
		
		User user = new User(this.id,
				this.name.trim().replace(" ", ""),
				this.password,
				getRole(this.role));
		
		service.add(user);
		
		return Action.SUCCESS;
	}
	
	public void validateAddUser(){
		//5个不能为空
		//员工编号只能是数字、字母、下划线
		//此员工编号已存在
		//密码只能是数字、字母、下划线
		//密码只能是数字、字母、下划线(重复)
		//两次输入的密码不一致
		
		UserService service = new UserService();		
		
		if(isEmptyString(this.id))
			this.addFieldError("id","员工编号不能为空!");
		else if(!this.id.trim().matches("^\\w{6,20}$"))
			this.addFieldError("id","员工编号只能是数字、字母、下划线,长度为6-20位!");
		else if(service.getUser(this.id) != null)
			this.addFieldError("id", "此员工编号已存在!");
			
		if(isEmptyString(this.name))
			addFieldError("name","姓名不能为空!");
			
		if(isEmptyString(this.password))
			addFieldError("password","密码不能为空!");		
		else if(!this.password.trim().matches("^\\w{6,20}$"))
			this.addFieldError("password","密码只能是数字、字母、下划线,长度为6-20位!");

		if(isEmptyString(this.repeatPassword))
			addFieldError("repeatPassword","请重复一下您的密码!");
		else if(!this.repeatPassword.trim().matches("^\\w{6,20}$"))
			this.addFieldError("repeatPassword","密码只能是数字、字母、下划线,长度为6-20位!");
		else if(!this.password.equals(this.repeatPassword))
			this.addFieldError("repeatPassword","两次输入的密码不一致!");
		
		if(!isIllegalRole())
			this.addFieldError("role","请选择角色权限!");
	}
	
	public String updateUser(){
		UserService service = new UserService();
		
		User user = new User(this.id,
				this.name.trim().replace(" ", ""),
				this.password,
				getRole(this.role));
		
		service.update(user);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateUser(){
		//5个不能为空
		//员工编号只能是数字、字母、下划线
		//密码只能是数字、字母、下划线
		//密码只能是数字、字母、下划线(重复)
		//两次输入的密码不一致		
			
		if(isEmptyString(this.name))
			addFieldError("name","姓名不能为空!");
			
		if(isEmptyString(this.password))
			addFieldError("password","密码不能为空!");
		else if(!this.password.trim().matches("^\\w{6,20}$"))
			this.addFieldError("password","密码只能是数字、字母、下划线,长度为6-20位!");

		if(isEmptyString(this.repeatPassword))
			addFieldError("repeatPassword","请重复一下您的密码!");
		else if(!this.repeatPassword.trim().matches("^\\w{6,20}$"))
			this.addFieldError("repeatPassword","密码只能是数字、字母、下划线,长度为6-20位!");
		else if(!this.password.equals(this.repeatPassword))
			this.addFieldError("repeatPassword","两次输入的密码不一致!");		
		
		if(!isIllegalRole())
			this.addFieldError("role","请选择角色权限!");
	}

	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}

	private boolean isIllegalRole(){
		if(isEmptyString(this.role))
			return false;
		if("admin".equals(this.role))
			return true;
		if("technician".equals(this.role))
			return true;
		if("salesman".equals(this.role))
			return true;
		return false;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
