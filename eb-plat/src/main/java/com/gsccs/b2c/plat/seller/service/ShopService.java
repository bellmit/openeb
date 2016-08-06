package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.eb.api.domain.seller.Grade;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;

/**
 * 
 * @创建人： x.j niu
 * @类名称：StoreService
 * @创建时间：2015年3月18日 下午4:11:22
 * 
 */
public interface ShopService {

	/**
	 * 添加
	 * 
	 * @param GoodsStore
	 * @return
	 */
	public Long saveShop(Shop store);

	/**
	 * 删除
	 * 
	 * @param storeId
	 */
	public void del(Long storeId);

	/**
	 * 分页查询
	 */
	public List<Shop> find(Shop site, String order, int currPage,
			int pageSize);

	public List<Shop> find(Shop site, String order);

	public int count(Shop site);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Shop findById(Long id);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Shop findByDomain(String domain, boolean cache);

	/**
	 * 根据sourcepath查询
	 * 
	 * @param id
	 * @return
	 */
	public Shop findBySourcepath(String sourcepath);

	/**
	 * 查询是否有此目录
	 * 
	 * @param path
	 * @return
	 */
	public boolean haveSourcePath(String path);

	/**
	 * 店铺导航
	 * 
	 * @param siteid
	 * @return
	 */
	public List<Navigation> findShopNavs(Long shopid);
	
	
	/**
	 * 保存店铺等级
	 * 
	 * @param GoodsGrade
	 * @return
	 */
	public Long saveGrade(Grade grade);
	
	/**
	 * 店铺等级
	 * @return
	 */
	public List<Grade> findGradeList();
	
	
	public Grade getGrade(Integer id);
	
	/**
	 * 平台商家统计
	 * @return
	 */
	public JSONObject storeStatist();

}
