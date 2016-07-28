package com.gsccs.b2c.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.domain.Cart;
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.site.service.CartService;
import com.gsccs.eb.api.domain.goods.Product;

/**
 * 购物车API实现类
 * @author ZhangTao
 *
 */
public class CartServiceAPI implements CartServiceI {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Override
	public List<Cart> getCarts(Long siteId, String buyer) {
		List<Cart> cars = new ArrayList<Cart>();
		List<com.gsccs.b2c.plat.site.model.Cart> carts = cartService.find(siteId, buyer);
		
		if(carts.size() > 0) {
			for (com.gsccs.b2c.plat.site.model.Cart car : carts) {
				Product product = goodsService.getProduct(siteId, car.getProductId(), true);
				GoodsT goods = goodsService.getGoods(siteId, car.getSku());
				
				Cart cart = new Cart();
				//cart.setId(car.getId());
				cart.setAmount(car.getNumber() * product.getPrice());
				cart.setDesc(product.getRemark());
				cart.setNumber(car.getNumber());
				cart.setPicUrl(product.getImg());
				cart.setPid(car.getProductId());
				cart.setPrice(product.getPrice());
				cart.setMktPrice(product.getMkprice());
				cart.setSku(goods.getSpecstr());
				
				cars.add(cart);
			}
			return cars;
		}
		
		return null;
	}

	@Override
	public int getCartCount(Long siteId, String buyer) {
		List<com.gsccs.b2c.plat.site.model.Cart> carts = cartService.find(siteId, buyer);
		if(carts.size() > 0) {
			return carts.size();
		}
		return 0;
	}

	@Override
	public Long addCart(Long siteId, Long pid, int number, Long sku, String buyer) {
		com.gsccs.b2c.plat.site.model.Cart cart = new com.gsccs.b2c.plat.site.model.Cart();
		cart.setBuyer(buyer);
		cart.setNumber(number);
		cart.setProductId(pid);
		cart.setSku(sku);
		return cartService.add(siteId, cart);
	}

	@Override
	public int upadteCart(Long sid, Cart cart) {
		com.gsccs.b2c.plat.site.model.Cart car = new com.gsccs.b2c.plat.site.model.Cart();
		//car.setId(cart.getId());
		car.setNumber(cart.getNumber());
		return cartService.upadte(sid, car);
	}

	@Override
	public void deleteCart(Long sid, Long cid) {
		cartService.delete(sid, cid);
	}

	@Override
	public Cart getCart(Long siteId, Long id) {
		com.gsccs.b2c.plat.site.model.Cart car = cartService.getCart(siteId, id);
		
		Product product = goodsService.getProduct(siteId, car.getProductId(), true);
		GoodsT goods = goodsService.getGoods(siteId, car.getSku());
		
		Cart cart = new Cart();
		
		//cart.setId(car.getId());
		cart.setAmount(car.getNumber() * product.getPrice());
		cart.setDesc(product.getRemark());
		cart.setNumber(car.getNumber());
		cart.setPicUrl(product.getImg());
		cart.setPid(car.getProductId());
		cart.setPrice(product.getPrice());
		cart.setMktPrice(product.getMkprice());
		cart.setSku(goods.getSpecstr());
		
		return cart;
	}

	@Override
	public Cart getCheckedCart(long siteId, String cartIds) {
		List<com.gsccs.b2c.plat.site.model.Cart> carts = cartService.findCheckedCart(siteId, cartIds);
		Cart cart = new Cart();
		
		if(carts.size() > 0) {
			Double amount = 0.0;
			int number = 0;
			for (com.gsccs.b2c.plat.site.model.Cart car : carts) {
				Product product = goodsService.getProduct(siteId, car.getProductId(), true);
				
				amount += car.getNumber() * product.getPrice();
				number ++;
			}
			
			// 小数点后两位4舍5入
			cart.setAmount(Double.parseDouble(new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString()));
			cart.setNumber(number);
		}
		
		return cart;
	}

}
