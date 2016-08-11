package com.gsccs.b2c.plat;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.eb.api.domain.seller.Menu;
import com.gsccs.eb.api.domain.site.Navigation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class ShopServiceTest {

	@Autowired
	private ShopServiceI shopAPI;

	@Test
	public void getShopMenu() throws Throwable {
		List<Menu> menuList = shopAPI.findShopMenu();
		Assert.assertNull(menuList);
	}
	
	
	@Test
	public void getShopNav() throws Throwable {
		List<Navigation> navList = shopAPI.findShopNav(1001l);
		Assert.assertNull(navList);
	}
}
