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
