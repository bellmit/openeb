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
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>分类管理</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/category"><span>管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/category/form" class="current"><span>新增</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="goods_class_form" action="${pageContext.request.contextPath}/category/edit" method="post">
    <input type="hidden" name="gcId" value="0">
    <input type="hidden" name="form_submit" value="ok">
    <table class="table tb-type2">
        <tbody>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label class="validation" for="gcName">分类名称:</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform"><input type="text" value="" name="gcName" id="gcName" maxlength="20" class="txt"></td>
            <td class="vatop tips"></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">
                    <label class="gc_expenScale validation" for="expenScale">佣金比例:</label>
                </td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform"><input type="text" maxlength="10" value="" name="expenScale" id="expenScale" class="txt" style="width: 40px;">%</td>
            <td class="vatop tips"></td>
        </tr>
        <tr>
            <td colspan="2" class="required"><label for="parent_id">上级分类:</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform">
                <select name="gcParentId" id="gc_parent_id">
                    <option value="0">请选择...</option>
                        <option value="0568b2fe256946ffa5b94bb5abb1adda">
                            &nbsp;&nbsp;二手房</option>
                            <option value="30e374ab974947449a8c1861ae8a9a4a">
                                &nbsp;&nbsp;&nbsp;&nbsp;客房电器</option>
                            <option value="f18a5d61baa7493fb660f13a8bc6e826">
                                &nbsp;&nbsp;&nbsp;&nbsp;1212</option>
                            <option value="816f6e71d85f49fe9739a6a260ba0fa7">
                                &nbsp;&nbsp;&nbsp;&nbsp;电视</option>
                            <option value="eb11fa0add384adb982c3f348be4f959">
                                &nbsp;&nbsp;&nbsp;&nbsp;冰箱</option>
                        <option value="eae1aa38c0c6451d8f9436e203880d78">
                            &nbsp;&nbsp;租房</option>
                            <option value="36cfeecf4a524016b7122034a3b2b516">
                                &nbsp;&nbsp;&nbsp;&nbsp;箱包</option>
                            <option value="3aef387727f64cc79494776ea595b0cc">
                                &nbsp;&nbsp;&nbsp;&nbsp;男装</option>
                            <option value="c9c3137e75d94ef5b58fcd1892399d9a">
                                &nbsp;&nbsp;&nbsp;&nbsp;鞋靴</option>
                            <option value="e29f56d378e3463a87cdfed62ee2e206">
                                &nbsp;&nbsp;&nbsp;&nbsp;童装</option>
                            <option value="d579627f99ba47968e37a203875d7ad7">
                                &nbsp;&nbsp;&nbsp;&nbsp;女装</option>
                        <option value="8a2defb1ebdf4458ab76b9369611586c">
                            &nbsp;&nbsp;手机 数码 电脑 家电</option>
                            <option value="0c52126b10e14c3e93c97ca73a4eb60f">
                                &nbsp;&nbsp;&nbsp;&nbsp;手机</option>
                            <option value="0f2084d600d74d8ab1f3c7a5e049bbe1">
                                &nbsp;&nbsp;&nbsp;&nbsp;电脑</option>
                            <option value="775e0aea66ba4c10bef2c0aa1a874a01">
                                &nbsp;&nbsp;&nbsp;&nbsp;数码配件</option>
                        <option value="be641713440a4788947c7234fa550a7b">
                            &nbsp;&nbsp;生活服务</option>
                            <option value="341fce8405464937addb7d9e3d767f79">
                                &nbsp;&nbsp;&nbsp;&nbsp;家政服务</option>
                        <option value="c748d987f7f043b3a4aa13c180cf77c4">
                            &nbsp;&nbsp;母婴用品 玩具图书</option>
                            <option value="49eca8d6bbe34a1c852b07fbd2d0dce5">
                                &nbsp;&nbsp;&nbsp;&nbsp;塑料玩具</option>
                            <option value="5a63cb1ccbc94bac8e96bbcd313e475d">
                                &nbsp;&nbsp;&nbsp;&nbsp;母婴用品</option>
                            <option value="903f8369f5ee4e848ac92f983aa59ee3">
                                &nbsp;&nbsp;&nbsp;&nbsp;辅食</option>
                            <option value="b5882dcbb65d4b49a268a395740afe90">
                                &nbsp;&nbsp;&nbsp;&nbsp;尿不湿</option>
                            <option value="e0ff263a84c74d7eaba5bb02084940f7">
                                &nbsp;&nbsp;&nbsp;&nbsp;食品</option>
                            <option value="0d7f84e4be344a9da50335d42bbbf6de">
                                &nbsp;&nbsp;&nbsp;&nbsp;玩具</option>
                            <option value="a33112c86d3f4ded9da98a0576e85002">
                                &nbsp;&nbsp;&nbsp;&nbsp;图书</option>
                        <option value="625bb2e038214198805db26596201210">
                            &nbsp;&nbsp;酒类 生鲜 食品</option>
                            <option value="1baefbc7469846eea819a120c888d7cc">
                                &nbsp;&nbsp;&nbsp;&nbsp;乳制品</option>
                            <option value="3e87314832644725812ebcb98db134f8">
                                &nbsp;&nbsp;&nbsp;&nbsp;生鲜</option>
                            <option value="52481fc1ce5646f3a9336fca204596ff">
                                &nbsp;&nbsp;&nbsp;&nbsp;龙虾</option>
                            <option value="6160c39bbc8d482091694b0b48118244">
                                &nbsp;&nbsp;&nbsp;&nbsp;生鲜食品</option>
                            <option value="61b647b4c97e48a3bb82e61f738d3acd">
                                &nbsp;&nbsp;&nbsp;&nbsp;果汁</option>
                            <option value="6c41104baa21437a839f9ad2cb8c5075">
                                &nbsp;&nbsp;&nbsp;&nbsp;美食</option>
                            <option value="6d959b2b8421430888423c6d761bc354">
                                &nbsp;&nbsp;&nbsp;&nbsp;地方特产</option>
                            <option value="c11b901fbf6e446dbcefcb53fca041e7">
                                &nbsp;&nbsp;&nbsp;&nbsp;零食</option>
                            <option value="cdbcbad4787a4be5b82b555879a9bd6f">
                                &nbsp;&nbsp;&nbsp;&nbsp;中外名酒</option>
                            <option value="d3d097458d7a4d4da5d8bc33b38eee43">
                                &nbsp;&nbsp;&nbsp;&nbsp;红酒</option>
                            <option value="ed61755920654e2d85c8300e1a86a635">
                                &nbsp;&nbsp;&nbsp;&nbsp;膨化食品</option>
                            <option value="fa12d866a45a4fa3b94024429743e57b">
                                &nbsp;&nbsp;&nbsp;&nbsp;碳酸饮料</option>
                        <option value="139eaf1f1e814a7fa93b903049c4771d">
                            &nbsp;&nbsp;家居家纺</option>
                            <option value="281336527d524ba1bcc5177ccf8d79c0">
                                &nbsp;&nbsp;&nbsp;&nbsp;床上用品四件套</option>
                            <option value="29203f19594642dfb001ea1d854fcb5c">
                                &nbsp;&nbsp;&nbsp;&nbsp;遮阳窗帘</option>
                            <option value="327ef9823cdf47369697ba9b02a8305d">
                                &nbsp;&nbsp;&nbsp;&nbsp;床罩</option>
                            <option value="40617af5faab402d8ee2afe4e4874b82">
                                &nbsp;&nbsp;&nbsp;&nbsp;布艺软饰</option>
                            <option value="4f83d2e4ce1d4d79b37b13c3e6ebfd15">
                                &nbsp;&nbsp;&nbsp;&nbsp;毛毯</option>
                            <option value="7ed2e0c7c04d4abb8e963b19b0c6bbbc">
                                &nbsp;&nbsp;&nbsp;&nbsp;床上用品</option>
                            <option value="81f34e9c10cc4c4dbaba62670f636973">
                                &nbsp;&nbsp;&nbsp;&nbsp;家居用品</option>
                            <option value="85944c625fc740b0ad09b891729797bc">
                                &nbsp;&nbsp;&nbsp;&nbsp;沙发垫</option>
                            <option value="c1bdb8075b5746d9958652d87893ba31">
                                &nbsp;&nbsp;&nbsp;&nbsp;墙纸</option>
                            <option value="d2d6cc36550347a5a11bb48be90fd4f4">
                                &nbsp;&nbsp;&nbsp;&nbsp;壁纸</option>
                            <option value="dc0042ae3e684f58ae698249f5a44950">
                                &nbsp;&nbsp;&nbsp;&nbsp;蚊帐</option>
                            <option value="f390d49eefb247b6bb6323dc21e98c43">
                                &nbsp;&nbsp;&nbsp;&nbsp;冰丝垫</option>
                        <option value="28ed715304e4437d962938964011ac95">
                            &nbsp;&nbsp;美妆洗护</option>
                            <option value="223a924b07ad4dbd8797142afeb1a450">
                                &nbsp;&nbsp;&nbsp;&nbsp;营养保健</option>
                            <option value="62a5ede1cca74b59b4357037eefd8835">
                                &nbsp;&nbsp;&nbsp;&nbsp;美妆</option>
                            <option value="f0c1670a220a46a2a0ae5cf3bfad9a5f">
                                &nbsp;&nbsp;&nbsp;&nbsp;个人护理</option>
                        <option value="e1dd743764d04071971d2cc57e5f6483">
                            &nbsp;&nbsp;家用电器</option>
                            <option value="cee9e37926c043d8aff6f9be1a16a23c">
                                &nbsp;&nbsp;&nbsp;&nbsp;运动</option>
                            <option value="d8ee246147254922983d15720e0ce16a">
                                &nbsp;&nbsp;&nbsp;&nbsp;乐器</option>
                            <option value="f8ab735d91874f30a1b17a08067fe4ba">
                                &nbsp;&nbsp;&nbsp;&nbsp;户外健身</option>
                        <option value="2848fbbb6ea84f6ba592f44e3f3d340c">
                            &nbsp;&nbsp;珠宝，首饰</option>
                            <option value="2c18a72888ab48cca1f6c57f391fb001">
                                &nbsp;&nbsp;&nbsp;&nbsp;黄金</option>
                            <option value="c5c900a924cb4a929151f4a52c1a47e3">
                                &nbsp;&nbsp;&nbsp;&nbsp;玉器</option>
                            <option value="c74f0152eea2420c8edf1aa731816dca">
                                &nbsp;&nbsp;&nbsp;&nbsp;钻石</option>
                            <option value="cc3b70832be8431db2d5a73c83566065">
                                &nbsp;&nbsp;&nbsp;&nbsp;玛瑙</option>
                </select>
            </td>
            <td class="vatop tips">如果选择上级分类，那么新增的分类则为被选择上级分类的子分类</td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required" id="gcategory">
                <label for="gc_name">类型:</label>
                <input id="typename" name="typename" type="hidden">
                <select class="class-select" name="typeId" id="typeId">
                    <option value="0">请选择...</option>
                        <option value="b85de2b4752849c985814beed5ea9a24">&nbsp;&nbsp;家政服务</option>
                        <option value="240b94dc876e49c0807c25999dbf0df8">&nbsp;&nbsp;555555</option>
                        <option value="06d506a0dadd476884d26722cb785394">&nbsp;&nbsp;电视</option>
                        <option value="76218b6a99ad4cb1ba747d1eb801c170">&nbsp;&nbsp;鞋类</option>
                        <option value="7754a2dff4f145d4890e2d443d61d577">&nbsp;&nbsp;裙子</option>
                        <option value="90afc229a95d497a8f9f1b56b8703271">&nbsp;&nbsp;生活用品</option>
                        <option value="bd519eb7cc3b4d569bc50a08e421c67c">&nbsp;&nbsp;裤子</option>
                        <option value="c9711bce8e0e44e3bb775ac3c84e2dda">&nbsp;&nbsp;套装</option>
                        <option value="d7281e43721e49c8a8001913008bde82">&nbsp;&nbsp;首饰</option>
                        <option value="e877850c1671456fa0dcddd84b80a8e8">&nbsp;&nbsp;美妆</option>
                        <option value="7619a285815e4ef0be0c91aa75abb0e9">&nbsp;&nbsp;rrrr</option>
                        <option value="6f2fab06e427456a98e18e655f6dcdf0">&nbsp;&nbsp;零食</option>
                        <option value="12f36c856c704d1baddb51ee9d4da33f">&nbsp;&nbsp;酒水</option>
                        <option value="19cd21091f614444a35e83a97aeb142e">&nbsp;&nbsp;消费娱乐s</option>
                        <option value="2e70040e62dd4d00a72339ec239f4a3d">&nbsp;&nbsp;蔬菜水果</option>
                        <option value="37428d5f68d94ea484f5d95a0710cddf">&nbsp;&nbsp;1</option>
                        <option value="394e97147d964f298bec87fccf27268e">&nbsp;&nbsp;衬衫</option>
                        <option value="4d53c794255e4127a08cc1d1f9b443db">&nbsp;&nbsp;房产</option>
                        <option value="5724d895a8bb4812a642dcbe5b4bd7a7">&nbsp;&nbsp;夹克</option>
                        <option value="5bf084a683794c6dbb3745f603b6f730">&nbsp;&nbsp;手机</option>
                        <option value="f124cb385c4d44bcb0ed48505b02b5e9">&nbsp;&nbsp;手机1</option>
                </select>
            </td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">显示: </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform onoff"><label for="brand_recommend1" class="cb-enable selected"><span>是</span></label>
                    <label for="brand_recommend0" class="cb-disable"><span>否</span></label>
                    <input id="brand_recommend1" name="gcshow" value="1" type="radio" checked="checked">
                    <input id="brand_recommend0" name="gcshow" value="0" type="radio"></td>
                <td class="vatop tips"></td>
            </tr>
             <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">分类图标:</td>
            </tr>
            <tr class="noborder" style="background: rgb(251, 251, 251);">
                  <td>
                        <div class="logo clf"> 
                              <a href="javascript:void(0);" class="btn-upload btng-s" style="background-color:#eee; color:#000; cursor:pointer;">
                                 <input type="file" class="file" name="files" id="myBlogImage0" onchange="ajaxFileUploads(&#39;myBlogImage0&#39;,&#39;busLicense&#39;,&#39;busLicense0&#39;);">
                              </a>
			                  <img src="./管理后台-分类新增_files/nopic.png" width="100px" height="100px" id="busLicense" class="img">
			            </div>
			            <input type="hidden" id="busLicense0" name="gcpic" value="">
                 </td>
                <td class="vatop tips">支持格式gif,jpg,jpeg,png</td>
            </tr>
            
      
        <tr>
            <td colspan="2" class="required"><label>排序:</label></td>
        </tr>
        <tr class="noborder">
            <td class="vatop rowform"><input type="text" value="0" name="gcSort" id="gc_sort" class="txt"></td>
            <td class="vatop tips">数字范围为0~255，数字越小越靠前</td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
        </tr>
        </tfoot>
    </table>
</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.mousewheel.js"></script>
<script>
    //按钮先执行验证再提交表单
    $(function(){

        $('#type_div').perfectScrollbar();

        $("#submitBtn").click(function(){
            if($("#goods_class_form").valid()){
                $("#goods_class_form").submit();
            }
        });

        $("#pic").change(function(){
            $("#textfield1").val($(this).val());
        });
       /*  $('input[type="radio"][name="typeId"]').click(function(){
            if($(this).val() == '0'){
                $('#t_name').val('');
            }else{
                $('#t_name').val($(this).next('span').html());
            }
        }); */

        $('#goods_class_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
                gcName : {
                    required : true,
                    remote   : {
                        url :APP_BASE+'/category/validName',
                        type:'get',
                        data:{
                            name : function(){
                                return $('#gcName').val();
                            },
                            gcParentId : function() {
                                return $('#gc_parent_id').val();
                            },
                            gcId : '0'
                        }
                    }
                },
                gcSort : {
                    number   : true,
                    max : 255,
                    min : 0
                },
                expenScale:{
                    required: true,
                    number   : true,
                    max : 100,
                    min : 0.01
                }
            },
            messages : {
                gcName : {
                    required : '分类名称不能为空',
                    remote   : '该分类名称已经存在了，请您换一个'
                },
                gcSort  : {
                    number   : '分类排序仅能为数字',
                    max : '最大值为255',
                    min : '最小值为0'
                },
                expenScale:{
                    required: '费用比例不能为空',
                    number   : '费用比例仅能为数字',
                    max : '最大值为100',
                    min : '最小值为0.1'
                }
            }
        });

        // 所属分类
        $("#gc_parent_id").live('change',function(){
            type_scroll($(this));
        });
        // 类型搜索
        $("#gcategory > select").live('change',function(){
            type_scroll($(this));
        });
        
          $("#typeId").change( function() {
              var sel=$("#typeId").find("option:selected").text();
              $("#typename").val($.trim(sel)); 
          });
    });
   /*  var typeScroll = 0;
    function type_scroll(o){
        var id = o.val();
        if(!$('#type_dt_'+id).is('dt')){
            return false;
        }
        $('#type_div').scrollTop(-typeScroll);
        var sp_top = $('#type_dt_'+id).offset().top;
        var div_top = $('#type_div').offset().top;
        $('#type_div').scrollTop(sp_top-div_top);
        typeScroll = sp_top-div_top;
    } */
    
    //上传图片
	function ajaxFileUploads(myBlogImage,imgId,img){
	    $.ajaxFileUpload({
	        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
	        url:'${pageContext.request.contextPath}/upload/fileUpload',
	        secureuri:false,                       //是否启用安全提交,默认为false
	        fileElementId:myBlogImage,           //文件选择框的id属性
	        dataType:'json',                       //服务器返回的格式,可以是json或xml等
	        fileSize:5120000,
	        allowType:'jpg,jpeg,png,JPG,JPEG,PNG',
	        success:function(data, status){        //服务器响应成功时的处理函数
	            if( true == data.success){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
	            	//alert(data.result);
	               $("img[id='"+imgId+"']").attr("src", "http://www.leimingtech.com:99"+data.result);
	               $("#"+img).val(data.result);
	            }
	        },
	        error:function(data, status, e){ //服务器响应失败时的处理函数
	        	layer.msg('图片上传失败，请重试！！', 1, 8);
	            //$('#result').html('图片上传失败，请重试！！');
	        }
	    });
	}
    
   /*  gcategoryInit('gcategory'); */
</script>


</body></html>