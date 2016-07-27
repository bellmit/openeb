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

import com.gsccs.b2c.plat.buyer.dao.BuyerAccountMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerInfoMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerLogMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerPointsMapper;
import com.gsccs.b2c.plat.buyer.model.BuyerAccount;
import com.gsccs.b2c.plat.buyer.model.BuyerInfo;
import com.gsccs.b2c.plat.buyer.model.BuyerPoints;
import com.gsccs.b2c.plat.buyer.model.BuyerPointsExample;
import com.gsccs.b2c.plat.buyer.model.BuyerPointsExample.Criteria;
import com.gsccs.b2c.plat.shop.dao.BuyerLevelTMapper;
import com.gsccs.b2c.plat.shop.model.BuyerLevelT;
import com.gsccs.b2c.plat.shop.model.BuyerLevelTExample;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerAccountMapper buyerAccountMapper;
	@Autowired
	private BuyerLevelTMapper buyerLevelTMapper;
	@Resource
	private BuyerPointsMapper buyerPointsMapper;
	@Resource
	private BuyerInfoMapper buyerInfoMapper;
	@Resource
	private BuyerLogMapper buyerLogMapper;

	// 根据店铺ID查询会员信息
	@Override
	public BuyerAccount getBuyerAccount(Long uid, Long sid) {
		return buyerAccountMapper.selectByPrimaryKey(uid, sid);
	}

	// 会员注册
	@Override
	public Long addBuyer(Long sid, BuyerAccount account) {
		if (null != sid && null != account) {
			PasswordHelper pwdhelp = new PasswordHelper();
			pwdhelp.encryptPassword(account);
			buyerAccountMapper.insert(sid, account);
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
	public BuyerAccount loginAccount(Long sid, String account, String pwd) {
		return buyerAccountMapper.loginAccount(sid, account, pwd);
	}

	// 根据店铺ID查询所有会员
	@Override
	public List<BuyerAccount> getAllAcountBySid(Long sid) {
		return buyerAccountMapper.selectAllAcountBySid(sid);
	}

	// 根据店铺ID与会员账号查询用户
	@Override
	public BuyerAccount getBuyerAccount(Long sid, String account) {
		return buyerAccountMapper.selectByAccount(account, sid);
	}

	@Override
	public List<BuyerLevelT> findBuyerLevels(Long sid) {
		BuyerLevelTExample e = new BuyerLevelTExample();
		BuyerLevelTExample.Criteria c = e.createCriteria();
		c.andSiteIdEqualTo(sid);
		return buyerLevelTMapper.selectByExample(e);
	}

	// 添加会员积分
	@Override
	public void insert(Long sid, BuyerPoints record) {
		buyerPointsMapper.insert(sid, record);
	}

	// 查询会员积分列表
	@Override
	public List<BuyerPoints> getBuyerScores(Long sid, BuyerPoints record,
			int page, int rows) {
		BuyerPointsExample example = new BuyerPointsExample();
		Criteria c = example.createCriteria();
		example.setOrderByClause("addtime desc");
		example.setCurrPage(page);
		example.setPageSize(rows);
		return buyerPointsMapper.selectPageByExample(sid, example);
	}

	@Override
	public int getBuyerScore(Long sid,Long buyerid) {
		return buyerPointsMapper.selectPointsSum(sid,buyerid);
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

		public void encryptPassword(BuyerAccount user) {
			user.setSalt(randomNumberGenerator.nextBytes().toHex());
			String newPassword = new SimpleHash(algorithmName, user.getPwd(),
					ByteSource.Util.bytes(user.getCredentialsSalt()),
					hashIterations).toHex();
			user.setPwd(newPassword);
		}
	}

}
