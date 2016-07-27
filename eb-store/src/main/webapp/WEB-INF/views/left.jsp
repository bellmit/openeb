<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/static/css/style.css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

<script type="text/javascript">
	var basePath = "${pageContext.request.contextPath}";
	$(function() {
		$('.title').live("click",function() {
			var $ul = $(this).next('ul');
			//$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
		
		//导航切换
		$(".menuson li").live("click",function() {
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
		});
	});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop" id="rootMenu"><span></span>商品管理</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    	<span><img src="${pageContext.request.contextPath}/static/images/leftico01.png" /></span>交易管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/order/orderList" target="rightFrame">订单管理</a><i></i></li>
        <%-- <li><cite></cite><a href="${pageContext.request.contextPath}/returnOrder/rorderList" target="rightFrame">退单管理</a><i></i></li> --%>
        
    </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/static/images/leftico02.png" /></span>宝贝管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=baby/release_main" target="rightFrame">发布宝贝</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=baby/product_onsale" target="rightFrame">出售中的宝贝</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=baby/product_instock" target="rightFrame">仓库中的宝贝</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/product/productStockList" target="rightFrame">预警中的宝贝</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>物流管理</div>
    <ul class="menuson">
       <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=logistics/deliver_type_list" target="rightFrame">配送方式</a><i></i></li>
    </ul>    
    </dd> 
    <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>评分管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=eval/eval_list" target="rightFrame">评分项目</a><i></i></li>
    </ul>    
    </dd> 
   <%--  <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>店铺管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/store/storeList" target="rightFrame">店铺列表</a><i></i></li>
    </ul>    
    </dd>  --%> 
    
    <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>模板管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/forward?path=site/template_list" target="rightFrame">模板列表</a><i></i></li>
    </ul>    
    </dd>
    <%-- <dd><div class="title"><span><img src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>配置管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/config" target="rightFrame">配置项</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    </dd>   --%> 
     <dd><div class="title"><span><img src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>索引管理</div>
	    <ul class="menuson">
	        <li><cite></cite><a href="${pageContext.request.contextPath}/product/toSolr" target="rightFrame">生成索引</a><i></i></li>
	    </ul>
	  </dd> 
    </dl>
    
</body>
</html>

