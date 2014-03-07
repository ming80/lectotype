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

import com.daCheng.lectotype.data.FluidMapper;
import com.daCheng.lectotype.data.SelectedModelMapper;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.SelectedModel;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class SelectedModelService {
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
	
	public void addSelectedModel(SelectedModel selectedModel){
		SqlSession session = openSession(null,null);
		try{
//			ValveSpecificationMapper mapper2 = session.getMapper(ValveSpecificationMapper.class);
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			mapper.insert(selectedModel);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteSelectedModel(String id){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchSelectedModel(String name){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			return mapper.countByName(name) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchSelectedModel(String id,String name){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			if(mapper.countByName(name) > 1)
				throw new IllegalStateException("数据异常,调节阀名称:" + name);
			
			SelectedModel existingSelectedModel = mapper.findByName(name);
			
			if(existingSelectedModel == null)
				return false;
			
			//id不同,则说明已存在其他的同名记录
			return !id.equals(existingSelectedModel.getId());
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public SelectedModel getSelectedModel(String id){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			return mapper.find(id);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<SelectedModel> getSelectedModels(){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findSelectedModels(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateSelectedModel(SelectedModel selectedModel){
		SqlSession session = openSession(null,null);
		try{
			SelectedModelMapper mapper = session.getMapper(SelectedModelMapper.class);
			
			mapper.update(selectedModel);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		SelectedModelService service = new SelectedModelService();		
//		service.deleteSelectedModel("id3");
//		SelectedModel selectedModel1 = new SelectedModel(
//				"id3",
//				"name23",
//				"model23",
//				"diameterNominal23",
//				"seatDiameter23",
//				"nominalPressure23",
//				"flowOpenClose23",
//				"airFail23",
//				"flowCharacter23",
//				"bodyMaterial23",
//				"seatMaterial23",
//				"plugMaterial23",
//				"packing23",
//				"bonnetType23",
//				"connectionFlange23",
//				"leakageClass23");
		
//		service.addSelectedModel(selectedModel1);
//		service.updateSelectedModel(selectedModel1);
//		System.out.print(service.hasSuchSelectedModel("id4","name1"));
		
		SelectedModel selectedModel = service.getSelectedModel("81db93b4-70b0-4e95-9ea5-f939351101a7");
		SelectedModel selectedModel2 = new SelectedModel(selectedModel.getId(),
				"33",
				"33",
				selectedModel.getDiameterNominal(),
				selectedModel.getSeatDiameter(),
				selectedModel.getNominalPressure(),
				selectedModel.getFlowOpenClose(),
				selectedModel.getAirFail(),
				selectedModel.getFlowCharacter(),
				selectedModel.getBodyMaterial(),
				selectedModel.getSeatMaterial(),
				selectedModel.getPlugMaterial(),
				selectedModel.getPacking(),
				selectedModel.getBonnetType(),
				selectedModel.getConnectionFlange(),
				selectedModel.getLeakageClass());
		service.updateSelectedModel(selectedModel2);
//		for(SelectedModel selectedModel:service.getSelectedModels())			
			System.out.println(
				selectedModel.getId() + "," +
				selectedModel.getName() + "," +
				selectedModel.getModel() + "," +
				selectedModel.getDiameterNominal() + "," +
				selectedModel.getSeatDiameter() + "," +
				selectedModel.getNominalPressure() + "," +
				selectedModel.getFlowOpenClose() + "," +
				selectedModel.getAirFail() + "," +
				selectedModel.getFlowCharacter() + "," +
				selectedModel.getBodyMaterial() + "," +
				selectedModel.getSeatMaterial() + "," +
				selectedModel.getPlugMaterial() + "," +
				selectedModel.getPacking() + "," +
				selectedModel.getBonnetType() + "," +
				selectedModel.getConnectionFlange() + "," +
				selectedModel.getLeakageClass());
		
	}
	
}
