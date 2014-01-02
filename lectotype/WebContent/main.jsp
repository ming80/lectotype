<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大成仪表</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">  
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>  
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function openTab(page,pageName){
		if ($('#content').tabs('exists',pageName)){
			$('#content').tabs('select', pageName);
		} else {
			var content = 
				'<iframe scrolling="no" frameborder="0" src="' + page + '" style="width:100%;height:100%;"></iframe>';
				
			$('#content').tabs('add',{
				title:pageName,
				content:content,
				//href:page,
				closable:true
			});
		}
	}
	
	function setLayoutHeight(){
		//alert($(window).height());	//窗口高度
		//alert(screen.availHeight);	//可用高度
		
		$('#cc').height(screen.height <= 768 ? 710 : (screen.availHeight * 0.92));	//可用高度的92%
		$('#cc').layout('resize');
	}

</script>
</head>

<body onload="setLayoutHeight() ">
  <div id="cc" class="easyui-layout" style="width:1020px;margin:0px auto"><!-- margin上下和body之间0px,左右自动调整,有居中效果 -->
    <div data-options="region:'north',border:false" style="height:50px;padding:5px;position:relative">
    	<!-- div style="border:0px solid black;position:absolute;left:0px;bottom:5px;">
    		<img src="images/huanya_logo.png">
    	</div-->
    	<!--  div style="border:0px solid black;position:absolute;right:0px;bottom:5px;"><font size=-1>
    		欢迎您，${sessionScope.user.name }！ &nbsp&nbsp&nbsp<img src="images/logout.png" style="vertical-align:bottom;">&nbsp<a href="logout.action">安全退出</a>
    	</font></div-->  

        <div style="padding:5px;border:1px solid #ddd"> 
        	<a href="#" id="mb1" class="easyui-menubutton" data-options="menu:'#mm1'">计算</a>
    		<a href="#" id="mb2" class="easyui-menubutton" data-options="menu:'#mm2'">选型表</a>
    	</div>	
    	<div id="mm1" style="width:150px">
    		<div>流量计算</div>
    	</div>
      	<div id="mm2" style="width:150px">
    		<div>
    			<span>气动调节阀</span>
    			<div style="width:150px">
	    			<div>添加</div>
	    			<div>查询</div>
    			</div>
    		</div>
    	</div>

    </div>   
    
    <div data-options="region:'center',border:false"  style="padding:0px 0px 0px 5px;">
		<div id="content" class="easyui-tabs" fit="true" border="true" plain="false">
    	</div>
    </div>
  </div>

  <script type="text/javascript">
		$(function(){
			$($('#mb1').menubutton('options').menu).menu({
				onClick: function (item) { 
                	if(item.text == "流量计算") 
                		openTab('caculateFlow.jsp','流量计算');
            	} 
        	});
			$($('#mb2').menubutton('options').menu).menu({
				onClick: function (item) {                 	
                	if(item.text == "添加") 
                		openTab('addValveSpecification.jsp','添加选型表');
                	if(item.text == "查询") 
                		openTab('queryValveSpecification.jsp','查询选型表');
            	} 
        	});
		});
  </script>
</body>
</html>