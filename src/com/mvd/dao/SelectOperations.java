package com.mvd.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SelectOperations {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mvd_db";
	private static String user = "root";
	private static String pass = "";
	HashMap<String, String> hm = new HashMap<String, String>();

	public void select_username_password() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT EMAIL_ID, PASSWORD FROM REGISTRATION_TABLE");
			while (rs.next()) {
				hm.put(rs.getString(1), rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	}

	public boolean check_username_password(String username, String password) {
		if(hm.containsKey(username)) {
			if(hm.get(username).equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public ArrayList<String> select_for_dashboard(String username){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> al = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT FULL_NAME, MOBILE_NO, DOB, GENDER FROM REGISTRATION_TABLE WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				al.add(rs.getString("FULL_NAME"));
				al.add(rs.getString("MOBILE_NO"));
				al.add(rs.getString("DOB"));
				al.add(rs.getString("GENDER"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return al;
	}
}
