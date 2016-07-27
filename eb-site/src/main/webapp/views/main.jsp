<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>商城应用系统--EB-Mall</title>	
        <meta name="keywords" content="{$metaKeywords}" />
        <meta name="description" content="" /> 
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        
        <script src="resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>

        <link type="text/css" rel="stylesheet" href="resources/css/common.css">
        <link type="text/css" rel="stylesheet" href="resources/css/basic.css">
        <link type="text/css" rel="stylesheet" href="resources/css/member.css">
        
    </head>
    <body>
        <!-- 顶部-start -->
        <div class="topbar">
            <div class="wrap iconlist">
                <div class="memberbox width-6">嗨！欢迎来Eb-Shop <a href="#">请登录</a>  <a href="#">免费注册</a> </div>
                <div class="width-6">
                    <a href="#"><i class="icon_heart icon_topbar"></i>我关注的品牌</a>
                    <a href="#">Eb-Shop会员</a>
                    <a href="#"><i class="icon_shopcart icon_topbar"></i>购物车<span id="shopcart_count">0</span>件</a>
                    <span class="fav">收藏夹<i class="icon icon_dropdown"></i></span> | 
                    <span><i class="icon_phone icon_topbar"></i>手机版</span>
                    <span class="fav">商家支持<i class="icon icon_dropdown"></i></span>
                    <span class="fav"><i class="icon_shopcart icon_topbar"></i>网站导航<i class="icon icon_dropdown"></i></span>
                </div>
            </div>  
        </div>
        <!-- 顶部-end -->
        
        <!-- LOGO-搜索-start -->
        <div id="header">
            <div class="wrap">
                <div class="logobar width-3">
                    <a href="" title="返回首页" class="logo"><img src="resources/images/logo.png"/></a>
                </div>
                
                <div id="searchbar" class="width-6">
                    <form method="get" action="">
                        <input type="text" name="keywords" class="txt" value="" placeholder="站内搜索"/>
                        <input type="submit" class="bt" value="搜索"/> 
                        <div class="clear"></div>
                    </form>
                    <span>热点关键词：</span>
                    <a href="#"> 时尚彩宝</a> | 
                    <a href="#"> 钻石</a> | 
                    <a href="#"> 时尚搭配</a> | 
                    <a href="#"> 设计师定制</a> | 
                    <a href="#"> 珠宝资讯</a> | 
                    <a href="#"> 贵金属投资</a> 
                </div>

                <div id="login">
                    <div class="">


                    </div>
                </div>
            </div>	
        </div>
        <!-- LOGO-搜索-end -->

        <!-- 导航-start -->
        <div style="clear:both"></div>
        <div id="nav" >
            <ul class="wrap">
                <li class="width-2"><a  href="#"   class="pronava">商品服务分类</a>
                    <div class="nav1">
                        
                    </div>
                </li>

                <li class="width-1"><a  href="brand.html"   class="nava">品牌街</a></li>
                <li class="width-1"><a  href="member.html"   class="nava">会员尊享</a></li>
                <li class="width-1"><a  href="offline.html"   class="nava">门店惊喜</a></li>
                <li class="width-1"><a  href="raise.html"   class="nava">珠宝众筹</a></li>
                <li class="width-1"><a  href="gold.html"   class="nava">金银投资</a></li>
                <li class="width-1"><a  href="design.html"   class="nava">设计定制</a></li>
                <li class="width-1"><a  href="vip.html"   class="nava">搭配资讯</a></li>
            </ul>
        </div>
        <!-- 导航-end -->
        
        <!-- Content-Start -->
        <div class="clear" style="height:10px;"></div>
        <div class="content clear">
            <!-- 左侧菜单-start -->
            <div class="left left-content">
                <div class="clearfix">
                  <div class="member-sidebar member-sidebar2">
                    <div class="member-menu">
                        <a href=""><h2 class="left_top">卖家中心</h2></a>
                        <ul class="body">
                            <li class="member-menu-list">
                                <div class="list-title-bg noborder">
                                    <h2 class="list-title-icon m-7">交易管理</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">订单管理</a>
                                    </li>
                                    <li>
                                        <a href="#">退货管理</a>
                                    </li>
                                    <li>
                                        <a href="#">退款管理</a>
                                    </li>
                                    <li>
                                        <a href="#">评论管理</a>
                                    </li>
                                </ul>
                           </li>
                           <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-8">物流管理</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">物流工具</a>
                                    </li>
                                 </ul>
                             </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-9">宝贝管理</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">发布宝贝</a>
                                    </li>
                                    <li>
                                        <a href="#">虚拟卡管理</a>
                                    </li>
                                    <li>
                                        <a href="#">出售中的宝贝</a>
                                    </li>
                                    <li>
                                        <a href="#">仓库中的宝贝</a>
                                    </li>
                                    <li>
                                        <a href="#">预警中的宝贝</a>
                                    </li>
                                    <li>
                                        <a href="#">宝贝分类管理</a>
                                    </li>
                                    <li>
                                        <a href="#">宝贝品牌管理</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-10">店铺管理</h2>
                                </div>
                                <ul>
                                    <li>
                                         <a target="_blank" href="http://58.214.7.150:8992/shop-view-38.html">店铺首页</a>
                                    </li>
                                    <li>
                                         <a href="#">基本设置</a>
                                     </li>
                                     <li>
                                          <a href="#">角色管理</a>
                                     </li>
                                     <li>
                                          <a href="#">店员管理</a>
                                     </li>
                                     <li>
                                          <a href="#">模版设置</a>
                                     </li>
                                     <li>
                                          <a href="#">保证金</a>
                                     </li>
                                  </ul>
                              </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-12">结算中心</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">结算报表</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-10">客服中心</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">投诉管理</a>
                                    </li>
                                    <li>
                                        <a href="#">举报管理</a>
                                    </li>
                                    <li>
                                        <a href="#">咨询管理</a>
                                    </li>
                                    <li>
                                        <a href="#">站内信(0)</a>
                                    </li>
                                    <li>
                                        <a href="#">在线客服管理</a>
                                    </li>
                                 </ul>
                            </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-10">营销中心</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">优惠券</a>
                                    </li>
                                    <li>
                                        <a href="#">活动报名</a>
                                    </li>
                                    <li>
                                        <a href="#">我参加的活动</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="member-menu-list">
                                <div class="list-title-bg">
                                    <h2 class="list-title-icon m-10">商户信息</h2>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">商户信息</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                  </div>
                 </div>
            </div>
            <!-- 左侧菜单-end -->
            
            <!-- 右侧内容-Start -->
            <div class="left right-content">
            <jsp:include page="home.jsp"></jsp:include>
            	
            </div>
            <!-- 右侧内容-End -->
        </div>
        <!-- Content-End -->
        
        <!-- Footer-Start -->
        ﻿<div id="footer" >
            <div class="wrap">
                <div class="help">
                    <dl class="width-2"> 
                        <dt>购物指南</dt> 
                        <dd><a href="{$prefix}article/?id={$v.id}">购买流程</a></dd> 
                        <dd><a href="{$prefix}article/?id={$v.id}">支付方式</a></dd> 
                    </dl> 
                    <dl class="width-2"> 
                        <dt>购物保障</dt> 
                        <dd><a href="{$prefix}article/?id={$v.id}">购买流程</a></dd> 
                        <dd><a href="{$prefix}article/?id={$v.id}">支付方式</a></dd> 
                    </dl> 
                    <dl class="width-2"> 
                        <dt>售后服务</dt> 
                        <dd><a href="{$prefix}article/?id={$v.id}">购买流程</a></dd> 
                        <dd><a href="{$prefix}article/?id={$v.id}">支付方式</a></dd> 
                    </dl> 
                    <dl class="width-2"> 
                        <dt>关于我们</dt> 
                        <dd><a href="{$prefix}article/?id={$v.id}">购买流程</a></dd> 
                        <dd><a href="{$prefix}article/?id={$v.id}">支付方式</a></dd> 
                    </dl> 
                    <dl class="width-4"> 
                        <dt>手机上Eb-Shop</dt> 
                        <dd><a href="{$prefix}article/?id={$v.id}">购买流程</a></dd> 
                        <dd><a href="{$prefix}article/?id={$v.id}">支付方式</a></dd> 
                    </dl> 
                    <div style="clear:both"></div>
                </div>
                <!-- help -->
            </div>
            <!-- copyright -->
            <div class="copyright">
                <p class="copy wrap">
                    <a href="#">关于Eb-Shop</a>
                    <a href="#">帮助中心</a>
                    <a href="#">诚聘英才</a>
                    <a href="#">联系我们</a>
                    <a href="#">网站合作</a>
                    <a href="#">法律声明</a>
                    <a href="#">廉政举报</a><br>
                    <a href="#">京东商城</a> |
                    <a href="#">中国白银网</a> |
                    <a href="#">央视网</a> |
                    <a href="#">1号店</a> |
                    <a href="#">京东商城</a> |
                    <a href="#">中国白银网</a> |
                    <a href="#">央视网</a> |
                    <a href="#">1号店</a> <br>

                    <a href="http://www.csmall.com/help.do?page=help_help_icp" target="_blank"  >中国增值电信业务经营许可证 B2-20140169号</a>
                    <span style="line-height:1.5;"> | ©2014甘肃中通申信科技有限公司 All Rights Reserved | 国家信息产业部甘ICP备14018586号</span> 
                    <span class="powerby">技术支持：<a href="http://www.jentian.com/" target="_blank" title="甘肃中通申信科技有限公司">牛军军</a>
                        <br>
                        <a href="http://si.trustutn.org/info?sn=131141223010513021410" target="_blank"><img src="http://v.trustutn.org/images/cert/bottom_small_img.png" alt="实名认证" title="实名认证"></a>
                    </span>
                </p>
            </div>
            <div class="clear"></div>
        </div>
        <!-- Footer-End -->
    </body>
</html>
