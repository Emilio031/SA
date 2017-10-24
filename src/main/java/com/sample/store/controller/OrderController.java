package com.sample.store.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.EmployeeDAO;
import com.sample.store.dao.OrderDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Order;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class OrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/Order", method = RequestMethod.GET)
	public ModelAndView getOrderList(){
	
		ModelAndView model = new ModelAndView("Order");
		//logger.info("controller");
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		List<Order> orderList = new ArrayList<Order>();
		orderList = orderDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("orderList", orderList);
		
		return model;
	}
	
	@RequestMapping(value = "/insertOrder", method = RequestMethod.GET)
	public ModelAndView insertOrderPage(){
		ModelAndView model = new ModelAndView("insertOrder");
		return model;
	}
	
	@RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
	public ModelAndView insertOrder(@ModelAttribute Order order){
		ModelAndView model = new ModelAndView("redirect:/Order");
		
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		orderDAO.add_order(order);
		
		return model;
	}
	
	@RequestMapping(value = "/modifyOrder", method = RequestMethod.GET)
	public ModelAndView modifyOrderPage(@ModelAttribute("id") Order order){
		ModelAndView model = new ModelAndView("modifyOrder");
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		order = orderDAO.get_order(order);
		model.addObject("order", order);
		//System.out.print("get id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	
	@RequestMapping(value = "/modifyOrder", method = RequestMethod.POST)
	public ModelAndView modifyOrder(@ModelAttribute Order order){
		ModelAndView model = new ModelAndView("redirect:/Order");
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		orderDAO.modify_order(order);	
		//System.out.print("post id:"+ employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");
		return model;
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	public ModelAndView deleteOrder(@ModelAttribute Order order){
		ModelAndView model = new ModelAndView("redirect:/Order");
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		orderDAO.delete_order(order);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
}
