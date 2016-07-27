<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript">
	// 获取滚动条高度
	function getScrollTop(){ 
		var scrollTop=0; 
		if(document.documentElement&&document.documentElement.scrollTop){ 
			scrollTop=document.documentElement.scrollTop; 
		}else if(document.body){ 
			scrollTop=document.body.scrollTop; 
		} 
		return scrollTop; 
	} 

	// 编辑Banner信息
	function editTopImg(){
		// 获取当前屏幕的高度
		var topHeight = getScrollTop();
		topHeight = topHeight > 0 ? topHeight : 10; 
		
		var topimgsDialog = $('<div/>').css('top',topHeight + 50).dialog({
			title:'编辑栏目模块',
		    width:820,
		    height:500,
		    closed: false,
		    cache: false,
			modal : true,
		    href: '${pageContext.request.contextPath}/forward?path=site/editBanner',
		    buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					// 保存品牌数据
					var banner = "";
					var banner_nodes = $("#index_banner").parent().find("div[class='brandLine']");
					for(var i = 0; i < banner_nodes.length; i++){
						banner += $($(banner_nodes[i]).find("input")[0]).val() + ";;";
						banner += $($(banner_nodes[i]).find("input")[1]).val() + "!!";
					}
					$("#index_longBanner").val(banner);
					
					// 保存Banner数据
					$.ajax({
						url : '${pageContext.request.contextPath}/saveBanner',
						data :　$("#banner_info").serialize(),
						dataType : 'json',
						success : function(json) {
							$.messager.show({
				                title:'提示',
				                msg:json.msg,
				                timeout:1000,
				                showType:'fade'
				            });
						}
					});
					topimgsDialog.dialog('destroy');
				}
			}],
			onClose : function(){
				topimgsDialog.dialog('destroy');
			}
		});
	}
	
	//编辑栏目模块
	function editChannel(){
		// 获取当前屏幕的高度
		var topHeight = getScrollTop();
		topHeight = topHeight > 0 ? topHeight : 10; 
		
		var imgsDialog = $('<div/>').css('top',topHeight + 50).dialog({
			title:'编辑栏目模块',
		    width:820,
		    height:500,
		    closed: false,
		    cache: false,
			modal : true,
		    href: '${pageContext.request.contextPath}/forward?path=site/editChannel',
		   	//href: '${pageContext.request.contextPath}/storeyform',
		    buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					// 保存楼层数据
					var cate = "";
					var cate_nodes = $("#addCate").parent().find("div[class='brandLine']");
					for(var i = 0; i < cate_nodes.length; i++){
						cate += $($(cate_nodes[i]).find("input")[0]).val() + ";;";
						cate += $($(cate_nodes[i]).find("input")[1]).val() + "!!";
					}
					
					var brand = "";
					var brand_nodes = $("#addBrand").parent().find("div[class='brandLine']");
					for(var i = 0; i < brand_nodes.length; i++){
						brand += $($(brand_nodes[i]).find("input")[0]).val() + ";;";
						brand += $($(brand_nodes[i]).find("input")[1]).val() + "!!";
					}
					
					var goods = "";
					var goods_nodes = $("#addGoods").parent().find("div[class='brandLine']");
					for(var i = 0; i < goods_nodes.length; i++){
						goods += $($(goods_nodes[i]).find("input")[0]).val() + ";;";
						goods += $($(goods_nodes[i]).find("input")[1]).val() + "!!";
					}

					$("#index_storey_cate").val(cate);
					$("#index_storey_brand").val(brand);
					$("#index_storey_goods").val(goods);
					
					$.ajax({
						url : '${pageContext.request.contextPath}/saveStorey',
						data : $("#storeyInfo").serialize(),
						dataType : 'json',
						success : function(json) {
							$.messager.show({
				                title:'提示',
				                msg:json.msg,
				                timeout:1000,
				                showType:'fade'
				            });
						}
					});
					imgsDialog.dialog('destroy');
				}
			}],
			onClose : function(){
				imgsDialog.dialog('destroy');
			}
		});
	}
	
	//编辑品牌模块
	function editBrand(){
		// 获取当前屏幕的高度
		var topHeight = getScrollTop();
		topHeight = topHeight > 0 ? topHeight : 10; 
		
		var hotBrandsDialog = $('<div/>').css('top',topHeight + 50).dialog({
			title:'编辑品牌模块',
		    width:820,
		    height:500,
		    closed: false,
		    cache: false,
			modal : true,
		    href: '${pageContext.request.contextPath}/forward?path=site/editBrand',
		    buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					// 保存品牌数据
					var brand = "";
					var brand_nodes = $("#index_brand").parent().find("div[class='brandLine']");
					for(var i = 0; i < brand_nodes.length; i++){
						brand += $($(brand_nodes[i]).find("input")[0]).val() + ";;";
						brand += $($(brand_nodes[i]).find("input")[1]).val() + "!!";
					}
					$("#index_brand_str").val(brand);					
					
					$.ajax({
						url : '${pageContext.request.contextPath}/saveIndexBrands',
						data : $("#indexBrandInfo").serialize(),
						dataType : 'json',
						success : function(json) {
							$.messager.show({
				                title:'提示',
				                msg:json.msg,
				                timeout:1000,
				                showType:'fade'
				            });
						}
					}); 
					hotBrandsDialog.dialog('destroy');
				}
			}],
			onClose : function(){
				hotBrandsDialog.dialog('destroy');
			}
		});
	}
	
	function createMenus() {
		$.ajax({
			url : '${pageContext.request.contextPath}/createMenus',
			dataType : 'json',
			success : function(json) {
				$.messager.show({
	                title:'提示',
	                msg:json.msg,
	                timeout:1000,
	                showType:'fade'
	            });
			}
		}); 
	}
</script>
<div class="member-main member-main2">
	<div class="orderlist-warp">
		<div class="title">模板列表</div>
		<div class="title_fb ">当前使用的模板</div><br />
		<div style="float: left; border:1px solid #bfbfbf; margin:10px;overflow: hidden;"><img alt="首页模板" src="resources/images/index.png" width="250" /></div>
		<div style="float: left;margin:10px;overflow: hidden;">
			<button class="btn submit-btn" type="submit" onclick="editTopImg();" rel="_request">
				<span>Banner 编辑</span>
			</button>
			
			<button class="btn submit-btn" type="submit" onclick="editChannel();" rel="_request">
				<span>楼层编辑</span>
			</button>
			
			<button class="btn submit-btn" type="submit" onclick="editBrand();" rel="_request">
				<span>品牌编辑</span>
			</button>
			
			<button class="btn submit-btn" type="submit" onclick="createMenus();" rel="_request">
				<span>生成菜单</span>
			</button>
		</div>
	</div>


</div>