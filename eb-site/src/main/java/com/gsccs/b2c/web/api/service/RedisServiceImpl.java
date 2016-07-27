package com.gsccs.b2c.web.api.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.b2c.api.domain.Category;
import com.gsccs.b2c.api.domain.Product;
import com.gsccs.b2c.api.domain.Shop;
import com.gsccs.b2c.api.domain.StoreNav;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.BrandServiceI;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.ConfigServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.api.service.StoreyServiceI;
import com.gsccs.b2c.api.service.TradeServiceI;
import com.gsccs.b2c.api.service.TypeServiceI;

@Service
public class RedisServiceImpl implements RedisService {

	private static Logger logger = Logger.getLogger("RedisCache");
	@Autowired
	private RedisTemplate redisTemplate;
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
	@Autowired
	private BrandServiceI brandAPI;
	@Autowired
	private StoreyServiceI storeyAPI;
	@Autowired
	private BuyerServiceI buyerAPI;

	@Override
	public String getDomain(String siteId) {
		String domain = (String) redisTemplate.boundValueOps(
				CacheConst.SITE_DOMAIN_ + siteId).get();
		if (!StringUtils.isNotEmpty(domain)) {
			try {
				Shop shop = shopAPI.getShop(Long.valueOf(siteId));
				if (null != shop) {
					domain = shop.getDomain();
					redisTemplate.boundValueOps(
							CacheConst.SITE_DOMAIN_ + siteId).set(domain);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return domain;
	}

	@Override
	public String getRootPath() {
		String rootPath = (String) redisTemplate.boundValueOps(
				CacheConst.CONFIG_ROOT_PATH).get();
		if (!StringUtils.isNotEmpty(rootPath)) {
			rootPath = configAPI.getConfigVal(CacheConst.CONFIG_ROOT_PATH);
			if (StringUtils.isNotEmpty(rootPath)) {
				redisTemplate.boundValueOps(CacheConst.CONFIG_ROOT_PATH).set(
						rootPath);
			}
		}
		return rootPath;
	}


	public JSONArray getSiteCates(Long sid){
		JSONArray cateArray = null;
		try{
			cateArray = (JSONArray) redisTemplate.boundValueOps(
					CacheConst.SITE_CATE_LIST_ + sid).get();
			if (null != cateArray) {
				return cateArray;
			}else{
				cateArray = cateAPI.getSiteCates(sid);
				redisTemplate.boundValueOps(
						CacheConst.SITE_CATE_LIST_ + sid).set(cateArray);
			}
		}catch(Exception e){
			try {
				cateArray = cateAPI.getSiteCates(sid);
			} catch (ApiException e1) {
				e1.printStackTrace();
			}
		}
		return cateArray;
	}
	
	
	@Override
	public List<StoreNav> getStoreNavs(Long sid) {
		List<StoreNav> navs = redisTemplate.boundListOps(
				CacheConst.SITE_NAV_LIST_ + sid).range(0, -1);
		if (null == navs || navs.size() <= 0) {
			navs = shopAPI.getStoreNav(sid);
			if (null != navs && navs.size() > 0) {
				for (StoreNav nav : navs) {
					redisTemplate.boundListOps(CacheConst.SITE_NAV_LIST_ + sid)
							.leftPush(nav);
				}
			}
		}
		/*
		 * redisTemplate.boundListOps(CacheConst.SITE_NAV_LIST_ + sid).expireAt(
		 * new Date());
		 */
		return navs;
	}

	@Override
	public Shop getStore(Long sid) {
		Shop store = (Shop) redisTemplate.boundValueOps(
				CacheConst.STORE_OBJ_ + sid).get();
		if (null == store) {
			try {
				store = shopAPI.getShop(sid);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return store;
	}

	@Override
	public Category getCategory(Long sid, Long cid) {
		Category category = (Category) redisTemplate.boundValueOps(
				CacheConst.CATE_OBJ_ + cid).get();
		if (null == category) {
			category = cateAPI.getCate(cid);
			if (null != category) {
				redisTemplate.boundValueOps(CacheConst.CATE_OBJ_ + cid).set(
						category);
			}
		}
		return category;
	}

	

	@Override
	public Brand getBrand(Long sid, Long brandid) {
		Brand brand = null;
		try {
			brand = (Brand) redisTemplate.boundValueOps(
					CacheConst.BRAND_OBJ_ + brandid).get();
			if (null == brand) {
				brand = brandAPI.getBrand(brandid);
				if (null != brand) {
					redisTemplate
							.boundValueOps(CacheConst.BRAND_OBJ_ + brandid)
							.set(brand);
				}
			}
		} catch (Exception e) {
			brand = brandAPI.getBrand(brandid);
		}
		return brand;
	}

	@Override
	public Product getProduct(Long sid, Long pid) {
		// 获取产品信息
		Product product = null;
		try {
			product = (Product) redisTemplate.boundValueOps(
					CacheConst.PRODUCT_OBJ_ + sid + "_" + pid).get();
			if (product == null) {
				product = goodsAPI.getProduct(sid, pid);
				if (null != product) {
					redisTemplate.boundValueOps(
							CacheConst.PRODUCT_OBJ_ + sid + "_" + pid).set(
							product);
				}
			} else {
				logger.info("缓存" + CacheConst.PRODUCT_OBJ_ + sid + "_" + pid
						+ "命中");
			}
		} catch (Exception e) {
			try {
				product = goodsAPI.getProduct(sid, pid);
			} catch (ApiException e1) {
				logger.info("错误：请求产品数据 " + sid + "_" + pid + "错误");
			}
		}
		return product;
	}

	@Override
	public JSONObject getStoreyList(Long sid) {
		JSONObject obj = null;
		try {
			obj = (JSONObject) redisTemplate.boundValueOps(
					CacheConst.STOREY_ + sid).get();
			if (null == obj) {
				obj = storeyAPI.findStoreyList(sid);
				redisTemplate.boundValueOps(CacheConst.STOREY_ + sid).set(obj);
				// 过期时间
				// redisTemplate.boundValueOps(CacheConst.STOREY_ +
				// sid).expireAt(new Date());
			}
		} catch (Exception e) {
			obj = storeyAPI.findStoreyList(sid);
		}
		return obj;
	}

	@Override
	public List<Product> getTopProduct(Long sid) {
		List<Product> products = null;
		try {
			products = redisTemplate.boundListOps(
					CacheConst.PRODUCT_TOP_LIST_ + sid).range(0, -1);
			if (null == products || products.size() <= 0) {
				products = goodsAPI.getHotProducts(sid);
				if (null != products && products.size() > 0) {
					for (Product p : products) {
						redisTemplate.boundListOps(
								CacheConst.PRODUCT_TOP_LIST_ + sid).leftPush(p);
					}
				}
			}
		} catch (Exception e) {
			products = goodsAPI.getHotProducts(sid);
		}
		return products;
	}

	@Override
	public List<Product> getHotProduct(Long sid) {
		List<Product> products = null;
		try {
			products = redisTemplate.boundListOps(
					CacheConst.PRODUCT_HOT_LIST_ + sid).range(0, -1);
			if (null == products || products.size() <= 0) {
				products = goodsAPI.getHotProducts(sid);
				if (null != products && products.size() > 0) {
					for (Product p : products) {
						redisTemplate.boundListOps(
								CacheConst.PRODUCT_HOT_LIST_ + sid).leftPush(p);
					}
				}
			}
		} catch (Exception e) {
			products = goodsAPI.getHotProducts(sid);
		}
		return products;
	}

	@Override
	public User getBuyer(Long sid, String account) {
		User user = null;
		try {
			user = (User) redisTemplate.boundValueOps(
					CacheConst.BUYER_OBJ_ + sid + "_" + account).get();
			if (user == null) {
				user = buyerAPI.findByAccount(sid, account);
			}
		} catch (Exception e) {
			try {
				user = buyerAPI.findByAccount(sid, account);
			} catch (ApiException e1) {
				
			}
		}
		return user;
	}
}
