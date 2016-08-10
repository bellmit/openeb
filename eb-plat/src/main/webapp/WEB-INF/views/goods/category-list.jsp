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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-plat/goods-class.js"></script>
	
	<script type="text/javascript">
		var vadate = false;
		var validate = false;
		function delClass() {
			var items = $("input[name='ids']:checked").length;
			if (items == 0) {
				alert("请至少选择一个要删除的项目");
			} else {
				if (confirm('您确定要删除吗?')) {
					$('#form_list').submit();
				}
			}
		}
		function delRow(obj) {
			if (confirm('您确定要删除吗?')) {
				$(obj).parents("tr").find("td:eq(0)>input").attr("checked", true);
				$('#form_list').submit();
			}
		}
	
		function delClassid(classid) {
			//校验菜单底线是否含有子菜单
			valicountparent(classid);
			//校验此分类下是否有未删除的商品
			validateGoodsByGcId(classid);
			if (vadate&&validate) {
				if (confirm('您确定要删除吗?')) {
					var url = APP_BASE+"/category/delete";
					var para = {
						"classid" : classid
					};
					$.ajax({
						type : "post",
						url : url,
						data : para,
						dataType : "json",
						async : false,
						success : function(data) {
							if (data.success == "true") {
								alert(data.result);
								window.location = APP_BASE+'/category/list'
							} else {
								alert(data.result);
							}
						}
					});
				}
			} 
			if(!vadate){
				alert("请删除子菜单后再进行删除！");
			}
			if(!validate){
				alert("该分类下有未删除商品，无法删除此分类！");
			}	
			
		}
	
		function validateGoodsByGcId(classid) {
			var url = APP_BASE+"/category/validateGoodsByGcId";
			var para = {
				"id" : classid
			};
			var vali = $.ajax({
				type : "post",
				url : url,
				data : para,
				dataType : "json",
				async : false,
				success : function(data) {
					if (data) {
						validate = true;
						return true;
					} else {
						validate = false;
						return false;
					}
				}
			});
		}
		function valicountparent(classid) {
			var url = APP_BASE+"/category/validateparentid";
			var para = {
				"id" : classid
			};
			var va = $.ajax({
				type : "post",
				url : url,
				data : para,
				dataType : "json",
				async : false,
				success : function(data) {
					if (data) {
						vadate = true;
						return true;
					} else {
						vadate = false;
						return false;
					}
				}
			});
		}
	</script>
</head>
 <body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>

<div class="page">
	<div class="fixed-bar">
		<div class="item-title">
			<h3>分类管理</h3>
			<ul class="tab-base">
				<li><a href="${pageContext.request.contextPath}/category" class="current"><span>管理</span>
				</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/category/form"><span>新增</span>
				</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="fixed-empty"></div>
	<table class="table tb-type2" id="prompt">
		<tbody>
			<tr style="background: rgb(255, 255, 255);" class="space odd">
				<th colspan="12"><div class="title">
						<h5>操作提示</h5>
						<span class="arrow"></span>
					</div>
				</th>
			</tr>
			<tr style="display: none; background: none 0% 0% repeat scroll rgb(255, 255, 255);" class="odd">
				<td><ul>
						<li>当店主添加商品时可选择商品分类，用户可根据分类查询商品列表</li>
						<li>点击分类名前“+”符号，显示当前分类的下级分类</li>
						<li><a>对分类作任何更改后，都需要到 设置 -&gt; 清理缓存 清理商品分类，新的设置才会生效</a>
						</li>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
	<form method="post" id="form_list" action="${pageContext.request.contextPath}/category/delete">
		<table class="table tb-type2" id="acct_grid">
			<thead>
				<tr class="thead">
					<th></th>
					<th>排序</th>
					<th>分类名称</th>
					<th>类型</th>
					<th>佣金比例</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorieList }" var="category">
				<tr class="hover edit" style="background: rgb(255, 255, 255);">
					<td class="w48">
						<input type="checkbox" name="ids" value="${category.id }" class="checkitem">
						<img fieldid="${category.id }" status="open" nc_type="flex" level="1" src="${pageContext.request.contextPath}/static/ui-v2/images/tv-expandable.gif">
					</td>
					<td class="w48 sort">
						<span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="${category.id }" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   1
						</span>
					</td>
					<td class="w50pre name">
						<span title="可编辑" required="1" fieldid="${category.id }" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
								${category.title }
						</span>
						<a class="btn-add-nofloat marginleft" href="${pageContext.request.contextPath}/category/form?parid=${category.id}">
							<span>新增下级</span>
						</a>
					</td>
					<td></td>
					<td>
									      0.1%
					</td>
					<td class="w84">
						<a href="${pageContext.request.contextPath}/category/form?id=${category.id}">编辑</a>
						| <a href="javascript:;" onclick="delClassid('${category.id}')">删除</a>
					</td> 
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr class="tfoot">
					<td><input type="checkbox" class="checkall" id="checkall_2">
					</td>
					<td id="batchAction" colspan="15">
						  <span class="all_checkbox">
								<label for="checkall_2">全选</label>
					      </span>&nbsp;&nbsp;
						  <a href="JavaScript:void(0);" class="btn" onclick="delClass()">
						  <span>删除</span>
					   </a>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<!-- content] -->

</body>
</html>