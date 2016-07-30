<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
    
    <title>管理后台</title>
    <link href="${pageContext.request.contextPath}/static/ui-v2/css/skin_0.css" rel="stylesheet" type="text/css" id="cssfile" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/admincp.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common.js"></script>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" />

	<script type="text/javascript">
	        var APP_BASE = '${pageContext.request.contextPath}';
	        LOADING_IMAGE = "${pageContext.request.contextPath}/res/images/loading.gif";
	</script>
    
	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
	        });
	    });
	    function delType(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("请至少选择一个要删除的项目");
	        }else{
	            if(confirm('您确定要删除吗?')){
	                $('#form_list').submit();
	            }
	        }
	    }
	    function delRow(obj){
	        if(confirm('您确定要删除吗?')) {
	            $(obj).parents("tr").find("td:eq(0)>input").attr("checked", true);
	            $('#form_list').submit();
	        }
	    }
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>类型管理</h3>
            <ul class="tab-base">
                <li><a class="current" href="JavaScript:void(0);"><span>列表</span></a></li>
                <li><a href="${pageContext.request.contextPath}/type/form"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/type">
        <input type="hidden" name="pageNo" value="1">
    </form>
    <table id="prompt" class="table tb-type2">
        <tbody>
        <tr class="space odd">
            <th colspan="12" class="nobg"> <div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span> </div>
            </th>
        </tr>
        <tr class="odd" style="display: none;">
            <td><ul>
                <li>当管理员添加商品分类时需选择类型。前台分类下商品列表页通过类型生成商品检索，方便用户搜索需要的商品。</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form id="form_list" method="post" action="${pageContext.request.contextPath}/type/delete">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th></th>
                <th>排序</th>
                <th>类型</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${typeList }" var="type">
            <tr class="hover edit" style="background: rgb(255, 255, 255);">
                <td class="w24"><input type="checkbox" class="checkitem" name="ids" value="${type.id}"></td>
                <td class="w48 sort">
                    <span class=" editable" title="可编辑" maxvalue="255" datatype="pint" modurl="${pageContext.request.contextPath}/type/modifySort" fieldid="${type.id}" fieldname="type_sort" nc_type="inline_edit">2</span></td>
                <td class="">${type.title }</td>
                <td class="w96 align-center"><a href="${pageContext.request.contextPath}/type/form?id=${type.id}">编辑</a> | <a href="javascript:void(0)" onclick="delRow(this)">删除</a></td>
            </tr>
            </c:forEach>
            <tr class="hover edit">
                <td class="w24"><input type="checkbox" class="checkitem" name="ids" value="5bf084a683794c6dbb3745f603b6f730"></td>
                <td class="w48 sort">
                    <span class=" editable" title="可编辑" maxvalue="255" datatype="pint" modurl="/leimingtech-admin/goods/type/modifySort" fieldid="5bf084a683794c6dbb3745f603b6f730" fieldname="type_sort" nc_type="inline_edit">0</span></td>
                <td class="">手机</td>
                <td class="w96 align-center"><a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/type/forward?id=5bf084a683794c6dbb3745f603b6f730">编辑</a> | <a href="javascript:void(0)" onclick="delRow(this)">删除</a></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td id="dataFuncs" colspan="16"><label for="checkallBottom">全选</label>&nbsp;&nbsp;
                    <a class="btn" onclick="delType();" href="JavaScript:void(0);"> <span>删除</span> </a>
				<div class="pagination">
				    <ul><li></li>
				    	<li><span>首页</span></li>
				        <li><span class="currentpage">1</span></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>末页</span></a></li>
				        <script language="javascript">
				            function turnOverPage(no) {
				                var queryForm = document.formSearch;
				                if (no >2) {
				                    no =2;
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
            <tr></tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>