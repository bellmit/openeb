<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />

<script type="text/javascript">
    $(function(){
        $('#ncsubmit').click(function(){
            $('#formSearch').submit();
        });
    });
     //标志性删除店铺
    function deletestore(storeid){
        var url = "${pageContext.request.contextPath}/shop/delete?id="+storeid;
        layer.confirm('您确定要删除店铺吗', function(){
            $.ajax({
                type: "post",
                url: url,
                data: null,
                dataType: "json",
                async:false,
                success:function(data) {
                    if(data){
                        layer.msg('删除成功', {icon: 1});
                        setTimeout("window.location.reload()", 1200);
                    }else{
                        layer.msg('删除失败', {icon: 2});
                    }
                }
            });
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
            <h3>店铺</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/store/joinlist"><span>开店申请</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/store">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label for="storeName">店铺</label></th>
                <td><input type="text" name="storeName" id="store_name" class="txt" value=""></td>
                <th><label for="sellerName">店主</label></th>
                <td><input type="text" name="memberName" id="owner_and_name" class="txt" value=""></td><td></td>
                <th><label>所属等级</label></th>
                <td><select name="gradeId">
                    <option value="">请选择...</option>
                        <option value="1">白金店铺</option>
                	</select>
                </td>
              
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
            </td></tr></tbody>
        </table>
    </form>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12"><div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td><ul>
                <li>如果当前时间超过店铺有效期或店铺处于关闭状态，前台将不能继续浏览该店铺，但是店主仍然可以编辑该店铺</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" id="store_form">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th>店铺</th>
                <th>店主账号</th>
                <th>所在地</th>
                <th>所属等级</th>
                <th>创店时间</th>
                <th class="align-center">有效期至</th>
                <th class="align-center">状态</th>
                <th class="align-center">推荐</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
	            <c:forEach items="${storeList }" var="shop">
	            <tr style="background: rgb(255, 255, 255);">
	                <td class="hover edit ">
	                    <a href="javascript:;" target="_blank">${shop.name }</a>
	                </td>
	                <td>pintaiziying</td>
	                <td>北京北京市</td>
	                <td></td>
	                <td></td>
	                <td class="nowarp align-center">
		                2016-01-05
	                </td>
	                <td class="align-center w72">开启</td>
	                <td class="align-center yes-onoff">
	                    <a href="JavaScript:void(0);" class="enabled" nc_type="inline_edit" fieldname="storeRecommend" fieldid="0" modurl="/leimingtech-admin/store/manager/recommond" fieldvalue="1" title="可编辑"><img src="./管理后台-店铺管理_files/transparent.gif"></a>
	                </td>
	                <td class="align-center w120">
	                    <a href="${pageContext.request.contextPath}/store/view?id=${shop.id}">查看</a>&nbsp;&nbsp;
	                    <a href="${pageContext.request.contextPath}/store/form?id=${shop.id}">编辑</a>&nbsp;&nbsp;
	                    <a href="JavaScript:void(0);" onclick="deletestore('${shop.id}')">删除</a><br>
	                    &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/report/orderIndex?storeId=${shop.id}">查看销售情况</a>&nbsp;&nbsp;<br>
	                    &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/report/goodsClickIndex?storeId=${shop.id}">查看商品流量</a>&nbsp;&nbsp;<br>
	                    &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/report/balanceIndex?storeId=${shop.id}">查看结算情况</a>&nbsp;&nbsp;<br>
	                    &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/bill/orderBillList?storeId=${shop.id}">查看店铺账单</a>&nbsp;&nbsp;
	                </td>
	            </tr>
	            </c:forEach>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td></td>
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