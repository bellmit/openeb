<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    
    <title>管理后台</title>
    <link href="${pageContext.request.contextPath}/static/ui-v2/css/skin_0.css" rel="stylesheet" type="text/css" id="cssfile" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/admincp.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common.js"></script>
    
    <script type="text/javascript">
	        var APP_BASE = '${pageContext.request.contextPath}';
	        LOADING_IMAGE = "${pageContext.request.contextPath}/res/images/loading.gif";
	</script>
	
	<link href="${pageContext.request.contextPath}/static/ui-v2/css/font-awesome.min.css" rel="stylesheet">
	<!--[if IE 7]>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ui-v2/css/font/font-awesome/css/font-awesome-ie7.min.css">
	<![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />

</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>楼层管理</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/floor/form"><span>新增楼层</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td>
                <ul>
                    <li>排序越小越靠前，可以控制楼层显示先后。</li>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table tb-type2 nobdb">
        <thead>
        <tr class="thead">
            <th class="align-center">排序</th>
            <th class="align-center">楼层名称</th>
            <th class="align-center">楼层副标题</th>
            <th class="align-center">显示</th>
            <th class="align-center">操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${floorList }" var="floor">
            <tr class="hover" style="background: rgb(255, 255, 255);">
                <td class="align-center">${floor.ordernum }</td>
                <td class="align-center">${floor.title }</td>
                <td class="align-center">
	                ${floor.title }
                </td>
                <td class="w150 align-center">是</td>
                <td class="w150 align-center">
                    <a href="${pageContext.request.contextPath}/floor/form?id=${floor.id }">编辑</a>|
                    <a href="${pageContext.request.contextPath}/floor/delete?id=${floor.id }">删除</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


</body></html>