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
	<link href="${pageContext.request.contextPath}/static/ui-v2/css/font-awesome.min.css" rel="stylesheet">
	<!--[if IE 7]>
	  <link rel="stylesheet" href="/leimingtech-admin/res/css/font/font-awesome/css/font-awesome-ie7.min.css">
	<![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/dialog/dialog.js" id="dialog_js" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dialog/dialog.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/perfect-scrollbar.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.mousewheel.js" charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/jquery-plat/area.js"></script>
	
	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
	        });
	    });
	
	    function deleteGoods(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("请至少选择一个要删除的项目");
	        }else{
	            if(confirm('您确定要删除吗?')){
	                $("#form_list").attr("action",APP_BASE+"/goods/goodsCommon/delGoods");
	                $('#form_list').submit();
	            }
	        }
	    }
	
	    function wgxjGoods(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("请至少选择一个要下架的项目");
	        }else{
	            var item = "";
	            $("input[name='ids']:checked").each(function(){
	                item += this.value+",";
	            });
	           item = item.substring(0,item.length-1);
	            goods_lockup(item);
	        }
	    }
	    //商品审核通过
	    function oNApply(id){
	    	layer.confirm('您确定要通过该商品的审核吗?', {icon: 3}, function(index){
	    		$("#form_list").attr("action",APP_BASE+"/goods/goodsCommon/oNApply?goodsId="+id);
	            $('#form_list').submit();   	    
	    	});
	    }
	   //商品审核拒绝
	    function offApply(id){
	    	layer.confirm('您确定要拒绝该商品的审核吗?', {icon: 3}, function(index){
	    		$("#form_list").attr("action",APP_BASE+"/goods/goodsCommon/offApply?goodsId="+id);
	            $('#form_list').submit();   	    
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
            <h3>商品管理</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>所有商品</span></a></li>
                <li><a href="${pageContext.request.contextPath}/goods/downList"><span>违规下架商品</span></a></li>
                <li><a href="${pageContext.request.contextPath}/goods/applyList"><span>待审核商品</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="${pageContext.request.contextPath}/goods">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label for="search_goods_name">商品名称:</label></th>
                <td><input type="text" value="" name="goodsName" id="search_goods_name" class="txt"></td>
                <th><label for="search_commonid">商品货号:</label></th>
                <td><input type="text" value="" name="goodsSerial" id="search_commonid" class="txt"></td>
                <th><label>分类</label></th>
                <td id="gcategory" colspan="8" style="width:600px">
                	<input type="hidden" id="cate_id" name="gcId" value="" class="mls_id">
                    <input type="hidden" id="cate_name" name="gcName" value="" class="mls_names">
                    <select class="querySelect">
	                    <option value="0">请选择...</option>
	                        <option value="0568b2fe256946ffa5b94bb5abb1adda">二手房</option>
	                        <option value="eae1aa38c0c6451d8f9436e203880d78">租房</option>
	                        <option value="8a2defb1ebdf4458ab76b9369611586c">手机 数码 电脑 家电</option>
	                        <option value="be641713440a4788947c7234fa550a7b">生活服务</option>
	                        <option value="c748d987f7f043b3a4aa13c180cf77c4">母婴用品 玩具图书</option>
	                        <option value="625bb2e038214198805db26596201210">酒类 生鲜 食品</option>
	                        <option value="139eaf1f1e814a7fa93b903049c4771d">家居家纺</option>
	                        <option value="28ed715304e4437d962938964011ac95">美妆洗护</option>
	                        <option value="e1dd743764d04071971d2cc57e5f6483">家用电器</option>
	                        <option value="2848fbbb6ea84f6ba592f44e3f3d340c">珠宝，首饰</option>
                    </select>
                </td>


            </tr>
            <tr>
                <th><label for="search_store_name">所属店铺:</label></th>
                <td>
                <input type="text" name="storeName" id="search_store_name" class="txt" value="">
                </td>
                <th><label>品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牌:</label></th>
                <td><select name="brandId">
                    <option value="">请选择...</option>
                    <option value="128">富安娜</option>
                    <option value="129">爱仕达</option>
                    <option value="130">罗莱</option>
                    <option value="131">麦包包</option>
                    <option value="132">天堂伞</option>
                    <option value="133">世家洁具</option>
                    <option value="135">慧乐家</option>
                    <option value="136">希格</option>
                    <option value="137">溢彩年华</option>
                    <option value="138">美好家</option>
                    <option value="139">博洋家纺</option>
                    <option value="49">纪梵希</option>
                    <option value="50">卡尼尔</option>
                    <option value="51">娇爽</option>
                </select></td>
                <th><label>商品状态:</label></th>
                <td>
	                <select name="goodsShow">
	                    <option value="" selected="selected">请选择...</option>
	                    <option value="1">上架</option>
	                    <option value="0">下架</option>
	                </select>
                </td>
                <th><label>审核状态:</label></th>
                <td>
	                <select name="goodsState">
	                    <option value="" selected="selected">请选择...</option>
	                    <option value="60">待审核</option>
	                    <option value="30">已通过</option>
	                    <option value="50">已拒绝</option>
	                    <option value="40">违规</option>
	                </select>
                </td>
                <th><label>所在地</label></th>
                <td>
                    <span id="spanarea">
				<select name="area" id="area">
                    <option value="">请选择...</option>
                            <option value="11">北京市</option>
                            <option value="44">广东省</option>
                            <option value="45">广西壮族自治区</option>
                            <option value="46">海南省</option>
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
                            <option value="43">湖南省</option>
                            <option value="42">湖北省</option>
                            <option value="12">天津市</option>
                            <option value="13">河北省</option>
                            <option value="14">山西</option>
                            <option value="15">内蒙古自治区</option>
                            <option value="21">辽宁省</option>
                            <option value="22">吉林省</option>
                            <option value="23">黑龙江省</option>
                            <option value="31">上海市</option>
                            <option value="32">江苏省</option>
                            <option value="33">浙江省</option>
                            <option value="34">安徽省</option>
                            <option value="35">福建省</option>
                            <option value="36">江西省</option>
                            <option value="37">山东省</option>
                            <option value="41">河南省</option>
                            <option value="82">澳门特别行政区</option>
                </select>
				</span>&nbsp;&nbsp;
                    <span id="spancity"></span>
                    <span class="form-tips" style="color: red" name="check" id="checkedarea"></span>
                    <input id="memberProvinceid" type="hidden" name="memberProvinceId" value="">
                    <input id="city_id" type="hidden" name="city_id" value="">
                </td>
                 <td>
                     <a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>
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
                <li>上架,下架，当商品处于非违规下架状态时，前台能浏览该商品，店主可控制商品上、下架状态</li>
                <li>违规下架，当商品处于违规下架状态时，前台将不能浏览该商品，管理员可控制商品违规下架状态，并且违规下架商品被商家重新编辑后可以上架</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form method="post" id="form_list">
        <input type="hidden" name="form_submit" value="ok">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th class="w24"></th>
                <th class="align-center">平台货号</th>
                <th colspan="2">商品名称</th>
                <th>品牌&amp;分类</th>
                <th class="align-center">价格</th>
                <th class="align-center">商品状态</th>
                <th class="align-center">商品审核状态</th>
                <th class="w48 align-center">操作  </th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${productList }" var="product">
	            <tr class="hover edit" style="background: rgb(255, 255, 255);">
	                <td><input type="checkbox" name="ids" value="${product.id }" class="checkitem"></td>
	                <td class="w60 align-center">${product.barcode }</td>
	                <td class="w60 picture">
	                	<div class="size-56x56">
	                		<span class="thumb size-56x56"><i></i>
	                    	<img src="/1469782841767.png" onload="javascript:DrawImage(this,56,56);" width="56" height="56">
	                		</span>
	                	</div>
	                </td>
	                <td class="goods-name w270">
	                	<p><span>${product.title }</span></p>
	                    <p class="store">所属店铺:${product.shoptitle }</p>
	                </td>
	                <td><p>${product.brandtitle }</p>
	                    <p>${product.catetitle }</p>
	                </td>
	                <td class="align-center">￥${product.price }</td>
	                <td class="align-center">上架</td>
                    <td class="align-center">已通过</td>
	                <td class="align-center">
	                	<p><a href="${pageContext.request.contextPath}//goods/form?id=${product.id }" target="_blank">修改</a></p>
	                	<p><a href="${pageContext.request.contextPath}//goods/detail?id=${product.id }" target="_blank">查看</a></p>
	                	<p><a href="javascript:void(0);" onclick="goods_lockup('${product.id }');">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            </c:forEach>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td><input type="checkbox" class="checkall" id="checkallBottom"></td>
                <td colspan="16"><label for="checkallBottom">全选</label>
                    &nbsp;&nbsp;<a href="JavaScript:void(0);" class="btn" nctype="lockup_batch" onclick="wgxjGoods()"><span>违规下架</span></a> <a href="JavaScript:void(0);" class="btn" nctype="del_batch" onclick="deleteGoods()"><span>删除</span></a>
				<div class="pagination">
				    <ul><li>
				                </li><li><span>首页</span></li>
				                    <li><span class="currentpage">1</span></li>
				                    <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
				                <li><span>...</span></li>
				                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(4)"><span>4</span></a></li>
				                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(5)"><span>5</span></a></li>
				                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
				                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(5)"><span>末页</span></a></li>
				        <script language="javascript">
				            function turnOverPage(no) {
				                var queryForm = document.formSearch;
				                if (no >5) {
				                    no =5;
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
</div>

<script type="text/javascript">

    $(function(){
        // 地区搜索后回显搜索的地区
    	// 选择分类搜索后回显搜索的分类
        gcategoryInit("gcategory");

        // ajax获取商品列表
        $('i[nctype="ajaxGoodsList"]').toggle(
                function(){
                    $(this).removeClass('icon-plus-sign').addClass('icon-minus-sign');
                    var _parenttr = $(this).parents('tr');
                    var _commonid = $(this).attr('data-comminid');
                    var _div = _parenttr.next().find('.ncsc-goods-sku');
                    if (_div.html() == '') {
                        $.getJSON(APP_BASE+'/goods/goodsCommon/getGoods' , {commonids : _commonid}, function(data){
                            if (data != 'false') {
                                var _ul = $('<ul class="ncsc-goods-sku-list"></ul>');
                                $.each(data, function(i, o){
                                    $('<li><div class="goods-thumb" title="商家货号：' + o.goodsCommonid + '">' +
                                            '<a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id='+o.goodsId+'" target="_blank"><image src="http://www.leimingtech.com:99'+ o.goodsImage + '" ></a></div>'
                                            + '<div class="goods_spec">颜色<em title=""></em></div>'
                                            + '<div class="goods-price">价格：<em title="￥' + o.goodsPrice + '">￥' + o.goodsPrice + '</em></div><div class="goods-storage">库存：<em title="' + o.goodsStorage + '">' + o.goodsStorage + '</em></div><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id='+o.goodsId+'" target="_blank" class="ncsc-btn-mini">查看商品详情</a></li>').appendTo(_ul);
                                });
                                _ul.appendTo(_div);
                                _parenttr.next().show();
                                // 计算div的宽度
                                _div.css('width', document.body.clientWidth-54);
                                _div.perfectScrollbar();
                            }
                        });
                    } else {
                        _parenttr.next().show()
                    }
                },
                function(){
                    $(this).removeClass('icon-minus-sign').addClass('icon-plus-sign');
                    $(this).parents('tr').next().hide();
                }
        );
    });

    // 获得选中ID
    function getId() {
        var str = '';
        $('#form_goods').find('input[name="id[]"]:checked').each(function(){
            id = parseInt($(this).val());
            if (!isNaN(id)) {
                str += id + ',';
            }
        });
        if (str == '') {
            return false;
        }
        str = str.substr(0, (str.length - 1));
        return str;
    }

    // 商品下架
    function goods_lockup(ids) {
        _uri = APP_BASE+"/goods/goodsCommon/remark?id="+ids ;
        CUR_DIALOG = ajax_form('goods_lockup', '违规下架理由', _uri, 350);
    }

</script>

</body>
</html>