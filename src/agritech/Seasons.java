package agritech;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Seasons extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seasons frame = new Seasons();
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
	public Seasons() {
		setMinimumSize(new Dimension(700, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblClickOnA = new JLabel("Click on a Season");
		lblClickOnA.setForeground(new Color(0, 100, 0));
		lblClickOnA.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickOnA.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClickOnA.setBounds(0, 35, 694, 41);
		contentPane.add(lblClickOnA);
		
		JButton btnSummer = new JButton("Summer");
		btnSummer.setForeground(new Color(255, 250, 250));
		btnSummer.setBackground(new Color(50, 205, 50));
		btnSummer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSummer.setFocusable(false);
		btnSummer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Summer smr=new Summer();
				Summer.main(null);
				setVisible(false);
			}
		});
		btnSummer.setBounds(258, 123, 161, 32);
		contentPane.add(btnSummer);
		
		JButton btnWinter = new JButton("Winter");
		btnWinter.setForeground(new Color(255, 250, 250));
		btnWinter.setBackground(new Color(50, 205, 50));
		btnWinter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnWinter.setFocusable(false);
		btnWinter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Winter wtn=new Winter();
				Winter.main(null);
				setVisible(false);
			}
		});
		btnWinter.setBounds(258, 182, 161, 32);
		contentPane.add(btnWinter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIconTextGap(8);
		btnBack.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\i24_nav_back-512.png"));
		btnBack.setForeground(new Color(255, 245, 238));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(204, 0, 0));
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Classification cf=new Classification();
				Classification.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(54, 372, 123, 32);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIconTextGap(10);
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
		btnHome.setBounds(515, 372, 131, 32);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\2-pic-sunflower-field.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 700, 362);
		contentPane.add(lblNewLabel);
	}
}
