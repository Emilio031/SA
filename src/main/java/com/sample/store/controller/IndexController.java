package com.sample.store.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class IndexController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("index");
		
		return model;
	}
	


}
