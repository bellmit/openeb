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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.domain.BuyerScore;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;

import freemarker.template.TemplateModelException;

/**
 * 积分管理管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/points")
public class PointController {

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private RedisService redisService;
	@Autowired
	private SsdbService ssdbService;

	/**
	 * 积分记录清单
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 * @
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String mycart(@PathVariable("site") Long siteId, String type,
			Model model, HttpServletResponse response)  {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_points.html";
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			User user = buyerAPI.findByAccount(siteId, username);
			Map<String, Object> data = new HashMap<String, Object>();
			int total = buyerAPI.getBuyerPoint(siteId,user.getUserId());
			data.put("store", redisService.getStore(siteId));
			data.put("total", total);
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
	 * 积分明细数据
	 * @param siteId
	 * @param page
	 * @param pagesize
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public JSONArray settle(@PathVariable("site") Long siteId,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response, HttpServletRequest request) {
		JSONArray json = new JSONArray();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			User user = buyerAPI.findByAccount(siteId, username);
			BuyerScore param = new BuyerScore();
			param.setBuyerid(user.getUserId());
			List<BuyerScore> scores = buyerAPI.getBuyerPoints(siteId, param,
					page, pagesize);
			json = (JSONArray) json.toJSON(scores);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}

}
