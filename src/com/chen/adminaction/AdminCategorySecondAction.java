package com.chen.adminaction;

import java.util.List;

import com.chen.entity.Category;
import com.chen.entity.CategorySecond;
import com.chen.service.ICategorySecondService;
import com.chen.service.ICategoryService;
import com.chen.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台二级分类的管理的Action.
 * 
 * @author
 * 
 */
public class AdminCategorySecondAction implements ModelDriven<CategorySecond> {

	// 模型驱动使用的对象
	private CategorySecond categorySecond = new CategorySecond();
	// 接收page参数:
	private Integer page;
	// 注入二级Service
	private ICategorySecondService categorySecondService;
	// 注入一级分类的Service
	private ICategoryService categoryService;

	public void setPage(Integer page) {
		this.page = page;
	}

	public ICategorySecondService getCategorySecondService() {
		return categorySecondService;
	}

	public void setCategorySecondService(ICategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategorySecond getModel() {
		return categorySecond;
	}

	// 带有分页的查询所有二级分类的操作:
	public String findAll() {
		// 调用Service进行查询.
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		// 将pageBean的数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 跳转到天津页面的方法:
	public String addPage() {
		// 查询所有一级分类.
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// 页面跳转:
		return "addPage";
	}

	// 添加二级分类的方法:
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	// 删除二级分类的方法:
	public String delete() {
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}

	// 编辑二级分类的方法:
	public String edit() {
		// 根据id查询二级分类:
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		// 查询所有一级分类:
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// 页面跳转:
		return "editSuccess";
	}

	// 修改二级分类的方法:
	public String update() {
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
