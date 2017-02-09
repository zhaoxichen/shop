package com.chen.service;

import java.util.List;

import com.chen.entity.Product;
import com.chen.utils.PageBean;

public interface IProductService {
	// 首页上热门商品查询
	List<Product> findHot();// 首页上最新商品的查询
	List<Product> findNew();// 根据商品ID查询商品
	Product findByPid(Integer pid);// 根据一级分类的cid带有分页查询商品
	PageBean<Product> findByPageCid(Integer cid, int page);// 根据二级分类查询商品信息
	PageBean<Product> findByPageCsid(Integer csid, int page);// 后台查询所有商品带分页
	PageBean<Product> findByPage(Integer page);// 业务层保存商品方法:
	void save(Product product);// 业务层删除商品
	void delete(Product product);
	// 业务层修改商品的方法
	void update(Product product);
}
