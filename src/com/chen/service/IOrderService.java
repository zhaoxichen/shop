package com.chen.service;

import java.util.List;

import com.chen.entity.Order;
import com.chen.entity.OrderItem;
import com.chen.utils.PageBean;

public interface IOrderService {
	// 业务层保存订单的方法
	public void save(Order order);
	// 业务层根据用户id查询订单,带分页查询.
	public PageBean<Order> findByUid(Integer uid,Integer page);
	// 根据订单id查询订单
	public Order findByOid(Integer oid);
	// 业务层修改订单的方法:
	public void update(Order currOrder);
	// 业务层查询所有订单方法
	public PageBean<Order> findAll(Integer page);
	// 业务层查询订单项的方法
	public List<OrderItem> findOrderItem(Integer oid);
}
