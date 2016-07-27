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
<style>
.eval_texterea{
	color: #333;
padding: 4px;
}

</style>
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
					$("#goods-table").append(
					"<tbody class='productNode'>"+
	                    "<tr>"+
	                		"<td><input type='checkbox' class='pro-marketable-check ' value='"+data[i].typeid+"'  name='' ></td>"+
							"<td><input type='text' class='fs10' value='"+data[i].typename+"' name='name' size='12' /></td>"+
							"<td><div class='fs10'>"+data[i].eiList[0].score+"分描述</div><textarea rows='5'  cols='15' class='fs10 eval_texterea' style='color: #333;'>"+data[i].eiList[0].content+"</textarea></td>"+
							"<td><div class='fs10'>"+data[i].eiList[1].score+"分描述</div><textarea rows='5'  cols='15' class='fs10 eval_texterea' style='color: #333;'>"+data[i].eiList[1].content+"</textarea></td>"+
							"<td><div class='fs10'>"+data[i].eiList[2].score+"分描述</div><textarea rows='5'  cols='15' class='fs10 eval_texterea' style='color: #333;'>"+data[i].eiList[2].content+"</textarea></td>"+
							"<td><div class='fs10'>"+data[i].eiList[3].score+"分描述</div><textarea rows='5'  cols='15' class='fs10 eval_texterea' style='color: #333;'>"+data[i].eiList[3].content+"</textarea></td>"+
							"<td><div class='fs10'>"+data[i].eiList[4].score+"分描述</div><textarea rows='5'  cols='15' class='fs10 eval_texterea' style='color: #333;'>"+data[i].eiList[4].content+"</textarea></td>"+
						"</tr></tbody>");
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
	});
  
  //添加项目
  function addEval(){
	  $("#goods-table").append(
		"<tbody class='productNode'>"+
                "<tr>"+
            		"<td><input type='checkbox' class='pro-marketable-check ' value=''  name='' ></td>"+
				"<td><input type='text' class='fs10' value='' name='evalName' size='12' /></td>"+
				"<td><div class='fs10'>5分描述</div><textarea rows='5' name='evalcontent5' cols='15' class='fs10 eval_texterea' style='color: #333;'></textarea></td>"+
				"<td><div class='fs10'>4分描述</div><textarea rows='5' name='evalcontent4' cols='15' class='fs10 eval_texterea' style='color: #333;'></textarea></td>"+
				"<td><div class='fs10'>3分描述</div><textarea rows='5' name='evalcontent3' cols='15' class='fs10 eval_texterea' style='color: #333;'></textarea></td>"+
				"<td><div class='fs10'>2分描述</div><textarea rows='5' name='evalcontent2' cols='15' class='fs10 eval_texterea' style='color: #333;'></textarea></td>"+
				"<td><div class='fs10'>1分描述</div><textarea rows='5' name='evalcontent1' cols='15' class='fs10 eval_texterea' style='color: #333;'></textarea></td>"+
			"</tr></tbody>");
  }
  //保存
  function saveEval(){
	var evalArray = new Array();
	var evals = $("#goods-table tbody");
	/*从第四项开始，前三项为系统默认*/
	if(evals.length > 3) {
		for(var i = 0; i < evals.length-3; i++) {
			
			var evalTypeName = $(evals[i+3]).find("tr:eq(0) td:eq(1) input[name='evalName']").val();
			var evalcontent5 = $(evals[i+3]).find("tr:eq(0) td:eq(2) textarea[name='evalcontent5']").val();
			var evalcontent4 = $(evals[i+3]).find("tr:eq(0) td:eq(3) textarea[name='evalcontent4']").val();
			var evalcontent3 = $(evals[i+3]).find("tr:eq(0) td:eq(4) textarea[name='evalcontent3']").val();
			var evalcontent2 = $(evals[i+3]).find("tr:eq(0) td:eq(5) textarea[name='evalcontent2']").val();
			var evalcontent1 = $(evals[i+3]).find("tr:eq(0) td:eq(6) textarea[name='evalcontent1']").val();
			
			var arrVal = evalTypeName+";"+evalcontent1+";"+evalcontent2+";"+evalcontent3+";"+evalcontent4+";"+evalcontent5;
			evalArray[i] = arrVal;
		}
	}
	
	/*方法保存*/
	 $.ajax({
		url : '${pageContext.request.contextPath}/eval/saveEval',
		type : 'post',
		data : "evalArray="+ evalArray,
		dataType : 'json',
		success : function(json) {
			
		}
	}); 
  }
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
		                    <!-- <tbody class='productNode'>
		                    	<tr>
		                    		<td><input type='checkbox' class='pro-marketable-check' value=''  name='' ></td>
									<td><input type='text' value='' name='specIds' size="12" /></td>
									<td><div class="fs10">1分描述</div>
									<textarea rows="5"  cols="15" class="fs10" style="color: #333;">金将军蓝景丽家发生点</textarea></td>
									<td><textarea rows="5"  cols="15"></textarea></td>
									<td><textarea rows="5"  cols="15"></textarea></td>
									<td><textarea rows="5"  cols="15"></textarea></td>
									<td><textarea rows="5"  cols="15"></textarea></td>
								</tr>
							</tbody>  -->
		                </table>
					</div>
					<div style="float:right;">
						<button class="btn submit-btn" type="button" onclick="addEval();" rel="_request">
							<span><span>添加</span></span>
						</button>
					</div>
					
					<div class="member-editwrap2">
						<button class="btn submit-btn" type="submit" onclick="saveEval();" rel="_request">
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
