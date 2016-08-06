package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.shop.service.CartService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.trade.CartItem;

/**
 * 购物车API实现类
 * 
 * @author ZhangTao
 * 
 */
public class CartServiceAPI implements CartServiceI {

	@Autowired
	private CartService cartService;

	@Autowired
	private GoodsService goodsService;

	@Override
	public List<CartItem> getCarts(Long siteId, Long buyerid) {
		List<CartItem> carts = cartService.find(siteId, buyerid);
		if (carts.size() > 0) {
			for (CartItem cartItem : carts) {
				Product product = goodsService.getGoods(cartItem.getPid());
				cartItem.setDesc(product.getRemark());
				cartItem.setPicUrl(product.getImg());
				cartItem.setPrice(product.getPrice());
				cartItem.setMktPrice(product.getMkprice());
			}
			return carts;
		}

		return null;
	}

	@Override
	public Long addCart(Long siteId, Long pid, int number, Long skuid,
			Long buyerid) {
		CartItem cart = new CartItem();
		cart.setBuyerid(buyerid);
		cart.setNum(number);
		cart.setPid(pid);
		cart.setSkuid(skuid);
		return cartService.add(siteId, cart);
	}

	@Override
	public int upadteCart(Long sid, CartItem cartItem) {
		return cartService.upadte(sid, cartItem);
	}

	@Override
	public void deleteCart(Long sid, Long cid) {
		cartService.delete(sid, cid);
	}

	@Override
	public CartItem getCart(Long siteId, Long id) {
		CartItem cartItem = cartService.getCart(siteId, id);
		Product product = goodsService.getGoods(cartItem.getPid());

		cartItem.setDesc(product.getRemark());
		cartItem.setPicUrl(product.getImg());
		cartItem.setMktPrice(product.getMkprice());
		return cartItem;
	}

	@Override
	public int getCartCount(Long siteId, Long buyerid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
