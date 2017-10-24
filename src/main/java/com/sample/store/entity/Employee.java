package com.sample.store.entity;

public class Employee {

	private int employee_id;

	private String employee_name;

	private String employee_position;

	private String employee_tel;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_position() {
		return employee_position;
	}

	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}

	public String getEmployee_tel() {
		return employee_tel;
	}

	public void setEmployee_tel(String imployee_tel) {
		this.employee_tel = imployee_tel;
	}

	// public Employee(int employee_id, String name, String position, String
	// tel){
	// this.employee_id = employee_id;
	// this.employee_name = name;
	// this.employee_position = position;
	// this.imployee_tel = tel;
	// }

}
