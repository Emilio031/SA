package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Attendence;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Salaries;

public interface SalariesDAO {
	public void add_salary(Salaries aSalary);
//	public void add_salary(Attendence aAttendence);
	public void delete_salary(Salaries aSalary);

	public void modify_salary(Salaries aSalary);
	
	public void modify_hour(Salaries aSalary);
	public List<Salaries> getList();
	
	public List<Salaries> getList2(Salaries aSalary);
	
//	public List<Salaries> getReorderList();
//	public List<Salaries> getAvailableList();

	public Salaries get_salary(Salaries aSalary);
//	public Salaries get_salary(Attendence aAttendence);
	

}
