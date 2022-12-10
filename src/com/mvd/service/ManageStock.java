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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.mvd.dao.SelectOperations;
import com.mvd.dao.UpdateOperations;

public class ManageStock extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField covaxin;
	private JTextField covishield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ManageStock frame = new ManageStock();
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
	public ManageStock() {
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
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(238, 232, 170));
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		headerPanel.setBounds(0, 0, 900, 118);
		contentPane.add(headerPanel);

		JLabel closeLabel = new JLabel();
		closeLabel.setIcon(new ImageIcon(ManageAppointments.class.getResource("/resources/exitButton.png")));
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
		headerImg.setBounds(0, 0, 900, 118);
		headerImg.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/header.jpg")));
		headerPanel.add(headerImg);

		JPanel hamburger_panel = new JPanel();
		hamburger_panel.setLayout(null);
		hamburger_panel.setOpaque(false);
		hamburger_panel.setBorder(null);
		hamburger_panel.setBackground(new Color(0, 51, 102));
		hamburger_panel.setBounds(0, 117, 196, 533);
		contentPane.add(hamburger_panel);

		JPanel vaccineStatsPanel = new JPanel();
		vaccineStatsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vaccineStatsPanel.setOpaque(true);
				AdminDashboard ad = new AdminDashboard();
				ad.setLocationRelativeTo(null);
				ad.setVisible(true);
				dispose();
			}
		});
		vaccineStatsPanel.setOpaque(false);
		vaccineStatsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaccineStatsPanel.setLayout(null);
		vaccineStatsPanel.setBackground(new Color(0, 51, 102, 30));
		vaccineStatsPanel.setBounds(0, 0, 196, 60);
		hamburger_panel.add(vaccineStatsPanel);

		JLabel label1 = new JLabel("Vaccine Stats");
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label1.setBounds(67, 0, 197, 60);
		vaccineStatsPanel.add(label1);

		JLabel logo1 = new JLabel("");
		logo1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/stats_ico.png")));
		logo1.setBounds(21, 0, 46, 60);
		vaccineStatsPanel.add(logo1);

		JSeparator s1 = new JSeparator();
		s1.setOrientation(SwingConstants.VERTICAL);
		s1.setForeground(new Color(0, 51, 102));
		s1.setBackground(new Color(0, 51, 102));
		s1.setBounds(20, 15, 3, 30);
		vaccineStatsPanel.add(s1);

		JPanel manageAppPanel = new JPanel();
		manageAppPanel.setOpaque(false);
		manageAppPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageAppPanel.setOpaque(true);
				ManageAppointments ma = new ManageAppointments();
				ma.setLocationRelativeTo(null);
				ma.setVisible(true);
				dispose();
			}
		});
		manageAppPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageAppPanel.setLayout(null);
		manageAppPanel.setBackground(new Color(0, 51, 102, 30));
		manageAppPanel.setBounds(0, 60, 196, 85);
		hamburger_panel.add(manageAppPanel);

		JSeparator hs1 = new JSeparator();
		hs1.setForeground(new Color(0, 51, 102));
		hs1.setBackground(new Color(0, 51, 102));
		hs1.setBounds(0, 0, 264, 12);
		manageAppPanel.add(hs1);

		JLabel label2 = new JLabel("<html>\r\nManage\r\n<br>Appointments\r\n</html>");
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label2.setBounds(67, 0, 197, 85);
		manageAppPanel.add(label2);

		JLabel logo2 = new JLabel("");
		logo2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/manage_1.png")));
		logo2.setBounds(22, 0, 46, 85);
		manageAppPanel.add(logo2);

		JSeparator s2 = new JSeparator();
		s2.setOrientation(SwingConstants.VERTICAL);
		s2.setForeground(new Color(0, 51, 102));
		s2.setBackground(new Color(0, 51, 102));
		s2.setBounds(20, 27, 3, 30);
		manageAppPanel.add(s2);

		JPanel manageStockPanel = new JPanel();
		manageStockPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageStockPanel.setLayout(null);
		manageStockPanel.setBackground(new Color(0, 51, 102, 30));
		manageStockPanel.setBounds(0, 142, 196, 60);
		hamburger_panel.add(manageStockPanel);

		JSeparator hs2 = new JSeparator();
		hs2.setForeground(new Color(0, 51, 102));
		hs2.setBackground(new Color(0, 51, 102));
		hs2.setBounds(0, 0, 264, 12);
		manageStockPanel.add(hs2);

		JLabel label3 = new JLabel("Manage Stock");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label3.setBounds(67, 0, 197, 60);
		manageStockPanel.add(label3);

		JLabel logo3 = new JLabel("");
		logo3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/manage2.png")));
		logo3.setBounds(22, 0, 46, 60);
		manageStockPanel.add(logo3);

		JSeparator s3 = new JSeparator();
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setForeground(new Color(0, 51, 102));
		s3.setBackground(new Color(0, 51, 102));
		s3.setBounds(20, 15, 3, 30);
		manageStockPanel.add(s3);

		JSeparator hs3 = new JSeparator();
		hs3.setForeground(new Color(0, 51, 102));
		hs3.setBackground(new Color(0, 51, 102));
		hs3.setBounds(0, 58, 264, 12);
		manageStockPanel.add(hs3);

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
		logoutPanel.setLayout(null);
		logoutPanel.setOpaque(false);
		logoutPanel.setBackground(new Color(0, 51, 102, 30));
		logoutPanel.setBounds(0, 473, 196, 60);
		hamburger_panel.add(logoutPanel);

		JSeparator hs4 = new JSeparator();
		hs4.setForeground(new Color(0, 51, 102));
		hs4.setBackground(new Color(0, 51, 102));
		hs4.setBounds(0, 0, 264, 12);
		logoutPanel.add(hs4);

		JLabel label4 = new JLabel("Logout");
		label4.setForeground(Color.BLACK);
		label4.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label4.setBounds(67, 0, 197, 60);
		logoutPanel.add(label4);

		JLabel logo4 = new JLabel("");
		logo4.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/log_out_ico.png")));
		logo4.setBounds(24, 0, 46, 60);
		logoutPanel.add(logo4);

		JSeparator s4 = new JSeparator();
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setForeground(new Color(0, 51, 102));
		s4.setBackground(new Color(0, 51, 102));
		s4.setBounds(20, 15, 3, 30);
		logoutPanel.add(s4);

		JLabel covaxinLabel = new JLabel("COVAXIN");
		covaxinLabel.setForeground(new Color(0, 51, 102));
		covaxinLabel.setOpaque(true);
		covaxinLabel.setIcon(new ImageIcon(ManageStock.class.getResource("/resources/bg.png")));
		covaxinLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		covaxinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		covaxinLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 24));
		covaxinLabel.setBounds(359, 192, 127, 36);
		contentPane.add(covaxinLabel);

		JPanel covaxinPanel = new JPanel();
		covaxinPanel.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		covaxinPanel.setOpaque(false);
		covaxinPanel.setBounds(324, 209, 196, 165);
		contentPane.add(covaxinPanel);
		covaxinPanel.setLayout(null);

		covaxin = new JTextField();
		covaxin.setForeground(Color.BLACK);
		covaxin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				covaxin.setEditable(true);
			}
		});
		covaxin.setText("0");
		covaxin.setBorder(null);
		covaxin.setOpaque(false);
		covaxin.setHorizontalAlignment(SwingConstants.CENTER);
		covaxin.setFont(new Font("Euclid Circular A", Font.PLAIN, 38));
		covaxin.setBounds(23, 40, 149, 84);
		covaxin.setEditable(false);
		covaxin.setColumns(10);
		covaxinPanel.add(covaxin);

		JLabel covishieldLabel = new JLabel("COVISHIELD");
		covishieldLabel.setIcon(new ImageIcon(ManageStock.class.getResource("/resources/bg.png")));
		covishieldLabel.setOpaque(true);
		covishieldLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		covishieldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		covishieldLabel.setForeground(new Color(0, 51, 102));
		covishieldLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 24));
		covishieldLabel.setBounds(592, 192, 159, 36);
		contentPane.add(covishieldLabel);

		JPanel covishieldPanel = new JPanel();
		covishieldPanel.setLayout(null);
		covishieldPanel.setOpaque(false);
		covishieldPanel.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		covishieldPanel.setBounds(573, 209, 196, 165);
		contentPane.add(covishieldPanel);

		covishield = new JTextField();
		covishield.setForeground(Color.BLACK);
		covishield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				covishield.setEditable(true);
			}
		});
		covishield.setText("0");
		covishield.setOpaque(false);
		covishield.setHorizontalAlignment(SwingConstants.CENTER);
		covishield.setFont(new Font("Euclid Circular A", Font.PLAIN, 38));
		covishield.setColumns(10);
		covishield.setBorder(null);
		covishield.setBounds(23, 40, 149, 84);
		covishield.setEditable(false);
		covishieldPanel.add(covishield);

		JLabel error = new JLabel(
				"<html><center>\r\n* Invalid Stock Input *<br>\r\nEnter only positive values\r\n</center></html>");
		error.setVisible(false);
		error.setForeground(Color.RED);
		error.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		error.setHorizontalTextPosition(SwingConstants.CENTER);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(420, 475, 250, 42);
		contentPane.add(error);

		SelectOperations so = new SelectOperations();
		covaxin.setText(String.valueOf(so.select_vaccine_stock(covaxinLabel.getText())));
		covishield.setText(String.valueOf(so.select_vaccine_stock(covishieldLabel.getText())));

		JButton btnUpdateStock = new JButton("UPDATE STOCK");
		btnUpdateStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(covaxin.getText()) < 0 || Integer.parseInt(covishield.getText()) < 0) {
					error.setVisible(true);
				} else {
					error.setVisible(false);
					UpdateOperations uo = new UpdateOperations();
					int rows = uo.update_vaccine_stock(covaxin.getText(), covishield.getText());
					if (rows == 0) {
						JOptionPane.showMessageDialog(null, "Updation Failed! Try Again", "Failed",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Stock Updated Successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnUpdateStock.setForeground(Color.WHITE);
		btnUpdateStock.setFont(new Font("Euclid Circular A", Font.BOLD, 20));
		btnUpdateStock.setBorderPainted(false);
		btnUpdateStock.setBackground(new Color(0, 128, 0));
		btnUpdateStock.setBounds(447, 422, 196, 42);
		contentPane.add(btnUpdateStock);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setIcon(new ImageIcon(ManageAppointments.class.getResource("/resources/bg.png")));
		backgroundImg.setBorder(null);
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
