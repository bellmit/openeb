package com.gsccs.b2c.plat.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.buyer.dao.DiscountMapper;
import com.gsccs.b2c.plat.buyer.dao.GradeMapper;
import com.gsccs.b2c.plat.buyer.model.Discount;
import com.gsccs.b2c.plat.buyer.model.DiscountExample;
import com.gsccs.b2c.plat.shop.dao.GoodsMapper;
import com.gsccs.b2c.plat.shop.dao.SkuMapper;
import com.gsccs.b2c.plat.shop.dao.SkuSpecMapper;
import com.gsccs.b2c.plat.shop.model.GoodsExample;
import com.gsccs.b2c.plat.shop.model.SkuExample;
import com.gsccs.b2c.plat.shop.model.SkuSpecExample;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.goods.SkuSpec;

/**
 * 商品服务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private SkuSpecMapper skuSpecMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private DiscountMapper discountMapper;

	@Override
	public List<Sku> findSkuList(Long goodsid) {
		if (null == goodsid) {
			return null;
		}
		SkuExample example = new SkuExample();
		SkuExample.Criteria c = example.createCriteria();
		c.andGoodsidEqualTo(goodsid);
		return skuMapper.selectByExample(example);
	}

	@Override
	public Goods getGoods(Long id) {
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int count(Goods param) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return goodsMapper.countByExample(example);
	}

	@Override
	public void editGoodsStatus(Long sid, Long productId, String status) {
		Goods pt = null;
		if (null != sid && null != productId && null != status) {
			pt = goodsMapper.selectByPrimaryKey(productId);
			pt.setStatus(status);
			goodsMapper.updateByPrimaryKey(sid, pt);
		}

	}

	@Override
	public void delGoods(Long sid, Long pId) {
		if (null != sid && null != pId) {
			goodsMapper.deleteByPrimaryKey(sid, pId);
		}
	}

	@Override
	public void editGoods(Long sid, Goods pt) {
		goodsMapper.updateByPrimaryKey(sid, pt);
	}

	@Override
	public void editGoods(Long sid, Sku goodsT) {
		skuMapper.updateByPrimaryKey(goodsT);
	}

	@Override
	public List<Goods> getHotGoodss(Long sid) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		c.andIshotEqualTo("1");
		return goodsMapper.selectByExample(sid, example);
	}

	@Override
	public List<Goods> getTopGoodss(Long sid) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		c.andIstopEqualTo("1");
		return goodsMapper.selectByExample(sid, example);
	}

	@Override
	public void productUnsale(Long sid) {
		goodsMapper.updateGoodsUnsale(sid, 0);
	}

	@Override
	public List<Goods> getGoodsList(Goods param, String order, int currPage,
			int pageSize) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return goodsMapper.selectPageByExample(example);
	}

	@Override
	public List<Goods> findGoodsList(String ids) {
		if (StringUtils.isEmpty(ids)) {
			return null;
		}
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		c.andSql(" id in (" + ids + ")");
		example.setCurrPage(1);
		example.setPageSize(Integer.MAX_VALUE);
		return goodsMapper.selectPageByExample(example);
	}

	@Override
	public Long addGoods(Goods goods, List<Sku> skulist) {
		Long goodsid = null;
		// 保存产品基础信息
		goods.setAddtime(new Date());
		goodsMapper.insert(goods);
		goodsid = goods.getId();
		saveSkuList(goodsid, skulist);
		return goodsid;
	}

	// 保存SKU信息
	public void saveSkuList(Long goodsid, List<Sku> skulist) {
		if (null == skulist || skulist.size() <= 0) {
			return;
		}

		// 是否存在SKU数据
		List<Sku> oldSkuList = findSkuList(goodsid);
		List<Long> skuids = new ArrayList<Long>();
		for (Sku sku : skulist) {
			sku.setGoodsid(goodsid);
			if (null == sku.getId()) {
				skuMapper.insert(sku);
			} else {
				skuMapper.updateByPrimaryKey(sku);
			}
			saveSkuSpec(goodsid, sku.getId(), sku.getSpecList());
			skuids.add(sku.getId());
		}
		// 删除失效的SKU数据
		System.out.println("###########goodsid:" + goodsid);
		if (null != skuids && skuids.size() > 0) {
			SkuExample example = new SkuExample();
			SkuExample.Criteria c = example.createCriteria();
			c.andIdNotIn(skuids);
			c.andGoodsidEqualTo(goodsid);
			skuMapper.deleteByExample(example);
		}
	}

	// 保存SKU规格特征
	private void saveSkuSpec(Long goodsid, Long skuid, List<SkuSpec> specList) {
		if (null == goodsid || null == skuid || specList == null) {
			return;
		}

		List<Long> skuspecids = new ArrayList<Long>();
		for (SkuSpec skuSpec : specList) {
			skuSpec.setSkuid(skuid);
			skuSpec.setGoodsid(goodsid);
			skuSpecMapper.insert(skuSpec);
			skuspecids.add(skuSpec.getId());
		}

		// 删除失效的数据
		if (null != skuspecids && skuspecids.size() > 0) {
			SkuSpecExample example = new SkuSpecExample();
			SkuSpecExample.Criteria c = example.createCriteria();
			c.andIdNotIn(skuspecids);
			c.andSkuidEqualTo(skuid);
			c.andGoodsidEqualTo(goodsid);
			skuSpecMapper.deleteByExample(example);
		}
	}

	public void proSearchParam(Sku p, SkuExample.Criteria criteria) {
		if (p != null) {
			if (p.getId() != null) {
				criteria.andIdEqualTo(p.getId());
			}

			if (null != p.getGoodsid()) {
				criteria.andGoodsidEqualTo(p.getGoodsid());
			}
		}
	}

	/**
	 * 处理查询条件
	 * 
	 * @param Goods
	 * @param criteria
	 */
	public void proSearchParam(Goods param, GoodsExample.Criteria c) {
		if (param != null) {
			if (param.getId() != null) {
				c.andIdEqualTo(param.getId());
			}

			if (StringUtils.isNotEmpty(param.getTitle())) {
				c.andTitleLike("'%" + param.getTitle() + "%'");
			}

			if (StringUtils.isNotEmpty(param.getStatus())) {
				c.andStatusEqualTo(param.getStatus());
			}

			if (StringUtils.isNotEmpty(param.getBarcode())) {
				c.andBarcodeLike("%" + param.getBarcode().trim() + "%");
			}

			if (null != param.getCateid()) {
				c.andCateidEqualTo(param.getCateid());
			}

			if (null != param.getShopid()) {
				c.andShopidEqualTo(param.getShopid());
			}
		}
	}

}
