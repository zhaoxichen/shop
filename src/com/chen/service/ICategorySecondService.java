package com.chen.service;

import java.util.List;

import com.chen.entity.CategorySecond;
import com.chen.utils.PageBean;

public interface ICategorySecondService{
	// 二级分类带有分页的查询操作:
	PageBean<CategorySecond> findByPage(Integer page);
	void save(CategorySecond categorySecond);
	void delete(CategorySecond categorySecond);
	CategorySecond findByCsid(Integer csid);
	// 业务层修改二级分类的方法
	void update(CategorySecond categorySecond);
	// 业务层查询所有二级分类(不带分页)
	List<CategorySecond> findAll();
}
