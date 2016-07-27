package com.gsccs.b2c.store.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.eb.api.domain.seller.Shop;


@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private ShopServiceI shopAPI;
	private CateServiceI cateAPI;
	
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addpage() {
    	/*Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Long sid = (Long)session.getAttribute("siteId");*/
		try {
			Shop shop = shopAPI.getShop(Long.valueOf(1001));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "goods";
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg add() {
    	BaseMsg baseMsg = new BaseMsg();
    	
    	
    	return baseMsg;
    }

    
  
}
