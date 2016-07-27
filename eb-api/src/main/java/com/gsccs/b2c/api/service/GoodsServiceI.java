package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.buyer.Discount;
import com.gsccs.eb.api.domain.goods.Album;
import com.gsccs.eb.api.domain.goods.ItemImg;
import com.gsccs.eb.api.domain.goods.Product;
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
	public Product getProduct(Long sid, Long pid) throws ApiException;

	public List<Product> getHotProducts(Long sid);
	public List<Product> getTopProducts(Long sid);
	
	
	
	
	
	/**
	 * 查询产品列表
	 * 
	 * @return
	 */
	public List<Product> getProducts(Long sid, String title, String barcode,
			String cateId, Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum,Integer maxStoreNum,Integer minStoreNum,String status, String order, int currPage, int pageSize)
			throws ApiException;
	
	
	public int getProductCount(Long sid, String title, String barcode,
			Long cateId, Double maxPrice, Double minPrice, Integer maxSaleNum,
			Integer minSaleNum,Integer maxStoreNum,Integer minStoreNum,String status) throws ApiException;
	
	/**
	 * 查询商品列表
	 * @param sid
	 * @param pid
	 * @return
	 */
	public List<Sku> getSkuList(Long sid, Long pid,int currPage, int pageSize) throws ApiException;
	

	/**
	 * 添加产品
	 * 
	 * @param p
	 * @return 商品结构
	 */
	public Long addProduct(Long sid, Product p) throws ApiException;

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
	public Album uploadProductImg(Long productid, byte[] img,
			int position, boolean is_major);

	/**
	 * 新增一个商品.商品的价格要位于sku的价格区间之中（例如，sku价格有5元、10元两种，那么商品的价格就需要大于等于5元，小于等于10元，
	 * 否则新增商品会失败） 商品的类目和商品的价格、sku的价格都有一定的相关性（具体的关系要通过类目属性查询接口获得）
	 * 商品的运费承担方式和邮费设置有相关性，卖家承担运费不用设置邮费，买家承担运费需要设置邮费
	 * 
	 * @return
	 */
	public void addSKU(Long sid, Long pid, List<Sku> items) throws ApiException;
	
	/**
	 * 编辑sku
	 * @param sid
	 * @param pid
	 * @param items
	 * @throws ApiException
	 */
	public void editSKU(Long sid, Long pid, List<Sku> items) throws ApiException;
	/**
	 * 获取SKU
	 * @param sid
	 * @param pid
	 * @param skuid
	 * @return
	 * @throws ApiException
	 */
	public Sku getSKU(Long sid, Long pid, Long skuid) throws ApiException;

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
	 * @param sid
	 * @param productId
	 * @param goodsid
	 * @return
	 * @throws ApiException
	 */
	public List<Discount> getBuyerDiscounts(Long sid,Long productId,Long goodsid) throws ApiException;
	
	/**
	 * 新增商品会员折扣信息
	 * @param sid        店铺ID
	 * @param productId  产品ID
	 * @param goodsid    商品ID
	 * @param dislist    折扣列表
	 * @return
	 */
	public Long[] addBuyerDiscount(Long sid,Long productId,Long goodsid,List<Discount> dislist) throws ApiException;
	
	/**
	 * 修改产品状态
	 * @param ids
	 * @throws ApiException
	 */
	public void editProductStatus(Long sid,String ids,String status) throws ApiException;
	
	
	public void editProduct(Long sid,Product product) throws ApiException;
	
	public void editProductById(Long sid,Long pid,String imgpath) throws ApiException;

	/**
	 * 删除产品
	 * @param sid
	 * @param ids
	 * @throws ApiException
	 */
	public void delProduct(Long sid,String ids) throws ApiException;
	
	public void editProductPrice(Long sid,Long pid,String price) throws ApiException;

	public List<Album> getProductByPid(Long sid, Long pid) throws ApiException;
	
	public void addPImg(Long sid, Long pid, List<Album> pimg) throws ApiException;
	

}
