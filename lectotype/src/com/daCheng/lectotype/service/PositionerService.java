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
import com.daCheng.lectotype.data.PositionerMapper;
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


public class PositionerService {
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
	
	public void addPositioner(Positioner positioner){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			mapper.insert(positioner);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deletePositioner(String id){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchPositioner(String model){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchPositioner(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			Positioner existingPositioner = mapper.findByModel(model);
			
			if(existingPositioner == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingPositioner.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public Positioner getPositioner(String id){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<Positioner> getPositioners(){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findPositioners(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updatePositioner(Positioner positioner){
		SqlSession session = openSession(null,null);
		try{
			PositionerMapper mapper = session.getMapper(PositionerMapper.class);
			
			mapper.update(positioner);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		PositionerService service = new PositionerService();
		
//		Positioner positioner2 = new Positioner("id9",
//				"model5",
//				"inputSignal5",
//				"airPressure5",
//				"signalConnection5",
//				"airConnectionSize5",
//				"explosionProof5");
		
//		service.addPositioner(positioner);
//		service.updatePositioner(positioner2);
//		service.deletePositioner("id9");
		
//		System.out.println(service.hasSuchPositioner("id","model2"));
		
//		Positioner positioner = service.getPositioner("id2");
//		for(Positioner positioner:service.getPositioners())
//			System.out.println(
//					positioner.getId() + "," +
//					positioner.getModel() + "," +
//					positioner.getInputSignal() + "," +
//					positioner.getAirPressure() + "," +
//					positioner.getSignalConnection() + "," +
//					positioner.getAirConnectionSize() + "," +
//					positioner.getExplosionProof());
		
	}
	
}
