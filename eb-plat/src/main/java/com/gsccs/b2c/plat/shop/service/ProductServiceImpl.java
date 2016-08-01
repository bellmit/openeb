package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.buyer.dao.DiscountMapper;
import com.gsccs.b2c.plat.buyer.dao.GradeMapper;
import com.gsccs.b2c.plat.buyer.model.Discount;
import com.gsccs.b2c.plat.buyer.model.DiscountExample;
import com.gsccs.b2c.plat.shop.dao.ProductMapper;
import com.gsccs.b2c.plat.shop.dao.SkuMapper;
import com.gsccs.b2c.plat.shop.dao.SkuSpecMapper;
import com.gsccs.b2c.plat.shop.model.ProductExample;
import com.gsccs.b2c.plat.shop.model.SkuExample;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.goods.SkuSpec;

/**
 * 商品服务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private SkuSpecMapper skuSpecMapper;
	@Autowired
	private GradeMapper buyerLevelTMapper;
	@Autowired
	private DiscountMapper buyerDisTMapper;

	@Override
	public Long addProduct(Long sid, Product p) {
		if (null != p) {
			int salenum = p.getSalenum() == null ? 0 : p.getSalenum();
			int storenum = p.getStorenum() == null ? 0 : p.getStorenum();
			int evalnum = p.getEvalnum() == null ? 0 : p.getEvalnum();
			int locknum = p.getLocknum() == null ? 0 : p.getLocknum();
			p.setSalenum(salenum);
			p.setStorenum(storenum);
			p.setEvalnum(evalnum);
			p.setLocknum(locknum);
			// productMapper.insert(sid, p);
			Long productid = p.getId();

			// 保存SKU

			// 保存Sku规格特征

			return productid;
		}
		return null;
	}

	@Override
	public List<Sku> getSkuList(Long productid) {
		if (null == productid) {
			return null;
		}
		SkuExample example = new SkuExample();
		SkuExample.Criteria c = example.createCriteria();
		c.andProductidEqualTo(productid);
		return skuMapper.selectByExample(example);
	}

	public void proSearchParam(Sku p, SkuExample.Criteria criteria) {
		if (p != null) {
			if (p.getId() != null) {
				criteria.andIdEqualTo(p.getId());
			}

			if (null != p.getProductid()) {
				criteria.andProductidEqualTo(p.getProductid());
			}
		}
	}

	/**
	 * 处理查询条件
	 * 
	 * @param Product
	 * @param criteria
	 */
	public void proSearchParam(Product param, ProductExample.Criteria c) {
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

			/*
			 * if (null != maxPrice) { c.andPriceLessThanOrEqualTo(maxPrice); }
			 * 
			 * if (null != minPrice) { c.andPriceGreaterThanOrEqualTo(minPrice);
			 * }
			 * 
			 * if (null != maxSaleNum) {
			 * c.andSalenumLessThanOrEqualTo(maxSaleNum); }
			 * 
			 * if (null != minSaleNum) {
			 * c.andSalenumGreaterThanOrEqualTo(minSaleNum); }
			 * 
			 * if (null != maxStoreNum) {
			 * c.andStorenumLessThanOrEqualTo(maxStoreNum); }
			 * 
			 * if (null != minStoreNum) {
			 * c.andStorenumGreaterThanOrEqualTo(minStoreNum); }
			 */

		}
	}

	@Override
	public Product getProduct(Long sid, Long pid, boolean extra) {
		Product pt = productMapper.selectByPrimaryKey(sid, pid);
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
	public void editProductStatus(Long sid, Long productId, String status) {
		Product pt = null;
		if (null != sid && null != productId && null != status) {
			pt = productMapper.selectByPrimaryKey(sid, productId);
			pt.setStatus(status);
			productMapper.updateByPrimaryKey(sid, pt);
		}

	}

	@Override
	public void delProduct(Long sid, Long pId) {
		if (null != sid && null != pId) {
			productMapper.deleteByPrimaryKey(sid, pId);
		}
	}

	@Override
	public void editProduct(Long sid, Product pt) {
		productMapper.updateByPrimaryKey(sid, pt);
	}

	@Override
	public void editGoods(Long sid, Sku goodsT) {
		skuMapper.updateByPrimaryKey(sid, goodsT);
	}

	@Override
	public List<Product> getHotProducts(Long sid) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
		c.andIshotEqualTo("1");
		return productMapper.selectByExample(sid, example);
	}

	@Override
	public List<Product> getTopProducts(Long sid) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
		c.andIstopEqualTo("1");
		return productMapper.selectByExample(sid, example);
	}

	@Override
	public void productUnsale(Long sid) {
		productMapper.updateProductUnsale(sid, 0);
	}

	@Override
	public List<Product> getProducts(Product param, String order, int currPage,
			int pageSize) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return productMapper.selectPageByExample(example);
	}

	@Override
	public Long addProduct(Product p, List<Sku> skulist) {
		Long productid = null;
		// 保存产品基础信息
		productMapper.insert(p);
		productid = p.getId();
		// 保存产品SKU信息
		addSkuList(productid, skulist);
		return productid;
	}

	@Override
	public Long[] addSkuList(Long productid, List<Sku> skulist) {
		if (null != skulist && skulist.size() > 0) {
			Long[] ids = new Long[skulist.size()];
			int i = 0;
			for (Sku sku : skulist) {
				sku.setProductid(productid);
				skuMapper.insert(sku);
				ids[i] = sku.getId();

				// 保存SKU规格特征
				saveSkuSpec(productid, sku);
				i++;
			}
			return ids;
		}
		return null;
	}

	private void saveSkuSpec(Long productid, Sku sku) {
		if (null != productid && null != sku) {
			String specids = sku.getSpecIds();
			String specvarids = sku.getSpecValIds();
			if (StringUtils.isNotEmpty(specids)
					&& StringUtils.isNotEmpty(specvarids)) {
				String[] specidArray = specids.split(",");
				String[] specvalidArray = specvarids.split(",");
				for (int i = 0; i < specidArray.length; i++) {
					SkuSpec skuSpec = new SkuSpec();
					skuSpec.setSkuid(sku.getId());
					skuSpec.setProductid(productid);
					skuSpec.setSpecid(Long.valueOf(specidArray[i]));
					skuSpec.setSpecvalid(Long.valueOf(specvalidArray[i]));
					skuSpecMapper.insert(skuSpec);
				}
			}
		}
	}

}
