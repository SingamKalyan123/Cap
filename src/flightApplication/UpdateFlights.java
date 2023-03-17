package flightApplication;
//import package own;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import own.Dashboardforadmin;

import java.util.regex.Matcher;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

//import org.eclipse.swt.graphics.Pattern;

//import own.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
//import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class UpdateFlights extends JFrame {

	private JPanel contentPane;
	private JTextField txtFlightName;
	private JTextField txtFlightNumber;
	private JTextField txtSource;
	private JTextField txtDestination;
	private JTextField txtArrivalTime;
	private JTextField txtDepartureTime;
	private JTextField txtDateOfJourney;
	private JTextField txtSeats;
	private JTextField txtPrice;
	private JTextField DateOfJourneyVali;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFlights frame = new UpdateFlights();
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
	public UpdateFlights() {
		setTitle("ADD FLIGHTS");
		
		setBounds(100, 100, 898, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 65, 801, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Flight Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 25, 265, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Flight Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(31, 65, 265, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Source");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(31, 104, 265, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Destination");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(31, 150, 265, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Arrival Time");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(31, 192, 265, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Departure Time");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(31, 224, 265, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Date Of Journey");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(31, 262, 265, 30);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Enter No Of Seats");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(31, 304, 265, 20);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Enter Base Price Per Ticket ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(31, 348, 265, 27);
		panel.add(lblNewLabel_9);
		
		txtFlightName = new JTextField();
		txtFlightName.setBounds(400, 11, 154, 36);
		panel.add(txtFlightName);
		txtFlightName.setColumns(10);
		
		JLabel txtflightnum = new JLabel("");
		txtflightnum.setForeground(new Color(255, 0, 0));
		txtflightnum.setBounds(564, 58, 227, 26);
		panel.add(txtflightnum);
		
		txtFlightNumber = new JTextField();
		/* try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
			Statement stmt=con.createStatement();
			int n=stmt.executeQuery("select FlightName from kalyanflight where FlightNumber='"+txtFlightNumber.getText()+"'");
			if(rs.next()==true)
				txtflightnum.setText("");
			else
				txtflightnum.setText("Enter Different Flight number");	
		}
		catch(Exception s)
		{
			//JOptionPane.showMessageDialog(null,"FlightNumber is already Available");
			//JOptionPane.showMessageDialog(null, "Flight number is already available", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(s);
		} */
		txtFlightNumber.setBounds(400, 58, 154, 27);
		panel.add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
			
		
		txtSource = new JTextField();
		txtSource.setBounds(400, 98, 154, 31);
		panel.add(txtSource);
		txtSource.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setBounds(400, 140, 154, 30);
		panel.add(txtDestination);
		txtDestination.setColumns(10);
		JLabel txtArrive = new JLabel("");
		txtArrive.setForeground(new Color(255, 0, 0));
		txtArrive.setBounds(564, 187, 227, 27);
		panel.add(txtArrive);
		txtArrivalTime = new JTextField();
		txtArrivalTime.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e)
			{
				String pa="^[0-2][0-9][:][0-5][0-9]";
				 Pattern p = Pattern.compile(pa);
	                Matcher match = p.matcher(txtArrivalTime.getText());
	                if(!match.matches()) {
	                	txtArrive.setText("Time Format is Missing");
	                }else {
	                	txtArrive.setText(null);
	                }
			}
		});
		
		txtArrivalTime.setBounds(400, 187, 154, 28);
		panel.add(txtArrivalTime);
		txtArrivalTime.setColumns(10);
		
		JLabel txtDeparture = new JLabel("");
		txtDeparture.setForeground(new Color(255, 0, 0));
		txtDeparture.setBounds(579, 224, 212, 27);
		panel.add(txtDeparture);
		
		txtDepartureTime = new JTextField();
		txtDepartureTime.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e)
			{
				String pa="^[0-2][0-9][:][0-5][0-9]";
				 Pattern p = Pattern.compile(pa);
	                Matcher match = p.matcher(txtDepartureTime.getText());
	                if(!match.matches()) {
	                	txtDeparture.setText("Time Format is Missing");
	                }else {
	                	txtDeparture.setText(null);
	                }
			}
		});
		txtDepartureTime.setBounds(400, 224, 154, 29);
		panel.add(txtDepartureTime);
		txtDepartureTime.setColumns(10);
		JLabel txtDate = new JLabel("");
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDate.setForeground(new Color(255, 0, 0));
		txtDate.setBounds(566, 262, 225, 24);
		panel.add(txtDate);
		
		txtDateOfJourney = new JTextField();
		txtDateOfJourney.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String Pat = "^[0-3][0-9][/-][0-1][1-9][/-][0-9]{0,4}$";   
                Pattern p = Pattern.compile(Pat);
                Matcher match = p.matcher(txtDateOfJourney.getText());
                if(!match.matches()) {
                	txtDate.setText("Date Format is Missing");
                }else {
                	txtDate.setText(null);
                }
			}
		});
		txtDateOfJourney.setBounds(400, 262, 154, 30);
		panel.add(txtDateOfJourney);
		txtDateOfJourney.setColumns(10);
		
		txtSeats = new JTextField();
		txtSeats.setBounds(400, 306, 154, 31);
		panel.add(txtSeats);
		txtSeats.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(400, 348, 154, 30);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit Details");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
				String FlightName =txtFlightName.getText();
				String FlightNumber =txtFlightNumber.getText();
				String Source =txtSource.getText();
				String Destination =txtDestination.getText();
				String ArrivalTime =txtArrivalTime.getText();
				String DepartureTime =txtDepartureTime.getText();
				String DateOfJOurney =txtDateOfJourney.getText();
				String Seats =txtSeats.getText();
				int sts=Integer.parseInt(Seats);
				int busi=(sts*20)/100;
				int ecoser=(sts*30)/100;
				int splbusi=(sts*20)/100;
				int eco;
				eco=sts-busi-ecoser-splbusi;
				String Busi=String.valueOf(busi);
				String SplBusi=String.valueOf(splbusi);
				String Ecoser=String.valueOf(ecoser);
				String Eco=String.valueOf(eco);
				String Price =txtPrice.getText();
				if(FlightName.equals(" ") || FlightNumber.equals(" ") || Source.equals(" ")|| Destination.equals(" ")|| ArrivalTime.equals(" ")|| DepartureTime.equals(" ") || DateOfJOurney.equals(" ") || Seats.equals(" ") || Price.equals(" "))
                {
					JOptionPane.showMessageDialog(null, "Please Update The Details Properly...", "Error", JOptionPane.ERROR_MESSAGE);
                }
				else {
				try
				{
					//Class.forName("com.mysql.jdbc.Driver");
					//Connection con = DBConnection.connectDB();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					PreparedStatement stmt=con.prepareStatement("insert into kalyanflight (FlightName,FlightNumber,Source,Destination,ArrivalTIme, DestinationTime,Date,Seats, Price,Economic,Economic_Service,Business,Special_Business) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					stmt.setString(1,FlightName);
					stmt.setString(2,FlightNumber);
					stmt.setString(3,Source);
					stmt.setString(4,Destination);
					stmt.setString(5,ArrivalTime);
					stmt.setString(6,DepartureTime);
					stmt.setString(7,DateOfJOurney);
					stmt.setString(8,Seats);
					stmt.setString(9,Price);
					stmt.setString(10,Eco);
					stmt.setString(11,Ecoser);
					stmt.setString(12,Busi);
					stmt.setString(13,SplBusi);
					int n=stmt.executeUpdate();
					
						//JOptionPane.showMessageDialog(null,"FlightNumber is already Available");
					
					//JOptionPane.showMessageDialog(null," Data added Successfully");
					JOptionPane.showMessageDialog(null, "Data updated successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					//int i=stmt.executeUpdate();
					System.out.println("Records Entered Successfully");
			}
				catch(Exception s)
				{
					//JOptionPane.showMessageDialog(null,"FlightNumber is already Available");
					JOptionPane.showMessageDialog(null, "Flight number is already available", "Error", JOptionPane.ERROR_MESSAGE);
					System.out.println(s);
				}
				}
	     }
		}); 
			
		btnNewButton.setBounds(566, 405, 195, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboardforadmin da=new Dashboardforadmin();
				da.main(null);
			}
		});
		btnNewButton_1.setBounds(107, 408, 136, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFlightName.setText("");
				txtFlightNumber.setText("");
				txtSource.setText("");
				txtDestination.setText("");
				txtArrivalTime.setText("");
				txtDepartureTime.setText("");
				txtDateOfJourney.setText("");
				txtSeats.setText("");
				txtPrice.setText("");
				txtArrive.setText("");
				txtDeparture.setText("");
				txtDate.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(356, 409, 144, 34);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("  Add Flights");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(256, 11, 313, 56);
		contentPane.add(lblNewLabel);
	}
}
