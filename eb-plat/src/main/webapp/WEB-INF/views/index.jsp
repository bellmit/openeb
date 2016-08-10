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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/perfect-scrollbar.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.mousewheel.js"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>系统信息</h3>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <div class="info-panel">
        <dl class="member">
            <dt>
            <div class="ico"><i></i><sub title="会员总数"><span><em id="statistics_member">172</em></span></sub></div>
            <h3>会员</h3>
            <h5>新增会员</h5>
            </dt>
            <dd>
                <ul>
                    <li class="w50pre normal" style="width: 100%">
                    	<a href="${pageContext.request.contextPath}/member/list">本周新增<sub><em id="statistics_week_add_member">172</em></sub></a></li>
                </ul>
            </dd>
        </dl>
        <dl class="shop">
            <dt>
            <div class="ico"><i></i><sub title="新增店铺数"><span><em id="statistics_store">11</em></span></sub></div>
            <h3>店铺</h3>
            <h5>新开店铺审核</h5>
            </dt>
            <dd>
                <ul>
                    <li class="w33pre none" style="width:50%;"><a href="${pageContext.request.contextPath}/store/manager/auditList">开店审核<sub><em id="statistics_store_joinin">0</em></sub></a></li>
                    <!--<li class="w33pre none"><a href="/leimingtech-admin/store/manager/list?storeStatus=expired">已到期<sub><em id="statistics_store_expired">0</em></sub></a></li>-->
                    <li class="w34pre none" style="width:50%;"><a href="${pageContext.request.contextPath}/store/manager/list?storeStatus=expire">全部店铺<sub><em id="statistics_store_expire">0</em></sub></a></li>
                </ul>
            </dd>
        </dl>
        <dl class="goods">
            <dt>
            <div class="ico"><i></i><sub title="商品总数"><span><em id="statistics_goods">119</em></span></sub></div>
            <h3>商品</h3>
            <h5>新增商品/品牌申请审核</h5>
            </dt>
            <dd>
                <ul>
                    <li class="w33pre normal"><a href="${pageContext.request.contextPath}/goods/goodsCommon/list">本周新增<sub title=""><em id="statistics_week_add_product">4</em></sub></a></li>
                    <li class="w33pre high"><a href="${pageContext.request.contextPath}/goods/goodsCommon/downList">商品下架<sub><em id="statistics_product_down">7</em></sub></a></li>
                    <li class="w34pre high"><a href="${pageContext.request.contextPath}/goods/brand/applyList">品牌申请<sub><em id="statistics_brand_apply">2</em></sub></a></li>
                </ul>
            </dd>
        </dl>
        <div class=" clear"></div>
    </div>
</div>
<script type="text/javascript">
    var normal = ['week_add_member','week_add_product'];
    var work = ['product_down','store_expired','store_expire','brand_apply'];
    $(document).ready(function(){
        $.getJSON(APP_BASE+"/statistics", function(data){
            $.each(data, function(k,v){
                $("#statistics_"+k).html(v);
                if (v!= 0 && $.inArray(k,work) !== -1){
                    $("#statistics_"+k).parent().parent().parent().removeClass('none').addClass('high');
                }else if (v == 0 && $.inArray(k,normal) !== -1){
                    $("#statistics_"+k).parent().parent().parent().removeClass('normal').addClass('none');
                }
            });
        });
        //自定义滚定条
        $('#system-info').perfectScrollbar();
    });
</script>


</body>
</html>