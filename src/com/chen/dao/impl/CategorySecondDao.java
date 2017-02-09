package com.chen.dao.impl;

import java.util.List;

import com.chen.dao.ICategorySecondDao;
import com.chen.entity.CategorySecond;

/**
 * 二级分类的Dao层的代码
 * 
 * @author 昭熙
 * 
 */
public class CategorySecondDao extends BaseDao<CategorySecond> implements ICategorySecondDao{

	// DAO中的统计二级分类个数的方法
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		return (int) this.selectCount(hql);
	}

	// DAO中分页查询的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		int[] hqlPage={begin,limit};
		List<CategorySecond> list = this.list(hql,null,hqlPage);
		return list;
	}

	// DAO中的查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.list(hql);
	}
}
