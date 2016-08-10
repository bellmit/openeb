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
	
	<script type="text/javascript">
	    $(function(){
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
            <h3>店铺</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/store"><span>管理</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>开店申请</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" action="${pageContext.request.contextPath}/store/auditlist">
         <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <th><label for="storeName">店铺</label></th>
                <td><input type="text" name="storeName" id="store_name" class="txt" value=""></td>
                <th><label for="memberName">店主</label></th>
                <td><input type="text" name="memberName" id="owner_and_name" class="txt" value=""></td>
                <th><label>所属等级</label></th>
                <td><select name="sgId">
                    <option value="">请选择...</option>
                        <option value="1">白金店铺</option>
                        <option value="4">钻石店铺</option>
                        <option value="7">信用店铺</option>
                        <option value="b46de06722fe49e2ab355477e64b5978">黄金</option>
                </select></td>
                <td>
                    <a href="javascript:document.formSearch.submit();" class="btn-search " title="搜索">"&gt;&nbsp;</a>
                </td>
            </tr>
            </tbody>
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
                <li></li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" id="store_form" name="store_form">
        <input type="hidden" name="form_submit" value="ok">
        <input type="hidden" name="type" id="type" value="">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th>店铺</th>
                <th>店主账号</th>
                <th>所在地</th>
                <th class="align-center">所属等级</th>
                <th class="align-center">状态</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${storeList }" var="shop">
                <tr class="hover edit" style="background: rgb(255, 255, 255);">
                    <td>${shop.name }</td>
                    <td>13818847995</td>
                    <td class="w150">上海市市辖区金山区</td>
                    <td class="align-center">
                       	 信用店铺
                    </td>
                    <td class="align-center w72">审核中</td>
                    <td class="w72 align-center">
                            <a href="${pageContext.request.contextPath}/store/audit?id=${shop.id}">开店审核</a>
                    </td>
                </tr>
                </c:forEach>
                
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td></td>
                <td colspan="15">
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
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>