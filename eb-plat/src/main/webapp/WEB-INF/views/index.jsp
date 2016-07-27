<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-portal/portal.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-portal/jquery.portal.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/extJquery.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
var portalLayout;
var portal;
$(function() {
	
	portalLayout = $('#portalLayout').layout({
		fit : true
	});
	
	$(window).resize(function() {
		portalLayout.layout('panel', 'center').panel('resize', {
			width : 1,
			height : 1
		});
	});

	panels = [ {
		id : 'p1',
		title : '本月交易金额 （费用单位：元）',
		height : 300,
		collapsible : true,
		href : '${pageContext.request.contextPath}/order'
	}, {
		id : 'p2',
		title : '新上架商品数量',
		height : 300,
		collapsible : true,
		href : '${pageContext.request.contextPath}/order'
	},{
		id : 'p3',
		title : '当日订单数量',
		height : 300,
		collapsible : true,
		href : '${pageContext.request.contextPath}/order'
	}, {
		id : 'p4',
		title : '库存预警',
		height : 400,
		collapsible : true,
		href : '${pageContext.request.contextPath}/order'
	}, {
		id : 'p5',
		title : '项目采购费用',
		height : 400,
		collapsible : true,
		href : '${pageContext.request.contextPath}/order'
	}];

	portal = $('#portal').portal({
		border : false,
		fit : true,
		onStateChange : function() {
			$.cookie('portal-state', getPortalState(), {
				expires : 7
			});
		}
	});
	
	var state = $.cookie('portal-state');
	if (!state) {
		state = 'p1,p2,p3:p4,p5';/*冒号代表列，逗号代表行*/
	}
	addPortalPanels(state);
	portal.portal('resize');

});

function getPanelOptions(id) {
	for ( var i = 0; i < panels.length; i++) {
		if (panels[i].id == id) {
			return panels[i];
		}
	}
	return undefined;
}


function getPortalState() {
	var aa = [];
	for ( var columnIndex = 0; columnIndex < 2; columnIndex++) {
		var cc = [];
		var panels = portal.portal('getPanels', columnIndex);
		for ( var i = 0; i < panels.length; i++) {
			cc.push(panels[i].attr('id'));
		}
		aa.push(cc.join(','));
	}
	return aa.join(':');
}


function addPortalPanels(portalState) {
	var columns = portalState.split(':');
	for ( var columnIndex = 0; columnIndex < columns.length; columnIndex++) {
		var cc = columns[columnIndex].split(',');
		for ( var j = 0; j < cc.length; j++) {
			var options = getPanelOptions(cc[j]);
			if (options) {
				var p = $('<div/>').attr('id', options.id).appendTo('body');
				p.panel(options);
				portal.portal('add', {
					panel : p,
					columnIndex : columnIndex
				});
			}
		}
	}
}
</script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">工作台</a></li>
		</ul>
	</div>
	
	<div id="portalLayout">
		<div data-options="region:'center',border:false">
			<div id="portal" style="position: relative">
				<div></div>
				<div></div>
			</div>
		</div>
	</div>
	</body>
</html>
