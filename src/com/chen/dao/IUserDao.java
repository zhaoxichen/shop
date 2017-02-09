package com.chen.dao;

import java.util.List;

import com.chen.entity.User;

public interface IUserDao extends IBaseDao<User> {
	User findByUsername(String username);
	User findByCode(String code);
	User login(User user);
	int findCount();
	List<User> findByPage(int begin, int limit);
}
