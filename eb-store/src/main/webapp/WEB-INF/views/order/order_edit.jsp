<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div style="padding:20px;">
		<input id="order_edit_id" type="hidden" name="id" value="${order.id}"/>
		<div>
		<table id="order_editTable" class="tableForm">
			
			<table cellspacing="0" cellpadding="0" border="0" class="gridlist gridlist3" id="goods-table" width="100%">
                   <thead id="productNodeTitle">
                       <tr class="fs10" style="height: 30px;">
                           <th class="textcenter" >宝贝名称</th>
                           <th class="textcenter" >订单号</th>
                           <th class="textcenter" >单价</th>
                           <th class="textcenter" >数量</th>
                       </tr>
                   </thead>
                    <tbody class='productNode'>
                    <c:forEach var="item" items="${oItemsList}" varStatus="status">   
	                   	<tr>
	                   		<td style="width:250px;text-align: center;"><div class="fs10">${product.title}</div></td>
							<td style="width:100px;text-align: center;"><div class="fs10">${order.serialnum}</div></td>
							<td style="width:50px;text-align: center;"><div class="fs10">${item.price }</div></td>
							<td style="width:50px;text-align: center;"><div class="fs10">${item.num }</div></td>
						</tr>
					</c:forEach>
				</tbody> 
               </table>
               </div>
			<%-- <div class="order_title">
				<div class="orderNum"><font size="4px;" >宝贝名称:</font>${product.title}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum"><font size="4px;" >订单号:</font>${order.serialnum}</div>
			</div>
			<div class="order_edit">
				<div class="orderNum"><font size="4px;" >单价:</font></div>
			</div>
			<div class="order_edit">
				<div class="orderNum"><font size="4px;" >数量:</font></div>
			</div> --%>
			<div class="order_edit">
				<div class="orderNum">邮费:<input type="text" name="shipfee"  class="easyui-numberbox"  precision="2" required="true" invalidMessage="格式错误，请重新输入数字" missingMessage="必须填写数字" value="${order.shipfee}" /></div>
				<%-- <div class="orderNum">邮费:<input type="text" name="shipFee"  class="easyui-numberbox"  precision="2" required="true" invalidMessage="格式错误，请重新输入数字" missingMessage="必须填写数字" value="${order.shipFee}" /></div> --%>
			</div>
		</table>
		</div>
	</form>
</body>

</html>
