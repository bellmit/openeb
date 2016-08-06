package com.gsccs.b2c.plat.seller.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.seller.dao.SellerAccountMapper;
import com.gsccs.b2c.plat.seller.dao.StoreGradeMapper;
import com.gsccs.b2c.plat.seller.dao.StoreMapper;
import com.gsccs.b2c.plat.seller.model.GradeExample;
import com.gsccs.b2c.plat.seller.model.ShopExample;
import com.gsccs.b2c.plat.seller.model.ShopExample.Criteria;
import com.gsccs.b2c.plat.site.dao.NavigationMapper;
import com.gsccs.b2c.plat.site.model.NavigationExample;
import com.gsccs.eb.api.domain.seller.Grade;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;

/**
 * 
 * @创建人：x.j niu
 * @类名称：ShopServiceImpl
 * @创建时间：2015年3月18日 下午4:41:07
 * 
 */
@Service(value = "storeService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private DruidDataSource dataSource;
	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private NavigationMapper navigationMapper;
	@Autowired
	private StoreGradeMapper storeGradeMapper;
	@Autowired
	private SellerAccountMapper sellerAccountMapper;

	/**
	 * 创建店铺
	 */
	@Override
	public Long saveShop(Shop store) {
		Long  id = null;
		if (null==store){
			return null;
		}
		if (null != store.getId()){
			storeMapper.updateByPrimaryKey(store);
		}else{
			store.setAddtime(new Date());
			storeMapper.insert(store);
		}
		return store.getId();
	}

	/**
	 * 根据id查询店铺信息
	 */
	@Override
	public Shop findById(Long id) {
		return storeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Shop> find(Shop store, String order) {

		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(store, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		return storeMapper.selectByExample(example);
	}

	@Override
	public void del(Long storeId) {

	}

	@Override
	public List<Shop> find(Shop store, String order, int currPage,
			int pageSize) {
		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(store, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return storeMapper.selectPageByExample(example);
	}

	@Override
	public Shop findByDomain(String domain, boolean cache) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop findBySourcepath(String sourcepath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean haveSourcePath(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(Shop site) {
		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(site, criteria);
		return storeMapper.countByExample(example);
	}

	@Override
	public List<Navigation> findShopNavs(Long shopid) {
		NavigationExample example = new NavigationExample();
		NavigationExample.Criteria c = example.createCriteria();
		c.andShopidEqualTo(shopid);
		return navigationMapper.selectByExample(example);
	}

	// 初始化表结构
	private void initDataTable() {
		try {
			String initsql = "CREATE TABLE `shop_product_1010` (`id` bigint(20) NOT NULL AUTO_INCREMENT,`status` varchar(10) DEFAULT NULL ,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;";
			DruidPooledConnection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(initsql);
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Grade> findGradeList() {
		GradeExample example = new GradeExample();
		GradeExample.Criteria c = example.createCriteria();
		return storeGradeMapper.selectByExample(example);
	}

	public void proSearchParam(Shop store, Criteria criteria) {

	}

	@Override
	public JSONObject storeStatist() {

		return null;
	}

	@Override
	public Long saveGrade(Grade grade) {
		if (null==grade){
			return null;
		}
		
		return null;
	}

	@Override
	public Grade getGrade(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
