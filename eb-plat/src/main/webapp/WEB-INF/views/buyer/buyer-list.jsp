<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />

<script type="text/javascript">
    $(function(){
        $('#formSearch').attr("action","");
        $('#ncsubmit').click(function(){
            $('#formSearch').submit();
        });
    });
    //重置密码
    function resetPass(id){
        var url = "${pageContext.request.contextPath}/member/resetPass?id="+id;
        layer.confirm('您确定要重置密码吗?重置后密码将变为初始密码', function(){
            $.ajax({
                type: "post",
                url: url,
                data: null,
                dataType: "json",
                async:false,
                success:function(data) {
                    if(data.success == "true"){
                        layer.msg('重置成功', {icon: 1});
                    }else{
                        layer.msg('重置失败', {icon: 2});
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
            <h3>会员管理</h3>
            <ul class="tab-base">
                <li><a href="javaScript:;" class="current"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/member/form"><span>新增</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/member/list">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <td>
                (支持会员名/电子邮箱/真实姓名)  关键字：
                </td>
                <td><input type="text" value="" name="memberNameflag" class="txt"></td>
                <td>
                    <select name="orderString">
                        <option value="" selected="">排序</option>
                        <option value="1">最后登录</option>
                        <option value="2">登录次数</option>
                        <option value="3">注册时间</option>
                    </select>
                </td>
                <td>
                    <select name="status">
                        <option value="" selected="">会员状态</option>
                        <option value="1">禁止举报</option>
                        <option value="2">禁止购买</option>
                        <option value="3">禁止发表言论</option>
                        <option value="4">禁止登录</option>
                    </select>
                </td>
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr style="background: none repeat scroll 0% 0% rgb(255, 255, 255);" class="space odd">
            <th colspan="12"><div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span></div></th>
        </tr>
        <tr style="display: none; background: none 0% 0% repeat scroll rgb(255, 255, 255);" class="odd">
            <td><ul>
                <li>通过会员管理，你可以进行查看、编辑会员资料以及删除会员等操作</li>
                <li>你可以根据条件搜索会员，然后选择相应的操作</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" id="form_member">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2 nobdb">
            <thead>
            <tr class="thead">
                <th>&nbsp;</th>
                <th colspan="2">会员</th>
                <th class="align-center"><span fieldname="logins" nc_type="order_by">登录次数</span></th>
                <th class="align-center"><span fieldname="last_login" nc_type="order_by">最后登录时间</span></th>
                <th class="align-center">积分</th>
                <th class="align-center">预存款</th>
                <th class="align-center">登录</th>
                <th class="align-center">操作</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${buyerList }" var="buyer">
                <tr class="hover member" style="background: rgb(255, 255, 255);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>${buyer.account }</strong>(真实姓名: ${realname })</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 ${buyer.regtimestr }
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        ${buyer.email }
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">1</td>
                    <td class="w150 align-center">
                    </td>
                    <td class="align-center">50</td>
                    <td class="align-center">
                        <p>可用:&nbsp;<strong class="red">0</strong>&nbsp;元</p>
                        <p>冻结:&nbsp;<strong class="red">0</strong>&nbsp;元</p>
                    </td>
                    <td class="align-center">
                        	允许
                    </td>
                    <td class="align-center">
                        <a href="${pageContext.request.contextPath}/buyer/form?id=${buyer.id}" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass('${buyer.id}')">重置</a>
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
                    <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
                <li><span>...</span></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(9)"><span>9</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(10)"><span>10</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(10)"><span>末页</span></a></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >10) {
                    no =10;
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