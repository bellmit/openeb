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
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/common_select.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/perfect-scrollbar.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.mousewheel.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-plat/goodsType.js" charset="utf-8"></script>
</head>
<body>
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div class="page">
<div class="fixed-bar">
    <div class="item-title">
        <h3>类型管理</h3>
        <ul class="tab-base">
            <li><a href="${pageContext.request.contextPath}/type"><span>列表</span></a></li>
            <li><a href="javascript:;" class="current"><span>新增</span></a></li>
        </ul>
    </div>
</div>
<div class="fixed-empty"></div>
<form id="type_form" method="post" action="${pageContext.request.contextPath}/type/save">
    <table id="prompt" class="table tb-type2">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12" class="nobg"> <div class="title">
                <h5>操作提示</h5>
                <span class="arrow"></span> </div>
            </th>
        </tr>
        <tr class="odd" style="display: none; background: rgb(255, 255, 255);">
            <td><ul>
                <li>关联规格不是必选项，它会影响商品发布时的规格及价格的录入。不选为没有规格。</li>
                <li>关联品牌不是必选项，它会影响商品发布时的品牌选择。</li>
                <li>属性值可以添加多个，每个属性值之间需要使用逗号隔开。</li>
                <li>选中属性的“显示”选项，该属性将会在商品列表页显示。</li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <input type="hidden" value="ok" name="form_submit">
    <table class="table tb-type2">
        <tbody>
        <tr style="background: rgb(255, 255, 255);">
            <td class="required" colspan="2"><label class="validation" for="goodsType.title">类型：</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform"><input type="text" class="txt" name="goodsType.title" id="t_mane"></td>
            <td class="vatop tips"></td>
        </tr>
        <tr style="background: rgb(255, 255, 255);">
            <td class="required" colspan="2"><label class="validation" for="goodsType.ordernum">排序：</label></td>
        </tr>
        <tr class="noborder" style="background: rgb(255, 255, 255);">
            <td class="vatop rowform"><input type="text" class="txt" name="goodsType.ordernum" id="t_sort" value="0"></td>
            <td class="vatop tips">请填写自然数。类型列表将会根据排序进行由小到大排列显示。</td>
        </tr>
        </tbody>
    </table>
    <div style="width: 100%; float: left; margin: 10px 0; border: solid #DEEFFB; border-width: 0 0 1px 0;">
        <table class="table tb-type2" style="margin: 0;">
            <thead class="thead">
            <tr class="space">
                <th colspan="15"> <label style=" float: left; margin-right: 10px;">选择关联规格：</label>
                </th>
            </tr>
            <tr>
            	<th></th>
            	<th>规格名称</th>
            	<th>规格值</th>
                <th style="text-align: right;" colspan="15"><a class="btns" nctype="spec_hide" href="javascript:viod(0);"><span>隐藏未选项</span></a></th>
            </tr>
            </thead>
        </table>
        <div style="position:relative; max-height:240px; overflow: hidden;" id="spec_div" class="scrollbar-box ps-container">
            <table class="table tb-type2" id="spec_table">
                <tbody>
                	<c:forEach items="${specList }" var="spec" varStatus="status">
                        <tr class="hover edit" style="background: rgb(255, 255, 255);">
                            <td width="50px">
                                <ul class="nofloat">
                                     <li class="left w33pre h36" style="width:1000px">
                                         <input class="checkitem" nc_type="change_default_spec_value" type="checkbox" value="${spec.id }" name="specList[${status.index }].id">
                                        	<span style="width:300px;margin-left: 30px;">${spec.title }</span>
                                           	<span style="width:500px;margin-left: 100px;">22,yu</span>
                                     </li>
                                </ul>
                            </td>
                        </tr>
                     </c:forEach>   
                </tbody>
            </table>
        <div class="ps-scrollbar-x" style="left: 0px; bottom: 3px; width: 0px;"></div><div class="ps-scrollbar-y" style="top: 0px; right: 3px; height: 48px;"></div></div>
    </div>
    
    <table class="table tb-type2 mtw">
        <thead class="thead">
	        <tr class="space">
	            <th colspan="15">添加属性：</th>
	        </tr>
	        <tr>
	            <th>排序</th>
	            <th>属性名称</th>
	            <th>属性可选值</th>
	            <th class="align-center">显示</th>
	            <th class="align-center">操作</th>
	        </tr>
        </thead>
        <tbody id="tr_model">
        	<tr></tr>
	    </tbody>
	    <tbody>
	        <tr>
	            <td colspan="15"><a id="add_type" class="btn-add marginleft" href="JavaScript:void(0);"> <span>添加一个属性</span> </a></td>
	        </tr>
        </tbody>
        <tfoot>
	        <tr class="tfoot">
	            <td colspan="15"><a id="submitBtn" class="btn" href="JavaScript:void(0);"> <span>提交</span> </a></td>
	        </tr>
        </tfoot>
    </table>
</form>
</div>
<script>
    $(function(){
        $('#spec_div').perfectScrollbar();
        //$('#brand_div').perfectScrollbar();
        var i = 0;
        var tr_model = '<tr class="hover edit">'+
                '<td class="w48 sort"><input type="text" name="attrList[key].ordernum" value="0" /></td>'+
                '<td class="w25pre name"><input type="text" name="attrList[key].title" value="" /></td>'+
                '<td class="w50pre name"><input type="text" name="attrList[key].useMinfo" value="" style="width:400px;"  placeholder="如要增加多个属性值，请以英文半角“ , ”隔开"/></textarea></td>'+
                '<td class="align-center power-onoff"><input type="checkbox" checked="checked" nc_type="checked_show" /><input type="hidden" name="attrList[key].state" value="1" /></td>'+
                '<td class="align-center w60"><a onclick="remove_tr($(this));" href="JavaScript:void(0);">移除</a></td>'+
                '</tr>';
                
        $("#add_type").click(function(){
            $('#tr_model > tr:last').after(tr_model.replace(/key/g, i));
            $.getScript(APP_BASE+"/static/ui-v2/admincp.js");
            i++;
        });

        $('input[nc_type="checked_show"]').live('click', function(){
            var o = $(this).next();
            //alert(o.val());
            if(o.val() == '1'){
                o.val('0');
            }else if(o.val() == '0'){
                o.val('1');
            }
        });


        //表单验证
        $('#type_form').validate({
            errorPlacement: function(error, element){
                error.appendTo(element.parent().parent().prev().find('td:first'));
            },

            rules : {
                'goodsType.title': {
                    required : true,
                    maxlength: 20,
                    minlength: 1,
                    remote   : {
                        url :APP_BASE+'/type/checkTypeName',
                        type:'post',
                        data:{
                            title : function(){
                                return $('#t_mane').val();
                            }
                        }
                    }
                },
                'goodsType.ordernum': {
                    required : true,
                    digits	 : true
                }
            },
            messages : {
                'goodsType.title' : {
                    required : '请填写类型名称',
                    maxlength: '类型名称长度应在1-20个字符之间',
                    minlength: '类型名称长度应在1-20个字符之间',
                    remote   : '类型名称已经存在'
                },
                'goodsType.ordernum': {
                    required : '请填写类型排序',
                    digits : '请填写整数'
                }
            }
        });


        //按钮先执行验证再提交表单
        $("#submitBtn").click(function(){
            spec_check();
            if($("#type_form").valid()){
                $("#type_form").submit();
            }
        });

        // 所属分类
        $("#gcategory > select").live('change',function(){
            spec_scroll($(this));
            brand_scroll($(this));
        });

        // 规格搜索
        $("#speccategory > select").live('change',function(){
            spec_scroll($(this));
        });
        // 品牌搜索
        $("#brandcategory > select").live('change',function(){
            brand_scroll($(this));
        });

        // 规格隐藏未选项
        $('a[nctype="spec_hide"]').live('click',function(){
        	spec_hide('spec');
        });
        // 规格全部显示
        $('a[nctype="spec_show"]').live('click',function(){
        	spec_show('spec');
        });
        // 品牌隐藏未选项
        $('a[nctype="brand_hide"]').live('click',function(){
            checked_hide('brand');
        });
        // 品牌全部显示
        $('a[nctype="brand_show"]').live('click',function(){
            checked_show('brand');
        });
    });
    var specScroll = 0;
    function spec_scroll(o){
        var id = o.val();
        if(!$('#spec_h6_'+id).is('h6')){
            return false;
        }
        $('#spec_div').scrollTop(-specScroll);
        var sp_top = $('#spec_h6_'+id).offset().top;
        var div_top = $('#spec_div').offset().top;
        $('#spec_div').scrollTop(sp_top-div_top);
        specScroll = sp_top-div_top;
    }

    var brandScroll = 0;
    function brand_scroll(o){
        var id = o.val();
        if(!$('#brand_h6_'+id).is('h6')){
            return false;
        }
        $('#brand_div').scrollTop(-brandScroll);
        var sp_top = $('#brand_h6_'+id).offset().top;
        var div_top = $('#brand_div').offset().top;
        $('#brand_div').scrollTop(sp_top-div_top);
        brandScroll = sp_top-div_top;
    }

    // 隐藏未选项
    function checked_show(str) {
        $('#'+str+'_table').find('h6').show().end().find('li').show();
        $('a[nctype="'+str+'_show"]').attr('nctype',str+'_hide').children().html('隐藏未选项');
    }

    // 显示全部选项
    function checked_hide(str) {
        $('#'+str+'_table').find('h6').hide();
        $('#'+str+'_table').find('input[type="checkbox"]').parents('li').hide();
        $('#'+str+'_table').find('input[type="checkbox"]:checked').parents('li').show();
        $('a[nctype="'+str+'_hide"]').attr('nctype',str+'_show').children().html('全部显示');
    }

    function spec_check(){
        var id='';
        $('input[nc_type="change_default_spec_value"]:checked').each(function(){
            if(!isNaN($(this).val())){
                id += $(this).val();
            }
        });
        if(id != ''){
            $('#spec_checkbox').val('ok');
        }else{
            $('#spec_checkbox').val('');
        }
    }


    function remove_tr(o){
        o.parents('tr:first').remove();
    }
    // 所属分类
    //gcategoryInit('gcategory');
    // 规格搜索
    //gcategoryInit('speccategory');
    // 品牌搜索
    //gcategoryInit('brandcategory');

</script>

</body>
</html>
