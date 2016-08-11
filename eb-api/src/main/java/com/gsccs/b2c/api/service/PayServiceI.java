package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.domain.trade.PayNote;
import com.gsccs.eb.api.domain.trade.PayType;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 支付管理API 
 * @author x.d zhang
 *
 */
public interface PayServiceI {

	/**
	 * 添加支付参数
	 * @param sid
	 * @param payArgs
	 * @return
	 */
	public void addPayArgs(Long sid,PayArgs payArgs) throws ApiException ;
	
	
	/**
	 * 删除支付参数
	 * @param shopid
	 * @param id
	 * @throws ApiException
	 */
	public void delPayArgs(Long shopid, String id) throws ApiException ;
	
	/**
	 * 查询支付方式
	 * @param sid
	 * @return
	 */
	public List<PayType> findPayType();
	
	
	/**
	 * 查询支付参数
	 * @param shopid
	 * @return
	 */
	public List<PayArgs> findPayArgs(Long shopid);
	
	/**
	 * 查询支付记录
	 * @param shopid
	 * @return
	 */
	public List<PayNote> findPayNote(Long shopid,int page,int rows);
	
	
	
}
