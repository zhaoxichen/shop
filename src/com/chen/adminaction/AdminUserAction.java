package com.chen.adminaction;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.AdminUser;
import com.chen.service.IAdminUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8136014868431214469L;
	// 模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// 注入AdminUserService
	private IAdminUserService adminUserService;


	public IAdminUserService getAdminUserService() {
		return adminUserService;
	}


	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}


	// 后台登录的执行的方法
	public String login() {
		// 调用service方法完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 判断
		if (existAdminUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		} else {
			// 登录成功:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
}
