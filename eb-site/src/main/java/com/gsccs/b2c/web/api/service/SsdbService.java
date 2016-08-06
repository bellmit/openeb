package com.gsccs.b2c.web.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.eb.api.domain.base.Area;
import com.gsccs.eb.api.domain.goods.GoodsParam;
import com.gsccs.eb.api.domain.goods.GoodsProp;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.rated.EvalGoods;
import com.gsccs.eb.api.domain.site.Collect;
import com.gsccs.eb.api.domain.site.Collect.CollectType;
import com.gsccs.eb.api.domain.trade.OrderItem;

/**
 * 门户缓存接口
 * @author x.d zhang
 *
 */
public interface SsdbService {
	public List<Area> getAreaByParId(Integer parid);
	
	/**
	 * 添加收藏
	 * @param key
	 * @param collect
	 */
	public void addCollect(Long sid, String accout,Collect collect);
	
	/**
	 * 收藏列表
	 * @param key
	 * @return
	 */
	public List<Collect> getCollects(Long sid, String accout,CollectType type);
	
	public String getGoodsDesc(Long sid,Long pid);
	public JSONArray getGoodsImgs(Long sid,Long pid);
	public List<GoodsProp> getGoodsProps(Long sid,Long pid);
	public List<GoodsParam> getGoodsParam(Long sid,Long pid);
	
	public List<Sku> getSKUList(Long sid,Long pid);
	
	public JSONObject getSkuSpecData(Long sid,Long pid);
	
	public void addCartItems(String key,OrderItem item);
	
	public List<OrderItem> cartItems(String key);
	
	public void addOrderItems(String key,OrderItem item);
	
	public List<OrderItem> OrderItems(String key);
	
	/**
	 * 删除购物车信息
	 * @param key
	 * @param itemid
	 */
	public void delCartItems(String key, String itemid);
	
	/**
	 * 添加商品评价
	 * @param key
	 * @param eval
	 */
	public void addGoodsEval(Long sid,Long pid,EvalGoods eval);
	
	public JSONObject getGoodsEvals(Long sid,Long pid,int page,int rows);
	
	public JSONObject getGoodsSales(Long sid,Long pid,int page,int rows);

}
