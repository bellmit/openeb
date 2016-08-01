package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.trade.CartItem;

/**
 * 购物车API
 * 
 * @author ZhangTao
 * 
 */
public interface CartServiceI {

	/**
	 * 根据登录会员获取会员购物车信息
	 * 
	 * @param buyer
	 *            (会员)
	 * @return
	 */
	public List<CartItem> getCarts(Long siteId, Long buyerid);

	/**
	 * 根据登录会员获取会员购物车数量
	 * 
	 * @param siteId
	 * @param buyer
	 * @return
	 */
	public int getCartCount(Long siteId, Long buyerid);

	/**
	 * 添加购物车信息
	 * 
	 * @param siteId
	 * @param buyer
	 * @return
	 */
	public Long addCart(Long siteId, Long pid, int number, Long sku,
			Long buyerid);

	/**
	 * 更新购物车信息
	 * 
	 * @param cart
	 * @return
	 */
	public int upadteCart(Long sid, CartItem cart);

	/**
	 * 删除购物车信息
	 * 
	 * @param cart
	 */
	public void deleteCart(Long sid, Long cid);

	/**
	 * 获取购物车信息
	 * 
	 * @param siteId
	 * @param id
	 * @return
	 */
	public CartItem getCart(Long siteId, Long id);

}
