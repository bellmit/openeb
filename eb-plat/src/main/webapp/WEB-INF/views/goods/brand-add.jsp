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
            <h3>品牌管理</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/brand/list"><span><span>管理</span></span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增</span></a></li>
                <li><a href="${pageContext.request.contextPath}/brand/auditlist"><span>待审核</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="brand_form" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/brand/save">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2 nobdb">
            <tbody>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation">品牌名称:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="" name="brandName" id="brand_name" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">所属分类: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform" id="gcategory">
                    <input type="hidden" value="" name="classId" class="mls_id">
                    <input type="hidden" value="" name="brandClass" class="mls_name">
                    <select class="class-select">
                        <option value="0">请选择...</option>
                            <option value="2848fbbb6ea84f6ba592f44e3f3d340c">珠宝，首饰</option>
                            <option value="e1dd743764d04071971d2cc57e5f6483">家用电器 户外运动</option>
                            <option value="28ed715304e4437d962938964011ac95">美妆洗护</option>
                            <option value="139eaf1f1e814a7fa93b903049c4771d">家居家纺</option>
                            <option value="625bb2e038214198805db26596201210">酒类 生鲜 食品</option>
                            <option value="c748d987f7f043b3a4aa13c180cf77c4">母婴用品 玩具图书</option>
                            <option value="8a2defb1ebdf4458ab76b9369611586c">手机 数码 电脑</option>
                            <option value="eae1aa38c0c6451d8f9436e203880d78">女装 男装 鞋靴 箱包</option>
                    </select></td>
                <td class="vatop tips">选择分类，可关联大分类或更具体的下级分类。（只在后台快捷定位中起作用）</td>
            </tr>
            <tr>
                <td colspan="2" class="required">品牌图片标识:  </td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                <td class="vatop rowform"><span class="type-file-box"><input type="text" name="textfield" id="textfield1" class="type-file-text">
            <input type="button" name="button" id="button1" value="" class="type-file-button">
            <input name="imageFile" type="file" class="type-file-file" id="pic" size="30" hidefocus="true" nc_type="change_pic">
            </span></td>
                <td class="vatop tips">仅支持 GIF, JPG, JPEG, png</td>
            </tr>
            <tr>
                <td colspan="2" class="required">推荐: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff">
                    <label for="brand_recommend1" class="cb-enable"><span>是</span></label>
                    <label for="brand_recommend0" class="cb-disable selected"><span>否</span></label>
                    <input id="brand_recommend1" name="brandRecommend" value="1" checked="checked" type="radio">
                    <input id="brand_recommend0" name="brandRecommend" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr>
            <!-- <tr>
                <td colspan="2" class="required">状态: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff"><label for="brand_brandApply1" class="cb-enable"><span>是</span></label>
                    <label for="brand_brandApply0" class="cb-disable selected"><span>待审核</span></label>
                    <input id="brand_brandApply1" name="brandApply" value="1" type="radio">
                    <input id="brand_brandApply0" name="brandApply" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr> -->
            
            <tr>
                <td colspan="2" class="required">排序: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="brandSort" id="brand_sort" class="txt">
                </td>
                <td class="vatop tips">数字范围为0~255，数字越大越靠前</td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td colspan="2"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script type="text/javascript">
    $("#pic").change(function(){
        $("#textfield1").val($(this).val());
    });
    //按钮先执行验证再提交表单
    $(function(){$("#submitBtn").click(function(){
        if($("#brand_form").valid()){
            $("#brand_form").submit();
        }
        });
    });
    //
    $(document).ready(function(){
        $("#brand_form").validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            success: function(label){
                label.addClass('valid');
            },
            rules : {
                brandName : {
                    required : true,
                    remote   : {
                        url :APP_BASE+'/brand/validName',
                        type:'post',
                        data:{
                            name : function(){
                                return $('#brand_name').val();
                            },
                            brandId  : 0
                        }
                    }
                },
                brandSort : {
                    number   : true,
                    max		:255
                }
            },
            messages : {
                brandName : {
                    required : '品牌名称不能为空',
                    remote   : '该品牌名称已经存在了，请您换一个'
                },
                brandSort  : {
                    number   : '排序仅可以为数字',
                    max:'数字范围必须为0~255'
                }
            }
        });
    });
    gcategoryInit('gcategory');
</script>


</body></html>