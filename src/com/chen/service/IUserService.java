package com.chen.service;

import com.chen.entity.User;
import com.chen.utils.PageBean;

public interface IUserService {
	// 按用户名查询用户的方法:
	User findByUsername(String username);
	// 业务层完成用户注册代码:
	void save(User user);
	// 业务层根据激活码查询用户
	User findByCode(String code);
	// 修改用户的状态的方法
	void update(User existUser);
	// 用户登录的方法
	User login(User user);
	// 业务层用户查询所有
	PageBean<User> findByPage(Integer page);
	User findByUid(Integer uid);
	void delete(User existUser);
}
