package com.gsccs.b2c.plat.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.auth.model.DictGroup;
import com.gsccs.b2c.plat.auth.model.DictItem;
import com.gsccs.b2c.plat.auth.service.DictService;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 数据字典
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class DictController {

	@Autowired
	private DictService dictService;

	@RequestMapping(value = "/dictgroup", method = RequestMethod.GET)
	public String dictgroup(DictGroup param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, ModelMap map,
			HttpServletRequest request) {
		List<DictGroup> dictgroupList = dictService.findGroupList(param, page,
				rows);
		map.put("dictGroupList", dictgroupList);
		return "auth/dictgroup-list";
	}

	@RequestMapping(value = "/dictgroup/form", method = RequestMethod.GET)
	public String dictgroupForm(String id, ModelMap map) {
		DictGroup dictGroup = null;
		if (StringUtils.isNotEmpty(id)) {
			dictGroup = dictService.getGroupById(id);
		}
		map.put("dictGroup", dictGroup);
		return "auth/dictgroup-add";
	}

	@ResponseBody
	@RequestMapping(value = "/dictgroup/save", method = RequestMethod.POST)
	public JsonMsg dictgroupSave(DictGroup dictGroup, ModelMap map) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == dictGroup) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}

		try {
			dictService.saveDictGroup(dictGroup);
			jsonMsg.setSuccess(true);
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
		}
		return jsonMsg;
	}

	@RequestMapping(value = "/dictitem", method = RequestMethod.GET)
	public String dictitem(String groupid,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, ModelMap map,
			HttpServletRequest request) {
		DictItem param = new DictItem();
		param.setGroupid(groupid);
		List<DictItem> dictItemList = dictService.findItemList(param, page,
				rows);
		map.put("dictItemList", dictItemList);
		return "auth/dictitem-list";
	}
	
	
	@RequestMapping(value = "/dictitem/form", method = RequestMethod.GET)
	public String dictItemForm(String id,String groupid, ModelMap map) {
		DictGroup dictGroup = null;
		DictItem dictItem = null;
		if (StringUtils.isNotEmpty(id)) {
			dictItem = dictService.getDictById(id);
			if (null != dictItem){
				groupid = dictItem.getGroupid();
			}
		}
		
		if (StringUtils.isNotEmpty(groupid)){
			dictGroup = dictService.getGroupById(groupid);
		}
		map.put("dictItem", dictItem);
		map.put("dictGroup", dictGroup);
		return "auth/dictitem-add";
	}

	@ResponseBody
	@RequestMapping(value = "/dictitem/save", method = RequestMethod.POST)
	public JsonMsg dictItemSave(DictItem dictItem, ModelMap map) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == dictItem) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		try {
			dictService.saveDictItem(dictItem);
			jsonMsg.setSuccess(true);
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
		}
		return jsonMsg;
	}

}
