package agritech;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ManipulationPage extends JFrame {

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
					ManipulationPage frame = new ManipulationPage();
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
	public ManipulationPage() {
		setMinimumSize(new Dimension(720, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setMinimumSize(new Dimension(720, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin!");
		lblNewLabel.setBackground(new Color(255, 228, 181));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(0, 0, 704, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\images (1).jpg"));
		btnAddNew.setForeground(new Color(51, 0, 153));
		btnAddNew.setBackground(new Color(0, 255, 102));
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNew.setFocusable(false);
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				AddNew an=new AddNew();
				AddNew.main(null);
				setVisible(false);
			}
		});
		btnAddNew.setBounds(267, 150, 199, 41);
		contentPane.add(btnAddNew);
		
		JButton btnDeleteUpdate = new JButton("Delete & Update");
		btnDeleteUpdate.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\edit.png"));
		btnDeleteUpdate.setForeground(new Color(220, 220, 220));
		btnDeleteUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Update up=new Update();
				Update.main(null);
				setVisible(false);
			}
		});
		btnDeleteUpdate.setBackground(Color.RED);
		btnDeleteUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteUpdate.setFocusable(false);
		btnDeleteUpdate.setBounds(267, 253, 199, 41);
		contentPane.add(btnDeleteUpdate);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				MainPage mp=new MainPage();
				MainPage.main(null);
				dispose();
			}
		});
		btnHome.setIconTextGap(8);
		btnHome.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\69524.png"));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setHorizontalTextPosition(SwingConstants.LEFT);
		btnHome.setForeground(new Color(245, 245, 220));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBackground(new Color(0, 0, 205));
		btnHome.setFocusable(false);
		btnHome.setBounds(291, 338, 145, 41);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\happy-cartoon-field-3d-model-low-poly-max-obj (1).jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 720, 459);
		contentPane.add(label);
	}
}
