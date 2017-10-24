package com.sample.store.entity;

import java.sql.Time;
import java.util.Date;

public class Order {
	private int order_id;

	private Date date;
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	private Time time;

	private int price;

	private int cups;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}
	
//	public Order(int o_id, Date d,int price, int cups){
//		this.order_id = o_id;
//		this.date = d;
//		this.price = price;
//		this.cups = cups;
//	}
}
