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
<script type="text/javascript" src="./管理后台-文章新增_files/jquery.ui.js"></script>
<script type="text/javascript" src="./管理后台-文章新增_files/zh-CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="./管理后台-文章新增_files/jquery.ui.css">
<script type="text/javascript" src="./管理后台-文章新增_files/common_select.js" charset="utf-8"></script>
<link rel="stylesheet" href="./管理后台-文章新增_files/default.css">
<script charset="utf-8" src="./管理后台-文章新增_files/kindeditor.js"></script>
<script charset="utf-8" src="./管理后台-文章新增_files/kindeditor-all.js"></script>
<script charset="utf-8" src="./管理后台-文章新增_files/zh_CN.js"></script>
<script charset="utf-8" src="./管理后台-文章新增_files/layer.js"></script><link rel="stylesheet" href="./管理后台-文章新增_files/layer.css" id="layui_layer_skinlayercss">
<script type="text/javascript">
	$(function (){
        KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[id="content"]', {
                uploadJson : APP_BASE+'/kind/upload',
                afterCreate : function() {
                    var self = this;
                },
                afterBlur: function(){this.sync();}
            });
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
            <h3>文章管理</h3>
            <ul class="tab-base">
                <li><a href="http://b2b2c.leimingtech.com/leimingtech-admin/website/article/index"><span>管理</span></a></li>
                <li><a href="JavaScript:void(0);" class="current"><span>新增文章</span></a></li>
            </ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form action="http://b2b2c.leimingtech.com/leimingtech-admin/website/article/edit" method="post" name="saveForm" id="saveForm">
        <input type="hidden" name="form_submit" value="ok">
         <table class="table tb-type2 nobdb">
            <tbody>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation">标题：</label></td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" id="articleTitle" name="articleTitle" class="text" value=""></td>
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required"><label class="validation">所属分类：</label> </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform" id="gcategory">
                    <select class="select" name="acId" id="acId" style="height:25px;width:100px">
                        <option value="0">请选择</option>
                        	<option value="1"> 店主之家</option>
                                <option value="15">&nbsp;&nbsp;  好店主如何养成</option>
                        	<option value="2"> 新手上路</option>
                        	<option value="3"> 支付方式</option>
                        	<option value="4"> 配送方式</option>
                        	<option value="5"> 售后服务</option>
                        	<option value="7"> 关于我们</option>
                        	<option value="8"> 商城公告</option>
                        	<option value="9"> 帮助中心</option>
                    </select>
                </td>
                <td class="vatop tips">选择分类</td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">链接：</td>
            </tr>
            <tr class="noborder">
                <td class="vatop rowform"><input type="text" name="articleUrl" class="text" value=""></td>
                <td class="vatop tips">当填写"链接"后点击文章标题将直接跳转至链接地址，不显示文章内容。链接格式请以http://开头</td>
            </tr>
            <tr style="background: rgb(251, 251, 251);">
                <td colspan="2" class="required">是否显示: </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform onoff">
                	<label for="brand_recommend1" class="cb-enable"><span>是</span></label>
                    <label for="brand_recommend0" class="cb-disable selected"><span>否</span></label>
                    <input id="brand_recommend1" name="articleShow" type="radio" value="1">
                    <input id="brand_recommend0" name="articleShow" type="radio" checked="checked" value="0"></td>
                
                <td class="vatop tips"></td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">排序: </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td class="vatop rowform"><input type="text" name="articleSort" id="article_sort" class="txt" value="255">
                </td>
                <td class="vatop tips">数字范围为0~255，数字越大越靠前</td>
            </tr>
            <tr style="background: rgb(255, 255, 255);">
                <td colspan="2" class="required">文章内容: </td>
            </tr>
            <tr class="noborder" style="background: rgb(255, 255, 255);">
                <td colspan="2">
                <div class="ke-container ke-container-default" style="width: 700px;"><div style="display:block;" class="ke-toolbar" unselectable="on"><span class="ke-outline" data-name="source" title="HTML代码" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-source" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="undo" title="后退(Ctrl+Z)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-undo" unselectable="on"></span></span><span class="ke-outline" data-name="redo" title="前进(Ctrl+Y)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-redo" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="preview" title="预览" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-preview" unselectable="on"></span></span><span class="ke-outline" data-name="print" title="打印(Ctrl+P)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-print" unselectable="on"></span></span><span class="ke-outline" data-name="template" title="插入模板" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-template" unselectable="on"></span></span><span class="ke-outline" data-name="code" title="插入程序代码" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-code" unselectable="on"></span></span><span class="ke-outline" data-name="cut" title="剪切(Ctrl+X)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-cut" unselectable="on"></span></span><span class="ke-outline" data-name="copy" title="复制(Ctrl+C)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-copy" unselectable="on"></span></span><span class="ke-outline" data-name="paste" title="粘贴(Ctrl+V)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-paste" unselectable="on"></span></span><span class="ke-outline" data-name="plainpaste" title="粘贴为无格式文本" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-plainpaste" unselectable="on"></span></span><span class="ke-outline" data-name="wordpaste" title="从Word粘贴" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-wordpaste" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="justifyleft" title="左对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyleft" unselectable="on"></span></span><span class="ke-outline" data-name="justifycenter" title="居中" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifycenter" unselectable="on"></span></span><span class="ke-outline" data-name="justifyright" title="右对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyright" unselectable="on"></span></span><span class="ke-outline" data-name="justifyfull" title="两端对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyfull" unselectable="on"></span></span><span class="ke-outline" data-name="insertorderedlist" title="编号" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertorderedlist" unselectable="on"></span></span><span class="ke-outline" data-name="insertunorderedlist" title="项目符号" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertunorderedlist" unselectable="on"></span></span><span class="ke-outline" data-name="indent" title="增加缩进" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-indent" unselectable="on"></span></span><span class="ke-outline" data-name="outdent" title="减少缩进" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-outdent" unselectable="on"></span></span><span class="ke-outline" data-name="subscript" title="下标" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-subscript" unselectable="on"></span></span><span class="ke-outline" data-name="superscript" title="上标" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-superscript" unselectable="on"></span></span><span class="ke-outline" data-name="clearhtml" title="清理HTML代码" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-clearhtml" unselectable="on"></span></span><span class="ke-outline" data-name="quickformat" title="一键排版" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-quickformat" unselectable="on"></span></span><span class="ke-outline" data-name="selectall" title="全选(Ctrl+A)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-selectall" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="fullscreen" title="全屏显示" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fullscreen" unselectable="on"></span></span><div class="ke-hr"></div><span class="ke-outline" data-name="formatblock" title="段落" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-formatblock" unselectable="on"></span></span><span class="ke-outline" data-name="fontname" title="字体" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fontname" unselectable="on"></span></span><span class="ke-outline" data-name="fontsize" title="文字大小" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fontsize" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="forecolor" title="文字颜色" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-forecolor" unselectable="on"></span></span><span class="ke-outline" data-name="hilitecolor" title="文字背景" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-hilitecolor" unselectable="on"></span></span><span class="ke-outline" data-name="bold" title="粗体(Ctrl+B)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-bold" unselectable="on"></span></span><span class="ke-outline" data-name="italic" title="斜体(Ctrl+I)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-italic" unselectable="on"></span></span><span class="ke-outline" data-name="underline" title="下划线(Ctrl+U)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-underline" unselectable="on"></span></span><span class="ke-outline" data-name="strikethrough" title="删除线" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-strikethrough" unselectable="on"></span></span><span class="ke-outline" data-name="lineheight" title="行距" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-lineheight" unselectable="on"></span></span><span class="ke-outline" data-name="removeformat" title="删除格式" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-removeformat" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="image" title="图片" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-image" unselectable="on"></span></span><span class="ke-outline" data-name="multiimage" title="批量图片上传" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-multiimage" unselectable="on"></span></span><span class="ke-outline" data-name="flash" title="Flash" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-flash" unselectable="on"></span></span><span class="ke-outline" data-name="media" title="视音频" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-media" unselectable="on"></span></span><span class="ke-outline" data-name="insertfile" title="插入文件" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertfile" unselectable="on"></span></span><span class="ke-outline" data-name="table" title="表格" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-table" unselectable="on"></span></span><span class="ke-outline" data-name="hr" title="插入横线" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-hr" unselectable="on"></span></span><span class="ke-outline" data-name="emoticons" title="插入表情" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-emoticons" unselectable="on"></span></span><span class="ke-outline" data-name="baidumap" title="百度地图" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-baidumap" unselectable="on"></span></span><span class="ke-outline" data-name="pagebreak" title="插入分页符" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-pagebreak" unselectable="on"></span></span><span class="ke-outline" data-name="anchor" title="锚点" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-anchor" unselectable="on"></span></span><span class="ke-outline" data-name="link" title="超级链接" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-link" unselectable="on"></span></span><span class="ke-outline" data-name="unlink" title="取消超级链接" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-unlink" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="about" title="关于" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-about" unselectable="on"></span></span></div><div style="display: block; height: 238px;" class="ke-edit"><iframe class="ke-edit-iframe" hidefocus="true" frameborder="0" tabindex="" style="width: 100%; height: 238px;" src="./管理后台-文章新增_files/saved_resource.html"></iframe><textarea class="ke-edit-textarea" hidefocus="true" tabindex="" style="width: 100%; height: 238px; display: none;"></textarea></div><div class="ke-statusbar"><span class="ke-inline-block ke-statusbar-center-icon"></span><span class="ke-inline-block ke-statusbar-right-icon"></span></div></div><textarea id="content" style="width: 700px; height: 300px; display: none;" name="articleContent"></textarea>
                </td>
                <td class="vatop tips"></td>
            </tr>
          	</tbody>
            <tfoot>
            <tr class="tfoot">
                <td colspan="2"><a href="JavaScript:void(0);" class="btn" id="submitBtn"><span>提交</span></a></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
<script type="text/javascript">
	
$(document).ready(function(){
    $("#saveForm").validate({
        errorPlacement: function(error, element){
            error.appendTo(element.parent().parent().prev().find('td:first'));
        },
        success: function(label){
            label.addClass('valid');
        },
        rules : {
        	articleTitle : {
                required : true,
                remote   : {
                    url :APP_BASE+'/website/article/validate',
                    type:'post',
                    data:{
                        brandName : function(){
                            return $('#articleTitle').val();
                        },
                        brandId  : 0
                    }
                }
            },
            acId : {
            	acId   : true
            }
        },
        messages : {
        	articleTitle : {
                required : '标题不能为空',
                remote   : '该文章名称已经存在了，请您换一个'
            },
            acId  : {
                acId   : "请选择分类"
            }
        }
    });
    jQuery.validator.addMethod("acId", function(value, element) {   
        return (value==0)?false:true;
    });
});
   //按钮先执行验证再提交表单
    $(function(){$("#submitBtn").click(function(){
    	if($("#saveForm").valid()){
         $("#saveForm").submit();
         layer.load(2, {
             shade: [0.2, '#999999'] //0.1透明度的白色背景
           });
    	}
        });
    });
</script>


</body></html>