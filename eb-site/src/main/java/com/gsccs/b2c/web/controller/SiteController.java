package com.gsccs.b2c.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;

import freemarker.template.TemplateModelException;

/**
 * 商城门户首页
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SiteController {

	private Logger logger = Logger.getLogger(SiteController.class);

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	/**
	 * 商城首页
	 * 
	 * @param siteId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{site}/index.html", method = RequestMethod.GET)
	public String site(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/index.html";
		Shop shop;
		try {
			shop = shopAPI.getShop(siteId);
			if (null == shop) {
				tempPath = "html/shop404.html";
			}
			JSONObject storeyObj = redisService.getStoreyList(siteId);
			Map<String, Object> data = new HashMap<String, Object>();
			// 域名
			data.put("domain", redisService.getDomain(siteId.toString()));
			data.put("store", redisService.getStore(siteId));
			data.put("storey", storeyObj);

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
			FreeMarkerUtil.createWriter(dir, data, tempPath,
					response.getWriter());

		} catch (TemplateModelException e) {
			// e.printStackTrace();
			logger.info(e.getMessage());
		} catch (IOException e) {
			// e.printStackTrace();
			logger.info(e.getMessage());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info(e.getMessage());
		}
		return null;
	}

	/**
	 * 店铺导航
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/navlist", method = RequestMethod.GET)
	public JsonMsg storenav(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		List<Navigation> navlist = redisService.getStoreNavs(siteId);
		json.setSuccess(true);
		json.setData(navlist);
		return json;
	}

}
