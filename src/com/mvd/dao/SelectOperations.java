package com.mvd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import org.jfree.data.general.DefaultPieDataset;

public class SelectOperations {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mvd_db";
	private static String user = "root";
	private static String pass = "";
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<String> select_for_dashboard(String username) {
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT FULL_NAME, MOBILE_NO, DOB, GENDER FROM REGISTRATION_TABLE WHERE EMAIL_ID = '"
					+ username + "'");
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

	public String select_user_name(String username) {
		String name = "user";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT FULL_NAME FROM REGISTRATION_TABLE WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				name = rs.getString("FULL_NAME");
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
		return name;
	}

	public int select_vaccine_stock(String vaccine) {
		int stock = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT STOCK FROM VACCINE_STOCK WHERE NAME = '" + vaccine + "'");
			while (rs.next()) {
				stock = rs.getInt("Stock");
			}

		} catch (ClassNotFoundException e0) {
			e0.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
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
		return stock;
	}

	public String check_vaccination_status(String username) {
		String date = "no-date";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT APPOINTMENT_DATE FROM APPOINTMENTS WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				date = rs.getString("APPOINTMENT_DATE");
			}
		} catch (ClassNotFoundException e0) {
			e0.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
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
		if (date.equals("no-date")) {
			return "Not Yet Vaccinated";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				UpdateOperations uo = new UpdateOperations();
				Date app_date = sdf.parse(date);
				Date current_date = new Date();
				if (app_date.compareTo(current_date) > 0) {
					uo.update_vaccine_status(username, "Scheduled");
					return "Scheduled";
				} else {
					uo.update_vaccine_status(username, "Vaccinated");
					return "Vaccinated";
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return "Not Yet Vaccinated";
	}

	public ArrayList<String> select_appointment_details(String username) {
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT ID, AADHAAR_NO, APPOINTMENT_DATE, VACCINE_NAME, VACCINE_CENTER FROM APPOINTMENTS WHERE EMAIL_ID = '"
							+ username + "'");
			while (rs.next()) {
				al.add("MVD0000777" + String.valueOf(rs.getInt("ID")));
				al.add(rs.getString("AADHAAR_NO"));
				al.add(rs.getString("APPOINTMENT_DATE"));
				al.add(rs.getString("VACCINE_NAME"));
				al.add(rs.getString("VACCINE_CENTER"));
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

	public DefaultTableModel create_appointments_table() {
		String[] columns = { "", "ID", "EMAIL_ID", "AADHAAR_NO", "APPOINTMENT_DATE", "VACCINE_NAME", "VACCINE_CENTER" };
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM APPOINTMENTS");
			while (rs.next()) {
				model.addRow(new Object[] { false, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
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
		return model;
	}

	public ArrayList<String> select_vaccine_centers() {
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT CENTER_NAME FROM VACCINE_CENTERS");
			al.add("Select a center to vaccinate");
			while (rs.next()) {
				al.add(rs.getString("CENTER_NAME"));
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

	public String select_vaccine_status(String username) {
		String status = "Not Yet Vaccinated";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT STATUS FROM VACCINE_STATUS WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				status = rs.getString("STATUS");
			}
		} catch (ClassNotFoundException e0) {
			e0.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
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
		return status;
	}

	public DefaultPieDataset select_pie_dataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		int rows = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT COUNT(ID) FROM VACCINE_STATUS WHERE STATUS = 'Not Yet Vaccinated'");
			while (rs.next()) {
				rows = rs.getInt(1);
			}
			dataset.setValue("Not Yet Vaccinated", rows);
			rows = 0;
			rs = st.executeQuery("SELECT COUNT(ID) FROM VACCINE_STATUS WHERE STATUS = 'Scheduled'");
			while (rs.next()) {
				rows = rs.getInt(1);
			}
			dataset.setValue("Scheduled", rows);
			rows = 0;
			rs = st.executeQuery("SELECT COUNT(ID) FROM VACCINE_STATUS WHERE STATUS = 'Vaccinated'");
			while (rs.next()) {
				rows = rs.getInt(1);
			}
			dataset.setValue("Vaccinated", rows);
		} catch (ClassNotFoundException e0) {
			e0.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
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
		return dataset;
	}
}
