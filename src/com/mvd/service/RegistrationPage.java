package com.mvd.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import com.toedter.calendar.JYearChooser;
import java.awt.Dimension;

public class RegistrationPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullName;
	private JTextField mobileNo;
	private JTextField emailID;
	private JPasswordField password;
	private JPasswordField confirmPassword;

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
		setBounds(100, 100, 900, 650);
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
		RegisterLabel.setBounds(179, 152, 531, 20);
		contentPane.add(RegisterLabel);
		RegisterLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 22));
		RegisterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		RegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RegisterLabel.setBackground(new Color(238, 232, 170));

		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new LineBorder(new Color(0, 51, 102), 3, true));
		registerPanel.setOpaque(false);
		registerPanel.setBounds(40, 161, 820, 450);
		contentPane.add(registerPanel);
		registerPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		registerPanel.setBackground(new Color(135, 206, 235));
		registerPanel.setLayout(null);

		password = new JPasswordField();
		password.setBorder(null);
		password.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		password.setOpaque(false);
		password.setBounds(466, 215, 310, 34);
		registerPanel.add(password);

		JSeparator s7 = new JSeparator();
		s7.setForeground(new Color(0, 51, 102));
		s7.setBackground(new Color(0, 51, 102));
		s7.setBounds(466, 250, 310, 5);
		registerPanel.add(s7);

		JSeparator s6 = new JSeparator();
		s6.setForeground(new Color(0, 51, 102));
		s6.setBackground(new Color(0, 51, 102));
		s6.setBounds(45, 250, 310, 5);
		registerPanel.add(s6);

		emailID = new JTextField();
		emailID.setToolTipText("");
		emailID.setOpaque(false);
		emailID.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		emailID.setColumns(10);
		emailID.setCaretColor(Color.BLACK);
		emailID.setBorder(null);
		emailID.setBounds(45, 215, 310, 34);
		registerPanel.add(emailID);

		JSeparator s1 = new JSeparator();
		s1.setForeground(new Color(0, 51, 102));
		s1.setBackground(new Color(0, 51, 102));
		s1.setBounds(45, 95, 310, 5);
		registerPanel.add(s1);

		JLabel fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setForeground(new Color(0, 0, 0));
		fullNameLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		fullNameLabel.setBounds(45, 35, 105, 29);
		registerPanel.add(fullNameLabel);

		fullName = new JTextField();
		fullName.setToolTipText("");
		fullName.setOpaque(false);
		fullName.setCaretColor(new Color(0, 0, 0));
		fullName.setBorder(null);
		fullName.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		fullName.setBounds(45, 62, 310, 34);
		registerPanel.add(fullName);
		fullName.setColumns(10);

		JLabel mobileLabel = new JLabel("Mobile No.");
		mobileLabel.setForeground(new Color(0, 0, 0));
		mobileLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		mobileLabel.setBounds(45, 110, 105, 29);
		registerPanel.add(mobileLabel);

		JLabel emailLabel = new JLabel("Email-ID (optional)");
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		emailLabel.setBounds(45, 188, 164, 29);
		registerPanel.add(emailLabel);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setForeground(new Color(0, 0, 0));
		genderLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		genderLabel.setBounds(45, 361, 105, 29);
		registerPanel.add(genderLabel);

		JRadioButton MaleRB = new JRadioButton("Male");
		MaleRB.setOpaque(false);
		MaleRB.setBackground(Color.WHITE);
		MaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		MaleRB.setBounds(45, 396, 66, 23);
		registerPanel.add(MaleRB);

		JRadioButton FemaleRB = new JRadioButton("Female");
		FemaleRB.setOpaque(false);
		FemaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		FemaleRB.setBackground(Color.WHITE);
		FemaleRB.setBounds(139, 396, 115, 23);
		registerPanel.add(FemaleRB);

		ButtonGroup group = new ButtonGroup();
		group.add(MaleRB);
		group.add(FemaleRB);

		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setForeground(new Color(0, 0, 0));
		dobLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		dobLabel.setBounds(45, 264, 115, 29);
		registerPanel.add(dobLabel);

		JLabel mobileNoError = new JLabel("* Incorrect Number");
		mobileNoError.setVisible(false);
		mobileNoError.setForeground(new Color(255, 0, 0));
		mobileNoError.setHorizontalTextPosition(SwingConstants.RIGHT);
		mobileNoError.setHorizontalAlignment(SwingConstants.RIGHT);
		mobileNoError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		mobileNoError.setBounds(175, 113, 180, 27);
		registerPanel.add(mobileNoError);

		JLabel emailError = new JLabel("* Incorrect Email-ID");
		emailError.setVisible(false);
		emailError.setHorizontalTextPosition(SwingConstants.RIGHT);
		emailError.setHorizontalAlignment(SwingConstants.RIGHT);
		emailError.setForeground(Color.RED);
		emailError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		emailError.setBounds(218, 192, 137, 25);
		registerPanel.add(emailError);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setForeground(new Color(0, 0, 0));
		addressLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		addressLabel.setBounds(466, 35, 132, 29);
		registerPanel.add(addressLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(0, 0, 0));
		passwordLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		passwordLabel.setBounds(466, 188, 105, 29);
		registerPanel.add(passwordLabel);

		JLabel confirmPassLabel = new JLabel("Confirm Password");
		confirmPassLabel.setForeground(new Color(0, 0, 0));
		confirmPassLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		confirmPassLabel.setBounds(466, 264, 201, 29);
		registerPanel.add(confirmPassLabel);

		JTextArea address = new JTextArea();
		address.setOpaque(false);
		address.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		address.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		address.setBounds(466, 67, 310, 110);
		registerPanel.add(address);

		JSeparator s2 = new JSeparator();
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(45, 175, 310, 5);
		registerPanel.add(s2);

		mobileNo = new JTextField();
		mobileNo.setToolTipText("");
		mobileNo.setOpaque(false);
		mobileNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		mobileNo.setColumns(10);
		mobileNo.setCaretColor(Color.BLACK);
		mobileNo.setBorder(null);
		mobileNo.setBounds(45, 137, 310, 34);
		registerPanel.add(mobileNo);

		JSeparator s3 = new JSeparator();
		s3.setPreferredSize(new Dimension(0, 3));
		s3.setForeground(new Color(0, 51, 102));
		s3.setBackground(new Color(0, 51, 102));
		s3.setBounds(45, 328, 50, 10);
		registerPanel.add(s3);

		JSeparator s4 = new JSeparator();
		s4.setSize(new Dimension(0, 2));
		s4.setForeground(new Color(0, 51, 102));
		s4.setBackground(new Color(0, 51, 102));
		s4.setBounds(139, 328, 50, 10);
		registerPanel.add(s4);

		JSeparator s5 = new JSeparator();
		s5.setForeground(new Color(0, 51, 102));
		s5.setBackground(new Color(0, 51, 102));
		s5.setBounds(232, 328, 50, 10);
		registerPanel.add(s5);

		JYearChooser year = new JYearChooser();
		year.setStartYear(0);
		year.setYear(0);
		year.setValue(0);
		year.setMaximum(2022);
		year.setMinimum(1900);
		year.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.getSpinner().setBounds(0, 0, 66, 30);
		year.setBounds(232, 301, 66, 30);
		registerPanel.add(year);
		year.setLayout(null);

		JYearChooser month = new JYearChooser();
		month.setYear(0);
		month.setStartYear(0);
		month.getSpinner().setBounds(0, 0, 66, 30);
		month.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setMaximum(12);
		month.setValue(0);
		month.setBounds(139, 301, 66, 30);
		registerPanel.add(month);
		month.setLayout(null);

		JYearChooser day = new JYearChooser();
		day.setValue(0);
		day.setStartYear(0);
		day.setYear(0);
		day.setOpaque(false);
		day.getSpinner().setForeground(new Color(0, 0, 0));
		day.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		day.setMaximum(31);
		day.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setBounds(0, 0, 66, 30);
		day.setBounds(45, 301, 66, 30);
		registerPanel.add(day);
		day.setLayout(null);

		confirmPassword = new JPasswordField();
		confirmPassword.setOpaque(false);
		confirmPassword.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		confirmPassword.setBorder(null);
		confirmPassword.setBounds(466, 291, 310, 34);
		registerPanel.add(confirmPassword);

		JSeparator s8 = new JSeparator();
		s8.setForeground(new Color(0, 51, 102));
		s8.setBackground(new Color(0, 51, 102));
		s8.setBounds(466, 326, 310, 5);
		registerPanel.add(s8);

		JSeparator middleSep = new JSeparator();
		middleSep.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		middleSep.setForeground(new Color(0, 51, 102));
		middleSep.setBackground(new Color(0, 51, 102));
		middleSep.setOrientation(SwingConstants.VERTICAL);
		middleSep.setBounds(410, 35, 3, 384);
		registerPanel.add(middleSep);

		JLabel req1 = new JLabel("* Required");
		req1.setVisible(false);
		req1.setHorizontalTextPosition(SwingConstants.RIGHT);
		req1.setHorizontalAlignment(SwingConstants.RIGHT);
		req1.setForeground(Color.RED);
		req1.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req1.setBounds(250, 35, 105, 29);
		registerPanel.add(req1);

		JLabel req3 = new JLabel("* Required");
		req3.setVisible(false);
		req3.setHorizontalTextPosition(SwingConstants.RIGHT);
		req3.setHorizontalAlignment(SwingConstants.RIGHT);
		req3.setForeground(Color.RED);
		req3.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req3.setBounds(671, 35, 105, 29);
		registerPanel.add(req3);

		JLabel req4 = new JLabel("* Required");
		req4.setVisible(false);
		req4.setHorizontalTextPosition(SwingConstants.RIGHT);
		req4.setHorizontalAlignment(SwingConstants.RIGHT);
		req4.setForeground(Color.RED);
		req4.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req4.setBounds(671, 188, 105, 29);
		registerPanel.add(req4);

		JLabel req5 = new JLabel("* Required");
		req5.setVisible(false);
		req5.setHorizontalTextPosition(SwingConstants.RIGHT);
		req5.setHorizontalAlignment(SwingConstants.RIGHT);
		req5.setForeground(Color.RED);
		req5.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req5.setBounds(671, 264, 105, 29);
		registerPanel.add(req5);

		JLabel req2 = new JLabel("* Required");
		req2.setVisible(false);
		req2.setHorizontalTextPosition(SwingConstants.RIGHT);
		req2.setHorizontalAlignment(SwingConstants.RIGHT);
		req2.setForeground(Color.RED);
		req2.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req2.setBounds(250, 361, 105, 29);
		registerPanel.add(req2);

		JLabel req6 = new JLabel("* Required");
		req6.setVisible(false);
		req6.setHorizontalTextPosition(SwingConstants.RIGHT);
		req6.setHorizontalAlignment(SwingConstants.RIGHT);
		req6.setForeground(Color.RED);
		req6.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req6.setBounds(240, 265, 115, 29);
		registerPanel.add(req6);

		JLabel dayMonthYear = new JLabel("Day                 Month            Year");
		dayMonthYear.setHorizontalTextPosition(SwingConstants.RIGHT);
		dayMonthYear.setHorizontalAlignment(SwingConstants.LEFT);
		dayMonthYear.setForeground(new Color(0, 51, 102));
		dayMonthYear.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		dayMonthYear.setBounds(45, 328, 253, 29);
		registerPanel.add(dayMonthYear);

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valName, valMobileNo, valEmail, valDob, valGender, valAddress, valPass, valConfPass;
				Pattern ptr;
				Matcher match;

				valName = fullName.getText().equals("");
				if (valName) {
					req1.setVisible(true);
				} else {
					req1.setVisible(false);
				}

				valGender = group.isSelected(null);
				if (valGender) {
					req2.setVisible(true);
				} else {
					req2.setVisible(false);
				}

				valAddress = address.getText().equals("");
				if (valAddress) {
					req3.setVisible(true);
				} else {
					req3.setVisible(false);
				}

				valPass = String.valueOf(password.getPassword()).equals("");
				if (valPass) {
					req4.setVisible(true);
				} else {
					req4.setVisible(false);
				}

				valConfPass = String.valueOf(confirmPassword.getPassword()).equals("");
				if (valConfPass) {
					req5.setVisible(true);
				} else {
					req5.setVisible(false);
				}

				valDob = (day.getValue() == 0) || (month.getValue() == 0) || (year.getValue() == 0);
				if (valDob) {
					req6.setVisible(true);
				} else {
					req6.setVisible(false);
				}

				valMobileNo = mobileNo.getText().equals("");
				if (valMobileNo) {
					mobileNoError.setText("* Required");
					mobileNoError.setVisible(true);
				} else {
					ptr = Pattern.compile("(0/+91)?[6-9][0-9]{9}");
					match = ptr.matcher(mobileNo.getText());
					valMobileNo = !(match.find() && match.group().equals(mobileNo.getText()));
					if (valMobileNo) {
						mobileNoError.setText("* Incorrect Mobile Number");
						mobileNoError.setVisible(true);
					} else {
						mobileNoError.setVisible(false);
					}
				}

				valEmail = emailID.getText().equals("");
				if (valEmail) {
					valEmail = false;
				} else {
					ptr = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)");
					match = ptr.matcher(emailID.getText());
					valEmail = !(match.find() && match.group().equals(emailID.getText()));
					if (valEmail) {
						emailError.setVisible(true);
					} else {
						emailError.setVisible(false);
					}
				}

				if (!(valName || valMobileNo || valEmail || valDob || valGender || valAddress || valPass
						|| valConfPass)) {
					if (String.valueOf(password.getPassword()).equals(String.valueOf(confirmPassword.getPassword()))) {
						LoginPage lp = new LoginPage();
						lp.setLocationRelativeTo(null);
						lp.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(0, 128, 0));
		submit.setBorderPainted(false);
		submit.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		submit.setBounds(466, 377, 115, 42);
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
		reset.setBounds(661, 377, 115, 42);
		registerPanel.add(reset);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setAutoscrolls(true);
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		backgroundImg.setIcon(new ImageIcon(image));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
