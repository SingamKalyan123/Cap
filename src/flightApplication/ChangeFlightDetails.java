package flightApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class ChangeFlightDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtFlightNumber;
	private JTextField txtArrivalTime;
	private JTextField txtDepartureTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeFlightDetails frame = new ChangeFlightDetails();
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
	public ChangeFlightDetails() {
		setTitle("CHANGE FLIGHT DETAILS");
		setBounds(100, 100, 855, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter FlightNumber");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(49, 61, 268, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New ArrivalTime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(49, 136, 268, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter New DepartureTime");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(49, 221, 268, 47);
		contentPane.add(lblNewLabel_2);
		
		txtFlightNumber = new JTextField();
		txtFlightNumber.setBounds(494, 59, 278, 47);
		contentPane.add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
		JLabel Kalyan = new JLabel("");
		Kalyan.setForeground(new Color(255, 0, 0));
		Kalyan.setFont(new Font("Tahoma", Font.BOLD, 15));
		Kalyan.setBounds(494, 186, 278, 34);
		contentPane.add(Kalyan);
		JLabel txtDeparture = new JLabel("");
		txtDeparture.setForeground(new Color(255, 0, 0));
		txtDeparture.setBounds(494, 290, 278, 34);
		contentPane.add(txtDeparture);
		
		txtArrivalTime = new JTextField();
		txtArrivalTime.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e)
			{
				String pa="^[0-2][0-9][:][0-5][0-9]";
				 Pattern p = Pattern.compile(pa);
	                Matcher match = p.matcher(txtArrivalTime.getText());
	                if(!match.matches()) {
	                	Kalyan.setText("* Time Format is Missing");
	                }else {
	                	Kalyan.setText(null);
	                }
			}
		});
		txtArrivalTime.setBounds(494, 136, 278, 47);
		contentPane.add(txtArrivalTime);
		txtArrivalTime.setColumns(10);
		
		txtDepartureTime = new JTextField();
		txtDepartureTime.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e)
			{
				String pa="^[0-2][0-9][:][0-5][0-9]";
				 Pattern p = Pattern.compile(pa);
	                Matcher match = p.matcher(txtDepartureTime.getText());
	                if(!match.matches()) {
	                	txtDeparture.setText("* Time Format is Missing");
	                }else {
	                	txtDeparture.setText(null);
	                }
			}
		});
		txtDepartureTime.setBounds(494, 221, 278, 47);
		contentPane.add(txtDepartureTime);
		txtDepartureTime.setColumns(10);
		
		JButton btnNewButton = new JButton("     Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                	Change(txtArrivalTime,txtDepartureTime,txtFlightNumber);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(228, 346, 406, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Change ArrivalTime and DepartureTime");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(147, 11, 606, 39);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyFlights mf =new ModifyFlights();
				mf.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(49, 429, 109, 39);
		contentPane.add(btnNewButton_1);
	}

	protected void Change(JTextField txtArrivalTime2, JTextField txtDepartureTime2, JTextField txtFlightNumber2) {
		// TODO Auto-generated method stub
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
            String query = "update kalyanflight set ArrivalTime = '"+txtArrivalTime.getText()+"' , DestinationTime = '"+txtDepartureTime.getText()+"' where FlightNumber ='"+txtFlightNumber.getText()+"' ";
			PreparedStatement stmt=con.prepareStatement(query);
			int n=stmt.executeUpdate();
			if(n==0)
				JOptionPane.showMessageDialog(null, "Please Enter Valid Flight Number", "Error", JOptionPane.ERROR_MESSAGE);
			
			else
				dispose();
			    ModifyFlights mf = new ModifyFlights();
			    mf.setVisible(true);
				JOptionPane.showMessageDialog(null,"New Arrival and departure Time Successfull updated");
			//int i=stmt.executeUpdate();
	}
		catch(Exception s)
		{
			System.out.println(s);
		}
	}
}
