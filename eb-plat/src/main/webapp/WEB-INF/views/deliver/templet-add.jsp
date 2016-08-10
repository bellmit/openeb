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
<link href="./管理后台-运费模板新增_files/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="./管理后台-运费模板新增_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-运费模板新增_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-运费模板新增_files/jquery.ui.css">
<script type="text/javascript" src="./管理后台-运费模板新增_files/common_select.js" charset="utf-8"></script>
<script type="text/javascript" src="./管理后台-运费模板新增_files/dialog.js" id="dialog_js" charset="utf-8"></script><link href="./管理后台-运费模板新增_files/dialog.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./管理后台-运费模板新增_files/dialog.css">
<script type="text/javascript" src="./管理后台-运费模板新增_files/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="./管理后台-运费模板新增_files/jquery.mousewheel.js"></script>
<!-- css -->
<link href="./管理后台-运费模板新增_files/member_store.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板新增_files/member.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板新增_files/base.css" rel="stylesheet" type="text/css">
<link href="./管理后台-运费模板新增_files/transport.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./管理后台-运费模板新增_files/jquery.js"></script>
<script type="text/javascript" charset="utf-8" src="./管理后台-运费模板新增_files/jquery.validation.min.js"></script>
<script src="./管理后台-运费模板新增_files/layer.js"></script><link rel="stylesheet" href="./管理后台-运费模板新增_files/layer.css" id="layui_layer_skinlayercss">
<script type="text/javascript" src="./管理后台-运费模板新增_files/transport.js" charset="utf-8">
var BASE_PATH = '/leimingtech-admin';
</script>
<script type="text/javascript">
var BASE_PATH = '/leimingtech-admin';
var transportId = "";
</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>运费模板</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/platform/transport/index"><span>所有模板</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增模板</span></a></li>
            </ul>
        </div>
    </div>
			<div class="wrap" style="width: 98%;">
				<div class="tabmenu">
					<ul class="tab pngFix">
						<li class="active"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/transport/index">运费模板</a></li>
					</ul>
				</div>
				<div class="ncu-form-style">
					<div id="dialog_batch" class="ks-ext-position ks-overlay ks-dialog dialog-batch" style="left: 0px; top: 0px; z-index: 9999; display: none">
						<div class="ks-contentbox">
							<div class="ks-stdmod-header"></div>
							<div class="ks-stdmod-body">
								<form method="post">
									默认运费： 
										<input class="w50 text" type="text" maxlength="4" autocomplete="off" data-field="start" value="1" name="express_start"> 件内， 
										<input class="w50 text" type="text" maxlength="6" autocomplete="off" value="0.00" name="express_postage" data-field="postage"> 元， 每增加 
										<input class="w50 text" type="text" maxlength="4" autocomplete="off" value="1" data-field="plus" name="express_plus"> 件，增加运费 
										<input class="w50 text" type="text" maxlength="6" autocomplete="off" value="0.00" data-field="postageplus" name="express_postageplus"> 元
									<div class="J_DefaultMessage"></div>
									<div class="btns">
										<button class="J_SubmitPL" type="button">确定</button>
										<button class="J_Cancel" type="button">取消</button>
									</div>
								</form>
							</div>
							<div class="ks-stdmod-footer"></div>
							<a class="ks-ext-close" href="javascript:void(0)"> <span class="ks-ext-close-x">X</span>
							</a>
						</div>
					</div>
					<form method="post" id="tpl_form" name="tpl_form" action="javascript:void(0);">
						<input type="hidden" name="transport_id" value=""> 
						<input type="hidden" name="form_submit" value="ok"> 
							<input type="hidden" name="type" value="">
						<div class="postage-tpl-head">
							<ul>
								<li class="form-elem"><label for="J_TemplateTitle" class="label-like">模板名称：</label> 
								<input type="text" class="text" autocomplete="off" value="" name="title" style="height: 18px;width: 123px; margin-top: 0px;">
									<p class="msg" style="display: none" error_type="title">
										<span class="error">必须填写模板名称</span>
									</p>
								</li>
								<li class="form-elem express"><span class="label-like">运送方式：</span>
									<span class="field-note">除指定地区外，其余地区的运费采用"默认运费"</span>
									<p class="msg" style="display: none" error_type="trans_type">
										<span class="error">请至少选择一种运送方式</span>
									</p>
								</li>
							</ul>
						</div>
						<!-----------------------POST begin--------------------------------------->
						<div class="postage-tpl" id="py">
							<p class="trans-line">
								<input id="Deliverypy" type="checkbox" value="py" name="tplType[]"> <label for="Deliverypy">平邮</label>
							</p>
						<div style="border: 1px solid #B2D1FF;margin: 5px 0px; padding: 5px;width:674px;" data-delivery="py"><div class="entity"><div class="default J_DefaultSet">默认运费：<input class="w30 mr5 text" type="text" aria-label="默认运费件数" maxlength="4" autocomplete="off" data-field="start" value="1" name="default[py][start]">件内，<input class="w50 mr5 text" type="text" aria-label="默认运费价格" maxlength="6" autocomplete="off" value="" name="default[py][postage]" data-field="postage">元， 每增加<input class="w30 ml5 mr5 text" type="text" aria-label="每加件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="default[py][plus]">件， 增加运费<input class="w50 ml5 mr5 text" type="text" aria-label="加件运费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="default[py][postageplus]">元<div class="J_DefaultMessage"></div></div><div class="tbl-except"><table cellspacing="0" cellpadding="0" border="0">
<colgroup>
<col class="col-area">
<col class="col-start">
<col class="col-postage">
<col class="col-plus">
<col class="col-postageplus">
<col class="col-action">
</colgroup>
<thead>
<tr>
<th>运送到</th>
<th>首件(件)</th>
<th>首费(元)</th>
<th>续件(件)</th>
<th>续费(元)</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<tr rulecellgroup="1" data-group="n1">
<td class="cell-area">
<a class="acc_popup edit J_EditArea" title="编辑运送区域" area-haspopup="true" area-controls="J_DialogArea" entype="J_EditArea" data-acc="event:enter" href="JavaScript:void(0);">编辑</a>
<span class="area-group">
<input class="J_BatchField" style="width:15px;display:none" type="checkbox" value="" name="py_n1">
<p>未添加地区</p></span>
<input type="hidden" value="" name="areas[py][1]">
</td>
<td>
<input class="input-text text" type="text" aria-label="首件" maxlength="4" autocomplete="off" value="1" data-field="start" name="special[py][1][start]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="首费" maxlength="6" autocomplete="off" value="" data-field="postage" name="special[py][1][postage]">
</td>
<td>
<input class="input-text text" type="text" aria-label="续件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="special[py][1][plus]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="续费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="special[py][1][postageplus]">
</td>
<td>
<a class="J_DeleteRule" href="JavaScript:void(0);">删除</a>
</td>
</tr>
</tbody>
</table>
</div><div class="batch" style="display:none"><label><input class="J_BatchCheck" type="checkbox" aria-label="全选" value="" name="">全选</label>&nbsp;<a class="J_BatchSet" href="JavaScript:void(0);">批量设置</a><a class="J_BatchDel" href="JavaScript:void(0);">批量删除</a></div><div class="tbl-attach"><div class="J_SpecialMessage"></div><a class="J_AddRule" href="JavaScript:void(0);">为指定地区城市设置运费</a><a class="J_ToggleBatch" href="JavaScript:void(0);">批量操作</a></div></div></div></div>
						<!-----------------------EXPRESS begin--------------------------------------->
						<div class="postage-tpl" id="kd">
							<p class="trans-line">
								<input id="Deliverykd" type="checkbox" value="kd" name="tplType[]"> <label for="Deliverykd">快递</label>
							</p>
						<div style="border: 1px solid #B2D1FF;margin: 5px 0px; padding: 5px;width:674px;" data-delivery="kd"><div class="entity"><div class="default J_DefaultSet">默认运费：<input class="w30 mr5 text" type="text" aria-label="默认运费件数" maxlength="4" autocomplete="off" data-field="start" value="1" name="default[kd][start]">件内，<input class="w50 mr5 text" type="text" aria-label="默认运费价格" maxlength="6" autocomplete="off" value="" name="default[kd][postage]" data-field="postage">元， 每增加<input class="w30 ml5 mr5 text" type="text" aria-label="每加件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="default[kd][plus]">件， 增加运费<input class="w50 ml5 mr5 text" type="text" aria-label="加件运费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="default[kd][postageplus]">元<div class="J_DefaultMessage"></div></div><div class="tbl-except"><table cellspacing="0" cellpadding="0" border="0">
<colgroup>
<col class="col-area">
<col class="col-start">
<col class="col-postage">
<col class="col-plus">
<col class="col-postageplus">
<col class="col-action">
</colgroup>
<thead>
<tr>
<th>运送到</th>
<th>首件(件)</th>
<th>首费(元)</th>
<th>续件(件)</th>
<th>续费(元)</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<tr rulecellgroup="2" data-group="n2">
<td class="cell-area">
<a class="acc_popup edit J_EditArea" title="编辑运送区域" area-haspopup="true" area-controls="J_DialogArea" entype="J_EditArea" data-acc="event:enter" href="JavaScript:void(0);">编辑</a>
<span class="area-group">
<input class="J_BatchField" style="width:15px;display:none" type="checkbox" value="" name="kd_n2">
<p>未添加地区</p></span>
<input type="hidden" value="" name="areas[kd][2]">
</td>
<td>
<input class="input-text text" type="text" aria-label="首件" maxlength="4" autocomplete="off" value="1" data-field="start" name="special[kd][2][start]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="首费" maxlength="6" autocomplete="off" value="" data-field="postage" name="special[kd][2][postage]">
</td>
<td>
<input class="input-text text" type="text" aria-label="续件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="special[kd][2][plus]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="续费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="special[kd][2][postageplus]">
</td>
<td>
<a class="J_DeleteRule" href="JavaScript:void(0);">删除</a>
</td>
</tr>
</tbody>
</table>
</div><div class="batch" style="display:none"><label><input class="J_BatchCheck" type="checkbox" aria-label="全选" value="" name="">全选</label>&nbsp;<a class="J_BatchSet" href="JavaScript:void(0);">批量设置</a><a class="J_BatchDel" href="JavaScript:void(0);">批量删除</a></div><div class="tbl-attach"><div class="J_SpecialMessage"></div><a class="J_AddRule" href="JavaScript:void(0);">为指定地区城市设置运费</a><a class="J_ToggleBatch" href="JavaScript:void(0);">批量操作</a></div></div></div></div>
						<!-----------------------EMS begin--------------------------------------->
						<div class="postage-tpl" id="es">
							<p class="trans-line">
								<input id="Deliveryes" type="checkbox" value="es" name="tplType[]"> <label for="Deliveryes">EMS</label>
							</p>
						<div style="border: 1px solid #B2D1FF;margin: 5px 0px; padding: 5px;width:674px;" data-delivery="es"><div class="entity"><div class="default J_DefaultSet">默认运费：<input class="w30 mr5 text" type="text" aria-label="默认运费件数" maxlength="4" autocomplete="off" data-field="start" value="1" name="default[es][start]">件内，<input class="w50 mr5 text" type="text" aria-label="默认运费价格" maxlength="6" autocomplete="off" value="" name="default[es][postage]" data-field="postage">元， 每增加<input class="w30 ml5 mr5 text" type="text" aria-label="每加件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="default[es][plus]">件， 增加运费<input class="w50 ml5 mr5 text" type="text" aria-label="加件运费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="default[es][postageplus]">元<div class="J_DefaultMessage"></div></div><div class="tbl-except"><table cellspacing="0" cellpadding="0" border="0">
<colgroup>
<col class="col-area">
<col class="col-start">
<col class="col-postage">
<col class="col-plus">
<col class="col-postageplus">
<col class="col-action">
</colgroup>
<thead>
<tr>
<th>运送到</th>
<th>首件(件)</th>
<th>首费(元)</th>
<th>续件(件)</th>
<th>续费(元)</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<tr rulecellgroup="3" data-group="n3">
<td class="cell-area">
<a class="acc_popup edit J_EditArea" title="编辑运送区域" area-haspopup="true" area-controls="J_DialogArea" entype="J_EditArea" data-acc="event:enter" href="JavaScript:void(0);">编辑</a>
<span class="area-group">
<input class="J_BatchField" style="width:15px;display:none" type="checkbox" value="" name="es_n3">
<p>未添加地区</p></span>
<input type="hidden" value="" name="areas[es][3]">
</td>
<td>
<input class="input-text text" type="text" aria-label="首件" maxlength="4" autocomplete="off" value="1" data-field="start" name="special[es][3][start]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="首费" maxlength="6" autocomplete="off" value="" data-field="postage" name="special[es][3][postage]">
</td>
<td>
<input class="input-text text" type="text" aria-label="续件" maxlength="4" autocomplete="off" value="1" data-field="plus" name="special[es][3][plus]">
</td>
<td>
<input class="w50 mr5 text" type="text" aria-label="续费" maxlength="6" autocomplete="off" value="" data-field="postageplus" name="special[es][3][postageplus]">
</td>
<td>
<a class="J_DeleteRule" href="JavaScript:void(0);">删除</a>
</td>
</tr>
</tbody>
</table>
</div><div class="batch" style="display:none"><label><input class="J_BatchCheck" type="checkbox" aria-label="全选" value="" name="">全选</label>&nbsp;<a class="J_BatchSet" href="JavaScript:void(0);">批量设置</a><a class="J_BatchDel" href="JavaScript:void(0);">批量删除</a></div><div class="tbl-attach"><div class="J_SpecialMessage"></div><a class="J_AddRule" href="JavaScript:void(0);">为指定地区城市设置运费</a><a class="J_ToggleBatch" href="JavaScript:void(0);">批量操作</a></div></div></div></div>
						<!-----------------------EMS end--------------------------------------->
						<div class="trans-submit">
							<input type="submit" id="submit_tpl" class="submit" value="保存">
						</div>
					</form>

				</div>
				<div class="ks-ext-mask" style="position: absolute; left: 0px; top: 0px; width: 100%; height: 5000px; z-index: 9998; display: none"></div>
			</div>
			<div id="dialog_areas" class="ks-ext-position ks-overlay ks-dialog dialog-areas" style="left: 112px; top: 307.583px; z-index: 9999; display: none;width:600px;">
				<div class="ks-contentbox">
					<div class="ks-stdmod-header">
						<div class="title">选择区域</div>
					</div>
					<div class="ks-stdmod-body">
						<form method="post">
							<ul id="J_CityList">
								<style type="text/css">
									em.zt {
										font-size: 0;
										line-height: 0;
										width: 0;
										height: 0;
										display: inline-block;
										padding: 0;
										border: 4px solid;
										border-color: #333 transparent transparent transparent; /
										border-style: solid dashed dashed dashed;
									}
								</style>
								<li>
									<div class=" dcity clearfix">
										<div class="province-list" style="width:600px;">
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_11" value="11"> 
													<label for="J_Province_11">北京市</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1101" value="1101">
															<label for="J_City_1101">市辖区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1102" value="1102">
															<label for="J_City_1102">县</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_44" value="44"> 
													<label for="J_Province_44">广东省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4401" value="4401">
															<label for="J_City_4401">广州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4415" value="4415">
															<label for="J_City_4415">汕尾市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4416" value="4416">
															<label for="J_City_4416">河源市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4417" value="4417">
															<label for="J_City_4417">阳江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4418" value="4418">
															<label for="J_City_4418">清远市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4419" value="4419">
															<label for="J_City_4419">东莞市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4420" value="4420">
															<label for="J_City_4420">中山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4451" value="4451">
															<label for="J_City_4451">潮州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4452" value="4452">
															<label for="J_City_4452">揭阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4414" value="4414">
															<label for="J_City_4414">梅州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4413" value="4413">
															<label for="J_City_4413">惠州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4412" value="4412">
															<label for="J_City_4412">肇庆市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4402" value="4402">
															<label for="J_City_4402">韶关市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4403" value="4403">
															<label for="J_City_4403">深圳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4404" value="4404">
															<label for="J_City_4404">珠海市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4405" value="4405">
															<label for="J_City_4405">汕头市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4406" value="4406">
															<label for="J_City_4406">佛山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4407" value="4407">
															<label for="J_City_4407">江门市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4408" value="4408">
															<label for="J_City_4408">湛江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4409" value="4409">
															<label for="J_City_4409">茂名市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4453" value="4453">
															<label for="J_City_4453">云浮市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_45" value="45"> 
													<label for="J_Province_45">广西壮族自治区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4501" value="4501">
															<label for="J_City_4501">南宁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4513" value="4513">
															<label for="J_City_4513">来宾市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4512" value="4512">
															<label for="J_City_4512">河池市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4511" value="4511">
															<label for="J_City_4511">贺州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4510" value="4510">
															<label for="J_City_4510">百色市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4509" value="4509">
															<label for="J_City_4509">玉林市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4508" value="4508">
															<label for="J_City_4508">贵港市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4507" value="4507">
															<label for="J_City_4507">钦州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4506" value="4506">
															<label for="J_City_4506">防城港市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4505" value="4505">
															<label for="J_City_4505">北海市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4504" value="4504">
															<label for="J_City_4504">梧州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4503" value="4503">
															<label for="J_City_4503">桂林市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4502" value="4502">
															<label for="J_City_4502">柳州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4514" value="4514">
															<label for="J_City_4514">崇左市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_46" value="46"> 
													<label for="J_Province_46">海南省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4601" value="4601">
															<label for="J_City_4601">海口市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4602" value="4602">
															<label for="J_City_4602">三亚市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4690" value="4690">
															<label for="J_City_4690">省属虚拟市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_50" value="50"> 
													<label for="J_Province_50">重庆市</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5001" value="5001">
															<label for="J_City_5001">市辖区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5002" value="5002">
															<label for="J_City_5002">县</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_51" value="51"> 
													<label for="J_Province_51">四川省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5101" value="5101">
															<label for="J_City_5101">成都市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5115" value="5115">
															<label for="J_City_5115">宜宾市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5116" value="5116">
															<label for="J_City_5116">广安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5117" value="5117">
															<label for="J_City_5117">达州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5118" value="5118">
															<label for="J_City_5118">雅安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5119" value="5119">
															<label for="J_City_5119">巴中市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5120" value="5120">
															<label for="J_City_5120">资阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5132" value="5132">
															<label for="J_City_5132">阿坝州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5133" value="5133">
															<label for="J_City_5133">甘孜藏族自治州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5114" value="5114">
															<label for="J_City_5114">眉山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5113" value="5113">
															<label for="J_City_5113">南充市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5111" value="5111">
															<label for="J_City_5111">乐山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5103" value="5103">
															<label for="J_City_5103">自贡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5104" value="5104">
															<label for="J_City_5104">攀枝花市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5105" value="5105">
															<label for="J_City_5105">泸州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5106" value="5106">
															<label for="J_City_5106">德阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5107" value="5107">
															<label for="J_City_5107">绵阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5108" value="5108">
															<label for="J_City_5108">广元市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5109" value="5109">
															<label for="J_City_5109">遂宁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5110" value="5110">
															<label for="J_City_5110">内江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5134" value="5134">
															<label for="J_City_5134">凉山州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_52" value="52"> 
													<label for="J_Province_52">贵州省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5201" value="5201">
															<label for="J_City_5201">贵阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5202" value="5202">
															<label for="J_City_5202">六盘水市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5203" value="5203">
															<label for="J_City_5203">遵义市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5204" value="5204">
															<label for="J_City_5204">安顺市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5222" value="5222">
															<label for="J_City_5222">铜仁地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5223" value="5223">
															<label for="J_City_5223">黔西南州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5224" value="5224">
															<label for="J_City_5224">毕节地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5226" value="5226">
															<label for="J_City_5226">黔东南苗族侗族自治州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5227" value="5227">
															<label for="J_City_5227">黔南布依族苗族自治州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_53" value="53"> 
													<label for="J_Province_53">云南省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5301" value="5301">
															<label for="J_City_5301">昆明市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5333" value="5333">
															<label for="J_City_5333">怒江州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5331" value="5331">
															<label for="J_City_5331">德宏州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5329" value="5329">
															<label for="J_City_5329">大理州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5328" value="5328">
															<label for="J_City_5328">西双版纳州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5326" value="5326">
															<label for="J_City_5326">文山州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5325" value="5325">
															<label for="J_City_5325">红河州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5323" value="5323">
															<label for="J_City_5323">楚雄州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5309" value="5309">
															<label for="J_City_5309">临沧市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5308" value="5308">
															<label for="J_City_5308">思茅市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5307" value="5307">
															<label for="J_City_5307">丽江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5306" value="5306">
															<label for="J_City_5306">昭通市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5305" value="5305">
															<label for="J_City_5305">保山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5304" value="5304">
															<label for="J_City_5304">玉溪市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5303" value="5303">
															<label for="J_City_5303">曲靖市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5334" value="5334">
															<label for="J_City_5334">迪庆州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_54" value="54"> 
													<label for="J_Province_54">西藏自治区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5401" value="5401">
															<label for="J_City_5401">拉萨市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5421" value="5421">
															<label for="J_City_5421">昌都地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5422" value="5422">
															<label for="J_City_5422">山南地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5423" value="5423">
															<label for="J_City_5423">日喀则地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5424" value="5424">
															<label for="J_City_5424">那曲地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5425" value="5425">
															<label for="J_City_5425">阿里地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_5426" value="5426">
															<label for="J_City_5426">林芝地区</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_61" value="61"> 
													<label for="J_Province_61">陕西省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6101" value="6101">
															<label for="J_City_6101">西安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6109" value="6109">
															<label for="J_City_6109">安康市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6108" value="6108">
															<label for="J_City_6108">榆林市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6107" value="6107">
															<label for="J_City_6107">汉中市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6106" value="6106">
															<label for="J_City_6106">延安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6105" value="6105">
															<label for="J_City_6105">渭南市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6104" value="6104">
															<label for="J_City_6104">咸阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6103" value="6103">
															<label for="J_City_6103">宝鸡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6102" value="6102">
															<label for="J_City_6102">铜川市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6110" value="6110">
															<label for="J_City_6110">商洛市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_62" value="62"> 
													<label for="J_Province_62">甘肃省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6201" value="6201">
															<label for="J_City_6201">兰州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6229" value="6229">
															<label for="J_City_6229">临夏州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6212" value="6212">
															<label for="J_City_6212">陇南市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6211" value="6211">
															<label for="J_City_6211">定西市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6210" value="6210">
															<label for="J_City_6210">庆阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6209" value="6209">
															<label for="J_City_6209">酒泉市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6208" value="6208">
															<label for="J_City_6208">平凉市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6207" value="6207">
															<label for="J_City_6207">张掖市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6206" value="6206">
															<label for="J_City_6206">武威市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6205" value="6205">
															<label for="J_City_6205">天水市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6204" value="6204">
															<label for="J_City_6204">白银市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6203" value="6203">
															<label for="J_City_6203">金昌市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6202" value="6202">
															<label for="J_City_6202">嘉峪关市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6230" value="6230">
															<label for="J_City_6230">甘南州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_63" value="63"> 
													<label for="J_Province_63">青海省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6301" value="6301">
															<label for="J_City_6301">西宁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6321" value="6321">
															<label for="J_City_6321">海东地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6322" value="6322">
															<label for="J_City_6322">海北州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6323" value="6323">
															<label for="J_City_6323">黄南州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6325" value="6325">
															<label for="J_City_6325">海南州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6326" value="6326">
															<label for="J_City_6326">果洛州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6327" value="6327">
															<label for="J_City_6327">玉树州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6328" value="6328">
															<label for="J_City_6328">海西州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_64" value="64"> 
													<label for="J_Province_64">宁夏回族自治区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6401" value="6401">
															<label for="J_City_6401">银川市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6402" value="6402">
															<label for="J_City_6402">石嘴山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6403" value="6403">
															<label for="J_City_6403">吴忠市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6404" value="6404">
															<label for="J_City_6404">固原市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6405" value="6405">
															<label for="J_City_6405">中卫市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_65" value="65"> 
													<label for="J_Province_65">新疆维吾尔自治区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6501" value="6501">
															<label for="J_City_6501">乌鲁木齐市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6543" value="6543">
															<label for="J_City_6543">阿勒泰地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6542" value="6542">
															<label for="J_City_6542">塔城地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6540" value="6540">
															<label for="J_City_6540">伊犁州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6532" value="6532">
															<label for="J_City_6532">和田地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6531" value="6531">
															<label for="J_City_6531">喀什地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6530" value="6530">
															<label for="J_City_6530">克州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6529" value="6529">
															<label for="J_City_6529">阿克苏地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6528" value="6528">
															<label for="J_City_6528">巴音郭楞蒙古自治州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6527" value="6527">
															<label for="J_City_6527">博尔塔拉蒙古自治州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6523" value="6523">
															<label for="J_City_6523">昌吉州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6522" value="6522">
															<label for="J_City_6522">哈密地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6521" value="6521">
															<label for="J_City_6521">吐鲁番地区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6502" value="6502">
															<label for="J_City_6502">克拉玛依市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_6590" value="6590">
															<label for="J_City_6590">省直辖行政单位</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_71" value="71"> 
													<label for="J_Province_71">台湾省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_81" value="81"> 
													<label for="J_Province_81">香港特别行政区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_43" value="43"> 
													<label for="J_Province_43">湖南省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4301" value="4301">
															<label for="J_City_4301">长沙市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4313" value="4313">
															<label for="J_City_4313">娄底市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4312" value="4312">
															<label for="J_City_4312">怀化市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4311" value="4311">
															<label for="J_City_4311">永州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4310" value="4310">
															<label for="J_City_4310">郴州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4309" value="4309">
															<label for="J_City_4309">益阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4308" value="4308">
															<label for="J_City_4308">张家界市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4307" value="4307">
															<label for="J_City_4307">常德市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4306" value="4306">
															<label for="J_City_4306">岳阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4305" value="4305">
															<label for="J_City_4305">邵阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4304" value="4304">
															<label for="J_City_4304">衡阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4303" value="4303">
															<label for="J_City_4303">湘潭市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4302" value="4302">
															<label for="J_City_4302">株洲市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4331" value="4331">
															<label for="J_City_4331">湘西土家族苗族自治州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_42" value="42"> 
													<label for="J_Province_42">湖北省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4201" value="4201">
															<label for="J_City_4201">武汉市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4228" value="4228">
															<label for="J_City_4228">恩施州</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4213" value="4213">
															<label for="J_City_4213">随州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4212" value="4212">
															<label for="J_City_4212">咸宁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4211" value="4211">
															<label for="J_City_4211">黄冈市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4210" value="4210">
															<label for="J_City_4210">荆州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4209" value="4209">
															<label for="J_City_4209">孝感市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4208" value="4208">
															<label for="J_City_4208">荆门市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4207" value="4207">
															<label for="J_City_4207">鄂州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4206" value="4206">
															<label for="J_City_4206">襄樊市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4205" value="4205">
															<label for="J_City_4205">宜昌市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4203" value="4203">
															<label for="J_City_4203">十堰市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4202" value="4202">
															<label for="J_City_4202">黄石市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4290" value="4290">
															<label for="J_City_4290">省直辖行政单位</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_12" value="12"> 
													<label for="J_Province_12">天津市</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1201" value="1201">
															<label for="J_City_1201">市辖区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1202" value="1202">
															<label for="J_City_1202">市辖县</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_13" value="13"> 
													<label for="J_Province_13">河北省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1301" value="1301">
															<label for="J_City_1301">石家庄市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1310" value="1310">
															<label for="J_City_1310">廊坊市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1309" value="1309">
															<label for="J_City_1309">沧州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1308" value="1308">
															<label for="J_City_1308">承德市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1307" value="1307">
															<label for="J_City_1307">张家口市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1306" value="1306">
															<label for="J_City_1306">保定市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1305" value="1305">
															<label for="J_City_1305">邢台市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1304" value="1304">
															<label for="J_City_1304">邯郸市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1303" value="1303">
															<label for="J_City_1303">秦皇岛市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1302" value="1302">
															<label for="J_City_1302">唐山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1311" value="1311">
															<label for="J_City_1311">衡水市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_14" value="14"> 
													<label for="J_Province_14">山西</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1401" value="1401">
															<label for="J_City_1401">太原市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1410" value="1410">
															<label for="J_City_1410">临汾市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1409" value="1409">
															<label for="J_City_1409">忻州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1408" value="1408">
															<label for="J_City_1408">运城市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1407" value="1407">
															<label for="J_City_1407">晋中市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1406" value="1406">
															<label for="J_City_1406">朔州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1405" value="1405">
															<label for="J_City_1405">晋城市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1404" value="1404">
															<label for="J_City_1404">长治市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1403" value="1403">
															<label for="J_City_1403">阳泉市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1402" value="1402">
															<label for="J_City_1402">大同市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1411" value="1411">
															<label for="J_City_1411">吕梁市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_15" value="15"> 
													<label for="J_Province_15">内蒙古自治区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1501" value="1501">
															<label for="J_City_1501">呼和浩特市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1525" value="1525">
															<label for="J_City_1525">锡林郭勒盟</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1522" value="1522">
															<label for="J_City_1522">兴安盟</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1509" value="1509">
															<label for="J_City_1509">乌兰察布市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1508" value="1508">
															<label for="J_City_1508">巴彦淖尔市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1507" value="1507">
															<label for="J_City_1507">呼伦贝尔市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1506" value="1506">
															<label for="J_City_1506">鄂尔多斯市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1505" value="1505">
															<label for="J_City_1505">通辽市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1504" value="1504">
															<label for="J_City_1504">赤峰市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1503" value="1503">
															<label for="J_City_1503">乌海市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1502" value="1502">
															<label for="J_City_1502">包头市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_1529" value="1529">
															<label for="J_City_1529">阿拉善盟</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_21" value="21"> 
													<label for="J_Province_21">辽宁省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2101" value="2101">
															<label for="J_City_2101">沈阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2113" value="2113">
															<label for="J_City_2113">朝阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2112" value="2112">
															<label for="J_City_2112">铁岭市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2111" value="2111">
															<label for="J_City_2111">盘锦市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2110" value="2110">
															<label for="J_City_2110">辽阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2109" value="2109">
															<label for="J_City_2109">阜新市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2108" value="2108">
															<label for="J_City_2108">营口市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2107" value="2107">
															<label for="J_City_2107">锦州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2106" value="2106">
															<label for="J_City_2106">丹东市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2105" value="2105">
															<label for="J_City_2105">本溪市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2104" value="2104">
															<label for="J_City_2104">抚顺市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2103" value="2103">
															<label for="J_City_2103">鞍山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2102" value="2102">
															<label for="J_City_2102">大连市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2114" value="2114">
															<label for="J_City_2114">葫芦岛市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_22" value="22"> 
													<label for="J_Province_22">吉林省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2201" value="2201">
															<label for="J_City_2201">长春市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2202" value="2202">
															<label for="J_City_2202">吉林市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2203" value="2203">
															<label for="J_City_2203">四平市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2204" value="2204">
															<label for="J_City_2204">辽源市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2205" value="2205">
															<label for="J_City_2205">通化市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2206" value="2206">
															<label for="J_City_2206">白山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2207" value="2207">
															<label for="J_City_2207">松原市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2208" value="2208">
															<label for="J_City_2208">白城市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2224" value="2224">
															<label for="J_City_2224">延边朝鲜族自治州</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_23" value="23"> 
													<label for="J_Province_23">黑龙江省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2301" value="2301">
															<label for="J_City_2301">哈尔滨市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2312" value="2312">
															<label for="J_City_2312">绥化市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2311" value="2311">
															<label for="J_City_2311">黑河市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2310" value="2310">
															<label for="J_City_2310">牡丹江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2309" value="2309">
															<label for="J_City_2309">七台河市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2308" value="2308">
															<label for="J_City_2308">佳木斯市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2307" value="2307">
															<label for="J_City_2307">伊春市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2306" value="2306">
															<label for="J_City_2306">大庆市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2305" value="2305">
															<label for="J_City_2305">双鸭山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2304" value="2304">
															<label for="J_City_2304">鹤岗市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2303" value="2303">
															<label for="J_City_2303">鸡西市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2302" value="2302">
															<label for="J_City_2302">齐齐哈尔市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_2327" value="2327">
															<label for="J_City_2327">大兴安岭地区</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_31" value="31"> 
													<label for="J_Province_31">上海市</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3101" value="3101">
															<label for="J_City_3101">市辖区</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3102" value="3102">
															<label for="J_City_3102">县</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_32" value="32"> 
													<label for="J_Province_32">江苏省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3201" value="3201">
															<label for="J_City_3201">南京市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3212" value="3212">
															<label for="J_City_3212">泰州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3211" value="3211">
															<label for="J_City_3211">镇江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3210" value="3210">
															<label for="J_City_3210">扬州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3209" value="3209">
															<label for="J_City_3209">盐城市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3208" value="3208">
															<label for="J_City_3208">淮安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3207" value="3207">
															<label for="J_City_3207">连云港市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3206" value="3206">
															<label for="J_City_3206">南通市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3205" value="3205">
															<label for="J_City_3205">苏州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3204" value="3204">
															<label for="J_City_3204">常州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3203" value="3203">
															<label for="J_City_3203">徐州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3202" value="3202">
															<label for="J_City_3202">无锡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3213" value="3213">
															<label for="J_City_3213">宿迁市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_33" value="33"> 
													<label for="J_Province_33">浙江省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3301" value="3301">
															<label for="J_City_3301">杭州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3310" value="3310">
															<label for="J_City_3310">台州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3309" value="3309">
															<label for="J_City_3309">舟山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3308" value="3308">
															<label for="J_City_3308">衢州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3307" value="3307">
															<label for="J_City_3307">金华市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3306" value="3306">
															<label for="J_City_3306">绍兴市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3305" value="3305">
															<label for="J_City_3305">湖州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3304" value="3304">
															<label for="J_City_3304">嘉兴市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3303" value="3303">
															<label for="J_City_3303">温州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3302" value="3302">
															<label for="J_City_3302">宁波市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3311" value="3311">
															<label for="J_City_3311">丽水市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_34" value="34"> 
													<label for="J_Province_34">安徽省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3401" value="3401">
															<label for="J_City_3401">合肥市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3417" value="3417">
															<label for="J_City_3417">池州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3416" value="3416">
															<label for="J_City_3416">亳州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3415" value="3415">
															<label for="J_City_3415">六安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3414" value="3414">
															<label for="J_City_3414">巢湖市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3413" value="3413">
															<label for="J_City_3413">宿州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3412" value="3412">
															<label for="J_City_3412">阜阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3411" value="3411">
															<label for="J_City_3411">滁州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3410" value="3410">
															<label for="J_City_3410">黄山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3408" value="3408">
															<label for="J_City_3408">安庆市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3407" value="3407">
															<label for="J_City_3407">铜陵市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3406" value="3406">
															<label for="J_City_3406">淮北市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3405" value="3405">
															<label for="J_City_3405">马鞍山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3404" value="3404">
															<label for="J_City_3404">淮南市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3403" value="3403">
															<label for="J_City_3403">蚌埠市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3402" value="3402">
															<label for="J_City_3402">芜湖市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3418" value="3418">
															<label for="J_City_3418">宣城市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_35" value="35"> 
													<label for="J_Province_35">福建省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3501" value="3501">
															<label for="J_City_3501">福州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3502" value="3502">
															<label for="J_City_3502">厦门市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3503" value="3503">
															<label for="J_City_3503">莆田市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3504" value="3504">
															<label for="J_City_3504">三明市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3505" value="3505">
															<label for="J_City_3505">泉州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3506" value="3506">
															<label for="J_City_3506">漳州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3507" value="3507">
															<label for="J_City_3507">南平市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3508" value="3508">
															<label for="J_City_3508">龙岩市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3509" value="3509">
															<label for="J_City_3509">宁德市　</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_36" value="36"> 
													<label for="J_Province_36">江西省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3601" value="3601">
															<label for="J_City_3601">南昌市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3610" value="3610">
															<label for="J_City_3610">抚州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3609" value="3609">
															<label for="J_City_3609">宜春市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3608" value="3608">
															<label for="J_City_3608">吉安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3607" value="3607">
															<label for="J_City_3607">赣州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3606" value="3606">
															<label for="J_City_3606">鹰潭市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3605" value="3605">
															<label for="J_City_3605">新余市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3604" value="3604">
															<label for="J_City_3604">九江市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3603" value="3603">
															<label for="J_City_3603">萍乡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3602" value="3602">
															<label for="J_City_3602">景德镇市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3611" value="3611">
															<label for="J_City_3611">上饶市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_37" value="37"> 
													<label for="J_Province_37">山东省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3701" value="3701">
															<label for="J_City_3701">济南市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3716" value="3716">
															<label for="J_City_3716">滨州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3715" value="3715">
															<label for="J_City_3715">聊城市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3714" value="3714">
															<label for="J_City_3714">德州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3713" value="3713">
															<label for="J_City_3713">临沂市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3712" value="3712">
															<label for="J_City_3712">莱芜市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3711" value="3711">
															<label for="J_City_3711">日照市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3710" value="3710">
															<label for="J_City_3710">威海市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3709" value="3709">
															<label for="J_City_3709">泰安市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3708" value="3708">
															<label for="J_City_3708">济宁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3707" value="3707">
															<label for="J_City_3707">潍坊市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3706" value="3706">
															<label for="J_City_3706">烟台市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3705" value="3705">
															<label for="J_City_3705">东营市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3704" value="3704">
															<label for="J_City_3704">枣庄市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3703" value="3703">
															<label for="J_City_3703">淄博市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3702" value="3702">
															<label for="J_City_3702">青岛市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_3717" value="3717">
															<label for="J_City_3717">菏泽市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_41" value="41"> 
													<label for="J_Province_41">河南省</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4101" value="4101">
															<label for="J_City_4101">郑州市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4116" value="4116">
															<label for="J_City_4116">周口市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4115" value="4115">
															<label for="J_City_4115">信阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4114" value="4114">
															<label for="J_City_4114">商丘市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4113" value="4113">
															<label for="J_City_4113">南阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4112" value="4112">
															<label for="J_City_4112">三门峡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4111" value="4111">
															<label for="J_City_4111">漯河市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4110" value="4110">
															<label for="J_City_4110">许昌市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4109" value="4109">
															<label for="J_City_4109">濮阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4108" value="4108">
															<label for="J_City_4108">焦作市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4107" value="4107">
															<label for="J_City_4107">新乡市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4106" value="4106">
															<label for="J_City_4106">鹤壁市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4105" value="4105">
															<label for="J_City_4105">安阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4104" value="4104">
															<label for="J_City_4104">平顶山市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4103" value="4103">
															<label for="J_City_4103">洛阳市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4102" value="4102">
															<label for="J_City_4102">开封市</label>
															</span> 
															<span class="areas">
															<input type="checkbox" class="J_City" id="J_City_4117" value="4117">
															<label for="J_City_4117">驻马店市</label>
															</span> 
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
												<div class="ecity" style="width: 140px;margin-right:0px;">
													<span class="gareas"> <input type="checkbox" class="J_Province" id="J_Province_82" value="82"> 
													<label for="J_Province_82">澳门特别行政区</label> 
													<span class="check_num">
													</span><em class="zt trigger"></em>
													<div class="citys">
														<p style="text-align: right;">
															<input type="button" class="close_button" value="关闭">
														</p>
													</div>
													</span>
												</div>
										</div>
									</div>
								</li>
							</ul>
							<div class="btns">
								<button class="J_Submit" type="button">确定</button>
								<button class="J_Cancel" type="button">取消</button>
							</div>
						</form>
					</div>
					<div class="ks-stdmod-footer">
						<a class="ks-ext-close" href="javascript:void(0)"><span class="ks-ext-close-x">X</span></a>
					</div>
				</div>
			</div>
	<script>
	$(function(){
		$('div[class="postage-tpl"]').each(function(){
			var tplType = $(this).find('input[name="tplType[]"]').attr('value');
		});
	
	});
	</script>
			</div>



</body></html>