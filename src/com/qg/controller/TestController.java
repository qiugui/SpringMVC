package com.qg.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.validation.Valid;





import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.qg.domain.User;


 @Controller
@SessionAttributes("user1")
 public class TestController {
 	@RequestMapping("test")
 	public String Test() {
 		System.out.println("test");
 		return "test";

 	}

 	@RequestMapping("test1")
 	public String test2(ModelMap map) {
 		System.out.println("test1");
 		map.put("test", "测试带参的逻辑视图！");
 		return "test";
 	}

 	@RequestMapping("test2")
 	public ModelAndView test1() {
 		System.out.println("test2");
 		ModelAndView view = new ModelAndView();
 		view.setViewName("test");
 		view.addObject("test2", "测试ModelAndView!");
 		return view;

 	}

 	@RequestMapping("test3/{userId}")
 	public ModelAndView test3(@PathVariable("userId") String userId) {
 		System.out.println("test3");
 		ModelAndView view = new ModelAndView();
 		view.setViewName("test");
 		view.addObject("test2", userId);
 		return view;

 	}

 	@RequestMapping("test4")
 	public ModelAndView test4(HttpServletRequest request,
 			HttpServletResponse response) {
 		System.out.println("test4");
 		String localName=request.getLocalName();
 		String URL=request.getRequestURL().toString();
 		ModelAndView view = new ModelAndView();
 		view.setViewName("test");
 		request.setAttribute("localName", localName);
 		view.addObject("URL", URL);
 		return view;

 	}

 	@RequestMapping("test5")
 	public void test5(HttpServletRequest request, HttpServletResponse response) throws ServletException {
 		System.out.println("test5");
 		try {
 			response.setContentType("text/html;charset=utf-8");
 			response.setCharacterEncoding("utf-8");
 			response.getWriter().write("<a href='#'>你好啊</a>");
// 			request.getRequestDispatcher("/test4.do").forward(request, response);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}

 	@RequestMapping(value = "test6", method = RequestMethod.POST)
 	public ModelAndView test6(@RequestParam("userId") String userId,
 			@RequestParam("password") String password) {
 		System.out.println("test6");
 		ModelAndView view = new ModelAndView();
 		view.setViewName("test");
 		view.addObject("test2", userId);
 		view.addObject("password",password);
 		return view;
 	}

 	@RequestMapping(value = "test7")
 	public ModelAndView test7(@CookieValue("JSESSIONID") String cookieId,
 			@RequestHeader("Accept-Language") String language,
 			@RequestHeader("Host") String host) {
 		ModelAndView mav=new ModelAndView();
 		System.out.println("test7");
 		System.out.println(cookieId + "   " + language+"   "+host);
 		mav.setViewName("test");
 		mav.addObject("cookieId", cookieId);
 		mav.addObject("language", language);
 		mav.addObject("host", host);
 		
 		return mav;
 		
 	}

 	@RequestMapping(value = "test8")
 	public void test8(OutputStream os) {
 		System.out.println("test8");
 		ClassPathResource rs = new ClassPathResource("../image/tomcat.png");
 		try {
 			FileCopyUtils.copy(rs.getInputStream(), os);
 			System.out.println(FileCopyUtils.copy(rs.getInputStream(), os));
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}

 	@ResponseBody
 	@RequestMapping(value = "test9")
 	public byte[] test9(HttpServletResponse response) {
 		byte[] data = null;
 		System.out.println("test9");
// 		ClassPathResource rs = new ClassPathResource("../image/tomcat.png");
 		response.setContentType("text/html;charset=utf-8");
 		try {
// 			data = FileCopyUtils.copyToByteArray(rs.getInputStream());
 			data=new String("你好").getBytes();
 			return data;
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return data;
 	}

 	@RequestMapping(value="test91",method=RequestMethod.POST)
 	public ModelAndView test91(@RequestBody String requestBody){
 		ModelAndView mav=new ModelAndView();
 		System.out.println(requestBody);
 		String s[]=requestBody.split("&");
 		for(String t:s){
 			String message[]=t.split("=");
 			System.out.println("属性名"+message[0]+"属性值"+message[1]);
 			mav.addObject(message[0], message[1]);
 		}
 		mav.setViewName("test");
 		
 		return mav;
 	}
 	
 	
 	@RequestMapping("/test10")
 	public ResponseEntity<byte[]> test11() throws Exception {
 		Resource rs = new ClassPathResource("../image/tomcat.png");
 		System.out.println("test10");
 		byte[] data = FileCopyUtils.copyToByteArray(rs.getInputStream());
 		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(
 				data, HttpStatus.OK);
 		return responseEntity;
 	}
 	
 	@RequestMapping(value = "test11")
 	public ModelAndView test10(HttpEntity<String> entity) {
 		System.out.println("test11");
 		System.out.println(entity.getBody());
 		System.out.println(entity.getHeaders().getContentLength());
 		ModelAndView view = new ModelAndView();
 		view.setViewName("test");
 		view.addObject("test2", entity.getHeaders().getIfModifiedSince() + "");
 		return view;
 	}

 	

 	@ModelAttribute("user1")
 	public User getUser() {
 		User user = new User();
 		user.setId(2);
 		user.setUsername("gaoda");
 		return user;
 	}

 	@RequestMapping("test12")
 	public String test12(@ModelAttribute("user1") User user) {
 		user.setId(3);
 		user.setUsername("qiugui");
 		return "test";
 	}

 	
 	@RequestMapping("test13")
 	public String test13(ModelMap modelMap) {
 		User user = (User) modelMap.get("user");
 		user.setUsername("张福");
 		return "test";
 	}
 	
 	@RequestMapping("test141")
 	public String test141(@ModelAttribute("user1") User user1){
 		user1.setUsername("qiugui");
 		System.out.println(user1.getId()+user1.getUsername());
 		return "redirect:/test14.do";
 	}
 	
 	@RequestMapping("test14")
 	public String test14(ModelMap modelMap, SessionStatus sessionStatus) {
 		User user1 = (User) modelMap.get("user1");
 		if (user1 != null) {
 			user1.setUsername("曾艺");
 			// 让springMvc清除本处理器对应的会话属性
 			sessionStatus.setComplete();
 		}
 		return "test";
 	}

 	// 数据校验@Valid
 	@RequestMapping(value = "test15", method = RequestMethod.GET)
 	public String test15( @ModelAttribute("user") User user,
 			BindingResult result) {
 		if(result.hasErrors())
 		{
 			return "test";
 		}
 		
 		return "";
 	}

 }


 