package com.chen.dao;

import java.util.List;

public interface IBaseDao<T> {
	//下面三个方法不需要得到返回的对象是什么，不用泛型的T来得到它，这样的通用性更高一些
	Integer insert(Object object);
	boolean update(Object object);
	boolean delete(Object object);
	void add(T t);
	void delete(int id);
	T load(int id);
	T get(int id);
	List<T> list(String hql,Object[] args,int[] page);
	List<T> list(String hql, Object[] args); 
	List<T> list(String hql);
	List<T> list(String hql,Object arg);
	List<T> list(String hql, Object arg,int[] page);
//	获取总数
	long selectCount(String hql);
	long selectCount(String hql,Object field);
	long selectCount(String hql,Object[] field);
}
