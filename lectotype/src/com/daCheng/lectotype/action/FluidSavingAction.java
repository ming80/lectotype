package com.daCheng.lectotype.action;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.daCheng.lectotype.data.ValveSpecificationMapper;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.service.FluidService;
import com.daCheng.lectotype.service.ValveSpecificationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FluidSavingAction extends ActionSupport{
	private String name;
	private String state;
	private String density;
	private String sg;
	
	private boolean isSeccessful;
	
	public String execute(){
		FluidService service = new FluidService();
		
		Fluid fluid = new Fluid(UUID.randomUUID().toString(),
				this.name,
				this.state,
				this.density,
				this.sg);
		
		if(service.hasSuchFluidName(this.name.trim().replace(" ", "")))
			//service.updateFluid(fluid);
		service.addFluid(fluid);
		
		return Action.SUCCESS;			
	}
	
	public void validate(){
		//4个不能为空
		//此介质已存在
		//状态只能是'气体'或'水蒸汽'
		//密度必须是大于0的数字
		//比重必须是大于0的数字
		FluidService service = new FluidService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","用户名不能为空!");
		else if(service.hasSuchFluidName(this.name.trim().replace(" ", "")))
			this.addFieldError("name", "此介质已存在!");
			
		if(isEmptyString(this.state))
			addFieldError("state","介质状态不能为空!");
		else if(isLegalState())
			addFieldError("state","状态只能是'气体'或'水蒸汽'!");
			
		if(isEmptyString(this.density))
			addFieldError("density","密度不能为空!");
		if(this.density.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("density","密度必须是大于0的数字!");
			
		if(isEmptyString(this.sg))
			addFieldError("sg","比重不能为空!");
		if(this.sg.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("sg","比重必须是大于0的数字!");
		
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

	public boolean isSeccessful() {
		return isSeccessful;
	}

	public void setSeccessful(boolean isSeccessful) {
		this.isSeccessful = isSeccessful;
	}
	
	private boolean isLegalState(){
		if(this.state.trim().equals("气体"))
			return true;
		if(this.state.trim().equals("水蒸汽"))
			return true;
		return false;	
	}
	
	private boolean isEmptyString(String str){
		if(str == null) return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}
	
}
