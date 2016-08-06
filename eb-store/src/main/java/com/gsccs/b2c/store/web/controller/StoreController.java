package com.gsccs.b2c.store.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.Order.OrderState;
import com.gsccs.eb.api.exception.ApiException;


/**
 * 商城楼层管理控制类
 * @author x.d zhang
 *
 */
@Controller
public class StoreController {

	@Autowired
	private ShopServiceI shopAPI;
	
	@Autowired
	private GoodsServiceI goodsServiceAPI;
	
	@Autowired
	private OrderServiceI orderAPI;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	
    @RequestMapping("/store")
    public String store() {
    	/*Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Long sid = (Long)session.getAttribute("siteId");*/
		try {
			Shop shop = shopAPI.getShop(Long.valueOf(1001));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "index";
        
    }

    @RequestMapping("/main")
	public String main(HttpServletRequest request,Model model) {
    	
    	long sid = (Long) request.getSession().getAttribute("siteId");
		return "main";
	}
    
    

    @RequestMapping("/index")
	public String index(HttpServletRequest request,Model model) {
    	
    	long sid = (Long) request.getSession().getAttribute("siteId");
    	
    	
    	Order o = new Order();
    	
    	Goods p = new Goods();
    	try {
    		
    		Shop shop = shopAPI.getShop(sid);
			
			Integer stockalertnum = shop.getStockalertnum();
    		
    		//待付款订单WAIT_PAY
    		o.setState(OrderState.valueOf("WAIT_PAY"));
			int   waitPaynum = orderAPI.getOrderCount(sid, o);
			model.addAttribute("waitPaynum", waitPaynum);
			
			//待发货订单WAIT_SEND
			o.setState(OrderState.valueOf("WAIT_SEND"));
			int   waitSendnum = orderAPI.getOrderCount(sid, o);
			model.addAttribute("waitSendnum", waitSendnum);
			
			//出售中的商品
			String status ="1";
			int onsaleNum = 0;
					/*goodsServiceAPI.getGoodsCount(sid, "", "", null, null,
					null, null, null, null, null, status);*/
			
			System.out.println("onsaleNum=="+onsaleNum);
			
			model.addAttribute("onsaleNum", onsaleNum);
			
			//预警中的商品
			
			Integer maxStoreNum = null;
			if(null != stockalertnum){
				maxStoreNum = stockalertnum;
			}
			
			int stockalertNum = 0;
			/*int stockalertNum = goodsServiceAPI.getGoodsCount(sid, "", "", null, null,
					null, null, null, maxStoreNum, null, status);
			*/
			model.addAttribute("stockalertNum", stockalertNum);
			
			System.out.println("预警中的值=="+stockalertNum);
			
			
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "index";
	}
   
    @RequestMapping("/forward")
	public String forward(String path) {
		return path;
	}
  
}
