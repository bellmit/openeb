<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<style>
.tr{
width: 300px;
height: 50px;
border: 1px solid red;
}
</style>
</head>


<body>
	<form id="order_editForm" method="post">
		<input id="order_edit_id" type="hidden" name="id" value="${order.id}"/>
		<table id="order_editTable" class="tableForm">
			<tr class="tr">
				<th style="width: 100px;">宝贝名称</th>
				<td>${order.title}</td>
			</tr>
			<tr>
				<th style="width: 100px;">订单号</th>
				<td>${order.orderNum}</td>
			</tr>
			<tr>
				<th style="width: 100px;">单价</th>
				<td>${order.productFee}</td>
			</tr>
			<tr>
				<th style="width: 100px;">数量</th>
				<td></td>
			</tr>
			<tr>
				<th style="width: 100px;">邮费</th>
				<td><input type="text" name="shipFee" value="${order.shipFee}" class="easyui-validatebox"/></td>
			</tr>
		</table>
	</form>
</body>

</html>
