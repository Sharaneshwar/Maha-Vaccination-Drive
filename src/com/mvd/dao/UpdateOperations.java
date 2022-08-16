package com.mvd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateOperations {
	public static String url = "jdbc:mysql://localhost:3306/mvd_db";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "";
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;

	public int update_vaccine_stock(String vaccine_name) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			rows = st.executeUpdate("UPDATE VACCINE_STOCK SET STOCK = STOCK - 1 WHERE NAME = '" + vaccine_name + "'");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
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

	public int update_vaccine_status(String email_ID, String status) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			rows = st.executeUpdate(
					"UPDATE VACCINE_STATUS SET STATUS = '" + status + "' WHERE EMAIL_ID = '" + email_ID + "'");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
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
	
	public int update_appointment(ArrayList<String> al) {
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("UPDATE APPOINTMENTS SET AADHAAR_NO = ?, APPOINTMENT_DATE = ?, VACCINE_NAME = ?, VACCINE_CENTER = ? WHERE EMAIL_ID = ?");
			if (ps != null) {
				ps.setString(1, al.get(1));
				ps.setString(2, al.get(2));
				ps.setString(3, al.get(3));
				ps.setString(4, al.get(4));
				ps.setString(5, al.get(0));
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