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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class HomePage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setLocationRelativeTo(null);		// To set the frame at the center of screen
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		setBackground(new Color(240, 230, 140));
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
		headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		headerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setBounds(0, 0, 900, 118);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);

		JLabel closeLabel = new JLabel();
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setIcon(new ImageIcon(HomePage.class.getResource("/resources/exitButton.png")));
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

		JLabel leftHeading = new JLabel("<HTML>\r\nMINISTRY OF <BR>\r\n<b>HEALTH </b> AND <BR>\r\n<b>FAMILY WELFARE</b><br>\r\nGOVERNMENT OF INDIA\r\n</HTML>");
		leftHeading.setAlignmentY(Component.TOP_ALIGNMENT);
		leftHeading.setForeground(Color.WHITE);
		leftHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		leftHeading.setHorizontalAlignment(SwingConstants.LEFT);
		leftHeading.setBounds(35, 11, 179, 96);
		leftHeading.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		headerPanel.add(leftHeading);

		JLabel h1 = new JLabel("कोरोना से लड़ना है तो वैक्सीन है जरुरी");
		h1.setAlignmentY(Component.TOP_ALIGNMENT);
		h1.setForeground(Color.WHITE);
		h1.setHorizontalTextPosition(SwingConstants.CENTER);
		h1.setHorizontalAlignment(SwingConstants.CENTER);
		h1.setFont(new Font("Poppins", Font.BOLD, 22));
		h1.setBounds(262, 11, 376, 55);
		headerPanel.add(h1);

		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setAlignmentY(Component.TOP_ALIGNMENT);
		h2.setForeground(Color.WHITE);
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setFont(new Font("Teko", Font.BOLD, 34));
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
		headerImg.setIcon(new ImageIcon(HomePage.class.getResource("/resources/header.jpg")));
		headerImg.setBounds(0, 0, 900, 118);
		headerPanel.add(headerImg);

		JButton login = new JButton("LOGIN");
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setFocusable(false);
		login.setAlignmentY(Component.TOP_ALIGNMENT);
		login.setHorizontalTextPosition(SwingConstants.CENTER);
		login.setForeground(new Color(255, 255, 255));
		login.setBorderPainted(false);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
				setVisible(false);
			}
		});
		login.setFont(new Font("Teko", Font.BOLD, 19));
		login.setBorder(null);
		login.setBackground(new Color(0, 51, 102));
		login.setBounds(531, 162, 113, 46);
		contentPane.add(login);

		JButton register = new JButton("REGISTER");
		register.setAlignmentY(Component.TOP_ALIGNMENT);
		register.setFocusable(false);
		register.setForeground(new Color(255, 255, 255));
		register.setBorder(null);
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setHorizontalTextPosition(SwingConstants.CENTER);
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrationPage rp = new RegistrationPage();
				rp.setLocationRelativeTo(null);
				rp.setVisible(true);
				setVisible(false);
			}
		});
		register.setFont(new Font("Teko", Font.BOLD, 19));
		register.setBorderPainted(false);
		register.setBackground(new Color(0, 51, 102));
		register.setBounds(654, 162, 113, 46);
		contentPane.add(register);

		JLabel indiaMap = new JLabel("");
		indiaMap.setIcon(new ImageIcon(HomePage.class.getResource("/resources/india_map.png")));
		indiaMap.setBounds(80, 162, 389, 445);
		getContentPane().add(indiaMap);

		JLabel quote = new JLabel("<html><center>\r\nIndia is set to defeat Covid-19.\r\n<br>\r\nEvery Indian is making it possible.\r\n<br>\r\n<strong>PM Narendra Modi<strong>\r\n</center></html>");
		quote.setAlignmentY(Component.TOP_ALIGNMENT);
		quote.setHorizontalTextPosition(SwingConstants.CENTER);
		quote.setHorizontalAlignment(SwingConstants.CENTER);
		quote.setVerticalAlignment(SwingConstants.TOP);
		quote.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		quote.setBounds(462, 507, 377, 100);
		contentPane.add(quote);

		JLabel vaccineSticker = new JLabel("");
		vaccineSticker.setIcon(new ImageIcon(HomePage.class.getResource("/resources/vaccine_sticker.png")));
		vaccineSticker.setBounds(531, 244, 236, 236);
		contentPane.add(vaccineSticker);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setIcon(new ImageIcon(HomePage.class.getResource("/resources/bg.png")));
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
