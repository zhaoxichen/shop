package com.chen.dao.impl;

import java.util.List;

import com.chen.dao.IOrderDao;
import com.chen.entity.Order;
import com.chen.entity.OrderItem;

public class OrderDao extends BaseDao<Order> implements IOrderDao{

	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		return (int) this.selectCount(hql,uid);
	}

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		int[] hqlPage={begin,limit};
		List<Order> list = this.list(hql,uid,hqlPage);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// DAO中统计订单个数的方法
	public int findCount() {
		String hql = "select count(*) from Order";
		return (int) this.selectCount(hql);
	}

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		int[] hqlPage={(begin-1)*limit,limit};
		List<Order> list = this.list(hql,null,hqlPage);
		return list;
	}

	// DAo中根据订单id查询订单项
	@SuppressWarnings("unchecked")
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getSession().createQuery(hql).setParameter(0, oid).list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
