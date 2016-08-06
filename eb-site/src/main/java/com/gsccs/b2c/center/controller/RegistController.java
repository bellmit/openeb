package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 会员注册
 * 
 * @author x.d zhang
 * @Date: 14-2-15
 * @version 1.0
 */
@Controller
public class RegistController {

	private static final Logger logger = Logger
			.getLogger(RegistController.class);
	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/{site}/regist.html", method = RequestMethod.GET)
	public String regist(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/register.html";
		try {
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

	
	/**
	 * 注册提交
	 * @param siteId
	 * @param user
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{site}/regist", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg showLoginForm(@PathVariable("site") Long siteId, Account user,
			HttpServletRequest req, Model model) {
		JsonMsg json = new JsonMsg();
		
		if (StringUtils.isBlank(user.getEmail())) {
			json.setSuccess(false);
			json.setMsg("邮箱不能为空！");
			return json;
		}

		if (StringUtils.isBlank(user.getAccount())) {
			json.setSuccess(false);
			json.setMsg("邮箱不能为空！");
			return json;
		} 
		
		try {
			buyerAPI.addAccount(siteId, user);
			json.setSuccess(true);
			json.setMsg(user.getAccount()+" 帐号注册成功！");
			json.setData(user);
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg(" 帐号注册失败,未知错误！");
		}
		
		return json;
	}

	/**
	 * 用户注册 邮箱认证
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/{site}/sendEmailAgain", method = RequestMethod.POST)
	public String sendEmailAgain(@PathVariable("site") Long siteId, String uid,
			ModelMap model){
		if (StringUtils.isBlank(uid)) {
			throw new NullPointerException("参数不正确！");
		}

		/*
		 * Account acc = accountService.selectById(uid); if (acc == null) {
		 * throw new NullPointerException("根据用户ID查询不到用户信息！"); }
		 * 
		 * accountService.sendEmail(acc, NotifyTemplate.email_reg);
		 * model.addAttribute("uid", acc.getId());
		 */
		// getResponse().sendRedirect(SystemManager.systemSetting.getWww()+"/account/checkEmail.html");
		return "redirect:/account/checkEmail.html";
	}

	/**
	 * 转到邮箱验证提示页面
	 * 
	 * @return
	 */
	@RequestMapping("/{site}/checkEmail")
	public String checkEmail(@PathVariable("site") Long siteId) {
		logger.info("checkEmail");

		return "/account/regsuccess";
	}

	/**
	 * 转到忘记密码页面
	 * 
	 * @return
	 */
	@RequestMapping("forget")
	public String forget() {
		return "/account/forget";
	}

	/**
	 * 找回密码
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{site}/doForget", method = RequestMethod.POST)
	public String doForget(@PathVariable("site") Long siteId, Account e,
			ModelMap model) throws Exception {
		// accountService.doForget(e);
		// 等待用户检查短信或邮件
		return "redirect:/account/waitUserCheck.html";
	}

	/**
	 * ajax检查用户名称是否存在
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/{site}/ckAccount")
	@ResponseBody
	public JsonMsg checkAccountExist(@PathVariable("site") Long siteId, String account) {
		JsonMsg msg = new JsonMsg();
		if (StringUtils.isBlank(account)) {
			msg.setSuccess(false);
			msg.setMsg("用户名不能为空!");
		} else {
			try {
				Account user = buyerAPI.findByAccount(siteId, account);
				if (null != user) {
					msg.setSuccess(false);
					msg.setMsg("用户名已存在！");
				} else {
					msg.setSuccess(true);
					msg.setMsg("用户名不存在！");
				}
			} catch (ApiException e1) {
				msg.setSuccess(false);
				msg.setMsg("未知错误！");
			}
		}
		return msg;
	}
}
