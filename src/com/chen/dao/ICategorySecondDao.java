package com.chen.dao;

import java.util.List;

import com.chen.entity.CategorySecond;

public interface ICategorySecondDao extends IBaseDao<CategorySecond> {

	int findCount();

	List<CategorySecond> findByPage(int begin, int limit);

}
