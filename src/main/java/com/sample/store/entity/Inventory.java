package com.sample.store.entity;

public class Inventory {
	private int inventory_id;

	private int firm_id;

	private String inventory_name;

	private int quantity;
	
	private int price;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public int getFirm_id() {
		return firm_id;
	}

	public void setFirm_id(int firm_id) {
		this.firm_id = firm_id;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	public Inventory(int id, int f_id, String i_name, int q){
//		this.inventory_id = id;
//		this.firm_id = f_id;
//		this.inventory_name = i_name;
//		this.quantity = q;
//	}
	
	
}
