 package com.qg.test;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


 public class TestController {

	 @Test
	 public void testTest91(){
		 RestTemplate restTemplate=new RestTemplate();
		 
		 MultiValueMap<String, String> form=new LinkedMultiValueMap<String, String>();
		 
		 form.add("userName", "qiugui");
		 form.add("password", "123456");
		 form.add("age", "45");
		 
		 restTemplate.postForLocation("http://localhost:8080/SpringMVC/test91.do", form);
	 }
}

 