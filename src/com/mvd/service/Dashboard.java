package com.mvd.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

public class Dashboard extends JFrame {
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
					Dashboard frame = new Dashboard("");
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
	public Dashboard(String username) {
		SelectOperations so = new SelectOperations();
		ArrayList<String> al = so.select_for_dashboard(username);

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

		JPanel myProfileSection = new JPanel();
		myProfileSection.setOpaque(false);
		myProfileSection.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		myProfileSection.setBounds(245, 134, 640, 500);
		contentPane.add(myProfileSection);
		myProfileSection.setLayout(null);

		JLabel m_profile_photo = new JLabel("");
		m_profile_photo.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/m_profile_photo.png")));
		m_profile_photo.setBounds(20, 20, 225, 225);
		myProfileSection.add(m_profile_photo);

		JLabel f_profile_photo = new JLabel("");
		f_profile_photo.setVisible(false);
		f_profile_photo.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/f_profile_photo.png")));
		f_profile_photo.setBounds(20, 20, 225, 225);
		myProfileSection.add(f_profile_photo);

		if (al.get(3).equals("Female")) {
			m_profile_photo.setVisible(false);
			f_profile_photo.setVisible(true);
		}

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 51, 102));
		separator.setForeground(new Color(0, 51, 102));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(255, 40, 3, 185);
		myProfileSection.add(separator);

		JLabel name = new JLabel(al.get(0));
		name.setForeground(Color.BLACK);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Euclid Circular A", Font.BOLD, 24));
		name.setBounds(278, 50, 322, 36);
		myProfileSection.add(name);

		JLabel icon_email = new JLabel("");
		icon_email.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/ico_email.png")));
		icon_email.setForeground(Color.DARK_GRAY);
		icon_email.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		icon_email.setBounds(278, 104, 25, 25);
		myProfileSection.add(icon_email);

		JLabel email_ID = new JLabel(username);
		email_ID.setForeground(Color.DARK_GRAY);
		email_ID.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		email_ID.setBounds(313, 104, 242, 25);
		myProfileSection.add(email_ID);

		JLabel icon_mobile = new JLabel("");
		icon_mobile.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/phone_no_ico.png")));
		icon_mobile.setForeground(Color.DARK_GRAY);
		icon_mobile.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		icon_mobile.setBounds(278, 140, 25, 25);
		myProfileSection.add(icon_mobile);

		JLabel mobile_no = new JLabel(al.get(1));
		mobile_no.setForeground(Color.DARK_GRAY);
		mobile_no.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		mobile_no.setBounds(313, 140, 242, 25);
		myProfileSection.add(mobile_no);

		JLabel icon_dob = new JLabel("");
		icon_dob.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/birth-date-icon.png")));
		icon_dob.setForeground(Color.DARK_GRAY);
		icon_dob.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		icon_dob.setBounds(278, 176, 25, 25);
		myProfileSection.add(icon_dob);

		JLabel dob = new JLabel(al.get(2));
		dob.setForeground(Color.DARK_GRAY);
		dob.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		dob.setBounds(313, 176, 242, 25);
		myProfileSection.add(dob);

		JLabel lblVaccinationStatus = new JLabel("VACCINATION STATUS");
		lblVaccinationStatus.setOpaque(true);
		lblVaccinationStatus.setBackground(new Color(230, 248, 255));
		lblVaccinationStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVaccinationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccinationStatus.setForeground(new Color(0, 51, 102));
		lblVaccinationStatus.setFont(new Font("Euclid Circular A", Font.BOLD, 22));
		lblVaccinationStatus.setBounds(183, 252, 273, 50);
		myProfileSection.add(lblVaccinationStatus);

		JPanel status_panel = new JPanel();
		status_panel.setOpaque(false);
		status_panel.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		status_panel.setBackground(new Color(230, 248, 255));
		status_panel.setBounds(159, 276, 322, 157);
		myProfileSection.add(status_panel);
		status_panel.setLayout(null);

		JLabel status_label = new JLabel("Not Yet Vaccinated");
		status_label.setHorizontalTextPosition(SwingConstants.CENTER);
		status_label.setHorizontalAlignment(SwingConstants.CENTER);
		status_label.setForeground(Color.RED);
		status_label.setFont(new Font("Euclid Circular A", Font.PLAIN, 17));
		status_label.setBounds(32, 31, 257, 34);
		status_panel.add(status_label);

		JLabel status_icon = new JLabel("");
		status_icon.setBounds(136, 76, 50, 50);
		status_panel.add(status_icon);
		status_icon.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/red_cross.png")));
		status_icon.setHorizontalTextPosition(SwingConstants.CENTER);
		status_icon.setHorizontalAlignment(SwingConstants.CENTER);

		String status = so.check_vaccination_status(username);
		status_label.setText(status);
		if (status.equals("Vaccinated")) {
			status_label.setForeground(new Color(0, 128, 0));
			status_icon.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/green_tick.png")));
		} else if (status.equals("Scheduled")) {
			status_label.setForeground(new Color(255, 140, 0));
			status_icon.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/scheduled.png")));
		} else {
			status_label.setForeground(Color.RED);
			status_icon.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/red_cross.png")));
		}

		JPanel hamburger_panel = new JPanel();
		hamburger_panel.setOpaque(false);
		hamburger_panel.setBackground(new Color(0, 51, 102));
		hamburger_panel.setBorder(null);
		hamburger_panel.setBounds(0, 117, 230, 533);
		contentPane.add(hamburger_panel);
		hamburger_panel.setLayout(null);

		JPanel myProfilePanel = new JPanel();
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

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setBorder(null);
		backgroundImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bg.png")));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);

	}
}
