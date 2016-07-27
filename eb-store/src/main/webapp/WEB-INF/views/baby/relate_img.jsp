<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
//宝贝图片上传
$(function() {
	$("#"+$("#relate_img_id").val() + " tr td span[class='sel-imgs-area'] img").remove();
	var relateImgPath = "";
	$("#relateImg").uploadify({
		debug			: false, 
		swf 			: 'resources/js/uploadify.swf',	//swf文件路径
		method			: 'post',	// 提交方式
		uploader		: '${pageContext.request.contextPath}/uploadify', // 服务器端处理该上传请求的程序
		preventCaching	: true,		// 加随机数到URL后,防止缓存
		buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
		buttonImage		: 'resources/images/addGoods.png',	// 按钮的背景图片,会覆盖文字
		//buttonText		: '选择文件'	, //按钮上显示的文字，默认”SELECTFILES”
        //buttonClass: "some-class", 
		height			: 25	, // 30 px
		width			: 104	, // 120 px
		fileObjName		: 'filedata',	//文件对象名称, 即属性名
		fileSizeLimit	: '100KB',		// 文件大小限制, 100 KB
		fileTypeDesc	: '请选择png或者jpg格式图片', 	//文件类型说明 any(*.*)
		fileTypeExts	: '*.jpg;*.jpeg;*.gif;*.png',		// 允许的文件类型,分号分隔
		formData		: {'id':'2', 'name':'ffff'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
		multi			: true ,	// 多文件上传
		progressData	: 'percentage',	// 进度显示, speed-上传速度,percentage-百分比	
		queueID			: 'relateImgQueue',//上传队列的DOM元素的ID号
		queueSizeLimit	: 99	,	// 队列长度
		removeCompleted : true	,	// 上传完成后是否删除队列中的对应元素
		removeTimeout	: 1	,	//上传完成后多少秒后删除队列中的进度条, 
		requeueErrors	: true,	// 上传失败后重新加入队列
		uploadLimit		: 10,	// 最多上传文件数量
		successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
		
		// 上传文件失败触发
		onUploadError : function(file, errorCode, errorMsg, errorString){ 
                              alert('上传文件失败!');
						},
           
         // 在每一个文件上传成功后触发
         onUploadSuccess : function(file, data, response) {
        	 var json = $.parseJSON(data);
        	 if(json.success) {
        		var data = json.data;
				$("#relate_new_images").append("<img src=\""+ data +"\" width=\"90\" height=\"90\">");
				$("#"+$("#relate_img_id").val() + " tr td span[class='sel-imgs-area'] img[src='']").remove();
				$("#"+$("#relate_img_id").val() + " tr td span[class='sel-imgs-area']").append("<img src=\""+ data +"\" width=\"25\" height=\"25\">");
				relateImgPath += '${pageContext.request.contextPath}/' + data + '|';
				$("#relateImgPath"+$("#relate_img_id").val().replace('typeDetailTbody','')).val('').val(relateImgPath);
        	 }
         }
	});

	
	$("#relateImgMouse").mouseover(function(){
		$("#relateImgTitle").show();
	}).mouseout(function(){
		$("#relateImgTitle").hide();
	});
})
</script>
<style>
<!--
div#relate_new_images img {
  border: 1px solid #bfbfbf;
  margin: 0 3px 0 0;
}
-->
</style>
<div class="division pic-main">
<input type="hidden" id="relate_img_id" value="${relateId}"/>
<div class="clearfix">
	<span class="pic-uploader">
			<span id="relateImg"></span>
			<div id="relateImgQueue"></div>
	</span>
	<span id="relateImgMouse" title=""><img
		src="resources/images/tips_help.gif"></span>
	<span id="relateImgTitle" class="notice-inline" style="display: none; color:#666666;">上传图片大小不能超过1MB,不能包含品牌LOGO!</span>
</div>
<div class="pic-area">
	<div class="all-pics" id="relate_new_images" style="width:100%;">
		
	</div>
</div>