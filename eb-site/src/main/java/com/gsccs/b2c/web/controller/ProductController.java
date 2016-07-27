package com.gsccs.b2c.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.ProductProp;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 商品详情页
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ProductController {

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;
	@Autowired
	private SsdbService ssdbService;

	/**
	 * 商品详情展示页面
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/{site}/item-{pid}.html", method = RequestMethod.GET)
	public String index(@PathVariable("site") Long siteId,
			@PathVariable("pid") Long pid, Model model,
			HttpServletResponse response) {

		String tempPath = "html/product.html";
		// 站点ID不存在，跳转站点404页面
		if (null == siteId) {
			tempPath = "html/shop_404.html";
		}
		if (null == pid) {
			tempPath = "html/product_404.html";
		}

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			// 商品基本信息
			Product product = redisService.getProduct(siteId, pid);
			if (null != product) {
				data.put("product", redisService.getProduct(siteId, pid));
				// 商品品牌
				Brand brand = redisService.getBrand(siteId, product.getBrand());
				data.put("brand", brand);
				// 扩展属性
				data.put("product_prop", JSON.toJSONString(ssdbService
						.getProductProps(siteId, pid)));
				// 详细参数
				data.put("product_param", JSON.toJSONString(ssdbService
						.getProductParam(siteId, pid)));
			} else {
				tempPath = "html/product_404.html";
			}

			// 店铺
			data.put("store", redisService.getStore(siteId));
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
	 * 商品图片商品描述
	 * 
	 * @param siteId
	 * @param pid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/descimgs", method = RequestMethod.GET)
	public JSONObject productInfo(@PathVariable("site") Long siteId, Long pid,
			Model model, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		JSONArray imgarray = ssdbService.getProductImgs(siteId, pid);
		String desc = ssdbService.getProductDesc(siteId, pid);
		json.put("images", imgarray);
		json.put("desc", desc);
		return json;
	}

	/**
	 * 产品参数
	 * 
	 * @param siteId
	 * @param pid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/skus", method = RequestMethod.GET)
	public JSONObject getProductSKU(@PathVariable("site") Long siteId,
			Long pid, Model model, HttpServletResponse response){
		return ssdbService.getSkuSpecData(siteId, pid);
	}

	@ResponseBody
	@RequestMapping(value = "/{site}/desc", method = RequestMethod.GET)
	public JsonMsg getProductDesc(@PathVariable("site") Long siteId, Long pid,
			Model model, HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		String desc = ssdbService.getProductDesc(siteId, pid);
		if (StringUtils.isNotEmpty(desc)) {
			json.setSuccess(true);
			json.setData(desc);
		} else {
			json.setSuccess(false);
		}
		return json;
	}

	/**
	 * 产品参数
	 * 
	 * @param siteId
	 * @param pid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/props", method = RequestMethod.GET)
	public JSONArray getProductProp(@PathVariable("site") Long siteId,
			Long pid, Model model, HttpServletResponse response) {
		JSONArray array = new JSONArray();
		// 扩展属性
		List<ProductProp> props = ssdbService.getProductProps(siteId, pid);
		Product product = redisService.getProduct(siteId, pid);
		JSONObject nameobj = new JSONObject();
		JSONObject barcodeobj = new JSONObject();
		JSONObject saletimeobj = new JSONObject();
		nameobj.put("title", "商品名称");
		nameobj.put("value", product.getTitle());
		barcodeobj.put("title", "商品编号");
		barcodeobj.put("value", product.getBarcode());
		saletimeobj.put("title", "上架时间");
		saletimeobj.put("value", product.getCreatedStr());
		array.add(nameobj);
		array.add(barcodeobj);
		array.add(saletimeobj);
		if (null != props && props.size() > 0) {
			for (ProductProp prop : props) {
				JSONObject propobj = new JSONObject();
				propobj.put("title", prop.getPropTitle());
				propobj.put("value", prop.getPropVal());
				array.add(propobj);
			}
		}
		return array;
	}

	/**
	 * 累计评价
	 * 
	 * @param siteId
	 * @param pid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/product/evals", method = RequestMethod.GET)
	public JSONArray getProductEval(@PathVariable("site") Long siteId,
			Long pid, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Model model,
			HttpServletResponse response) {
		JSONArray array = new JSONArray();
		try {
			ssdbService.getProductEvals(siteId, pid, page, rows);
		} catch (Exception e) {

		}
		return array;
	}

	/**
	 * 月成交记录
	 * 
	 * @param siteId
	 * @param pid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/product/sales", method = RequestMethod.GET)
	public JSONObject getProductSale(@PathVariable("site") Long siteId,
			Long pid, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Model model,
			HttpServletResponse response) {
		return ssdbService.getProductSales(siteId, pid, page, rows);
	}
}
