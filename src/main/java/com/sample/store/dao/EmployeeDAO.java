package com.sample.store.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sample.store.entity.Employee;


public interface EmployeeDAO {
	
	public void add_employee(Employee aEmployee);
	public void Clock(Employee aEmployee);
	public void delete_employee(Employee aEmployee);

	public void modify_employee(Employee aEmployee);

	public List<Employee> getList();
	//public List<Employee> getReorderList();
	//public List<Employee> getAvailableList();
	
	public Employee get_employee(Employee aEmployee);
}
