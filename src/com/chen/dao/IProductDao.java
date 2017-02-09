package com.chen.dao;

import java.util.List;

import com.chen.entity.Product;

public interface IProductDao extends IBaseDao<Product> {
	List<Product> findHot();
	List<Product> findNew();
	int findCountCid(Integer cid);
	List<Product> findByPageCid(Integer cid, int begin, int limit);
	int findCountCsid(Integer csid);
	List<Product> findByPageCsid(Integer csid, int begin, int limit);
	int findCount();
	List<Product> findByPage(int begin, int limit);
}
