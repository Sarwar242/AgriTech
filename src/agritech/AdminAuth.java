package agritech;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class AdminAuth extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernm;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	//Connection--------//
		public Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/AgricultureDB?autoReconnect=true&useSSL=false",
									"root",
									"sarwar");
				return con;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAuth frame = new AdminAuth();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminAuth() {
		setMinimumSize(new Dimension(800, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAdminAthorization = new JLabel("Admin Authorization");
		lblAdminAthorization.setOpaque(true);
		lblAdminAthorization.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAdminAthorization.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminAthorization.setBounds(262, 80, 329, 42);
		contentPane.add(lblAdminAthorization);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBackground(new Color(72, 209, 204));
		lblUsername.setOpaque(true);
		lblUsername.setBounds(186, 200, 112, 34);
		contentPane.add(lblUsername);
		
		usernm = new JTextField();
		usernm.setName("username");
		usernm.setBounds(351, 200, 268, 34);
		contentPane.add(usernm);
		usernm.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setOpaque(true);
		lblPassword.setBackground(new Color(64, 224, 208));
		lblPassword.setBounds(186, 287, 112, 34);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setForeground(new Color(238, 232, 170));
		btnLogin.setIconTextGap(12);
		btnLogin.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLogin.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\access-512.png"));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=usernm.getText();
				String pass=String.valueOf(password.getPassword());
				Connection  connection=getConnection();
				String query="select * from admins where name='"+user+"' and password='"+pass+"'";
				Statement st;
				ResultSet rs = null;
				
					try {
						st=connection.createStatement();
						rs=st.executeQuery(query);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "You have logged in Successfully");
							ManipulationPage mp=new ManipulationPage();
							ManipulationPage.main(null);
							dispose();
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally {
						try {
							connection.close();
							rs.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
							
			}	
		});
		btnLogin.setBounds(357, 397, 126, 34);
		contentPane.add(btnLogin);
		
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
			public void actionPerformed(ActionEvent e) {
				MainPage mp=new MainPage();
				MainPage.main(null);
				dispose();
			}
		});
		btnBack.setBounds(493, 396, 126, 34);
		contentPane.add(btnBack);
		
		password = new JPasswordField();
		password.setBounds(351, 287, 268, 34);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\happy-cartoon-field-3d-model-low-poly-max-obj.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 800, 540);
		contentPane.add(lblNewLabel);
	}
}
