package com.mvd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperations {
	public static String url = "jdbc:mysql://localhost:3306/mvd_db";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "";
	
	public int update_vaccine_stock(String vaccine_name) {
		Connection con = null;
		Statement st = null;
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
}