package com.gsccs.b2c.plat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.eb.api.domain.rated.EvalGoods;
import com.gsccs.eb.api.domain.rated.EvalOrder;
import com.gsccs.eb.api.exception.ApiException;


public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo-server-consumer.xml","spring-redis.xml" });
		context.start();
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
