<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fs" uri="/fs-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">

<%@include file="/include/bsie_head.jsp"%>

</head>

<body>
	<%@include file="/include/loading.jsp"%>
	<div >
		<div class="row-fluid">

			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-edit"></i>
					</span>
					<h5>信息审核</h5>
				</div>
				<div class="widget-content nopadding">

					<form class="form-horizontal" method="post" action="infoAuditDo.do" name="form" id="form">
						<input type="hidden" id="pageFuncId" name="pageFuncId" value="${param.pageFuncId }" /> 
						<input type="hidden" name="id" value="${info.id }">

						<div id="nameDiv" class="control-group">
							<label class="control-label" style="width: 160px">信息标题</label>
							<div class="controls" style="margin-left: 190px;">
								<textarea data-placement="top"
									title="" 
									maxLength=200 id=title
									name="title" cols="40" style="width: 180px" rows="3" readonly="readonly">${info.title }</textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" style="width: 160px">是否同意</label>
							<div class="controls" style="margin-left: 190px;">
								<label style="float: left"><input type="radio"
									name="auditState" value="1"
									<c:if test="${info==null || info.auditState==1 || info.auditState==0}">checked="checked"</c:if> />同意</label>
								<label style="float: left"><input type="radio"
									name="auditState" value="2"
									<c:if test="${info.auditState==2 }">checked="checked"</c:if> />不同意</label>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" style="width: 160px">审批意见</label>
							<div class="controls" style="margin-left: 190px;">
								<textarea data-placement="top"
									title="" 
									maxLength=200 id=auditResult
									name="auditResult" cols="40" style="width: 180px" rows="3">${info.auditResult }</textarea>
							</div>
						</div>

					</form>

				</div>
			</div>
			<!--/row-->
		</div>
		<!--/span-->
		<%@include file="/include/foot.jsp"%>
		<script src="${pageContext.request.contextPath}/static/admin/cms/js/info.js"></script>
		<script src="${pageContext.request.contextPath}/static/common/js/check.js"></script>
		<script src="${pageContext.request.contextPath}/static/common/js/checkLoginName.js"></script>
</body>
</html>