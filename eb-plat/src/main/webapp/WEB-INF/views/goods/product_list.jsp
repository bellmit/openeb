<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    
    <title>管理后台</title>
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
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/goodsCommon/downList"><span>违规下架商品</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/goods/goodsCommon/goodsApply"><span>待审核商品</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="http://b2b2c.leimingtech.com/leimingtech-admin/goods/goodsCommon/list">
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
                    <option value="3807b748f2264f5b83769e2025ad315e">阿尼亚斯贝</option>
                    <option value="107">阿迪达斯</option>
                    <option value="108">李宁</option>
                    <option value="109">宝姿</option>
                    <option value="110">佐丹奴</option>
                    <option value="112">百丽</option>
                    <option value="113">梦特娇</option>
                    <option value="114">骆驼</option>
                    <option value="115">猫人</option>
                    <option value="116">皮尔卡丹</option>
                    <option value="117">RDK</option>
                    <option value="118">康妮雅</option>
                    <option value="119">justyle</option>
                    <option value="120">享爱.</option>
                    <option value="121">派丽蒙</option>
                    <option value="122">茵曼（INMAN）</option>
                    <option value="123">她他/tata</option>
                    <option value="124">缪诗</option>
                    <option value="125">真维斯</option>
                    <option value="126">金利来</option>
                    <option value="78">诺基亚</option>
                    <option value="79">摩托罗拉</option>
                    <option value="80">苹果2</option>
                    <option value="81">HTC</option>
                    <option value="82">罗技</option>
                    <option value="83">TP-LINK</option>
                    <option value="84">金士顿</option>
                    <option value="85">雷蛇</option>
                    <option value="86">爱普生</option>
                    <option value="87">DELL</option>
                    <option value="88">索尼</option>
                    <option value="89">富勒</option>
                    <option value="90">雷柏</option>
                    <option value="91">双飞燕</option>
                    <option value="92">山泽</option>
                    <option value="93">三木</option>
                    <option value="94">迈乐</option>
                    <option value="95">惠普</option>
                    <option value="96">索爱</option>
                    <option value="97">飞毛腿</option>
                    <option value="98">阿尔卡特</option>
                    <option value="99">D-Link</option>
                    <option value="100">台电</option>
                    <option value="101">ThinkPad</option>
                    <option value="102">得力</option>
                    <option value="103">acer</option>
                    <option value="104">清华同方</option>
                    <option value="105">富士通</option>
                    <option value="106">微软</option>
                    <option value="140">小米</option>
                    <option value="59">海尔</option>
                    <option value="60">LG</option>
                    <option value="61">飞利浦</option>
                    <option value="62">松下</option>
                    <option value="63">奥克斯</option>
                    <option value="64">三洋</option>
                    <option value="65">奔腾</option>
                    <option value="66">西门子</option>
                    <option value="67">三星</option>
                    <option value="68">格兰仕</option>
                    <option value="69">艾力斯特</option>
                    <option value="70">苏泊尔</option>
                    <option value="71">伊莱克斯</option>
                    <option value="72">创维</option>
                    <option value="73">三菱电机</option>
                    <option value="74">TCL</option>
                    <option value="75">夏普</option>
                    <option value="76">格力</option>
                    <option value="77">九阳</option>
                    <option value="41">珀莱雅</option>
                    <option value="42">护舒宝</option>
                    <option value="43">娇兰</option>
                    <option value="44">兰蔻</option>
                    <option value="45">妮维雅</option>
                    <option value="46">高丝洁</option>
                    <option value="47">高丝</option>
                    <option value="48">佳洁士</option>
                    <option value="49">纪梵希</option>
                    <option value="50">卡尼尔</option>
                    <option value="51">娇爽</option>
                    <option value="52">苏菲</option>
                    <option value="53">芙丽芳丝</option>
                    <option value="54">波斯顿</option>
                    <option value="55">雅诗兰黛</option>
                    <option value="56">资生堂</option>
                    <option value="57">相宜本草</option>
                    <option value="58">薇姿</option>
                    <option value="37">高仕</option>
                    <option value="38">佐卡伊</option>
                    <option value="39">瑞士军刀</option>
                    <option value="40">蓝色多瑙河</option>
                    <option value="27">汤臣倍健</option>
                    <option value="28">白兰氏</option>
                    <option value="29">同仁堂</option>
                    <option value="30">善存</option>
                    <option value="31">长城葡萄酒</option>
                    <option value="32">新西兰十一坊</option>
                    <option value="33">Lumi</option>
                    <option value="34">养生堂</option>
                    <option value="19">金史密斯（KINGSMITH）</option>
                    <option value="20">BH (必艾奇)</option>
                    <option value="21">威尔胜</option>
                    <option value="22">皮尔瑜伽</option>
                    <option value="23">以诗萜</option>
                    <option value="24">斯伯丁</option>
                    <option value="25">远洋瑜伽</option>
                    <option value="26">捷安特</option>
                    <option value="4">费雪</option>
                    <option value="5">美斯特伦</option>
                    <option value="6">惠氏</option>
                    <option value="7">美赞臣</option>
                    <option value="8">布朗博士</option>
                    <option value="9">乐高</option>
                    <option value="10">嘉宝</option>
                    <option value="11">多美</option>
                    <option value="12">雀巢</option>
                    <option value="13">妈咪宝贝</option>
                    <option value="14">强生</option>
                    <option value="15">澳优</option>
                    <option value="16">雅培</option>
                    <option value="17">亨氏</option>
                    <option value="18">十月妈咪</option>
                    <option value="1">中国移动</option>
                    <option value="2">中国电信</option>
                    <option value="3">中国联通</option>
                    <option value="141">乐视</option>
                    <option value="142">格莱帝</option>
                    <option value="322de12474e048c6a4c6975aa0319c55">呵呵呵商品</option>
                    <option value="7e12a0c0333944c09d34d2ef96e360c1">1111</option>
                    <option value="c66f117297fa4b46a31d1bb6ddc6d56a">消费娱乐</option>
                    <option value="e5f8e0f24de54b9ba00e4a323c54da99">长虹电视</option>
                    <option value="179">DR</option>
                    <option value="180">三只松鼠</option>
                    <option value="181">星巴克</option>
                    <option value="182">无名缘米粉</option>
                    <option value="183">零食铺</option>
                    <option value="184">大白兔</option>
                    <option value="185">恰恰</option>
                    <option value="186">零舍梧桐</option>
                    <option value="187">达利园</option>
                    <option value="188">猪手</option>
                    <option value="09939d90d9744b37ad06eeb986675e00">C</option>
                    <option value="0ecb21243cbc4b738e4cf34b8eac10ac">赫莲娜</option>
                    <option value="183c9d9cb01248a092b3aa2cb81f1502">好奇</option>
                    <option value="2c0e850a4fdc415ab1f2daf1706063a2">倩碧</option>
                    <option value="3f10529f5e034d619d389ced4cafb0b1">R</option>
                    <option value="421b3381fcfa4d4eb9d8990d19540360">Olay</option>
                    <option value="4268cc45ead84fc1aa89a5c4b3e806ad">悦诗风吟</option>
                    <option value="4a708b19ca944b3dac6ad3d3a0de9b17">迪奥</option>
                    <option value="52f155010e784411bc9ae24ea1457052">香奈儿</option>
                    <option value="69daa4c17840427aa3dc8110c6e37c21">sony</option>
                    <option value="72ecd2dc993949228ad6d9be46edbba6">贝玲妃</option>
                    <option value="91a21c818e234ab0bc23dc2dd91d4b32">蜜丝佛陀</option>
                    <option value="9ab40cefedb6471596ee2056fb0b5642">索尼（测）</option>
                    <option value="aa222bc30cec4655be8e87a2fb7cfa37">韩都衣舍</option>
                    <option value="b1bacd67919246a8beedd7bbba643d40">eeeee</option>
                    <option value="c1fb012c18fe40e284d50c10eedcda99">NARS</option>
                    <option value="cc7961b3eee44dbea3b4ba29e6f9618f">B</option>
                    <option value="d870e3e7a7c74691b12ef6332316280d">C</option>
                    <option value="ea6c637f5c0a4abcabcacd8247099c03">植村秀</option>
                    <option value="f110930dfffe46809d5c54afd9b4d99d">阿玛尼</option>
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
	            <tr class="hover edit" style="background: rgb(255, 255, 255);">
	                <td><input type="checkbox" name="ids" value="8f200d98b5f24b2693d38a30f04d1dc1" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469782841767.png" onload="javascript:DrawImage(this,56,56);" width="56" height="56">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>ttttttttt</span></p>
	                    <p class="store">所属店铺:不加奶油的蛋糕</p></td>
	                <td><p></p>
	                    <p>三星</p></td>
	                <td class="align-center">￥22</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=8f200d98b5f24b2693d38a30f04d1dc1" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;8f200d98b5f24b2693d38a30f04d1dc1&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="6d87071e40554a96a8e9b4765f9596b0" class="checkitem"></td>
	                <td class="w60 align-center">212122121</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469674255290.jpg" onload="javascript:DrawImage(this,56,56);" height="56" width="51">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>哈哈哈哈背包</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>背包</p></td>
	                <td class="align-center">￥0.01</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=6d87071e40554a96a8e9b4765f9596b0" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;6d87071e40554a96a8e9b4765f9596b0&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="5c0891a6226b477c80100dcf2579380d" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469527086330.png" onload="javascript:DrawImage(this,56,56);" width="56" height="20">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>12312123</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>手机膜</p></td>
	                <td class="align-center">￥1</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=5c0891a6226b477c80100dcf2579380d" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;5c0891a6226b477c80100dcf2579380d&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit" style="background: rgb(251, 251, 251);">
	                <td><input type="checkbox" name="ids" value="07f18502264f4acfad21b24c10cd5760" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469437319231.png" onload="javascript:DrawImage(this,56,56);" height="56" width="54">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>我的手机1</span></p>
	                    <p class="store">所属店铺:不加奶油的蛋糕</p></td>
	                <td><p>小米</p>
	                    <p>IPHONE</p></td>
	                <td class="align-center">￥1200</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=07f18502264f4acfad21b24c10cd5760" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;07f18502264f4acfad21b24c10cd5760&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit" style="background: rgb(255, 255, 255);">
	                <td><input type="checkbox" name="ids" value="25b9d26afeac412188566b0fcadffc5c" class="checkitem"></td>
	                <td class="w60 align-center">12314123</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469349103095.PNG" onload="javascript:DrawImage(this,56,56);" height="56" width="53">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>会理石榴</span></p>
	                    <p class="store">所属店铺:兔兔qqqq</p></td>
	                <td><p></p>
	                    <p>生鲜</p></td>
	                <td class="align-center">￥123</td>
	                <td class="align-center">
	                	下架
	                    
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=25b9d26afeac412188566b0fcadffc5c" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="68ea413343e444d188a3e21ab998387a" class="checkitem"></td>
	                <td class="w60 align-center">123</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/saved_resource" onload="javascript:DrawImage(this,56,56);">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>123</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p>佐丹奴</p>
	                    <p>家政服务</p></td>
	                <td class="align-center">￥1</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=68ea413343e444d188a3e21ab998387a" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;68ea413343e444d188a3e21ab998387a&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="4cc9aa1af1514f349598b091a37caa75" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469082658405.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="31">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>fdsdf</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p></p>
	                    <p>衬衣</p></td>
	                <td class="align-center">￥25</td>
	                <td class="align-center">
	                	
	                    
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=4cc9aa1af1514f349598b091a37caa75" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="104a0f05565e4d5084fe96594a8046e1" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1469006369627.jpg" onload="javascript:DrawImage(this,56,56);" height="56" width="42">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>123</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p>佐丹奴</p>
	                    <p>家政服务</p></td>
	                <td class="align-center">￥100</td>
	                <td class="align-center">
	                	
	                    
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=104a0f05565e4d5084fe96594a8046e1" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="9368290050b04d72a0c1789901ac5fc9" class="checkitem"></td>
	                <td class="w60 align-center">就是不发货</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1468999122499.jpg" onload="javascript:DrawImage(this,56,56);" height="56" width="42">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>哇哈哈面膜</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p></p>
	                    <p>超级本</p></td>
	                <td class="align-center">￥99999</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=9368290050b04d72a0c1789901ac5fc9" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;9368290050b04d72a0c1789901ac5fc9&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="6b7baf4121564a1e8acac04dea3d1346" class="checkitem"></td>
	                <td class="w60 align-center">333</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/saved_resource" onload="javascript:DrawImage(this,56,56);">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>sasss</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>匡威</p></td>
	                <td class="align-center">￥33</td>
	                <td class="align-center">
	                	下架
	                    
                    </td>
                    <td class="align-center">
	                	
	                    
	                    
	                    违规
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=6b7baf4121564a1e8acac04dea3d1346" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="116d38e20e8c472787f1376c408a8c97" class="checkitem"></td>
	                <td class="w60 align-center">37322</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1467118413386.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="42">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>在这里搞个奶粉</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p></p>
	                    <p>美食</p></td>
	                <td class="align-center">￥288</td>
	                <td class="align-center">
	                	下架
	                    
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=116d38e20e8c472787f1376c408a8c97" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="0983a1f4b93546f29e0c7faf175b8cce" class="checkitem"></td>
	                <td class="w60 align-center">37321</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1467116635658.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="42">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>婴儿乳粉色情</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>食品</p></td>
	                <td class="align-center">￥288</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=0983a1f4b93546f29e0c7faf175b8cce" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;0983a1f4b93546f29e0c7faf175b8cce&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="e57b96075d38407a845ce8bfe4cce89e" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1467102765272.jpg" onload="javascript:DrawImage(this,56,56);" height="56" width="38">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>U-FUN</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p>阿迪达斯</p>
	                    <p>女鞋</p></td>
	                <td class="align-center">￥100</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=e57b96075d38407a845ce8bfe4cce89e" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;e57b96075d38407a845ce8bfe4cce89e&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="bb03439649134545926e86f6570506f6" class="checkitem"></td>
	                <td class="w60 align-center">R01</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1467075023555.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="42">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>上衣aa</span></p>
	                    <p class="store">所属店铺:123</p></td>
	                <td><p></p>
	                    <p>童装</p></td>
	                <td class="align-center">￥300</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=bb03439649134545926e86f6570506f6" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;bb03439649134545926e86f6570506f6&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="2b3610435dd643ff80cea9f705646c86" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/saved_resource" onload="javascript:DrawImage(this,56,56);">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>wwwq</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>32</p></td>
	                <td class="align-center">￥100</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    
	                    已拒绝
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=2b3610435dd643ff80cea9f705646c86" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="d42a87cbae1042f181f6d9c13524c851" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1466494382235.png" onload="javascript:DrawImage(this,56,56);" height="56" width="52">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>AAABBB</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p>双飞燕</p>
	                    <p>55</p></td>
	                <td class="align-center">￥10</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=d42a87cbae1042f181f6d9c13524c851" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;d42a87cbae1042f181f6d9c13524c851&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="8ae0a69cc3e2483a9a2307d8fb899763" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1466478484517.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="35">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>iphone6</span></p>
	                    <p class="store">所属店铺:平台自营</p></td>
	                <td><p></p>
	                    <p>IPHONE</p></td>
	                <td class="align-center">￥1234</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=8ae0a69cc3e2483a9a2307d8fb899763" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;8ae0a69cc3e2483a9a2307d8fb899763&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="c729de2cc65e42c589e9b2e2d046d16e" class="checkitem"></td>
	                <td class="w60 align-center">DSFDADSasfa</td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1466348322228.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="38">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>TCL</span></p>
	                    <p class="store">所属店铺:不加奶油的蛋糕</p></td>
	                <td><p></p>
	                    <p>32</p></td>
	                <td class="align-center">￥23000</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    
	                    已拒绝
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=c729de2cc65e42c589e9b2e2d046d16e" target="_blank">查看</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="4b67c2850e4f43999df1bcb115eb53e1" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1466071717985.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="30">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>海绵宝宝</span></p>
	                    <p class="store">所属店铺:蜂蜜柚子</p></td>
	                <td><p></p>
	                    <p>手拿玩具</p></td>
	                <td class="align-center">￥1</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=4b67c2850e4f43999df1bcb115eb53e1" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;4b67c2850e4f43999df1bcb115eb53e1&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
	            <tr class="hover edit">
	                <td><input type="checkbox" name="ids" value="1cd2cdc6286d4dd8903bcb3ad85d312c" class="checkitem"></td>
	                <td class="w60 align-center"></td>
	                <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i>
	                    <img src="./管理后台-商品管理_files/1465290855995.jpg" onload="javascript:DrawImage(this,56,56);" width="56" height="56">
	                </span></div></td>
	                <td class="goods-name w270"><p><span>开帝国</span></p>
	                    <p class="store">所属店铺:不加奶油的蛋糕</p></td>
	                <td><p></p>
	                    <p>IPHONE</p></td>
	                <td class="align-center">￥5052</td>
	                <td class="align-center">
	                	
	                    上架
                    </td>
                    <td class="align-center">
	                	
	                    已通过
	                    
	                    
                    </td>
	                <td class="align-center">
	                	<p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=1cd2cdc6286d4dd8903bcb3ad85d312c" target="_blank">查看</a></p>
	                		<p><a href="javascript:void(0);" onclick="goods_lockup(&#39;1cd2cdc6286d4dd8903bcb3ad85d312c&#39;);">违规下架</a></p>
	                </td>
	            </tr>
	            <tr style="display:none;">
	                <td colspan="20"><div class="ncsc-goods-sku ps-container"></div></td>
	            </tr>
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