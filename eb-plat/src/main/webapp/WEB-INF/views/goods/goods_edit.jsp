<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>商家中心-商品修改</title>
    <link href="${pageContext.request.contextPath}/static/jquery-store/css/base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/jquery-store/css/member.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/jquery-store/css/member_store.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/jquery-store/css/style.css" rel="stylesheet">
    <!--[if IE 6]>
    <style type="text/css">
    	body {_behavior: url(/leimingtech-seller/res/css/csshover.htc);}
	</style>
    <![endif]-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/member.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/utils.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-store/css/layer.css" id="layui_layer_skinlayercss">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/index.js"></script>
    <!-- IE8兼容性
   	<script src="/leimingtech-seller/res/js/html5shiv.min.js"></script> -->
    <!--[if IE]>
    <script src="/leimingtech-seller/res/js/html5.js"></script>
    <![endif]-->
    <!--[if IE 6]>
    <script src="/leimingtech-seller/res/js/IE6_PNG.js"></script>
    <script>
        DD_belatedPNG.fix('.pngFix');
    </script>
    <script>
        // <![CDATA[
        if((window.navigator.appName.toUpperCase().indexOf("MICROSOFT")>=0)&&(document.execCommand))
        try{
        document.execCommand("BackgroundImageCache", false, true);
           }
        catch(e){}
        // ]]>
     </script>
     <![endif]-->
    <script type="text/javascript">
        COOKIE_PRE = '5C83_';_CHARSET = 'utf-8';SITEURL = 'http://b2b2c.leimingtech.com/leimingtech-seller/';
        var PRICE_FORMAT = '&yen;%s';
        $(function(){
            //search
            $("#details").children('ul').children('li').click(function(){
                $(this).parent().children('li').removeClass("current");
                $(this).addClass("current");
                $('#search_act').attr("value",$(this).attr("act"));
            });
            var search_act = $("#details").find("li[class='current']").attr("act");
            $('#search_act').attr("value",search_act);
            $("#keyword").blur();
        });
    </script>
    <script type="text/javascript">
        var APP_BASE = '${pageContext.request.contextPath}';
        var FRONT_BASE = 'http://b2b2c.leimingtech.com/leimingtech-front/';
        var STORE_ID = 'a32b6116722f4f80a324988a5281af7f';
    </script>
<link href="${pageContext.request.contextPath}/static/jquery-store/css/WdatePicker.css" rel="stylesheet" type="text/css"><link href="./商家中心-商品修改_files/default.css" rel="stylesheet"></head>
<body>
<!-- <script type="text/javascript" src="/leimingtech-seller/res/js/common2.2.js" charset="utf-8"></script> -->
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>

<div class="layout">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-store/css/default.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.ajaxContent.pack.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/zh-CN.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/common_select.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/ajaxfileupload.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/store_goods.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/area.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/kindeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/prettify.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.masonry.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.scrollLoading-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/goods.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.sortable.js" charset="utf-8"></script>

    <style>

        #header h1 i {
            font-size: 24px;
            font-family: "微软雅黑";
            float: left;
            margin-top: 12px;
            margin-left: 12px;
        }

        h1 {
            font-size: 24px;
            font-family: arial;
            margin: 10px;
        }

        .gbin1-list {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .gbin1-list li {

            float: left;

            height: 80px;
            text-align: center;

            margin: 17px;
            font-family: arial;

            color: #FFF;

            border-radius: 5px;
            padding: 0px;
        }

        #msg {
            font-size: 12px;
            font-family: arial;
            background: #303030;
            color: #cccccc;
            padding: 10px;
            display: none;
            width: 370px;
            margin: 10px;
        }

        .ui-timepicker-div .ui-widget-header {
            margin-bottom: 8px;
        }

        .ui-timepicker-div dl {
            text-align: left;
        }

        .ui-timepicker-div dl dt {
            float: left;
            clear: left;
            padding: 0 0 0 5px;
        }

        .ui-timepicker-div dl dd {
            margin: 0 10px 10px 45%;
        }

        .ui-timepicker-div td {
            font-size: 90%;
        }

        .ui-tpicker-grid-label {
            background: none;
            border: none;
            margin: 0;
            padding: 0;
        }

        .ui-timepicker-rtl {
            direction: rtl;
        }

        .ui-timepicker-rtl dl {
            text-align: right;
            padding: 0 5px 0 0;
        }

        .ui-timepicker-rtl dl dt {
            float: right;
            clear: right;
        }

        .ui-timepicker-rtl dl dd {
            margin: 0 45% 10px 10px;
        }

        .dialog_body {
            border: 0px;
        }

        .add_spec .add_link {
            color: #919191;
        }

        .add_spec .add_link:hover {
            color: red;
        }

        .add_spec h2 {
            padding-left: 10px;
        }

        .f_l {
            float: left;
            line-height: 24px;
        }

        .mls_id {
            width: 0;
            filter: alpha(opacity=0);
            opacity: 0;
        }

        .noSelect {
            color: #B9B9B9 !important;
        }

        .attr {
            line-height: 20px;
            float: left;
            clear: both;
            padding-top: 4px;
            padding-bottom: 4px;
            height: auto;
        }
    </style>


    <div class="wp">
        <ul class="flow-chart">
            <li class="step a2" title="选择商品所在分类"></li>
            <li class="step b1" title="填写商品详细信息"></li>
            <li class="step c2" title="商品发布成功"></li>
        </ul>
        <div class="item-publish">
            <form method="post" id="goods_form" action="http://b2b2c.leimingtech.com/leimingtech-seller/pro/editgoods#">
                <input type="hidden" name="form_submit" value="ok">
                <input type="hidden" name="goodsId" value="104a0f05565e4d5084fe96594a8046e1">
                <input type="hidden" name="type_id" value="7619a285815e4ef0be0c91aa75abb0e9">
                <input type="hidden" name="goodsIsHaveSpec" id="goodsIsHaveSpec" value="">
                <div class="goods-attribute">
                    <dl class="tit">
                        <h3>商品基本信息</h3>
                    </dl>
                    <dl>
                        <dt>商品分类：</dt>
                        <dd id="gcategory">
                            <span class="f_l">家政服务</span> <a class="edit_gcategory ncu-btn1 ml10" href="http://b2b2c.leimingtech.com/leimingtech-seller/pro/sell?goodsId=104a0f05565e4d5084fe96594a8046e1">
                            <span>编辑</span>
                        </a> <input type="text" id="cate_id" name="cate_id" value="341fce8405464937addb7d9e3d767f79" class="mls_id text"> <input type="hidden" name="cate_name" id="cate_name" value="家政服务" class="mls_names text">
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品类型：</dt>
                        <dd>
                            <p>
                                <label style="padding-right: 8px;">  <input name="goods_form" value="1" checked="checked" type="radio"> 全新 
                                </label> <label>  <input name="goods_form" value="2" type="radio">
                                二手 
                            </label>
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt class="required">
                            <span class="red">*</span>商品名称：
                        </dt>
                        <dd>
                            <p>
                                <input name="goods_name" type="text" class="text w400" title="" value="123">
                            </p><p>
                            </p><p class="hint">商品标题名称长度至少3个字符，最长50个汉字</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">商品副标题：</dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_subtitle" value="" type="text" class="text w500">
                            </p>
                            <p class="hint">商品副标题做商品特殊说明，位于详情页商品名称下面</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">
                            <span class="red">*</span>商品价格：
                        </dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_store_price" value="100" type="text" class="text"> <input name="goods_store_price_interval" value="" type="hidden">
                                <!-- 价格区间 -->
                            </p>
                            <p class="hint">
                                商品价格必须是0.01~1000000之间的数字<br>若启用了库存配置，请在下方商品库存区域进行管理<br>商品规格库存表中如有价格差异，店铺价格显示为价格区间形式
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec"><span class="red">*</span>市场价：</dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_market_price" type="text" class="text" value="234">
                                <!-- 价格区间 -->
                            </p>
                            <p class="hint">商品价格必须是0.01~1000000之间的数字</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">成本价：</dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_cost_price" type="text" class="text" value="">
                                <!-- 价格区间 -->
                            </p>
                            <p class="hint">商品价格必须是0.01~1000000之间的数字</p>
                        </dd>
                    </dl>
                 	
                 	<c:forEach items="${type.specs }" var="spec" varStatus="status">
                    <dl nc_type="spec_group_dl_${status.index }" spid="${spec.id }" spname="${spec.title }" nctype="spec_group_dl" class="spec-bg" spec_img="t" spformat="0">
                        <dt>
                            <input type="hidden" name="sp_name[${status.index }]" value="${spec.title }"> ${spec.title }：
                        </dt>
                        <dd nctype="sp_group_val">
                            <ul class="spec">
                            		<c:forEach items="${spec.specVals }" var="specval">
                                    <li><span nctype="input_checkbox" class="checkbox">
										<input type="checkbox" groupid="group_${status.index }" name="specCheckBox" value="${specval.id }" spvaluename="${specval.title }" class="sp_val" spformat="0">
										</span>  
										<span nctype="pv_name" class="pvname"> ${specval.title } </span>
									</li>
									</c:forEach>
                            </ul>
                            <div class="clear"></div>
                        </dd>
                    </dl>
                	</c:forEach>
                 
                    <dl nc_type="spec_dl" class="spec-bg" style="display: none">
                        <dt>库存配置：</dt>
                        <dd class="spec-dd">
                            <table border="0" cellpadding="0" cellspacing="0" class="spec_table">
                                <thead>
                                <tr>
	                                <c:forEach items="${type.specs }" var="spec" varStatus="status">
	                                <th>${spec.title }</th> 
	                                </c:forEach>
	                                <th><span class="red">*</span>价格</th>
	                                <th><span class="red">*</span>库存</th>
	                                <th>商品货号</th>
	                                <th>是否开启</th>
                                </tr>
                                </thead>
                                <tbody nc_type="spec_table"></tbody>
                            </table>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">
                            <span class="red">*</span>商品库存：
                        </dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_storage" value="0" type="text" class="text">
                            </p>
                            <p class="hint">
                                商铺库存数量必须为1~1000000000之间的整数<br>若启用了库存配置，则系统自动计算商品的总数，此处无需卖家填写
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">商品货号：</dt>
                        <dd nc_type="no_spec">
                            <p>
                                <input name="goods_serial" value="" type="text" class="text">
                            </p>
                            <p class="hint">
                                商品货号是指卖家个人管理商品的编号，买家不可见<br>最多可输入20个字符，支持输入中文、字母、数字、_、/、-和小数点
                            </p>
                        </dd>
                    </dl>
                    <!-- 图片上传 -->
                    <dl>
                        <dt><span class="red">*</span>商品图片：</dt>
                        <dd>
                            <div class="pic_list">
                                <ul id="menu" class="menu">
                                    <li class="active" id="li_1">
                                        <a href="javascript:void(0);" style="background: #3366CC; color: #fff; line-height: 22px; height: 22px; padding: 0 11px; position: relative; margin-right: 20px;">
                                            本地上传
                                            <input type="file" onchange="ajaxTypeImageUploads(&#39;myBlogImage1&#39;,&#39;photo&#39;)" style="opacity: 0; top: 0; left: 0; width: 100%; height: 100%; margin: 0; position: absolute;" id="myBlogImage1" name="myfiles" class="file" multiple="multiple">
                                        </a>
                                        <span>上传的商品图片可以任意拖拽，拖拽后的显示效果可以在商品详情页相册查看</span>
                                    </li>
                                </ul>
                                <div class="content">
                                    <div id="demo"></div>
                                    <div class="standard">

                                        <ul style="min-height: 130px; overflow: auto; overflow-x: hidden;" id="photoView01" class="gbin1-list">
                                         
                                            <li style="height: 120px; display: inline" draggable="true">
                                                <img class="img" style="width: 100px; height: 100px" src="./商家中心-商品修改_files/1469006369627.jpg">
                                                <a href="javascript:void(0)" imagesrc="/upload/img/store/a32b6116722f4f80a324988a5281af7f/1469006369627.jpg" name="deletePhoto"> 删除</a></li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </dd>
                    </dl>


                    <dl class="tit">
                        <h3>商品详情描述</h3>
                    </dl>
                    <dl>
                        <dt>商品属性：</dt>
                        <dd>
                            <div class="attr">
                              
                            </div>
                            <div class="clear"></div>
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品品牌：</dt>
                        <dd>
                            <select name="brand_id" id="brand">
                                <option value="" selected="selected">-请选择-</option>  
                                    <option value="110" selected="selected">佐丹奴</option>
                                 	
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品描述：</dt>
                        <dd>
                            <p>
								<textarea id="goods_body" name="goods_body" style="width: 100%; height: 400px; visibility: hidden; display: none;">122334445555</textarea>
                            </p>
                            <!-- <p class="info-album">
                                <a class="des_demo"
                                    href="#?act=store_album&op=pic_list&item=des">插入相册图片</a>
                            </p> -->
                            <p id="des_demo" style="display: none;"></p>
                        </dd>
                    </dl>
                    <!--transport info begin-->
                    <dl class="tit">
                        <h3>商品物流信息</h3>
                    </dl>
                    <dl>
                        <dt nc_type="no_spec">
                            <span class="red">*</span>所在地：
                        </dt>
                        <dd>
							<span id="spanarea">
                                <select name="area" class="select" id="area" check="needCheck">
                                    <option value="">请选择</option>
                                        <option value="11">北京市</option>
                                        <option value="44">广东省</option>
                                        <option value="45">广西壮族自治区</option>
                                        <option value="46" selected="selected">海南省</option>
                                        <option value="50">重庆市</option>
                                        <option value="51">四川省</option>
                                        <option value="52">贵州省</option>
                                        <option value="53">云南省</option>
                                        <option value="54">西藏自治区</option>
                                        <option value="61">陕西省</option>
                                        <option value="62">甘肃省</option>
                                        <option value="63">青海省</option>
                                        <option value="64">宁夏回族自治区</option>
                                        <option value="65">新疆维吾尔自治区</option>
                                        <option value="71">台湾省</option>
                                        <option value="81">香港特别行政区</option>
                                        <option value="41">河南省</option>
                                        <option value="82">澳门特别行政区</option>
                                </select>
							</span>&nbsp;&nbsp; <span id="spancity"><select name="city" class="select" id="city" onchange="getqu(1);"><option selected="selected" value="0">请选择</option><option value="4601" selected="selected">海口市</option><option value="4602">三亚市</option><option value="4690">省属虚拟市</option></select></span>
                        </dd>
                    </dl>
                    <dl>
                        <dt>运费：</dt>
                        <dd>
                            <p style="float: left; clear: both; margin-top: 8px;">
                                <input type="radio" value="1" checked="checked" name="goods_transfee_charge" id="whops_seller"> <label for="whops_seller">卖家承担运费</label>
                            </p>
                            <p style="float: left; clear: both; margin-top: 8px;">
                                <input type="radio" value="0" name="goods_transfee_charge" id="whops_buyer" checked="checked"> <label for="whops_buyer">买家承担运费</label>
                            </p>
                            <div class="transport_tpl" id="whops_buyer_box">
                                <ul style="line-height: 30px">
                                    <li><input id="isApplyPostage_true" name="isApplyPostage" class="radio" type="radio" value="1"> <label for="isApplyPostage_true">使用运费模板</label>
                                        <div id="Postage" style="">
                                            <div class="freight-template">
                                             cs  <input onclick="window.open(&#39;/leimingtech-seller/transport/index&#39;)" type="button" value="查看我的运费模板" class="select-templ" id="postageButton">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </dd>
                    </dl>
                    <!--transport info end-->
                    <dl class="tit">
                        <h3>其他信息</h3>
                    </dl>
                    <dl>
                        <dt>本店分类：</dt>
                        <dd>
                            <p>
                                <select name="storeGoodsClass" class="sgcategory">
                                    <option value="">请选择</option> 
                                      
                                            <option value="4ef668b836be467aaafaed6dc0d64bb6" selected="selected">女鞋</option>
    
                                            <option value="742f99cf0291473c804ec4611ab9b012">测试</option>
                                              <option value="006944fc37b34d249033754a50e45ce9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;测试1</option>
                                            
                                            <option value="57cf8c51a1fe45c68368411cf597415c">婴童用品</option>
    
                                            <option value="5e9d7cdf2109496ea66ee02ef658b2f3">海鲜</option>
   
                                </select>
                            </p>
                            <p></p>
                            <p class="hint">
                                                                                店铺分类可以由 "商家中心 -&gt; 商品管理 -&gt; 店铺分类" 中自定义
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品发布：</dt>
                        <dd>
                            <p class="mt5">
                                <label> <input name="goods_show" value="1" type="radio">
                                    立即发布
                                </label>
                            </p>
                            <p class="mt5">
                                <label> <input name="goods_show" value="0" type="radio">
                                    <!-- /> -->
                                    发布时间
                                </label> <input onclick="WdatePicker({minDate:&#39;%y-%M-{%d+1} %H:%m:%s&#39;,dateFmt:&#39;yyyy-MM-dd HH:mm:ss&#39;,alwaysUseStartDate:true});" class="txt" type="text" value="" id="time_to" name="endTime" style="width: 250px; height: 18px;">
                            </p>
                            <p class="mt5">
                                <label> <input name="goods_show" value="2" type="radio" checked="checked">
                                    放入仓库
                                </label>
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品推荐：</dt>
                        <dd>
                            <p>
                                <label style="padding-right: 8px;"> 
                                <input name="goods_commend" value="1" type="radio" checked="checked">是
                                </label> 
                                <label> 
                                <input name="goods_commend" value="0" type="radio"> 否
                            	</label>
                            </p>
                            <p class="hint">被推荐的商品会显示在店铺首页</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>
                            SEO关键字<br>(keywords)：
                        </dt>
                        <dd>
                            <p>
                                <input name="seo_keywords" type="text" class="w400 text" value="">
                            </p>
                            <p class="hint">
                                SEO关键字 (keywords) 出现在商品详细页面头部的 Meta 标签中，<br>用于记录本页面商品的关键字，多个关键字间请用半角逗号
                                "," 隔开
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>
                            SEO描述<br>(description)：
                        </dt>
                        <dd>
                            <p>
								<textarea class="w400" name="seo_description" rows="3" id="remark_input"></textarea>
                            </p>
                            <p class="hint">
                                SEO描述 (description) 出现在商品详细页面头部的 Meta 标签中，<br>用于记录本页面商品内容的概要与描述，建议120字以内
                            </p>
                        </dd>
                    </dl>
                    <div class="clear">
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                    </div>
                    <div class="ncu-form-style tc mb30">
                        <input type="button" class="submit" value="提交" id="btn-sub">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script type="text/javascript">
        var SITE_URL = "http://www.leimingtech.com:99";
        var imgBasePath = 'http://www.leimingtech.com:99';
        var DEFAULT_GOODS_IMAGE = "upload/common/default_goods_image.gif_tiny.gif";
        var provinceId = '46';
        var cityId = '4601';
        //var storeGoodsClassId = '4ef668b836be467aaafaed6dc0d64bb6';
        var goodsFreightPrice = '0';
        var goodsShow = '2';
        var timeTo = '';
        var goodsName = "";             // 商品名称
        var goodsSubtitle = "";         // 商品副标题
        var gcId = "";                  // 分类id
        var gcName = "";                // 分类名称
        var brandId = "";               // 品牌id
        var brandName = "";             // 品牌名
        var typeId = "";                // 类型id
        var specName = "";              // 规格名称
        var specCount = "";             // 规格的数量
        var goodsImage = "";            // 商品默认封面图片
        var goodsImageMore = "";        // 商品多图
        var goodsStorePrice = "";       // 商品店铺价格
        var goodsSerial = "";           // 商品货号
        var goodsShow = "";             // 商品上架1上架0下架
        var prepareUp = "";             // 商品上架1上架0下架
        var goodsCommend = "";          // 商品推荐
        var goodsKeywords = "";         // 商品关键字
        var goodsDescription = "";      // 商品描述
        var goodsBody = "";             // 商品详细内容
        var goodsAttr = "";             // 商品属性
        var attrTag = true;             // 商品属性
        var goodsSpec = "";             // 商品规格
        var specOpen = "";              // 规格开关
        var goodsColImg = "";           // 颜色自定义图片
        var imageSrcCount = 0;          // 图片数量
        var goodsForm = "";             // 商品类型,1为全新、2为二手
        var cityIdSelect = "";          // 商品所在地(市)
        var cityName = "";              // 商品所在地(市)名称
        var provinceIdSelect = "";      // 商品所在地(省)
        var goodsTransfeeCharge = "";   // 商品运费承担方式 默认 0为买家承担 1为卖家承担
        var transportId = "0";
        var StoreClassId = "";          // 店铺自定义分类id
        var goodsStorePriceInterval = "";// 设置商品的价格区间
        var PRICE_FORMAT = '&yen;%s';
        var searchTxt = ' 搜索其实很容易！';
        var oldspecName = '{"90ebdeec509942c29f9780680f500fc1":"美妆效果","d74d77a38ae0404993ca45b6756b8228":"口味","de56f4af63fc48908e91b7c1c11bb4d7":"kk"}';
        $(function () {
            // 初始化富文本编辑器
            initKinEdit();
            // 校验表单
            formValidate();
            // 校验运费模板
            checkTransportId();
            // 颜色图片
            initColorImage();
            // 初始化规格颜色的图片
            initSpecColor();
            // 初始化商品属性
            initGoodsAttr();
            // 初始化商品品牌
            initGoodsBrand();
            // 地区初始化
            init_area(provinceId, cityId);
            // 本店分类初始化
            //initStoreGoodsClass();
            // 初始化运费
            initGoodsStoreTransfee();
            // 初始化,上架下架
            initgoodsUpOrDown();
            // 点击运费有谁负责的适合
            initGoodsTransFeeFrom();
            // 上架下架,以及定时上架
            initGoodsStatus();
            // 删除上传的图片
            deleteUploadImage();
            // 初始化表单数据
            initFormData();
            // 买家承担运费&运费模板
            initFreightStore();
            // 实现图片慢慢浮现出来的效果
            initImageFade();
            // 当选中规格后需要上传图片的时候
            specCheckBoxFun();
            $('#keyword').css("color", "#999999");
            if (oldspecName != "") {
            	console.log("oldspecName:",oldspecName);
                var totalSku = 0;
                $("[name=sku]").each(function () {
                    totalSku += parseInt($(this).attr("value"));
                    console.log("skustore:",totalSku);
                });
                $("[name=goods_storage]").attr("value", totalSku);
                // 商品库存
                specGroupFun();
                // 初始化库存配置
                initSkuDoStore();
                // 获取总库存
                getTotalSku();
            } else {
                initNotHaveGoodsSpec();
            }

            //控制规格,以及规格的图片上传,以及选中规格后库存的控制
            //当规格都至少选中一个的时候,增加一个节点,用来让用户控制商品的库存,以及货号
            $("[nctype=spec_group_dl]").live("change", function () {
                specGroupFun();
            });

            //库存配置变化
            $("[nc_type=spec_table]").live("change", function () {
                getTotalSku();
                caculatePrice();
            });
            
            
            $("[name=specCheckBox]").live("click", function () {
                getTotalSku();
                //caculatePrice();
            });

            $("[name=goodsInfo]").live("change", function () {
                $(this).next().attr("value", $(this).val);
            });

        });

        /**
         * 没有规格的商品
         */
        var initNotHaveGoodsSpec = function () {
        	console.log("initNotHaveGoodsSpec");
        };

        /**
         * 初始化规格颜色的图片
         */
        var initSpecColor = function () {
            $("[nctype=file_tr]").find("[name=customSpecImage]").each(function () {
            });
        };

        /**
         * 初始化库存配置
         */
        var initSkuDoStore = function () {
            $("[name=skuDo]").each(function (index, element) {
                var skuDoSpecValueIdArr = $(this).attr("specValueId").split(",");
            });
        };


        /**
         * 初始化库存配置元素
         */
        var initStoreDocument = function () {
            $("[name=skuDo]").each(function (index, element) {
                var skuDoSpecValueIdArr = $(this).attr("specValueId").split(",");
                var nowIndex;
            });
        }


        /**
         * 初始化属性
         */
        var initGoodsAttr = function () {
            $("[nc_type=attr_select]").each(function () {
                $(this).find("option").each(function () {
                    var attrValueId = $(this).attr("attrValueId");
                });
            });
        };

        /**
         * 品牌初始化
         */
        var initGoodsBrand = function () {
            $("#brand").find("option").each(function () {
                $(this).val();
                if ($(this).val() == '110') {
                    $(this).attr("selected", "selected");
                }
            });
        };

    </script>

    <script type="text/javascript">

        $('.gbin1-list').sortable();

    </script>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-store/js/jquery.mousewheel.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //实现图片慢慢浮现出来的效果
        $("img").load(function () {
            //图片默认隐藏
            $(this).hide();
            //使用fadeIn特效
            $(this).fadeIn("5000");
        });
        // 异步加载图片，实现逐屏加载图片
        $(".scrollLoading").scrollLoading();
    });
</script>


</body>
</html>