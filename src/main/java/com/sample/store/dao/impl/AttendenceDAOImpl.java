package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.Statement;
import com.sample.store.entity.Attendence;
import com.sample.store.dao.AttendenceDAO;

public class AttendenceDAOImpl implements AttendenceDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add_attendence(Attendence aAttendence) {
		String d = "SELECT CURDATE";
		String m = "SELECT CURTIME";
		String sql = "INSERT INTO attendence (employees_id, date, arrivalTime) VALUES(?,  CURDATE(), CURTIME())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aAttendence.getEmployee_id());

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
		System.out.print("\n(DAOimplement) id: " + aAttendence.getEmployee_id());
	}

	public void delete_attendence(Attendence aAttendence) {
		String sql = "DELETE FROM attendence WHERE employees_id = ? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aAttendence.getEmployee_id());
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
		System.out.print(aAttendence.getEmployee_id() + "  " + (Date) aAttendence.getDate() + "  ");

	}

	public List<Attendence> search_attendence(Attendence aAttendence) {
		String sql = "SELECT employees_id, date, arrivalTime, leaveTime, timediff(leaveTime, arrivalTime) "
				+ "as difftime FROM attendence where employees_id = ?";
		List<Attendence> attendenceList = new ArrayList<Attendence>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aAttendence.getEmployee_id());
			rs = smt.executeQuery();
			
			while (rs.next()) {
				Attendence aAttendence1 = new Attendence();
				aAttendence1.setEmployee_id(rs.getInt("employees_id"));
				aAttendence1.setDate(rs.getDate("date"));
				aAttendence1.setArrivaltime(rs.getTime("arrivaltime"));
				aAttendence1.setLeavetime(rs.getTime("leavetime"));
				aAttendence1.setDiff(rs.getString("difftime"));
				attendenceList.add(aAttendence1);
				
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
		return attendenceList;


	}

	@Override
	public void modify_attendence(Attendence aAttendence) {

		String sql = "UPDATE attendence SET leaveTime = CURTIME() ,diff = timediff(CURTIME(), arrivalTime) "
				+ " WHERE employees_id = ? and date = CURDATE() ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, aAttendence.getEmployee_id());

			// smt.setDate(2,(Date) aAttendence.getDate());
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

	public List<Attendence> getList() {
		String sql = "SELECT employees_id, date, arrivalTime, leaveTime, timediff(leaveTime, arrivalTime) as difftime FROM attendence";
		return getList(sql);
	}

	public List<Attendence> getList(String sql) {
		// TODO Auto-generated method stub
		List<Attendence> attendenceList = new ArrayList<Attendence>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Attendence aAttendence = new Attendence();
				aAttendence.setEmployee_id(rs.getInt("employees_id"));
				aAttendence.setDate(rs.getDate("date"));
				aAttendence.setArrivaltime(rs.getTime("arrivaltime"));
				aAttendence.setLeavetime(rs.getTime("leavetime"));
				aAttendence.setDiff(rs.getString("difftime"));
				attendenceList.add(aAttendence);
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
		return attendenceList;
	}

	@Override
	public Attendence get_attendence(Attendence aAttendence) {

		String sql = "SELECT * FROM attendence WHERE employees_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aAttendence.getEmployee_id());
			rs = smt.executeQuery();
			if (rs.next()) {
				aAttendence.setEmployee_id(rs.getInt("employees_id"));
				aAttendence.setDate(rs.getDate("date"));
				aAttendence.setArrivaltime(rs.getTime("arrivaltime"));
				aAttendence.setLeavetime(rs.getTime("leavetime"));
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
		return aAttendence;
	}
}
