package com.chen.dao;

import com.chen.entity.AdminUser;

public interface IAdminUserDao extends IBaseDao<AdminUser>{
	AdminUser login(AdminUser adminUser);
}
