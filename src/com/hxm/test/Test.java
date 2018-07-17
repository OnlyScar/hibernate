package com.hxm.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hxm.pojo.Category;
import com.hxm.pojo.Product;


public class Test {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		/*Product p = (Product) s.get(Product.class, 6);
		System.out.println("id=6的产品名称是: "+p.getName());
		//s.delete(p);
		p.setName("iphone-modified");
		s.update(p);*/
		
		/**
		 * 使用HQL,根据name进行模糊查询
		 */
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%" + name + "%");
		List<Product> ps = q.list();
		for (Product p : ps) {
			System.out.println(p.getName());
		}
		
		/**
		          使用Criteria 查询数据
			1. 通过session的createCriteria创建一个Criteria 对象
			2. Criteria.add 增加约束。 在本例中增加一个对name的模糊查询(like)
			3. 调用list()方法返回查询结果的集合
			除此之外，Criteria 还可以很方便的进行进行分页查询和获取总数
		*/
		
		String name1 = "饮料";
		Criteria c = s.createCriteria(Category.class);
		c.add(Restrictions.like("name", "%"+name1+"%"));
		List<Category> cs = c.list();
		for (Category category : cs) {
			System.out.println(category.getName());
		}
		
		String sql = "select * from product_ p where p.name like '%" + name + "%'";
		Query query = s.createSQLQuery(sql);
		List<Object[]> list = query.list();
		for (Object[] os : list) {
			for (Object field : os) {
				System.out.print(field + "\t");
			}
			System.out.println();
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
}
