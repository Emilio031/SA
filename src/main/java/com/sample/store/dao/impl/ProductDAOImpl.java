package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.entity.Product;
import com.sample.store.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add_product(Product aProduct) {
		String sql = "INSERT INTO product(product_id,name, Price,condition1) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getProduct_id());
			smt.setString(2, aProduct.getProduct_name());
			smt.setInt(3, aProduct.getPrice());
			smt.setString(4, aProduct.getCondition1());
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
	public void delete_product(Product aProduct) {
		String sql = "DELETE FROM product WHERE product_ID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getProduct_id());
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
	public void modify_product(Product aProduct) {
		String sql = "UPDATE product SET name=?, price=?, condition1=? " + "WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1, aProduct.getProduct_name());
			smt.setInt(2, aProduct.getPrice());
			smt.setString(3, aProduct.getCondition1());
			smt.setInt(4, aProduct.getProduct_id());
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

	public List<Product> getList(String sql) {

		List<Product> productList = new ArrayList<Product>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setProduct_name(rs.getString("name"));
				aProduct.setPrice(rs.getInt("price"));
				aProduct.setCondition1(rs.getString("condition1"));
				// System.out.println(rs.getString("description"));

				// aProduct.setCondition(rs.getBoolean("condition"));
				productList.add(aProduct);
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
		return productList;
	}

	public Product get_product(Product aProduct) {

		String sql = "SELECT * FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getProduct_id());
			rs = smt.executeQuery();
			if (rs.next()) {
				aProduct.setProduct_id(rs.getInt("product_id"));

				aProduct.setProduct_name(rs.getString("name"));
				aProduct.setPrice(rs.getInt("Price"));
				aProduct.setCondition1(rs.getString("condition1"));
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
		return aProduct;
	}

	@Override
	public List<Product> getList() {
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

}