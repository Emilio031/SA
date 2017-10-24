package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;     

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.Statement;
import com.sample.store.entity.Product;
import com.sample.store.dao.FirmDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Firm;

public class FirmDAOImpl implements FirmDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void add_firm(Firm aFirm) {
		String sql = "INSERT INTO firm (f_id, name, tel) VALUES(?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aFirm.getFirm_id());
			smt.setString(2, aFirm.getFirm_name());
			smt.setString(3, aFirm.getTel());
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
	public void delete_firm(Firm aFirm) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM firm WHERE f_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aFirm.getFirm_id());
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
	public void modify_firm(Firm aFirm) {
		// TODO Auto-generated method stub
		String sql = "UPDATE firm SET name=?, Tel=?" + "WHERE f_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1, aFirm.getFirm_name());
			smt.setString(2, aFirm.getTel());
			smt.setInt(3, aFirm.getFirm_id());
			
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
	public List<Firm> getList(String sql) {

		List<Firm> firmList = new ArrayList<Firm>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Firm aFirm = new Firm();
				aFirm.setFirm_id(rs.getInt("f_id"));
				aFirm.setFirm_name(rs.getString("name"));
				aFirm.setTel(rs.getString("tel"));
				// System.out.println(rs.getString("description"));

				firmList.add(aFirm);
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
		return firmList;
	}
//	public Firm get_firm(Firm aFirm) {
//
//		String sql = "SELECT * FROM firm WHERE f_id = ?";
//		try {
//			conn = dataSource.getConnection();
//			smt = conn.prepareStatement(sql);
//			smt.setLong(1, aFirm.getFirm_id());
//			
//			rs = smt.executeQuery();
//			if (rs.next()) {
//				aFirm.setFirm_id(rs.getInt("f_id"));
//
//				aFirm.setFirm_name(rs.getString("name"));
//				aFirm.setTel(rs.getString("tel"));
//			}
//			rs.close();
//			smt.close();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
//		return aFirm;
//	}
	@Override
	public List<Firm> getList() {
		String sql = "SELECT * FROM firm";
		return getList(sql);
	}
	public Firm get_firm(Firm aFirm) {
		String sql = "SELECT * FROM Firm WHERE f_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aFirm.getFirm_id());
			
			rs = smt.executeQuery();
			if (rs.next()) {
				aFirm.setFirm_id(rs.getInt("f_id"));

				aFirm.setFirm_name(rs.getString("name"));
				aFirm.setTel(rs.getString("tel"));
				
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
		return aFirm;
	}
}
