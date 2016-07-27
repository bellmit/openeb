package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Collect;
import com.gsccs.b2c.api.domain.Collect.CollectType;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.shop.model.CollectStatist;
import com.gsccs.b2c.plat.shop.model.CollectT;
import com.gsccs.b2c.plat.shop.service.CollectService;

public class CollectServiceAPI implements CollectServiceI {

	@Autowired
	private CollectService collectService;

	@Override
	public void addCollect(Collect collect) throws ApiException {
		if (null == collect) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			CollectT collectT = new CollectT();
			BeanUtils.copyProperties(collectT, collect);
			collectT.setColltype(collect.getType().name());
			collectService.addCollect(collectT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONArray getCollects(Collect collect, int page, int size)
			throws ApiException {
		if (null == collect) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<CollectT> collectTs = null;
		if (null != collect.getType()) {
			System.out.println("collectType:"+collect.getType());
			if (collect.getType().name().equals(CollectType.PRODUCT.name())) {
				collectTs = collectService.getCollectProducts(null, page, size);
			}
			if (collect.getType().name().equals(CollectType.BRAND.name())) {
				collectTs = collectService.getCollectBrands(null, page, size);
			}
		}else{
			System.out.println("else collectType:"+collect.getType());
			collectTs = collectService.getCollectProducts(null, page, size);
		}

		if (null != collectTs && collectTs.size() > 0) {
			JSONArray array = new JSONArray();
			for (CollectT collectT : collectTs) {
				JSONObject object = new JSONObject();
				object.put("id", collectT.getId());
				object.put("targetid", collectT.getTargetid());
				object.put("type", collectT.getColltype());
				object.put("remark", collectT.getRemark());
				object.put("picurl", null==collectT.getPicurl()?"#":collectT.getPicurl());
				object.put("addtime", collectT.getAddtime());
				object.put("siteid", collectT.getSiteid());
				
				array.add(object);
			}
			return array;
		}
		return null;
	}

	
	@Override
	public JSONObject collectStatist(Long siteid, Long buyerid)
			throws ApiException {
		JSONObject json = new JSONObject();
		if (null == siteid || null == buyerid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<CollectStatist> statists = collectService.collectStatist(siteid,
				buyerid);
		if (null != statists && statists.size() > 0) {
			for (CollectStatist statist : statists) {
				json.put(statist.getColltype(), statist.getTotalnum());
			}
		}
		return json;
	}

}
