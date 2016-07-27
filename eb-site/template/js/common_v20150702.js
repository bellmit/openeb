 function initSiteCates(){
    	$.ajax({
    		url : domain+'/allcates',
    		dataType : 'json',
    		type : 'GET',
    		//contentType:'application/json;charset=UTF-8',
    		success : function(json) {
    			if (json.success){
    				/** 首页导航 **/
    				var index_nav_ = eval(json.data);
    				console.info(json.data);
    				if(index_nav_.length > 0) {
    					var index_nav_html_ = "";
    					var sub_nav_html_ = "";
    					// 遍历一级
    					for(var i = 0; i < index_nav_.length; i++) {
    						if(i == 0) {
    							index_nav_html_ += "<div class='item fore' cateid='"+index_nav_[i].id+"'>";
    						} else {
    							index_nav_html_ += "<div class='item' cateid='"+index_nav_[i].id+"'>";
    						}
    						index_nav_html_ += "<h3><a href=''>"+index_nav_[i].title+"</a></h3><i>&gt;</i>"
    						+"</div></div>";
    						//+"<div class='subnav-layer'>"
    						sub_nav_html_ = sub_nav_html_+"<div class='item-sub' id='subcategory-"+index_nav_[i].id+"'>"
    						+"<div class='item-promotions'></div>"
    						+"<div class='item-item-brands'></div>"
    						+"<div class='subitems'>";
    						var index_nav_html2_ = index_nav_[i].cates;
    						if(index_nav_html2_ != null) {
    							// 遍历一级
    							for(var j = 0; j < index_nav_html2_.length; j ++) {
    								if(j == 0) {
    									sub_nav_html_ += "<dl class='fore'>";
    								} else {
    									sub_nav_html_ += "<dl>";
    								}
    								sub_nav_html_ += "<dt><a href=\""+domain+"/list-"+index_nav_html2_[j].id+".html\" target=\"_blank\">"+index_nav_html2_[j].title+"<i>&gt;</i></a></dt>"
    								+"<dd>";
    								var index_nav_html3_ = index_nav_html2_[j].cates;
    								if(index_nav_html3_ != null) {
    									for(var k = 0; k < index_nav_html3_.length; k ++) {
    										sub_nav_html_ += "<a href=\""+domain+"/list-"+index_nav_html3_[k].id+".html\">"+index_nav_html3_[k].title+"</a>";
    									}
    								}
    								sub_nav_html_ += "</dd></dl>";
    							}
    						}
    						//index_nav_html_ += "</div></div></div></div>";
    						sub_nav_html_+="</div></div>";
    					}
    					$("#root_nav_list").html(index_nav_html_);
    					$("#sub_nav_list").html(sub_nav_html_);
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
			success : function(json) {
				$("#shopcart_count").text(json.totalnum);
				$("#shopcart_num").text(json.totalnum);
			}
	});
 }
 
 function showShopCart(){
 	$(".mui-mbar-tab.mui-mbar-tab-cart").find(".mui-mbar-tab-tip").show().animate({
             right: "35px",
             opacity: "1"
         },
         300);
 }