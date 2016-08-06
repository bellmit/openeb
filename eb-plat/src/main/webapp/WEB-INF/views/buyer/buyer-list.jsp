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
                <li><a href="${pageContext.request.contextPath}/member/add"><span>新增</span></a></li>
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
            </thead><tbody>
                <tr class="hover member" style="background: rgb(255, 255, 255);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>13818847995</strong>(真实姓名: 13818847995)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-30  22:30:01
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=b90cd97922b1449192e786b8ed80a439" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;b90cd97922b1449192e786b8ed80a439&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member" style="background: rgb(255, 255, 255);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="http://www.leimingtech.com:99http//wx.qlogo.cn/mmopen/tWd49EVFUrGhxicnpN5NsVVvfuNostStEz3PujZINTcvgiaY1YMvibgFicdwR2ZFibPiajicJc3GJWK8I9yAk1NuhExB1KFdzg2Wnqv/0" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>Smart.Wang</strong>(真实姓名: Smart.Wang)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-30  22:28:32
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=b6d343cb36d7401bacbc92542a4d03d1" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;b6d343cb36d7401bacbc92542a4d03d1&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member" style="background: rgb(251, 251, 251);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>13556735742</strong>(真实姓名: 13556735742)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-30  16:34:40
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=7725b1ccb44341508afdea239fac2314" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;7725b1ccb44341508afdea239fac2314&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member" style="background: rgb(255, 255, 255);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>霍比特</strong>(真实姓名: 霍比特)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-29  20:31:50
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=5f965222667149a8bffe143610bd499d" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;5f965222667149a8bffe143610bd499d&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member" style="background: rgb(255, 255, 255);">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>第五维</strong>(真实姓名: 第五维)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-25  22:41:28
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">5</td>
                    <td class="w150 align-center">
                      		 2016-07-28  16:13:04
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=958116c9bb3643db978920f83688034c" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;958116c9bb3643db978920f83688034c&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>gagjtm</strong>(真实姓名: gagjtm)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-25  16:33:05
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        1741937@qq.com
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=c6e77e810f0b4823af4bbed369e74a35" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;c6e77e810f0b4823af4bbed369e74a35&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>卢</strong>(真实姓名: 卢)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-24  16:33:58
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=7d37b1398e4c469fa4d71931d6bada1e" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;7d37b1398e4c469fa4d71931d6bada1e&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>15811099615</strong>(真实姓名: 15811099615)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-22  17:26:03
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=e04ab6f3d0e74e63af9929413f03479e" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;e04ab6f3d0e74e63af9929413f03479e&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>A茂</strong>(真实姓名: A茂)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-22  14:13:26
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=7a9155ffe5bb4fbe96b1b388f36c628d" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;7a9155ffe5bb4fbe96b1b388f36c628d&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>18500304651</strong>(真实姓名: 18500304651)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-22  10:32:45
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=d9d21f70204846a9abbf9fcd160faef7" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;d9d21f70204846a9abbf9fcd160faef7&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>13129538989</strong>(真实姓名: 13129538989)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-21  16:33:53
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=9ed64404971044279252252a5d6d51f2" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;9ed64404971044279252252a5d6d51f2&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>15511356869</strong>(真实姓名: 15511356869)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-21  09:51:07
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=a2aa6c37f7f540d8bd19b30591eb8a8c" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;a2aa6c37f7f540d8bd19b30591eb8a8c&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>13823215592</strong>(真实姓名: 13823215592)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-20  12:46:31
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=bd2308afe09a4ed3a6db45064a090997" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;bd2308afe09a4ed3a6db45064a090997&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>15201992294</strong>(真实姓名: 15201992294)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-07-19  14:57:21
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=05c3a575559c40ddb5b8cea3264f5c82" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;05c3a575559c40ddb5b8cea3264f5c82&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>13898495562</strong>(真实姓名: 13898495562)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-30  20:01:19
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=28ca4fb16d264a61b168edeb1490a3c9" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;28ca4fb16d264a61b168edeb1490a3c9&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="http://www.leimingtech.com:99http//wx.qlogo.cn/mmopen/vsAViaKGWic0WbmcaOtmicNYibZq2GxkqLD9L11FBARCJN4DIHXUkV1nj6HmqK6Jh7Gvl92EeMWAepvZz3Z7bibxS1g/0" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>Jeson.LK</strong>(真实姓名: Jeson.LK)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-29  17:46:24
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=a06dc9106a45435e8a0332c61488ae74" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;a06dc9106a45435e8a0332c61488ae74&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="http://www.leimingtech.com:99http//tva1.sinaimg.cn/crop.0.0.749.749.50/006tdSCgjw8f46ezq9r7sj30ku0kt3zp.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>夜弦声悲</strong>(真实姓名: 夜弦声悲)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-29  15:41:16
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=bdf54ba7cff642b68327029e9ed7fc7b" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;bdf54ba7cff642b68327029e9ed7fc7b&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>夜弦声悲</strong>(真实姓名: 夜弦声悲)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-29  15:40:54
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">4</td>
                    <td class="w150 align-center">
                      		 2016-06-29  15:40:54
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=ffac3e72a00e49b3aaab240d62f58ed0" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;ffac3e72a00e49b3aaab240d62f58ed0&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="./管理后台-会员管理_files/01.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>VIVI</strong>(真实姓名: VIVI)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-29  13:50:23
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        1112@11.com
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">3</td>
                    <td class="w150 align-center">
                      		 2016-06-29  13:50:23
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=e0c8ac64163441f3b7f1c177b263d81e" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;e0c8ac64163441f3b7f1c177b263d81e&#39;)">重置</a>
                    </td>
                </tr>
                <tr class="hover member">
                    <td class="w24"></td>
                    <td class="w48 picture" style="text-align:right"><div class="size-44x44"><span class="thumb size-44x44"><i></i><img src="http://www.leimingtech.com:99http//tva4.sinaimg.cn/crop.0.0.1002.1002.50/d5605025jw8f4a1b60j9vj20ru0run1z.jpg" onload="javascript:DrawImage(this,44,44);" height="44" width="44"></span></div></td>
                    <td style="text-align:left">
                        <p class="name"><strong>SayloveLuHan</strong>(真实姓名: SayloveLuHan)</p>
                        <p class="smallfont">注册时间:&nbsp;
                      		 2016-06-29  13:42:33
                        </p>
                        <div class="im">
	                        <span class="email">
		                        <a href="mailto:" class="yes" title="电子邮箱:">
		                        </a>
		                        
	                        </span>
                        </div>
                    </td>
                    <td class="align-center">2</td>
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
                        <a href="${pageContext.request.contextPath}/member/findById?id=e927086bc9424098b8e103cbfdf0bb20" title="编辑">编辑</a>
                         &nbsp;|&nbsp;
	                    <a onclick="resetPass(&#39;e927086bc9424098b8e103cbfdf0bb20&#39;)">重置</a>
                    </td>
                </tr>
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