package com.hxm.test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hxm.pojo.Category;
import com.hxm.pojo.Product;

public class TestHibernate {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/*for (int i = 0; i < 10; i++) {
			Product p = new Product();
			//p.setId(i);
			p.setName("iphone X" + i);
			p.setPrice(6660+i);
			s.save(p);
		}*/
		
		/*Category c = new Category();
		c.setName("美食");
		s.save(c);
		
		Product p = (Product) s.get(Product.class, 8);
		p.setCategory(c);
		s.update(p);*/
		
		Category c = (Category) s.get(Category.class, 1);
		Set<Product> ps = c.getProducts();
		for (Product p : ps) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
