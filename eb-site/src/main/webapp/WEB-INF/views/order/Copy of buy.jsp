<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
	// 选择宝贝
	function chooseBaby() {
		// 获取当前屏幕的高度
		var clientHeight = $(document.body).height();
		var topHeight = (clientHeight - 400)/2;
		topHeight = topHeight > 0 ? topHeight : 10; 
		
		var chooseBabyDialog = $('<div/>').css('top',topHeight).dialog({
			title:'分类选择',
		    width:640,
		    height:400,
		    closed: false,
		    cache: false,
			modal : true,
		    href: '${pageContext.request.contextPath}/forward?path=baby/category',
		    buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					$("#chooseCates").html($("#cur3").html());
					$("#chooseCate").show();
					chooseBabyDialog.dialog('destroy');
					// 加载规格
					var typeId = $("#cateTypeId").val();
					if(typeId == 0 || typeId == null || typeId == "null") {
					} else {
						// 清空规格列表
						$("#spec_items").empty();
						
						//通过type_id，拿到规格
						$.ajax({
							url : '${pageContext.request.contextPath}/getSpecification',
							dataType : 'json',
							data: 'typeId=' + typeId,
							success : function(json) {
								if (json.success) {
									var data = json.data;
									for(var i = 0; i < data.length; i ++) {
										console.info(data[i]);
										var specVals = data[i].specVals;
										if(i == 0) {
											$("ul#typeList").append("<li><a href='javascript:specClick(\"tp"+ data[i].id +"\")' spec='tp"+ data[i].id +"' spec_id='"+ data[i].id +"' spec_type='"+ data[i].showType +"' spec_name='"+ data[i].title +"' class='c'>"+ data[i].alias +"</a></li>");
											if(specVals != null) {
												for(var j = 0; j < specVals.length; j++) {
													$("ul#typeItem").append("<li spec='tp"+ data[i].id +"'><input type='checkbox' id='"+ specVals[j].id +"' name='tp"+ data[i].id +"'><label class='fs10' for='"+ specVals[j].id +"'><em>"+ specVals[j].title +"</em></label></li>");
												}
											}
										} else {
											$("ul#typeList").append("<li><a href='javascript:specClick(\"tp"+ data[i].id +"\")' spec='tp"+ data[i].id +"' spec_id='"+ data[i].id +"' spec_type='"+ data[i].showType +"' spec_name='"+ data[i].title +"' class='t'>"+ data[i].alias +"</a></li>");
											if(specVals != null) {
												for(var j = 0; j < specVals.length; j++) {
													$("ul#typeItem").append("<li style='display:none;' spec='tp"+ data[i].id +"'><input type='checkbox' id='"+ specVals[j].id +"' name='tp"+ data[i].id +"'><label class='fs10' for='"+ specVals[j].id +"'><em>"+ specVals[j].title +"</em></label></li>");
												}
											}
										}
									}
								}
								// 加载成功，提示
								$.messager.show({
					                title:'提示信息',
					                msg:json.msg,
					                timeout:1000,
					                showType:'fade'
					            });
							}
						});
					}
				}
			}],
			onClose : function(){
				chooseBabyDialog.dialog('destroy');
			}
		});
	}
	
	//SKU 信息处理
	function specClick(spec) {
		//改变点击样式
		$("ul#typeList li a").removeClass('c').addClass('t');
		$("ul#typeList li a[spec='"+spec+"']").removeClass('t').addClass('c');
		//改变规格值
		$("ul#typeItem li").hide();
		$("ul#typeItem li[spec='"+spec+"']").show();
	}
	
	//SKU 全选
	var select_tmp = 1;
	function selectAll() {
		if(select_tmp == 1) {
			alert(select_tmp);
			select_tmp = 0;
		} else {
			alert(select_tmp);
			select_tmp = 1;
		}
	}
	
	// 宝贝图片上传
	$(function() {
		var phonePath = "";
		$("#uploadify").uploadify({
			debug			: false, 
			swf 			: 'resources/js/uploadify.swf',	//swf文件路径
			method			: 'post',	// 提交方式
			uploader		: '${pageContext.request.contextPath}/uploadify', // 服务器端处理该上传请求的程序(servlet, struts2-Action)
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
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
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
					$("#goods_new_images").append("<img src=\""+ data +"\" width=\"90\" height=\"90\">");
 					phonePath += '${pageContext.request.contextPath}/' + data + '|';
 					$("#picPath").val('').val(phonePath);
            	 }
             }
		});

	})
	
	// 详细信息
	KindEditor.ready(function(K) {
		var editor1 = K.create('#description', {
			uploadJson : '${pageContext.request.contextPath}/descriptionUpload',
			allowFileManager : true
		});
	});
	
	// 宝贝上传图片提示
	$(function(){
		$("#shopPhone").mouseover(function(){
			$("#shopPhoneTitle").show();
		}).mouseout(function(){
			$("#shopPhoneTitle").hide();
		});
	});
	
	// 品牌列表
	$(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/getBrands',
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i ++){
						$("#brand").append("<option class=\"brandOp\" value=\""+data[i].id+"\">"+data[i].name+"</option>");
					}
				}
			}
		});
	});
	
	//编辑会员价格
	function editPrice() {
		var shopPrice = "";
		var editPriceDialog = $('<div/>').css('top',650).dialog({
			title:'编辑会员价格',
		    width:640,
		    height:400,
		    closed: false,
		    cache: false,
			modal : true,
		    href: '${pageContext.request.contextPath}/forward?path=baby/editPrice',
		    buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					var mg_tr = $("#member-grade tr");
					for(var i = 0; i < mg_tr.length; i++) {
						if(i != 0) {
							var mg_input = $(mg_tr[i]).find("td input");
							var input_val = "";
							for(var j = 0; j < mg_input.length; j++) {
								if(j == 0) {
									input_val += $(mg_input[j]).val();
								} else {
									input_val += ',' + $(mg_input[j]).val();
								}
							}
							shopPrice += input_val + '|';
						}
					}
					$("#shopPrice").val(shopPrice);
					editPriceDialog.dialog('destroy');
				}
			}],
			onClose : function(){
				editPriceDialog.dialog('destroy');
			}
		});
	}
	
	//保存商品，提交表单
	function saveBaby() {
		$.ajax({
			url : '${pageContext.request.contextPath}/saveBaby',
			data : $("#form_saveGoods").serialize(),
			dataType : 'json',
			success : function(json) {
				
			}
		});
	}
	
</script>
<style>
#form_saveGoods input,#form_saveGoods textarea{font-size:10px;}
</style>
<div id="main" class="member-main member-main2" action="">
	<div class="title">发布宝贝</div>
	<form method="post" action="#" id="form_saveGoods" class="section">
		<div id="gEditor-Body">
			<div class="title_fb ">1. 宝贝基本信息</div>
			<div class="FormWrap" style="background:none">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="liststyle data width1" style="border:none">
					<tbody>
						<tr>
							<th><em><font color="red">*</font></em>宝贝分类：</th>
							<td>
								<div class="object-select clearfix" id="gEditor-GCat-category">
									<div class="label" rel="请选择" onclick="chooseBaby();" style="float: left;padding:0;width:77px;height:23px;"><img alt="请选择" src="resources/images/choose.png"></div>
									<div class="fs10" style="margin-left:10px; color:#666666; display:none;" id="chooseCate">您选择的分类是<span id="chooseCates"></span></div>
								</div>
								<input type="hidden" name="cateId" id="cateId" />
								<input type="hidden" name="cateName" id="cateName" />
								<input type="hidden" id="cateTypeId"/>
							</td>
						</tr>
						<tr>
							<th><em><font color="red">*</font></em>商品名称：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								id="title" name="title" required="true" maxlength="100" vtype="required" style="width:60%"></td>
						</tr>
						<tr>
							<th>商品编号：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								name="barcode" id="barcode" vtype="text"></td>
						</tr>
						<tr>
							<th>商品关键词：</th>
							<td><input type="text" name="keyWords" value=""
								class="inputstyle" maxlength="100"> <span
								class="notice-inline ">用于筛选商品，多个关键词用半角竖线"|"分开</span></td>
						</tr>

						<tr>
							<th>商品简介：</th>
							<td><textarea type="textarea" class="x-input"
									name="brief" style="resize:none;" cols="50" rows="5"
									maxth="255" id="dom_el_8bbbb42"></textarea><br />
								<span class="notice-inline">简短的商品介绍,请不要超过70个字</span></td>
						</tr>

						<tr>
							<th>商品相册：</th>
							<td>
								<div class="division pic-main">
									<div class="clearfix">
										<span class="pic-uploader">
												<span id="uploadify"></span>
												<div id="fileQueue"></div>
										</span>
										<span id="shopPhone" title=""><img
											src="resources/images/tips_help.gif"></span>
										<span id="shopPhoneTitle" class="notice-inline" style="display: none; color:#666666;">上传图片大小不能超过1MB,不能包含品牌LOGO!</span>
									</div>
									<div class="pic-area">
										<input type="hidden" name="picPath" id="picPath" value="">
										<div class="all-pics" id="goods_new_images" style="width:100%;">
										
										</div>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div id="gEditor-ginfo">
					<table class="liststyle2 width1" style="border:none">
						<tbody>
							<tr>
								<th style="text-align:right;" class="fs10 fc_black">宝贝属性：</th>
								<td>
									<table border="0" cellpadding="0" cellspacing="0" class="sx">
									</table>
								</td>
							</tr>
							<tr id="gEd2itor-GBrand">
								<th style="text-align:right;" class="fs10 fc_black">品牌：</th>
								<td>
									<select type="select" name="brand" required="true" nulloption="1" id="brand" class=" x-input-select inputstyle fs10 fc_black">
										
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					<div id="spec_items">
						<table border="0" cellpadding="0" cellspacing="0" width="100%"
							id="nospec_body" class="liststyle data" style="border:none">
							<tbody>
								<tr>
									<th width="98"><em><font color="red">*</font></em>销售价：<input type="hidden" name="shopPrice" id="shopPrice" value=""></th>
									<td>
										<input autocomplete="off" class="x-input inputstyle" key="price" name="standPrice" style="width:60px" maxlength="25" id="dom_el_8bbbb45" type="text">
										<button type="button" class="btn btn-has-icon">
											<span><span onclick="editPrice()"><i class="btn-icon">
												<img src="resources/images/btn_edit.gif" app="desktop"></i>编辑会员价格</span></span>
										</button>
									</td>
								</tr>

								<tr>
									<th>市场价：</th>
									<td><input autocomplete="off" class="x-input "
										vtype="unsigned&amp;&amp;minpirce" key="mktprice"
										name="price" maxlength="30" style="width:60px" id="dom_el_8bbbb46" type="text"></td>
								</tr>
								<tr>
									<th>货号：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										key="bn" name="tsc" maxlength="25"
										id="dom_el_8bbbb47" vtype="text"></td>
								</tr>
								<tr>
									<th>重量：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										key="weight" name="itemWeight"
										style="width:60px" maxlength="25" id="dom_el_8bbbb48"
										vtype="unsigned"><span class="notice-inline"> 千克(kg)</span></td>
								</tr>
								<tr>
									<th><em><font color="red">*</font></em>库存：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										vtype="required&amp;&amp;unsigned" id="p_store" key="store"
										name="withHoldQuantity" style="width:60px"
										maxlength="25"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- 商品规格 -->
			<div id="sepc-panel" style="clear:both;">
			    <div class="specification">
			        <div class="tt fs10"><strong>商品规格</strong>点击选择当前商品需要的规格。</div>
			        <div class="td clearfix">
			            <div class="type">
			                <ul id="typeList">
			                </ul>
			            </div>
			            <div class="list">
			                <div class="list-wrap">
			                    <div class="selectAll"><input type="checkbox" name="selectAll" id="selectAll" onclick="selectAll();"><span onclick="selectAll();"><label for="selectAll" class="fs10">全选</label></span></div>
			                    <div class="typeItem clearfix">
			                        <ul id="typeItem">
			                        </ul>
			                    </div>
			                    <div class="item">
			                        <table id="typeDetailView" width="100%">
			                        	
			                        </table>
			                    </div>
			                </div>
			                <div class="table-action" id="create-good" style="border-top-width: 0px; display: none;">
			                    <button type="button" id="createAllGoods" class="btn btn-primary"><span><span>生成所有货品</span></span></button>
			                    <button type="button" class="btn btn-primary" id="addOneGood"><span><span>添加一个货品</span></span></button>
			                </div>
			            </div>
			            <div class="item-wrap" style="display:none;">
			                <div class="item">共<b id="goodsNum">0</b>件货品</div>
			                <table cellspacing="0" cellpadding="0" border="0" class="gridlist gridlist2" id="goods-table" width="100%">
			                    <thead id="productNodeTitle">
			                        <tr class="fs10">
			                            <th class="textcenter" width="25">上架</th>
			                            <th class="textcenter" width="150">规格值</th>
			                            <th class="textcenter" width="100">货号</th>
			                            <th class="textcenter" width="70"><em><font color="red">*</font></em>库存</th>
			                            <th class="textcenter" width="175"><em><font color="red">*</font></em>销售价</th>
			                            <th class="textcenter" width="70">成本价</th>
			                            <th class="textcenter" width="70">市场价</th>
			                            <th class="textcenter" width="50">重量</th>
			                            <th class="textcenter" width="50">货位</th>
			                            <th class="textcenter" width="25">操作</th>
			                        </tr>
			                    </thead>
			                </table>
			            </div>
			        </div>
			    </div>
			
			    <input type="hidden" name="goods[product]" id="product_datas">
			</div>
			<div class="FormWrap" style="background:none">
				<table border="0" cellpadding="0" cellspacing="0" class="liststyle tdright" style="border:none">
					<tbody>
						<tr>
							<th class="fs10 fc_black">运费模板：</th>
							<td>
								<div id="ipt_dfc1a4" class="clearfix">
									<div id="dfc1a4" class="object-select clearfix"
										style="display:inline-block;*zoom:1;">
										<div class="object-select clearfix" id="gEditor-GCat-category">
											<div class="label" rel="请选择" onclick="" style="float: left;padding:0;width:77px;height:23px;"><img alt="请选择" src="resources/images/choose.png"></div>
										</div>
										<div class="handle">&nbsp;</div>
										<input type="hidden" name="gdlytype" id="list_datas" vtype="" value="">
									</div>
									<div class="gridlist rows-body" id="handle_dfc1a4" style="display:none;"></div>
								</div>
							</td>
						</tr>
						<tr>
							<th class="fs10 fc_black">是否包邮：</th>
							<td>
								<input type="radio" name="goods[freight_bear]" checked="checked" value="member"><span class="fs10 fc_black">否</span> 
								<input type="radio" name="goods[freight_bear]" value="business"><span class="fs10 fc_black">是</span>
							</td>
						</tr>
						<!--tag_foreign_freeshipping-->
						<tr>
							<th class="fs10 fc_black">计量单位：</th>
							<td>
								<input autocomplete="off" class="x-input " type="text"
										name="goods[unit]" maxlength="25" style="width:60px"
										id="dom_el_8bbbb410" vtype="text">
							</td>
						</tr>
						<tr>
							<th class="fs10 fc_black">立即上架：</th>
							<td><input type="radio" name="goods[status]" checked="checked" value="true"><span class="fs10 fc_black">是</span>
								<input type="radio" name="goods[status]" value="false"><span class="fs10 fc_black">否</span>
							</td>
						</tr>

						<tr>
							<th class="fs10 fc_black">积分：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								value="0.5" name="goods[gain_score]" maxlength="25"
								vtype="score" id="gain_score">% <input type="hidden"
								name="goods[score_setting]" value="percent"> <span class="fs10 fc_black">（请填写与商品销售价的比例，运营商设置范围为0.5%~30%）</span>
							</td>
						</tr>
						<tr>
							<th class="fs10 fc_black">自定义分类：</th>
							<td>
								<div id="ipt_b76416" class="clearfix">
									<div id="b76416" class="object-select clearfix" style="display:inline-block;*zoom:1;">
										<div class="object-select clearfix" id="gEditor-GCat-category">
											<div class="label" rel="请选择" onclick="" style="float: left;padding:0;width:77px;height:23px;">
												<img alt="请选择" src="resources/images/choose.png">
											</div>
										</div>
										<div class="handle">&nbsp;</div>
										<input type="hidden" name="customcatid" id="list_datas" vtype="" value="">
									</div>
									<div class="gridlist rows-body" id="handle_b76416" style="display:none;"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<div class="title_fb">2. 配件</div>
			<div class="tableform">
				<button type="button" class="btn btn-has-icon">
					<span><span>
					<i class="btn-icon">
						<img src="resources/images/btn_add.gif"></i>添加配件</span></span>
				</button>
				<div class="adjs" id="goods-adj"></div>
			</div>
			<div>
				<div class="title_fb">
					3. <em><font color="red">*</font></em>详细介绍
				</div>
				<div class="tableform">
					<div>
						<textarea name="desc" id="description" style="width:800px;height:400px;visibility:hidden;">请输入商品的详细描述</textarea>
					</div>
				</div>
			</div>
			<div>
				<div class="title_fb">4. 相关商品</div>
				<div class="tableform">
					<div id="ipt_5bc356" class="clearfix">
						<div id="5bc356" class="object-select clearfix" style="display:inline-block;*zoom:1;">
							<div class="object-select clearfix" id="gEditor-GCat-category">
								<div class="label" rel="请选择" onclick="" style="float: left;padding:0;width:77px;height:23px;">
									<img alt="请选择" src="resources/images/choose.png">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="member-editwrap2">
				<button class="btn submit-btn" type="submit" onclick="saveBaby();" rel="_request">
					<span><span>保存</span></span>
				</button>
			</div>
		</div>
	</form>
</div>