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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-plat/article_class.js" charset="utf-8"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
        <h3>文章分类</h3>
            <ul class="tab-base">
            <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/channel/form"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th class="nobg" colspan="12"><div class="title">
            <h5>操作提示</h5>
                <span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td><ul>
            <li>管理员新增文章时，可选择文章分类。文章分类将在前台文章列表页显示</li>
            <li>默认的文章分类不可以删除</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" action="${pageContext.request.contextPath}/channel/delete">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th class="w48"></th>
                <th class="w48">排序</th>
                <th>文章分类</th>
                <th class="w96 align-center">操作提示</th>
            </tr>
            </thead>
            <tbody id="treet1">
            	<c:forEach items="${channelList }" var="channel">
                <tr class="hover edit" style="background: rgb(255, 255, 255);">
                    <td>
                      	<input name="" type="checkbox" disabled="disabled" value="">
                        <img src="${pageContext.request.contextPath}/static/ui-v2/images/tv-expandable.gif" fieldid="${channel.id }" level="1" status="open" nc_type="flex">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="1" fieldname="acSort" modurl="${pageContext.request.contextPath}/channel/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="1" fieldname="acName" modurl="${pageContext.request.contextPath}/channel/modifyName" nc_type="inline_edit" class="editable ">${channel.title }</span>
                        <a class="btn-add-nofloat marginleft" href="${pageContext.request.contextPath}/channel/findOne?id=1"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center">
                    	<a href="${pageContext.request.contextPath}/channel/edit?id=${channel.id}">编辑</a>
                    	<a href="javascript:if(confirm('删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗'))window.location ='${pageContext.request.contextPath}/channel/delete?ids=9'">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td><label for="checkall1">
                    <input type="checkbox" class="checkall" id="checkall_2">
                </label></td>
                <td colspan="16"><label for="checkall_2">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="if(confirm('删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗')){$('form:first').submit();}"><span>删除</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>