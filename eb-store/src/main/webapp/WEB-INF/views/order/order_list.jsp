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
	width: 500px;
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
.order_input{
	
}
.gridlist3 tr td{
border:1px solid #eee;
}

</style>

<body>
	<table id="order_list" cellspacing="0" cellpadding="0">
	</table>
	<div id="order_edit"></div>
	<script type="text/javascript">
	$(function() {
		showOrder('WAIT_PAY');
	});
	function showOrder(state){
		$('#order_list').datagrid({
			title : '订单列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/order/datagrid?state='+state,
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
				field : 'serialnum',
				title : '订单号',
				width : 150,
			},/*,{
				field : 'title',
				title : '订单商品',
				width : 150,
			},{
				field : 'price',
				title : '订单金额',
				width : 150,
			},*/{
				field : 'adddatestr',
				title : '下单时间',
				width : 150,
			}, {
				field : 'buyernick',
				title : '买家',
				width : 150,
			},{
				field : 'stateStr',
				title : '订单状态',
				width : 150,
			},{
				field : 'state',
				title : '操作',
				hidden : true,
			}]],
			toolbar : "#order_toolbar"
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
		}
		/*查看订单*/
		function show_order(){
			var checkedRows = $("#order_list").datagrid('getChecked');
			if(checkedRows.length == 1){
				var id = checkedRows[0].serialnum;
				window.location.href="${pageContext.request.contextPath}/order/orderShow?id="+id;
			}else if(checkedRows.length > 1){
				$.messager.show({
					title : '提示',
					msg : '只能选择一条订单信息查看详情!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请选择要查看的订单信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		/*发货*/
		function shipments_order(){
			var checkedRows = $("#order_list").datagrid('getChecked');
		    if(checkedRows.length == 1){
		    	var id = checkedRows[0].serialnum;
				var state = checkedRows[0].state;
				
				if(state=='WAIT_SEND'){
					
					var order_shipments_dialog = $('#order_edit').dialog({
						title: '发货',
					    width: 800,
					    height:500,
					    closed: false,
					    cache: false,
					    href: '${pageContext.request.contextPath}/order/orderShipments?id='+id,
					    modal: true,
					    buttons : [ {
							text : '保	存',
							handler : function() {
								var logistnum = $('#logistnum').val();
								var code = $('#code').val();
								if(logistnum==''){
									alert('请输入运单编号');
								}else{
									  $.ajax({
											url : '${pageContext.request.contextPath}/order/orderShipmentsDo',
											data : "id="+id+"&logistnum="+logistnum+"&code="+code,
											type : 'POST',
											dataType : 'json',
											success : function(json) {
												
												order_shipments_dialog.dialog('destroy');
												showOrder('WAIT_SEND');
												$("#order_list").datagrid('load');
										        $("#order_list").datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
												$("#order_list").datagrid('reload');
											}
										});  
								}
								
							}
						} ]
					}); 
				}else if(state=='WAIT_PAY'){
					$.messager.show({
						title : '提示',
						msg : '未付款，不能发货!',
						timeout : 3000,
						showType : 'slide'
					});
				}else{
					$.messager.show({
						title : '提示',
						msg : '只能对未发货的订单进行操作!',
						timeout : 3000,
						showType : 'slide'
					});
				}
		    	
			} else if(checkedRows.length > 1){
				$.messager.show({
					title : '提示',
					msg : '只能选择一条订单进行发货!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要发货的订单!',
					timeout : 3000,
					showType : 'slide'
				});
			} 
			
		}
		
		/*取消订单*/
		function cancel_order(id){
			
			var checkedRows = $("#order_list").datagrid('getChecked');
			
			 if(checkedRows.length == 1){
				 
				 var id = checkedRows[0].serialnum;
				 var state = checkedRows[0].state;
				 if(state=='WAIT_PAY'){
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
				 }else{
					 $.messager.show({
							title : '提示',
							msg : '只能对未付款的订单进行取消!',
							timeout : 3000,
							showType : 'slide'
						});
				 }
				
			 }else if(checkedRows.length > 1){
				 $.messager.show({
						title : '提示',
						msg : '只能选择一条订单进行取消!',
						timeout : 3000,
						showType : 'slide'
					});
			 }else if(checkedRows.length < 1){
				 $.messager.show({
						title : '提示',
						msg : '请选择要取消的订单!',
						timeout : 3000,
						showType : 'slide'
					});
			 }
			
			
		}
		
		/*订单价格*/
		function update_order(){
			
			var checkedRows = $("#order_list").datagrid('getChecked');
			
			 if(checkedRows.length == 1){
				 
				 var id = checkedRows[0].serialnum;
				 var state = checkedRows[0].state;
				 if(state=='WAIT_PAY'){
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
								iconCls : 'icon-add',
								handler : function() {
									$.ajax({
										url : "${pageContext.request.contextPath}/order/orderEditDo",
										data:$('#order_editForm').serialize(),
										dataType : 'json',
										success : function(json) {
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
							}
						    ,{
								text : '返回',
								iconCls : 'icon-undo',
								handler : function() {
									order_edit_dialog.dialog("destroy");
								}
							}]
						});
				 }else{
					 $.messager.show({
							title : '提示',
							msg : '只能对未付款的订单进行修改!',
							timeout : 3000,
							showType : 'slide'
						});
				 }
				
			 }else if(checkedRows.length > 1){
				 $.messager.show({
						title : '提示',
						msg : '只能选择一条订单进行修改!',
						timeout : 3000,
						showType : 'slide'
					});
			 }else if(checkedRows.length < 1){
				 $.messager.show({
						title : '提示',
						msg : '请选择要修改的订单!',
						timeout : 3000,
						showType : 'slide'
					});
			 }
			
			
			
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
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('WAIT_PAY');">待付款</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('WAIT_SEND');">待发货</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="showOrder('SUCCESSED');">已完成</a><font color="gray">|</font>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="shipments_order();">发货</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="cancel_order();">取消订单</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="update_order();">修改订单</a><font color="gray">|</font>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="show_order();">订单详情</a><font color="gray">|</font>
	</div>
</body>

</html>
