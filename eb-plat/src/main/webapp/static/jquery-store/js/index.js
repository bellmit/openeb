$(document).ready(function(){
	$.ajax({
		type: "GET",
     	url: APP_BASE + "getMenuJSON",
     	dataType: "json",
	 	success:function(data) {
			var menus = data;
		 	if(menus.length>0){
		 		buildMenu(menus);
			}else{
				layer.msg("加载菜单出错" , {icon:2});
			} 
		},
		error:function(e){
			layer.msg("加载菜单出错" , {icon:2});
		}
	});
});

function buildMenu(menus){
	var menuHtml = "";
	for (var i = 0; i < menus.length; i++) {
		var menu  = menus[i];
		menuHtml += '<dl>';
		menuHtml += '<dt id="sidebar_goods_manage" ><i class="pngFix"></i>'+menu.menuName+'</dt>';
		menuHtml += '<dd style=""><ul>';
		var subMenus = menu.shopSellerMenuList;
		for(var j = 0; j < subMenus.length; j++){
			var sub = subMenus[j];
			if(sub.menuName == "我的店铺"){
				menuHtml += '<li><a class="normal" target="_blank" href="'+FRONT_BASE+sub.menuUrl + '?storeId=' + STORE_ID + '">'+sub.menuName+'</a></li>';
			} else {
				menuHtml += '<li><a class="normal" href="'+APP_BASE+sub.menuUrl+'">'+sub.menuName+'</a></li>';
			}
		}
		menuHtml += '</ul></dd></dl>';
	}
	$(".sidebar").append(menuHtml);
}