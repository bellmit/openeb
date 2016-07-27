<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商城类目列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script>
</head>
<body>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'center',split:false">
		<table id="list_data" cellspacing="0" cellpadding="0">
	</table>
	</div>
</div>
	<table id="list_data" cellspacing="0" cellpadding="0">
	</table>
	<div id="dd"></div>
	
	
	<script type="text/javascript">
		var basepath = "${pageContext.request.contextPath}";
		$('#list_data').treegrid({
			title : '商城商品类目列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : basepath+'/category/treeGrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			idField:'id',
			treeField:'text',
			parentField : 'parentId',
			//singleSelect : false,//是否单选 
			rownumbers : true,//行号 
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			},{
				field : 'text',
				title : '类目名称',
				width : 150
			},{
				field : 'typename',
				title : '商品类型',
				width : 150
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="false"){
			    		str = "<font style=''>锁定</font>";
			    	}else{
			    		str = "<font style=''>正常</font>";
			    	}
			    	 return str;
				}
			} ] ],
			toolbar : [ {
				text : '新    增',
				iconCls : 'icon-add',
				handler : function() {
					addFun();
				}
			}, '-', {
				text : '修    改',
				iconCls : 'icon-edit',
				handler : function() {
					editFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					delFun();
				}
			}, '-', {
				text : '添加帐号',
				iconCls : 'icon-add',
				handler : function() {
					addSellerFun();
				}
			} ],
			onLoadSuccess : function() {
				alert("loadsuccess");
			}
		});

		function addSellerFun() {
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1) {
			var seller_dialog_ = $('#dd').dialog({
				title : '新增商城卖家账户',
				width : 600,
				height : 400,
				closed : false,
				cache : false,
				href : basepath+'/seller/dataform?storeId='+checkedRows[0].id,
				modal : true,
				buttons : [ {
					text : '创     建',
					handler : function() {
						$('#seller_form').form('submit',
						{
							url : basepath+'/seller/create',
							success : function(data) {
							var json = $.parseJSON(data);
							if (json.success) {
								$('#list_data').datagrid('load');
									seller_dialog_.dialog('close');
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
			} else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一个记录删除!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要删除的记录!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		
		function delFun() {
			
		}
	</script>

</body>

</html>
