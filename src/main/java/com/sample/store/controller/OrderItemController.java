package com.sample.store.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.AttendenceDAO;
import com.sample.store.dao.OrderItemDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Attendence;
import com.sample.store.entity.OrderItem;
import com.sample.store.entity.Product;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class OrderItemController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
//	public ModelAndView getProductList() {
//
//		ModelAndView model = new ModelAndView("Product");
//		// logger.info("controller");
//		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
//		List<Product> productList = new ArrayList<Product>();
//		productList = productDAO.getList();
//		// logger.info(""+productList.size());
//		model.addObject("productList", productList);
//
//		return model;
//	}


	@RequestMapping(value = "/OrderItem", method = RequestMethod.GET)
	public ModelAndView getOrderItemList() {

		ModelAndView model = new ModelAndView("OrderItem");

		OrderItemDAO orderItemDAO = (OrderItemDAO) context.getBean("OrderItemDAO");
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList = orderItemDAO.getList();

		model.addObject("orderItemList", orderItemList);

		return model;
	}
	@RequestMapping(value = "/searchOrderItem", method = RequestMethod.GET)
	public ModelAndView searchOrderItemPage(@ModelAttribute("id") OrderItem orderItem) {
		ModelAndView model = new ModelAndView("OrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO) context.getBean("OrderItemDAO");
		orderItem = orderItemDAO.get_orderItem(orderItem);
		model.addObject("orderItem", orderItem);

		System.out.print("list:\n"+ orderItem.getOrder_id());
		 
		
		return model;

	}
	@RequestMapping(value = "/searchOrderItem", method = RequestMethod.POST)
	public ModelAndView searchOrderItem(@ModelAttribute OrderItem orderItem){
		ModelAndView model = new ModelAndView("OrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO)context.getBean("OrderItemDAO");
		orderItemDAO.search_orderItem(orderItem);
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList = orderItemDAO.search_orderItem(orderItem);
		model.addObject("orderItemList", orderItemList);
		
		for(int i=0;i < orderItemList.size();i++){
			System.out.print("list:\n"+ orderItemList.get(i).getOrder_id());
		}
		
		return model;
	}

	@RequestMapping(value = "/insertOrderItem", method = RequestMethod.GET)
	public ModelAndView insertOrderItemPage(@ModelAttribute("id") OrderItem orderItem) {
		ModelAndView model = new ModelAndView("insertOrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO) context.getBean("OrderItemDAO");
		orderItem = orderItemDAO.get_orderItem(orderItem);
		model.addObject("orderItem", orderItem);

		//System.out.print("\n(controller, get) id:" + attendence.getEmployee_id());
		 
		
		return model;

	}

	@RequestMapping(value = "/insertOrderItem", method = RequestMethod.POST)
	public ModelAndView insertOrderItem(@ModelAttribute("id") OrderItem orderItem) {
		ModelAndView model = new ModelAndView("redirect:/OrderItem");
		
		OrderItemDAO orderItemDAO = (OrderItemDAO) context.getBean("OrderItemDAO");
		orderItemDAO.add_orderItem(orderItem);
		
		//System.out.print("\n(controller, post) id:" + attendence.getEmployee_id());
		return model;
	}
	@RequestMapping(value = "/deleteOrderItem", method = RequestMethod.POST)
	public ModelAndView deleteOrderItem(@ModelAttribute OrderItem orderItem){
		ModelAndView model = new ModelAndView("redirect:/OrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO)context.getBean("OrderItemDAO");
		orderItemDAO.delete_orderItem(orderItem);
		

		return model;
	}
	@RequestMapping(value = "/modifyOrderItem", method = RequestMethod.GET)
	public ModelAndView modifyOrderItemPage(@ModelAttribute("id") OrderItem orderItem){
		ModelAndView model = new ModelAndView("modifyOrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO)context.getBean("OrderItemDAO");
		orderItem = orderItemDAO.get_orderItem(orderItem);
		model.addObject("orderItem", orderItem);
		

		return model;
	}
	@RequestMapping(value = "/modifyOrderItem", method = RequestMethod.POST)
	public ModelAndView modifyOrderItem(@ModelAttribute OrderItem orderItem){
		ModelAndView model = new ModelAndView("redirect:/OrderItem");
		OrderItemDAO orderItemDAO = (OrderItemDAO)context.getBean("OrderItemDAO");
		orderItemDAO.modify_orderItem(orderItem);	
		
		return model;
	}
}
