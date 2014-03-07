package com.daCheng.lectotype.action;

import java.util.UUID;

import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.service.FluidService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FluidMaintenanceAction extends ActionSupport{
	private String id;
	private String name;
	private String state;
	private String density;
	private String sg;
	
	public String deleteFluid(){
		FluidService service = new FluidService();
		service.deleteFluid(this.id);
		
		return Action.SUCCESS;
	}
	
	public String addFluid(){
		FluidService service = new FluidService();
		
		Fluid fluid = new Fluid(UUID.randomUUID().toString(),
				this.name.trim().replace(" ", ""),
				this.state,
				this.density,
				this.sg);
		
		service.addFluid(fluid);
		
		return Action.SUCCESS;
	}
	
	public void validateAddFluid(){
		//4个不能为空
		//此介质已存在
		//状态只能是'气体'或'水蒸汽'
		//密度必须是大于0的数字
		//比重必须是大于0的数字
		FluidService service = new FluidService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","介质名称不能为空!");
		else if(service.hasSuchFluid(this.name.trim().replace(" ", "")))
			this.addFieldError("name", "此介质已存在!");
			
		if(isEmptyString(this.state))
			addFieldError("state","介质状态不能为空!");
		else if(!isLegalState())
			addFieldError("state","状态只能是'气体'或'液体'!");
			
		if(isEmptyString(this.density))
			addFieldError("density","密度不能为空!");
		else if(!this.density.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("density","密度必须是大于0的数字!");
			
		if(isEmptyString(this.sg))
			addFieldError("sg","比重不能为空!");
		else if(!this.sg.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("sg","比重必须是大于0的数字!");				
	}
	
	public String updateFluid(){
		FluidService service = new FluidService();
		
		Fluid fluid = new Fluid(this.id,
				this.name.trim().replace(" ", ""),
				this.state,
				this.density,
				this.sg);
		
		service.updateFluid(fluid);
		
		return Action.SUCCESS;
	}
	
	public void validateUpdateFluid(){
		//4个不能为空
		//此介质已存在
		//状态只能是'气体'或'水蒸汽'
		//密度必须是大于0的数字
		//比重必须是大于0的数字
		FluidService service = new FluidService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","介质名称不能为空!");
		else if(service.hasSuchFluid(this.id,this.name.trim().replace(" ", "")))
			this.addFieldError("name", "名称为'" + this.name.trim().replace(" ", "") + "'的介质已存在!");
			
		if(isEmptyString(this.state))
			addFieldError("state","介质状态不能为空!");
		else if(!isLegalState())
			addFieldError("state","状态只能是'气体'或'液体'!");
			
		if(isEmptyString(this.density))
			addFieldError("density","密度不能为空!");
		else if(!this.density.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("density","密度必须是大于0的数字!");
			
		if(isEmptyString(this.sg))
			addFieldError("sg","比重不能为空!");
		else if(!this.sg.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("sg","比重必须是大于0的数字!");				
	}
	
	public void setId(String id){
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

	private boolean isLegalState(){
		if(this.state.trim().equals("gas"))
			return true;
		if(this.state.trim().equals("liquid"))
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
