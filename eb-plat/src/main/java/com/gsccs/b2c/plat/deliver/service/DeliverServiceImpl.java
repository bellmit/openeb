package com.gsccs.b2c.plat.deliver.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.deliver.dao.DeliverCorpMapper;
import com.gsccs.b2c.plat.deliver.dao.DeliverSetMapper;
import com.gsccs.b2c.plat.deliver.model.CorpExample;
import com.gsccs.b2c.plat.deliver.model.TempletExample;
import com.gsccs.eb.api.domain.deliver.Corp;
import com.gsccs.eb.api.domain.deliver.Templet;

/**
 * @说明 商品货运物流接口 快递物流订单查询服务比如申通快递、顺丰快递、圆通快递、EMS快递、汇通快递、宅急送快递等
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 上午9:33:36
 */
@Service
public class DeliverServiceImpl implements DeliverService {

	@Resource
	private DeliverCorpMapper deliverCorpMapper;
	@Resource
	private DeliverSetMapper deliverSetMapper;

	// 物流公司信息保存
	@Override
	public void saveCorp(Corp corp) {
		if (null == corp) {
			return;
		}
		if (null != corp.getId()) {
			deliverCorpMapper.updateByPrimaryKey(corp);
		} else {
			deliverCorpMapper.insert(corp);
		}

	}

	// 根据ID删除物流公司信息
	@Override
	public void deleteCorp(Integer id) {
		deliverCorpMapper.deleteByPrimaryKey(id);
	}

	// 根据ID查询一条物流公司信息
	@Override
	public Corp getCorp(Integer id) {
		return deliverCorpMapper.selectByPrimaryKey(id);
	}

	// 查询所有
	public List<Corp> findtAll() {
		return deliverCorpMapper.selectAll();
	}

	@Override
	public List<Corp> find(Corp t, String order, int currPage, int pageSize,
			boolean cache) {
		CorpExample example = new CorpExample();
		CorpExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return deliverCorpMapper.selectPageByExample(example);
	}

	@Override
	public int count(Corp t) {
		CorpExample example = new CorpExample();
		CorpExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverCorpMapper.countByExample(example);
	}

	@Override
	public List<Templet> find(Templet t, String order, int currPage,
			int pageSize, boolean cache) {
		TempletExample example = new TempletExample();
		TempletExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return deliverSetMapper.selectPageByExample(example);
	}

	@Override
	public int count(Templet t) {
		TempletExample example = new TempletExample();
		TempletExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverSetMapper.countByExample(example);
	}

	public void proSearchParam(Corp t, CorpExample.Criteria criteria) {

	}

	public void proSearchParam(Templet t, TempletExample.Criteria c) {
		if (null != t) {
			if (null != t.getSiteid()) {
				System.out.println("sid==" + t.getSiteid());
				c.andSiteidEqualTo(t.getSiteid());
			}
		}
	}

	public Templet get(Long siteid, String id) {
		return deliverSetMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Templet> get(Templet t) {
		TempletExample example = new TempletExample();
		TempletExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverSetMapper.selectByExample(example);
	}

	// 根据id删除支付方式
	@Override
	public void delDeliverType(String id) {
		deliverSetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveType(Templet dtt) {
		if (null == dtt) {
			return;
		}
		if (StringUtils.isNotEmpty(dtt.getId())) {
			deliverSetMapper.updateByPrimaryKey(dtt);
		}
		deliverSetMapper.insert(dtt);
	}

	@Override
	public Templet find(String id) {
		return deliverSetMapper.selectByPrimaryKey(id);
	}

	@Override
	public Templet getType(String id) {
		return deliverSetMapper.selectByPrimaryKey(id);
	}

	@Override
	public Templet getType(Long siteid, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
