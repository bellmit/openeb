package com.gsccs.b2c.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.api.service.TypeServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.solr.service.QueryParam;
import com.gsccs.b2c.solr.service.SolrService;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 类目管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class CategoryController {

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private CateServiceI cateAPI;
	@Autowired
	private TypeServiceI typeAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 商品类目页面
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 * @
	 */
	@RequestMapping(value = "/{siteId}/list-{cateid}.html", method = RequestMethod.GET)
	public String index(@PathVariable("siteId") Long siteId,
			@PathVariable("cateid") String cateid, String keyword,
			String brand, String prop, String price, String sort, Model model,
			HttpServletRequest request, HttpServletResponse response)
			 {

		// 类目ID为空,则跳转到商城首页
		if (StringUtils.isEmpty(cateid)) {
			return "redirect:index.html";
		} else {
			Category category = redisService.getCategory(Long.valueOf(siteId),
					Long.valueOf(cateid));
			if (null == category || category.getParid().equals(0)) {
				return "redirect:index.html";
			}
			String tempPath = "html/category.html";
			String sitePath = redisService.getRootPath() + File.separator
					+ siteId;
			try {
				Map<String, Object> data = new HashMap<String, Object>();
				SolrService solrService = new SolrService();
				solrService.init();
				String[] brandArr = null;
				String[] propArr = null;
				String[] propvalArr = null;
				Integer minp = null, maxp = null;

				// 品牌请求参数
				if (StringUtils.isNotEmpty(brand)) {
					brandArr = brand.split(":");
				}

				// 属性请求参数
				if (StringUtils.isNotEmpty(prop)) {
					List<String> attrvallist = new ArrayList<String>();
					// :分割查询条件
					String[] attrValsStrArr = prop.split(":");
					if (null != attrValsStrArr && attrValsStrArr.length > 0) {
						propvalArr = new String[attrValsStrArr.length];
						propArr = new String[attrValsStrArr.length];
						for (int i = 0; i < attrValsStrArr.length; i++) {
							// 单个查询条件：由单个属性_多个属性值组成
							String attrValStrArr[] = attrValsStrArr[i]
									.split("_");
							// condlist.put(attrValsStrArr[i], "");
							if (null != attrValStrArr
									&& attrValStrArr.length > 0) {
								// 属性ID
								propArr[i] = attrValStrArr[0];
								// 属性属性值组合:属性ID_属性值ID
								propvalArr[i] = attrValStrArr[0];
								for (int j = 1; j < attrValStrArr.length; j++) {
									attrvallist.add(propvalArr[i] + "_"
											+ attrValStrArr[j]);
								}
							}
						}
					}
					if (null != attrvallist && attrvallist.size() > 0) {
						propvalArr = (String[]) attrvallist
								.toArray(new String[attrvallist.size()]);
					}
				}
				// 价格请求参数
				if (StringUtils.isNotEmpty(price)) {
					String[] priceArr = price.split("_");
					if (null != priceArr && priceArr.length > 1) {
						minp = Integer.valueOf(price.split("_")[0]);
						maxp = Integer.valueOf(price.split("_")[1]);
					}
				}

				// 搜索条件对象
				QueryParam param = new QueryParam();
				param.setSiteId(siteId.toString());
				param.setCateId(cateid);
				param.setBrandIds(brandArr);
				param.setAttrIds(propArr);
				param.setAttrValIds(propvalArr);
				param.setMinPrice(minp);
				param.setMaxPrice(maxp);
				param.setKeyword(keyword);
				/*
				 * param.setPage(page); param.setRows(rows);
				 */
				// 分片查询条件
				JSONObject json = solrService.facetQuery(param);
				// 查询参数
				data.put("param_cate", cateid);
				data.put("param_keyword", keyword);
				data.put("param_prop", prop);
				data.put("param_brand", brand);
				data.put("param_sort", sort);
				data.put("param_price", price);
				data.put("search_param", json.toString());
				data.put("category", category);
				data.put("store", redisService.getStore(siteId));

				// 生成页面
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
		}
		return null;
	}

	/**
	 * 类目页面查询结果
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/{siteId}/list-{cateid}", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray listData(@PathVariable("siteId") Long siteId,
			@PathVariable("cateid") String cateid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "32") int rows, String keyword,
			String brands, String props, String price, String sort,
			Model model, HttpServletResponse response) {

		QueryParam param = new QueryParam();
		SolrService solrService = new SolrService();
		solrService.init();
		String[] brandArr = null;
		String[] propArr = null;
		String[] propvalArr = null;
		Integer minp = null, maxp = null;

		// 品牌请求参数
		if (StringUtils.isNotEmpty(brands)) {
			brandArr = brands.split(":");
		}

		// 属性请求参数
		if (StringUtils.isNotEmpty(props)) {
			List<String> attrvallist = new ArrayList<String>();
			// :分割查询条件
			String[] attrValsStrArr = props.split(":");
			propvalArr = new String[attrValsStrArr.length];
			propArr = new String[attrValsStrArr.length];

			if (null != attrValsStrArr && attrValsStrArr.length > 0) {
				for (int i = 0; i < attrValsStrArr.length; i++) {
					// 单个查询条件：由单个属性_多个属性值组成
					String attrValStrArr[] = attrValsStrArr[i].split("_");
					if (null != attrValStrArr && attrValStrArr.length > 0) {
						// 属性ID
						propArr[i] = attrValStrArr[0];
						// 属性属性值组合:属性ID_属性值ID
						propvalArr[i] = attrValStrArr[0];
						for (int j = 1; j < attrValStrArr.length; j++) {
							attrvallist.add(propvalArr[i] + "_"
									+ attrValStrArr[j]);
						}

						/*
						 * CateProp prop = redisService.getProp(Long
						 * .valueOf(propArr[i])); if (null != prop){
						 * 
						 * }
						 */
					}
				}
			}
			if (null != attrvallist && attrvallist.size() > 0) {
				propvalArr = (String[]) attrvallist
						.toArray(new String[attrvallist.size()]);
			}
		}
		// 价格请求参数
		if (StringUtils.isNotEmpty(price)) {
			String[] priceArr = price.split("_");
			if (null != priceArr && priceArr.length > 1) {
				minp = Integer.valueOf(price.split("_")[0]);
				maxp = Integer.valueOf(price.split("_")[1]);
			}
		}

		param.setSiteId(siteId.toString());
		param.setCateId(cateid);
		param.setBrandIds(brandArr);
		param.setAttrIds(propArr);
		param.setAttrValIds(propvalArr);
		param.setMinPrice(minp);
		param.setMaxPrice(maxp);
		param.setKeyword(keyword);

		param.setPage(page);
		param.setRows(rows);

		return solrService.goodsQuery(param);
	}

	/**
	 * 获取类目数据
	 * 
	 * @param siteId
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/allcates")
	public JSONArray siteCategory(@PathVariable("site") Long siteId,
			Model model, HttpServletResponse response) {
		return redisService.getSiteCates(siteId);
	}

}
