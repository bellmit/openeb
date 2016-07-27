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
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">  
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
	<!-- title-->
	<div class="clearfix">
		<!-- right-->
		<div class="member-main member-main2">
			<div style="height:auto">
				<div class="title">订单信息</div>
				<table border="0" width="100%" cellpadding="0" cellspacing="0"
					class="order-info" style="margin:10px 0 20px 0">
					<tbody>
						<tr>
							<!-- order status -->
							<td width="30%" valign="top"><ul>
									<li class="fs10">订单号：<span class="price-normal">${order.serialnum}</span></li>
									<li class="fs10">订单金额：<span class="point">${order.totalfee}</span></li>
									<li class="fs10">订单状态：<span class="siteparttitle-blue">${order.stateStr}</span></li>
								</ul></td>
							<!-- order action -->
						</tr>
					</tbody>
				</table>
				<!-- common order info -->
				<div class="order-track" style="border:none">
					<div id="order_des" class="switch">
						<ul class="switchable-triggerBox clearfix">
							<li class="active fs10"><a href="javascript:void(0);">订单追踪</a></li>
						</ul>
						<div class="switchable-content">
							<div class="switchable-panel">
								<div class="box">
									<div class="flow">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tbody>
												<tr>
													<td class="box-td fs10">提交订单</td>
													<td class="box-td fs10"><span class="point">等待确认</span></td>
													<td class="box-td fs10">捡配货物</td>
													<td class="box-td fs10">店家发货</td>
												</tr>
												<tr>
													<td colspan="5" class="flow-bg"><div
															class="flow-bg bg2"></div></td>
												</tr>
											</tbody>
										</table>
									</div>
									<p>${order.adddatestr}&nbsp;&nbsp;订单创建成功！</p>
									<!-- <p>2015-07-01 14:29&nbsp;&nbsp;订单创建成功！</p> 
										<p>2015-07-02 10:05&nbsp;&nbsp;修改运费为40.000元！</p>
									-->
									<p>${order.shipfee}&nbsp;&nbsp;修改运费为${order.shipfee}元！</p>
								</div>
							</div>
							<div class="switchable-panel" style="display: none;"></div>
						</div>
					</div>
					<div class="cart-wrap ">
						<div class="FormWrap gift-bag order-trace">
							<!-- <h4>商品</h4> -->
							<table width="100%" cellspacing="0" cellpadding="3"
								class="gridlist">
								<colgroup>
									<col class="span-auto">
									<col class="span-2">
									<col class="span-2">
									<col class="span-3">
								</colgroup>
								<tbody>
									<tr>
										<th class="first fs10">商品</th>
										<th class="fs10">数量</th>
										<th class="fs10">金额小计</th>
										<!-- <th class="fs10">积分</th> -->
									</tr>
								</tbody>
								<tbody>
									<tr>
										<td>
											<div class="clearfix horizontal-m">

												<div class="product-list-img goodpic"
													isrc=""
													ghref=""
													style="width:50px;height:50px; margin:0 5px">
													<a href=""
														target="_blank" style="border: 0px;"><img
														src="${product.picUrl }"
														width="50" height="50" style="cursor: pointer;"></a>
												</div>
												<div class="goods-main">
													<div style="width:50%" class="goodinfo">
														<h3>
															<a target="_blank" class="font-blue fs10"
																href="">${product.title}&nbsp;&nbsp; </a>
														</h3>
													</div>
													<div class="good-wrap order-goodpirce">
														<ul>
															<li class="price-normal fs10">${product.price}</li>
														</ul>
													</div>
												</div>
											</div>
										</td>
										<td class="textcenter vm fs10">${order.totalnum}</td>
										<td class="textcenter vm font-orange fs10">${product.price}</td>
										<!-- <td class="textcenter vm fs10">38</td> -->
									</tr>
								</tbody>
							</table>

							<h4>收货信息</h4>
							<table width="100%" cellspacing="0" cellpadding="0"
								class="takegoods">
								<tbody>
									<tr>
										<th class="fs10">收货地址：</th>
										<td class="fs10">${order.receaddress}</td>
									</tr>
									<tr>
										<th class="fs10">收货人姓名：</th>
										<td class="fs10">${order.consignee}</td>
									</tr>
									<tr>
										<th class="fs10">联系电话：</th>
										<td class="fs10">${order.phone}</td>
									</tr>
								</tbody>
							</table>
							<h4 >配送方式</h4>
							<table cellspacing="0" cellpadding="0" border="0" width="100%"
								class="takegoods">
								<tbody>
									<tr>
										<th class="fs10">配送方式：</th>
										<td class="fs10">${deliver.name}</td>
									</tr>
									<tr>
										<th class="fs10">配送费用：</th>
										<td class="fs10"><span class="point">${order.shipfee}</span></td>
									</tr>
								</tbody>
							</table>
							<h4>支付方式</h4>
							<table cellspacing="0" cellpadding="0" border="0" width="100%"
								class="takegoods">
								<tbody>
									<tr>
										<td style="padding-left:40px" class="fs10">快付通在线支付</td>
									</tr>
								</tbody>
							</table>
							<h4>订单备注</h4>
							<table cellspacing="0" cellpadding="0" border="0" width="100%"
								class="takegoods">
								<tbody>
									<tr>
										<td style="padding-left:40px"></td>
									</tr>
								</tbody>
							</table>


							<h4 >结算信息</h4>
							<table cellspacing="0" cellpadding="0" border="0" width="100%"
								class="takegoods">
								<tbody>
									<tr>
										<th class="fs10">商品总金额:</th>
										<td class="fs10">${product.price}</td>
									</tr>
									<tr>
										<th class="fs10">配送费用:</th>
										<td class="fs10"><span class="point">${order.shipfee}</span></td>
									</tr>
									<tr>
										<th class="fs10" style="height:20px;">订单总金额:</th>
										<td class="font16px font-orange fontbold fs10">${order.totalfee}</td>
									</tr>
								</tbody>
							</table>
							
							<%-- 
							<h4>结算信息</h4>
							<table border="0" cellspacing="0" cellpadding="0"
								class="liststyle data" style="border:none" width="100%">
								<colgroup>
									<col width="88%">
									<col width="12%">
								</colgroup>
								<tbody>
									<tr>
										<th class="fs10" style="height:20px;">商品总金额:</th>
										<td class="font14px font-orange fs10">${product.price}</td>
									</tr>
									<tr>
										<th class="fs10" style="height:20px;">配送费用:</th>
										<td class="font14px fs10">${order.shipfee}</td>
									</tr>
									<!-- <tr>
										<th class="fs10">您可获得积分:</th>
										<td class="font14px font-orange">38</td>
									</tr> -->
									<tr>
										<th class="fs10" style="height:20px;">订单总金额:</th>
										<td class="font16px font-orange fontbold fs10">${order.totalfee}</td>
									</tr>
								</tbody>
							</table> --%>
							<!-- order info end -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- right-->
	</div>
</body>

</html>
