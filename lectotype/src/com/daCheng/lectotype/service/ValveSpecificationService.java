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
		valveSpecification.setId("1");
		valveSpecification.setProjectName("22");
		valveSpecification.setTagNo("33");
		valveSpecification.setQuantity("44");
		valveSpecification.setService("55");
		valveSpecification.setRemarks("66");
		
		ProcessParameter processPara = new ProcessParameter();
		processPara.setPipeSizeAndMaterial("77");
		processPara.setFluidState("88");
		processPara.setFluidName("99");
		processPara.setDensity("1010");
		processPara.setFlowUnit("1111");
		processPara.setQmax("1212");
		processPara.setQnor("1313");
		processPara.setQmin("1414");
		processPara.setOperationTemperature("1515");
		processPara.setPressureUnit("1616");
		processPara.setUpstreamPressure("1717");
		processPara.setDownstreamPressure("1818");
		processPara.setDifferentialPressure("1919");
		processPara.setDynamicViscosity("2020");
		processPara.setCompressFactor("2121");
		processPara.setVaporPressure("2222");
		processPara.setCriticalPressure("2323");
		
		Calculation calculation = new Calculation();
		calculation.setKvmax("2424");
		calculation.setKvmin("2525");
		calculation.setSelectedKv("2626");
		calculation.setAdjustableRatio("2727");
		calculation.setFlowCharacteristic("2828");
		calculation.setKmax("2929");
		calculation.setKmin("3030");
		calculation.setNominalPressure("3131");
		calculation.setNoiseLevel("3232");
		calculation.setCloseOpen("3333");
		
		SelectedModel selectedModel = new SelectedModel();
		selectedModel.setName("3434");
		selectedModel.setModel("3535");
		selectedModel.setDiameterNominal("3636");
		selectedModel.setSeatDiameter("3737");
		selectedModel.setNominalPressure("3838");
		selectedModel.setFlowOpenClose("3939");
		selectedModel.setAirFail("4040");
		selectedModel.setFlowCharacter("4141");
		selectedModel.setBodyMaterial("4242");
		selectedModel.setSeatMaterial("4343");
		selectedModel.setPlugMaterial("4444");
		selectedModel.setPacking("4545");
		selectedModel.setBonnetType("4646");
		selectedModel.setConnectionFlange("4747");
		selectedModel.setLeakageClass("4848");

		Actuator actuator = new Actuator();
		actuator.setModel("4949");
		actuator.setAction("5050");
		actuator.setSpringRange("5151");
		actuator.setAirPressure("5252");
		actuator.setAirConnection("5353");

		Accessory accessory = new Accessory();
		Positioner positioner = new Positioner();
		positioner.setModel("5454");
		positioner.setInputSignal("5555");
		positioner.setAirPressure("5656");
		positioner.setSignalConnection("5757");
		positioner.setAirConnectionSize("5858");
		positioner.setExplosionProof("5959");
		
		Solenoid solenoid = new Solenoid();
		solenoid.setModel("6060");
		solenoid.setSupplyPower("6161");
		solenoid.setPowerConnection("6262");
		solenoid.setAirConnection("6363");
		solenoid.setExplosionProof("6464");

		LimitSwitch limitSwitch = new LimitSwitch();
		limitSwitch.setModel("6565");
		limitSwitch.setJointModel("6666");
		limitSwitch.setConnectionSize("6767");
		limitSwitch.setExplosionProof("6868");

		Conveyer conveyer = new Conveyer();
		conveyer.setModel("6969");
		conveyer.setOutputSignal("7070");
		conveyer.setConnectionSize("7171");
		conveyer.setExplosionProof("7272");
		
		FilterReducingValve filterReducingValve = new FilterReducingValve();
		filterReducingValve.setModel("7373");
		filterReducingValve.setConnection("7474");		
		
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
		
//		mapper.insert(valveSpecification);
//		mapper.delete("11");
//		ValveSpecification spec = mapper.find("1");
//		System.out.print(mapper.count("1"));
//		mapper.update(valveSpecification);
//		session.commit();
//		session.close();
		
		ValveSpecificationService service = new ValveSpecificationService();
//		service.addValveSpecification(valveSpecification);
//		service.updateValveSpecification(valveSpecification);
//		ValveSpecification aaa = service.getValveSpecification("1");
		
		
		System.out.print(service.getValveSpecifications("%ro%",null,null).size());
		return;
	}
	
}
