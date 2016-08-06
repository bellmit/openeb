package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ProductServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.trade.CartItem;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 购物车管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/cart")
public class CartController {

	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private ProductServiceI goodsAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	/**
	 * 我的购物车
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cart.html", method = RequestMethod.GET)
	public String mycart(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_shopcart.html";
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

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg getGoodsItem(@PathVariable("site") Long siteId,
			HttpServletRequest request, Long productId, Long skuId) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();

		List<OrderItem> items = ssdbService.cartItems(CacheConst.CART_LIST_
				+ siteId + "_" + username);
		json.setSuccess(true);
		json.setData(items);

		return json;
	}

	/**
	 * 添加购物车
	 * 
	 * @param request
	 * @param cart
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addGoodsItem(@PathVariable("site") Long siteId,
			HttpServletRequest request, Long productId, Long skuId) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Product product = null;
		if (null == productId) {
			json.setSuccess(false);
			json.setMsg("添加购物车失败：商品不存在！");
			return json;
		}

		product = redisService.getProduct(siteId, productId);
		if (null == product) {
			json.setSuccess(false);
			json.setMsg("添加购物车失败：商品不存在！");
			return json;
		}

		OrderItem item = new OrderItem();
		item.setId(productId.toString());
		item.setProductid(product.getId());
		item.setTitle(product.getTitle());
		item.setPrice(product.getPrice());
		item.setPurl(product.getImg());
		item.setNum(1);
		item.setAddtime(new Date());
		if (null != skuId) {
			item.setId(productId + "_" + skuId);
			try {
				Sku sku = goodsAPI.getSku(siteId, Long.valueOf(productId),
						skuId);
				if (null != sku) {
					item.setSkuid(sku.getId());
					item.setPrice(sku.getPrice() == null ? 0.00 : sku
							.getPrice());
					item.setSpecstr(sku.getSpecstr());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ssdbService.addCartItems(CacheConst.CART_LIST_ + siteId + "_"
				+ username, item);
		json.setSuccess(true);
		json.setMsg("添加购物车成功!");
		return json;
	}

	/**
	 * 获取购物车数据
	 * 
	 * @param siteId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCartItems")
	@ResponseBody
	public JSONObject getCartItems(@PathVariable("site") Long siteId,
			HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Integer totalnum = 0;
		Double totalfee = 0.00;
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		List<OrderItem> items = ssdbService.cartItems(CacheConst.CART_LIST_
				+ siteId + "_" + username);

		if (null != items && items.size() > 0) {
			for (OrderItem item : items) {
				if (null != item.getPrice() && null != item.getNum()) {
					totalnum = totalnum + item.getNum();
					totalfee = totalfee + item.getNum() * item.getPrice();
					if (null == item.getAccout()) {
						item.setAccout(item.getNum() * item.getPrice());
					}
				}
			}
		}

		json.put("totalnum", totalnum);
		json.put("totalfee", totalfee);
		json.put("items", items);

		return json;
	}

	/**
	 * 删除购物车信息
	 * 
	 * @param request
	 * @param cartId
	 * @return
	 */
	@RequestMapping("/delCart")
	@ResponseBody
	public JsonMsg delCart(@PathVariable("site") Long siteId,
			HttpServletRequest request, String pid, String skuid) {
		JsonMsg json = new JsonMsg();
		String itemid = pid + "_" + skuid;
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		// cartServiceAPI.deleteCart(siteId, cartId);

		// 先通过siteid和username获得购物车信息，循环判断，然后删除
		ssdbService.delCartItems(CacheConst.CART_LIST_ + siteId + "_"
				+ username, itemid);
		json.setSuccess(true);
		json.setMsg("删除购物车信息成功!");

		return json;
	}

	/**
	 * 购物车数量更新
	 * 
	 * @return
	 */
	@RequestMapping("/modifynumber")
	@ResponseBody
	public JsonMsg modifyCartNumber(HttpServletRequest request, CartItem cart) {
		JsonMsg json = new JsonMsg();
		int modifySize = 1;
		// cartServiceAPI.upadteCart(siteId, cart);
		if (modifySize == 1) {
			// Cart car = cartServiceAPI.getCart(siteId, cart.getId());
			json.setSuccess(true);
			json.setMsg("更新购物车成功!");
			// json.setData(car);
		}
		return json;
	}

}
