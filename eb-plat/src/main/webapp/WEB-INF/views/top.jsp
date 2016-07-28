<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电商管理平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript">
var basePath = "${pageContext.request.contextPath}";
$(function(){
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
		top.leftFrame.document.getElementById("rootMenu").innerHTML="<span></span>"+$(this).attr("title");
		if($(this).attr("name")=="workplat"){
			top.rightFrame.src="forward?path=index";
			return;
		}else{
			loadMenu($(this).attr("id"));
		}
	});
});


function loadMenu(id) {
	$.ajax({
		type : "post",
		url : basePath + "/menu?pid="+id,
		success : function(data, textStatus) {
		var menuHtml = "";
		for (var i = 0; i < data.length; i++) {
			menuHtml = menuHtml
			+ "<dd><div class=\"title\"><span><img src=\"${pageContext.request.contextPath}/static/images/leftico01.png\" /></span>"
			+ data[i].name
			+ "</div>"
			+"<ul class=\"menuson\" id='"+data[i].id+"' style=\"display: block;\">";
			if (data[i].subs){
				for (var s = 0; s < data[i].subs.length; s++) {
					if (s == 0) {
						menuHtml = menuHtml + "<li class=\"active\">";
					} else {
						menuHtml = menuHtml + "<li>";
					}
					menuHtml = menuHtml + "<cite></cite><a href=\"${pageContext.request.contextPath}"+data[i].subs[s].url+"\" target=\"rightFrame\">"
									+ data[i].subs[s].name + "</a><i></i></li>";
				}
			}
			menuHtml = menuHtml+"</ul></dd>";
		}
		//top.leftFrame.document.getElementById("menuTree").empty();
		top.leftFrame.document.getElementById("menuTree").innerHTML=menuHtml;
			
		},
		complete : function(XMLHttpRequest, textStatus) {
					//HideLoading();
		},
		error : function() {
					//请求出错处理
		}
	});
}

</script>
</head>
<body style="background:url(${pageContext.request.contextPath}/static/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/static/images/logo.png" title="系统首页" /></a>
    </div>
        
    <%-- 
    <ul class="nav">
    <li><a href="javascript:void(0);" target="rightFrame" class="selected" title="工作台" ><img src="${pageContext.request.contextPath}/static/images/icon01.png" /><h2>工作台</h2></a></li>
    <li><a href="javascript:void(0);" target="rightFrame" title="商品管理" ><img src="${pageContext.request.contextPath}/static/images/icon02.png" /><h2>商品管理</h2></a></li>
    <li><a href="javascript:void(0);"  target="rightFrame" title="订单管理" ><img src="${pageContext.request.contextPath}/static/images/icon03.png" /><h2>订单管理</h2></a></li>
    <li><a href="javascript:void(0);"  target="rightFrame" title="店铺管理" ><img src="${pageContext.request.contextPath}/static/images/icon04.png" /><h2>店铺管理</h2></a></li>
    <li><a href="javascript:void(0);" target="rightFrame" title="营销管理" ><img src="${pageContext.request.contextPath}/static/images/icon05.png" /><h2>营销管理</h2></a></li>
    <li><a href="javascript:void(0);"  target="rightFrame" title="系统设置" ><img src="${pageContext.request.contextPath}/static/images/icon06.png" /><h2>系统设置</h2></a></li>
    </ul> 
    --%>
    
    <ul class="nav">
    	<li><a name="workplat" href="forward?path=index" href="javascript:void(0);" target="rightFrame" class="selected" title="工作台" ><img src="${pageContext.request.contextPath}/static/images/icon01.png" /><h2>工作台</h2></a></li>
    	<c:forEach items="${menus }" var="menu" varStatus="status">
    		<li><a href="javascript:void(0);" id="${menu.id }" target="rightFrame" title="${menu.name }" ><img src="${pageContext.request.contextPath}/static/images/icon0${status.index+2}.png" /><h2>${menu.name }</h2></a></li>
    	</c:forEach>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath}/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/login" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><shiro:principal/></span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>
