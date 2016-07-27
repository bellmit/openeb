<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title></title>
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
	<div data-options="region:'north',title:'商城会员查询'" style="height: 100px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <th>会员名称：</th>
	              <td><input id="title" name="title" value=""/></td>
	              <th>登录帐号：</th>
	              <td><input id="username" name="username" value=""/></td>
	              <th>帐号状态：</th>
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
<div id="user_window"></div>
<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
$('#list_data').datagrid({
	title : '商城会员列表',
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/buyer/datagrid',
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
		title : '登录帐号',
		width : 150
	},{
		field : 'nick',
		title : '会员昵称',
		width : 150
	},{
		field : 'locked',
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
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			addFun();
		}
	}, '-', {
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
			editFun();
		}
	}, '-', {
		text : '更改密码',
		iconCls : 'icon-edit',
		handler : function() {
			changePwdFun();
		}
	}, '-', {
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			delFun();
		}
	}]
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

function addFun() {
	var user_window_dialog = $('#user_window').dialog({
		title : '新增商城会员',
		width : 600,
		height : 400,
		closed : false,
		cache : false,
		href : basepath+'/buyer/dataform',
		modal : true,
		buttons : [ {
			text : '保   存',
			handler : function() {
				$('#user_form').form('submit',{
					url : basepath+'/user/create',
					success : function(data) {
						var result = $.parseJSON(data);
						if (result.success) {
							$('#list_data').datagrid('load');
							user_window_dialog.dialog('close');
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


/*编辑*/
function editFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var user_window_dialog = $('#user_window').dialog({
			title : '商城会员信息编辑',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : basepath+'/buyer/dataform?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#buyer_form').form('submit',{
						url : basepath+'/buyer/update',
						success : function(data) {
							var result = $.parseJSON(data);
							if (result.success) {
								$('#list_data').datagrid('load');
								user_window_dialog.dialog('close');
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


/*修改密码*/
function changePwdFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var user_window_dialog = $('#user_window').dialog({
			title : '系统用户密码修改',
			width : 400,
			height : 200,
			closed : false,
			cache : false,
			href : basepath+'/user/changepwd?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#user_pwd_form').form('submit',{
						url : basepath+'/user/changepwd',
						success : function(data) {
							var result = $.parseJSON(data);
							if (result.success) {
								$('#list_data').datagrid('load');
								user_window_dialog.dialog('close');
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

//记录删除
function delFun(){
	var checkedRows = $("#list_data").datagrid('getChecked');
	if(checkedRows.length == 1) {
		$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
			if(r) {
				$.ajax({
					url : '${pageContext.request.contextPath}/type/typeDel',
					data : {
						id : checkedRows[0].id
					},
					type:'GET',
					dataType : 'json',
					success : function(json) {
						if (json.success) {
							$("#list_data").datagrid('load');
						}
						$.messager.show({
							title : '提示',
							msg : json.msg
						});
					}
				});
			}
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

/*授权*/
function authFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var user_window_dialog = $('#user_window').dialog({
			title : '用户授权',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : basepath+'/user/authform?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					var roleRows = $("#auth_list_data").datagrid('getSelections');
					if (!roleRows || roleRows.length<=0){
						$.messager.show({
							title : '提示',
							msg : '请勾选想要授权的记录!',
							timeout : 3000,
							showType : 'slide'
						});
					}else{
						var roleidstr="";
						for(var i=0;i<roleRows.length;i++){
							roleidstr = roleidstr+roleRows[i].id+",";
						}
						$.ajax({
							url : basepath+'/user/userauth',
							data : "userid="+checkedRows[0].id+"&roleids="+roleidstr,
							type:'POST',
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									$("#list_data").datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
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

function searchFunc(){
	var paramobj={
		title:$("#title").val(),
		corpid:$("#corpid").val(),
		state:$("#state").val()
	};
    $("#list_data").datagrid("load",paramobj);
}

//点击清空按钮出发事件
function clearSearch() {
    $("#list_data").datagrid("load", {});
    $("#searchForm").find("input").val("");
}				
	</script>
</body>
</html>