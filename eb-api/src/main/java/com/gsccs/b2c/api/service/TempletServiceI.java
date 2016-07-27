package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.utils.FileTreeGrid;

/**
 * 模板API
 * @创建人：x.j  niu 
 * @类名称：TempletServiceI
 * @创建时间：2015年4月16日 下午3:25:18
 */
public interface TempletServiceI {

	/**
	 * 获得模板
	 * @param id
	 * @return
	 */
	public List<FileTreeGrid> getTemplet(long id);

	/**
	 * 根据店铺Id获取该站点使用的模板
	 * @param storeId
	 * @return
	 */
	public List<FileTreeGrid> getTempleByStoreId(Long storeId);
}
