package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.buyer.dao.AccountMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerInfoMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerLogMapper;
import com.gsccs.b2c.plat.buyer.dao.DeliverMapper;
import com.gsccs.b2c.plat.buyer.dao.GradeMapper;
import com.gsccs.b2c.plat.buyer.dao.PointsMapper;
import com.gsccs.b2c.plat.buyer.model.Account;
import com.gsccs.b2c.plat.buyer.model.AccountExample;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliver;
import com.gsccs.b2c.plat.buyer.model.BuyerInfo;
import com.gsccs.b2c.plat.buyer.model.GradeExample;
import com.gsccs.b2c.plat.buyer.model.PointsExample;
import com.gsccs.b2c.plat.buyer.model.PointsExample.Criteria;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Resource
	private PointsMapper pointsMapper;
	@Resource
	private DeliverMapper deliverMapper;
	@Resource
	private BuyerInfoMapper buyerInfoMapper;
	@Resource
	private BuyerLogMapper buyerLogMapper;

	// 根据店铺ID查询会员信息
	@Override
	public Account getBuyerAccount(Long uid, Long sid) {
		return accountMapper.selectByPrimaryKey(uid, sid);
	}

	// 会员注册
	@Override
	public Long addBuyer(Long sid, Account account) {
		if (null != sid && null != account) {
			PasswordHelper pwdhelp = new PasswordHelper();
			pwdhelp.encryptPassword(account);
			accountMapper.insert(sid, account);
			BuyerInfo info = new BuyerInfo();
			info.setId(account.getId());
			info.setNickName(account.getNick());
			buyerInfoMapper.insert(sid, info);
			return account.getId();
		}
		return null;
	}

	// 会员登录
	@Override
	public Account loginAccount(Long sid, String account, String pwd) {
		return accountMapper.loginAccount(sid, account, pwd);
	}

	// 根据店铺ID与会员账号查询用户
	@Override
	public Account getBuyerAccount(Long sid, String account) {
		return accountMapper.selectByAccount(account, sid);
	}

	@Override
	public List<Grade> findBuyerLevels(Long sid) {
		GradeExample e = new GradeExample();
		GradeExample.Criteria c = e.createCriteria();
		c.andSiteIdEqualTo(sid);
		return gradeMapper.selectByExample(e);
	}

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

	private class PasswordHelper {
		private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

		@Value("${password.algorithmName}")
		private String algorithmName = "md5";
		@Value("${password.hashIterations}")
		private int hashIterations = 2;

		public void setRandomNumberGenerator(
				RandomNumberGenerator randomNumberGenerator) {
			this.randomNumberGenerator = randomNumberGenerator;
		}

		public void setAlgorithmName(String algorithmName) {
			this.algorithmName = algorithmName;
		}

		public void setHashIterations(int hashIterations) {
			this.hashIterations = hashIterations;
		}

		public void encryptPassword(Account user) {
			user.setSalt(randomNumberGenerator.nextBytes().toHex());
			String newPassword = new SimpleHash(algorithmName, user.getPwd(),
					ByteSource.Util.bytes(user.getCredentialsSalt()),
					hashIterations).toHex();
			user.setPwd(newPassword);
		}
	}

	@Override
	public List<Account> getBuyerList(Account param, int page, int rows) {
		AccountExample example = new AccountExample();
		AccountExample.Criteria c = example.createCriteria();
		return accountMapper.selectPageByExample(example);
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
	public List<BuyerDeliver> findDeliverList(Long sid, Long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyerDeliver getDeliver(Long userid, Long deliverid) {
		// TODO Auto-generated method stub
		return null;
	}

}
