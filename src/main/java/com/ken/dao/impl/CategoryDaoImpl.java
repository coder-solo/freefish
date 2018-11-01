package com.ken.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ken.dao.BaseDao;
import com.ken.dao.CategoryDao;
import com.ken.domain.Category;

@Repository(value = "categoryDao")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	public List<Category> getCategorys() {
		List<Category> categoryList = super.getList("getCategorys");
		return categoryList;
	}

}
