package com.chen.dao.impl;

import java.util.List;

import com.chen.dao.IAdminUserDao;
import com.chen.entity.AdminUser;

public class AdminUserDao extends BaseDao<AdminUser> implements IAdminUserDao{

	// Dao完成登录的代码
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		String[] hqlParas = {adminUser.getUsername(),adminUser.getPassword()}; 
		List<AdminUser> list = this.list(hql,hqlParas);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
