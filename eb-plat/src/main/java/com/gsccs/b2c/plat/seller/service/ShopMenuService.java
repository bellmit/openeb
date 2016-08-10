package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import com.gsccs.eb.api.domain.seller.Menu;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ShopMenuService {

    public void save(Menu shopmenu);
    Menu getById(Long Id);
    List<Menu> find(Menu param);
    List<Menu> findByParId(Long parid);
    public void deleteById(Long Id);

  
}
