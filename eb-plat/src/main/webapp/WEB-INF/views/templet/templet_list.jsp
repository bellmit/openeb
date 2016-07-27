<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模板列表</title>
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
	<div id="templet_add"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			title : '订单列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/templet/datagrid',
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
				field : 'name',
				title : '模板名称',
				width : 150,
			}]],
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					addFun();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					openDialog("add_dialog", "edit");
				}
			},'-', {
				text : '文件管理',
				iconCls : 'icon-edit',
				handler : function() {
					fileManageFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					delAppInfo();
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
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});

		/*添加模板*/
		function addFun() {
			var templet_add_dialog = $('#templet_add').dialog({
			    title: '添加模板',
			    width: 600,
			    height:400,
			    closed: false,
			    cache: false,
			    href: '${pageContext.request.contextPath}/templet/create',
			    modal: true,
			    buttons : [ {
					text : '添加',
					handler : function() {
						$('#templet_addForm').form('submit', {
							url : '${pageContext.request.contextPath}/templet/templetAdd',
							success : function(data) {
								console.info(data);
								var result = $.parseJSON(data);
								if(result.success){
									templet_add_dialog.dialog('close');
									$('#list_data').datagrid('load');
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
		/*文件管理(打开一个页面)*/
		function fileManageFun(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length < 1) {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的记录!',
					timeout : 3000,
					showType : 'slide'
				});
			}else{
				var templetId= checkedRows[0].id;
				window.location.href="${pageContext.request.contextPath}/templet/fileList?templetId="+templetId;
			}
		}
		
	</script>

</body>

</html>
