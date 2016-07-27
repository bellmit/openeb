package com.gsccs.b2c.plat.order.service;

import java.util.List;

import com.gsccs.b2c.plat.order.model.OrderStatist;
import com.gsccs.b2c.plat.order.model.OrderTrace;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.OrderItem;

/**
 * 订单服务接口
 * 
 */
public interface OrderService {

	/**
	 * 获取订单分页列表
	 * 
	 * @param orders
	 * @param sid
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<Order> find(Order orders, Long sid, String order, int currPage,
			int pageSize);

	/**
	 * 添加订单
	 * 
	 * @param sid
	 * @param order
	 * @return
	 */
	public String insert(Long sid, Order order, List<OrderItem> items);

	/**
	 * 添加订单处理记录
	 * 
	 * @param sid
	 * @param trace
	 * @return
	 */
	public void addTrace(Long sid, OrderTrace trace);

	/**
	 * 修改订单
	 * 
	 * @param templet
	 */
	public void update(Order order, Long sid);

	/**
	 * 根据Id查询订单
	 * 
	 * @param id
	 * @return
	 */
	public Order findById(Long sid, Long id);

	/**
	 * 根据序列号查询订单
	 * 
	 * @param ordersn
	 * @return
	 */
	public Order findByOrdersn(Long sid, String ordersn);

	/**
	 * 删除订单
	 * 
	 * @param sid
	 * @param ordersn
	 */
	public void deleteOrder(Long sid, String ordersn);

	/**
	 * 查询总数
	 * 
	 * @param order
	 * @param sid
	 * @return
	 */
	public int count(Long sid, Order order);

	/**
	 * 会员订单状态统计
	 * 
	 * @param sid
	 * @param buyerid
	 * @return
	 */
	public List<OrderStatist> orderBuyerStatist(Long sid, Long buyerid);

	/**
	 * 商家订单状态统计
	 * 
	 * @param sid
	 * @return
	 */
	public List<OrderStatist> orderStoreStatist(Long sid);

	/**
	 * 查询订单详情
	 * 
	 * @param sid
	 * @param oId
	 * @return
	 */
	public List<OrderItem> findOItems(Long sid, Long oId);

	/**
	 * 查询未评价商品列表
	 * 
	 * @param sid
	 * @return
	 */
	public List<OrderItem> findIsNotEvalItems(Long sid, Long uid, int page,
			int pagesize);

	/**
	 * 查询产品销售记录
	 * 
	 * @param sid
	 * @param oId
	 * @return
	 */
	public List<OrderItem> findProductSaleItems(Long sid, Long pid);

	/**
	 * 统计产品销售记录
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public int countProductSaleItems(Long sid, Long pid);

	/**
	 * 查询订单记录
	 * 
	 * @param sid
	 * @param orderid
	 * @return
	 */
	public List<OrderTrace> findOrderTraces(Long sid, String orderid);

}
