package com.gsccs.b2c.plat.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.eb.api.domain.goods.Category;

/**
 * 平台类目控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequiresPermissions("category:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "category/list";
	}

	@RequestMapping(value = "/treeGrid")
	@ResponseBody
	public JSONArray cateTree(ModelMap map, Category cate,
			HttpServletRequest request) {
		return categoryService.findAll(null);
	}

	@RequiresPermissions("category:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model, String pid) {
		model.addAttribute("op", "新增");
		model.addAttribute("pid", pid);
		return "category/edit";
	}

	@RequiresPermissions("category:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(Category category,
			RedirectAttributes redirectAttributes, String pid) {
		JsonMsg json = new JsonMsg();
		if (null != category) {
			System.out.println("categoryName=" + pid + "=========="
					+ category.getTitle());
			category.setParid(Long.valueOf(pid));
			categoryService.insert(category);
			json.setSuccess(true);
			json.setMsg("新增成功！");
		} else {
			json.setSuccess(false);
			json.setMsg("新增失败！");
		}

		return json;
	}

	@RequiresPermissions("category:update")
	@RequestMapping(value = "/{categoryId}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("categoryId") Long categoryId,
			Model model) {
		model.addAttribute("category", categoryService.findById(categoryId));
		model.addAttribute("op", "修改");
		return "category/edit";
	}

	
	@RequiresPermissions("category:update")
	@RequestMapping(value = "/{categoryId}/update", method = RequestMethod.POST)
	public String update(Category category,
			RedirectAttributes redirectAttributes) {
		categoryService.update(category);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/category";
	}

}
