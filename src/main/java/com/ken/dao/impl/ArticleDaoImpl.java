package com.ken.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ken.dao.ArticleDao;
import com.ken.dao.BaseDao;
import com.ken.domain.Article;

@Repository(value = "articleDao")
public class ArticleDaoImpl extends BaseDao implements ArticleDao {

	public List<Article> getArticles() {
		List<Article> articleList = super.getList("getArticles");
		return articleList;
	}

	public List<Article> getArticles(String categoryId) {
		List<Article> articleList = super.getList("getArticles", categoryId);
		return articleList;
	}

	public Article getArticleByCode(String code) {
		return super.get("getArticleByCode", code);
	}

}
