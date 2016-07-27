<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<table id="list_data" cellspacing="0" cellpadding="0">
	</table>
	<div id="dd"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			title : '商城商品列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/product/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'barcode',
				title : '商品编号',
				width : 150
			},{
				field : 'cate',
				title : '商品类目',
				width : 150
			},{
				field : 'brand',
				title : '商品品牌',
				width : 150
			},{
				field : 'title',
				title : '商品名称',
				width : 150
			},{
				field : 'price',
				title : '价格',
				width : 150
			},{
				field : 'mktprice',
				title : '市场价',
				width : 150
			},{
				field : 'storenum',
				title : '库存',
				width : 150
			},{
				field : 'weight',
				title : '重量',
				width : 150
			},{
				field : 'gainScore',
				title : '积分',
				width : 150
			}] ],
			toolbar : [ {
				text : '查看',
				iconCls : 'icon-add',
				handler : function() {
					addFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
				}
			} ]
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	</script>

</body>
</html>
