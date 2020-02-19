package agritech;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Summer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField title;
	private JTextField season;
	private JTextArea details;
	private JLabel pic;
	private ArrayList<Items> list;

	private ImageIcon format;

	private JLabel lblNonseasonalCrops;

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/AgricultureDB?autoReconnect=true&useSSL=false",
												"root", "sarwar");
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
		String query="SELECT * FROM info_agri where season='Summer'";
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
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				
				},
				new String[] {
					" Sl NO.", " Title"
				}
			));
		list= getItemList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[2];
		for(int i=0;i<list.size();i++) {
			row[0]=i+1;
			row[1]=list.get(i).getTitle();
			
			
			model.addRow(row);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summer frame = new Summer();
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
	public Summer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\Agritech\\src\\img\\2-pic-sunflower-field.jpg"));
		setBackground(new Color(240, 240, 240));
		setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		pic = new JLabel("Image");
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		pic.setOpaque(true);
		pic.setBounds(786, 39, 388, 268);
		contentPane.add(pic);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setForeground(new Color(255, 165, 0));
		scrollPane.setBackground(new Color(107, 142, 35));
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setBounds(28, 51, 307, 543);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(new Color(34, 139, 34));
		table.setForeground(new Color(255, 255, 153));
		table.setGridColor(new Color(220, 20, 60));
	
		table.setSelectionBackground(new Color(255, 255, 0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				title.setText(model.getValueAt(i,1).toString());
				season.setText(list.get(i).getSeason().toString());
				details.setText(list.get(i).getDetails().toString());
				
				 if(list.get(i).getImg() != null)
			        {
					 format = new ImageIcon(new ImageIcon(list.get(i).getImg()).getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH));
			     
			        pic.setIcon(format);
			        }
			       else{
			            pic.setText("No Image");
			        }
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				" Sl NO.", " Title"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(237);
		table.getColumnModel().getColumn(1).setMinWidth(136);
		show_database();
		title = new JTextField();
		title.setForeground(new Color(255, 0, 0));
		title.setBorder(null);
		title.setBackground(new Color(240, 248, 255));
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setEditable(false);
		title.setBounds(383, 144, 393, 33);
		contentPane.add(title);
		title.setColumns(10);
		
		season = new JTextField();
		season.setForeground(new Color(139, 0, 0));
		season.setBorder(null);
		season.setBackground(new Color(240, 248, 255));
		season.setEditable(false);
		season.setHorizontalAlignment(SwingConstants.LEFT);
		season.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		season.setBounds(383, 212, 138, 27);
		contentPane.add(season);
		season.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 319, 810, 336);
		contentPane.add(scrollPane_1);
		
		details = new JTextArea();
		details.setForeground(new Color(51, 0, 0));
		details.setBackground(new Color(189, 183, 107));
		details.setLineWrap(true);
		details.setBorder(new EmptyBorder(9, 9, 6, 6));
		details.setFont(new Font("Monospaced", Font.PLAIN, 15));
		details.setEditable(false);
		scrollPane_1.setViewportView(details);
		
		lblNonseasonalCrops = new JLabel("Summer Season Crops :");
		lblNonseasonalCrops.setForeground(new Color(255, 255, 255));
		lblNonseasonalCrops.setOpaque(true);
		lblNonseasonalCrops.setBackground(new Color(102, 0, 0));
		lblNonseasonalCrops.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonseasonalCrops.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNonseasonalCrops.setBounds(0, 0, 1184, 40);
		contentPane.add(lblNonseasonalCrops);
		
		JButton btnBack = new JButton("Back");
		btnBack.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\i24_nav_back-512.png"));
		btnBack.setForeground(new Color(255, 245, 238));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(204, 0, 0));
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Seasons cf=new Seasons();
				Seasons.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(28, 621, 115, 34);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
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
		btnHome.setBounds(177, 621, 127, 34);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setFocusable(false);
		label.setIgnoreRepaint(true);
		label.setOpaque(true);
		label.setIcon(new ImageIcon("D:\\java\\Agritech\\src\\img\\open_fields_headvisual-graded.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 1200, 700);
		contentPane.add(label);
	}
}
