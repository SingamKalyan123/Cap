package keerthi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class CancellationForm {

	private JFrame frame;
	private JTextField txtTicketNumber;
	private JTextField txtFlightNumber;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancellationForm window = new CancellationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CancellationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Ticket Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(63, 140, 237, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTicketNumber = new JTextField();
		txtTicketNumber.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtTicketNumber.setBounds(401, 140, 155, 46);
		frame.getContentPane().add(txtTicketNumber);
		txtTicketNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Flight Number");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(63, 218, 237, 46);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtFlightNumber = new JTextField();
		txtFlightNumber.setBounds(401, 222, 155, 46);
		frame.getContentPane().add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String num=txtTicketNumber.getText();
					String mem=txtFlightNumber.getText();
					Connection Com=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					Statement stmt=Com.createStatement();
					System.out.println("inserting records");		
					DefaultTableModel model=(DefaultTableModel) table.getModel();
	                 ResultSet rs=stmt.executeQuery("Select Flight_num,Name, Source, Destination, Mobile,Class from Passenger Where TicketNumber='"+num+"' and Flight_num='"+mem+"'"); 
	                 while(rs.next())
	                 {
	                   String[]  s= {rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)};
	                     model.addRow(s);
	             
	                     
	                 }								
	                 if(model.getRowCount()==0) {
	                     JOptionPane.showMessageDialog(null,"Ticket not found");
	                 }
				}
				catch(Exception f) {
					System.out.println(f);
				}
			}
     	});		
		
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnNewButton_2.setBounds(621, 174, 160, 58);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 322, 665, 109);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Flight Number", "Name", "Source", "Destination", "Mobile","Class"
			}
		));
		
		JButton btnNewButton_3 = new JButton("Cancel Ticket");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 JOptionPane.showMessageDialog(null,"Are you Sure You want to cancel Ticket");
					String num=txtTicketNumber.getText();
					String mem=txtFlightNumber.getText();
					//Class.forName("Com.mysql.jdbc.Driver");
					Connection Com=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
				    Statement stmt=Com.createStatement();
					System.out.println("deleting records");
					//DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String s="select Class from Passenger where TicketNumber='"+num+"'";
					ResultSet rs1=stmt.executeQuery(s);
                    while(rs1.next()) {
                    	String Class=rs1.getString("Class");
                    
	                
	                    
	                    JOptionPane.showMessageDialog(null,"Ticket cancelled successfully");
	                    
	                
	                    System.out.println(Class);
	                    
	                    switch(Class)
	                    {
	                    case "Economic":String Query="update kalyanflight set Economic_Service =Economic_Service+1 where FlightNumber='"+mem+"'";
	   	                 stmt.executeUpdate(Query);
	   	                 break;
	                    case "Business":
	                    	String Q="update kalyanflight set Economic =Economic+1 where FlightNumber='"+mem+"'";
		   	                 stmt.executeUpdate(Q);
		   	                 break;
	                    case "Economic Service":
	                    	String Qu="update kalyanflight set Economic_Service =Economic_Service+1 where FlightNumber='"+mem+"'";
		   	                 stmt.executeUpdate(Qu);
		   	                 break;
	                    case "Special_Business":
	                    	String Que="update kalyanflight set Special_Business=Special_Business+1 where FlightNumber='"+mem+"'";
		   	                 stmt.executeUpdate(Que);
		   	                 break;
	                    	
	                    	
	                    }
	                    String Qry="update kalyanflight set Seats=Seats+1 where FlightNumber='"+mem+"'";
		                 stmt.executeUpdate(Qry);
		                 System.out.println(mem);
		                 String sql ="delete from Passenger where TicketNumber='"+num+"'";
			                 stmt.executeUpdate(sql);
			             Refund rf=new Refund();
			             rf.main(null);
                    }
	              
	                 
				}
				
				catch(Exception f) {
					System.out.println(f);
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_3.setBounds(107, 477, 310, 58);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnNewButton_4.setBounds(629, 477, 136, 58);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Cancellation Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(209, 21, 412, 58);
		frame.getContentPane().add(lblNewLabel);
	}
}
