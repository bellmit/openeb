<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓售中的宝贝</title>
       <link type="text/css" rel="stylesheet" href="resources/css/common.css">
       <link type="text/css" rel="stylesheet" href="resources/css/basic.css">
       <link type="text/css" rel="stylesheet" href="resources/css/member.css">        
       <link type="text/css" rel="stylesheet" href="resources/css/framework.css">     
       <link type="text/css" rel="stylesheet" href="resources/css/style.css">    
       <link type="text/css" rel="stylesheet" href="resources/css/css.css">    
       <link type="text/css" rel="stylesheet" href="resources/css/b2c.css">
       
       <!-- EasyUI -->
	<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
	<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
	<script src="resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/syUtil.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/uploadify.css">
	<link rel="stylesheet" type="text/css" href="resources/css/singlepage.css">
	
	<!-- 编辑器 -->
	<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="resources/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="resources/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>

		
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
input{
width:100px;
}
</style>

<body>
	<table id="product_list" cellspacing="0" cellpadding="0">
	</table>
	<div id="product_edit"></div>
	<script type="text/javascript">
	$(function() {
		$('#product_list').datagrid({
			title : '仓库中的宝贝列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/product/datagrid?status=0',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			columns : [ [ {
				field : 'pId',
				title : '商品编码',
				width : 150,
				checkbox : true
			},{
				field : 'barcode',
				title : '商品编码',
				width : 150,
			},{
				field : 'picUrl',
				title : '商品图片',
				width : 150,
				formatter:function(value, rec){//使用formatter格式化刷子
					return '<img src='+value+' width="100" height="80" >';
				}
			},{
				field : 'title',
				title : '宝贝名称',
				width : 150,
			},{
				field : 'price',
				title : '价格',
				width : 150,
			},{
				field : 'storenum',
				title : '库存',
				width : 150,
			},{
				field : 'saleNum',
				title : '总销量',
				width : 150,
			},{
				field : 'createdStr',
				title : '发布时间',
				width : 150,
			},{
				field : 'operation',
				title : '操作',
			}]],
			toolbar : "#product_toolbar"
		});
		
		//设置分页控件 
		var p = $('#product_list').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
	});
	//查询订单
	function product_searchFun() {
		$('#product_list').datagrid('load',serializeObject($('#product_searchContent')));
	}
	//产品上架
	function product_down(status){
		var checkedRows = $("#product_list").datagrid('getChecked');
		var ids = [];
		if(checkedRows.length > 0) {
			$.messager.confirm('确认', '您是否要上架当前选中的商品？', function(r) {
				if(r) {
					for ( var i = 0; i < checkedRows.length; i++) {
						ids.push(checkedRows[i].pId);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/product/productUp',
						data : {
							ids : ids.join(','),
							status:status
						},
						dataType : 'json',
						success : function(json) {
							if (json.success) {
								$("#product_list").datagrid('load');
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
				msg : '请勾选想要上架的商品!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
	
	
	//产品删除
	function product_del(){
		var checkedRows = $("#product_list").datagrid('getChecked');
		var ids = [];
		if(checkedRows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的商品？', function(r) {
				if(r) {
					for ( var i = 0; i < checkedRows.length; i++) {
						ids.push(checkedRows[i].pId);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/product/productDel',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(json) {
							if (json.success) {
								$("#product_list").datagrid('load');
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
				msg : '请勾选想要删除的商品!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
	function product_edit(){
		var checkedRows = $("#product_list").datagrid('getChecked');
		if(checkedRows.length == 1) {
			var id = checkedRows[0].pId;
			window.location.href="${pageContext.request.contextPath}/product/productEdit?id="+id;
		} else if(checkedRows.length > 1){
			$.messager.show({
				title : '提示',
				msg : '只能选择一个商品进行编辑!',
				timeout : 3000,
				showType : 'slide'
			});
		}else {
			$.messager.show({
				title : '提示',
				msg : '请勾选想要编辑的商品!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
	
	

	</script>
	<div id="product_toolbar">
		<form id="product_searchContent" method="post">
				<!-- 查询功能 -->
				&nbsp;宝贝名称&nbsp;<input  name="title" value=""/>|
				&nbsp;商品编码&nbsp;<input name="barcode"  value=""/>
				&nbsp;价格：&nbsp;<input name="minPrice"  value=""/>&nbsp;到&nbsp;<input name="maxPrice" id="maxPrice" value=""/>
				&nbsp;总销量：&nbsp;<input name="minSaleNum"  value=""/>&nbsp;到&nbsp;<input name="maxSaleNum"  value=""/>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="product_searchFun();">查询</a>
			</form>
			 <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="product_down('1');">上架</a><font color="gray">|</font>
			 <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="product_del();">删除</a><font color="gray">|</font>
			 <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"  onclick="product_edit();">编辑</a><font color="gray">|</font>
	</div>
</body>

</html>
