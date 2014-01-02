<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>流量计算</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<div class="easyui-panel" title="Kv/Cv计算" style="padding:10px;width:600px;height:250px;">
			<table border="0" width="480px" height="200px">
				<tr>
					<td style="text-align:right">介质选择</td>
					<td colspan="2">									
						<select id="" class="easyui-combobox" data-options="width:150,editable:false">
							<option value="liquid">液体</option>
							<option value="gas">气体</option>
							<option value="vaper">水蒸汽</option>
						</select>
					</td>
					<td style="text-align:right">压力单位</td>
					<td>									
						<select id="pressureUnit" class="easyui-combobox" data-options="width:105,editable:false">
							<option value="Kgf/cm2">Kgf/cm2</option>
							<option value="MPa">MPa</option>
							<option value="KPa">KPa</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:60px;text-align:right">最大流量</td>
					<td style="width:100px;"><input type="text" id="Q" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="width:60px;text-align:left">m3/h</td>
					<td style="width:60px;text-align:right">比重</td>
					<td><input type="text" id="G" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
				<tr>
					<td style="text-align:right">进口压力</td>
					<td><input type="text" id="P1" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="text-align:left"><div id="P1Unit">Kgf/cm2</div></td>
					<td style="text-align:right">流体温度</td>
					<td><input type="text" id="" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
				<tr>
					<td style="text-align:right">出口压力</td>
					<td><input type="text" id="P2" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="text-align:left"><div id="P2Unit">Kgf/cm2</div></td>
					<td style="text-align:right">过热温度</td>
					<td><input type="text" id="" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
				<tr>
					<td style="text-align:right"><font size="3" color=blue><b>Cv:</b></font></td>
					<td><font size="3" color=blue><i><div id="Cv">---</div></i></font></td>
					<td colspan="3" rowspan="2" style="text-align:center">
						<a href="#" class="easyui-linkbutton" onclick="showKvCv()">计 算</a> 
						<a href="#" class="easyui-linkbutton" onclick="">重 置</a> 
					</td>
				</tr>
				<tr>
					<td style="text-align:right"><font size="3" color=blue><b>Kv:</b></font></td>
					<td><font size="3" color=blue><i><div id="Kv">---</div></i></font></td>
				</tr>
			</table>
		</div>
		<div style="height:20px"></div>
		<div class="easyui-panel" title="开度计算" style="padding:10px;width:500px;height:150px;">
		222
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#pressureUnit').combobox({
				onSelect:function(record){
					$('#P1Unit').html(record.text);
					$('#P2Unit').html(record.text);
				}
			});					
		});
	
	
		function showKvCv(){
			var Kv = calculateLiquidKv();
			var Cv = 1.17 * Kv;
			if($.isNumeric(Kv)){
				$('#Kv').html(Kv);
				$('#Cv').html(Cv);
			}
			else{
				$('#Kv').html('---');
				$('#Cv').html('---');
			}
		}
	
		function calculateLiquidKv(){
			var Q = $('#Q').val();
			var P1 = $('#P1').val();
			var P2 = $('#P2').val();
			var G = $('#G').val();
			
			var pressureUnit = $('#pressureUnit').combobox('getValue');
			if(pressureUnit == 'MPa'){
				P1 = P1 * 10;
				P2 = P2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				P1 = P1 / 100;
				P2 = P2 / 100;
			}			
			
			return Q * Math.sqrt(G / (P1 - P2));
		}
	</script>
</body>
</html>