package com.mvd.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.mvd.dao.InsertOperations;
import com.mvd.dao.SelectOperations;
import com.mvd.dao.UpdateOperations;
import com.mvd.utility.EmailNotification;
import com.toedter.calendar.JYearChooser;

public class BookYourSlotPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField aadhaarNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BookYourSlotPage frame = new BookYourSlotPage("");
					frame.setLocationRelativeTo(null); // To set the frame at the center of screen
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookYourSlotPage(String username) {
		SelectOperations so = new SelectOperations();
		ArrayList<String> al = so.select_vaccine_centers();
		String status = so.select_vaccine_status(username);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		headerPanel.setBounds(0, 0, 900, 118);
		contentPane.add(headerPanel);

		JLabel closeLabel = new JLabel();
		closeLabel.setBounds(872, 3, 25, 25);
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/exitButton.png")));
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					setVisible(false);
					dispose();
				}
			}
		});
		headerPanel.setLayout(null);
		closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(closeLabel);

		JLabel leftHeading = new JLabel(
				"<HTML>\r\nMINISTRY OF <BR>\r\n<b>HEALTH </b> AND <BR>\r\n<b>FAMILY WELFARE</b><br>\r\nGOVERNMENT OF INDIA\r\n</HTML>");
		leftHeading.setBounds(35, 11, 179, 96);
		leftHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		leftHeading.setHorizontalAlignment(SwingConstants.LEFT);
		leftHeading.setForeground(Color.WHITE);
		leftHeading.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		leftHeading.setAlignmentY(0.0f);
		headerPanel.add(leftHeading);

		JLabel h1 = new JLabel("कोरोना से लड़ना है तो वैक्सीन है जरुरी");
		h1.setBounds(262, 11, 376, 55);
		h1.setHorizontalTextPosition(SwingConstants.CENTER);
		h1.setHorizontalAlignment(SwingConstants.CENTER);
		h1.setForeground(Color.WHITE);
		h1.setFont(new Font("Poppins", Font.BOLD, 22));
		h1.setAlignmentY(0.0f);
		headerPanel.add(h1);

		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setBounds(262, 57, 376, 50);
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Teko", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		headerPanel.add(h2);

		JLabel rightHeading = new JLabel(
				"<HTML><p style=\"text-align:right\">\r\nJOIN <b>INDIA'S<BR>\r\nGLORIOUS </b>JOURNEY<BR>\r\nOF <b>200 CRORE</b><br>\r\nVACCINATIONS\r\n</p></HTML>");
		rightHeading.setBounds(685, 11, 179, 96);
		rightHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		rightHeading.setHorizontalAlignment(SwingConstants.RIGHT);
		rightHeading.setForeground(Color.WHITE);
		rightHeading.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		rightHeading.setAlignmentY(0.0f);
		headerPanel.add(rightHeading);

		JLabel headerImg = new JLabel("");
		headerImg.setBounds(0, 0, 900, 118);
		headerImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/header.jpg")));
		headerPanel.add(headerImg);

		JPanel hamburger_panel = new JPanel();
		hamburger_panel.setOpaque(false);
		hamburger_panel.setBackground(new Color(0, 51, 102));
		hamburger_panel.setBorder(null);
		hamburger_panel.setBounds(0, 117, 230, 533);
		contentPane.add(hamburger_panel);
		hamburger_panel.setLayout(null);

		JPanel myProfilePanel = new JPanel();
		myProfilePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myProfilePanel.setOpaque(true);
				Dashboard db = new Dashboard(username);
				db.setLocationRelativeTo(null);
				db.setVisible(true);
				dispose();
			}
		});
		myProfilePanel.setOpaque(false);
		myProfilePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myProfilePanel.setBackground(new Color(0, 51, 102, 30));
		myProfilePanel.setBounds(0, 0, 231, 60);
		hamburger_panel.add(myProfilePanel);
		myProfilePanel.setLayout(null);

		JLabel label1 = new JLabel("My Profile");
		label1.setForeground(Color.BLACK);
		label1.setBounds(67, 0, 164, 60);
		myProfilePanel.add(label1);
		label1.setFont(new Font("Euclid Circular A", Font.BOLD, 17));

		JLabel logo1 = new JLabel("");
		logo1.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/ico_profile.png")));
		logo1.setBounds(21, 0, 46, 60);
		myProfilePanel.add(logo1);

		JSeparator s1 = new JSeparator();
		s1.setBackground(new Color(0, 51, 102));
		s1.setForeground(new Color(0, 51, 102));
		s1.setOrientation(SwingConstants.VERTICAL);
		s1.setBounds(20, 15, 3, 30);
		myProfilePanel.add(s1);

		JPanel bookSlotPanel = new JPanel();
		bookSlotPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookSlotPanel.setBackground(new Color(0, 51, 102, 30));
		bookSlotPanel.setLayout(null);
		bookSlotPanel.setBounds(0, 60, 231, 60);
		hamburger_panel.add(bookSlotPanel);

		JSeparator hs1 = new JSeparator();
		hs1.setForeground(new Color(0, 51, 102));
		hs1.setBackground(new Color(0, 51, 102));
		hs1.setBounds(0, 0, 252, 12);
		bookSlotPanel.add(hs1);

		JLabel label2 = new JLabel("Book Your Slot");
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label2.setBounds(67, 0, 162, 60);
		bookSlotPanel.add(label2);

		JLabel logo2 = new JLabel("");
		logo2.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/appointment_icon.png")));
		logo2.setBounds(24, 0, 46, 60);
		bookSlotPanel.add(logo2);

		JSeparator s2 = new JSeparator();
		s2.setOrientation(SwingConstants.VERTICAL);
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(20, 15, 3, 30);
		bookSlotPanel.add(s2);

		JPanel viewAppointmentPanel = new JPanel();
		viewAppointmentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewAppointmentPanel.setOpaque(true);
				ViewAppointmentPage vap = new ViewAppointmentPage(username);
				vap.setLocationRelativeTo(null);
				vap.setVisible(true);
				dispose();
			}
		});
		viewAppointmentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAppointmentPanel.setOpaque(false);
		viewAppointmentPanel.setBackground(new Color(0, 51, 102, 30));
		viewAppointmentPanel.setLayout(null);
		viewAppointmentPanel.setBounds(0, 120, 231, 60);
		hamburger_panel.add(viewAppointmentPanel);

		JSeparator hs2 = new JSeparator();
		hs2.setForeground(new Color(0, 51, 102));
		hs2.setBackground(new Color(0, 51, 102));
		hs2.setBounds(0, 0, 252, 12);
		viewAppointmentPanel.add(hs2);

		JLabel label3 = new JLabel("View Appointment");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label3.setBounds(67, 0, 162, 60);
		viewAppointmentPanel.add(label3);

		JLabel logo3 = new JLabel("");
		logo3.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/booking_ico.png")));
		logo3.setBounds(24, 0, 46, 60);
		viewAppointmentPanel.add(logo3);

		JSeparator s3 = new JSeparator();
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setForeground(new Color(0, 51, 102));
		s3.setBackground(new Color(0, 51, 102));
		s3.setBounds(20, 15, 3, 30);
		viewAppointmentPanel.add(s3);

		JSeparator hs3 = new JSeparator();
		hs3.setForeground(new Color(0, 51, 102));
		hs3.setBackground(new Color(0, 51, 102));
		hs3.setBounds(0, 58, 252, 12);
		viewAppointmentPanel.add(hs3);

		JPanel logoutPanel = new JPanel();
		logoutPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutPanel.setOpaque(true);
				LoginPage lp = new LoginPage();
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
				dispose();
			}
		});
		logoutPanel.setOpaque(false);
		logoutPanel.setBackground(new Color(0, 51, 102, 30));
		logoutPanel.setLayout(null);
		logoutPanel.setBounds(0, 473, 231, 60);
		hamburger_panel.add(logoutPanel);

		JSeparator hs4 = new JSeparator();
		hs4.setForeground(new Color(0, 51, 102));
		hs4.setBackground(new Color(0, 51, 102));
		hs4.setBounds(0, 0, 252, 12);
		logoutPanel.add(hs4);

		JLabel label4 = new JLabel("Logout");
		label4.setForeground(Color.BLACK);
		label4.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label4.setBounds(67, 0, 162, 60);
		logoutPanel.add(label4);

		JLabel logo4 = new JLabel("");
		logo4.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/log_out_ico.png")));
		logo4.setBounds(24, 0, 46, 60);
		logoutPanel.add(logo4);

		JSeparator s4 = new JSeparator();
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setForeground(new Color(0, 51, 102));
		s4.setBackground(new Color(0, 51, 102));
		s4.setBounds(20, 15, 3, 30);
		logoutPanel.add(s4);

		JLabel guidelines = new JLabel("");
		guidelines.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/guidelines_covid.png")));
		guidelines.setForeground(Color.BLACK);
		guidelines.setFont(new Font("Teko", Font.PLAIN, 38));
		guidelines.setBounds(0, 180, 230, 293);
		hamburger_panel.add(guidelines);

		JLabel heading = new JLabel("NEW APPOINTMENT");
		heading.setOpaque(true);
		heading.setIcon(new ImageIcon(BookYourSlotPage.class.getResource("/resources/bg.png")));
		heading.setHorizontalTextPosition(SwingConstants.CENTER);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(427, 140, 277, 31);
		contentPane.add(heading);
		heading.setForeground(new Color(0, 51, 102));
		heading.setFont(new Font("Euclid Circular A", Font.BOLD, 26));

		JPanel mainSection = new JPanel();
		mainSection.setOpaque(false);
		mainSection.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		mainSection.setBounds(265, 155, 600, 460);
		contentPane.add(mainSection);
		mainSection.setLayout(null);

		aadhaarNo = new JTextField();
		aadhaarNo.setToolTipText("");
		aadhaarNo.setOpaque(false);
		aadhaarNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		aadhaarNo.setColumns(10);
		aadhaarNo.setCaretColor(Color.BLACK);
		aadhaarNo.setBorder(null);
		aadhaarNo.setBounds(208, 56, 350, 34);
		mainSection.add(aadhaarNo);

		JSeparator saadhaar = new JSeparator();
		saadhaar.setForeground(new Color(0, 51, 102));
		saadhaar.setBackground(new Color(0, 51, 102));
		saadhaar.setBounds(208, 89, 350, 5);
		mainSection.add(saadhaar);

		JLabel lblAadharNo = new JLabel("Aadhaar No.");
		lblAadharNo.setForeground(Color.BLACK);
		lblAadharNo.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblAadharNo.setBounds(42, 58, 146, 29);
		mainSection.add(lblAadharNo);

		JLabel lblDateAppointment = new JLabel("<html>\r\nDate of<br>Appointment\r\n</html");
		lblDateAppointment.setForeground(Color.BLACK);
		lblDateAppointment.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblDateAppointment.setBounds(42, 120, 146, 51);
		mainSection.add(lblDateAppointment);

		JYearChooser year = new JYearChooser();
		year.setBounds(395, 123, 66, 30);
		mainSection.add(year);
		year.setValue(0);
		year.setStartYear(2022);
		year.setYear(0);
		year.setMaximum(2023);
		year.setMinimum(2022);
		year.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setBounds(0, 0, 66, 30);
		year.setLayout(null);

		JYearChooser month = new JYearChooser();
		month.setBounds(302, 123, 66, 30);
		mainSection.add(month);
		month.setYear(0);
		month.getSpinner().setBounds(0, 0, 66, 30);
		month.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setMaximum(12);
		month.setValue(0);
		month.setLayout(null);

		JYearChooser day = new JYearChooser();
		day.setBounds(208, 123, 66, 30);
		mainSection.add(day);
		day.setValue(1);
		day.setYear(0);
		day.setOpaque(false);
		day.getSpinner().setForeground(new Color(0, 0, 0));
		day.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		day.setMaximum(31);
		day.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setBounds(0, 0, 66, 30);
		day.setLayout(null);

		JLabel dayMonthYear = new JLabel("Day                 Month            Year");
		dayMonthYear.setBounds(208, 152, 253, 29);
		mainSection.add(dayMonthYear);
		dayMonthYear.setHorizontalTextPosition(SwingConstants.RIGHT);
		dayMonthYear.setHorizontalAlignment(SwingConstants.LEFT);
		dayMonthYear.setForeground(new Color(0, 51, 102));
		dayMonthYear.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));

		JLabel lblChooseVaccine = new JLabel("Choose Vaccine");
		lblChooseVaccine.setForeground(Color.BLACK);
		lblChooseVaccine.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblChooseVaccine.setBounds(42, 192, 146, 29);
		mainSection.add(lblChooseVaccine);

		ButtonGroup group = new ButtonGroup();

		JRadioButton Covaxin = new JRadioButton("Covaxin");
		Covaxin.setBounds(208, 194, 105, 23);
		mainSection.add(Covaxin);
		Covaxin.setOpaque(false);
		Covaxin.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		Covaxin.setActionCommand("Covaxin");
		group.add(Covaxin);

		JRadioButton Covishield = new JRadioButton("Covishield");
		Covishield.setBounds(395, 194, 115, 23);
		mainSection.add(Covishield);
		Covishield.setOpaque(false);
		Covishield.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		Covishield.setActionCommand("Covishield");
		group.add(Covishield);

		JLabel lblVaccineCenter = new JLabel("Vaccine Center");
		lblVaccineCenter.setForeground(Color.BLACK);
		lblVaccineCenter.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblVaccineCenter.setBounds(42, 243, 146, 29);
		mainSection.add(lblVaccineCenter);

		JComboBox<String> vaccineCenters = new JComboBox<>();
		vaccineCenters.setMaximumRowCount(30);
		vaccineCenters.setModel(new DefaultComboBoxModel<>(al.toArray(new String[al.size()])));
		vaccineCenters.setFont(new Font("Euclid Circular A Light", Font.PLAIN, 15));
		vaccineCenters.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 51, 102)));
		vaccineCenters.setBounds(209, 243, 349, 30);
		mainSection.add(vaccineCenters);

		JLabel r1 = new JLabel("*");
		r1.setVisible(false);
		r1.setForeground(Color.RED);
		r1.setFont(new Font("Euclid Circular A", Font.PLAIN, 20));
		r1.setHorizontalTextPosition(SwingConstants.RIGHT);
		r1.setHorizontalAlignment(SwingConstants.RIGHT);
		r1.setBounds(10, 58, 28, 23);
		mainSection.add(r1);

		JLabel r2 = new JLabel("*");
		r2.setVisible(false);
		r2.setHorizontalTextPosition(SwingConstants.RIGHT);
		r2.setHorizontalAlignment(SwingConstants.RIGHT);
		r2.setForeground(Color.RED);
		r2.setFont(new Font("Euclid Circular A", Font.PLAIN, 20));
		r2.setBounds(10, 192, 28, 23);
		mainSection.add(r2);

		JLabel r3 = new JLabel("*");
		r3.setVisible(false);
		r3.setHorizontalTextPosition(SwingConstants.RIGHT);
		r3.setHorizontalAlignment(SwingConstants.RIGHT);
		r3.setForeground(Color.RED);
		r3.setFont(new Font("Euclid Circular A", Font.PLAIN, 20));
		r3.setBounds(10, 243, 28, 23);
		mainSection.add(r3);

		JLabel error = new JLabel(
				"<html>ERROR!<br>Stock not available for selected vaccine<br>Please select other vaccine or try after some time</html>");
		error.setVisible(false);
		error.setVerticalAlignment(SwingConstants.TOP);
		error.setHorizontalTextPosition(SwingConstants.LEFT);
		error.setHorizontalAlignment(SwingConstants.LEFT);
		error.setForeground(Color.RED);
		error.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		error.setBounds(42, 379, 350, 64);
		mainSection.add(error);

		JLabel aadhaarError = new JLabel("* Invalid Aadhar Number");
		aadhaarError.setVisible(false);
		aadhaarError.setHorizontalTextPosition(SwingConstants.LEFT);
		aadhaarError.setHorizontalAlignment(SwingConstants.LEFT);
		aadhaarError.setForeground(Color.RED);
		aadhaarError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		aadhaarError.setBounds(208, 90, 193, 29);
		mainSection.add(aadhaarError);

		JButton btnBookSlot = new JButton("BOOK SLOT");
		btnBookSlot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean valAadhaar, valStock, valCenter, valDate = false;
				valAadhaar = aadhaarNo.getText().equals("");
				if (valAadhaar) {
					aadhaarError.setVisible(false);
					r1.setVisible(true);
				} else {
					r1.setVisible(false);
					Pattern ptr = Pattern.compile("[0-9]{12}");
					Matcher match = ptr.matcher(aadhaarNo.getText());
					valAadhaar = !(match.find() && match.group().equals(aadhaarNo.getText()));
					if (valAadhaar) {
						aadhaarError.setVisible(true);
					} else {
						aadhaarError.setVisible(false);
					}
				}

				valStock = group.isSelected(null);
				if (valStock) {
					r2.setVisible(true);
				} else {
					r2.setVisible(false);
				}

				valCenter = vaccineCenters.getSelectedItem().equals("Select a center to vaccinate");
				if (valCenter) {
					r3.setVisible(true);
				} else {
					r3.setVisible(false);
				}

				String appointment_date = year.getValue() + "-" + String.format("%02d", month.getValue()) + "-"
						+ String.format("%02d", day.getValue());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date app_date = sdf.parse(appointment_date);
					Date current_date = new Date();
					valDate = app_date.compareTo(current_date) < 0;
					if (valDate) {
						error.setText(
								"<html>ERROR!<br>Appointment Date cannot be less than current date<br>Please select correct date</html>");
						error.setVisible(true);
					} else {
						error.setVisible(false);
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				if (!(valAadhaar || valStock || valCenter || valDate)) {
					if (so.select_vaccine_stock(group.getSelection().getActionCommand()) == 0) {
						error.setText(
								"<html>ERROR!<br>Stock not available for selected vaccine<br>Please select other vaccine or try after some time</html>");
						error.setVisible(true);
					} else {
						error.setVisible(false);

						ArrayList<String> al = new ArrayList<>();
						al.add(username);
						al.add(aadhaarNo.getText());
						al.add(appointment_date);
						al.add(group.getSelection().getActionCommand());
						al.add((String) vaccineCenters.getSelectedItem());

						if (status.equals("Not Yet Vaccinated")) {
							InsertOperations io = new InsertOperations();
							int rows = io.insert_into_appointments(al);
							if (rows == 0) {
								JOptionPane.showMessageDialog(null, "Appointment Failed! Try Again", "Failed",
										JOptionPane.ERROR_MESSAGE);
							} else {
								UpdateOperations uo = new UpdateOperations();
								uo.decrement_stock(group.getSelection().getActionCommand());
								EmailNotification en = new EmailNotification();
								en.send_notification(username);
								JOptionPane.showMessageDialog(null,
										"Slot Booked Successfully\nCheck your mail for confirmation", "Success",
										JOptionPane.INFORMATION_MESSAGE);
								myProfilePanel.setOpaque(true);
								Dashboard db = new Dashboard(username);
								db.setLocationRelativeTo(null);
								db.setVisible(true);
								dispose();
							}
						} else {
							UpdateOperations uo = new UpdateOperations();
							int rows = uo.update_appointment(al);
							if (rows == 0) {
								JOptionPane.showMessageDialog(null, "Appointment Failed! Try Again", "Failed",
										JOptionPane.ERROR_MESSAGE);
							} else {
								EmailNotification en = new EmailNotification();
								en.send_notification(username);
								JOptionPane.showMessageDialog(null,
										"Slot Booked Successfully\nCheck your mail for confirmation", "Success",
										JOptionPane.INFORMATION_MESSAGE);
								myProfilePanel.setOpaque(true);
								Dashboard db = new Dashboard(username);
								db.setLocationRelativeTo(null);
								db.setVisible(true);
								dispose();
							}
						}
					}
				}

			}
		});
		btnBookSlot.setForeground(Color.WHITE);
		btnBookSlot.setFont(new Font("Euclid Circular A", Font.BOLD, 16));
		btnBookSlot.setBorderPainted(false);
		btnBookSlot.setBackground(new Color(0, 128, 0));
		btnBookSlot.setBounds(42, 326, 133, 42);
		mainSection.add(btnBookSlot);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myProfilePanel.setOpaque(true);
				Dashboard db = new Dashboard(username);
				db.setLocationRelativeTo(null);
				db.setVisible(true);
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Euclid Circular A", Font.BOLD, 16));
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(197, 326, 116, 42);
		mainSection.add(btnCancel);

		JLabel slotBooked = new JLabel(
				"<html><center>You have already booked a slot.<br>Check <b>View Apointments</b> tab for more details.</center></html>");
		slotBooked.setVisible(false);
		slotBooked.setHorizontalTextPosition(SwingConstants.CENTER);
		slotBooked.setHorizontalAlignment(SwingConstants.CENTER);
		slotBooked.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		slotBooked.setForeground(Color.BLACK);
		slotBooked.setFont(new Font("Euclid Circular A", Font.PLAIN, 20));
		slotBooked.setBounds(265, 155, 600, 110);
		contentPane.add(slotBooked);

		JButton btnReschedule = new JButton("RESCHEDULE");
		btnReschedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReschedule.setFocusable(false);
		btnReschedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainSection.setVisible(true);
				ArrayList<String> al = so.select_appointment_details(username);
				aadhaarNo.setText(al.get(1));
				day.setValue(Integer.parseInt(al.get(2).substring(8)));
				month.setValue(Integer.parseInt(al.get(2).substring(5, 7)));
				year.setValue(Integer.parseInt(al.get(2).substring(0, 4)));
				if (al.get(3).equals("Covaxin")) {
					Covaxin.setSelected(true);
				} else {
					Covishield.setSelected(true);
				}
				vaccineCenters.setSelectedItem(al.get(4));
				slotBooked.setVisible(false);
				btnReschedule.setVisible(false);
				heading.setText("NEW APPOINTMENT");
				heading.setBounds(427, 140, 277, 31);
			}
		});
		btnReschedule.setVisible(false);
		btnReschedule.setForeground(Color.WHITE);
		btnReschedule.setFont(new Font("Euclid Circular A", Font.BOLD, 16));
		btnReschedule.setBorderPainted(false);
		btnReschedule.setBackground(new Color(0, 128, 0));
		btnReschedule.setBounds(265, 285, 144, 42);
		contentPane.add(btnReschedule);

		if (status.equals("Not Yet Vaccinated")) {
			mainSection.setVisible(true);
			slotBooked.setVisible(false);
			btnReschedule.setVisible(false);
		} else {
			slotBooked.setVisible(true);
			heading.setText("SLOT ALREADY BOOKED");
			heading.setBounds(395, 140, 334, 31);
			mainSection.setVisible(false);
			if (status.equals("Scheduled")) {
				btnReschedule.setVisible(true);
			} else {
				btnReschedule.setVisible(false);
			}
		}

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setBorder(null);
		backgroundImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bg.png")));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
