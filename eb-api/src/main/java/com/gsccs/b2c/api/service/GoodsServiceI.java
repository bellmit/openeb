package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.buyer.Discount;
import com.gsccs.eb.api.domain.goods.Album;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.goods.ItemImg;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 商品API 提供了商品以及商品相关的sku，邮费增加，修改功能
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface GoodsServiceI {

	/**
	 * 查看一个产品详细信息: 传入product_id来查询 传入cid和props来查询
	 */
	public Goods getGoods(Long sid, Long pid) throws ApiException;

	public List<Goods> getHotGoodss(Long sid);

	public List<Goods> getTopGoodss(Long sid);

	public Sku getSku(Long sid, Long pid, Long skuid);

	/**
	 * 查询商品列表
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public List<Sku> getSkuList(Long sid, Long pid, int currPage, int pageSize)
			throws ApiException;

	/**
	 * 添加产品
	 * 
	 * @param p
	 * @return 商品结构
	 */
	public Long addGoods(Goods p, List<Sku> skuList) throws ApiException;

	/**
	 * 上传单张产品非主图，如果需要传多张，可调多次
	 * 
	 * @param productid
	 *            产品ID
	 * @param img
	 *            图片内容.图片最大为500K
	 * @param position
	 *            图片序号
	 * @param is_major
	 *            是否将该图片设为主图.可选值:true,false;默认值:false.
	 * @return 产品图片结构
	 */
	public Album uploadGoodsImg(Long productid, byte[] img, int position,
			boolean is_major);

	/**
	 * 添加一张商品图片到num_iid指定的商品中
	 * 
	 * @param num_iid
	 * @param image
	 * @param position
	 * @param is_major
	 * @return
	 */
	public ItemImg uploadItemImg(Long num_iid, byte[] image, int position,
			boolean is_major);

	/**
	 * 查询商品会员折扣
	 * 
	 * @param sid
	 * @param productId
	 * @param goodsid
	 * @return
	 * @throws ApiException
	 */
	public List<Discount> getBuyerDiscounts(Long sid, Long productId,
			Long goodsid) throws ApiException;

	/**
	 * 新增商品会员折扣信息
	 * 
	 * @param sid
	 *            店铺ID
	 * @param productId
	 *            产品ID
	 * @param goodsid
	 *            商品ID
	 * @param dislist
	 *            折扣列表
	 * @return
	 */
	public Long[] addBuyerDiscount(Long sid, Long productId, Long goodsid,
			List<Discount> dislist) throws ApiException;

	/**
	 * 修改产品状态
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void editGoodsStatus(Long sid, String ids, String status)
			throws ApiException;

	public void editGoods(Long sid, Goods product) throws ApiException;

	public void editGoodsById(Long sid, Long pid, String imgpath)
			throws ApiException;

	/**
	 * 删除产品
	 * 
	 * @param sid
	 * @param ids
	 * @throws ApiException
	 */
	public void delGoods(Long sid, String ids) throws ApiException;

	public void editGoodsPrice(Long sid, Long pid, String price)
			throws ApiException;

	public List<Album> getGoodsByPid(Long sid, Long pid) throws ApiException;

	public void addPImg(Long sid, Long pid, List<Album> pimg)
			throws ApiException;

}
