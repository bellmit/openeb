function initselect() {
	var brands = searchResult.brand_data;
	var attrs = searchResult.attr_data;
	if (null != brands && brands.length > 0) {
		var brandHtml = "<div class=\"sl-wrap\"> <div class=\"sl-key\"><span>品牌：</span></div><div class=\"sl-value\"><div class=\"clr\"></div><div class=\"sl-v-list\"><ul class=\"J_valueList v-fixed\">  ";
		for (var i = 0; i < brands.length; i++) {
			brandHtml = brandHtml + "<li id=\"brand-" + brands[i].id
					+ "\" style=\"display: block;\">"
					+ "<a href=\"#\" title=\"" + brands[i].title
					+ "\" rel=\"nofollow\"><i></i>" + brands[i].title + "</a>"
					+ "</li> ";
		}
		brandHtml = brandHtml
				+ "</ul> </div> <div style=\"display: none;\" class=\"sl-b-selected J_brandSelected\"> <span class=\"sl-b-key\">已选条件：</span> <ul class=\"sl-v-list brand-selected\"></ul> </div> <div class=\"sl-btns\"> <a href=\"javascript:;\" class=\"btn btn-primary J_btnsConfirm\">确定</a> <a href=\"javascript:;\" class=\"btn btn-default J_btnsCancel\">取消</a> </div> </div> <div class=\"sl-ext\"> <a href=\"javascript:;\" style=\"visibility: visible;\" class=\"sl-e-more J_extMore\">更多<i></i></a> <a href=\"javascript:;\" class=\"sl-e-multiple J_extMultiple\">多选<i></i></a> </div> </div> ";
		$("#J_selectorBrand").empty();
		$("#J_selectorBrand").html(brandHtml);
	}

	if (null != attrs && attrs.length > 0) {
		var attrHtml = "";
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
			// console.info(attrs[i].vals);
			for (var j = 0; j < attrs[i].vals.length; j++) {
				// alert(attrs[i].vals[j].title);
				attrHtml = attrHtml
						+ "<li style=\"display: block;\"><a href=\"#\" rel=\"nofollow\"><i></i>"
						+ attrs[i].vals[j].title + "</a></li> ";
			}
			if (!attrs[i].vals) {

			}
			attrHtml = attrHtml + "</ul>";
			attrHtml = attrHtml
					+ "</div>"
					+ " <div class=\"sl-btns\"> <a href=\"javascript:;\" class=\"btn btn-primary J_btnsConfirm\">确定</a> <a href=\"javascript:;\" class=\"btn btn-default J_btnsCancel\">取消</a> </div> </div>"
					+ " <div class=\"sl-ext\"> <a href=\"javascript:;\"  class=\"sl-e-more J_extMore opened\">更多<i></i></a> <a href=\"javascript:;\" class=\"sl-e-multiple J_extMultiple\">多选<i></i></a> </div>"
					+ " </div> </div> </div>  ";
		}
		$("#J_selectorAttr").append(attrHtml);
	}
}

function queryGoodsList(page) {
	$
			.ajax({
				url : domain + '/searchlist?rows=32&page='+page+"&keyword="+keyword,
				dataType : 'json',
				//data : 'page=' + page+"&keyword=",
				type : 'GET',
				success : function(goods) {
					if (goods) {
						var plisthtml = "<ul class=\"list-h clearfix\">";
						for (var i = 0; i < goods.length; i++) {
							plisthtml = plisthtml
									+ "<li class=\"gl-item\">"
									+ "<div class=\"p-img\"><a target=\"_blank\" href=\""+domain+"/item-"
									+ goods[i].productid
									+ ".html\" onclick=\"searchlog()\" title=\"\"> <img width=\"160\" height=\"160\" data-img=\"1\" src=\""+goods[i].picurl+"\" class=\"err-product\"></a><div></div></div>"
									+ "<div class=\"p-name\"><a target=\"_blank\" href=\""+domain+"/item-"
									+ goods[i].productid
									+ ".html\" onclick=\"searchlog()\" title=\"\"> <span class=\"p-promo-tag1\"> <b class=\"text\">推荐&gt;&gt;</b><b class=\"arrow\"></b></span>"
									+ goods[i].title
									+ "<font class=\"adwords\" id=\""
									+ goods[i].productid
									+ "\"></font></a></div>"
									+ "<div class=\"p-info\"></div>"
									+ "<div class=\"p-price\"><i>价格：</i> <strong class=\""
									+ goods[i].productid
									+ "\" data-price=\""
									+ goods[i].price
									+ "\" done=\"1\">￥"
									+ goods[i].price
									+ "</strong> <span class=\"discount\"></span><span id=\"p"
									+ goods[i].productid
									+ "\"></span></div>"
									+ "<div class=\"p-market\">市场价：<del>￥"
									+ goods[i].price
									+ "</del></div>"
									+ "<div class=\"stocklist\"><span class=\"st33\">甘肃有货</span></div>"
									+ "<div class=\"service\"></div>"
									+ "<div class=\"extra\"><span class=\"star\"><span class=\"star-white\"><span class=\"star-yellow h5\">&nbsp;</span></span></span> <a id=\"comment-"
									+ goods[i].productid
									+ "\" onclick=\"searchlog()\" target=\"_blank\" href=\""+domain+"/item-"
									+ goods[i].productid
									+ ".html#comment\">已有0人评价</a> </div>"
									+ "<div class=\"btns\"><a data-stock-val=\"1\" data-disable-notice=\"0\" href=\"\" target=\"_blank\" class=\"btn-buy\" onclick=\"searchlog()\">关注</a> </div>"
									+ "<div class=\"p-shopnum\"></div>"
									+ "</li>";
						}
						plisthtml = plisthtml + "</ul>";
						$("#plist").empty();
						$("#plist").html(plisthtml);
					}
				}
			});
}