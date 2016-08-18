package com.gsccs.b2c.plat.rated.service;

import java.util.List;

import com.gsccs.b2c.plat.rated.model.EvalConfT;
import com.gsccs.b2c.plat.rated.model.EvalGoodsT;
import com.gsccs.b2c.plat.rated.model.EvalItemT;
import com.gsccs.b2c.plat.rated.model.EvalOrderT;
import com.gsccs.b2c.plat.rated.model.EvalTypeT;

/**
 * 商家评分接口
 * 
 * @author x.d zhang
 * 
 */
public interface EvalService {

	/**
	 * 获得评分配置信息
	 * 
	 * @param siteid
	 * @param id
	 * @return
	 */
	public EvalConfT getEvalConf(Long siteid, Long id);

	/**
	 * 添加评分项目
	 * 
	 * @param evalTypeT
	 * @return
	 */
	public Long addEvalTypeT(EvalTypeT evalTypeT);

	/**
	 * 删除评分项目
	 * 
	 * @param id
	 * @return
	 */
	public void delEvalTypeT(Long id);

	/**
	 * 编辑评分项目
	 * 
	 * @param evalTypeT
	 */
	public void editEvalTypeT(EvalTypeT evalTypeT);

	/**
	 * 根据站点Id获得评分项目
	 * 
	 * @param siteid
	 * @return
	 */
	public List<EvalTypeT> getEvalTypes(Long siteid);

	/**
	 * 根据条件查询评分项目
	 * 
	 * @param evalTypeT
	 * @return
	 */
	public List<EvalTypeT> getEvalTypes(EvalTypeT evalTypeT);

	/**
	 * 根据站点id获得打分项
	 * 
	 * @param siteid
	 * @return
	 */
	public List<EvalItemT> getEvalItems(Long siteid);

	/**
	 * 添加打分项
	 * 
	 * @param evalItemT
	 * @return
	 */
	public Long addEvalItem(EvalItemT evalItemT);

	/**
	 * 添加评价内容
	 * 
	 * @param evalItemT
	 * @return
	 */
	public void addEvalRemark(Long siteid, EvalGoodsT detailT);

	/**
	 * 添加打分
	 * 
	 * @param scoreList
	 */
	public void addEvalScore(Long siteid, List<EvalOrderT> scoreList);

	/**
	 * 删除打分项
	 * 
	 * @param id
	 * @return
	 */
	public void delEvalItem(Long id);

	/**
	 * 编辑打分项目
	 * 
	 * @param evalItemT
	 */
	public void editEvalItem(EvalItemT evalItemT);

	/**
	 * 根据条件获得打分项
	 * 
	 * @param evalItemT
	 */
	public List<EvalItemT> getEvalItems(EvalItemT evalItemT);

	/**
	 * 查询商品评价记录
	 * 
	 * @param siteid
	 * @param productid
	 * @return
	 */
	public List<EvalGoodsT> findProductEvals(Long siteid, EvalGoodsT param,
			int pagesize, int rows);

	/**
	 * 查询订单评价记录
	 * 
	 * @param siteid
	 * @return
	 */
	public void findOrderEvals(Long siteid, int pagesize, int rows);

}
