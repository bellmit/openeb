/**
 * 
 */
package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.eb.api.domain.goods.Brand;

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
	public List<Brand> find(Brand brands, String order, int currPage,
			int pageSize, boolean iscache);
	
	
	public List<Brand> findStoreBrand(Long sid,int currPage,
			int pageSize, boolean iscache);
	
	public int count(Brand brands);

	/**
	 * 查询
	 */
	public List<Brand> find(Brand brands, String order);

	/**
	 * 统计
	 * 
	 * @param info
	 * @return
	 */
	public int count(Brand brands, boolean iscache);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @param cache
	 * @return
	 */
	public Brand findById(Long id);

	/**
	 * 更新
	 * 
	 * @param Brand
	 */
	public void update(Brand brands);

	/**
	 * 添加
	 * 
	 * @param brands
	 * @return
	 */
	public Long add(Brand brands);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void del(Long id);

}
