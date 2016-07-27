package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.EvalGoods;
import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.domain.Order.OrderState;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;

import freemarker.template.TemplateModelException;

/**
 * 会员中心
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/home")
public class HomeController {

	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private OrderServiceI orderAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String index(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/home.html";
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

}
