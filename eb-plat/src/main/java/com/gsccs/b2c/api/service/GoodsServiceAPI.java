package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.b2c.plat.shop.service.AlbumService;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.eb.api.domain.buyer.Discount;
import com.gsccs.eb.api.domain.goods.Album;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.goods.ItemImg;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.exception.ApiException;

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
	private ShopService shopService;
	@Autowired
	private AlbumService albumService;

	@Override
	public Goods getGoods(Long sid, Long pid) throws ApiException {

		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = shopService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		Goods pt = goodsService.getGoods(pid);
		return pt;
	}

	@Override
	public Long addGoods(Goods param, List<Sku> skuList) throws ApiException {

		if (null == param) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		return goodsService.addGoods(param, skuList);
	}

	@Override
	public Album uploadGoodsImg(Long productid, byte[] img, int position,
			boolean is_major) {
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

		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		Shop store = shopService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		return goodsService.findSkuList(pid);
	}

	@Override
	public Long[] addBuyerDiscount(Long sid, Long productId, Long goodsid,
			List<Discount> dislist) throws ApiException {
		List<Sku> list = null;
		if (null == sid || null == productId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		Shop store = shopService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		return null;
	}

	@Override
	public List<Discount> getBuyerDiscounts(Long sid, Long productId,
			Long goodsid) throws ApiException {
		// goodsService.getGoods(sid, pid, extra)
		return null;
	}

	@Override
	public void editGoodsStatus(Long sid, String ids, String status)
			throws ApiException {
		String[] pids = ids.split(",");
		if (pids != null) {
			for (String s : pids) {
				Long pid = Long.valueOf(s);
				goodsService.editGoodsStatus(sid, pid, status);
			}
		}
	}

	@Override
	public void delGoods(Long sid, String ids) throws ApiException {
		String[] pids = ids.split(",");
		if (pids != null) {
			for (String s : pids) {
				Long pid = Long.valueOf(s);
				goodsService.delGoods(sid, pid);
			}
		}
	}

	@Override
	public void editGoods(Long sid, Goods product) throws ApiException {
		goodsService.editGoods(sid, product);
	}

	@Override
	public List<Goods> getHotGoodss(Long sid) {
		List<Goods> list = goodsService.getHotGoodss(sid);
		return list;
	}

	@Override
	public List<Goods> getTopGoodss(Long sid) {
		List<Goods> list = goodsService.getTopGoodss(sid);
		return list;
	}

	@Override
	public void editGoodsById(Long sid, Long pid, String imgpath)
			throws ApiException {
		Goods pt = goodsService.getGoods(pid);
		pt.setMainimg(imgpath);
		goodsService.editGoods(sid, pt);

	}

	@Override
	public void editGoodsPrice(Long sid, Long pid, String price)
			throws ApiException {
		Goods pt = goodsService.getGoods(pid);
		pt.setPrice(Double.parseDouble(price));
		goodsService.editGoods(sid, pt);
	}

	@Override
	public List<Album> getGoodsByPid(Long sid, Long pid) throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = shopService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		List<Album> list = albumService.getImgByPid(sid, pid);
		return list;
	}

	@Override
	public void addPImg(Long sid, Long pid, List<Album> pimgs)
			throws ApiException {
		if (null == sid || null == pid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = shopService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}

		if (null != pimgs && pimgs.size() > 0) {
			albumService.addListImg(sid, pimgs);
		}
	}

	@Override
	public Sku getSku(Long sid, Long pid, Long skuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
