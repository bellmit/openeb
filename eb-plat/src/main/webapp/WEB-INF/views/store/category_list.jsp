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
					var url = "/leimingtech-admin/goods/class/deleteid";
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
								window.location = '/leimingtech-admin/goods/class/list'
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
			var url = "/leimingtech-admin/goods/goods/validateGoodsByGcId";
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
			var url = "/leimingtech-admin/goods/class/validateparentid";
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
				<li><a href="/class/list" class="current"><span>管理</span>
				</a>
				</li>
				<li><a href="/class/forward?gcId=0&amp;gcParentId=0"><span>新增</span>
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
	<form method="post" id="form_list" action="/goods/class/delete">
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
				<tr class="hover edit" style="background: rgb(255, 255, 255);">
					<td class="w48">
						<input type="checkbox" name="ids" value="0568b2fe256946ffa5b94bb5abb1adda" class="checkitem">
						<img fieldid="0568b2fe256946ffa5b94bb5abb1adda" status="open" nc_type="flex" level="1" src="${pageContext.request.contextPath}/static/ui-v2/images/tv-expandable.gif">
					</td>
					<td class="w48 sort">
						<span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="0568b2fe256946ffa5b94bb5abb1adda" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   1
						</span>
					</td>
					<td class="w50pre name">
						<span title="可编辑" required="1" fieldid="0568b2fe256946ffa5b94bb5abb1adda" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
								二手房
						</span>
						<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=0568b2fe256946ffa5b94bb5abb1adda">
							<span>新增下级</span>
						</a>
					</td>
					<td></td>
					<td>
									      0.1%
					</td>
					<td class="w84">
						<a href="/class/forward?gcId=0568b2fe256946ffa5b94bb5abb1adda&amp;gcParentId=0568b2fe256946ffa5b94bb5abb1adda">编辑</a>
						| <a href="javascript:;" onclick="delClassid(&#39;0568b2fe256946ffa5b94bb5abb1adda&#39;)">删除</a>
					</td> 
				</tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="eae1aa38c0c6451d8f9436e203880d78" class="checkitem">
										    <img fieldid="eae1aa38c0c6451d8f9436e203880d78" status="open" nc_type="flex" level="1" src="${pageContext.request.contextPath}/static/ui-v2/images/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="eae1aa38c0c6451d8f9436e203880d78" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   1
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="eae1aa38c0c6451d8f9436e203880d78" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   租房
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=eae1aa38c0c6451d8f9436e203880d78">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>服装</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=eae1aa38c0c6451d8f9436e203880d78&amp;gcParentId=eae1aa38c0c6451d8f9436e203880d78">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;eae1aa38c0c6451d8f9436e203880d78&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="8a2defb1ebdf4458ab76b9369611586c" class="checkitem">
										    <img fieldid="8a2defb1ebdf4458ab76b9369611586c" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="8a2defb1ebdf4458ab76b9369611586c" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   2
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="8a2defb1ebdf4458ab76b9369611586c" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   手机 数码 电脑 家电
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=8a2defb1ebdf4458ab76b9369611586c">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>手机</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=8a2defb1ebdf4458ab76b9369611586c&amp;gcParentId=8a2defb1ebdf4458ab76b9369611586c">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;8a2defb1ebdf4458ab76b9369611586c&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit" style="background: rgb(255, 255, 255);">
							       <td class="w48"><input type="checkbox" name="ids" value="be641713440a4788947c7234fa550a7b" class="checkitem">
										    <img fieldid="be641713440a4788947c7234fa550a7b" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="be641713440a4788947c7234fa550a7b" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   2
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="be641713440a4788947c7234fa550a7b" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   生活服务
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=be641713440a4788947c7234fa550a7b">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>rrrr</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=be641713440a4788947c7234fa550a7b&amp;gcParentId=be641713440a4788947c7234fa550a7b">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;be641713440a4788947c7234fa550a7b&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit" style="background: rgb(251, 251, 251);">
							       <td class="w48"><input type="checkbox" name="ids" value="c748d987f7f043b3a4aa13c180cf77c4" class="checkitem">
										    <img fieldid="c748d987f7f043b3a4aa13c180cf77c4" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="c748d987f7f043b3a4aa13c180cf77c4" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   3
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="c748d987f7f043b3a4aa13c180cf77c4" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   母婴用品 玩具图书
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=c748d987f7f043b3a4aa13c180cf77c4">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>母婴用品 玩具图书</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=c748d987f7f043b3a4aa13c180cf77c4&amp;gcParentId=c748d987f7f043b3a4aa13c180cf77c4">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;c748d987f7f043b3a4aa13c180cf77c4&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="625bb2e038214198805db26596201210" class="checkitem">
										    <img fieldid="625bb2e038214198805db26596201210" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="625bb2e038214198805db26596201210" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   4
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="625bb2e038214198805db26596201210" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   酒类 生鲜 食品
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=625bb2e038214198805db26596201210">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>海鲜</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=625bb2e038214198805db26596201210&amp;gcParentId=625bb2e038214198805db26596201210">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;625bb2e038214198805db26596201210&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="139eaf1f1e814a7fa93b903049c4771d" class="checkitem">
										    <img fieldid="139eaf1f1e814a7fa93b903049c4771d" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="139eaf1f1e814a7fa93b903049c4771d" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   5
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="139eaf1f1e814a7fa93b903049c4771d" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   家居家纺
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=139eaf1f1e814a7fa93b903049c4771d">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>生活用品</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=139eaf1f1e814a7fa93b903049c4771d&amp;gcParentId=139eaf1f1e814a7fa93b903049c4771d">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;139eaf1f1e814a7fa93b903049c4771d&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="28ed715304e4437d962938964011ac95" class="checkitem">
										    <img fieldid="28ed715304e4437d962938964011ac95" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="28ed715304e4437d962938964011ac95" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   6
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="28ed715304e4437d962938964011ac95" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   美妆洗护
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=28ed715304e4437d962938964011ac95">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>美妆</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=28ed715304e4437d962938964011ac95&amp;gcParentId=28ed715304e4437d962938964011ac95">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;28ed715304e4437d962938964011ac95&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="e1dd743764d04071971d2cc57e5f6483" class="checkitem">
										    <img fieldid="e1dd743764d04071971d2cc57e5f6483" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="e1dd743764d04071971d2cc57e5f6483" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   7
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="e1dd743764d04071971d2cc57e5f6483" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   家用电器
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=e1dd743764d04071971d2cc57e5f6483">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td></td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=e1dd743764d04071971d2cc57e5f6483&amp;gcParentId=e1dd743764d04071971d2cc57e5f6483">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;e1dd743764d04071971d2cc57e5f6483&#39;)">删除</a>
									</td> 
							  </tr>
						<tr class="hover edit">
							       <td class="w48"><input type="checkbox" name="ids" value="2848fbbb6ea84f6ba592f44e3f3d340c" class="checkitem">
										    <img fieldid="2848fbbb6ea84f6ba592f44e3f3d340c" status="open" nc_type="flex" level="1" src="./管理后台-分类管理_files/tv-expandable.gif">
								   </td>
									<td class="w48 sort">
									   <span title="可编辑" datatype="number" modurl="/leimingtech-admin/goods/class/modifySort" fieldid="2848fbbb6ea84f6ba592f44e3f3d340c" fieldname="gcSort" nc_type="inline_edit" class="editable ">
										   8
									   </span>
									</td>
									<td class="w50pre name">
										      <span title="可编辑" required="1" fieldid="2848fbbb6ea84f6ba592f44e3f3d340c" modurl="/leimingtech-admin/goods/class/modifyName" fieldname="gcName" nc_type="inline_edit" class="editable ">
											   珠宝，首饰
											 </span>
										<a class="btn-add-nofloat marginleft" href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=0&amp;gcParentId=2848fbbb6ea84f6ba592f44e3f3d340c">
											 <span>
											     新增下级
											 </span>
									   </a>
									</td>
									<td>首饰</td>
									<td>
									      1%
									</td>
									<td class="w84">
										<a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/class/forward?gcId=2848fbbb6ea84f6ba592f44e3f3d340c&amp;gcParentId=2848fbbb6ea84f6ba592f44e3f3d340c">编辑</a>
										| <a href="javascript:;" onclick="delClassid(&#39;2848fbbb6ea84f6ba592f44e3f3d340c&#39;)">删除</a>
									</td> 
							  </tr>
					
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