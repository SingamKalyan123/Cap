package flightApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import own.Dashboardforadmin;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class ViewDetails extends JFrame {

	private JPanel contentPane;
	private JTable tbflights;
	private JTextField txtFlightNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetails frame = new ViewDetails();
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
	public ViewDetails() {
		setTitle("VIEW FLIGHTS");
		setBounds(100, 100, 915, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ViewFlightDetails");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    
	                 //Class.forName("com.mysql.jdbc.Driver");
	                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
	                 Statement stmt=con.createStatement();
	                 DefaultTableModel model=(DefaultTableModel) tbflights.getModel();
	                 ResultSet rs=stmt.executeQuery("Select * from kalyanflight where FlightNumber= '"+txtFlightNumber.getText()+"'");
	                 int n=0;
	                 while(rs.next())
	                 {
	                     String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
	                     model.addRow(s);
	                     n++;
	                     
	                 }
	                 if(n==0)
	                	 JOptionPane.showMessageDialog(null,"Enter valid Flight Number","Error",JOptionPane.ERROR_MESSAGE);
	                }
	                catch(Exception ae)
	            
	                {
	                    System.out.println(ae);
	                }
				
			}
		});
		btnNewButton.setBounds(524, 57, 289, 49);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 531, 821, -441);
		contentPane.add(scrollPane);
		
		tbflights = new JTable();
		 tbflights.setModel(new DefaultTableModel(
		            new Object[][] {
		                {"FlightName","FlightNumber","Source", "Destination","ArrivalTime","DepartureTime", "DOJ", "Seats", "Price"},
		            },
		            new String[] {
		                "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column",
		            }
		        ));
		tbflights.setBounds(48, 132, 821, 302);
		contentPane.add(tbflights);
		
		JLabel lblNewLabel = new JLabel("Enter FlightNumber");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 67, 170, 32);
		contentPane.add(lblNewLabel);
		
		txtFlightNumber = new JTextField();
		txtFlightNumber.setBounds(296, 68, 170, 35);
		contentPane.add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UpdateFlightDetails");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyFlights mf=new ModifyFlights();
				mf.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(411, 459, 418, 61);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("  ViewFlightDetails");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(200, 11, 337, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboardforadmin da=new Dashboardforadmin();
				da.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setBounds(76, 468, 144, 43);
		contentPane.add(btnNewButton_2);
	}
}
