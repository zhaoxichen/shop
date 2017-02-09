package com.chen.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.ICategoryDao;
import com.chen.entity.Category;
import com.chen.service.ICategoryService;

/**
 * 一级分类的业务层对象
 * @author 
 *
 */
@Transactional
public class CategoryService implements ICategoryService{
	// 注入CategoryDao
	private ICategoryDao categoryDao;

	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有一级分类的方法
	public List<Category> findAll() {
		return categoryDao.list("from Category");
	}

	// 业务层保存一级分类的操作
	public void save(Category category) {
		categoryDao.add(category);
	}

	// 业务层根据一级分类id查询一级分类
	public Category findByCid(Integer cid) {
		return categoryDao.get(cid);
	}

	// 业务层删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	// 业务层修改一级分类
	public void update(Category category) {
		categoryDao.update(category);
	}
	
}
