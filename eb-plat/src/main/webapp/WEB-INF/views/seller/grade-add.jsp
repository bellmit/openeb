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
            <h3>等级名称</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/list"><span>管理</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="gradeadd_form" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/store/grade/edit">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="sgName">等级名称:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" id="sg_name" name="sgName" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label class="validation" for="sgGoodsLimit">可发布商品数量:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" id="sg_goods_limit" name="sgGoodsLimit" class="txt" value="10"></td>
                <td class="vatop tips">0 表示没有限制</td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label class="validation"> 上传图片数量:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                <td class="vatop rowform"><input type="text" value="1000" id="sg_album_limit" name="sgAlbumLimit" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label for="sgDescription"> 申请说明:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><textarea rows="6" class="tarea" id="sg_description" name="sgDescription"></textarea></td>
                <td class="vatop tips">申请说明，在会员开通或升级店铺时将显示在前台</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation">级别: </label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" id="sg_sort" name="sgSort" class="txt"></td>
                <td class="vatop tips">数值越大表明级别越高</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="sgPrice">收费标准</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" value="" id="sg_price" name="sgPrice" class="txt"></td>
                <td class="vatop tips">收费标准，在会员开通或升级店铺时将显示在前台</td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label class="validation" for="sgBrokerageScale">佣金比例:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" value="" id="sg_BrokerageScale" name="sgBrokerageScale" class="txt"></td>
                <td class="vatop tips">店铺等级越高佣金比例越小</td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn_add"><span>提交</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>



</body></html>