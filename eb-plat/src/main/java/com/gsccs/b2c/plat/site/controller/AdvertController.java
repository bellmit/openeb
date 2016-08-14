package com.gsccs.b2c.plat.site.controller;

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

import com.gsccs.b2c.plat.site.service.AdvertService;
import com.gsccs.eb.api.domain.site.Advert;
import com.gsccs.eb.api.domain.site.AdvertSpace;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 广告管理
 */
@Controller
public class AdvertController {

	@Autowired
	private AdvertService advertService;

	/**
	 * 广告位管理
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adspace", method = RequestMethod.GET)
	public String spaceList(
			@RequestParam(defaultValue = " ordernum ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, AdvertSpace param,
			Model model) {
		List<AdvertSpace> spaceList = advertService.find(param, order, page,
				rows);
		model.addAttribute("spaceList", spaceList);
		return "site/adspace-list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adspace/form", method = RequestMethod.GET)
	public String adspaceForm(Long id, Model model) {
		AdvertSpace adspace = null;
		String view = "site/adspace-add";
		if (null != id) {
			view = "site/adspace-edit";
			adspace = advertService.getAdvertSpace(id);
		}
		model.addAttribute("adspace", adspace);
		return view;
	}

	/**
	 * 保存广告位信息
	 * 
	 * @param adspace
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adspace/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg adspaceSave(AdvertSpace adspace, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == adspace) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		advertService.saveAdvertSpace(adspace);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	/**
	 * 广告管理
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/advert", method = RequestMethod.GET)
	public String advertList(
			@RequestParam(defaultValue = " ordernum ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Advert param,
			Model model) {
		List<Advert> advertList = advertService.find(param, order, page, rows);
		
		AdvertSpace spaceParam =new AdvertSpace();
		spaceParam.setShopid(0l);
		spaceParam.setState("1");
		List<AdvertSpace> spaceList = advertService.find(spaceParam, "", 1, Integer.MAX_VALUE);
		model.addAttribute("spaceList", spaceList);
		model.addAttribute("advertList", advertList);
		return "site/advert-list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/advert/form", method = RequestMethod.GET)
	public String advertForm(Long id, Model model) {
		Advert advert = null;
		String view = "site/advert-add";
		if (null != id) {
			view = "site/advert-edit";
			advert = advertService.getAdvert(id);
		}
		
		AdvertSpace param =new AdvertSpace();
		param.setShopid(0l);
		param.setState("1");
		List<AdvertSpace> spaceList = advertService.find(param, "", 1, Integer.MAX_VALUE);
		model.addAttribute("advert", advert);
		model.addAttribute("spaceList", spaceList);
		return view;
	}

	/**
	 * 保存广告信息
	 * 
	 * @param advert
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/advert/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg advertSave(Advert advert, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == advert) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		advertService.saveAdvert(advert);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
