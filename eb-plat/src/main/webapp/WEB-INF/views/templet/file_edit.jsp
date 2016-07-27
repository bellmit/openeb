<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模板添加</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		
	});
	
	
</script>
<style>
	input{width: 200px;}
</style>

<body>
	<form id="file_editForm"  method="post">
		<table class="tableForm" style="margin-top: 10px;">
			
			<tr>
				<th style="width: 100px;">模板名称</th>
				<td><input type="text" name="name" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<th style="width: 100px;">模板文件</th>
				<td><input id=uploadFile type=file  style="border: #666666 1px solid; width:170px;" name=uploadFile value=""> (请上传格式为zip的压缩文件)</td>
			</tr>
			<tr>
				<th style="width: 100px;">预览图</th>
				<td><input id="imgfile" type=file style="border: #666666 1px solid; width:170px;" name="imgfile" value=""> (请上传格式为jpg,jpeg,gif,png格式的图片文件)</td>
			</tr>
		</table>
	</form>
</body>

</html>
