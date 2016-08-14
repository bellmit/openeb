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

import com.gsccs.b2c.plat.site.service.ArticleService;
import com.gsccs.b2c.plat.site.service.ChannelService;
import com.gsccs.eb.api.domain.site.Article;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 文章管理
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;

	/**
	 * 文章列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String articleList(
			@RequestParam(defaultValue = " indexnum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Article param, HttpServletRequest request) {
		List<Article> articleList = articleService.find(param, order, currPage,
				pageSize);
		map.put("articleList", articleList);
		return "site/article-list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String articleForm(Long id, Model model) {
		String view = "site/article-add";
		if (null != id) {
			view = "site/article-edit";
			Article article = articleService.getArticle(id);
			model.addAttribute("article", article);
		}
		model.addAttribute("channelTree", channelService.findChannelTree(0l));
		return view;
	}

	/**
	 * 保存文章信息
	 * 
	 * @param floor
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg articleSave(Article article, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == article) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		articleService.saveArticle(article);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
