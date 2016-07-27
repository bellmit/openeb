<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>索引列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">  
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"></script>
</head>
<style>
.orderTable{
	width:300px;
	margin:0 auto;
}
.order_num{
	width: 500px;
	height: 40px;
	margin: 0 auto;
	min-height: 40px;
	padding-top: 10px;
}
.order_edit{
	width: 450px;
	height: 20px;
	margin: 0 auto;
	min-height: 20px;
	padding-top: 10px;
}
.order_title{
	width: 450px;
	height: 50px;
	margin: 0 auto;
	min-height: 20px;
	padding-top: 10px;
}
.order_product{
	margin: 0 auto;
	width: 700px;
}
.tr{
	height:50px;
}
.th{
	padding: 0;
	text-align: center;
	background: #f1f1f1;
	height: 20px;
	line-height: 20px;
	border: 1px solid #ddd;
	border-right: none;
	font-size: 12px;
	width: 400px;
}
.td{
	text-align: center;
	height: 28px;
	border: 1px solid #eee;
	border-right: none;
	border-top: none;
}
.orderNum{
float:left;
}
.orderTime{
float:right;
}

</style>

<body>
	<table id="order_list" cellspacing="0" cellpadding="0">
	</table>
	<div id="order_edit"></div>
	<script type="text/javascript">
	
	
		//查询订单
		function order_searchFun() {
			var page = $("#page").val();
			var rows = $("#rows").val();
			 $.ajax({
				url : "${pageContext.request.contextPath}/product/getSolrBySiteId",
				data:"page="+page+"&rows="+rows,
				dataType : 'json',
				success : function(json) {
					if(json.success){
						alert("生成成功！");
					}
				}
			});  
		}
		
	</script>
	<div id="order_toolbar">
		<form id="order_searchContent" method="post">
				
				<!-- 查询功能 -->
				&nbsp;第几页&nbsp;<input  name="page" id="page" value=""/>
				&nbsp;每页条数&nbsp;<input name="rows"  id="rows" value=""/>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="order_searchFun();">查询</a>
			</form>
	</div>
</body>

</html>
