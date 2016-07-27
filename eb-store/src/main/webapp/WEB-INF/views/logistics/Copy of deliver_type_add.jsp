<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
//保存商品，提交表单
function saveBaby() {
	var staval =$('input[name="deliverTypestatus"]:checked').val();
	$("#status").val(staval);
	
	 $.ajax({
		url : '${pageContext.request.contextPath}/product/productEditDo',
		data : "product="+$("#product_editForm").serialize()+"&skuArray="+ skuArray,
		type : 'post',
		dataType : 'json',
		success : function(json) {
			$.messager.show({
                title:'提示信息',
                msg:json.msg,
                timeout:1000,
                showType:'fade'
            });
		}
	}); 
}
</script>
<style>
#form_saveGoods input,#form_saveGoods textarea{font-size:10px;}
</style>
<div id="main" class="member-main member-main2" action="">
	<div class="title">添加配送方式</div>
	<form method="post" action="#" id="deliverType_addForm" class="section">
		
		<div id="gEditor-Body">
			<div class="title_fb ">1. 宝贝基本信息</div>
			<div class="FormWrap" style="background:none">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="liststyle data width1" style="border:none">
					<tbody>
						<tr>
							<th><em><font color="red">*</font></em>宝贝分类：</th>
							<td>
								<input type="radio"  name="deliverTypestatus" checked="checked" value="1"><span class="fs10 fc_black">是</span>
								<input type="radio"  name="deliverTypestatus" value="0"><span class="fs10 fc_black">否</span>
								<input type="text" name="status" id="status" value="0">
							</td>
						</tr>
						<tr>
							<th><em><font color="red">*</font></em>商品名称：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								id="title" name="title" required="true" maxlength="100" vtype="required" style="width:60%" value="${product.title}"></td>
						</tr>
						<tr>
							<th>商品编号：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								name="tsc" id="tsc" vtype="text" value="${product.barcode}" ></td>
						</tr>
						
						<tr>
							<th>商品id：</th>
							<td><input autocomplete="off" class="x-input " type="text"
								name="pId" id="pId" vtype="text" value="${product.pId}" >
								<input autocomplete="off" class="x-input " type="text"
								name="typeId" id="typeId" vtype="text" value="${cate.id}" ></td>
						</tr>
						<tr>
							<th>商品关键词：</th>
							<td><input type="text" name="keyWords" 
								class="inputstyle" maxlength="100" value="${product.keyWords}"> <span
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
											src="${pageContext.request.contextPath}/resources/images/tips_help.gif"></span>
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
									<th width="98"><em><font color="red">*</font></em>销售价：<input type="hidden" name="price" id="shopPrice" ></th>
									<td>
										<input autocomplete="off" class="x-input inputstyle" key="price" name="standPrice" style="width:60px" maxlength="25" id="dom_el_8bbbb45" type="text" value="${product.price}">
										<button type="button" class="btn btn-has-icon">
											<span><span onclick="editPrice()"><i class="btn-icon">
												<img src="${pageContext.request.contextPath}/resources/images/btn_edit.gif" app="desktop"></i>编辑会员价格</span></span>
										</button>
									</td>
								</tr>

								<tr>
									<th>市场价：</th>
									<td><input autocomplete="off" class="x-input "
										vtype="unsigned&amp;&amp;minpirce" key="mktprice"
										name="marketPrice" maxlength="30" style="width:60px" id="dom_el_8bbbb46" type="text" value="${product.marketPrice}"></td>
								</tr>
								<tr>
									<th>货号：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										key="bn" name="barcode" maxlength="25"
										id="dom_el_8bbbb47" vtype="text" value="${product.price}"></td>
								</tr>
								<tr>
									<th>重量：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										key="weight" name="itemWeight"
										style="width:60px" maxlength="25" id="dom_el_8bbbb48"
										vtype="unsigned" value="${product.itemWeight}"><span class="notice-inline"> 千克(kg)</span></td>
								</tr>
								<tr>
									<th><em><font color="red">*</font></em>库存：</th>
									<td><input autocomplete="off" class="x-input " type="text"
										vtype="required&amp;&amp;unsigned" id="p_store" key="store"
										name="withHoldQuantity" style="width:60px"
										maxlength="25" value="${product.storenum}"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- 商品规格 -->
			<div id="sepc-panel" style="clear:both;display:none;">
			    <div class="specification">
			        <div class="tt fs10"><strong>商品规格</strong>点击选择当前商品需要的规格。</div>
			        <div class="td clearfix">
			            <div class="type">
			                <ul id="typeList">
			                </ul>
			            </div>
			            <div class="list">
			                <div class="list-wrap">
			                    <div class="checkAll fs10"><label for="" class="fs10">商品规格列表</label><!-- <span><input type="checkbox" name="selectAll" id="selectAll" onchange="changeSelectAll();" /><label for="selectAll" class="fs10">全选</label></span> --></div>
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
			                    <button type="button" id="createAllGoods" class="btn btn-primary" onclick="createGoods();"><span><span>生成所有货品</span></span></button>
			                    <!-- <button type="button" class="btn btn-primary" id="addOneGood"><span><span>添加一个货品</span></span></button> -->
			                </div>
			            </div>
			            <div class="item-wrap" id="goods_type_item" style="display:none;">
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
											<div class="label" rel="请选择" onclick="chooseDeliverType();" style="float: left;padding:0;width:77px;height:23px;"><img alt="请选择" src="resources/images/choose.png"></div>
											<div class="label fs10" id="deliverTshow" style="display:none;">您选择的运费模板是:<span id="deliverTypeName"></span></div>
										</div>
										<input type="hidden" name="postage" id="deliverTypeId" vtype="" value="">
										<div class="handle">&nbsp;</div>
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
							<td><input type="radio"  name="goodsstatus" checked="checked" value="1"><span class="fs10 fc_black">是</span>
								<input type="radio"  name="goodsstatus" value="0"><span class="fs10 fc_black">否</span>
								<input type="hidden" name="status" id="status" value="1">
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
									<img alt="请选择" src="${pageContext.request.contextPath}/resources/images/choose.png">
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