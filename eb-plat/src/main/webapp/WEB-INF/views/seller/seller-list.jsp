<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商城卖家列表</title>
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
	<div data-options="region:'north',title:'平台卖家查询'" style="height: 100px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <th>商城名称：</th>
	              <td><input id="title" name="title" value=""/></td>
	              <th>商城状态：</th>
	              <td>
	              	<select id="state" name="state">
	              		<option value="">----- 请选择-----</option>
	              		<option value="1">启用</option>
	              		<option value="0">禁用</option>
	              	</select>
	              </td>
	          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
	          </tr>                     
			</table>
		</form>                                    
	</div>            
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
		$('#list_data').datagrid({
			title : '平台卖家列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : basepath+'/seller/datagrid',
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
				field : 'account',
				title : '卖家帐号',
				width : 150
			},{
				field : 'name',
				title : '卖家名称',
				width : 150
			},{
				field : 'phone',
				title : '联系电话',
				width : 150
			},{
				field : 'email',
				title : '邮箱地址',
				width : 150
			},{
				field : 'storename',
				title : '商城名称',
				width : 150
			},{
				field : 'addtimestr',
				title : '入驻时间',
				width : 150
			},{
				field : 'status',
				title : '帐号状态',
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
		/*onBeforeRefresh:function(){
		    $(this).pagination('loading');
		    alert('before refresh');
		    $(this).pagination('loaded');
		}*/
		});

		function editFun() {
			var seller_dialog_ = $('#dd').dialog({
				title : '修改商城卖家账户信息',
				width : 600,
				height : 400,
				closed : false,
				cache : false,
				href : basepath+'/seller/dataform',
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
		}
		
		function delFun() {
			
		}
	</script>

</body>

</html>
