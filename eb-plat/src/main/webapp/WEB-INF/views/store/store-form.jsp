<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商城注册信息表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}

input {
	width: 200px;
	height: 30px;
}
</style>
</head>

<body>
	<form id="store_form" method="post">
		<input type="hidden" name="id" value="${store.id }" />
		
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;font-size: 14px;">商城名称<font style="color: red">*</font></th>
				<td><input type="text" name="name" class="easyui-validatebox"
					required="true" missingMessage="不能为空" value="${store.name}" /></td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;font-size: 14px;">联系电话<font style="color: red">*</font></th>
				<td><input type="text" name="phone" class="easyui-validatebox"
					required="true" missingMessage="不能为空" value="${store.phone}" /></td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;font-size: 14px;">商城域名<font style="color: red">*</font></th>
				<td><input type="text" name="domain" class="easyui-validatebox"
					required="true" missingMessage="不能为空" value="${store.domain}" /></td>
			</tr>

		</table>
	</form>

</body>

</html>
