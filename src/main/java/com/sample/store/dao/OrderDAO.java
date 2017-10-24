package com.sample.store.dao;

import java.util.Date;
import java.util.List;

import com.sample.store.entity.Order;

public interface OrderDAO {

	public void add_order(Order aOrder);
    public void delete_order(Order aOrder);
    public void modify_order(Order aOrder);
    public List<Order> getList();
	
	//public List<Product> getReorderList();
	//public List<Product> getAvailableList();
    
	public Order get_order(Order aOrder);
}
