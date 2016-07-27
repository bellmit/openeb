<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>商城应用系统--EB-Mall</title>	
        <meta name="keywords" content="{$metaKeywords}" />
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vip/common.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vip/basic.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vip/member.css">
        
    </head>
    <body>
        <jsp:include page="../top.jsp"></jsp:include>
        
        <!-- Content-Start -->
        <div class="clear" style="height:10px;"></div>
        
        <div class="content clear">
            <!-- 左侧菜单-start -->
            <jsp:include page="../left.jsp"></jsp:include>
            <!-- 左侧菜单-end -->
            
            <!-- 右侧内容-Start -->
            <div id="contentPage" class="left right-content">
            	<jsp:include page="buy.jsp"></jsp:include>
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
        
        <!-- Footer-Start -->
        <jsp:include page="../footer.jsp"></jsp:include>﻿
        <!-- Footer-End -->
    </body>
</html>
