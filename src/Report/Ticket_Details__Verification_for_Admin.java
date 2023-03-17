package Report;

//USE TICKET DETAILS DATABASE

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Ticket_Details__Verification_for_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtFlightNumber;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable tbflights;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Details__Verification_for_Admin frame = new Ticket_Details__Verification_for_Admin();
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
	public Ticket_Details__Verification_for_Admin() {
		setTitle("Ticket Verification For Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ViewPassengerDetails");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    
	                 //Class.forName("com.mysql.jdbc.Driver");
	                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
	                 Statement stmt=con.createStatement();
	                 DefaultTableModel model=(DefaultTableModel) tbflights.getModel();
	                 ResultSet rs=stmt.executeQuery("Select * from Passenger where Flight_num= '"+txtFlightNumber.getText()+"'");
	                 int n=0;
	                 while(rs.next())
	                 {
	                     String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
	                     model.addRow(s);
	                     n++;
	                     
	                 }
	                 if(n==0)
	                	 //JOptionPane.showMessageDialog(null,"Enter valid Flight Number");
	                	 JOptionPane.showMessageDialog(null, "Enter Valid Flight Number", "Error", JOptionPane.ERROR_MESSAGE);
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
		                {"Name","Gender","Source", "Destination","Adreess","Mobile", "DOJ", "flightNumber", "TicketNumber"},
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
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(511, 167, 147, 23);
		contentPane.add(btnCancel);
	}
}
