package com.sample.store.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.AttendenceDAO;
import com.sample.store.dao.EmployeeDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Attendence;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Product;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
@SessionAttributes("session")
//@SessionAttributes("session2")

public class AttendenceController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/Attendence", method = RequestMethod.GET)
	public ModelAndView getAttendenceList() {

		ModelAndView model = new ModelAndView("Attendence");

		AttendenceDAO attendenceDAO = (AttendenceDAO) context.getBean("AttendenceDAO");
		List<Attendence> attendenceList = new ArrayList<Attendence>();
		attendenceList = attendenceDAO.getList();

		model.addObject("attendenceList", attendenceList);

		return model;
	}

	@RequestMapping(value = "/insertAttendence", method = RequestMethod.GET)
	public ModelAndView insertAttendencePage(@ModelAttribute("id") Attendence attendence) {
		ModelAndView model = new ModelAndView("insertAttendence");
		AttendenceDAO attendenceDAO = (AttendenceDAO) context.getBean("AttendenceDAO");
		attendence = attendenceDAO.get_attendence(attendence);
		model.addObject("attendence", attendence);

		System.out.print("\n(controller, get) id:" + attendence.getEmployee_id());
		model.addObject("session", attendence.getEmployee_id()); 
		
		return model;

	}

	@RequestMapping(value = "/insertAttendence", method = RequestMethod.POST)
	public ModelAndView insertAttendence(@ModelAttribute("id") Attendence attendence) {
		ModelAndView model = new ModelAndView("redirect:/Attendence");
		// System.out.print(employee.getAttendence_name());
		AttendenceDAO attendenceDAO = (AttendenceDAO) context.getBean("AttendenceDAO");
		attendenceDAO.add_attendence(attendence);
		
		System.out.print("\n(controller, post) id:" + attendence.getEmployee_id());
		return model;
	}
	
	@RequestMapping(value = "/deleteAttendence", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Attendence attendence){
		ModelAndView model = new ModelAndView("redirect:/Attendence");
		AttendenceDAO attendenceDAO = (AttendenceDAO)context.getBean("AttendenceDAO");
		attendenceDAO.delete_attendence(attendence);
		System.out.print("delete id:"+attendence.getEmployee_id());

		return model;
	}
	
	@RequestMapping(value = "/searchAttendence", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@ModelAttribute Attendence attendence){
		ModelAndView model = new ModelAndView("Attendence");
		AttendenceDAO attendenceDAO = (AttendenceDAO)context.getBean("AttendenceDAO");
		attendenceDAO.search_attendence(attendence);
		
		List<Attendence> attendenceList = new ArrayList<Attendence>();
		attendenceList = attendenceDAO.search_attendence(attendence);
		model.addObject("attendenceList", attendenceList);

		//System.out.print("search id:"+attendence.getEmployee_id());
		for(int i=0;i < attendenceList.size();i++){
			System.out.print("list:\n"+ attendenceList.get(i).getEmployee_id());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/modifyAttendence", method = RequestMethod.GET)
	public ModelAndView modifyAttendencePage(@ModelAttribute("id") Attendence attendence){
		ModelAndView model = new ModelAndView("modifyAttendence");
		AttendenceDAO attendenceDAO = (AttendenceDAO)context.getBean("AttendenceDAO");
		attendence = attendenceDAO.get_attendence(attendence);
		model.addObject("attendence", attendence);
		System.out.print("get id:"+attendence.getEmployee_id());

		return model;
	}
	@RequestMapping(value = "/modifyAttendence", method = RequestMethod.POST)
	public ModelAndView modifyAttendence(@ModelAttribute Attendence attendence){
		ModelAndView model = new ModelAndView("redirect:/Attendence");
		AttendenceDAO attendenceDAO = (AttendenceDAO)context.getBean("AttendenceDAO");
		attendenceDAO.modify_attendence(attendence);	
		System.out.print("post id:"+ attendence.getEmployee_id());
		return model;
	}

}
