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

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setMinimumSize(new Dimension(1000, 640));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setMinimumSize(new Dimension(1000, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblWelcomeToAgritech = new JLabel("AgriTech ");
		lblWelcomeToAgritech.setBackground(new Color(0, 0, 255));
		lblWelcomeToAgritech.setForeground(Color.GREEN);
		lblWelcomeToAgritech.setOpaque(true);
		lblWelcomeToAgritech.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 46));
		lblWelcomeToAgritech.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAgritech.setBounds(10, 30, 963, 76);
		contentPane.add(lblWelcomeToAgritech);
		
		JButton btnShow = new JButton("Show ");
		btnShow.setBackground(new Color(144, 238, 144));
		btnShow.setForeground(new Color(0, 0, 205));
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShow.setFocusable(false);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Classification cf=new Classification();
				Classification.main(null);
				setVisible(false);
			}
		});
		btnShow.setBounds(419, 208, 109, 44);
		contentPane.add(btnShow);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(new Color(143, 188, 143));
		btnAdmin.setForeground(new Color(0, 0, 205));
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAuth aa= new AdminAuth();
				AdminAuth.main(null);
				dispose();
			
			}
			
			
		});
		btnAdmin.setBounds(419, 292, 109, 44);
		contentPane.add(btnAdmin);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBackground(new Color(192, 192, 192));
		btnAbout.setForeground(new Color(0, 0, 205));
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAbout.setFocusable(false);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutPage ap=new AboutPage();
				AboutPage.main(null);
				dispose();
			}
		});
		btnAbout.setBounds(419, 376, 109, 44);
		contentPane.add(btnAbout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\spraying-soybean-field.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 1000, 600);
		contentPane.add(label);
	}

}
