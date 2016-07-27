<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	var banner_index = 1;
	$(function() {
		// 添加品牌链接
		$("#index_banner").click(function(){
			$(this).parent().append("<div class='brandLine'><input type='text' name='brand_"+banner_index+"' /><div><span class='uploadFiles' id='brand_"+banner_index+"' onclick='uploadFiles(\"brand_"+banner_index+"\");'>上传图片</span>&nbsp;&nbsp;链接地址：</div><input type='text' name='bannerLine' /></div>");
			banner_index ++;
		});
	});
	
	// 图片上传
	function uploadFiles(id) {
		$("#"+id).uploadify({
			debug			: false, 
			swf 			: 'resources/js/uploadify.swf',	//swf文件路径
			method			: 'get',	// 提交方式
			uploader		: '${pageContext.request.contextPath}/uploadify', // 服务器端处理该上传请求的程序
			preventCaching	: true,		// 加随机数到URL后,防止缓存
			buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
			buttonImage		: 'resources/images/upload.jpg',	// 按钮的背景图片,会覆盖文字
			//buttonText		: '选择文件'	, //按钮上显示的文字，默认”SELECTFILES”
            //buttonClass: "some-class", 
			height			: 26	, // 30 px
			width			: 62	, // 120 px
			fileObjName		: 'filedata',	//文件对象名称, 即属性名
			fileSizeLimit	: '3000KB',		//文件大小限制, 100 KB
			fileTypeDesc	: '请选择png或者jpg格式图片', 	//文件类型说明 any(*.*)
			fileTypeExts	: '*.jpg;*.jpeg;*.gif;*.png',		// 允许的文件类型,分号分隔
			formData		: {'id':'2', 'name':'ffff'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
			multi			: false ,	// 多文件上传
			progressData	: 'percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 10,		// 队列长度
			removeCompleted : true,		// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 1	,		//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: false,	// 上传失败后重新加入队列
			uploadLimit		: 1,	// 最多上传文件数量
			successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
			// 在每一个文件上传成功后触发
            onUploadSuccess : function(file, data, response) {
            	 var json = $.parseJSON(data);
            	 if(json.success) {
					$("input[name='"+id+"']").val(json.data);
            	 }
             }
		});
	}
</script>
<style>
<!--
.channel-edit {
	padding:10px;
	padding-top: 0px;
}

.channel-edit table {
	padding:10px;
	font-size: 12px;
	border:1px solid #d9d9d9;
	width:765px;
	background-color: #f4f4f4;
}

.channel-edit h4 {
	line-height: 30px;
	padding:5px;
}

.channel-edit table tr td input {
	border: 1px solid #d9d9d9;
	width:160px;
	height:24px;
	margin-right: 5px;
	color:#999999;
	float:left;
}

.channel-edit table tr {
	height:30px;
	line-height: 30px;
}

.channel-edit table tr td{
	padding-right: 20px;
  margin-bottom: 1em;
}

.channel-edit table tr td span{
	padding:5px;
	border:1px solid #d9d9d9;
	cursor: pointer;
}

.channel-edit table tr td .brandLine{
	clear:both;
	float: left;
	display: block;
}

.channel-edit table tr td div{
	float:left;
}

-->
</style>
<div class="channel-edit">
	<form method="post" id="banner_info">
		<h4>首页Banner信息</h4>
		<table>
			<tr>
				<td>顶部主图（宽：1600px，高480px）：</td>
				<td><input type="text" name="maingraph" /><span class="uploadFiles" id="maingraph" onclick="uploadFiles('maingraph');">上传图片</span></td>
				<td><div>链接：</div><input type="text" name="maingraphline" /></td>
			</tr>
			<tr>
				<td>顶部副图(1)（宽：190px，高240px）：</td>
				<td><input type="text" name="subgraph1" /><span class="uploadFiles" id="subgraph1" onclick="uploadFiles('subgraph1');">上传图片</span></td>
				<td><div>链接：</div><input type="text" name="subgraphline1" /></td>
			</tr>
			<tr>
				<td>顶部副图(2)（宽：190px，高240px）：</td>
				<td><input type="text" name="subgraph2" /><span class="uploadFiles" id="subgraph2" onclick="uploadFiles('subgraph2');">上传图片</span></td>
				<td><div>链接：</div><input type="text" name="subgraphline2" /></td>
			</tr>
		</table>
		
		<h4>页面长条幅</h4>
		<table>
			<tr>
				<td>长条幅列表：</td>
				<td><div id="index_banner"><span>上传图片</span>(宽：1190px，高：90px)</div></td>
			</tr>
		</table>
		
		<input type="hidden" name="longBanner" id="index_longBanner" />
	</form>
</div>