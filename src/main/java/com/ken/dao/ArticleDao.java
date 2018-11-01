package com.ken.dao;

import java.util.List;

import com.ken.domain.Article;

public interface ArticleDao {

	List<Article> getArticles();

	List<Article> getArticles(String categoryId);

	Article getArticleByCode(String code);
}
