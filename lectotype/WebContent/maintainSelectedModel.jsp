<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>调节阀</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="selectedModels"></table>
		<div id="editSelectedModel" class="easyui-window" style="width:850px;height:420px;padding:20px"
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:800px;height:340px;border:0px solid red">
				<tr>
					<td width="60px"><label>名称</label></td>
					<td width="120px">
						<input id="id" type="hidden" />
						<input id="name" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsName" width="165px"></td>
					<td width="63px"><label>阀体材质</label></td>
					<td width="120px">
						<input id="bodyMaterial" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsBodyMaterial"></td>
				</tr>
				<tr>
					<td><label>型号</label></td>
					<td>
						<input id="model" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsModel"></td>
					<td><label>阀座材质</label></td>
					<td>
						<input id="seatMaterial" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsSeatMaterial"></td>
				</tr>	
				<tr>
					<td><label>公称通径</label></td>
					<td>
						<input id="diameterNominal" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsDiameterNominal"></td>
					<td><label>阀芯材质</label></td>
					<td>
						<input id="plugMaterial" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsPlugMaterial"></td>
				</tr>	
				<tr>
					<td><label>阀座直径</label></td>
					<td>
						<input id="seatDiameter" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsSeatDiameter"></td>
					<td><label>填料</label></td>
					<td>
						<input id="packing" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsPacking"></td>
				</tr>	
				<tr>
					<td><label>公称压力</label></td>
					<td>
						<input id="nominalPressure" type="text" size="18" style="height:20px;border:1px solid #9D9D9D;" />&nbspMPa
					</td>
					<td id="fieldErrorsNominalPressure"></td>
					<td><label>上阀盖型式</label></td>
					<td>
						<input id="bonnetType" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsBonnetType"></td>
				</tr>	
				<tr>
					<td><label>流开/流闭</label></td>
					<td>
						<select id="flowOpenClose" class="easyui-combobox" data-options="width:162,panelHeight:70,editable:false">
							<option value="default">--请选择--</option>
							<option value="open">开</option>
							<option value="close">闭</option>							
						</select>					
					</td>
					<td id="fieldErrorsFlowOpenClose"></td>
					<td><label>连接法兰</label></td>
					<td>
						<input id="connectionFlange" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsConnectionFlange"></td>
				</tr>	
				<tr>
					<td><label>失气位置</label></td>
					<td>
						<select id="airFail" class="easyui-combobox" data-options="width:162,panelHeight:70,editable:false">
							<option value="default">--请选择--</option>
							<option value="open">开</option>
							<option value="close">关</option>							
						</select>				
					</td>
					<td id="fieldErrorsAirFail"></td>
					<td><label>泄露等级</label></td>
					<td>
						<input id="leakageClass" type="text" size="22" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsLeakageClass"></td>
				</tr>	
				<tr>
					<td><label>流量特性</label></td>
					<td>
						<select id="flowCharacter" class="easyui-combobox" data-options="width:162,panelHeight:130,editable:false">
							<option value="default">--请选择--</option>
							<option value="equalPercentage">等百分比</option>
							<option value="linear">直线</option>	
							<option value="quickOpening">快开</option>							
							<option value="squareRoot">平方根</option>
							<option value="modifiedParabolic">抛物线</option>
						</select>						
					</td>
					<td id="fieldErrorsFlowCharacter" colspan="4"></td>	
				</tr>					
				<tr style="height:50px">
					<td colspan="6" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editSelectedModel').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#selectedModels').datagrid({
				//title:'介质表维护',
			    url:'queryAllSelectedModel.action',
			    width:970,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    frozenColumns:[[
					{field:'opration',title:'操作',width:100,			        	
						formatter:function(value,row,index){
							//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
							return "[<a href=# onclick='showEditSelectedModelWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteSelectedModel(" + index + ")'>删除</a>]";
						}
					}
				]],
			    columns:[[
					//{field:'ck',checkbox:true},	
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
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editSelectedModel').window('setTitle','添加调节阀');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editSelectedModel').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditSelectedModelWindow(index){
    		$('#editSelectedModel').window('setTitle','修改调节阀');
    		clearWindow();
    		var row = $('#selectedModels').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#name').val(row.name);
    		$('#model').val(row.model);
    		$('#diameterNominal').val(row.diameterNominal);
    		$('#seatDiameter').val(row.seatDiameter);
    		$('#nominalPressure').val(row.nominalPressure);
    		
    		if(row.flowOpenClose == 'open')
    			$('#flowOpenClose').combobox('select','open');
    		else if(row.flowOpenClose == 'close')
    			$('#flowOpenClose').combobox('select','close');  

    		if(row.airFail == 'open')
    			$('#airFail').combobox('select','open');
    		else if(row.airFail == 'close')
    			$('#airFail').combobox('select','close'); 

    		if(row.flowCharacter == 'equalPercentage')
    			$('#flowCharacter').combobox('select','equalPercentage');
    		else if(row.flowCharacter == 'linear')
    			$('#flowCharacter').combobox('select','linear'); 
    		else if(row.flowCharacter == 'quickOpening')
    			$('#flowCharacter').combobox('select','quickOpening'); 
    		else if(row.flowCharacter == 'squareRoot')
    			$('#flowCharacter').combobox('select','squareRoot'); 
    		else if(row.flowCharacter == 'modifiedParabolic')
    			$('#flowCharacter').combobox('select','modifiedParabolic'); 
    		    		
    		$('#bodyMaterial').val(row.bodyMaterial);
    		$('#seatMaterial').val(row.seatMaterial);
    		$('#plugMaterial').val(row.plugMaterial);
    		$('#packing').val(row.packing);
    		$('#bonnetType').val(row.bonnetType);
    		$('#connectionFlange').val(row.connectionFlange);
    		$('#leakageClass').val(row.leakageClass);    		
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editSelectedModel').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#name').val('');
    		$('#model').val('');
    		$('#diameterNominal').val('');
    		$('#seatDiameter').val('');
    		$('#nominalPressure').val('');
    		
   			$('#flowOpenClose').combobox('select','default');
			$('#airFail').combobox('select','default'); 
			$('#flowCharacter').combobox('select','default'); 
    		    		
    		$('#bodyMaterial').val('');
    		$('#seatMaterial').val('');
    		$('#plugMaterial').val('');
    		$('#packing').val('');
    		$('#bonnetType').val('');
    		$('#connectionFlange').val('');
    		$('#leakageClass').val(''); 
    		
			$('#fieldErrorsName').html('');
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsDiameterNominal').html('');
			$('#fieldErrorsSeatDiameter').html('');
			$('#fieldErrorsNominalPressure').html('');
			$('#fieldErrorsFlowOpenClose').html('');
			$('#fieldErrorsAirFail').html('');
			$('#fieldErrorsFlowCharacter').html('');
			$('#fieldErrorsBodyMaterial').html('');
			$('#fieldErrorsSeatMaterial').html('');
			$('#fieldErrorsPlugMaterial').html('');
			$('#fieldErrorsPacking').html('');
			$('#fieldErrorsBonnetType').html('');
			$('#fieldErrorsConnectionFlange').html('');
			$('#fieldErrorsLeakageClass').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addSelectedModel.action',
					dataType:'json',
					data:{
						name:$('#name').val(),
						model:$('#model').val(),
						diameterNominal:$('#diameterNominal').val(),
						seatDiameter:$('#seatDiameter').val(),
						nominalPressure:$('#nominalPressure').val(),		    		
						flowOpenClose:$('#flowOpenClose').combobox('getValue'),
						airFail:$('#airFail').combobox('getValue'),
						flowCharacter:$('#flowCharacter').combobox('getValue'),		    		    		
						bodyMaterial:$('#bodyMaterial').val(),
						seatMaterial:$('#seatMaterial').val(),
						plugMaterial:$('#plugMaterial').val(),
						packing:$('#packing').val(),
						bonnetType:$('#bonnetType').val(),
						connectionFlange:$('#connectionFlange').val(),
						leakageClass:$('#leakageClass').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						
						$('#fieldErrorsName').html('');
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsDiameterNominal').html('');
						$('#fieldErrorsSeatDiameter').html('');
						$('#fieldErrorsNominalPressure').html('');
						$('#fieldErrorsFlowOpenClose').html('');
						$('#fieldErrorsAirFail').html('');
						$('#fieldErrorsFlowCharacter').html('');
						$('#fieldErrorsBodyMaterial').html('');
						$('#fieldErrorsSeatMaterial').html('');
						$('#fieldErrorsPlugMaterial').html('');
						$('#fieldErrorsPacking').html('');
						$('#fieldErrorsBonnetType').html('');
						$('#fieldErrorsConnectionFlange').html('');
						$('#fieldErrorsLeakageClass').html('');
						
						if($.isEmptyObject(data)){
							$('#selectedModels').datagrid('reload');
							$('#fieldErrorsLeakageClass').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsName = data.fieldErrors.name;
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsDiameterNominal = data.fieldErrors.diameterNominal;
							var fieldErrorsSeatDiameter = data.fieldErrors.seatDiameter;
							var fieldErrorsNominalPressure = data.fieldErrors.nominalPressure;
							var fieldErrorsFlowOpenClose = data.fieldErrors.flowOpenClose;
							var fieldErrorsAirFail = data.fieldErrors.airFail;
							var fieldErrorsFlowCharacter = data.fieldErrors.flowCharacter;
							var fieldErrorsBodyMaterial = data.fieldErrors.bodyMaterial;
							var fieldErrorsSeatMaterial = data.fieldErrors.seatMaterial;
							var fieldErrorsPlugMaterial = data.fieldErrors.plugMaterial;
							var fieldErrorsPacking = data.fieldErrors.packing;
							var fieldErrorsBonnetType = data.fieldErrors.bonnetType;
							var fieldErrorsConnectionFlange = data.fieldErrors.connectionFlange;
							var fieldErrorsLeakageClass = data.fieldErrors.leakageClass;
							
							if(fieldErrorsName)
								$('#fieldErrorsName').html('<font size=-1 color=red>' + fieldErrorsName + '</font>');
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsDiameterNominal)
								$('#fieldErrorsDiameterNominal').html('<font size=-1 color=red>' + fieldErrorsDiameterNominal + '</font>');
							if(fieldErrorsSeatDiameter)
								$('#fieldErrorsSeatDiameter').html('<font size=-1 color=red>' + fieldErrorsSeatDiameter + '</font>');
							if(fieldErrorsNominalPressure)
								$('#fieldErrorsNominalPressure').html('<font size=-1 color=red>' + fieldErrorsNominalPressure + '</font>');
							if(fieldErrorsFlowOpenClose)
								$('#fieldErrorsFlowOpenClose').html('<font size=-1 color=red>' + fieldErrorsFlowOpenClose + '</font>');
							if(fieldErrorsAirFail)
								$('#fieldErrorsAirFail').html('<font size=-1 color=red>' + fieldErrorsAirFail + '</font>');
							if(fieldErrorsFlowCharacter)
								$('#fieldErrorsFlowCharacter').html('<font size=-1 color=red>' + fieldErrorsFlowCharacter + '</font>');
							if(fieldErrorsBodyMaterial)
								$('#fieldErrorsBodyMaterial').html('<font size=-1 color=red>' + fieldErrorsBodyMaterial + '</font>');
							if(fieldErrorsSeatMaterial)
								$('#fieldErrorsSeatMaterial').html('<font size=-1 color=red>' + fieldErrorsSeatMaterial + '</font>');
							if(fieldErrorsPlugMaterial)
								$('#fieldErrorsPlugMaterial').html('<font size=-1 color=red>' + fieldErrorsPlugMaterial + '</font>');
							if(fieldErrorsPacking)
								$('#fieldErrorsPacking').html('<font size=-1 color=red>' + fieldErrorsPacking + '</font>');
							if(fieldErrorsBonnetType)
								$('#fieldErrorsBonnetType').html('<font size=-1 color=red>' + fieldErrorsBonnetType + '</font>');
							if(fieldErrorsConnectionFlange)
								$('#fieldErrorsConnectionFlange').html('<font size=-1 color=red>' + fieldErrorsConnectionFlange + '</font>');
							if(fieldErrorsLeakageClass)
								$('#fieldErrorsLeakageClass').html('<font size=-1 color=red>' + fieldErrorsLeakageClass + '</font>');
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			else if($('#operationType').val() == 'update'){
				//alert($('#id').val());
				$.ajax({
					type:'POST',
					url:'updateSelectedModel.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						name:$('#name').val(),
						model:$('#model').val(),
						diameterNominal:$('#diameterNominal').val(),
						seatDiameter:$('#seatDiameter').val(),
						nominalPressure:$('#nominalPressure').val(),		    		
						flowOpenClose:$('#flowOpenClose').combobox('getValue'),
						airFail:$('#airFail').combobox('getValue'),
						flowCharacter:$('#flowCharacter').combobox('getValue'),		    		    		
						bodyMaterial:$('#bodyMaterial').val(),
						seatMaterial:$('#seatMaterial').val(),
						plugMaterial:$('#plugMaterial').val(),
						packing:$('#packing').val(),
						bonnetType:$('#bonnetType').val(),
						connectionFlange:$('#connectionFlange').val(),
						leakageClass:$('#leakageClass').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						
						$('#fieldErrorsName').html('');
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsDiameterNominal').html('');
						$('#fieldErrorsSeatDiameter').html('');
						$('#fieldErrorsNominalPressure').html('');
						$('#fieldErrorsFlowOpenClose').html('');
						$('#fieldErrorsAirFail').html('');
						$('#fieldErrorsFlowCharacter').html('');
						$('#fieldErrorsBodyMaterial').html('');
						$('#fieldErrorsSeatMaterial').html('');
						$('#fieldErrorsPlugMaterial').html('');
						$('#fieldErrorsPacking').html('');
						$('#fieldErrorsBonnetType').html('');
						$('#fieldErrorsConnectionFlange').html('');
						$('#fieldErrorsLeakageClass').html('');
						
						if($.isEmptyObject(data)){
							$('#selectedModels').datagrid('reload');
							$('#fieldErrorsLeakageClass').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsName = data.fieldErrors.name;
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsDiameterNominal = data.fieldErrors.diameterNominal;
							var fieldErrorsSeatDiameter = data.fieldErrors.seatDiameter;
							var fieldErrorsNominalPressure = data.fieldErrors.nominalPressure;
							var fieldErrorsFlowOpenClose = data.fieldErrors.flowOpenClose;
							var fieldErrorsAirFail = data.fieldErrors.airFail;
							var fieldErrorsFlowCharacter = data.fieldErrors.flowCharacter;
							var fieldErrorsBodyMaterial = data.fieldErrors.bodyMaterial;
							var fieldErrorsSeatMaterial = data.fieldErrors.seatMaterial;
							var fieldErrorsPlugMaterial = data.fieldErrors.plugMaterial;
							var fieldErrorsPacking = data.fieldErrors.packing;
							var fieldErrorsBonnetType = data.fieldErrors.bonnetType;
							var fieldErrorsConnectionFlange = data.fieldErrors.connectionFlange;
							var fieldErrorsLeakageClass = data.fieldErrors.leakageClass;
							
							if(fieldErrorsName)
								$('#fieldErrorsName').html('<font size=-1 color=red>' + fieldErrorsName + '</font>');
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsDiameterNominal)
								$('#fieldErrorsDiameterNominal').html('<font size=-1 color=red>' + fieldErrorsDiameterNominal + '</font>');
							if(fieldErrorsSeatDiameter)
								$('#fieldErrorsSeatDiameter').html('<font size=-1 color=red>' + fieldErrorsSeatDiameter + '</font>');
							if(fieldErrorsNominalPressure)
								$('#fieldErrorsNominalPressure').html('<font size=-1 color=red>' + fieldErrorsNominalPressure + '</font>');
							if(fieldErrorsFlowOpenClose)
								$('#fieldErrorsFlowOpenClose').html('<font size=-1 color=red>' + fieldErrorsFlowOpenClose + '</font>');
							if(fieldErrorsAirFail)
								$('#fieldErrorsAirFail').html('<font size=-1 color=red>' + fieldErrorsAirFail + '</font>');
							if(fieldErrorsFlowCharacter)
								$('#fieldErrorsFlowCharacter').html('<font size=-1 color=red>' + fieldErrorsFlowCharacter + '</font>');
							if(fieldErrorsBodyMaterial)
								$('#fieldErrorsBodyMaterial').html('<font size=-1 color=red>' + fieldErrorsBodyMaterial + '</font>');
							if(fieldErrorsSeatMaterial)
								$('#fieldErrorsSeatMaterial').html('<font size=-1 color=red>' + fieldErrorsSeatMaterial + '</font>');
							if(fieldErrorsPlugMaterial)
								$('#fieldErrorsPlugMaterial').html('<font size=-1 color=red>' + fieldErrorsPlugMaterial + '</font>');
							if(fieldErrorsPacking)
								$('#fieldErrorsPacking').html('<font size=-1 color=red>' + fieldErrorsPacking + '</font>');
							if(fieldErrorsBonnetType)
								$('#fieldErrorsBonnetType').html('<font size=-1 color=red>' + fieldErrorsBonnetType + '</font>');
							if(fieldErrorsConnectionFlange)
								$('#fieldErrorsConnectionFlange').html('<font size=-1 color=red>' + fieldErrorsConnectionFlange + '</font>');
							if(fieldErrorsLeakageClass)
								$('#fieldErrorsLeakageClass').html('<font size=-1 color=red>' + fieldErrorsLeakageClass + '</font>');
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			}
		}
		
		function deleteSelectedModel(index){
			var row = $('#selectedModels').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.name + "'的调节阀型号么?"))
				$.ajax({
					type:'POST',
					url:'deleteSelectedModel.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#selectedModels').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>