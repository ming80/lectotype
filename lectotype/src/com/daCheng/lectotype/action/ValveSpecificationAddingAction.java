package com.daCheng.lectotype.action;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.daCheng.lectotype.data.ValveSpecificationMapper;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.service.ValveSpecificationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ValveSpecificationAddingAction extends ActionSupport{
	private ValveSpecification valveSpecification;
	private boolean isSeccessful;
	private String msg;
	
	public String execute(){
		ValveSpecificationService service = new ValveSpecificationService();
		String id = "" + new Date().getTime();
		
		if(service.hasSuchValveSpecification(id)){
			this.isSeccessful = false;
			this.msg = "此选型表已存在,id:" + id;	
			return Action.ERROR;
		}
		
		valveSpecification.setId(id);
				
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader("com/daCheng/lectotype/data/Configuration.xml");
//			
//			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//			SqlSession session = builder.build(reader).openSession();
//			
//			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
//			mapper.insert(valveSpecification);
//			session.commit();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		service.addValveSpecification(valveSpecification);
		this.isSeccessful = true;
		return Action.SUCCESS;
			
	}
	
	public void setValveSpecification(ValveSpecification valveSpecification){
		this.valveSpecification = valveSpecification;
	}

	public ValveSpecification getValveSpecification() {
		return valveSpecification;
	}
}
