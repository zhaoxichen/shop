package com.chen.adminaction;

import com.chen.entity.User;
import com.chen.service.IUserService;
import com.chen.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台用户管理的Action类
 * 
 * @author 熙
 *
 */
public class UserAdminAction implements ModelDriven<User> {
	// 模型驱动使用的类
	private User user = new User();

	public User getModel() {
		return user;
	}

	// 注入用户的Service
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	// 接受page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 后台查询所有用户的方法带分页:
	public String findAll() {
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 后台用户的删除
	public String delete() {
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}

	// 后台用户的编辑
	public String edit() {
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}

	// 后台用户的修改:
	public String update() {
		userService.update(user);
		return "updateSuccess";
	}
}
