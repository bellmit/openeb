package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.api.domain.ReturnOrder;
import com.gsccs.b2c.api.exception.ApiException;

/**
 * 退单（退货,退款）API
 * @创建人：x.j  niu 
 * @类名称：ReturnOrderServiceI
 * @创建时间：2015年5月14日 上午9:30:05
 */
public interface ReturnOrderServiceI {
	
	/**
	 * 查询退单信息
	 * @param sid
	 * @param roId
	 * @return
	 * @throws ApiException
	 */
	public ReturnOrder getReturnOrder(Long sid,Long roId) throws ApiException;

	/**
	 * 创建退货单（过时）
	 * @param sid
	 * @param order
	 * @return
	 * @throws ApiException
	 */
	public Long addReturnOrder(Long sid,Order order,ReturnOrder rOrder) throws ApiException;
	
	/**
	 * 修改退单
	 * @param sid
	 * @param roId
	 * @param returnGoodsStatus
	 * @param backMoneyStatus
	 * @return
	 * @throws ApiException
	 */
	public void editReturnOrder(Long sid, Long roId,String backMoneyStatus)throws ApiException;
	
	/**
	 * 创建退款单{根据订单状态创建，如果是已付款，已发货。流程是：申请退款（退款原因，退款金额）--卖家同意--填写退货信息--卖家确认收货，退款成功}
	 * 			如果是已付款，正在备货。流程是：申请退款（退款原因，退款金额）---卖家同意，退款成功
	 * @param sid
	 * @param roId
	 * @param backMoneyStatus
	 * @param backMoneyExplain
	 * @param backMoneyReason
	 * @param price
	 * @return
	 */
	public Long addRetrurnMoney(Long sid, Long roId,Order order,ReturnOrder returnOrder) throws ApiException;
	
	/**
	 * 卖家同意退款，提交退货地址
	 * @param sid
	 * @param roId
	 * @param backMoneyStatus
	 * @param returnGoodsAddress
	 * @throws ApiException
	 */
	public void sellerAuditBackMoney(Long sid,Long roId, String backMoneyStatus,String returnGoodsAddress,String authreturngoodsexplain) throws ApiException;
	
	/**
	 * 买家填写退货信息，物流单号，物流信息等
	 * @param sid
	 * @param roId
	 * @param apirOrder
	 * @throws ApiException
	 */
	public void buyerWriteBackGoods(Long sid, Long roId, ReturnOrder apirOrder) throws ApiException;
	
	/**
	 * 如果是退货信息，卖家确认收到货物，退款。如果没有退货。审核通过退款成功
	 * @param sid
	 * @param roId
	 * @param backMomeyStatus
	 * @return
	 * @throws ApiException
	 */
	public Long sellerAuditBackGoods(Long sid, Long roId,String backMomeyStatus) throws ApiException;
	
	/**
	 * 查询卖家订单信息
	 * @param sid
	 * @param rOrder
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<ReturnOrder> getrOrderList(Long sid, ReturnOrder rOrder ,String order,int currPage,int pageSize) throws ApiException; 
	
	/**
	 * 查询买家订单信息
	 * @param sid
	 * @param rOrder
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<ReturnOrder> getBuyerROrderList(Long sid, ReturnOrder rOrder ,String order,int currPage,int pageSize) throws ApiException; 
	
	/**
	 * 根据条件查询条数
	 * @param sid
	 * @param apirOrder
	 * @return
	 * @throws ApiException
	 */
	public int getrOrderCount(Long sid, ReturnOrder apirOrder) throws ApiException;
}
