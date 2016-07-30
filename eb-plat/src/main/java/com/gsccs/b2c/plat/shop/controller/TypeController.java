package com.gsccs.b2c.plat.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.b2c.plat.shop.model.TypeForm;
import com.gsccs.b2c.plat.shop.service.SpecService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.domain.goods.Type;

/**
 * 平台商品类型控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	@Autowired
	private SpecService specService;

	@RequiresPermissions("type:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Type param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map) {
		List<Type> typeList = typeService.getTypeList(param, "", page, rows);
		int total = typeService.count(param);
		map.put("page", page);
		map.put("rows", rows);
		map.put("typeList", typeList);
		map.put("total", total);
		return "goods/type_list";
	}

	@RequiresPermissions("type:view")
	@RequestMapping(value = "/checkTypeName")
	@ResponseBody
	public Boolean checkTypeName(String typename, HttpServletRequest request) {
		List<Type> list = typeService.queryByTypeName(typename);
		if (null == list || list.size() <= 0) {
			return true;
		}else{
		}
		return false;
	}
	
	
	@RequestMapping(value = "/deleteAttr")
	@ResponseBody
	public void deleteAttr(Long propid) {
		typeService.deletePropById(propid);
	}
	
	@RequiresPermissions("type:create")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String typeForm(Long id, Model model) {
		String view = "goods/type_add";
		if (null != id) {
			view = "goods/type_edit";
			Type type = typeService.getType(id);
			String specids="";
			if (null != type && null != type.getSpecs()){
				List<Specific> specList= type.getSpecs();
				for(Specific specific:specList){
					specids = specific.getId()+","+specids;
				}
			}
			model.addAttribute("specids", specids);
			model.addAttribute("type", type);
		}
		
		List<Specific> specList = specService.getSpecList(null, "", 1, Integer.MAX_VALUE);
		model.addAttribute("specList", specList);
		return view;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String typeSave(TypeForm typeForm) {
		if (null != typeForm && null != typeForm.getGoodsType()) {
			Type type = typeForm.getGoodsType();
			type.setProps(typeForm.getAttrList());
			type.setSpecs(typeForm.getSpecList());
			if (null==type.getId()){
				typeService.addType(type);
			}else{
				typeService.updateType(type);
			}
		}
		return "redirect:/type";
	}
	
	
	@RequiresPermissions("type:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String typeDelete(Long id, Model model) {
		if (null != id) {
			typeService.deleteTypeById(id);
		}
		return "redirect:/type";
	}

}
