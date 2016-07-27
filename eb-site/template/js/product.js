
/*
 * product obj
 */
function getProductImgs(){
				$.ajax({
					url : domain+'/imgs?pid=${product.id}',
					dataType : 'json',
					type : 'GET',
					success : function(json) {
						var imghtml = "<ul>";
						if (json.success){
							$("#bigger-photo").html("<img jqimg=\""+json.data[0].url+"\" src=\""+json.data[0].url+"\" />");
							for(var i=0;i<json.data.length>0;i++){
								imghtml = imghtml+
	                        	"<li class=\"small-photo-out\">"
	                           +"	<img bimg=\""+json.data[i].url+"\" src=\""+json.data[i].url+"\" width=\"60\" height=\"60\" />"
	                           +" </li>"	
							}
						}
						imghtml = imghtml+"</ul>";
						$("#small-photo").html(imghtml);
					}
				});
			}
			
			function checkFirstSpec(){
				
			}
			function getProductSKUs(){
				$.ajax({
					url : domain+'/skus?pid=${product.id}',
					dataType : 'json',
					type : 'GET',
					success : function(json) {
						console.info(json);
						if (json){
							var skus_data = eval("("+json.PRODUCT_SKU_JSON_+")");
							var spec_data = eval("("+json.PRODUCT_SPEC_JSON_+")");
							if (null != spec_data && spec_data.length>0){
								var spechtml = "";
								for(var i=0;i<spec_data.length;i++){
									spechtml = spechtml +"<dl class=\"tm-price-panel\">"
									+"<dt class=\"tb-metatit\">"+spec_data[i].title+"</dt>"
									+"<dd>"
									+"<ul class=\"product-sku\" id=\"product-sku\">";
									if (null != spec_data[i].vals && spec_data[i].vals.length>0){
										for(var j=0;j<spec_data[i].vals.length;j++){
											spechtml = spechtml+"<li class=\"product-sku-out\" data-value='"+spec_data[i].id+":"+spec_data[i].vals[j].id+"'>"+spec_data[i].vals[j].title+"</li>";
										}
									}
									spechtml = spechtml +"</ul></dd></dl>";
								}
								$("#product-spec-list").empty();
								$("#product-spec-list").html(spechtml);
								checkFirstSpec();
							}
							
							$(".product-sku-out").click(function(){
								$("#product-spec-list").removeClass("sku-warning");
								$(this).siblings().removeClass("product-sku-over");
								$(this).siblings().addClass("product-sku-out");
								$(this).removeClass("product-sku-out");
								$(this).addClass("product-sku-over");
								var specs = $("#product-spec-list").children();
								var selecteds = $(".product-sku-over");
								//规格全部选中
								if(specs.length==selecteds.length){
									var specvals = "";
									$(".product-sku-over").each(function(){
										specvals = specvals+";"+$(this).attr("data-value");
									});
									
									specvals = specvals.substring(1);
									var sku = skus_data[specvals];
									if (!sku){
										return;
									}
									skuid = sku.skuId;
									$("#product-mkprice").html(sku.mkPrice);
									$("#product-price").html(sku.price);
									//$("#product-salesnum").html("0");
									$("#product-storenum").html(sku.store);
								}
							});
							
						}
					}
				});
			}
			

			
			function getProductProps(){
				$.ajax({
					url : domain+'/props?pid=${product.id}',
					dataType : 'json',
					type : 'GET',
					success : function(json) {
						var propshtml = "";
						if (json.success){
							for(var i=0;i<json.data.length;i++){
								propshtml = propshtml+"<li>"+json.data[i].propTitle+"</li>"
							}
						}
						$("#product-props").html(propshtml);
					}
				});
			}
			
			function getProductDesc(){
				$.ajax({
					url : domain+'/desc?pid=${product.id}',
					dataType : 'json',
					type : 'GET',
					success : function(data) {
						$("#product-desc").html(data);
					}
				});
			}
			
			function getProductSales(){
				$.ajax({
					url : domain+'/sales?pid=${product.id}',
					dataType : 'json',
					type : 'GET',
					success : function(data) {
						var saleshtml = "";
						if (!data){
							return;
						}
						$("#goods-solds").children("span").text(data.total);
						$("#product-salesnum").text(data.total);
						if (!data.rows){
							return;
						}
						for(var i=0;i<data.rows.length;i++){
							saleshtml = saleshtml
							+"<tr>"
							+"<td class=\"cell-align-l buyer\">"
							+" 	<div class=\"line\">"+data.rows[i].buyer+"<span class=\"tb-anonymous\">**</span>笨 </div>"
							//+"    <div class=\"line\">"
							//+"    	<img src=\"http://cdn.titles.top/images/buy/b_blue_1.gif\" border=\"0\" align=\"absmiddle\" class=\"rank\">"
							//+"        <a target=\"_blank\" href=\"#\" title=\"V4会员\"><img src=\"http://cdn.titles.top/images/buy/v4.png\" alt=\"V4会员\"></a>"
							//+"    </div> "
							+"</td>"
							+"<td class=\"cell-align-l style\"> "+data.rows[i].specstr+" </td>"
							+"<td class=\"quantity\">"+data.rows[i].num+"</td>"
							+"<td class=\"dealtime\"> <p class=\"date\">"+data.rows[i].adddatestr+"</p> <p class=\"time\">13:29:45</p> </td>"
							+"</tr>"
						}
						$("#product-sales").html(saleshtml);
					}
				});
			}
			
			function getProductEvals(page){
				$.ajax({
					url : domain+'/evals?pid=${product.id}&page='+page,
					dataType : 'json',
					type : 'GET',
					success : function(data) {
						var evalshtml = "";
						if (!data){
							return;
						}
						$("#product-pinjia").text(data.total);
						$("#goods-assessment").children("span").text(data.total);
						for(var i=0;i<data.rows.length;i++){
							evalshtml = evalshtml
							+"<li class=\"items\">"
							+"<div class=\"goods-desc\">"
							+"<div class=\"desc\">"+data.rows[i].content+"</div>"
							+"<div class=\"date\">"+data.rows[i].addtime+"</div>"
							+"</div>"
							+"<div class=\"goods-sku\">"
							+"<ul>"
							+"	<li><label>颜色分类：</label><span>粉红色/金属蓝/白色</span></li>"
							+"	<li><label>鞋码：</label><span>38</span></li>"
							+"</ul>"
							+"</div>"
							+"<div class=\"goods-buyer\"><label>"+data.rows[i].account+"</label><span></span></div>"
							+"</li>"
						}
						$("#product-evals").html(evalshtml);
					}
				});
			}