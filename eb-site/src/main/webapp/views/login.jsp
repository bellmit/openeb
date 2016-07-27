<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户中心</title>
<link href="resources/css1/mll_common.min.css" rel="stylesheet"></link>
<script type="text/javascript" src="resources/js/dc.js"></script>
<script type="text/javascript" src="resources/js/recad.min.js"></script>


<style type="text/css">
.inline_block {
	display: inline-block;
	zoom: 1
}

.yahei {
	font-family: "Microsoft YaHei", "SimHei"
}

.main {
	width: 980px;
	margin: 0 auto;
	position: relative;
	text-align: left
}

.main .user_login_tip {
	position: absolute;
	top: 40px;
	left: 160px;
	font-size: 2em;
	padding: 0;
	font-weight: normal
}

.main .user_header .nav {
	width: 180px;
	padding-top: 40px;
	text-align: right
}

.main .content {
	width: 918px;
	border: 1px solid #d7d7d7;
	position: relative;
	padding: 50px 30px
}

.main .ad_img {
	width: 435px;
	height: 335px;
	background: #fff
}

.main .login_form {
	width: 316px;
	border-left: 1px solid #d7d7d7;
	padding: 0 30px 0 60px
}

.main .login_form .form_header {
	width: 100%;
	height: 20px
}

.main .login_form .form_header h2 {
	font-size: 16px;
	line-height: 18px;
	font-weight: bold;
	color: #333
}

.main .login_form .form_header .phone_icon {
	height: 14px !important;
	margin-left: 3px;
	background: url(resources/imgs/login.png) -316px 0 no-repeat;
	padding-left: 16px;
	line-height: 14px
}

.main .login_form .form_header .person_icon {
	background: url(resources/imgs/login.png) -316px -14px no-repeat
}

.main .login_form .input,.normal_input {
	width: 304px;
	font-size: 14px;
	line-height: 26px;
	height: 28px;
	border: 1px solid #d5d5d5;
	padding: 2px 5px
}

.main .login_form .remchk {
	vertical-align: middle
}

.main .login_form .submit_btn {
	background: url(resources/imgs/login.png) 1px 0 no-repeat;
	display: block;
	line-height: 33px;
	width: 100%;
	height: 33px;
	text-align: center;
	color: #fff;
	font-size: 1.4em
}

.main .login_form a.submit_btn:HOVER {
	text-decoration: none;
	color: #fff !important
}

.main .login_form .api_tips {
	color: #666
}

.main .login_form .login_api .api_links a {
	color: #4a92f5;
	line-height: 26px;
	height: 26px;
	padding-left: 20px;
	background: url(resources/imgs/login_icon2.png) scroll no-repeat;
	padding-right: 2px
}

.main .login_form .reg_p {
	height: 30px;
	padding-top: 10px;
	border-top: 1px solid #eee
}

.error_tip {
	font-size: 12px;
	margin-top: 5px
}

.main .login_form .get_pwd_btn {
	width: 118px;
	height: 24px;
	line-height: 24px;
	text-align: center;
	background: url(resources/imgs/login.png) 0 -35px no-repeat
}

a.get_pwd_btn_disabled {
	width: 81px !important;
	height: 31px !important;
	background-position: -201px -35px !important;
	color: #999 !important
}

a.get_pwd_btn_resend {
	width: 81px !important;
	height: 31px !important;
	background-position: -118px -35px !important
}

a.get_pwd_btn_disabled:hover {
	text-decoration: none;
	color: #999 !important
}

.black {
	color: #333 !important
}

.gray {
	color: #b2b2b2
}

.lightBox {
	text-align: left
}

.input_error {
	background-color: #fff3f3;
	border-color: #c9033b !important;
	color: #c9033b
}

.check_icon {
	display: inline-block;
	*zoom: 1;
	width: 14px;
	height: 14px;
	background: url(resources/imgs/check_icon8.png) 0 -29px no-repeat
}

.check_icon_right {
	background-position: 0 -8px
}

.check_icon_err {
	background-position: 0 -29px
}
</style>
<script>
	
</script>
<style type="text/css">
.AD_tonglan {
	width: 100%;
	height: 50px;
	background: #1F87B0;
}
</style>
<style type="text/css">
.back_to_top {
	display: none;
	width: 44px;
	right: 0;
	position: fixed;
	z-index: 100;
	bottom: 0px;
	_position: absolute;
	_top: expression(eval(document.documentElement.scrollTop + 
		 document.documentElement.clientHeight-188));
}

.back_to_top .in_box {
	display: inline-block;
	width: 44px;
	height: 42px;
	overflow: hidden;
	background: url(resources/imgs/zhuanti/upload/ttop_1389063073.gif) 0px
		-126px no-repeat;
}

.back_to_top_hover_zoom {
	cursor: pointer;
	height: 43px;
}

.back_to_top .in_box.back_to_top_share {
	background-position: 0 0
}

.back_to_top .in_box.back_to_top_lottery {
	background-position: 0 -42px
}

.back_to_top .in_box.back_to_top_quiz {
	background-position: 0 -84px
}

.back_to_top_hover .in_box {
	background-position: -44px -126px
}

.back_to_top_hover .in_box.back_to_top_share {
	background-position: -44px 0
}

.back_to_top_hover .in_box.back_to_top_lottery {
	background-position: -44px -42px
}

.back_to_top_hover .in_box.back_to_top_quiz {
	background-position: -44px -84px
}

.back_to_top_tip {
	position: absolute;
	margin-top: 6px;
	padding-left: 10px;
	background: #fff6ce;
	color: #d3033b;
	line-height: 30px;
	width: 62px;
	margin-left: -72px;
	border-top-left-radius: 15px;
	border-bottom-left-radius: 15px;
	display: none;
	font-family: "微软雅黑";
	font-size: 14px;
	font-weight: bold;
}

.back_to_top_hover .back_to_top_tip {
	display: block
}
</style>
</head>
<body>
	<div class="AD_tonglan">
		<div style="width: 980px; height: 50px; margin: 0 auto">
			<a href="#" target="_blank" onclick="window.__clickAd('tonglan','http://www.meilele.com/topic/201410-gqdc.html?site_from=dbtll#thg=gaca&amp;adg=gaco&amp;adn=%E5%85%A8%E7%BD%91%E9%A1%B6%E9%83%A8%E9%80%9A%E6%A0%8F%E5%B9%BF%E5%91%8A&amp;ado=1&amp;adc=0',1);return false;"><img style="background: none" src="resources/imgs/201409/1410576098397329073.jpg" width="980px" height="50px"></a>
		</div>
	</div>

	<div class="main">
		<div id="" class="user_header clearfix" style="padding: 15px 0px;">
			<div class="logo Left" style="background: url(resources/imgs/flow2.png) 0 0 no-repeat; width: 146px; height: 53px">
				<a href="/" title="返回采购商城首页"><img style="background: none" src="resources/imgs/blank.gif" width="146" height="53" border="0" alt="采购商城"></a>
			</div>
			<div id="" class="nav Right">
				<a href="/">返回首页</a> | <a href="#" target="_blank">帮助中心</a>
			</div>
		</div>
		<h1 class="user_login_tip yahei">用户登录</h1>
		<div class="content clearfix">
			<a class="Left" href="#" title="国庆大促" target="_blank"><img src="resources/imgs/201409/1410577448638509070.jpg" class="ad-img"></a>
			<div class="login_form Right" id="JS_loginForm">
				<div class="form_header">
					<h2 class="yahei Left">用户登录</h2>
					<a id="JS_loginswitch" href="javascript:void(0);" class="phone_icon inline_block Right">手机动态密码登录</a>
				</div>
				<br>
				<form action="${pageContext.request.contextPath}/login" method="post">
					<p>
						<input id="JS_username" type="text" class="input yahei gray" name="username" autocomplete="off" tabindex="0" maxlength="50" value="admin">
					</p>
					<br>
					<p>
						<input id="JS_password" type="password" class="input yahei black" name="password" tabindex="1" maxlength="50" value="000000">
					</p>
					<br>
					<div class="form_header clearfix">
						<label class="black Left"><input checked="true" type="checkbox" name="remchk" class="remchk" id="JS_remchk" tabindex="1">自动登录</label> <a id="JS_forgetpwd" href="/user/?act=get_password" class="Right">忘记密码？</a>
					</div>
					<br> 
					<br> 
					<input name="" type="submit" class="loginbtn" value="登录"/>
					<!-- <a tabindex="3" id="JS_submit" href="javascript:void(0)" class="submit_btn yahei">登&nbsp;&nbsp;&nbsp;录</a> -->	
				</form>
				<br> 
				<br> 
				<br>
				<!-- <div class="login_api">
					<span class="api_tips">使用合作网站账号登录采购商城：</span><br>
					<p class="api_links">
						<a href="/solr_api/Order/thirdlogin.do?type=alipay" style="padding-left: 38px; background-position: 0 -64px;" class="inline_block" tabindex="9">支付宝</a>| <a href="/solr_api/Order/thirdlogin.do?type=taobao" style="background-position: 0 -91px;" class="inline_block" tabindex="9">淘宝网</a>| <a href="/solr_api/Order/thirdlogin.do?type=qq" style="background-position: 0 -120px;" class="inline_block" tabindex="9">QQ</a>| <a href="/solr_api/Order/thirdlogin.do?type=sina" style="background-position: 0 -175px;" class="inline_block" tabindex="9">新浪微博</a>
					</p>
				</div> -->
				<br> <br> <br>
				<p class="reg_p r">
					<a href="memb_register.htm" class="bold red">立即注册&gt;&gt;</a>
				</p>
			</div>
			<br>
		</div>
	</div>

	<!-- 底部 -->

	<script type="text/javascript">
		$("#JS_submit").click(function() {
			var username = $("#JS_username").val();
			var password = $("#JS_password").val();
			if(username==""){
				alert("账号不能为空");
			}
			if(password==""){
				alert("密码不能为空");
			}
			$.ajax({
				url : "/mall/memb_login_do.htm",
				type: "POST",
				dataType: "json",
				data: {loginname:$("#JS_username").val(), pwd:$("#JS_password").val()},
				success : function(data) {
					if (data.result){
						window.location.href="/mall/index.htm";
					}
					//alert(data.result +"|" +data.desc);
				},
				error : function(data) {
					alert("网络错误，请刷新后重试。"+data);
				}
			});
		});
	</script>

	<div id="JS_back_to_top" class="back_to_top">
		<div class="JS_back_to_top_hover back_to_top_hover_zoom">
			<div class="back_to_top_tip">返回顶部</div>
			<div class="in_box back_to_top_top"></div>
		</div>
	</div>

</body>
</html>