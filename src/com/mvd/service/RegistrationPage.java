package com.mvd.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class RegistrationPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullName;
	private JTextField mobileNo;
	private JTextField emailID;
	private JTextField city;
	private JTextField state;

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
		setBounds(100, 100, 900, 600);
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
		registerPanel.setBounds(58, 156, 784, 433);
		contentPane.add(registerPanel);
		registerPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		registerPanel.setBackground(new Color(135, 206, 235));
		registerPanel.setLayout(null);

		JLabel fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		fullNameLabel.setBounds(47, 38, 105, 29);
		registerPanel.add(fullNameLabel);

		JLabel mobileLabel = new JLabel("Mobile No.");
		mobileLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		mobileLabel.setBounds(47, 114, 105, 29);
		registerPanel.add(mobileLabel);

		JLabel emailLabel = new JLabel("Email-ID (optional)");
		emailLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		emailLabel.setBounds(47, 188, 164, 29);
		registerPanel.add(emailLabel);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		genderLabel.setBounds(47, 262, 105, 29);
		registerPanel.add(genderLabel);

		JRadioButton MaleRB = new JRadioButton("Male");
		MaleRB.setOpaque(false);
		MaleRB.setBackground(Color.WHITE);
		MaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		MaleRB.setBounds(47, 292, 66, 23);
		registerPanel.add(MaleRB);

		JRadioButton FemaleRB = new JRadioButton("Female");
		FemaleRB.setOpaque(false);
		FemaleRB.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		FemaleRB.setBackground(Color.WHITE);
		FemaleRB.setBounds(141, 292, 115, 23);
		registerPanel.add(FemaleRB);

		fullName = new JTextField();
		fullName.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		fullName.setBounds(47, 69, 310, 34);
		registerPanel.add(fullName);
		fullName.setColumns(10);

		mobileNo = new JTextField();
		mobileNo.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		mobileNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		mobileNo.setColumns(10);
		mobileNo.setBounds(47, 143, 310, 34);
		registerPanel.add(mobileNo);

		emailID = new JTextField();
		emailID.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		emailID.setColumns(10);
		emailID.setBounds(47, 217, 310, 34);
		registerPanel.add(emailID);

		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		dobLabel.setBounds(405, 38, 115, 29);
		registerPanel.add(dobLabel);

		JLabel mobileNoError = new JLabel("* Incorrect Number");
		mobileNoError.setVisible(false);
		mobileNoError.setForeground(new Color(255, 0, 0));
		mobileNoError.setHorizontalTextPosition(SwingConstants.RIGHT);
		mobileNoError.setHorizontalAlignment(SwingConstants.RIGHT);
		mobileNoError.setFont(new Font("Euclid Circular A", Font.PLAIN, 12));
		mobileNoError.setBounds(242, 116, 115, 27);
		registerPanel.add(mobileNoError);

		JLabel emailError = new JLabel("* Incorrect Email-ID");
		emailError.setVisible(false);
		emailError.setHorizontalTextPosition(SwingConstants.RIGHT);
		emailError.setHorizontalAlignment(SwingConstants.RIGHT);
		emailError.setForeground(Color.RED);
		emailError.setFont(new Font("Euclid Circular A", Font.PLAIN, 12));
		emailError.setBounds(244, 192, 113, 25);
		registerPanel.add(emailError);

		JDateChooser dob = new JDateChooser();
		dob.setFont(new Font("Euclid Circular A", Font.PLAIN, 17));
		dob.setBounds(405, 69, 310, 35);
		registerPanel.add(dob);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		addressLabel.setBounds(405, 114, 132, 29);
		registerPanel.add(addressLabel);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblCity.setBounds(405, 252, 105, 29);
		registerPanel.add(lblCity);

		city = new JTextField();
		city.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		city.setColumns(10);
		city.setBounds(405, 281, 132, 34);
		registerPanel.add(city);

		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblState.setBounds(562, 252, 105, 29);
		registerPanel.add(lblState);

		state = new JTextField();
		state.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		state.setColumns(10);
		state.setBounds(562, 281, 153, 34);
		registerPanel.add(state);

		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		address.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		address.setBounds(405, 143, 310, 94);
		registerPanel.add(address);

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag1, flag2;
				Pattern ptr = Pattern.compile("(0/91)?[7-9][0-9]{9}");
				Matcher match = ptr.matcher(mobileNo.getText());
				if (!(match.find() && match.group().equals(mobileNo.getText()))) {
					mobileNoError.setVisible(true);
					flag1 = false;
				} else {
					mobileNoError.setVisible(false);
					flag1 = true;
				}
				ptr = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)");
				match = ptr.matcher(emailID.getText());
				if (!(match.find() && match.group().equals(emailID.getText()))) {
					emailError.setVisible(true);
					flag2 = false;
				} else {
					emailError.setVisible(false);
					flag2 = true;
				}
				if (flag1 && flag2) {
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
		submit.setBounds(242, 346, 115, 42);
		registerPanel.add(submit);

		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fullName.setText("");
				mobileNo.setText("");
				emailID.setText("");
				dob.setCalendar(null);
				address.setText("");
				state.setText("");
				city.setText("");
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
		reset.setBounds(405, 346, 115, 42);
		registerPanel.add(reset);

		JDateChooser date = new JDateChooser();
		date.setFont(new Font("Euclid Circular A", Font.PLAIN, 15));
		date.setDateFormatString("dd MMM, yy");
		date.setBounds(405, 69, 310, 34);
		registerPanel.add(date);

		JLabel backgroundImg = new JLabel("");
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		backgroundImg.setIcon(new ImageIcon(image));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundImg);
	}
}
