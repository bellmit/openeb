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
	<link rel="stylesheet" type="text/css" href="./管理后台-楼层编辑_files/jquery.ui.css">
	<link rel="stylesheet" type="text/css" href="./管理后台-楼层编辑_files/dialog.css">
	<script type="text/javascript" src="./管理后台-楼层编辑_files/jquery.ui.js"></script>
	<script type="text/javascript" src="./管理后台-楼层编辑_files/zh-CN.js" charset="utf-8"></script>
	<script type="text/javascript" src="./管理后台-楼层编辑_files/dialog.js" id="dialog_js"></script>
	<link href="./管理后台-楼层编辑_files/dialog.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="./管理后台-楼层编辑_files/ajaxfileupload.js"></script>
	<script type="text/javascript" src="./管理后台-楼层编辑_files/common_select.js"></script>
	<script type="text/javascript">
	    DialogManager.close = function(id) {
	        __DIALOG_WRAPPER__[id].hide();
	        ScreenLocker.unlock();
	    }
	    DialogManager.show = function(id) {
	        if (__DIALOG_WRAPPER__[id]) {
	            __DIALOG_WRAPPER__[id].show();
	            ScreenLocker.lock();
	            return true;
	        }
	        return false;
	    }
	    function show_dialog(id,title) {//弹出框
	        if(DialogManager.show(id)) return;
	        var d = DialogManager.create(id);//不存在时初始化(执行一次)
	        var dialog_html = $("#"+id+"_dialog").html();
	        $("#"+id+"_dialog").remove();
	        d.setTitle(title);
	        d.setContents('<div id="'+id+'_dialog" class="'+id+'_dialog">'+dialog_html+'</div>');
	        d.setWidth(640);
	        d.show('center',1);
	        //update_dialog(id);
	    }
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>楼层管理</h3>
        <ul class="tab-base">
            <li><a href="/website/index/list?type=floor_list"><span>管理</span></a></li>
            <li><a href="JavaScript:void(0);" class="current"><span>编辑</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="store_class_form" name="floorForm" method="post" action="/website/index/save">
    <table class="table tb-type2">
        <tbody>
        <input type="hidden" name="id" value="118a7c76ba5746788b1271c30cbd0ba6">
        <input type="hidden" name="type" value="floor_list">
        <input type="hidden" name="gcId" id="gcId" value="eae1aa38c0c6451d8f9436e203880d78">
        <tr>
            <td colspan="2" class="required"><label for="sort">楼层主题分类：</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform">
                <input type="button" value="编辑" onclick="show_dialog(&#39;category_list&#39;,&#39;楼层主题分类&#39;)">
                <div id="floorClassData">
                    <input type="hidden" name="goodsClassList[0].gcId" value="36cfeecf4a524016b7122034a3b2b516">
                    <input type="text" name="goodsClassList[0].gcName" value="箱包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[1].gcId" value="3aef387727f64cc79494776ea595b0cc">
                    <input type="text" name="goodsClassList[1].gcName" value="男装" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[2].gcId" value="c9c3137e75d94ef5b58fcd1892399d9a">
                    <input type="text" name="goodsClassList[2].gcName" value="鞋靴" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[3].gcId" value="d579627f99ba47968e37a203875d7ad7">
                    <input type="text" name="goodsClassList[3].gcName" value="女装" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[4].gcId" value="1712da292900481f8a2165ab1a784e09">
                    <input type="text" name="goodsClassList[4].gcName" value="青年服装" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[5].gcId" value="4628617e3cee4b07b5e2d90daa09ddf7">
                    <input type="text" name="goodsClassList[5].gcName" value="钱包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[6].gcId" value="6ed250e7f2774306a16d6d5fe2f4b8df">
                    <input type="text" name="goodsClassList[6].gcName" value="中老年服装" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[7].gcId" value="74fba86e5ced4c188b9933834bbc4d73">
                    <input type="text" name="goodsClassList[7].gcName" value="电脑包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[8].gcId" value="99d9b4e18b0b4123a1868723544ba3f8">
                    <input type="text" name="goodsClassList[8].gcName" value="双肩包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[9].gcId" value="dbe939dee686424fadbd4b9c9cac3e36">
                    <input type="text" name="goodsClassList[9].gcName" value="手提包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[10].gcId" value="e012edc9f79f4c60a1d8291cc0c6bc24">
                    <input type="text" name="goodsClassList[10].gcName" value="手提包" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                    <input type="hidden" name="goodsClassList[11].gcId" value="e29f56d378e3463a87cdfed62ee2e206">
                    <input type="text" name="goodsClassList[11].gcName" value="童装" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px">
                </div>
            </td>
            <td class="vatop tips"></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label for="sort">楼层主题图片：</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
        	<input type="hidden" name="floorImg" id="floorImg" value="/upload/img/adv/1463715790091.png">
        	<input type="hidden" name="floorUrl" id="floorUrl" value="">
            <td class="vatop rowform">
                	<img id="floorThemeImg" width="212px" height="212px" src="./管理后台-楼层编辑_files/1463715790091.png">
                <input type="button" value="编辑" onclick="show_dialog(&#39;upload_floorTheme&#39;,&#39;楼层主题图片&#39;)"></td>
            <td class="vatop tips">请上传212×241像素GIF\JPG\PNG格式图片</td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label>楼层导航图片：</label></td>
        </tr>
        <tr class="noborder">
        	<input type="hidden" name="bannerImg" id="bannerImg" value="/upload/img/adv/1463715362471.png">
        	<input type="hidden" name="bannerUrl" id="bannerUrl" value="">
            <td class="vatop rowform">
	            	<img id="floorBannerImg" width="210px" height="212px" src="./管理后台-楼层编辑_files/1463715362471.png">
                <input type="button" value="编辑" onclick="show_dialog(&#39;upload_floorBanner&#39;,&#39;楼层导航图片&#39;);">
            </td>
            <td class="vatop tips">请上传210×40像素GIF\JPG\PNG格式图片</td>
        </tr>

        <tr>
            <td colspan="2" class="required"><label for="sort">楼层主题名称：</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" class="txt" name="floorName" id="floorName" value="服装、箱包"></td>
            <td class="vatop tips"></td>
        </tr>

        <tr>
            <td colspan="2" class="required"><label for="sort">楼层副名称：</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" class="txt" name="subName" id="subName" value="服装、箱包"></td>
            <td class="vatop tips"></td>
        </tr>

        <tr>
            <td colspan="2" class="required"><label for="sort">楼层商品列表：</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <input type="button" value="编辑" onclick="show_dialog(&#39;recommend_list&#39;,&#39;楼层商品列表&#39;)">
                <div id="floorGoodsData">
                          <input type="hidden" name="goodsList[0].goodsId" value="5d1fc175983d4ebe91f2cae75afd4995">
                          <input type="hidden" name="goodsList[0].goodsName" value="欧时纳包包2016新款 手提包韩版时尚女士斜挎包春夏百搭休闲女包">
                          <input type="hidden" name="goodsList[0].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[0].goodsPrice" value="">
                          <input type="hidden" name="goodsList[0].goodsImage" value="/upload/img/store/0/1458292894109.jpg_430x430q90.jpg">
                          <input type="hidden" name="goodsList[1].goodsId" value="1de7c8c13609465990805ba0f57652c1">
                          <input type="hidden" name="goodsList[1].goodsName" value="正品高端女款旅行箱万向轮行礼箱凯容牌PU皮萌萌小熊拉杆箱">
                          <input type="hidden" name="goodsList[1].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[1].goodsPrice" value="">
                          <input type="hidden" name="goodsList[1].goodsImage" value="/upload/img/store/0/1458293966433.jpg_400x400.jpg">
                          <input type="hidden" name="goodsList[2].goodsId" value="9f3a8bf0808248799f8ef57deb0bcb28">
                          <input type="hidden" name="goodsList[2].goodsName" value="骆驼男装 2016春装男士夹克衫 短款外套大码青年简约薄款茄克立领">
                          <input type="hidden" name="goodsList[2].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[2].goodsPrice" value="">
                          <input type="hidden" name="goodsList[2].goodsImage" value="/upload/img/store/0/1458291946677.jpg_430x430q90.jpg">
                          <input type="hidden" name="goodsList[3].goodsId" value="fdcdee420a69434cbd21d615ed97b43b">
                          <input type="hidden" name="goodsList[3].goodsName" value="春季白色商务休闲男士长袖衬衫韩版修身职业正装寸衫免烫工装衬衣">
                          <input type="hidden" name="goodsList[3].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[3].goodsPrice" value="">
                          <input type="hidden" name="goodsList[3].goodsImage" value="/upload/img/store/0/1458292234477.jpg_430x430q90.jpg">
                          <input type="hidden" name="goodsList[4].goodsId" value="78216c41029d4f41bfbca7ad5e57487e">
                          <input type="hidden" name="goodsList[4].goodsName" value="韩版潮短靴休闲鞋真皮女高帮鞋平底女靴春秋拉链女鞋靴子B815">
                          <input type="hidden" name="goodsList[4].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[4].goodsPrice" value="">
                          <input type="hidden" name="goodsList[4].goodsImage" value="/upload/img/store/0/1458294123763.jpg_430x430q90.jpg">
                          <input type="hidden" name="goodsList[5].goodsId" value="d0e3e12758d34aa190daacc86271a8c6">
                          <input type="hidden" name="goodsList[5].goodsName" value="春季男鞋子男士休闲鞋韩版潮鞋青年板鞋男时尚系带低帮布洛克皮鞋">
                          <input type="hidden" name="goodsList[5].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[5].goodsPrice" value="">
                          <input type="hidden" name="goodsList[5].goodsImage" value="/upload/img/store/0/1458294717927.jpg_400x400.jpg">
                          <input type="hidden" name="goodsList[6].goodsId" value="7a125d2b9ac24449beea87cc57352f31">
                          <input type="hidden" name="goodsList[6].goodsName" value="2016春秋新款中长半身裙网纱裙高腰蓬蓬裙欧根纱半裙大摆伞裙中裙">
                          <input type="hidden" name="goodsList[6].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[6].goodsPrice" value="">
                          <input type="hidden" name="goodsList[6].goodsImage" value="/upload/img/store/0/1458291777550.gif_400x400.jpg">
                          <input type="hidden" name="goodsList[7].goodsId" value="07b9989c2d4c41b18aed23b1ecdc6494">
                          <input type="hidden" name="goodsList[7].goodsName" value="时尚棉麻套裙2016春装新款七分袖上衣半身长裙印花套装休闲两件套">
                          <input type="hidden" name="goodsList[7].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[7].goodsPrice" value="">
                          <input type="hidden" name="goodsList[7].goodsImage" value="/upload/img/store/0/1458289058765.jpg_430x430q90.jpg">
                          <input type="hidden" name="goodsList[8].goodsId" value="2c4c4a966bde41f9ba0f92d2e6baddeb">
                          <input type="hidden" name="goodsList[8].goodsName" value="2016春秋新款韩版女装针织衫中长款圆领开衫双排扣毛衣秋装外套女">
                          <input type="hidden" name="goodsList[8].goodsMarketprice" value="">
                          <input type="hidden" name="goodsList[8].goodsPrice" value="">
                          <input type="hidden" name="goodsList[8].goodsImage" value="/upload/img/store/0/1458291260590.jpg_430x430q90.jpg">
                </div>
            </td>
            <td class="vatop tips"></td>
        </tr>
        <tr>
            <td colspan="2" class="required">楼层颜色: </td>
        </tr>
        <tr class="noborder">
             	<td>
	             	<select name="floorColor">
		             		<option value="pink">粉色</option>
		             		<option value="blue">蓝色</option>
		             		<option value="orange">橙色</option>
		             		<option value="red">红色</option>
		             		<option value="brown">棕色</option>
		             		<option value="green" selected="">绿色</option>
		             		<option value="purple">紫色</option>
		             		<option value="gray">浅色</option>
		             	</select>
             	</td>
             	<td class="vatop tips"> </td>
         </tr>
         <tr>
            <td colspan="2" class="required">是否显示: </td>
        </tr>
        <tr class="noborder">
             <td class="vatop rowform onoff"><label for="isShow1" class="cb-enable selected"><span>是</span></label>
                 <label for="isShow0" class="cb-disable "><span>否</span></label>
                 <input id="isShow1" name="isShow" value="1" type="radio" checked="true">
                 <input id="isShow0" name="isShow" value="0" type="radio"></td>
             
             <td class="vatop tips"></td>
        </tr>
        <tr>
            <td colspan="2" class="required">排序: </td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" name="sort" class="txt" value="1">
                </td>
            <td class="vatop tips">数字范围为1~255，数字越小越靠前</td>
        </tr>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn" onclick="document.floorForm.submit()"><span>提交</span></a></td>
        </tr>
        </tfoot>
    </table>
</form>
<div id="category_list_dialog" style="display:none;">
    <div class="dialog-handle">
        <h4 class="dialog-handle-title">楼层主题分类&gt;</h4>
        <p><span class="handle">
      <select name="gc_parent_id" id="gc_parent_id" class=" w200" onchange="get_goods_class();">
          <option value="0">-请选择-</option>
              <option value="0568b2fe256946ffa5b94bb5abb1adda">&nbsp;&nbsp;二手房</option>
                  <option value="30e374ab974947449a8c1861ae8a9a4a">&nbsp;&nbsp;&nbsp;&nbsp;客房电器</option>
                  <option value="f18a5d61baa7493fb660f13a8bc6e826">&nbsp;&nbsp;&nbsp;&nbsp;1212</option>
                  <option value="816f6e71d85f49fe9739a6a260ba0fa7">&nbsp;&nbsp;&nbsp;&nbsp;电视</option>
                  <option value="eb11fa0add384adb982c3f348be4f959">&nbsp;&nbsp;&nbsp;&nbsp;冰箱</option>
              <option value="eae1aa38c0c6451d8f9436e203880d78">&nbsp;&nbsp;租房</option>
                  <option value="36cfeecf4a524016b7122034a3b2b516">&nbsp;&nbsp;&nbsp;&nbsp;箱包</option>
                  <option value="3aef387727f64cc79494776ea595b0cc">&nbsp;&nbsp;&nbsp;&nbsp;男装</option>
                  <option value="c9c3137e75d94ef5b58fcd1892399d9a">&nbsp;&nbsp;&nbsp;&nbsp;鞋靴</option>
                  <option value="e29f56d378e3463a87cdfed62ee2e206">&nbsp;&nbsp;&nbsp;&nbsp;童装</option>
                  <option value="d579627f99ba47968e37a203875d7ad7">&nbsp;&nbsp;&nbsp;&nbsp;女装</option>
              <option value="8a2defb1ebdf4458ab76b9369611586c">&nbsp;&nbsp;手机 数码 电脑 家电</option>
                  <option value="0c52126b10e14c3e93c97ca73a4eb60f">&nbsp;&nbsp;&nbsp;&nbsp;手机</option>
                  <option value="0f2084d600d74d8ab1f3c7a5e049bbe1">&nbsp;&nbsp;&nbsp;&nbsp;电脑</option>
                  <option value="775e0aea66ba4c10bef2c0aa1a874a01">&nbsp;&nbsp;&nbsp;&nbsp;数码配件</option>
              <option value="be641713440a4788947c7234fa550a7b">&nbsp;&nbsp;生活服务</option>
                  <option value="341fce8405464937addb7d9e3d767f79">&nbsp;&nbsp;&nbsp;&nbsp;家政服务</option>
              <option value="c748d987f7f043b3a4aa13c180cf77c4">&nbsp;&nbsp;母婴用品 玩具图书</option>
                  <option value="49eca8d6bbe34a1c852b07fbd2d0dce5">&nbsp;&nbsp;&nbsp;&nbsp;塑料玩具</option>
                  <option value="5a63cb1ccbc94bac8e96bbcd313e475d">&nbsp;&nbsp;&nbsp;&nbsp;母婴用品</option>
                  <option value="903f8369f5ee4e848ac92f983aa59ee3">&nbsp;&nbsp;&nbsp;&nbsp;辅食</option>
                  <option value="b5882dcbb65d4b49a268a395740afe90">&nbsp;&nbsp;&nbsp;&nbsp;尿不湿</option>
                  <option value="e0ff263a84c74d7eaba5bb02084940f7">&nbsp;&nbsp;&nbsp;&nbsp;食品</option>
                  <option value="0d7f84e4be344a9da50335d42bbbf6de">&nbsp;&nbsp;&nbsp;&nbsp;玩具</option>
                  <option value="a33112c86d3f4ded9da98a0576e85002">&nbsp;&nbsp;&nbsp;&nbsp;图书</option>
              <option value="625bb2e038214198805db26596201210">&nbsp;&nbsp;酒类 生鲜 食品</option>
                  <option value="1baefbc7469846eea819a120c888d7cc">&nbsp;&nbsp;&nbsp;&nbsp;乳制品</option>
                  <option value="3e87314832644725812ebcb98db134f8">&nbsp;&nbsp;&nbsp;&nbsp;生鲜</option>
                  <option value="52481fc1ce5646f3a9336fca204596ff">&nbsp;&nbsp;&nbsp;&nbsp;龙虾</option>
                  <option value="6160c39bbc8d482091694b0b48118244">&nbsp;&nbsp;&nbsp;&nbsp;生鲜食品</option>
                  <option value="61b647b4c97e48a3bb82e61f738d3acd">&nbsp;&nbsp;&nbsp;&nbsp;果汁</option>
                  <option value="6c41104baa21437a839f9ad2cb8c5075">&nbsp;&nbsp;&nbsp;&nbsp;美食</option>
                  <option value="6d959b2b8421430888423c6d761bc354">&nbsp;&nbsp;&nbsp;&nbsp;地方特产</option>
                  <option value="c11b901fbf6e446dbcefcb53fca041e7">&nbsp;&nbsp;&nbsp;&nbsp;零食</option>
                  <option value="cdbcbad4787a4be5b82b555879a9bd6f">&nbsp;&nbsp;&nbsp;&nbsp;中外名酒</option>
                  <option value="d3d097458d7a4d4da5d8bc33b38eee43">&nbsp;&nbsp;&nbsp;&nbsp;红酒</option>
                  <option value="ed61755920654e2d85c8300e1a86a635">&nbsp;&nbsp;&nbsp;&nbsp;膨化食品</option>
                  <option value="fa12d866a45a4fa3b94024429743e57b">&nbsp;&nbsp;&nbsp;&nbsp;碳酸饮料</option>
              <option value="139eaf1f1e814a7fa93b903049c4771d">&nbsp;&nbsp;家居家纺</option>
                  <option value="281336527d524ba1bcc5177ccf8d79c0">&nbsp;&nbsp;&nbsp;&nbsp;床上用品四件套</option>
                  <option value="29203f19594642dfb001ea1d854fcb5c">&nbsp;&nbsp;&nbsp;&nbsp;遮阳窗帘</option>
                  <option value="327ef9823cdf47369697ba9b02a8305d">&nbsp;&nbsp;&nbsp;&nbsp;床罩</option>
                  <option value="40617af5faab402d8ee2afe4e4874b82">&nbsp;&nbsp;&nbsp;&nbsp;布艺软饰</option>
                  <option value="4f83d2e4ce1d4d79b37b13c3e6ebfd15">&nbsp;&nbsp;&nbsp;&nbsp;毛毯</option>
                  <option value="7ed2e0c7c04d4abb8e963b19b0c6bbbc">&nbsp;&nbsp;&nbsp;&nbsp;床上用品</option>
                  <option value="81f34e9c10cc4c4dbaba62670f636973">&nbsp;&nbsp;&nbsp;&nbsp;家居用品</option>
                  <option value="85944c625fc740b0ad09b891729797bc">&nbsp;&nbsp;&nbsp;&nbsp;沙发垫</option>
                  <option value="c1bdb8075b5746d9958652d87893ba31">&nbsp;&nbsp;&nbsp;&nbsp;墙纸</option>
                  <option value="d2d6cc36550347a5a11bb48be90fd4f4">&nbsp;&nbsp;&nbsp;&nbsp;壁纸</option>
                  <option value="dc0042ae3e684f58ae698249f5a44950">&nbsp;&nbsp;&nbsp;&nbsp;蚊帐</option>
                  <option value="f390d49eefb247b6bb6323dc21e98c43">&nbsp;&nbsp;&nbsp;&nbsp;冰丝垫</option>
              <option value="28ed715304e4437d962938964011ac95">&nbsp;&nbsp;美妆洗护</option>
                  <option value="223a924b07ad4dbd8797142afeb1a450">&nbsp;&nbsp;&nbsp;&nbsp;营养保健</option>
                  <option value="62a5ede1cca74b59b4357037eefd8835">&nbsp;&nbsp;&nbsp;&nbsp;美妆</option>
                  <option value="f0c1670a220a46a2a0ae5cf3bfad9a5f">&nbsp;&nbsp;&nbsp;&nbsp;个人护理</option>
              <option value="e1dd743764d04071971d2cc57e5f6483">&nbsp;&nbsp;家用电器</option>
                  <option value="cee9e37926c043d8aff6f9be1a16a23c">&nbsp;&nbsp;&nbsp;&nbsp;运动</option>
                  <option value="d8ee246147254922983d15720e0ce16a">&nbsp;&nbsp;&nbsp;&nbsp;乐器</option>
                  <option value="f8ab735d91874f30a1b17a08067fe4ba">&nbsp;&nbsp;&nbsp;&nbsp;户外健身</option>
              <option value="2848fbbb6ea84f6ba592f44e3f3d340c">&nbsp;&nbsp;珠宝，首饰</option>
                  <option value="2c18a72888ab48cca1f6c57f391fb001">&nbsp;&nbsp;&nbsp;&nbsp;黄金</option>
                  <option value="c5c900a924cb4a929151f4a52c1a47e3">&nbsp;&nbsp;&nbsp;&nbsp;玉器</option>
                  <option value="c74f0152eea2420c8edf1aa731816dca">&nbsp;&nbsp;&nbsp;&nbsp;钻石</option>
                  <option value="cc3b70832be8431db2d5a73c83566065">&nbsp;&nbsp;&nbsp;&nbsp;玛瑙</option>
      </select>
      </span> <span class="note">从分类下拉菜单中选择该板块要推荐的分类，选择父级分类将包含字分类。</span></p>
    </div>
    <div class="s-tips"><i></i>小提示：双击分类名称可删除不想显示的分类</div>
    <div class="category-list category-list-edit">
        <dl>
            <dd gc_id="36cfeecf4a524016b7122034a3b2b516" title="箱包" ondblclick="del_goods_class(&#39;36cfeecf4a524016b7122034a3b2b516&#39;);">
                <i onclick="del_goods_class(&#39;36cfeecf4a524016b7122034a3b2b516&#39;);"></i>箱包
            </dd>
            <dd gc_id="3aef387727f64cc79494776ea595b0cc" title="男装" ondblclick="del_goods_class(&#39;3aef387727f64cc79494776ea595b0cc&#39;);">
                <i onclick="del_goods_class(&#39;3aef387727f64cc79494776ea595b0cc&#39;);"></i>男装
            </dd>
            <dd gc_id="c9c3137e75d94ef5b58fcd1892399d9a" title="鞋靴" ondblclick="del_goods_class(&#39;c9c3137e75d94ef5b58fcd1892399d9a&#39;);">
                <i onclick="del_goods_class(&#39;c9c3137e75d94ef5b58fcd1892399d9a&#39;);"></i>鞋靴
            </dd>
            <dd gc_id="d579627f99ba47968e37a203875d7ad7" title="女装" ondblclick="del_goods_class(&#39;d579627f99ba47968e37a203875d7ad7&#39;);">
                <i onclick="del_goods_class(&#39;d579627f99ba47968e37a203875d7ad7&#39;);"></i>女装
            </dd>
            <dd gc_id="1712da292900481f8a2165ab1a784e09" title="青年服装" ondblclick="del_goods_class(&#39;1712da292900481f8a2165ab1a784e09&#39;);">
                <i onclick="del_goods_class(&#39;1712da292900481f8a2165ab1a784e09&#39;);"></i>青年服装
            </dd>
            <dd gc_id="4628617e3cee4b07b5e2d90daa09ddf7" title="钱包" ondblclick="del_goods_class(&#39;4628617e3cee4b07b5e2d90daa09ddf7&#39;);">
                <i onclick="del_goods_class(&#39;4628617e3cee4b07b5e2d90daa09ddf7&#39;);"></i>钱包
            </dd>
            <dd gc_id="6ed250e7f2774306a16d6d5fe2f4b8df" title="中老年服装" ondblclick="del_goods_class(&#39;6ed250e7f2774306a16d6d5fe2f4b8df&#39;);">
                <i onclick="del_goods_class(&#39;6ed250e7f2774306a16d6d5fe2f4b8df&#39;);"></i>中老年服装
            </dd>
            <dd gc_id="74fba86e5ced4c188b9933834bbc4d73" title="电脑包" ondblclick="del_goods_class(&#39;74fba86e5ced4c188b9933834bbc4d73&#39;);">
                <i onclick="del_goods_class(&#39;74fba86e5ced4c188b9933834bbc4d73&#39;);"></i>电脑包
            </dd>
            <dd gc_id="99d9b4e18b0b4123a1868723544ba3f8" title="双肩包" ondblclick="del_goods_class(&#39;99d9b4e18b0b4123a1868723544ba3f8&#39;);">
                <i onclick="del_goods_class(&#39;99d9b4e18b0b4123a1868723544ba3f8&#39;);"></i>双肩包
            </dd>
            <dd gc_id="dbe939dee686424fadbd4b9c9cac3e36" title="手提包" ondblclick="del_goods_class(&#39;dbe939dee686424fadbd4b9c9cac3e36&#39;);">
                <i onclick="del_goods_class(&#39;dbe939dee686424fadbd4b9c9cac3e36&#39;);"></i>手提包
            </dd>
            <dd gc_id="e012edc9f79f4c60a1d8291cc0c6bc24" title="手提包" ondblclick="del_goods_class(&#39;e012edc9f79f4c60a1d8291cc0c6bc24&#39;);">
                <i onclick="del_goods_class(&#39;e012edc9f79f4c60a1d8291cc0c6bc24&#39;);"></i>手提包
            </dd>
            <dd gc_id="e29f56d378e3463a87cdfed62ee2e206" title="童装" ondblclick="del_goods_class(&#39;e29f56d378e3463a87cdfed62ee2e206&#39;);">
                <i onclick="del_goods_class(&#39;e29f56d378e3463a87cdfed62ee2e206&#39;);"></i>童装
            </dd>
        </dl>
    </div>
   <center><a href="JavaScript:void(0);" onclick="update_category();" class="btn ml30"><span>确定</span></a></center>
    <script type="text/javascript">
        //分类相关
        function get_goods_class() {//查询子分类
            var gc_id = $("#gc_parent_id").val();
            $("#gcId").val(gc_id);
            if (gc_id != '0') {
                $.get(APP_BASE+'/goods/class/child?id='+gc_id+'&level=0', function(data) {
                    $.each(data, function(i, item) {
                        var temp='<dd gc_id="'+item.gcId+'" title="'+item.gcName+'" ondblclick="del_goods_class(\''+item.gcId+'\');">'+
                                '<i onclick="del_goods_class(\''+item.gcId+'\');"></i>'+item.gcName+
                                '</dd>';
                        var ddlist = $(".category-list dl").find("dd");
                        if(typeof($(ddlist).html())!="undefined"){
                    	    var flag = 0;
                        	$(ddlist).each(function(){
                            	if($(this).attr("gc_id")==item.gcId){
                            		flag=1;
                            	}
                            });
                        	if(flag==0){
                        		$(".category-list dl").append(temp);
                        	}
                         }else{
                        	$(".category-list dl").append(temp);
                       	 }
                    });
                });
            }
        }
        function del_goods_class(gc_id) {//删除已选分类
            var obj = $("dd[gc_id='"+gc_id+"']");
            obj.remove();
        }
        function update_category(){
            $("#floorClassData").empty();
            $(".category-list dl").find("dd").each(function(i){
                $("#floorClassData").append("<input type='hidden' name='goodsClassList["+i+"].gcId' value='"+$(this).attr("gc_id")+"'/>");
                $("#floorClassData").append("<input type='text' readonly='true' name='goodsClassList["+i+"].gcName' value='"+$(this).attr("title")+"' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/>");
            });
            DialogManager.close("category_list");
            initGoodsClass();
        }

        //选择分类后 初始化这个分类的图片 ，访问路径等
        function initGoodsClass(){
        	var gc_id = $("#gcId").val();
	        if (gc_id>0) {
	            $.get(APP_BASE+'/goods/class/getGoodsClass?gcId='+gc_id, function(data) {
	            	/* alert(data.gcpic); */
		            if(data){
		            	$("#floorClass").html(data.gcName);//显示标题名称
		            	$("#floorThemeImg").attr("src", 'http://www.leimingtech.com:99'+data.gcpic);//显示分类图片
		            	$("#floorImg").val(data.gcpic);//设置分类图片
	           			$("#floorName").val(data.gcName);//设置分类名称
	           			$("#subName").val(data.gcName);//设置副标题名称
		            }
	             });
            }
        }
    </script>
</div>
<div id="upload_floorTheme_dialog" style="display:none;">
    <table class="table tb-type2">
        <tbody>
        <tr>
            <td><ul>
                <li>请按照操作注释要求，上传设置楼层主题图片。</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_pic" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">楼层主题上传：</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><span class="type-file-box">
            <input type="text" name="textfield" id="textfield2" class="type-file-text">
            <input type="button" name="button" id="button1" value="" class="type-file-button">
            <input name="pic" id="pic1" type="file" class="type-file-file" size="30">
            </span></td>
            <td class="vatop tips">建议上传212×241像素GIF\JPG\PNG格式图片。</td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_txt" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">楼层主题链接</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <input class="txt" type="text" id="themeUrl">
            </td>
            <td class="vatop tips"></td>
        </tr>
        </tbody>
    </table>
    <center><a href="JavaScript:void(0);" onclick="themeImgCommit()" class="btn"><span>确定</span></a></center>
    <script type="text/javascript">
        $("#pic1").change(function(){
            $("#textfield2").val($(this).val());
        });
        function themeImgCommit(){
            $.ajaxFileUpload({
                //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
                url:'/leimingtech-admin/website/index/upload',
                secureuri:false,                       //是否启用安全提交,默认为false
                fileElementId:'pic1',           //文件选择框的id属性
                dataType:'json',                       //服务器返回的格式,可以是json或xml等
                success:function(data, status){        //服务器响应成功时的处理函数
                    if(data.success){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
                    	//设置显示图片
                        $("#floorThemeImg").attr("src", 'http://www.leimingtech.com:99'+data.result);
                    		//隐藏值
                       // var input = '<input type="hidden" name="floorImg" value="'+data.result+'"/>' +
                       //        '<input type="hidden" name="floorUrl" value="'+$("#themeUrl").val()+'"/>';
                       // $("#floorThemeImg").parent("td").append(input);

		            	$("#floorImg").val(data.result);//设置分类图片
		            	$("#floorUrl").val($("#themeUrl").val());
		            	//设置跳转路径
		            	//var input = '<input type="hidden" name="floorUrl" value="'+$("#themeUrl").val()+'"/>';

                        DialogManager.close("upload_floorTheme");
                    }
                },
                error:function(data, status, e){ //服务器响应失败时的处理函数
                    alert('图片上传失败，请重试！！');
                }
            });
        }
    </script>
</div>
<div id="upload_floorBanner_dialog" style="display:none;">
    <table class="table tb-type2">
        <tbody>
        <tr>
            <td><ul>
                <li>请按照操作注释要求，上传设置楼层导航图片。</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_pic" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">导航图片上传：</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><span class="type-file-box">
            <input type="text" name="textfield" id="textfield1" class="type-file-text">
            <input type="button" name="button" id="button1" value="" class="type-file-button">
            <input name="pic" id="pic" type="file" class="type-file-file" size="30">
            </span></td>
            <td class="vatop tips">建议上传210×40像素GIF\JPG\PNG格式图片。</td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_txt" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">导航图片链接</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <input class="txt" type="text" id="bannerUrl">
            </td>
            <td class="vatop tips"></td>
        </tr>
        </tbody>
    </table>
    <center><a href="JavaScript:void(0);" onclick="bannerImgCommit()" class="btn"><span>确定</span></a></center>
    <script type="text/javascript">
        $("#pic").change(function(){
            $("#textfield1").val($(this).val());
        });
        function bannerImgCommit(){
            $.ajaxFileUpload({
                //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
                url:'/leimingtech-admin/website/index/upload',
                secureuri:false,                       //是否启用安全提交,默认为false
                fileElementId:'pic',           //文件选择框的id属性
                dataType:'json',                       //服务器返回的格式,可以是json或xml等
                success:function(data, status){        //服务器响应成功时的处理函数
                    if(data.success){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
                        $("#floorBannerImg").attr("src", 'http://www.leimingtech.com:99'+data.result);
                        //var input = '<input type="hidden" name="bannerImg" value="'+data.result+'"/>' +
                       //         '<input type="hidden" name="bannerUrl" value="'+$("#bannerUrl").val()+'"/>';
                       // $("#floorBannerImg").parent("td").append(input);

                        $("#bannerImg").val(data.result);//设置分类图片
		            	$("#bannerUrl").val($("#bannerUrl").val());

                        DialogManager.close("upload_floorBanner");
                    }
                },
                error:function(data, status, e){ //服务器响应失败时的处理函数
                    alert('图片上传失败，请重试！！');
                }
            });
        }
    </script>
</div>
<div id="recommend_list_dialog" style="display:none;">
    <div id="recommend_input_list" style="display:none;"><!-- 推荐拖动排序 --></div>
    <dl>
        <dd>
            <h4 class="dialog-handle-title">请选择要展示的推荐商品</h4>
            <div class="s-tips"><i></i>小提示：单击查询出的商品选中，双击已选择的可以删除，最多9个，保存后生效。</div>

            <ul class="dialog-goodslist-s1 goods-list">
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;5d1fc175983d4ebe91f2cae75afd4995&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;5d1fc175983d4ebe91f2cae75afd4995&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="5d1fc175983d4ebe91f2cae75afd4995" title="欧时纳包包2016新款 手提包韩版时尚女士斜挎包春夏百搭休闲女包" src="./管理后台-楼层编辑_files/1458292894109.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=5d1fc175983d4ebe91f2cae75afd4995" target="_blank"> 欧时纳包包2016新款 手提包韩版时尚女士斜挎包春夏百搭休闲女包</a>
            		</div>
           		  	<input id="goodsId" value="5d1fc175983d4ebe91f2cae75afd4995" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="欧时纳包包2016新款 手提包韩版时尚女士斜挎包春夏百搭休闲女包" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458292894109.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;1de7c8c13609465990805ba0f57652c1&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;1de7c8c13609465990805ba0f57652c1&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="1de7c8c13609465990805ba0f57652c1" title="正品高端女款旅行箱万向轮行礼箱凯容牌PU皮萌萌小熊拉杆箱" src="./管理后台-楼层编辑_files/1458293966433.jpg_400x400.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=1de7c8c13609465990805ba0f57652c1" target="_blank"> 正品高端女款旅行箱万向轮行礼箱凯容牌PU皮萌萌小熊拉杆箱</a>
            		</div>
           		  	<input id="goodsId" value="1de7c8c13609465990805ba0f57652c1" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="正品高端女款旅行箱万向轮行礼箱凯容牌PU皮萌萌小熊拉杆箱" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458293966433.jpg_400x400.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;9f3a8bf0808248799f8ef57deb0bcb28&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;9f3a8bf0808248799f8ef57deb0bcb28&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="9f3a8bf0808248799f8ef57deb0bcb28" title="骆驼男装 2016春装男士夹克衫 短款外套大码青年简约薄款茄克立领" src="./管理后台-楼层编辑_files/1458291946677.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=9f3a8bf0808248799f8ef57deb0bcb28" target="_blank"> 骆驼男装 2016春装男士夹克衫 短款外套大码青年简约薄款茄克立领</a>
            		</div>
           		  	<input id="goodsId" value="9f3a8bf0808248799f8ef57deb0bcb28" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="骆驼男装 2016春装男士夹克衫 短款外套大码青年简约薄款茄克立领" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458291946677.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;fdcdee420a69434cbd21d615ed97b43b&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;fdcdee420a69434cbd21d615ed97b43b&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="fdcdee420a69434cbd21d615ed97b43b" title="春季白色商务休闲男士长袖衬衫韩版修身职业正装寸衫免烫工装衬衣" src="./管理后台-楼层编辑_files/1458292234477.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=fdcdee420a69434cbd21d615ed97b43b" target="_blank"> 春季白色商务休闲男士长袖衬衫韩版修身职业正装寸衫免烫工装衬衣</a>
            		</div>
           		  	<input id="goodsId" value="fdcdee420a69434cbd21d615ed97b43b" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="春季白色商务休闲男士长袖衬衫韩版修身职业正装寸衫免烫工装衬衣" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458292234477.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;78216c41029d4f41bfbca7ad5e57487e&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;78216c41029d4f41bfbca7ad5e57487e&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="78216c41029d4f41bfbca7ad5e57487e" title="韩版潮短靴休闲鞋真皮女高帮鞋平底女靴春秋拉链女鞋靴子B815" src="./管理后台-楼层编辑_files/1458294123763.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=78216c41029d4f41bfbca7ad5e57487e" target="_blank"> 韩版潮短靴休闲鞋真皮女高帮鞋平底女靴春秋拉链女鞋靴子B815</a>
            		</div>
           		  	<input id="goodsId" value="78216c41029d4f41bfbca7ad5e57487e" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="韩版潮短靴休闲鞋真皮女高帮鞋平底女靴春秋拉链女鞋靴子B815" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458294123763.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;d0e3e12758d34aa190daacc86271a8c6&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;d0e3e12758d34aa190daacc86271a8c6&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="d0e3e12758d34aa190daacc86271a8c6" title="春季男鞋子男士休闲鞋韩版潮鞋青年板鞋男时尚系带低帮布洛克皮鞋" src="./管理后台-楼层编辑_files/1458294717927.jpg_400x400.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=d0e3e12758d34aa190daacc86271a8c6" target="_blank"> 春季男鞋子男士休闲鞋韩版潮鞋青年板鞋男时尚系带低帮布洛克皮鞋</a>
            		</div>
           		  	<input id="goodsId" value="d0e3e12758d34aa190daacc86271a8c6" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="春季男鞋子男士休闲鞋韩版潮鞋青年板鞋男时尚系带低帮布洛克皮鞋" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458294717927.jpg_400x400.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;7a125d2b9ac24449beea87cc57352f31&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;7a125d2b9ac24449beea87cc57352f31&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="7a125d2b9ac24449beea87cc57352f31" title="2016春秋新款中长半身裙网纱裙高腰蓬蓬裙欧根纱半裙大摆伞裙中裙" src="./管理后台-楼层编辑_files/1458291777550.gif_400x400.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=7a125d2b9ac24449beea87cc57352f31" target="_blank"> 2016春秋新款中长半身裙网纱裙高腰蓬蓬裙欧根纱半裙大摆伞裙中裙</a>
            		</div>
           		  	<input id="goodsId" value="7a125d2b9ac24449beea87cc57352f31" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="2016春秋新款中长半身裙网纱裙高腰蓬蓬裙欧根纱半裙大摆伞裙中裙" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458291777550.gif_400x400.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;07b9989c2d4c41b18aed23b1ecdc6494&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;07b9989c2d4c41b18aed23b1ecdc6494&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="07b9989c2d4c41b18aed23b1ecdc6494" title="时尚棉麻套裙2016春装新款七分袖上衣半身长裙印花套装休闲两件套" src="./管理后台-楼层编辑_files/1458289058765.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=07b9989c2d4c41b18aed23b1ecdc6494" target="_blank"> 时尚棉麻套裙2016春装新款七分袖上衣半身长裙印花套装休闲两件套</a>
            		</div>
           		  	<input id="goodsId" value="07b9989c2d4c41b18aed23b1ecdc6494" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="时尚棉麻套裙2016春装新款七分袖上衣半身长裙印花套装休闲两件套" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458289058765.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            	<li>
         			<div ondblclick="del_recommend_goods(&#39;2c4c4a966bde41f9ba0f92d2e6baddeb&#39;);" class="goods-pic">
           				 <span class="ac-ico" onclick="del_recommend_goods(&#39;2c4c4a966bde41f9ba0f92d2e6baddeb&#39;);"></span>
          					 <span class="thumb size-72x72">
           							<img select_goods_id="2c4c4a966bde41f9ba0f92d2e6baddeb" title="2016春秋新款韩版女装针织衫中长款圆领开衫双排扣毛衣秋装外套女" src="./管理后台-楼层编辑_files/1458291260590.jpg_430x430q90.jpg" onload="javascript:DrawImage(this,72,72);" width="72" height="72">
           				 </span>
           			</div>
           			 <div class="goods-name">
           				 <a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=2c4c4a966bde41f9ba0f92d2e6baddeb" target="_blank"> 2016春秋新款韩版女装针织衫中长款圆领开衫双排扣毛衣秋装外套女</a>
            		</div>
           		  	<input id="goodsId" value="2c4c4a966bde41f9ba0f92d2e6baddeb" type="hidden">
		            <input id="goodsMarketprice" value="" type="hidden">
		            <input id="goodsName1" value="2016春秋新款韩版女装针织衫中长款圆领开衫双排扣毛衣秋装外套女" type="hidden">
		            <input id="goodsPrice" value="" type="hidden">'
		            <input id="goodPic" value="/upload/img/store/0/1458291260590.jpg_430x430q90.jpg" type="hidden">
            	 </li>
            </ul>

        </dd>
    </dl>
    <div id="add_recommend_list" style="display:none;"></div>
    <div class="dialog-show-box">
        <form name="queryListForm" id="queryListForm" method="post">
            <input type="hidden" id="div" name="div" value="#show_recommend_goods_list">


        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label>选择分类</label></th>
                <td class="dialog-select-bar" id="recommend_gcategory">
                    <select>
                        <option value="0">-请选择-</option>
                            <option value="0568b2fe256946ffa5b94bb5abb1adda">&nbsp;&nbsp;二手房</option>
                            <option value="eae1aa38c0c6451d8f9436e203880d78">&nbsp;&nbsp;租房</option>
                            <option value="8a2defb1ebdf4458ab76b9369611586c">&nbsp;&nbsp;手机 数码 电脑 家电</option>
                            <option value="be641713440a4788947c7234fa550a7b">&nbsp;&nbsp;生活服务</option>
                            <option value="c748d987f7f043b3a4aa13c180cf77c4">&nbsp;&nbsp;母婴用品 玩具图书</option>
                            <option value="625bb2e038214198805db26596201210">&nbsp;&nbsp;酒类 生鲜 食品</option>
                            <option value="139eaf1f1e814a7fa93b903049c4771d">&nbsp;&nbsp;家居家纺</option>
                            <option value="28ed715304e4437d962938964011ac95">&nbsp;&nbsp;美妆洗护</option>
                            <option value="e1dd743764d04071971d2cc57e5f6483">&nbsp;&nbsp;家用电器</option>
                            <option value="2848fbbb6ea84f6ba592f44e3f3d340c">&nbsp;&nbsp;珠宝，首饰</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="recommend_goods_name">商品名称</label></th>
                <td><input type="text" value="" name="recommend_goods_name" id="recommend_goods_name" class="txt">
                    <a href="JavaScript:void(0);" onclick="get_recommend_goods();" class="btn-search " title="查询"></a>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="show_recommend_goods_list" class="show-recommend-goods-list"></div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <center><a href="JavaScript:void(0);" onclick="update_recommend();" class="btn"><span>确定</span></a></center>
    <script type="text/javascript">
        gcategoryInit("recommend_gcategory");
        $("#recommend_list_form dl dd ul").sortable({ items: 'li' });
        function get_recommend_goods() {//查询商品
            var gc_id = 0;
            $('#recommend_gcategory > select').each(function() {
                if ($(this).val()!='0') gc_id = $(this).val();
            });
            var goods_name = $.trim($('#recommend_goods_name').val());
            if (gc_id!='0' || goods_name!='') {
                var div = '#show_recommend_goods_list';
               /*  $("#gcId").val(gc_id);
                $("#goodsName").val(goods_name) */
                $.ajax({
                    url:"/leimingtech-admin/goods/goods/list",//默认加载list 页面
                    data:{div:div,gcId:gc_id,goodsName:goods_name,goodsShow:"1",goodsState:"30"},
                    error:function(){frameControl.lhDgFalInfo("通讯失败!");},
                    dataType:'html',
                    type: "POST",
                    contentType:"application/x-www-form-urlencoded; charset=utf-8",
                    success: function(data){
                        $(div).empty();
                        $(div).html(data);
                        $(div).hide();
                        $(div).fadeIn(300);
                    }
                });
            }
        }
        function select_recommend_goods(goods_id) {//商品选择
            var id = 'recommend_show';
            var goods_max = 9;//商品数
            var obj = $("dl");
            if(obj.find("img[select_goods_id='"+goods_id+"']").size()>0) return;//避免重复
            if(obj.find("img[select_goods_id]").size()>=goods_max) return;
            var goods = $("#show_recommend_goods_list img[goods_id='"+goods_id+"']");
            var text_append = '';
            var goods_pic = goods.attr("src");
            var goods_name = goods.attr("title");
            var goods_price = goods.attr("goods_price");
            var market_price = goods.attr("market_price");
            text_append += '<div ondblclick="del_recommend_goods('+"'"+goods_id+"'"+');" class="goods-pic">';
            text_append += '<span class="ac-ico" onclick="del_recommend_goods('+goods_id+');"></span>';
            text_append += '<span class="thumb size-72x72">';
            text_append += '<i></i>';
            text_append += '<img select_goods_id="'+goods_id+'" title="'+goods_name+'" src="'+goods_pic+'" onload="javascript:DrawImage(this,72,72);" />';
            text_append += '</span></div>';
            text_append += '<div class="goods-name">';
            text_append += '<a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id='+goods_id+'" target="_blank">';
            text_append += goods_name+'</a>';
            text_append += '</div>';
            text_append += '<input id="goodsId" value="'+goods_id+'" type="hidden">';
            text_append += '<input id="goodsMarketprice" value="'+market_price+'" type="hidden">';
            text_append += '<input id="goodsName1" value="'+goods_name+'" type="hidden">';
            text_append += '<input id="goodsPrice" value="'+goods_price+'" type="hidden">';
            text_append += '<input id="goodPic" value="'+goods_pic.replace('http://www.leimingtech.com:99',"")+'" type="hidden">';
            obj.find("ul").append('<li id="select_recommend_'+id+'_goods_'+goods_id+'">'+text_append+'</li>');
        }
        function del_recommend_goods(goods_id) {//删除已选商品
            var id = 'recommend_show';
            var obj = $("dl");
            obj.find("img[select_goods_id='"+goods_id+"']").parent().parent().parent().remove();
        }
        function update_recommend(){
        	$("#floorGoodsData").empty();
            $("dl>dd>ul>li").each(function(i){
                $("#floorGoodsData").append("<input type='hidden' name='goodsList["+i+"].goodsId' value='"+$(this).find("#goodsId").val()+"'/>");
                $("#floorGoodsData").append("<input type='hidden' name='goodsList["+i+"].goodsName' value='"+$(this).find("#goodsName1").val()+"'/>");
                $("#floorGoodsData").append("<input type='hidden' name='goodsList["+i+"].goodsMarketprice' value='"+$(this).find("#goodsMarketprice").val()+"'/>");
                $("#floorGoodsData").append("<input type='hidden' name='goodsList["+i+"].goodsPrice' value='"+$(this).find("#goodsPrice").val()+"'/>");
                $("#floorGoodsData").append("<input type='hidden' name='goodsList["+i+"].goodsImage' value='"+$(this).find("#goodPic").val()+"'/>");
            });
            DialogManager.close("recommend_list");
        }
    </script>
</div>

</div>

</body>
</html>