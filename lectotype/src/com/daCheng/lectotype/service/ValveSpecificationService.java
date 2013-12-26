package com.daCheng.lectotype.service;

import java.io.IOException;
import java.io.Reader;

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
	
	public int addValveSpecification(ValveSpecification valveSpecification){
		SqlSession session = openSession(null,null);
		try{
			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
			
			if(mapper.count(valveSpecification.getId()) > 0)
				return 0;
			
			mapper.insert(valveSpecification);
			session.commit();
			return 1;
		}
		finally{
			if(session != null) session.close();
		}
		
	}
	
	public int deleteValveSpecification(String id){
		
	}
	
	public valveSpecification getValveSpecification(String id){
		
	}
	
	public int updateValveSpecification(ValveSpecification valveSpecification){
		
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
		valveSpecification.setId("11");
		valveSpecification.setProjectName("2");
		valveSpecification.setTagNo("3");
		valveSpecification.setQuantity("4");
		valveSpecification.setService("5");
		valveSpecification.setRemarks("6");
		
		ProcessParameter processPara = new ProcessParameter();
		processPara.setPipeSizeAndMaterial("7");
		processPara.setFluidState("8");
		processPara.setFluidName("9");
		processPara.setDensity("10");
		processPara.setFlowUnit("11");
		processPara.setQmax("12");
		processPara.setQnor("13");
		processPara.setQmin("14");
		processPara.setOperationTemperature("15");
		processPara.setPressureUnit("16");
		processPara.setUpstreamPressure("17");
		processPara.setDownstreamPressure("18");
		processPara.setDifferentialPressure("19");
		processPara.setDynamicViscosity("20");
		processPara.setCompressFactor("21");
		processPara.setVaporPressure("22");
		processPara.setCriticalPressure("23");
		
		Calculation calculation = new Calculation();
		calculation.setKvmax("24");
		calculation.setKvmin("25");
		calculation.setSelectedKv("26");
		calculation.setAdjustableRatio("27");
		calculation.setFlowCharacteristic("28");
		calculation.setKmax("29");
		calculation.setKmin("30");
		calculation.setNominalPressure("31");
		calculation.setNoiseLevel("32");
		calculation.setCloseOpen("33");
		
		SelectedModel selectedModel = new SelectedModel();
		selectedModel.setName("34");
		selectedModel.setModel("35");
		selectedModel.setDiameterNominal("36");
		selectedModel.setSeatDiameter("37");
		selectedModel.setNominalPressure("38");
		selectedModel.setFlowOpenClose("39");
		selectedModel.setAirFail("40");
		selectedModel.setFlowCharacter("41");
		selectedModel.setBodyMaterial("42");
		selectedModel.setSeatMaterial("43");
		selectedModel.setPlugMaterial("44");
		selectedModel.setPacking("45");
		selectedModel.setBonnetType("46");
		selectedModel.setConnectionFlange("47");
		selectedModel.setLeakageClass("48");

		Actuator actuator = new Actuator();
		actuator.setModel("49");
		actuator.setAction("50");
		actuator.setSpringRange("51");
		actuator.setAirPressure("52");
		actuator.setAirConnection("53");

		Accessory accessory = new Accessory();
		Positioner positioner = new Positioner();
		positioner.setModel("54");
		positioner.setInputSignal("55");
		positioner.setAirPressure("56");
		positioner.setSignalConnection("57");
		positioner.setAirConnectionSize("58");
		positioner.setExplosionProof("59");
		
		Solenoid solenoid = new Solenoid();
		solenoid.setModel("60");
		solenoid.setSupplyPower("61");
		solenoid.setPowerConnection("62");
		solenoid.setAirConnection("63");
		solenoid.setExplosionProof("64");

		LimitSwitch limitSwitch = new LimitSwitch();
		limitSwitch.setModel("65");
		limitSwitch.setJointModel("66");
		limitSwitch.setConnectionSize("67");
		limitSwitch.setExplosionProof("68");

		Conveyer conveyer = new Conveyer();
		conveyer.setModel("69");
		conveyer.setOutputSignal("70");
		conveyer.setConnectionSize("71");
		conveyer.setExplosionProof("72");
		
		FilterReducingValve filterReducingValve = new FilterReducingValve();
		filterReducingValve.setModel("73");
		filterReducingValve.setConnection("74");		
		
		accessory.setPositioner(positioner);
		accessory.setSolenoid(solenoid);
		accessory.setLimitSwitch(limitSwitch);
		accessory.setConveyer(conveyer);
		accessory.setFilterReducingValve(filterReducingValve);
		accessory.setHandWheel(false);		
		
		valveSpecification.setProcessPara(processPara);
		valveSpecification.setCalculation(calculation);
		valveSpecification.setSelectedModel(selectedModel);
		valveSpecification.setActuator(actuator);
		valveSpecification.setAccessory(accessory);
		
//		mapper.insert(valveSpecification);
//		mapper.delete("11");
		ValveSpecification spec = mapper.find("1");
		session.commit();
		session.close();
	}
	
}
