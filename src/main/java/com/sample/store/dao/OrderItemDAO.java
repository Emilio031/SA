package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Attendence;
import com.sample.store.entity.OrderItem;

public interface OrderItemDAO {

	public void add_orderItem(OrderItem aOrderitem);
    public void delete_orderItem(OrderItem aOrderitem);
    public void modify_orderItem(OrderItem aOrderitem);
    
    
    public List<OrderItem> search_orderItem(OrderItem aOrderItem);
    //public List<Attendence> search_attendence(Attendence aAttendence);
    
    public List<OrderItem> getList();
	//public List<Product> getReorderList();
	//public List<Product> getAvailableList();
	public OrderItem get_orderItem(OrderItem aOrderitem);
	List<OrderItem> getList(String sql);
	
	
	

}
