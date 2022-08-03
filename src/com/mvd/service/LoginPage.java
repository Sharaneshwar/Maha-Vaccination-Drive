package com.mvd.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setLocationRelativeTo(null);		// To set the frame at the center of screen
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		Image image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		LoginLabel.setIcon(new ImageIcon(image));
		LoginLabel.setBounds(542, 185, 122, 35);
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
		image = new ImageIcon(this.getClass().getResource("/exitButton.png")).getImage();
		closeLabel.setIcon(new ImageIcon(image));
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
		image = new ImageIcon(this.getClass().getResource("/homelogo.png")).getImage();
		homeLabel.setIcon(new ImageIcon(image));
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to cancel the registration?");
				if (choice == JOptionPane.YES_OPTION) {
					HomePage hPage = new HomePage();
					hPage.setLocationRelativeTo(null);
					hPage.setVisible(true);
					setVisible(false);
				}
			}
		});
		homeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setBounds(3, 3, 25, 25);
		headerPanel.add(homeLabel);
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		
		JLabel leftHeading = new JLabel("<HTML>\r\nMINISTRY OF <BR>\r\n<b>HEALTH </b> AND <BR>\r\n<b>FAMILY WELFARE</b><br>\r\nGOVERNMENT OF INDIA\r\n</HTML>");
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
		
		JLabel rightHeading = new JLabel("<HTML><p style=\"text-align:right\">\r\nJOIN <b>INDIA'S<BR>\r\nGLORIOUS </b>JOURNEY<BR>\r\nOF <b>200 CRORE</b><br>\r\nVACCINATIONS\r\n</p></HTML>");
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
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new LineBorder(new Color(0, 51, 102), 3, true));
		registerPanel.setOpaque(false);
		registerPanel.setBounds(112, 202, 675, 366);
		contentPane.add(registerPanel);
		registerPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		registerPanel.setBackground(new Color(135, 206, 235));
		registerPanel.setLayout(null);
		
		JLabel loginImg = new JLabel("");
		image = new ImageIcon(this.getClass().getResource("/loginImg.png")).getImage();
		loginImg.setIcon(new ImageIcon(image));
		loginImg.setBounds(3, 3, 300, 360);
		registerPanel.add(loginImg);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblUsername.setBounds(366, 62, 105, 29);
		registerPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblPassword.setBounds(366, 138, 105, 29);
		registerPanel.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(434, 240, 115, 42);
		registerPanel.add(btnLogin);
		
		JSeparator middleSep = new JSeparator();
		middleSep.setOrientation(SwingConstants.VERTICAL);
		middleSep.setForeground(new Color(0, 51, 102));
		middleSep.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		middleSep.setBackground(new Color(0, 51, 102));
		middleSep.setBounds(303, 0, 2, 384);
		registerPanel.add(middleSep);
		
		JSeparator s1 = new JSeparator();
		s1.setForeground(new Color(0, 51, 102));
		s1.setBackground(new Color(0, 51, 102));
		s1.setBounds(366, 121, 250, 5);
		registerPanel.add(s1);
		
		username = new JTextField();
		username.setToolTipText("");
		username.setOpaque(false);
		username.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		username.setColumns(10);
		username.setCaretColor(Color.BLACK);
		username.setBorder(null);
		username.setBounds(366, 88, 250, 34);
		registerPanel.add(username);
		
		JSeparator s2 = new JSeparator();
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(366, 196, 250, 5);
		registerPanel.add(s2);
		
		password = new JPasswordField();
		password.setOpaque(false);
		password.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		password.setBorder(null);
		password.setBounds(366, 160, 250, 34);
		registerPanel.add(password);
		
		JLabel loginError = new JLabel("<html><center>\r\n* Incorrect Username or Password *<br>\r\nPlease try again!\r\n</center></html>");
		loginError.setVisible(false);
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		loginError.setHorizontalTextPosition(SwingConstants.CENTER);
		loginError.setHorizontalAlignment(SwingConstants.CENTER);
		loginError.setBounds(366, 299, 250, 42);
		registerPanel.add(loginError);
		
		JLabel backgroundImg = new JLabel("");
		image = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		backgroundImg.setIcon(new ImageIcon(image));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
