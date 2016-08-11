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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
	
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
            <h3>数据字典 </h3>
            <ul class="tab-base">
                <li><a class="current" href="JavaScript:void(0);"><span>列表 </span></a></li>
                <li><a href="${pageContext.request.contextPath}/dictgroup/form"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/dictgroup">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
			<tbody>
				<tr>
					<th><label for="search_brand_name">搜索</label></th>
					<td><input type="text" id="groupName" name="groupName" value="" class="mls_names"></td>
					<td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
					</td>
				</tr>
			</tbody>
		</table>
    </form>
    <table id="prompt" class="table tb-type2">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12" class="nobg"> <div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span> </div>
            </th>
        </tr>
        <tr class="odd" style="display: none;">
            <td><ul>
                <li>数据字典组，系统需要的维护数据列表，需要有字典编码对应关系</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form id="form_list" method="post" action="${pageContext.request.contextPath}/dictgroup/delete">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
            	<th></th>
                <th>字典名称</th>
                <th>字典编号</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
	            <tr class="hover edit" name="goodsInfo" style="background: rgb(255, 255, 255);">
	            	<td class="w24"><input type="checkbox" class="checkitem" name="ids" value="2"></td>
	                <td class="">缓存</td>
	                <td class="">jedis</td>
	                <td class="align-center" style="width:170px">
                    <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionaryGroup/forward?id=2">编辑</a> | 
	                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/list?groupId=2">字典选项</a> |
                    <a href="javascript:void(0)" onclick="delRow(this)">删除</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo">
	            	<td class="w24"><input type="checkbox" class="checkitem" name="ids" value="3"></td>
	                <td class="">性别</td>
	                <td class="">sex</td>
	                <td class="align-center" style="width:170px">
                    <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionaryGroup/forward?id=3">编辑</a> | 
	                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/list?groupId=3">字典选项</a> |
                    <a href="javascript:void(0)" onclick="delRow(this)">删除</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo" style="background: rgb(251, 251, 251);">
	            	<td class="w24"><input type="checkbox" class="checkitem" name="ids" value="5"></td>
	                <td class="">角色别名</td>
	                <td class="">roleAlias</td>
	                <td class="align-center" style="width:170px">
                    <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionaryGroup/forward?id=5">编辑</a> | 
	                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/list?groupId=5">字典选项</a> |
                    <a href="javascript:void(0)" onclick="delRow(this)">删除</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo" style="background: rgb(255, 255, 255);">
	            	<td class="w24"><input type="checkbox" class="checkitem" name="ids" value="b429eaa2b6f74f5d9c95c6fe0e97eca1"></td>
	                <td class="">测试</td>
	                <td class="">123456</td>
	                <td class="align-center" style="width:170px">
                    <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionaryGroup/forward?id=b429eaa2b6f74f5d9c95c6fe0e97eca1">编辑</a> | 
	                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/group/dictionary/list?groupId=b429eaa2b6f74f5d9c95c6fe0e97eca1">字典选项</a> |
                    <a href="javascript:void(0)" onclick="delRow(this)">删除</a>
	                </td>
	            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td id="dataFuncs" colspan="16">
                	<label for="checkallBottom">全选</label>&nbsp;&nbsp;
                    <a class="btn" onclick="delType();" href="JavaScript:void(0);"> <span>删除</span> </a>
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
            <tr></tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>