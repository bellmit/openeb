package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.EvalConfMapper;
import com.gsccs.b2c.plat.shop.dao.EvalProductMapper;
import com.gsccs.b2c.plat.shop.dao.EvalItemMapper;
import com.gsccs.b2c.plat.shop.dao.EvalOrderMapper;
import com.gsccs.b2c.plat.shop.dao.EvalTypeMapper;
import com.gsccs.b2c.plat.shop.model.EvalConfT;
import com.gsccs.b2c.plat.shop.model.EvalGoodsT;
import com.gsccs.b2c.plat.shop.model.EvalItemT;
import com.gsccs.b2c.plat.shop.model.EvalItemTExample;
import com.gsccs.b2c.plat.shop.model.EvalOrderT;
import com.gsccs.b2c.plat.shop.model.EvalTypeT;
import com.gsccs.b2c.plat.shop.model.EvalTypeTExample;

/**
 * 商家评价数据接口
 * 
 * @author x.d zhang
 * 
 */
@Service
public class EvalServiceImpl implements EvalService {

	@Autowired
	private EvalConfMapper evalConfMapper;
	@Autowired
	private EvalItemMapper evalItemMapper;
	@Autowired
	private EvalTypeMapper evalTypeMapper;
	@Autowired
	private EvalOrderMapper evalScoreMapper;
	@Autowired
	private EvalProductMapper evalDetailMapper;

	@Override
	public EvalConfT getEvalConf(Long siteid, Long id) {
		return evalConfMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<EvalTypeT> getEvalTypes(Long siteid) {
		EvalTypeTExample example = new EvalTypeTExample();
		EvalTypeTExample.Criteria c = example.createCriteria();
		c.andSiteidEqualTo(siteid);
		return evalTypeMapper.selectByExample(example);
	}

	@Override
	public List<EvalItemT> getEvalItems(Long siteid) {
		EvalItemTExample example = new EvalItemTExample();
		EvalItemTExample.Criteria c = example.createCriteria();
		c.andSiteidEqualTo(siteid);
		return evalItemMapper.selectByExample(example);
	}

	@Override
	public Long addEvalTypeT(EvalTypeT evalTypeT) {
		if (null != evalTypeT) {
			evalTypeMapper.insert(evalTypeT);
			return (long) evalTypeT.getId();
		} else {
			return null;
		}
	}

	@Override
	public void delEvalTypeT(Long id) {
		evalTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editEvalTypeT(EvalTypeT evalTypeT) {
		evalTypeMapper.updateByPrimaryKey(evalTypeT);
	}

	@Override
	public Long addEvalItem(EvalItemT evalItemT) {
		return (long) evalItemMapper.insert(evalItemT);
	}

	@Override
	public void delEvalItem(Long id) {
		evalItemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editEvalItem(EvalItemT evalItemT) {
		evalItemMapper.updateByPrimaryKey(evalItemT);
	}

	/**
	 * 处理评分项目查询条件
	 * 
	 * @param evalTypeT
	 * @param criteria
	 */
	public void evalTypeproSearchParam(EvalTypeT evalTypeT,
			EvalTypeTExample.Criteria criteria) {
		if (null != evalTypeT) {
			if (evalTypeT.getId() != null) {
				criteria.andIdEqualTo(evalTypeT.getId());
			}
			if (evalTypeT.getSiteid() != null) {
				criteria.andSiteidEqualTo(evalTypeT.getSiteid());
			}
			if (evalTypeT.getIsdefault() != null) {
				criteria.andIsdefaultEqualTo(evalTypeT.getIsdefault());
			}
		}
	}

	/**
	 * 处理打分项查询条件
	 * 
	 * @param evalItemT
	 * @param criteria
	 */
	public void evalItemproSearchParam(EvalItemT evalItemT,
			EvalItemTExample.Criteria criteria) {
		if (null != evalItemT) {
			if (evalItemT.getId() != null) {
				criteria.andIdEqualTo(evalItemT.getId());
			}
			if (evalItemT.getSiteid() != null) {
				criteria.andSiteidEqualTo(evalItemT.getSiteid());
			}
			if (evalItemT.getIsdefault() != null) {
				criteria.andIsdefaultEqualTo(evalItemT.getIsdefault());
			}
			if (evalItemT.getTypeid() != null) {
				criteria.andTypeidEqualTo(evalItemT.getTypeid());
			}
		}
	}

	@Override
	public List<EvalTypeT> getEvalTypes(EvalTypeT evalTypeT) {
		EvalTypeTExample example = new EvalTypeTExample();
		EvalTypeTExample.Criteria c = example.createCriteria();
		evalTypeproSearchParam(evalTypeT, c);
		return evalTypeMapper.selectByExample(example);
	}

	@Override
	public List<EvalItemT> getEvalItems(EvalItemT evalItemT) {
		EvalItemTExample example = new EvalItemTExample();
		EvalItemTExample.Criteria c = example.createCriteria();
		evalItemproSearchParam(evalItemT, c);
		return evalItemMapper.selectByExample(example);
	}

	@Override
	public void addEvalRemark(Long siteid, EvalGoodsT detailT) {
		if (null != detailT) {
			evalDetailMapper.insert(siteid, detailT);
		}
	}

	@Override
	public void addEvalScore(Long siteid, List<EvalOrderT> scoreList) {
		if (null != scoreList) {
			for (EvalOrderT scoreT : scoreList) {
				evalScoreMapper.insert(siteid, scoreT);
			}
		}
	}

	@Override
	public List<EvalGoodsT> findProductEvals(Long siteid, EvalGoodsT param,
			int pagesize, int rows) {
		
		return null;
	}

	@Override
	public void findOrderEvals(Long siteid, int pagesize, int rows) {
		// TODO Auto-generated method stub
		
	}
}
