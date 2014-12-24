package com.qg.service.implement;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qg.dao.HibernateUtil;
import com.qg.domain.User;
import com.qg.service.interfaces.UserServiceInterface;
@Service("userService")
@Transactional
public class UserService implements UserServiceInterface {
    @Resource(name="hibernateUtil") 
	private HibernateUtil hibernateUtil;
    
    public UserService(){
    	System.out.println("UserService()对象被注入");
    }
    
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		String hql="from User where id=? and password=?";
		Object []parameters={user.getId(),user.getPassword()};
		user=hibernateUtil.checkUser(hql, parameters);		
		return user;
	}

}
