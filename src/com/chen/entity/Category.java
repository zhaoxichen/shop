package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 一级分类的实体类对象
 * @author 
 *
 */
@Entity // 注解为hibernate实体
@Table(name="tab_category") // 注解对应的表名
public class Category {
	@Id	// 注解主键
	@GeneratedValue // id生成策略  默认auto 
	private Integer cid;
	private String cname;
	// 一级分类中存放二级分类的集合:  对应CategorySecond类的category属性
	@OneToMany(fetch=FetchType.EAGER,mappedBy="category",cascade={CascadeType.DETACH})
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
