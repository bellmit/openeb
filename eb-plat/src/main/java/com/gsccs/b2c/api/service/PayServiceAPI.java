package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.pay.service.PayService;
import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.domain.trade.PayNote;
import com.gsccs.eb.api.domain.trade.PayType;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 支付服务接口
 * 
 * @author x.d zhang
 * 
 */
public class PayServiceAPI implements PayServiceI {

	@Autowired
	private PayService payService;

	@Override
	public void addPayArgs(Long shopid, PayArgs payArgs) throws ApiException {
		if (null == shopid || null == payArgs) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		payArgs.setShopid(shopid);
		payService.savePayArgs(payArgs);
	}

	@Override
	public void delPayArgs(Long shopid, String id) throws ApiException {

	}

	@Override
	public List<PayType> findPayType() {
		PayType param = new PayType();
		param.setState("1");
		return payService.queryPayTypes(null, 1, Integer.MAX_VALUE);
	}

	@Override
	public List<PayArgs> findPayArgs(Long shopid) {
		PayArgs param = new PayArgs();
		param.setShopid(shopid);
		return payService.queryPayArgs(param, 1, Integer.MAX_VALUE);
	}

	@Override
	public List<PayNote> findPayNote(Long shopid, int page, int rows) {
		return null;
	}

}
