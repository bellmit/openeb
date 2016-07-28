package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.BuyerDisT;
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.eb.api.domain.goods.Product;

public interface GoodsService {

	/**
	 * 添加产品
	 * 
	 * @param p
	 * @return
	 */
	public Long addProduct(Long sid, Product p);

	/**
	 * 添加商品
	 * 
	 * @param g
	 * @return
	 */
	public Long addGoods(Long sid, GoodsT g);

	/**
	 * 批量添加商品
	 * 
	 * @param gtlist
	 * @return
	 */
	public Long[] addGoodsList(Long sid, List<GoodsT> gtlist);

	/**
	 * 获得产品
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public Product getProduct(Long sid, Long pid, boolean extra);

	public List<Product> getProduct(Long sid);

	/**
	 * 查询热销商品
	 * 
	 * @param sid
	 * @return
	 */
	public List<Product> getHotProducts(Long sid);

	/**
	 * 查询置顶商品
	 * 
	 * @param sid
	 * @return
	 */
	public List<Product> getTopProducts(Long sid);

	/**
	 * 获得商品
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public GoodsT getGoods(Long sid, Long goodsId);

	/**
	 * 根据条件查询产品
	 * 
	 * @param sid
	 *            站点ID
	 * @param title
	 *            商品标题
	 * @param barcode
	 *            商品编码
	 * @param cateId
	 *            商品类目
	 * @param maxPrice
	 *            最大价格
	 * @param minPrice
	 *            最小价格
	 * @param maxSaleNum
	 *            最大销售数量
	 * @param minSaleNum
	 *            最小销售数量
	 * @param maxStoreNum
	 *            最大库存数
	 * @param minStoreNum
	 *            最小库存数
	 * @param order
	 *            排序字段
	 * @param state
	 *            产品状态
	 * @param currPage
	 * @param pageSize
	 * @param iscache
	 * @return
	 */
	public List<Product> getProducts(Long sid, String title, String barcode,
			Long cateId, Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum, Integer maxStoreNum, Integer minStoreNum,
			String state, String order, int currPage, int pageSize,
			boolean iscache);

	/**
	 * 根据条件统计产品总数
	 * 
	 * @param sid
	 * @param title
	 * @param barcode
	 * @param cateId
	 * @param maxPrice
	 * @param minPrice
	 * @param maxSaleNum
	 * @param minSaleNum
	 * @param maxStoreNum
	 * @param minStoreNum
	 * @param state
	 *            产品状态
	 * @return
	 */
	public int count(Long sid, String title, String barcode, Long cateId,
			Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum, Integer maxStoreNum, Integer minStoreNum,
			String state);

	public List<Product> getProducts(Product param, String order, int currPage,
			int pageSize);

	/**
	 * 获取产品对应的货品
	 * 
	 * @param pid
	 *            产品ID
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<GoodsT> getGoods(Long sid, Long pid, int currPage, int pageSize);

	/**
	 * 获取产品对应的货品
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public List<GoodsT> getGoodsbyPid(Long sid, Long pid);

	int count(Long sid, Long pid);

	/**
	 * 增加商品根据会员等级的折扣价格
	 * 
	 * @param sid
	 * @param dislist
	 * @return
	 */
	public Long[] addBuyerPrice(Long sid, Long productId, Long goodsid,
			List<BuyerDisT> dislist);

	/**
	 * 查询商品的会员等级的折扣价格
	 * 
	 * @param sid
	 * @param productId
	 * @return
	 */
	public List<BuyerDisT> getBuyerPrice(Long sid, Long productId, Long goodsid);

	/**
	 * 修改产品状态
	 * 
	 * @param sid
	 * @param productId
	 * @param status
	 */
	public void editProductStatus(Long sid, Long productId, String status);

	/**
	 * 删除产品
	 * 
	 * @param sid
	 * @param pId
	 */
	public void delProduct(Long sid, Long pId);

	/**
	 * 编辑产品
	 * 
	 * @param sid
	 * @param pt
	 */
	public void editProduct(Long sid, Product pt);

	/**
	 * 编辑商品
	 * 
	 * @param sid
	 * @param goods
	 */
	public void editGoods(Long sid, GoodsT goodsT);

	/**
	 * 商品自动下架
	 * 
	 * @param sid
	 */
	public void productUnsale(Long sid);

}
