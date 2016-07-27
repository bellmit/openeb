<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/product/getDeliverType",
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					var data = json.data;
					for(var i = 0; i < data.length; i++){
						$("#member-grade").append("<tr style='width:640px; height:50px; line-height:50px;'>" + 
								"<td style='text-align:center;font-size:10px;border-left:1px solid #bfbfbf;border-bottom:1px solid #bfbfbf;'><input type='radio' name='id' id='deliverTypeId' value='"+ data[i].id +"' /></th>" + 
								"<td style='text-align:center;font-size:10px;border-left:1px solid #bfbfbf;border-bottom:1px solid #bfbfbf;border-right:1px solid #bfbfbf;'><input type='hidden' name='deliverTypeName' id='deliverTypeName' value='"+ data[i].title +"' />"+ data[i].title +"</th>" + 
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
				<th style="width:180px; text-align:center; font-size:12px;">选择</th>
				<th style="width:330px; text-align:center; font-size:12px;">配送方式</th>
			</tr>
		</table>
	</div>
</div>