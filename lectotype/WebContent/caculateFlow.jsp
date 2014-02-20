<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>流量计算</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/flowCaculation_20140214-1.js" charset="GBK"></script>
</head>

<body>
	<div style="padding:10px">	
		<div class="easyui-panel" title="Kv/Cv计算" style="padding:10px;width:630px;height:270px;">
			<table border="0" width="600px" height="200px">
				<tr>
					<td style="text-align:right"><label for="fluidState">介质选择</label></td>
					<td colspan="2">									
						<select id="fluidState" class="easyui-combobox" data-options="width:150,panelHeight:80,editable:false">
							<option value="liquid">液体</option>
							<option value="gas">气体</option>
							<option value="vaper">水蒸汽</option>
						</select>
					</td>
					<td style="text-align:right"><label for="pressureUnit">压力单位</label></td>
					<td>									
						<select id="pressureUnit" class="easyui-combobox" data-options="width:105,panelHeight:80,editable:false">
							<option value="Kgf/cm2">Kgf/cm2</option>
							<option value="MPa">MPa</option>
							<option value="KPa">KPa</option>
						</select>
					</td>
					<td style="text-align:center">1MPa = 1000KPa ≈ 10Kgf/cm2</td>
				</tr>
				<tr><td colspan="6"><hr/></td></tr>
				<tr>
					<td style="width:60px;text-align:right"><label for="Q">最大流量</label></td>
					<td style="width:100px;"><input type="text" id="Q" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="width:60px;text-align:left"><div id="QUnit">m3/h</div></td>
					<td style="width:60px;text-align:right"><label id="GLabel" for="G">比重</label></td>
					<td style="width:100px;"><input type="text" id="G" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td></td>
				</tr>
				<tr>
					<td style="text-align:right"><label for="P1">进口压力</label></td>
					<td><input type="text" id="P1" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="text-align:left"><div id="P1Unit">Kgf/cm2</div></td>
					<td style="text-align:right"><label id="TLabel" for="T">流体温度</label></td>
					<td><input type="text" id="T" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td></td>
				</tr>
				<tr>
					<td style="text-align:right"><label for="P2">出口压力</label></td>
					<td><input type="text" id="P2" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="text-align:left"><div id="P2Unit">Kgf/cm2</div></td>
					<td style="text-align:right"><label id="overtemperatureLabel" for="overtemperature">过热温度</label></td>
					<td><input type="text" id="overtemperature" size="12" style="height:20px;border:1px solid #9D9D9D" onclick="showOvertemperature()"></td>
					<td></td>
				</tr>
				<tr>
					<td style="text-align:right"><font size="3" color=blue><b>Cv:</b></font></td>
					<td><font size="3" color=blue><i><div id="Cv">---</div></i></font></td>
					<td colspan="3" rowspan="2" style="text-align:center">
						<a href="#" class="easyui-linkbutton" onclick="showKvCv()">计 算</a> 
						<a href="#" class="easyui-linkbutton" onclick="resetKvCvCalculation()">重 置</a> 
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="text-align:right"><font size="3" color=blue><b>Kv:</b></font></td>
					<td><font size="3" color=blue><i><div id="Kv">---</div></i></font></td>
				</tr>
			</table>
		</div>
		<div style="height:20px"></div>
		<div class="easyui-panel" title="开度计算" style="padding:10px;width:630px;height:200px;">
			<table border="0" width="600px" height="130px">
				<tr>
					<td style="text-align:right"><label for="">流量特性</label></td>
					<td>									
						<select id="flowCharacteristic" class="easyui-combobox" data-options="width:100,panelHeight:100,editable:false">
							<option value="equalPercentage">等百分比</option>
							<option value="linear">直线</option>							
							<option value="squareRoot">平方根</option>
							<option value="modifiedParabolic">抛物线</option>
						</select>
					</td>
					<td style="text-align:right"><label for="adjustableRatio">可调比</label></td>
					<td>
					    <input type="text" id="adjustableRatio" size="12" style="height:20px;border:1px solid #9D9D9D">									
						<select id="adjustableRatioSele" class="easyui-combobox" data-options="width:140,editable:false">
							<option value="1">精小型 JP.JM</option>
							<option value="2">轻小型 P.M</option>
							<option value="3">蝶阀 20</option>
							<option value="4">挠曲阀 100</option>
							<option value="5">VS角形阀 30</option>
							<option value="6">VZ偏心旋转阀 100</option>
							<option value="7">VV球阀 300</option>
							<option value="8">三通阀 10</option>
						</select>
					</td>
				</tr>
				<tr><td colspan="4"><hr/></td></tr>
				<tr>
					<td style="width:60px;text-align:right"><label for="selcetedKv">选用Kv</label></td>
					<td style="width:100px;"><input type="text" id="selcetedKv" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="width:60px;text-align:right"><label for="calculatedKv">计算Kv</label></td>
					<td ><input type="text" id="calculatedKv" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
				<tr style="height:60px">
					<td style="text-align:right"><font size="3" color=blue><b>开度</b></font></td>
					<td><font size="3" color=blue><i><div id="K">---</div></i></font></td>
					<td colspan="2" style="text-align:left">
						<a href="#" class="easyui-linkbutton" onclick="showK()">计 算</a> 
						<a href="#" class="easyui-linkbutton" onclick="resetKCalculation()">重 置</a> 
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#pressureUnit').combobox({
				onSelect:function(record){
					$('#P1Unit').html(record.text);
					$('#P2Unit').html(record.text);
					clearKvCvCalculationInput();
				}
			});
			
			$('#fluidState').combobox({
				onSelect:function(record){
					if(record.text == '液体'){
						$('#QUnit').html('m3/h');
						$('#G').removeAttr("disabled");//去除input元素的disabled属性
						$('#T').attr("disabled","disabled");//将input元素设置为disabled
						$('#overtemperature').attr("disabled","disabled");		
						
						$('#GLabel').css({'color':'black'});
						$('#TLabel').css({'color':'gray'});
						$('#overtemperatureLabel').css({'color':'gray'});
					}						
					else if(record.text == '气体'){
						$('#QUnit').html('m3/h');
						$('#G').removeAttr("disabled");
						$('#T').removeAttr("disabled");
						$('#overtemperature').attr("disabled","disabled");		
						
						$('#GLabel').css({'color':'black'});
						$('#TLabel').css({'color':'black'});
						$('#overtemperatureLabel').css({'color':'gray'});
					}
					else if(record.text == '水蒸汽'){
						$('#QUnit').html('kg/h');
						$('#G').attr("disabled","disabled");		
						//$('#T').attr("disabled","disabled");		
						$('#T').removeAttr("disabled");
						$('#overtemperature').removeAttr("disabled");
						
						$('#GLabel').css({'color':'gray'});
						//$('#TLabel').css({'color':'gray'});
						$('#TLabel').css({'color':'black'});
						$('#overtemperatureLabel').css({'color':'black'});
					}
					clearKvCvCalculationInput();
				}
			});
			
			$('#adjustableRatioSele').combobox({
				onSelect:function(record){
					if(record.text == '精小型 JP.JM'){
						$('#adjustableRatio').val('50');						
					}
					else if(record.text == '轻小型 P.M'){
						$('#adjustableRatio').val('30');
					}
					else if(record.text == '蝶阀 20'){
						$('#adjustableRatio').val('20');
					}
					else if(record.text == '挠曲阀 100'){
						$('#adjustableRatio').val('100');
					}
					else if(record.text == 'VS角形阀 30'){
						$('#adjustableRatio').val('30');
					}
					else if(record.text == 'VZ偏心旋转阀 100'){
						$('#adjustableRatio').val('100');
					}
					else if(record.text == 'VV球阀 300'){
						$('#adjustableRatio').val('300');
					}
					else if(record.text == '三通阀 10'){
						$('#adjustableRatio').val('10');
					}
					else{
						$('#adjustableRatio').val('');
					}
					
				}
			});
			
			$('#fluidState').combobox('select','liquid');
			$('#adjustableRatioSele').combobox('select','1');
		});
	
	
		function showKvCv(){
			var fluidState = $('#fluidState').combobox('getValue');
			var Kv,Cv;
			if(fluidState == "liquid"){
				//alert('1');
				Kv = calculateLiquidKv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#G').val(),$('#pressureUnit').combobox('getValue'));
				Cv = 1.17 * Kv;
			}				
			else if(fluidState == "gas"){
				
				Cv = calculateGasCv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#G').val(),$('#T').val(),$('#pressureUnit').combobox('getValue'));
				//alert(Cv);
				Kv = Cv / 1.17;
			}				
			else if(fluidState == "vaper"){
				Cv = calculateVaperCv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#overtemperature').val(),$('#pressureUnit').combobox('getValue'));
				Kv = Cv / 1.17;
			}				

			//alert(Kv);
			if($.isNumeric(Kv)){				
				$('#Kv').html(Math.round(Kv * 10000) / 10000);
				$('#Cv').html(Math.round(Cv * 10000) / 10000);
				$('#calculatedKv').val(Math.round(Kv * 10000) / 10000);
			}
			else{
				$('#Kv').html('---');
				$('#Cv').html('---');
				$('#calculatedKv').val('');
			}
		}
		
		function resetKvCvCalculation(){
			$('#fluidState').combobox('select','liquid');
			$('#pressureUnit').combobox('select','Kgf/cm2');
		}
		
		function clearKvCvCalculationInput(){
			$('#Q').val('');
			$('#P1').val('');
			$('#P2').val('');
			$('#G').val('');
			$('#T').val('');
			$('#overtemperature').val('');	
			$('#Kv').html('---');
			$('#Cv').html('---');
		}
		
		function showK(){
			var flowCharacteristic = $('#flowCharacteristic').combobox('getValue');
			var K;
			
			if(flowCharacteristic == "equalPercentage")
				K = calculateKByEqualPercentage($('#selcetedKv').val(),$('#calculatedKv').val(),$('#adjustableRatio').val());
			else if(flowCharacteristic == "linear")
				K = calculateKByLinear($('#selcetedKv').val(),$('#calculatedKv').val(),$('#adjustableRatio').val());
			else if(flowCharacteristic == "modifiedParabolic")
				K = calculateKByModifiedParabolic($('#selcetedKv').val(),$('#calculatedKv').val(),$('#adjustableRatio').val());
			else if(flowCharacteristic == "squareRoot")
				K = calculateKBySquareRoot($('#selcetedKv').val(),$('#calculatedKv').val(),$('#adjustableRatio').val());
			
			//alert(K);
			if($.isNumeric(K))		
				$('#K').html((Math.round(K * 100) / 100) + '%');
			else
				$('#K').html('---');
			
		}
		
		function resetKCalculation(){
			//alert('111');
			$('#flowCharacteristic').combobox('select','equalPercentage');
			$('#adjustableRatioSele').combobox('select','1');
			$('#selcetedKv').val('');
			$('#calculatedKv').val('');
			$('#K').html('---');
		}

		function showOvertemperature(){
			//alert($('#P1').val());
			//alert($('#T').val());
			var overtemperature = calculateOvertemperature($('#P1').val(),$('#T').val(),$('#pressureUnit').combobox('getValue'));
			if($.isNumeric(overtemperature))
				$('#overtemperature').val(Math.round(overtemperature * 100) / 100 );
		}
	</script>
</body>
</html>