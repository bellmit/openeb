$(document).ready(function(){
	//列表下拉
	$('img[nc_type="flex"]').click(function(){
		var status = $(this).attr('status');
		if(status == 'open'){
			var pr = $(this).parent('td').parent('tr');
			var id = $(this).attr('fieldid');
            var level = $(this).attr('level');
			var obj = $(this);
			$(this).attr('status','none');
			//ajax
			$.ajax({
				url: APP_BASE+'/channel/child?id='+id+'&level='+(Number(level)+1),
				dataType: 'json',
				success: function(data){
					var src='';
					for(var i = 0; i < data.length; i++){
						var tmp_vertline = "<img class='preimg' src='"+APP_BASE+"/static/ui-v2/images/vertline.gif'/>";
						src += "<tr class='"+pr.attr('class')+" row"+id+"'>";
						src += "<td class='w36'><input type='checkbox' name='check_ac_id[]' value='"+data[i].id+"' class='checkitem'>";
						if(data[i].have_child == 1){
							src += "<img fieldid='"+data[i].id+"' status='open' nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-expandable.gif' />";
						}else{
							src += "<img fieldid='"+data[i].id+"' status='none' nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-item.gif' />";
						}
						//图片
						src += "</td><td class='w48 sort'>";
						//排序
						src += "<span title='可编辑'  datatype='number' fieldid='"+data[i].id+"' modUrl='"+APP_BASE+"/website/classs/modifySort' fieldname='ac_sort' nc_type='inline_edit' class='editable'>"+data[i].indexnum+"</span></td>";
						//名称
						src += "<td class='name'>";
						for(var tmp_i=1; tmp_i < (data[i].deep-1); tmp_i++){
							src += tmp_vertline;
						}
						if(data[i].have_child == 1){
							src += " <img fieldid='"+data[i].id+"' status='open' nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-item1.gif' />";
						}else{
							src += " <img fieldid='"+data[i].id+"' status='none' nc_type='flex' src='"+APP_BASE+"/static/ui-v2/images/tv-expandable1.gif' />";
						}
						src += " <span title='可编辑' required='1' fieldid='"+data[i].id+"' modUrl='"+APP_BASE+"/channel/modifyName' fieldname='ac_name' nc_type='inline_edit' class='editable'>"+data[i].title+"</span>";
						src += "</td>";
						
						//操作
						src += "<td class='w84'>";
                        src += "<span><a href=" + APP_BASE + "/channel/form?id=" + data[i].id + ">编辑</a>";
						src += " | <a href=\"javascript:if(confirm('删除该分类将会同时删除该分类的所有下级分类，您确定要删除吗'))window.location = '"+APP_BASE+"/channel/delete?ids="+data[i].id+"';\">删除</a>";
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
                    $.getScript(APP_BASE+"/static/ui-v2/jquery.edit.js");
					$.getScript(APP_BASE+"/static/jquery-plat/article_class.js");
					$.getScript(APP_BASE+"/static/ui-v2/admincp.js");
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