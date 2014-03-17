<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电池阀</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="solenoids"></table>
		<div id="editSolenoid" class="easyui-window" style="width:500px;height:370px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:400px;height:270px;border:0px solid red">						  
				<tr>
					<td width="70px"><label>型号</label></td>
					<td width="120px">
						<input id="id" type="hidden" />
						<input id="model" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsModel">*</td>
				</tr>
				<tr>
					<td><label>电源电压</label></td>
					<td><input id="supplyPower" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsSupplyPower">*</td>
				</tr>
				<tr>
					<td><label>电源接口</label></td>
					<td><input id="powerConnection" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsPowerConnection">*</td>
				</tr>
				<tr>
					<td><label>气接口尺寸</label></td>
					<td><input id="airConnection" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsAirConnection">*</td>
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
						<a href="#" class="easyui-linkbutton" onclick="$('#editSolenoid').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#solenoids').datagrid({
				//title:'介质表维护',
			    url:'queryAllSolenoid.action',
			    width:800,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},
					{field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditSolenoidWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteSolenoid(" + index + ")'>删除</a>]";
			        	}
			        },
			        {field:'model',title:'型号',width:100},
			        {field:'supplyPower',title:'电源电压',width:100},
			        {field:'powerConnection',title:'电源接口',width:100},
			        {field:'airConnection',title:'气接口尺寸',width:100},
			        {field:'explosionProof',title:'防爆等级',width:100}
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editSolenoid').window('setTitle','添加电池阀');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editSolenoid').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditSolenoidWindow(index){
    		$('#editSolenoid').window('setTitle','修改电池阀');
    		clearWindow();
    		var row = $('#solenoids').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#model').val(row.model);
    		$('#supplyPower').val(row.supplyPower);
    		$('#powerConnection').val(row.powerConnection);
    		$('#airConnection').val(row.airConnection);
    		$('#explosionProof').val(row.explosionProof);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editSolenoid').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#model').val('');
    		$('#supplyPower').val('');
    		$('#powerConnection').val('');
    		$('#airConnection').val('');
    		$('#explosionProof').val('');
    		
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsSupplyPower').html('');
			$('#fieldErrorsPowerConnection').html('');
			$('#fieldErrorsAirConnection').html('');
			$('#fieldErrorsExplosionProof').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addSolenoid.action',
					dataType:'json',
					data:{
						model:$('#model').val(),
						supplyPower:$('#supplyPower').val(),
						powerConnection:$('#powerConnection').val(),
						airConnection:$('#airConnection').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsSupplyPower').html('');
						$('#fieldErrorsPowerConnection').html('');
						$('#fieldErrorsAirConnection').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#solenoids').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsSupplyPower = data.fieldErrors.supplyPower;
							var fieldErrorsPowerConnection = data.fieldErrors.powerConnection;
							var fieldErrorsAirConnection = data.fieldErrors.airConnection;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsSupplyPower)
								$('#fieldErrorsSupplyPower').html('<font size=-1 color=red>' + fieldErrorsSupplyPower + '</font>');
							if(fieldErrorsPowerConnection)
								$('#fieldErrorsPowerConnection').html('<font size=-1 color=red>' + fieldErrorsPowerConnection + '</font>');
							if(fieldErrorsAirConnection)
								$('#fieldErrorsAirConnection').html('<font size=-1 color=red>' + fieldErrorsAirConnection + '</font>');
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
					url:'updateSolenoid.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						model:$('#model').val(),
						supplyPower:$('#supplyPower').val(),
						powerConnection:$('#powerConnection').val(),
						airConnection:$('#airConnection').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsSupplyPower').html('');
						$('#fieldErrorsPowerConnection').html('');
						$('#fieldErrorsAirConnection').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#solenoids').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsSupplyPower = data.fieldErrors.supplyPower;
							var fieldErrorsPowerConnection = data.fieldErrors.powerConnection;
							var fieldErrorsAirConnection = data.fieldErrors.airConnection;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsSupplyPower)
								$('#fieldErrorsSupplyPower').html('<font size=-1 color=red>' + fieldErrorsSupplyPower + '</font>');
							if(fieldErrorsPowerConnection)
								$('#fieldErrorsPowerConnection').html('<font size=-1 color=red>' + fieldErrorsPowerConnection + '</font>');
							if(fieldErrorsAirConnection)
								$('#fieldErrorsAirConnection').html('<font size=-1 color=red>' + fieldErrorsAirConnection + '</font>');
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
		
		function deleteSolenoid(index){
			var row = $('#solenoids').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.model + "'的电池阀型号么?"))
				$.ajax({
					type:'POST',
					url:'deleteSolenoid.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#solenoids').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>