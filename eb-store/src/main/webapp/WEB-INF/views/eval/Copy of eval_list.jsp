<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>评论管理</title>	
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <link type="text/css" rel="stylesheet" href="resources/css/common.css">
        <link type="text/css" rel="stylesheet" href="resources/css/basic.css">
        <link type="text/css" rel="stylesheet" href="resources/css/member.css">        
        <link type="text/css" rel="stylesheet" href="resources/css/framework.css">     
        <link type="text/css" rel="stylesheet" href="resources/css/style.css">    
        <link type="text/css" rel="stylesheet" href="resources/css/css.css">    
        <link type="text/css" rel="stylesheet" href="resources/css/b2c.css">
        
        <!-- EasyUI -->
		<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css">
		<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
		<script src="resources/js/jquery.uploadify.min.js" type="text/javascript"></script>
	
		<link rel="stylesheet" type="text/css" href="resources/css/uploadify.css">
		<link rel="stylesheet" type="text/css" href="resources/css/singlepage.css">
		
		<!-- 编辑器 -->
		<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="resources/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="resources/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
		
    </head>
    <body>
    <script type="text/javascript">
    $(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/eval/EvalTypeList',
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i ++) {
						$("#goods-table").append("<tbody class='productNode'><tr><td><input type='checkbox' class='pro-marketable-check' value='' state='' key='marketable' name='' checked='checked'></td>"+
								"<td><input type='hidden' value='"+type_spec_id+"' name='specIds' /><input type='hidden' value='"+title+":"+type+"' name='specStr' /><div style='position:relative;' class='spec_item'><div class='spec-block'>"+
								"<div specid='1' class='select-spec-unselect goods-spec-selected  clearfix flt' style='margin:0 10px;'>"+
								"<div key='spec_value_1' class='spec_sel clearfix'>"+
								"<div class='flt fs10' style='line-height:30px;'>"+title+":</div>"+
								"<div class='flt specSelect' style='cursor:pointer;'>"+
								"<p style='height:30px;line-height:30px;' class='flt db selectedValue fs10'>"+type+"</p></div></div></div></div></div></td>"+
								"<td><div class='fill'><input type='text' value='' key='bn' name='barcode' size='10'></div></td>"+
								"<td><input type='text' vtype='required&amp;&amp;unsigned' value='' key='store' name='quantity' size='10'></td>"+
								"<td><div class='fill'><input type='text' vtype='unsigned&amp;&amp;minpirce' id='typeId"+typeId+"' value='' key='price' name='price' size='10'>"+
								"<img src='resources/images/btn_edit.gif' align='absmiddle' app='desktop'><span class='edit lnk fs10' onclick='getMemberPrice("+typeId+")'>会员价</span></div></td>"+
								"<td><div class='fill'><input type='text' vtype='unsigned' value='' key='cost' name='cost' size='10'></div></td><td>"+
								"<div class='fill'><input type='text' vtype='unsigned&amp;&amp;minpirce' value='' key='mktprice' name='marketPrice' size='10'></div></td>"+
								"<td><div class='fill'><input type='text' vtype='unsigned' value='' key='weight' name='goodsWeight' size='4'></div></td>"+
								"<td><input type='text' value='' key='goodsQuantity' name='goodsQuantity' size='4'></td></tr></tbody>");
					}
				}
				// 加载成功，提示
				$.messager.show({
	                title:'提示信息',
	                msg:json.msg,
	                timeout:1000,
	                showType:'fade'
	            });
			}
		});
		
		</script>
        <div class="clear" style="height:10px;"></div>
        <div class="content clear">
            <!-- 右侧内容-Start -->
            <div id="contentPage" class="left right-content">
            	<div id="main" class="member-main member-main2" action="">
					<div class="title">评论设置</div>
					<form method="post" action="#" id="form_saveGoods" class="section">
						<div id="gEditor-Body">
							<div class="title_fb ">1. 基本信息</div>
							<div class="FormWrap" style="background:none">
								
							</div>
							
						</div>
						<div>
							<div class="title_fb">2. 高级设置</div>
							<div class="FormWrap" style="background:none">
								<table cellspacing="0" cellpadding="0" border="0" class="gridlist gridlist2" id="goods-table" width="100%">
				                    <thead id="productNodeTitle">
				                        <tr class="fs10">
				                            <th class="textcenter" width="25">设置</th>
				                            <th class="textcenter" width="80">评分项目</th>
				                            <th class="textcenter" width="150">5分描述</th>
				                            <th class="textcenter" width="150">4分描述</th>
				                            <th class="textcenter" width="150">3分描述</th>
				                            <th class="textcenter" width="150">2分描述</th>
				                            <th class="textcenter" width="150">1分描述</th>
				                        </tr>
				                    </thead>
				                    <tbody class='productNode'>
				                    	<tr>
				                    		<td><input type='checkbox' class='pro-marketable-check' value=''  name='' ></td>
											<td><input type='text' value='' name='specIds' size="12" /></td>
											<td><textarea rows="5"  cols="15"></textarea></td>
											<td><textarea rows="5"  cols="15"></textarea></td>
											<td><textarea rows="5"  cols="15"></textarea></td>
											<td><textarea rows="5"  cols="15"></textarea></td>
											<td><textarea rows="5"  cols="15"></textarea></td>
										</tr>
									</tbody>
				                </table>
							</div>
							<div class="member-editwrap2">
								<button class="btn submit-btn" type="submit" onclick="saveBaby();" rel="_request">
									<span><span>保存</span></span>
								</button>
							</div>
						</div>
					</form>
				</div>
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
    </body>
</html>
