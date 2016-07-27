package com.gsccs.b2c.plat;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.eb.api.domain.seller.Shop;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class SellerServiceTest {

	@Autowired
	private BuyerServiceI buyerAPI;
	
	@Autowired
	private ShopServiceI shopAPI;

	@Test
	public void getSeller() throws Throwable {
		System.out.println("###############");
		/**User user = buyerAPI.getBuyer(Long.valueOf(1001), Long.valueOf(1000));
		Assert.assertNull(user);
		Assert.assertEquals(1000, user.getUserId().longValue());**/
		long s =1001;
		Shop shop = shopAPI.getShop(s);
		Assert.assertNull(shop);
		System.out.println(shop.getTitle());
		Assert.assertEquals("ss", shop.getTitle());
	}
}
