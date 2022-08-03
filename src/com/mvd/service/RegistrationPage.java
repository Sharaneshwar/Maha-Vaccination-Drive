package com.mvd.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Group;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

public class RegistrationPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullName;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JTextField mobileNo;
	private JTextField emailID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		headerPanel.setBounds(0, 0, 900, 118);
		contentPane.add(headerPanel);

		JLabel closeLabel = new JLabel();
		Image image = new ImageIcon(this.getClass().getResource("/exitButton.png")).getImage();
		closeLabel.setIcon(new ImageIcon(image));
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(872, 3, 25, 25);
		headerPanel.add(closeLabel);

		JLabel leftHeading = new JLabel(
				"<HTML>\r\nMINISTRY OF <BR>\r\n<b>HEALTH </b> AND <BR>\r\n<b>FAMILY WELFARE</b><br>\r\nGOVERNMENT OF INDIA\r\n</HTML>");
		leftHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		leftHeading.setHorizontalAlignment(SwingConstants.LEFT);
		leftHeading.setForeground(Color.WHITE);
		leftHeading.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		leftHeading.setAlignmentY(0.0f);
		leftHeading.setBounds(35, 11, 179, 96);
		headerPanel.add(leftHeading);

		JLabel h1 = new JLabel("कोरोना से लड़ना है तो वैक्सीन है जरुरी");
		h1.setHorizontalTextPosition(SwingConstants.CENTER);
		h1.setHorizontalAlignment(SwingConstants.CENTER);
		h1.setForeground(Color.WHITE);
		h1.setFont(new Font("Poppins", Font.BOLD, 22));
		h1.setAlignmentY(0.0f);
		h1.setBounds(262, 11, 376, 55);
		headerPanel.add(h1);

		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Teko", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(262, 57, 376, 50);
		headerPanel.add(h2);

		JLabel rightHeading = new JLabel(
				"<HTML><p style=\"text-align:right\">\r\nJOIN <b>INDIA'S<BR>\r\nGLORIOUS </b>JOURNEY<BR>\r\nOF <b>200 CRORE</b><br>\r\nVACCINATIONS\r\n</p></HTML>");
		rightHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		rightHeading.setHorizontalAlignment(SwingConstants.RIGHT);
		rightHeading.setForeground(Color.WHITE);
		rightHeading.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		rightHeading.setAlignmentY(0.0f);
		rightHeading.setBounds(685, 11, 179, 96);
		headerPanel.add(rightHeading);

		JLabel headerImg = new JLabel("");
		image = new ImageIcon(this.getClass().getResource("/header.jpg")).getImage();
		headerImg.setIcon(new ImageIcon(image));
		headerImg.setBounds(0, 0, 900, 118);
		headerPanel.add(headerImg);

		JLabel RegisterLabel = new JLabel("REGISTER YOURSELF TO PROTECT THE NATION");
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		RegisterLabel.setIcon(new ImageIcon(image));
		RegisterLabel.setForeground(new Color(0, 51, 102));
		RegisterLabel.setBounds(179, 147, 531, 20);
		contentPane.add(RegisterLabel);
		RegisterLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 22));
		RegisterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		RegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RegisterLabel.setBackground(new Color(238, 232, 170));

		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new LineBorder(new Color(0, 51, 102), 3, true));
		registerPanel.setOpaque(false);
		registerPanel.setBounds(46, 161, 821, 511);
		contentPane.add(registerPanel);
		registerPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		registerPanel.setBackground(new Color(135, 206, 235));
		registerPanel.setLayout(null);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(0, 51, 102));
		separator_1_2.setBackground(new Color(0, 51, 102));
		separator_1_2.setBounds(71, 249, 310, 5);
		registerPanel.add(separator_1_2);
		
		emailID = new JTextField();
		emailID.setToolTipText("");
		emailID.setOpaque(false);
		emailID.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		emailID.setColumns(10);
		emailID.setCaretColor(Color.BLACK);
		emailID.setBorder(null);
		emailID.setBounds(71, 215, 310, 34);
		registerPanel.add(emailID);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 51, 102));
		separator.setBackground(new Color(0, 51, 102));
		separator.setBounds(71, 95, 310, 5);
		registerPanel.add(separator);

		JLabel fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setForeground(new Color(0, 0, 0));
		fullNameLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		fullNameLabel.setBounds(71, 35, 105, 29);
		registerPanel.add(fullNameLabel);
		
		fullName = new JTextField();
		fullName.setToolTipText("");
		fullName.setOpaque(false);
		fullName.setCaretColor(new Color(0, 0, 0));
		fullName.setBorder(null);
		fullName.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		fullName.setBounds(71, 62, 310, 34);
		registerPanel.add(fullName);
		fullName.setColumns(10);

		JLabel mobileLabel = new JLabel("Mobile No.");
		mobileLabel.setForeground(new Color(0, 0, 0));
		mobileLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		mobileLabel.setBounds(71, 115, 105, 29);
		registerPanel.add(mobileLabel);

		JLabel emailLabel = new JLabel("Email-ID (optional)");
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		emailLabel.setBounds(71, 188, 164, 29);
		registerPanel.add(emailLabel);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		genderLabel.setBounds(71, 343, 105, 29);
		registerPanel.add(genderLabel);

		JRadioButton MaleRB = new JRadioButton("Male");
		MaleRB.setOpaque(false);
		MaleRB.setBackground(Color.WHITE);
		MaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		MaleRB.setBounds(71, 379, 66, 23);
		registerPanel.add(MaleRB);

		JRadioButton FemaleRB = new JRadioButton("Female");
		FemaleRB.setOpaque(false);
		FemaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		FemaleRB.setBackground(Color.WHITE);
		FemaleRB.setBounds(165, 379, 115, 23);
		registerPanel.add(FemaleRB);
		
		ButtonGroup group = new ButtonGroup();		
		group.add(MaleRB);
		group.add(FemaleRB);

		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setForeground(new Color(0, 0, 0));
		dobLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		dobLabel.setBounds(71, 262, 115, 29);
		registerPanel.add(dobLabel);

		JLabel mobileNoError = new JLabel("* Incorrect Number");
		mobileNoError.setVisible(false);
		mobileNoError.setForeground(new Color(255, 0, 0));
		mobileNoError.setHorizontalTextPosition(SwingConstants.RIGHT);
		mobileNoError.setHorizontalAlignment(SwingConstants.RIGHT);
		mobileNoError.setFont(new Font("Euclid Circular A", Font.PLAIN, 12));
		mobileNoError.setBounds(244, 118, 137, 27);
		registerPanel.add(mobileNoError);

		JLabel emailError = new JLabel("* Incorrect Email-ID");
		emailError.setVisible(false);
		emailError.setHorizontalTextPosition(SwingConstants.RIGHT);
		emailError.setHorizontalAlignment(SwingConstants.RIGHT);
		emailError.setForeground(Color.RED);
		emailError.setFont(new Font("Euclid Circular A", Font.PLAIN, 12));
		emailError.setBounds(244, 192, 113, 25);
		registerPanel.add(emailError);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		addressLabel.setBounds(456, 11, 132, 29);
		registerPanel.add(addressLabel);

		JLabel lblCity = new JLabel("Password");
		lblCity.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblCity.setBounds(430, 188, 105, 29);
		registerPanel.add(lblCity);

		JLabel lblState = new JLabel("Confirm Password");
		lblState.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblState.setBounds(430, 262, 201, 29);
		registerPanel.add(lblState);

		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		address.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		address.setBounds(430, 67, 310, 110);
		registerPanel.add(address);

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern ptr = Pattern.compile("(0/+91)?[6-9][0-9]{9}");
				Matcher match = ptr.matcher(mobileNo.getText());
				boolean validateMobileNo = match.find() && match.group().equals(mobileNo.getText());
				if (validateMobileNo) {
					mobileNoError.setVisible(false);
				} else {
					mobileNoError.setVisible(true);
				}
				ptr = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)");
				match = ptr.matcher(emailID.getText());
				boolean validateEmail = match.find() && match.group().equals(emailID.getText());
				if (validateEmail) {
					emailError.setVisible(false);
				} else {
					emailError.setVisible(true);
				}
				if (validateMobileNo && validateEmail) {
					LoginPage lp = new LoginPage();
					lp.setVisible(true);
					setVisible(false);
				}
			}
		});
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(0, 128, 0));
		submit.setBorderPainted(false);
		submit.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		submit.setBounds(266, 429, 115, 42);
		registerPanel.add(submit);

		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fullName.setText("");
				mobileNo.setText("");
				emailID.setText("");
				address.setText("");
				MaleRB.setSelected(false);
				FemaleRB.setSelected(false);
				mobileNoError.setVisible(false);
				emailError.setVisible(false);
			}
		});
		reset.setForeground(new Color(255, 255, 255));
		reset.setBackground(new Color(255, 0, 0));
		reset.setBorderPainted(false);
		reset.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		reset.setBounds(430, 429, 115, 42);
		registerPanel.add(reset);
		
		password = new JPasswordField();
		password.setBounds(430, 218, 310, 35);
		registerPanel.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(430, 293, 310, 35);
		registerPanel.add(confirmPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 51, 102));
		separator_1.setBackground(new Color(0, 51, 102));
		separator_1.setBounds(71, 175, 310, 5);
		registerPanel.add(separator_1);
		
		mobileNo = new JTextField();
		mobileNo.setToolTipText("");
		mobileNo.setOpaque(false);
		mobileNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		mobileNo.setColumns(10);
		mobileNo.setCaretColor(Color.BLACK);
		mobileNo.setBorder(null);
		mobileNo.setBounds(71, 142, 310, 34);
		registerPanel.add(mobileNo);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 51, 102));
		separator_1_1.setBackground(new Color(0, 51, 102));
		separator_1_1.setBounds(71, 321, 50, 10);
		registerPanel.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(0, 51, 102));
		separator_1_1_1.setBackground(new Color(0, 51, 102));
		separator_1_1_1.setBounds(165, 321, 50, 10);
		registerPanel.add(separator_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(new Color(0, 51, 102));
		separator_1_1_1_1.setBackground(new Color(0, 51, 102));
		separator_1_1_1_1.setBounds(258, 321, 50, 10);
		registerPanel.add(separator_1_1_1_1);
		
		JYearChooser year = new JYearChooser();
		year.setMaximum(2022);
		year.setMinimum(1900);
		year.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setBounds(0, 0, 66, 30);
		year.setBounds(258, 293, 66, 30);
		registerPanel.add(year);
		year.setLayout(null);
		
		JYearChooser month = new JYearChooser();
		month.getSpinner().setBounds(0, 0, 66, 30);
		month.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setMaximum(12);
		month.setValue(1);
		month.setBounds(165, 293, 66, 30);
		registerPanel.add(month);
		month.setLayout(null);
		
		JYearChooser day = new JYearChooser();
		day.setOpaque(false);
		day.getSpinner().setForeground(new Color(0, 0, 0));
		day.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		day.setMaximum(31);
		day.setValue(1);
		day.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setBounds(0, 0, 66, 30);
		day.setBounds(71, 293, 66, 30);
		registerPanel.add(day);
		day.setLayout(null);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setAutoscrolls(true);
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		backgroundImg.setIcon(new ImageIcon(image));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 700);
		contentPane.add(backgroundImg);
	}
}
