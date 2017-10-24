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
import com.sample.store.dao.InventoryDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Firm;
import com.sample.store.entity.Inventory;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class InventoryController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/Inventory", method = RequestMethod.GET)
	public ModelAndView getEmployeeList(){
	
		ModelAndView model = new ModelAndView("Inventory");
		//logger.info("controller");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		inventoryList = inventoryDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("inventoryList", inventoryList);
		
		return model;
	}

	@RequestMapping(value = "/insertInventory", method = RequestMethod.GET)
	public ModelAndView insertInventoryPage(){
		ModelAndView model = new ModelAndView("insertInventory");
		return model;
	}
	
	@RequestMapping(value = "/insertInventory", method = RequestMethod.POST)
	public ModelAndView insertInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		System.out.print(inventory.getInventory_name());
		inventoryDAO.add_inventory(inventory);
		
		return model;
	}
	@RequestMapping(value = "/deleteInventory", method = RequestMethod.POST)
	public ModelAndView deleteInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.delete_inventory(inventory);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	
	@RequestMapping(value = "/minusInventory", method = RequestMethod.POST)
	public ModelAndView minusInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.minus_inventory(inventory);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}

	@RequestMapping(value = "/clearUse", method = RequestMethod.POST)
	public ModelAndView clearUse(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.clearUse(inventory);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	
	@RequestMapping(value = "/plusInventory", method = RequestMethod.POST)
	public ModelAndView plusInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.plus_inventory(inventory);
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	@RequestMapping(value = "/useInventory", method = RequestMethod.POST)
	public ModelAndView useInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.use_inventory(inventory);
		System.out.print("use controller");
		//System.out.print("delete id:"+employee.getEmployee_id()+"  name:"+employee.getEmployee_name()+"  \n");

		return model;
	}
	
	@RequestMapping(value = "/modifyInventory", method = RequestMethod.GET)
	public ModelAndView modifyInventoryPage(@ModelAttribute("id") Inventory inventory){
		ModelAndView model = new ModelAndView("modifyInventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventory = inventoryDAO.get_inventory(inventory);
		model.addObject("inventory", inventory);
		//System.out.print("get id:"+inventory.getFirm_id());

		return model;
	}
	
	@RequestMapping(value = "/modifyInventory", method = RequestMethod.POST)
	public ModelAndView modifyInventory(@ModelAttribute Inventory inventory){
		ModelAndView model = new ModelAndView("redirect:/Inventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventoryDAO.modify_inventory(inventory);	
		//System.out.print("post id:"+inventory.getFirm_id());
		return model;
	}
	@RequestMapping(value = "/minusInventory", method = RequestMethod.GET)
	public ModelAndView minusInventoryPage(@ModelAttribute("id") Inventory inventory){
		ModelAndView model = new ModelAndView("minusInventory");
		InventoryDAO inventoryDAO = (InventoryDAO)context.getBean("InventoryDAO");
		inventory = inventoryDAO.get_inventory(inventory);
		model.addObject("inventory", inventory);
		//System.out.print("get id:"+inventory.getFirm_id());

		return model;
	}
	
	
}
