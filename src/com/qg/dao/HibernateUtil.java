package com.qg.dao;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qg.domain.User;

@Repository("hibernateUtil")
public class HibernateUtil{
    @Resource
	private SessionFactory sessionFactory;
    

    public HibernateUtil(){
    	System.out.println("HibernateUtil()对象被注入");
    }
    
	//提供一个用于验证用户的check方法
	public User checkUser(String hql,Object[]parameters){
	
		Session session=sessionFactory.getCurrentSession();
		User user=null;	
		
			Query query=session.createQuery(hql);

			if (parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setParameter(i, parameters[i]);
				}
			}		
			user=(User) query.uniqueResult();
			return user;
			

	}
}
