<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/custom.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.poshytip.min.js" charset="utf-8"></script>
	<link href="${pageContext.request.contextPath}/static/ui-v2/css/nyroModal.css" rel="stylesheet" type="text/css" id="cssfile2">
	<script type="text/javascript">
	    $(function(){
		    $("#submitBtn").click(function(){
		            $("#form_store_verify").submit();
		    });
		    
		    //当入驻状态为待审核时显示
		    if('10'!=null&&'10'!=10){
		       $("#checkstate").hide();
		       $("#submitBtn").hide();
		    } 
	    });
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>店铺</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/store"><span>管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/store/auditlist"><span>开店申请</span></a></li>
            <li><a href="JavaScript:void(0);" class="current"><span>查看</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20" 公司及联系人信息<="" th="">
		</th></tr>
	</thead>
	<tbody>
		<tr style="background: rgb(255, 255, 255);">
			<th class="w150">公司名称：</th>
			<td colspan="20">古玩</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>公司地址：</th>
			<td>上海市市辖区金山区</td>
			<th>公司详细地址：</th>
			<td colspan="20">是打发斯蒂芬</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>联系电话：</th>
			<td>645098712</td>
			<th>员工总数：</th>
			<td>10&nbsp;人</td>
			<th>注册资金：</th>
			<td>100&nbsp;万元 </td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>联系人姓名：</th>
			<td>Smart</td>
			<th>联系电话：</th>
			<td>13849574887</td>
			<th>电子邮箱：</th>
			<td>wym930@126.com</td>
		</tr>
	</tbody>
</table>

<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20">营业执照信息（副本）</th>
		</tr>
	</thead>
	<tbody>
		<tr style="background: rgb(255, 255, 255);">
			<th class="w150">营业执照号：</th>
			<td>wym930@126.com</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">

			<th>营业执照所在地：</th>
			<td>上海市市辖区金山区</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">

			<th>营业执照有效期：</th>
			<td>
	                2016-07-28
            -
	                2016-07-31
			</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>法定经营范围：</th>
			<td colspan="20">艺术品</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>营业执照
				<br> 电子版：
			</th>
			<td colspan="20">
			   <a nctype="nyroModal" href="./管理后台-开店审核_files/1469714086131.JPG">
	            	<img src="./管理后台-开店审核_files/1469714086131.JPG" alt="">
	            </a>
			</td>
		</tr>
	</tbody>
</table>

<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20">组织机构代码证</th>
		</tr>
	</thead>
	<tbody>
		<tr style="background: rgb(255, 255, 255);">
			<th>组织机构代码：</th>
			<td colspan="20">423546564564</td>
		</tr>
		<tr style="background: rgb(255, 255, 255);">
			<th>组织机构代码证
				<br> 电子版：</th>
			<td colspan="20">
				<a nctype="nyroModal" href="./管理后台-开店审核_files/1469714097585.JPG">
	            	<img src="./管理后台-开店审核_files/1469714097585.JPG" alt="">
	            </a>
			</td>
		</tr>
	</tbody>
</table>

<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20">一般纳税人证明：</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>一般纳税人证明：</th>
			<td colspan="20">
				<a nctype="nyroModal" href="./管理后台-开店审核_files/1469714129006.JPG">
	            	<img src="./管理后台-开店审核_files/1469714129006.JPG" alt="">
	            </a>
			</td>
		</tr>
	</tbody>
</table>

<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20">开户银行信息：</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th class="w150">开户银行姓名：</th>
			<td>Smart</td>
		</tr>
		<tr>
			<th>公司银行账号：</th>
			<td>56786445434343434</td>
		</tr>
		<tr>
			<th>开户银行支行名称：</th>
			<td>上海</td>
		</tr>
		<tr>
			<th>支行联行号：</th>
			<td>324556576764564</td>
		</tr>
		<tr>
			<th>开户银行所在地：</th>
			<td colspan="20">上海市市辖区金山区</td>
		</tr>
		<tr>
			<th>开户银行许可证
				<br>电子版：</th>
			<td colspan="20">
				<a nctype="nyroModal" href="./管理后台-开店审核_files/1469714237381.JPG">
	            	<img src="./管理后台-开店审核_files/1469714237381.JPG" alt="">
	            </a>
			</td>
		</tr>
	</tbody>

</table>


electronicedition
		<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
	<thead>
		<tr>
			<th colspan="20">税务登记证号</th>
		</tr>
	</thead>
	<tbody>
		<tr>
            <th class="w150">税务登记证：</th>
			<td>23423425346546</td>
		</tr>
		<tr>
			<th>纳税人识别号：</th>
			<td>342524354356346</td>
		</tr><tr>
			<th>税务登记证号
				<br>电子版：
			</th>
			<td>
				<a nctype="nyroModal" href="./管理后台-开店审核_files/1469714245772.JPG">
	            	<img src="./管理后台-开店审核_files/1469714245772.JPG" alt="">
	            </a>
			</td>
		</tr>
	</tbody>
</table>

<form id="form_store_verify" action="http://b2b2c.leimingtech.com/leimingtech-admin/shopStoreJoinin/saveOrUpdate" method="post">
	<input id="verify_type" name="verify_type" type="hidden">
	<input name="memberId" type="hidden" value="ec21e947c3c44a059957265281e432ee">
	<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
		<thead>
			<tr>
				<th colspan="20">店铺经营信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th class="w150">卖家账号：</th>
				<td>13818847995</td>
			</tr>
			<tr>
				<th class="w150">店铺名称：</th>
				<td>古玩时间</td>
			</tr>
			<tr>
				<th>店铺等级：</th>
				<td>信用店铺</td>
			</tr>
			<tr>
				<th class="w150">开店时长：</th>
				<td>1年</td>
			</tr>
			<tr>
				<th>店铺分类：</th>
				<td>酒类 生鲜 食品（开店保证金：10000元）</td>
			</tr>
		</tbody>
	</table>



    <table border="0" cellpadding="0" cellspacing="0" class="store-joinin" id="checkstate">
        <thead>
        <tr>
            <th colspan="20">审核:</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>审核:</th>
            <td class="vatop rowform onoff" rowspan="4">
                <label for="store_state1" class="cb-enable selected"><span>通过</span></label>
                <label for="store_state0" class="cb-disable"><span>失败</span></label>
                <input id="store_state1" name="joininState" checked="checked" onclick="$(&#39;#nopass2&#39;).hide();" value="20" type="radio">
                <input id="store_state0" name="joininState" onclick="$(&#39;#nopass2&#39;).show();" value="30" type="radio">
            </td>
        </tr>
        <tr class="noborder" id="nopass2" style="display: none;">
            <th>未通过原因:</th>
            <td class="vatop rowform" colspan="4"><textarea name="joininMessage" rows="6" class="tarea" id="store_close_info"></textarea></td>
        </tr>
        </tbody>
    </table>
    <link href="./管理后台-开店审核_files/transport.css" rel="stylesheet" type="text/css">
    <div class="store-joinin">
        <div id="postage-tpl" style="">
            <div id="J_TemplateList" class="manage-list">
                <div class="section J_Section">
                    <div class="tbl-head">
                        <table cellspacing="0" cellpadding="0" border="0">
                            <colgroup>
                                <col class="col-express">
                                <col class="col-starting">
                                <col class="col-postage">
                                <col class="col-area">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th>标题</th>
                                <th>审批人</th>
                                <th>时间</th>
                                <th class="cell-area">审批意见</th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="entity">
                        <table cellspacing="0" cellpadding="0" border="0">
                            <colgroup>
                                <col class="col-express">
                                <col class="col-starting">
                                <col class="col-postage">
                                <col class="col-area">
                            </colgroup>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


        <a href="JavaScript:void(0);" class="btn" id="submitBtn" style="margin-left: 390px;"><span>提交</span></a>
</form>
</div>


</body></html>