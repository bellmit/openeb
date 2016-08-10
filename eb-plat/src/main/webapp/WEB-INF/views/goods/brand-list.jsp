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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-plat/goods-class.js"></script>
	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	           $('#formSearch').submit();
	        });
	    });
	    function delBrand(){
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
            <h3>品牌管理</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/brand/form"><span>新增</span></a></li>
                <li><a href="${pageContext.request.contextPath}/brand/auditlist"><span><span>待审核</span></span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/brand">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
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
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none; background: rgb(255, 255, 255);">
            <td>
                <ul>
                    <li>当店主添加商品时可选择商品品牌，用户可根据品牌查询商品列表</li>
                    <li>被推荐品牌，将在前台品牌推荐模块处显示</li>
                    <li>在品牌列表页面，品牌将按类别分组，即具有相同类别的品牌为一组，品牌类别与品牌分类无联系</li>
                </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" id="form_list" action="${pageContext.request.contextPath}/brand/delete">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th class="w24"></th>
                <th class="w48">排序</th>
                <th class="w270">品牌名称</th>
                <th class="w150">所属分类</th>
                <th>品牌图片标识</th>
                <th>品牌状态</th>
                <th class="align-center">推荐</th>
                <th class="w72 align-center">操作提示</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${brandList }" var="brand">
	            <tr class="hover edit" style="background: rgb(255, 255, 255);">
	                <td>
                    <input value="179" class="checkitem" type="checkbox" name="ids">
	                </td>
	                <td class="sort">
	                    <span class=" editable" nc_type="inline_edit" fieldname="brandSort" fieldid="179" datatype="pint" modurl="/leimingtech-admin/goods/brand/modifySort" maxvalue="255" title="可编辑">
	                    </span>
	                </td>
	                <td class="name">
	                    <span nc_type="inline_edit" fieldname="brandName" modurl="/leimingtech-admin/goods/brand/modifyName" fieldid="179" required="1" title="可编辑">DR</span>
	                </td>
	                <td class="class">${brand.name }</td>
	                <td class="picture">
	                	<div class="brand-picture">
	                	    <img src="./管理后台-品牌管理_files/1465697490606.jpg">
	                	</div>
	                </td>
	                <td>审核通过				    </td>
	                <td class="align-center yes-onoff">
		                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="brandRecommend" fieldid="179" modurl="/leimingtech-admin/goods/brand/recommond" fieldvalue="1" title="可编辑">
		                      <img src="./管理后台-品牌管理_files/transparent.gif">
		                    </a>
	                 </td>
	                <td class="align-center">
	                    <a href="${pageContext.request.contextPath}/brand/form?id=${brand.id}">编辑</a>
	                    &nbsp;|&nbsp;
	                    <a href="javascript:;" onclick="delRow(this)">删除</a>
	                </td>
	            </tr>
	            </c:forEach>
            </tbody>
            <tfoot>
            <tr colspan="15" class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="16"><label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="delBrand()"><span>删除</span></a>
				<div class="pagination">
				    <ul><li></li>
				    	<li><span>首页</span></li>
				        <li><span class="currentpage">1</span></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
				        <li><span>...</span></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(8)"><span>8</span></a></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(9)"><span>9</span></a></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
				        <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(9)"><span>末页</span></a></li>
				        <script language="javascript">
				            function turnOverPage(no) {
				                var queryForm = document.formSearch;
				                if (no >9) {
				                    no =9;
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
    <div class="clear"></div>
</div>



</body></html>