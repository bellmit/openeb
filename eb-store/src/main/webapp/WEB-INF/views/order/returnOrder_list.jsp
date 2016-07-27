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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"></script>
</head>
<style>
.orderTable{
	width:300px;
	margin:0 auto;
}
.order_num{
	width: 450px;
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
.order_product{
	margin: 0 auto;
	width: 500px;
}
.tr{
	height:50px;
}
.th{
	padding: 0;
	text-align: center;
	background: #f1f1f1;
	height: 32px;
	line-height: 32px;
	border: 1px solid #ddd;
	border-right: none;
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
		$('#order_list').datagrid({
			title : '退单列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/returnOrder/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			},{
				field : 'orderNum',
				title : '订单号',
				width : 150,
			},{
				field : 'title',
				title : '订单商品',
				width : 150,
			},{
				field : 'price',
				title : '订单金额',
				width : 150,
			},{
				field : 'name',
				title : '下单时间',
				width : 150,
			},{
				field : 'buyerNick',
				title : '买家',
				width : 150,
			},{
				field : 'statusStr',
				title : '订单状态',
				width : 150,
			},{
				field : 'operation',
				title : '操作',
			}]]
		});
		
		//设置分页控件 
		var p = $('#order_list').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
		/*查看订单*/
		function show_order(id){
			alert('查看订单'+id);
		}
		/*发货*/
		function shipments_order(id){
			var order_shipments_dialog = $('#order_edit').dialog({
				title: '修改订单',
			    width: 600,
			    height:400,
			    closed: false,
			    cache: false,
			    href: '${pageContext.request.contextPath}/order/orderShipments?id='+id,
			    modal: true,
			    buttons : [ {
					text : '保	存',
					handler : function() {
						$('#order_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/order/orderShipmentsDo',
							success : function(data) {
								
								var result = $.parseJSON(data);
								if(result.success){
									order_edit_dialog.dialog('close');
									$('#order_list').datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : result.msg,
									timeout : 3000,
									showType : 'slide'
								});
							}
						});
					}
				} ]
			});
		}
		
		/*取消订单*/
		function cancel_order(id){
			if(id !='') {
				$.messager.confirm('确认', '您是否要取消当前的订单？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/order/orderCancelDo',
							data : {
								id : id
							},
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									$("#order_list").datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
				});
			} else {
				$.messager.show({
					title : '提示',
					msg : '请选择想要取消的订单!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		/*修改订单*/
		function update_order(id){
			var order_edit_dialog = $('#order_edit').dialog({
				title: '修改订单',
			    width: 600,
			    height:400,
			    closed: false,
			    cache: false,
			    href: '${pageContext.request.contextPath}/order/orderEdit?id='+id,
			    modal: true,
			    buttons : [ {
					text : '保存',
					handler : function() {
						$.ajax({
							url : "${pageContext.request.contextPath}/order/orderEditDo",
							data:$('#order_editForm').serialize(),
							dataType : 'json',
							success : function(json) {
								alert(json);
								if(json.success){
									order_edit_dialog.dialog('close');
									$('#order_list').datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg,
									timeout : 3000,
									showType : 'slide'
								});
							}
						});
					}
				} ]
			});
		}
		
	
		//查询订单
		function order_searchFun() {
			/* $.ajax({
				url : "${pageContext.request.contextPath}/order/datagrid",
				data:$('#order_searchContent').serialize(),
				dataType : 'json',
				success : function(json) {
					if(json.success){
						$('#order_list').datagrid('load');
					}
				}
			}); */
			$('#order_list').datagrid('load',serializeObject($('#order_searchContent')));
			//$('#order_list').datagrid('load',$('#order_searchContent').serialize());
		}
		
	</script>
	<div id="order_toolbar">
		<form id="order_searchContent" method="post">
				<!-- 查询功能 -->
				&nbsp;订单号&nbsp;<input  name="orderNum" value=""/>
				&nbsp;商品名称&nbsp;<input name="title"  value=""/>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="order_searchFun();">查询</a>
			</form>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('2');">待付款</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('3');">待发货</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('0');">已完成</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('0');">已取消</a><font color="gray">|</font>
	</div>
</body>

</html>
