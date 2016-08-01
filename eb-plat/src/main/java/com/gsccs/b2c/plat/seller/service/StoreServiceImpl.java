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
import com.gsccs.b2c.plat.seller.dao.StoreMapper;
import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.model.StoreExample;
import com.gsccs.b2c.plat.seller.model.StoreExample.Criteria;
import com.gsccs.b2c.plat.site.dao.NavigationMapper;
import com.gsccs.b2c.plat.site.model.NavigationExample;
import com.gsccs.eb.api.domain.site.Navigation;

/**
 * 
 * @创建人：x.j niu
 * @类名称：StoreServiceImpl
 * @创建时间：2015年3月18日 下午4:41:07
 * 
 */
@Service(value="storeService")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private DruidDataSource dataSource;
	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private NavigationMapper navigationMapper;
	// 卖家账号
	@Autowired
	private SellerAccountMapper sellerAccountMapper;

	/**
	 * 创建店铺
	 */
	@Override
	public Long insert(Store store) {
		// 创建店铺
		if (null != store){
			store.setAddtime(new Date());
			storeMapper.insert(store);
		}
		//initDataTable();
		return store.getId();
	}

	/**
	 * 根据id查询店铺信息
	 */
	@Override
	public Store findById(Long id) {
		return storeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Store> find(Store store, String order) {

		StoreExample example = new StoreExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(store, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		return storeMapper.selectByExample(example);
	}

	/**
	 * 获取店铺Id
	 */
	public Long findMaxSId() {
		Long maxSId = storeMapper.selectMaxId();
		if (null == maxSId) {
			maxSId = (long) 1000;
		}
		maxSId = maxSId + 1;
		return maxSId;
	}

	@Override
	public void update(Store store) {
		storeMapper.updateByPrimaryKey(store);
	}

	@Override
	public void del(Long storeId) {

	}

	@Override
	public List<Store> find(Store store, String order, int currPage,
			int pageSize) {
		StoreExample example = new StoreExample();
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
	public Store findByDomain(String domain, boolean cache) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store findBySourcepath(String sourcepath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean haveSourcePath(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(Store site) {
		StoreExample example = new StoreExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(site, criteria);
		return storeMapper.countByExample(example);
	}

	@Override
	public List<Navigation> findStoreNavs(Long siteid) {
		NavigationExample example = new NavigationExample();
		NavigationExample.Criteria c = example.createCriteria();
		c.andShopidEqualTo(siteid);
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

	public void proSearchParam(Store store, Criteria criteria) {

	}

	
	
	@Override
	public JSONObject storeStatist() {
		
		return null;
	}

}
