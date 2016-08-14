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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"></head>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/kindeditor/kindeditor-all.js"></script>
	<script type="text/javascript">
		
		$(function (){
		  	KindEditor.create('textarea[id="content"]', {
	            uploadJson : APP_BASE+'/kind/upload',
	            afterCreate : function() {
	                var self = this;
	            },
			 	allowFileManager: true,
				afterBlur: function(){this.sync();}
			});
	
		});
	</script>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>文章管理</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/article"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/article/form"><span>新增文章</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form action="${pageContext.request.contextPath}/article/save" method="post" name="saveForm" id="saveForm">
        <input type="hidden" name="articleId" value="${article.id }">
        <table class="table tb-type2 nobdb">
            <tbody>
            <tr class="noborder">
                <td colspan="2" class="required"><label class="validation">标题：</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" name="articleTitle" class="text" value="${article.title }"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation">所属分类：</label> </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform" id="gcategory">
                    <select class="select" name="acId" style="height:25px;width:100px">
                        <option value="0">全部</option>
			            <c:forEach items="${channelTree }" var="chl">
	                    <option value="${chl.id }">${chl.title }</option>
		                    <c:forEach items="${chl.subChannel }" var="chl2">
		                    <option value="${chl2.id }">&nbsp;&nbsp;|--${chl2.title }</option>
		                    <c:forEach items="${chl2.subChannel }" var="chl3">
		                    <option value="${chl3.id }">&nbsp;&nbsp;&nbsp;&nbsp;|-- 
		                    		${chl3.title }</option>
		                    </c:forEach>
		                    </c:forEach>
	                    </c:forEach>
                    </select>
                </td>
                <td class="vatop tips">选择分类</td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">链接：</td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="articleUrl" class="text" value=""></td>
                <td class="vatop tips">当填写"链接"后点击文章标题将直接跳转至链接地址，不显示文章内容。链接格式请以http://开头</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">是否显示: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff">
                	<label for="brand_recommend1" class="cb-enable selected" title="是"><span>是</span></label>
                    <label for="brand_recommend0" class="cb-disable " title="否"><span>否</span></label>
                    <input id="brand_recommend1" name="articleShow" checked="checked" value="1" type="radio">
                    <input id="brand_recommend0" name="articleShow" value="0" type="radio">
                </td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required">排序: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="articleSort" id="article_sort" class="txt" value="255">
                </td>
                <td class="vatop tips">数字范围为0~255，数字越大越靠前</td>
            </tr>
            <tr>
                <td colspan="2" class="required">文章内容: </td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                <td colspan="2">
                <textarea id="content" style="width: 700px; height: 300px; display: none;" name="articleContent">${article.content }</textarea>
                </td>
                <td class="vatop tips"></td>
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
   //按钮先执行验证再提交表单
    $(function(){$("#submitBtn").click(function(){
       	if($("#articleTitle").val()==""){
       		alert("标题不能为空");
       		return false;
       	}
        if($("#acId").val()==0){
       		alert("请选择分类");
       		return false;
       	}

         $("#saveForm").submit();
         layer.load(2, {
             shade: [0.2, '#999999'] //0.1透明度的白色背景
           });
        });
    });
</script>
</body>
</html>