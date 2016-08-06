package com.gsccs.b2c.web.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.goods.Brand;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Goods;
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
	public Goods getGoods(Long sid,Long pid);
	
	
	public List<Goods> getTopGoods(Long sid);
	public List<Goods> getHotGoods(Long sid);
	

}
