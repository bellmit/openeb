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
            <h3>广告管理</h3>
	        <ul class="tab-base">
	            <li><a href="${pageContext.request.contextPath}/advert" class="current"><span>管理</span></a></li>
	            <li><a href="${pageContext.request.contextPath}/advert/form"><span>新增</span></a></li>
	        </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/advert">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <td>广告标题:</td>
                <td>
                	<input name="title" value="" class="txt">
				</td>
                <td>广告位:</td>
                <td>
                    <select id="advPositionId" name="spaceid">
                    	<c:forEach items="${spaceList }" var="space">
                            <option value="${space.id }">${space.title }</option>
                        </c:forEach>
                    </select>
                </td>
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
                    <a href="${pageContext.request.contextPath}/advert" class="btns "><span>撤销检索</span></a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <table class="table tb-type2" id="prompt">
    </table>
    <form method="post" id="form_member">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2 nobdb">
            <thead>
            <tr class="thead">
                <th>&nbsp;</th>
                <th class="align-center">广告标题</th>
                <th class="align-center">开始时间</th>
                 <th class="align-center">结束时间</th>
                <th class="align-center">点击次数</th>
                <th class="align-center">排序</th>
               <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${advertList }" var="advert">
	                <tr class="hover" style="background: rgb(255, 255, 255);">
	                    <td class="w24"></td>
	                    <td class="align-center">${advert.title }</td>
	                    <td class="align-center">${advert.starttimestr }</td>
	                    <td class="align-center">${advert.endtimestr }</td>
	                    <td class="align-center"></td>
	                    <td class="align-center">${advert.ordernum }</td>
	                    <td class="align-center">
	                        <a href="${pageContext.request.contextPath}/advert/form?id=${advert.id };advId=13" title="编辑">编辑</a> | <a href="${pageContext.request.contextPath}/adv/delete?advId=13" title="删除">删除</a>
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
</body>
</html>