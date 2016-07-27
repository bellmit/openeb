<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		//获取根类目
		$.ajax({
			url : '${pageContext.request.contextPath}/product/rootCates',
			dataType : 'json',
			success : function(json) {
				var firstRootCateId;
				if (json.success) {
					var data = json.data;
					console.info(data);
					for(var i = 0; i < data.length; i ++){
						if(i == 0) {
							$("#cate1").append("<li class=\"isParent cur\" onclick=\"cate1Click("+data[i].id+")\" isparent=\"isParent\" type=\"1\" id=\""+data[i].id+"\"" + 
									"type_id=\""+data[i].typeId+"\">"+data[i].title+"<span class=\"icon\"></span></li>");
							firstRootCateId = data[i].id;
						} else {
							$("#cate1").append("<li class=\"isParent\" onclick=\"cate1Click("+data[i].id+")\" isparent=\"isParent\" type=\"1\" id=\""+data[i].id+"\"" + 
									"type_id=\""+data[i].typeId+"\">"+data[i].title+"<span class=\"icon\"></span></li>");
						}
					}
				}
				
				//获取第一个根类目下二级类目
				$.ajax({
					url : '${pageContext.request.contextPath}/product/getCates?parId='+　firstRootCateId,
					dataType : 'json',
					success : function(json) {
						
						if (json.success) {
							var data = json.data;
							console.info(data);
							for(var i = 0; i < data.length; i ++){
								$("#cate2").append("<li class=\"isParent\" onclick=\"cate2Click("+data[i].id+")\" isparent=\"isParent\" type=\"1\" id=\""+data[i].id+"\"" + 
										"type_id=\""+data[i].typeId+"\">"+data[i].title+"<span class=\"icon\"></span></li>");
							}
						}
					}
				});
				
				// 添加当前选择内容
				$("#cur1").html($("#"+firstRootCateId).html());
			}
		});
		
	});
	
	//一级目录的点击事件
	function cate1Click(id) {
		//清空二级、三级目录数据
		$("#cate2").empty();
		$("#cate3").empty();
		
		//改变一级目录CSS样式
		$("#cate1 li").removeClass("cur");
		$("#"+id).addClass("cur");
		
		// 更新当前选择内容
		$("#cur2").html("");
		$("#cur3").html("");
		$("#cur1").html("").html($("#"+id).html());
		
		//加载二级目录数据
		$.ajax({
			url : '${pageContext.request.contextPath}/product/getCates?parId='+　id,
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i ++){
						$("#cate2").append("<li class=\"isParent\" onclick=\"cate2Click("+data[i].id+")\" isparent=\"isParent\" type=\"1\" id=\""+data[i].id+"\"" + 
								"type_id=\""+data[i].typeId+"\">"+data[i].title+"<span class=\"icon\"></span></li>");
					}
				}
			}
		});
	}
	
	//二级目录的点击事件
	function cate2Click(id) {
		//清空三级目录数据
		$("#cate3").empty();
		
		//改变二级目录CSS样式
		$("#cate2 li").removeClass("cur");
		$("#"+id).addClass("cur");
		
		// 更新当前选择内容
		$("#cur3").html("");
		$("#cur2").html("").html(" > " + $("#"+id).html());
		
		//加载三级目录数据
		$.ajax({
			url : '${pageContext.request.contextPath}/product/getCates?parId='+　id,
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i ++){
						$("#cate3").append("<li class=\"isParent\" onclick=\"cate3Click("+data[i].id+")\" isparent=\"isParent\" type=\"1\" id=\""+data[i].id+"\"" + 
								"type_id=\""+data[i].typeId+"\">"+data[i].title+"<span class=\"icon\"></span></li>");
					}
				}
			}
		});
	}
	
	//三级目录的点击事件
	function cate3Click(id) {
		//改变三级目录CSS样式
		$("#cate3 li").removeClass("cur");
		$("#"+id).addClass("cur");
		
		// 更新当前选择内容
		$("#cur3").html("").html(" > " + $("#"+id).html());
		$("#cateTypeId").val('').val($("#"+id).attr('type_id'));
		$("#cateId").val(id);
		$("#cateName").val($("#"+id).text());
	}
</script>
<div class="goods_category_body">
	<ul id="cate1" class="cat_select">
		
	</ul>
	<ul id="cate2" class="cat_select">
		
	</ul>
	<ul id="cate3" class="cat_select">

	</ul>
	<div id="curCate">您当前选择的类目是：<span id="cur1"></span><span id="cur2"></span><span id="cur3"></span></div>
</div>