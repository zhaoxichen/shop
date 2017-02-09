package com.chen.dao;

import java.util.List;

import com.chen.entity.Order;
import com.chen.entity.OrderItem;

public interface IOrderDao extends IBaseDao<Order> {
	int findCountByUid(Integer uid);
	List<Order> findPageByUid(Integer uid, int begin, int limit);
	int findCount();
	List<Order> findByPage(int begin, int limit);
	List<OrderItem> findOrderItem(Integer oid);
}
