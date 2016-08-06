<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>地域列表</title>
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
	<script type="text/javascript">
		$('#list_data').treegrid({
			title : '地域列表',
			idField:'code',
		    treeField:'name',
		    parentField : 'parentid',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/area/treegrid',
			remoteSort : false,
			fitColums : true,
			pagination : true,//分页控件 
			rownumbers : true,//行号 
            pageSize: 30,
            pageList: [30,50],
			columns:[[
			          {title:'地域编码',field:'name',width:180},
			          {title:'地域编码',field:'code',width:60,align:'right'},
			          {title:'地域编码',field:'parentid',width:80},
			          {title:'级别',field:'level',width:80}
			]],
			onBeforeLoad: function(row,param){
                if (!row) {    				// load top level rows
                    //param.id = 0;   		// set id=0, indicate to load new page rows
                }else{
                	$(this).treegrid('options').url="${pageContext.request.contextPath}/area/treegrid?id="+param.id;
                }
            }
            /* onBeforeExpand:function(row){
            	$(this).treegrid('options').url="${pageContext.request.contextPath}/area/treegrid?parentid="+row.treeid;
            	return true;
            } */
		});
	</script>

</body>
</html>
