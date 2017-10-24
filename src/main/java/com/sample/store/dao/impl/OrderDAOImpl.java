package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.entity.Order;
import com.sample.store.dao.OrderDAO;

public class OrderDAOImpl implements OrderDAO{

	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void add_order(Order aOrder) {


		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO orders (order_id, date,time, price, cups) VALUES (?, CURDATE(),CURTIME(), ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aOrder.getOrder_id());
			
			smt.setInt(2, aOrder.getPrice());
			smt.setInt(3, aOrder.getCups());
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
	public void delete_order(Order aOrder) {
		
		String sql = "DELETE FROM orders WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aOrder.getOrder_id());
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
	public void modify_order(Order aOrder) {

		
		String sql = "UPDATE orders SET price=?, cups=? WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			
			smt.setInt(1, aOrder.getPrice());
			smt.setInt(2, aOrder.getCups());
			smt.setInt(3, aOrder.getOrder_id());
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
	public List<Order> getList() {
		String sql = "SELECT * FROM orders";
		return getList(sql);
	}
	
    public List<Order> getList(String sql) {
		
		List<Order> orderList = new ArrayList<Order>();
		//will need this part later
		/*
		String sql = "SELECT * FROM article a "
				+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
				+ "ORDER BY articleID DESC";
		*/
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Order aOrder = new Order();
				aOrder.setOrder_id(rs.getInt("order_id"));			
				aOrder.setDate(rs.getDate("date"));
				aOrder.setTime(rs.getTime("time"));
				aOrder.setPrice(rs.getInt("price"));
				aOrder.setCups(rs.getInt("cups"));
				orderList.add(aOrder);
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
		return orderList;
	}

	@Override
	public Order get_order(Order aOrder) {
		
		String sql = "SELECT * FROM orders WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aOrder.getOrder_id());
			rs = smt.executeQuery();
			if(rs.next()){
				aOrder.setOrder_id(rs.getInt("order_id"));
				aOrder.setDate(rs.getDate("date"));
				aOrder.setTime(rs.getTime("time"));
				aOrder.setPrice(rs.getInt("price"));
				aOrder.setCups(rs.getInt("cups"));
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
		return aOrder;
	}
}
