package Raashi;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import own.Dashboardforuser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import java.sql.*;

public class Pnr extends JFrame { 

	private JPanel contentPane;
	JLabel label;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "select Name, DOJ, Source, Destination,Status,Gender from Passenger where TicketNumber = ?";
	private JTextField textName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pnr frame = new Pnr();
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
	public Pnr() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(0, 0, 1500, 500));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Ticket no.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(120, 190, 151, 47);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(63, 27, 708, 38);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("VIEW RESERVATION STATUS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Tahoma", Font.BOLD, 19));
		textName.setBounds(300, 198, 224, 29);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(176, 298, 82, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(176, 357, 59, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(176, 411, 82, 25);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(325, 298, 176, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(325, 357, 176, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(325, 413, 176, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Get Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					
					pst = con.prepareStatement(sql);
					pst.setString(1, textName.getText());
					rs = pst.executeQuery();
					
					if(textName.getText().isEmpty()) 
					{
	                    JOptionPane.showMessageDialog(null, "Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
	                }
					
					if (rs.next()) 
					{
						textField_1.setText(rs.getString("Name"));
						textField_2.setText(rs.getString("DOJ"));
						textField_3.setText(rs.getString("Status"));
						textField.setText(rs.getString("Source"));
						textField_4.setText(rs.getString("Destination"));
						textField_5.setText(rs.getString("Gender"));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ticket number is invalid", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				} 
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(580, 190, 161, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Source");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(176, 468, 95, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Destination");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(176, 527, 114, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(176, 580, 103, 25);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(325, 468, 176, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(325, 527, 176, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(325, 580, 176, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		JButton btnNewButton = new JButton("Clear");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField.setText("");
                textField_4.setText("");
                textField_5.setText("");
                textName.setText("");
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(481, 616, 114, 38);
        contentPane.add(btnNewButton);
        JButton btnNewButton_2 = new JButton("OK");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	Dashboardforuser du=new Dashboardforuser();
            	du.main(null);
            	
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.setBounds(236, 618, 85, 34);
        contentPane.add(btnNewButton_2);
	}
}
