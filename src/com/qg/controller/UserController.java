package com.qg.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qg.domain.User;
import com.qg.service.interfaces.UserServiceInterface;
import com.qg.util.MD5;

@Controller
public class UserController {
	@Resource(name="userService")
	UserServiceInterface userService;
	
	public UserController(){
		System.out.println("UserController()控制器被注入");
	}
	
	@RequestMapping(value="checkuser",method=RequestMethod.POST)
	public ModelAndView checkUser(User user){
		ModelAndView mav=new ModelAndView();
		user.setPassword(MD5.encipher(user.getPassword()));
		user=userService.checkUser(user);
		if (user!=null){
			mav.setViewName("mainview");
			mav.addObject("user", user);
			return mav;
		} else {
			mav.setViewName("err");
			return mav;
		}
	}
}
