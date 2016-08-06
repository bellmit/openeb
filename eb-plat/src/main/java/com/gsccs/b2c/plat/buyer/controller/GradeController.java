package com.gsccs.b2c.plat.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.buyer.service.BuyerService;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 会员管理
 */
@Controller("BuyerGradeCtl")
@RequestMapping("/bgrade")
public class GradeController {

	@Autowired
	private BuyerService buyerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Grade param, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Model model) {
		List<Grade> gradeList = buyerService.findGradeList();
		model.addAttribute("gradeList", gradeList);
		return "buyer/grade-list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String gradeForm(Long id, Model model) {
		String view = "buyer/grade-add";
		if (null != id) {
			view = "buyer/grade-edit";
			Grade grade = buyerService.getGrade(id);
			model.addAttribute("grade", grade);
		}
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg gradeSave(Grade grade,ModelMap map, HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null==grade){
			jsonMsg.setSuccess(false);
		}
		try{
			buyerService.saveGrade(grade);
			jsonMsg.setSuccess(true);
		}catch(Exception e){
			jsonMsg.setSuccess(false);
			e.printStackTrace();
		}
		return jsonMsg;
	}

}
