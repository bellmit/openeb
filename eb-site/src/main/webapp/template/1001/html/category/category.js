//查询条件选择项列表
function initselect() {
	//初始化品牌条件
	initParamBrand();
	//初始化属性条件
	initParamAttr();
	//初始化已选条件
	initcheckedSet();
}


//初始化品牌
function initParamBrand(){
	var J_selectorBrand = $("#J_selectorBrand");
	if (null != brands && brands.length > 0) {
		var brandHtml = "<div class=\"sl-wrap\"> <div class=\"sl-key\"><span>品牌：</span></div><div class=\"sl-value\"><div class=\"clr\"></div><div class=\"sl-v-list\"><ul class=\"J_valueList v-fixed\">  ";
		for (var i = 0; i < brands.length; i++) {
			if (param_brand) {
				brandHtml = brandHtml + "<li id=\"brand-" + brands[i].id+ "\" style=\"display: block;\">"
				+ "<a href=\"list-" + cateid + ".html?keyword="+ param_keyword +"&brand="+brands[i].id+"-"+param_brand+"&prop="+param_prop+"&sort="+param_sort+"\""
				+ " title=\"" + brands[i].title
				+ "\" rel=\"nofollow\"><i></i>" + brands[i].title + "</a>"
				+ "</li> ";
			}else{
				brandHtml = brandHtml + "<li id=\"brand-" + brands[i].id+ "\" style=\"display: block;\">"
				+ "<a href=\"list-" + cateid + ".html?keyword="+ param_keyword +"&brand="+brands[i].id+"&prop="+param_prop+"&sort="+param_sort+"\""
				+ " title=\"" + brands[i].title
				+ "\" rel=\"nofollow\"><i></i>" + brands[i].title + "</a>"
				+ "</li> ";
			}
		}
		brandHtml = brandHtml
				+ "</ul> </div> <div style=\"display: none;\" class=\"sl-b-selected J_brandSelected\"> <span class=\"sl-b-key\">已选条件：</span> <ul class=\"sl-v-list brand-selected\"></ul> </div> <div class=\"sl-btns\"> <a href=\"javascript:;\" class=\"btn btn-primary J_btnsConfirm\">确定</a> <a href=\"javascript:;\" class=\"btn btn-default J_btnsCancel\">取消</a> </div> </div> <div class=\"sl-ext\"> <a href=\"javascript:;\" style=\"visibility: visible;\" class=\"sl-e-more J_extMore\">更多<i></i></a> <a href=\"javascript:;\" class=\"sl-e-multiple J_extMultiple\">多选<i></i></a> </div> </div> ";
	}
	
	J_selectorBrand.empty();
	J_selectorBrand.html(brandHtml);
}

//初始化属性条件
function initParamAttr(){
	var attrHtml = "";
	if (null != attrs && attrs.length > 0) {
		for (var i = 0; i < attrs.length; i++) {
			if (i < 3) {
				attrHtml = attrHtml
						+ "<div style=\"display: block;\" class=\"J_selectorLine s-line J_selectorFold\">"
			} else {
				attrHtml = attrHtml
						+ "<div style=\"display: none;\" class=\"J_selectorLine s-line J_selectorFold hide\">"
			}
			attrHtml = attrHtml + "<div class=\"sl-wrap extend\">"
					+ "<div class=\"sl-key\"> <span>" + attrs[i].title
					+ "：</span> </div> " + "<div class=\"sl-value\"> "
					+ "<div class=\"sl-v-list\"> "
					+ "<ul class=\"J_valueList\"> ";
			for (var j = 0; j < attrs[i].vals.length; j++) {
				if (param_prop) {
					attrHtml = attrHtml
							+ "<li style=\"display: block;\">"
							+ "<a href=\"list-" + cateid + ".html?keyword="+ param_keyword +"&brand="+param_brand+"&prop="+param_prop+ ":"+ attrs[i].vals[j].id+"&sort="+param_sort+"\" rel=\"nofollow\"><i></i>"
							+ attrs[i].vals[j].title + "</a></li> ";
				} else {
					attrHtml = attrHtml
							+ "<li style=\"display: block;\">"
							+ "<a href=\"list-" + cateid + ".html?keyword="+ param_keyword +"&brand="+param_brand+"&prop="+ attrs[i].vals[j].id+"&sort="+param_sort+"\" rel=\"nofollow\"><i></i>"
							+ attrs[i].vals[j].title + "</a></li> ";
				}
			}
			attrHtml = attrHtml + "</ul>";
			attrHtml = attrHtml+ "</div>"
				+ " <div class=\"sl-btns\"> <a href=\"javascript:;\" class=\"btn btn-primary J_btnsConfirm\">确定</a> <a href=\"javascript:;\" class=\"btn btn-default J_btnsCancel\">取消</a> </div> </div>"
				+ " <div class=\"sl-ext\"> <a href=\"javascript:;\"  class=\"sl-e-more J_extMore opened\">更多<i></i></a> <a href=\"javascript:;\" class=\"sl-e-multiple J_extMultiple\">多选<i></i></a> </div>"
				+ " </div> </div> </div> ";
		}
	}
	$("#J_selectorAttr").append(attrHtml);
}


//初始化已选条件
function initcheckedSet(){
	var param_checked = $("#param_checked");
	if (checked_brand){
		param_checked.append("<a href=\"list-"+ cateid + ".html?keyword="+ param_keyword +"&brand="+param_brand+"&prop="+param_prop+"&sort="+param_sort+" title=\"11-15W、15W以上\" class=\"ss-item\"><b>品牌：</b><em>"+checked_brand.title+"</em><i></i></a>");
	}
	
	if (checked_prop){
		param_checked.append("<a href=\"#\" title=\"11-15W、15W以上\" class=\"ss-item\"><b>功率：</b><em>11-15W、15W以上</em><i></i></a>");
	}
}

function queryGoodsList(page) {
	$.ajax({
			url : domain + '/list-'+cateid,
			dataType : 'json',
			data : 'rows='+pagesize+'&page='+page+"&keyword="+param_keyword+"&brand="+param_brand+"&prop="+param_prop+"&sort="+param_sort,
			type : 'GET',
			success : function(goods) {
				if (goods) {
					var plisthtml = "<ul class=\"list-h clearfix\">";
					for (var i = 0; i < goods.length; i++) {
							plisthtml = plisthtml
									+ "<li class=\"gl-item\">"
									+ "<div class=\"p-img\"><a target=\"_blank\" href=\""+domain+"/item-"
									+ goods[i].productid
									+ ".html\" title=\"\"> <img width=\"160\" height=\"160\" data-img=\"1\" src=\""+goods[i].picurl+"\" class=\"err-product\"></a><div></div></div>"
									+ "<div class=\"p-name\"><a target=\"_blank\" href=\""+domain+"/item-"
									+ goods[i].productid
									+ ".html\" title=\"\"> <span class=\"p-promo-tag1\"> <b class=\"text\">推荐&gt;&gt;</b><b class=\"arrow\"></b></span>"
									+ goods[i].title
									+ "<font class=\"adwords\">"
									+ goods[i].title
									+ "</font></a></div>"
									+ "<div class=\"p-price\"><i>定价：</i> <strong class=\""
									+ goods[i].productid
									+ "\" done=\"1\">￥"
									+ goods[i].price
									+ "</strong> <span class=\"discount\">（8.2折）</span><span id=\"\"></span></div>"
									+ "<div class=\"p-market\">市场定价：<del>￥"
									+ goods[i].price
									+ "</del></div>"
									+ "<div class=\"extra\"><span class=\"star\"><span class=\"star-white\"><span class=\"star-yellow h5\">&nbsp;</span></span></span> <a id=\"comment-11111117\"  target=\"_blank\" href=\"#comment\">已有0人评价</a> </div>"
									+ "<div class=\"p-summary\" done=\"1\"> <span> "
									+ goods[i].title
									+ "...</span><a href=\"\" target=\"_blank\" >更多&gt;</a> </div>"
									+ "<div class=\"p-shopnum\"></div>"
									+ "</li>";
						}
						plisthtml = plisthtml + "</ul>";
					}
					$("#plist").empty();
					$("#plist").html(plisthtml);
				}
			});
}