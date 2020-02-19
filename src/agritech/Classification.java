package agritech;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Classification extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classification frame = new Classification();
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
	public Classification() {
		setMinimumSize(new Dimension(720, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Seasonal");
		btnNewButton.setForeground(new Color(245, 245, 220));
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Seasons sns=new Seasons();
				Seasons.main(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(258, 121, 161, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Non-Seasonal");
		btnNewButton_1.setForeground(new Color(245, 245, 220));
		btnNewButton_1.setBackground(new Color(0, 0, 205));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				NonSeasonal nsn=new NonSeasonal();
				NonSeasonal.main(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(258, 193, 161, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblChooseFromThe = new JLabel("Choose From The Options");
		lblChooseFromThe.setForeground(new Color(0, 100, 0));
		lblChooseFromThe.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblChooseFromThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseFromThe.setBounds(10, 32, 684, 29);
		contentPane.add(lblChooseFromThe);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIconTextGap(8);
		btnHome.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\69524.png"));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setHorizontalTextPosition(SwingConstants.LEFT);
		btnHome.setForeground(new Color(245, 245, 220));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBackground(new Color(34, 139, 34));
		btnHome.setFocusable(false);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				MainPage mp= new MainPage();
				MainPage.main(null);
				setVisible(false);
			}
			
		});
		btnHome.setBounds(272, 262, 134, 42);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 704, 461);
		contentPane.add(lblNewLabel);
	}
}
