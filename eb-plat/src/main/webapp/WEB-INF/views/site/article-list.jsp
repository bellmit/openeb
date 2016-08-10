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
<script type="text/javascript" src="./管理后台-文章管理_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-文章管理_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-文章管理_files/jquery.ui.css">
<script type="text/javascript">
    $(function(){
        $('#ncsubmit').click(function(){
           $('#formSearch').submit();
        });
    });
    function delArticleAll(){
        var items = $("input[name='ids']:checked").length;
        if (items==0) {
            alert("请至少选择一个要删除的项目");
        }else{
            if(confirm('您确定要删除吗?')){
                $('#form_list').submit();
            }
        }
    }
    function deleteArticle(id){
    	
       if(confirm('您确定要删除吗?')){
           $('#'+id).attr("checked",'true');//全选   
           $('#form_list').submit();
       }else{
       	   $('#'+id).attr("checked",'false');//全选
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
            <h3>文章管理</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/article/form"><span>新增文章</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/article/index">
            <input type="hidden" name="pageNo" value="1">
            <table class="tb-type1 noborder search">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <th><label for="search_brand_name">标题:</label></th>
                <td><input type="text" name="articleTitle" class="text" placeholder="输入关键字搜索" value=""></td>
                <th><label for="search_brand_class">文章分类：</label></th>
                <td><select class="select" name="acId" style="height:25px">
                        <option value="0">全部</option>
	                            <option value="1"> 店主之家
	                            </option>
	                                    <option value="15">&nbsp;&nbsp;  好店主如何养成</option>
	                            <option value="2"> 新手上路
	                            </option>
	                            <option value="3"> 支付方式
	                            </option>
	                            <option value="4"> 配送方式
	                            </option>
	                            <option value="5"> 售后服务
	                            </option>
	                            <option value="7"> 关于我们
	                            </option>
	                            <option value="8"> 商城公告
	                            </option>
	                            <option value="9"> 帮助中心
	                            </option>
                    </select></td>
                <td>
                	<a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="撤销检索">&nbsp;</a>
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
        <tr class="odd" style="display: none;">
            <td>
                <ul>
                    <li>区别于系统文章，可在文章列表页点击查看</li>
                </ul></td>
        </tr>
        </tbody>
    </table>
    
    <form method="post" id="form_list" action="${pageContext.request.contextPath}/article/delete">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2">
            <thead>			
            <tr class="thead">
                <th class="w24"></th>
                <th class="w48">排序</th>
                <th class="w850">标题</th>
                <th class="w470">文章分类</th>
                <th class="w270">显示</th>
                <th class="w270">添加时间</th>
                <th class="w272">操作</th>
            </tr>
            </thead>
	        <tbody>
	        <c:forEach items="${articleList }" var="article">
		        <tr style="background: rgb(255, 255, 255);">
		        	<td><input value="28" class="checkitem" type="checkbox" name="ids" id="28"></td>
		        	<td>255</td>
		            <td>${article.title }</td>
		            <td>${article.channelstr }</td>
		            <td>是</td>
		            <td>2608-07-23 12:08:32</td>
		            <td class="txt-link">
		                <a href="${pageContext.request.contextPath}/article/form?id=${article.id}" title="编辑编辑">编辑</a> ｜
		                <a href="javascript:;" title="删除" onclick="deleteArticle('${article.id}')">删除</a> </td>
		        </tr>
	        </c:forEach>
	        </tbody>
            
            <tfoot>
            <tr colspan="15" class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="16"><label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" onclick="delArticleAll()"><span>删除</span></a>
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
            </td></tr>
            </tfoot>
        </table>
    </form>
    <div class="clear"></div>
</div>


</body></html>