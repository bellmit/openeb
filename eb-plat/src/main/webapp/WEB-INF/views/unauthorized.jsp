<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>没有权限</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 


</head>


<body style="background:#edf6fa;">

	<div class="place">
    <span>您没有权限[${exception.message}]</span>
    <ul class="placeul">
    </ul>
    </div>
    
    <div class="error">
    
    <h2>您没有权限[${exception.message}]</h2>
    <div class="reindex"><a href="main.html" target="_parent">返回首页</a></div>
    
    </div>


</body>

</html>
