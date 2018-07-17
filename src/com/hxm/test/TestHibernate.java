package com.hxm.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hxm.pojo.Product;

public class TestHibernate {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = new Product();
		p.setName("iphone X");
		p.setPrice(8888);
		s.save(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
