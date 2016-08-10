<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.seller_menu_class.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
	<link href="${pageContext.request.contextPath}/static/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>分类管理</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/shopMenu/list"><span>管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/shopMenu/form" class="current"><span>新增</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="shopSellerMenu_form" action="${pageContext.request.contextPath}/shopMenu/saveOrUpdate" method="post">
    <input type="hidden" name="menuId" value="0">
    <input type="hidden" name="form_submit" value="ok">
    <table class="table tb-type2" style="width:auto;">
        <tbody>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
            	<td colspan="2" class="required"><label class="validation" for="menuName">菜单名称:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(255, 255, 255);">
	            <td class="vatop rowform"><input type="text" value="" name="menuName" id="menuName" maxlength="20" class="txt"></td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	        <tr>
            <td colspan="2" class="required"><label for="menuParentId">上级分类:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
	                <select name="menuParentId" id="menuParentId">
	                    <option value="0">请选择</option>
	                        <option value="100">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="101">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="102">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="104">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="105">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="106">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="107">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="108">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="109">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="110">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="111">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="112">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="113">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="114">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="115">
	                            &nbsp;&nbsp;结算信息设置</option>
	                            <option value="117">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="118">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                            <option value="131">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="132">
	                                &nbsp;&nbsp;&nbsp;&nbsp;修改</option>
	                        <option value="116">
	                            &nbsp;&nbsp;订单结算</option>
	                            <option value="119">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="120">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="117">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="118">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="119">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="120">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="122">
	                            &nbsp;&nbsp;导入商品信息</option>
	                            <option value="123">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="124">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="123">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="124">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="130">
	                            &nbsp;&nbsp;退款记录</option>
	                        <option value="131">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="132">
	                            &nbsp;&nbsp;修改</option>
	                        <option value="141">
	                            &nbsp;&nbsp;换货记录</option>
	                        <option value="18">
	                            &nbsp;&nbsp;商品管理</option>
	                            <option value="19">
	                                &nbsp;&nbsp;&nbsp;&nbsp;商品发布</option>
	                            <option value="20">
	                                &nbsp;&nbsp;&nbsp;&nbsp;出售中的商品</option>
	                            <option value="21">
	                                &nbsp;&nbsp;&nbsp;&nbsp;仓库中的商品</option>
	                            <option value="22">
	                                &nbsp;&nbsp;&nbsp;&nbsp;违规下架的商品</option>
	                            <option value="23">
	                                &nbsp;&nbsp;&nbsp;&nbsp;下架的商品</option>
	                            <option value="24">
	                                &nbsp;&nbsp;&nbsp;&nbsp;待审核的商品</option>
	                            <option value="25">
	                                &nbsp;&nbsp;&nbsp;&nbsp;已拒绝的商品</option>
	                            <option value="26">
	                                &nbsp;&nbsp;&nbsp;&nbsp;品牌列表</option>
	                            <option value="27">
	                                &nbsp;&nbsp;&nbsp;&nbsp;店铺分类</option>
	                            <option value="122">
	                                &nbsp;&nbsp;&nbsp;&nbsp;导入商品信息</option>
	                        <option value="19">
	                            &nbsp;&nbsp;商品发布</option>
	                            <option value="55">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="60">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="20">
	                            &nbsp;&nbsp;出售中的商品</option>
	                            <option value="61">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="62">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="21">
	                            &nbsp;&nbsp;仓库中的商品</option>
	                            <option value="63">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="64">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="22">
	                            &nbsp;&nbsp;违规下架的商品</option>
	                            <option value="65">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="66">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="23">
	                            &nbsp;&nbsp;下架的商品</option>
	                            <option value="67">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="68">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="24">
	                            &nbsp;&nbsp;待审核的商品</option>
	                            <option value="69">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="70">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="25">
	                            &nbsp;&nbsp;已拒绝的商品</option>
	                            <option value="71">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="72">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="26">
	                            &nbsp;&nbsp;品牌列表</option>
	                            <option value="73">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="74">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="27">
	                            &nbsp;&nbsp;店铺分类</option>
	                            <option value="75">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="76">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="28">
	                            &nbsp;&nbsp;交易管理</option>
	                            <option value="34">
	                                &nbsp;&nbsp;&nbsp;&nbsp;评价管理</option>
	                            <option value="33">
	                                &nbsp;&nbsp;&nbsp;&nbsp;物流工具</option>
	                            <option value="32">
	                                &nbsp;&nbsp;&nbsp;&nbsp;店铺商品交易</option>
	                            <option value="31">
	                                &nbsp;&nbsp;&nbsp;&nbsp;发货设置</option>
	                            <option value="30">
	                                &nbsp;&nbsp;&nbsp;&nbsp;发货</option>
	                            <option value="29">
	                                &nbsp;&nbsp;&nbsp;&nbsp;订单管理</option>
	                        <option value="29">
	                            &nbsp;&nbsp;订单管理</option>
	                            <option value="77">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="78">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="30">
	                            &nbsp;&nbsp;发货</option>
	                            <option value="79">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="80">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="31">
	                            &nbsp;&nbsp;发货设置</option>
	                            <option value="81">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="82">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="32">
	                            &nbsp;&nbsp;店铺商品交易</option>
	                            <option value="83">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="84">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="33">
	                            &nbsp;&nbsp;物流工具</option>
	                            <option value="85">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="86">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="34">
	                            &nbsp;&nbsp;评价管理</option>
	                            <option value="87">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="88">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="35">
	                            &nbsp;&nbsp;促销管理</option>
	                            <option value="36">
	                                &nbsp;&nbsp;&nbsp;&nbsp;满就减</option>
	                            <option value="37">
	                                &nbsp;&nbsp;&nbsp;&nbsp;优惠券管理</option>
	                            <option value="b396b6efdd5b4b238e06fa056b44b7f2">
	                                &nbsp;&nbsp;&nbsp;&nbsp;满免邮</option>
	                        <option value="36">
	                            &nbsp;&nbsp;满就减</option>
	                            <option value="56">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="57">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="37">
	                            &nbsp;&nbsp;优惠券管理</option>
	                            <option value="58">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="91">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="38">
	                            &nbsp;&nbsp;店铺设置</option>
	                            <option value="39">
	                                &nbsp;&nbsp;&nbsp;&nbsp;我的店铺</option>
	                            <option value="41">
	                                &nbsp;&nbsp;&nbsp;&nbsp;店铺设置</option>
	                            <option value="42">
	                                &nbsp;&nbsp;&nbsp;&nbsp;主题设置</option>
	                            <option value="115">
	                                &nbsp;&nbsp;&nbsp;&nbsp;结算信息设置</option>
	                        <option value="39">
	                            &nbsp;&nbsp;我的店铺</option>
	                            <option value="92">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="93">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="41">
	                            &nbsp;&nbsp;店铺设置</option>
	                            <option value="94">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="95">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="42">
	                            &nbsp;&nbsp;主题设置</option>
	                            <option value="96">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="97">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="43">
	                            &nbsp;&nbsp;客服管理</option>
	                            <option value="44">
	                                &nbsp;&nbsp;&nbsp;&nbsp;咨询管理</option>
	                            <option value="45">
	                                &nbsp;&nbsp;&nbsp;&nbsp;退货记录</option>
	                            <option value="130">
	                                &nbsp;&nbsp;&nbsp;&nbsp;退款记录</option>
	                            <option value="141">
	                                &nbsp;&nbsp;&nbsp;&nbsp;换货记录</option>
	                        <option value="44">
	                            &nbsp;&nbsp;咨询管理</option>
	                            <option value="98">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="99">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="45">
	                            &nbsp;&nbsp;退货记录</option>
	                            <option value="100">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="101">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="46">
	                            &nbsp;&nbsp;统计结算</option>
	                            <option value="47">
	                                &nbsp;&nbsp;&nbsp;&nbsp;流量统计</option>
	                            <option value="48">
	                                &nbsp;&nbsp;&nbsp;&nbsp;订单统计</option>
	                            <option value="49">
	                                &nbsp;&nbsp;&nbsp;&nbsp;购买率统计</option>
	                            <option value="50">
	                                &nbsp;&nbsp;&nbsp;&nbsp;结算统计</option>
	                            <option value="51">
	                                &nbsp;&nbsp;&nbsp;&nbsp;结算账单列表</option>
	                            <option value="116">
	                                &nbsp;&nbsp;&nbsp;&nbsp;订单结算</option>
	                        <option value="47">
	                            &nbsp;&nbsp;流量统计</option>
	                            <option value="102">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                        <option value="48">
	                            &nbsp;&nbsp;订单统计</option>
	                            <option value="113">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="114">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="49">
	                            &nbsp;&nbsp;购买率统计</option>
	                            <option value="104">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="105">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="50">
	                            &nbsp;&nbsp;结算统计</option>
	                            <option value="106">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="107">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="51">
	                            &nbsp;&nbsp;结算账单列表</option>
	                            <option value="108">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="109">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="52">
	                            &nbsp;&nbsp;账号</option>
	                            <option value="53">
	                                &nbsp;&nbsp;&nbsp;&nbsp;用户管理</option>
	                            <option value="54">
	                                &nbsp;&nbsp;&nbsp;&nbsp;用户角色</option>
	                        <option value="53">
	                            &nbsp;&nbsp;用户管理</option>
	                            <option value="59">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="110">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="54">
	                            &nbsp;&nbsp;用户角色</option>
	                            <option value="111">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                            <option value="112">
	                                &nbsp;&nbsp;&nbsp;&nbsp;编辑</option>
	                        <option value="55">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="56">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="57">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="58">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="59">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="60">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="61">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="62">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="63">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="64">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="65">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="66">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="67">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="68">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="69">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="70">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="71">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="72">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="73">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="74">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="75">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="76">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="77">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="78">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="79">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="80">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="81">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="82">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="83">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="84">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="85">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="86">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="87">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="88">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="91">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="92">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="93">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="94">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="95">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="96">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="97">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="98">
	                            &nbsp;&nbsp;查看</option>
	                        <option value="99">
	                            &nbsp;&nbsp;编辑</option>
	                        <option value="b396b6efdd5b4b238e06fa056b44b7f2">
	                            &nbsp;&nbsp;满免邮</option>
	                            <option value="d379704db17f465e94eb61232b610f57">
	                                &nbsp;&nbsp;&nbsp;&nbsp;修改</option>
	                            <option value="f606c778fba1410fb12d932fdf6a6c6d">
	                                &nbsp;&nbsp;&nbsp;&nbsp;查看</option>
	                        <option value="d379704db17f465e94eb61232b610f57">
	                            &nbsp;&nbsp;修改</option>
	                        <option value="f606c778fba1410fb12d932fdf6a6c6d">
	                            &nbsp;&nbsp;查看</option>
	                </select>
	            </td>
	            <td class="vatop tips">如果选择上级分类，那么新增的分类则为被选择上级分类的子分类</td>
	        </tr>
	        
	        <tr style="background: rgb(255, 255, 255);">
            <td colspan="2" class="required"><label for="menuUrl">网址:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform"><input type="text" value="" name="menuUrl" id="menuUrl" class="txt"></td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	        <tr>
                <td colspan="2" class="required"><label for="menuDescription">描述:</label></td>
         	</tr>
     		<tr class="noborder">
            	<td class="vatop rowform"><input type="text" value="" name="mDescription" id="mDescription" class="txt"></td>
        	</tr>
	        <tr>
	            <td colspan="2" class="required"><label for="menuIsshow">显示:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
		            <input type="radio" name="menuIsshow" value="1" checked="checked">显示
		            <input type="radio" name="menuIsshow" value="0">不显示
	            </td>
	            <td class="vatop tips">该菜单或操作是否显示到系统菜单中</td>
	        </tr>
	        <tr>
	            <td colspan="2" class="required"><label for="menuPermission">权限标识:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(251, 251, 251);">
	            <td class="vatop rowform"><input type="text" value="" name="menuPermission" id="menuPermission" class="txt"></td>
	            <td class="vatop tips">控制器中定义的权限标识，如：@RequiresPermissions("权限标识")</td>
	        </tr>
	        <tr>
	            <td colspan="2" class="required"><label for="menuSort" class="validation">排序:</label></td>
	        </tr>
	        
	        <tr class="noborder">
	            <td class="vatop rowform"><input type="text" value="0" name="menuSort" id="menuSort" class="txt"></td>
	            <td class="vatop tips">数字范围为0~255，数字越大越靠前</td>
	        </tr>
        </tbody>
        <tfoot>
	        <tr>
	        	<td colspan="2">
	            	<a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a>
	            </td>
	        </tr>
        </tfoot>
    </table>
</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.mousewheel.js"></script>
<script>
    //按钮先执行验证再提交表单
    $(function(){
        $("#submitBtn").click(function(){
            if($("#shopSellerMenu_form").valid()){
                $("#shopSellerMenu_form").submit();
            }
        });
        $('#shopSellerMenu_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
            	menuName: {
                    required : true,
                    maxlength: 10,
                    minlength: 1
                },
                /*menuUrl: {
                    required : true,
                    maxlength: 30,
                    minlength: 1
                },*/
                menuSort: {
                    required : true,
                    digits	 : true
                }
            },
            messages : {
            	menuName : {
                    required : '请填写菜单名称',
                    maxlength: '规格菜单名称长度应在1-10个字符之间',
                    minlength: '规格菜单名称长度应在1-10个字符之间'
                },
                /*menuUrl : {
                    required : '请填写菜单路径',
                    maxlength: '规格菜单路径长度应在1-30个字符之间',
                    minlength: '规格菜单路径长度应在1-30个字符之间'
                },*/
                menuSort: {
                    required : '请填写菜单排序',
                    digits   : '请填写整数'
                }
            }
        });
    });
</script>
</body>
</html>