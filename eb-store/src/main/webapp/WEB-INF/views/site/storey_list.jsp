<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>商城应用系统--EB-Mall</title>
<meta name="description" content="" />
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- EasyUI -->
<link rel="stylesheet" type="text/css"
	href="resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="resources/easyui/themes/icon.css">
<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<table id="list_data" cellspacing="0" cellpadding="0"></table>

</body>

<script type="text/javascript">
$("#list_data").datagrid({
	title : "商城楼层列表",
	nowrap : false,
	striped : true,
	border : true,
	loadMsg : '数据加载中请稍后……',
	fitColums : true,
	rownumbers : true,//行号
	singleSelect : true,//是否单选 
	idField: 'id',
	columns : [ [ {
		field : 'lng',
		title : '经度',
		width : 100
	}, {
		field : 'lat',
		title : '维度',
		width : 100
	} ] ],
	toolbar : [ {
		text : '保   存',
		iconCls : 'icon-add',
		handler : function() {
			//savePipePoints(id);
		}
	} ],
	data:points,
	onClickRow:function (index,row){
		//map.centerAndZoom(new BMap.Point(row.lng,row.lat), 16);
	}
});
</script>
</html>