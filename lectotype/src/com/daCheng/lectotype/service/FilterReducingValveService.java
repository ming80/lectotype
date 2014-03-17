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
import com.daCheng.lectotype.data.FilterReducingValveMapper;
import com.daCheng.lectotype.data.LimitSwitchMapper;
import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class FilterReducingValveService {
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
	
	public void addFilterReducingValve(FilterReducingValve filterReducingValve){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			mapper.insert(filterReducingValve);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteFilterReducingValve(String id){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchFilterReducingValve(String model){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			return mapper.countByModel(model) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchFilterReducingValve(String id,String model){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			if(mapper.countByModel(model) > 1)
				throw new IllegalStateException("数据异常,型号名称:" + model);
			
			FilterReducingValve existingFilterReducingValve = mapper.findByModel(model);
			
			if(existingFilterReducingValve == null)
				return false;
			
			//id不同,则说明已存在其他的同名介质
			return !id.equals(existingFilterReducingValve.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public FilterReducingValve getFilterReducingValve(String id){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<FilterReducingValve> getFilterReducingValves(){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findFilterReducingValves(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateFilterReducingValve(FilterReducingValve filterReducingValve){
		SqlSession session = openSession(null,null);
		try{
			FilterReducingValveMapper mapper = session.getMapper(FilterReducingValveMapper.class);
			
			mapper.update(filterReducingValve);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		//7个方法
		FilterReducingValveService service = new FilterReducingValveService();
		
//		FilterReducingValve filterReducingValve = new FilterReducingValve("id45",
//				"model44",
//				"connection44");
		
//		service.addFilterReducingValve(filterReducingValve);
//		service.updateFilterReducingValve(filterReducingValve);
		service.deleteFilterReducingValve("id45");
		
//		System.out.println(service.hasSuchFilterReducingValve("model462"));
		
//		FilterReducingValve filterReducingValve2 = service.getFilterReducingValve("id45");
		for(FilterReducingValve filterReducingValve2:service.getFilterReducingValves())
			System.out.println(
					filterReducingValve2.getId() + "," +
					filterReducingValve2.getModel() + "," +
					filterReducingValve2.getConnection());
		
	}
	
}
