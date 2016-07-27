package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.CateParam;
import com.gsccs.b2c.api.domain.CateProp;
import com.gsccs.b2c.api.domain.CateReqInfo;
import com.gsccs.b2c.api.domain.CateSpec;
import com.gsccs.b2c.api.domain.PropValue;
import com.gsccs.b2c.api.domain.PropsVal;

public interface TypeServiceI {
	
	/**
	 * 获取类目规格列表
	 * 
	 * @param typeId
	 * @return
	 */
	public List<CateSpec> getCateSpecs(Long typeId);

	/**
	 * 获取类目扩展属性列表
	 * 
	 * @param typeId
	 * @return
	 */
	public List<CateProp> getCateProps(Long typeId);

	/**
	 * 获取类目详细参数
	 * 
	 * @param typeId
	 * @return
	 */
	public List<CateParam> getCateDetailParam(Long typeId);

	/**
	 * 根据类目获取购物必填信息
	 * 
	 * @param typeId
	 * @return
	 */
	public List<CateReqInfo> getCateRequireInfo(Long typeId);
	
	/**
	 * 
	 * @param propid
	 * @return
	 */
	public CateProp getCateProp(Long propid) ;
	
	
	/**
	 * 根据商品id获取类目扩展属性列表
	 * 
	 * @param typeId
	 * @return
	 */
	public List<CateProp> getCatePropsByPid(Long sid, Long pid);
	
	public PropsVal getPropsVal(Long pvId);

}
