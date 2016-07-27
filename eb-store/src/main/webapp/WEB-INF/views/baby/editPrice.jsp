<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/product/getMember",
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i++){
						$("#member-grade").append("<tr style='width:640px; height:50px; line-height:50px;'>" + 
								"<td style='text-align:center;font-size:10px;border-left:1px solid #bfbfbf;border-bottom:1px solid #bfbfbf;'>"+ data[i].name +"</th>" + 
								"<td style='text-align:center;font-size:10px;border-left:1px solid #bfbfbf;border-bottom:1px solid #bfbfbf;'><input type='hidden' name='memberGrand' value='"+ data[i].id +"' /><input type='text' name='memberPrice' value='' style='border:1px solid #bfbfbf;width:320px; height:35px;font-size:10px;' /></th>" + 
								"<td style='text-align:center;font-size:10px;border-left:1px solid #bfbfbf;border-bottom:1px solid #bfbfbf;'>"+ data[i].disCount +"</th>" + 
								"</tr>");
					}
				}
			}
		});
	});
</script>
<div class="goods_category_body">
	<div style="">
		<table id="member-grade">
			<tr style="background-color:#bfbfbf; width:640px; height:40px; line-height:20px;">
				<th style="width:180px; text-align:center; font-size:12px;">会员等级</th>
				<th style="width:330px; text-align:center; font-size:12px;">价格</th>
				<th style="width:120px; text-align:center; font-size:12px;">折扣</th>
			</tr>
		</table>
	</div>
</div>