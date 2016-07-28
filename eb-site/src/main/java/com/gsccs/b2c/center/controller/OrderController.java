package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.DeliverServiceI;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.domain.trade.Order.OrderState;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 订单管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/order")
public class OrderController {

	private Logger logger = Logger.getLogger(OrderController.class);
	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private GoodsServiceI goodsAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private OrderServiceI orderAPI;
	@Autowired
	private DeliverServiceI logistAPI;
	@Autowired
	private EvalServiceI evalAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	/**
	 * 立即购买
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/buyImmedit", method = RequestMethod.POST)
	public JsonMsg settle(@PathVariable("site") Long siteId, Long pid,
			Long skuid, Integer num, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JsonMsg jsonmsg = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			if (null == pid) {
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("无需要结算的产品!");
				return jsonmsg;
			}

			Date date = new Date();
			Long rid = date.getTime();
			Product product = redisService.getProduct(siteId, pid);
			OrderItem item = new OrderItem();
			item.setProductid(pid);
			item.setTitle(product.getTitle());
			item.setNum(null == num ? 1 : num);
			Sku sku = goodsAPI.getSKU(siteId, pid, skuid);
			if (null != sku) {
				item.setSkuid(skuid);
				item.setSpecstr(sku.getSpecStr());
			}

			ssdbService.addOrderItems(CacheConst.ORDER_LIST_ + username + "_"
					+ rid, item);
			jsonmsg.setSuccess(true);
			jsonmsg.setData(rid);
		} catch (Exception e) {
			jsonmsg.setSuccess(false);
			jsonmsg.setMsg("未知错误");
		}
		return jsonmsg;
	}

	/**
	 * 购物车结算页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/settle.html", method = RequestMethod.GET)
	public String settle(@PathVariable("site") Long siteId, String rid,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_settle.html";

		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rid", rid);
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
	 * 我的订单
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 * @
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String orders(@PathVariable("site") Long siteId, String state,
			Model model, HttpServletResponse response)  {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_list.html";
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = redisService.getBuyer(siteId, username);
			Long buyerid = user.getUserId();
			Order param = new Order();
			param.setBuyerid(buyerid);
			int total = orderAPI.getOrderCount(siteId, param);
			JSONObject statistObj = orderAPI.orderStatist(siteId, buyerid);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			data.put("state", state);
			data.put("total", total);
			data.put("statistnum", statistObj);
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
	 * 订单详情页面
	 * 
	 * @param siteId
	 * @param orderid
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/detail.html", method = RequestMethod.GET)
	public String orderDetail(@PathVariable("site") Long siteId,
			String orderid, Model model, HttpServletResponse response) {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_detail.html";
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			if (StringUtils.isEmpty(orderid)) {
				tempPath = "html/order_404.html";
			} else {
				Order order = orderAPI.getOrder(siteId, Long.valueOf(orderid));
				List<OrderItem> orderitem = orderAPI.getOrderItems(siteId,
						order.getId());
				data.put("order", order);
				data.put("orderitems", orderitem);
			}
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
	 * 订单评价页面
	 * 
	 * @param siteId
	 * @param orderid
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/eval.html", method = RequestMethod.GET)
	public String orderEval(@PathVariable("site") Long siteId, String orderid,
			Model model, HttpServletResponse response)  {

		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_eval.html";
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			if (StringUtils.isEmpty(orderid)) {
				tempPath = "html/order_404.html";
			} else {
				Order order = orderAPI.getOrder(siteId, Long.valueOf(orderid));
				data.put("order", order);
			}
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
	 * 订单物流信息页面
	 * 
	 * @param siteId
	 * @param orderid
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ship.html", method = RequestMethod.GET)
	public String orderShip(@PathVariable("site") Long siteId, String orderid,
			Model model, HttpServletResponse response){
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_ship.html";
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			if (StringUtils.isEmpty(orderid)) {
				tempPath = "html/order_404.html";
			} else {
				Order order = orderAPI.getOrder(siteId, Long.valueOf(orderid));
				data.put("order", order);
			}
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
	 * 购物车结算
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/settle", method = RequestMethod.POST)
	public JsonMsg settle(@PathVariable("site") Long siteId,
			@RequestBody List<OrderItem> items, Model model,
			HttpServletResponse response, HttpServletRequest request) {
		JsonMsg jsonmsg = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			if (null == items || items.size() == 0) {
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("无需要结算的产品!");
				return jsonmsg;
			}

			Date date = new Date();
			Long rid = date.getTime();

			// 会员购物车中商品列表
			List<OrderItem> cartItems = ssdbService
					.cartItems(CacheConst.CART_LIST_ + siteId + "_" + username);
			if (null != cartItems && cartItems.size() > 0) {
				int i = 0;
				for (OrderItem item : cartItems) {
					// 本次结算商品
					for (OrderItem item_ : items) {
						// logger.info("商品数量："+item_.getNum());
						if (item_.getId().equals(item.getId())) {
							item.setNum(null == item_.getNum() ? 1 : item_
									.getNum());
							ssdbService.addOrderItems(CacheConst.ORDER_LIST_
									+ username + "_" + rid, item);
						}
					}
					i++;
				}
			}
			jsonmsg.setSuccess(true);
			jsonmsg.setData(rid);
			jsonmsg.setMsg("生成订单成功！");
		} catch (Exception e) {
			jsonmsg.setSuccess(false);
			jsonmsg.setMsg("结算失败：未知错误！");
		}
		return jsonmsg;
	}

	/**
	 * 结算商品清单
	 * 
	 * @param siteId
	 * @param rid
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/settleItems", method = RequestMethod.POST)
	public JSONObject settleItems(@PathVariable("site") Long siteId,
			String rid, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject json = new JSONObject();

		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		// 待结算商品清单
		List<OrderItem> items = ssdbService.OrderItems(CacheConst.ORDER_LIST_
				+ username + "_" + rid);
		Integer goodsnum = 0;
		Double goodsfee = 0.00;
		Float shipfee = 0.00f;
		Double discount = 0.00;
		if (null != items && items.size() > 0) {
			for (OrderItem item : items) {
				goodsnum = goodsnum + item.getNum();
				goodsfee = goodsfee + item.getNum() * item.getPrice();
				try {
					// 待结算商品
					Product p = goodsAPI
							.getProduct(siteId, item.getProductid());
					// 物流费用
					float itemshipfee = logistAPI.calculateFee(siteId,
							p.getPostage(), null, p.getWeight());
					shipfee = shipfee + itemshipfee;
				} catch (ApiException e) {
					logger.info("获取结算商品错误：错误编码：" + e.getErrCode() + "错误描述："
							+ e.getErrMsg());
				}
			}
		}

		json.put("rid", rid);
		json.put("items", items);
		// 商品数量
		json.put("goodsnum", goodsnum);
		// 商品总额
		json.put("goodsfee", goodsfee);
		// 物流费用
		json.put("shipfee", shipfee);
		// 优惠总额
		json.put("discount", JSON.toJSONString(discount));
		// 订单总额
		Double orderfee = goodsfee + shipfee - discount;
		json.put("totalfee", orderfee);

		return json;
	}

	/**
	 * 订单创建
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JsonMsg create(@PathVariable("site") Long siteId, Model model,
			String rid, String addressid, String shiptypeid,
			HttpServletResponse response) {

		JsonMsg json = new JsonMsg();
		try {
			Float shipfee = 0.00f;
			Double totalfee = 0.00d;
			Integer totalnum = 0;

			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = redisService.getBuyer(siteId, account);
			Deliver deliver = null;
			if (StringUtils.isNotEmpty(addressid)) {
				deliver = buyerAPI.getbuyerDeliver(siteId, user.getUserId(),
						Long.valueOf(addressid));
			}

			if (null == deliver) {
				json.setSuccess(false);
				json.setMsg("生成订单失败：邮寄地址有误！");
				return json;
			}

			List<OrderItem> items = ssdbService
					.OrderItems(CacheConst.ORDER_LIST_ + account + "_" + rid);
			if (null == items || items.size() <= 0) {
				json.setSuccess(false);
				json.setMsg("生成订单失败：无待结算的商品");
				return json;
			}

			List<OrderItem> lastItems = new ArrayList<OrderItem>();
			for (OrderItem item : items) {
				totalfee = totalfee + item.getPrice() * item.getNum();
				totalnum = totalnum + item.getNum();
				
				Product p = goodsAPI.getProduct(siteId, item.getProductid());
				float itemshipfee = logistAPI.calculateFee(siteId,
						p.getPostage(), null, p.getWeight());
				shipfee = shipfee + itemshipfee;
				shiptypeid = p.getPostage();
				
				item.setPtitle(p.getTitle());
				item.setPurl(p.getImg());
				item.setAccout(totalfee);
				item.setBuyer(user.getUserId().toString());
				item.setSeller(siteId.toString());
				
				lastItems.add(item);

				// 删除购物车中商品记录
				ssdbService.delCartItems(CacheConst.CART_LIST_ + siteId + "_"
						+ account, item.getId());
			}
			Order order = new Order();
			order.setStoreid(siteId);
			order.setBuyerid(user.getUserId());
			order.setShipfee(Double.valueOf(shipfee));
			order.setTotalfee(totalfee);
			order.setTotalnum(totalnum);
			order.setShiptype(shiptypeid);
			order.setConsignee(deliver.getReceiver());
			order.setReceaddress(deliver.getRegion() + deliver.getDetails());
			order.setPhone(deliver.getMobile());
			order.setTelnum(deliver.getTelephone());
			order.setState(OrderState.WAIT_PAY);
			String ordersn = orderAPI.createOrder(siteId, order, lastItems);

			json.setSuccess(true);
			json.setData(ordersn);
			json.setMsg("订单创建成功!");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("订单创建失败:" + e.getErrMsg());
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("订单创建失败:未知原因！" + e.getLocalizedMessage());
		}
		return json;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject orderinfo(@PathVariable("site") Long siteId, String sn,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Order order;
		List<OrderItem> orderItems = null;
		try {
			order = orderAPI.getOrder(siteId, Long.valueOf(sn));
			if (null != order) {
				orderItems = orderAPI.getOrderItems(siteId, order.getId());
			}
			json.put("order", order);
			json.put("orderItems", orderItems);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 分页查询订单列表
	 * 
	 * @param siteId
	 * @param page
	 * @param pagesize
	 * @param state
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public JSONObject orderList(@PathVariable("site") Long siteId,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, String state,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = buyerAPI.findByAccount(siteId, username);
			Long buyerid = user.getUserId();
			Order param = new Order();
			if (StringUtils.isNotEmpty(state)) {
				param.setState(OrderState.valueOf(state));
			}
			param.setBuyerid(buyerid);
			List<Order> orderlist = orderAPI.getBuyerOrderList(siteId, param,
					"addtime desc", page, pagesize);

			int total = orderAPI.getOrderCount(siteId, param);
			Map<String, List<OrderItem>> orderItemMap = new HashMap<String, List<OrderItem>>();
			if (null != orderlist && orderlist.size() > 0) {
				for (Order o : orderlist) {
					orderItemMap.put(o.getId().toString(),
							orderAPI.getOrderItems(siteId, o.getId()));
				}
			}

			JSONObject statistObj = orderAPI.orderStatist(siteId, buyerid);
			json.put("orderlist", orderlist);
			json.put("orderItemMap", orderItemMap);
			json.put("total", total);
			json.put("statist", statistObj);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 订单支付页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pay.html", method = RequestMethod.GET)
	public String pay(@PathVariable("site") Long siteId, String sn,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_pay.html";

		try {
			Map<String, Object> data = new HashMap<String, Object>();
			if (StringUtils.isEmpty(sn)) {
				tempPath = "html/order_404.html";
			} else {
				Order order = orderAPI.getOrder(siteId, Long.valueOf(sn));
				List<OrderItem> orderitem = orderAPI.getOrderItems(siteId,
						order.getId());
				data.put("order", order);
				data.put("orderitems", orderitem);
			}

			data.put("sn", sn);
			data.put("store", redisService.getStore(siteId));
			File dir = new File(sitePath);
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
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
	 * 订单取消
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg orderCancel(@PathVariable("site") Long siteId,
			String ordersn, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		try {
			if (null == siteId || StringUtils.isEmpty(ordersn)) {
				json.setSuccess(false);
				json.setMsg("订单取消失败，订单不存在。");
				return json;
			}
			orderAPI.orderCancel(siteId, ordersn);
			json.setSuccess(true);
			json.setMsg("订单取消成功！");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("订单取消失败，未知错误");
		}
		return json;
	}

	
	
	/**
	 * 买家收货确认
	 * 
	 * @param siteId
	 * @param ordersn
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/received", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg orderReceived(@PathVariable("site") Long siteId,
			String ordersn, Model model) {
		JsonMsg json = new JsonMsg();
		try {
			if (null == siteId || StringUtils.isEmpty(ordersn)) {
				json.setSuccess(false);
				json.setMsg("确认收货失败，订单不存在。");
				return json;
			}
			orderAPI.orderReceived(siteId, ordersn);
			json.setSuccess(true);
			json.setMsg("确认收货成功！");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("确认收货失败，未知错误");
		}
		return json;
	}

	/**
	 * 订单跟踪记录
	 * 
	 * @param siteId
	 * @param ordersn
	 * @return
	 */
	@RequestMapping(value = "/tracelist", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray orderTraceList(@PathVariable("site") Long siteId,
			String ordersn, Model model) {
		try {
			return orderAPI.orderTraceList(siteId, ordersn);
		} catch (ApiException e) {

		}
		return null;
	}

	
	

	/**
	 * 会员订单统计
	 * 
	 * @param siteId
	 * @param request
	 * @return
	 */
	@RequestMapping("/statist")
	@ResponseBody
	public JSONObject orderStatic(@PathVariable("site") Long siteId,
			HttpServletRequest request) {
		JSONObject json = null;
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = buyerAPI.findByAccount(siteId, username);
			Long uid = user.getUserId();
			json = orderAPI.orderStatist(siteId, uid);
		} catch (Exception e) {
		}
		return json;
	}
}
