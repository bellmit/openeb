package com.gsccs.b2c.web.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.api.exception.ApiException;


/**
 * 物流查询接口
 * @author x.d zhang
 *
 */
@Controller
@RequestMapping("/{site}/deliver")
public class DeliverController {

	/**
	 * TODO 快递100查询 
	 * @param String id 身份授权key 
	 * @param String com 快递公司代码(不支持中文，对应的公司代码) 
	 * @param String nu要查询的快递单号 
	 * @param String show 
	 * @param 返回类型（json，xml,html）0：返回json字符串， 1：返回xml对象，
	 * 2：返回html对象， 3：返回text文本。如果不填，默认返回json字符串。 
	 * @param String muti 返回信息数量 1:返回多行完整的信息，
	 * 0:只返回一行信息。 不填默认返回多行。
	 * @param String order 排序 desc：按时间由新到旧排列， asc：按时间由旧到新排列。 快递100
	 * http://api.kuaidi100.com/api?id=[]&com=[]&nu=[]&valicode=[]&show=0&muti=1&order=asc
	 */
	@RequestMapping(value = "/kuaidi100", method = RequestMethod.GET)
	public JSONObject getKuaiDiInfo(String com, String nu) {
		String key = "6959527b1a3a8782";// 授权密钥
		String urlString = "http://api.kuaidi100.com/api?id=" + key
				+ "&com=" + com + "&nu=" + nu + "&show=0&muti=1&order=desc";
		HttpGet getRequest = new HttpGet(urlString);
		JSONObject jsonObject = null;
		try {
			HttpClient client = HttpClients.createDefault();
			HttpResponse res = client.execute(getRequest);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				jsonObject = (JSONObject) JSON.toJSON(entity.getContent());
				/*jsonObject = new JSONObject(new JSONTokene(
						new InputStreamReader(entity.getContent(), HTTP.UTF_8)));*/
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jsonObject;
	}
	
	/**
	 * TODO 爱快递查询 2015 上午10:04:51 
	 * @param String key 授权密钥 
	 * @param String order 快递单号
	 * @param String id 快递代号 
	 * @param String ord 时间排序 
	 * @param String show 返回类型（json，xml,html） 爱快递
	 * http://www.aikuaidi.cn/rest/?key=[]&order=[]&id=[]&ord=[]&show=[]
	 */
	@RequestMapping(value = "/aikuaidi", method = RequestMethod.GET)
	public JSONObject getAiLogisticsInfo(String order, String id, String ord,
			String show) {
		String keyString = "";// 授权密钥
		String urlString = "http://www.aikuaidi.cn/rest/?key=" + keyString
				+ "&order=" + order + "&id=" + id + "&ord=" + ord + "&show="
				+ show + "";
		HttpGet getRequest = new HttpGet(urlString);
		JSONObject jsonObject = null;
		try {
			HttpClient client = HttpClients.createDefault();
			HttpResponse res = client.execute(getRequest);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				// String str = EntityUtils.toString(entity, "UTF-8");
				/*jsonObject = new JSONObject(new JSONTokener(
						new InputStreamReader(entity.getContent(), HTTP.UTF_8)));*/
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jsonObject;
	}
	
	
	/**
	 * 订单物流跟踪记录
	 * 
	 * @param siteId
	 * @param ordersn
	 * @return
	 */
	@RequestMapping(value = "/shiplist", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject orderShipList(@PathVariable("site") Long siteId,
			String ordersn,String shipcorp,String shipcode, Model model) {
		String key = "6959527b1a3a8782";// 授权密钥
		String urlString = "http://api.kuaidi100.com/api?id=" + key
				+ "&com=" + shipcorp + "&nu=" + shipcode + "&show=0&muti=1&order=desc";
		HttpGet getRequest = new HttpGet(urlString);
		JSONObject jsonObject = null;
		try {
			HttpClient client = HttpClients.createDefault();
			HttpResponse res = client.execute(getRequest);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				jsonObject = (JSONObject) JSON.toJSON(entity.getContent());
				/*jsonObject = new JSONObject(new JSONTokene(
						new InputStreamReader(entity.getContent(), HTTP.UTF_8)));*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}


}
