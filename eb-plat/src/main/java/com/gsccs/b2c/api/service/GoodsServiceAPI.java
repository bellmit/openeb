package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.ItemImg;
import com.gsccs.b2c.api.domain.Sku;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.model.ProductImgT;
import com.gsccs.b2c.plat.shop.model.ProductT;
import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.ProductImgService;
import com.gsccs.eb.api.domain.buyer.Discount;
import com.gsccs.eb.api.domain.goods.Attach;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.ProductParam;
import com.gsccs.eb.api.domain.goods.ProductProp;
import com.gsccs.eb.api.domain.goods.ProductReqInfo;

/**
 * 商品服务
 * 
 * @author x.d zhang
 * 
 */
public class GoodsServiceAPI implements GoodsServiceI {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private ProductImgService pimgService;

	@Override
	public void addSKU(Long sid, Long pid, List<Sku> items) throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		if (null != items && items.size() > 0) {
			List<GoodsT> goodsList = new ArrayList<GoodsT>();
			for (Sku g : items) {
				GoodsT gt = new GoodsT();
				gt.setPid(pid);
				gt.setPrice(g.getPrice());
				gt.setMkprice(g.getMkprice());
				gt.setBarcode(g.getBarcode());
				gt.setStorenum(g.getStorenum() == null ? 0 : g.getStorenum());
				gt.setLocknum(g.getLocknum() == null ? 0 : g.getLocknum());
				gt.setSalenum(g.getSalenum() == null ? 0 : g.getSalenum());
				gt.setSpecids(g.getSpecIds());
				gt.setSpecstr(g.getSpecStr());
				goodsList.add(gt);
			}
			goodsService.addGoodsList(sid, goodsList);
		}
	}

	@Override
	public Product getProduct(Long sid, Long pid) throws ApiException {

		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		ProductT pt = goodsService.getProduct(sid, pid, true);
		if (null != pt) {
			Product p = new Product();
			p.setId(pt.getId());
			p.setpId(pt.getId());
			p.setTitle(pt.getTitle());
			p.setPrice(pt.getPrice());
			p.setCateId(pt.getCate());
			p.setBrand(pt.getBrand());
			p.setPostage(pt.getPostage());
			p.setMarketPrice(pt.getMktprice());
			p.setTypeId(pt.getTypeid());
			p.setPicUrl(pt.getImg());
			p.setCreated(pt.getAddtime());
			p.setBrief(pt.getBrief());
			p.setBarcode(pt.getBarcode());
			p.setStorenum(pt.getStorenum());
			return p;
		}
		return null;
	}

	@Override
	public List<Product> getProducts(Long sid, String title, String barcode,
			String cateId, Double maxPrice, Double minPrice,
			Integer maxSaleNum, Integer minSaleNum, Integer maxStoreNum,
			Integer minStoreNum, String status, String order, int currPage,
			int pageSize) throws ApiException {

		List<Product> list = null;
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		List<ProductT> ptList = goodsService.getProducts(sid, title, barcode,
				null, maxPrice, minPrice, maxSaleNum, minSaleNum, maxStoreNum,
				minStoreNum, status, order, currPage, pageSize, true);

		if (null != ptList && ptList.size() > 0) {
			list = new ArrayList<Product>();
			for (ProductT pt : ptList) {
				Product p = new Product();

				try {
					// 商品Id
					BeanUtils.copyProperties(p, pt);
					p.setpId(pt.getId());
					// 商品图片
					p.setPicUrl(pt.getImg());
					// 发布时间
					p.setCreated(pt.getAddtime());
					p.setSaleNum(pt.getSalenum());
					p.setTypeId(pt.getTypeid());
					p.setCateId(pt.getCate());
					p.setTsc(pt.getBarcode());
					list.add(p);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}
		return list;
	}

	@Override
	public Long addProduct(Long sid, Product p) throws ApiException {

		if (null == sid || null == p) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		ProductT pt = new ProductT();
		pt.setSite(p.getSite());
		pt.setTitle(p.getTitle());
		pt.setBarcode(p.getBarcode());
		pt.setPrice(p.getPrice());
		pt.setBrief(p.getBrief());
		pt.setWeight(0.0);
		pt.setCate(p.getCateId());
		pt.setBrand(p.getBrand());
		pt.setAddtime(new Date());
		pt.setPostage(p.getPostage());
		pt.setTypeid(p.getTypeId());
		pt.setStatus(p.getStatus());
		pt.setBarcode(p.getTsc());
		pt.setMktprice(p.getMarketPrice());
		pt.setStorenum(p.getStorenum());
		// 产品扩展属性
		String propStr = "";
		List<ProductProp> props = p.getProps();
		if (null != props && props.size() > 0) {
			for (ProductProp prop : props) {
				propStr = propStr + prop.getPropStr() + ";";
			}
		}
		pt.setPropStr(propStr);
		// 产品参数属性
		String paramStr = "";
		List<ProductParam> params = p.getParams();
		if (null != params && params.size() > 0) {
			for (ProductParam param : params) {
				paramStr = paramStr + param.getParamStr() + ";";
			}
		}

		// 购物必填信息
		String reqInfoStr = "";
		List<ProductReqInfo> reqInfos = p.getReqInfos();
		if (null != reqInfos && reqInfos.size() > 0) {
			for (ProductReqInfo reqInfo : reqInfos) {
				reqInfoStr = reqInfoStr + reqInfo.getReqInfoStr();
			}
		}
		return goodsService.addProduct(sid, pt);
	}

	@Override
	public Attach uploadProductImg(Long productid, byte[] img,
			int position, boolean is_major) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemImg uploadItemImg(Long num_iid, byte[] image, int position,
			boolean is_major) {
		return null;
	}

	@Override
	public List<Sku> getSkuList(Long sid, Long pid, int currPage, int pageSize)
			throws ApiException {

		List<Sku> list = null;
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		List<GoodsT> goodsList = goodsService.getGoods(sid, pid, currPage,
				pageSize);
		if (null != goodsList && goodsList.size() > 0) {
			list = new ArrayList<Sku>();
			for (GoodsT t : goodsList) {
				Sku sku = new Sku();
				sku.setSkuId(t.getId());
				sku.setProductId(t.getPid());
				sku.setBarcode(t.getBarcode());
				sku.setPrice(t.getPrice());
				sku.setMkprice(t.getMkprice());
				sku.setStorenum(t.getStorenum());
				sku.setSalenum(t.getSalenum());
				sku.setLocknum(t.getLocknum());
				sku.setSpecIds(t.getSpecids());
				sku.setSpecStr(t.getSpecstr());
				list.add(sku);
			}
		}
		return list;
	}

	@Override
	public Long[] addBuyerDiscount(Long sid, Long productId, Long goodsid,
			List<Discount> dislist) throws ApiException {
		List<Sku> list = null;
		if (null == sid || null == productId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		return null;
	}

	@Override
	public List<Discount> getBuyerDiscounts(Long sid, Long productId,
			Long goodsid) throws ApiException {
		// goodsService.getProduct(sid, pid, extra)
		return null;
	}

	@Override
	public Sku getSKU(Long sid, Long pid, Long skuid) throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		GoodsT t = goodsService.getGoods(sid, skuid);

		if (null != t) {
			Sku sku = new Sku();
			sku.setProductId(t.getPid());
			sku.setSkuId(t.getId());
			sku.setBarcode(t.getBarcode());
			sku.setPrice(t.getPrice());
			sku.setMkprice(t.getMkprice());
			sku.setStorenum(t.getStorenum());
			sku.setSalenum(t.getSalenum());
			sku.setLocknum(t.getLocknum());
			sku.setSpecIds(t.getSpecids());
			sku.setSpecStr(t.getSpecstr());
			return sku;
		}
		return null;
	}

	@Override
	public int getProductCount(Long sid, String title, String barcode,
			Long cateId, Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum, Integer maxStoreNum, Integer minStoreNum,
			String status) throws ApiException {

		int count = goodsService.count(sid, title, barcode, cateId, maxPrice,
				minPrice, maxSaleNum, minSaleNum, maxStoreNum, minStoreNum,
				status);
		return count;
	}

	@Override
	public void editProductStatus(Long sid, String ids, String status)
			throws ApiException {
		String[] pids = ids.split(",");
		if (pids != null) {
			for (String s : pids) {
				Long pid = Long.valueOf(s);
				goodsService.editProductStatus(sid, pid, status);
			}
		}
	}

	@Override
	public void delProduct(Long sid, String ids) throws ApiException {
		String[] pids = ids.split(",");
		if (pids != null) {
			for (String s : pids) {
				Long pid = Long.valueOf(s);
				goodsService.delProduct(sid, pid);
			}
		}
	}

	@Override
	public void editProduct(Long sid, Product product) throws ApiException {
		ProductT pt = goodsService.getProduct(sid, product.getpId(), true);

		try {
			BeanUtils.copyProperties(pt, product);
			pt.setCate(product.getCateId());
			pt.setImg(product.getPicUrl());
			goodsService.editProduct(sid, pt);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editSKU(Long sid, Long pid, List<Sku> items)
			throws ApiException {

		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		if (null != items && items.size() > 0) {
			List<GoodsT> goodsList = new ArrayList<GoodsT>();
			GoodsT gt;
			for (Sku g : items) {
				// GoodsT gt = new GoodsT();
				gt = goodsService.getGoods(sid, g.getSkuId());
				gt.setPid(pid);
				gt.setPrice(g.getPrice());
				gt.setMkprice(g.getMkprice());
				gt.setBarcode(g.getBarcode());
				gt.setStorenum(g.getStorenum() == null ? 0 : g.getStorenum());
				gt.setLocknum(g.getLocknum() == null ? 0 : g.getLocknum());
				gt.setSalenum(g.getSalenum() == null ? 0 : g.getSalenum());
				gt.setSpecids(g.getSpecIds());
				gt.setSpecstr(g.getSpecStr());
				goodsService.editGoods(sid, gt);

			}
		}
	}

	@Override
	public List<Product> getHotProducts(Long sid) {
		List<Product> list = null;
		List<ProductT> ptList = goodsService.getHotProducts(sid);
		if (null != ptList) {
			list = new ArrayList<Product>();
			for (ProductT pt : ptList) {
				Product p = new Product();
				try {
					// 商品Id
					BeanUtils.copyProperties(p, pt);
					p.setpId(pt.getId());
					// 商品图片
					p.setPicUrl(pt.getImg());
					// 发布时间
					p.setCreated(pt.getAddtime());
					p.setSaleNum(pt.getSalenum());
					p.setTsc(pt.getBarcode());
					p.setIsTop(true);
					list.add(p);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<Product> getTopProducts(Long sid) {
		List<Product> list = null;
		List<ProductT> ptList = goodsService.getTopProducts(sid);
		if (null != ptList) {
			list = new ArrayList<Product>();
			for (ProductT pt : ptList) {
				Product p = new Product();
				try {
					// 商品Id
					BeanUtils.copyProperties(p, pt);
					p.setpId(pt.getId());
					// 商品图片
					p.setPicUrl(pt.getImg());
					// 发布时间
					p.setCreated(pt.getAddtime());
					p.setSaleNum(pt.getSalenum());
					p.setTsc(pt.getBarcode());
					p.setIsTop(true);
					list.add(p);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public void editProductById(Long sid, Long pid, String imgpath)
			throws ApiException {
		ProductT pt = goodsService.getProduct(sid, pid, true);
		pt.setImg(imgpath);
		goodsService.editProduct(sid, pt);

	}

	@Override
	public void editProductPrice(Long sid, Long pid, String price)
			throws ApiException {
		ProductT pt = goodsService.getProduct(sid, pid, true);
		pt.setPrice(Double.parseDouble(price));
		goodsService.editProduct(sid, pt);
	}

	@Override
	public List<Attach> getProductByPid(Long sid, Long pid)
			throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		List<Attach> list = null;
		List<ProductImgT> ptmList = pimgService.getImgByPid(sid, pid);

		if (null != ptmList && ptmList.size() > 0) {
			list = new ArrayList<Attach>();
			for (ProductImgT pit : ptmList) {
				Attach p = new Attach();
				try {
					// 商品Id
					BeanUtils.copyProperties(p, pit);
					list.add(p);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}
		return list;
	}

	@Override
	public void addPImg(Long sid, Long pid, List<Attach> pimgs)
			throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		if (null != pimgs && pimgs.size() > 0) {
			List<ProductImgT> pimgts = new ArrayList<ProductImgT>();
			for (Attach pimg : pimgs) {
				ProductImgT gt = new ProductImgT();
				try {
					BeanUtils.copyProperties(gt, pimg);
					gt.setProductid(pimg.getProductId());
					pimgts.add(gt);

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			pimgService.addListImg(sid, pimgts);
		}
	}

}
