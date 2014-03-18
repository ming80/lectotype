package com.daCheng.lectotype.action;

import java.util.UUID;

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
import com.daCheng.lectotype.service.ValveSpecificationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ValveSpecificationAddingAction extends ActionSupport{
//	private ValveSpecification valveSpecification;
	private String valveSpecification_projectName;
	private String valveSpecification_quantity;
	private String valveSpecification_tagNo;
	private String valveSpecification_service;
	private String valveSpecification_remarks;
	private String valveSpecification_processPara_pipeSizeAndMaterial;		                                                                                     
	private String valveSpecification_processPara_pressureUnit;
	private String valveSpecification_processPara_fluidName;
	private String valveSpecification_processPara_upstreamPressure;
	private String valveSpecification_processPara_fluidState;
	private String valveSpecification_processPara_flowUnit;		
	private String valveSpecification_processPara_downstreamPressure;
	private String valveSpecification_processPara_density;
	private String valveSpecification_processPara_differentialPressure;
	private String valveSpecification_processPara_Qmax;
	private String valveSpecification_processPara_dynamicViscosity;
	private String valveSpecification_processPara_Qnor;
	private String valveSpecification_processPara_compressFactor;
	private String valveSpecification_processPara_Qmin;
	private String valveSpecification_processPara_vaporPressure;
	private String valveSpecification_processPara_operationTemperature;
	private String valveSpecification_processPara_criticalPressure;
	private String valveSpecification_calculation_Kvmax;
	private String valveSpecification_calculation_Kvmin;
	private String valveSpecification_calculation_selectedKv;
	private String valveSpecification_calculation_Kmax;
	private String valveSpecification_calculation_flowCharacteristic;
	private String valveSpecification_calculation_adjustableRatio;
	private String valveSpecification_calculation_Kmin;
	private String valveSpecification_calculation_nominalPressure;
	private String valveSpecification_calculation_noiseLevel;
	private String valveSpecification_calculation_closeOpen;
	private String valveSpecification_selectedModel_name;
	private String valveSpecification_selectedModel_bodyMaterial;
	private String valveSpecification_selectedModel_model;
	private String valveSpecification_selectedModel_seatMaterial;
	private String valveSpecification_selectedModel_diameterNominal;
	private String valveSpecification_selectedModel_plugMaterial;
	private String valveSpecification_selectedModel_seatDiameter;
	private String valveSpecification_selectedModel_packing;
	private String valveSpecification_selectedModel_nominalPressure;
	private String valveSpecification_selectedModel_bonnetType;
	private String valveSpecification_selectedModel_flowOpenClose;
	private String valveSpecification_selectedModel_connectionFlange;
	private String valveSpecification_selectedModel_airFail;
	private String valveSpecification_selectedModel_leakageClass;
	private String valveSpecification_selectedModel_flowCharacter;
	private String valveSpecification_actuator_model;
	private String valveSpecification_actuator_action;
	private String valveSpecification_actuator_springRange;
	private String valveSpecification_actuator_airPressure;
	private String valveSpecification_actuator_airConnection;
	private String valveSpecification_accessory_positioner_model;
	private String valveSpecification_accessory_positioner_signalConnection;
	private String valveSpecification_accessory_positioner_inputSignal;
	private String valveSpecification_accessory_positioner_airConnectionSize;
	private String valveSpecification_accessory_positioner_airPressure;
	private String valveSpecification_accessory_positioner_explosionProof;
	private String valveSpecification_accessory_solenoid_model;
	private String valveSpecification_accessory_solenoid_airConnection;
	private String valveSpecification_accessory_solenoid_supplyPower;
	private String valveSpecification_accessory_solenoid_explosionProof;
	private String valveSpecification_accessory_solenoid_powerConnection;
	private String valveSpecification_accessory_limitSwitch_model;
	private String valveSpecification_accessory_limitSwitch_connectionSize;
	private String valveSpecification_accessory_limitSwitch_jointModel;
	private String valveSpecification_accessory_limitSwitch_explosionProof;
	private String valveSpecification_accessory_conveyer_model;
	private String valveSpecification_accessory_conveyer_connectionSize;				   
	private String valveSpecification_accessory_conveyer_outputSignal;
	private String valveSpecification_accessory_conveyer_explosionProof;
	private String valveSpecification_accessory_filterReducingValve_model;
	private String valveSpecification_accessory_filterReducingValve_connection;
	private String valveSpecification_accessory_handWheel;
	
	private boolean isSeccessful;
	private String msg;
	
	public String execute(){
		ValveSpecificationService service = new ValveSpecificationService();
		String id = "" + UUID.randomUUID();
		
		if(service.hasSuchValveSpecification(id)){
			this.isSeccessful = false;
			this.msg = "此选型表已存在,id:" + id;	
			return Action.ERROR;
		}
		
		ValveSpecification valveSpecification = new ValveSpecification();
		
		valveSpecification.setId(id);
		valveSpecification.setProjectName(valveSpecification_projectName);
		valveSpecification.setQuantity(valveSpecification_quantity);
		valveSpecification.setTagNo(valveSpecification_tagNo);
		valveSpecification.setService(valveSpecification_service);
		valveSpecification.setRemarks(valveSpecification_remarks);
		
		//工艺参数
		ProcessParameter processPara = new ProcessParameter();	
		processPara.setPipeSizeAndMaterial(valveSpecification_processPara_pipeSizeAndMaterial);
		processPara.setPressureUnit(valveSpecification_processPara_pressureUnit);
		processPara.setFluidName(valveSpecification_processPara_fluidName);
		processPara.setUpstreamPressure(valveSpecification_processPara_upstreamPressure);
		processPara.setFluidState(valveSpecification_processPara_fluidState);
		processPara.setFlowUnit(valveSpecification_processPara_flowUnit);
		processPara.setDownstreamPressure(valveSpecification_processPara_downstreamPressure);
		processPara.setDensity(valveSpecification_processPara_density);
		processPara.setDifferentialPressure(valveSpecification_processPara_differentialPressure);
		processPara.setQmax(valveSpecification_processPara_Qmax);
		processPara.setDynamicViscosity(valveSpecification_processPara_dynamicViscosity);
		processPara.setQnor(valveSpecification_processPara_Qnor);
		processPara.setCompressFactor(valveSpecification_processPara_compressFactor);
		processPara.setQmin(valveSpecification_processPara_Qmin);
		processPara.setVaporPressure(valveSpecification_processPara_vaporPressure);
		processPara.setOperationTemperature(valveSpecification_processPara_operationTemperature);
		processPara.setCriticalPressure(valveSpecification_processPara_criticalPressure);
		valveSpecification.setProcessPara(processPara);
		
		//计算
		Calculation calculation = new Calculation();	
		calculation.setKvmax(valveSpecification_calculation_Kvmax);
		calculation.setKvmin(valveSpecification_calculation_Kvmin);
		calculation.setSelectedKv(valveSpecification_calculation_selectedKv);
		calculation.setKmax(valveSpecification_calculation_Kmax);
		calculation.setFlowCharacteristic(valveSpecification_calculation_flowCharacteristic);
		calculation.setAdjustableRatio(valveSpecification_calculation_adjustableRatio);
		calculation.setKmin(valveSpecification_calculation_Kmin);
		calculation.setNominalPressure(valveSpecification_calculation_nominalPressure);
		calculation.setNoiseLevel(valveSpecification_calculation_noiseLevel);
		calculation.setCloseOpen(valveSpecification_calculation_closeOpen);
		valveSpecification.setCalculation(calculation);
		
		//调节阀选型
		valveSpecification.setSelectedModel(
			new SelectedModel(
				id,
				valveSpecification_selectedModel_name,
				valveSpecification_selectedModel_model,
				valveSpecification_selectedModel_diameterNominal,
				valveSpecification_selectedModel_seatDiameter,
				valveSpecification_selectedModel_nominalPressure,
				valveSpecification_selectedModel_flowOpenClose,
				valveSpecification_selectedModel_airFail,
				valveSpecification_selectedModel_flowCharacter,
				valveSpecification_selectedModel_bodyMaterial,
				valveSpecification_selectedModel_seatMaterial,
				valveSpecification_selectedModel_plugMaterial,
				valveSpecification_selectedModel_packing,
				valveSpecification_selectedModel_bonnetType,
				valveSpecification_selectedModel_connectionFlange,
				valveSpecification_selectedModel_leakageClass));
		
		//执行机构
		valveSpecification.setActuator(
			new Actuator(id,
				valveSpecification_actuator_model,
				valveSpecification_actuator_action,
				valveSpecification_actuator_springRange,
				valveSpecification_actuator_airPressure,
				valveSpecification_actuator_airConnection));	
		
		//附件
		Accessory accessory = new Accessory();
		accessory.setPositioner(
			new Positioner(id,
				valveSpecification_accessory_positioner_model,	//型号
				valveSpecification_accessory_positioner_inputSignal,	//输入信号
				valveSpecification_accessory_positioner_airPressure,	//供气压力
				valveSpecification_accessory_positioner_signalConnection,	//信号接口
				valveSpecification_accessory_positioner_airConnectionSize,	//气接口尺寸
				valveSpecification_accessory_positioner_explosionProof));
		accessory.setSolenoid(
			new	Solenoid(id,
				valveSpecification_accessory_solenoid_model,	//型号 Model	
				valveSpecification_accessory_solenoid_supplyPower,	//电源电压 Supply Power.v	
				valveSpecification_accessory_solenoid_powerConnection,	//电源接口 Power Conn.	
				valveSpecification_accessory_solenoid_airConnection,	//气接口尺寸 Air Conn.	
				valveSpecification_accessory_solenoid_explosionProof));
		accessory.setLimitSwitch(
			new LimitSwitch(id,
				valveSpecification_accessory_limitSwitch_model,	//型号 Model	
				valveSpecification_accessory_limitSwitch_jointModel,	//接点型式  Joint Model	
				valveSpecification_accessory_limitSwitch_connectionSize,	//接口尺寸  Conn. Size	
				valveSpecification_accessory_limitSwitch_explosionProof));
		accessory.setConveyer(
			new Conveyer(id,
				valveSpecification_accessory_conveyer_model,	//型号 Model	
				valveSpecification_accessory_conveyer_outputSignal,	//输出信号 Output Sig.mA	
				valveSpecification_accessory_conveyer_connectionSize,	//接口尺寸  Conn. Size	
				valveSpecification_accessory_conveyer_explosionProof));
		accessory.setFilterReducingValve(
			new FilterReducingValve(id,
				valveSpecification_accessory_filterReducingValve_model,
				valveSpecification_accessory_filterReducingValve_connection));
		if(valveSpecification_accessory_handWheel != null && valveSpecification_accessory_handWheel.equals("带"))
			accessory.setHandWheel(true);
		valveSpecification.setAccessory(accessory);
		
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader("com/daCheng/lectotype/data/Configuration.xml");
//			
//			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//			SqlSession session = builder.build(reader).openSession();
//			
//			ValveSpecificationMapper mapper = session.getMapper(ValveSpecificationMapper.class);
//			mapper.insert(valveSpecification);
//			session.commit();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		service.addValveSpecification(valveSpecification);
		this.isSeccessful = true;
		return Action.SUCCESS;
			
	}

	public String getValveSpecification_projectName() {
		return valveSpecification_projectName;
	}

	public void setValveSpecification_projectName(
			String valveSpecification_projectName) {
		this.valveSpecification_projectName = valveSpecification_projectName;
	}

	public String getValveSpecification_quantity() {
		return valveSpecification_quantity;
	}

	public void setValveSpecification_quantity(String valveSpecification_quantity) {
		this.valveSpecification_quantity = valveSpecification_quantity;
	}

	public String getValveSpecification_tagNo() {
		return valveSpecification_tagNo;
	}

	public void setValveSpecification_tagNo(String valveSpecification_tagNo) {
		this.valveSpecification_tagNo = valveSpecification_tagNo;
	}

	public String getValveSpecification_service() {
		return valveSpecification_service;
	}

	public void setValveSpecification_service(String valveSpecification_service) {
		this.valveSpecification_service = valveSpecification_service;
	}

	public String getValveSpecification_remarks() {
		return valveSpecification_remarks;
	}

	public void setValveSpecification_remarks(String valveSpecification_remarks) {
		this.valveSpecification_remarks = valveSpecification_remarks;
	}

	public String getValveSpecification_processPara_pipeSizeAndMaterial() {
		return valveSpecification_processPara_pipeSizeAndMaterial;
	}

	public void setValveSpecification_processPara_pipeSizeAndMaterial(
			String valveSpecification_processPara_pipeSizeAndMaterial) {
		this.valveSpecification_processPara_pipeSizeAndMaterial = valveSpecification_processPara_pipeSizeAndMaterial;
	}

	public String getValveSpecification_processPara_pressureUnit() {
		return valveSpecification_processPara_pressureUnit;
	}

	public void setValveSpecification_processPara_pressureUnit(
			String valveSpecification_processPara_pressureUnit) {
		this.valveSpecification_processPara_pressureUnit = valveSpecification_processPara_pressureUnit;
	}

	public String getValveSpecification_processPara_fluidName() {
		return valveSpecification_processPara_fluidName;
	}

	public void setValveSpecification_processPara_fluidName(
			String valveSpecification_processPara_fluidName) {
		this.valveSpecification_processPara_fluidName = valveSpecification_processPara_fluidName;
	}

	public String getValveSpecification_processPara_upstreamPressure() {
		return valveSpecification_processPara_upstreamPressure;
	}

	public void setValveSpecification_processPara_upstreamPressure(
			String valveSpecification_processPara_upstreamPressure) {
		this.valveSpecification_processPara_upstreamPressure = valveSpecification_processPara_upstreamPressure;
	}

	public String getValveSpecification_processPara_fluidState() {
		return valveSpecification_processPara_fluidState;
	}

	public void setValveSpecification_processPara_fluidState(
			String valveSpecification_processPara_fluidState) {
		this.valveSpecification_processPara_fluidState = valveSpecification_processPara_fluidState;
	}

	public String getValveSpecification_processPara_flowUnit() {
		return valveSpecification_processPara_flowUnit;
	}

	public void setValveSpecification_processPara_flowUnit(
			String valveSpecification_processPara_flowUnit) {
		this.valveSpecification_processPara_flowUnit = valveSpecification_processPara_flowUnit;
	}

	public String getValveSpecification_processPara_downstreamPressure() {
		return valveSpecification_processPara_downstreamPressure;
	}

	public void setValveSpecification_processPara_downstreamPressure(
			String valveSpecification_processPara_downstreamPressure) {
		this.valveSpecification_processPara_downstreamPressure = valveSpecification_processPara_downstreamPressure;
	}

	public String getValveSpecification_processPara_density() {
		return valveSpecification_processPara_density;
	}

	public void setValveSpecification_processPara_density(
			String valveSpecification_processPara_density) {
		this.valveSpecification_processPara_density = valveSpecification_processPara_density;
	}

	public String getValveSpecification_processPara_differentialPressure() {
		return valveSpecification_processPara_differentialPressure;
	}

	public void setValveSpecification_processPara_differentialPressure(
			String valveSpecification_processPara_differentialPressure) {
		this.valveSpecification_processPara_differentialPressure = valveSpecification_processPara_differentialPressure;
	}

	public String getValveSpecification_processPara_Qmax() {
		return valveSpecification_processPara_Qmax;
	}

	public void setValveSpecification_processPara_Qmax(
			String valveSpecification_processPara_Qmax) {
		this.valveSpecification_processPara_Qmax = valveSpecification_processPara_Qmax;
	}

	public String getValveSpecification_processPara_dynamicViscosity() {
		return valveSpecification_processPara_dynamicViscosity;
	}

	public void setValveSpecification_processPara_dynamicViscosity(
			String valveSpecification_processPara_dynamicViscosity) {
		this.valveSpecification_processPara_dynamicViscosity = valveSpecification_processPara_dynamicViscosity;
	}

	public String getValveSpecification_processPara_Qnor() {
		return valveSpecification_processPara_Qnor;
	}

	public void setValveSpecification_processPara_Qnor(
			String valveSpecification_processPara_Qnor) {
		this.valveSpecification_processPara_Qnor = valveSpecification_processPara_Qnor;
	}

	public String getValveSpecification_processPara_compressFactor() {
		return valveSpecification_processPara_compressFactor;
	}

	public void setValveSpecification_processPara_compressFactor(
			String valveSpecification_processPara_compressFactor) {
		this.valveSpecification_processPara_compressFactor = valveSpecification_processPara_compressFactor;
	}

	public String getValveSpecification_processPara_Qmin() {
		return valveSpecification_processPara_Qmin;
	}

	public void setValveSpecification_processPara_Qmin(
			String valveSpecification_processPara_Qmin) {
		this.valveSpecification_processPara_Qmin = valveSpecification_processPara_Qmin;
	}

	public String getValveSpecification_processPara_vaporPressure() {
		return valveSpecification_processPara_vaporPressure;
	}

	public void setValveSpecification_processPara_vaporPressure(
			String valveSpecification_processPara_vaporPressure) {
		this.valveSpecification_processPara_vaporPressure = valveSpecification_processPara_vaporPressure;
	}

	public String getValveSpecification_processPara_operationTemperature() {
		return valveSpecification_processPara_operationTemperature;
	}

	public void setValveSpecification_processPara_operationTemperature(
			String valveSpecification_processPara_operationTemperature) {
		this.valveSpecification_processPara_operationTemperature = valveSpecification_processPara_operationTemperature;
	}

	public String getValveSpecification_processPara_criticalPressure() {
		return valveSpecification_processPara_criticalPressure;
	}

	public void setValveSpecification_processPara_criticalPressure(
			String valveSpecification_processPara_criticalPressure) {
		this.valveSpecification_processPara_criticalPressure = valveSpecification_processPara_criticalPressure;
	}

	public String getValveSpecification_calculation_Kvmax() {
		return valveSpecification_calculation_Kvmax;
	}

	public void setValveSpecification_calculation_Kvmax(
			String valveSpecification_calculation_Kvmax) {
		this.valveSpecification_calculation_Kvmax = valveSpecification_calculation_Kvmax;
	}

	public String getValveSpecification_calculation_Kvmin() {
		return valveSpecification_calculation_Kvmin;
	}

	public void setValveSpecification_calculation_Kvmin(
			String valveSpecification_calculation_Kvmin) {
		this.valveSpecification_calculation_Kvmin = valveSpecification_calculation_Kvmin;
	}

	public String getValveSpecification_calculation_selectedKv() {
		return valveSpecification_calculation_selectedKv;
	}

	public void setValveSpecification_calculation_selectedKv(
			String valveSpecification_calculation_selectedKv) {
		this.valveSpecification_calculation_selectedKv = valveSpecification_calculation_selectedKv;
	}

	public String getValveSpecification_calculation_Kmax() {
		return valveSpecification_calculation_Kmax;
	}

	public void setValveSpecification_calculation_Kmax(
			String valveSpecification_calculation_Kmax) {
		this.valveSpecification_calculation_Kmax = valveSpecification_calculation_Kmax;
	}

	public String getValveSpecification_calculation_flowCharacteristic() {
		return valveSpecification_calculation_flowCharacteristic;
	}

	public void setValveSpecification_calculation_flowCharacteristic(
			String valveSpecification_calculation_flowCharacteristic) {
		this.valveSpecification_calculation_flowCharacteristic = valveSpecification_calculation_flowCharacteristic;
	}

	public String getValveSpecification_calculation_adjustableRatio() {
		return valveSpecification_calculation_adjustableRatio;
	}

	public void setValveSpecification_calculation_adjustableRatio(
			String valveSpecification_calculation_adjustableRatio) {
		this.valveSpecification_calculation_adjustableRatio = valveSpecification_calculation_adjustableRatio;
	}

	public String getValveSpecification_calculation_Kmin() {
		return valveSpecification_calculation_Kmin;
	}

	public void setValveSpecification_calculation_Kmin(
			String valveSpecification_calculation_Kmin) {
		this.valveSpecification_calculation_Kmin = valveSpecification_calculation_Kmin;
	}

	public String getValveSpecification_calculation_nominalPressure() {
		return valveSpecification_calculation_nominalPressure;
	}

	public void setValveSpecification_calculation_nominalPressure(
			String valveSpecification_calculation_nominalPressure) {
		this.valveSpecification_calculation_nominalPressure = valveSpecification_calculation_nominalPressure;
	}

	public String getValveSpecification_calculation_noiseLevel() {
		return valveSpecification_calculation_noiseLevel;
	}

	public void setValveSpecification_calculation_noiseLevel(
			String valveSpecification_calculation_noiseLevel) {
		this.valveSpecification_calculation_noiseLevel = valveSpecification_calculation_noiseLevel;
	}

	public String getValveSpecification_calculation_closeOpen() {
		return valveSpecification_calculation_closeOpen;
	}

	public void setValveSpecification_calculation_closeOpen(
			String valveSpecification_calculation_closeOpen) {
		this.valveSpecification_calculation_closeOpen = valveSpecification_calculation_closeOpen;
	}

	public String getValveSpecification_selectedModel_name() {
		return valveSpecification_selectedModel_name;
	}

	public void setValveSpecification_selectedModel_name(
			String valveSpecification_selectedModel_name) {
		this.valveSpecification_selectedModel_name = valveSpecification_selectedModel_name;
	}

	public String getValveSpecification_selectedModel_bodyMaterial() {
		return valveSpecification_selectedModel_bodyMaterial;
	}

	public void setValveSpecification_selectedModel_bodyMaterial(
			String valveSpecification_selectedModel_bodyMaterial) {
		this.valveSpecification_selectedModel_bodyMaterial = valveSpecification_selectedModel_bodyMaterial;
	}

	public String getValveSpecification_selectedModel_model() {
		return valveSpecification_selectedModel_model;
	}

	public void setValveSpecification_selectedModel_model(
			String valveSpecification_selectedModel_model) {
		this.valveSpecification_selectedModel_model = valveSpecification_selectedModel_model;
	}

	public String getValveSpecification_selectedModel_seatMaterial() {
		return valveSpecification_selectedModel_seatMaterial;
	}

	public void setValveSpecification_selectedModel_seatMaterial(
			String valveSpecification_selectedModel_seatMaterial) {
		this.valveSpecification_selectedModel_seatMaterial = valveSpecification_selectedModel_seatMaterial;
	}

	public String getValveSpecification_selectedModel_diameterNominal() {
		return valveSpecification_selectedModel_diameterNominal;
	}

	public void setValveSpecification_selectedModel_diameterNominal(
			String valveSpecification_selectedModel_diameterNominal) {
		this.valveSpecification_selectedModel_diameterNominal = valveSpecification_selectedModel_diameterNominal;
	}

	public String getValveSpecification_selectedModel_plugMaterial() {
		return valveSpecification_selectedModel_plugMaterial;
	}

	public void setValveSpecification_selectedModel_plugMaterial(
			String valveSpecification_selectedModel_plugMaterial) {
		this.valveSpecification_selectedModel_plugMaterial = valveSpecification_selectedModel_plugMaterial;
	}

	public String getValveSpecification_selectedModel_seatDiameter() {
		return valveSpecification_selectedModel_seatDiameter;
	}

	public void setValveSpecification_selectedModel_seatDiameter(
			String valveSpecification_selectedModel_seatDiameter) {
		this.valveSpecification_selectedModel_seatDiameter = valveSpecification_selectedModel_seatDiameter;
	}

	public String getValveSpecification_selectedModel_packing() {
		return valveSpecification_selectedModel_packing;
	}

	public void setValveSpecification_selectedModel_packing(
			String valveSpecification_selectedModel_packing) {
		this.valveSpecification_selectedModel_packing = valveSpecification_selectedModel_packing;
	}

	public String getValveSpecification_selectedModel_nominalPressure() {
		return valveSpecification_selectedModel_nominalPressure;
	}

	public void setValveSpecification_selectedModel_nominalPressure(
			String valveSpecification_selectedModel_nominalPressure) {
		this.valveSpecification_selectedModel_nominalPressure = valveSpecification_selectedModel_nominalPressure;
	}

	public String getValveSpecification_selectedModel_bonnetType() {
		return valveSpecification_selectedModel_bonnetType;
	}

	public void setValveSpecification_selectedModel_bonnetType(
			String valveSpecification_selectedModel_bonnetType) {
		this.valveSpecification_selectedModel_bonnetType = valveSpecification_selectedModel_bonnetType;
	}

	public String getValveSpecification_selectedModel_flowOpenClose() {
		return valveSpecification_selectedModel_flowOpenClose;
	}

	public void setValveSpecification_selectedModel_flowOpenClose(
			String valveSpecification_selectedModel_flowOpenClose) {
		this.valveSpecification_selectedModel_flowOpenClose = valveSpecification_selectedModel_flowOpenClose;
	}

	public String getValveSpecification_selectedModel_connectionFlange() {
		return valveSpecification_selectedModel_connectionFlange;
	}

	public void setValveSpecification_selectedModel_connectionFlange(
			String valveSpecification_selectedModel_connectionFlange) {
		this.valveSpecification_selectedModel_connectionFlange = valveSpecification_selectedModel_connectionFlange;
	}

	public String getValveSpecification_selectedModel_airFail() {
		return valveSpecification_selectedModel_airFail;
	}

	public void setValveSpecification_selectedModel_airFail(
			String valveSpecification_selectedModel_airFail) {
		this.valveSpecification_selectedModel_airFail = valveSpecification_selectedModel_airFail;
	}

	public String getValveSpecification_selectedModel_leakageClass() {
		return valveSpecification_selectedModel_leakageClass;
	}

	public void setValveSpecification_selectedModel_leakageClass(
			String valveSpecification_selectedModel_leakageClass) {
		this.valveSpecification_selectedModel_leakageClass = valveSpecification_selectedModel_leakageClass;
	}

	public String getValveSpecification_selectedModel_flowCharacter() {
		return valveSpecification_selectedModel_flowCharacter;
	}

	public void setValveSpecification_selectedModel_flowCharacter(
			String valveSpecification_selectedModel_flowCharacter) {
		this.valveSpecification_selectedModel_flowCharacter = valveSpecification_selectedModel_flowCharacter;
	}

	public String getValveSpecification_actuator_model() {
		return valveSpecification_actuator_model;
	}

	public void setValveSpecification_actuator_model(
			String valveSpecification_actuator_model) {
		this.valveSpecification_actuator_model = valveSpecification_actuator_model;
	}

	public String getValveSpecification_actuator_action() {
		return valveSpecification_actuator_action;
	}

	public void setValveSpecification_actuator_action(
			String valveSpecification_actuator_action) {
		this.valveSpecification_actuator_action = valveSpecification_actuator_action;
	}

	public String getValveSpecification_actuator_springRange() {
		return valveSpecification_actuator_springRange;
	}

	public void setValveSpecification_actuator_springRange(
			String valveSpecification_actuator_springRange) {
		this.valveSpecification_actuator_springRange = valveSpecification_actuator_springRange;
	}

	public String getValveSpecification_actuator_airPressure() {
		return valveSpecification_actuator_airPressure;
	}

	public void setValveSpecification_actuator_airPressure(
			String valveSpecification_actuator_airPressure) {
		this.valveSpecification_actuator_airPressure = valveSpecification_actuator_airPressure;
	}

	public String getValveSpecification_actuator_airConnection() {
		return valveSpecification_actuator_airConnection;
	}

	public void setValveSpecification_actuator_airConnection(
			String valveSpecification_actuator_airConnection) {
		this.valveSpecification_actuator_airConnection = valveSpecification_actuator_airConnection;
	}

	public String getValveSpecification_accessory_positioner_model() {
		return valveSpecification_accessory_positioner_model;
	}

	public void setValveSpecification_accessory_positioner_model(
			String valveSpecification_accessory_positioner_model) {
		this.valveSpecification_accessory_positioner_model = valveSpecification_accessory_positioner_model;
	}

	public String getValveSpecification_accessory_positioner_signalConnection() {
		return valveSpecification_accessory_positioner_signalConnection;
	}

	public void setValveSpecification_accessory_positioner_signalConnection(
			String valveSpecification_accessory_positioner_signalConnection) {
		this.valveSpecification_accessory_positioner_signalConnection = valveSpecification_accessory_positioner_signalConnection;
	}

	public String getValveSpecification_accessory_positioner_inputSignal() {
		return valveSpecification_accessory_positioner_inputSignal;
	}

	public void setValveSpecification_accessory_positioner_inputSignal(
			String valveSpecification_accessory_positioner_inputSignal) {
		this.valveSpecification_accessory_positioner_inputSignal = valveSpecification_accessory_positioner_inputSignal;
	}

	public String getValveSpecification_accessory_positioner_airConnectionSize() {
		return valveSpecification_accessory_positioner_airConnectionSize;
	}

	public void setValveSpecification_accessory_positioner_airConnectionSize(
			String valveSpecification_accessory_positioner_airConnectionSize) {
		this.valveSpecification_accessory_positioner_airConnectionSize = valveSpecification_accessory_positioner_airConnectionSize;
	}

	public String getValveSpecification_accessory_positioner_airPressure() {
		return valveSpecification_accessory_positioner_airPressure;
	}

	public void setValveSpecification_accessory_positioner_airPressure(
			String valveSpecification_accessory_positioner_airPressure) {
		this.valveSpecification_accessory_positioner_airPressure = valveSpecification_accessory_positioner_airPressure;
	}

	public String getValveSpecification_accessory_positioner_explosionProof() {
		return valveSpecification_accessory_positioner_explosionProof;
	}

	public void setValveSpecification_accessory_positioner_explosionProof(
			String valveSpecification_accessory_positioner_explosionProof) {
		this.valveSpecification_accessory_positioner_explosionProof = valveSpecification_accessory_positioner_explosionProof;
	}

	public String getValveSpecification_accessory_solenoid_model() {
		return valveSpecification_accessory_solenoid_model;
	}

	public void setValveSpecification_accessory_solenoid_model(
			String valveSpecification_accessory_solenoid_model) {
		this.valveSpecification_accessory_solenoid_model = valveSpecification_accessory_solenoid_model;
	}

	public String getValveSpecification_accessory_solenoid_airConnection() {
		return valveSpecification_accessory_solenoid_airConnection;
	}

	public void setValveSpecification_accessory_solenoid_airConnection(
			String valveSpecification_accessory_solenoid_airConnection) {
		this.valveSpecification_accessory_solenoid_airConnection = valveSpecification_accessory_solenoid_airConnection;
	}

	public String getValveSpecification_accessory_solenoid_supplyPower() {
		return valveSpecification_accessory_solenoid_supplyPower;
	}

	public void setValveSpecification_accessory_solenoid_supplyPower(
			String valveSpecification_accessory_solenoid_supplyPower) {
		this.valveSpecification_accessory_solenoid_supplyPower = valveSpecification_accessory_solenoid_supplyPower;
	}

	public String getValveSpecification_accessory_solenoid_explosionProof() {
		return valveSpecification_accessory_solenoid_explosionProof;
	}

	public void setValveSpecification_accessory_solenoid_explosionProof(
			String valveSpecification_accessory_solenoid_explosionProof) {
		this.valveSpecification_accessory_solenoid_explosionProof = valveSpecification_accessory_solenoid_explosionProof;
	}

	public String getValveSpecification_accessory_solenoid_powerConnection() {
		return valveSpecification_accessory_solenoid_powerConnection;
	}

	public void setValveSpecification_accessory_solenoid_powerConnection(
			String valveSpecification_accessory_solenoid_powerConnection) {
		this.valveSpecification_accessory_solenoid_powerConnection = valveSpecification_accessory_solenoid_powerConnection;
	}

	public String getValveSpecification_accessory_limitSwitch_model() {
		return valveSpecification_accessory_limitSwitch_model;
	}

	public void setValveSpecification_accessory_limitSwitch_model(
			String valveSpecification_accessory_limitSwitch_model) {
		this.valveSpecification_accessory_limitSwitch_model = valveSpecification_accessory_limitSwitch_model;
	}

	public String getValveSpecification_accessory_limitSwitch_connectionSize() {
		return valveSpecification_accessory_limitSwitch_connectionSize;
	}

	public void setValveSpecification_accessory_limitSwitch_connectionSize(
			String valveSpecification_accessory_limitSwitch_connectionSize) {
		this.valveSpecification_accessory_limitSwitch_connectionSize = valveSpecification_accessory_limitSwitch_connectionSize;
	}

	public String getValveSpecification_accessory_limitSwitch_jointModel() {
		return valveSpecification_accessory_limitSwitch_jointModel;
	}

	public void setValveSpecification_accessory_limitSwitch_jointModel(
			String valveSpecification_accessory_limitSwitch_jointModel) {
		this.valveSpecification_accessory_limitSwitch_jointModel = valveSpecification_accessory_limitSwitch_jointModel;
	}

	public String getValveSpecification_accessory_limitSwitch_explosionProof() {
		return valveSpecification_accessory_limitSwitch_explosionProof;
	}

	public void setValveSpecification_accessory_limitSwitch_explosionProof(
			String valveSpecification_accessory_limitSwitch_explosionProof) {
		this.valveSpecification_accessory_limitSwitch_explosionProof = valveSpecification_accessory_limitSwitch_explosionProof;
	}

	public String getValveSpecification_accessory_conveyer_model() {
		return valveSpecification_accessory_conveyer_model;
	}

	public void setValveSpecification_accessory_conveyer_model(
			String valveSpecification_accessory_conveyer_model) {
		this.valveSpecification_accessory_conveyer_model = valveSpecification_accessory_conveyer_model;
	}

	public String getValveSpecification_accessory_conveyer_outputSignal() {
		return valveSpecification_accessory_conveyer_outputSignal;
	}

	public void setValveSpecification_accessory_conveyer_outputSignal(
			String valveSpecification_accessory_conveyer_outputSignal) {
		this.valveSpecification_accessory_conveyer_outputSignal = valveSpecification_accessory_conveyer_outputSignal;
	}

	public String getValveSpecification_accessory_conveyer_explosionProof() {
		return valveSpecification_accessory_conveyer_explosionProof;
	}

	public void setValveSpecification_accessory_conveyer_explosionProof(
			String valveSpecification_accessory_conveyer_explosionProof) {
		this.valveSpecification_accessory_conveyer_explosionProof = valveSpecification_accessory_conveyer_explosionProof;
	}

	public String getValveSpecification_accessory_filterReducingValve_model() {
		return valveSpecification_accessory_filterReducingValve_model;
	}

	public void setValveSpecification_accessory_filterReducingValve_model(
			String valveSpecification_accessory_filterReducingValve_model) {
		this.valveSpecification_accessory_filterReducingValve_model = valveSpecification_accessory_filterReducingValve_model;
	}

	public String getValveSpecification_accessory_filterReducingValve_connection() {
		return valveSpecification_accessory_filterReducingValve_connection;
	}

	public void setValveSpecification_accessory_filterReducingValve_connection(
			String valveSpecification_accessory_filterReducingValve_connection) {
		this.valveSpecification_accessory_filterReducingValve_connection = valveSpecification_accessory_filterReducingValve_connection;
	}

	public String getValveSpecification_accessory_handWheel() {
		return valveSpecification_accessory_handWheel;
	}

	public void setValveSpecification_accessory_handWheel(
			String valveSpecification_accessory_handWheel) {
		this.valveSpecification_accessory_handWheel = valveSpecification_accessory_handWheel;
	}

	public String getValveSpecification_accessory_conveyer_connectionSize() {
		return valveSpecification_accessory_conveyer_connectionSize;
	}

	public void setValveSpecification_accessory_conveyer_connectionSize(
			String valveSpecification_accessory_conveyer_connectionSize) {
		this.valveSpecification_accessory_conveyer_connectionSize = valveSpecification_accessory_conveyer_connectionSize;
	}

}
