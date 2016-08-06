<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    
    <title>管理后台</title>
    <link href="${pageContext.request.contextPath}/static/ui-v2/css/skin_0.css" rel="stylesheet" type="text/css" id="cssfile" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.validation.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/admincp.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common.js"></script>

    <script type="text/javascript">
	        var APP_BASE = '${pageContext.request.contextPath}';
	        LOADING_IMAGE = "${pageContext.request.contextPath}/res/images/loading.gif";
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui/themes/ui-lightness/jquery-ui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js" />
	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
	        });
	    });
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>平台订单</h3>
            <ul class="tab-base">
                <li><a href="JavaScript:void(0);" class="current"><span>管理</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/platformOrder/list" name="formSearch" id="formSearch">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
            <tbody>
            <tr>
                <th><label>订单号</label></th>
                <td><input class="txt2" type="text" name="orderSn" value=""></td>
                <th><label>订单状态</label></th>
                <td colspan="4"><select name="orderState" class="querySelect">
                    <option value="" selected="selected">请选择</option>
                    <option value="10">待付款</option>
                    <option value="20">待发货</option>
                    <option value="30">待收货</option>
                    <option value="40">交易完成</option>
                    <option value="50">已提交</option>
					<option value="60">已确认</option>
                    <option value="0">已取消</option>
                </select></td>

            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <th><label for="query_start_time">下单时间</label></th>
                <td><input class="txt date hasDatepicker" type="text" id="query_start_time" name="startTime" value="" readonly="readonly">
                    <label for="query_start_time">~</label>
                    <input class="txt date hasDatepicker" type="text" id="query_end_time" name="endTime" value="" readonly="readonly"></td>
                <th>买家</th>
                <td><input class="txt-short" type="text" name="buyerName" value=""></td>
                <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="查询">&nbsp;</a>

                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none; background: rgb(255, 255, 255);">
            <td>
                <ul>
                    <li>点击查看操作将显示订单（包括订单物品）的详细信息</li>
                    <li>点击取消操作可以取消订单（在线支付但未付款的订单和货到付款但未发货的订单）</li>
                    <li>如果平台已确认收到买家的付款，但系统支付状态并未变更，可以点击收到货款操作，并填写相关信息后更改订单支付状态</li>
                </ul></td>
        </tr>
        </tbody>
    </table>
    <table class="table tb-type2 nobdb">
        <thead>
        <tr class="thead">
            <th>订单号</th>
            <th>买家</th>
            <th class="align-center">下单时间</th>
            <th class="align-center">订单总额</th>
            <th class="align-center">支付总额</th>
            <th class="align-center">支付方式</th>
            <th class="align-center">订单状态</th>
            <th class="align-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderList }" var="order">
	        <tr class="hover">
	            <td>${order.id }-${order.serial }</td>
	            <td>${order.buyerid }</td>
	            <td class="nowrap align-center">${order.adddatestr }</td>
	            <td class="align-center">${order.totalfee }</td>
	            <td class="align-center">${order.payedfee }</td>
	            <td class="align-center">支付宝</td>
	            <td class="align-center">已取消</td>
	            <td class="w144 align-center"><a href="${pageContext.request.contextPath}/orders/show?id=${order.id}">查看</a>
	                <!-- 取消订单 -->
	            </td>
	        </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td colspan="15" id="dataFuncs">
<div class="pagination">
    <ul><li>
                </li><li><span>首页</span></li>
                    <li><span class="currentpage">1</span></li>
                    <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
                <li><span>...</span></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(12)"><span>12</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(13)"><span>13</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(13)"><span>末页</span></a></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >13) {
                    no =13;
                }
                if (no < 1) {
                    no = 1;
                }
                queryForm.pageNo.value=no;
                queryForm.submit();
            }
        </script>
    </ul>
</div>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script type="text/javascript">
    $(function(){
        $('#query_start_time').datepicker({dateFormat: 'yy-mm-dd'});
        $('#query_end_time').datepicker({dateFormat: 'yy-mm-dd'});
        $('#ncsubmit').click(function(){
            $('#formSearch').submit();
        });
    });
    
    /**调整费用**/
	function updateAmount(id) {
	   	layer.open({
		    type: 2,
		    area: ['400px', '200px'],
		    skin: 'layui-layer-rim',
		    title: '调整订单费用',
		    //content: APP_BASE + '/cart/addresslist'
		    content :  ['/leimingtech-admin/platformOrder/updateAmountIndex?orderId=' + id, 'no'],
		    success: function(layero, index){
		    	layer.getChildFrame('#confirm_button',index).on('click', function(){
					var orderId=layer.getChildFrame("#orderId",index).val();
					var orderAmount=layer.getChildFrame("#orderAmount",index).val();
					var fmUrl = '/leimingtech-admin/platformOrder/updateAmount';
					$.ajax({
			             type: "post",
			             url: fmUrl,
			             data: {orderId:orderId,orderAmount:orderAmount},
			             dataType: "json",
						 async:false,
						 success:function(data) {
							if(data.success){
								parent.layer.msg("订单修改成功",{icon:1},function(){
									location.reload();
								});	
							}else{
								parent.layer.msg("订单修改失败",{icon:2},function(){
									location.reload();
								});		
							}
						}
			         });  
				});	
		    }
		});
	}
	
	/**订单确认**/
	function confirmOrder(id) {
	   	layer.open({
		    type: 2,
		    area: ['400px', '200px'],
		    skin: 'layui-layer-rim',
		    title: '订单确认',
		    //content: APP_BASE + '/cart/addresslist'
		    content :  ['/leimingtech-admin/platformOrder/confirmOrderIndex?orderId=' + id, 'no'],
		    success: function(layero, index){
		    	layer.getChildFrame('#confirm_button',index).on('click', function(){
					var orderSn=layer.getChildFrame("#orderSn",index).val();
					var fmUrl = '/leimingtech-admin/platformOrder/confirmOrder';
					$.ajax({
			             type: "post",
			             url: fmUrl,
			             data: {orderSn:orderSn},
			             dataType: "json",
						 async:false,
						 success:function(data) {
							if(data.success){
								parent.layer.msg("订单确认成功",{icon:1},function(){
									location.reload();
								});	
							}else{
								parent.layer.msg("订单确认失败",{icon:2},function(){
									location.reload();
								});		
							}
						}
			         });  
				});	
		    }
		});
	}
	
	/**退款审核**/
	function refund(id) {
	   	layer.open({
		    type: 2,
		    area: ['500px', '400px'],
		    skin: 'layui-layer-rim',
		    title: '订单退款',
		    //content: APP_BASE + '/cart/addresslist'
		    content :  ['/leimingtech-admin/platformOrder/refundOrderIndex?logId=' + id, 'no'],
		    success: function(layero, index){
		    	layer.getChildFrame('#confirm_button',index).on('click', function(){
					var logId=layer.getChildFrame("input[name='logId']",index).val();
					var refundState = layer.getChildFrame("input[name='refund_state']:checked",index).val();
					var refundMessage = layer.getChildFrame("input[name='refund_message']",index).val();
					var fmUrl = '/leimingtech-admin/platformOrder/refundOrder';
					$.ajax({
			             type: "post",
			             url: fmUrl,
			             data: {logId:logId,refundState:refundState,refundMessage:refundMessage},
			             dataType: "json",
						 async:false,
						 success:function(data) {
							if(data.success){
								parent.layer.msg("审核成功!",{icon:1},function(){
									location.reload();
								});	
							}else{
								parent.layer.msg("审核失败!",{icon:2},function(){
									location.reload();
								});		
							}
						}
			         });  
				});	
		    }
		});
	}
	
	/**退货审核**/
	function returnOrder(id){
		layer.open({
		    type: 2,
		    area: ['500px', '400px'],
		    skin: 'layui-layer-rim',
		    title: '订单退货',
		    //content: APP_BASE + '/cart/addresslist'
		    content :  ['/leimingtech-admin/platformOrder/returnOrderIndex?returnId=' + id, 'no'],
		    success: function(layero, index){
		    	layer.getChildFrame('#confirm_button',index).on('click', function(){
					var returnId=layer.getChildFrame("input[name='returnId']",index).val();
					var returnState = layer.getChildFrame("input[name='return_state']:checked",index).val();
					var returnMessage = layer.getChildFrame("input[name='return_message']",index).val();
					var fmUrl = '/leimingtech-admin/platformOrder/returnOrder';
					$.ajax({
			             type: "post",
			             url: fmUrl,
			             data: {returnId:returnId,returnState:returnState,returnMessage:returnMessage},
			             dataType: "json",
						 async:false,
						 success:function(data) {
							if(data.success){
								parent.layer.msg("审核成功!",{icon:1},function(){
									location.reload();
								});	
							}else{
								parent.layer.msg("审核失败!",{icon:2},function(){
									location.reload();
								});		
							}
						}
			         });   
				});	
		    }
		});
	}
</script>


<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>