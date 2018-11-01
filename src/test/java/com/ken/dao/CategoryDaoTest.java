package com.ken.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ken.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-Test.xml" })
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testGetArticleList() {
		List<Category> categorys = categoryDao.getCategorys();
		System.out.println(categorys);
	}
}
