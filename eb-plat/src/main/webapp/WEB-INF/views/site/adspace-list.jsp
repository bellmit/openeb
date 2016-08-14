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
	
	
	<script type="text/javascript">
    $(function(){
        $('#formSearch').attr("action","");
        $('#ncsubmit').click(function(){
            $('#formSearch').submit();
        });
    });
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>广告位管理</h3>
	        <ul class="tab-base">
	            <li><a href="${pageContext.request.contextPath}/adspace" class="current"><span>管理</span></a></li>
	            <li><a href="${pageContext.request.contextPath}/adspace/form"><span>新增</span></a></li>
	        </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/adspace">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <td>
                    是否启用:
                </td>
                <td> <select name="isUse" id="isUse">
                		<option value="">－请选择－</option>
	                	<option value="1">启用</option>
	                	<option value="0">停用</option>
	                </select></td>
                <td>
                    广告展示方式:
                </td>
                <td>
                    <select name="apDisplay" id="apDisplay">
                    	<option value="">－请选择－</option>
	                	<option value="0">幻灯片</option>
	                	<option value="1">多广告展示</option>
	                	<option value="2">单广告展示</option>
	                </select>
                </td>
               	<td>广告类别:</td>
                <td>
                    <select name="apClass" id="apClass">
                    	<option value="">－请选择－</option>
	                	<option value="0">图片</option>
	                	<option value="1">文字</option>
	                	<option value="2">Flash</option>
	                </select>
                </td>
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
                    <a href="${pageContext.request.contextPath}/adspace" class="btns "><span>撤销检索</span></a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <table class="table tb-type2" id="prompt">
        <!-- <tbody>
        <tr style="background: none repeat scroll 0% 0% rgb(255, 255, 255);" class="space odd">
            <th colspan="12"><div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span></div></th>
        </tr>
        <tr style="background: none repeat scroll 0% 0% rgb(255, 255, 255);" class="odd">
            <td><ul>
                <li>通过会员管理，你可以进行查看、编辑会员资料以及删除会员等操作</li>
                <li>你可以根据条件搜索会员，然后选择相应的操作</li>
            </ul></td>
        </tr>
        </tbody> -->
    </table>
    <form method="post" id="form_member">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2 nobdb">
            <thead>
            <tr class="thead">
                <th>&nbsp;</th>
                <th class="align-center">ID</th>
                <th class="align-center">广告位置名</th>
                <th class="align-center">广告位简介</th>
                <th class="align-center">广告类别</th>
                <th class="align-center">广告展示方式</th>
                <th class="align-center">获取标记</th>
                <th class="align-center">是否启用</th>
                <th class="align-center">长度(px)</th>
                <th class="align-center">高度(px)</th>
               <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${spaceList }" var="adspace">
	                <tr class="hover member" style="background: rgb(255, 255, 255);">
	                    <td class="w24"></td>
	                    <td class="align-center">10</td>
	                    <td class="align-center">${adspace.title }</td>
	                    <td class="align-center">${adspace.remark }</td>
	                    <td class="align-center">${adspace.apclass }</td>
	                    <td class="align-center">${adspace.apdisplay }</td>
	                    <td class="align-center">${adspace.apcode }</td>
	                    <td class="align-center">${adspace.state }
	                    	启用
	                    </td>
	                    <td class="align-center">${adspace.apwidth }</td>
	                    <td class="align-center">${adspace.apheight }</td>
	                    <td class="align-center">
	                        <a href="${pageContext.request.contextPath}/advert?spaceid=${adspace.id }" title="查看子广告">查看</a> 
	                        | <a href="${pageContext.request.contextPath}/adspace/form?id=${adspace.id }" title="编辑">编辑</a> |
	                        <a href="${pageContext.request.contextPath}/adspace/delete?id=${adspace.id }" title="删除">删除</a>
	                    </td>
	                </tr>
	            </c:forEach>
            </tbody>
            <tfoot class="tfoot">
            <tr>
                <td colspan="16">
<div class="pagination">
    <ul><li>
                </li><li><span>首页</span></li>
                    <li><span class="currentpage">1</span></li>
                <li><span>末页</span></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >1) {
                    no =1;
                }
                if (no < 1) {
                    no = 1;
                }
                queryForm.pageNo.value=no;
                queryForm.submit();
            }
        </script>
    </ul>
</div>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>


</body></html>