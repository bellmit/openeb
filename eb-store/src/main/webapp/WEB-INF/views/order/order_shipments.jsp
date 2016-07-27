<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/order.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<div class="order_div">
		<form id="order_editForm" method="post">
			<div class="order_num">
				<div class="orderNum">订单号：${order.serialnum}【待发货】</div>
				<div class="orderTime">下单时间：${order.adddatestr }</div>
			</div>
			<div class="order_product">
				<table>
					<tr>
						<th class="th" style="width:200px;">货号</th>
						<th class="th" style="width:300px;">商品名称</th>
					</tr>
					<tr>
						<td class="td fs10" style="width:200px;">${tsc }</td>
						<td class="td fs10" style="width:300px;">${product.title}</td>
					</tr>
				</table>
			</div>
			<div class="order_num">
				收货人信息:${order.receaddress}|${order.consignee}|${order.phone} 
			</div>
			<div class="order_num">
				<div class="orderNum">发货公司名称:</div>
				<div class="orderTime">
				<input type="text" style="border:1px #95B8E7 solid;" name="code" id="code" value="${deliver.code}"/>
				<input type="text"  style="border:1px #95B8E7 solid;" name="" value="${deliver.name}"/></div>
			</div>
			<div class="order_num">
				<div class="orderNum">运单号:</div>
				<div class="orderTime"><input style="width:250px;border:1px #95B8E7 solid;" name="logistnum" type="text" id="logistnum" value=""/></div>
			</div>
			
		</form>
	</div>
</body>

</html>
