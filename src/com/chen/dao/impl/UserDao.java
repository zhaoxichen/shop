package com.chen.dao.impl;

import java.util.List;

import com.chen.dao.IUserDao;
import com.chen.entity.User;

/**
 * 用户模块持久层代码:
 * 
 * @author 
 * 
 */
public class UserDao extends BaseDao<User> implements IUserDao{

	// 按名次查询是否有该用户:
	public User findByUsername(String username) {
		String hql = "from User where username = ? order by uid desc";
		List<User> list = this.list(hql, username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 根据激活码查询用户
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.list(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 用户登录的方法
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = 1";
		String[] hqlParas={user.getUsername(),user.getPassword()};
		List<User> list = this.list(hql,hqlParas);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public int findCount() {
		String hql = "select count(*) from User";
		return (int) this.selectCount(hql);
	}

	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		int[] hqlPage={begin,limit};
		List<User> list = this.list(hql, null, hqlPage);
		return list;
	}
}
