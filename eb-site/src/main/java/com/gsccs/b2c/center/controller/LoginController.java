package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.Shop;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.shiro.client.UserPwdSiteToken;
import com.gsccs.b2c.web.api.service.RedisService;

import freemarker.template.TemplateModelException;

/**
 * 会员登录管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private RedisService redisService;

	
	@RequestMapping(value = "/{site}/login.html", method = RequestMethod.GET)
	public String login1(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/login.html";
		Shop shop;
		try {
			shop = shopAPI.getShop(siteId);
			if (null == shop) {
				tempPath = "shop/shop404.html";
			}

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
			// 生成商品页面
			FreeMarkerUtil.createWriter(dir, data, tempPath,
					response.getWriter());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String doGet(Model model,
			HttpServletResponse response) {
		Long siteId = 1001l;
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/login.html";
		Shop shop;
		try {
			shop = shopAPI.getShop(siteId);
			if (null == shop) {
				tempPath = "shop/shop404.html";
			}

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
			// 生成商品页面
			FreeMarkerUtil.createWriter(dir, data, tempPath,
					response.getWriter());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/{site}/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg showLoginForm(@PathVariable("site") Long siteId,
			HttpServletRequest req, Model model) {
		
		JsonMsg json = new JsonMsg();
		String error = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Subject subject = SecurityUtils.getSubject();
		UserPwdSiteToken token = new UserPwdSiteToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		token.setSite(siteId);
		token.setRememberMe(true);
		try {
			subject.login(token);
			json.setSuccess(true);
			return json;
		} catch (UnknownAccountException e) {
			error = "用户名不存在";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			error = "其他错误：" + e.getMessage();
		}
		json.setSuccess(false);
		json.setMsg(error);
		return json;

	}

	/**
	 * 用户注销
	 * 
	 * @return
	 */
	@RequestMapping("/{site}/logout")
	@ResponseBody
	public JSONObject logout() {
		// 清除用户session
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		// 清除用户购物车缓存
		// 清除历史浏览记录
		return null;
	}

}
