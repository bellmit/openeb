 function initSiteCates(){
    	$.ajax({
    		url : domain+'/allcates',
    		dataType : 'json',
    		type : 'GET',
    		success : function(json) {
    			console.info(json);
    			if (json){
    				var index_nav_ = json;
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
    						var index_nav_html2_ = index_nav_[i].items;
    						if(index_nav_html2_ != null) {
    							// 遍历二级
    							for(var j = 0; j < index_nav_html2_.length; j ++) {
    								if(j == 0) {
    									index_nav_html_ += "<dl class='fore'>";
    								} else {
    									index_nav_html_ += "<dl>";
    								}
    								index_nav_html_ += "<dt><a href=\""+domain+"/list-"+index_nav_html2_[j].id+".html\">"+index_nav_html2_[j].title+"</a></dt><dd>";
    								var index_nav_html3_ = index_nav_html2_[j].items;
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
				
					var arr = new Array();
					arr = data.items[i].id.split("_");
					
					var pid = arr[0];
					var skuid= arr[1];

					R_carthtml=R_carthtml+"<div class='jdm-tbar-cart-item' data-type='sku' id=\"Jcart_div_"+data.items[i].id+"\">"
								  +"<div class='jtc-item-goods'>"
								  +"		<span class=\"p-img\"> " 
								  +"        <a href=\""+domain+"/item-"+data.items[i].productid+".html\" target=\"_blank\">"
								  +"		<img src=\""+data.items[i].purl+"\" width=\"50\" height=\"50\" alt=\""+data.items[i].title+"\">"
								  +"		</a>"
								  +"		</span>"
								  +"		<div class=\"p-name\">"
								  +"			<a href=\""+domain+"/item-"+data.items[i].productid+".html\" title=\"\" target=\"_blank\">"+data.items[i].title+"</a>"
							      +"		</div>"
							      +"		<div class=\"p-price\">"
							      +"			<strong>"+data.items[i].price+"</strong>×"+data.items[i].num+""
							      +"		</div>"
								  +"		<div onclick=\"deleteCart("+pid+","+skuid+")\">"
							      +"		<a  class=\"p-del J-del\" data-cid=\"1518576197\" onclick=\"deleteCart("+pid+","+skuid+")\" style=\"cursor: pointer;\"  data-action=\"RemoveProduct\" >删除</a>"
							      +"		</div>"
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
 //删除购物车
function deleteCart(pid,skuid) {
	$.ajax({
		url : domain+'/cart/delCart',
		data : {'pid':pid,'skuid':skuid},
		dataType : 'json',
		success : function(json) {
			if(json.success) {
				initShopCart();
				//$("Jcart_div_"+pid+"_"+skuid).remove();
			}
		}
	});
}