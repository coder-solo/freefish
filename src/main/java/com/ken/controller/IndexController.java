package com.ken.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ken.dao.ArticleDao;
import com.ken.dao.CategoryDao;
import com.ken.domain.Article;
import com.ken.domain.Category;

@Controller
public class IndexController {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private CategoryDao categoryDao;

	/**
	 * Home page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<Article> articleList = articleDao.getArticles(null);
		model.addAttribute("articleList", articleList);
		return "home";
	}

	/**
	 * List page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Article> articleList = articleDao.getArticles("");
		model.addAttribute("articleList", articleList);

		List<Category> categoryList = categoryDao.getCategorys();
		model.addAttribute("categoryList", categoryList);
		return "list";
	}

	@RequestMapping(value = "/about")
	public String about(Model model) {
		return "about";
	}

	/**
	 * error
	 */
	@RequestMapping("error/{code}")
	public String redirectError(@PathVariable("code") String code, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "error/" + code;
	}
}
