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

import com.daCheng.lectotype.data.ValveSpecificationMapper;
import com.daCheng.lectotype.domain.Accessory;
import com.daCheng.lectotype.domain.Actuator;
import com.daCheng.lectotype.domain.Calculation;
import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.domain.Positioner;
import com.daCheng.lectotype.domain.ProcessParameter;
import com.daCheng.lectotype.domain.SelectedModel;
import com.daCheng.lectotype.domain.Solenoid;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.exception.ValveSpecificationServiceException;


public class ValveSpecificationService {
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
	
	public void addValveSpecification(ValveSpecification valveSpecification){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			mapper.insert(valveSpecification);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public void deleteValveSpecification(String id){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}	
	}
	
	public boolean hasSuchValveSpecification(String id){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			return mapper.count(id) > 0;
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public ValveSpecification getValveSpecification(String id){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			return mapper.find(id);

		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public List<ValveSpecification> getValveSpecifications(String projectName,String selectedModelName,String model){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
			conditions.put("projectName", projectName);
			conditions.put("selectedModelName", selectedModelName);
			conditions.put("model", model);
			
			return mapper.findValveSpecifications(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void updateValveSpecification(ValveSpecification valveSpecification){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			mapper.update(valveSpecification);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public static void main(String[] args){
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSession session = builder.build(reader).openSession();
		
		ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
		
		ValveSpecification valveSpecification = new ValveSpecification();
		valveSpecification.setId("aaaaaaaaaaaaaaaaaaaaaaaa" + new Date().getTime());
		valveSpecification.setProjectName("");
		valveSpecification.setTagNo("");
		valveSpecification.setQuantity("");
		valveSpecification.setService("");
		valveSpecification.setRemarks("");
		
		ProcessParameter processPara = new ProcessParameter();
		processPara.setPipeSizeAndMaterial("");
		processPara.setFluidState("");
		processPara.setFluidName("");
		processPara.setDensity("");
		processPara.setFlowUnit("");
		processPara.setQmax("");
		processPara.setQnor("");
		processPara.setQmin("");
		processPara.setOperationTemperature("");
		processPara.setPressureUnit("KPa");
		processPara.setUpstreamPressure("");
		processPara.setDownstreamPressure("");
		processPara.setDifferentialPressure("");
		processPara.setDynamicViscosity("");
		processPara.setCompressFactor("");
		processPara.setVaporPressure("");
		processPara.setCriticalPressure("");
		
		Calculation calculation = new Calculation();
		calculation.setKvmax("");
		calculation.setKvmin("");
		calculation.setSelectedKv("");
		calculation.setAdjustableRatio("");
		calculation.setFlowCharacteristic("");
		calculation.setKmax("");
		calculation.setKmin("");
		calculation.setNominalPressure("");
		calculation.setNoiseLevel("");
		calculation.setCloseOpen("");
		
		SelectedModel selectedModel = new SelectedModel();
		selectedModel.setName("");
		selectedModel.setModel("");
		selectedModel.setDiameterNominal("");
		selectedModel.setSeatDiameter("");
		selectedModel.setNominalPressure("");
		selectedModel.setFlowOpenClose("");
		selectedModel.setAirFail("");
		selectedModel.setFlowCharacter("");
		selectedModel.setBodyMaterial("");
		selectedModel.setSeatMaterial("");
		selectedModel.setPlugMaterial("");
		selectedModel.setPacking("");
		selectedModel.setBonnetType("");
		selectedModel.setConnectionFlange("");
		selectedModel.setLeakageClass("");

		Actuator actuator = new Actuator();
		actuator.setModel("");
		actuator.setAction("");
		actuator.setSpringRange("");
		actuator.setAirPressure("");
		actuator.setAirConnection("");

		Accessory accessory = new Accessory();
		Positioner positioner = new Positioner();
		positioner.setModel("");
		positioner.setInputSignal("");
		positioner.setAirPressure("");
		positioner.setSignalConnection("");
		positioner.setAirConnectionSize("");
		positioner.setExplosionProof("");
		
		Solenoid solenoid = new Solenoid();
		solenoid.setModel("");
		solenoid.setSupplyPower("");
		solenoid.setPowerConnection("");
		solenoid.setAirConnection("");
		solenoid.setExplosionProof("");

		LimitSwitch limitSwitch = new LimitSwitch();
		limitSwitch.setModel("");
		limitSwitch.setJointModel("");
		limitSwitch.setConnectionSize("");
		limitSwitch.setExplosionProof("");

		Conveyer conveyer = new Conveyer();
		conveyer.setModel("");
		conveyer.setOutputSignal("");
		conveyer.setConnectionSize("");
		conveyer.setExplosionProof("");
		
		FilterReducingValve filterReducingValve = new FilterReducingValve();
		filterReducingValve.setModel("");
		filterReducingValve.setConnection("");		
		
		accessory.setPositioner(positioner);
		accessory.setSolenoid(solenoid);
		accessory.setLimitSwitch(limitSwitch);
		accessory.setConveyer(conveyer);
		accessory.setFilterReducingValve(filterReducingValve);
		accessory.setHandWheel(true);		
		
		valveSpecification.setProcessPara(processPara);
		valveSpecification.setCalculation(calculation);
		valveSpecification.setSelectedModel(selectedModel);
		valveSpecification.setActuator(actuator);
		valveSpecification.setAccessory(accessory);
		
		mapper.insert(valveSpecification);
//		mapper.delete("11");
//		ValveSpecification spec = mapper.find("1");
//		System.out.print(mapper.count("1"));
//		mapper.update(valveSpecification);
		session.commit();
//		session.close();
		
//		ValveSpecificationService service = new ValveSpecificationService();
//		service.addValveSpecification(valveSpecification);
//		service.updateValveSpecification(valveSpecification);
//		ValveSpecification aaa = service.getValveSpecification("1");
		
		
//		System.out.print(service.getValveSpecifications("%ro%",null,null).size());
		return;
	}
	
}
