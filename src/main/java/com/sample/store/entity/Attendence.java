package com.sample.store.entity;
import java.sql.Time;
import java.util.Date;
public class Attendence {

	private int employee_id;
    private Date date;
    private Time arrivaltime;
    private Time leavetime;
    String diff;

	public String getDiff() {
		return diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(Time arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public Date getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(Time leavetime) {
		this.leavetime = leavetime;
	}
//	public long getDiff(){
//		long diff = arrivaltime.getTime() - leavetime.getTime();
//		System.out.print(diff);
//		diff = diff*1000/60/60;
//		return diff;
//	}

}
