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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
	<link href="${pageContext.request.contextPath}/static/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/ajaxfileupload.js"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>广告管理</h3>
        <ul class="tab-base">
            <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/adv/list"><span>管理</span></a></li>
            <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/adv/forward?advId=0"><span>新增</span></a></li>
            <li><a href="javascript:void(0)" class="current"><span>编辑</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="adv_form" action="http://b2b2c.leimingtech.com/leimingtech-admin/adv/saveOrUpdate" method="post">
    <input type="hidden" name="advId" value="14">
    <table class="table tb-type2">
        <tbody>
        	
        	<tr class="noborder">
	            <td colspan="2" class="required"><label class="validation" for="advTitle">广告位:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
					APP启动广告
					<input name="apId" value="14" type="hidden">		
				</td>
	            <td class="vatop tips"></td>
	        </tr>
	        <tr class="noborder">
	            <td colspan="2" class="required"><label class="validation" for="advTitle">广告标题:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
	            <input type="text" value="app二" name="advTitle" id="advTitle" maxlength="100" class="txt"></td>
	            <td class="vatop tips"></td>
	        </tr>
	      <tr style="background: rgb(255, 255, 255);">
	            <td colspan="2" class="required"><label for="resUrl" class="validation">资源:</label></td>
	        </tr>
	        <tr class="noborder" style="background: rgb(251, 251, 251);">
	            <td class="vatop rowform">
					<input type="hidden" name="resUrl" id="resUrl" value="/upload/img/adv/1441162177006.png" class="type-file-text">
	               	<input name="myfiles" id="myfiles" type="file" multiple="multiple" onchange="ajaxFileUploads(&#39;myfiles&#39;,&#39;resUrl&#39;);">
	               		<img id="resUrl" name="resUrl" width="600px" src="./管理后台-广告编辑_files/1441162177006.png">
	                
	            </td>
	            <td class="vatop tips">图片／Flash/GIF</td>
	        </tr>
	        
	       <tr>
	            <td colspan="2" class="required"><label for="parent_id">广告url:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
	            <input type="text" value="www.leimingtech.com" name="advUrl" id="advUrl" maxlength="100" class="txt">
	            </td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" class="required"><label for="startDate" class="validation">开始时间:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform"><input type="text" class="txt Wdate" value="2015-09-24 11:44:41" name="startTime1" id="startTime" onclick="WdatePicker({skin:&#39;twoer&#39;,dateFmt:&#39;yyyy-MM-dd HH:mm:ss&#39;});"></td>
	           <td class="vatop tips"></td>
	        </tr>
	        
	       <tr>
	            <td colspan="2" class="required"><label for="endTime" class="validation">结束时间:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform">
	            	<input type="text" class="txt Wdate" name="endTime1" id="endTime" value="2016-01-18 05:31:21" onclick="WdatePicker({skin:&#39;twoer&#39;,dateFmt:&#39;yyyy-MM-dd HH:mm:ss&#39;});">
	            </td>
	            <td class="vatop tips"></td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" class="required"><label for="sort" class="validation">排序:</label></td>
	        </tr>
	        <tr class="noborder">
	            <td class="vatop rowform"><input type="text" value="255" name="sort" id="sort" class="txt"></td>
	            <td class="vatop tips"></td>
	        </tr>
	        
        </tbody>
        <tfoot>
	        <tr>
	            <td colspan="2"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
	        </tr>
        </tfoot>
    </table>
</form>
</div>
<script>
    //按钮先执行验证再提交表单
    $(function(){
        $("#submitBtn").click(function(){
            if($("#adv_form").valid()){
                $("#adv_form").submit();
           }
        });
        $('#adv_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },
            rules : {
                apId: {
                    required : true
                },
                advTitle: {
                    required : true
                },
                advUrl: {
                    required : true
                },
                startTime1: {
                    required : true
                },
                endTime1: {
                    required : true
                }
            },
            messages : {
                apId : {
                    required : '请选择广告位'
                },
                advTitle: {
                    required : '请填写广告标题'
                },
                advUrl: {
                    required : '请填写广告url'
                },
                startTime1: {
                    required : '请选择开始时间'
                },
                endTime1: {
                    required : '请选择结束时间'
                }
            }
        });
    });
    
  //上传图片
	function ajaxFileUploads(myfiles,resUrl){
	   $.ajaxFileUpload({
	        //处理文件上传操作的服务器端地址
	        url:"/leimingtech-admin/adv/uploadImage",
	        secureuri:false,                       //是否启用安全提交,默认为false
	        fileElementId:myfiles,           //文件选择框的id属性
	        dataType:'json',                       //服务器返回的格式,可以是json或xml等
	        success:function(data, status){//服务器响应成功时的处理函数
	            if(data.success == true ){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
	            	$("img[id='resUrl']").attr("src", "http://www.leimingtech.com:99/"+data.result);
	            	$("#resUrl").val(data.result);
	            }
	        },
	        error:function(data, status, e){//服务器响应失败时的处理函数
	             alert('图片上传失败，请重试！！');
	        }
	    });
	}
  
	//删除
	function reMove(){
		$("img[id='resUrl']").attr("src", "/leimingtech-admin/res/images/nopic.png");
    	$("#resUrl").val("");
	}
	
</script>


</body></html>