package com.gsccs.b2c.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.site.model.StoreyList;
import com.gsccs.b2c.plat.site.service.FloorService;
import com.gsccs.eb.api.domain.site.Banner;
import com.gsccs.eb.api.domain.site.Floor;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 楼层管理API实现类
 * 
 * @author x.d zhang
 * 
 */
public class FloorServiceAPI implements StoreyServiceI {

	@Autowired
	private FloorService storeyService;

	/**
	 * 添加楼层
	 * 
	 * @throws ApiException
	 */
	@Override
	public void addStorey(Long sid, JSONObject storey) throws ApiException {
		if (null == sid || null == storey) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		String id = UUID.randomUUID().toString();
		JSONArray items = storey.getJSONArray("items");
		StoreyList storeyList = new StoreyList();
		storeyList.setTitle(storey.getString("title"));
		storeyList.setLink(storey.getString("link"));
		storeyList.setMainimg(storey.getString("mainimg"));
		storeyList.setMainlink(storey.getString("mainlink"));
		storeyList.setOrdernum(null == storey.getInteger("ordernum") ? 0
				: storey.getInteger("ordernum"));
		storeyList.setId(id);
		storeyList.setSiteid(sid);

		List<Floor> storeyItems = null;
		if (null != items && items.size() > 0) {
			storeyItems = new ArrayList<Floor>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject itemObject = (JSONObject) items.get(i);
				Floor storeyItem = new Floor();
				storeyItem.setTitle(itemObject.getString("title"));
				storeyItem.setLink(itemObject.getString("link"));
				storeyItem.setImgurl(itemObject.getString("imgurl"));
				storeyItem.setType(itemObject.getString("type"));
				storeyItem.setOrdernum(i);
				storeyItem.setId(UUID.randomUUID().toString());
				storeyItem.setStoreyid(id);
				storeyItem.setSiteid(sid);
				storeyItems.add(storeyItem);
			}
		}
		storeyService.addStorey(sid, storeyList, storeyItems);
	}

	@Override
	public JSONObject findStoreyList(Long sid) {
		JSONObject json = new JSONObject();
		List<StoreyList> storeylist = storeyService.findStoreyList(sid);
		List<Floor> storeyitems = storeyService.findStoreyItems(sid);
		List<Banner> storeyBanners = storeyService.findStoreyBanners(sid);
		if (null != storeylist && storeylist.size() > 0) {
			JSONArray storeys = new JSONArray();
			for (StoreyList storey : storeylist) {
				JSONObject jsonObject = (JSONObject) JSON.toJSON(storey);
				JSONArray itemsJson = new JSONArray();
				for (Floor item : storeyitems) {
					if (item.getStoreyid().equals(storey.getId())) {
						itemsJson.add(JSON.toJSON(item));
					}
				}
				jsonObject.put("items", itemsJson);
				storeys.add(jsonObject);
			}
			json.put("total", storeylist.size());
			json.put("storeys", storeys);
		}

		if (null != storeyBanners && storeyBanners.size() > 0) {
			json.put("banners", JSON.toJSON(storeyBanners));
		}

		return json;
	}

	@Override
	public void delStorey(Long sid, String storeyid) throws ApiException {
		if (null == sid || null == storeyid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		storeyService.deleteStorey(sid, storeyid);
	}

	@Override
	public void addBanner(Long sid, JSONArray banners) throws ApiException {
		if (null == sid || null == banners || banners.size() <= 0) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<Banner> list = new ArrayList<Banner>();
		for (int i = 0; i < banners.size(); i++) {
			JSONObject jsonObject = (JSONObject) banners.get(i);
			Banner banner = JSON.toJavaObject(jsonObject,
					Banner.class);
			banner.setId(UUID.randomUUID().toString());
			banner.setSiteid(sid);
			banner.setOrdernum(i);
			list.add(banner);
		}
		storeyService.addBanners(sid, list);
	}
}
