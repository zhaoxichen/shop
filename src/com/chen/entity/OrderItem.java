package com.chen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chen.entity.Product;

/**
 * 订单项的实体
 * @author 
 *
 */
@Entity // 注解为hibernate实体
@Table(name="tab_orderItem") // 注解对应的表名
public class OrderItem {
	@Id	// 注解主键
	@GeneratedValue // id生成策略  默认auto 
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	// 商品外键:对象
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;
	// 订单外键:对象
	@ManyToOne
	@JoinColumn(name="oid")
	private Order order;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
