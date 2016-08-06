<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dialog/dialog.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/dialog/dialog.js" id="dialog_js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js"></script>
	
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
	    function show_dialog(id,title) {//å¼¹åºæ¡
	        if(DialogManager.show(id)) return;
	        var d = DialogManager.create(id);//ä¸å­å¨æ¶åå§å(æ§è¡ä¸æ¬¡)
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
        <h3>楼层管理</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/floor"><span>楼层管理</span></a></li>
            <li><a href="JavaScript:void(0);" class="current"><span>楼层新增</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="store_class_form" name="floorForm" method="post" action="${pageContext.request.contextPath}/floor/save">
    <table class="table tb-type2">
        <tbody>
        <input type="hidden" name="gcId" id="gcId">
       <input type="hidden" name="type" value="mobile_list">
        <tr>
            <td colspan="2" class="required"><label for="sort">æ¥¼å±ä¸»é¢åç±»ï¼</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform">
                <input type="button" value="ç¼è¾" onclick="show_dialog(&#39;category_list&#39;,&#39;æ¥¼å±ä¸»é¢åç±»&#39;)">
                <div id="floorClassData"></div>
            </td>
            <td class="vatop tips"></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label for="sort">æ¥¼å±ä¸»é¢å¾çï¼</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
        	<input type="hidden" name="floorImg" id="floorImg">
        	<input type="hidden" name="floorUrl" id="floorUrl">
            <td class="vatop rowform">
                <img id="floorThemeImg" width="212px" src="./ç®¡çåå°-æ¥¼å±æ°å¢_files/nopic.png">
                <input type="button" value="ç¼è¾" onclick="show_dialog(&#39;upload_floorTheme&#39;,&#39;æ¥¼å±ä¸»é¢å¾ç&#39;)"></td>
            <td class="vatop tips">è¯·ä¸ä¼ 212Ã241åç´ GIF\JPG\PNGæ ¼å¼å¾ç</td>
        </tr>
        <tr class="noborder">
            <td colspan="2" class="required"><label>æ¥¼å±å¯¼èªå¾çï¼</label></td>
        </tr>
        <tr class="noborder">
        	<input type="hidden" name="bannerImg" id="bannerImg">
        	<input type="hidden" name="bannerUrl" id="bannerUrl">
            <td class="vatop rowform">
                <img id="floorBannerImg" width="210px" src="./ç®¡çåå°-æ¥¼å±æ°å¢_files/noslide.png">
                <input type="button" value="ç¼è¾" onclick="show_dialog(&#39;upload_floorBanner&#39;,&#39;æ¥¼å±å¯¼èªå¾ç&#39;);">
            </td>
            <td class="vatop tips">è¯·ä¸ä¼ 210Ã40åç´ GIF\JPG\PNGæ ¼å¼å¾ç</td>
        </tr>

        <tr>
            <td colspan="2" class="required"><label for="sort">æ¥¼å±ä¸»é¢åç§°ï¼</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" class="txt" name="floorName" id="floorName"></td>
            <td class="vatop tips"></td>
        </tr>

        <tr>
            <td colspan="2" class="required"><label for="sort">æ¥¼å±å¯åç§°ï¼</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" class="txt" name="subName" id="subName"></td>
            <td class="vatop tips"></td>
        </tr>

        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label for="sort">æ¥¼å±åååè¡¨ï¼</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform">
                <input type="button" value="ç¼è¾" onclick="show_dialog(&#39;recommend_list&#39;,&#39;æ¥¼å±åååè¡¨&#39;)">
                <div id="floorGoodsData"></div>
            </td>
            <td class="vatop tips"></td>
        </tr>
        <tr>
            <td colspan="2" class="required">æ¥¼å±é¢è²: </td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
             	<td>
	             	<select name="floorColor">
	             		<!-- <option value="">è¯·éæ©</option> -->
	             		<option value="gray">æµè²</option>
	             		<option value="pink">ç²è²</option>
	             		<option value="blue">èè²</option>
	             		<option value="orange">æ©è²</option>
	             		<option value="red">çº¢è²</option>
	             		<option value="brown">æ£è²</option>
	             		<option value="green">ç»¿è²</option>
	             		<option value="purple">ç´«è²</option>
	             	</select>
             	</td>
             	<td class="vatop tips"> </td>
         </tr>
         <tr style="background: rgb(251, 251, 251);">
            <td colspan="2" class="required">æ¯å¦æ¾ç¤º: </td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform onoff"><label for="isShow1" class="cb-enable selected"><span>æ¯</span></label>
                <label for="isShow0" class="cb-disable"><span>å¦</span></label>
                <input id="isShow1" name="isShow" value="1" type="radio" checked="true">
                <input id="isShow0" name="isShow" value="0" type="radio"></td>
            
            <td class="vatop tips"></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required">æåº: </td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" name="sort" class="txt" value="0">
            </td>
            <td class="vatop tips">æ°å­èå´ä¸º1~255ï¼æ°å­è¶å°è¶é å</td>
        </tr>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn" onclick="document.floorForm.submit()"><span>æäº¤</span></a></td>
        </tr>
        </tfoot>
    </table>
</form>
<div id="category_list_dialog" style="display:none;">
    <div class="dialog-handle">
        <h4 class="dialog-handle-title">æ¥¼å±ä¸»é¢åç±»&gt;</h4>
        <p><span class="handle">
      <select name="gc_parent_id" id="gc_parent_id" class=" w200" onchange="get_goods_class();">
          <option value="0">-è¯·éæ©-</option>
              <option value="0568b2fe256946ffa5b94bb5abb1adda">&nbsp;&nbsp;äºææ¿</option>
                  <option value="30e374ab974947449a8c1861ae8a9a4a">&nbsp;&nbsp;&nbsp;&nbsp;å®¢æ¿çµå¨</option>
                  <option value="f18a5d61baa7493fb660f13a8bc6e826">&nbsp;&nbsp;&nbsp;&nbsp;1212</option>
                  <option value="816f6e71d85f49fe9739a6a260ba0fa7">&nbsp;&nbsp;&nbsp;&nbsp;çµè§</option>
                  <option value="eb11fa0add384adb982c3f348be4f959">&nbsp;&nbsp;&nbsp;&nbsp;å°ç®±</option>
              <option value="eae1aa38c0c6451d8f9436e203880d78">&nbsp;&nbsp;ç§æ¿</option>
                  <option value="36cfeecf4a524016b7122034a3b2b516">&nbsp;&nbsp;&nbsp;&nbsp;ç®±å</option>
                  <option value="3aef387727f64cc79494776ea595b0cc">&nbsp;&nbsp;&nbsp;&nbsp;ç·è£</option>
                  <option value="c9c3137e75d94ef5b58fcd1892399d9a">&nbsp;&nbsp;&nbsp;&nbsp;éé´</option>
                  <option value="e29f56d378e3463a87cdfed62ee2e206">&nbsp;&nbsp;&nbsp;&nbsp;ç«¥è£</option>
                  <option value="d579627f99ba47968e37a203875d7ad7">&nbsp;&nbsp;&nbsp;&nbsp;å¥³è£</option>
              <option value="8a2defb1ebdf4458ab76b9369611586c">&nbsp;&nbsp;ææº æ°ç  çµè å®¶çµ</option>
                  <option value="0c52126b10e14c3e93c97ca73a4eb60f">&nbsp;&nbsp;&nbsp;&nbsp;ææº</option>
                  <option value="0f2084d600d74d8ab1f3c7a5e049bbe1">&nbsp;&nbsp;&nbsp;&nbsp;çµè</option>
                  <option value="775e0aea66ba4c10bef2c0aa1a874a01">&nbsp;&nbsp;&nbsp;&nbsp;æ°ç éä»¶</option>
              <option value="be641713440a4788947c7234fa550a7b">&nbsp;&nbsp;çæ´»æå¡</option>
                  <option value="341fce8405464937addb7d9e3d767f79">&nbsp;&nbsp;&nbsp;&nbsp;å®¶æ¿æå¡</option>
              <option value="c748d987f7f043b3a4aa13c180cf77c4">&nbsp;&nbsp;æ¯å©´ç¨å ç©å·å¾ä¹¦</option>
                  <option value="49eca8d6bbe34a1c852b07fbd2d0dce5">&nbsp;&nbsp;&nbsp;&nbsp;å¡æç©å·</option>
                  <option value="5a63cb1ccbc94bac8e96bbcd313e475d">&nbsp;&nbsp;&nbsp;&nbsp;æ¯å©´ç¨å</option>
                  <option value="903f8369f5ee4e848ac92f983aa59ee3">&nbsp;&nbsp;&nbsp;&nbsp;è¾é£</option>
                  <option value="b5882dcbb65d4b49a268a395740afe90">&nbsp;&nbsp;&nbsp;&nbsp;å°¿ä¸æ¹¿</option>
                  <option value="e0ff263a84c74d7eaba5bb02084940f7">&nbsp;&nbsp;&nbsp;&nbsp;é£å</option>
                  <option value="0d7f84e4be344a9da50335d42bbbf6de">&nbsp;&nbsp;&nbsp;&nbsp;ç©å·</option>
                  <option value="a33112c86d3f4ded9da98a0576e85002">&nbsp;&nbsp;&nbsp;&nbsp;å¾ä¹¦</option>
              <option value="625bb2e038214198805db26596201210">&nbsp;&nbsp;éç±» çé² é£å</option>
                  <option value="1baefbc7469846eea819a120c888d7cc">&nbsp;&nbsp;&nbsp;&nbsp;ä¹³å¶å</option>
                  <option value="3e87314832644725812ebcb98db134f8">&nbsp;&nbsp;&nbsp;&nbsp;çé²</option>
                  <option value="52481fc1ce5646f3a9336fca204596ff">&nbsp;&nbsp;&nbsp;&nbsp;é¾è¾</option>
                  <option value="6160c39bbc8d482091694b0b48118244">&nbsp;&nbsp;&nbsp;&nbsp;çé²é£å</option>
                  <option value="61b647b4c97e48a3bb82e61f738d3acd">&nbsp;&nbsp;&nbsp;&nbsp;ææ±</option>
                  <option value="6c41104baa21437a839f9ad2cb8c5075">&nbsp;&nbsp;&nbsp;&nbsp;ç¾é£</option>
                  <option value="6d959b2b8421430888423c6d761bc354">&nbsp;&nbsp;&nbsp;&nbsp;å°æ¹ç¹äº§</option>
                  <option value="c11b901fbf6e446dbcefcb53fca041e7">&nbsp;&nbsp;&nbsp;&nbsp;é¶é£</option>
                  <option value="cdbcbad4787a4be5b82b555879a9bd6f">&nbsp;&nbsp;&nbsp;&nbsp;ä¸­å¤åé</option>
                  <option value="d3d097458d7a4d4da5d8bc33b38eee43">&nbsp;&nbsp;&nbsp;&nbsp;çº¢é</option>
                  <option value="ed61755920654e2d85c8300e1a86a635">&nbsp;&nbsp;&nbsp;&nbsp;è¨åé£å</option>
                  <option value="fa12d866a45a4fa3b94024429743e57b">&nbsp;&nbsp;&nbsp;&nbsp;ç¢³é¸é¥®æ</option>
              <option value="139eaf1f1e814a7fa93b903049c4771d">&nbsp;&nbsp;å®¶å±å®¶çºº</option>
                  <option value="281336527d524ba1bcc5177ccf8d79c0">&nbsp;&nbsp;&nbsp;&nbsp;åºä¸ç¨ååä»¶å¥</option>
                  <option value="29203f19594642dfb001ea1d854fcb5c">&nbsp;&nbsp;&nbsp;&nbsp;é®é³çªå¸</option>
                  <option value="327ef9823cdf47369697ba9b02a8305d">&nbsp;&nbsp;&nbsp;&nbsp;åºç½©</option>
                  <option value="40617af5faab402d8ee2afe4e4874b82">&nbsp;&nbsp;&nbsp;&nbsp;å¸èºè½¯é¥°</option>
                  <option value="4f83d2e4ce1d4d79b37b13c3e6ebfd15">&nbsp;&nbsp;&nbsp;&nbsp;æ¯æ¯¯</option>
                  <option value="7ed2e0c7c04d4abb8e963b19b0c6bbbc">&nbsp;&nbsp;&nbsp;&nbsp;åºä¸ç¨å</option>
                  <option value="81f34e9c10cc4c4dbaba62670f636973">&nbsp;&nbsp;&nbsp;&nbsp;å®¶å±ç¨å</option>
                  <option value="85944c625fc740b0ad09b891729797bc">&nbsp;&nbsp;&nbsp;&nbsp;æ²åå«</option>
                  <option value="c1bdb8075b5746d9958652d87893ba31">&nbsp;&nbsp;&nbsp;&nbsp;å¢çº¸</option>
                  <option value="d2d6cc36550347a5a11bb48be90fd4f4">&nbsp;&nbsp;&nbsp;&nbsp;å£çº¸</option>
                  <option value="dc0042ae3e684f58ae698249f5a44950">&nbsp;&nbsp;&nbsp;&nbsp;èå¸</option>
                  <option value="f390d49eefb247b6bb6323dc21e98c43">&nbsp;&nbsp;&nbsp;&nbsp;å°ä¸å«</option>
              <option value="28ed715304e4437d962938964011ac95">&nbsp;&nbsp;ç¾å¦æ´æ¤</option>
                  <option value="223a924b07ad4dbd8797142afeb1a450">&nbsp;&nbsp;&nbsp;&nbsp;è¥å»ä¿å¥</option>
                  <option value="62a5ede1cca74b59b4357037eefd8835">&nbsp;&nbsp;&nbsp;&nbsp;ç¾å¦</option>
                  <option value="f0c1670a220a46a2a0ae5cf3bfad9a5f">&nbsp;&nbsp;&nbsp;&nbsp;ä¸ªäººæ¤ç</option>
              <option value="e1dd743764d04071971d2cc57e5f6483">&nbsp;&nbsp;å®¶ç¨çµå¨</option>
                  <option value="cee9e37926c043d8aff6f9be1a16a23c">&nbsp;&nbsp;&nbsp;&nbsp;è¿å¨</option>
                  <option value="d8ee246147254922983d15720e0ce16a">&nbsp;&nbsp;&nbsp;&nbsp;ä¹å¨</option>
                  <option value="f8ab735d91874f30a1b17a08067fe4ba">&nbsp;&nbsp;&nbsp;&nbsp;æ·å¤å¥èº«</option>
              <option value="2848fbbb6ea84f6ba592f44e3f3d340c">&nbsp;&nbsp;ç å®ï¼é¦é¥°</option>
                  <option value="2c18a72888ab48cca1f6c57f391fb001">&nbsp;&nbsp;&nbsp;&nbsp;é»é</option>
                  <option value="c5c900a924cb4a929151f4a52c1a47e3">&nbsp;&nbsp;&nbsp;&nbsp;çå¨</option>
                  <option value="c74f0152eea2420c8edf1aa731816dca">&nbsp;&nbsp;&nbsp;&nbsp;é»ç³</option>
                  <option value="cc3b70832be8431db2d5a73c83566065">&nbsp;&nbsp;&nbsp;&nbsp;çç</option>
      </select>
      </span> <span class="note">ä»åç±»ä¸æèåä¸­éæ©è¯¥æ¿åè¦æ¨èçåç±»ï¼éæ©ç¶çº§åç±»å°åå«å­åç±»ã</span></p>
    </div>
    <div class="s-tips"><i></i>å°æç¤ºï¼åå»åç±»åç§°å¯å é¤ä¸æ³æ¾ç¤ºçåç±»</div>
    <div class="category-list category-list-edit">
        <dl>
        </dl>
    </div>
    <center><a href="JavaScript:void(0);" onclick="update_category();" class="btn ml30"><span>ç¡®å®</span></a></center>
    <script type="text/javascript">
        //åç±»ç¸å³
        function get_goods_class() {//æ¥è¯¢å­åç±»
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
        function del_goods_class(gc_id) {//å é¤å·²éåç±»
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

        //éæ©åç±»å åå§åè¿ä¸ªåç±»çå¾ç ï¼è®¿é®è·¯å¾ç­
        function initGoodsClass(){
        	var gc_id = $("#gcId").val();
	        if (gc_id>0) {
	            $.get(APP_BASE+'/goods/class/getGoodsClass?gcId='+gc_id, function(data) {
	            	/* alert(data.gcpic); */
		            if(data){
		            	$("#floorClass").html(data.gcName);//æ¾ç¤ºæ é¢åç§°
		            	$("#floorThemeImg").attr("src", 'http://www.leimingtech.com:99'+data.gcpic);//æ¾ç¤ºåç±»å¾ç
		            	$("#floorImg").val(data.gcpic);//è®¾ç½®åç±»å¾ç
	           			$("#floorName").val(data.gcName);//è®¾ç½®åç±»åç§°
	           			$("#subName").val(data.gcName);//è®¾ç½®å¯æ é¢åç§°
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
                <li>è¯·æç§æä½æ³¨éè¦æ±ï¼ä¸ä¼ è®¾ç½®æ¥¼å±ä¸»é¢å¾çã</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_pic" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">æ¥¼å±ä¸»é¢ä¸ä¼ ï¼</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><span class="type-file-box">
            <input type="text" name="textfield" id="textfield2" class="type-file-text">
            <input type="button" name="button" id="button1" value="" class="type-file-button">
            <input name="pic" id="pic1" type="file" class="type-file-file" size="30">
            </span></td>
            <td class="vatop tips">å»ºè®®ä¸ä¼ 212Ã241åç´ GIF\JPG\PNGæ ¼å¼å¾çã</td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_txt" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">æ¥¼å±ä¸»é¢é¾æ¥</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <input class="txt" type="text" id="themeUrl">
            </td>
            <td class="vatop tips"></td>
        </tr>
        </tbody>
    </table>
    <center><a href="JavaScript:void(0);" onclick="themeImgCommit()" class="btn"><span>ç¡®å®</span></a></center>
    <script type="text/javascript">
        $("#pic1").change(function(){
            $("#textfield2").val($(this).val());
        });
        function themeImgCommit(){
            $.ajaxFileUpload({
                //å¤çæä»¶ä¸ä¼ æä½çæå¡å¨ç«¯å°å(å¯ä»¥ä¼ åæ°,å·²äº²æµå¯ç¨)
                url:'/leimingtech-admin/website/index/upload',
                secureuri:false,                       //æ¯å¦å¯ç¨å®å¨æäº¤,é»è®¤ä¸ºfalse
                fileElementId:'pic1',           //æä»¶éæ©æ¡çidå±æ§
                dataType:'json',                       //æå¡å¨è¿åçæ ¼å¼,å¯ä»¥æ¯jsonæxmlç­
                success:function(data, status){        //æå¡å¨ååºæåæ¶çå¤çå½æ°
                    if(data.success){     //0è¡¨ç¤ºä¸ä¼ æå(åè·ä¸ä¼ åçæä»¶è·¯å¾),1è¡¨ç¤ºå¤±è´¥(åè·å¤±è´¥æè¿°)
                    	//è®¾ç½®æ¾ç¤ºå¾ç
                        $("#floorThemeImg").attr("src", 'http://www.leimingtech.com:99'+data.result);
                    		//éèå¼
                       // var input = '<input type="hidden" name="floorImg" value="'+data.result+'"/>' +
                       //        '<input type="hidden" name="floorUrl" value="'+$("#themeUrl").val()+'"/>';
                       // $("#floorThemeImg").parent("td").append(input);

		            	$("#floorImg").val(data.result);//è®¾ç½®åç±»å¾ç
		            	$("#floorUrl").val($("#themeUrl").val());
		            	//è®¾ç½®è·³è½¬è·¯å¾
		            	//var input = '<input type="hidden" name="floorUrl" value="'+$("#themeUrl").val()+'"/>';

                        DialogManager.close("upload_floorTheme");
                    }
                },
                error:function(data, status, e){ //æå¡å¨ååºå¤±è´¥æ¶çå¤çå½æ°
                    alert('å¾çä¸ä¼ å¤±è´¥ï¼è¯·éè¯ï¼ï¼');
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
                <li>è¯·æç§æä½æ³¨éè¦æ±ï¼ä¸ä¼ è®¾ç½®æ¥¼å±å¯¼èªå¾çã</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_pic" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">å¯¼èªå¾çä¸ä¼ ï¼</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><span class="type-file-box">
            <input type="text" name="textfield" id="textfield1" class="type-file-text">
            <input type="button" name="button" id="button1" value="" class="type-file-button">
            <input name="pic" id="pic" type="file" class="type-file-file" size="30">
            </span></td>
            <td class="vatop tips">å»ºè®®ä¸ä¼ 210Ã40åç´ GIF\JPG\PNGæ ¼å¼å¾çã</td>
        </tr>
        </tbody>
    </table>
    <table id="upload_tit_type_txt" class="table tb-type2">
        <tbody>
        <tr>
            <td colspan="2" class="required">å¯¼èªå¾çé¾æ¥</td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <input class="txt" type="text" id="bannerUrl">
            </td>
            <td class="vatop tips"></td>
        </tr>
        </tbody>
    </table>
    <center><a href="JavaScript:void(0);" onclick="bannerImgCommit()" class="btn"><span>ç¡®å®</span></a></center>
    <script type="text/javascript">
        $("#pic").change(function(){
            $("#textfield1").val($(this).val());
        });
        function bannerImgCommit(){
            $.ajaxFileUpload({
                //å¤çæä»¶ä¸ä¼ æä½çæå¡å¨ç«¯å°å(å¯ä»¥ä¼ åæ°,å·²äº²æµå¯ç¨)
                url:'/leimingtech-admin/website/index/upload',
                secureuri:false,                       //æ¯å¦å¯ç¨å®å¨æäº¤,é»è®¤ä¸ºfalse
                fileElementId:'pic',           //æä»¶éæ©æ¡çidå±æ§
                dataType:'json',                       //æå¡å¨è¿åçæ ¼å¼,å¯ä»¥æ¯jsonæxmlç­
                success:function(data, status){        //æå¡å¨ååºæåæ¶çå¤çå½æ°
                    if(data.success){     //0è¡¨ç¤ºä¸ä¼ æå(åè·ä¸ä¼ åçæä»¶è·¯å¾),1è¡¨ç¤ºå¤±è´¥(åè·å¤±è´¥æè¿°)
                        $("#floorBannerImg").attr("src", 'http://www.leimingtech.com:99'+data.result);

                        //var input = '<input type="hidden" name="bannerImg" value="'+data.result+'"/>' +
                        //        '<input type="hidden" name="bannerUrl" value="'+$("#bannerUrl").val()+'"/>';
                        //$("#floorBannerImg").parent("td").append(input);

                        $("#bannerImg").val(data.result);//è®¾ç½®åç±»å¾ç
		            	$("#bannerUrl").val($("#bannerUrl").val());

                        DialogManager.close("upload_floorBanner");
                    }
                },
                error:function(data, status, e){ //æå¡å¨ååºå¤±è´¥æ¶çå¤çå½æ°
                    alert('å¾çä¸ä¼ å¤±è´¥ï¼è¯·éè¯ï¼ï¼');
                }
            });
        }
    </script>
</div>
<div id="recommend_list_dialog" style="display:none;">
    <div id="recommend_input_list" style="display:none;"><!-- æ¨èæå¨æåº --></div>
    <dl>
        <dd>
            <h4 class="dialog-handle-title">è¯·éæ©è¦å±ç¤ºçæ¨èåå</h4>
            <div class="s-tips"><i></i>å°æç¤ºï¼åå»æ¥è¯¢åºçååéä¸­ï¼åå»å·²éæ©çå¯ä»¥å é¤ï¼æå¤9ä¸ªï¼ä¿å­åçæã</div>
            <ul class="dialog-goodslist-s1 goods-list">
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
                <th><label>éæ©åç±»</label></th>
                <td class="dialog-select-bar" id="recommend_gcategory">
                    <select>
                        <option value="0">-è¯·éæ©-</option>
                            <option value="0568b2fe256946ffa5b94bb5abb1adda">&nbsp;&nbsp;äºææ¿</option>
                            <option value="eae1aa38c0c6451d8f9436e203880d78">&nbsp;&nbsp;ç§æ¿</option>
                            <option value="8a2defb1ebdf4458ab76b9369611586c">&nbsp;&nbsp;ææº æ°ç  çµè å®¶çµ</option>
                            <option value="be641713440a4788947c7234fa550a7b">&nbsp;&nbsp;çæ´»æå¡</option>
                            <option value="c748d987f7f043b3a4aa13c180cf77c4">&nbsp;&nbsp;æ¯å©´ç¨å ç©å·å¾ä¹¦</option>
                            <option value="625bb2e038214198805db26596201210">&nbsp;&nbsp;éç±» çé² é£å</option>
                            <option value="139eaf1f1e814a7fa93b903049c4771d">&nbsp;&nbsp;å®¶å±å®¶çºº</option>
                            <option value="28ed715304e4437d962938964011ac95">&nbsp;&nbsp;ç¾å¦æ´æ¤</option>
                            <option value="e1dd743764d04071971d2cc57e5f6483">&nbsp;&nbsp;å®¶ç¨çµå¨</option>
                            <option value="2848fbbb6ea84f6ba592f44e3f3d340c">&nbsp;&nbsp;ç å®ï¼é¦é¥°</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="recommend_goods_name">åååç§°</label></th>
                <td><input type="text" value="" name="recommend_goods_name" id="recommend_goods_name" class="txt">
                    <a href="JavaScript:void(0);" onclick="get_recommend_goods();" class="btn-search " title="æ¥è¯¢"></a>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="show_recommend_goods_list" class="show-recommend-goods-list"></div>
         </form>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <center><a href="JavaScript:void(0);" onclick="update_recommend();" class="btn"><span>ç¡®å®</span></a></center>
    <script type="text/javascript">
        gcategoryInit("recommend_gcategory");
        $("#recommend_list_form dl dd ul").sortable({ items: 'li' });
        function get_recommend_goods() {//æ¥è¯¢åå
            var gc_id = 0;
            $('#recommend_gcategory > select').each(function() {
                if ($(this).val()!='0') gc_id = $(this).val();
            });
            var goods_name = $.trim($('#recommend_goods_name').val());
            if (gc_id!='0' || goods_name!='') {
                var div = '#show_recommend_goods_list';
                /* $("#gcId").val(gc_id);
                $("#goodsName").val(goods_name) */
                $.ajax({
                    url:"/leimingtech-admin/goods/goods/list",//é»è®¤å è½½list é¡µé¢
                    data:{div:div,gcId:gc_id,goodsName:goods_name,goodsShow:"1",goodsState:"30"},
                    error:function(){frameControl.lhDgFalInfo("éè®¯å¤±è´¥!");},
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
        function select_recommend_goods(goods_id) {//ååéæ©
            var id = 'recommend_show';
            var goods_max = 9;//ååæ°
            var obj = $("dl");
            if(obj.find("img[select_goods_id='"+goods_id+"']").size()>0) return;//é¿åéå¤
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
        function del_recommend_goods(goods_id) {//å é¤å·²éåå
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



</body></html>