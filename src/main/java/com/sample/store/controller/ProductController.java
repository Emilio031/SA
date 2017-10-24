package com.sample.store.controller;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.EmployeeDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public ModelAndView getProductList() {

		ModelAndView model = new ModelAndView("Product");
		// logger.info("controller");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getList();
		// logger.info(""+productList.size());
		model.addObject("productList", productList);

		return model;
	}

	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage() {
		ModelAndView model = new ModelAndView("insertProduct");
		return model;
	}

	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/Product");
		// System.out.print(product.getProduct_name());
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		productDAO.add_product(product);

		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/Product");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		productDAO.delete_product(product);
		return model;
	}

	@RequestMapping(value = "/modifyProduct", method = RequestMethod.GET)
	public ModelAndView modifyEmployeePage(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("modifyProduct");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		product = productDAO.get_product(product);
		model.addObject("product", product);
		// System.out.print(employee.getEmployee_id()+"
		// "+employee.getEmployee_name()+" ");

		return model;
	}

	@RequestMapping(value = "/modifyProduct", method = RequestMethod.POST)
	public ModelAndView modifyProduct(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/Product");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		productDAO.modify_product(product);
		System.out.print(product.getProduct_id() + "  " + product.getProduct_name() + "  ");
		return model;
	}

}