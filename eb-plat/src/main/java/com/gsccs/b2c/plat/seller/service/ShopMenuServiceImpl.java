package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.seller.dao.ShopMenuMapper;
import com.gsccs.b2c.plat.seller.model.MenuExample;
import com.gsccs.b2c.plat.seller.model.MenuExample.Criteria;
import com.gsccs.eb.api.domain.seller.Menu;

@Service
public class ShopMenuServiceImpl implements ShopMenuService {

	@Autowired
	private ShopMenuMapper shopMenuMapper;

	@Override
	public void save(Menu shopmenu) {
		if (null == shopmenu) {
			return;
		}
		if (shopmenu.getParentId() == null) {
			shopmenu.setParentId(0l);
		}
		if (null == shopmenu.getId()) {
			shopMenuMapper.insert(shopmenu);
		} else {
			shopMenuMapper.updateByPrimaryKey(shopmenu);
		}
	}

	@Override
	public void deleteById(Long shopmenuId) {
		shopMenuMapper.deleteByPrimaryKey(shopmenuId);
	}

	@Override
	public Menu getById(Long shopmenuId) {
		return shopMenuMapper.selectByPrimaryKey(shopmenuId);
	}

	@Override
	public List<Menu> findByParId(Long parid) {
		MenuExample rexample = new MenuExample();
		Criteria c = rexample.createCriteria();
		if (null != parid) {
			c.andParentIdEqualTo(parid);
		} else {
			c.andParentIdEqualTo(0l);
		}
		return shopMenuMapper.selectByExample(rexample);
	}

	@Override
	public List<Menu> find(Menu param) {
		MenuExample rexample = new MenuExample();
		Criteria c = rexample.createCriteria();
		if (null != param) {
			if (null != param.getParentId()) {
				c.andParentIdEqualTo(param.getParentId());
			}
			/*
			 * if (null != param.getAvailable()){
			 * c.andParentIdEqualTo(param.getParentId()); }
			 */
		}
		return shopMenuMapper.selectByExample(rexample);
	}

}
