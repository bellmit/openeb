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
            <h3>数据字典</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionaryGroup/list"><span>列表</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/list?groupId=2"><span>字典选项列表</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>字典选项编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="store_class_form" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/save">
    	<input type="hidden" name="dictionaryId" value="">
    	<input type="hidden" name="groupId" value="2">
        <table class="table tb-type2">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="dictionaryName">字典名称:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="" name="dictionaryName" id="dictionaryName" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
              <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="dictionaryName">字典值:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="" name="dictionaryValue" id="dictionaryValue" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label class="validation" for="dictionaryCode">字典编码:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><p>jedis</p><input type="hidden" value="jedis" name="dictionaryCode" id="dictionaryCode"></td>
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
                dictionaryName : {
                    required : true
                },
                dictionaryValue : {
                    required : true
                },
                dictionaryCode : {
                    required : true
                }
            },
            messages : {
                dictionaryName : {
                    required : '字典名称不能为空',
                },
                dictionaryValue : {
                    required : '字典值不能为空',
                },
                dictionaryCode  : {
                    required : '字典编码不能为空'
                }
            }
        });
    });
</script>


</body></html>