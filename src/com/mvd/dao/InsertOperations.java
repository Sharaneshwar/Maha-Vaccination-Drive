package com.mvd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertOperations {
	public static String url = "jdbc:mysql://localhost:3306/mvd_db";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "";
	Connection con = null;
	PreparedStatement ps = null;

	public int insert_into_registration_table(ArrayList<String> al) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("INSERT INTO registration_table (FULL_NAME, DOB, MOBILE_NO, EMAIL_ID, ADDRESS, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)");
			if (ps != null) {
				ps.setString(1, al.get(0));
				ps.setString(2, al.get(1));
				ps.setString(3, al.get(2));
				ps.setString(4, al.get(3));
				ps.setString(5, al.get(4));
				ps.setString(6, al.get(5));
				ps.setString(7, al.get(6));
				rows = ps.executeUpdate();
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
		return rows;
	}

	public int insert_into_appointments(ArrayList<String> al) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("INSERT INTO appointments (EMAIL_ID, AADHAAR_NO, APPOINTMENT_DATE, VACCINE_NAME, VACCINE_CENTER) VALUES (?, ?, ?, ?, ?)");
			if (ps != null) {
				ps.setString(1, al.get(0));
				ps.setString(2, al.get(1));
				ps.setString(3, al.get(2));
				ps.setString(4, al.get(3));
				ps.setString(5, al.get(4));
				rows = ps.executeUpdate();
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
		return rows;
	}

	public int insert_into_vaccine_status(String emailID) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("INSERT INTO vaccine_status (EMAIL_ID, STATUS) VALUES (?, ?)");
			if (ps != null) {
				ps.setString(1, emailID);
				ps.setString(2, "Not Yet Vaccinated");
				rows = ps.executeUpdate();
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
		return rows;
	}
}
