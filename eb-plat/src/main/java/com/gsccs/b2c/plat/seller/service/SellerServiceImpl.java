package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.auth.service.PasswordHelper;
import com.gsccs.b2c.plat.seller.dao.SellerAccountMapper;
import com.gsccs.b2c.plat.seller.model.SellerAccount;
import com.gsccs.b2c.plat.seller.model.SellerAccountExample;

/**
 * 卖家信息
 * 
 * @创建人：x.j niu
 * @类名称：SellerAccountServiceImpl
 * @创建时间：2015年4月1日 上午10:32:28
 */
@Service(value="sellerService")
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerAccountMapper sAccountMapper;
	@Autowired
	private PasswordHelper passwordHelper;

	/**
	 * 根据id查询
	 */
	@Override
	public SellerAccount findById(Long id) {
		return sAccountMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据登陆账号account查询卖家信息
	 */
	@Override
	public SellerAccount findByAccount(String account) {
		return sAccountMapper.selectByAccount(account);
	}

	/**
	 * 添加卖家账号
	 */
	@Override
	public Long insert(SellerAccount sellerAccount) {
		if (null != sellerAccount) {
			// 加密密码
			passwordHelper.encryptPassword(sellerAccount);
			sAccountMapper.insert(sellerAccount);
		}
		return null;
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(SellerAccount sellerAccount) {
		sAccountMapper.updateByPrimaryKey(sellerAccount);
	}

	@Override
	public List<SellerAccount> find(SellerAccount account, String order,
			int currPage, int pageSize) {
		SellerAccountExample example = new SellerAccountExample();
		SellerAccountExample.Criteria criteria = example.createCriteria();
		proSearchParam(account, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		return sAccountMapper.selectByExample(example);
	}

	@Override
	public int count(SellerAccount account) {
		SellerAccountExample example = new SellerAccountExample();
		SellerAccountExample.Criteria criteria = example.createCriteria();
		proSearchParam(account, criteria);
		return sAccountMapper.countByExample(example);
	}

	public void proSearchParam(SellerAccount account,
			SellerAccountExample.Criteria criteria) {
		if (null != account) {
			if (StringUtils.isNotEmpty(account.getAccount())) {
				criteria.andAccountEqualTo(account.getAccount());
			}
			if (null != account.getStoreId()) {
				criteria.andStoreIdEqualTo(account.getStoreId());
			}
		}
	}

	@Override
	public List<SellerAccount> find(SellerAccount account) {
		SellerAccountExample example = new SellerAccountExample();
		SellerAccountExample.Criteria criteria = example.createCriteria();
		proSearchParam(account, criteria);
		return sAccountMapper.selectByExample(example);
	}
}
