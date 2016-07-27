<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>商城应用系统--EB-Mall</title>	
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">        
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/framework.css">     
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css.css">    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/b2c.css">
        
        <!-- EasyUI -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/uploadify.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/singlepage.css">
		
		<!-- 编辑器 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/resources/kindeditor/plugins/code/prettify.js"></script>
		
    </head>
    <body>
    <script type="text/javascript">
	//保存配送方式，提交表单
	function saveDeliverType() {
		 var staval =$('input[name="deliverTypestatus"]:checked').val();
		$("#status").val(staval);
		var hascodval =$('input[name="deliverTypehascod"]:checked').val();
		$("#hascod").val(hascodval); 
		 $.ajax({
			url : '${pageContext.request.contextPath}/logistics/DeliverTypeAddDo',
			data : "deliverType="+$("#deliverType_addForm").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(json) {
				if(json.success){
					$("#title").val("");
					$("#content").val("");
					$("#firstunit").val("");
					$("#continueunit").val("");
				}
				$.messager.show({
	                title:'提示信息',
	                msg:json.msg,
	                timeout:1000,
	                showType:'fade'
	            });
				
			}
		}); 
	}
</script>
        
        <div class="content clear">
            
            <!-- 右侧内容-Start -->
            <div id="contentPage" class="left right-content">
				<div id="main" class="member-main member-main2" action="">
					<div class="title">添加配送方式</div>
					<form method="post" action="#" id="deliverType_addForm" class="section">
						
						<div id="gEditor-Body">
							<div class="title_fb ">1. 配送方式基本信息</div>
							<div class="FormWrap" style="background:none">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="liststyle data width1" style="border:none">
									<tbody>
										<tr>
											<th><em><font color="red">*</font></em>是否启用：</th>
											<td>
												<input type="radio"  name="deliverTypestatus" checked="checked" value="1"><span class="fs10 fc_black">是</span>
												<input type="radio"  name="deliverTypestatus" value="0"><span class="fs10 fc_black">否</span>
												<input type="hidden" name="status" id="status" value="0">
											</td>
										</tr>
										<tr>
											<th><em><font color="red">*</font></em>配送方式名称：</th>
											<td><input autocomplete="off" class="x-input " type="text"
												id="title" name="title" maxlength="100" style="width:60%" value=""></td>
										</tr>
										 <tr id="gEd2itor-GBrand">
												<th style="text-align:right;" class="fs10 fc_black">选择默认物流公司：</th>
												<td>
													<select name="corpid"  id="corpid" class=" x-input-select inputstyle fs10 fc_black">
														<c:forEach items="${dlyCorys}" var="item">
															<option class="brandOp" value="${item.id }">${item.name }</option>
														</c:forEach>
													</select>
												</td>
										</tr>
										<tr>
											<th><em><font color="red">*</font></em>类型：</th>
											<td>
												<input type="radio"  name="deliverTypehascod" checked="checked" value="0"><span class="fs10 fc_black">货到付款</span>
												<input type="radio"  name="deliverTypehascod" value="1"><span class="fs10 fc_black">先付款后发货</span>
												<input type="hidden" name="hascod" id="hascod" value="0">
											</td>
										</tr>
										<tr>
											<th>重量设置：</th>
											<td><font  style="color: black;font-size: 12px;">首重重量</font>
													<select type="select" name="firstunit" id="firstunit"   class=" x-input-select inputstyle fs10 fc_black">
														<option class="brandOp" value="1">0.5kg</option>
														<option class="brandOp" value="1">1kg</option>
													</select>
												<font  style="color: black;font-size: 12px;">续重重量</font>
													<select type="select" name="continueunit" id="continueunit"   class=" x-input-select inputstyle fs10 fc_black">
														<option class="brandOp" value="1">0.5kg</option>
														<option class="brandOp" value="1">1kg</option>
													</select>
											</td>
										</tr>
									
										<tr>
											<th>默认配送费用：</th>
											<td><font  style="color: black;font-size: 12px;">首重费用</font>
												<input type="value" style="width: 100px;" class="x-input " name="firstprice" id="firstprice" value="0"/>
												<font  style="color: black;font-size: 12px;">续重费用</font>
												<input type="value" style="width: 100px;"  class="x-input " name="continueprice" id="continueprice" value="0">
											</td>
										</tr>
				
										<tr>
											<th>配送方式介绍：</th>
											<td><textarea type="textarea" class="x-input"
													name="content" style="resize:none;" cols="50" rows="5"
													maxth="255" id="dom_el_8bbbb42"></textarea><br />
												<span class="notice-inline"></span></td>
										</tr> 
				
										
									</tbody>
								</table>
								
							</div>
							
						</div>
						
						<div class="member-editwrap2">
								<button class="btn submit-btn" type="button" onclick="saveDeliverType();" rel="_request">
									<span><span>保存</span></span>
								</button>
							</div>
					</form>
				</div>
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
    </body>
</html>
