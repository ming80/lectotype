<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>介质</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="fluids"></table>
		<div id="editFluid" class="easyui-window" style="width:500px;height:300px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:300px;height:200px;border:0px solid red">						  
				<tr>
					<td><label>介质名称</label></td>
					<td>
						<input id="id" type="hidden" />
						<input id="name" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
				</tr>
				<tr>
					<td><label>介质状态</label></td>
					<td><input id="state" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
				</tr>
				<tr>
					<td><label>密度</label></td>
					<td><input id="density" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
				</tr>
				<tr>
					<td><label>比重</label></td>
					<td><input id="sg" type="text" style="height:20px;border:1px solid #9D9D9D" /></td>
				</tr>
				<tr style="height:50px">
					<td colspan="2" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editFluid').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#fluids').datagrid({
				//title:'介质表维护',
			    url:'queryAllFluid.action',
			    width:600,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},	
			        {field:'name',title:'介质名称',width:100},
			        {field:'state',title:'介质状态',width:100},
			        {field:'density',title:'密度',width:100},
			        {field:'sg',title:'比重',width:100},
			        {field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditFluidWindow(" + index + ")'>修改</a>] [删除]";
			        	}
			        }
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editFluid').window('setTitle','添加介质');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editFluid').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditFluidWindow(index){
    		$('#editFluid').window('setTitle','修改介质');
    		clearWindow();
    		var row = $('#fluids').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#name').val(row.name);
    		$('#state').val(row.state);
    		$('#density').val(row.density);
    		$('#sg').val(row.sg);
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editFluid').window('open');
		}
		
		function clearWindow(){
			$('#id').val('');
    		$('#name').val('');
    		$('#state').val('');
    		$('#density').val('');
    		$('#sg').val('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addFluid.action',
					dataType:'json',
					data:{
						name:$('#name').val(),
						state:$('#state').val(),
						density:$('#density').val(),
						sg:$('#sg').val()
					},
					success:function(data){
						alert('1');
						alert(JSON.stringify(data));
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			//else if($('#operationType').val() == 'update')
		}
	</script>

</body>
</html>