//package com.qg.test;
////
////import org.hibernate.Session;
////import org.hibernate.SessionFactory;
////import org.hibernate.Transaction;
////import org.hibernate.cfg.Configuration;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.context.ApplicationContext;
////import org.springframework.context.support.ClassPathXmlApplicationContext;
////
////import com.qg.domain.User;
//import com.qg.util.MD5;
////
//public class Test {
////
////	
//	public static void main(String[] args) {
//////		// TODO Auto-generated method stub
//////		
//////		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc-servlet.xml");
//////		Session s=HibernateUtil.getCurrentSession();
//////		
//////		Transaction tx=s.beginTransaction();
//////		User u=new User();
////////		u.setEmail("taogang@sina.com");
////////		u.setPassword("123456");
////////		u.setUsername("taogang");
////////
////////		s.save(u);
//////		tx.commit();
//////		
//////		u=(User) s.get(User.class, 3);
//////		System.out.println(u.getUsername()+""+u.getPassword());
//////		
//////		
//////		if (s!=null&&s.isOpen()){
//////			s.close();
//////		}
////		
////		
//		System.out.println(MD5.encipher("123456"));
//e10adc3949ba59abbe56e057f20f883e
//	}
////
//}
