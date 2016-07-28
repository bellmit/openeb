package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.CollectStatist;
import com.gsccs.eb.api.domain.site.Collect;

/**
 * 收藏业务接口
 * @author x.d zhang
 *
 */
public interface CollectService {
	
	/**
	 * 添加收藏
	 * @param evalTypeT
	 * @return
	 */
	public void addCollect(Collect collect);
	
	/**
	 * 取消收藏
	 * @param id
	 * @return
	 */
	public void delCollect(String id);
	
	/**
	 * 根据条件查询收藏列表
	 */
	public List<Collect> getCollectProducts(Collect collect, int page,
			int pagesize);
	
	public List<Collect> getCollectBrands(Collect collect, int page,
			int pagesize);
	
	public List<CollectStatist> collectStatist(Long siteid,Long buyerid);

}
