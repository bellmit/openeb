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
        LOADING_IMAGE = "${pageContext.request.contextPath}/static/ui-v2/images/loading.gif";
    </script>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/layer.css" id="layui_layer_skinlayercss" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/admincp.js" charset="utf-8"></script>
	</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>规格管理</h3>
            <ul class="tab-base">
                <li><a href="${pageContext.request.contextPath}/spec"><span>管理</span></a></li>
                <li><a href="${pageContext.request.contextPath}/spec/form"><span>新增</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="spec_form" method="post" action="javascript:void(0);">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder">
                <td class="required" colspan="2"><label class="validation" for="s_name">规格：</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" class="txt" name="spName" id="s_name" value="${spec.title }"></td>
                <td class="vatop tips">请填写常用的商品规格的名称；例如：颜色；尺寸等。</td>
            </tr>
             <tr style="background: rgb(255, 255, 255);">
                <td class="required" colspan="2"><label class="validation" for="s_sort">排序：</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" class="txt" name="spSort" id="s_sort" value="${spec.ordernum }"></td>
                <td class="vatop tips">请填写自然数。规格列表将会根据排序进行由小到大排列显示。</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td class="required" colspan="2"><label class="validation" for="s_format">规格类型：</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform">
                		<input type="radio" name="spFormat" checked="checked" spectype="wenzi" value="0">文字
	                	<input type="radio" name="spFormat" spectype="tupian">图片
				</td>
                <td class="vatop tips">图片类型的规格值用于直观表现某些特殊规格类型，例如颜色规格，可用对应的色彩图片来表现其各种颜色值。</td>
            </tr>
            
            <tr>
                <td class="required" colspan="2"><label class="validation" for="s_value">添加规格值：</label></td>
            </tr>
            <tr style="background: rgb(251, 251, 251);">
            	<td>
            		<span style="margin:0px ">排序</span>
            		<span style="margin:120px ">规格值</span>
            	</td>
            </tr>
            <c:forEach items="${spec.specVals }" var="spceval">
		     <tr class="noborder" name="specValueDiv">
				<td class="vatop rowform" colspan="1.5">
					<input type="hidden" name="spValueId" value="${spceval.id }">
		        	<input type="text" name="spValueSort" placeholder="排序" value="${spceval.ordernum }">
		            <input type="text" name="spValueName" placeholder="规格值" value="${spceval.title }">
		            <p href="javascript:void(0);" style="display: none;" name="spValueImage">
		               	<input type="file" id="myBlogImage0" name="files" class="file" multiple="multiple" onchange="ajaxFileUploads('myBlogImage0',this);">
							<img style="width:30px;height:30px" src="${pageContext.request.contextPath}/static/ui-v2/picture.gif">
						<input type="hidden" value="">
					</p>
		        </td>
				<td class="vatop rowform">
		             <a href="javascript:void(0);" onclick="deleteSpecValue(this)">移除</a>
				</td>        
		     </tr>
		     </c:forEach>      
		     <tr>
		     	<td colspan="2">
		        	<a class="btn-add marginleft" href="JavaScript:void(0);" id="addSpecValue">新增一个规格值</a>
		        </td>
		     </tr>
           	</tbody>
	        <tfoot>
		       	<tr class="tfoot">
		            <td colspan="15"><a id="submitBtn" class="btn" href="JavaScript:void(0);"> <span>提交</span> </a></td>
		        </tr>
	        </tfoot>
        </table>
    </form>
</div>
<script type="text/javascript">
var specFormat;
var specImage;
function initEdit(){
	//全局变量,是图片还是文字
	if($("[name=spFormat]:checked").attr("value")=="0"){
		specFormat ='text';
		$("[name=spValueImage]").each(function(){
			$(this).css("display","none");
		});
	}else{
		specFormat ='image';
		$("[name=spValueImage]").each(function(){
			$(this).css("display","");
		});
	}
	//全局变量,文件上传的编号
	specImage = $("[name=specValueDiv]").length;
	specImage++;
}


//上传规格图片
function ajaxFileUploads(imageid,ob) {
	var $obj = $(ob);
	var $img = $obj.next();
	var $hid = $obj.next().next();
    $.ajaxFileUpload({
        url: APP_BASE+'/upload/specImage',
        data: '',
        secureuri: false,
        fileElementId: imageid,
        dataType: 'json',
        success: function (data, status) {
            if (data.success) {
            	$img.attr("src",data.imageServer+"/"+data.result);
            	$hid.attr("value",data.result);
            } 
        },
        error: function (data, status, e) { //服务器响应失败时的处理函数
            if (type == 0) {
                $('#result_logo').html('图片上传失败，请重试！！');
            } else {
                $('#result_banner').html('图片上传失败，请重试！！');
            }
        }
    });
}

	//删除一个规格值
	function deleteSpecValue(obj){
		var len = $("[name=specValueDiv]").length
		if(len != 1){
			$(obj).parent().parent().remove();
		}
	}
	
	
    $(function(){
    	//初始化
    	initEdit();
    	
    	//新增一个规格值
    	$("#addSpecValue").click(function(){
    		var len = $("[name=specValueDiv]").length;
    		var i = 0;
    		$("[name=specValueDiv]").each(function(){
    			if(i == (len-1)){
    				var myBlogImage = "myBlogImage" + specImage;
    				if(specFormat == 'image'){
    					$(this).after('<tr class="noborder" name="specValueDiv">'+
        		                '<td  class="vatop rowform" colspan="1.5">'+
        		                '<input type="hidden" name="spValueId" /> '+
        	                	'<input type="text" name="spValueSort" placeholder="排序"/> '+
        	                	'<input type="text" name="spValueName" placeholder="规格值"/>'+
        	                	'<p href="javascript:void(0);" name="spValueImage">'+
    		                		'<input type="file" id="'+myBlogImage+'" name="files" class="file" multiple="multiple" onChange="ajaxFileUploads(\''+myBlogImage+'\',this);" />'+
    								'<img style="width:30px;height:30px" src="/leimingtech-admin/res/images/picture.gif"/>'+
    								'<input type="hidden"/>'+
    							'</p>'+
        	                '</td>'+
        					'<td class="vatop rowform">'+
        	                	'<a href="javascript:void(0);" onclick="deleteSpecValue(this)">移除</a>'+
        					'</td>'+
        	            '</tr>');
    				}else{
    					 $(this).after('<tr class="noborder" name="specValueDiv">'+
        		                '<td class="vatop rowform" colspan="1.5">'+
        		                '<input type="hidden" name="spValueId" /> '+
        	                	'<input type="text" name="spValueSort" placeholder="排序"/> '+
        	                	'<input type="text" name="spValueName" placeholder="规格值"/>'+
        	                	'<p href="javascript:void(0);" style="display: none;" name="spValueImage">'+
    		                		'<input type="file" id="'+myBlogImage+'" name="files" class="file" multiple="multiple" onChange="ajaxFileUploads(\''+myBlogImage+'\',this);" />'+
    								'<img style="width:30px;height:30px" src="/leimingtech-admin/res/images/picture.gif"/>'+
    								'<input type="hidden"/>'+
    							'</p>'+
        	                '</td>'+
        					'<td class="vatop rowform">'+
        	                	'<a href="javascript:void(0);" onclick="deleteSpecValue(this)">移除</a>'+
        					'</td>'+
        	            '</tr>'); 
    				}
    				specImage++;
    			};
    			i++;
    		}); 
    	});
    		
    	
    	//文字,图片的js效果
    	$("[name=spFormat]").change(function(){
			if($(this).attr("specType") == "tupian"){
				specFormat='image';
				$(this).attr("value","1");
				$("[name=spValueImage]").each(function(){
					$(this).css("display","");
				});
			}else{
				specFormat='text';
				$(this).attr("value","0");
				$("[name=spValueImage]").each(function(){
					$(this).css("display","none");
				});
			}
    	});
    	
        //表单验证
        $('#spec_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },

            rules : {
                spName: {
                    required : true,
                    maxlength: 10,
                    minlength: 1
                },
                spSort: {
                    required : true,
                    digits	 : true
                },
                spValueSort: {
                    required : true,
                    digits	 : true,
                    maxlength: 3,
                    minlength: 1
                },
                spValueName: {
                    required : true,
                    maxlength: 10,
                    minlength: 1
                }
            },
            messages : {
                spName : {
                    required : '请填写规格名称',
                    maxlength: '规格名称长度应在1-10个字符之间',
                    minlength: '规格名称长度应在1-10个字符之间'
                },
                spSort: {
                    required : '请填写规格排序',
                    digits   : '请填写整数'
                },
                spValueSort: {
                    required : '请填写规格排序',
                    digits   : '请填写整数',
               	 	maxlength: '排序应在0-999之间数字',
                    minlength: '排序应在0-999之间数字'
                },
                spValueName: {
                    required : '请填写规格值',
                    digits   : '规格名称长度应在1-10个字符之间'
                }
            }
        });

        //按钮先执行验证再提交表单
        $("#submitBtn").click(function(){
            if($("#spec_form").valid()){
            	var spName = $("[name=spName]").val();
            	var spFormat = $("[name=spFormat]:checked").attr("value");
            	var spSort = $("[name=spSort]").val();
            	//获取规格值
            	var spValue = "";
            	$("[name=spValueName]").each(function(){
            		spValue += $(this).val() + ",";
            	});
            	spValue = spValue.substring(0,spValue.length-1);
            	//获取规格值对象的集合
            	var specVals = new Array();
            	var tag = true;
            	$("[name=specValueDiv]").each(function(){
            		var spValueId = $(this).find("[name=spValueId]").val();
            		var spValueName = $(this).find("[name=spValueName]").val();
            		var spValueSort = $(this).find("[name=spValueSort]").val();
            		//判断是否有图片
            		if(spFormat == "1"){
            			var spValueImage = $(this).find(":hidden").val();
            			if(spValueName==null||spValueName==""||spValueSort==null||spValueSort==""||isNaN(spValueSort)){
           					/* alert("规格值输入不合法"); */
           					tag = false;
           					layer.alert("规格值输入不合法",{icon:2});
           					return false
           				}
            			
            			var specval = {
            				id:spValueId,
               				title:spValueName,
               				spValueImage:spValueImage,
               				ordernum:spValueSort
               			};
               			specVals.push(specval);
            		}else{
            			//SpecValues += '{"spValueName":"' + spValueName + '","spValueSort":"' + spValueSort + '"},'
            			if(spValueName == "" || spValueName == null ||spValueSort == "" || spValueSort == null){
            				tag = false;
            				layer.alert("规格值输入不合法",{icon:2});
            				return false
            			}
            			var specval = {
            				id:spValueId,
                   			title:spValueName,
                   			ordernum:spValueSort
                   		};
                   		specVals.push(specval);
            		}
            	});
            	var args = {
            		"id":'${spec.id}',
            		"title":spName,
            		"showType":spFormat,
            		"ordernum":spSort,
            		//"spValue":spValue,
            		"specVals":specVals
            	};
            	console.log(args);
            	var url = APP_BASE+"/spec/save";
            	if(tag){
            		$.ajax({ 
                        type:"POST", 
                        url:url, 
                        dataType:"json",      
                        contentType:"application/json",               
                        data:JSON.stringify(args),
                        success:function(data){ 
                                                   
                        } 
                    }); 
            		/* $.post(url,args,function(data){
                		$(".page").empty();
                		$(".page").append(data);
            		}); */
            	}
            }
        });
    });

</script>
</body>
</html>