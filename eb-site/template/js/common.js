 function initSiteCates(){
	 //var index_nav_ = eval(json.data);
	 
    	$.ajax({
    		url : domain+'/allcates',
    		dataType : 'json',
    		type : 'GET',
    		//contentType:'application/json;charset=UTF-8',
    		success : function(json) {
    			if (json.success){
    				var index_nav_ = eval(json.data);
    				if(index_nav_.length > 0) {
    					var index_nav_html_ = "";
    					// 遍历一级
    					for(var i = 0; i < index_nav_.length; i++) {
    						if(i == 0) {
    							index_nav_html_ += "<div class='item fore'>";
    						} else {
    							index_nav_html_ += "<div class='item'>";
    						}
    						index_nav_html_ += "<span><h3><a href=''>"+index_nav_[i].title+"</a></h3><i>&gt;</i></span><div class='i-mc'>"+
    										   "<div class='close' onclick=\"$(this).parent().parent().removeClass('hover')\"></div><div class='subitem'>";
    						var index_nav_html2_ = index_nav_[i].cates;
    						if(index_nav_html2_ != null) {
    							// 遍历二级
    							for(var j = 0; j < index_nav_html2_.length; j ++) {
    								if(j == 0) {
    									index_nav_html_ += "<dl class='fore'>";
    								} else {
    									index_nav_html_ += "<dl>";
    								}
    								index_nav_html_ += "<dt><a href=\""+domain+"/list-"+index_nav_html2_[j].id+".html\">"+index_nav_html2_[j].title+"</a></dt><dd>";
    								var index_nav_html3_ = index_nav_html2_[j].cates;
    								if(index_nav_html3_ != null) {
    									// 遍历三级
    									for(var k = 0; k < index_nav_html3_.length; k ++) {
    										index_nav_html_ += "<em><a href=\""+domain+"/list-"+index_nav_html3_[k].id+".html\">"+index_nav_html3_[k].title+"</a></em>";
    									}
    								}
    								index_nav_html_ += "</dd></dl>";
    							}
    						}
    						index_nav_html_ += "</div></div></div>";
    					}
    					$("#index_nav_list").append(index_nav_html_);
    					// 类目事件
    					$(".allsort").hoverForIE6({
    						current : "allsorthover",
    						delay : 200
    					});
    					$(".allsort .item").hoverForIE6({
    						delay : 150
    					});
    				}
    			}
    		}
    	}); 
	 
	 	/** 首页导航 **/
	 	//var jsonData = '[{"cates":[{"cates":[{"id":"1010","title":"测试类目1010"},{"id":"1011","title":"类目测试1011"}],"id":"101","title":"类目测试100"},{"cates":[{"id":"1012","title":"类目测试1012"},{"id":"1013","title":"类目测试1013"},{"id":"1014","title":"类目测试1014"}],"id":"102","title":"类目测试101"},{"id":"103","title":"类目测试102"},{"id":"104","title":"类目测试103"},{"id":"105","title":"类目测试200"},{"id":"106","title":"类目测试202"}],"id":"10","title":"家用电器"},{"id":"11","title":"手机数码"},{"id":"12","title":"电脑办公"},{"id":"13","title":"家具家装"},{"id":"14","title":"男装女装"},{"id":"15","title":"个性化妆"},{"id":"16","title":"鞋包"},{"id":"17","title":"运动户外"},{"id":"19","title":"食品饮料"},{"id":"20","title":"营养保健"},{"id":"21","title":"图书音像"},{"id":"22","title":"票务充值"}]';
		//var index_nav_ = eval(jsonData);
		//console.info(index_nav_);
		
    }
 
function initShopNav(){
	$.ajax({
		url : domain+'/navlist',
		dataType : 'json',
		type : 'GET',
		success : function(json) {
			var navhtml = "";
			if (json.success){
				for(var i=0;i<json.data;i++){
					navhtml = navhtml+"<li class=\"width-1\"><a href=\""+json.data[i].href+"\" class=\"nava\">"+json.data[i].title+"</a></li>"
				}
			}
			$(".nava").remove();
			$("#rootnav").append(navhtml);
		}
});
}
 
 
 function initShopCart(){
 	$.ajax({
			url : domain+'/cart/getCartItems',
			dataType : 'json',
			type : 'POST',
			success : function(data) {
				$("#top_cart_num").text(data.totalnum);
				$("#right_cart_num").text(data.totalnum);
				$("#J-count").text(data.totalnum);
				$("#J-total").text("￥"+data.totalfee);
				if (!data.items){
					return;
				}
				var R_carthtml="";
				for (var i=0;i<data.items.length;i++){
					R_carthtml=R_carthtml+"<div class='jdm-tbar-cart-item' data-type='sku'>"
								  +"<div class='jtc-item-goods'>"
								  +"		<span class=\"p-img\"> " 
								  +"        <a href=\""+domain+"/item-"+data.items[i].productid+".html\" target=\"_blank\">"
								  +"		<img src=\"\" width=\"50\" height=\"50\" alt=\""+data.items[i].title+"\">"
								  +"		</a>"
								  +"		</span>"
								  +"		<div class=\"p-name\">"
								  +"			<a href=\""+domain+"/item-"+data.items[i].productid+".html\" title=\"\" target=\"_blank\">"+data.items[i].title+"</a>"
							      +"		</div>"
							      +"		<div class=\"p-price\">"
							      +"			<strong>"+data.items[i].price+"</strong>×"+data.items[i].num+""
							      +"		</div>"
							      +"		<a href=\"#none\" class=\"p-del J-del\" data-cid=\"1518576197\" data-action=\"RemoveProduct\">删除</a>"
							      +" 	</div>"
							      +" </div>";
				}
				$("#jdm-tbar-cart-list").empty();
				$("#jdm-tbar-cart-list").html(R_carthtml);
			}
	});
 }
 
 
 function showShopCart(){
 	$(".mui-mbar-tab.mui-mbar-tab-cart").find(".mui-mbar-cart-tip").show().animate({
             right: "35px",
             opacity: "1"
         },
    300);
 }