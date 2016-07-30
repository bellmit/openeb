package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.PropsVal;
import com.gsccs.eb.api.domain.goods.SpecVal;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.domain.goods.Type;

/**
 * 商品参数服务接口
 * 
 * @author x.d zhang
 * 
 */
public interface TypeService {

	/**
	 * 获取类型列表
	 * 
	 * @param type
	 * @return
	 */
	public List<Type> getTypeList(Type type, String order, int currPage,
			int pageSize);

	public List<Type> queryByTypeName(String typename);

	public int count(Type type);
	
	/**
	 * 删除类型
	 * 
	 * @param typeid
	 * @return
	 */
	public void deleteTypeById(Long typeid);

	/**
	 * 根据类型获取商品规格
	 * 
	 * @param typeId
	 * @return
	 */
	public List<Specific> getSpecByTypeId(Long typeId);

	/**
	 * 根据类型获取商品属性
	 * 
	 * @param propId
	 * @return
	 */
	public List<Property> getPropList(Long typeId);
	
	/**
	 * 根据类型获取商品属性
	 * 
	 * @param propId
	 * @return
	 */
	public void deletePropById(Long propid);

	/**
	 * 根据属性Id
	 * 
	 * @param proId
	 * @return
	 */
	public List<PropsVal> getPropsValList(Long proId);

	public PropsVal getPropsVal(Long pvId);

	/**
	 * 根据规格获取规格值列表
	 * 
	 * @param specId
	 * @return
	 */
	public List<SpecVal> getSpecvalList(Long specId);


	/**
	 * 添加类型。属性、规格等操作在同一事务中完成。
	 * 
	 * @param type
	 */
	public Long addType(Type type);

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	public Type getType(Long typeId);

	/**
	 * 
	 * @param type
	 */
	public void updateType(Type type);

	public Property getProp(Long propid);

}
