<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/grade_zh_CN.js" charset="utf-8"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>店铺等级</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/storegrade/form"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label for="like_sg_name">等级名称</label></th>
                <td><input type="text" value="" name="sgName" id="like_sg_name" class="txt"></td>
                <td><a href="javascript:document.formSearch.submit();" class="btn-search " title="搜索">&nbsp;</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <form id="form_list" method="post" name="" action="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/delete">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th class="w24">&nbsp;</th>
                <th>级别</th>
                <th>等级名称</th>
                <th class="align-center">可发布商品数量</th>
                <th class="align-center">上传图片数量</th>
                <th class="align-center">收费标准</th>
                <th class="align-center">佣金比例</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <tr class="hover" style="background: rgb(255, 255, 255);">
                    <td>
                            <input type="checkbox" name="ids" value="b46de06722fe49e2ab355477e64b5978" class="checkitem">
                    </td>
                    <td class="w36">4</td>
                    <td>黄金</td>
                    <td class="align-center">10</td>
                    <td class="align-center">1000</td>
                    <td class="align-center">10000</td>
                    <td class="align-center">0.5</td>
                    <td class="w270"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/forward?id=b46de06722fe49e2ab355477e64b5978">编辑</a> |
                            <a href="javascript:;" onclick="delRow(this)">删除</a> |
                        <a href="JavaScript:;"> 设置 模板(暂无)</a></td>
                </tr>
                <tr class="hover" style="background: rgb(255, 255, 255);">
                    <td>
                            <input type="checkbox" name="ids" value="4" class="checkitem">
                    </td>
                    <td class="w36">3</td>
                    <td>钻石店铺</td>
                    <td class="align-center">700</td>
                    <td class="align-center">700</td>
                    <td class="align-center">300</td>
                    <td class="align-center"></td>
                    <td class="w270"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/forward?id=4">编辑</a> |
                            <a href="javascript:;" onclick="delRow(this)">删除</a> |
                        <a href="JavaScript:;"> 设置 模板(暂无)</a></td>
                </tr>
                <tr class="hover" style="background: rgb(255, 255, 255);">
                    <td>
                            <input type="checkbox" name="ids" value="7" class="checkitem">
                    </td>
                    <td class="w36">2</td>
                    <td>信用店铺</td>
                    <td class="align-center">100000</td>
                    <td class="align-center">1000</td>
                    <td class="align-center">12121</td>
                    <td class="align-center"></td>
                    <td class="w270"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/forward?id=7">编辑</a> |
                            <a href="javascript:;" onclick="delRow(this)">删除</a> |
                        <a href="JavaScript:;"> 设置 模板(暂无)</a></td>
                </tr>
                <tr class="hover">
                    <td>
                    </td>
                    <td class="w36">1</td>
                    <td>白金店铺</td>
                    <td class="align-center">10</td>
                    <td class="align-center">10</td>
                    <td class="align-center">100</td>
                    <td class="align-center"></td>
                    <td class="w270"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/forward?id=1">编辑</a> |
                            默认等级不能删除|
                        <a href="JavaScript:;"> 设置 模板(暂无)</a></td>
                </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="15"><label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="deleteGrade()"><span> 删除</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>


</body></html>