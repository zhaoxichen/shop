package com.chen.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.IAdminUserDao;
import com.chen.entity.AdminUser;
import com.chen.service.IAdminUserService;
@Transactional
public class AdminUserService implements IAdminUserService{
	// 注入Dao
	private IAdminUserDao adminUserDao;

	public IAdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(IAdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
