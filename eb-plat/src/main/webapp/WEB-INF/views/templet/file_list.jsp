<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文件列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js" charset="utf-8"></script> 

<script type="text/javascript">
</script>
</head>


<body>

	<table id="file_treegrid" cellspacing="0" cellpadding="0">
	</table>
	<div id="file_edit"></div>
	<script type="text/javascript">
	
	//文件树形表格
	 $("#file_treegrid").treegrid({
		 title : '文件列表',
		 url : '${pageContext.request.contextPath}/templet/fileTreegrid?templetId=${templetId}',
		 idField : 'id',
		 treeField : 'text',
		 parentField : 'parentId',
		 rownumbers : true,
		 fitColums : true,
		 checkOnSelect:true,
		 selectOnCheck:true,
		 columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'text',
				title : '文件名称',
				width : 350
			} ,{
				field : 'iconCls',
				title : '操作',
				width : 350
			} ] ],
			toolbar : [ {
				text : '文件编辑',
				iconCls : 'icon-add',
				handler : function() {
					fileEditFun();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					//openDialog("add_dialog", "edit");
				}
			} ]
	 });
		
	 /*文件编辑*/
	 function fileEditFun(){
		 var node = $('#file_treegrid').treegrid('getSelected');
		 if(node){
			 var fileName = node.text;
			 var extend = fileName.substring(fileName.lastIndexOf(".")+1);  
			 alert(extend);
			//截取字符串，判断，只能对html，jsp，css和js文件进行编辑
			 if(!(extend=="html"||extend=="jsp"||extend=="css"||extend=="js")){
				 $.messager.show({
						title : '提示',
						msg : '只能编辑后缀名为html，jsp，css，js的文件!',
						timeout : 3000,
						showType : 'slide'
					});
			 }else{
				 //对html，jsp，css，js文件进行编辑
				 var file_edit_dialog = $('#file_edit').dialog({
					    title: '文件编辑',
					    width: 600,
					    height:400,
					    closed: false,
					    cache: false,
					    href: '${pageContext.request.contextPath}/templet/fileEdit',
					    modal: true,
					    buttons : [ {
							text : '添加',
							handler : function() {
								$('#file_editForm').form('submit', {
									url : '${pageContext.request.contextPath}/templet/templetEditSave',
									success : function(data) {
										var result = $.parseJSON(data);
										if(result.success){
											file_edit_dialog.dialog('close');
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
			 
		 }else{
			 $.messager.show({
				title : '提示',
				msg : '请勾选想要编辑的记录!',
				timeout : 3000,
				showType : 'slide'
			});
		 }
	 }
	
	
	</script>

	</body>
</html>
