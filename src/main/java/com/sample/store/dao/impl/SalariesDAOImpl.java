package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.sample.store.dao.SalariesDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.Salaries;

public class SalariesDAOImpl implements SalariesDAO {
	// @Autowired
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;
	private Connection conn2 = null;
	private ResultSet rs2 = null;
	private PreparedStatement smt2 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add_salary(Salaries aSalary) {
		String sql = "INSERT INTO salaries (employees_id, year_month, salary_per_hour) VALUES(?, ?, ?)";
		String sql2 = "INSERT INTO salaries hours = Attendence.diff from attendence where employees_id = ? and date = ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aSalary.getEmployee_id());
			smt.setDate(2, (Date) aSalary.getYear_month());

			smt.setInt(3, aSalary.getSalary_per_hour());
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
	public void delete_salary(Salaries aSalary) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM salaries WHERE employees_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aSalary.getEmployee_id());
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
	public void modify_salary(Salaries aSalary) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Salaries SET hours=?, salary_per_hour=? " + "WHERE employees_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aSalary.getHours());
			smt.setInt(2, aSalary.getSalary_per_hour());

			smt.setInt(3, aSalary.getEmployee_id());
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
	public void modify_hour(Salaries aSalary){
		String sql = "UPDATE Salaries SET hours = sum(diff) as total FROM SA.Attendence WHERE employees_id = ? and "; 
		//SELECT sum(diff) as total FROM SA.Attendence where employees_id = 14 ;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aSalary.getHours());
			smt.setInt(2, aSalary.getSalary_per_hour());

			smt.setInt(3, aSalary.getEmployee_id());
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
	public List<Salaries> getList() {
		String sql = "SELECT * FROM salaries";
		return getList(sql);
	}
	public List<Salaries> getList2(Salaries aSalary) {
		String sql = "SELECT salaries.employees_id ,salaries.year_month, salaries.salary_per_hour FROM SA.salaries";
		String sql2 = "SELECT Attendence.date, Attendence.diff FROM SA.Attendence";
		List<Salaries> salariesList = new ArrayList<Salaries>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				conn2 = dataSource.getConnection();
				smt2 = conn.prepareStatement(sql2);
				rs2 = smt.executeQuery();
				Salaries aSalary2 = new Salaries();
				aSalary2.setEmployee_id(rs.getInt("employees_id"));
				aSalary2.setYear_month(rs.getDate("year_month"));
				aSalary2.setSalary_per_hour(rs.getInt("salary_per_hour"));
				aSalary2.setDiff(rs2.getTime("diff"));
				
				salariesList.add(aSalary2);
			}
			rs.close();
			smt.close();
			rs2.close();
			smt2.close();

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
		return salariesList;
		
	}
	
	public List<Salaries> getList(String sql) {
		// TODO Auto-generated method stub

		List<Salaries> salariesList = new ArrayList<Salaries>();
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Salaries aSalary = new Salaries();
				aSalary.setEmployee_id(rs.getInt("employees_id"));
				aSalary.setYear_month(rs.getDate("year_month"));
				aSalary.setHours(rs.getInt("hours"));
				aSalary.setSalary_per_hour(rs.getInt("salary_per_hour"));
				
				salariesList.add(aSalary);
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
		return salariesList;
	}

	@Override
	public Salaries get_salary(Salaries aSalary) {
		// TODO Auto-generated method stub
		String sql = "SELECT salaries.employees_id ,salaries.year_month, salaries.salary_per_hour ,Attendence.date, Attendence.diff FROM SA.Attendence,SA.salaries";
		//原本的 String sql = "SELECT * FROM salaries WHERE employees_id = ?";
		//String sql = "UPDATE Salaries SET hours = sum(diff) as total FROM SA.Attendence " + "WHERE employees_id = ?";
		//String sql = "SELECT employees_id, date, arrivalTime, leaveTime, timediff(leaveTime, arrivalTime) as difftime FROM attendence";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aSalary.getEmployee_id());
			rs = smt.executeQuery();
			if(rs.next()){
				aSalary.setEmployee_id(rs.getInt("employees_id"));
				aSalary.setYear_month(rs.getDate("year_month"));
				aSalary.setHours(rs.getInt("hours"));
				aSalary.setSalary_per_hour(rs.getInt("salary_per_hour"));
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
		return aSalary;
	}

}
