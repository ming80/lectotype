<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选型表查询</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/json2.js"></script> 
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>

<body>
	<div style="padding:10px">		
		<table id="tt"></table>
		<div id="tb" style="padding:8px;height:auto">
			<form metod="post" action="">
			<table border="0" height="70px" width="550px">
				<tr>
					<td align="right">项目名称</td>
					<td><input type="text" id="projectName" style="height:20px;border:1px solid #9D9D9D"><font size="-1" color="grey">#</font></td>
					<td align="right">调节阀名称</td>
					<td><input type="text" id="selectedModelName" style="height:20px;border:1px solid #9D9D9D"><font size="-1" color="grey">#</font></td>
				</tr>	
				<tr>
					<td align="right">调节阀型号</td>
					<td><input type="text" id="model" style="height:20px;border:1px solid #9D9D9D"><font size="-1" color="grey">#</font></td>
					<td colspan="2" align="center">
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="query()">查 询</a> 
						<font size="-1" color="grey">&nbsp#表示此条件支持模糊查询</font>
					</td>
				</tr>			
			</table>
			</form>			
		</div>
	</div>	
	<div id="win2"></div>
	
	<script type="text/javascript">
		$(function(){	
			//{'total':100,'rows':[{id:'1',name:'一'},{id:'2',name:'二'}]};
			//var nullData = {"total":1,"rows":[],"footer":[{"policyNo":"Total","premium":18.00}]};
			//var json = JSON.parse(nullData);
			//data:{'total':1,'rows':[],'footer':[{'policyNo':'Total','premium':18.00}]}			
			$('#tt').datagrid({
				//width: 830,
				height: 670,
				showFooter:true,
				pagination: true,	
				pageSize: 20,
				frozenColumns:[[
					{field:'projectName',title:'项目名称',width:160,sortable:true}
				]],
				columns:[[
					{field:'tagNo',title:'位号',width:60,sortable:true},
					{field:'quantity',title:'数量',width:50,sortable:true},
					{field:'selectedModel.name',title:'调节阀名称',width:200,sortable:true,
						formatter: function(value,row,index){
							return row.selectedModel.name;
						}	
					},
					{field:'selectedModel.model',title:'调节阀型号',width:100,sortable:true,
						formatter: function(value,row,index){
							return row.selectedModel.model;
						}		
					},
					{field:'selectedModel.bodyMaterial',title:'阀体材质',width:100,sortable:true,
						formatter: function(value,row,index){
							return row.selectedModel.bodyMaterial;
						}		
					},
					{field:'selectedModel.seatMaterial',title:'阀座材质',width:100,sortable:true,
						formatter: function(value,row,index){
							return row.selectedModel.seatMaterial;
						}		
					},
					{field:'selectedModel.plugMaterial',title:'阀芯材质',width:100,sortable:true,
						formatter: function(value,row,index){
							return row.selectedModel.plugMaterial;
						}		
					}					
				]],	  
				toolbar:'#tb'				
			});	
		});
		
		function query(){
			$('#tt').datagrid('options').url = "queryValveSpecification.action";
			$('#tt').datagrid('load',{
				queryTimestamp: new Date().getTime(),
				selectedModelName: $('#selectedModelName').val(),
				projectName: $('#projectName').val(),
				model: $('#model').val()
			});
			
		}
	</script>
</body>
</html>