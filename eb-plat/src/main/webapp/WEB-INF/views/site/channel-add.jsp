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
        
        <h3>文章分类</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/list"><span>管理</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="article_class_form" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/website/class/saveOrUpdate">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder">
                <td colspan="2" class="required"><label class="validation" for="acName">文章分类:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" value="" name="acName" id="ac_name" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label for="acParentId">上级分类:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><select name="acParentId" id="ac_parent_id" class="valid">
                    <option value="0">请选择...</option>
                    <option value="1">
                        &nbsp;&nbsp;店主之家</option>
                    <option value="2">
                        &nbsp;&nbsp;新手上路</option>
                    <option value="3">
                        &nbsp;&nbsp;支付方式</option>
                    <option value="4">
                        &nbsp;&nbsp;配送方式</option>
                    <option value="5">
                        &nbsp;&nbsp;售后服务</option>
                    <option value="7">
                        &nbsp;&nbsp;关于我们</option>
                    <option value="8">
                        &nbsp;&nbsp;商城公告</option>
                    <option value="9">
                        &nbsp;&nbsp;帮助中心</option>
                </select></td>
                <td class="vatop tips">如果选择上级分类，那么新增的分类则为被选择上级分类的子分类</td>

            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label for="acSort">排序:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="255" name="acSort" id="ac_sort" class="txt"></td>
                <td class="vatop tips">更新排序</td>
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
    //按钮先执行验证再提交表单
    $(function(){$("#submitBtn").click(function(){
        if($("#article_class_form").valid()){
            $("#article_class_form").submit();
        }
    });
    });
    //
    $(document).ready(function(){
        $('#article_class_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
                acName : {
                    required : true,
                    remote   : {
                        url :APP_BASE+'/website/class/validate',
                        type:'post',
                        data:{
                            acName : function(){
                                return $('#ac_name').val();
                            },
                            acParentId : function() {
                                return $('#ac_parent_id').val();
                            },
                            acId : ''
                        }
                    }
                },
                ac_sort : {
                    number   : true
                }
            },
            messages : {
                acName : {
                    required : '{0} 为必填项。',
                    remote   : '这个值是存在的'
                },
                acSort  : {
                    number   : '{0} 必须为一数值。'
                }
            }
        });
    });
</script>
</body>
</html>