<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    
    <title>管理后台</title>
    <link href="${pageContext.request.contextPath}/static/ui-v2/css/skin_0.css" rel="stylesheet" type="text/css" id="cssfile" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/admincp.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common.js"></script>
    
    <script type="text/javascript">
		var APP_BASE = '${pageContext.request.contextPath}';
	   	LOADING_IMAGE = "${pageContext.request.contextPath}/res/images/loading.gif";
	</script>
<link href="./管理后台-运费模板_files/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="./管理后台-运费模板_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-运费模板_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-运费模板_files/jquery.ui.css">
<script type="text/javascript" src="./管理后台-运费模板_files/common_select.js" charset="utf-8"></script>
<script type="text/javascript" src="./管理后台-运费模板_files/dialog.js" id="dialog_js" charset="utf-8"></script><link href="./管理后台-运费模板_files/dialog.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./管理后台-运费模板_files/dialog.css">
<script type="text/javascript" src="./管理后台-运费模板_files/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="./管理后台-运费模板_files/jquery.mousewheel.js"></script>
<link href="./管理后台-运费模板_files/member_store.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板_files/member.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板_files/base.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板_files/transport.css" rel="stylesheet" type="text/css">
<script src="./管理后台-运费模板_files/layer.js"></script><link rel="stylesheet" href="./管理后台-运费模板_files/layer.css" id="layui_layer_skinlayercss">
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>运费模板</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>所有模板</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/platform/transport/toAdd"><span>新增模板</span></a></li>
            </ul>
        </div>
    </div>
    <div id="postage-tpl" style="padding: 20px 0;margin-top: 25px;">
				<div id="J_TemplateList" class="manage-list">
					<div class="section J_Section">
						<div class="tbl-prefix">
							<span class="meta"> 最后编辑时间：<span class="J_LastModified"></span> 
								<a href="javascript:void(0)" data-id="777a6c76f2b648c8bb4985d7c4b30097" onclick="setDefTran(&#39;777a6c76f2b648c8bb4985d7c4b30097&#39;)">设为默认的运费模板</a> | 
							<!-- <a class="J_Clone" href="javascript:void(0)" data-id="15">复制模板</a> |  -->
							<a href="http://b2b2c.leimingtech.com/leimingtech-admin/platform/transport/toEdit?id=777a6c76f2b648c8bb4985d7c4b30097">修改</a> | 
							<a class="J_Delete" href="javascript:void(0)" data-id="777a6c76f2b648c8bb4985d7c4b30097">删除</a></span>
							<h3 class="J_Title">
								测试
							</h3>
							</div>
							<div class="tbl-head">
								<table cellspacing="0" cellpadding="0" border="0">
									<colgroup>
										<col class="col-express">
										<col class="col-area">
										<col class="col-starting">
										<col class="col-postage">
										<col class="col-plus">
										<col class="col-postageplus">
									</colgroup>
									<tbody>
										<tr style="background: rgb(255, 255, 255);">
											<th>运送方式</th>
											<th class="cell-area">运送到</th>
											<th>首件(个)</th>
											<th>运费(元)</th>
											<th>续件(个)</th>
											<th>运费(元)</th>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="entity">
								<table cellspacing="0" cellpadding="0" border="0">
									<colgroup>
										<col class="col-express">
										<col class="col-area">
										<col class="col-starting">
										<col class="col-postage">
										<col class="col-plus">
										<col class="col-postageplus">
									</colgroup>
									<tbody>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															快递
													</td>
													<td class="cell-area">海南省</td>
													<td>1</td>
													<td>20</td>
													<td>1</td>
													<td>20</td>
												</tr>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															快递
													</td>
													<td class="cell-area">市辖区,广州市</td>
													<td>1</td>
													<td>10</td>
													<td>1</td>
													<td>10</td>
												</tr>
												<tr style="background: rgb(251, 251, 251);">
													<td>
															快递
													</td>
													<td class="cell-area">全国</td>
													<td>1</td>
													<td>10</td>
													<td>1</td>
													<td>10</td>
												</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				<div id="J_TemplateList" class="manage-list">
					<div class="section J_Section">
						<div class="tbl-prefix">
							<span class="meta"> 最后编辑时间：<span class="J_LastModified"></span> 
							<!-- <a class="J_Clone" href="javascript:void(0)" data-id="15">复制模板</a> |  -->
							<a href="http://b2b2c.leimingtech.com/leimingtech-admin/platform/transport/toEdit?id=b2d265f74c884aba97cbcaefd68d41c1">修改</a> | 
							<a class="J_Delete" href="javascript:void(0)" data-id="b2d265f74c884aba97cbcaefd68d41c1">删除</a></span>
							<h3 class="J_Title">
								运费模板
									<font style="color: red;">(默认的运费模板)</font>
							</h3>
							</div>
							<div class="tbl-head">
								<table cellspacing="0" cellpadding="0" border="0">
									<colgroup>
										<col class="col-express">
										<col class="col-area">
										<col class="col-starting">
										<col class="col-postage">
										<col class="col-plus">
										<col class="col-postageplus">
									</colgroup>
									<tbody>
										<tr style="background: rgb(255, 255, 255);">
											<th>运送方式</th>
											<th class="cell-area">运送到</th>
											<th>首件(个)</th>
											<th>运费(元)</th>
											<th>续件(个)</th>
											<th>运费(元)</th>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="entity">
								<table cellspacing="0" cellpadding="0" border="0">
									<colgroup>
										<col class="col-express">
										<col class="col-area">
										<col class="col-starting">
										<col class="col-postage">
										<col class="col-plus">
										<col class="col-postageplus">
									</colgroup>
									<tbody>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															快递
													</td>
													<td class="cell-area">北京市</td>
													<td>1</td>
													<td>10</td>
													<td>1</td>
													<td>5</td>
												</tr>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															平邮
													</td>
													<td class="cell-area">广东省</td>
													<td>1</td>
													<td>5</td>
													<td>1</td>
													<td>4</td>
												</tr>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															快递
													</td>
													<td class="cell-area">全国</td>
													<td>1</td>
													<td>15</td>
													<td>1</td>
													<td>5</td>
												</tr>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															平邮
													</td>
													<td class="cell-area">北京市</td>
													<td>1</td>
													<td>8</td>
													<td>1</td>
													<td>3</td>
												</tr>
												<tr style="background: rgb(255, 255, 255);">
													<td>
															平邮
													</td>
													<td class="cell-area">全国</td>
													<td>1</td>
													<td>10</td>
													<td>1</td>
													<td>5</td>
												</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
		</div>
		<script>
		$(function(){	
			$('a[class="J_Delete"]').click(function(){
				var id = $(this).attr('data-id');
				if(typeof(id) == 'undefined') return false;
				if (confirm('确认删除此模板?')){
					var url = '/leimingtech-admin/platform/transport/delete';
					var args = {"transportId":id};
					$.post(url, args, function(data){
						if("success" == data){
							layer.msg("删除成功" , {icon:1});
							setTimeout("ok()",1000); 
						}else{
							layer.msg("删除失败" , {icon:2});
						}
					});
				}
			});
			
			$('a[class="J_Clone"]').click(function(){
				var id = $(this).attr('data-id');
				if(typeof(id) == 'undefined') return false;
				$(this).attr('href','#?act=transport&op=clone&type=&id='+id);
				return true;
			});
			$('a[class="ncu-btn2"]').click(function(){
				var data = $(this).attr('enty-data');
				if(typeof(data) == 'undefined') return false;
				data = data.split('|||');
		//		opener.document.getElementById("postageName").innerHTML=data[0];
				$("#postageName", opener.document).css('display','inline').html(data[0]);
				$("#transport_id", opener.document).val(data[1]);
				window.close();
			});	
			
		});
		
		
		//设置默认运费模板
		function setDefTran(tranId){
			var url = "/leimingtech-admin/platform/transport/setDefaultTransport"
			var args = {"transportId":tranId};
			$.post(url, args, function(data){
				if(data == "success"){
					layer.msg("修改成功" , {icon:1});
					setTimeout("ok()",1000); 
				}else{
					layer.msg("修改失败" , {icon:2});
				}
			});
		}
		
		function ok(){
			window.location.href = '/leimingtech-admin/platform/transport/index';
		}
		</script>
</div>


</body></html>