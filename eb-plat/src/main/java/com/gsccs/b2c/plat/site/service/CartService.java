package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.b2c.plat.site.model.Cart;

/**
 * 购物车服务类
 * @author ZhangTao
 *
 */
public interface CartService {
	
	/**
	 * 根据登录会员名称，查询对应的购物车信息
	 * @param buyer
	 * @return 购物车信息列表
	 */
	public List<Cart> find(Long sid, String buyer);
	
	/**
	 * 添加
	 * @param cart
	 * @return
	 */
	public Long add(Long sid, Cart cart);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Long sid, Long id);
	
	/**
	 * 更新
	 * @param cart
	 * @return
	 */
	public int upadte(Long sid, Cart cart);

	/**
	 * 根据ID查询购物车信息
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
	public List<com.gsccs.b2c.plat.site.model.Cart> findCheckedCart(
			long siteId, String cartIds);
}
