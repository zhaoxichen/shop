package com.chen.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chen.dao.IProductDao;
import com.chen.entity.Product;

/**
 * 商品持久层的代码
 * 
 * @author
 * 
 */
public class ProductDao extends BaseDao<Product> implements IProductDao{

	// 首页上热门商品查询
	public List<Product> findHot() {
		// 使用离线条件查询.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 查询热门的商品,条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		// 倒序排序输出:
/*		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;*/
		int[] hqlPage={0,10};
		return this.list("from Product",null,hqlPage);
	}

	// 首页上最新商品的查询
	public List<Product> findNew() {
		// 使用离线条件查询:
//		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
//		// 按日期进行倒序排序:
//		criteria.addOrder(Order.desc("pdate"));
//		// 执行查询:
//		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		int[] hqlPage={0,10};
		return this.list("from Product order by pid desc",null,hqlPage);
	}
	
	// 根据分类id查询商品的个数
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		return (int) this.selectCount(hql,cid);
	}

	// 根据分类id查询商品的集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		int[] hqlPage={begin,limit};
		// 分页另一种写法:
		List<Product> list = this.list(hql, cid, hqlPage);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
		
	}

	// 根据二级分类查询商品个数
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		return (int) this.selectCount(hql,csid);
	}

	// 根据二级分类查询商品信息
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		int[] hqlPage={begin,limit};
		List<Product> list = this.list(hql,csid,hqlPage);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	// 后台统计商品个数的方法
	public int findCount() {
		String hql = "select count(*) from Product";
		return (int) this.selectCount(hql);
	}

	// 后台查询所有商品的方法
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list =this.list(hql);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}
