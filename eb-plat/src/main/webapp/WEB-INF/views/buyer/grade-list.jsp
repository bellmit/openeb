<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    
    <title>ç®¡çåå°</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
	
	<script type="text/javascript">
	function initGoodsInfo(){
		if($("[name=goodsInfo]").length == 0){
			$("#theGoodsInfo").css("display","block");
		}
	}
	 $(function(){
		 initGoodsInfo();
	 });
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
	        });
	        
	        gcategoryInit('gcategory');
	    });
	    function delType(){
	        var items = $("input[name='ids']:checked").length;
	        if (items==0) {
	            alert("è¯·è³å°éæ©ä¸ä¸ªè¦å é¤çé¡¹ç®");
	        }else{
	            if(confirm('æ¨ç¡®å®è¦å é¤å?')){
	                $('#form_list').submit();
	            }
	        }
	    }
	    function delRow(id){
	    
	        if(confirm('æ¨ç¡®å®è¦å é¤å?')) {
	        debugger;
	           	$("#id").val(id);
	            $('#form_list').submit();
	        }
	    }
	</script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
    <div class="fixed-bar">
        <div class="item-title">
            <h3>ä¼åç­çº§</h3>
            <ul class="tab-base">
                <li><a class="current" href="JavaScript:void(0);"><span>åè¡¨</span></a></li>
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/add"><span>æ°å¢</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <!-- <form method="post" name="formSearch" id="formSearch" action="/leimingtech-admin/group/dictionaryGroup/list">
        <input type="hidden" name="pageNo" value="1">
        <table class="tb-type1 noborder search">
			<tbody>
				<tr>
					<th><label for="search_brand_name">æç´¢</label></th>
					<td><input type="text" id="groupName" name="groupName" value="" class="mls_names" /></td>
					<td><a href="javascript:void(0);" id="ncsubmit"
						class="btn-search " title="æ¥è¯¢">&nbsp;</a>
					</td>
				</tr>
			</tbody>
		</table>
    </form> -->
    <table id="prompt" class="table tb-type2">
        <tbody>
        <tr class="space odd">
            <th colspan="12" class="nobg"> <div class="title">
                <h5>æä½æç¤º</h5>
                <span class="arrow"></span> </div>
            </th>
        </tr>
        <tr class="odd" style="display: none;">
            <td><ul>
                <li>ä¼åç­çº§çè®¾ç½®</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <form id="form_list" method="post" action="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/delete">
    <input type="hidden" id="id" name="id" value="">
        <table class="table tb-type2">
            <thead>
            <tr class="thead">
                <th>ç­çº§åç§°</th>
                <th>æ¯å¦é»è®¤</th>
                <th>ç­çº§æéç§¯å</th>
                <th>ä¼æ ç¾åæ¯ï¼ææ£ï¼</th>
                <th class="align-center">æä½</th>
            </tr>
            </thead>
            <tbody>
	            <tr class="hover edit" name="goodsInfo" style="background: rgb(255, 255, 255);">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808595823.png" style="height: 30px;width: 30px;">éçä¼å
	                </td>
	                <td class="yes-onoff">
                    	æ¯
                	</td>
	                <td class="">500</td>
	                <td>99 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=19a14a9cc03542d5bcf6060b0b050782">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;19a14a9cc03542d5bcf6060b0b050782&#39;)">å é¤</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo" style="background: rgb(255, 255, 255);">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808632777.png" style="height: 30px;width: 30px;">é¶çä¼å
	                </td>
	                <td class="yes-onoff">
                    	å¦
                	</td>
	                <td class="">1000</td>
	                <td>95 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=644610a083c04e88ac00105706f3d3dd">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;644610a083c04e88ac00105706f3d3dd&#39;)">å é¤</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808881999.png" style="height: 30px;width: 30px;">ç´«é»ä¼å
	                </td>
	                <td class="yes-onoff">
                    	å¦
                	</td>
	                <td class="">10000</td>
	                <td>88 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=a545f6a89c6e425b878f101a266f2a14">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;a545f6a89c6e425b878f101a266f2a14&#39;)">å é¤</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808972781.png" style="height: 30px;width: 30px;">è¶çº§VIP
	                </td>
	                <td class="yes-onoff">
                    	å¦
                	</td>
	                <td class="">50000</td>
	                <td>80 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=abfbde3b1ff342478c88e6430f59653c">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;abfbde3b1ff342478c88e6430f59653c&#39;)">å é¤</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808820732.png" style="height: 30px;width: 30px;">é»ç³ä¼å
	                </td>
	                <td class="yes-onoff">
                    	å¦
                	</td>
	                <td class="">5000</td>
	                <td>90 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=d0c066daa3d84040a6d92ce2d487b549">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;d0c066daa3d84040a6d92ce2d487b549&#39;)">å é¤</a>
	                </td>
	            </tr>
	            <tr class="hover edit" name="goodsInfo">
	                <td class="">
	                	<img src="./ç®¡çåå°-ä¼åç­çº§_files/1458808674262.png" style="height: 30px;width: 30px;">éçä¼å
	                </td>
	                <td class="yes-onoff">
                    	å¦
                	</td>
	                <td class="">2000</td>
	                <td>94 %</td>
	                <td class="align-center" style="width:170px">
		                <a href="http://b2b2c.leimingtech.com/leimingtech-admin/member/grade/update?id=e006d8f55f3f4b53b5f2ffabf037cb3a">ç¼è¾</a> | 
		                <a href="javascript:void(0)" onclick="delRow(&#39;e006d8f55f3f4b53b5f2ffabf037cb3a&#39;)">å é¤</a>
	                </td>
	            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="5">
<div class="pagination">
    <ul><li>
                </li><li><span>é¦é¡µ</span></li>
                    <li><span class="currentpage">1</span></li>
                <li><span>æ«é¡µ</span></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >1) {
                    no =1;
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
            </tr><tr>
            </tr></tfoot>
        </table>
    </form>
</div>


</body></html>