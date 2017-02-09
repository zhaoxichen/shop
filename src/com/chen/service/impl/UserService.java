package com.chen.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.IUserDao;
import com.chen.entity.User;
import com.chen.service.IUserService;
import com.chen.utils.MailUitls;
import com.chen.utils.PageBean;
import com.chen.utils.UUIDUtils;

/**
 * 用户名模块业务层代码
 * @author 
 *
 */
@Transactional
public class UserService implements IUserService{
	// 注入UserDao
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.list("from User where username = ?",username).get(0);
	}

	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.add(user);
		// 发送激活邮件;
		MailUitls.sendMail(user.getEmail(), code);
	}

	// 业务层根据激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// 修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}

	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public User findByUid(Integer uid) {
		return userDao.get(uid);
	}

	public void delete(User existUser) {
		userDao.delete(existUser);
	}
}