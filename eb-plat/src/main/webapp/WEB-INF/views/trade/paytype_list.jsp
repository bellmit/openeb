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

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>支付方式</h3>
            <ul class="tab-base">
                <li>
	                <a class="current">
		                <span>支付方式	</span>
	                </a>
                </li>
                <li>
                   <a href="${pageContext.request.contextPath}/paytype/form">
                       <span>新增</span>
                   </a>
				</li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd">
            <th colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td>
                <ul>
                    <li>此处列出了系统支持的支付方式，点击编辑可以设置支付参数及开关状态</li>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table tb-type2">
        <thead>
        <tr class="thead">
            <th>支付方式</th>
            <th>支付Logo</th>
            <th class="align-left">启用</th>
            <th class="align-center">操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${paytypeList }" var="paytype">
            <tr style="background: rgb(255, 255, 255);">
                <td>支付宝</td>
                <td>
                    <img src="${paytype.logo }" style="width: :100px;height: 50px;">
                </td>
                <td>开启中 </td>
                <td class="w156 align-center">
                    <a href="${pageContext.request.contextPath}/paytype/form?id=${paytype.id}">编辑</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td colspan="15"></td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>