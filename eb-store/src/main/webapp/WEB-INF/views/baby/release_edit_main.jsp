<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>商城应用系统--EB-Mall</title>	
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">        
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/framework.css">     
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css.css">    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/b2c.css">
        
        <!-- EasyUI -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/uploadify.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/singlepage.css">
		
		<!-- 编辑器 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.js"></script>
		
    </head>
    <style>
#form_saveGoods input,#form_saveGoods textarea{font-size:10px;}
</style>
    <body>
        <div class="clear" style="height:10px;"></div>
        
        <div class="content clear">
            <!-- 左侧菜单-start 
            <jsp:include page="../left.jsp"></jsp:include>-->
            <!-- 左侧菜单-end -->
            
            <!-- 右侧内容-Start -->
            <div id="contentPage" class="left right-content">
            	<jsp:include page="product_edit.jsp"></jsp:include>
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
    </body>
</html>
