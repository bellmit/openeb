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

import com.gsccs.b2c.plat.site.service.NavigationService;
import com.gsccs.eb.api.domain.site.Navigation;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 页面导航光临
 */
@Controller
@RequestMapping("/nav")
public class NavController {

	@Autowired
	private NavigationService navigationService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = " ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			Navigation param,Model model) {
		List<Navigation> navList = navigationService.findnavList(param, page, rows);
		model.addAttribute("navList", navList);
		return "site/navigation-list";
	}
	
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String navForm(String id, Model model) {
		String view = "site/floor-add";
		if (null != id) {
			view = "site/floor-edit";
			Navigation navigation = navigationService.get(id);
			model.addAttribute("navigation", navigation);
		}
		return view;
	}

	/**
	 * 保存楼层信息
	 * 
	 * @param floor
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg navSave(Navigation navigation, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == navigation) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}

		navigationService.save(navigation);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
