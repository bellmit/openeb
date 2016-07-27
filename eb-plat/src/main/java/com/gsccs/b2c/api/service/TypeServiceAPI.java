package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.domain.CateParam;
import com.gsccs.b2c.api.domain.CateProp;
import com.gsccs.b2c.api.domain.CateReqInfo;
import com.gsccs.b2c.api.domain.CateSpec;
import com.gsccs.b2c.api.domain.CateSpecVal;
import com.gsccs.b2c.api.domain.PropValue;
import com.gsccs.b2c.api.domain.PropsVal;
import com.gsccs.b2c.plat.shop.model.CategoryT;
import com.gsccs.b2c.plat.shop.model.ProductT;
import com.gsccs.b2c.plat.shop.model.Property;
import com.gsccs.b2c.plat.shop.model.PropsValT;
import com.gsccs.b2c.plat.shop.model.SpecVal;
import com.gsccs.b2c.plat.shop.model.Specific;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;


public class TypeServiceAPI implements TypeServiceI {

	@Autowired
	private TypeService typeService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Override
	public List<CateSpec> getCateSpecs(Long typeId) {
		List<CateSpec> list = null;

		List<Specific> specList = typeService.getSpecList(typeId);
		if (null != specList && specList.size() > 0) {
			list = new ArrayList<CateSpec>();
			CateSpec cateSpec;
			String valStr = "";
			for (Specific t : specList) {
				cateSpec = new CateSpec();
				try {
					PropertyUtils.copyProperties(cateSpec, t);
					List<SpecVal> vals = typeService.getSpecvalList(t.getId());
					if (null != vals && vals.size() > 0) {
						List<CateSpecVal> specVals = new ArrayList<CateSpecVal>();
						for (SpecVal sv : vals) {
							CateSpecVal spevVal = new CateSpecVal();
							BeanUtils.copyProperties(spevVal, sv);
							
							specVals.add(spevVal);
							/*valStr = valStr + sv.getId() + ":" + sv.getTitle()
									+ ":" + sv.getAlias() + ";";*/
						}
						cateSpec.setSpecVals(specVals);
						/*if (StringUtils.isNotEmpty(valStr)) {
							valStr = valStr.substring(0, valStr.length() - 2);
						}*/
					}
					list.add(cateSpec);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<CateProp> getCateProps(Long typeId) {
		List<CateProp> list = null;
		List<PropsVal> pvList = null ;
		List<Property> propList = typeService.getPropList(typeId);
		if (null != propList && propList.size() > 0) {
			CateProp prop;
			list = new ArrayList<CateProp>();
			List<PropsValT> pvtList;
			for (Property t : propList) {
				try {
					prop = new CateProp();
					pvList = new ArrayList<PropsVal>();
					PropertyUtils.copyProperties(prop, t);
					if(null !=t.getId()){
						PropsVal pv;
						pvtList = typeService.getPropsValList(t.getId());
						if( null !=pvtList && pvtList.size() >0){
							for (PropsValT propsValT : pvtList) {
								pv = new PropsVal();
								System.out.println("propsValT=="+propsValT.getVals());
								BeanUtilsEx.copyProperties(pv, propsValT);
								pvList.add(pv);
							}
							prop.setPropsVals(pvList);
						}
						
						
					}
					list.add(prop);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
	
	@Override
	public List<CateParam> getCateDetailParam(Long typeId) {
		List<CateParam> list = null;
		List<Property> propList = typeService.getPropList(typeId);
		if (null != propList && propList.size() > 0) {
			CateParam dp;
			list = new ArrayList<CateParam>();
			for (Property t : propList) {
				try {
					dp = new CateParam();
					PropertyUtils.copyProperties(dp, t);
					list.add(dp);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<CateReqInfo> getCateRequireInfo(Long typeId) {
		List<CateReqInfo> list = null;
		List<Property> propList = typeService.getPropList(typeId);
		if (null != propList && propList.size() > 0) {
			CateReqInfo ri;
			list = new ArrayList<CateReqInfo>();
			for (Property t : propList) {
				try {
					ri = new CateReqInfo();
					PropertyUtils.copyProperties(ri, t);
					list.add(ri);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public CateProp getCateProp(Long propid) {
		Property prop = typeService.getProp(propid);
		if (null != prop){
			CateProp cprop = new CateProp();
			cprop.setId(prop.getId());
			cprop.setTitle(prop.getTitle());
			return cprop;
		}
		return null;
	}

	@Override
	public List<CateProp> getCatePropsByPid(Long sid, Long pid) {
		List<CateProp> cpList =null;
		ProductT pt = goodsService.getProduct(sid, pid, true);
		CategoryT ct = null;
		if(null !=pt && pt.getCate().trim().length()> 0){
			ct =categoryService.findById(Long.valueOf(pt.getCate()));
			if(null !=ct && null !=ct.getTypeId()){
				cpList = this.getCateProps(ct.getTypeId());
			}
		}
		
		return cpList;
	}

	@Override
	public PropsVal getPropsVal(Long pvId) {
		PropsValT pvt = typeService.getPropsVal(pvId);
		PropsVal pv = new PropsVal();
		BeanUtilsEx.copyProperties(pv, pvt);
		return pv;
	}

}
