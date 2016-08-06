package com.gsccs.b2c.plat.shop.service;

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
	private GoodsMapper productMapper;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private SkuSpecMapper skuSpecMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private DiscountMapper discountMapper;

	@Override
	public List<Sku> getSkuList(Long productid) {
		if (null == productid) {
			return null;
		}
		SkuExample example = new SkuExample();
		SkuExample.Criteria c = example.createCriteria();
		c.andGoodsidEqualTo(productid);
		return skuMapper.selectByExample(example);
	}

	@Override
	public Goods getGoods(Long id) {
		Goods pt = productMapper.selectByPrimaryKey(id);
		return pt;
	}

	@Override
	public int count(Long sid, Long pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long[] addBuyerPrice(Long sid, Long productId, Long goodsid,
			List<Discount> dislist) {
		if (null != sid && null != productId) {

		}
		return null;
	}

	@Override
	public List<Discount> getBuyerPrice(Long sid, Long productId, Long goodsid) {
		if (null != sid && null != productId) {
			DiscountExample e = new DiscountExample();
			DiscountExample.Criteria c = e.createCriteria();
		}
		return null;
	}

	@Override
	public void editGoodsStatus(Long sid, Long productId, String status) {
		Goods pt = null;
		if (null != sid && null != productId && null != status) {
			pt = productMapper.selectByPrimaryKey(productId);
			pt.setStatus(status);
			productMapper.updateByPrimaryKey(sid, pt);
		}

	}

	@Override
	public void delGoods(Long sid, Long pId) {
		if (null != sid && null != pId) {
			productMapper.deleteByPrimaryKey(sid, pId);
		}
	}

	@Override
	public void editGoods(Long sid, Goods pt) {
		productMapper.updateByPrimaryKey(sid, pt);
	}

	@Override
	public void editGoods(Long sid, Sku goodsT) {
		skuMapper.updateByPrimaryKey(sid, goodsT);
	}

	@Override
	public List<Goods> getHotGoodss(Long sid) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		c.andIshotEqualTo("1");
		return productMapper.selectByExample(sid, example);
	}

	@Override
	public List<Goods> getTopGoodss(Long sid) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		c.andIstopEqualTo("1");
		return productMapper.selectByExample(sid, example);
	}

	@Override
	public void productUnsale(Long sid) {
		productMapper.updateGoodsUnsale(sid, 0);
	}

	@Override
	public List<Goods> getGoodss(Goods param, String order, int currPage,
			int pageSize) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return productMapper.selectPageByExample(example);
	}

	@Override
	public Long addGoods(Goods p, List<Sku> skulist) {
		Long goodsid = null;
		// 保存产品基础信息
		productMapper.insert(p);
		goodsid = p.getId();
		// 保存产品SKU信息
		addSkuList(goodsid, skulist);
		return goodsid;
	}

	
	public void addSkuList(Long goodsid, List<Sku> skulist) {
		if (null != skulist && skulist.size() > 0) {
			int i = 0;
			for (Sku sku : skulist) {
				sku.setGoodsid(goodsid);
				skuMapper.insert(sku);
				// 保存SKU规格特征
				saveSkuSpec(goodsid,sku.getId(), sku.getSpecList());
			}
		}
	}

	private void saveSkuSpec(Long goodsid, Long skuid, List<SkuSpec> specList) {
		if (null == goodsid || null == skuid || specList == null) {
			return;
		}
		for (SkuSpec skuSpec : specList) {
			skuSpec.setSkuid(skuid);
			skuSpec.setGoodsid(goodsid);
			skuSpecMapper.insert(skuSpec);
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
		}
	}
}
