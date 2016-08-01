package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.CartItemMapper;
import com.gsccs.eb.api.domain.trade.CartItem;

/**
 * 购物车服务类
 * 
 * @author ZhangTao
 * 
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemMapper cartMapper;

	@Override
	public List<CartItem> find(Long sid, Long buyerid) {
		return cartMapper.selectCartsByBuyer(sid, buyerid);
	}

	@Override
	public Long add(Long sid, CartItem cart) {
		if (null != cart) {
			cartMapper.insert(sid, cart);
			return cart.getId();
		}
		return null;
	}

	@Override
	public void delete(Long sid, Long id) {
		cartMapper.deleteByPrimaryKey(sid, id);
	}

	@Override
	public int upadte(Long sid, CartItem cart) {
		return cartMapper.updateCart(sid, cart);
	}

	@Override
	public CartItem getCart(Long siteId, Long id) {
		return cartMapper.selectByPrimaryKey(siteId, id);
	}

	@Override
	public List<CartItem> findCheckedCart(long siteId, String cartIds) {
		return cartMapper.selectCheckedCart(siteId, cartIds);
	}

}
