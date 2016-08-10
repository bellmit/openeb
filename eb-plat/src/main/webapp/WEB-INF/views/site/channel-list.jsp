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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.article_class_zh_CN.js" charset="utf-8"></script>
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
            <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=0"><span>新增</span></a></li>
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
    <form method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/delete">
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
                <tr class="hover edit" style="background: rgb(255, 255, 255);">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img src="./管理后台-文章分类_files/tv-expandable.gif" fieldid="1" level="1" status="open" nc_type="flex">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="1" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="1" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">店主之家</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=1"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=1">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit" style="background: rgb(255, 255, 255);">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img fieldid="2" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="2" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="2" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">新手上路</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=2"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=2">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img fieldid="3" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="3" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="3" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">支付方式</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=3"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=3">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img fieldid="4" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="4" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="4" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">配送方式</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=4"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=4">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img fieldid="5" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="5" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="5" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">售后服务</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=5"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=5">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input name="" type="checkbox" disabled="disabled" value="">
                            <img fieldid="7" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="7" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="7" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">关于我们</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=7"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=7">编辑</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input type="checkbox" name="ids" value="8" class="checkitem">
                            <img fieldid="8" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="8" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="8" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">商城公告</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=8"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=8">编辑</a>
                            <a href="javascript:if(confirm(&#39;删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗&#39;))window.location = &#39;/leimingtech-admin/website/class/delete?ids=8&#39;;">删除</a>
                    </td>
                </tr>
                <tr class="hover edit">
                    <td>
                            <input type="checkbox" name="ids" value="9" class="checkitem">
                            <img fieldid="9" status="close" nc_type="flex" src="./管理后台-文章分类_files/tv-item.gif">
                    </td>
                    <td class="sort"><span title="可编辑" datatype="number" fieldid="9" fieldname="acSort" modurl="/leimingtech-admin/website/class/modifySort" nc_type="inline_edit" class="editable">0</span></td>
                    <td class="name"><span title="可编辑" required="1" fieldid="9" fieldname="acName" modurl="/leimingtech-admin/website/class/modifyName" nc_type="inline_edit" class="editable ">帮助中心</span>
                        <a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/findOne?id=9"><span>新增&nbsp;下级</span></a></td>
                    <td class="align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/editFind?id=9">编辑</a>
                            <a href="javascript:if(confirm(&#39;删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗&#39;))window.location = &#39;/leimingtech-admin/website/class/delete?ids=9&#39;;">删除</a>
                    </td>
                </tr>
            </tbody>
            <tfoot>
            <tr>
                <td><label for="checkall1">
                    <input type="checkbox" class="checkall" id="checkall_2">
                </label></td>
                <td colspan="16"><label for="checkall_2">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="if(confirm(&#39;删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗&#39;)){$(&#39;form:first&#39;).submit();}"><span>删除</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>