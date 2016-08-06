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
	
<script type="text/javascript" src="./管理后台-查看店铺_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-查看店铺_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-查看店铺_files/jquery.ui.css">
<script type="text/javascript" src="./管理后台-查看店铺_files/jquery.edit.js"></script>
<script type="text/javascript" src="./管理后台-查看店铺_files/custom.min.js" charset="utf-8"></script>
<script type="text/javascript" src="./管理后台-查看店铺_files/jquery.poshytip.min.js" charset="utf-8"></script>
<link href="./管理后台-查看店铺_files/nyroModal.css" rel="stylesheet" type="text/css" id="cssfile2">
<script type="text/javascript">
   /*  $(document).ready(function(){
        $('a[nctype="nyroModal"]').nyroModal();

        $('#btn_fail').on('click', function() {
            if($('#joinin_message').val() == '') {
                $('#validation_message').text('请输入审核意见');
                $('#validation_message').show();
                return false;
            } else {
                $('#validation_message').hide();
            }
            if(confirm('确认拒绝申请？')) {
                $('#verify_type').val('fail');
                $('#form_store_verify').submit();
            }
        });
        var commisRate = '';
        $('#btn_pass').on('click', function() {
            var valid = true;
            $('[nctype="commis_rate"]').each(function(commis_rate) {
                rate = $(this).val();
                if(rate == '') {
                    valid = false;
                    return false;
                }
                var rate = Number($(this).val());
                if(isNaN(rate) || rate< 0 || rate >= 100) {
                    valid = false;
                    return false;
                }else{
                    commisRate += rate + ",";
                }
            });
            if(valid) {
                $('#validation_message').hide();
                if(confirm('确认通过申请？')) {
                    $('#verify_type').val('pass');
                    $("#commisRate").val(commisRate.substring(0,commisRate.length-1));
                    $('#form_store_verify').submit();
                }
            } else {
                $('#validation_message').text('请正确填写分佣比例');
                $('#validation_message').show();
            }
        });
    }); */
    $(function(){
	    $("#submitBtn").click(function(){
	            $("#form_store_verify").submit();
	    });
	    var storeState=$("#storeState").val();
	    if(storeState!=null&&storeState!=2){
	       $("#checkstate").hide();
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
            <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/manager/list"><span>管理</span></a></li>
            <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/store/manager/auditList"><span>开店申请</span></a></li>
            <li><a href="JavaScript:void(0);" class="current"><span>查看店铺</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
    <thead>
    <tr>
        <th colspan="20">公司及联系人信息</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>公司名称：</th>
        <td>
           平台自营
           <input type="hidden" id="storeState" value="1">
        </td>
        <th>账号：</th>
        <td colspan="20">pintaiziying</td>
    </tr>
    <tr style="background: rgb(255, 255, 255);">
        <th>公司所在地：</th>
        <td>北京北京市</td>
        <th>公司详细地址：</th>
        <td colspan="20">朝阳区</td>
    </tr>
    <tr style="background: rgb(255, 255, 255);">
        <th>联系电话：</th>
        <td>15932110597</td>
        <th>邮政编码：</th>
        <td>100000</td>
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
    <tr style="background: rgb(251, 251, 251);">
        <th>营业执照号<br>
            电子版：</th>
        <td colspan="20">
            <a nctype="nyroModal" href="./管理后台-查看店铺_files/saved_resource">
            <img src="./管理后台-查看店铺_files/saved_resource" alt=""> </a>
        </td>
    </tr>
    </tbody>
</table>



<form id="form_store_verify" action="http://b2b2c.leimingtech.com/leimingtech-admin/store/manager/verify" method="post">
    <input name="memberId" type="hidden" value="0">
    <input name="storeId" id="storeId" type="hidden" value="0">
    <input name="storeClassCommisRates" type="hidden" id="commisRate">
    <table border="0" cellpadding="0" cellspacing="0" class="store-joinin">
        <thead>
        <tr>
            <th colspan="20">店铺经营信息</th>
        </tr>
        </thead>
        <tbody>
        <tr style="background: rgb(255, 255, 255);">
            <th class="w150">店铺名称：</th>
            <td>平台自营</td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>店铺等级：</th>
            <td>钻石店铺</td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>主营商品：</th>
            <td></td>
        </tr>
        <tr>
            <th>店铺分类：</th>
            <td></td>
        </tr>
        <tr>
            <th>身份证号：</th>
            <td></td>
        </tr>
         <tr>
	        <th>身份证电子版：</th>
	        <td colspan="20">
	            <a nctype="nyroModal" href="./管理后台-查看店铺_files/saved_resource">
	            <img src="./管理后台-查看店铺_files/saved_resource" alt=""> </a>
	        </td>
        </tr>
        </tbody>
    </table>
   <table border="0" cellpadding="0" cellspacing="0" class="store-joinin" id="checkstate" style="display: none;">
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
		                <input id="store_state1" name="storeState" checked="checked" onclick="$(&#39;#nopass2&#39;).hide();" value="1" type="radio">
		                <input id="store_state0" name="storeState" onclick="$(&#39;#nopass2&#39;).show();" value="0" type="radio">
	            </td>
	        </tr>
	        <tr class="noborder" id="nopass2" style="display: none;">
	            <th>未通过原因:</th>
	            <td class="vatop rowform" colspan="4"><textarea name="storeCloseInfo" rows="6" class="tarea" id="store_close_info"></textarea></td>
	        </tr>
       </tbody>
   </table>
        <a href="JavaScript:void(0);" class="btn" id="submitBtn" style="margin-left: 390px;"><span>提交</span></a>
</form>
</div>


</body>
</html>