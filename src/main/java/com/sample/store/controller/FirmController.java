package com.sample.store.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.EmployeeDAO;
import com.sample.store.dao.FirmDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Firm;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class FirmController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/Firm", method = RequestMethod.GET)
	public ModelAndView getFirmList(){
	
		ModelAndView model = new ModelAndView("Firm");
		//logger.info("controller");
		FirmDAO firmDAO = (FirmDAO)context.getBean("FirmDAO");
		List<Firm> firmList = new ArrayList<Firm>();
		firmList = firmDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("firmList", firmList);
		
		return model;
	}
	
	@RequestMapping(value = "/insertFirm", method = RequestMethod.GET)
	public ModelAndView insertFirmPage(){
		ModelAndView model = new ModelAndView("insertFirm");
		return model;
	}
	
	@RequestMapping(value = "/insertFirm", method = RequestMethod.POST)
	public ModelAndView insertFirm(@ModelAttribute Firm firm){
		ModelAndView model = new ModelAndView("redirect:/Firm");
		System.out.print(firm.getFirm_name());
		FirmDAO firmDAO = (FirmDAO)context.getBean("FirmDAO");
		firmDAO.add_firm(firm);
		
		return model;
	}
	
	@RequestMapping(value = "/deleteFirm", method = RequestMethod.POST)
	public ModelAndView deleteFirm(@ModelAttribute Firm firm){
		ModelAndView model = new ModelAndView("redirect:/Firm");
		FirmDAO firmDAO = (FirmDAO)context.getBean("FirmDAO");
		firmDAO.delete_firm(firm);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	@RequestMapping(value = "/modifyFirm", method = RequestMethod.GET)
	public ModelAndView modifyFirmPage(@ModelAttribute("id") Firm firm){
		ModelAndView model = new ModelAndView("modifyFirm");
		FirmDAO firmDAO = (FirmDAO)context.getBean("FirmDAO");
		firm = firmDAO.get_firm(firm);
		model.addObject("firm", firm);
		System.out.print("get id:"+firm.getFirm_id());

		return model;
	}
	
	@RequestMapping(value = "/modifyFirm", method = RequestMethod.POST)
	public ModelAndView modifyFirm(@ModelAttribute Firm firm){
		ModelAndView model = new ModelAndView("redirect:/Firm");
		FirmDAO firmDAO = (FirmDAO)context.getBean("FirmDAO");
		firmDAO.modify_firm(firm);	
		System.out.print("post id:"+firm.getFirm_id());
		return model;
	}
}
