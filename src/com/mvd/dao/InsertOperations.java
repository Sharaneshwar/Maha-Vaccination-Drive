package com.mvd.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class InsertOperations {
	public static String INSERT_USER_QUERY = "INSERT INTO registration_table (FULL_NAME, DOB, MOBILE_NO, EMAIL_ID, ADDRESS, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static String INSERT_APPOINTMENT = "INSERT INTO appointments (EMAIL_ID, AADHAAR_NO, APPOINTMENT_DATE, VACCINE_NAME, VACCINE_CENTER) VALUES (?, ?, ?, ?, ?)";
	public static String url = "jdbc:mysql://localhost:3306/mvd_db";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "";

	public int insert_into_registration_table(ArrayList<String> al) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(INSERT_USER_QUERY);
			if (ps != null) {
				ps.setString(1, al.get(0));
				ps.setString(2, al.get(1));
				ps.setString(3, al.get(2));
				ps.setString(4, al.get(3));
				ps.setString(5, al.get(4));
				ps.setString(6, al.get(5));
				ps.setString(7, al.get(6));
				return ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int insert_into_appointments(ArrayList<String> al) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(INSERT_APPOINTMENT);
			if (ps != null) {
				ps.setString(1, al.get(0));
				ps.setString(2, al.get(1));
				ps.setString(3, al.get(2));
				ps.setString(4, al.get(3));
				ps.setString(5, al.get(4));
				return ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
