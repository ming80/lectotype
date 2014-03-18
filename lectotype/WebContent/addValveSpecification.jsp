<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加选型表</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/json2.js"></script> 
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/flowCaculation_20140214-1.js" charset="GBK"></script>
</head>

<body>
	<div style="padding:10px">		
		<div class="easyui-panel" style="padding:10px;">
			<table border="0" width="850px">
				<tr height="35px">
					<td align="right">项目名称&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification_projectName" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
					<td align="right">数量&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification_quantity" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>	
				<tr height="35px">
					<td align="right">位号&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification_tagNo" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
					<td align="right">用途&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification_service" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
			</table>
		</div><br>
		<div id="" class="easyui-tabs" style="height:240px;" fit="true" border="true" plain="true">
      		<div title="工艺参数&计算" style="padding:10px;">
      			<div style="float:left">
      				<div class="easyui-panel" style="width:480px;height:350px;padding:10px;" data-options="title:'工艺参数'">
						<table border="0" width="450px">
							<tr height="35px">
								<td width="80px">管道尺寸/材质</td>
								<td width="138px"><input type="text" id="valveSpecification_processPara_pipeSizeAndMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">压力单位</td>
								<td>
									<select id="valveSpecification_processPara_pressureUnit" class="easyui-combobox" data-options="width:122,panelHeight:80,editable:false">
										<option value="Kgf/cm2">Kgf/cm2</option>
										<option value="MPa">MPa</option>
										<option value="KPa">KPa</option>
									</select>
								</td>
							</tr>                                                         
							<tr height="35px">
								<td>介质名称</td>
								<td>
									<input type="text" id="valveSpecification_processPara_fluidName" size="8" style="height:20px;border:1px solid #9D9D9D">
								 	<input type="button" value="..." onclick="showSelectFluidWin()">
								</td>
								<td>阀前压力</td>
								<td>
									<input type="text" id="valveSpecification_processPara_upstreamPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="P1Unit">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>介质状态</td>
								<td>
									<select id="valveSpecification_processPara_fluidState" class="easyui-combobox" data-options="width:122,panelHeight:80,editable:false">
										<option value="liquid">液体</option>
										<option value="gas">气体</option>
										<option value="vaper">水蒸汽</option>
									</select>									
								</td>
								<td>阀后压力</td>
								<td>
									<input type="text" id="valveSpecification_processPara_downstreamPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="P2Unit">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>密度</td>
								<td>
									<input type="text" id="valveSpecification_processPara_density" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="densityUnit">kg/m3</div>
								</td>
								<td>关闭时压差</td>
								<td>
									<input type="text" id="valveSpecification_processPara_differentialPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="diffPUnit">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>最大流量</td>
								<td>
									<input type="text" id="valveSpecification_processPara_Qmax" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="QmaxFlowUnit">m3/h</span>
								</td>
								<td>运动粘度</td>
								<td><input type="text" id="valveSpecification_processPara_dynamicViscosity" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>正常流量</td>
								<td>
									<input type="text" id="valveSpecification_processPara_Qnor" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="QnorFlowUnit">m3/h</span>
								</td>
								<td>压缩系数</td>
								<td><input type="text" id="valveSpecification_processPara_compressFactor" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>最小流量</td>
								<td>
									<input type="text" id="valveSpecification_processPara_Qmin" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="QminFlowUnit">m3/h</span>
								</td>
								<td>汽化压力</td>
								<td>
									<input type="text" id="valveSpecification_processPara_vaporPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>100KPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>操作温度</td>
								<td>
									<input type="text" id="valveSpecification_processPara_operationTemperature" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>℃</span>
								</td>
								<td>临界压力</td>
								<td>
									<input type="text" id="valveSpecification_processPara_criticalPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>100KPa</span>
								</td>
							</tr>
						</table>
					</div>
      			</div>
      			<div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:350px;padding:10px;" data-options="title:'计算'">
      					<table border="0" width="440px">
							<tr height="35px">
								<td>计算Kvmax</td>
								<td colspan="5"><input type="text" id="valveSpecification_calculation_Kvmax" size="11" style="height:20px;border:1px solid #9D9D9D" onclick="caculateKvmax()"></td>
							</tr>
							<tr height="35px">
								<td>计算Kvmin</td>
								<td colspan="5"><input type="text" id="valveSpecification_calculation_Kvmin" size="11" style="height:20px;border:1px solid #9D9D9D" onclick="caculateKvmin()"></td>
							</tr>
							<tr height="35px">
								<td>选用Kv</td>
								<td colspan="5"><input type="text" id="valveSpecification_calculation_selectedKv" size="11" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td width="70px">阀开度Kmax</td>
								<td><input type="text" id="valveSpecification_calculation_Kmax" size="11" style="height:20px;border:1px solid #9D9D9D" onclick="caculateKmax()"></td>
								<td width="55px">流量特性</td>
								<td>
									<select id="valveSpecification_calculation_flowCharacteristic" class="easyui-combobox" data-options="width:75,panelHeight:100,editable:false">
										<option value="equalPercentage">等百分比</option>
										<option value="linear">直线</option>							
										<option value="squareRoot">平方根</option>
										<option value="modifiedParabolic">抛物线</option>
									</select>
								</td>
								<td width="40px">可调比</td>
								<td>
									<select id="valveSpecification_calculation_adjustableRatio" class="easyui-combobox" data-options="width:50,panelHeight:100,editable:true">
										<option value="50">50</option>
										<option value="30">30</option>							
										<option value="20">20</option>
										<option value="100">100</option>
									</select>
								</td>				
							</tr>
							<tr height="35px">
								<td>阀开度Kmin</td>
								<td><input type="text" id="valveSpecification_calculation_Kmin" size="11" style="height:20px;border:1px solid #9D9D9D" onclick="caculateKmin()"></td>
								<td>公称压力</td>
								<td colspan="3">
									<select id="valveSpecification_calculation_nominalPressure" class="easyui-combobox" data-options="width:75,panelHeight:100,editable:true">
										<option>&ensp;</option>
										<option value="1.6">1.6</option>
										<option value="4.0">4.0</option>							
										<option value="6.4">6.4</option>
									</select>
									<span>MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>噪声估算</td>
								<td><input type="text" id="valveSpecification_calculation_noiseLevel" size="11" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>气开/气关</td>
								<td colspan="3">
									<select id="valveSpecification_calculation_closeOpen" class="easyui-combobox" data-options="width:75,panelHeight:100,editable:false">
										<option>&ensp;</option>
										<option>气开</option>										
										<option>气关</option>							
									</select>
								</td>
							</tr>
						</table>
      				</div>
      			</div>
      			<div style="clear:both"></div>
      		</div>
      		<div title="调节阀选型" style="padding:10px;">
      			<div class="easyui-panel" style="width:450px;padding:10px;">
      				<table border="0" width="430px">
							<tr height="35px">
								<td width="60px">名称</td>
								<td>
									<input type="text" id="valveSpecification_selectedModel_name" size="10" style="height:20px;border:1px solid #9D9D9D">
									<input type="button" value="..." onclick="showSelectSelectedModelWin()">
								</td>
								<td width="60px">阀体材质</td>
								<td><input type="text" id="valveSpecification_selectedModel_bodyMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>型号</td>
								<td><input type="text" id="valveSpecification_selectedModel_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀座材质</td>
								<td><input type="text" id="valveSpecification_selectedModel_seatMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>公称通径</td>
								<td><input type="text" id="valveSpecification_selectedModel_diameterNominal" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀芯材质</td>
								<td><input type="text" id="valveSpecification_selectedModel_plugMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>阀座直径</td>
								<td><input type="text" id="valveSpecification_selectedModel_seatDiameter" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>填料</td>
								<td><input type="text" id="valveSpecification_selectedModel_packing" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>公称压力</td>
								<td>
									<input type="text" id="valveSpecification_selectedModel_nominalPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>
								</td>
								<td>上阀盖型式</td>
								<td><input type="text" id="valveSpecification_selectedModel_bonnetType" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>流开/流闭</td>
								<td>
									<select id="valveSpecification_selectedModel_flowOpenClose" class="easyui-combobox" data-options="width:125,panelHeight:70,editable:false">
										<option value="default">&ensp;</option>
										<option value="open">开</option>
										<option value="close">闭</option>							
									</select>
									<!-- input type="text" id="valveSpecification_selectedModel_flowOpenClose" size="15" style="height:20px;border:1px solid #9D9D9D"-->
								</td>
								<td>连接法兰</td>
								<td><input type="text" id="valveSpecification_selectedModel_connectionFlange" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>失气位置</td>
								<td>
									<select id="valveSpecification_selectedModel_airFail" class="easyui-combobox" data-options="width:125,panelHeight:70,editable:false">
										<option value="default">&ensp;</option>
										<option value="open">开</option>
										<option value="close">关</option>							
									</select>
									<!-- input type="text" id="valveSpecification_selectedModel_airFail" size="15" style="height:20px;border:1px solid #9D9D9D"-->
								</td>
								<td>泄露等级</td>
								<td><input type="text" id="valveSpecification_selectedModel_leakageClass" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>流量特性</td>
								<td colspan="3">
									<select id="valveSpecification_selectedModel_flowCharacter" class="easyui-combobox" data-options="width:125,panelHeight:130,editable:false">
										<option value="default">&ensp;</option>
										<option value="equalPercentage">等百分比</option>
										<option value="linear">直线</option>	
										<option value="quickOpening">快开</option>							
										<option value="squareRoot">平方根</option>
										<option value="modifiedParabolic">抛物线</option>
									</select>	
									<!-- input type="text" id="valveSpecification_selectedModel_flowCharacter" size="15" style="height:20px;border:1px solid #9D9D9D"-->
								</td>
	
							</tr>
					</table>
				</div>
      		</div>
      		<div title="执行机构" style="padding:10px;">
      			<div class="easyui-panel" style="width:450px;padding:10px;">
      				<table border="0" width="430px">
							<tr height="35px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_actuator_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>动作形式</td>
								<td><input type="text" id="valveSpecification_actuator_action" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>弹簧范围</td>
								<td>
									<input type="text" id="valveSpecification_actuator_springRange" size="15" style="height:20px;border:1px solid #9D9D9D">
									<span>KPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>供气压力</td>
								<td>
									<input type="text" id="valveSpecification_actuator_airPressure" size="15" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>	
								</td>
							</tr>
							<tr height="35px">
								<td>气源接头</td>
								<td><input type="text" id="valveSpecification_actuator_airConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>						
					</table>
				</div>
      		</div>
      		<div title="附件" style="padding:10px;">
      			<div style="float:left">
      				<div class="easyui-panel" style="width:460px;height:150px;padding:5px;" data-options="title:'定位器'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_accessory_positioner_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">信号接口</td>
								<td><input type="text" id="valveSpecification_accessory_positioner_signalConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>输入信号</td>
								<td>
									<input type="text" id="valveSpecification_accessory_positioner_inputSignal" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>mA</span>
								</td>
								<td>气接口尺寸</td>
								<td><input type="text" id="valveSpecification_accessory_positioner_airConnectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>供气压力</td>
								<td>
									<input type="text" id="valveSpecification_accessory_positioner_airPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>
								</td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification_accessory_positioner_explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:150px;padding:5px;" data-options="title:'电磁阀'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_accessory_solenoid_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">气接口尺寸</td>
								<td><input type="text" id="valveSpecification_accessory_solenoid_airConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>电源电压</td>
								<td><input type="text" id="valveSpecification_accessory_solenoid_supplyPower" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification_accessory_solenoid_explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>电源接口</td>
								<td colspan="3"><input type="text" id="valveSpecification_accessory_solenoid_powerConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      			<div style="float:left;width:800px;height:15px"></div>
      			<div style="float:left">
      				<div class="easyui-panel" style="width:460px;height:110px;padding:5px;" data-options="title:'阀位开关'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_accessory_limitSwitch_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口尺寸</td>
								<td><input type="text" id="valveSpecification_accessory_limitSwitch_connectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>结点形式</td>
								<td><input type="text" id="valveSpecification_accessory_limitSwitch_jointModel" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification_accessory_limitSwitch_explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:110px;padding:5px;" data-options="title:'阀位传送器'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_accessory_conveyer_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口尺寸</td>
								<td><input type="text" id="valveSpecification_accessory_conveyer_connectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>输出信号</td>
								<td>
									<input type="text" id="valveSpecification_accessory_conveyer_outputSignal" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>mA</span>
								</td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification_accessory_conveyer_explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      			<div style="float:left;width:800px;height:15px"></div>
      			<div style="float:left">
      				<div class="easyui-panel" style="width:460px;height:80px;padding:5px;" data-options="title:'过滤减压阀'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification_accessory_filterReducingValve_model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口</td>
								<td><input type="text" id="valveSpecification_accessory_filterReducingValve_connection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:80px;padding:5px;" data-options="title:'手轮机构'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td>                                                                           
									<select id="valveSpecification_accessory_handWheel" class="easyui-combobox" data-options="width:200,editable:false">
										<option value="false">不带</option>
										<option value="true">带</option>
									</select>
								<!-- input type="text" id="valveSpecification_accessory_handWheel" size="15" style="height:20px;border:1px solid #9D9D9D"-->
								</td>
							</tr>
						</table>
      				</div>
      			</div>
      		</div>
      		<div title="备注" style="padding:10px;">
      			<textarea id="valveSpecification_remarks" rows="15" cols="80" style="border:1px solid #9D9D9D"></textarea> 
      		</div>
    	</div>
		<div style="text-align:center;padding:20px">
			<a href="#" class="easyui-linkbutton" onclick="save()">保存选型表</a>&nbsp&nbsp
			<a href="#" class="easyui-linkbutton" >清空选型表</a>
		</div>
	</div>	
	<div id="selectFluid" style="padding:10px;">
		<table id="allFluids"></table>
		<div style="text-align:center;padding:10px">
			<a href="#" class="easyui-linkbutton" onclick="selectFluid()">确定</a>
		</div>
	</div>
	
	<div id="selectSelectedModel" style="padding:10px;">
		<table id="allSelectedModels"></table>
		<div style="text-align:center;padding:10px">
			<a href="#" class="easyui-linkbutton" onclick="selectSelectedModel()">确定</a>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){			
			$('#valveSpecification_processPara_pressureUnit').combobox({
				onSelect:function(record){
					$('#P1Unit').html(record.text);
					$('#P2Unit').html(record.text);
					$('#diffPUnit').html(record.text);
				}
			});
			
			$('#valveSpecification_processPara_fluidState').combobox({
				onSelect:function(record){
					if(record.text == '液体'){
						$('#QmaxFlowUnit').html('m3/h');
						$('#QnorFlowUnit').html('m3/h');
						$('#QminFlowUnit').html('m3/h');
					}
						
					else if(record.text == '气体'){
						$('#QmaxFlowUnit').html('m3/h');
						$('#QnorFlowUnit').html('m3/h');
						$('#QminFlowUnit').html('m3/h');
					}
					else if(record.text == '水蒸汽'){
						$('#QmaxFlowUnit').html('kg/h');
						$('#QnorFlowUnit').html('kg/h');
						$('#QminFlowUnit').html('kg/h');
					}
				}
			});
			
			$('#valveSpecification_calculation_flowCharacteristic').combobox({
				onSelect:function(record){
					caculateKmax();
					caculateKmin();
				}
			});
			
			$('#valveSpecification_calculation_adjustableRatio').combobox({
				onSelect:function(record){
					//alert(record);
					caculateKmax();
					caculateKmin();
				}
			});
			
			$('#valveSpecification_processPara_pressureUnit').combobox('select','MPa');
			//$('#valveSpecification_accessory_handWheel').combobox			
		});
		
		function save(){
			//alert($('#valveSpecification_accessory_handWheel').combobox('getValue'));
			var handWheel = false;
			if($('#valveSpecification_accessory_handWheel').combobox('getValue') == 'true')
				handWheel = true;
			
			$.ajax({
				type:'POST',				     
				url:'addValveSpecification.action',
				dataType:'json',
				data:{														  
					'valveSpecification_projectName':$('#valveSpecification_projectName').val(),
					'valveSpecification_quantity':$('#valveSpecification_quantity').val(),
					'valveSpecification_tagNo':$('#valveSpecification_tagNo').val(),
					'valveSpecification_service':$('#valveSpecification_service').val(),
					'valveSpecification_remarks':$('#valveSpecification_remarks').val(),
					'valveSpecification_processPara_pipeSizeAndMaterial':$('#valveSpecification_processPara_pipeSizeAndMaterial').val(),					                                                                                     
					'valveSpecification_processPara_pressureUnit':$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
					'valveSpecification_processPara_fluidName':$('#valveSpecification_processPara_fluidName').val(),
					'valveSpecification_processPara_upstreamPressure':$('#valveSpecification_processPara_upstreamPressure').val(),
					'valveSpecification_processPara_fluidState':$('#valveSpecification_processPara_fluidState').combobox('getValue'),
					'valveSpecification_processPara_flowUnit':$('#QmaxFlowUnit').html(),					
					'valveSpecification_processPara_downstreamPressure':$('#valveSpecification_processPara_downstreamPressure').val(),
					'valveSpecification_processPara_density':$('#valveSpecification_processPara_density').val(),
					'valveSpecification_processPara_differentialPressure':$('#valveSpecification_processPara_differentialPressure').val(),
					'valveSpecification_processPara_Qmax':$('#valveSpecification_processPara_Qmax').val(),
					'valveSpecification_processPara_dynamicViscosity':$('#valveSpecification_processPara_dynamicViscosity').val(),
					'valveSpecification_processPara_Qnor':$('#valveSpecification_processPara_Qnor').val(),
					'valveSpecification_processPara_compressFactor':$('#valveSpecification_processPara_compressFactor').val(),
					'valveSpecification_processPara_Qmin':$('#valveSpecification_processPara_Qmin').val(),
					'valveSpecification_processPara_vaporPressure':$('#valveSpecification_processPara_vaporPressure').val(),
					'valveSpecification_processPara_operationTemperature':$('#valveSpecification_processPara_operationTemperature').val(),
					'valveSpecification_processPara_criticalPressure':$('#valveSpecification_processPara_criticalPressure').val(),
					'valveSpecification_calculation_Kvmax':$('#valveSpecification_calculation_Kvmax').val(),
					'valveSpecification_calculation_Kvmin':$('#valveSpecification_calculation_Kvmin').val(),
					'valveSpecification_calculation_selectedKv':$('#valveSpecification_calculation_selectedKv').val(),
					'valveSpecification_calculation_Kmax':$('#valveSpecification_calculation_Kmax').val(),
					'valveSpecification_calculation_flowCharacteristic':$('#valveSpecification_calculation_flowCharacteristic').val(),
					'valveSpecification_calculation_adjustableRatio':$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
					'valveSpecification_calculation_Kmin':$('#valveSpecification_calculation_Kmin').val(),
					'valveSpecification_calculation_nominalPressure':$('#valveSpecification_calculation_nominalPressure').val(),
					'valveSpecification_calculation_noiseLevel':$('#valveSpecification_calculation_noiseLevel').val(),
					'valveSpecification_calculation_closeOpen':$('#valveSpecification_calculation_closeOpen').val(),
					'valveSpecification_selectedModel_name':$('#valveSpecification_selectedModel_name').val(),
					'valveSpecification_selectedModel_bodyMaterial':$('#valveSpecification_selectedModel_bodyMaterial').val(),
					'valveSpecification_selectedModel_model':$('#valveSpecification_selectedModel_model').val(),
					'valveSpecification_selectedModel_seatMaterial':$('#valveSpecification_selectedModel_seatMaterial').val(),
					'valveSpecification_selectedModel_diameterNominal':$('#valveSpecification_selectedModel_diameterNominal').val(),
					'valveSpecification_selectedModel_plugMaterial':$('#valveSpecification_selectedModel_plugMaterial').val(),
					'valveSpecification_selectedModel_seatDiameter':$('#valveSpecification_selectedModel_seatDiameter').val(),
					'valveSpecification_selectedModel_packing':$('#valveSpecification_selectedModel_packing').val(),
					'valveSpecification_selectedModel_nominalPressure':$('#valveSpecification_selectedModel_nominalPressure').val(),
					'valveSpecification_selectedModel_bonnetType':$('#valveSpecification_selectedModel_bonnetType').val(),
					'valveSpecification_selectedModel_flowOpenClose':$('#valveSpecification_selectedModel_flowOpenClose').combobox('getValue'),
					'valveSpecification_selectedModel_connectionFlange':$('#valveSpecification_selectedModel_connectionFlange').val(),					 
					'valveSpecification_selectedModel_airFail':$('#valveSpecification_selectedModel_airFail').combobox('getValue'),
					'valveSpecification_selectedModel_leakageClass':$('#valveSpecification_selectedModel_leakageClass').val(),
					'valveSpecification_selectedModel_flowCharacter':$('#valveSpecification_selectedModel_flowCharacter').combobox('getValue'),
					'valveSpecification_actuator_model':$('#valveSpecification_actuator_model').val(),
					'valveSpecification_actuator_action':$('#valveSpecification_actuator_action').val(),
					'valveSpecification_actuator_springRange':$('#valveSpecification_actuator_springRange').val(),
					'valveSpecification_actuator_airPressure':$('#valveSpecification_actuator_airPressure').val(),
					'valveSpecification_actuator_airConnection':$('#valveSpecification_actuator_airConnection').val(),
					'valveSpecification_accessory_positioner_model':$('#valveSpecification_accessory_positioner_model').val(),
					'valveSpecification_accessory_positioner_signalConnection':$('#valveSpecification_accessory_positioner_signalConnection').val(),
					'valveSpecification_accessory_positioner_inputSignal':$('#valveSpecification_accessory_positioner_inputSignal').val(),
					'valveSpecification_accessory_positioner_airConnectionSize':$('#valveSpecification_accessory_positioner_airConnectionSize').val(),
					'valveSpecification_accessory_positioner_airPressure':$('#valveSpecification_accessory_positioner_airPressure').val(),
					'valveSpecification_accessory_positioner_explosionProof':$('#valveSpecification_accessory_positioner_explosionProof').val(),
					'valveSpecification_accessory_solenoid_model':$('#valveSpecification_accessory_solenoid_model').val(),
					'valveSpecification_accessory_solenoid_airConnection':$('#valveSpecification_accessory_solenoid_airConnection').val(),
					'valveSpecification_accessory_solenoid_supplyPower':$('#valveSpecification_accessory_solenoid_supplyPower').val(),
					'valveSpecification_accessory_solenoid_explosionProof':$('#valveSpecification_accessory_solenoid_explosionProof').val(),
					'valveSpecification_accessory_solenoid_powerConnection':$('#valveSpecification_accessory_solenoid_powerConnection').val(),
					'valveSpecification_accessory_limitSwitch_model':$('#valveSpecification_accessory_limitSwitch_model').val(),
					'valveSpecification_accessory_limitSwitch_connectionSize':$('#valveSpecification_accessory_limitSwitch_connectionSize').val(),
					'valveSpecification_accessory_limitSwitch_jointModel':$('#valveSpecification_accessory_limitSwitch_jointModel').val(),
					'valveSpecification_accessory_limitSwitch_explosionProof':$('#valveSpecification_accessory_limitSwitch_explosionProof').val(),
					'valveSpecification_accessory_conveyer_model':$('#valveSpecification_accessory_conveyer_model').val(),
					'valveSpecification_accessory_conveyer_connectionSize':$('#valveSpecification_accessory_conveyer_connectionSize').val(),					                                                           
					'valveSpecification_accessory_conveyer_outputSignal':$('#valveSpecification_accessory_conveyer_outputSignal').val(),
					'valveSpecification_accessory_conveyer_explosionProof':$('#valveSpecification_accessory_conveyer_explosionProof').val(),
					'valveSpecification_accessory_filterReducingValve_model':$('#valveSpecification_accessory_filterReducingValve_model').val(),
					'valveSpecification_accessory_filterReducingValve_connection':$('#valveSpecification_accessory_filterReducingValve_connection').val(),
					'valveSpecification_accessory_handWheel':$('#valveSpecification_accessory_handWheel').val()
				},
				success:function(data){
					//alert(JSON.stringify(data));
					alert('保存成功!');
				},
				error:function(jqXHR, textStatus,errorThrown){
					alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
				}
			});
		}
		
		function showSelectFluidWin(){
			
			$('#selectFluid').window({
				title:'请选择介质',
			    width:600,
			    height:400,
			    modal:true
			    //content:'<table id="allFluids"></table><a href="#" class="easyui-linkbutton" onclick="save()">确定</a>'
			});
			
			$('#allFluids').datagrid({
			    url:'queryAllFluid.action',
			    height:300,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					{field:'ck',checkbox:true},	
			        {field:'name',title:'介质名称',width:100},
			        {field:'state',title:'介质状态',width:100,
			        	formatter:function(value){
							if(!value)
								return '';
							
							if(value == 'gas')
								return '气体';
							else if(value == 'liquid')
								return '液体';
		                }	
			        },
			        {field:'density',title:'密度',width:100},
			        {field:'sg',title:'比重',width:100}
			    ]]
			});
		}
		
		function selectFluid(){
			var selectedRow = $('#allFluids').datagrid('getSelected');
			
			if(selectedRow){
				$('#valveSpecification_processPara_fluidName').val(selectedRow.name);
				
				if(selectedRow.state == 'liquid')
					$('#valveSpecification_processPara_fluidState').combobox('select','liquid');
				if(selectedRow.state == 'gas')
					$('#valveSpecification_processPara_fluidState').combobox('select','gas');
				
				$('#valveSpecification_processPara_density').val(selectedRow.density);
			}
			
			$('#selectFluid').window('close');
		}
		   
		function showSelectSelectedModelWin(){
			
			$('#selectSelectedModel').window({
				title:'请选择调节阀选型',
			    width:800,
			    height:450,
			    modal:true
			    //content:'<table id="allFluids"></table><a href="#" class="easyui-linkbutton" onclick="save()">确定</a>'
			});
			
			$('#allSelectedModels').datagrid({
			    url:'queryAllSelectedModel.action',
			    height:350,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					{field:'ck',checkbox:true},	
					{field:'name',title:'名称',width:100},
					{field:'model',title:'型号',width:100},
					{field:'diameterNominal',title:'公称通径',width:100},
					{field:'seatDiameter',title:'阀座直径',width:100},
					{field:'nominalPressure',title:'公称压力',width:100},
					{field:'flowOpenClose',title:'流开/流闭',width:100,
					        formatter:function(value){
					        		if(!value) return '';			        		
					        		if(value == 'open') return '开';			        		
					        		if(value == 'close') return '闭';			        		
					        }			        	
					},
					{field:'airFail',title:'失气位置',width:100,
							formatter:function(value){
					        		if(!value) return '';			        		
					        		if(value == 'open') return '开';			        		
					        		if(value == 'close') return '关';			        		
					        	}
					},
					{field:'flowCharacter',title:'流量特性',width:100,
							formatter:function(value){
					        		if(!value) return '';			        		
					        		if(value == 'equalPercentage') return '等百分比';			        		
					        		if(value == 'linear') return '直线';	
					        		if(value == 'quickOpening') return '快开';			        		
					        		if(value == 'squareRoot') return '平方根';	
					        		if(value == 'modifiedParabolic') return '抛物线';
					        	}
					},
					{field:'bodyMaterial',title:'阀体材质',width:100},
					{field:'seatMaterial',title:'阀座材质',width:100},
					{field:'plugMaterial',title:'阀芯材质',width:100},
					{field:'packing',title:'填料',width:100},
					{field:'bonnetType',title:'上阀盖型式',width:100},
					{field:'connectionFlange',title:'连接法兰',width:100},
					{field:'leakageClass',title:'泄露等级',width:100},
				]]
			});
		}
		
		function selectSelectedModel(){
			var selectedRow = $('#allSelectedModels').datagrid('getSelected');
			
			if(selectedRow){
				
				$('#valveSpecification_selectedModel_name').val(selectedRow.name);
				$('#valveSpecification_selectedModel_bodyMaterial').val(selectedRow.bodyMaterial);
				$('#valveSpecification_selectedModel_model').val(selectedRow.model);
				$('#valveSpecification_selectedModel_seatMaterial').val(selectedRow.seatMaterial);
				$('#valveSpecification_selectedModel_diameterNominal').val(selectedRow.diameterNominal);
				$('#valveSpecification_selectedModel_plugMaterial').val(selectedRow.plugMaterial);
				$('#valveSpecification_selectedModel_seatDiameter').val(selectedRow.seatDiameter);
				$('#valveSpecification_selectedModel_packing').val(selectedRow.packing);
				$('#valveSpecification_selectedModel_nominalPressure').val(selectedRow.nominalPressure);
				$('#valveSpecification_selectedModel_bonnetType').val(selectedRow.bonnetType);
				
				if(selectedRow.flowOpenClose == 'open')
					$('#valveSpecification_selectedModel_flowOpenClose').combobox('select','open');
				else if(selectedRow.flowOpenClose == 'close')
					$('#valveSpecification_selectedModel_flowOpenClose').combobox('select','close');
				else
					$('#valveSpecification_selectedModel_flowOpenClose').combobox('select','default');
					
				$('#valveSpecification_selectedModel_connectionFlange').val(selectedRow.connectionFlange);				 
				
				if(selectedRow.airFail == 'open')
					$('#valveSpecification_selectedModel_airFail').combobox('select','open');
				else if(selectedRow.airFail == 'close')
					$('#valveSpecification_selectedModel_airFail').combobox('select','close');
				else
					$('#valveSpecification_selectedModel_airFail').combobox('select','default');
	
				
				$('#valveSpecification_selectedModel_leakageClass').val(selectedRow.leakageClass);				
							
				if(selectedRow.flowCharacter == 'equalPercentage')
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','equalPercentage');
				else if(selectedRow.flowCharacter == 'linear')
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','linear');
				else if(selectedRow.flowCharacter == 'quickOpening')
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','quickOpening');
				else if(selectedRow.flowCharacter == 'squareRoot')
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','squareRoot');
				else if(selectedRow.flowCharacter == 'modifiedParabolic')
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','modifiedParabolic');
				else
					$('#valveSpecification_selectedModel_flowCharacter').combobox('select','default');
			}

			$('#selectSelectedModel').window('close');
		}
		
		function caculateKvmax(){
			//alert('1');
			var fluidState = $('#valveSpecification_processPara_fluidState').combobox('getValue');
			var Kv,Cv;
			if(fluidState == "liquid"){
				//alert('液体');
				Kv = calculateLiquidKv($('#valveSpecification_processPara_Qmax').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						($('#valveSpecification_processPara_density').val() / 1000),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'maxKv');
			}
			else if(fluidState == "gas"){
				//alert('气体');
				Cv = calculateGasCv($('#valveSpecification_processPara_Qmax').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						($('#valveSpecification_processPara_density').val() / 1.29),
						$('#valveSpecification_processPara_operationTemperature').val(),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'maxKv');
				Kv = Cv / 1.17;
				//alert(Kv);
			}				
			else if(fluidState == "vaper"){
				//alert('水蒸汽');
				Cv = calculateVaperCv($('#valveSpecification_processPara_Qmax').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						$('#valveSpecification_processPara_operationTemperature').val(),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'maxKv');
				Kv = Cv / 1.17;
			}				

			if($.isNumeric(Kv))
				$('#valveSpecification_calculation_Kvmax').val(Math.round(Kv * 10000) / 10000);			
		}
		
		function caculateKvmin(){	
			//alert('1');
			var fluidState = $('#valveSpecification_processPara_fluidState').combobox('getValue');
			var Kv,Cv;
			if(fluidState == "liquid"){
				//alert('液体');
				Kv = calculateLiquidKv($('#valveSpecification_processPara_Qmin').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						($('#valveSpecification_processPara_density').val() / 1000),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'minKv');
			}
			else if(fluidState == "gas"){
				//alert('气体');
				Cv = calculateGasCv($('#valveSpecification_processPara_Qmin').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						($('#valveSpecification_processPara_density').val() / 1.29),
						$('#valveSpecification_processPara_operationTemperature').val(),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'minKv');
				Kv = Cv / 1.17;
				//alert(Kv);
			}				
			else if(fluidState == "vaper"){
				//alert('水蒸汽');
				Cv = calculateVaperCv($('#valveSpecification_processPara_Qmin').val(),
						$('#valveSpecification_processPara_upstreamPressure').val(),
						$('#valveSpecification_processPara_downstreamPressure').val(),
						$('#valveSpecification_processPara_operationTemperature').val(),
						$('#valveSpecification_processPara_pressureUnit').combobox('getValue'),
						'minKv');
				Kv = Cv / 1.17;
			}				

			if($.isNumeric(Kv))
				$('#valveSpecification_calculation_Kvmin').val(Math.round(Kv * 10000) / 10000);	
		}
		
		function caculateKmax(){
			var flowCharacteristic = $('#valveSpecification_calculation_flowCharacteristic').combobox('getValue');
			var K;
			
			if(flowCharacteristic == "equalPercentage")
				K = calculateKByEqualPercentage($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmax').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'maxKv');
			else if(flowCharacteristic == "linear")
				K = calculateKByLinear($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmax').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'maxKv');
			else if(flowCharacteristic == "modifiedParabolic")
				K = calculateKByModifiedParabolic($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmax').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'maxKv');
			else if(flowCharacteristic == "squareRoot")
				K = calculateKBySquareRoot($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmax').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'maxKv');
			
			//alert(K);
			if($.isNumeric(K))		
				$('#valveSpecification_calculation_Kmax').val((Math.round(K * 100) / 100) + '%');

		}
		
		function caculateKmin(){
			var flowCharacteristic = $('#valveSpecification_calculation_flowCharacteristic').combobox('getValue');
			var K;
			
			//alert(flowCharacteristic);
			if(flowCharacteristic == "equalPercentage")
				K = calculateKByEqualPercentage($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmin').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'minKv');
			else if(flowCharacteristic == "linear")
				K = calculateKByLinear($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmin').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'minKv');
			else if(flowCharacteristic == "modifiedParabolic")
				K = calculateKByModifiedParabolic($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmin').val(),
						$('#valveSpecification_calculation_adjustableRatio').val(),
						'minKv');
			else if(flowCharacteristic == "squareRoot")
				K = calculateKBySquareRoot($('#valveSpecification_calculation_selectedKv').val(),
						$('#valveSpecification_calculation_Kvmin').val(),
						$('#valveSpecification_calculation_adjustableRatio').combobox('getValue'),
						'minKv');
			
			//alert(K);
			if($.isNumeric(K))		
				$('#valveSpecification_calculation_Kmin').val((Math.round(K * 100) / 100) + '%');
		}
	</script>
</body>
</html>