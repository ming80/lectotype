<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阀位传送器</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="conveyers"></table>
		<div id="editConveyer" class="easyui-window" style="width:500px;height:370px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:400px;height:270px;border:0px solid red">						  
				<tr>
					<td width="60px"><label>型号</label></td>
					<td width="120px">
						<input id="id" type="hidden" />
						<input id="model" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsModel">*</td>
				</tr>
				<tr>
					<td><label>输出信号</label></td>
					<td><input id="outputSignal" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsOutputSignal">*</td>
				</tr>
				<tr>
					<td><label>接口尺寸</label></td>
					<td><input id="connectionSize" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsConnectionSize">*</td>
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
						<a href="#" class="easyui-linkbutton" onclick="$('#editConveyer').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#conveyers').datagrid({
				//title:'介质表维护',
			    url:'queryAllConveyer.action',
			    width:800,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},
					{field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditConveyerWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteConveyer(" + index + ")'>删除</a>]";
			        	}
			        },
			        {field:'model',title:'型号',width:100},
			        {field:'outputSignal',title:'输出信号',width:100},
			        {field:'connectionSize',title:'接口尺寸',width:100},
			        {field:'explosionProof',title:'防爆等级',width:100}
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editConveyer').window('setTitle','添加阀位传送器');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editConveyer').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditConveyerWindow(index){
    		$('#editConveyer').window('setTitle','修改阀位传送器');
    		clearWindow();
    		var row = $('#conveyers').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#model').val(row.model);
    		$('#outputSignal').val(row.outputSignal);
    		$('#connectionSize').val(row.connectionSize);
    		$('#explosionProof').val(row.explosionProof);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editConveyer').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#model').val('');
    		$('#outputSignal').val('');
    		$('#connectionSize').val('×');
    		$('#explosionProof').val('');
    		
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsOutputSignal').html('');
			$('#fieldErrorsConnectionSize').html('');
			$('#fieldErrorsExplosionProof').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addConveyer.action',
					dataType:'json',
					data:{
						model:$('#model').val(),
						outputSignal:$('#outputSignal').val(),
						connectionSize:$('#connectionSize').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsOutputSignal').html('');
						$('#fieldErrorsConnectionSize').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#conveyers').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsOutputSignal = data.fieldErrors.outputSignal;
							var fieldErrorsConnectionSize = data.fieldErrors.connectionSize;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsOutputSignal)
								$('#fieldErrorsOutputSignal').html('<font size=-1 color=red>' + fieldErrorsOutputSignal + '</font>');
							if(fieldErrorsConnectionSize)
								$('#fieldErrorsConnectionSize').html('<font size=-1 color=red>' + fieldErrorsConnectionSize + '</font>');
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
					url:'updateConveyer.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						model:$('#model').val(),
						outputSignal:$('#outputSignal').val(),
						connectionSize:$('#connectionSize').val(),
						explosionProof:$('#explosionProof').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsOutputSignal').html('');
						$('#fieldErrorsConnectionSize').html('');
						$('#fieldErrorsExplosionProof').html('');
						
						if($.isEmptyObject(data)){
							$('#conveyers').datagrid('reload');
							$('#fieldErrorsExplosionProof').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsOutputSignal = data.fieldErrors.outputSignal;
							var fieldErrorsConnectionSize = data.fieldErrors.connectionSize;
							var fieldErrorsExplosionProof = data.fieldErrors.explosionProof;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsOutputSignal)
								$('#fieldErrorsOutputSignal').html('<font size=-1 color=red>' + fieldErrorsOutputSignal + '</font>');
							if(fieldErrorsConnectionSize)
								$('#fieldErrorsConnectionSize').html('<font size=-1 color=red>' + fieldErrorsConnectionSize + '</font>');
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
		
		function deleteConveyer(index){
			var row = $('#conveyers').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.model + "'的阀位传送器型号么?"))
				$.ajax({
					type:'POST',
					url:'deleteConveyer.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#conveyers').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>