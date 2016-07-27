package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.CartMapper;
import com.gsccs.b2c.plat.site.model.Cart;
import com.gsccs.b2c.plat.site.model.CartExample;
import com.gsccs.b2c.plat.site.model.CartExample.Criteria;

/**
 * 购物车服务类
 * @author ZhangTao
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> find(Long sid, String buyer) {
		return cartMapper.selectCartsByBuyer(sid, buyer);
	}

	@Override
	public Long add(Long sid, Cart cart) {
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
	public int upadte(Long sid, Cart cart) {
		return cartMapper.updateCart(sid, cart);
	}

	@Override
	public Cart getCart(Long siteId, Long id) {
		return cartMapper.selectByPrimaryKey(siteId, id);
	}

	@Override
	public List<Cart> findCheckedCart(long siteId, String cartIds) {
		return cartMapper.selectCheckedCart(siteId, cartIds);
	}

}
