package com.gsccs.b2c.store.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.CacheConst;

@Service
public class SsdbServiceImpl implements SsdbService{

	@Autowired
	private RedisTemplate ssdbTemplate;
	
	private static Logger logger = Logger.getLogger("SSDBCache");
	@Override
	public JSONArray getProductImgs(Long sid, Long pid) {
		
		/*String key = "PRODUCT_IMG_LIST_1001_209";
		JSONArray jsonArray = new JSONArray();
		
		String a  = ssdbTemplate.boundListOps(key).toString();
		
		System.out.println("a=="+a);
		
		
		String[] skuValue = a.split(",");*/
		JSONArray jsonArray = (JSONArray)ssdbTemplate.boundValueOps(CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid).get();
		System.out.println("k======"+jsonArray.size());
		//System.out.println(jsonArray.size());
		return jsonArray;
	}

	@Override
	public String getProductDesc(Long sid, Long pid) {
		// 获取产品描述信息   CacheConst.PRODUCT_DESC_+ siteId + "_" + productId
		String desc = (String) ssdbTemplate.boundValueOps(
				CacheConst.PRODUCT_DESC_ + sid + "_" + pid).get();
		
		if (StringUtils.isNotEmpty(desc)) {
			logger.debug("缓存" + CacheConst.PRODUCT_OBJ_ + sid + "_" + pid
					+ "命中");
		}
		return desc;
	}

}
