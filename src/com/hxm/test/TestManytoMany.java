package com.hxm.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hxm.pojo.Product;
import com.hxm.pojo.User;

public class TestManytoMany {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
/*		//增加3个用户
        Set<User> users = new HashSet<User>();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }
          
        //产品1被用户1,2,3购买
        Product p1 = (Product) s.get(Product.class, 1);
        p1.setUsers(users);
        s.save(p1);*/
        
        Product p = (Product) s.get(Product.class, 1);
        s.delete(p);
        
        Product p2 = (Product) s.get(Product.class, 2);
        p2.setName("长度超过30的字符串作为产品名称");
        s.update(p2);
        
        s.getTransaction().commit();
        s.close();
        sf.close();
	}
}
