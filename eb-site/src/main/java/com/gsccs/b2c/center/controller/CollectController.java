package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import com.gsccs.b2c.api.domain.Collect;
import com.gsccs.b2c.api.domain.Collect.CollectType;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.CollectServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 收藏管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/collect")
public class CollectController {

	private Logger logger = Logger.getLogger(CollectController.class);
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private CollectServiceI collectAPI;
	@Autowired
	private BuyerServiceI buyerAPI;

	/**
	 * 收藏商品
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String mycart(@PathVariable("site") Long siteId, String type,
			Model model, HttpServletResponse response) {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_collect.html";
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
	 * 收藏列表
	 * 
	 * @param request
	 * @param type
	 *            商品收藏/品牌收藏
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray getCollect(@PathVariable("site") Long siteId,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize,
			HttpServletRequest request, String type) {
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, username);
			Long buyerid = user.getUserId();
			
			Collect collect = new Collect();
			collect.setBuyerid(buyerid);
			if (StringUtils.isEmpty(type)) {
				collect.setType(CollectType.PRODUCT);
			}else{
				collect.setType(CollectType.valueOf(type));
			}
			return collectAPI.getCollects(collect, page, pagesize);
		} catch (ApiException e) {
			logger.info("获取收藏列表失败："+e.getErrCode()+e.getErrMsg());
		} catch (Exception e) {
			logger.info("获取收藏列表失败："+e.getMessage());
		}
		return null;
	}

	/**
	 * 添加收藏
	 * 
	 * @param request
	 * @param type
	 *            商品收藏/品牌收藏
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addCollect(@PathVariable("site") Long siteId,
			HttpServletRequest request, String targetid, String type) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();

		if (StringUtils.isNotEmpty(targetid) && StringUtils.isNotEmpty(type)) {
			json.setSuccess(false);
			json.setMsg("收藏失败，目标对象不存在。");
			return json;
		}

		Collect collect = new Collect();
		collect.setTargetid(targetid);
		collect.setType(CollectType.valueOf(type));
		collect.setSiteid(siteId);
		collect.setAccount(username);
		ssdbService.addCollect(siteId, username, collect);
		json.setSuccess(true);
		json.setMsg("添加收藏成功!");
		return json;
	}

	/**
	 * 删除收藏信息
	 * 
	 * @param request
	 * @param cartId
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public JsonMsg delCart(@PathVariable("site") Long siteId,
			HttpServletRequest request, Long cartId) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();

		// cartServiceAPI.deleteCart(siteId, cartId);

		json.setSuccess(true);
		json.setMsg("删除购物车信息成功!");

		return json;
	}
}
