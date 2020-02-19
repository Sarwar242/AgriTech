package agritech;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class IndexPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexPage frame = new IndexPage();
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
	public IndexPage() {
		setMinimumSize(new Dimension(800, 580));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,900, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setMinimumSize(new Dimension(800, 540));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblWelcomeToAgritech = new JLabel("Welcome to AgriTech");
		lblWelcomeToAgritech.setBackground(new Color(0, 0, 255));
		lblWelcomeToAgritech.setForeground(Color.GREEN);
		lblWelcomeToAgritech.setOpaque(true);
		lblWelcomeToAgritech.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblWelcomeToAgritech.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAgritech.setBounds(0, 33, 884, 97);
		contentPane.add(lblWelcomeToAgritech);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setIconTextGap(16);
		btnEnter.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\enter_318-40164.jpg"));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp=new MainPage();
				MainPage.main(null);
				dispose();
			}
		});
		btnEnter.setFocusable(false);
		btnEnter.setBackground(new Color(128, 0, 128));
		btnEnter.setForeground(new Color(216, 191, 216));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnEnter.setBounds(315, 362, 260, 52);
		contentPane.add(btnEnter);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\farm.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 900, 540);
		contentPane.add(lblNewLabel);
	}
}
