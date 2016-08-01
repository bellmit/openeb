package com.gsccs.b2c.plat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.b2c.api.service.ProductServiceI;
import com.gsccs.eb.api.domain.goods.Album;
import com.gsccs.eb.api.domain.rated.EvalGoods;
import com.gsccs.eb.api.domain.rated.EvalOrder;
import com.gsccs.eb.api.exception.ApiException;


public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo-server-consumer.xml","spring-redis.xml" });
		context.start();
		/*// 获取远程服务代理
		SellerServiceI sellerAPI = (SellerServiceI) context
				.getBean("sellerAPI");*/
		/*CateServiceI cateAPI = (CateServiceI) context
				.getBean("cateAPI");*/
		
		/*EvalServiceI evalAPI = (EvalServiceI) context
				.getBean("evalAPI");*/
		//testCategory(cateAPI);
		//testEval(evalAPI);
		RedisTemplate ssdbTemplate =  (RedisTemplate) context
				.getBean("ssdbTemplate");
		ProductServiceI goodsAPI = (ProductServiceI) context
				.getBean("goodsAPI");
		getProductImgs(ssdbTemplate,goodsAPI);
	}
	
	public static JSONArray getProductImgs(RedisTemplate ssdbTemplate, ProductServiceI goodsAPI) {
		Long sid = 1001l;
		Long pid = 251l;
		JSONArray jsonArray = (JSONArray) ssdbTemplate.boundValueOps(
				CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid).get();

		if (null != jsonArray && jsonArray.size() > 0) {
			System.out.println("cache is not null");
			return jsonArray;
		} else {
			jsonArray = new JSONArray();
			System.out.println("cache is null");
			try {
				List<Album> goodsImgs = goodsAPI.getProductByPid(sid, pid);
				if (null == goodsImgs || goodsImgs.size() <= 0) {
					for (int i = 0; i < 5; i++) {
						JSONObject json = new JSONObject();
						json.put("url", "http://cdn.titles.top/pic/product-" + i
								+ ".jpg");
						jsonArray.add(json);
					}
					System.out.println("db is null");
				} else {
					System.out.println("db is not null");
					for (Album img : goodsImgs) {
						JSONObject json = new JSONObject();
						json.put("url", img.getUrl());
						jsonArray.add(json);
					}
					ssdbTemplate.boundValueOps(
							CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid)
							.set(jsonArray);
				}
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return jsonArray;
	}
	
	public static void testCategory(CateServiceI cateAPI){
		try {
			JSONArray array = cateAPI.getStoreCates(1001l,13l);
			System.out.println(array.toString());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void testEval(EvalServiceI evalAPI){
		long siteid=1001l;
		try {
			List<EvalOrder> scoreList = new ArrayList<EvalOrder>();
			EvalOrder score1 = new EvalOrder();
			score1.setItemId(10l);
			score1.setProductid(250l);
			score1.setUserid(1000l);
			score1.setScore(5);
			scoreList.add(score1);
			
			EvalOrder score2 = new EvalOrder();
			score2.setItemId(11l);
			score2.setProductid(250l);
			score2.setUserid(1000l);
			score2.setScore(4);
			scoreList.add(score2);
			
			EvalGoods remark = new EvalGoods();
			remark.setUserid(1000l);
			remark.setProductid(250l);
			remark.setContent("测试");
			
			evalAPI.addEvalScores(siteid, scoreList, remark);;
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
