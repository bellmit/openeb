package com.gsccs.b2c.web.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.eb.api.domain.goods.Brand;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;


public interface RedisService {

	public String getDomain(String siteId);

	public String getRootPath();

	public JSONArray getSiteCates(Long sid);

	public Shop getStore(Long sid);
	
	public Account getBuyer(Long sid,String account);
	
	public JSONObject getStoreyList(Long sid);
	
	public Category getCategory(Long sid,Long cid);
	public List<Navigation> getStoreNavs(Long sid);
	public Brand getBrand(Long sid,Long brandid);
	public Product getProduct(Long sid,Long pid);
	
	
	public List<Product> getTopProduct(Long sid);
	public List<Product> getHotProduct(Long sid);
	

}
