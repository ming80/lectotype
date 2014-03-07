package com.daCheng.lectotype.service;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import com.daCheng.lectotype.data.ActuatorMapper;
import com.daCheng.lectotype.data.FluidMapper;
import com.daCheng.lectotype.data.ValveSpecificationMapper;
import com.daCheng.lectotype.domain.Accessory;
import com.daCheng.lectotype.domain.Actuator;
import com.daCheng.lectotype.domain.Calculation;
import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.domain.Positioner;
import com.daCheng.lectotype.domain.ProcessParameter;
import com.daCheng.lectotype.domain.SelectedModel;
import com.daCheng.lectotype.domain.Solenoid;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class ActuatorService {
	private final static String RESOURCE = "com/daCheng/lectotype/data/Configuration.xml";
	
	private SqlSession openSession(ExecutorType type,TransactionIsolationLevel level){
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException e) {
			throw new ValveSpecificationServiceException("open session failed!",e);
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		if(type != null && level == null)
			return builder.build(reader).openSession(type);
		
		if(type == null && level != null)
			return builder.build(reader).openSession(level);
		
		if(type != null && level != null)
			return builder.build(reader).openSession(type,level);
		
		return builder.build(reader).openSession();
	}	
	
	public void addActuator(Actuator actuator){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			mapper.insert(actuator);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteActuator(String id){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchActuator(String model){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchActuator(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			Actuator existingActuator = mapper.findByModel(model);
			
			if(existingActuator == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingActuator.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public Actuator getActuator(String id){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<Actuator> getActuators(){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findActuators(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateActuator(Actuator actuator){
		SqlSession session = openSession(null,null);
		try{
			ActuatorMapper mapper = session.getMapper(ActuatorMapper.class);
			
			mapper.update(actuator);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		ActuatorService service = new ActuatorService();
		
//		Actuator actuator = new Actuator("id3","model4","action4",
//				"springRange4","airPressure4","airConnection4");
		
//		service.addActuator(actuator);
//		service.updateActuator(actuator);
//		service.deleteActuator("id3");
		
//		System.out.println(service.hasSuchActuator("id","model1"));
		
//		Actuator actuator = service.getActuator("id2");
//		for(Actuator actuator:service.getActuators())
//			System.out.println(
//					actuator.getId() + "," +
//					actuator.getModel() + "," +
//					actuator.getAction() + "," +
//					actuator.getSpringRange() + "," +
//					actuator.getAirPressure() + "," +
//					actuator.getAirConnection());
		
	}
	
}
