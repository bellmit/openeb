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
				field : 'serialnum',
				title : '订单号',
				width : 150,
			},{
				field : 'buyernick',
				title : '申请人',
				width : 150,
			},{
				field : 'addtime',
				title : '申请时间',
				width : 150,
			},{
				field : 'backmoneystatusStr',
				title : '处理状态',
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
		/*处理审核*/
		function audit_rorder(id){
			var rorder_audit_dialog = $('#order_edit').dialog({
				title: '处理审核退单',
			    width: 600,
			    height:400,
			    closed: false,
			    cache: false,
			    href: '${pageContext.request.contextPath}/returnOrder/auditBackGoods?id='+id,
			    modal: true,
			    buttons : [ {
					text : '保	存',
					handler : function() {
						$('#order_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/returnOrder/auditBackGoodsDo',
							success : function(data) {
								
								var result = $.parseJSON(data);
								if(result.success){
									rorder_audit_dialog.dialog('close');
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
</body>

</html>
