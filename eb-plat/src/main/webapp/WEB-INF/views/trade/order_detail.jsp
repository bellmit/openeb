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
	<script src="${pageContext.request.contextPath}/static/jquery-plat/area.js" charset="utf-8"></script>
	<style>
		.transinput{
			background-color: transparent;border:none; outline:none;
		}
		.select{width: 100px;height: 26px;}
	</style>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <table class="table tb-type2 order">
        <tbody>
        <tr class="space">
            <th colspan="15">订单状态</th>
        </tr>
        <tr>
            <td colspan="2">
                <ul>
                    <li>
                        <strong>订单号:</strong>20160630100250335
                        ( 支付单号 : P20160630100250240 )
                    </li>
                    <li><strong>订单状态:</strong>
                       	 已取消
                    </li>
                    <li>
                    	<strong>支付金额:</strong>
                    	<span class="red_common">¥
                    		<script type="text/javascript">
	    						var amount = number_format(1356,2);
	    						document.write(amount);
	    					</script>1356.00
                    	</span>
                    </li>
                    <li><strong>余额支付金额:</strong>¥
                    	<script type="text/javascript">
    						var predepositAmount = number_format(0,2);
    						document.write(predepositAmount);
    					</script>0.00
                    </li>
                    <li><strong>商品总额:</strong>¥
                    	<script type="text/javascript">
    						var goodsamount = number_format(1356,2);
    						document.write(goodsamount);
    					</script>1356.00
                    </li>
                    <li><strong>运费:</strong>
	              				（免运费）
                    </li>
                </ul>
            </td>
        </tr>
        <tr class="space" style="background: rgb(255, 255, 255);">
            <th colspan="2">订单详情</th>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>订单信息</th>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td><ul>
                <li><strong>买家：</strong>15932110597</li>
                <li><strong>店铺：</strong>平台自营</li>
                <li><strong>支付方式：</strong>支付宝</li>
                <li><strong>下单时间：</strong>2016-07-29 15:39:05</li>
            </ul></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>收货人及发货信息</th>
        </tr>
        <tr style="background: rgb(251, 251, 251);">
            <td>
                <ul>
                	<form action="http://b2b2c.leimingtech.com/leimingtech-admin/orders/show?id=fcb190ea2a9a4ef5a54a8410e051d7f0#" id="addressForm">
                		<input name="addressId" value="ebe7a25377dd4d56804238aa0346bfd7" type="hidden">
               			<li>
               				<em style="color:red;display:none;">*</em>
               				<strong>收货人姓名：</strong>
               				<span id="trueNameSp">康兰</span>
               				<input name="trueName" value="康兰" style="display: none;">
               			</li>
               			<li>
               				<em style="color:red;display:none;">*</em>
               				<strong>收货人手机：</strong>
               				<span id="mobPhoneSp">18610810207</span>
               				<input name="mobPhone" value="18610810207" style="display: none;">
               			</li>
               			<!-- <li>
               				<em style="color:red;display:none;">*</em>
               				<strong>收货人电话：</strong>
               				<input name="telPhone" value="021222222" disabled="disabled" class="transinput"/>
               			</li> -->
               			<li>
               				<em style="color:red;display:none;">*</em>
               				<strong>邮编：</strong>
               				<span id="zipCodeSp">111111</span>
               				<input name="zipCode" value="111111" style="display: none;">
               			</li>
               			<li>
               				<em style="color:red;display:none;">*</em>
               				<strong>收货地区：</strong>
               				<div id="region" style="display: none;">
	                        	<input id="city_id" type="hidden" name="cityId" value="">
								<input id="area_id" class="area_ids" type="hidden" name="areaId" value="">
								<input id="area_info" class="area_names" type="hidden" name="areaInfo" value="">
	                            <span id="spanarea">
							       	<select name="provinceId" id="area">
							       		<option selected="selected" value="0">请选择</option>
							  					<option value="11" selected="selected">北京市</option>
							  					<option value="44">广东省</option>
							  					<option value="45">广西壮族自治区</option>
							  					<option value="46">海南省</option>
							  					<option value="50">重庆市</option>
							  					<option value="51">四川省</option>
							  					<option value="52">贵州省</option>
							  					<option value="53">云南省</option>
							  					<option value="54">西藏自治区</option>
							  					<option value="61">陕西省</option>
							  					<option value="62">甘肃省</option>
							  					<option value="63">青海省</option>
							  					<option value="64">宁夏回族自治区</option>
							  					<option value="65">新疆维吾尔自治区</option>
							  					<option value="71">台湾省</option>
							  					<option value="81">香港特别行政区</option>
							  					<option value="43">湖南省</option>
							  					<option value="42">湖北省</option>
							  					<option value="12">天津市</option>
							  					<option value="13">河北省</option>
							  					<option value="14">山西</option>
							  					<option value="15">内蒙古自治区</option>
							  					<option value="21">辽宁省</option>
							  					<option value="22">吉林省</option>
							  					<option value="23">黑龙江省</option>
							  					<option value="31">上海市</option>
							  					<option value="32">江苏省</option>
							  					<option value="33">浙江省</option>
							  					<option value="34">安徽省</option>
							  					<option value="35">福建省</option>
							  					<option value="36">江西省</option>
							  					<option value="37">山东省</option>
							  					<option value="41">河南省</option>
							  					<option value="82">澳门特别行政区</option>
						         	</select> 	
								</span>
								<span id="spancity"><select name="city" id="city" onchange="getqu(1);"><option selected="selected" value="0">请选择</option><option value="1101" selected="selected">市辖区</option><option value="1102">县</option></select></span>
								<span id="spanqu"><select name="qu" class="select" id="qu" onchange="getqu(2);"><option selected="selected" value="0">请选择</option><option value="110101">东城区</option><option value="110116">怀柔区</option><option value="110115">大兴区</option><option value="110114">昌平区</option><option value="110113">顺义区</option><option value="110112">通州区</option><option value="110111">房山区</option><option value="110109">门头沟区</option><option value="110108">海淀区</option><option value="110107">石景山区</option><option value="110106">丰台区</option><option value="110105">朝阳区</option><option value="110104">宣武区</option><option value="110103">崇文区</option><option value="110102">西城区</option><option value="110117">平谷区</option></select></span>
								<span class="areaMsg" style="color: red"></span>
	                        </div>
               				<span id="areaInfoSp">北京市,市辖区&nbsp;</span>
               			</li>
               			<li>
               				<em style="color:red;display:none;">*</em>
               				<strong>详细地址：</strong>
               				<span id="addressSp">我</span>
               				<input name="address" value="我" style="width: 200px;display: none;">
               			</li>
               			<li id="update_address"><a href="javascript:void(0)" onclick="updateAddress();">修改收货地址</a></li>
               			<li id="save_address" style="display:none;">
               				<a href="javascript:void(0)" onclick="saveAddress(this);">保存</a>
               				<a href="javascript:void(0)" onclick="cancel();">取消</a>	
               			</li>
               		</form>
                </ul>
            </td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>发票信息</th>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td>
                <ul>
                	<li>不开发票</li>
                </ul>
            </td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <th>商品信息</th>
        </tr>
        <tr>
            <td><table class="table tb-type2 goods ">
                <tbody>
                <tr>
                    <th></th>
                    <th>商品信息</th>
                    <th class="align-center">单价</th>
                    <th class="align-center">数量</th>
                    <th class="align-center">小计</th>
                </tr>
                    <tr>
                        <td class="w60 picture"><div class="size-56x56"><span class="thumb size-56x56"><i></i><a href="javascript:;" target="_blank"><img src="./管理后台-订单查看_files/1458291926161.jpg" onload="javascript:DrawImage(this,60,60);" width="60" height="60"> </a></span></div></td>
                        <td class="w50pre"><p><a href="http://b2b2c.leimingtech.com/leimingtech-front/product/detail?id=9f3a8bf0808248799f8ef57deb0bcb28" target="_blank">骆驼男装 2016春装男士夹克衫 短款外套大码青年简约薄款茄克立领</a></p></td>
                        <td class="w96 align-center">
                        	<span class="red_common">￥
                        		<script type="text/javascript">
		    						var price = number_format(339,2);
		    						document.write(price);
		    					</script>339.00
                        	</span>
                        </td>
                        <td class="w96 align-center">4</td>
                        <td class="w96 align-center">
                        	<span class="red_common">￥
                        		<script type="text/javascript">
		    						var payprice = number_format(1356,2);
		    						document.write(payprice);
		    					</script>1356.00
                        	</span>
                        </td>
                        
                    </tr>
                </tbody>
            </table></td>
        </tr>
        <tr>
            <th>操作历史</th>
        </tr>
            <tr>
                <td>
                    15932110597 于 2016-07-29 15:39:05 取消订单
                </td>
            </tr>
            <tr>
                <td>
                    15932110597 于 2016-06-30 10:02:50 提交订单
                </td>
            </tr>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td><a href="JavaScript:void(0);" class="btn" onclick="history.go(-1)"><span>返回</span></a></td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
	$(function(){
		formValidate();
		init_area('11','1101','0');
	});
	
	jQuery.validator.addMethod("isMobPhone",function(value,element){
		var pattern = /^1\d{10}$/; //手机号格式
		return this.optional(element) || (pattern.test(value));  
	},"请填写正确的手机号");
	
	var formValidate = function(){
		$('#addressForm').validate({
		    errorPlacement: function(error, element){
		        $(element).next('.field_notice').hide();
		        $(element).after(error);
		    },
		    rules : {
		    	trueName : {
		    		required   : true
		    	},
		        mobPhone : {	
					required   : true,
					isMobPhone : true
		        },
		        address : {
		        	required   : true
		        },
		        zipCode : {
		        	required   : true
		        }
		    },
		    messages : {
		    	trueName : {
		    		required   : '请填写收货人姓名'
		    	},
		        mobPhone : {
					required : '请填写收货人手机',
					isMobPhone : '请填写正确的手机号'
		        },
		        address : {
		        	required   : '请填写收货地址'
		        },
		        zipCode : {
		        	required   : '请填写邮编'
		        }
		    }
		});
	}
	
	function saveAddress(obj){
		if($('#addressForm').valid()){
			//保存,取消链接标签设置为显示
			$(obj).attr("onclick","");
			var provinceId = $('#area').val(); //省的id
            var cityId = $('#city').val(); //城市id
            var areaId = $('#qu').val(); //区的id
			if(provinceId==''||provinceId=='0'){
                $(".areaMsg").html('请选择省份');
                return false;
            }else{
                $(".areaMsg").html('');
            }
            if(cityId==''||cityId=='0'){
                $(".areaMsg").html('请选择城市');
                return false;
            }
            if(areaId==''||areaId=='0'){
                $(".areaMsg").html('请选择区');
                return false;
            }else{
                $(".areaMsg").html('');
            }

            var provinceval = $('#area').find("option:selected").html(); //省的值
            var cityval = $('#city').find("option:selected").html(); //城市的值
            var quval = $('#qu').find("option:selected").html(); 	 //区的值
            var areaInfo=provinceval+","+cityval+","+quval;//保存到常用地址表
            $('#area_info').val(areaInfo);
			var address = $("#addressForm").serialize();
			$.ajax({
	        	url:'/leimingtech-admin/orders/updateOrderAddress',
	            type:'post',
	            data : address,
	            dataType:'json',
	            success:function(data){
	            	if(data.result==1){
						layer.msg('保存成功', {icon: 1, time:500}, function(){
							location.reload();
						});
	            	}else{
	            		//保存,取消链接标签设置为显示
						$(obj).attr("onclick","saveAddress();");
	            	}
	            },error:function(){
	            	//保存,取消链接标签设置为显示
					$(obj).attr("onclick","saveAddress();");
	            	cancel();
	            	layer.msg('通信失败', {icon: 2});
	            }
	        });
		}
	}
	
	//修改收货地址
	function updateAddress(){
		//获取收货地址form表单下的所有input
		var transin = $("#addressForm").find("input");
		//获取收货地址form表单下的所有<em>
		var formems = $("#addressForm").find("em");
		//获取收货地址form表单下的所有<span>
		var formsp = $("#addressForm").find("span");
		//收货地址form表单下的所有input设置为显示
		transin.css("display","inline");
		//收货地址form表单下的所有<em>设置为显示
		formems.css("display","inline");
		//收货地址form表单下的所有<span>设置为隐藏
		formsp.css("display","none");
		//修改收货地址链接标签设置为隐藏
		$("#update_address").css("display","none");
		//保存,取消链接标签设置为显示
		$("#save_address").css("display","inline");
		//收货地区选择显示
		$("#region").css("display","inline");
		$("#region").find("span").css("display","inline");
	}
	
	//取消修改
	function cancel(){
		//获取收货地址form表单下的所有input
		var transin = $("#addressForm").find("input");
		//获取收货地址form表单下的所有<em>
		var formems = $("#addressForm").find("em");
		//获取收货地址form表单下的所有<span>
		var formsp = $("#addressForm").find("span");
		//获取收货地址form表单下的所有<label>
		var formlab = $("#addressForm").find("label");
		//收货地址form表单下的所有input设置为隐藏
		transin.css("display","none");		
		//收货地址form表单下的所有<em>设置为隐藏
		formems.css("display","none");
		//收货地址form表单下的所有<span>设置为显示
		formsp.css("display","inline");
		//修改收货地址链接标签设置为显示
		$("#update_address").css("display","inline");
		//保存,取消链接标签设置为隐藏
		$("#save_address").css("display","none");
		//收货地区选择隐藏
		$("#region").css("display","none");
		//删除validation的错误label
		formlab.remove();
	}
</script>


</body></html>