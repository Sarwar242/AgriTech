package agritech;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class Update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int id;
	private byte[] imagedata;
	private ImageIcon format;
	private JTextField idf;

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
	public ArrayList<Items>getItemList(){
		ArrayList<Items>itemList=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM info_agri";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("id"),rs.getString("title"),rs.getString("season"),rs.getString("details"),rs.getBytes("image"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	public void show_database() {
		String[] columnName = {"ID", "Title","Season", "Details", "Image"};
		
		ArrayList<Items> list= getItemList();
		
		Object[][] row= new Object[list.size()][5];
		for(int i=0;i<list.size();i++) {
			row[i][0]=list.get(i).getId();
			row[i][1]=list.get(i).getTitle();
			row[i][2]=list.get(i).getSeason();
			row[i][3]=list.get(i).getDetails();
			  if(list.get(i).getImg() != null){
	                
		             format = new ImageIcon(new ImageIcon(list.get(i).getImg()).getImage().getScaledInstance(130, 60,3));   
		                
		            row[i][4] = format;
		            }
		            else{
		                row[i][4] = null;
		            }

		}
		TheModel model = new TheModel(row, columnName);
		  table.setModel(model);
		  table.setRowHeight(120);
		  table.getColumnModel().getColumn(0).setPreferredWidth(20);
		  table.getColumnModel().getColumn(4).setPreferredWidth(150);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setMinimumSize(new Dimension(1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBounds(932, 48, 242, 168);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 885, 650);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(255, 204, 255));
		
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null}
	            },
	            new String [] {
	                "Id", "Title","Season", "Details", "Picture"
	            }
	        ));
		table.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				idf.setText(model.getValueAt(i,0).toString());
				id=(int) model.getValueAt(i,0);
				 if(table.getValueAt(i, 4) != null)
			        {
			        ImageIcon image1 = (ImageIcon)table.getValueAt(i, 4);
			        Image image2 = image1.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			        ImageIcon image3 = new ImageIcon(image2);
			        label.setIcon(image3);
			        }
			        else{
			            System.out.println("No Image");
			        }
			}
		});
		/* int x = 2; */
		JButton btnEdit = new JButton("Edit");
		btnEdit.setIconTextGap(16);
		btnEdit.setHorizontalTextPosition(SwingConstants.LEFT);
		btnEdit.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\edit.png"));
		btnEdit.setBackground(new Color(0, 0, 0));
		btnEdit.setForeground(new Color(255, 255, 0));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddNew(id).setVisible(true);
				dispose();
			}
		});
		btnEdit.setBounds(995, 375, 136, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIconTextGap(8);
		btnDelete.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\63402720-trash-sign-illustration-white-icon-on-red-circle-.jpg"));
		btnDelete.setBackground(new Color(47, 79, 79));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure? You want to delete this?","WARNING",JOptionPane.YES_NO_OPTION);

				if(dialogButton == JOptionPane.YES_OPTION) {
					String query="DELETE FROM `info_agri` WHERE id='"+id+"'";
					Connection con= getConnection();
					Statement st;
					try {
						st=con.createStatement();
						if(st.executeUpdate(query)==1) {
							TheModel model=(TheModel) table.getModel();
							model.setRowCount(0);
							show_database();
						}else {
							JOptionPane.showMessageDialog(null, "Unexpected Error!");
							show_database();
						}
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					}
				else {
					show_database();
					}
			}
		});
		btnDelete.setBounds(995, 450, 136, 37);
		contentPane.add(btnDelete);
		
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
				ManipulationPage off=new ManipulationPage();
				ManipulationPage.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(1009, 581, 122, 37);
		contentPane.add(btnBack);
		
		idf = new JTextField();
		idf.setEditable(false);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		idf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idf.setBounds(984, 276, 64, 23);
		contentPane.add(idf);
		idf.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(932, 280, 46, 19);
		contentPane.add(lblId);
		
		JLabel lblIsSelected = new JLabel("  is Selected.");
		lblIsSelected.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsSelected.setBounds(1058, 282, 89, 17);
		contentPane.add(lblIsSelected);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\Farm-fields-road-clouds_1920x1200.jpg"));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(0,0,1200, 700);
		contentPane.add(lblNewLabel);
		
		/*
		 * JLabel lblNewLabel = new
		 * JLabel("           ID                     Title                      Details                   Image"
		 * ); lblNewLabel.setForeground(new Color(0, 0, 205));
		 * lblNewLabel.setBackground(new Color(210, 180, 140)); lblNewLabel.setFont(new
		 * Font("Tahoma", Font.BOLD, 16)); lblNewLabel.setOpaque(true);
		 * lblNewLabel.setBounds(10, 11, 695, 31); contentPane.add(lblNewLabel);
		 */

		show_database();
	}
}
