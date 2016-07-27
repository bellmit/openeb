package com.gsccs.b2c.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.order.model.ReturnOrderT;
import com.gsccs.b2c.plat.order.service.ReturnOrderService;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.ReturnOrder;
import com.gsccs.eb.api.exception.ApiException;

public class ReturnOrderServiceAPI implements ReturnOrderServiceI {

	@Autowired
	private ReturnOrderService returnOrderService;

	@Override
	public Long addReturnOrder(Long sid, Order order, ReturnOrder apiROrder)
			throws ApiException {

		if (null == sid || null == order) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		ReturnOrderT platROrder = new ReturnOrderT();
		// 订单号
		platROrder.setOrdernum(order.getId().toString());
		Date date = new Date();
		// 退货创建时间
		platROrder.setCreatereturngoodstime(date);
		// 退货原因
		platROrder.setReturngoodsreason(apiROrder.getReturngoodsreason());

		platROrder.setReturngoodsstatus(apiROrder.getReturngoodsstatus());
		// 产品Id
		platROrder.setProductid(apiROrder.getProductid());

		returnOrderService.insert(sid, platROrder);

		return sid;
	}

	@Override
	public void editReturnOrder(Long sid, Long roId, String backMoneyStatus)
			throws ApiException {
		if (null == sid || null == roId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ReturnOrderT returnOrder = returnOrderService.findById(sid, roId);
		if (null == returnOrder) {
			throw new ApiException(APIConst.ERROR_CODE_0004,
					APIConst.ERROR_MSG_0004);
		}
		if (!"".equals(backMoneyStatus)) {
			returnOrder.setBackmoneystatus(backMoneyStatus);
		}
		returnOrderService.update(sid, returnOrder);
	}

	@Override
	public Long addRetrurnMoney(Long sid, Long roId, Order order,
			ReturnOrder apiReturnOrder) throws ApiException {
		if (null == sid || null == order || null == apiReturnOrder) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ReturnOrderT platReturnOrder = new ReturnOrderT();

		platReturnOrder.setOrdernum(order.getId().toString());

		Date date = new Date();
		// 买家创建退款时间，
		platReturnOrder.setCreatebackmoneytime(date);
		// 退款原因
		platReturnOrder.setBackmoneyexplain(apiReturnOrder
				.getBackmoneyexplain());
		// 退款说明
		platReturnOrder.setBackmoneyreason(apiReturnOrder.getBackmoneyreason());
		// 退款状态
		platReturnOrder.setBackmoneystatus(APIConst.RETURNORDER_BUYER_APPLY);

		platReturnOrder.setPrice(apiReturnOrder.getPrice());

		returnOrderService.insert(sid, platReturnOrder);

		return sid;
	}

	@Override
	public List<ReturnOrder> getrOrderList(Long sid,
			ReturnOrder apiReturnOrder, String order, int currPage, int pageSize)
			throws ApiException {
		ReturnOrderT platReturnOrder = new ReturnOrderT();
		BeanUtils.copyProperties(apiReturnOrder, platReturnOrder);
		List<ReturnOrderT> platROList = returnOrderService.find(
				platReturnOrder, sid, order, currPage, pageSize);

		List<ReturnOrder> apiROList = new ArrayList<ReturnOrder>();

		for (ReturnOrderT returnOrder : platROList) {
			ReturnOrder apiROrder = new ReturnOrder();

			String operation = "";
			if (returnOrder.getBackmoneystatus().equals(
					APIConst.RETURNORDER_BUYER_APPLY)) {
				operation = "<a href=\"#\" onclick=\"javascript:audit_rorder('"
						+ returnOrder.getId() + "')\">处理申请</a>";
			} else if (returnOrder.getBackmoneystatus().equals(
					APIConst.RETURNORDER_BUYER_REFUND)) {
				operation = "<a href=\"#\" onclick=\"javascript:show_rorder('"
						+ returnOrder.getId() + "')\">查看</a>";
			} else if (returnOrder.getBackmoneystatus().equals(
					APIConst.RETURNORDER_BUYER_REFUND)) {
				operation = "<a href=\"#\" onclick=\"javascript:show_rorder('"
						+ returnOrder.getId() + "')\">查看</a>";
			} else if (returnOrder.getBackmoneystatus().equals(
					APIConst.RETURNORDER_BUYER_REFUND)) {
				operation = "<a href=\"#\" onclick=\"javascript:show_rorder('"
						+ returnOrder.getId() + "')\">查看</a>";
			} else {
				operation = "<a href=\"#\" onclick=\"javascript:show_rorder('"
						+ returnOrder.getId() + "')\">查看</a>";
			}
			apiROrder.setOperation(operation);
			BeanUtils.copyProperties(returnOrder, apiROrder);
			apiROList.add(apiROrder);
		}

		return apiROList;
	}

	@Override
	public List<ReturnOrder> getBuyerROrderList(Long sid,
			ReturnOrder apiReturnOrder, String order, int currPage, int pageSize)
			throws ApiException {
		ReturnOrderT platReturnOrder = new ReturnOrderT();
		BeanUtils.copyProperties(apiReturnOrder, platReturnOrder);
		List<ReturnOrderT> platROList = returnOrderService.find(
				platReturnOrder, sid, order, currPage, pageSize);

		List<ReturnOrder> apiROList = new ArrayList<ReturnOrder>();

		for (ReturnOrderT returnOrder : platROList) {
			ReturnOrder apiROrder = new ReturnOrder();
			BeanUtils.copyProperties(returnOrder, apiROrder);
			apiROList.add(apiROrder);
		}

		return apiROList;
	}

	@Override
	public int getrOrderCount(Long sid, ReturnOrder apirOrder)
			throws ApiException {
		ReturnOrderT platrOrder = new ReturnOrderT();
		BeanUtils.copyProperties(apirOrder, platrOrder);
		int count = returnOrderService.count(sid, platrOrder);
		return count;
	}

	/**
	 * backMoneyStatus = 2 同意退款退货。 backMoneyStatus = 1 不同意退款退货。
	 */
	@Override
	public void sellerAuditBackMoney(Long sid, Long roId,
			String backMoneyStatus, String returnGoodsAddress,
			String authreturngoodsexplain) throws ApiException {
		if (null == sid || null == roId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ReturnOrderT returnOrder = returnOrderService.findById(sid, roId);
		if (null == returnOrder) {
			throw new ApiException(APIConst.ERROR_CODE_0004,
					APIConst.ERROR_MSG_0004);
		}
		if (!"".equals(backMoneyStatus)) {
			returnOrder.setBackmoneystatus(backMoneyStatus);
		}
		returnOrder.setReturngoodsaddress(returnGoodsAddress);

		Date date = new Date();
		// 卖家审核退货时间
		returnOrder.setAuthreturngoodstime(date);

		returnOrder.setAuthreturngoodsexplain(authreturngoodsexplain);

		returnOrderService.update(sid, returnOrder);
	}

	@Override
	public void buyerWriteBackGoods(Long sid, Long roId, ReturnOrder apirOrder)
			throws ApiException {

		if (null == sid || null == roId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ReturnOrderT returnOrder = returnOrderService.findById(sid, roId);
		if (null == returnOrder) {
			throw new ApiException(APIConst.ERROR_CODE_0004,
					APIConst.ERROR_MSG_0004);
		}
		// 填写退货物流信息，物流公司，物流单号。修改退款状态，3
		returnOrder.setShipmethod(apirOrder.getShipmethod());
		returnOrder.setShipfee(apirOrder.getShipfee());
		returnOrder.setLogisticsnum(apirOrder.getLogisticsnum());
		Date date = new Date();
		// 提交退货表单时间
		returnOrder.setSubmitreturngoodsformtime(date);
		returnOrderService.update(sid, returnOrder);
	}

	// 确认收货。退款成功，修改状态(backMomeyStatus=0)
	@Override
	public Long sellerAuditBackGoods(Long sid, Long roId, String backMomeyStatus)
			throws ApiException {
		if (null == sid || null == roId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ReturnOrderT returnOrder = returnOrderService.findById(sid, roId);
		if (null == returnOrder) {
			throw new ApiException(APIConst.ERROR_CODE_0004,
					APIConst.ERROR_MSG_0004);
		}
		returnOrder.setBackmoneystatus(backMomeyStatus);

		Date date = new Date();
		// 卖家退货确认时间。
		returnOrder.setFinishreturngoodstime(date);
		returnOrderService.update(sid, returnOrder);
		return returnOrder.getId();
	}

	@Override
	public ReturnOrder getReturnOrder(Long sid, Long roId) throws ApiException {
		if (null == sid || null == roId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		ReturnOrder apiReturnOrder = new ReturnOrder();
		ReturnOrderT returnOrder = returnOrderService.findById(sid, roId);
		BeanUtils.copyProperties(returnOrder, apiReturnOrder);

		return apiReturnOrder;
	}

}
