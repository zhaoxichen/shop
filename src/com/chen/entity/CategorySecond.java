package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chen.entity.Category;
import com.chen.entity.Product;

/**
 * 二级分类的实体
 * @author 
 *
 */
@Entity // 注解为hibernate实体
@Table(name="tab_categorySecond") // 注解对应的表名
public class CategorySecond {
	@Id	// 注解主键
	@GeneratedValue // id生成策略  默认auto 
	private Integer csid;
	private String csname;
	// 所属一级分类.存的是一级分类的对象.
	@ManyToOne
	@JoinColumn(name="cid")
	private Category category;
	// 配置商品集合
	@OneToMany(mappedBy="categorySecond")//对应 product类的categorySecond属性
	private Set<Product> products = new HashSet<Product>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
