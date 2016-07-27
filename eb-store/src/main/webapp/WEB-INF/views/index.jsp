<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/member.css"  >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sell.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/basic.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

</head>


<body>
<body>
<div class="webwidth">
       
<div class="memberwrap">
 
<div class="clearfix">
  <!-- left-->
  <!-- left-->

  <!-- right--> 

<div class="sell_ri fr">
    <div class="Plate">
       <h4>
        <a href="#" class="current">我的专营店</a>
        <a href="#" class="">管理店铺动态</a>
        </h4>
    </div>
    <div class="sell_ri_top">
	    <!-- <div class="sell_ri_top_le fl">
			<a href="http://58.214.7.150:8992/business.html#"><img src="./店铺管理_BIZmall商城--6-26_files/839377e60b869ff0183363f71af2bbfa.jpg" alt=""></a>
	    	<p>婧婧之家</p>
		</div> -->
	    <div class="sell_ri_top_ri fr">
           <div class="order_info">
		        <div class="order_info_le fl">
			        <ul>
				      	<li>
				      		<strong><b class="icon01"></b>订单</strong>
				      		<span class="color_1"><a href="${pageContext.request.contextPath}/order/orderList">待付款订单<font>（${waitPaynum }）</font></a></span>
				      		<span class="color_1"><a href="${pageContext.request.contextPath}/order/orderList">待发货订单<font>（${waitSendnum }）</font></a></span>
				      		
				      	</li>

				      	<li>
				      		<strong><b class="icon02"></b>提醒</strong>
   						      <span class="color_1"><a href="${pageContext.request.contextPath}/forward?path=baby/product_onsale">出售中的商品<font>（${onsaleNum}）</font></a></span>
   						      <span class="color_1"><a href="${pageContext.request.contextPath}/product/productStockList">预警中的宝贝<font>（${stockalertNum }）</font></a></span>
                  		</li>

						<li>
							<strong><b class="icon03"></b>违规</strong>
					      	<span class="color_1">一般违规累计<font>（2）</font></span>
					      	<span class="color_1">严重违规累计<font>（0）</font></span>
						</li>

						<li class="none">
							<strong><b class="icon04"></b>宝贝</strong>

				      						      		<span class="color_1"><a href="http://58.214.7.150:8992/business-goods_onsell.html">出售中的宝贝<font>（35）</font></a></span>
				      		
				      		<span class="color_1">待评论宝贝<font>（25）</font></span>
				    	</li>
			        </ul>
			  
			    </div>
		        <table class="order_info_ri fr" cellpadding="0" cellspacing="0">
					<tbody><tr>
						<th>店铺动态评分</th>
						<th>与同行业相比</th>
					</tr>
	                					<tr>
						<td class="color_1">描述相符：4.00</td>
						<td class="red">
	                    低于100%
	                    </td>
					</tr>
	                					<tr>
						<td class="color_1">服务态度：5.00</td>
						<td class="red">
	                    高于24.23%
	                    </td>
					</tr>
	                					<tr>
						<td class="color_1">发货速度：2.50</td>
						<td class="red">
	                    低于100%
	                    </td>
					</tr>
	                			    </tbody></table>
		    </div>
		</div>
		
	    <div class="cl_zhi"></div>
	</div>
	<!-- <div class="Plate width_472 fl">
		<h4><a href="http://58.214.7.150:8992/business.html#" class="current">营销推广活动</a></h4>
		<div class="Plate_info">
			<div class="Plate_info_table_div">
				<ul class="Plate_info_table">
										<li><span>[2015-06-09]</span><a href="http://58.214.7.150:8992/promotions-attend.html">促销活动1</a></li>
										<li><span>[2015-06-16]</span><a href="http://58.214.7.150:8992/promotions-attend.html">test xianshi</a></li>
										<li><span>[2015-06-26]</span><a href="http://58.214.7.150:8992/promotions-attend.html">111</a></li>
					
				</ul>
		  </div>
            <div style='float:right;'><a href="http://58.214.7.150:8992/article-promotions-1-12.html">更多活动》</a></div>
			<div class="cl_zhi"></div>
		</div>

	</div> -->
	<div class="Plate width_472 fr">
		<h4><a href="http://58.214.7.150:8992/business.html#" class="current">官方活动信息</a></h4>
		<div class="Plate_info">
			<ul class="Plate_info_ul">
								<li><a href="http://58.214.7.150:8992/article-news-65.html">
				<strong>▪ 8月26日平台大促</strong><span class="fr">13-07-02</span>
				<span class="cl_zhi"></span>
				</a></li>
								<li><a href="http://58.214.7.150:8992/article-news-64.html">
				<strong>▪ 7月1日开放外部公测</strong><span class="fr">13-06-26</span>
				<span class="cl_zhi"></span>
				</a></li>
								<li><a href="http://58.214.7.150:8992/article-news-55.html">
				<strong>▪ 系统升级通知（周二）！</strong><span class="fr">10-10-01</span>
				<span class="cl_zhi"></span>
				</a></li>
								<li><a href="http://58.214.7.150:8992/article-news-54.html">
				<strong>▪ 8月8日暂停货品出库</strong><span class="fr">10-10-01</span>
				<span class="cl_zhi"></span>
				</a></li>
								<li><a href="http://58.214.7.150:8992/article-news-53.html">
				<strong>▪ 商品评论改版升级!</strong><span class="fr">10-10-01</span>
				<span class="cl_zhi"></span>
				</a></li>
								<li><a href="http://58.214.7.150:8992/article-news-52.html">
				<strong>▪ 银行系统升级通告！</strong><span class="fr">10-10-01</span>
				<span class="cl_zhi"></span>
				</a></li>
				
			</ul>
		</div>

	</div>
	<div class="cl_zhi"></div>
	<div class="Plate width_960">
		<h4><a href="http://58.214.7.150:8992/business.html#" class="current">近期服务情况</a></h4>
		<div class="Plate_info" style="position:relative;">
        <div class="Yellow_bg">服务月</div>
        <div class="Plate_info_table_2">
			<table width="938" border="0" cellspacing="0" cellpadding="0">
				<tbody><tr>
					<th class="width_95">服务月</th>
					<th>退款</th> 
					<th>退款率</th>
					<th>纠纷退款</th>
					<th>纠纷退款率</th>
					<th colspan="2">平均退款速度</th>
					<th>投诉</th>
				</tr>
				<tr>
					<td>最近30天</td>
					<td>0&nbsp;笔</td>
					<td>0%</td>
					<td>0&nbsp;笔</td>
					<td>0% </td>
					<td style="text-align:right;"> 0&nbsp;天 </td>
                   
                                           <td class="td_color_2" style="text-align:left;width:200px;">
                       &nbsp;&nbsp;&nbsp;-                    </td>
					<td>0&nbsp;笔</td>
				</tr>
				<tr>
					<td>2015年05月 </td>
					<td>0&nbsp;笔</td>
					<td>0%</td>
					<td>0&nbsp;笔</td>
					<td>0%  </td>
					<td style="text-align:right;">0&nbsp;天 </td>
                   
                                           <td class="td_color_2" style="text-align:left;width:200px;">
                       &nbsp;&nbsp;&nbsp;-                    </td>
					<td>0&nbsp;笔</td>
				</tr>
			</tbody></table>
            </div>
		</div>

	</div>
	 
	 
	<!-- <div class="Plate2 width_472 f14 fl">
		<h4><a href="http://58.214.7.150:8992/business.html#" class="current2">平台服务专区</a></h4>
		<div class="Plate_info tac">
			<p class="Plate_info_p" style="margin:25px auto;"> 
				<strong>需缴纳保证金额：</strong><span class="font-red">￥1000.00</span>元
			</p>
			<p class="Plate_info_p" style="margin:25px auto;"> 
				<strong>已缴纳保证金额：</strong><span class="font-blue">￥10000.00</span>元
			</p>
			
			<div style="margin-left:140px;">
            <p class="button_1" style="float:left;margin-right:10px;"> <a href="http://58.214.7.150:8992/store-storeapplystep4-676-isedit.html">资质认证</a></p>
                        <p class="button_2" style="float:left;"> <a href="">开店续费</a></p>
							<span class="cl_zhi"></span>
			</div>
		</div>

	</div> -->
	<div class="Plate width_472 fr">
		<h4><a href="http://58.214.7.150:8992/business.html#" class="current">评价信息</a></h4>
		<div class="Plate_info">
			<div class="Plate_info_table_2_div">
            <div class="Plate_info_table_2">
				<table width="100%">
					<tbody><tr>
						<th class="width_95">服务月</th>
						<th class="width_70">评价总数</th> 
						<th class="width_110">原始中差评数</th>
						<th class="width_110">删除中差评数</th>
					</tr>
					<tr>
						<td>最近30天 </td>
						<td>0&nbsp;笔</td>
						<td>0&nbsp;笔</td>
						<td>0&nbsp;笔</td>

					</tr>
					<tr>
						<td> 2015年05月 </td>
						<td>0&nbsp;笔</td>
						<td>0&nbsp;笔</td>
						<td>0&nbsp;笔</td>
					</tr>
				</tbody></table>
                </div>
			</div>
		</div>
	</div>
</div>  
  </div>
</div>
</div>









 </body>
</body>

</html>
