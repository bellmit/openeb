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
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>广告位管理</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/adspace"><span>管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/adspace/form?" class="current"><span>新增</span></a></li>
            <!-- <li><a href="javascript:void(0)" class="current"><span>修改</span></a></li> -->
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="adv_position_form" action="${pageContext.request.contextPath}/adspace/save" method="post">
    <input type="hidden" name="apId" value="">
    <table class="table tb-type2">
        <tbody>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td colspan="2" class="required"><label class="validation" for="gcName">广告位置名:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td class="vatop rowform">
	            <input type="text" value="" name="apName" id="apName" maxlength="100" class="txt"></td>
	            <td class="vatop tips"></td>
	        </tr>
	        <tr>
	            <td colspan="2" class="required"><label class="validation" for="parent_id">广告位简介:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td class="vatop rowform">
	            <input type="text" value="" name="apIntro" id="apIntro" maxlength="100" class="txt">
	            </td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	         <tr>
	             <td colspan="2" class="required"><label for="murl" class="validation">广告类别:</label></td>
	            </tr>
	            <tr class="noborder">
	                <td class="vatop rowform">
	              <!-- 0图片1文字2幻灯3Flash -->
	                <select name="apClass" id="apClass">
	                	<option value="0">图片</option>
	                	<option value="1">文字</option>
	                	<option value="2">Flash</option>
	                </select>
	                </td>
	            </tr>
	        <tr>
	        </tr><tr>
	            <td colspan="2" class="required"><label for="gcmdescription">广告展示方式:</label></td>
	        </tr>
	        <tr class="noborder">
                <td class="vatop rowform">
                <!-- 0幻灯片1多广告展示2单广告展示 -->
                <select name="apDisplay" id="apDisplay">
                	<option value="0">幻灯片</option>
                	<option value="1">多广告展示</option>
                	<option value="2">单广告展示</option>
                </select>
                </td>
	        </tr>
	        <tr>
	            <td colspan="2" class="required"><label for="apKey">获取标记:</label></td>
	        </tr>
	        <tr class="noborder">
                <td class="vatop rowform">
               		<input type="text" value="" name="apKey" id="apKey" maxlength="100" class="txt">
                </td>
	        </tr>
	        <tr style="background: rgb(255, 255, 255);">
	            <td colspan="2" class="required"><label for="isUse" class="validation">是否启用:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td class="vatop rowform">启用：<input type="radio" value="1" name="isUse" id="isUse" class="radio" checked="">
	            停用：<input type="radio" value="0" name="isUse" id="isUse" class="radio"></td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	         <tr style="background: rgb(255, 255, 255);">
	            <td colspan="2" class="required"><label for="apWidth" class="validation">广告位宽度:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td class="vatop rowform"><input type="text" value="" name="apWidth" id="apWidth" class="txt"></td>
	           <td class="vatop tips">请填写数字</td>
	        </tr>
	         <tr>
	            <td colspan="2" class="required"><label for="apHeight" class="validation">广告位高度:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform"><input type="text" value="" name="apHeight" id="apHeight" class="txt"></td>
	            <td class="vatop tips">请填写数字</td>
	        </tr>
	        
        </tbody>
        <tfoot>
	        <tr>
	            <td colspan="2"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
	        </tr>
        </tfoot>
    </table>
</form>
</div>
<script>
    //按钮先执行验证再提交表单
    $(function(){
        $("#submitBtn").click(function(){
            if($("#adv_position_form").valid()){
                $("#adv_position_form").submit();
            }
        });
          $('#adv_position_form').validate({
           errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
            	apName: {
                    required : true,
                    maxlength: 10,
                    minlength: 1
                },
                apIntro: {	//简介
                    required : true
                },
                apClass: {
                	required : true
                },
                apKey:  {	//标记
                	required : true
                },
                apWidth:{	//宽度
                	required:true,
                	digits:true 
                },
                apHeight:{	//高度
                	required:true,
                	digits:true 
                }
            },
            messages : {
            	apName : {
                    required : '请填写广告位置名',
                    maxlength: '广告位置名称长度应在1-10个字符之间',
                    minlength: '广告位置名称长度应在1-10个字符之间'
                },
                apIntro : {
                    required : '请填写广告位简介'
                },
                apClass: {
                	required : '请填写广告类别'
                },
                apKey: {
                    required : '请填写标记'
                },
                apWidth:{	//宽度
                	required : '请填写广告位宽度',
                	digits : '请输入合法的数字'
                },
                apHeight:{	//高度
                	required:'请填写广告位高度',
                	digits : '请输入合法的数字'
                }
            } 
        });
    });
</script>


</body></html>