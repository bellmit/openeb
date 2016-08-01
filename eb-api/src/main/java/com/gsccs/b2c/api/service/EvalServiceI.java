package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.rated.EvalGoods;
import com.gsccs.eb.api.domain.rated.EvalItem;
import com.gsccs.eb.api.domain.rated.EvalModel;
import com.gsccs.eb.api.domain.rated.EvalOrder;
import com.gsccs.eb.api.domain.rated.EvalType;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 评价服务接口
 * 
 * @author x.d zhang
 * 
 */
public interface EvalServiceI {

	/**
	 * 增加评价描述
	 * 
	 * @param detail
	 */
	public void addEvalRemark(Long siteid,EvalGoods detail);

	/**
	 * 增加评价打分
	 * 
	 * @param scores
	 */
	public void addEvalScores(Long siteid, List<EvalOrder> scoreList,
			EvalGoods detail) throws ApiException;

	/**
	 * 添加评分项目
	 * 
	 * @param evalType
	 */
	public Long addEvalType(EvalType evalType);

	/**
	 * 编辑评分项目
	 * 
	 * @param evalType
	 */
	public void editEvalType(EvalType evalType);

	/**
	 * 删除评分项目
	 * 
	 * @param id
	 */
	public void delEvalType(Long id);

	/**
	 * 根据条件查询评分项目
	 * 
	 * @param evalType
	 * @return
	 */
	public List<EvalType> evalTypeList(EvalType evalType);

	/**
	 * 添加打分项
	 * 
	 * @param evalItem
	 */
	public Long addEvalItem(EvalItem evalItem);

	/**
	 * 编辑打分项
	 * 
	 * @param evalItem
	 */
	public void editEvalItem(EvalItem evalItem);

	/**
	 * 删除打分项
	 * 
	 * @param id
	 */
	public void delEvalItem(Long id);

	/**
	 * 根据条件查询打分项
	 * 
	 * @param evalItem
	 * @return
	 */
	public List<EvalItem> getEvalItems(EvalItem evalItem);

	/**
	 * 查询评分项目及打分项
	 * 
	 * @return
	 */
	public List<EvalModel> getEvals();
}
