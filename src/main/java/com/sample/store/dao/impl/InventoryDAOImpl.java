package com.sample.store.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;     

import javax.sql.DataSource;

import com.sample.store.dao.InventoryDAO;
import com.sample.store.entity.Inventory;

public class InventoryDAOImpl implements InventoryDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add_inventory(Inventory aInventory) {
		
		String sql = "INSERT INTO inventory (inventory_id, firm_id, name, quantity, price) VALUES(?, ?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aInventory.getInventory_id());
			smt.setInt(2, aInventory.getFirm_id());
			smt.setString(3, aInventory.getInventory_name());
			smt.setInt(4, aInventory.getQuantity());
			smt.setInt(5, aInventory.getPrice());
			
			smt.executeUpdate();
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
		
	}

	@Override
	public void delete_inventory(Inventory aInventory) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM inventory WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aInventory.getInventory_id());
			smt.executeUpdate();
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
		
	}

	@Override
	public void modify_inventory(Inventory aInventory) {
		// TODO Auto-generated method stub
		
			String sql = "UPDATE inventory SET name=?, quantity=?, price =? " + " 	WHERE inventory_id = ?";
			//String sql = "UPDATE inventory SET name=?, position=?, tel=?" + " WHERE employees_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setString(1, aInventory.getInventory_name());
				smt.setInt(2, aInventory.getQuantity());
				smt.setInt(3, aInventory.getPrice());
				smt.setInt(4, aInventory.getInventory_id());
				smt.executeUpdate();
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
		
	}
	public List<Inventory> getList(String sql) {

		List<Inventory> inventoryList = new ArrayList<Inventory>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Inventory aInventory = new Inventory();
				aInventory.setInventory_id(rs.getInt("inventory_id"));
				aInventory.setFirm_id(rs.getInt("firm_id"));
				aInventory.setInventory_name(rs.getString("name"));
				// System.out.println(rs.getString("description"));

				aInventory.setQuantity(rs.getInt("quantity"));
				aInventory.setPrice(rs.getInt("price"));
				aInventory.setCount(rs.getInt("count"));
				inventoryList.add(aInventory);
			}
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
		return inventoryList;
	}
	public Inventory get_inventory(Inventory aInventory) {

		String sql = "SELECT * FROM inventory WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aInventory.getInventory_id());
			rs = smt.executeQuery();
			if (rs.next()) {
				aInventory.setInventory_id(rs.getInt("inventory_id"));
				aInventory.setFirm_id(rs.getInt("firm_id"));
				aInventory.setInventory_name(rs.getString("name"));
				aInventory.setQuantity(rs.getInt("quantity"));
				aInventory.setPrice(rs.getInt("price"));
				aInventory.setCount(rs.getInt("count"));
			}
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
		return aInventory;
	}
	public  void minus_inventory(Inventory aInventory){
		String sql = "UPDATE inventory SET quantity = quantity -1 ,count=count+1" + " 	WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aInventory.getInventory_id());
			
			smt.executeUpdate();
			
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
		
	}
	public  void plus_inventory(Inventory aInventory){
		String sql = "UPDATE inventory SET quantity=quantity +10" + " 	WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aInventory.getInventory_id());
			smt.executeUpdate();
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
		
	}
	
	public  void use_inventory(Inventory aInventory){
		String sql = "UPDATE inventory SET count=count +1 " + " 	WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aInventory.getInventory_id());
			smt.executeUpdate();
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
		System.out.print("use impl");
		
	}
	public void clearUse(Inventory aInventory){
		String sql = "UPDATE inventory SET count= 0 WHERE inventory_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aInventory.getInventory_id());
			smt.executeUpdate();
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
		
	}

	@Override
	public List<Inventory> getList() {
		String sql = "SELECT * FROM inventory";
		return getList(sql);
	}
	
}
