package com.gsccs.b2c.store.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.StoreyServiceI;
import com.gsccs.b2c.store.base.JsonMsg;
import com.gsccs.eb.api.domain.site.Banner;
import com.gsccs.eb.api.domain.site.Storey;
import com.gsccs.eb.api.domain.site.Storey.IndexBrand;
import com.gsccs.eb.api.exception.ApiException;


@Controller
public class HomeController {

	@Autowired
	private StoreyServiceI storeyAPI;
	/*
	 * @Autowired private BannerServiceI bannerServiceAPI;
	 */
	@Autowired
	private RedisTemplate ssdbTemplate;
	@Autowired
	private CateServiceI cateServiceAPI;

	/**
	 * 楼层数据
	 * @param storey
	 * @param request
	 * @return
	 */
	@RequestMapping("/storeydata")
	@ResponseBody
	public JSONObject storeydata(HttpServletRequest request) {
		try {
			JSONObject jsonObject = storeyAPI.findStoreyList(1001l);
			System.out.println(jsonObject.toJSONString());
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 保存楼层数据
	 * 
	 * @param request
	 * @param storey
	 * @return
	 */
	@RequestMapping("/saveStorey")
	@ResponseBody
	public JsonMsg saveStoreyList(Storey storey, HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		long siteId = (Long) request.getSession().getAttribute("siteId");
		String cate = storey.getCate();
		String brand = storey.getBrand();
		String goods = storey.getGoods();
		JSONObject jsonObject = new JSONObject();

		if (null != storey) {
			jsonObject.put("title", storey.getTitle());
			jsonObject.put("link", storey.getTitleLine());
			jsonObject.put("mainimg", storey.getMainImg());
			jsonObject.put("mainlink", storey.getMainImgline());
			jsonObject.put("ordernum", storey.getOrderNum());
		}

		JSONArray itemArray = new JSONArray();
		if (StringUtils.isNotEmpty(cate)) {
			for (String cs : cate.split("!!")) {
				String[] cats = cs.split(";;");
				if (cats.length > 1) {
					JSONObject object = new JSONObject();
					object.put("title", cats[0]);
					object.put("link", cats[1]);
					object.put("type", "CATEGORY");
					itemArray.add(object);
				}
			}
		}

		if (StringUtils.isNotEmpty(brand)) {
			for (String br : brand.split("!!")) {
				String[] brs = br.split(";;");
				if (brs.length > 1) {
					JSONObject object = new JSONObject();
					object.put("title", brs[0]);
					object.put("link", brs[1]);
					object.put("type", "BRAND");
					itemArray.add(object);
				}
			}
		}

		if (StringUtils.isNotEmpty(goods)) {
			for (String gd : goods.split("!!")) {
				String[] gds = gd.split(";;");
				if (gds.length > 1) {
					JSONObject object = new JSONObject();
					object.put("imgurl", gds[0]);
					object.put("link", gds[1]);
					object.put("type", "PRODUCT");
					itemArray.add(object);
				}
			}
		}
		jsonObject.put("items", itemArray);
		try {
			storeyAPI.addStorey(siteId, jsonObject);
			json.setSuccess(true);
			json.setMsg("保存楼层信息成功!");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("保存楼层失败!");
		}
		// ssdbTemplate.boundListOps(CacheConst.STOREY_ +
		// siteId).rightPush(storey);
		return json;
	}

	/**
	 * 保存banner
	 * 
	 * @param request
	 * @param banner
	 * @return
	 */
	@RequestMapping("/saveBanner")
	@ResponseBody
	public JsonMsg saveBanner(HttpServletRequest request, Banner banner) {
		JsonMsg json = new JsonMsg();
		long siteId = (Long) request.getSession().getAttribute("siteId");
		ssdbTemplate.boundListOps(CacheConst.INDEX_BANNER_ + siteId).leftPush(
				banner);

		json.setSuccess(true);
		json.setMsg("保存Banner信息成功!");

		return json;
	}

	/**
	 * 保存品牌数据
	 * 
	 * @param request
	 * @param brands
	 * @return
	 */
	@RequestMapping("/saveIndexBrands")
	@ResponseBody
	public JsonMsg saveIndexBrands(HttpServletRequest request,
			IndexBrand brands) {
		JsonMsg json = new JsonMsg();
		long siteId = (Long) request.getSession().getAttribute("siteId");

		json.setSuccess(true);
		json.setMsg("保存热门品牌信息成功!");
		return json;
	}

}
