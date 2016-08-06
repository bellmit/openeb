package com.gsccs.b2c.solr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.api.CacheConst;
import com.gsccs.b2c.api.service.BrandServiceI;
import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.b2c.api.service.ProductServiceI;
import com.gsccs.b2c.api.service.TypeServiceI;
import com.gsccs.eb.api.domain.goods.Brand;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.ProductProp;
import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.PropsVal;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 
 * @author niu x j
 * 商品索引
 *
 */
@Service
public class GoodsSolrServiceImpl implements GoodsSolrService{
	
	@Autowired
	private ProductServiceI goodsServiceAPI;
	
	@Autowired
	private CateServiceI cateServiceAPI;
	
	@Autowired
	private BrandServiceI brandServiceAPI;
	
	@Autowired
	private TypeServiceI typeServiceAPI;
	
	@Autowired
	private RedisTemplate ssdbTemplate;
	
	
	
	@Override
	public void addGoodsSolrBySite(Long sid,int page,int rows){
		
		
		
		SolrService solrS = new SolrService();
		solrS.init();

		
		List<Product> pList;
		List<GoodsSolr> glist = new ArrayList<GoodsSolr>();
		
		try {
			
			pList = null;
					//goodsServiceAPI.getProducts(sid, null, null, null, null, null, null, null, null, null, null, null, page, rows);
			if(null !=pList && pList.size() > 0){
				GoodsSolr tg;
				Brand b;
				Category category;
				for (int i = 0; i < pList.size(); i++) {
					tg = new GoodsSolr();
					tg.setId(sid+"_"+pList.get(i).getId());
					tg.setProductid(pList.get(i).getId()+"");
					tg.setBrandid(pList.get(i).getBrandid()+"");
					tg.setPicurl(pList.get(i).getImg());
					if(null !=pList.get(i).getBrandid() && pList.get(i).getBrandid().toString().length() >0){
						b =brandServiceAPI.getBrand(Long.valueOf(pList.get(i).getBrandid()));
						if(null !=b){
							tg.setBrandstr(pList.get(i).getBrandid() + "-" + b.getName());
						}
					}
					tg.setPrice( pList.get(i).getPrice().floatValue());
					
					tg.setSiteid(pList.get(i).getShopid().toString());
					if(null !=pList.get(i).getCategoryid()){
						tg.setCateid(pList.get(i).getCategoryid()+"");
						category = cateServiceAPI.getCate(Long.valueOf(pList.get(i).getCategoryid()));
						if(null !=category){
							tg.setCatestr(pList.get(i).getCategoryid()+"-"+category.getTitle());
						}
					}
					
					tg.setTitle(pList.get(i).getTitle());
					
					
					String selectKey=CacheConst.STOREY_ + sid + "_" + pList.get(i).getId() + "_select";
					
					List<ProductProp> sppList = ssdbTemplate.boundListOps(selectKey).range(0, -1);
					
					
					int count = 0;
					
					long pid = pList.get(i).getId();
					Long typeid = pList.get(i).getTypeid();
					String checkKey="";
					List<ProductProp> cppList = null;
					List<Property> cpList = typeServiceAPI.findPropList(typeid);
					if(null !=cpList && cpList.size() > 0){
						for (Property cateProp : cpList) {
							checkKey = CacheConst.STOREY_ + sid + "_" + pList.get(i).getId() + "_check_"+cateProp.getId();
							cppList = ssdbTemplate.boundListOps(checkKey).range(0, -1);
							count += count+cppList.size();
						}
					}
					count += count +sppList.size();
					
					List<Sku> skuList = goodsServiceAPI.getSkuList(sid, pid, 1, 10000);
					
					int skuSize = 0;
					
					if(null !=skuList && skuList.size() > 0){
						for (int j = 0; j < skuList.size(); j++) {
							String skuV = skuList.get(j).getSpecids();
							String[] specVlas = skuV.split(";");
							skuSize += specVlas.length;
						}
					}
					count = count + skuSize;
					String[] attrid = new String[count] ;
					String[] attrstr = new String[count];
					String[] attrvalid = new String[count] ;
					String[] attrvalstr = new String[count] ;
					
					int num = 0;
					if(null !=cpList && cpList.size() > 0){
						for (Property cateProp : cpList) {
							checkKey = CacheConst.STOREY_ + sid + "_" + pList.get(i).getId() + "_check_"+cateProp.getId();
							cppList = ssdbTemplate.boundListOps(checkKey).range(0, -1);
							if(null !=cppList && cppList.size() >0){
								
								for (ProductProp pp : cppList) {
									attrid[num] = pp.getPropId().toString();
									attrstr[num] = pp.getPropId().toString() +"-"+ pp.getPropTitle();
									attrvalid[num] = pp.getPropId().toString() + "_" + pp.getPropVal();
									PropsVal pv= typeServiceAPI.getPropsVal(Long.valueOf(pp.getPropVal()));
									if(null != pv){
										attrvalstr[num] = pp.getPropId().toString() + "_" + pp.getPropVal() + "-"+ pv.getVals();
									}
									num = num +1;
								}
							}
							
						}
					}
					
					if(null !=sppList  && sppList.size() > 0){
						for (ProductProp spp : sppList) {
							attrid[num] = spp.getPropId().toString();
							attrstr[num] = spp.getPropId().toString() +"-"+ spp.getPropTitle();
							attrvalid[num] = spp.getPropId().toString() + "_" + spp.getPropVal();
							PropsVal pv= typeServiceAPI.getPropsVal(Long.valueOf(spp.getPropVal()));
							if(null != pv){
								attrvalstr[num] = spp.getPropId().toString() + "_" + spp.getPropVal() + "-"+ pv.getVals();
							}
							num = num +1;
						}
					}
					
					if(null !=skuList && skuList.size() > 0){
						for (int k = 0; k < skuList.size(); k++) {
							String speI = skuList.get(k).getSpecids();
							String speV = skuList.get(k).getSpecstr();
							String[] speIs = speI.split(";");
							String[] speVs = speV.split(";");
							for (int m = 0; m < speIs.length; m++) {
								String[] sIsv = speIs[m].split(":");
								String[] sTrv = speVs[m].split(":");
								attrid[num] = sIsv[0];
								attrstr[num] = sIsv[0] + "-" + sTrv[0];
								attrvalid[num] = sIsv[0] + "_" + sIsv[1];
								attrvalstr[num] = sIsv[0] + "_" + sIsv[1] + "-" + sTrv[1];
								num = num +1;
							}
						}
					}
					
					
					tg.setAttrid(attrid);
					tg.setAttrstr(attrstr);
					tg.setAttrvalid(attrvalid);
					tg.setAttrvalstr(attrvalstr);
					glist.add(tg);
					solrS.addBeans(glist);
					
					
				}
				
			}
			
		
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void addGoodsSolrBySiteAndPid(Long siteId, Long productId) {
		

		//7.保存索引
		
		SolrService solrS = new SolrService();
		solrS.init();
		//solrS.remove();

		List<GoodsSolr> list = new ArrayList<GoodsSolr>();
		
		GoodsSolr tg = new GoodsSolr();
		
		/*Product product = goodsServiceAPI.getProduct(siteId, productId);
		
		tg.setId(siteId+"_"+productId+"");
		tg.setSiteid(siteId+"");
		tg.setCateid(product.getCateId());
		tg.setCatestr(product.getCateId()+"-"+product.getCateName());
		
		Brand b =brandServiceAPI.getBrand(product.getBrand());
		
		tg.setBrandid(product.getBrand()+"");
		tg.setBrandstr(product.getBrand() + "-" + b.getName());
		tg.setTitle(product.getTitle());
		tg.setProductid(productId+"");
		
		//商品价格
		String  price = product.getPrice().toString();
		tg.setPrice(Float.valueOf(price));
		
		//图片
		String img = product.getPicUrl();
		tg.setPicurl(img);
		int proCount = 0;*/
		
		/*if(null!=checkVals && checkVals.length()>0){
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
		//int proCount = selectVals.length() + checkVals.length();
		
		
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
		}*/
		/*tg.setAttrid(attrid);
		tg.setAttrstr(attrstr);
		tg.setAttrvalid(attrvalid);
		tg.setAttrvalstr(attrvalstr);*/
		list.add(tg);
		solrS.addBeans(list);
		
	}

}
