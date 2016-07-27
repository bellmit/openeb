package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.EvalGoods;
import com.gsccs.b2c.api.domain.EvalItem;
import com.gsccs.b2c.api.domain.EvalModel;
import com.gsccs.b2c.api.domain.EvalOrder;
import com.gsccs.b2c.api.domain.EvalType;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.shop.model.EvalGoodsT;
import com.gsccs.b2c.plat.shop.model.EvalItemT;
import com.gsccs.b2c.plat.shop.model.EvalOrderT;
import com.gsccs.b2c.plat.shop.model.EvalTypeT;
import com.gsccs.b2c.plat.shop.service.EvalService;
import com.gsccs.eb.api.domain.deliver.DeliverType;

/**
 * 评价服务接口
 * @author x.d zhang
 *
 */
public class EvalServiceAPI implements EvalServiceI {

	@Autowired
	private EvalService evalService;
	
	@Override
	public void addEvalRemark(Long siteid,EvalGoods detail) {
		if (null != detail){
			EvalGoodsT detailT = new EvalGoodsT();
			detailT.setProductid(detail.getProductid());
			detailT.setSiteid(detail.getSiteid());
			detailT.setContent(detail.getContent());
			detailT.setUserid(detail.getUserid());
			evalService.addEvalRemark(siteid,detailT);
		}
	}


	@Override
	public void addEvalScores(Long siteid,List<EvalOrder> scoreList, EvalGoods detail) throws ApiException {
		if (null == siteid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		if (null != scoreList && scoreList.size()>0){
			List<EvalOrderT> scoreTList = new ArrayList<EvalOrderT>();
			for(int i=0;i<scoreList.size();i++){
				EvalOrder score =scoreList.get(i); 
				EvalOrderT scoreT = new EvalOrderT();
				scoreT.setScore(score.getScore());
				scoreT.setItemid(score.getItemId());
				scoreT.setProductid(score.getProductid());
				scoreT.setUserid(score.getUserid());
				scoreTList.add(scoreT);
			}
			evalService.addEvalScore(siteid,scoreTList);
		}
		
		if (null != detail){
			EvalGoodsT detailT = new EvalGoodsT();
			detailT.setProductid(detail.getProductid());
			detailT.setSiteid(detail.getSiteid());
			detailT.setContent(detail.getContent());
			detailT.setUserid(detail.getUserid());
			evalService.addEvalRemark(siteid,detailT);
		}
		
	}


	
	@Override
	public Long addEvalType(EvalType et) {
		EvalTypeT ett = new EvalTypeT();
		try {
			BeanUtils.copyProperties(ett,et);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return evalService.addEvalTypeT(ett);
	}

	@Override
	public void editEvalType(EvalType et) {
		EvalTypeT ett = new EvalTypeT();
		try {
			BeanUtils.copyProperties(ett,et);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		evalService.editEvalTypeT(ett);
	}

	@Override
	public void delEvalType(Long id) {
		evalService.delEvalTypeT(id);
	}

	@Override
	public List<EvalType> evalTypeList(EvalType et) {
		List<EvalType> etList = new ArrayList<EvalType>();
		List<EvalTypeT> ettList =null;
		EvalTypeT ett = new EvalTypeT();
		try {
			BeanUtils.copyProperties(ett,et);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ettList = evalService.getEvalTypes(ett);
		EvalType evalType = null;
		if(ettList !=null && ettList.size() >0){
			for (EvalTypeT evalTypeT : ettList) {
				evalType = new EvalType();
				try {
					BeanUtils.copyProperties(evalType,evalTypeT);
					etList.add(evalType);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return etList;
	}

	@Override
	public Long addEvalItem(EvalItem ei) {
		EvalItemT eit = new EvalItemT();
		try {
			BeanUtils.copyProperties(eit,ei);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return evalService.addEvalItem(eit);
	}

	@Override
	public void editEvalItem(EvalItem ei) {
		EvalItemT eit = new EvalItemT();
		try {
			BeanUtils.copyProperties(eit,ei);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		evalService.editEvalItem(eit);
	}

	@Override
	public void delEvalItem(Long id) {
		evalService.delEvalItem(id);
	}

	@Override
	public List<EvalItem> getEvalItems(EvalItem ei) {
		List<EvalItem> eiList = new ArrayList<EvalItem>();
		List<EvalItemT> eitList =null;
		EvalItemT eit = new EvalItemT();
		try {
			BeanUtils.copyProperties(eit,ei);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		eitList = evalService.getEvalItems(eit);
		EvalItem evalItem = null;
		if(eitList !=null && eitList.size() >0){
			for (EvalItemT evalItemT : eitList) {
				evalItem = new EvalItem();
				try {
					BeanUtils.copyProperties(evalItem,evalItemT);
					eiList.add(evalItem);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return eiList;
	}

	@Override
	public List<EvalModel> getEvals() {
		List<EvalModel> evalList = new ArrayList<EvalModel>();
		EvalTypeT ett = new EvalTypeT();
		List<EvalTypeT> ettList = evalService.getEvalTypes(ett);
		EvalModel em = null;
		List<EvalItem> eiList = null; 
		List<EvalItemT> eitList = null;
		EvalItemT  eit = null;
		
		if(null !=ettList){
			for (EvalTypeT e : ettList) {
				
				em = new EvalModel();
				em.setSiteid(e.getSiteid());
				em.setTypeid(e.getId());
				em.setTypename(e.getTitle());
				em.setIsdefault(e.getIsdefault());
				em.setState(e.getState());
				em.setTypeid(e.getId());
				
				eit = new EvalItemT();
				eit.setTypeid(e.getId());
				
				EvalItem ei = null;
				
				eitList = evalService.getEvalItems(eit);
				
				eiList = new ArrayList<EvalItem>();
				
				if(null !=eitList){
					for (EvalItemT evalItemT : eitList) {
						ei = new EvalItem();
						try {
							BeanUtils.copyProperties(ei,evalItemT);
							eiList.add(ei);
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							e1.printStackTrace();
						}
					}
					em.setEiList(eiList);
				}
				evalList.add(em);
			}
		}
		return evalList;
	}


	

	
	

}
