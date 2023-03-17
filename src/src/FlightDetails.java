package src;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FlightDetails extends JFrame {

	private JPanel contentPane;
	private JTable tbflights;
	

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightDetails frame = new FlightDetails();
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
	public FlightDetails() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                    FLIGHT DETAILS");
	
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(316, 11, 488, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Source");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(192, 124, 104, 19);
		contentPane.add(lblNewLabel_1);
		String s[]= {"Hyderabad","Delhi","Vizag","Pune","Tirupati","Kadapa","Banglore","USA","Canada","Paris","Dubai"};
		
		JComboBox comboBox = new JComboBox(s);
		comboBox.setToolTipText("");
		comboBox.setBounds(340, 126, 193, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Destination");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(586, 121, 155, 25);
		contentPane.add(lblNewLabel_2);
		String s1[]= {"Hyderabad","Delhi","Vizag","Pune","Tirupati","Kadapa","Banglore","USA","Canada","Paris","Dubai"};
		
		JComboBox comboBox_1 = new JComboBox(s1);
		comboBox_1.setBounds(751, 126, 193, 22);
		contentPane.add(comboBox_1);
		
		
		//String Select=comboBox.getSelectedItem().toString();
		//String Select1=comboBox_1.getSelectedItem().toString();
		 //System.out.println(Select);
		 
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String Select=comboBox.getSelectedItem().toString();
					String Select1=comboBox_1.getSelectedItem().toString();
				// Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
                 Statement stmt=con.createStatement();
                 
                 
                 DefaultTableModel model=(DefaultTableModel) tbflights.getModel();
                 ResultSet rs=stmt.executeQuery("Select * from kalyanflight where Source= '"+Select+"' and Destination = '"+Select1+"'");
                
                 while(rs.next())
                 {
                	 String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)};
                	 model.addRow(s);
                	
                	 
                 }
                 
                if(model.getRowCount()==0) {
                	JOptionPane.showMessageDialog(null,"Searched Flights not Available and Try Again After sometime");
                }
				}
				catch(Exception ae)
			
				{
					System.out.println(ae);
				}
					
				}
				
			}
		);
		
				
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(465, 212, 213, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(38, 274, 1055, 199);
		contentPane.add(scrollPane);
		
		tbflights = new JTable();
		scrollPane.setViewportView(tbflights);
		tbflights.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FlightName", "FlightNumber", "Source", "Destination", "ArrivalTime", "DestinationTime", "Date", "Seats","Price","Economic","Economic_Service","Business","Special_Business"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Book Tickets");
		btnNewButton_1.setBackground(new Color(128, 64, 64));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookTickets fd=new BookTickets();
				fd.NewScreen();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(481, 502, 213, 71);
		contentPane.add(btnNewButton_1);
		
		
	}
}
