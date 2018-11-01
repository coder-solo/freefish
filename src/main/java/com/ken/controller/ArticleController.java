package com.ken.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ken.dao.ArticleDao;
import com.ken.domain.Article;
import com.ken.util.FfConstants;
import com.ken.util.PropertyUtil;

@Controller
@RequestMapping("article")
public class ArticleController {

	private Logger logger = Logger.getLogger(ArticleController.class);

	@Autowired
	private ArticleDao articleDao;

	/**
	 * The blog action
	 * 
	 * @param year
	 * @param month
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{year}/{month}/{code}")
	public String showArticle(@PathVariable("year") String year, @PathVariable("month") String month,
			@PathVariable("code") String code, Model model) {

		Article article = articleDao.getArticleByCode(code);
		model.addAttribute("article", article);
		return "detail";
	}

	/**
	 * Get html for blog
	 * 
	 * @param year
	 * @param month
	 * @param code
	 * @param response
	 */
	@RequestMapping(value = "/{year}/{month}/{code}.html")
	public void showBlogHtml(@PathVariable("year") String year, @PathVariable("month") String month,
			@PathVariable("code") String code, HttpServletResponse response) {

		String baseBlogPath = PropertyUtil.getProperty(FfConstants.BLOG_PATH);
		File blogHtml = new File(baseBlogPath + "/" + year + "/" + month + "/" + code + ".html");
		writeFileToResponse(blogHtml, response);
	}

	/**
	 * Get png for blog
	 * 
	 * @param year
	 * @param month
	 * @param name
	 * @param response
	 */
	@RequestMapping(value = "/{year}/{month}/image/{name}.png")
	public void showBlogImg(@PathVariable("year") String year, @PathVariable("month") String month,
			@PathVariable("name") String name, HttpServletResponse response) {

		String baseBlogPath = PropertyUtil.getProperty(FfConstants.BLOG_PATH);
		File blogHtml = new File(baseBlogPath + "/" + year + "/" + month + "/image/" + name + ".png");
		writeFileToResponse(blogHtml, response);
	}

	/**
	 * List articles.
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Article> list(String categoryId) {
		List<Article> articleList = articleDao.getArticles(categoryId);
		return articleList;
	}

	/*
	 * Write html file to response
	 */
	private void writeFileToResponse(File file, HttpServletResponse response) {
		if (file == null || !file.exists()) {
			logger.error("Blog file is not found. File name: " + file);
			return;
		}

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			os = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] buf = new byte[100 * 1024];
		int len;
		try {
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
