package Flight_management_system;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import own.Dashboardforuser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class display extends JFrame {

	private JPanel contentPane;
	private JTable tables;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display();
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
	public display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ticket is Booked Suceesfully below are the ticket details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(204, 42, 587, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Get Ticket Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
		             
		             //Class.forName("com.mysql.jdbc.Driver");
		             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
		             Statement stmt=con.createStatement();
		             // System.out.println("ae");
		            // DefaultTableModel model=(DefaultTableModel) tables.getModel();
		            // System.out.println("ae");
                     ticket tk=new ticket();
                     int a=tk.tkt();
                     String str=String.valueOf(a);
		             ResultSet rs=stmt.executeQuery("Select * from Passenger where TicketNumber= '"+str+"'");
		             int n=0;
		             DefaultTableModel model=(DefaultTableModel) tables.getModel();
		            // DefaultTableModel model=(DefaultTableModel) tables.getModel();
		             while(rs.next())
		             {
		                 String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
		                 model.addRow(s);
		                 n++;
		                 
		             }
		             if(n==0)
		            	 JOptionPane.showMessageDialog(null,"Enter valid Ticket Number","Error",JOptionPane.ERROR_MESSAGE);
		            }
		            catch(Exception ae)
		        
		            {
		                System.out.println(ae);
		            }
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(372, 84, 241, 46);
		contentPane.add(btnNewButton);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 458, 781, -300);
		contentPane.add(scrollPane);
		
		tables = new JTable();
		 tables.setModel(new DefaultTableModel(
		            new Object[][] {
		                {"Name","Gender","Source", "Destination","Adress","Mobile", "FlightNumber", "TicketNumber", "Status","Class"},
		            },
		            new String[] {
		                "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column","New column",
		            }
		        ));
		tables.setBounds(72, 159, 781, 302);
		contentPane.add(tables);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboardforuser du=new Dashboardforuser();
				du.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton_1.setBounds(429, 477, 125, 36);
		contentPane.add(btnNewButton_1);
	}
}
