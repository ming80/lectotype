<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>定位器</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="actuators"></table>
		<div id="editPositioner" class="easyui-window" style="width:500px;height:320px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:400px;height:230px;border:0px solid red">						  
				<tr>
					<td width="60px"><label>型号</label></td>
					<td width="120px">
						<input id="id" type="hidden" />
						<input id="model" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsModel">*</td>
				</tr>
				<tr>
					<td><label>输入信号</label></td>
					<td><input id="inputSignal" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsInputSignal">*</td>
				</tr>
				<tr>
					<td><label>供气压力</label></td>
					<td><input id="airPressure" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAirPressure">*</td>
				</tr>
				<tr>
					<td><label>信号接口</label></td>
					<td><input id="signalConnection" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsSignalConnection">*</td>
				</tr>
				<tr>
					<td><label>气接口尺寸</label></td>
					<td><input id="airConnectionSize" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAirConnectionSize">*</td>
				</tr>
				<tr>
					<td><label>防爆等级</label></td>
					<td><input id="explosionProof" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsExplosionProof">*</td>
				</tr>
				<tr style="height:50px">
					<td colspan="3" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editPositioner').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#positioners').datagrid({
				//title:'介质表维护',
			    url:'queryAllPositioner.action',
			    width:800,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},
					{field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditPositionerWindow(" + index + ")'>修改</a>] [<a href=# onclick='deletePositioner(" + index + ")'>删除</a>]";
			        	}
			        },
			        {field:'model',title:'型号',width:100},
			        {field:'inputSignal',title:'输入信号',width:100},
			        {field:'airPressure',title:'供气压力',width:100},
			        {field:'signalConnection',title:'信号接口',width:100},
			        {field:'airConnectionSize',title:'气接口尺寸',width:100},
			        {field:'explosionProof',title:'防爆等级',width:100}
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editPositioner').window('setTitle','添加定位器');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editPositioner').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditPositionerWindow(index){
    		$('#editPositioner').window('setTitle','修改定位器');
    		clearWindow();
    		var row = $('#positioners').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#model').val(row.model);
    		$('#inputSignal').val(row.inputSignal);
    		$('#airPressure').val(row.airPressure);
    		$('#signalConnection').val(row.signalConnection);
    		$('#airConnectionSize').val(row.airConnectionSize);
    		$('#explosionProof').val(row.explosionProof);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editPositioner').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#model').val('');
    		$('#inputSignal').val('');
    		$('#airPressure').val('');
    		$('#signalConnection').val('');
    		$('#airConnectionSize').val('');
    		$('#explosionProof').val('');
    		
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsInputSignal').html('');
			$('#fieldErrorsAirPressure').html('');
			$('#fieldErrorsSignalConnection').html('');
			$('#fieldErrorsAirConnectionSize').html('');
			$('#fieldErrorsExplosionProof').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addPositioner.action',
					dataType:'json',
					data:{
						model:$('#model').val(),
						inputSignal:$('#inputSignal').val(),
						airPressure:$('#airPressure').val(),
						signalConnection:$('#signalConnection').val(),
						airConnectionSize:$('#airConnectionSize').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsInputSignal').html('');
						$('#fieldErrorsAirPressure').html('');
						$('#fieldErrorsSignalConnection').html('');
						$('#fieldErrorsAirConnectionSize').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#positioners').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsInputSignal = data.fieldErrors.inputSignal;
							var fieldErrorsAirPressure = data.fieldErrors.airPressure;
							var fieldErrorsSignalConnection = data.fieldErrors.signalConnection;
							var fieldErrorsAirConnectionSize = data.fieldErrors.airConnectionSize;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsInputSignal)
								$('#fieldErrorsInputSignal').html('<font size=-1 color=red>' + fieldErrorsInputSignal + '</font>');
							if(fieldErrorsAirPressure)
								$('#fieldErrorsAirPressure').html('<font size=-1 color=red>' + fieldErrorsAirPressure + '</font>');
							if(fieldErrorsSignalConnection)
								$('#fieldErrorsSignalConnection').html('<font size=-1 color=red>' + fieldErrorsSignalConnection + '</font>');
							if(fieldErrorsAirConnectionSize)
								$('#fieldErrorsAirConnectionSize').html('<font size=-1 color=red>' + fieldErrorsAirConnectionSize + '</font>');
							if(fieldErrorsExplosionProof)
								$('#fieldErrorsExplosionProof').html('<font size=-1 color=red>' + fieldErrorsExplosionProof + '</font>');						
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			else if($('#operationType').val() == 'update'){
				$.ajax({
					type:'POST',
					url:'updatePositioner.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						model:$('#model').val(),
						inputSignal:$('#inputSignal').val(),
						airPressure:$('#airPressure').val(),
						signalConnection:$('#signalConnection').val(),
						airConnectionSize:$('#airConnectionSize').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsInputSignal').html('');
						$('#fieldErrorsAirPressure').html('');
						$('#fieldErrorsSignalConnection').html('');
						$('#fieldErrorsAirConnectionSize').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#positioners').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsInputSignal = data.fieldErrors.inputSignal;
							var fieldErrorsAirPressure = data.fieldErrors.airPressure;
							var fieldErrorsSignalConnection = data.fieldErrors.signalConnection;
							var fieldErrorsAirConnectionSize = data.fieldErrors.airConnectionSize;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsInputSignal)
								$('#fieldErrorsInputSignal').html('<font size=-1 color=red>' + fieldErrorsInputSignal + '</font>');
							if(fieldErrorsAirPressure)
								$('#fieldErrorsAirPressure').html('<font size=-1 color=red>' + fieldErrorsAirPressure + '</font>');
							if(fieldErrorsSignalConnection)
								$('#fieldErrorsSignalConnection').html('<font size=-1 color=red>' + fieldErrorsSignalConnection + '</font>');
							if(fieldErrorsAirConnectionSize)
								$('#fieldErrorsAirConnectionSize').html('<font size=-1 color=red>' + fieldErrorsAirConnectionSize + '</font>');
							if(fieldErrorsExplosionProof)
								$('#fieldErrorsExplosionProof').html('<font size=-1 color=red>' + fieldErrorsExplosionProof + '</font>');
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			}
		}
		
		function deletePositioner(index){
			var row = $('#positioners').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.model + "'的定位器型号么?"))
				$.ajax({
					type:'POST',
					url:'deletePositioner.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#positioners').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>