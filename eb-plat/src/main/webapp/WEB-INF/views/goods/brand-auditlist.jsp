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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" ></script>

	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
	        });
	    });
	    function delBrand(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("请至少选择一个要拒绝的项目");
	        }else{
	            if(confirm('您确定要拒绝吗?')){
	                $('#form_list').attr("action",APP_BASE+"/brand/refuse");
	                $('#form_list').submit();
	            }
	        }
	    }
	    function passBrand(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("请至少选择一个要通过的项目");
	        }else{
	            if(confirm('您确定要通过该品牌吗?')){
	                $('#form_list').attr("action",APP_BASE+"/brand/pass");
	                $('#form_list').submit();
	            }
	        }
	    }
	    function delRow(obj){
	        if(confirm('您确定要拒绝吗?')) {
	            $(obj).parents("tr").find("td:eq(0)>input").attr("checked", true);
	            $('#form_list').attr("action", APP_BASE + "/brand/refuse");
	            $('#form_list').submit();
	        }
	    }
	    function passRow(obj){
	        if(confirm('您确定要通过该品牌吗?')){
	            $(obj).parents("tr").find("td:eq(0)>input").attr("checked", true);
	            $('#form_list').attr("action",APP_BASE+"/brand/pass");
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
            <h3>品牌管理</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/brand/list"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/brand/form"><span>新增</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>待审核</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/brand/auditlist">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <th><label for="search_brand_name">品牌名称</label></th>
                <td><input class="txt" name="brandName" id="search_brand_name" value="" type="text"></td>
                <th><label for="search_brand_class">所属分类</label></th>
                <td><input class="txt" name="brandClass" id="search_brand_class" value="" type="text"></td>
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="撤销检索">&nbsp;</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <form method="post" id="form_list">
        <input type="hidden" name="form_submit" value="ok">
        <input type="hidden" name="type" id="type" value="">
        <table class="table tb-type2 nobdb">
            <thead>
            <tr class="space"></tr>
            <tr class="thead">
                <th>&nbsp;</th>
                <th>品牌名称</th>
                <th>所属分类</th>
                <th>品牌图片标识</th>
                <th class="align-center">操作提示</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${brandList }" var="brand">
	                <tr class="hover edit">
		                <td class="w24"><input type="checkbox" class="checkitem" name="ids" value="${brand.id }"></td>
		                <td class="name w270"><span>${brand.name }</span></td>
		                <td class="class">母婴用品 玩具图书</td>
		                <td><div class="brand-picture"><img src="./管理后台-品牌审核_files/1459222670961.jpg"></div></td>
		                <td class="w96 align-center"><a href="javascript:;" onclick="passRow(this)">通过</a> | <a href="JavaScript:;" onclick="delRow(this)">拒绝</a></td>
	            	</tr>
	            </c:forEach>     		
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="16">
                     <label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="passBrand()" "="" name="id">
                    <span>通过</span>
                    </a>
                    <a href="JavaScript:void(0);" class="btn" onclick="delBrand()" name="id">
	                <span>拒绝</span>
                    </a>
					<div class="pagination">
					    <ul><li></li>
					    	<li><span>首页</span></li>
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