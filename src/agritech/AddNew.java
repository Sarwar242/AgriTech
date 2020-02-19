package agritech;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class AddNew extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2682987783119261082L;
	private JPanel contentPane;
	private JTextField title;
	private String filename;
	private String sn="nothing";
	private byte[] imagedata=new byte[] { 1 };;

	private ImageIcon format;
	private JComboBox comboBox;
	private JTextArea details;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/AgricultureDB?autoReconnect=true&useSSL=false", "root", "sarwar");
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
					AddNew frame = new AddNew();
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
	public AddNew() {
		setMinimumSize(new Dimension(720, 550));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblImage_1 = new JLabel("image");
		lblImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage_1.setBounds(461, 359, 189, 133);
		contentPane.add(lblImage_1);
		JLabel lblSeason = new JLabel("Season : ");
		lblSeason.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeason.setBounds(32, 133, 79, 31);
		contentPane.add(lblSeason);
		//combobox
		String[] catagory={"Select a Season","Non-Seasonal","Summer","Winter"};
		comboBox = new JComboBox(catagory);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Non-Seasonal")) {
					sn="Non-Seasonal";
				}else if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Summer")){
					sn="Summer";
				}
				else if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Winter")) {
					sn="Winter";
				}
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		comboBox.setBounds(152, 135, 265, 31);
		contentPane.add(comboBox);
		
		
		JLabel lblAddNewInformation = new JLabel("Add New Information");
		lblAddNewInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewInformation.setBounds(203, 11, 281, 38);
		contentPane.add(lblAddNewInformation);
		
		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(32, 78, 67, 31);
		contentPane.add(lblTitle);
		
		JLabel lblDetails = new JLabel("Details : ");
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setBounds(32, 214, 89, 31);
		contentPane.add(lblDetails);
		
		title = new JTextField();
		title.setBounds(147, 78, 547, 27);
		contentPane.add(title);
		title.setColumns(10);
		
		details = new JTextArea();
		details.setBorder(new EmptyBorder(8, 8, 5, 5));
		details.setWrapStyleWord(true);
		details.setLineWrap(true);
		details.setBounds(147, 197, 547, 151);
		contentPane.add(details);
		
		JButton chooseimage = new JButton("Choose Image");
		chooseimage.setBackground(new Color(153, 0, 102));
		chooseimage.setForeground(new Color(255, 255, 204));
		chooseimage.setHorizontalTextPosition(SwingConstants.LEFT);
		chooseimage.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\img_234957.png"));
		chooseimage.setFont(new Font("Tahoma", Font.BOLD, 15));
		chooseimage.setFocusable(false);
		chooseimage.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				//file chooser
				JFileChooser chooser= new JFileChooser();
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("jpg", "jpeg", "png", "gif"));
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				if(f!=null) {	
				filename=f.getAbsolutePath();
				ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage_1.getWidth(),lblImage_1.getHeight(),3));
				lblImage_1.setIcon(imageIcon);
				try {
					File image= new File(filename);
					
					FileInputStream fis=new FileInputStream(image);
					
					ByteArrayOutputStream bos= new ByteArrayOutputStream();
					byte[] buf= new byte[3040];
					for(int readnum;(readnum=fis.read(buf))!=-1;) {
						bos.write(buf,0,readnum);
					}
					imagedata = bos.toByteArray();
					fis.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				}
			}
		
		});
		chooseimage.setBounds(226, 359, 206, 40);
		contentPane.add(chooseimage);
		
		JButton submit = new JButton("Submit");
		submit.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\images (1).jpg"));
		submit.setForeground(new Color(51, 102, 51));
		submit.setBackground(new Color(204, 204, 153));
		submit.setFocusable(false);
		submit.setFont(new Font("Tahoma", Font.BOLD, 16));
		submit.addActionListener(new ActionListener() {
			private PreparedStatement pst;
			
			public void actionPerformed(ActionEvent arg0) {
				String query="INSERT INTO `info_agri` (`id`, `title`,season, `details`,image) VALUES (NULL, ?, ?, ?, ?);";
				Connection con= getConnection();
			
				pst = null;
				try {
					if(sn.equals("nothing")) {
						JOptionPane.showMessageDialog(null, "Please select a valid Option First!");
					}else {
					pst=con.prepareStatement(query);
					pst.setString(1,title.getText() );
					pst.setString(2,sn);
					pst.setString(3, details.getText());
					pst.setBytes(4,imagedata);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
					@SuppressWarnings("unused")
					ManipulationPage mp=new ManipulationPage();
					ManipulationPage.main(null);
					dispose();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					title.setText("");
					details.setText("");
					lblImage_1.setIcon(null);
				}
			}
		});
		submit.setBounds(252, 441, 156, 40);
		contentPane.add(submit);
		
		JButton btnBack = new JButton("Back");
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
				ManipulationPage mp=new ManipulationPage();
				ManipulationPage.main(null);
				dispose();
			}
			
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(32, 443, 110, 37);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\rural_land.jpg"));
		label.setBounds(0, 0, 720, 550);
		contentPane.add(label);
		
		
	}
	public AddNew(int x) {
		setMinimumSize(new Dimension(720, 550));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAddNewInformation = new JLabel("Update Information");
		lblAddNewInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewInformation.setBounds(203, 11, 281, 38);
		contentPane.add(lblAddNewInformation);
		
		//combobox
				String[] catagory={"Non-Seasonal","Summer","Winter"};
				comboBox = new JComboBox(catagory);
				comboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
				comboBox.setBounds(152, 135, 265, 31);
				contentPane.add(comboBox);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Non-Seasonal")) {
							sn="Non-Seasonal";
						}else if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Summer")){
							sn="Summer";
						}
						else if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Winter")) {
							sn="Winter";
						}
					}
				});
				
		lblImage = new JLabel("image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(465, 359, 172, 121);
		contentPane.add(lblImage);
		
		JLabel lblSeason = new JLabel("Season : ");
		lblSeason.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeason.setBounds(32, 133, 79, 31);
		contentPane.add(lblSeason);
		
		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(32, 78, 67, 31);
		contentPane.add(lblTitle);
		
		JLabel lblDetails = new JLabel("Details : ");
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setBounds(32, 214, 89, 31);
		contentPane.add(lblDetails);
		
		title = new JTextField();
		title.setBounds(147, 78, 547, 27);
		contentPane.add(title);
		title.setColumns(10);
		
		details = new JTextArea();
		details.setBorder(new EmptyBorder(8, 8, 5, 5));
		details.setWrapStyleWord(true);
		details.setLineWrap(true);
		details.setBounds(147, 197, 547, 151);
		contentPane.add(details);
		updateData(x);
		JButton chooseimage = new JButton("Choose Image");
		chooseimage.setBackground(new Color(153, 0, 102));
		chooseimage.setForeground(new Color(255, 255, 204));
		chooseimage.setHorizontalTextPosition(SwingConstants.LEFT);
		chooseimage.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\img_234957.png"));
		chooseimage.setFont(new Font("Tahoma", Font.BOLD, 15));
		chooseimage.setFocusable(false);
		chooseimage.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				//file chooser
				JFileChooser chooser= new JFileChooser();
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("jpg", "jpeg", "png", "gif"));
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				if(f!=null) {	
				filename=f.getAbsolutePath();
				ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),3));
				lblImage.setIcon(imageIcon);
				try {
					File image= new File(filename);
					
					FileInputStream fis=new FileInputStream(image);
					
					ByteArrayOutputStream bos= new ByteArrayOutputStream();
					byte[] buf= new byte[3040];
					for(int readnum;(readnum=fis.read(buf))!=-1;) {
						bos.write(buf,0,readnum);
					}
					imagedata = bos.toByteArray();
					fis.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				}
			}
		
		});
		chooseimage.setBounds(226, 359, 206, 40);
		contentPane.add(chooseimage);
		
		JButton submit = new JButton("Update");
		submit.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\edit.png"));
		submit.setForeground(new Color(51, 102, 51));
		submit.setBackground(new Color(204, 204, 153));
		submit.setFocusable(false);
		submit.setFont(new Font("Tahoma", Font.BOLD, 16));
		submit.addActionListener(new ActionListener() {
			private PreparedStatement pst;
			
			public void actionPerformed(ActionEvent arg0) {
				String query="update `info_agri` set `title`=?, season=?, `details`=?, image=? where id='"+x+"';";
				Connection con= getConnection();
			
				pst = null;
				try {
					pst=con.prepareStatement(query);
					pst.setString(1,title.getText() );
					pst.setString(2, sn);
					pst.setString(3, details.getText());
					pst.setBytes(4,imagedata);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					@SuppressWarnings("unused")
					Update mp=new Update();
					Update.main(null);
					dispose();
					
					} catch (Exception ex) {
					ex.printStackTrace();
					title.setText("");
					details.setText("");
					lblImage.setIcon(null);
				}
			}
		});
		submit.setBounds(252, 441, 156, 40);
		contentPane.add(submit);
		
		JButton btnBack = new JButton("Back");
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
				Update mp=new Update();
				Update.main(null);
				dispose();
			}
			
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(32, 443, 110, 37);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\rural_land.jpg"));
		label.setBounds(0, 0, 720, 550);
		contentPane.add(label);
		
		
	}
	private void updateData(int a2) {
		Connection  connection=getConnection();
		//System.out.println(a2);
		String query="SELECT * FROM info_agri where id='"+a2+"'";
		Statement st=null;
		String s=null;
		ResultSet rs = null;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				title.setText(rs.getString("title"));
				details.setText(rs.getString("details"));
				imagedata=rs.getBytes("image");
				format = new ImageIcon(new ImageIcon(imagedata).getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),3));
				lblImage.setIcon(format);
				s=rs.getString("season").toString();
				if(s.equals("Non-Seasonal")) {
					comboBox.setSelectedIndex(0);
				}else if(s.equals("Summer")) {
					comboBox.setSelectedIndex(1);
				}
				else if(s.equals("Winter")) {
					comboBox.setSelectedIndex(2);
				}
				
			}
			
	}catch (Exception e) 
			{
				e.printStackTrace();
			}
			
	}
}
