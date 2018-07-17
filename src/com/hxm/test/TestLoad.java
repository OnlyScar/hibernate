package com.hxm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hxm.pojo.Category;
import com.hxm.pojo.Product;

public class TestLoad {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/*Product p = (Product) s.load(Product.class, 6);
		System.out.println("log1");
		System.out.println(p.getName());
		System.out.println("log2");*/
		
		/*Category c = (Category) s.get(Category.class, 1);
		System.out.println("log1");
		System.out.println(c.getProducts());
		System.out.println("log2");*/
		
	
        Category c1 = (Category)s.get(Category.class, 1);
        System.out.println("log1");
        Category c2= (Category)s.get(Category.class, 1);
        System.out.println("log2");  
		s.getTransaction().commit();
		s.close();
		
		Session s2 = sf.openSession();
		s2.beginTransaction();
		Category c3 = (Category) s2.get(Category.class, 1);
	    System.out.println("log3"); 
		
		s2.getTransaction().commit();
		s2.close();
		
		sf.close();
	}

}
