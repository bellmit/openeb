<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预警中的宝贝</title>
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css">
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">        
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/framework.css">     
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">    
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css.css">    
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/b2c.css">
       
       <!-- EasyUI -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/syUtil.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/uploadify.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/singlepage.css">
	
	<!-- 编辑器 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.js"></script>

		
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
	/* $(function() */ 
	$(function() {
		var stocknum = ${store.stockalertnum};
		showOrder(stocknum);
	});
	
	function showOrder(stocknum){
		$('#product_list').datagrid({
			title : '预警中的宝贝列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/product/datagrid?status=1&stockalertnum='+stocknum,
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
	};
	//查询订单
	function product_searchFun() {
		$('#product_list').datagrid('load',serializeObject($('#product_searchContent')));
	}
	//产品下架
	function product_down(status){
		var checkedRows = $("#product_list").datagrid('getChecked');
		var ids = [];
		if(checkedRows.length > 0) {
			$.messager.confirm('确认', '您是否要下架当前选中的商品？', function(r) {
				if(r) {
					for ( var i = 0; i < checkedRows.length; i++) {
						ids.push(checkedRows[i].pId);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/product/productDown',
						data : {
							ids : ids.join(','),
							status:status
						},
						dataType : 'json',
						success : function(json) {
							if (json.success) {
								$("#product_list").datagrid('reload');
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
				msg : '请勾选想要下架的商品!',
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
	
	//产品编辑
	function product_edit1(){
		var checkedRows = $("#product_list").datagrid('getChecked');
		if(checkedRows.length == 1) {
			var id = checkedRows[0].pId;
			alert(id);
			var porduct_edit_dialog = $('#product_edit').dialog({
				title: '编辑商品',
			    width: 1000,
			    height:500,
			    closed: false,
			    cache: false,
			    href: '${pageContext.request.contextPath}/product/productEdit?id='+id,
			    modal: true,
			    buttons : [ {
					text : '保	存',
					handler : function() {
						$('#product_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/product/productEidtDo',
							success : function(data) {
								
								var result = $.parseJSON(data);
								if(result.success){
									porduct_edit_dialog.dialog('close');
									$('#product_list').datagrid('load');
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
	function edit_store_alertnum(){
		var storealertnum= $("#stockalertnum").val();
		if(storealertnum >0) { 
			$.messager.confirm('确认', '您是否要修改店铺预警值吗？', function(r) {
				if(r) {
					$.ajax({
						url : '${pageContext.request.contextPath}/product/editStorealertnum',
						data : {
							stockalertnum : storealertnum
						},
						dataType : 'json',
						success : function(json) {
							if (json.success) {
								showOrder(storealertnum);
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
				msg : '请填写要修改的店铺库库存预警值!',
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
			  店铺库存预警值&nbsp;<input  type="text" id="stockalertnum" name="stockalertnum" value="${store.stockalertnum}"/>|
			   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="edit_store_alertnum();">设置预警值</a><font color="gray">|</font>
			 <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="product_del();">删除</a><font color="gray">|</font>
			 <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"  onclick="product_edit();">编辑</a><font color="gray">|</font>
	</div>
</body>

</html>
