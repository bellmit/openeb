<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	var brand_index = 1;
	var goods_index = 1;
	var basepath = "${pageContext.request.contextPath}";
	$(function() {
		// 添加类目链接
		$("#addCate").click(function(){
			$(this).parent().append("<div class='brandLine'><div>文字：</div><input type='text' name='textCate' /> <div>链接地址：</div><input type='text' name='textline' /></div>");
		});

		// 添加品牌链接
		$("#addBrand").click(function(){
			$(this).parent().append("<div class='brandLine'><input type='text' name='brand_"+brand_index+"' /><div><span class='uploadFiles' id='brand_"+brand_index+"' onclick='uploadFiles(\"brand_"+brand_index+"\");'>上传图片</span> 链接地址：</div><input type='text' name='brandline' /></div>");
			brand_index ++;
		});
		
		// 添加商品链接
		$("#addGoods").click(function(){
			$(this).parent().append("<div class='brandLine'><input type='text' name='goods_"+goods_index+"' /><div><span class='uploadFiles' id='goods_"+goods_index+"' onclick='uploadFiles(\"goods_"+goods_index+"\");'>上传图片</span> 链接地址：</div><input type='text' name='goodsLine' /></div>");
			goods_index ++;
		});
		
		initData();
	});
	
	
	
	
	// 图片上传
	function uploadFiles(id) {
		$("#"+id).uploadify({
			debug			: false, 
			swf 			: 'resources/js/uploadify.swf',	//swf文件路径
			method			: 'post',	// 提交方式
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
			multi			: true ,	// 多文件上传
			progressData	: 'percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 99	,	// 队列长度
			removeCompleted : true	,	// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 1	,	//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: true,	// 上传失败后重新加入队列
			uploadLimit		: 10,	// 最多上传文件数量
			successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
			
			// 上传文件失败触发
			onUploadError : 
				function(file, errorCode, errorMsg, errorString){ 
                                  //alert('上传文件失败!');
				},
               
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

<script type="text/javascript">
$("#list_data").datagrid({
	title : "商城楼层列表",
	nowrap : false,
	striped : true,
	border : true,
	loadMsg : '数据加载中请稍后……',
	fitColums : true,
	rownumbers : true,//行号
	singleSelect : true,//是否单选 
	idField: 'id',
	columns : [ [ {
		field : 'title',
		title : '楼层名称',
		width : 100
	}, {
		field : 'lat',
		title : '维度',
		width : 100
	} ] ],
	toolbar : [ {
		text : '保   存',
		iconCls : 'icon-add',
		handler : function() {
			//savePipePoints(id);
		}
	} ],
	onLoadSuccess : function() {
		alert("ddd");
		initData();
	}
});

function initData(){
	$.ajax({
		url : basepath+'/storeydata',
		dataType : 'json',
		success : function(json) {
			console.info(json);
			if(json && json.storeys){
				var storeys = json.storeys;
				$("#list_data").datagrid(storeys);
				/* for(var i=0;i<storeys.length;i++){
					$('#aa').accordion('add', {
						title:storeys[i].title ,
						content: $("#storeyForm").html(),
						selected: false
					});
				} */
			}
		}
	});
}	
</script>
<table id="list_data" cellspacing="0" cellpadding="0"></table>

</body>
<div id="storeyForm" class="channel-edit">
	<h4>楼层基本信息</h4>
	<form method="post" id="storeyInfo">
		<table>
			<tr>
				<td>楼层标题：</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>楼层排序：</td>
				<td><input type="text" name="ordernum" /></td>
			</tr>
			<tr>
				<td>楼层标题链接：</td>
				<td><input type="text" name="titleLine" /></td>
			</tr>
			<tr>
				<td>楼层小图标：</td>
				<td>
					<input type="text" name="icon" value="图片尺寸:宽26px高30px" onfocus="javascript:if(this.value=='图片尺寸:宽26px高30px') this.value='';" />
					<span class="uploadFiles" id="icon" onclick="uploadFiles('icon');">上传图片</span>
				</td>
			</tr>
			<tr>
				<td>标题背景色：</td>
				<td><input type="text" name="bgColor" /></td>
			</tr>
			<tr>
				<td>楼层主图片（宽：397px，高420px）：</td>
				<td><input type="text" name="mainImg" /><span class="uploadFiles" id="mainImg" onclick="uploadFiles('mainImg');">上传图片</span></td>
				<td><div>链接：</div><input type="text" name="mainImgline" /></td>
			</tr>
		</table>
		
		<h4>楼层热门类目</h4>
		<table>
			<tr>
				<td>热门类目链接：</td>
				<td><span id="addCate">添加类目</span><br /></td>
			</tr>
		</table>
		
		<h4>楼层热门品牌</h4>
		<table>
			<tr>
				<td>楼层热门品牌：</td>
				<td><div id="addBrand"><span>添加品牌</span></div></td>
			</tr>
		</table>
		
		<h4>楼层热门商品</h4>
		<table>
			<tr>
				<td>楼层热门商品（宽：198px，高210px）：</td>
				<td><div id="addGoods"><span>添加商品</span></div></td>
			</tr>
		</table>
		<input type="hidden" name="cate" id="index_storey_cate" />
		<input type="hidden" name="brand" id="index_storey_brand" />
		<input type="hidden" name="goods" id="index_storey_goods" />
	</form>
</div>