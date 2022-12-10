package com.mvd.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.mvd.dao.SelectOperations;

public class ViewAppointmentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ViewAppointmentPage frame = new ViewAppointmentPage("");
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
	public ViewAppointmentPage(String username) {
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
		logo1.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/ico_profile.png")));
		logo1.setBounds(21, 0, 46, 60);
		myProfilePanel.add(logo1);

		JSeparator s1 = new JSeparator();
		s1.setBackground(new Color(0, 51, 102));
		s1.setForeground(new Color(0, 51, 102));
		s1.setOrientation(SwingConstants.VERTICAL);
		s1.setBounds(20, 15, 3, 30);
		myProfilePanel.add(s1);

		JPanel bookSlotPanel = new JPanel();
		bookSlotPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bookSlotPanel.setOpaque(true);
				BookYourSlotPage bysp = new BookYourSlotPage(username);
				bysp.setLocationRelativeTo(null);
				bysp.setVisible(true);
				dispose();
			}
		});
		bookSlotPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookSlotPanel.setOpaque(false);
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
		logo2.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/appointment_icon.png")));
		logo2.setBounds(24, 0, 46, 60);
		bookSlotPanel.add(logo2);

		JSeparator s2 = new JSeparator();
		s2.setOrientation(SwingConstants.VERTICAL);
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(20, 15, 3, 30);
		bookSlotPanel.add(s2);

		JPanel viewAppointmentPanel = new JPanel();
		viewAppointmentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		logo3.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/booking_ico.png")));
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
		logo4.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/log_out_ico.png")));
		logo4.setBounds(24, 0, 46, 60);
		logoutPanel.add(logo4);

		JSeparator s4 = new JSeparator();
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setForeground(new Color(0, 51, 102));
		s4.setBackground(new Color(0, 51, 102));
		s4.setBounds(20, 15, 3, 30);
		logoutPanel.add(s4);

		JLabel guidelines = new JLabel("");
		guidelines.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/guidelines_covid.png")));
		guidelines.setForeground(Color.BLACK);
		guidelines.setFont(new Font("Teko", Font.PLAIN, 38));
		guidelines.setBounds(0, 180, 230, 293);
		hamburger_panel.add(guidelines);

		JLabel lblAppointmentDetails = new JLabel("APPOINTMENT DETAILS");
		lblAppointmentDetails.setIcon(new ImageIcon(ViewAppointmentPage.class.getResource("/resources/bg.png")));
		lblAppointmentDetails.setOpaque(true);
		lblAppointmentDetails.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAppointmentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentDetails.setForeground(new Color(0, 51, 102));
		lblAppointmentDetails.setFont(new Font("Euclid Circular A", Font.BOLD, 26));
		lblAppointmentDetails.setBounds(399, 139, 323, 31);
		contentPane.add(lblAppointmentDetails);

		JPanel mainSection = new JPanel();
		mainSection.setOpaque(false);
		mainSection.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		mainSection.setBounds(265, 155, 600, 340);
		contentPane.add(mainSection);
		mainSection.setLayout(null);

		JLabel lblAppointmentId = new JLabel("Appointment ID");
		lblAppointmentId.setForeground(Color.BLACK);
		lblAppointmentId.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblAppointmentId.setBounds(30, 47, 164, 29);
		mainSection.add(lblAppointmentId);

		JLabel lblAppointmentDate = new JLabel("Date");
		lblAppointmentDate.setForeground(Color.BLACK);
		lblAppointmentDate.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblAppointmentDate.setBounds(30, 124, 164, 29);
		mainSection.add(lblAppointmentDate);

		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setForeground(Color.BLACK);
		lblVaccineName.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblVaccineName.setBounds(315, 124, 164, 29);
		mainSection.add(lblVaccineName);

		JLabel lblVaccineCenter = new JLabel("Vaccine Center");
		lblVaccineCenter.setForeground(Color.BLACK);
		lblVaccineCenter.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblVaccineCenter.setBounds(30, 203, 164, 29);
		mainSection.add(lblVaccineCenter);

		JLabel lblAadharNo = new JLabel("Aadhaar No.");
		lblAadharNo.setForeground(Color.BLACK);
		lblAadharNo.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblAadharNo.setBounds(315, 47, 164, 29);
		mainSection.add(lblAadharNo);

		JLabel appointmentID = new JLabel("");
		appointmentID.setAlignmentY(Component.TOP_ALIGNMENT);
		appointmentID.setForeground(Color.BLACK);
		appointmentID.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		appointmentID.setBounds(30, 74, 232, 29);
		mainSection.add(appointmentID);

		JLabel date = new JLabel("");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		date.setAlignmentY(0.0f);
		date.setBounds(30, 150, 232, 29);
		mainSection.add(date);

		JLabel vaccineCenter = new JLabel("");
		vaccineCenter.setVerticalTextPosition(SwingConstants.TOP);
		vaccineCenter.setVerticalAlignment(SwingConstants.TOP);
		vaccineCenter.setForeground(Color.BLACK);
		vaccineCenter.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		vaccineCenter.setAlignmentY(0.0f);
		vaccineCenter.setBounds(30, 231, 537, 42);
		mainSection.add(vaccineCenter);

		JLabel aadhaarNo = new JLabel("");
		aadhaarNo.setForeground(Color.BLACK);
		aadhaarNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		aadhaarNo.setAlignmentY(0.0f);
		aadhaarNo.setBounds(315, 74, 232, 29);
		mainSection.add(aadhaarNo);

		JLabel vaccineName = new JLabel("");
		vaccineName.setForeground(Color.BLACK);
		vaccineName.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		vaccineName.setAlignmentY(0.0f);
		vaccineName.setBounds(315, 150, 232, 29);
		mainSection.add(vaccineName);

		JLabel lblACopyOf = new JLabel(
				"<html>\r\nA copy of this is sent to your registered email address.<br>\r\nIf not present in Inbox, please check spam folder.\r\n<html>");
		lblACopyOf.setForeground(new Color(0, 51, 102));
		lblACopyOf.setFont(new Font("Euclid Circular A", Font.ITALIC, 15));
		lblACopyOf.setAlignmentY(0.0f);
		lblACopyOf.setBounds(30, 279, 537, 50);
		mainSection.add(lblACopyOf);

		JLabel noAppointmentLabel = new JLabel(
				"<html><center>\r\nNo appointments booked yet for vaccination<br>\r\nOpen <b>Book Your Slot</b> tab to schedule the appointment\r\n</center></html>");
		noAppointmentLabel.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		noAppointmentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		noAppointmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		noAppointmentLabel.setFont(new Font("Euclid Circular A", Font.PLAIN, 20));
		noAppointmentLabel.setBounds(265, 155, 600, 103);
		contentPane.add(noAppointmentLabel);

		SelectOperations so = new SelectOperations();
		String status = so.check_vaccination_status(username);
		if (status.equals("Not Yet Vaccinated")) {
			mainSection.setVisible(false);
			noAppointmentLabel.setVisible(true);
		} else {
			ArrayList<String> al = so.select_appointment_details(username);
			noAppointmentLabel.setVisible(false);
			appointmentID.setText(al.get(0));
			aadhaarNo.setText(al.get(1));
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2 = new SimpleDateFormat("EEEE, MMMM d, yyyy");
			Date app_date = null;
			try {
				app_date = format1.parse(al.get(2));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			date.setText(format2.format(app_date));
			vaccineName.setText(al.get(3));
			vaccineCenter.setText(al.get(4) + ", Solapur");
		}

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setBorder(null);
		backgroundImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bg.png")));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
