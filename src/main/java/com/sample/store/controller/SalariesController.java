package com.sample.store.controller;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import com.sample.store.dao.SalariesDAO;

import com.sample.store.entity.Salaries;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class SalariesController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Salaries", method = RequestMethod.GET)
	public ModelAndView getSalariesList(){
	
		ModelAndView model = new ModelAndView("Salaries");

		SalariesDAO salariesDAO = (SalariesDAO)context.getBean("SalariesDAO");
		List<Salaries> salariesList = new ArrayList<Salaries>();
		salariesList = salariesDAO.getList();

		model.addObject("salariesList", salariesList);
		return model;
	}
}	
