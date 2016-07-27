<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>支付宝支付测试</title>
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.jqzoom.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buy.css">

<script>
	$(function() {
		$('#rechange').click(function(e) {
			//$this = $("#deposit");
			e.preventDefault();
			//var postData = $.toJSON(form2js('deposit', '.', true));
			//console.log(postData);
			$.ajax({
				url : "${pageContext.request.contextPath}/1001/alipay/deposit",
				type : "POST",
				//data : postData,
				contentType : "application/json",
				success : function(json) {
					//data.total_fee = data.total_fee / 100;//测试成功后请删除
					console.log(json);
					console.log(json.data);
					$("#deposit").append(json.data);//后台会返回一个新的交易表单，并自动提交。所以随便放一个地方就OK
				},
				error : function() {
				}
			});
		});
	});
</script>

</head>
<body>
	<!-- TopBar-Start -->
	<div class="topbar">
		<div class="wrap iconlist">
			<div class="memberbox width-6">
				嗨！欢迎来到EB-SHOP <a href="http://127.0.0.1:9080/eb-site/1001/login">请登录</a>
				<a href="#">免费注册</a>
			</div>
			<div class="width-6">
				<span class="fav"><a href="#">我关注的品牌</a></span> <span class="fav"><a
					href="#">EB-SHOP会员</a></span> <span class="fav"><a
					href="${pageContext.request.contextPath}/cart">购物车<span
						id="shopcart_count">0</span>件
				</a></span> <span class="fav"><a href="#">收藏夹</a></span> | <span class="fav"><a
					href="#">手机版</a></span> <span class="fav"><a href="#">商家支持</a></span> <span
					class="fav"><a href="#">网站导航</a></span>
			</div>
		</div>
	</div>
	<!-- TopBar-Start -->

	<!-- Header-Start -->
	<div id="header">
		<div class=" wrap">
			<div class="logobar width-3">
				<a href="${pageContext.request.contextPath}/forward?path=main"
					title="返回首页" class="logo"><img
					src="resources/images/index/logo.png" /></a>
			</div>
			<div id="searchbar" class="width-6">
				<form method="get" action="/product/">
					<input type="text" name="keywords" class="txt" value=""
						placeholder="站内搜索" /> <input type="submit" class="bt" value="搜索" />
					<div class="clear"></div>
				</form>
				<a href="#">&nbsp;时尚彩宝</a> | <a href="#">&nbsp;钻石</a> | <a href="#">&nbsp;时尚搭配</a>
				| <a href="#">&nbsp;设计师定制</a> | <a href="#">&nbsp;珠宝资讯</a> | <a
					href="#">&nbsp;贵金属投资</a>
			</div>
		</div>
	</div>
	<!-- Header-End -->

	<div style="clear: both"></div>
	<!-- 导航-Start -->
	<div id="nav" class="nav-bottom">
		<ul class="wrap">

		</ul>
		<div class="clear"></div>
	</div>
	<div></div>
	<!-- 导航-End -->



	<!-- 内容-Start -->
	<div id="mainer">
		<div class="wrap ">
			<form id="deposit" name="alipaysubmit" method="post" target="_blank">
				<input type="hidden" name="user.id" value="<shiro:principal property="id"/>" />
				<table cellpadding="10">
					<tr>
						<td>账户余额</td>
						<td class="balance" id="userBalance"></td>
					</tr>
					<tr>
						<td><i class="zfb"></i></td>
						<td style="padding-bottom: 0px;">亲爱的<span
							class="suppliment_user" id="suppliment_user"></span>,您可以使用支付宝充值积善分，请填写以下信息
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="radio inline"> 
						<input type="radio" name="amount" id="optionsRadios7" value="option7">自定义 
						<input class="compliment_count" name="amount" placeholder="充值金额">元
						</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="warm_prompt">温馨提示:<br />1.采用支付宝充值，1元可以充值1积善值。<br />2.若出现已充值成功的提示，但积善值未到账，可能是网络或者系统繁忙导致，我们会在2个工作日内核对后为您充值<br />3在充值过程中如出现网页错误或打开缓慢时，请先查询支付宝的交易记录，检查扣款是否成功；然后查看积善之家账户是否成功充值。若没有确认，请不要反复刷新页面，以防止重复购买。
						</td>
					</tr>
					<tr>
						<td></td>
						<td><button class="affirm-donate" id="rechange">立即充值</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

