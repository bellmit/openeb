package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.eb.api.domain.trade.CartItem;

/**
 * 购物车服务类
 * 
 * @author ZhangTao
 * 
 */
public interface CartService {

	/**
	 * 根据登录会员名称，查询对应的购物车信息
	 * 
	 * @param buyer
	 * @return 购物车信息列表
	 */
	public List<CartItem> find(Long sid, Long buyerid);

	/**
	 * 添加
	 * 
	 * @param cart
	 * @return
	 */
	public Long add(Long sid, CartItem cart);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delete(Long sid, Long id);

	/**
	 * 更新
	 * 
	 * @param cart
	 * @return
	 */
	public int upadte(Long sid, CartItem cart);

	/**
	 * 根据ID查询购物车信息
	 * 
	 * @param siteId
	 * @param id
	 * @return
	 */
	public CartItem getCart(Long siteId, Long id);

	/**
	 * 获取选中的购物车信息
	 * 
	 * @param siteId
	 * @param cartIds
	 * @return
	 */
	public List<CartItem> findCheckedCart(long siteId, String cartIds);
}
