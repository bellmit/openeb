<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css" />
<script language="JavaScript"
	src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript">
	var basePath = "${pageContext.request.contextPath}";
	$(function() {
		$('.title').live("click",function() {
			var $ul = $(this).next('ul');
			//$('dd').find('ul').slideUp();
			//$(".menuson").slideUp();
			if ($ul.is(':visible')) {
				//$(this).next('ul').slideUp();
			} else {
				//$(this).next('ul').slideDown();
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

<body style="background: #f0f9fd;">
	<div class="lefttop" id="rootMenu">
		<span></span>管理平台
	</div>

	<dl class="leftmenu" id="menuTree">
		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/static/images/leftico01.png" /></span>商品管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a
					href="${pageContext.request.contextPath}/product"
					target="rightFrame">商品列表</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/product"
					target="rightFrame">下架商品</a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/static/images/leftico02.png" /></span>商品配置
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/category" target="rightFrame">商品分类</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/type" target="rightFrame">商品类型</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/spec" target="rightFrame">商品规格</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/brand" target="rightFrame">商品品牌</a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="static/images/leftico03.png" /></span>会员管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/buyer" target="rightFrame">会员列表</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="static/images/leftico03.png" /></span>店铺管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/store"
					target="rightFrame">店铺列表</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/seller"
					target="rightFrame">卖家列表</a><i></i></li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="static/images/leftico03.png" /></span>模板管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/templet/templetList"
					target="rightFrame">模板列表</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>订单管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">订单订购</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">订单结算</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">订单签收</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>支付管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">订单支付</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">预付款管理</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/order" target="rightFrame">资金平台</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>资源管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">入库管理</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">出库管理</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">库存调拨</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">库存盘点</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">库存管控</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>售后管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/config" target="rightFrame">退换货申请</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">退换货处理</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">维修工单</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>评价管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/config" target="rightFrame">商品评价</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">交易评价</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">评价回复</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">评价处理</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>系统配置
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/config" target="rightFrame">数据字典</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">邮件模板</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">地域列表</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/static/images/leftico04.png" /></span>认证授权
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/user" target="rightFrame">系统用户</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/role" target="rightFrame">角色权限</a><i></i></li>
			</ul>
		</dd>
	</dl>

</body>
</html>
