package com.gsccs.b2c.plat.pay.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.pay.dao.PayArgsMapper;
import com.gsccs.b2c.plat.pay.dao.PayTypeMapper;
import com.gsccs.b2c.plat.pay.model.PayArgsExample;
import com.gsccs.b2c.plat.pay.model.PayTypeExample;
import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.domain.trade.PayType;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private PayTypeMapper payTypeMapper;
	@Autowired
	private PayArgsMapper payArgsMapper;

	@Override
	public String savePayArgs(PayArgs param) {
		if (null == param) {
			return null;
		}
		String id = param.getId();
		if (StringUtils.isEmpty(id)) {
			id = UUID.randomUUID().toString();
			param.setId(id);
			payArgsMapper.insert(param);
		} else {
			payArgsMapper.updateByPrimaryKey(param);
		}
		return id;
	}

	@Override
	public String savePayType(PayType param) {
		if (null == param) {
			return null;
		}
		String id = param.getId();
		if (StringUtils.isEmpty(id)) {
			id = UUID.randomUUID().toString();
			param.setId(id);
			payTypeMapper.insert(param);
		} else {
			payTypeMapper.updateByPrimaryKey(param);
		}
		return id;
	}

	@Override
	public List<PayType> queryPayTypes(PayType param, int page, int pagesize) {
		PayTypeExample example = new PayTypeExample();
		PayTypeExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return payTypeMapper.selectByExample(example);
	}

	@Override
	public PayType getPayType(String id) {
		return payTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public PayArgs getPayArgs(String id) {
		return payArgsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PayArgs> queryPayArgs(PayArgs payArgs, int page, int pagesize) {
		return null;
	}

	public void proSearchParam(PayType param, PayTypeExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getName())) {
				criteria.andNameLike("%" + param.getName() + "%");
			}
			if (StringUtils.isNotEmpty(param.getKey())) {
				criteria.andKeyEqualTo(param.getKey());
			}
		}
	}

	public void proSearchParam(PayArgs param, PayArgsExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTypeid())) {
				criteria.andTypeidEqualTo(param.getTypeid());
			}
			if (StringUtils.isNotEmpty(param.getAppid())) {
				criteria.andAppidEqualTo(param.getAppid());
			}
			if (null != param.getShopid()) {
				criteria.andShopidEqualTo(param.getShopid());
			}
		}
	}

}
