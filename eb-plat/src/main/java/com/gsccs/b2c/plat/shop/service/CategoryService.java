package com.gsccs.b2c.plat.shop.service;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.eb.api.domain.goods.Category;

/**
 * 类目服务
 * 
 * @author x.d zhang
 * @version 1.0
 */
public interface CategoryService {

	/**
	 * 分页查询
	 */
	public List<Category> find(Category category, String order, int currPage,
			int pageSize);

	public int count(Category category);

	/**
	 * 查询所有类目
	 * 
	 * @return
	 */
	public JSONArray findAll(String state);

	/**
	 * 查询是否有子数据
	 * 
	 * @param parId
	 * @return
	 */
	public boolean hasChildren(Long parId);

	/**
	 * 根据父id查询
	 * 
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Category> queryCateList(Long shopid, Long parid);

	/**
	 * 根据父id查询
	 * 
	 * @param parid
	 * @param state
	 * @return
	 */
	public List<Category> findByPar(Long parid, String state);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Category findById(Long id);

	/**
	 * 更新
	 * 
	 * @param category
	 */
	public void update(Category category);

	/**
	 * 添加
	 * 
	 * @param category
	 */
	public Long insert(Category category);

	/**
	 * 删除
	 * 
	 * @param categoryId
	 */
	public void del(Long id);

	/**
	 * 递归删除
	 * 
	 * @param parId
	 * @throws TemplateException
	 * @throws IOException
	 */
	public void delPar(Long parId);

	/**
	 * 查询所有父栏目（递归）
	 * 
	 * @param id
	 * @return
	 */
	public String findParPro(Long id);

	/**
	 * 商城站点类目列表
	 * 
	 * @param siteid
	 * @return
	 */
	public JSONArray findBySite(Long siteid);

	/**
	 * 商城管理类目列表
	 * 
	 * @param siteid
	 * @return
	 */
	public JSONArray findByStore(Long storeid);

	/**
	 * 商城管理类目列表
	 * 
	 * @param siteid
	 * @return
	 */
	public JSONArray findByStore(Long storeid, Long parid);

}
