package Raashi;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import own.Dashboardforuser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Flight_Manage_System {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "select Name,  Status, Flight_num, TicketNumber, Gender from Passenger where Mobile = ?";
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flight_Manage_System window = new Flight_Manage_System();
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
	public Flight_Manage_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 870, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 10, 809, 67);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("VIEW RESERVATION STATUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 137, 154, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DOJ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 196, 154, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Source");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(44, 251, 154, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c= e.getKeyChar();
				if(!Character.isDigit(c))
				{
					e.consume();
				}
			}
		});
		textField.setBounds(230, 137, 247, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String PATTERN = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";   
                Pattern pat = Pattern.compile(PATTERN);
                Matcher match = pat.matcher(textField_1.getText());
                if(!match.matches()) {
                    
                	textField_10.setText("*Incorrect Format");
                }else {
                	textField_10.setText(null);
                }
			}
		});
		textField_1.setBounds(230, 196, 247, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 251, 247, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Destination");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(44, 303, 132, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 303, 247, 29);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(39, 435, 65, 29);
		frame.getContentPane().add(lblNewLabel_5);
		
		/*JLabel lblNewLabel_6 = new JLabel("Payment");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(39, 503, 85, 29);
		frame.getContentPane().add(lblNewLabel_6); */
		
		JLabel lblNewLabel_7 = new JLabel("Status");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(39, 578, 85, 29);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Flight Number");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(427, 435, 140, 29);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Ticket Number");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(427, 502, 132, 31);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(427, 578, 99, 29);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(149, 440, 194, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		/*textField_5 = new JTextField();
		textField_5.setBounds(149, 503, 194, 28);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10); */
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(151, 578, 192, 28);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(629, 435, 178, 28);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(629, 503, 178, 28);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(629, 578, 178, 28);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					
					pst = con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					rs = pst.executeQuery();
					
					if(textField.getText().isEmpty() | textField_1.getText().isEmpty() | textField_2.getText().isEmpty() | textField_3.getText().isEmpty()) 
					{
	                    JOptionPane.showMessageDialog(null, "Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
	                }
					
					if (rs.next()) 
					{
						textField_4.setText(rs.getString("Name"));
						//textField_5.setText(rs.getString("Payment"));
						textField_6.setText(rs.getString("Status"));
						textField_7.setText(rs.getString("Flight_num"));
						textField_8.setText(rs.getString("TicketNumber"));
						textField_9.setText(rs.getString("Gender"));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Mobile number is invalid", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				} 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(372, 364, 187, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Clear");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                //textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                textField_8.setText("");
                textField_9.setText("");
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.setBounds(520, 617, 99, 41);
        frame.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Ok");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//dispose();
            	Dashboardforuser du=new Dashboardforuser();
            	du.main(null);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(300, 617, 132, 41);
        frame.getContentPane().add(btnNewButton_1);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBackground(new Color(237, 240, 241));
		textField_10.setBorder(null);
		textField_10.setForeground(new Color(255, 0, 0));
		textField_10.setBounds(600, 189, 187, 31);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
