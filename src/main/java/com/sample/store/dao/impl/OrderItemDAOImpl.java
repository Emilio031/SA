package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;     

import javax.sql.DataSource;

import com.sample.store.entity.Attendence;
import com.sample.store.entity.Order;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.Statement;
import com.sample.store.entity.OrderItem;
import com.sample.store.dao.OrderItemDAO;


public class OrderItemDAOImpl implements OrderItemDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void add_orderItem(OrderItem aOrderitem) {


		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO orderitem (order_id, product_id, ice, sugar) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aOrderitem.getOrder_id());
			smt.setInt(2, aOrderitem.getProduct_id());
			
			smt.setString(3, aOrderitem.getIce());
			smt.setString(4, aOrderitem.getSugar());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
		

	@Override
	public void delete_orderItem(OrderItem aOrderitem) {

		
		String sql = "DELETE FROM orderItem WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aOrderitem.getOrder_id());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public void modify_orderItem(OrderItem aOrderitem) {

		
		String sql = "UPDATE orderitem SET item_id=?, ice=?, sugar=?"
				+ "WHERE order_id, product_id = ? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aOrderitem.getItem_id());
			smt.setString(2, aOrderitem.getIce());
			smt.setString(3, aOrderitem.getSugar());
			smt.setInt(4, aOrderitem.getOrder_id());
			smt.setInt(5, aOrderitem.getProduct_id());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public List<OrderItem> getList() {
		String sql = "SELECT * FROM orderitem order by order_id,item_id ASC";
		return getList(sql);
	}

	@Override
   public List<OrderItem> getList(String sql) {
		List<OrderItem> orderitemList = new ArrayList<OrderItem>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				OrderItem aOrderitem = new OrderItem();
				aOrderitem.setOrder_id(rs.getInt("order_id"));
				aOrderitem.setProduct_id(rs.getInt("product_id"));
				aOrderitem.setItem_id(rs.getInt("item_id"));
				aOrderitem.setIce(rs.getString("ice"));
				aOrderitem.setSugar(rs.getString("sugar"));
				orderitemList.add(aOrderitem);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return orderitemList;
	}
	
	@Override
	public OrderItem get_orderItem(OrderItem aOrderitem) {
		
		String sql = "SELECT * FROM orderItem WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aOrderitem.getOrder_id());
			rs = smt.executeQuery();
			if(rs.next()){
				aOrderitem.setOrder_id(rs.getInt("order_id"));
				aOrderitem.setProduct_id(rs.getInt("product_id"));
				aOrderitem.setItem_id(rs.getInt("item_id"));
				aOrderitem.setIce(rs.getString("ice"));
				aOrderitem.setSugar(rs.getString("sugar"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return aOrderitem;
	}

	
	public List<OrderItem> search_orderItem(OrderItem aOrderItem){
		String sql = "SELECT * FROM orderItem WHERE order_id = ?";
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aOrderItem.getOrder_id());
			rs = smt.executeQuery();
			while(rs.next()){
				OrderItem aOrderitem = new OrderItem();
				aOrderitem.setOrder_id(rs.getInt("order_id"));
				aOrderitem.setProduct_id(rs.getInt("product_id"));
				aOrderitem.setItem_id(rs.getInt("item_id"));
				aOrderitem.setIce(rs.getString("ice"));
				aOrderitem.setSugar(rs.getString("sugar"));
				orderItemList.add(aOrderitem);
			}
			System.out.println(orderItemList);
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return orderItemList;


	
	}
	
}