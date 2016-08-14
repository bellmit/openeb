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
import com.gsccs.eb.api.utils.JsonMsg;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private PayTypeMapper payTypeMapper;
	@Autowired
	private PayArgsMapper payArgsMapper;

	@Override
	public JsonMsg savePayArgs(PayArgs param) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == param) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("数据有误！");
			return jsonMsg;
		}
		String id = param.getId();
		if (StringUtils.isEmpty(id)) {
			// 判断支付方式是否存在
			List<PayArgs> payArgsList = queryPayArgs(param.getShopid(),
					param.getTypeid());
			if (null != payArgsList || payArgsList.size() > 0) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("保存失败，该支付方式已存在！");
				return jsonMsg;
			}

			id = UUID.randomUUID().toString();
			param.setId(id);
			payArgsMapper.insert(param);
		} else {
			payArgsMapper.updateByPrimaryKey(param);
		}
		jsonMsg.setSuccess(true);
		return jsonMsg;
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
	public List<PayArgs> queryPayArgs(PayArgs param, int page, int pagesize) {
		PayArgsExample example = new PayArgsExample();
		PayArgsExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return payArgsMapper.selectPageByExample(example);
	}

	@Override
	public List<PayArgs> queryPayArgs(Long shopid, String paytypeid) {
		if (null == shopid || StringUtils.isEmpty(paytypeid)) {
			return null;
		}
		PayArgsExample example = new PayArgsExample();
		PayArgsExample.Criteria c = example.createCriteria();
		PayArgs param = new PayArgs();
		param.setShopid(shopid);
		param.setTypeid(paytypeid);
		proSearchParam(param, c);
		example.setCurrPage(1);
		example.setPageSize(Integer.MAX_VALUE);
		return payArgsMapper.selectPageByExample(example);
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

		}
		// 不允许查询到其他地铺支付参数
		if (null != param && null != param.getShopid()) {
			criteria.andShopidEqualTo(param.getShopid());
		} else {
			criteria.andShopidEqualTo(0l);
		}
	}

}
