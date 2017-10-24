package com.sample.store.entity;

public class OrderItem {

	private int order_id;

	private int product_id;

	private int item_id;

	private String  ice;

	private String sugar;
	

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	
//	public OrderItem(int order_id, int product_id, int item_id, String ice, String sugar){
//		
//		this.order_id = order_id;
//		this.product_id = product_id;
//		this.item_id = item_id;
//		this.ice = ice;
//		this.sugar = sugar;
//	}

}
