package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;     

import javax.sql.DataSource;

import com.sample.store.entity.Employee;
import com.sample.store.entity.Firm;
import com.sample.store.dao.EmployeeDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.Statement;



public class EmployeeDAOImpl implements EmployeeDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void add_employee(Employee aEmployee) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO Employees (employees_id,name,position,tel) VALUES(?, ?, ?, ?)";	
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, aEmployee.getEmployee_id());
				smt.setString(2, aEmployee.getEmployee_name());
				smt.setString(3, aEmployee.getEmployee_position());
				smt.setString(4, aEmployee.getEmployee_tel());
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
	public void Clock(Employee aEmployee) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO Attendence (employees_id,date,arrivalTime) VALUES(?, ?, ?)";	
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, aEmployee.getEmployee_id());
				smt.setString(2, aEmployee.getEmployee_name());
				smt.setString(3, aEmployee.getEmployee_position());
				smt.setString(4, aEmployee.getEmployee_tel());
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
	public void delete_employee(Employee aEmployee) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Employees WHERE employees_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aEmployee.getEmployee_id());
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
		System.out.print("delete id:"+aEmployee.getEmployee_id()+"  name:"+aEmployee.getEmployee_name()+"  \n");

	}
	
	public void modify_employee(Employee aEmployee) {
		// TODO Auto-generated method stub
		String sql = "UPDATE employees SET name=?, position=?, tel=?" + " WHERE employees_id = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1, aEmployee.getEmployee_name());
			smt.setString(2, aEmployee.getEmployee_position());
			smt.setString(3, aEmployee.getEmployee_tel());	
			smt.setInt(4, aEmployee.getEmployee_id());
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
		System.out.print(aEmployee.getEmployee_id()+"  "+aEmployee.getEmployee_name()+"  ");

	}

	
	public List<Employee> getList(String sql) {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Employee aEmployee = new Employee();
				aEmployee.setEmployee_id(rs.getInt("employees_id"));
				aEmployee.setEmployee_name(rs.getString("name"));
				aEmployee.setEmployee_position(rs.getString("position"));
				aEmployee.setEmployee_tel(rs.getString("tel"));
				// System.out.println(rs.getString("description"));

				employeeList.add(aEmployee);
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
		return employeeList;
	}


	@Override
	public Employee get_employee(Employee aEmployee) {
		String sql = "SELECT * FROM Employees WHERE employees_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aEmployee.getEmployee_id());
			
			rs = smt.executeQuery();
			if (rs.next()) {
				aEmployee.setEmployee_id(rs.getInt("employees_id"));
				aEmployee.setEmployee_position(rs.getString("position"));
				aEmployee.setEmployee_name(rs.getString("name"));
				aEmployee.setEmployee_tel(rs.getString("Tel"));
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
		return aEmployee;
	}
	public List<Employee> getList() {
		String sql = "SELECT * FROM employees";
		return getList(sql);
	}
}
