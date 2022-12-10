package com.mvd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeleteOperations {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mvd_db";
	private static String user = "root";
	private static String pass = "";
	Connection con = null;
	Statement st = null;

	public int delete_appointments(ArrayList<Integer> rows) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			for (Integer row : rows) {
				st.executeUpdate("DELETE FROM APPOINTMENTS WHERE ID = " + row);
			}
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
