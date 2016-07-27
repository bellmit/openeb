<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>商城应用系统--EB-Mall</title>	
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <link type="text/css" rel="stylesheet" href="resources/css/common.css">
        <link type="text/css" rel="stylesheet" href="resources/css/basic.css">
        <link type="text/css" rel="stylesheet" href="resources/css/member.css">        
        <link type="text/css" rel="stylesheet" href="resources/css/framework.css">     
        <link type="text/css" rel="stylesheet" href="resources/css/style.css">    
        <link type="text/css" rel="stylesheet" href="resources/css/css.css">    
        <link type="text/css" rel="stylesheet" href="resources/css/b2c.css">
        
        <!-- EasyUI -->
		<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
		<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
		<script src="resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
	
		<link rel="stylesheet" type="text/css" href="resources/css/uploadify.css">
		<link rel="stylesheet" type="text/css" href="resources/css/singlepage.css">
		
		<!-- 编辑器 -->
		<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="resources/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="resources/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
		
    </head>
    <body>
        <div class="clear" style="height:10px;"></div>
        
        <div class="content clear">
            <!-- 左侧菜单-start 
            <jsp:include page="../left.jsp"></jsp:include>-->
            <!-- 左侧菜单-end -->
            
            <!-- 右侧内容-Start -->
            <div id="contentPage" class="left right-content">
            	<jsp:include page="release.jsp"></jsp:include>
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
    </body>
</html>
