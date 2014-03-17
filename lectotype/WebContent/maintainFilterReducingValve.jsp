<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>过滤减压阀</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">		
		<table id="filterReducingValves"></table>
		<div id="editFilterReducingValve" class="easyui-window" style="width:500px;height:370px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:400px;height:150px;border:0px solid red">						  
				<tr>
					<td width="60px"><label>型号</label></td>
					<td width="120px">
						<input id="id" type="hidden" />
						<input id="model" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsModel">*</td>
				</tr>
				<tr>
					<td><label>接口</label></td>
					<td><input id="connection" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsConnection">*</td>
				</tr>
				<tr style="height:50px">
					<td colspan="3" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editFilterReducingValve').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
	$(function(){
		$('#filterReducingValves').datagrid({
			//title:'介质表维护',				     
		    url:'queryAllFilterReducingValve.action',
		    width:800,
		    height:500,
		    rownumbers:true,
		    singleSelect:true,
		    columns:[[
				//{field:'ck',checkbox:true},
				{field:'opration',title:'操作',width:100,			        	
		        	formatter:function(value,row,index){
		        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
		        		return "[<a href=# onclick='showEditFilterReducingValveWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteFilterReducingValve(" + index + ")'>删除</a>]";
		        	}
		        },
		        {field:'model',title:'型号',width:100},
		        {field:'connection',title:'接口',width:100}
		    ]],
		    toolbar:[{
		    	text:'添加',
		    	iconCls:'icon-add',
		    	handler:function(){
		    		$('#editFilterReducingValve').window('setTitle','添加过滤减压阀');
		    		clearWindow();	
		    		$('#operationType').val('add'); //表示是添加操作
		    		$('#editFilterReducingValve').window('open');
		    	}
		    }]	
		});
	});
		
		function showEditFilterReducingValveWindow(index){
    		$('#editFilterReducingValve').window('setTitle','修改过滤减压阀');
    		clearWindow();
    		var row = $('#filterReducingValves').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#model').val(row.model);
    		$('#connection').val(row.connection);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editFilterReducingValve').window('open');
		}
		
		function clearWindow(){	
    		$('#id').val('');
    		$('#model').val('');
    		$('#connection').val('×-φ');
    		
			$('#fieldErrorsModel').html('');
			$('#fieldErrorsConnection').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addFilterReducingValve.action',
					dataType:'json',
					data:{
						model:$('#model').val(),
						connection:$('#connection').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsConnection').html('');
						
						if($.isEmptyObject(data)){
							$('#filterReducingValves').datagrid('reload');
							$('#fieldErrorsConnection').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsConnection = data.fieldErrors.connection;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsConnection)
								$('#fieldErrorsConnection').html('<font size=-1 color=red>' + fieldErrorsConnection + '</font>');				
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			else if($('#operationType').val() == 'update'){
				$.ajax({
					type:'POST',
					url:'updateFilterReducingValve.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						model:$('#model').val(),
						connection:$('#connection').val()
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsModel').html('');
						$('#fieldErrorsConnection').html('');
						
						if($.isEmptyObject(data)){
							$('#filterReducingValves').datagrid('reload');
							$('#fieldErrorsConnection').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsModel = data.fieldErrors.model;
							var fieldErrorsConnection = data.fieldErrors.connection;
							
							if(fieldErrorsModel)
								$('#fieldErrorsModel').html('<font size=-1 color=red>' + fieldErrorsModel + '</font>');
							if(fieldErrorsConnection)
								$('#fieldErrorsConnection').html('<font size=-1 color=red>' + fieldErrorsConnection + '</font>');							
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			}
		}
		
		function deleteFilterReducingValve(index){
			var row = $('#filterReducingValves').datagrid('getRows')[index];
			if(confirm("您确定要删除名称为'" + row.model + "'的过滤减压阀型号么?"))
				$.ajax({
					type:'POST',
					url:'deleteFilterReducingValve.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#filterReducingValves').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>