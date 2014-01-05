<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保单查询</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/json2.js"></script> 
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>

<body>
	<div style="padding:10px">		
		<div class="easyui-panel" style="padding:10px;">
			<table border="0" width="850px">
				<tr height="35px">
					<td align="right">项目名称&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification.projectName" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
					<td align="right">数量&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification.quantity" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>	
				<tr height="35px">
					<td align="right">位号&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification.tagNo" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
					<td align="right">用途&nbsp</td>
					<td colspan="3"><input type="text" id="valveSpecification.service" size="50" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
			</table>
		</div><br>
		<div id="" class="easyui-tabs" style="height:240px;" fit="true" border="true" plain="true">
      		<div title="工艺参数&计算" style="padding:10px;">
      			<div style="float:left">
      				<div class="easyui-panel" style="width:460px;height:350px;padding:10px;" data-options="title:'工艺参数'">
						<table border="0" width="430px">
							<tr height="35px">
								<td width="80px">管道尺寸/材质</td>
								<td><input type="text" id="valveSpecification.processPara.pipeSizeAndMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">压力单位</td>
								<td><input type="text" id="valveSpecification.processPara.pressureUnit" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>介质名称</td>
								<td><input type="text" id="valveSpecification.processPara.fluidName" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀前压力</td>
								<td>
									<input type="text" id="valveSpecification.processPara.upstreamPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>介质状态</td>
								<td><input type="text" id="valveSpecification.processPara.fluidState" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀后压力</td>
								<td>
									<input type="text" id="valveSpecification.processPara.downstreamPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>密度</td>
								<td>
									<input type="text" id="valveSpecification.processPara.density" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="">kg/m3</span>
								</td>
								<td>关闭时压差</td>
								<td>
									<input type="text" id="valveSpecification.processPara.differentialPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span id="">MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>最大流量</td>
								<td>
									<input type="text" id="valveSpecification.processPara.Qmax" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="">m3/h</span>
								</td>
								<td>运动粘度</td>
								<td><input type="text" id="valveSpecification.processPara.dynamicViscosity" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>正常流量</td>
								<td>
									<input type="text" id="valveSpecification.processPara.Qnor" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="">m3/h</span>
								</td>
								<td>压缩系数</td>
								<td><input type="text" id="valveSpecification.processPara.compressFactor" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>最小流量</td>
								<td>
									<input type="text" id="valveSpecification.processPara.Qmin" size="8" style="height:20px;border:1px solid #9D9D9D">
									<span id="">m3/h</span>
								</td>
								<td>汽化压力</td>
								<td>
									<input type="text" id="valveSpecification.processPara.vaporPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>100KPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>操作温度</td>
								<td>
									<input type="text" id="valveSpecification.processPara.operationTemperature" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>℃</span>
								</td>
								<td>临界压力</td>
								<td>
									<input type="text" id="valveSpecification.processPara.criticalPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>100KPa</span>
								</td>
							</tr>
						</table>
					</div>
      			</div>
      			<div style="float:right">
      				<div class="easyui-panel" style="width:480px;height:350px;padding:10px;" data-options="title:'计算'">
      					<table border="0" width="440px">
							<tr height="35px">
								<td>计算Kvmax</td>
								<td colspan="5"><input type="text" id="valveSpecification.calculation.Kvmax" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>计算Kvmin</td>
								<td colspan="5"><input type="text" id="valveSpecification.calculation.Kvmin" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>选用Kv</td>
								<td colspan="5"><input type="text" id="valveSpecification.calculation.selectedKv" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td width="70px">阀开度Kmax</td>
								<td><input type="text" id="valveSpecification.calculation.Kmax" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="55px">流量特性</td>
								<td><input type="text" id="valveSpecification.calculation.flowCharacteristic" size="5" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="40px">可调比</td>
								<td><input type="text" id="valveSpecification.calculation.adjustableRatio" size="3" style="height:20px;border:1px solid #9D9D9D"></td>				
							</tr>
							<tr height="35px">
								<td>阀开度Kmin</td>
								<td><input type="text" id="valveSpecification.calculation.Kmin" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>公称压力</td>
								<td colspan="3">
									<input type="text" id="valveSpecification.calculation.nominalPressure" size="15" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>噪声估算</td>
								<td><input type="text" id="valveSpecification.calculation.noiseLevel" size="13" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>气开/气关</td>
								<td colspan="3"><input type="text" id="valveSpecification.calculation.closeOpen" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
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
								<td><input type="text" id="valveSpecification.selectedModel.name" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">阀体材质</td>
								<td><input type="text" id="valveSpecification.selectedModel.bodyMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>型号</td>
								<td><input type="text" id="valveSpecification.selectedModel.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀座材质</td>
								<td><input type="text" id="valveSpecification.selectedModel.seatMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>公称通径</td>
								<td><input type="text" id="valveSpecification.selectedModel.diameterNominal" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>阀芯材质</td>
								<td><input type="text" id="valveSpecification.selectedModel.plugMaterial" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>阀座直径</td>
								<td><input type="text" id="valveSpecification.selectedModel.seatDiameter" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>填料</td>
								<td><input type="text" id="valveSpecification.selectedModel.packing" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>公称压力</td>
								<td>
									<input type="text" id="valveSpecification.selectedModel.nominalPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>
								</td>
								<td>上阀盖型式</td>
								<td><input type="text" id="valveSpecification.selectedModel.bonnetType" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>流开/流闭</td>
								<td><input type="text" id="valveSpecification.selectedModel.flowOpenClose" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>连接法兰</td>
								<td><input type="text" id="valveSpecification.selectedModel.connectionFlange" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>失气位置</td>
								<td><input type="text" id="valveSpecification.selectedModel.airFail" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>泄露等级</td>
								<td><input type="text" id="valveSpecification.selectedModel.leakageClass" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>流量特性</td>
								<td colspan="3"><input type="text" id="valveSpecification.selectedModel.flowCharacter" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
	
							</tr>
					</table>
				</div>
      		</div>
      		<div title="执行机构" style="padding:10px;">
      			<div class="easyui-panel" style="width:450px;padding:10px;">
      				<table border="0" width="430px">
							<tr height="35px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification.actuator.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>动作形式</td>
								<td><input type="text" id="valveSpecification.actuator.action" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="35px">
								<td>弹簧范围</td>
								<td>
									<input type="text" id="valveSpecification.actuator.springRange" size="15" style="height:20px;border:1px solid #9D9D9D">
									<span>KPa</span>
								</td>
							</tr>
							<tr height="35px">
								<td>供气压力</td>
								<td>
									<input type="text" id="valveSpecification.actuator.airPressure" size="15" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>	
								</td>
							</tr>
							<tr height="35px">
								<td>气源接头</td>
								<td><input type="text" id="valveSpecification.actuator.airConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
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
								<td><input type="text" id="valveSpecification.accessory.positioner.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">信号接口</td>
								<td><input type="text" id="valveSpecification.accessory.positioner.signalConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>输入信号</td>
								<td>
									<input type="text" id="valveSpecification.accessory.positioner.inputSignal" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>mA</span>
								</td>
								<td>气接口尺寸</td>
								<td><input type="text" id="valveSpecification.accessory.positioner.airConnectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>供气压力</td>
								<td>
									<input type="text" id="valveSpecification.accessory.positioner.airPressure" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>MPa</span>
								</td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification.accessory.positioner.explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:150px;padding:5px;" data-options="title:'电磁阀'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification.accessory.solenoid.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">气接口尺寸</td>
								<td><input type="text" id="valveSpecification.accessory.solenoid.airConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>电源电压</td>
								<td><input type="text" id="valveSpecification.accessory.solenoid.supplyPower" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification.accessory.solenoid.explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>电源接口</td>
								<td colspan="3"><input type="text" id="valveSpecification.accessory.solenoid.powerConnection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
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
								<td><input type="text" id="valveSpecification.accessory.limitSwitch.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口尺寸</td>
								<td><input type="text" id="valveSpecification.accessory.limitSwitch.connectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>结点形式</td>
								<td><input type="text" id="valveSpecification.accessory.limitSwitch.jointModel" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification.accessory.limitSwitch.explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:110px;padding:5px;" data-options="title:'阀位传送器'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td width="60px">型号</td>
								<td><input type="text" id="valveSpecification.accessory.conveyer.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口尺寸</td>
								<td><input type="text" id="valveSpecification.accessory.conveyer.connectionSize" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
							<tr height="30px">
								<td>输出信号</td>
								<td>
									<input type="text" id="valveSpecification.accessory.conveyer.outputSignal" size="10" style="height:20px;border:1px solid #9D9D9D">
									<span>mA</span>
								</td>
								<td>防爆等级</td>
								<td><input type="text" id="valveSpecification.accessory.conveyer.explosionProof" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
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
								<td><input type="text" id="valveSpecification.accessory.filterReducingValve.model" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
								<td width="60px">接口</td>
								<td><input type="text" id="valveSpecification.accessory.filterReducingValve.connection" size="15" style="height:20px;border:1px solid #9D9D9D"></td>
							</tr>
						</table>
      				</div>
      			</div>
      		    <div style="float:right">
      				<div class="easyui-panel" style="width:460px;height:80px;padding:5px;" data-options="title:'手轮机构'">
      					<table border="0" width="430px">
							<tr height="30px">
								<td>                                                                           
									<select id="valveSpecification.accessory.handWheel" class="easyui-combobox" data-options="width:200,editable:false">
										<option value="false">不带</option>
										<option value="true">带</option>
									</select>
								<!-- input type="text" id="valveSpecification.accessory.handWheel" size="15" style="height:20px;border:1px solid #9D9D9D"-->
								</td>
							</tr>
						</table>
      				</div>
      			</div>
      		</div>
      		<div title="备注" style="padding:10px;">
      			<textarea id="valveSpecification.remarks" rows="15" cols="80" style="border:1px solid #9D9D9D"></textarea> 
      		</div>
    	</div>
		<div style="text-align:center;padding:20px">
			<a href="#" class="easyui-linkbutton" onclick="save()">保存选型表</a>&nbsp&nbsp
			<a href="#" class="easyui-linkbutton" >清空选型表</a>
		</div>
	</div>	
	<div id="win2"></div>
	
	<script type="text/javascript">
		$(function(){			
			$('#valveSpecification\\.accessory\\.handWheel').combobox
		});
		
		function save(){
			//alert($('#valveSpecification\\.accessory\\.handWheel').combobox('getValue'));
			var handWheel = false;
			if($('#valveSpecification\\.accessory\\.handWheel').combobox('getValue') == 'true')
				handWheel = true;			
			
			$.ajax({
				type:'POST',				     
				url:'addValveSpecification.action',
				dataType:'json',
				data:{														  
					'valveSpecification.projectName':$('#valveSpecification\\.projectName').val(),
					'valveSpecification.quantity':$('#valveSpecification\\.quantity').val(),
					'valveSpecification.tagNo':$('#valveSpecification\\.tagNo').val(),
					'valveSpecification.service':$('#valveSpecification\\.service').val(),
					'valveSpecification.remarks':$('#valveSpecification\\.remarks').val(),
					'valveSpecification.processPara.pipeSizeAndMaterial':$('#valveSpecification\\.processPara\\.pipeSizeAndMaterial').val(),
					'valveSpecification.processPara.pressureUnit':$('#valveSpecification\\.processPara\\.pressureUnit').val(),
					'valveSpecification.processPara.fluidName':$('#valveSpecification\\.processPara\\.fluidName').val(),
					'valveSpecification.processPara.upstreamPressure':$('#valveSpecification\\.processPara\\.upstreamPressure').val(),
					'valveSpecification.processPara.fluidState':$('#valveSpecification\\.processPara\\.fluidState').val(),
					'valveSpecification.processPara.downstreamPressure':$('#valveSpecification\\.processPara\\.downstreamPressure').val(),
					'valveSpecification.processPara.density':$('#valveSpecification\\.processPara\\.density').val(),
					'valveSpecification.processPara.differentialPressure':$('#valveSpecification\\.processPara\\.differentialPressure').val(),
					'valveSpecification.processPara.Qmax':$('#valveSpecification\\.processPara\\.Qmax').val(),
					'valveSpecification.processPara.dynamicViscosity':$('#valveSpecification\\.processPara\\.dynamicViscosity').val(),
					'valveSpecification.processPara.Qnor':$('#valveSpecification\\.processPara\\.Qnor').val(),
					'valveSpecification.processPara.compressFactor':$('#valveSpecification\\.processPara\\.compressFactor').val(),
					'valveSpecification.processPara.Qmin':$('#valveSpecification\\.processPara\\.Qmin').val(),
					'valveSpecification.processPara.vaporPressure':$('#valveSpecification\\.processPara\\.vaporPressure').val(),
					'valveSpecification.processPara.operationTemperature':$('#valveSpecification\\.processPara\\.operationTemperature').val(),
					'valveSpecification.processPara.criticalPressure':$('#valveSpecification\\.processPara\\.criticalPressure').val(),
					'valveSpecification.calculation.Kvmax':$('#valveSpecification\\.calculation\\.Kvmax').val(),
					'valveSpecification.calculation.Kvmin':$('#valveSpecification\\.calculation\\.Kvmin').val(),
					'valveSpecification.calculation.selectedKv':$('#valveSpecification\\.calculation\\.selectedKv').val(),
					'valveSpecification.calculation.Kmax':$('#valveSpecification\\.calculation\\.Kmax').val(),
					'valveSpecification.calculation.flowCharacteristic':$('#valveSpecification\\.calculation\\.flowCharacteristic').val(),
					'valveSpecification.calculation.adjustableRatio':$('#valveSpecification\\.calculation\\.adjustableRatio').val(),
					'valveSpecification.calculation.Kmin':$('#valveSpecification\\.calculation\\.Kmin').val(),
					'valveSpecification.calculation.nominalPressure':$('#valveSpecification\\.calculation\\.nominalPressure').val(),
					'valveSpecification.calculation.noiseLevel':$('#valveSpecification\\.calculation\\.noiseLevel').val(),
					'valveSpecification.calculation.closeOpen':$('#valveSpecification\\.calculation\\.closeOpen').val(),
					'valveSpecification.selectedModel.name':$('#valveSpecification\\.selectedModel\\.name').val(),
					'valveSpecification.selectedModel.bodyMaterial':$('#valveSpecification\\.selectedModel\\.bodyMaterial').val(),
					'valveSpecification.selectedModel.model':$('#valveSpecification\\.selectedModel\\.model').val(),
					'valveSpecification.selectedModel.seatMaterial':$('#valveSpecification\\.selectedModel\\.seatMaterial').val(),
					'valveSpecification.selectedModel.diameterNominal':$('#valveSpecification\\.selectedModel\\.diameterNominal').val(),
					'valveSpecification.selectedModel.plugMaterial':$('#valveSpecification\\.selectedModel\\.plugMaterial').val(),
					'valveSpecification.selectedModel.seatDiameter':$('#valveSpecification\\.selectedModel\\.seatDiameter').val(),
					'valveSpecification.selectedModel.packing':$('#valveSpecification\\.selectedModel\\.packing').val(),
					'valveSpecification.selectedModel.nominalPressure':$('#valveSpecification\\.selectedModel\\.nominalPressure').val(),
					'valveSpecification.selectedModel.bonnetType':$('#valveSpecification\\.selectedModel\\.bonnetType').val(),
					'valveSpecification.selectedModel.flowOpenClose':$('#valveSpecification\\.selectedModel\\.flowOpenClose').val(),
					'valveSpecification.selectedModel.connectionFlange':$('#valveSpecification\\.selectedModel\\.connectionFlange').val(),
					'valveSpecification.selectedModel.airFail':$('#valveSpecification\\.selectedModel\\.airFail').val(),
					'valveSpecification.selectedModel.leakageClass':$('#valveSpecification\\.selectedModel\\.leakageClass').val(),
					'valveSpecification.selectedModel.flowCharacter':$('#valveSpecification\\.selectedModel\\.flowCharacter').val(),
					'valveSpecification.actuator.model':$('#valveSpecification\\.actuator\\.model').val(),
					'valveSpecification.actuator.action':$('#valveSpecification\\.actuator\\.action').val(),
					'valveSpecification.actuator.springRange':$('#valveSpecification\\.actuator\\.springRange').val(),
					'valveSpecification.actuator.airPressure':$('#valveSpecification\\.actuator\\.airPressure').val(),
					'valveSpecification.actuator.airConnection':$('#valveSpecification\\.actuator\\.airConnection').val(),
					'valveSpecification.accessory.positioner.model':$('#valveSpecification\\.accessory\\.positioner\\.model').val(),
					'valveSpecification.accessory.positioner.signalConnection':$('#valveSpecification\\.accessory\\.positioner\\.signalConnection').val(),
					'valveSpecification.accessory.positioner.inputSignal':$('#valveSpecification\\.accessory\\.positioner\\.inputSignal').val(),
					'valveSpecification.accessory.positioner.airConnectionSize':$('#valveSpecification\\.accessory\\.positioner\\.airConnectionSize').val(),
					'valveSpecification.accessory.positioner.airPressure':$('#valveSpecification\\.accessory\\.positioner\\.airPressure').val(),
					'valveSpecification.accessory.positioner.explosionProof':$('#valveSpecification\\.accessory\\.positioner\\.explosionProof').val(),
					'valveSpecification.accessory.solenoid.model':$('#valveSpecification\\.accessory\\.solenoid\\.model').val(),
					'valveSpecification.accessory.solenoid.airConnection':$('#valveSpecification\\.accessory\\.solenoid\\.airConnection').val(),
					'valveSpecification.accessory.solenoid.supplyPower':$('#valveSpecification\\.accessory\\.solenoid\\.supplyPower').val(),
					'valveSpecification.accessory.solenoid.explosionProof':$('#valveSpecification\\.accessory\\.solenoid\\.explosionProof').val(),
					'valveSpecification.accessory.solenoid.powerConnection':$('#valveSpecification\\.accessory\\.solenoid\\.powerConnection').val(),
					'valveSpecification.accessory.limitSwitch.model':$('#valveSpecification\\.accessory\\.limitSwitch\\.model').val(),
					'valveSpecification.accessory.limitSwitch.connectionSize':$('#valveSpecification\\.accessory\\.limitSwitch\\.connectionSize').val(),
					'valveSpecification.accessory.limitSwitch.jointModel':$('#valveSpecification\\.accessory\\.limitSwitch\\.jointModel').val(),
					'valveSpecification.accessory.limitSwitch.explosionProof':$('#valveSpecification\\.accessory\\.limitSwitch\\.explosionProof').val(),
					'valveSpecification.accessory.conveyer.model':$('#valveSpecification\\.accessory\\.conveyer\\.model').val(),
					'valveSpecification.accessory.conveyer.connectionSize':$('#valveSpecification\\.accessory\\.conveyer\\.connectionSize').val(),
					'valveSpecification.accessory.conveyer.outputSignal':$('#valveSpecification\\.accessory\\.conveyer\\.outputSignal').val(),
					'valveSpecification.accessory.conveyer.explosionProof':$('#valveSpecification\\.accessory\\.conveyer\\.explosionProof').val(),
					'valveSpecification.accessory.filterReducingValve.model':$('#valveSpecification\\.accessory\\.filterReducingValve\\.model').val(),
					'valveSpecification.accessory.filterReducingValve.connection':$('#valveSpecification\\.accessory\\.filterReducingValve\\.connection').val(),
					'valveSpecification.accessory.handWheel':handWheel
				},
				success:function(data){
					//alert(data);
				}
			});
		}
	</script>
</body>
</html>