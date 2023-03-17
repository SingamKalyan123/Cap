package own;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class NewPassword extends JFrame {

	private JPanel contentPane;
	private JTextField usern;
	private JTextField npswd;
	private JPasswordField rnpswd;
	private JTextField crntpswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPassword frame = new NewPassword();
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
	
	DBConnection conn1;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NewPassword() {
		//database connection
		conn1 = new DBConnection();
		if (conn1 == null) {
			JOptionPane.showMessageDialog(null, "DB Connection not available", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 711);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 527, 652);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 507, 630);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\pass.png"));
		lblNewLabel.setBounds(10, 11, 127, 106);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODERS AIRLINES");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(143, 11, 354, 62);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RESET PASSWORD");
		lblNewLabel_2.setForeground(new Color(240, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(207, 71, 228, 23);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USERNAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(41, 165, 165, 23);
		panel_1.add(lblNewLabel_3);
		
		JLabel unrplabel = new JLabel("");
		unrplabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		unrplabel.setForeground(new Color(255, 0, 0));
		unrplabel.setBounds(41, 237, 417, 14);
		panel_1.add(unrplabel);
		
		JLabel npswdrplabel = new JLabel("");
		npswdrplabel.setForeground(Color.RED);
		npswdrplabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		npswdrplabel.setBounds(41, 439, 417, 14);
		panel_1.add(npswdrplabel);
		
		JLabel cpswdrplabel = new JLabel("");
		cpswdrplabel.setForeground(Color.RED);
		cpswdrplabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cpswdrplabel.setBounds(41, 535, 417, 14);
		panel_1.add(cpswdrplabel);
		
		usern = new JTextField();
		usern.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z]{0,20}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(usern.getText());
				if(!match.matches()) {
					unrplabel.setText(" *Incorrect Format");
					}else {
						unrplabel.setText(null);
					}
				}
			});
		usern.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usern.setBounds(41, 199, 417, 37);
		panel_1.add(usern);
		usern.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("NEW PASSWORD");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(41, 368, 175, 23);
		panel_1.add(lblNewLabel_4);
		
		npswd = new JTextField();
		npswd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9-_@#]{0,10}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(npswd.getText());
				if(!match.matches()) {
					
					npswdrplabel.setText(" *Can not be a password");
				}else {
					npswdrplabel.setText(null);
				}
			}
		});
		npswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		npswd.setBounds(41, 402, 417, 37);
		panel_1.add(npswd);
		npswd.setColumns(10);
		
		rnpswd = new JPasswordField();
		rnpswd.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				String newpass = npswd.getText().toLowerCase();
				String cnewpass = rnpswd.getText().toLowerCase();
				if(!cnewpass.equals(newpass)) {
					cpswdrplabel.setText("*password not matched");
				}else {
					cpswdrplabel.setText(null);
				}
			}
		});
		rnpswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rnpswd.setBounds(41, 498, 417, 37);
		panel_1.add(rnpswd);
		
		JLabel lblNewLabel_5 = new JLabel("CONFIRM NEW PASSWORD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(41, 464, 274, 23);
		panel_1.add(lblNewLabel_5);
        
        JLabel crntpswdlabel = new JLabel("");
        crntpswdlabel.setForeground(Color.RED);
        crntpswdlabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        crntpswdlabel.setBounds(41, 332, 417, 14);
        panel_1.add(crntpswdlabel);
        
        JComboBox choice = new JComboBox();
        choice.setModel(new DefaultComboBoxModel(new String[] {"CURRENT PASSWORD", "WHAT IS UR MOTHERS MAIDEN NAME?"}));
        choice.setFont(new Font("Tahoma", Font.BOLD, 17));
        choice.setBounds(41, 253, 417, 32);
        panel_1.add(choice);
        
        crntpswd = new JTextField();
        crntpswd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String PATTERN = "^[a-zA-Z0-9-_@#]{0,10}$";
                Pattern pat = Pattern.compile(PATTERN);
                Matcher match = pat.matcher(crntpswd.getText());
                if(!match.matches()) {
                    
                    crntpswdlabel.setText(" *Incorrect format");
                }else {
                    crntpswdlabel.setText(null);
                }
            }
        });
        crntpswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
        crntpswd.setColumns(10);
        crntpswd.setBounds(41, 296, 417, 37);
        panel_1.add(crntpswd);
		
		JButton btnNewButton = new JButton("SET");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String usernamerst = usern.getText();
				String currentpassword = crntpswd.getText();
				String newpassword = npswd.getText();
				String retypepassword = rnpswd.getText();
				String qn = (String) choice.getSelectedItem();
				if(usernamerst.isEmpty() || currentpassword.isEmpty() || newpassword.isEmpty() || retypepassword.isEmpty() || !unrplabel.isVisible() || !npswdrplabel.isVisible() || !cpswdrplabel.isVisible()) {
					JOptionPane.showMessageDialog(null, "Username or Password fields should not be Empty", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					//update the password
			    	usersetpassword(usernamerst,currentpassword,newpassword,retypepassword,qn);
			
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(300, 563, 158, 43);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK TO LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setTitle("Login");
				l.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(31, 563, 175, 43);
		panel_1.add(btnNewButton_1);
		
		
		
		
		

	}
	protected void usersetpassword(String usernamerst,String currentpassword, String newpassword, String retypepassword,String qn) {
		// TODO Auto-generated method stub
		Connection dbconn1 = DBConnection.connectDB();
		try {
			PreparedStatement stmt=(PreparedStatement)dbconn1.prepareStatement("select * from persons where user_name = ?");
			PreparedStatement stmt0=(PreparedStatement)dbconn1.prepareStatement("select * from persons where user_name = ? and passwords = ?");
			PreparedStatement stmt1= (PreparedStatement)dbconn1.prepareStatement("update persons set passwords = ? where user_name = ? and passwords = ?");
			PreparedStatement stmt2=(PreparedStatement)dbconn1.prepareStatement("select * from persons where user_name = ? and answer = ?");
			PreparedStatement stmt3= (PreparedStatement)dbconn1.prepareStatement("update persons set passwords = ? where user_name = ? and answer = ?");
			stmt.setString(1, usernamerst);
			stmt0.setString(1, usernamerst);
			stmt0.setString(2, currentpassword);
			stmt1.setString(1, retypepassword);
	        stmt1.setString(2, usernamerst);
	        stmt1.setString(3, currentpassword);
	        stmt2.setString(1, usernamerst);
            stmt2.setString(2, currentpassword);
            stmt3.setString(1, retypepassword);
            stmt3.setString(2, usernamerst);
            stmt3.setString(3, currentpassword);
	        ResultSet rs=stmt.executeQuery();
	        if(rs.next()) {
	        	if(qn == "CURRENT PASSWORD") {
	        		ResultSet rs1=stmt0.executeQuery();
		        	if(rs1.next())
		        	{
		        		stmt1.executeUpdate();	
		        		dispose();
	                    NewLogin();
		        		JOptionPane.showMessageDialog(null, "Password Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		        	}else {
		        		JOptionPane.showMessageDialog(null, "Current Password does not match", "Error", JOptionPane.ERROR_MESSAGE);
		        	}
	        	}else {
	        		ResultSet rs2=stmt2.executeQuery();
		        	if(rs2.next())
		        	{
		        		stmt3.executeUpdate();	
		        		dispose();
		        		NewLogin();
		        		JOptionPane.showMessageDialog(null, "Password Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		        	}else {
		        		JOptionPane.showMessageDialog(null, "answer does not match", "Error", JOptionPane.ERROR_MESSAGE);
		        	}
	        	}
	        	
	        }else {
	        	JOptionPane.showMessageDialog(null, "Username not found...Need to register...", "Error", JOptionPane.ERROR_MESSAGE);
	        }
		}catch(SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
	private void NewLogin() {
		// TODO Auto-generated method stub
		Login l2 = new Login();
		l2.setTitle("LOGIN");
		l2.setVisible(true);
	}
	
	
}
