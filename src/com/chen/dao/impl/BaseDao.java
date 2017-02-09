package com.chen.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chen.dao.IBaseDao;

/**
 * dao层基 
 */
public class BaseDao<T> implements IBaseDao<T>{

	@Resource
	private SessionFactory sessionFactory;//注入会话工厂
	private Session session;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		this.session = sessionFactory.getCurrentSession();
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	/**
	 * 创建Class的对象来获取泛型的class
	 */
	private Class<T> clz;

//	获取传入的泛型对像
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass()))
					.getActualTypeArguments()[0]));
		}
		return clz;
	}
	/**
	 * 公共DAO的增删改查，此处是基于hibernate4的，已经摒弃了hibernate3以前的HibernateTemplate
	 */
//  �?
    @Override 
    public void add(T t) { 
	  		this.getSession().save(t);
	   }
	public Integer insert(Object object){
		return (Integer) getSession().save(object);
	}
//	�?
	@Override
	public void delete(int id) {
		this.getSession().delete(this.load(id));
	}
	@Override 
	public boolean delete(Object object){
		try {
			getSession().delete(object);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	public boolean update(Object object){
		try {
			getSession().update(object);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		return (T) this.getSession().get(getClz(), id);
	}
//	加载
	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		return (T) this.getSession().load(getClz(), id);
	}
	
//	查出结果�?
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String hql, Object[] args,int[] page) {
		Query u = this.getSession().createQuery(hql);
		if (args!=null) {
			for (int i = 0; i < args.length; i++) {
				u.setParameter(i, args[i]);
			}
		}
		if (page!=null) {
			u.setFirstResult(page[0]);
			u.setMaxResults(page[1]);
		}
		List<T> list = u.list();
		return list;
	}
	@Override
	public List<T> list(String hql, Object[] args) {
		return this.list(hql,args,null);
	}
	@Override
	public List<T> list(String hql) {
		return this.list(hql, null,null);
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[] { arg });
	}
	@Override
	public List<T> list(String hql, Object arg,int[] page) {
		return this.list(hql, new Object[] { arg }, page);
	}
//	得到记录数目
	@Override
	public long selectCount(String hql) {
		return this.selectCount(hql,null);
	}
	@Override
	public long selectCount(String hql, Object field) {
		return this.selectCount(hql,new Object[] {field});
	}
	@Override
	public long selectCount(String hql, Object[] field) {
		Query q = this.getSession().createQuery(hql);
		if (field!=null) {
			for (int i = 0; i < field.length; i++) {
				q.setParameter(i, field[i]);
			}
		}
		return (long) q.uniqueResult();
	}

}
