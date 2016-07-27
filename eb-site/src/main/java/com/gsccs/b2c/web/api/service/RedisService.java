package com.gsccs.b2c.web.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.b2c.api.domain.Category;
import com.gsccs.b2c.api.domain.Product;
import com.gsccs.b2c.api.domain.Shop;
import com.gsccs.b2c.api.domain.StoreNav;
import com.gsccs.b2c.api.domain.User;


public interface RedisService {

	public String getDomain(String siteId);

	public String getRootPath();

	public JSONArray getSiteCates(Long sid);

	public Shop getStore(Long sid);
	
	public User getBuyer(Long sid,String account);
	
	public JSONObject getStoreyList(Long sid);
	
	public Category getCategory(Long sid,Long cid);
	public List<StoreNav> getStoreNavs(Long sid);
	public Brand getBrand(Long sid,Long brandid);
	public Product getProduct(Long sid,Long pid);
	
	
	public List<Product> getTopProduct(Long sid);
	public List<Product> getHotProduct(Long sid);
	

}
