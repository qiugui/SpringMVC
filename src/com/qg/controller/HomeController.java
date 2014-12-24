package com.qg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//声明为控制器
@Controller
public class HomeController {

	public HomeController(){
		System.out.println("HomeController()控制器被注入");
	}
	
	//声明请求处理方法
	@RequestMapping({"/","/html/home"})
	public String showHomePage(Map<String,Object> model){
//		model.put("xinxi", "你好！");
		System.out.println("进入showHomePage");
		return "home";
	}
	
}
