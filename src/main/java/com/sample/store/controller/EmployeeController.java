package com.sample.store.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.AttendenceDAO;
import com.sample.store.dao.EmployeeDAO;
import com.sample.store.entity.Attendence;
import com.sample.store.entity.Employee;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class EmployeeController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	
	@RequestMapping(value = "/Employee", method = RequestMethod.GET)
	public ModelAndView getEmployeeList(){
	
		ModelAndView model = new ModelAndView("Employee");
		//logger.info("controller");
		EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("EmployeeDAO");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = employeeDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("employeeList", employeeList);
		
		return model;
	}
	
	@RequestMapping(value = "/insertEmployee", method = RequestMethod.GET)
	public ModelAndView insertEmployeePage(){
		ModelAndView model = new ModelAndView("insertEmployee");
		return model;
	}
	
	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute Employee employee){
		ModelAndView model = new ModelAndView("redirect:/Employee");
		System.out.print(employee.getEmployee_name());
		EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("EmployeeDAO");
		employeeDAO.add_employee(employee);
		
		return model;
	}
	
	
	@RequestMapping(value = "/modifyEmployee", method = RequestMethod.GET)
	public ModelAndView modifyEmployeePage(@ModelAttribute("id") Employee employee){
		ModelAndView model = new ModelAndView("modifyEmployee");
		EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("EmployeeDAO");
		employee = employeeDAO.get_employee(employee);
		model.addObject("employee", employee);
		System.out.print("get id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	
	@RequestMapping(value = "/modifyEmployee", method = RequestMethod.POST)
	public ModelAndView modifyEmployee(@ModelAttribute Employee employee){
		ModelAndView model = new ModelAndView("redirect:/Employee");
		EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("EmployeeDAO");
		employeeDAO.modify_employee(employee);	
		System.out.print("post id:"+ employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");
		return model;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
		ModelAndView model = new ModelAndView("redirect:/Employee");
		EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("EmployeeDAO");
		employeeDAO.delete_employee(employee);
		System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}


}
