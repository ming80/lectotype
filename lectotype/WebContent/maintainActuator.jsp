<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>执行机构</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="actuators"></table>
		<div id="editActuator" class="easyui-window" style="width:500px;height:320px;padding:20px" 
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
					<td><label>动作形式</label></td>
					<td><input id="action" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAction">*</td>
				</tr>
				<tr>
					<td><label>弹簧范围</label></td>
					<td><input id="springRange" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsSpringRange">*</td>
				</tr>
				<tr>
					<td><label>供气压力</label></td>
					<td><input id="airPressure" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAirPressure">*</td>
				</tr>
				<tr>
					<td><label>气源接头</label></td>
					<td><input id="airConnection" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAirConnection">*</td>
				</tr>
				<tr style="height:50px">
					<td colspan="3" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editActuator').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#actuators').datagrid({
				//title:'介质表维护',
			    url:'queryAllActuator.action',
			    width:800,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},
					{field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditActuatorWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteActuator(" + index + ")'>删除</a>]";
			        	}
			        },
			        {field:'model',title:'型号',width:100},
			        {field:'action',title:'动作形式',width:100},
			        {field:'springRange',title:'弹簧范围',width:100},
			        {field:'airPressure',title:'供气压力',width:100},
			        {field:'airConnection',title:'气源接头',width:100}
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editActuator').window('setTitle','添加执行机构');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editActuator').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditActuatorWindow(index){
    		$('#editActuator').window('setTitle','修改执行机构');
    		clearWindow();
    		var row = $('#actuators').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#model').val(row.model);
    		$('#action').val(row.action);
    		$('#springRange').val(row.springRange);
    		$('#airPressure').val(row.airPressure);
    		$('#airConnection').val(row.airConnection);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editActuator').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#model').val('');
    		$('#action').val('');
    		$('#springRange').val('');
    		$('#airPressure').val('');
    		$('#airConnection').val('-φ');
    		
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsAction').html('');
			$('#fieldErrorsSpringRange').html('');
			$('#fieldErrorsAirPressure').html('');
			$('#fieldErrorsAirConnection').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addActuator.action',
					dataType:'json',
					data:{
						model:$('#model').val(),
						action:$('#action').val(),
						springRange:$('#springRange').val(),
						airPressure:$('#airPressure').val(),
						airConnection:$('#airConnection').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsAction').html('');
						$('#fieldErrorsSpringRange').html('');
						$('#fieldErrorsAirPressure').html('');
						$('#fieldErrorsAirConnection').html('');
						
						if($.isEmptyObject(data)){
							$('#actuators').datagrid('reload');
							$('#fieldErrorsAirConnection').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsAction = data.fieldErrors.action;
							var fieldErrorsSpringRange = data.fieldErrors.springRange;
							var fieldErrorsAirPressure = data.fieldErrors.airPressure;
							var fieldErrorsAirConnection = data.fieldErrors.airConnection;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsAction)
								$('#fieldErrorsAction').html('<font size=-1 color=red>' + fieldErrorsAction + '</font>');
							if(fieldErrorsSpringRange)
								$('#fieldErrorsSpringRange').html('<font size=-1 color=red>' + fieldErrorsSpringRange + '</font>');
							if(fieldErrorsAirPressure)
								$('#fieldErrorsAirPressure').html('<font size=-1 color=red>' + fieldErrorsAirPressure + '</font>');
							if(fieldErrorsAirConnection)
								$('#fieldErrorsAirConnection').html('<font size=-1 color=red>' + fieldErrorsAirConnection + '</font>');

						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			else if($('#operationType').val() == 'update'){
				$.ajax({
					type:'POST',
					url:'updateActuator.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						model:$('#model').val(),
						action:$('#action').val(),
						springRange:$('#springRange').val(),
						airPressure:$('#airPressure').val(),
						airConnection:$('#airConnection').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsAction').html('');
						$('#fieldErrorsSpringRange').html('');
						$('#fieldErrorsAirPressure').html('');
						$('#fieldErrorsAirConnection').html('');
						
						if($.isEmptyObject(data)){
							$('#actuators').datagrid('reload');
							$('#fieldErrorsAirConnection').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsAction = data.fieldErrors.action;
							var fieldErrorsSpringRange = data.fieldErrors.springRange;
							var fieldErrorsAirPressure = data.fieldErrors.airPressure;
							var fieldErrorsAirConnection = data.fieldErrors.airConnection;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsAction)
								$('#fieldErrorsAction').html('<font size=-1 color=red>' + fieldErrorsAction + '</font>');
							if(fieldErrorsSpringRange)
								$('#fieldErrorsSpringRange').html('<font size=-1 color=red>' + fieldErrorsSpringRange + '</font>');
							if(fieldErrorsAirPressure)
								$('#fieldErrorsAirPressure').html('<font size=-1 color=red>' + fieldErrorsAirPressure + '</font>');
							if(fieldErrorsAirConnection)
								$('#fieldErrorsAirConnection').html('<font size=-1 color=red>' + fieldErrorsAirConnection + '</font>');

						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			}
		}
		
		function deleteActuator(index){
			var row = $('#actuators').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.model + "'的介质么?"))
				$.ajax({
					type:'POST',
					url:'deleteActuator.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#actuators').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>