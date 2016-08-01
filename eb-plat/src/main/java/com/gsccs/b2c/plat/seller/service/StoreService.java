package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.eb.api.domain.site.Navigation;

/**
 * 
 * @创建人： x.j niu
 * @类名称：StoreService
 * @创建时间：2015年3月18日 下午4:11:22
 * 
 */
public interface StoreService {

	/**
	 * 添加
	 * 
	 * @param GoodsStore
	 * @return
	 */
	public Long insert(Store store);

	/**
	 * 更新
	 * 
	 * @param GoodsStore
	 */
	public void update(Store store);

	/**
	 * 删除
	 * 
	 * @param storeId
	 */
	public void del(Long storeId);

	/**
	 * 分页查询
	 */
	public List<Store> find(Store site, String order, int currPage,
			int pageSize);

	public List<Store> find(Store site, String order);

	public int count(Store site);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Store findById(Long id);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Store findByDomain(String domain, boolean cache);

	/**
	 * 根据sourcepath查询
	 * 
	 * @param id
	 * @return
	 */
	public Store findBySourcepath(String sourcepath);

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
	public List<Navigation> findStoreNavs(Long siteid);
	
	/**
	 * 平台商家统计
	 * @return
	 */
	public JSONObject storeStatist();

}
