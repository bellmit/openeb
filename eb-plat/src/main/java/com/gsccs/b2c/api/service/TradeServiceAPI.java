package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.order.service.OrderService;
import com.gsccs.eb.api.domain.trade.OrderItem;

public class TradeServiceAPI implements TradeServiceI {
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public JSONObject getGoodsSaleList_m(Long siteid, Long pid,int page,int rows) {
		JSONObject json = new JSONObject();
		List<OrderItem> items = orderService.findGoodsSaleItems(siteid, pid);
		int total = orderService.countGoodsSaleItems(siteid, pid);
		JSONArray array = new JSONArray();
		if (null != items && items.size()>0){
			for(OrderItem t:items){
				JSONObject object = new JSONObject();
				object.put("id", t.getId());
				object.put("buyerid", t.getBuyer());
				object.put("addtime", t.getAdddatestr());
				object.put("totalnum", t.getNum());
				object.put("totalfee", t.getPrice());
				array.add(object);
			}
			
		}
		json.put("items", array);
		json.put("total", total);
		return json;
	}

	
}
