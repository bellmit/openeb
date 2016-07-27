package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.Cart;

/**
 * 购物车API
 * @author ZhangTao
 *
 */
public interface CartServiceI {

	/**
	 * 根据登录会员获取会员购物车信息
	 * @param buyer(会员)
	 * @return
	 */
	public List<Cart> getCarts(Long siteId, String buyer);
	
	/**
	 * 根据登录会员获取会员购物车数量
	 * @param siteId
	 * @param buyer
	 * @return
	 */
	public int getCartCount(Long siteId, String buyer);
	
	/**
	 * 添加购物车信息
	 * @param siteId
	 * @param buyer
	 * @return
	 */
	public Long addCart(Long siteId,Long pid, int number, Long sku, String buyer);
	
	/**
	 * 更新购物车信息
	 * @param cart
	 * @return
	 */
	public int upadteCart(Long sid, Cart cart);
	
	/**
	 * 删除购物车信息
	 * @param cart
	 */
	public void deleteCart(Long sid, Long cid);

	/**
	 * 获取购物车信息
	 * @param siteId
	 * @param id
	 * @return 
	 */
	public Cart getCart(Long siteId, Long id);

	/**
	 * 获取选中的购物车信息
	 * @param siteId
	 * @param cartIds
	 * @return
	 */
	public Cart getCheckedCart(long siteId, String cartIds);
	
}
