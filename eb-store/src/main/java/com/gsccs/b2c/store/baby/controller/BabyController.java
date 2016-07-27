package com.gsccs.b2c.store.baby.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.b2c.api.domain.CateProp;
import com.gsccs.b2c.api.domain.CateSpec;
import com.gsccs.b2c.api.domain.Category;
import com.gsccs.b2c.api.domain.Datagrid;
import com.gsccs.b2c.api.domain.DeliverType;
import com.gsccs.b2c.api.domain.Product;
import com.gsccs.b2c.api.domain.ProductImg;
import com.gsccs.b2c.api.domain.ProductProp;
import com.gsccs.b2c.api.domain.Shop;
import com.gsccs.b2c.api.domain.Sku;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.BrandServiceI;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.LogistServiceI;
import com.gsccs.b2c.api.service.ShopServiceI;
import com.gsccs.b2c.api.service.TypeServiceI;
import com.gsccs.b2c.solr.service.GoodsSolr;
import com.gsccs.b2c.solr.service.GoodsSolrService;
import com.gsccs.b2c.solr.service.SolrService;
import com.gsccs.b2c.store.base.JsonMsg;
import com.gsccs.b2c.store.service.SsdbService;


@Controller
@RequestMapping("/product")
public class BabyController {

	@Autowired
	private CateServiceI cateServiceAPI;
	
	@Autowired
	private BrandServiceI brandServiceAPI;
	
	@Autowired
	private BuyerServiceI buyerServiceAPI;
	
	@Autowired
	private GoodsServiceI goodsServiceAPI;
	
	@Autowired
	private TypeServiceI typeServiceAPI;
	
	@Autowired
	private RedisTemplate ssdbTemplate;
	
	@Autowired
	private LogistServiceI logistServiceAPI;
	@Autowired 
	private ShopServiceI shopServiceAPI;
	
	@Autowired 
	private  GoodsSolrService goodsSolrService;
	
	@Autowired
	private SsdbService ssdbService;

	// 获取根类目
	@RequestMapping("/rootCates")
	@ResponseBody
	public JsonMsg getRootCates(HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();

		long siteId = (Long) request.getSession().getAttribute("siteId");
		try {
			JSONArray array = cateServiceAPI.getSiteCates(siteId);
			msg.setSuccess(true);
			msg.setData(array);
		} catch (ApiException e) {
			//e.printStackTrace();
			msg.setSuccess(false);
		}
		return msg;
	}
	
	// 根据父ID获取类目列表
	@RequestMapping("/getCates")
	@ResponseBody
	public JsonMsg getCates(HttpServletRequest request, Long parId) {
		JsonMsg msg = new JsonMsg();
		
		Long siteId = (Long) request.getSession().getAttribute("siteId");
		
		try {
			JSONArray array = cateServiceAPI.getStoreCates(siteId, parId);
			
			msg.setSuccess(true);
			msg.setData(array);
		} catch (ApiException e) {
			msg.setSuccess(false);
		}
		
		

		return msg;
	}
	
	// 获取品牌列表
	@RequestMapping("/getBrands")
	@ResponseBody
	public JsonMsg getBrands(HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		
		long siteId = (Long) request.getSession().getAttribute("siteId");
		
		List brans = null;
		try {
			brans = brandServiceAPI.getBrands(siteId, 1, 1000);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		msg.setSuccess(true);
		msg.setData(brans);

		return msg;
	}
	
	// 获取会员信息
	@RequestMapping("/getMember")
	@ResponseBody
	public JsonMsg getVips(HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		
		long siteId = (Long) request.getSession().getAttribute("siteId");
		
		List buyers = null;
		try {
			buyers = buyerServiceAPI.getBuyerLevels(siteId);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		msg.setSuccess(true);
		msg.setData(buyers);

		return msg;
	}
	
	// 关联商品图片
	@RequestMapping("/relateImg")
	public String relateImg(String path, Model model, String relateId) {
		model.addAttribute("relateId", relateId);
		return path;
	}
	
	// 关联商品图片
	@RequestMapping("/memberPrice")
	public String memberPrice(String path, Model model, String id) {
		model.addAttribute("typeId", id);
		return path;
	}
	
	// 获取规格
	@RequestMapping("/getSpecification")
	@ResponseBody
	public JsonMsg getSpecification(Long typeId) {
		JsonMsg msg = new JsonMsg();
		
		System.out.println("进入加载规格");
		
		List<CateSpec> cateSpecsEs = this.typeServiceAPI.getCateSpecs(typeId);
		
		msg.setData(cateSpecsEs);
		msg.setSuccess(true);
		msg.setMsg("成功加载规格!");
		
		return msg;
	}
	
	// 获取属性
	@RequestMapping("/getProps")
	@ResponseBody
	public JsonMsg getProps(Long typeId) {
		JsonMsg msg = new JsonMsg();
		List<CateProp>  propsList= this.typeServiceAPI.getCateProps(typeId);
		if(null !=propsList && propsList.size() > 0){
			msg.setData(propsList);
		}
		msg.setSuccess(true);
		msg.setMsg("成功加载属性!");
		
		return msg;
	}
	
	// 获取运费模板
	@RequestMapping("/getDeliverType")
	@ResponseBody
	public JsonMsg getDeliverType(HttpServletRequest request){
		
		JsonMsg msg = new JsonMsg();
		
		long siteId = (Long) request.getSession().getAttribute("siteId");
		
		List<DeliverType> dtList = logistServiceAPI.findDeliverTypes(siteId);
		
		msg.setData(dtList);
		msg.setSuccess(true);
		msg.setMsg("成功加载运费模板!");
		
		return msg;
	}
	
	// 保存产品
	@RequestMapping("/saveBaby")
	@ResponseBody
	public JsonMsg saveBaby(HttpServletRequest request, Product product,
			String[] skuArray,String checkVals,String inputVals, String selectVals) {
		JsonMsg msg = new JsonMsg();
		
		
		System.out.println("jin save fang fa ");
		
		long siteId = (Long) request.getSession().getAttribute("siteId");
		
		// 1、保存产品信息
		Product p = new Product();
		p.setSite(siteId);
		p.setCateId(product.getCateId());						//产品分类
		p.setCateName(product.getCateName());					//类目名称
		p.setTitle(product.getTitle());							//商品名称
		p.setTsc(product.getTsc());								//商品编号
		p.setKeyWords(product.getKeyWords());					//商品关键字
		p.setBrief(product.getBrief());							//商品简介
		p.setBrand(product.getBrand());							//商品品牌
		p.setPostage(product.getPostage());                     //运费模板
		p.setStatus(product.getStatus());
		long productId = 0;
		
		try {
			productId = this.goodsServiceAPI.addProduct(siteId, p);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		// 2、保存会员价格信息
		/*String shopPrice = product.getShopPrice();
		String[] shopPrices = shopPrice.substring(0, shopPrice.length()-1).split("|");*/
		
		
		
		// 3、保存产品图片信息
		String picPath = product.getPicUrl();//商品图片
		
		if(picPath.trim().length() >0 && null !=picPath){
			String[] picPaths = picPath.substring(0, picPath.length() - 1).split("\\|");
			String imgPath ="";
			if(null !=picPaths && picPaths.length >0){
				JSONArray jsonArray= new JSONArray();
				
				List<ProductImg> piList = new ArrayList<ProductImg>();
				
				for(int i = 0; i < picPaths.length; i ++) {
					
					ProductImg pi = new ProductImg();
					pi.setUrl(picPaths[i]);
					pi.setProductId(productId);
					piList.add(pi);
				}
				imgPath = picPaths[0];
				if(null != piList && piList.size() > 0){
					try {
						goodsServiceAPI.addPImg(siteId, productId, piList);
						goodsServiceAPI.editProductById(siteId, productId,imgPath);
					} catch (ApiException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}
	
		
		//编辑商品价格
		if(null != skuArray){
			String[] skuValue = skuArray[0].split(";");
			try {
				goodsServiceAPI.editProductPrice(siteId, productId, skuValue[4]);
			} catch (ApiException e) {
				e.printStackTrace();
			}
			
		}
		
		//判断sku，如果sku不为空，存sku值的。如果为空，存产品信息值
		
		// 4、保存SKU信息
		if(null != skuArray){
			List<Sku> skus = new ArrayList<Sku>();
			for(String s : skuArray) {
				String[] skuValue = s.split(";");
				Sku sku = new Sku();
				if(null !=skuValue[0]){
					String specIds = skuValue[0].replaceAll("_", ";");
					sku.setSpecIds(specIds);
				}
				if(null !=skuValue[1]){
					String specStr = skuValue[1].replaceAll("  ", ";");
					sku.setSpecStr(specStr);
				}
				sku.setBarcode(skuValue[2]);
				sku.setStorenum(Integer.parseInt(skuValue[3]));
				//sku.setQuantity(Long.parseLong(skuValue[3]));
				sku.setPrice(Double.parseDouble(skuValue[4]));
				sku.setCost(Double.parseDouble(skuValue[5]));
				sku.setMkprice(Double.parseDouble(skuValue[6]));
				sku.setGoodsWeight(Double.parseDouble(skuValue[7]));
				sku.setSalenum(Integer.parseInt(skuValue[8]));
				sku.setProductId(productId);
				sku.setCreated(new Date().toString());
				
				skus.add(sku);
			}
			
			try {
				this.goodsServiceAPI.addSKU(siteId, productId, skus);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}else{
			p.setPrice(product.getPrice());				//销售价
			p.setMarketPrice(product.getMarketPrice()); 						//市场价
			p.setBarcode(product.getBarcode());						//货号
			//p.setItemWeight(product.getItemWeight());				//重量
			p.setLocknum(product.getLocknum());	//库存
		}
		
		
		//5.保存商品描述  desc
		
		System.out.println("商品描述========="+product.getDesc());
		if(null !=product.getDesc() && product.getDesc().trim().length() >0){
			//商品描述，缓存中存的键是(常亮+siteID + 商品编号)：CacheConst.PRODUCT_ + siteId _tsc
			ssdbTemplate.boundValueOps(CacheConst.PRODUCT_DESC_+ siteId + "_" + productId).set(product.getDesc());
		}
		
		
		//6.保存属性
		//String checkVals,String inputVals, String selectVals
		//保存input值
		if(null!=inputVals && inputVals.length()>0){
			String[] inputVal = inputVals.split("\\|");
			ProductProp ipp ;
			for (String iVal : inputVal) {
				ipp = new ProductProp();
				String[] input = iVal.split(":");
				String propId = input[0];
				ipp.setPropId(Long.valueOf(propId));
				ipp.setPropTitle(input[1]);
				if(input.length >2){
					ipp.setPropVal(input[2]);
				}
				//ippList.add(ipp);
				ssdbTemplate.boundValueOps(CacheConst.STOREY_ + siteId + "_" + productId + "_input_"+propId).set(ipp);
				//.rightPush(ipp);
			}
		}
		//保存check值
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			List<ProductProp> cppList = null;
			ProductProp cpp ;
			for (String cVal : checkVal) {
				cppList = new ArrayList<ProductProp>();
				String[] check = cVal.split(":");
				
				if(check.length >2){
					String[] cvalue = check[2].split(";");
					String propId = check[0];
					if(cvalue.length > 0){
						for (String string : cvalue) {
							cpp = new ProductProp();
							cpp.setPropId(Long.valueOf(propId));
							cpp.setPropTitle(check[1]);
							String[] pvId= string.split("-");
							cpp.setPropVal(pvId[0]);
							//cppList.add(cpp);
							ssdbTemplate.boundListOps(CacheConst.STOREY_ + siteId + "_" + productId + "_check"+propId)
							.rightPush(cpp);
						}
					}
					
				}
			}
		}
		//保存select值
		if(null!=selectVals && selectVals.length()>0){
			String[] selectVal = selectVals.split("\\|");
			ProductProp spp ;
			for (String sVal : selectVal) {
				spp = new ProductProp();
				String[] select = sVal.split(":");
				spp.setPropId(Long.valueOf(select[0]));
				spp.setPropTitle(select[1]);
				if(select.length >2){
					String[] pVa = select[2].split("-");
					spp.setPropVal(pVa[0]);
				}
				ssdbTemplate.boundListOps(CacheConst.STOREY_ + siteId + "_" + productId + "_select").rightPush(spp);
			}
			
		}
		
		
		
		//7.保存索引
		
		SolrService solrS = new SolrService();
		solrS.init();
		//solrS.remove();

		List<GoodsSolr> list = new ArrayList<GoodsSolr>();
		
		GoodsSolr tg = new GoodsSolr();
		tg.setId(siteId+"_"+productId+"");
		tg.setSiteid(siteId+"");
		tg.setCateid(product.getCateId());
		tg.setCatestr(product.getCateId()+"-"+product.getCateName());
		
		Brand b = brandServiceAPI.getBrand(product.getBrand());
		
		tg.setBrandid(product.getBrand()+"");
		tg.setBrandstr(product.getBrand() + "-" + b.getName());
		tg.setTitle(product.getTitle());
		tg.setProductid(productId+"");
		
		
		String price ="";
		if(null != skuArray && skuArray.length >0){
			String[] skuValue = skuArray[0].split(";");
			if(skuValue[4] !=null){
				price = skuValue[4];
			}
				
			
		}
		tg.setPrice(Float.valueOf(price));
		
		//图片
		//String picPath1 = product.getPicUrl();//商品图片
		if(picPath.trim().length() >0 && null !=picPath){
			String[] picPaths = picPath.substring(0, picPath.length() - 1).split("\\|");
			if(null !=picPaths && picPaths.length >0){
				
				tg.setPicurl(picPaths[0]);
			}
		}
		
		int proCount = 0;
		
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			for (int j = 0; j <  checkVal.length; j++) {
				String[] check = checkVal[j].split(":");
				
				if(check.length >2){
					String[] num = check[2].split(";");
					proCount +=num.length;
				}
			}
		}
		
		proCount +=selectVals.length();
		
		
		//规格长度
		int skuSize = 0;
		if(null != skuArray){
			List<Sku> skus = new ArrayList<Sku>();
			for(String s : skuArray) {
				String[] skuValue = s.split(";");
				if(null !=skuValue[0]){
					String[] skuVs = skuValue[0].split("_");
					skuSize += skuVs.length;
				}
			}
		}
		proCount += skuSize;
		
		String[] attrid = new String[proCount] ;
		String[] attrstr = new String[proCount];
		String[] attrvalid = new String[proCount] ;
		String[] attrvalstr = new String[proCount] ;
		
		int count =0;
		if(null!=selectVals && selectVals.length()>0){
			String[] selectVal = selectVals.split("\\|");
			for (int i = 0; i < selectVal.length; i++) {
				String[] select = selectVal[i].split(":");
				attrid[i] = select[0];
				
				attrstr[i] = select[0] +"-"+ select[1];
				String[] item = select[2].split("-");
				attrvalid[i] = select[0] + "_" + item[0];
				attrvalstr[i] = select[0] + "_" + select[2];
			}
			count = selectVal.length;
		}
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			for (int j = 0; j <  checkVal.length; j++) {
				String[] check = checkVal[j].split(":");
				
				if(check.length >2){
					String[] cvalue = check[2].split(";");
					if(cvalue.length > 0){
						
						for (int k = 0; k < cvalue.length; k++) {
							attrid[count] = check[0];
							attrstr[count] = check[0] +"-"+ check[1];
							String[] item= cvalue[k].split("-");
							attrvalid[count] = check[0] + "_" + item[0];
							attrvalstr[count] = check[0] + "_" + cvalue[k];
							count = count+1;
						}
					}
					
				}
			}
		}
		if(null != skuArray){
			for(String s : skuArray) {
				String[] skuValue = s.split(";");
				if(null !=skuValue[0] && null !=skuValue[1]){
					String[] specIds = skuValue[0].split("_");
					String[] specStr = skuValue[1].split("  ");
					for (int k = 0; k < specIds.length; k++) {
						String[] specIV = specIds[k].split(":");
						String[] specSV = specStr[k].split(":");
						
						attrid[count] = specIV[0];
						attrstr[count] = specIV[0] + "-" + specSV[0];
						attrvalid[count] = specIV[0] + "_" + specIV[1];
						attrvalstr[count] = specIV[0] + "_" + specIV[1] + "-" + specSV[1];
						
						count = count+1;
					}
					
				}
			}
		}
		
		
		tg.setAttrid(attrid);
		tg.setAttrstr(attrstr);
		tg.setAttrvalid(attrvalid);
		tg.setAttrvalstr(attrvalstr);
		list.add(tg);
		solrS.addBeans(list);
		
		msg.setSuccess(true);
		msg.setMsg("产品保存成功");
		return msg;
	}
	
	/**
	 * 获得商品列表
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param o
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			Product product,String title,String barcode,String status,Double minPrice,
			Double maxPrice,Integer maxSaleNum,Integer minSaleNum,Integer stockalertnum, HttpServletRequest request) throws ApiException {
		Long  cateId = null;
		long sid =1001;
		//long sid = (Long) request.getSession().getAttribute("siteId");
		Integer  minStoreNum = null;
		
		Integer maxStoreNum =null;
		
		if(stockalertnum != null){
			maxStoreNum = stockalertnum;
		}
		
		 
		int count = goodsServiceAPI.getProductCount(sid, title, barcode, cateId, maxPrice, 
				minPrice, maxSaleNum, minSaleNum, maxStoreNum, minStoreNum, status);
		List<Product> pList = goodsServiceAPI.getProducts(sid, title, barcode, String.valueOf(cateId), 
				maxPrice, minPrice, maxSaleNum, minSaleNum, maxStoreNum, minStoreNum,status,  order, page, rows);
		
		
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(pList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	
	// 产品下架
	@RequestMapping("/productDown")
	@ResponseBody
	public JsonMsg productDown(String ids,String status, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=ids &&  null !=status){
			goodsServiceAPI.editProductStatus(sid, ids, status);
			msg.setSuccess(true);
			msg.setMsg("商品下架成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("商品下架失败!");
		}
		
		return msg;
	}
	
	// 产品上架
	@RequestMapping("/productUp")
	@ResponseBody
	public JsonMsg productUp(String ids,String status, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=ids &&  null !=status){
			goodsServiceAPI.editProductStatus(sid, ids, status);
			msg.setSuccess(true);
			msg.setMsg("商品上架成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("商品上架失败!");
		}
		
		return msg;
	}
	
	// 商品删除
	@RequestMapping("/productDel")
	@ResponseBody
	public JsonMsg productDel(String ids, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=ids ){
			goodsServiceAPI.delProduct(sid, ids);
			msg.setSuccess(true);
			msg.setMsg("商品删除成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("商品删除失败!");
		}
		
		return msg;
	}
	
	/**
	 * 跳转到预警中的商品页面
	 * @return
	 */
	@RequestMapping(value="/productStockList")
	public String productStockList(String id,Model model,
			HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		Shop shop;
		try {
			shop = shopServiceAPI.getShop(sid);
			model.addAttribute("store", shop);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "baby/product_stockalert";
	}
	
	/**
	 * 修改预警值
	 * @param stockalertnum
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping("/editStorealertnum")
	@ResponseBody
	public JsonMsg editStorealertnum(String stockalertnum, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=stockalertnum ){
			shopServiceAPI.editStore(sid, Integer.valueOf(stockalertnum));
			msg.setSuccess(true);
			msg.setMsg("店铺预警值修改成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("店铺预警值修改失败!");
		}
		
		return msg;
	}
	
	@RequestMapping("/getSku")
	@ResponseBody
	public JsonMsg getSku(String id,@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		List<Sku> skuList ;
		if(null !=id ){
			skuList = goodsServiceAPI.getSkuList(sid, Long.valueOf(id), page, rows);
			msg.setData(skuList);
			msg.setSuccess(true);
			msg.setMsg("商品列表获得成功");
		}else{
			msg.setSuccess(false);
			msg.setMsg("商品列表获得失败!");
		}
		
		return msg;
	}
	
	/**
	 * 跳转到商品编辑页面
	 * @return
	 */
	@RequestMapping(value="/productEdit")
	public String productEdit(String id,Model model,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		Product product ;
		Category cate ;
		if(null !=id){
			try {
				product = goodsServiceAPI.getProduct(sid, Long.valueOf(id));
				System.out.println("getBrief=="+product.getBrief());
				System.out.println("getBarcode=="+product.getBarcode());
				
				if(null !=product && product.getCateId()!=null&& product.getCateId().trim().length() > 0){
					cate=  cateServiceAPI.getCate(Long.valueOf(product.getCateId()));
					model.addAttribute("cate", cate);
				}
				//获得商品描述
				String desc = ssdbService.getProductDesc(sid, Long.valueOf(id));
				if(StringUtils.isNotEmpty(desc)){
					model.addAttribute("desc", desc);
				}
				//获得商品图片
				
				List<ProductImg> pimList = goodsServiceAPI.getProductByPid(sid, Long.valueOf(id));
				if(null != pimList && pimList.size() > 0){
					String imgurls = "";
					for (ProductImg productImg : pimList) {
						imgurls +=productImg.getUrl() + "|";
					}
					if(null !=imgurls && imgurls.trim().length() >0 ){
						//imgurls =imgurls.substring(0, imgurls.length() - 1);
						model.addAttribute("imgurls", imgurls);
					}
					model.addAttribute("imglist", pimList);
				}
				
				/*JSONArray imglist = ssdbService.getProductImgs(sid, Long.valueOf(id));
				System.out.println("imglist=="+imglist.size());
				if(null != imglist && imglist.size() > 0){
					model.addAttribute("imglist", imglist);
				}*/
				
				if(product !=null){
					model.addAttribute("product", product);
				}
				
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return "baby/release_edit_main";
	}
	
	
	
	// 商品编辑
	@RequestMapping("/productEditDo")
	@ResponseBody
	public JsonMsg productEditDo(Product product, String[] skuArray,String checkVals,String inputVals, String selectVals,
			HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		// 1、保存产品信息
		Product p = new Product();
		Long productId = product.getpId();
		p.setSite(sid);
		p.setStatus(product.getStatus());
		p.setpId(product.getpId());
		p.setCateId(product.getCateId());						//产品分类
		p.setCateName(product.getCateName());					//类目名称
		p.setTitle(product.getTitle());							//商品名称
		p.setTsc(product.getTsc());								//商品编号
		p.setKeyWords(product.getKeyWords());					//商品关键字
		p.setBrief(product.getBrief());							//商品简介
		p.setBrand(product.getBrand());							//商品品牌
		p.setPostage(product.getPostage());                     //运费模板
		//p.setPicUrl(product.getPicUrl());
		p.setBarcode(product.getBarcode());
		
		
		
		System.out.println("==========="+product.getPicUrl());
		/*p.setPrice(product.getPrice());				//销售价
		p.setMarketPrice(product.getMarketPrice()); 						//市场价
		p.setBarcode(product.getBarcode());						//货号
		p.setItemWeight(product.getItemWeight());				//重量
		p.setWithHoldQuantity(product.getWithHoldQuantity());	*///库存
		goodsServiceAPI.editProduct(sid, p);
		
		
		

		// 3、保存产品图片信息
		String picPath = product.getPicUrl();//商品图片
		
		
		System.out.println("picPaht=="+picPath);
		
		if(null !=picPath &&  picPath.trim().length() >0 ){
			String[] picPaths = picPath.substring(0, picPath.length() - 1).split("\\|");
			String imgPath ="";
			if(null !=picPaths && picPaths.length >0){
				JSONArray jsonArray= new JSONArray();
				
				List<ProductImg> piList = new ArrayList<ProductImg>();
				
				for(int i = 0; i < picPaths.length; i ++) {
					
					ProductImg pi = new ProductImg();
					pi.setUrl(picPaths[i]);
					pi.setProductId(productId);
					piList.add(pi);
				}
				imgPath = picPaths[0];
				if(null != piList && piList.size() > 0){
					try {
						goodsServiceAPI.addPImg(sid, productId, piList);
						goodsServiceAPI.editProductById(sid, productId,imgPath);
					} catch (ApiException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}
		
		
		//编辑商品价格
		if(null != skuArray){
			String[] skuValue = skuArray[0].split("=");
			try {
				goodsServiceAPI.editProductPrice(sid, productId, skuValue[4]);
			} catch (ApiException e) {
				e.printStackTrace();
			}
			
		}
		
		
		// 4、修改SKU信息
		
		System.out.println("sku=="+skuArray);
		if(null != skuArray){
			List<Sku> skus = new ArrayList<Sku>();
			
			String[] skuVs = skuArray[0].split("=");
			//判断sku是修改还是添加 。skuVa==10的时候。是要修改sku信息。skuVa==9的时候。添加sku信息
			//
			long pid = product.getpId();
			if(skuVs.length ==10){
				Sku sku;
				for(String s : skuArray) {
					String[] skuValue = s.split("=");
					String skuid = skuValue[9];
					sku = new Sku();
					sku.setSkuId(Long.valueOf(skuid));
					sku.setSpecIds(skuValue[0]);
					sku.setSpecStr(skuValue[1]);
					sku.setBarcode(skuValue[2]);
					
					sku.setStorenum(Integer.parseInt(skuValue[3]));
					//sku.setQuantity(Long.parseLong(skuValue[3]));
					sku.setPrice(Double.parseDouble(skuValue[4]));
					sku.setCost(Double.parseDouble(skuValue[5]));
					if(null !=skuValue[6] && !skuValue[6].equals("")){
						sku.setMkprice(Double.parseDouble(skuValue[6]));
					}
					if(null !=skuValue[7] && !skuValue[7].equals("")){
						sku.setGoodsWeight(Double.parseDouble(skuValue[7]));
					}
					if(null !=skuValue[8] && !skuValue[8].equals("")){
						sku.setSalenum(Integer.parseInt(skuValue[8]));
					}
					
					sku.setProductId(product.getpId());
					sku.setCreated(new Date().toString());
					
					skus.add(sku);
				}
				this.goodsServiceAPI.editSKU(sid, pid, skus);
			}else if(skuVs.length ==9){
				for(String s : skuArray) {
					String[] skuValue = s.split("=");
					
					Sku sku = new Sku();
					sku.setSpecIds(skuValue[0]);
					sku.setSpecStr(skuValue[1]);
					sku.setBarcode(skuValue[2]);
					sku.setStorenum(Integer.parseInt(skuValue[3]));
					//sku.setQuantity(Long.parseLong(skuValue[3]));
					sku.setPrice(Double.parseDouble(skuValue[4]));
					sku.setCost(Double.parseDouble(skuValue[5]));
					sku.setMkprice(Double.parseDouble(skuValue[6]));
					sku.setGoodsWeight(Double.parseDouble(skuValue[7]));
					sku.setSalenum(Integer.parseInt(skuValue[8]));
					//sku.setGoodsQuantity(Long.parseLong(skuValue[8]));
					sku.setProductId(product.getpId());
					sku.setCreated(new Date().toString());
					
					skus.add(sku);
				}
				try {
					this.goodsServiceAPI.addSKU(sid, productId, skus);
				} catch (ApiException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			p.setPrice(product.getPrice());				//销售价
			p.setMarketPrice(product.getMarketPrice()); 						//市场价
			p.setBarcode(product.getBarcode());						//货号
			//p.setItemWeight(product.getItemWeight());				//重量
			p.setLocknum(product.getLocknum());	//库存
		}
		
		//5.保存商品描述  desc
		if(null !=product.getDesc() && product.getDesc().trim().length() >0){
			
			System.out.println("desc=="+product.getDesc());
			//商品描述，缓存中存的键是(常亮+siteID + 商品编号)：CacheConst.PRODUCT_ + siteId _tsc
			System.out.println("key="+CacheConst.PRODUCT_DESC_+ sid + "_" + product.getpId());
			ssdbTemplate.boundValueOps(CacheConst.PRODUCT_DESC_+ sid + "_"+ product.getpId()).set(product.getDesc());
		}
		
		
		
		
		//6.保存属性
		//String checkVals,String inputVals, String selectVals
		//保存input值
		if(null!=inputVals && inputVals.length()>0){
			String[] inputVal = inputVals.split("\\|");
			ProductProp ipp ;
			for (String iVal : inputVal) {
				ipp = new ProductProp();
				String[] input = iVal.split(":");
				String propId = input[0];
				ipp.setPropId(Long.valueOf(propId));
				ipp.setPropTitle(input[1]);
				if(input.length >2){
					ipp.setPropVal(input[2]);
				}
				//ippList.add(ipp);
				ssdbTemplate.boundValueOps(CacheConst.STOREY_ + sid + "_" + productId + "_input_"+propId).set(ipp);
				//.rightPush(ipp);
			}
		}
		//保存check值
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			List<ProductProp> cppList = null;
			ProductProp cpp ;
			for (String cVal : checkVal) {
				cppList = new ArrayList<ProductProp>();
				String[] check = cVal.split(":");
				
				if(check.length >2){
					String[] cvalue = check[2].split(";");
					String propId = check[0];
					if(cvalue.length > 0){
						for (String string : cvalue) {
							cpp = new ProductProp();
							cpp.setPropId(Long.valueOf(propId));
							cpp.setPropTitle(check[1]);
							String[] pvId= string.split("-");
							cpp.setPropVal(pvId[0]);
							//cppList.add(cpp);
							ssdbTemplate.boundListOps(CacheConst.STOREY_ + sid + "_" + productId + "_check"+propId)
							.rightPush(cpp);
						}
					}
					
				}
			}
		}
		//保存select值
		if(null!=selectVals && selectVals.length()>0){
			String[] selectVal = selectVals.split("\\|");
			ProductProp spp ;
			for (String sVal : selectVal) {
				spp = new ProductProp();
				String[] select = sVal.split(":");
				spp.setPropId(Long.valueOf(select[0]));
				spp.setPropTitle(select[1]);
				if(select.length >2){
					String[] pVa = select[2].split("-");
					spp.setPropVal(pVa[0]);
				}
				ssdbTemplate.boundListOps(CacheConst.STOREY_ + sid + "_" + productId + "_select").rightPush(spp);
			}
			
		}
		
		
		
		//7.保存索引
		
		SolrService solrS = new SolrService();
		solrS.init();
		//solrS.remove();

		List<GoodsSolr> list = new ArrayList<GoodsSolr>();
		
		GoodsSolr tg = new GoodsSolr();
		tg.setId(sid+"_"+productId+"");
		tg.setSiteid(sid+"");
		tg.setCateid(product.getCateId());
		tg.setCatestr(product.getCateId()+"-"+product.getCateName());
		
		Brand b = brandServiceAPI.getBrand(product.getBrand());
		
		tg.setBrandid(product.getBrand()+"");
		tg.setBrandstr(product.getBrand() + "-" + b.getName());
		tg.setTitle(product.getTitle());
		tg.setProductid(productId+"");
		
		
		String price ="";
		if(null != skuArray && skuArray.length >0){
			String[] skuValue = skuArray[0].split("=");
			if(skuValue[4] !=null){
				price = skuValue[4];
			}
				
			
		}
		tg.setPrice(Float.valueOf(price));
		
		//图片
		//String picPath1 = product.getPicUrl();//商品图片
		if(null !=picPath && picPath.trim().length() >0){
			String[] picPaths = picPath.substring(0, picPath.length() - 1).split("\\|");
			if(null !=picPaths && picPaths.length >0){
				
				tg.setPicurl(picPaths[0]);
			}
		}
		
		int proCount = 0;
		
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			for (int j = 0; j <  checkVal.length; j++) {
				String[] check = checkVal[j].split(":");
				
				if(check.length >2){
					String[] num = check[2].split(";");
					proCount +=num.length;
				}
			}
		}
		
		proCount +=selectVals.length();
		
		
		//规格长度
		int skuSize = 0;
		if(null != skuArray){
			List<Sku> skus = new ArrayList<Sku>();
			for(String s : skuArray) {
				String[] skuValue = s.split("=");
				if(null !=skuValue[0]){
					String[] skuVs = skuValue[0].split("_");
					skuSize += skuVs.length;
				}
			}
		}
		proCount += skuSize;
		
		String[] attrid = new String[proCount] ;
		String[] attrstr = new String[proCount];
		String[] attrvalid = new String[proCount] ;
		String[] attrvalstr = new String[proCount] ;
		
		int count =0;
		if(null!=selectVals && selectVals.length()>0){
			String[] selectVal = selectVals.split("\\|");
			for (int i = 0; i < selectVal.length; i++) {
				String[] select = selectVal[i].split(":");
				attrid[i] = select[0];
				
				attrstr[i] = select[0] +"-"+ select[1];
				String[] item = select[2].split("-");
				attrvalid[i] = select[0] + "_" + item[0];
				attrvalstr[i] = select[0] + "_" + select[2];
			}
			count = selectVal.length;
		}
		if(null!=checkVals && checkVals.length()>0){
			String[] checkVal = checkVals.split("\\|");
			for (int j = 0; j <  checkVal.length; j++) {
				String[] check = checkVal[j].split(":");
				
				if(check.length >2){
					String[] cvalue = check[2].split(";");
					if(cvalue.length > 0){
						
						for (int k = 0; k < cvalue.length; k++) {
							attrid[count] = check[0];
							attrstr[count] = check[0] +"-"+ check[1];
							String[] item= cvalue[k].split("-");
							attrvalid[count] = check[0] + "_" + item[0];
							attrvalstr[count] = check[0] + "_" + cvalue[k];
							count = count+1;
						}
					}
					
				}
			}
		}
		if(null != skuArray){
			for(String s : skuArray) {
				String[] skuValue = s.split("=");
				if(null !=skuValue[0] && null !=skuValue[1]){
					String[] specIds = skuValue[0].split("_");
					String[] specStr = skuValue[1].split("  ");
					for (int k = 0; k < specIds.length; k++) {
						String[] specIV = specIds[k].split(":");
						String[] specSV = specStr[k].split(":");
						
						attrid[count] = specIV[0];
						attrstr[count] = specIV[0] + "-" + specSV[0];
						attrvalid[count] = specIV[0] + "_" + specIV[1];
						attrvalstr[count] = specIV[0] + "_" + specIV[1] + "-" + specSV[1];
						
						count = count+1;
					}
					
				}
			}
		}
		
		
		tg.setAttrid(attrid);
		tg.setAttrstr(attrstr);
		tg.setAttrvalid(attrvalid);
		tg.setAttrvalstr(attrvalstr);
		list.add(tg);
		solrS.addBeans(list);
		
		
		msg.setSuccess(true);
		msg.setMsg("商品修改成功！");
		return msg;
	 }
	
	/**
	 * 跳转到订单页面
	 * @return
	 */
	@RequestMapping(value="/toSolr")
	public String orderList(){
		return "solr/solr";
	}
	
	
	@RequestMapping("/getSolrBySiteId")
	@ResponseBody
	public JsonMsg getSolrBySiteId(String id,@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		
		goodsSolrService.addGoodsSolrBySite(sid,page,rows);
		msg.setSuccess(true);
		msg.setMsg("索引生成成功");
		
		return msg;
	}
}
