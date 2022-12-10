package com.mvd.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.ui.RectangleInsets;

import com.mvd.dao.SelectOperations;

public class AdminDashboard extends JFrame {

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
			@Override
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
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
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setBounds(872, 3, 25, 25);
		closeLabel.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/exitButton.png")));
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
		manageAppPanel.setOpaque(false);
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
		manageStockPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageStockPanel.setOpaque(true);
				ManageStock ms = new ManageStock();
				ms.setLocationRelativeTo(null);
				ms.setVisible(true);
				dispose();
			}
		});
		manageStockPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageStockPanel.setLayout(null);
		manageStockPanel.setOpaque(false);
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

		SelectOperations so = new SelectOperations();
		JFreeChart chart = ChartFactory.createPieChart("", so.select_pie_dataset(), true, false, false);
		chart.setBackgroundImageAlpha(0.0f);
		chart.setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF, 0));
		chart.getLegend().setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF, 0));
		chart.getLegend().setBorder(0, 0, 0, 0);
		chart.getLegend().setItemFont(new Font("Euclid Circular A", Font.PLAIN, 17));
		chart.getLegend().setItemLabelPadding(new RectangleInsets(2, 2, 20, 20));
		chart.getLegend().setLegendItemGraphicPadding(new RectangleInsets(0, 0, 18, 5));

		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF, 0));
		piePlot.setLabelGenerator(null);
		piePlot.setOutlinePaint(null);

		JLabel chartTitle = new JLabel("VACCINATION STATISTICS");
		chartTitle.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/bg.png")));
		chartTitle.setForeground(new Color(0, 51, 102));
		chartTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		chartTitle.setHorizontalAlignment(SwingConstants.CENTER);
		chartTitle.setFont(new Font("Euclid Circular A", Font.BOLD, 26));
		chartTitle.setBounds(360, 156, 369, 44);
		contentPane.add(chartTitle);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(null);
		chartPanel.setOpaque(false);

		JPanel cPanel = new JPanel();
		cPanel.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		cPanel.setOpaque(false);
		cPanel.setBounds(256, 178, 577, 416);
		contentPane.add(cPanel);
		cPanel.setLayout(new BorderLayout(0, 0));
		cPanel.add(chartPanel, BorderLayout.CENTER);
		cPanel.validate();

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setIcon(new ImageIcon(AdminDashboard.class.getResource("/resources/bg.png")));
		backgroundImg.setBorder(null);
		backgroundImg.setAlignmentY(0.0f);
		backgroundImg.setBounds(0, 0, 900, 650);
		contentPane.add(backgroundImg);
	}
}
