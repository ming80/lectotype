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


public class FluidService {
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
	
	public void addFluid(Fluid fluid){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			mapper.insert(fluid);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteFluid(String id){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchFluid(String id){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			return mapper.count(id) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchFluidName(String name){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			return mapper.countByName(name) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public Fluid getFluid(String id){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<Fluid> getFluids(){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findFluids(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateFluid(Fluid fluid){
		SqlSession session = openSession(null,null);
		try{
			FluidMapper mapper = session.getMapper(FluidMapper.class);
			
			mapper.update(fluid);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		FluidService service = new FluidService();		
		
//		Fluid fluid = new Fluid("id1","name11","state11","111","211");
//		Fluid fluid2 = new Fluid("id2","name2","state2","3","4");
//		Fluid fluid3 = new Fluid("id3","name3","state3","5","6");
//		service.deleteFluid("id1");
		
//		Fluid fluid = service.getFluid("id2");
		
		System.out.println(service.hasSuchFluid("id1"));
		
		for(Fluid fluid:service.getFluids())
			System.out.println(fluid.getId() + "," +
					fluid.getName() + "," +
					fluid.getState() + "," +
					fluid.getDensity() + "," +
					fluid.getSg());
		
		
		return;
	}
	
}
