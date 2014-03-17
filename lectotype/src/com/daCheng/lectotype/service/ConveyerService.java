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

import com.daCheng.lectotype.data.ConveyerMapper;
import com.daCheng.lectotype.data.LimitSwitchMapper;
import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class ConveyerService {
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
	
	public void addConveyer(Conveyer conveyer){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			mapper.insert(conveyer);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteConveyer(String id){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchConveyer(String model){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchConveyer(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			Conveyer existingConveyer = mapper.findByModel(model);
			
			if(existingConveyer == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingConveyer.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public Conveyer getConveyer(String id){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<Conveyer> getConveyers(){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findConveyers(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateConveyer(Conveyer conveyer){
		SqlSession session = openSession(null,null);
		try{
			ConveyerMapper mapper = session.getMapper(ConveyerMapper.class);
			
			mapper.update(conveyer);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		ConveyerService service = new ConveyerService();
		
		Conveyer conveyer = new Conveyer("id34",
				"model4",
				"outputSignal4",
				"connectionSize4",
				"explosionProof4");
		
//		service.addConveyer(conveyer);
//		service.updateConveyer(conveyer);
//		service.deleteConveyer("id34");
		
//		System.out.println(service.hasSuchConveyer("id3","model1"));
		
//		LimitSwitch limitSwitch2 = service.getLimitSwitch("id");
		for(Conveyer conveyer2:service.getConveyers())
			System.out.println(
					conveyer2.getId() + "," +
					conveyer2.getModel() + "," +
					conveyer2.getOutputSignal() + "," +
					conveyer2.getConnectionSize() + "," +
					conveyer2.getExplosionProof());
		
	}
	
}
