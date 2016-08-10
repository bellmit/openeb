package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.eb.api.domain.site.Article;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface ArticleService {

	public void addArticle(Article conten);

	public Article getArticle(Long id);

	public void delArticle(Long id);

	public List<Article> find(Article content);

	public List<Article> find(Article content, String order, int currPage,
			int pageSize);

	public int count(Article content);

	public void update(Article content);

	public void index();
}
