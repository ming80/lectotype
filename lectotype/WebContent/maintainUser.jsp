<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工帐号</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div style="padding:10px">	
		<table id="users"></table>
		<div id="editUser" class="easyui-window" style="width:500px;height:350px;padding:20px" 
				data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<table style="margin:0 auto;width:400px;height:250px;border:0px solid red">						  
				<tr>
					<td width="60px"><label>员工编号</label></td>
					<td width="120px">
						<input id="id" type="text" style="height:20px;border:1px solid #9D9D9D" />						
					</td>
					<td id="fieldErrorsId">*</td>
				</tr>
				<tr>
					<td><label>姓名</label></td>
					<td><input id="name" type="text" style="height:20px;border:1px solid #9D9D9D"/>
					</td>
					<td id="fieldErrorsName">*</td>
				</tr>
				<tr>
					<td><label>密码</label></td>
					<td><input id="password" type="password" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsPassword">*</td>
				</tr>
				<tr>
					<td><label>重复密码</label></td>
					<td><input id="repeatPassword" type="password" style="height:20px;border:1px solid #9D9D9D" /></td>
					<td id="fieldErrorsRepeatPassword">*</td>
				</tr>
				<tr>
					<td><label>角色权限</label></td>
					<td>
						<select id="role" class="easyui-combobox" data-options="width:150,panelHeight:90,editable:false">
							<option value="default">--请选择--</option>
							<option value="admin">系统管理员</option>
							<option value="technician">技术员</option>	
							<option value="salesman">销售员</option>							
						</select>					
					<td id="fieldErrorsRole">*</td>
				</tr>
				<tr style="height:50px">
					<td colspan="3" style="text-align:center">
						<input id="operationType" type="hidden" /> <!-- [add|update] 新建或者更新  -->
						<a href="#" class="easyui-linkbutton" onclick="save()">保  存</a>&nbsp&nbsp&nbsp   
						<a href="#" class="easyui-linkbutton" onclick="$('#editUser').window('close');">关  闭</a>
					</td>
				</tr>
			</table>			
		</div>		
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#users').datagrid({
				//title:'介质表维护',
			    url:'queryAllUser.action',
			    width:600,
			    height:500,
			    rownumbers:true,
			    singleSelect:true,
			    columns:[[
					//{field:'ck',checkbox:true},
					{field:'opration',title:'操作',width:100,			        	
			        	formatter:function(value,row,index){
			        		//alert("[<a href=# onclick='showEditFluidWindow(row)'>修改</a>] [删除]");
			        		return "[<a href=# onclick='showEditUserWindow(" + index + ")'>修改</a>] [<a href=# onclick='deleteUser(" + index + ")'>删除</a>]";
			        	}
			        },
			        {field:'id',title:'员工编号',width:100},
			        {field:'name',title:'姓名',width:100},
			        {field:'pw',title:'密码',width:100,
			        	formatter:function(value){
							return '******';
		                }	
			        },
			        {field:'role',title:'角色权限',width:100,
			        	formatter:function(value){
							if(!value)
								return '';
							
							if(value == '1')
								return '系统管理员';
							else if(value == '2')
								return '技术员';
							else if(value == '3')
								return '销售员';
		                }
			        }
			    ]],
			    toolbar:[{
			    	text:'添加',
			    	iconCls:'icon-add',
			    	handler:function(){
			    		$('#editUser').window('setTitle','添加员工');
			    		clearWindow();	
			    		$('#operationType').val('add'); //表示是添加操作
			    		$('#editUser').window('open');
			    	}
			    }]	
			});
		});
		
		function showEditUserWindow(index){
    		$('#editUser').window('setTitle','修改员工');
    		clearWindow();
    		var row = $('#users').datagrid('getRows')[index];
    		
    		$('#id').val(row.id);
    		$('#name').val(row.name);    		
    		
    		if(row.role == '1')
    			$('#role').combobox('select','admin');
    		else if(row.role == '2')
    			$('#role').combobox('select','technician');  
    		else if(row.role == '3')
    			$('#role').combobox('select','salesman'); 
    		
    		$('#operationType').val('update');	//表示是更新操作
    		$('#editUser').window('open');
		}
		
		function clearWindow(){			
			$('#id').val('');
    		$('#name').val('');
    		$('#password').val('');
    		$('#repeatPassword').val('');
    		$('#role').combobox('select','default');
    		
			$('#fieldErrorsId').html('');
			$('#fieldErrorsName').html('');
			$('#fieldErrorsPassword').html('');
			$('#fieldErrorsRepeatPassword').html('');
			$('#fieldErrorsRole').html('');
		}
		
		function save(){
			//alert($('#editFluid').window('options').title);
			//alert($('#operationType').val());
			if($('#operationType').val() == 'add')
				$.ajax({
					type:'POST',
					url:'addUser.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						name:$('#name').val(),
						password:$('#password').val(),
						repeatPassword:$('#repeatPassword').val(),
						role:$('#role').combobox('getValue')
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						$('#fieldErrorsId').html('');
						$('#fieldErrorsName').html('');
						$('#fieldErrorsPassword').html('');
						$('#fieldErrorsRepeatPassword').html('');
						$('#fieldErrorsRole').html('');
						
						if($.isEmptyObject(data)){
							$('#users').datagrid('reload');
							$('#fieldErrorsRole').html('<font size=-1 color=green>保存成功!</font>');							
						}
						else{
							var fieldErrorsId = data.fieldErrors.id;
							var fieldErrorsName = data.fieldErrors.name;
							var fieldErrorsPassword = data.fieldErrors.password;
							var fieldErrorsRepeatPassword = data.fieldErrors.repeatPassword;
							var fieldErrorsRole = data.fieldErrors.role;
							
							if(fieldErrorsId)
								$('#fieldErrorsId').html('<font size=-1 color=red>' + fieldErrorsId + '</font>');
							if(fieldErrorsName)
								$('#fieldErrorsName').html('<font size=-1 color=red>' + fieldErrorsName + '</font>');
							if(fieldErrorsPassword)
								$('#fieldErrorsPassword').html('<font size=-1 color=red>' + fieldErrorsPassword + '</font>');
							if(fieldErrorsRepeatPassword)
								$('#fieldErrorsRepeatPassword').html('<font size=-1 color=red>' + fieldErrorsRepeatPassword + '</font>');
							if(fieldErrorsRole)
								$('#fieldErrorsRole').html('<font size=-1 color=red>' + fieldErrorsRole + '</font>');
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			else if($('#operationType').val() == 'update'){
				//$('#id').attr('disabled','disabled');

				
				$.ajax({
					type:'POST',
					url:'updateUser.action',
					dataType:'json',
					data:{
						id:$('#id').val(),
						name:$('#name').val(),
						password:$('#password').val(),
						repeatPassword:$('#repeatPassword').val(),
						role:$('#role').combobox('getValue')
					},
					success:function(data){
						//alert(data.fieldErrors ? true : false);
						//alert(JSON.stringify(data));
						
						$('#fieldErrorsId').html('');
						$('#fieldErrorsName').html('');
						$('#fieldErrorsPassword').html('');
						$('#fieldErrorsRepeatPassword').html('');
						$('#fieldErrorsRole').html('');
						
						if($.isEmptyObject(data)){
							$('#users').datagrid('reload');
							$('#fieldErrorsRole').html('<font size=-1 color=green>修改成功!</font>');								
						}
						else{
							var fieldErrorsId = data.fieldErrors.id;
							var fieldErrorsName = data.fieldErrors.name;
							var fieldErrorsPassword = data.fieldErrors.password;
							var fieldErrorsRepeatPassword = data.fieldErrors.repeatPassword;
							var fieldErrorsRole = data.fieldErrors.role;
							
							if(fieldErrorsId)
								$('#fieldErrorsId').html('<font size=-1 color=red>' + fieldErrorsId + '</font>');
							if(fieldErrorsName)
								$('#fieldErrorsName').html('<font size=-1 color=red>' + fieldErrorsName + '</font>');
							if(fieldErrorsPassword)
								$('#fieldErrorsPassword').html('<font size=-1 color=red>' + fieldErrorsPassword + '</font>');
							if(fieldErrorsRepeatPassword)
								$('#fieldErrorsRepeatPassword').html('<font size=-1 color=red>' + fieldErrorsRepeatPassword + '</font>');
							if(fieldErrorsRole)
								$('#fieldErrorsRole').html('<font size=-1 color=red>' + fieldErrorsRole + '</font>');
						}
					},
					error:function(jqXHR, textStatus,errorThrown){
						alert('jqXHR:' + jqXHR + ',textStatus:' + textStatus + ',errorThrown:' + errorThrown);
					}
				});
			}
		}
		
		function deleteUser(index){
			var row = $('#users').datagrid('getRows')[index];
			if(confirm("您确定要删除编号为'" + row.id + "'的员工么?"))
				$.ajax({
					type:'POST',
					url:'deleteUser.action',
					dataType:'json',
					data:{
						id:row.id
					},
					success:function(data){
						$('#users').datagrid('reload');
					}
				});
		}
	</script>

</body>
</html>