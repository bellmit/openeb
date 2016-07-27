package com.gsccs.b2c.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.domain.BuyerDeliver;
import com.gsccs.b2c.api.domain.BuyerLevel;
import com.gsccs.b2c.api.domain.BuyerScore;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.exception.ApiException;

/**
 * 用户API 提供了用户基本信息查询功能
 * 
 * @author x.d zhang
 */
public interface BuyerServiceI {

	/**
	 * 根据买家ID查询买家信息
	 * 
	 * @param siteId
	 *            站点ID
	 * @param userId
	 *            用户ID
	 */
	public User getBuyer(Long siteId, Long userId) throws ApiException;

	/**
	 * 会员注册
	 */
	public void addAccount(Long sid, User user) throws ApiException;

	/**
	 * 会员登录
	 */
	public User loginAccount(Long sid, String account, String pwd)
			throws ApiException;

	/**
	 * 根据店铺ID查询所有会员
	 */
	public List<User> getAllAcountBySid(Long siteId) throws ApiException;

	/**
	 * 根据买家帐号查询买家API
	 * 
	 * @param siteId
	 *            站点ID
	 * @param account
	 *            登录帐号
	 */
	public User findByAccount(Long siteId, String account) throws ApiException;

	/**
	 * 添加并更新会员资料
	 */
	public void updateBuyerInfo(Long siteId, User user) throws ApiException;

	/**
	 * 会员所有收货地址
	 * @param sid
	 * @param uid
	 * @return
	 * @throws ApiException
	 */
	public JSONArray buyerDelivers(Long sid, Long uid) throws ApiException;

	/**
	 * 新增收货地址
	 * 
	 * @param sid
	 * @param address
	 * @throws ApiException
	 */
	public void addBuyerDelivers(Long sid, BuyerDeliver dlv)
			throws ApiException;

	/**
	 * 查询收货地址
	 * 
	 * @param sid
	 * @param uid
	 * @param addressid
	 * @return
	 * @throws ApiException
	 */
	public BuyerDeliver getbuyerDeliver(Long sid, Long uid, Long addressid)
			throws ApiException;

	/**
	 * 删除收货地址
	 * 
	 * @param sid
	 * @param uid
	 * @param addressid
	 * @throws ApiException
	 */
	public void deletebuyerDeliver(Long sid, Long addressid)
			throws ApiException;

	/**
	 * 查询会员等级列表
	 * 
	 * @param sid
	 * @return
	 * @throws ApiException
	 */
	public List<BuyerLevel> getBuyerLevels(Long sid) throws ApiException;

	/**
	 * 积分明细
	 * 
	 * @param sid
	 * @param point
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws ApiException
	 */
	public List<BuyerScore> getBuyerPoints(Long sid, BuyerScore point,
			int page, int pagesize) throws ApiException;

	/**
	 * 积分总额
	 * 
	 * @param sid
	 * @return
	 * @throws ApiException
	 */
	public int getBuyerPoint(Long sid, Long buyerid) throws ApiException;

}
