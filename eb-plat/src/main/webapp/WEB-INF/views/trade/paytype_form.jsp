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
            <h3>支付方式</h3>
            <ul class="tab-base"><li><a class="current"><span>支付方式</span></a></li>
        </ul></div>
    </div>
    <div class="fixed-empty"></div>
    <form id="post_form" method="post" name="form1" action="${pageContext.request.contextPath}/paytype/saveOrUpdate">
        <table class="table tb-type2 nobdb">
            <tbody>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">支付方式:</td>
            </tr>
            <tr>
                  <td>
			            <input type="text" id="paymentName" name="paymentName" value="">
                  </td>
            </tr>
             <tr>
                <td colspan="2" class="required">支付编码： 汉字首字母或英文缩写:</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                  <td>
			            <input type="text" id="paymentCode" name="paymentCode" value="">
                  </td>
            </tr>
            <tr>
                <td colspan="2" class="required">启用: </td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff">
                	<label for="payment_state1" class="cb-enable"><span>是</span></label>
                    <label for="payment_state2" class="cb-disable selected"><span>否</span></label>
                    <input type="radio" value="1" name="paymentState" id="payment_state1">
                    <input type="radio" checked="checked" value="0" name="paymentState" id="payment_state2"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required">支付图标:</td>
            </tr>
            <tr class="noborder">
                  <td>
                        <div class="logo clf"> 
                              <a href="javascript:void(0);" class="btn-upload btng-s" style="background-color:#eee; color:#000; cursor:pointer;float: left;">
                                 <input type="file" class="file" name="files" id="myBlogImage0" onchange="ajaxFileUploads('myBlogImage0','paymentLogoimg','paymentLogo');">
                              </a>
                              <br><br>  
                              <p><img src="./管理后台-支付新增_files/nopic.png" width="100px" height="100px" id="paymentLogoimg" class="img" style="float: left;"></p>
			            </div>
			            <input type="hidden" id="paymentLogo" name="paymentLogo" value="">
                 </td>
                <td class="vatop tips">支持格式gif,jpg,jpeg,png</td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn" onclick="document.form1.submit()"><span>提交</span></a> 
                <a href="${pageContext.request.contextPath}/payment" class="btn"><span>返回</span></a></td>
                </tr>
            </tfoot>
        </table>
    </form>
</div>
<script>
     //上传图片
	function ajaxFileUploads(myBlogImage,imgId,img){
	    $.ajaxFileUpload({
	        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
	        url:'${pageContext.request.contextPath}/payment/fileUpload',
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
	        	layer.msg('上传图片失败，请重试！', 1, 8);
	            //$('#result').html('图片上传失败，请重试！！');
	        }
	    });
	}
</script>
</body>
</html>