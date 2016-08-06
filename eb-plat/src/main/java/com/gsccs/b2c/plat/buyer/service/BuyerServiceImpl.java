package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.auth.shiro.PasswordHelper;
import com.gsccs.b2c.plat.buyer.dao.BuyerMapper;
import com.gsccs.b2c.plat.buyer.dao.DeliverMapper;
import com.gsccs.b2c.plat.buyer.dao.GradeMapper;
import com.gsccs.b2c.plat.buyer.dao.PointsMapper;
import com.gsccs.b2c.plat.buyer.model.BuyerExample;
import com.gsccs.b2c.plat.buyer.model.GradeExample;
import com.gsccs.b2c.plat.buyer.model.PointsExample;
import com.gsccs.b2c.plat.buyer.model.PointsExample.Criteria;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.buyer.Buyer;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private GradeMapper gradeMapper;
	@Resource
	private PointsMapper pointsMapper;
	@Resource
	private DeliverMapper deliverMapper;
	@Resource
	private BuyerMapper buyerMapper;


	// 添加会员积分
	@Override
	public void insert(Long sid, Points record) {
		pointsMapper.insert(sid, record);
	}

	// 查询会员积分列表
	@Override
	public List<Points> getBuyerPoints(Long sid, Points record, int page,
			int rows) {
		PointsExample example = new PointsExample();
		Criteria c = example.createCriteria();
		example.setOrderByClause("addtime desc");
		example.setCurrPage(page);
		example.setPageSize(rows);
		return pointsMapper.selectPageByExample(sid, example);
	}

	@Override
	public int getBuyerPoints(Long sid, Long buyerid) {
		return pointsMapper.selectPointsSum(sid, buyerid);
	}

	

	@Override
	public List<Buyer> getBuyerList(Buyer param, int page, int rows) {
		BuyerExample example = new BuyerExample();
		BuyerExample.Criteria c = example.createCriteria();
		return buyerMapper.selectPageByExample(example);
	}

	@Override
	public void saveDeliver(Long sid, Deliver deliver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDeliver(Long sid, Long deliverid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDeliver(Long sid, Deliver deliver) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Deliver> findDeliverList(Long sid, Long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deliver getDeliver(Long userid, Long deliverid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> findGradeList() {
		GradeExample e = new GradeExample();
		GradeExample.Criteria c = e.createCriteria();
		return gradeMapper.selectByExample(e);
	}

	@Override
	public Grade getGrade(Long id) {
		return gradeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveGrade(Grade param) {
		if (null == param) {
			return;
		}
		if (null != param.getId()) {
			gradeMapper.updateByPrimaryKey(param);
		} else {
			gradeMapper.insert(param);
		}
	}

}
