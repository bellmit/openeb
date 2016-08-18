package com.gsccs.b2c.plat.rated.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.rated.model.EvalGoodsT;
import com.gsccs.b2c.plat.rated.service.EvalService;

/**
 * 评价管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/eval")
public class EvalController {

	@Autowired
	private EvalService evalService;

	/**
	 * 商品评价
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public String evalProduct() {
		return "eval/eval-goods";
	}

	/**
	 * 订单评价
	 * 
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String evalOrder() {
		return "eval/eval-order";
	}

	/**
	 * 商品评价
	 * 
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param orderT
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goodsEvalList", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " addtime desc ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Long siteid, EvalGoodsT param, HttpServletRequest request) {

		List<EvalGoodsT> evalProductTs = evalService.findProductEvals(siteid,
				param, pageSize, currPage);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(evalProductTs);
		return datagrid;
	}

}
