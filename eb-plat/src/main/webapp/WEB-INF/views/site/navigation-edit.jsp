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
<script type="text/javascript" src="./管理后台-导航编辑_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-导航编辑_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-导航编辑_files/jquery.ui.css">
<script type="text/javascript" src="./管理后台-导航编辑_files/common_select.js" charset="utf-8"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>页面导航</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/list"><span>管理</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/forward?id=0"><span>新增</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>编辑</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form id="navigation_form" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/website/navigation/edit">
        <input type="hidden" name="navId" value="6">
        <table class="table tb-type2">
            <tbody>
            <tr class="noborder">
                <td colspan="2" class="required"><label>  导航类型</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><ul class="nofloat">
                    <li class="left w100pre"><span class="radio">
                <input type="radio" checked="checked" value="0" name="navType" id="diy" onclick="showType(&#39;diy&#39;);">
                <label for="diy">自定义导航</label>
                </span> </li>
                    <li class="left w100pre"><span class="radio">
                <input type="radio" value="1" name="navType" id="goods_class" onclick="showType(&#39;goods_class&#39;);">
                <label for="goods_class">商品分类</label>
                </span>
                        <select name="gcId" id="goods_class_id" style="display: none;">
                            <option value="2c7ac8dd602e4c5e863bb0c2a2c29591">&nbsp;&nbsp;潮流女装</option>
                                    <option value="0ad0d64a6812448384e243025f40717f">&nbsp;&nbsp;&nbsp;&nbsp;裙装</option>
                                            <option value="ab21f2a220a546e5ad9e92b6691ab20f">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;套装裙</option>
                                            <option value="fb40b602d0e341f999f6b42923255464">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牛仔裙</option>
                                            <option value="fca0b3971af14801b1d48d35d5876be1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;蕾丝连衣裙</option>
                                            <option value="8342470523e94f13822947253caf172d">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性感连衣裙</option>
                                            <option value="930791e2f18b4b6f96a884cb2f205681">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;棉麻连衣裙</option>
                                            <option value="03b1ebebd953402b9d6ec9734c3c52a1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;雪纺连衣裙</option>
                                            <option value="5b57890260ae43f98d38a44ce70617d3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;针织连衣裙</option>
                                            <option value="668420d4397f4249bc59b7f1ceebd64c">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长袖连衣裙</option>
                                            <option value="0942eb28b6d847ca83a9937720ac4434">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;秋季连衣裙</option>
                            <option value="2848fbbb6ea84f6ba592f44e3f3d340c">&nbsp;&nbsp;珠宝，首饰</option>
                                    <option value="2c18a72888ab48cca1f6c57f391fb001">&nbsp;&nbsp;&nbsp;&nbsp;黄金</option>
                                            <option value="941bc7e149b5409fb00274ab4624bbf3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项链</option>
                                    <option value="30bb4050c0e84c4c804a62c69b0b578e">&nbsp;&nbsp;&nbsp;&nbsp;和田玉</option>
                                    <option value="65745ef8757a40ff92030bbfbb81144b">&nbsp;&nbsp;&nbsp;&nbsp;琥珀</option>
                                    <option value="7fb8d1c2a7404c8e96036703ad8bbeb5">&nbsp;&nbsp;&nbsp;&nbsp;珍珠</option>
                                    <option value="8ec19d064b084c0c954d4b271e074588">&nbsp;&nbsp;&nbsp;&nbsp;铂金</option>
                                    <option value="c5c900a924cb4a929151f4a52c1a47e3">&nbsp;&nbsp;&nbsp;&nbsp;玉器</option>
                                            <option value="027bb110f4934d5787a0cb782ab1a28e">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;镯子</option>
                                    <option value="c74f0152eea2420c8edf1aa731816dca">&nbsp;&nbsp;&nbsp;&nbsp;钻石</option>
                                            <option value="fceccc248e2c4a8f9f854611b01aeafa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;钻戒</option>
                                    <option value="cc3b70832be8431db2d5a73c83566065">&nbsp;&nbsp;&nbsp;&nbsp;玛瑙</option>
                                            <option value="be9c5f4e505c4dc2a23d35286b504e44">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对戒</option>
                            <option value="e1dd743764d04071971d2cc57e5f6483">&nbsp;&nbsp;家用电器 户外运动</option>
                                    <option value="cee9e37926c043d8aff6f9be1a16a23c">&nbsp;&nbsp;&nbsp;&nbsp;生活家电</option>
                                            <option value="c839a6f9a80147ebac8144188c72c7a8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;吸尘器</option>
                                            <option value="ca42132854d748c785b77ce87f747ccd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平板电视</option>
                                    <option value="5036aaad94084eac9409265f81ca3a9a">&nbsp;&nbsp;&nbsp;&nbsp;厨卫家电</option>
                                    <option value="2039f5e4450c433dbd2c128df355013a">&nbsp;&nbsp;&nbsp;&nbsp;体育用品</option>
                                    <option value="f8ab735d91874f30a1b17a08067fe4ba">&nbsp;&nbsp;&nbsp;&nbsp;户外健身</option>
                                            <option value="5b2350f4e7bc4b5d9a0efae8bf47c70b">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;羽毛球</option>
                            <option value="28ed715304e4437d962938964011ac95">&nbsp;&nbsp;美妆洗护</option>
                                    <option value="62a5ede1cca74b59b4357037eefd8835">&nbsp;&nbsp;&nbsp;&nbsp;美妆</option>
                                            <option value="c2ee0d0000484d78a2759fffc4f7ceb9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;洁面</option>
                                            <option value="c6ce5d8a0d56453191b85e606bd56790">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乳液</option>
                                            <option value="f78cabdccd8142879ed12006827d18f0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;香水</option>
                                    <option value="f0c1670a220a46a2a0ae5cf3bfad9a5f">&nbsp;&nbsp;&nbsp;&nbsp;个人护理</option>
                                            <option value="060be0d2ead34a95b2cdbc840b4fc703">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;洗发水</option>
                                            <option value="26a71535b1d04fe4b78b7a582aa1cbee">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;沐浴露</option>
                                            <option value="c3011be3cffc42c5a60efaf7035a5061">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;洗手液</option>
                            <option value="139eaf1f1e814a7fa93b903049c4771d">&nbsp;&nbsp;家居家纺</option>
                                    <option value="40617af5faab402d8ee2afe4e4874b82">&nbsp;&nbsp;&nbsp;&nbsp;布艺软饰</option>
                                            <option value="9a250ad9207e419382fdaa2740a02a06">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家居饰品</option>
                                            <option value="f525b2b73ced4b4e82f801b35266d89c">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抱枕</option>
                                            <option value="fc6835bd7c32451d8f71cd66adeec076">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;桌布</option>
                                    <option value="7ed2e0c7c04d4abb8e963b19b0c6bbbc">&nbsp;&nbsp;&nbsp;&nbsp;床上用品</option>
                                            <option value="13d661eeebd949ed80fc53b2ce31d6ce">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;床垫</option>
                                            <option value="4ddda2c0799e499bb9b03bed3cae6ff3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;被服</option>
                                            <option value="88368019b84f4f13aa5caf7cc3b0bdfa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时尚套件</option>
                                    <option value="81f34e9c10cc4c4dbaba62670f636973">&nbsp;&nbsp;&nbsp;&nbsp;家居用品</option>
                                            <option value="851cc790dc084cc19bf91d87f4f651b3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生活用品</option>
                                            <option value="ad12568089c347d2a66d9d81a096b39e">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地毯</option>
                                            <option value="c53f19c097b5499d88335b4869029606">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;窗帘</option>
                            <option value="625bb2e038214198805db26596201210">&nbsp;&nbsp;酒类 生鲜 食品</option>
                                    <option value="dc1a74fc229940fc8f31d9594d715d8d">&nbsp;&nbsp;&nbsp;&nbsp;南北干活</option>
                                    <option value="6160c39bbc8d482091694b0b48118244">&nbsp;&nbsp;&nbsp;&nbsp;生鲜食品</option>
                                            <option value="4cc444870c704f1391be1a88601d4bd9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;蔬菜水果</option>
                                            <option value="897a6a856dd3496b88c2df663fa2bf45">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;海参</option>
                                            <option value="c20c427666b146858708ba6a96f3c7fc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;海鲜水产</option>
                                    <option value="6c41104baa21437a839f9ad2cb8c5075">&nbsp;&nbsp;&nbsp;&nbsp;美食</option>
                                    <option value="6d959b2b8421430888423c6d761bc354">&nbsp;&nbsp;&nbsp;&nbsp;地方特产</option>
                                            <option value="2f883d43de9f4e6e8572cfce29a85852">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;华南区</option>
                                            <option value="9894c3cbbc044542a17e03d0a83c5aff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;华北区</option>
                                            <option value="b226fca9ff8848a08400087deb059ef4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西南区</option>
                                    <option value="cdbcbad4787a4be5b82b555879a9bd6f">&nbsp;&nbsp;&nbsp;&nbsp;中外名酒</option>
                                            <option value="50cea2a3514a4ea0805fd382399c6e62">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;白酒</option>
                                            <option value="548ebad615b445fa823ce20e31274bc9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;啤酒</option>
                                            <option value="f38d8b64ab9b4b25b76e070fb8d90fc2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;葡萄酒</option>
                            <option value="c748d987f7f043b3a4aa13c180cf77c4">&nbsp;&nbsp;母婴用品 玩具图书</option>
                                    <option value="a33112c86d3f4ded9da98a0576e85002">&nbsp;&nbsp;&nbsp;&nbsp;图书</option>
                                            <option value="4d796bb80f45414ea8f1e5a425db37e6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7岁以上</option>
                                            <option value="2c15c69c15e947e9956628b9bceff135">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4-6岁图书</option>
                                            <option value="7ef1ed2ade0848798f5ff64d76bbea57">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0-3岁绘本</option>
                                    <option value="0d7f84e4be344a9da50335d42bbbf6de">&nbsp;&nbsp;&nbsp;&nbsp;玩具</option>
                                            <option value="0af814cc6c554ef794a7050ddc2c2bbf">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爬行垫围栏</option>
                                            <option value="6ca08699928942c4ace91b74dd1eeb3c">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手拿玩具</option>
                                            <option value="7d6d0ab210644f09b40f0f34dec6144c">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电动玩具</option>
                                    <option value="5a63cb1ccbc94bac8e96bbcd313e475d">&nbsp;&nbsp;&nbsp;&nbsp;母婴用品</option>
                                            <option value="9aa9d94dbee643b5ad005140b46c28e8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;儿童用品</option>
                                            <option value="a4a35c6a222f4817bbe40d22cde9cacd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;童车童床</option>
                                            <option value="d47885e4dd814daa85421c7d312633c5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;奶粉</option>
                                    <option value="e0ff263a84c74d7eaba5bb02084940f7">&nbsp;&nbsp;&nbsp;&nbsp;食品</option>
                            <option value="8a2defb1ebdf4458ab76b9369611586c">&nbsp;&nbsp;手机 数码 电脑</option>
                                    <option value="0c52126b10e14c3e93c97ca73a4eb60f">&nbsp;&nbsp;&nbsp;&nbsp;手机</option>
                                            <option value="066f01becd0a47e990b1e366c5e9364a">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IPHONE</option>
                                            <option value="17973fea43ad4f0989b2d1c8dfbeb72f">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;三星</option>
                                            <option value="3087b134d36a4a56bcfa6aab71b7c39a">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;华为</option>
                                            <option value="d74b480d2249499eb7437099bb58cff3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;小米</option>
                                    <option value="0f2084d600d74d8ab1f3c7a5e049bbe1">&nbsp;&nbsp;&nbsp;&nbsp;电脑</option>
                                            <option value="63227d06e1ec42208f33b1cb36045b7e">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;笔记本</option>
                                            <option value="6f7fd31911364f4abffdbf00f21d0633">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;超级本</option>
                                            <option value="a450210ec82b4867a802caf0cb5090f6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台式机</option>
                                            <option value="b56b0ccb802b494b966ccab11b7bd5bc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一体机</option>
                                    <option value="775e0aea66ba4c10bef2c0aa1a874a01">&nbsp;&nbsp;&nbsp;&nbsp;数码配件</option>
                                            <option value="351f2b5af8304f1c9a3c7ee0f32d7a18">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机膜</option>
                                            <option value="57bb63c247fa4193bbd54e063e1ad9cc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电池</option>
                                            <option value="67ea0382f21549cf838002cfa8deda08">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内存卡</option>
                                            <option value="acd1ab926d3c4235818cb6771bc1748c">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;充电器</option>
                            <option value="eae1aa38c0c6451d8f9436e203880d78">&nbsp;&nbsp;女装 男装 鞋靴 箱包</option>
                                    <option value="d579627f99ba47968e37a203875d7ad7">&nbsp;&nbsp;&nbsp;&nbsp;女装</option>
                                            <option value="81ac0ba8e6ee404084d07840bc95f517">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;半身裙</option>
                                            <option value="9303960bb76f4abf961acb6daa815ff3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;套装</option>
                                            <option value="e980f3c519c842ff94db019effe767c2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上衣</option>
                                    <option value="36cfeecf4a524016b7122034a3b2b516">&nbsp;&nbsp;&nbsp;&nbsp;箱包</option>
                                            <option value="1a5b03508a3643f7886989ce37d5444b">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;背包</option>
                                            <option value="27f949f32e05491da8769121bc948ef8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;拉杆箱</option>
                                            <option value="7c93827c8bcf417695d459ef52cbcf5a">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单肩包</option>
                                            <option value="a14eac569a81411e9e6cc70f07f979d3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;斜跨包</option>
                                    <option value="3aef387727f64cc79494776ea595b0cc">&nbsp;&nbsp;&nbsp;&nbsp;男装</option>
                                            <option value="0baf2e9ef9c04bef810aa50a502299bd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;夹克</option>
                                            <option value="2aff7152b9e540c9b44c49137fe79b35">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;衬衣</option>
                                            <option value="ae8165c6b68148889eaa382522e47b74">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长裤</option>
                                    <option value="c9c3137e75d94ef5b58fcd1892399d9a">&nbsp;&nbsp;&nbsp;&nbsp;鞋靴</option>
                                            <option value="60b8cdb5afc44b8fbd759ac25910b617">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女鞋</option>
                                            <option value="d542e34745db493ea42d9ae49c2c54b9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;男鞋</option>
                                            <option value="dda98aabef6f4753863e14924e00937a">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;童鞋</option>
                                    <option value="e29f56d378e3463a87cdfed62ee2e206">&nbsp;&nbsp;&nbsp;&nbsp;童装</option>
                        </select>
                    </li>
                    <li class="left w100pre"><span class="radio">
                <input type="radio" value="2" name="navType" id="article_class" onclick="showType(&#39;article_class&#39;);">
                <label for="article_class">文章分类</label>
                </span>
                        <select name="acId" id="article_class_id" style="display: none;">
                            <option value="15">&nbsp;&nbsp;好店主如何养成</option>
                            <option value="1">&nbsp;&nbsp;店主之家</option>
                                    <option value="15">&nbsp;&nbsp;&nbsp;&nbsp;好店主如何养成</option>
                            <option value="2">&nbsp;&nbsp;新手上路</option>
                            <option value="3">&nbsp;&nbsp;支付方式</option>
                            <option value="4">&nbsp;&nbsp;配送方式</option>
                            <option value="5">&nbsp;&nbsp;售后服务</option>
                            <option value="7">&nbsp;&nbsp;关于我们</option>
                            <option value="8">&nbsp;&nbsp;商城公告</option>
                            <option value="9">&nbsp;&nbsp;帮助中心</option>
                        </select>
                    </li>
                </ul></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation" for="navTitle">标题:</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" value="联系我们" name="navTitle" id="nav_title" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(251, 251, 251);">
                <td colspan="2" class="required"><label for="navUrl">链接:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" value="http://b2b2c.leimingtech.com/help/content?acId=7&amp;articleId=38" name="navUrl" id="nav_url" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label>
                    <label for="type">所在位置:</label>
                </label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform "><ul>
                    <li>
                        <input type="radio" value="0" name="navLocation" id="nav_location0">
                        <label for="nav_location0">头部</label>
                    </li>
                    <li>
                        <input type="radio" value="1" name="navLocation" id="nav_location1">
                        <label for="nav_location1">中部</label>
                    </li>
                    <li>
                        <input type="radio" checked="checked" value="2" name="navLocation" id="nav_location2">
                        <label for="nav_location2">底部</label>
                    </li>
                </ul></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label>
                    <label>新窗口打开:</label>
                </label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform onoff"><label for="nav_new_open1" class="cb-enable selected"><span>是</span></label>
                    <label for="nav_new_open0" class="cb-disable "><span>否</span></label>
                    <input id="nav_new_open1" name="navNewOpen" checked="checked" value="1" type="radio">
                    <input id="nav_new_open0" name="navNewOpen" value="0" type="radio"></td>
                <td class="vatop tips"></td>
            </tr>
            <tr>
                <td colspan="2" class="required"><label for="nav_sort">排序:</label></td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" value="255" name="navSort" id="nav_sort" class="txt"></td>
                <td class="vatop tips"></td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="tfoot">
                <td colspan="15"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script>
    //按钮先执行验证再提交表单
    $(function(){$("#submitBtn").click(function(){
        if($("#navigation_form").valid()){
            $("#navigation_form").submit();
        }
    });
    });
    //
    $(document).ready(function(){
        $('#navigation_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
                nav_title : {
                    required : true
                },
                nav_sort:{
                    number   : true
                }
            },
            messages : {
                navTitle : {
                    required : '标题不能为空'
                },
                navSort  : {
                    number   : '分类排序仅能为数字'
                }
            }
        });

    });

    function showType(type){
        $('#goods_class_id').css('display','none');
        $('#article_class_id').css('display','none');
        $('#activity_id').css('display','none');
        if(type == 'diy'){
            $('#nav_url').attr('disabled',false);
        }else{
            $('#nav_url').attr('disabled',true);
            $('#'+type+'_id').show();
        }
    }
</script>


</body></html>