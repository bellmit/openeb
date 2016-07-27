/**
 * 
 */
package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.BrandT;

/**
 * 品牌管理服务
 * 
 * @author x.d zhang
 * 
 */
public interface BrandService {

	/**
	 * 分页查询
	 */
	public List<BrandT> find(BrandT brands, String order, int currPage,
			int pageSize, boolean iscache);
	
	
	public List<BrandT> findStoreBrand(Long sid,int currPage,
			int pageSize, boolean iscache);
	
	public int count(BrandT brands);

	/**
	 * 查询
	 */
	public List<BrandT> find(BrandT brands, String order);

	/**
	 * 统计
	 * 
	 * @param info
	 * @return
	 */
	public int count(BrandT brands, boolean iscache);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @param cache
	 * @return
	 */
	public BrandT findById(Long id);

	/**
	 * 更新
	 * 
	 * @param BrandT
	 */
	public void update(BrandT brands);

	/**
	 * 添加
	 * 
	 * @param brands
	 * @return
	 */
	public Long add(BrandT brands);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void del(Long id);

}
