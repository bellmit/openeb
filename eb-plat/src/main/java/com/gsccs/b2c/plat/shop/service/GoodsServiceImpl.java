package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.BuyerDisTMapper;
import com.gsccs.b2c.plat.shop.dao.BuyerLevelTMapper;
import com.gsccs.b2c.plat.shop.dao.GoodsTMapper;
import com.gsccs.b2c.plat.shop.dao.ProductExtraMapper;
import com.gsccs.b2c.plat.shop.dao.ProductMapper;
import com.gsccs.b2c.plat.shop.model.BuyerDisT;
import com.gsccs.b2c.plat.shop.model.BuyerDisTExample;
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.model.GoodsTExample;
import com.gsccs.b2c.plat.shop.model.ProductExample;
import com.gsccs.b2c.plat.shop.model.ProductExtra;
import com.gsccs.eb.api.domain.goods.Product;

/**
 * 商品服务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private GoodsTMapper goodsTMapper;
	@Autowired
	private ProductExtraMapper productExtraMapper;
	@Autowired
	private BuyerLevelTMapper buyerLevelTMapper;
	@Autowired
	private BuyerDisTMapper buyerDisTMapper;

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
			productMapper.insert(sid, p);
			if (StringUtils.isNotEmpty(p.getParamStr())
					|| StringUtils.isNotEmpty(p.getPropStr())
					|| StringUtils.isNotEmpty(p.getReqInfoStr())) {
				ProductExtra extra = new ProductExtra();
				extra.setId(p.getId());
				extra.setPropsstr(p.getPropStr());
				extra.setParamsstr(p.getParamStr());
				extra.setReqinfostr(p.getReqInfoStr());
				productExtraMapper.insert(extra);
			}
			return p.getId();
		}
		return null;
	}

	@Override
	public Long addGoods(Long sid, GoodsT g) {
		if (null != g) {
			goodsTMapper.insert(sid, g);
			return g.getId();
		}
		return null;
	}

	@Override
	public List<GoodsT> getGoods(Long sid, Long productid, int currPage,
			int pageSize) {
		GoodsTExample example = new GoodsTExample();
		GoodsTExample.Criteria c = example.createCriteria();
		c.andPidEqualTo(productid);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return goodsTMapper.selectPageByExample(sid, example);
	}

	public void proSearchParam(GoodsT p, GoodsTExample.Criteria criteria) {
		if (p != null) {
			if (p.getId() != null) {
				criteria.andIdEqualTo(p.getId());
			}

			if (null != p.getPid()) {
				criteria.andPidEqualTo(p.getPid());
			}
		}
	}

	/**
	 * 处理查询条件
	 * 
	 * @param Product
	 * @param criteria
	 */
	public void proSearchParam(Product p, ProductExample.Criteria criteria) {
		if (p != null) {
			if (p.getId() != null) {
				criteria.andIdEqualTo(p.getId());
			}

			if (StringUtils.isNotEmpty(p.getTitle())) {
				criteria.andTitleLike("'%" + p.getTitle() + "%'");
			}

			if (StringUtils.isNotEmpty(p.getStatus())) {
				criteria.andStatusEqualTo(p.getStatus());
			}
		}
	}

	@Override
	public Long[] addGoodsList(Long sid, List<GoodsT> gtlist) {
		if (null != gtlist && gtlist.size() > 0) {
			Long[] ids = new Long[gtlist.size()];
			int i = 0;
			for (GoodsT gt : gtlist) {
				goodsTMapper.insert(sid, gt);
				ids[i] = gt.getId();
				i++;
			}
			return ids;
		}
		return null;
	}

	@Override
	public Product getProduct(Long sid, Long pid, boolean extra) {
		Product pt = productMapper.selectByPrimaryKey(sid, pid);
		if (null != pt && extra) {
			ProductExtra pe = productExtraMapper.selectByPrimaryKey(pid);
			if (null != pe) {
				pt.setPropStr(pe.getPropsstr());
				pt.setParamStr(pe.getParamsstr());
				pt.setReqInfoStr(pe.getReqinfostr());
			}
		}
		return pt;
	}

	@Override
	public List<Product> getProducts(Long sid, String title, String barcode,
			Long cateId, Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum, Integer maxStoreNum, Integer minStoreNum,
			String status, String order, int currPage, int pageSize,
			boolean iscache) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(title)) {
			c.andTitleLike("%" + title.trim() + "%");
		}
		if (StringUtils.isNotEmpty(barcode)) {
			c.andBarcodeLike("%" + barcode.trim() + "%");
		}
		if (StringUtils.isNotEmpty(status)) {
			c.andStatusEqualTo(status);
		}
		if (null != maxPrice) {
			c.andPriceLessThanOrEqualTo(maxPrice);
		}

		if (null != minPrice) {
			c.andPriceGreaterThanOrEqualTo(minPrice);
		}

		if (null != maxSaleNum) {
			c.andSalenumLessThanOrEqualTo(maxSaleNum);
		}

		if (null != minSaleNum) {
			c.andSalenumGreaterThanOrEqualTo(minSaleNum);
		}

		if (null != maxStoreNum) {
			c.andStorenumLessThanOrEqualTo(maxStoreNum);
		}

		if (null != minStoreNum) {
			c.andStorenumGreaterThanOrEqualTo(minStoreNum);
		}
		example.setOrderByClause(order);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return productMapper.selectPageByExample(example);
	}

	@Override
	public int count(Long sid, String title, String barcode, Long cateId,
			Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum, Integer maxStoreNum, Integer minStoreNum,
			String status) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(title)) {
			c.andTitleLike("%" + title.trim() + "%");
		}
		if (StringUtils.isNotEmpty(barcode)) {
			c.andBarcodeLike("%" + barcode.trim() + "%");
		}
		if (StringUtils.isNotEmpty(status)) {
			c.andStatusEqualTo(status);
		}

		if (null != maxPrice) {
			c.andPriceLessThanOrEqualTo(maxPrice);
		}

		if (null != minPrice) {
			c.andPriceGreaterThanOrEqualTo(minPrice);
		}

		if (null != maxSaleNum) {
			c.andSalenumLessThanOrEqualTo(maxSaleNum);
		}

		if (null != minSaleNum) {
			c.andSalenumGreaterThanOrEqualTo(minSaleNum);
		}

		if (null != maxStoreNum) {
			c.andStorenumLessThanOrEqualTo(maxStoreNum);
		}

		if (null != minStoreNum) {
			c.andStorenumGreaterThanOrEqualTo(minStoreNum);
		}

		return productMapper.countByExample(sid, example);
	}

	@Override
	public int count(Long sid, Long pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long[] addBuyerPrice(Long sid, Long productId, Long goodsid,
			List<BuyerDisT> dislist) {
		if (null != sid && null != productId) {

		}
		return null;
	}

	@Override
	public List<BuyerDisT> getBuyerPrice(Long sid, Long productId, Long goodsid) {
		if (null != sid && null != productId) {
			BuyerDisTExample e = new BuyerDisTExample();
			BuyerDisTExample.Criteria c = e.createCriteria();
		}
		return null;
	}

	@Override
	public GoodsT getGoods(Long sid, Long id) {
		GoodsT goods = goodsTMapper.selectByPrimaryKey(sid, id);
		return goods;
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
	public List<GoodsT> getGoodsbyPid(Long sid, Long pid) {
		GoodsTExample example = new GoodsTExample();
		GoodsTExample.Criteria c = example.createCriteria();
		c.andPidEqualTo(pid);
		return goodsTMapper.selectByExample(sid, example);
	}

	@Override
	public void editProduct(Long sid, Product pt) {
		productMapper.updateByPrimaryKey(sid, pt);
	}

	@Override
	public void editGoods(Long sid, GoodsT goodsT) {
		goodsTMapper.updateByPrimaryKey(sid, goodsT);
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
	public List<Product> getProduct(Long sid) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria c = example.createCriteria();
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
		return productMapper.selectPageByExample(example);
	}

}
