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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.mvd.dao.CheckUsernamePassword;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	CheckUsernamePassword cup = new CheckUsernamePassword();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		cup.select_username_password();

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

		JLabel LoginLabel = new JLabel("LOGIN");
		LoginLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bg.png")));
		LoginLabel.setBounds(546, 167, 122, 35);
		contentPane.add(LoginLabel);
		LoginLabel.setForeground(new Color(0, 51, 102));
		LoginLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 30));
		LoginLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setBackground(new Color(238, 232, 170));

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		headerPanel.setBounds(0, 0, 900, 118);
		contentPane.add(headerPanel);

		JLabel closeLabel = new JLabel();
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
		closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(872, 3, 25, 25);
		headerPanel.add(closeLabel);

		JLabel homeLabel = new JLabel();
		homeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/homelogo.png")));
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to cancel the login?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					HomePage hPage = new HomePage();
					hPage.setLocationRelativeTo(null);
					hPage.setVisible(true);
					dispose();
				}
			}
		});
		homeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setBounds(3, 3, 25, 25);
		headerPanel.add(homeLabel);

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
		headerImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/header.jpg")));
		headerImg.setBounds(0, 0, 900, 118);
		headerPanel.add(headerImg);

		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new LineBorder(new Color(0, 51, 102), 3, true));
		registerPanel.setOpaque(false);
		registerPanel.setBounds(73, 182, 753, 400);
		contentPane.add(registerPanel);
		registerPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		registerPanel.setBackground(new Color(135, 206, 235));
		registerPanel.setLayout(null);

		JSeparator middleSep_1 = new JSeparator();
		middleSep_1.setOrientation(SwingConstants.VERTICAL);
		middleSep_1.setForeground(new Color(0, 51, 102));
		middleSep_1.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		middleSep_1.setBackground(new Color(0, 51, 102));
		middleSep_1.setBounds(0, 3, 2, 400);
		registerPanel.add(middleSep_1);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblUsername.setBounds(384, 69, 105, 29);
		registerPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblPassword.setBounds(384, 145, 105, 29);
		registerPanel.add(lblPassword);

		JSeparator middleSep = new JSeparator();
		middleSep.setOrientation(SwingConstants.VERTICAL);
		middleSep.setForeground(new Color(0, 51, 102));
		middleSep.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		middleSep.setBackground(new Color(0, 51, 102));
		middleSep.setBounds(326, 0, 2, 400);
		registerPanel.add(middleSep);

		JSeparator s1 = new JSeparator();
		s1.setForeground(new Color(0, 51, 102));
		s1.setBackground(new Color(0, 51, 102));
		s1.setBounds(384, 129, 300, 5);
		registerPanel.add(s1);

		username = new JTextField();
		username.setOpaque(false);
		username.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		username.setColumns(10);
		username.setCaretColor(Color.BLACK);
		username.setBorder(null);
		username.setBounds(384, 96, 300, 34);
		registerPanel.add(username);

		JSeparator s2 = new JSeparator();
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(384, 204, 300, 5);
		registerPanel.add(s2);

		password = new JPasswordField();
		password.setOpaque(false);
		password.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		password.setBorder(null);
		password.setBounds(384, 168, 300, 34);
		registerPanel.add(password);

		JLabel loginError = new JLabel(
				"<html><center>\r\n* Incorrect Username or Password *<br>\r\nPlease try again!\r\n</center></html>");
		loginError.setVisible(false);
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		loginError.setHorizontalTextPosition(SwingConstants.CENTER);
		loginError.setHorizontalAlignment(SwingConstants.CENTER);
		loginError.setBounds(415, 334, 250, 42);
		registerPanel.add(loginError);

		JLabel req1 = new JLabel("* Required");
		req1.setVisible(false);
		req1.setForeground(Color.RED);
		req1.setHorizontalTextPosition(SwingConstants.RIGHT);
		req1.setHorizontalAlignment(SwingConstants.RIGHT);
		req1.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req1.setBounds(560, 70, 124, 29);
		registerPanel.add(req1);

		JLabel req2 = new JLabel("* Required");
		req2.setVisible(false);
		req2.setHorizontalTextPosition(SwingConstants.RIGHT);
		req2.setHorizontalAlignment(SwingConstants.RIGHT);
		req2.setForeground(Color.RED);
		req2.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req2.setBounds(560, 146, 123, 29);
		registerPanel.add(req2);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean valUsername, valPassword;
				valUsername = username.getText().equals("");
				if (valUsername) {
					req1.setVisible(true);
				} else {
					req1.setVisible(false);
				}

				valPassword = String.valueOf(password.getPassword()).equals("");
				if (valPassword) {
					req2.setVisible(true);
				} else {
					req2.setVisible(false);
				}

				if (!(valUsername || valPassword)) {
					if (username.getText().equals("admin")
							&& String.valueOf(password.getPassword()).equals("12345678")) {
						JOptionPane.showMessageDialog(null, "Login Successfull !", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						AdminDashboard adboard = new AdminDashboard();
						adboard.setLocationRelativeTo(null);
						adboard.setVisible(true);
						dispose();
					} else {
						if (cup.check_username_password(username.getText(), String.valueOf(password.getPassword()))) {
							loginError.setVisible(false);
							JOptionPane.showMessageDialog(null, "Login Successfull !", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							Dashboard dboard = new Dashboard(username.getText());
							dboard.setLocationRelativeTo(null);
							dboard.setVisible(true);
							dispose();
						} else {
							loginError.setVisible(true);
						}
					}
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(483, 234, 115, 42);
		registerPanel.add(btnLogin);

		JLabel lblUseYourMobile = new JLabel("* Use registered email-ID as username *");
		lblUseYourMobile.setForeground(Color.BLACK);
		lblUseYourMobile.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUseYourMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseYourMobile.setFont(new Font("Euclid Circular A", Font.ITALIC, 14));
		lblUseYourMobile.setBounds(384, 29, 300, 29);
		registerPanel.add(lblUseYourMobile);

		JLabel register = new JLabel(
				"<html>\r\nDon't have an account?  <u style=\"color: blue\"> Register</u>\r\n</html>");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationPage rp = new RegistrationPage();
				rp.setLocationRelativeTo(null);
				rp.setVisible(true);
				dispose();
			}
		});
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setHorizontalTextPosition(SwingConstants.CENTER);
		register.setHorizontalAlignment(SwingConstants.CENTER);
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Euclid Circular A", Font.BOLD, 16));
		register.setBounds(390, 294, 300, 29);
		registerPanel.add(register);

		JLabel loginImg = new JLabel("");
		loginImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/Login_Image.png")));
		loginImg.setBounds(-25, 3, 350, 394);
		registerPanel.add(loginImg);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bg.png")));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
