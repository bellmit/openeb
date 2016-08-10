package com.gsccs.b2c.store.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsccs.b2c.api.service.SellerServiceI;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.exception.ApiException;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {
	
	
	@Autowired
	private SellerServiceI sellerAPI;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doGet(HttpServletRequest req) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showLoginForm(HttpServletRequest req, Model model) {
		String error = null;

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(true);
		try {
			subject.login(token);
			Account account = sellerAPI.getSeller(username);
			Session session = subject.getSession();

			session.setAttribute("siteId", account.getShopid());
			session.setAttribute("userId", account.getId());
			
		} catch (UnknownAccountException e) {
			error = "用户名不存在";
			e.printStackTrace();
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
			e.printStackTrace();
		} catch (AuthenticationException e) {
			error = "其他错误：" + e.getMessage();
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}

		if (error != null) {// 出错了，返回登录页面
			model.addAttribute("error", error);
			
		} else {// 登录成功
			return "redirect:/main";
		}
		return "login";
	}


}
