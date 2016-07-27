package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.eb.api.domain.buyer.BuyerDeliver;

import freemarker.template.TemplateModelException;

/**
 * 会员管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/buyer")
public class BuyerController {

	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 会员基本信息管理
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/info.html", method = RequestMethod.GET)
	public String info(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_info.html";
		try {

			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, account);

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("buyer", user);
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
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
	 * 会员帐号安全管理
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/safe.html", method = RequestMethod.GET)
	public String safe(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_safe.html";
		try {

			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, account);

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("buyer", user);
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
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
	 * 收货地址管理
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/address.html", method = RequestMethod.GET)
	public String index(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_deliver.html";
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
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
	 * 获取邮寄地址列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dlvlist", method = RequestMethod.GET)
	public JsonMsg confirm(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) throws ApiException {
		JsonMsg json = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, account);
			Long uid = user.getUserId();
			JSONArray delivers = buyerAPI.buyerDelivers(siteId, uid);
			json.setSuccess(true);
			json.setMsg("获取收货地址信息成功");
			json.setData(delivers);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("获取收货地址失败");
		}
		return json;
	}

	/**
	 * 新增邮寄地址
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/adddlv", method = RequestMethod.POST)
	public JsonMsg adddlv(@PathVariable("site") Long siteId, BuyerDeliver dlv,
			Model model, HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, account);
			Long uid = user.getUserId();

			if (null != dlv) {
				dlv.setBuyerid(uid);
				buyerAPI.addBuyerDelivers(siteId, dlv);
			}
			json.setSuccess(true);
			json.setMsg("新增收货地址信息成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增收货地址失败");
		}
		return json;
	}

}
