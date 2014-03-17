package com.daCheng.lectotype.service;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import com.daCheng.lectotype.data.SolenoidMapper;
import com.daCheng.lectotype.domain.Solenoid;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class SolenoidService {
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
	
	public void addSolenoid(Solenoid solenoid){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			mapper.insert(solenoid);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteSolenoid(String id){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchSolenoid(String model){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchSolenoid(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			Solenoid existingSolenoid = mapper.findByModel(model);
			
			if(existingSolenoid == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingSolenoid.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public Solenoid getSolenoid(String id){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<Solenoid> getSolenoids(){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findSolenoids(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateSolenoid(Solenoid solenoid){
		SqlSession session = openSession(null,null);
		try{
			SolenoidMapper mapper = session.getMapper(SolenoidMapper.class);
			
			mapper.update(solenoid);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		SolenoidService service = new SolenoidService();
		
//		Solenoid solenoid = new Solenoid("id4",
//				"model5",
//		 		"supplyPower5",
//		 		"powerConnection5",
//		 		"airConnection5",
//		 		"explosionProof5");
		
//		service.addSolenoid(solenoid);
//		service.updateSolenoid(solenoid);
		service.deleteSolenoid("id4");
		
//		System.out.println(service.hasSuchSolenoid("id1","model2"));
		
//		Solenoid solenoid = service.getSolenoid("id2");
		for(Solenoid solenoid1:service.getSolenoids())
			System.out.println(
					solenoid1.getId() + "," +
					solenoid1.getModel() + "," +
					solenoid1.getSupplyPower() + "," +
					solenoid1.getPowerConnection() + "," +
					solenoid1.getAirConnection() + "," +
					solenoid1.getExplosionProof());
		
	}
	
}
