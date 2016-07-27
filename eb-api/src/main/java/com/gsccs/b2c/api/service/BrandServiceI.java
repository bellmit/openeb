package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 品牌API
 * 
 * @author x.d zhang
 * 
 */
public interface BrandServiceI {
	/**
	 * 获取品牌
	 * 
	 * @param id
	 * @return
	 */
	public Brand getBrand(Long id);

	/**
	 * 获取商城品牌列表
	 * 
	 * @param shopid
	 * @return
	 */
	public List<Brand> getBrands(Long sid, int currPage, int pageSize)
			throws ApiException;
	
	/**
	 * 添加
	 * @param brand
	 */
	public void addBrand(Brand brand);
	
	/**
	 * 修改
	 * @param brand
	 */
	public void updateBrand(Brand brand);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delBrand(Long id);

}
