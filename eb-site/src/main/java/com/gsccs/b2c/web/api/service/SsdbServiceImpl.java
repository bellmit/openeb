package com.gsccs.b2c.web.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.api.service.TradeServiceI;
import com.gsccs.b2c.api.service.TypeServiceI;
import com.gsccs.eb.api.domain.base.Area;
import com.gsccs.eb.api.domain.goods.Album;
import com.gsccs.eb.api.domain.goods.GoodsParam;
import com.gsccs.eb.api.domain.goods.GoodsProp;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.rated.EvalGoods;
import com.gsccs.eb.api.domain.site.Collect;
import com.gsccs.eb.api.domain.site.Collect.CollectType;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.exception.ApiException;

@Service
public class SsdbServiceImpl implements SsdbService {

	private static Logger logger = Logger.getLogger("SSDBCache");
	@Autowired
	private RedisTemplate ssdbTemplate;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private ShopServiceI shopAPI;
	@Autowired
	private GoodsServiceI goodsAPI;
	@Autowired
	private CateServiceI cateAPI;
	@Autowired
	private TradeServiceI tradeAPI;
	@Autowired
	private EvalServiceI evalAPI;
	@Autowired
	private TypeServiceI typeAPI;

	public void addCartItems(String key, OrderItem item) {
		ssdbTemplate.boundListOps(key).leftPush(item);
	}

	@Override
	public List<OrderItem> cartItems(String key) {
		List<OrderItem> results = new ArrayList<OrderItem>();
		List<OrderItem> list = ssdbTemplate.boundListOps(key).range(0, -1);
		if (null != list && list.size() > 0) {
			Map<String, Integer> nummap = new HashMap<String, Integer>();
			for (OrderItem c : list) {
				if (null == nummap.get(c.getId())) {
					nummap.put(c.getId(), c.getNum());
					results.add(c);
				} else {
					nummap.put(c.getId().toString(),
							c.getNum() + nummap.get(c.getId()));
				}
			}

			if (results.size() > 0) {
				for (OrderItem c : results) {
					c.setNum(nummap.get(c.getId()) == null ? c.getNum()
							: nummap.get(c.getId()));
				}
			}
		}
		return results;
	}

	@Override
	public void addOrderItems(String key, OrderItem item) {
		boolean insert = true;
		List<OrderItem> list = ssdbTemplate.boundListOps(key).range(0, -1);
		if (null != list && list.size() > 0) {
			int i = 0;
			for (OrderItem item_ : list) { // 如果存在，则置换
				if (item_.getId().equals(item.getId())) {
					insert = false;
					item_.setNum(item.getNum() + 1);
					ssdbTemplate.boundListOps(key).set(i, item_);
					break;
				}
			}
			i++;
		}
		if (insert) {
			ssdbTemplate.boundListOps(key).leftPush(item);
		}
	}

	@Override
	public List<OrderItem> OrderItems(String key) {
		List<OrderItem> list = ssdbTemplate.boundListOps(key).range(0, -1);
		return list;
	}

	public List<Sku> getSKUList(Long sid, Long pid) {
		// 获取产品SKU信息
		List<Sku> skus = ssdbTemplate.boundListOps(
				CacheConst.SKU_LIST_ + sid + "_" + pid).range(0, -1);
		if (null == skus || skus.size() <= 0) {
			try {
				skus = goodsAPI.getSkuList(sid, pid, 1, Integer.MAX_VALUE);
				if (null != skus && skus.size() > 0) {
					for (Sku sku : skus) {
						ssdbTemplate.boundListOps(
								CacheConst.SKU_LIST_ + sid + "_" + pid)
								.leftPush(sku);
					}
				}
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return skus;
	}

	@Override
	public JSONObject getSkuSpecData(Long sid, Long pid) {
		List<Sku> skus = null;
		JSONObject json = new JSONObject();
		try {
			// 获取产品规格数据
			String specJson = (String) ssdbTemplate.boundValueOps(
					CacheConst.PRODUCT_SPEC_JSON_ + sid + "_" + pid).get();
			// 获取产品SKU数据
			String skuJson = (String) ssdbTemplate.boundValueOps(
					CacheConst.PRODUCT_SKU_JSON_ + sid + "_" + pid).get();
			if (StringUtils.isNotEmpty(specJson)
					&& StringUtils.isNotEmpty(skuJson)) {
				logger.debug("缓存" + CacheConst.PRODUCT_SKU_JSON_ + sid + "_"
						+ pid + "命中");
				json.put("PRODUCT_SPEC_JSON_", specJson);
				json.put("PRODUCT_SKU_JSON_", skuJson);
				return json;
			}
		} catch (Exception e) {
			// 从数据库获取数据
			skus = getSKUList(sid, pid);
		}

		if (null == skus || skus.size() <= 0) {
			return null;
		}

		// SKU MAP
		Map<String, Map<String, String>> skuMaps = new HashMap<String, Map<String, String>>();
		// SPEC LIST
		List<Map<String, Object>> specList = new ArrayList<Map<String, Object>>();

		Map<String, String> specMapTemp_ = new HashMap<String, String>();

		Map<String, Map<String, String>> valsMap = new LinkedHashMap<String, Map<String, String>>();
		for (Sku sku : skus) {
			if (sku == null || StringUtils.isEmpty(sku.getSpecids().trim())) {
				break;
			}
			// 规格ID
			String[] specIds = sku.getSpecids().split(";");
			// 规格标题
			String[] specStr = sku.getSpecstr().split(";");
			if (null == specIds || specIds.length <= 0 || null == specStr
					|| specStr.length <= 0) {
				break;
			}

			Map<String, String> skuMap = new HashMap<String, String>();

			skuMap.put("skuId", sku.getId().toString());
			skuMap.put("price", sku.getPrice().toString());
			skuMap.put("mkprice", sku.getMkprice().toString());
			skuMap.put("storenum", sku.getStorenum().toString());
			skuMaps.put(sku.getSpecids(), skuMap);

			// String s : specIds
			for (int i = 0; i < specIds.length; i++) {
				String[] spedId = specIds[i].split(":");
				String[] spectitle = specStr[i].split(":");
				Map<String, String> temp_ = null;
				if (valsMap.get(spedId[0]) != null) {
					temp_ = valsMap.get(spedId[0]);
				} else {
					temp_ = new HashMap<String, String>();
				}

				if (null != spectitle && null != spectitle[1]) {
					// 规格值ID 规格值名称
					temp_.put(spedId[1], spectitle[1]);
					valsMap.put(spedId[0], temp_);
					specMapTemp_.put(spedId[0], spectitle[0]);
				}
			}
		}

		if (null != valsMap) {
			Iterator<String> its = valsMap.keySet().iterator();
			while (its.hasNext()) {
				String key = its.next();
				Map temp_ = valsMap.get(key);
				Map<String, Object> specmap = new HashMap<String, Object>();
				specmap.put("id", key);
				specmap.put("title", specMapTemp_.get(key));

				if (null != temp_) {
					Iterator<String> its_ = temp_.keySet().iterator();
					List<Map<String, String>> vallist = (List<Map<String, String>>) specmap
							.get("vals");
					if (null == vallist) {
						vallist = new ArrayList<Map<String, String>>();
					}
					while (its_.hasNext()) {
						String id_ = its_.next();
						String title_ = (String) temp_.get(id_);
						Map<String, String> specmap_ = new HashMap<String, String>();
						specmap_.put("id", id_);
						specmap_.put("title", title_);
						vallist.add(specmap_);
					}
					specmap.put("vals", vallist);
				}
				specList.add(specmap);
			}
		}

		if (null != specList && null != skuMaps && specList.size() > 0
				&& !skuMaps.isEmpty()) {
			json.put("PRODUCT_SPEC_JSON_", JSON.toJSONString(specList));
			json.put("PRODUCT_SKU_JSON_", JSON.toJSONString(skuMaps));

			// 缓存产品规格数据
			ssdbTemplate.boundValueOps(
					CacheConst.PRODUCT_SPEC_JSON_ + sid + "_" + pid).set(
					JSON.toJSONString(specList));
			;
			ssdbTemplate.boundValueOps(
					CacheConst.PRODUCT_SKU_JSON_ + sid + "_" + pid).set(
					JSON.toJSONString(skuMaps));
			;

		}
		return json;
	}

	@Override
	public String getGoodsDesc(Long sid, Long pid) {
		// 获取产品描述信息 CacheConst.PRODUCT_DESC_+ siteId + "_" + productId
		String desc = (String) ssdbTemplate.boundValueOps(
				CacheConst.PRODUCT_DESC_ + sid + "_" + pid).get();

		if (StringUtils.isNotEmpty(desc)) {
			logger.debug("缓存" + CacheConst.PRODUCT_OBJ_ + sid + "_" + pid
					+ "命中");
		}
		return desc;
	}

	@Override
	public JSONArray getGoodsImgs(Long sid, Long pid) {

		JSONArray jsonArray = (JSONArray) ssdbTemplate.boundValueOps(
				CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid).get();

		if (null != jsonArray && jsonArray.size() > 0) {
			return jsonArray;
		} else {
			jsonArray = new JSONArray();
			try {
				List<Album> goodsImgs = goodsAPI.getGoodsByPid(sid, pid);
				if (null == goodsImgs || goodsImgs.size() <= 0) {
					for (int i = 0; i < 5; i++) {
						JSONObject json = new JSONObject();
						json.put("url", "http://cdn.titles.top/pic/product-"
								+ i + ".jpg");
						jsonArray.add(json);
					}
				} else {
					for (Album img : goodsImgs) {
						JSONObject json = new JSONObject();
						json.put("url", img.getUrl());
						jsonArray.add(json);
					}
					ssdbTemplate.boundValueOps(
							CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid)
							.set(jsonArray);
					ssdbTemplate.boundValueOps(
							CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid)
							.expireAt(new Date());
				}
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return jsonArray;
	}

	@Override
	public void addCollect(Long sid, String accout, Collect collect) {
		String key = CacheConst.COLLECT_LIST_ + collect.getType().getType()
				+ "_" + sid + "_" + accout;
		ssdbTemplate.boundListOps(key).leftPush(collect);
	}

	@Override
	public List<Collect> getCollects(Long sid, String accout, CollectType type) {
		String key = CacheConst.COLLECT_LIST_ + type.getType() + "_" + sid
				+ "_" + accout;
		List<Collect> collects = ssdbTemplate.boundListOps(key).range(0, -1);
		if (null != collects && collects.size() > 0) {
			return collects;
		} else {
			return null;
		}
	}

	@Override
	public void addGoodsEval(Long sid, Long pid, EvalGoods eval) {
		ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_EVAL_LIST_ + sid + "_" + pid).leftPush(eval);
	}

	@Override
	public JSONObject getGoodsEvals(Long sid, Long pid, int page, int rows) {
		JSONObject json = new JSONObject();
		int start = page - 1 * rows;
		List<EvalGoods> evals = ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_EVAL_LIST_ + sid + "_" + pid).range(start,
				rows);
		long total = ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_EVAL_LIST_ + sid + "_" + pid).size();
		json.put("total", total);

		if (null != evals && evals.size() > 0) {
			JSONArray array = new JSONArray();
			for (EvalGoods evalDetail : evals) {
				JSONObject evJsonObject = new JSONObject();
				evJsonObject.put("buyer", evalDetail.getUsername());
				evJsonObject.put("addtime", evalDetail.getShowdatestr());
				evJsonObject.put("score", evalDetail.getScore());
				evJsonObject.put("content", evalDetail.getContent());
				array.add(evJsonObject);
			}
			json.put("items", array);
		}
		return json;
	}

	public void addGoodsProp(Long sid, Long pid, GoodsProp prop) {
		ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_PROP_LIST_ + sid + "_" + pid).leftPush(prop);
	}

	@Override
	public List<GoodsProp> getGoodsProps(Long sid, Long pid) {
		List<GoodsProp> props = ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_PROP_LIST_ + sid + "_" + pid).range(0, -1);
		return props;
	}

	@Override
	public List<GoodsParam> getGoodsParam(Long sid, Long pid) {
		List<GoodsParam> params = ssdbTemplate.boundListOps(
				CacheConst.PRODUCT_PARAM_LIST_ + sid + "_" + pid).range(0, -1);
		return params;
	}

	@Override
	public List<Area> getAreaByParId(Integer parid) {
		List<Area> arealist = ssdbTemplate.boundListOps(
				CacheConst.AREA_LIST_ + parid).range(0, -1);
		return arealist;
	}

	@Override
	public JSONObject getGoodsSales(Long sid, Long pid, int page, int rows) {
		JSONObject json = new JSONObject();
		int start = page - 1 * rows;
		/*
		 * List<OrderItem> salelist = ssdbTemplate.boundListOps(
		 * CacheConst.PRODUCT_SALE_LIST_ + sid + "_" + pid).range(start, rows);
		 * if (null == salelist || salelist.size() <= 0) { json =
		 * tradeAPI.getGoodsSaleList_m(sid, pid, page, rows); }
		 */
		json = tradeAPI.getGoodsSaleList_m(sid, pid, page, rows);
		return json;
	}

	@Override
	public void delCartItems(String key, String itemid) {
		List<OrderItem> list = ssdbTemplate.boundListOps(key).range(0, -1);
		// 删除
		for (int i = 0; i < list.size(); i++) {
			ssdbTemplate.boundListOps(key).leftPop();
		}
		if (null != list && list.size() > 0) {
			for (OrderItem orderItem : list) {
				if (!orderItem.getId().equals(itemid)) {
					this.addCartItems(key, orderItem);
				}
			}
		}

	}

}
