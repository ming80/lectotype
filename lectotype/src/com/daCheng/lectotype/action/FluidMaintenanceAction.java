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
		//4������Ϊ��
		//�˽����Ѵ���
		//״ֻ̬����'����'��'ˮ����'
		//�ܶȱ����Ǵ���0������
		//���ر����Ǵ���0������
		FluidService service = new FluidService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","�������Ʋ���Ϊ��!");
		else if(service.hasSuchFluid(this.name.trim().replace(" ", "")))
			this.addFieldError("name", "�˽����Ѵ���!");
			
		if(isEmptyString(this.state))
			addFieldError("state","����״̬����Ϊ��!");
		else if(!isLegalState())
			addFieldError("state","״ֻ̬����'����'��'Һ��'!");
			
		if(isEmptyString(this.density))
			addFieldError("density","�ܶȲ���Ϊ��!");
		else if(!this.density.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("density","�ܶȱ����Ǵ���0������!");
			
		if(isEmptyString(this.sg))
			addFieldError("sg","���ز���Ϊ��!");
		else if(!this.sg.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("sg","���ر����Ǵ���0������!");				
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
		//4������Ϊ��
		//�˽����Ѵ���
		//״ֻ̬����'����'��'ˮ����'
		//�ܶȱ����Ǵ���0������
		//���ر����Ǵ���0������
		FluidService service = new FluidService();		
		
		if(isEmptyString(this.name))
			this.addFieldError("name","�������Ʋ���Ϊ��!");
		else if(service.hasSuchFluid(this.id,this.name.trim().replace(" ", "")))
			this.addFieldError("name", "����Ϊ'" + this.name.trim().replace(" ", "") + "'�Ľ����Ѵ���!");
			
		if(isEmptyString(this.state))
			addFieldError("state","����״̬����Ϊ��!");
		else if(!isLegalState())
			addFieldError("state","״ֻ̬����'����'��'Һ��'!");
			
		if(isEmptyString(this.density))
			addFieldError("density","�ܶȲ���Ϊ��!");
		else if(!this.density.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("density","�ܶȱ����Ǵ���0������!");
			
		if(isEmptyString(this.sg))
			addFieldError("sg","���ز���Ϊ��!");
		else if(!this.sg.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"))
			addFieldError("sg","���ر����Ǵ���0������!");				
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
