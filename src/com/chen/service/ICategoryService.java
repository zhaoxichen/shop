package com.chen.service;

import java.util.List;

import com.chen.entity.Category;

public interface ICategoryService {
	// 业务层查询所有一级分类的方法
	List<Category> findAll();
	// 业务层保存一级分类的操作
	void save(Category category);
	// 业务层根据一级分类id查询一级分类
	Category findByCid(Integer cid);
	// 业务层删除一级分类
	void delete(Category category);
	// 业务层修改一级分类
	 void update(Category category);
}
