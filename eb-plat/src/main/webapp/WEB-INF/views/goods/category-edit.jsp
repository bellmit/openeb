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
                <li><a href="${pageContext.request.contextPath}/category/form"><span>新增</span></a></li>
                <li><a href="javascript:void(0)" class="current"><span>编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd">
            <th class="nobg" colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td>
                <ul>
                    <li>"类型"关系到商品发布时商品规格的添加，没有类型的商品分类的将不能添加规格。</li>
                    <li>默认勾选"关联到子分类"将商品类型附加到子分类，如子分类不同于上级分类的类型，可以取消勾选并单独对子分类的特定类型进行编辑选择。</li>
                    <li>在编辑"类型"和勾选"关联到子分类"时，涉及分类下的商品将会被进行"违规下架"处理，商品在重新编辑后才能正常使用，<span color="color:#F30">请慎重操作</span></li>
                </ul></td>
        </tr>
        </tbody>
    </table>
    <form id="goods_class_form" name="goodsClassForm" action="${pageContext.request.contextPath}/category/edit" method="post">
        <input type="hidden" name="form_submit" value="ok">
        <input type="hidden" name="gcId" value="eae1aa38c0c6451d8f9436e203880d78">
        <input type="hidden" name="gcParentId" id="gc_parent_id" value="0">
        <input type="hidden" name="old_type_id" value="4d53c794255e4127a08cc1d1f9b443db">
         <input type="hidden" name="gcIdpath" value="eae1aa38c0c6451d8f9436e203880d78,">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder">
                <td colspan="2" class="required"><label class="gc_name validation" for="gcName">分类名称:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" maxlength="20" value="租房" name="gcName" id="gcName" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">
	                <label class="gc_expenScale validation" for="expenScale">
	               		 佣金比例:
	               		<input type="checkbox" name="isRelate" value="1">关联到子分类
	                </label>
                </td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" maxlength="10" value="1" name="expenScale" id="expenScale" class="txt" style="width: 40px;">%</td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
		            <td colspan="2" class="required" id="gcategory">
		                <label for="gc_name">类型:</label>
		                <input id="typename" name="typename" type="hidden" value="服装">
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
		                        <option value="4d53c794255e4127a08cc1d1f9b443db" selected="selected">&nbsp;&nbsp;房产</option>
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
                <td class="vatop rowform onoff"><label for="brand_recommend1" class="cb-enable selected "><span>是</span></label>
                    <label for="brand_recommend0" class="cb-disable "><span>否</span></label>
                    <input id="brand_recommend1" name="gcshow" value="1" type="radio" checked="checked">
                    <input id="brand_recommend0" name="gcshow" value="0" type="radio"></td>
                    
                
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">分类图标:</td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                  <td>
                        <div class="logo clf"> 
                              <a href="javascript:void(0);" class="btn-upload btng-s" style="background-color:#eee; color:#000; cursor:pointer;">
                                 <input type="file" class="file" name="files" id="myBlogImage0" onchange="ajaxFileUploads(&#39;myBlogImage0&#39;,&#39;busLicense&#39;,&#39;busLicense0&#39;);">
                              </a>
                                   <img src="./管理后台-分类编辑_files/1460109042247.jpg" width="100px" height="100px" id="busLicense" class="img">
			            </div>
			            <input type="hidden" id="busLicense0" name="gcpic" value="">
                 </td>
                <td class="vatop tips">支持格式gif,jpg,jpeg,png</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label for="gcSort">排序:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="1" name="gcSort" id="gc_sort" class="txt"></td>
                <td class="vatop tips">数字范围为0~255，数字越小越靠前</td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot"><td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script type="text/javascript" src="./管理后台-分类编辑_files/common_select.js" charset="utf-8"></script>
<script type="text/javascript" src="./管理后台-分类编辑_files/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="./管理后台-分类编辑_files/jquery.mousewheel.js"></script>
<script>
     //上传图片
	function ajaxFileUploads(myBlogImage,imgId,img){
	    $.ajaxFileUpload({
	        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
	        url:'/leimingtech-admin/upload/fileUpload',
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


    $(document).ready(function(){
        $('#type_div').perfectScrollbar();
        //按钮先执行验证再提交表单
        $("#submitBtn").click(function(){
            if($("#goods_class_form").valid()){
                $("#goods_class_form").submit();
            }
        });

        $("#pic").change(function(){
            $("#textfield1").val($(this).val());
        });
      /*   $('input[type="radio"][name="typeId"]').change(function(){
            // 标记类型时候修改 修改为ok
            var t_id = '4d53c794255e4127a08cc1d1f9b443db';
            if(t_id != $(this).val()){
                $('#t_sign').val('ok');
            }else{
                $('#t_sign').val('');
            }

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
                        url :APP_BASE+'/goods/class/validate',
                        type:'post',
                        data:{
                            gcName : function(){
                                return $('#gcName').val();
                            },
                            gcParentId : function() {
                                return $('#gc_parent_id').val();
                            },
                            gcId : 'eae1aa38c0c6451d8f9436e203880d78'
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

        // 类型搜索
       /*  $("#gcategory > select").live('change',function(){
            type_scroll($(this));
        }); */
        
        
          $("#typeId").change( function() {
              var sel=$("#typeId").find("option:selected").text()
              $("#typename").val($.trim(sel)); 
          });
    });
  /*   var typeScroll = 0;
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
   /*  gcategoryInit('gcategory'); */
</script>


</body></html>