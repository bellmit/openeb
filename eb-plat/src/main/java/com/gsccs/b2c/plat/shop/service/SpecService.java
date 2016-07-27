package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.Specific;

public interface SpecService {
	
	/**
	 * 新增规格
	 * @param spec
	 * @return
	 */
	public Long addSpecific(Specific spec);
	
	/**
	 * 更新规格列表
	 * @param spec
	 */
	public void updateSpecific(Specific spec);
	
	/**
	 * 根据规格ID获取规格
	 * @param specId
	 * @return
	 */
	public Specific getSpec(Long specId);
	
	/**
	 * 查询规格列表
	 * @param spec
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<Specific> getSpecList(Specific spec,String order,int currPage,int pageSize);
	
	
	public int count(Specific spec);

}
