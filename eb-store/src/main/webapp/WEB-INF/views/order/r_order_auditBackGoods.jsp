<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退单列表</title>
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
		<input id="order_edit_id" type="hidden" name="id" value="${returnOrder.id}"/>
		<table id="order_editTable" class="tableForm">
			<div class="order_edit">
				<div class="orderNum">订单编号:${returnOrder.ordernum}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum">订单状态:${returnOrder.backmoneystatusStr}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum">退款金额:${returnOrder.price}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum">退款原因:${returnOrder.backmoneyreason}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum">货号:${returnOrder.productid}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum">商品名称:${returnOrder.productname}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum"><input name="backmoneystatus" type="radio" value="2" checked="checked"/> 同意<input name="backmoneystatus" type="radio" value="1"/>拒绝</div>
			</div>
		</table>
	</form>
</body>

</html>
