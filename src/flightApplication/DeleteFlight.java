package flightApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DeleteFlight extends JFrame {

	private JPanel contentPane;
	private JTextField txtFlightNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFlight frame = new DeleteFlight();
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
	public DeleteFlight() {
		setTitle("DELETE FLIGHTS");
		setBounds(100, 100, 819, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Flight Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(97, 92, 238, 63);
		contentPane.add(lblNewLabel);
		
		txtFlightNumber = new JTextField();
		txtFlightNumber.setBounds(414, 102, 327, 48);
		contentPane.add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					
                    String query = "delete from kalyanflight where FlightNumber ='"+txtFlightNumber.getText()+"' ";
					PreparedStatement stmt=con.prepareStatement(query);
					int n=stmt.executeUpdate();
					if(n==0)
					{
						JOptionPane.showMessageDialog(null, "Enter Valid Flight Number", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						dispose();
					    ModifyFlights mf = new ModifyFlights();
					    mf.setVisible(true);
					    JOptionPane.showMessageDialog(null,"Successfully Delete above Entered FlightNumber");
					}
					
					//int i=stmt.executeUpdate();
					System.out.println("Records updated"
							+ " Successfully");
			}
				catch(Exception s)
				{
					System.out.println(s);
				}
			}
		});
		btnNewButton.setBounds(278, 206, 238, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("DELETE FLIGHTS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(262, 11, 268, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyFlights mf= new ModifyFlights();
				mf.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(63, 300, 122, 35);
		contentPane.add(btnNewButton_1);
	}
}
