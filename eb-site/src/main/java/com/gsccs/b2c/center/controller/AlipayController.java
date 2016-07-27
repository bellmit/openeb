package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.alipay.config.AlipayConfig;
import com.gsccs.b2c.alipay.util.AlipaySubmit;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.api.service.SellerServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.exception.ApiException;

import freemarker.template.TemplateModelException;

/**
 * 支付管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/alipay")
public class AlipayController {

	private Logger logger = Logger.getLogger(AlipayController.class);
	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private RedisService redisService;
	@Autowired
	private OrderServiceI orderAPI;
	@Autowired
	private SellerServiceI sellerAPI;

	/**
	 * 请求支付页面
	 * 
	 * @param siteId
	 * @param model
	 * @param sn
	 * @param response
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/payrequest", method = RequestMethod.GET)
	public String payrequest(@PathVariable("site") Long siteId, Model model,
			String sn, HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/deposit.html";

		try {
			Order order = null;
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));

			if (StringUtils.isNotEmpty(sn)) {
				order = orderAPI.getOrder(siteId, Long.valueOf(sn));
			}
			data.put("order", order);
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
	 * 支付宝在线订单支付
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public JsonMsg deposit(@PathVariable("site") Long siteId, Model model,
			String ordersn, HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		try {
			String domain = redisService.getDomain(siteId.toString());
			List<OrderItem> orderitems = orderAPI.getOrderItems(siteId,
					Long.valueOf(ordersn));
			AlipayConfig aliconf = new AlipayConfig();
			// 支付类型 必填 不必修改
			String payment_type = "1";

			// 服务器异步通知页面路径
			// 需http://格式的完整路径，不能加?id=123这类自定义参数
			String notify_url = domain + "/alipay/async.html";

			// 页面跳转同步通知页面路径
			// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
			String return_url = domain + "/alipay/return_url.html";

			// 订单名称
			String title = new String("测试商品".getBytes("UTF-8"), "UTF-8");
			Double totalfee = 0.00;
			if (null != orderitems && orderitems.size() > 0) {
				for (OrderItem item : orderitems) {
					String productTitle = item.getPtitle() == null ? "" : item
							.getPtitle();
					Double itemFee = item.getAccout() == null ? 0.00 : item
							.getAccout();
					title += productTitle + ";";
					totalfee += itemFee;
				}
			}
			// 付款金额
			String total_fee = totalfee.toString();
			// 测试付款金额
			total_fee = "0.01";
			
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "create_direct_pay_by_user"); // 接口服务----即时到账
			sParaTemp.put("partner", aliconf.getPartner()); // 支付宝PID
			sParaTemp.put("_input_charset", AlipayConfig.input_charset); // 统一编码
			sParaTemp.put("payment_type", payment_type); // 支付类型
			sParaTemp.put("notify_url", notify_url); // 异步通知页面
			sParaTemp.put("return_url", return_url); // 页面跳转同步通知页面
			sParaTemp.put("seller_email", aliconf.getSellerEmail()); // 卖家支付宝账号
			sParaTemp.put("out_trade_no", ordersn); // 商品订单编号
			sParaTemp.put("subject", title); // 商品名称
			sParaTemp.put("total_fee", total_fee); // 支付金额

			// 建立请求
			String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, aliconf,
					"get", "确认");
			json.setData(sHtmlText);
			json.setSuccess(true);

		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("支付失败：" + e.getMessage());
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 异步通知
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/async.html", method = RequestMethod.GET)
	public JsonMsg async(@PathVariable("site") Long siteId, Model model,
			HttpServletRequest request) {

		JsonMsg json = new JsonMsg();
		AlipayConfig conf = new AlipayConfig();
		Map<String, String> params = new HashMap<String, String>();
		try {
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter
					.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用。
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
				params.put(name, valueStr);
			}
			String outtradeNo = request.getParameter("out_trade_no");
			String tradeStatus = request.getParameter("trade_status");
			// String notifyId = request.getParameter("notify_id");
			/*
			 * if (AlipayNotify.verify(params, conf)) {// 验证成功 if
			 * (tradeStatus.equals("TRADE_FINISHED") ||
			 * tradeStatus.equals("TRADE_SUCCESS")) { // 更新订单状态
			 * orderAPI.orderPayment(siteId, outtradeNo);
			 * System.out.println(">>>>>支付成功" + outtradeNo); }
			 * json.setMsg("支付成功"); json.setSuccess(true); } else {
			 * json.setSuccess(false); json.setMsg("验证失败"); }
			 */

			if (tradeStatus.equals("TRADE_FINISHED")
					|| tradeStatus.equals("TRADE_SUCCESS")) {
				// 更新订单状态
				orderAPI.orderPayment(siteId, outtradeNo);
				System.out.println(">>>>>支付成功" + outtradeNo);
				json.setMsg("支付成功");
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
				json.setMsg("验证失败");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}

		return json;
	}

	
	
	/**
	 * 页面跳转同步通知页面路径
	 * 
	 * @param siteId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/return_url.html", method = RequestMethod.GET)
	public String returnUrl(@PathVariable("site") Long siteId, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/order_payed.html";
		boolean payed_result = true;
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		try {
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter
					.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			String trade_no = request.getParameter("trade_no");             //支付宝交易号  
		    String out_trade_no = request.getParameter("out_trade_no");         //获取订单号  
		    String total_fee = request.getParameter("total_fee");           //获取总金额
		    String buyer_email = request.getParameter("buyer_email");       //买家支付宝账号  
		    String trade_status = request.getParameter("trade_status");     //交易状态

		    // 计算得出通知验证结果
			AlipayConfig conf = new AlipayConfig();
			/*
			 * if (AlipayNotify.verify(params, conf)) { if
			 * (trade_status.equals("TRADE_FINISHED") ||
			 * trade_status.equals("TRADE_SUCCESS")) { // 更新订单状态
			 * orderAPI.orderPayment(siteId, out_trade_no); payed_result = true;
			 * } } else { payed_result = false; }
			 */

			if (trade_status.equals("TRADE_FINISHED")
					|| trade_status.equals("TRADE_SUCCESS")) {
				// 更新订单状态
				//orderAPI.orderPayment(siteId, out_trade_no);
				orderAPI.orderAlipayPayment(siteId, out_trade_no, trade_no, total_fee);
				payed_result = true;
			}
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			data.put("order",
					orderAPI.getOrder(siteId, Long.valueOf(out_trade_no)));
			data.put("payed_result", payed_result);

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
			// 生成商品页面
			FreeMarkerUtil.createWriter(dir, data, tempPath,
					response.getWriter());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (TemplateModelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
