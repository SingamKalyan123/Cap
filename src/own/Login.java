package own;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings({ "unused", "serial" })
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	DBConnection conn;
	//@SuppressWarnings("unused")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Login() {
		
		//database connection
		conn = new DBConnection();
		if (conn == null) {
			JOptionPane.showMessageDialog(null, "DB Connection not available", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 740, 573);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 720, 551);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\flight.png"));
		lblNewLabel.setBounds(10, 11, 178, 134);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODERS AIRLINES");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(212, 47, 454, 62);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(66, 186, 178, 34);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(66, 266, 178, 34);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("USER TYPE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(66, 347, 178, 34);
		panel_1.add(lblNewLabel_4);
		
		JLabel unllabel = new JLabel("");
		unllabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		unllabel.setForeground(new Color(255, 0, 0));
		unllabel.setBounds(254, 220, 328, 22);
		panel_1.add(unllabel);
		
		JLabel pswdllabel = new JLabel("");
		pswdllabel.setForeground(Color.RED);
		pswdllabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pswdllabel.setBounds(254, 298, 328, 22);
		panel_1.add(pswdllabel);
		
		user = new JTextField();
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z]{0,20}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(user.getText());
				if(!match.matches()) {
					
					unllabel.setText(" *Incorrect Format");
				}else {
					unllabel.setText(null);
				}
			}
		});
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(254, 186, 328, 34);
		panel_1.add(user);
		user.setColumns(10);
		
		pswd = new JPasswordField();
		pswd.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9-_@#]{0,10}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(pswd.getText());
				if(!match.matches()) {
					
					pswdllabel.setText(" *Can not be a password");
				}else {
					pswdllabel.setText(null);
				}
			}
		});
		pswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pswd.setBounds(254, 266, 328, 34);
		panel_1.add(pswd);
		
		JComboBox usrty = new JComboBox();
		usrty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usrty.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		usrty.setBounds(254, 347, 328, 34);
		panel_1.add(usrty);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//login code for user and admin;
				String username = user.getText();
				String password = pswd.getText();
				String usertype = (String) usrty.getSelectedItem();
				if(username.isEmpty() || password.isEmpty() || !unllabel.isVisible() || !pswdllabel.isVisible()) {
					JOptionPane.showMessageDialog(null, "Username or Password field should not be Empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//start the login process.
					userLogin(username,password,usertype);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(353, 414, 133, 44);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for the action of register button
				dispose();
				RegistrationForm rf = new RegistrationForm();
			    rf.setTitle("Registration Form");
			    rf.setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(66, 484, 229, 34);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SET NEW PASSWORD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setting the new password
				dispose();
				NewPassword np = new NewPassword();
				np.setTitle("Re-Set Password");
				np.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(412, 484, 267, 34);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("WELCOME TO ");
		lblNewLabel_5.setForeground(new Color(255, 20, 147));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_5.setBounds(274, 11, 273, 43);
		panel_1.add(lblNewLabel_5);
		
		
	}
	protected void userLogin(String username, String password, String usertype) {
		// TODO Auto-generated method stub
		Connection dbconn = DBConnection.connectDB();
		try {
			PreparedStatement stmt= (PreparedStatement)dbconn.prepareStatement("select * from persons where user_name = ? and passwords = ? and user_type = ?");
			stmt.setString(1, username);
	        stmt.setString(2, password);
	        stmt.setString(3, usertype);
	        ResultSet rs=stmt.executeQuery();
	        if(rs.next()) {
	        	if(usertype == "admin") {
	        		//Display dashboard or new page after login
	        		dispose();
	        	    Dashboardforadmin da = new Dashboardforadmin();
	        	    da.setTitle("Dashboard for Admin");
	        	    da.setVisible(true);
	        	}else {
	        		// display dashboard for user
	        		dispose();
	        	    Dashboardforuser du = new Dashboardforuser();
	        	    du.setTitle("Dashboard for User");
	        	    du.setVisible(true);
	        	}
	   
	        }
	        else
	        	JOptionPane.showMessageDialog(null, "Invalid username or password or user type");
		}catch(SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null,ex);
		}
		
	}
		

}
