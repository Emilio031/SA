package com.sample.store.entity;

import java.sql.Time;
import java.util.Date;

public class Salaries {
	private int employee_id;

	public Time getDiff() {
		return diff;
	}

	public void setDiff(Time diff) {
		this.diff = diff;
	}

	private Date year_month;

	private int hours;

	private int salary_per_hour;
	
	Time diff;
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Date getYear_month() {
		return year_month;
	}

	public void setYear_month(Date year_month) {
		this.year_month = year_month;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getSalary_per_hour() {
		return salary_per_hour;
	}

	public void setSalary_per_hour(int salary_per_hour) {
		this.salary_per_hour = salary_per_hour;
	}
	// public Salaries(int e_id, Date date,int hour, int salary_per_hour ){
	// this.employee_id = e_id;
	// this.year_month = date;
	// this.hours = hour;
	// this.salary_per_hour = salary_per_hour;
	// }
}
