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

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/WdatePicker.js"></script>
	<link href="${pageContext.request.contextPath}/static/ui-v2/WdatePicker.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	    .d_inline {
	        display:inline;
	    }
	</style>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>店铺</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/store/manager/list"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/store/manager/auditList"><span>开店申请</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="store_form" method="post" action="${pageContext.request.contextPath}/store/manager/updateDetail">
        <input type="hidden" name="storeId" value="0">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder">
                <td colspan="2" class="required"><label>店主账号:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform">pintaiziying</td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2"><label class="validation" for="storeOwnerCard">身份证号:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" name="storeOwnerCard" value="" id="store_storeOwnerCard" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2"> 店铺:</td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform">平台自营</td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label>所属分类:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform">
	                 <select name="scId">
	                    <option value="0">请选择...</option>
	                            <option value="5c52490512a14d1d826819905069f30b">
	                            餐饮美食 </option>
	                            <option value="8599c3d7ea57466da804564d31385143">
	                                &nbsp;&nbsp;----</option>
	                            <option value="a813d94f848c4f068bc39adde3c15364">
	                                &nbsp;&nbsp;正餐</option>
	                            <option value="3940cf7cfaf140e8a49657fa5385e753">
	                            农家特色 </option>
	                            <option value="8fcbfc6859ba4bdc981942c6af3e0502">
	                                &nbsp;&nbsp;农家乐</option>
	                            <option value="4758df884f6245688fbda3cd54692480">
	                            333 </option>
	                            <option value="b62207b7563d499289ac4ef746dfe3c9">
	                                &nbsp;&nbsp;1</option>
	                            <option value="62d4b6ded122451c8aa8c5a81595792a">
	                            女装 男装 鞋靴 箱包 </option>
	                            <option value="9130116686af4862ab1c7147f3104f92">
	                            手机 数码 电脑 </option>
	                            <option value="98ced5c35c97407ab2404f6710ed6ef5">
	                            母婴用品 玩具图书 </option>
	                            <option value="9988f01def8b445cb8a2c4e82b397041">
	                            家居家纺 </option>
	                </select>
                </td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2"><label for="areaInfo">所在地</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform">北京北京市</td>
                <td class="vatop tips"></td>
            </tr>
             <tr>
                <td colspan="2"><label for="storeAddress">详细地区</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                <td class="vatop rowform">朝阳区</td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2"><label class="validation" for="storeZip">邮政编码</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="storeZip" value="100000" id="store_Zip" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2"><label class="validation" for="storeTel">联系电话</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="storeTel" value="15932110597" id="store_Tel" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td colspan="2" class="required"><label>
                    <label for="gradeId">  所属等级:  </label>
                </label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><select id="grade_id" name="gradeId">
                        <option value="1">
                       			 白金店铺  
                        </option>
                </select></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label>有效期至:</label></td>
            </tr>
           <tr class="noborder">
                <td class="vatop rowform">
                    <input onclick="WdatePicker({dateFmt:&#39;yyyy-MM-dd&#39;});" class="txt Wdate" type="text" value="2016-01-05" id="endTimet" name="endTimet" style="width: 151px;height: 18px;">
                </td>
                <td class="vatop tips">格式：2009-4-30，留空表示不限时间</td>
            </tr> 
            <tr>
                <td colspan="2" class="required">
                    <label for="state">状态:</label>
               </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff">
                    <label for="store_state1" class="cb-enable selected"><span>开启</span></label>
                    <label for="store_state0" class="cb-disable "><span>关闭</span></label>
                    <input id="store_state1" name="storeState" checked="checked" onclick="$(&#39;#tr_store_close_info&#39;).hide();" value="1" type="radio">
                    <input id="store_state0" name="storeState" onclick="$(&#39;#tr_store_close_info&#39;).show();" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr>
             <tr>
                <td colspan="2" class="required">
                    <label for="storeRecommend">推荐:</label>
                </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff"><label for="store_Recommend1" class="cb-enable selected"><span>是</span></label>
                    <label for="store_Recommend0" class="cb-disable "><span>否</span></label>
                    <input id="store_Recommend1" name="storeRecommend" checked="checked" value="1" type="radio">
                    <input id="store_Recommend0" name="storeRecommend" checked="checked" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr>
            <!--  <tr>
                <td colspan="2"><label  for="storeSort">排序</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="storeSort" value="0" id="store_Sort" class="txt"></td>
                <td class="vatop tips"></td>
            </tr> -->
            </tbody>
            <tbody id="tr_store_close_info" style="display: none;">
            <tr>
                <td colspan="2" class="required"><label for="storeCloseInfo">关闭原因:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><textarea name="storeCloseInfo" rows="6" class="tarea" id="store_close_info"></textarea></td>
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
<script type="text/javascript">
$(function(){

    $('#end_time').datepicker();
    $('input[name="storeState"][value=1]').trigger('click');
    regionInit("region");
    $('input[class="edit_region"]').click(function(){
        $(this).css('display','none');
        $(this).parent().children('select').css('display','');
        $(this).parent().children('span').css('display','none');
    });
//按钮先执行验证再提交表单

    $("#submitBtn").click(function(){
        if($("#store_form").valid()){
            $("#store_form").submit();
        }
    });

//
    $('#store_form').validate({
        errorPlacement: function(error, element){
            error.appendTo(element.parentsUntil('tr').parent().prev().find('td:first'));
        },
        rules : {
            storeOwnerCard: {
                required : true,
                minlength: 18,
                maxlength: 18
            },
            storeZip: {
                     number: true,
                     minlength: 6,
                     maxlength: 6
                 },
            storeTel: {
                     required: true,
                     isTel:true
                 },
             storeSort: {
                number: true
            }
        },
        messages : {
            storeOwnerCard: {
                required : '身份证号不能为空',
                minlength: '身份证格式不正确',
                maxlength: '身份证格式不正确'
            },
            storeZip: {
                      number: '邮编必须为数字',
                      minlength: '邮编格式不正确',
                      maxlength: '邮编格式不正确'
                  },
            storeTel: {
                 required: '请输入联系电话',
                 isTel:'请输入正确的联系方式'
             },
             storeSort: {
                number: '请填写数字'
            }
        }
    });
    
           //校验电话格式
	   jQuery.validator.addMethod("isTel", function(value, element) { 
		  var tel =/(^(\d{2,5}-)?\d{6,9}(-\d{2,4})?$)|(^1\d{10}?$)/; //电话号码格式010-12345678 
		  return this.optional(element) || (tel.test(value)); 
	   }, "phone"); 
});
</script>
</body>
</html>