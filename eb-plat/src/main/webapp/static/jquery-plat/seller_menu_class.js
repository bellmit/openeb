$(document).ready(function(){
	//列表下拉
	$('img[nc_type="flex"]').click(function(){
		var status = $(this).attr('status');
		if(status == 'open'){
			var pr = $(this).parent('td').parent('tr');
			var mid = $(this).attr('fieldid');
            var level = $(this).attr('level');
			var obj = $(this);
			$(this).attr('status','none');
			//ajax
			$.ajax({
				url: APP_BASE+'/shopmenu/child?id='+mid+'&level='+(Number(level)+1),
				dataType: 'json',
				success: function(data){
					var src='';
					for(var i = 0; i < data.length; i++){
						var tmp_vertline = "<img class='preimg' src='"+APP_BASE+"/static/ui-v2/images/vertline.gif'/>";
						src += "<tr class='"+pr.attr('class')+" row"+mid+"'>";
						src += "<td class='w36'><input type='checkbox' name='ids' value='"+data[i].menuId+"' class='checkitem'>";
						//图片
						if(data[i].hasChild != 0){
							src += " <img fieldid='"+data[i].menuId+"' status='open' level="+(data[i].deep)+" nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-expandable.gif' />";
						}else{
							src += " <img fieldid='"+data[i].menuId+"' status='none' nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-item.gif' />";
						}
						//名称
						src += "<td class='w50pre name'>";
						
						
						for(var tmp_i=1; tmp_i < (data[i].deep-1); tmp_i++){
							src += tmp_vertline;
						}
						if(data[i].hasChild != 0){
							src += " <img fieldid='"+data[i].menuId+"' status='open' nc_type='flex' level="+(data[i].deep)+" src='"+APP_BASE+"/res/images/tv-item1.gif' />";
						}else{
							src += " <img fieldid='"+data[i].menuId+"' status='none' nc_type='flex' src='"+APP_BASE+"/res/images/tv-expandable1.gif' />";
						}
						src +=data[i].menuName;
						//新增下级
						if(data[i].deep < 3){
							src += "<a class='btn-add-nofloat marginleft' href='"+APP_BASE+"/shopSellerMenu/forward?menuId=0&menuParentId="+data[i].menuId+"'><span>新增下级</span></a>";
						}
						src += "</td>";
						//链接
						src += "<td>"+data[i].menuUrl+"</td>";
						//是否可见
						src += "<td>"+data[i].menuIsshow+"</td>";
						//权限标识
						src += "<td>"+data[i].menuPermission+"</td>";
						//操作
						src += "<td class='w84'>";
						src += "<a href="+APP_BASE+"/shopSellerMenu/forward?menuId="+data[i].menuId+"&menuParentId="+data[i].menuParentId+">编辑</a>";
						src += "&nbsp;|&nbsp;<a href=\"javascript:;\"  onclick=\"delClassid('"+data[i].menuId+"');\">删除</a>";
						src += "</td>";
						src += "</tr>";
					}
					//插入
					pr.after(src);
					obj.attr('status','close');
					obj.attr('src',obj.attr('src').replace("tv-expandable","tv-collapsable"));
					$('img[nc_type="flex"]').unbind('click');
					$('span[nc_type="inline_edit"]').unbind('click');
					//重现初始化页面
                    $.getScript(APP_BASE+"/res/js/jquery.edit.js");
					$.getScript(APP_BASE+"/res/js/jquery.seller_menu_class.js");
					$.getScript(APP_BASE+"/res/js/admincp.js");
				},
				error: function(){
					alert('获取信息失败');
				}
			});
		}
		if(status == 'close'){
			$(".row"+$(this).attr('fieldid')).remove();
			$(this).attr('src',$(this).attr('src').replace("tv-collapsable","tv-expandable"));
			$(this).attr('status','open');
		}
	})
});