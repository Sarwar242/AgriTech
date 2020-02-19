package agritech;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class AboutPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutPage frame = new AboutPage();
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
	public AboutPage() {
		setMinimumSize(new Dimension(1240, 680));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 411);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1240, 680));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(529, 421, 206, 55);
		btnHome.setIconTextGap(8);
		btnHome.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\69524.png"));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setHorizontalTextPosition(SwingConstants.LEFT);
		btnHome.setForeground(new Color(245, 245, 220));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBackground(new Color(0, 0, 205));
		btnHome.setFocusable(false);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				MainPage mp=new MainPage();
				MainPage.main(null);
				dispose();
			}
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnHome);
	}

}
