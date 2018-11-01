package com.ken.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ken.domain.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-Test.xml"})
public class ArticleDaoTest {

	@Autowired
	private ArticleDao articleDao;
	
	@Test
	public void testGetArticleList() {
		List<Article> articles = articleDao.getArticles("");
		System.out.println(articles);
	}

	@Test
	public void testGetArticleByCode() {
		Article article = articleDao.getArticleByCode("teamviewer-black-screen");
		System.out.println(article);
	}
	
	@Test
	public void testGetArticleListByCategory() {
		List<Article> articles = articleDao.getArticles("teamviewer-black-screen");
		System.out.println(articles);
	}
}
