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

import com.daCheng.lectotype.data.LimitSwitchMapper;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class LimitSwitchService {
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
	
	public void addLimitSwitch(LimitSwitch limitSwitch){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			mapper.insert(limitSwitch);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteLimitSwitch(String id){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchLimitSwitch(String model){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchLimitSwitch(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			LimitSwitch existingLimitSwitch = mapper.findByModel(model);
			
			if(existingLimitSwitch == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingLimitSwitch.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public LimitSwitch getLimitSwitch(String id){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<LimitSwitch> getLimitSwitchs(){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findLimitSwitchs(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateLimitSwitch(LimitSwitch limitSwitch){
		SqlSession session = openSession(null,null);
		try{
			LimitSwitchMapper mapper = session.getMapper(LimitSwitchMapper.class);
			
			mapper.update(limitSwitch);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		LimitSwitchService service = new LimitSwitchService();
		
		LimitSwitch limitSwitch = new LimitSwitch("id44",
				"model34",
				"jointModel34",
				"connectionSize34",
				"explosionProof34");
		
//		service.addLimitSwitch(limitSwitch);
//		service.updateLimitSwitch(limitSwitch);
		service.deleteLimitSwitch("id44");
		
//		System.out.println(service.hasSuchLimitSwitch("model4"));
		
//		LimitSwitch limitSwitch2 = service.getLimitSwitch("id");
		for(LimitSwitch limitSwitch2:service.getLimitSwitchs())
			System.out.println(
					limitSwitch2.getId() + "," +
					limitSwitch2.getModel() + "," +
					limitSwitch2.getJointModel() + "," +
					limitSwitch2.getConnectionSize() + "," +
					limitSwitch2.getExplosionProof());
		
	}
	
}
