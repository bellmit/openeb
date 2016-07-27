<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    
    <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
    <!--  
     * String id 身份授权key
	 * String com 快递公司代码(不支持中文，对应的公司代码) 
	 * String nu 要查询的快递单号
	 * String show 返回类型（json，xml,html）0：返回json字符串， 1：返回xml对象， 2：返回html对象， 3：返回text文本。如果不填，默认返回json字符串。
	 * String muti 返回信息数量  1:返回多行完整的信息， 0:只返回一行信息。 不填默认返回多行。 
	 * String order 排序   desc：按时间由新到旧排列， asc：按时间由旧到新排列。  
	 -->
     <script type="text/javascript" language="javascript">
  			function getIdSendKuaiDi(){
  				var danhao = document.getElementById("danhao").value;
  				var com = document.getElementById("com").value;
  				if(com == "顺丰快递"){
  					com = "shunfen";
  				}else if(com == "百世汇通"){
  					com = "huitongkuaidi";
  				};
	  	  		$.ajax({
				    url: "http://api.kuaidi100.com/api?id=6959527b1a3a8782&com="+com+"&nu="+danhao+"&show=0&muti=1&order=asc",
					type: "GET",
					dataType: "jsonp",
					success: function(data){
						var kdObject = data.data;//定位到物流文字数据
						alert(kdObject);
						for (var i = 0; i < kdObject.length; i++) {
								var time = kdObject[i].time;
								var context = kdObject[i].context;
								alert(time+"---"+context);
								/* $("#result ul").append("<li>"+time+"</li>").append("<li>"+context+"</li>"); */
								
								$("#result ul").append("<li>"+time+"----------"+context+"</li>")
						}
					}
				});
  			}
    </script>
    
    <script type="text/javascript">
    	function countYunFeiMath(){
    		var qishidi = document.getElementById("qishidi");
    		var shoujiandi = document.getElementById("shoujiandi");
    		var zhongliang = document.getElementById("zhongliang");
    		$.ajax({
			    url: "http://www.kuaidi100.com/delivery.shtml?source=kuaidi100&orderSource=orderIndex&headerMenu=orderIndex&startPlace_input="+qishidi+"&street=&startPlace=[]&endPlace_input="+shoujiandi+"&endPlace=[code]&weight="+zhongliang+"",
				type: "GET",
				dataType: "jsonp",
				data:"",
				success: function(kdObject){
					for (var i = 0; i < kdObject.length; i++){
					}
				}
			});
    	}
    
    </script>
    
  </head>
  
  <body>
    <div style="width: 300px;height: 100px;border: 1px dashed #000;" align="center">
    	<input id="danhao" name="danhao" value="210720949399" style="margin-top: 10px;width: 200px;"><!-- 快递单号 -->
    	<input id="com" name="com" value="" style="margin-top: 10px;width: 200px;"><!-- 快递公司 -->
    	<br>
		<a href="javascript:void(0)" onclick="getIdSendKuaiDi();" style="margin-top: 10px;width: 100px;">包裹跟踪</a><!-- javascript:void(0) -->
    </div>
    <div style="margin-top: 50px;width: 750px;border: 1px dashed #000;">
    	<div id="result">
    		<ul style="list-style-type: none;">
    			<li style="list-style: none;font-size: 3px;"></li>
    		</ul>
    	</div>
    </div>
    
    <div style="border: 1px solid black;margin-top: 50px;">
    	<div>起始地：<input id="qishidi" name="qishidi" type="text" style="width: 150px;">*省份-城市-县区-街道</div>
    	<div>收件地：<input id="shoujiandi" name="shoujiandi" type="text" style="width: 150px;">*省份-城市-县区-街道</div>
    	<div>重&nbsp;&nbsp;量：<input id="zhongliang" name="zhongliang" name="zhongliang" type="text" style="width: 150px;">*公斤</div>
    	<a href="javascript:void(0)" onclick="countYunFeiMath();" style="margin-top: 50px;width: 150px;">查询</a>
    </div>
    
  </body>
</html>
