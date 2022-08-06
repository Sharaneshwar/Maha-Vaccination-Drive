package com.mvd.service;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class VaccineAppointment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VaccineAppointment frame = new VaccineAppointment();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
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
	public VaccineAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, SystemColor.activeCaption, SystemColor.inactiveCaption));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 255), null));
		headerPanel.setBounds(3, 3, 900, 118);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		
		JLabel closeLabel = new JLabel();
		Image image = new ImageIcon(this.getClass().getResource("/exitButton.png")).getImage();
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
		h1.setFont(new Font("Dialog", Font.BOLD, 22));
		h1.setAlignmentY(0.0f);
		h1.setBounds(262, 11, 376, 55);
		headerPanel.add(h1);
		
		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
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
		headerImg.setIcon(new ImageIcon(VaccineAppointment.class.getResource("/images/header.jpg")));
		headerImg.setBounds(0, 0, 900, 118);
		headerPanel.add(headerImg);
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(headerPanel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(3, 123, 188, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-12, 0, 77, 54);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\susmi\\Downloads\\user__1_-removebg-preview (1).png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Susmit Borala");
		lblNewLabel_1.setBounds(56, 12, 140, 42);
		lblNewLabel_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_1.setFont(new Font("Euclid Circular A Medium", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				LoginPage lp = new LoginPage();
				lp.setVisible(true);
			}
		});
		lblNewLabel_2.setBounds(24, 452, 20, 28);
		lblNewLabel_2.setIcon(new ImageIcon(VaccineAppointment.class.getResource("/images/favpng_login-icon-logout-icon 2.png")));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sign out");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				LoginPage lp = new LoginPage();
				lp.setVisible(true);
			}
		});
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Euclid Circular A SemiBold", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(56, 452, 65, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\susmi\\Downloads\\s (1).png"));
		lblNewLabel_4.setBounds(-1, 76, 45, 54);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 168, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("Schedule Vaccine");
		lblNewLabel_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_5.setFont(new Font("Euclid Circular A Medium", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(46, 100, 132, 22);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\susmi\\Downloads\\3273685695 (1).png"));
		lblNewLabel_6.setBounds(6, 140, 30, 42);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("View Appointment");
		lblNewLabel_5_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_5_1.setFont(new Font("Euclid Circular A Medium", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(46, 155, 130, 22);
		panel.add(lblNewLabel_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(191, 123, 735, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(0, 34, 147, 100);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\susmi\\Downloads\\user__2_-removebg-preview.png"));
		panel_1.add(lblNewLabel_7);
		
		JLabel lblSusmitBorala = new JLabel("Susmit Borala");
		lblSusmitBorala.setBounds(158, 53, 210, 50);
		lblSusmitBorala.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSusmitBorala.setHorizontalAlignment(SwingConstants.CENTER);
		lblSusmitBorala.setForeground(Color.BLACK);
		lblSusmitBorala.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSusmitBorala.setAlignmentY(0.0f);
		panel_1.add(lblSusmitBorala);
		
		JLabel lblNewLabel_8 = new JLabel("ID :");
		lblNewLabel_8.setBounds(180, 100, 29, 19);
		lblNewLabel_8.setForeground(Color.GRAY);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("183298");
		lblNewLabel_9.setBounds(200, 100, 77, 19);
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Addhar Card No. :");
		lblNewLabel_9_1.setBounds(58, 161, 135, 27);
		lblNewLabel_9_1.setForeground(Color.GRAY);
		lblNewLabel_9_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("698498547363");
		lblNewLabel_9_1_1.setBounds(195, 161, 135, 27);
		lblNewLabel_9_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_2 = new JLabel("Date Of Birth       :");
		lblNewLabel_9_1_2.setBounds(58, 210, 135, 27);
		lblNewLabel_9_1_2.setForeground(Color.GRAY);
		lblNewLabel_9_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblNewLabel_9_1_2);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("02-04-2005");
		lblNewLabel_9_1_1_1.setBounds(195, 210, 135, 27);
		lblNewLabel_9_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_2_1 = new JLabel("Mobile Number   :");
		lblNewLabel_9_1_2_1.setBounds(58, 258, 135, 27);
		lblNewLabel_9_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_9_1_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblNewLabel_9_1_2_1);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("9284669149");
		lblNewLabel_9_1_1_2.setBounds(195, 258, 135, 27);
		lblNewLabel_9_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_9_1_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(42, 338, 294, 125);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		
		JLabel lblNewLabel_9_1_2_1_1 = new JLabel("Successfully Taken");
		lblNewLabel_9_1_2_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_9_1_2_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_9_1_2_1_1.setBounds(80, 62, 117, 50);
		panel_2.add(lblNewLabel_9_1_2_1_1);
		
		JLabel lblNewLabel_9_1_2_1_2_1 = new JLabel("Dose 1");
		lblNewLabel_9_1_2_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_9_1_2_1_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_9_1_2_1_2_1.setBounds(128, 13, 56, 27);
		panel_2.add(lblNewLabel_9_1_2_1_2_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(VaccineAppointment.class.getResource("/images/dose1 (1).png")));
		lblNewLabel_11.setBounds(95, 9, 32, 37);
		panel_2.add(lblNewLabel_11);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(366, 338, 294, 125);
		panel_2_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setOpaque(false);
		
		JLabel lblNewLabel_9_1_2_1_1_1 = new JLabel("Yet not taken");
		lblNewLabel_9_1_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_9_1_2_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_9_1_2_1_1_1.setBounds(80, 62, 117, 50);
		panel_2_1.add(lblNewLabel_9_1_2_1_1_1);
		
		JLabel lblNewLabel_9_1_2_1_2_1_1 = new JLabel("Dose 2");
		lblNewLabel_9_1_2_1_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_9_1_2_1_2_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_9_1_2_1_2_1_1.setBounds(122, 13, 56, 27);
		panel_2_1.add(lblNewLabel_9_1_2_1_2_1_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("");
		lblNewLabel_11_1.setIcon(new ImageIcon(VaccineAppointment.class.getResource("/images/dose2 (1).png")));
		lblNewLabel_11_1.setBounds(88, 13, 28, 33);
		panel_2_1.add(lblNewLabel_11_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 144, 618, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_9_1_2_1_2 = new JLabel("Vacination Status");
		lblNewLabel_9_1_2_1_2.setBounds(287, 308, 135, 27);
		lblNewLabel_9_1_2_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_9_1_2_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblNewLabel_9_1_2_1_2);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(VaccineAppointment.class.getResource("/images/bg.png")));
		lblNewLabel_10.setBounds(0, 0, 712, 490);
		panel_1.add(lblNewLabel_10);
		
		
		
		
	}
}
