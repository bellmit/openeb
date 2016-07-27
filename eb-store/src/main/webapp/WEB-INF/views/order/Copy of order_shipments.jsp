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
				<div class="orderNum">订单号：${order.serialnum}【${order.stateStr}】</div>
				<div class="orderTime">下单时间：${order.addtime }</div>
			</div>
			<div class="order_product">
				<table>
					<tr>
						<th class="th">货号</th>
						<th class="th">商品名称</th>
						<th class="th">购买数量</th>
						<th class="th">已发货</th>
						<th class="th">此单发货</th>
					</tr>
					<tr>
						<td class="td">P556D46ABA6476</td>
						<td class="td">${order.addtime}</td>
						<td class="td">5</td>
						<td class="td">0</td>
						<td class="td"><input name="" id="" value=""/></td>
					</tr>
				</table>
			</div>
			<div class="order_num">
				收货人信息:${order.receaddress}${order.consignee}${order.phone} 
			</div>
			<div class="order_num">
				<div class="orderNum">发货公司名称:</div>
				<div class="orderTime"><input name="" value=""/></div>
			</div>
			<div class="order_num">
				<div class="orderNum">运单号:</div>
				<div class="orderTime"><input name="" value=""/></div>
			</div>
			
		</form>
	</div>
</body>

</html>
