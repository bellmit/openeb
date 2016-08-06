package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.buyer.model.Discount;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.goods.Sku;

public interface GoodsService {

	/**
	 * 添加产品
	 * 
	 * @param p
	 * @return
	 */
	public Long addGoods(Goods goods, List<Sku> skulist);

	/**
	 * 获得产品
	 * 
	 * @param pid
	 * @return
	 */
	public Goods getGoods(Long id);

	/**
	 * 查询热销商品
	 * 
	 * @param sid
	 * @return
	 */
	public List<Goods> getHotGoodss(Long shopid);

	/**
	 * 查询置顶商品
	 * 
	 * @param sid
	 * @return
	 */
	public List<Goods> getTopGoodss(Long shopid);

	public List<Goods> getGoodss(Goods param, String order, int currPage,
			int pageSize);

	/**
	 * 获取SKU
	 * 
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public List<Sku> getSkuList(Long goodsid);

	int count(Long sid, Long pid);

	/**
	 * 增加商品根据会员等级的折扣价格
	 * 
	 * @param sid
	 * @param dislist
	 * @return
	 */
	public Long[] addBuyerPrice(Long sid, Long productId, Long goodsid,
			List<Discount> dislist);

	/**
	 * 查询商品的会员等级的折扣价格
	 * 
	 * @param sid
	 * @param productId
	 * @return
	 */
	public List<Discount> getBuyerPrice(Long sid, Long productId, Long goodsid);

	/**
	 * 修改产品状态
	 * 
	 * @param sid
	 * @param productId
	 * @param status
	 */
	public void editGoodsStatus(Long sid, Long productId, String status);

	/**
	 * 删除产品
	 * 
	 * @param sid
	 * @param pId
	 */
	public void delGoods(Long sid, Long pId);

	/**
	 * 编辑产品
	 * 
	 * @param sid
	 * @param pt
	 */
	public void editGoods(Long sid, Goods pt);

	/**
	 * 编辑商品
	 * 
	 * @param sid
	 * @param goods
	 */
	public void editGoods(Long sid, Sku goodsT);

	/**
	 * 商品自动下架
	 * 
	 * @param sid
	 */
	public void productUnsale(Long sid);

}
