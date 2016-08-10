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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" charset="utf-8"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>页面导航</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=0"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" action="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/list">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label for="navTitle">标题</label></th>
                <td><input type="text" value="" name="navTitle" id="search_nav_title" class="txt"></td>
                <th><label>所在位置</label></th>
                <td><select name="navLocation">
                    <option value="">请选择...</option>
                    <option value="0">头部</option>
                    <option value="1">中部</option>
                    <option value="2">底部</option>
                </select></td>
                <td><a href="javascript:document.formSearch.submit();" class="btn-search " title="查询">&nbsp;</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <form method="post" id="form_nav" action="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/delete">
        <table class="table tb-type2">
            <thead>
            <tr class="space">
                <th colspan="15">页面导航列表</th>
            </tr>
            <tr class="thead">
                <th>&nbsp;</th>
                <th>排序</th>
                <th>标题</th>
                <th>链接</th>
                <th class="align-center">所在位置</th>
                <th class="align-center">新窗口打开</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
                <tr class="hover" style="background: rgb(255, 255, 255);">
                    <td class="w24"><input type="checkbox" name="ids" value="6" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="6" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>联系我们</td>
                    <td>http://b2b2c.leimingtech.com/help/content?acId=7&amp;articleId=38</td>
                    <td class="w150 align-center">底部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=6">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=6&#39;;">删除</a></td>
                </tr>
                <tr class="hover">
                    <td class="w24"><input type="checkbox" name="ids" value="7" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="7" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>关于我们</td>
                    <td>http://b2b2c.leimingtech.com/help/content?acId=7&amp;articleId=33</td>
                    <td class="w150 align-center">底部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=7">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=7&#39;;">删除</a></td>
                </tr>
                <tr class="hover">
                    <td class="w24"><input type="checkbox" name="ids" value="12" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="12" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>首页</td>
                    <td>http://b2b2c.leimingtech.com</td>
                    <td class="w150 align-center">头部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=12">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=12&#39;;">删除</a></td>
                </tr>
                <tr class="hover">
                    <td class="w24"><input type="checkbox" name="ids" value="13" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="13" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>品牌</td>
                    <td>http://b2b2c.leimingtech.com/all/brand</td>
                    <td class="w150 align-center">头部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=13">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=13&#39;;">删除</a></td>
                </tr>
                <tr class="hover">
                    <td class="w24"><input type="checkbox" name="ids" value="14" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="14" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>优惠券</td>
                    <td>http://b2b2c.leimingtech.com/all/coupon</td>
                    <td class="w150 align-center">头部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=14">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=14&#39;;">删除</a></td>
                </tr>
                <tr class="hover">
                    <td class="w24"><input type="checkbox" name="ids" value="15" class="checkitem"></td>
                    <td class="w48 sort"><span title="可编辑" style="cursor:pointer;" datatype="number" fieldid="15" fieldname="nav_sort" nc_type="inline_edit" class="editable">255</span></td>
                    <td>积分中心</td>
                    <td>http://b2b2c.leimingtech.com/points/index</td>
                    <td class="w150 align-center">头部</td>
                    <td class="w150 align-center">是</td>
                    <td class="w72 align-center">
                        <a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=15">编辑</a> | <a href="javascript:if(confirm(&#39;您确定要删除吗?&#39;))window.location = &#39;/leimingtech-admin/website/navigation/delete?ids=15&#39;;">删除</a></td>
                </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="16"><label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="delarticle();"><span>删除</span></a>
<div class="pagination">
    <ul><li>
                </li><li><span>首页</span></li>
                    <li><span class="currentpage">1</span></li>
                <li><span>末页</span></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >1) {
                    no =1;
                }
                if (no < 1) {
                    no = 1;
                }
                queryForm.pageNo.value=no;
                queryForm.submit();
            }
        </script>
    </ul>
</div>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script type="text/javascript">
function delarticle(){
	if($('input[name="ids"]:checked').length!=0){
		if(confirm('您确定要删除吗?')){
			$('#form_nav').submit();
		}
	}else{
		layer.alert('没有数据删除', {icon: 2});
	}
}
</script>



</body></html>