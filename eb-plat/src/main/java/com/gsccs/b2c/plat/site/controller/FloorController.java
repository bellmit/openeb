package com.gsccs.b2c.plat.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.b2c.plat.site.service.FloorService;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.site.Floor;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 楼层管理
 */
@Controller
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 楼层管理
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Floor> floorList = floorService.findFloorList(0l);
		model.addAttribute("floorList", floorList);
		return "site/floor-list";
	}
	
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String floorForm(String id, Model model) {
		List<Goods> goodsList = null;
		List<Category> categorieList = null;
		Floor floor = null;
		String view = "site/floor-add";
		if (null != id) {
			view = "site/floor-edit";
			floor = floorService.getFloor(id);
		}
		
		if (null != floor){
			if (StringUtils.isNotEmpty(floor.getGoodids())){
				goodsList = goodsService.findGoodsList(floor.getGoodids());
			}
			
			if (StringUtils.isNotEmpty(floor.getCateids())){
				categorieList = categoryService.findCateList(floor.getCateids());
			}
			
			model.addAttribute("floor", floor);
			model.addAttribute("goodsList", goodsList);
			model.addAttribute("categorieList", categorieList);
		}
		model.addAttribute("categoryTree", categoryService.findCategoryTree(0l));
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
	public JsonMsg floorSave(Floor floor, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == floor) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}

		floorService.saveFloor(floor);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
