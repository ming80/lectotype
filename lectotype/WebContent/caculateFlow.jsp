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
						<select id="fluidState" class="easyui-combobox" data-options="width:150,editable:false">
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
				<tr><td colspan="5"><hr/></td></tr>
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
					<td><input type="text" id="T" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
				</tr>
				<tr>
					<td style="text-align:right">出口压力</td>
					<td><input type="text" id="P2" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
					<td style="text-align:left"><div id="P2Unit">Kgf/cm2</div></td>
					<td style="text-align:right">过热温度</td>
					<td><input type="text" id="overtemperature" size="12" style="height:20px;border:1px solid #9D9D9D"></td>
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
					clearInput();
				}
			});					
		});
	
	
		function showKvCv(){
			var fluidState = $('#fluidState').combobox('getValue');
			var Kv,Cv;
			if(fluidState == "liquid"){
				Kv = calculateLiquidKv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#G').val(),$('#pressureUnit').combobox('getValue'));
				Cv = 1.17 * Kv;
			}				
			else if(fluidState == "gas"){
				Cv = calculateGasCv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#G').val(),$('#T').val(),$('#pressureUnit').combobox('getValue'));
				Kv = Cv / 1.17;
			}				
			else if(fluidState == "vaper"){
				Cv = calculateVaperCv($('#Q').val(),$('#P1').val(),$('#P2').val(),$('#overtemperature').val(),$('#pressureUnit').combobox('getValue'));
				Kv = Cv/ 1.17;
			}				

			if($.isNumeric(Kv)){				
				$('#Kv').html(Math.round(Kv * 10000) / 10000);
				$('#Cv').html(Math.round(Cv * 10000) / 10000);
			}
			else{
				$('#Kv').html('---');
				$('#Cv').html('---');
			}
		}
	
		function clearInput(){
			$('#Q').val('');
			$('#P1').val('');
			$('#P2').val('');
			$('#G').val('');
			$('#T').val('');
			$('#overtemperature').val('');	
			$('#Kv').html('---');
			$('#Cv').html('---');
		}
		
		function calculateLiquidKv(Q,P1,P2,G,pressureUnit){
			if(Q == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(G == ''){
				alert('请输入比重!');
				return;
			}			
			
			if(!$.isNumeric(Q)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('比重必须是数字!');
				return;
			}	
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			
			if(numQ <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}				
			if(numG <= 0){
				alert('比重必须大于0!');
				return;
			}						
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}			
			
			return numQ * Math.sqrt(numG / (numP1 - numP2));
		}
		
		function calculateGasCv(Q,P1,P2,G,T,pressureUnit){
			//alert(Q + ',' + P1 + ',' + P2 + ',' + G + ',' + T)
			if(Q == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(G == ''){
				alert('请输入比重!');
				return;
			}	
			if(T == ''){
				alert('请输入流体温度!');
				return;
			}
			
			if(!$.isNumeric(Q)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('比重必须是数字!');
				return;
			}
			if(!$.isNumeric(T)){
				alert('流体温度必须是数字!');
				return;
			}
			
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			var numT = new Number(T);			
			
			if(numQ <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}				
			if(numG <= 0){
				alert('比重必须大于0!');
				return;
			}	
			if(numT <= -273){
				alert('流体温度必须大于-273!');
				return;
			}			
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}
			
			var deltaP = numP1 - numP2;
			if(deltaP < (numP1 / 2))
				return Math.sqrt(numG * (273 + numT) / (deltaP * (numP1 + numP2))) * numQ / 287;
			else
				return Math.sqrt(numG * (273 + numT)) * Q / (249 * P1);							
		}
		
		function calculateVaperCv(W,P1,P2,overT,pressureUnit){
			if(W == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(overT == ''){
				alert('请输入过热温度!');
				return;
			}			
			
			if(!$.isNumeric(W)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}
			if(!$.isNumeric(overT)){
				alert('流体温度必须是数字!');
				return;
			}
			
			var numW = new Number(W);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numOverT = new Number(overT);			
			
			if(numW <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}

			var deltaP = numP1 - numP2;
			if(deltaP < (numP1 / 2))
				return numW * (0.0013 * numOverT + 1) / (Math.sqrt(deltaP * (numP1 + numP2)) * 13.67);
			else{
				var a = numW * (0.0013 * numOverT + 1);
				var b = 11.9 * numP1;				
				alert(a + ',' + b);
				return numW * (0.0013 * numOverT + 1) / (11.9 * numP1);
			}
				
		}
	</script>
</body>
</html>