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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>会员等级</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/list"><span>列表</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="store_class_form" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/add.do">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="gradeName">等级名称:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="" name="gradeName" id="gradeName" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="integration">等级所需积分:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="" name="integration" id="integration" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="preferential">等级折扣:</label></td>
            </tr>
            <tr class="noborder rowform" style="background: rgb(255, 255, 255);">
                <td class="vatop"><input type="text" value="" name="preferential" id="preferential" class="txt">%</td>
                <td class="vatop tips"> 请填写折扣所占的百分比</td>
            </tr>
            <tr>
                <td colspan="2" xclass="required"><label class="validation" for="gradeImg">图标上传:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform">
                	<input type="file" id="gradeImage" name="files" multiple="multiple" onchange="ajaxFileUploads(&#39;gradeImage&#39;,&#39;#imgView&#39;);">
                </td>
                <td class="vatop tips">
                	<img id="imgView" src="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/add" style="width: 100px;height:100px;">
                	<input type="hidden" name="gradeImg">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="required">
                    <label for="isDefault">是否默认:</label>
                </td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                <td class="vatop rowform onoff">
                	<label for="is_default1" class="cb-enable"><span>是</span></label>
                    <label for="is_default2" class="cb-disable selected"><span>否</span></label>
                    <input id="is_default1" name="isDefault" value="1" type="radio">
                    <input id="is_default2" name="isDefault" checked="checked" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr>
            </tbody>
            <tfoot>
	            <tr class="tfoot">
	                <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
	            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script>

//上传图片
function ajaxFileUploads(imageid,imgView) {
	var $img = $(imgView);
    $.ajaxFileUpload({
        url: '/leimingtech-admin/upload/gradeImage',
        data: '',
        secureuri: false,
        fileElementId: imageid,
        dataType: 'json',
        success: function(data){
        	$img.attr("src", data.imageServer+data.result);
        	$img.next().attr("value", data.result)
        },
        error: function (data, status, e) { //服务器响应失败时的处理函数
        }
    });
}
	    //按钮先执行验证再提交表单
	    $(function(){$("#submitBtn").click(function(){
	        if($("#store_class_form").valid()){
	            $("#store_class_form").submit();
	        }
	    });
    });
    //
    $(document).ready(function(){
        $('#store_class_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },

            rules : {
                gradeName : {
                    required : true
                },
                integration : {
                    required : true,
                    number:true 
                },
                preferential : {
                	required : true,
                	number:true,
                    range:[0,100]
                },
                gradeImg : {
                    required : true
                }
                
            },
            messages : {
                gradeName : {
                    required : '等级名称不能为空',
                },
                integration  : {
                    required : '等级所需积分不能为空',
                    number:'请填写正确格式的积分'
                },
                preferential : {
                	required : '等级折扣不能为空',
                	number: '请填写1至100之间的正整数',
                	range: $.validator.format("请填写1至100之间的正整数"),
                },
                 gradeImg : {
                    required :'图标不能为空'
                }
            }
        });
    });
</script>


</body>
</html>