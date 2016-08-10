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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ui-v2/jquery.edit.js"></script>
	<script type="text/javascript">
	    $(function(){
	        $('#ncsubmit').click(function(){
	            $('#formSearch').submit();
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
            <h3>快递公司</h3>
            <ul class="tab-base"><li><a class="current"><span>快递公司</span></a></li></ul>
        </div>
    </div>
    <div class="fixed-empty"></div>
    <form method="post" name="formSearch" id="formSearch" action="{pageContext.request.contextPath}/express/list">
        <input type="hidden" name="pageNo" value="1">
    </form>
    <table class="tb-type1 noborder search">
        <tbody>
        <tr style="background: rgb(255, 255, 255);">
            <th><label for="search_brand_name">首字母</label></th>
            <td>
                <a href="{pageContext.request.contextPath}/express/list?letter=A">A</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=B">B</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=C">C</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=D">D</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=E">E</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=F">F</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=G">G</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=H">H</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=I">I</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=J">J</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=K">K</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=L">L</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=M">M</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=N">N</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=O">O</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=P">P</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=Q">Q</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=R">R</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=S">S</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=T">T</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=U">U</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=V">V</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=W">W</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=X">X</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=Y">Y</a>&nbsp;&nbsp;
                <a href="{pageContext.request.contextPath}/express/list?letter=Z">Z</a>&nbsp;&nbsp;
            </td>
            <td><a href="javascript:void(0);" id="ncsubmit" class="btn-search " title="撤销检索">&nbsp;</a>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table tb-type2" id="prompt">
        <tbody>
        <tr class="space odd" style="background: rgb(255, 255, 255);">
            <th colspan="12"><div class="title"><h5>操作提示</h5><span class="arrow"></span></div></th>
        </tr>
        <tr class="odd" style="display: none;">
            <td>
                <ul>
                    <li>系统内置的快递公司不得删除，只可编辑状态，平台可禁用不需要的快递公司，默认按首字母进行排序，常用的快递公司将会排在靠前位置</li>
                </ul></td>
        </tr>
        </tbody>
    </table>
    <table class="table tb-type2">
        <thead>
        <tr class="thead">
            <th class="w24"></th>
            <th class="w270">快递公司</th>
            <th>首字母</th>
            <th class="w270">网址 (仅供参考)</th>
            <th class="align-center">常用</th>
            <th class="align-center">状态</th>
        </tr>
        </thead>
        <tbody>
            <tr class="hover" style="background: rgb(255, 255, 255);">
                <td></td>
                <td>顺丰快递</td>
                <td>S</td>
                <td>http://www.sf-express.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="29" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="29" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
            </tr>
            <tr class="hover" style="background: rgb(255, 255, 255);">
                <td></td>
                <td>德邦物流</td>
                <td>D</td>
                <td>http://www.deppon.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="7" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="7" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>优速快递</td>
                <td>Y</td>
                <td>http://www.uc56.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="43" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="43" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>邮政包裹</td>
                <td>Y</td>
                <td>http://yjcx.chinapost.com.cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="42" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="42" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>UPS快递</td>
                <td>U</td>
                <td>http://www.ups.com/cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="34" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="34" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>天天快递</td>
                <td>T</td>
                <td>http://www.ttkdex.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="32" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="32" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>申通快递</td>
                <td>S</td>
                <td>http://www.sto.cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="28" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="28" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover" style="background: rgb(251, 251, 251);">
                <td></td>
                <td>DHL快递</td>
                <td>D</td>
                <td>http://www.cn.dhl.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="5" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="5" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>韵达快递</td>
                <td>Y</td>
                <td>http://www.yundaex.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="41" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="41" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>TNT快递</td>
                <td>T</td>
                <td>http://www.tnt.com.cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="31" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="31" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>飞康达</td>
                <td>F</td>
                <td>http://www.fkd.com.cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="10" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="10" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>速尔快递</td>
                <td>S</td>
                <td>http://www.sure56.com</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="30" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="30" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>中邮物流</td>
                <td>Z</td>
                <td>http://www.cnpl.com.cn</td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="47" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="47" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>FedEx(国际)</td>
                <td>F</td>
                <td>http://fedex.com/cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="11" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="11" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>挂号信</td>
                <td>G</td>
                <td>http://yjcx.chinapost.com.cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="14" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="14" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>龙邦快递</td>
                <td>L</td>
                <td>http://www.lbex.com.cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="22" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="22" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>快捷速递</td>
                <td>K</td>
                <td>http://www.fastexpress.com.cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="21" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">
                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="21" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
</td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>急先达</td>
                <td>J</td>
                <td>http://www.joust.cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="20" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="20" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>包裹平邮</td>
                <td>B</td>
                <td>http://yjcx.chinapost.com.cn</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="2" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="2" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
            <tr class="hover">
                <td></td>
                <td>共速达</td>
                <td>G</td>
                <td>http://www.gongsuda.com/mall/Search.aspx</td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" disabled" nc_type="inline_edit" fieldname="eorder" modurl="/leimingtech-admin/setting/express/updateOrder" fieldid="15" fieldvalue="0" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
                <td class="align-center yes-onoff">                    <a href="JavaScript:void(0);" class=" enabled" nc_type="inline_edit" fieldname="estate" modurl="/leimingtech-admin/setting/express/updateState" fieldid="15" fieldvalue="1" title="可编辑"><img src="./管理后台-快递公司_files/transparent.gif"></a>
                    </td>
            </tr>
        </tbody>
        <tfoot>
        <tr class="tfoot">
            <td colspan="20">
<div class="pagination">
    <ul><li>
                </li><li><span>首页</span></li>
                    <li><span class="currentpage">1</span></li>
                    <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>2</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(3)"><span>3</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(2)"><span>下一页</span></a></li>
                <li><a class="demo" href="javascript:void(0);" onclick="turnOverPage(3)"><span>末页</span></a></li>
        <script language="javascript">
            function turnOverPage(no) {
                var queryForm = document.formSearch;
                if (no >3) {
                    no =3;
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
        </tr>
        </tfoot>
    </table>
    <div class="clear"></div>
</div>



</body></html>