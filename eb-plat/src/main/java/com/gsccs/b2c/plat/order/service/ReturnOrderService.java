package com.gsccs.b2c.plat.order.service;

import java.util.List;

import com.gsccs.b2c.plat.order.model.ReturnOrderT;
/**
 * 退货退款服务接口
 * @创建人：x.j  niu 
 * @类名称：ReturnOrder
 * @创建时间：2015年5月8日 上午9:26:18
 */

public interface ReturnOrderService {

	/**
	 * 分页查询退货退单管理
	 * @param returnOrder
	 * @param sid
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<ReturnOrderT> find(ReturnOrderT returnOrder, Long sid, String order, int currPage,
			int pageSize);

	/**
	 * 创建退货退款
	 * @param sid
	 * @param returnOrder
	 * @return
	 */
	public Long insert(Long sid, ReturnOrderT returnOrder);
	
	/**
	 * 修改退货退款单
	 * @param sid
	 * @param returnOrder
	 */
	public void update(Long sid, ReturnOrderT returnOrder);
	
	/**
	 * 根据退单Id和站点id查询
	 * @param sid
	 * @param roId
	 * @return
	 */
	public ReturnOrderT findById(Long sid, Long roId);
	
	/**
	 * 根据条件查询条数
	 * @param sid
	 * @param returnOrder
	 * @return
	 */
	public int count(Long sid,ReturnOrderT returnOrder);
}
