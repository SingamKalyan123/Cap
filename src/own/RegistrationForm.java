package own;

import java.awt.EventQueue;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "serial", "unused" })
public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField uname;
	private JTextField mid;
	private JTextField inpswd;
	private JPasswordField cinpswd;
	private JTextField gndr;
	private JTextField question;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	DBConnection conn2;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistrationForm() {
		
		conn2 = new DBConnection();
		if (conn2 == null) {
			JOptionPane.showMessageDialog(null, "DB Connection not available", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 871, 665);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 851, 643);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\register.png"));
		lblNewLabel.setBounds(178, 11, 107, 112);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CODERS AIRLINES");
		lblNewLabel_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(295, 11, 354, 51);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATION FORM");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(330, 59, 276, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("FIRST NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(61, 144, 188, 33);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("LAST NAME");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(61, 188, 188, 33);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("USER NAME");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_2.setBounds(61, 232, 188, 33);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("GENDER");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_3.setBounds(61, 276, 188, 33);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("EMAIL ID");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_4.setBounds(61, 320, 188, 33);
		panel_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("PASSWORD");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_5.setBounds(61, 364, 188, 33);
		panel_1.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("RE-TYPE PASSWORD");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_6.setBounds(61, 408, 188, 33);
		panel_1.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("USER TYPE");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_7.setBounds(61, 452, 188, 33);
		panel_1.add(lblNewLabel_3_7);
		
		JLabel fnlabel = new JLabel("");
		fnlabel.setForeground(new Color(255, 0, 0));
		fnlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		fnlabel.setBounds(604, 144, 223, 33);
		panel_1.add(fnlabel);
		
		JLabel lnlabel = new JLabel("");
		lnlabel.setForeground(new Color(255, 0, 0));
		lnlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lnlabel.setBounds(604, 188, 223, 33);
		panel_1.add(lnlabel);
		
		JLabel unlabel = new JLabel("");
		unlabel.setForeground(new Color(255, 0, 0));
		unlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		unlabel.setBounds(604, 232, 223, 33);
		panel_1.add(unlabel);
		
		JLabel glabel = new JLabel("");
		glabel.setForeground(new Color(255, 0, 0));
		glabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		glabel.setBounds(604, 276, 223, 33);
		panel_1.add(glabel);
		
		JLabel emlabel = new JLabel("");
		emlabel.setForeground(new Color(255, 0, 0));
		emlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emlabel.setBounds(604, 320, 223, 33);
		panel_1.add(emlabel);
		
		JLabel plabel = new JLabel("");
		plabel.setForeground(new Color(255, 0, 0));
		plabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		plabel.setBounds(604, 364, 223, 33);
		panel_1.add(plabel);
		
		JLabel cplabel = new JLabel("");
		cplabel.setForeground(Color.RED);
		cplabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cplabel.setBounds(604, 408, 223, 33);
		panel_1.add(cplabel);
		
		JLabel gndrlabel = new JLabel("");
		gndrlabel.setForeground(Color.RED);
		gndrlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		gndrlabel.setBounds(604, 276, 223, 33);
		panel_1.add(gndrlabel);
		
		fname = new JTextField();
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z]{0,20}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(fname.getText());
				if(!match.matches()) {
					
					fnlabel.setText("*Incorrect Format");
				}else {
					fnlabel.setText(null);
				}
			}
		});
		fname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fname.setBounds(280, 144, 314, 33);
		panel_1.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z]{0,20}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(lname.getText());
				if(!match.matches()) {
					
					lnlabel.setText("*Incorrect Format");
				}else {
					lnlabel.setText(null);
				}
			}
		});
		lname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lname.setColumns(10);
		lname.setBounds(280, 188, 314, 33);
		panel_1.add(lname);
		
		uname = new JTextField();
		uname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9.-_@#]{0,10}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(uname.getText());
				if(!match.matches()) {
					
					unlabel.setText("*Incorrect Format");
				}else {
					unlabel.setText(null);
				}
			}
		});
		uname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		uname.setColumns(10);
		uname.setBounds(280, 232, 314, 33);
		panel_1.add(uname);
		
		JComboBox gndr = new JComboBox();
        gndr.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gndr.setModel(new DefaultComboBoxModel(new String[] {"female", "male"}));
        gndr.setBounds(280, 276, 314, 33);
        panel_1.add(gndr);
		
		mid = new JTextField();
		mid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{0,20}[@][a-z]{0,5}[.][a-z]{0,3}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(mid.getText());
				if(!match.matches()) {
					
					emlabel.setText("*Incorrect Mail ID");
				}else {
					emlabel.setText(null);
				}
			}
		});
		mid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mid.setColumns(10);
		mid.setBounds(280, 320, 314, 33);
		panel_1.add(mid);
		
		inpswd = new JTextField();
		inpswd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9-_@#]{0,10}$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(inpswd.getText());
				if(!match.matches()) {
					
					plabel.setText("*Can not be a password");
				}else {
					plabel.setText(null);
				}
			}
		});
		inpswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inpswd.setColumns(10);
		inpswd.setBounds(280, 364, 314, 33);
		panel_1.add(inpswd);
		
		cinpswd = new JPasswordField();
		cinpswd.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(!cinpswd.getText().equals(inpswd.getText())) {
					cplabel.setText("*password not matched");
				}else {
					cplabel.setText(null);
				}
			}
		});
		cinpswd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cinpswd.setBounds(280, 408, 314, 33);
		panel_1.add(cinpswd);
		
		JComboBox tuser = new JComboBox();
		tuser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tuser.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		tuser.setBounds(280, 452, 314, 33);
		panel_1.add(tuser);
		
		JLabel lblNewLabel_4 = new JLabel("WHAT IS YOUR MOTHERS MAIDEN NAME?");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_4.setBounds(61, 496, 371, 33);
        panel_1.add(lblNewLabel_4);
        
        JLabel questionlabel = new JLabel("");
        questionlabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        questionlabel.setForeground(new Color(255, 0, 0));
        questionlabel.setBounds(442, 531, 354, 23);
        panel_1.add(questionlabel);
        
        question = new JTextField();
        question.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String PATTERN = "^[a-zA-Z]{0,20}$";    
                Pattern pat = Pattern.compile(PATTERN);
                Matcher match = pat.matcher(question.getText());
                if(!match.matches()) {
                    
                    questionlabel.setText("*Incorrect Format");
                }else {
                    questionlabel.setText(null);
                }
            }
        });
        question.setBounds(442, 496, 354, 33);
        panel_1.add(question);
        question.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BACK TO LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l1 = new Login();
				l1.setTitle("Login");
				l1.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(173, 588, 204, 44);
		panel_1.add(btnNewButton_1);
		
		JCheckBox chkbxtc = new JCheckBox("TERMS AND CONDITIONS");
		chkbxtc.setFont(new Font("Tahoma", Font.BOLD, 17));
		chkbxtc.setBounds(68, 556, 21, 23);
		panel_1.add(chkbxtc);
		
		JButton btnNewButton_1_1 = new JButton("REGISTER");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String firstname = fname.getText();
				String lastname = lname.getText();
				String username = uname.getText();
				String emailid = mid.getText();
				String gender = (String) gndr.getSelectedItem();
				String password = inpswd.getText();
				String cpassword = cinpswd.getText();
				String qanswer = question.getText();
				String usertype = (String) tuser.getSelectedItem();
				if(firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || emailid.isEmpty() || gender.isEmpty() || password.isEmpty()
						|| cpassword.isEmpty() || !chkbxtc.isSelected() || !fnlabel.isVisible() || !lnlabel.isShowing()
						|| !unlabel.isShowing() || !emlabel.isShowing() || !plabel.isShowing() || !cplabel.isShowing() || qanswer.isEmpty() || !questionlabel.isShowing()) {
					JOptionPane.showMessageDialog(null, "Please Fill The Form Properly...", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//start the login process.
					userLogin(firstname,lastname,username,emailid,gender,password,cpassword,usertype,qanswer);
				}
					
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(518, 588, 178, 44);
		panel_1.add(btnNewButton_1_1);
		
		JButton tc = new JButton("Terms and Conditions");
		tc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for opening terms and conditions page
				Termsandconditions tc = new Termsandconditions();
				tc.setTitle("TERMS AND CONDITIONS");
				tc.setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		tc.setBackground(UIManager.getColor("Button.background"));
		tc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tc.setBounds(95, 556, 217, 23);
		panel_1.add(tc);
		
	}

	protected void userLogin(String firstname, String lastname, String username, String emailid, String gender,String password,
			String cpassword, String usertype,String qanswer) {
		// TODO Auto-generated method stub
		Connection dbconn = DBConnection.connectDB();
		try {
			PreparedStatement stmt= (PreparedStatement)dbconn.prepareStatement("select * from persons where user_name = ?");
			stmt.setString(1, username);
			PreparedStatement stmt1= (PreparedStatement)dbconn.prepareStatement("insert into persons values(?,?,?,?,?,?,?,?)");
			stmt1.setString(1, firstname);
	        stmt1.setString(2, lastname);
	        stmt1.setString(3, username);
	        stmt1.setString(4, gender);
	        stmt1.setString(5, emailid);
	        stmt1.setString(6, cpassword);
	        stmt1.setString(7, usertype);
	        stmt1.setString(8, qanswer);
	        ResultSet rs = stmt.executeQuery();
	        if(rs.next()) {
	        	JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
	        }else{
	        	stmt1.executeUpdate();
		        //register success
	        	dispose();
	        	Login l2 = new Login();
	        	l2.setTitle("LOGIN");
	        	l2.setVisible(true);
		        JOptionPane.showMessageDialog(null, "Registered successfully...", "Success", JOptionPane.INFORMATION_MESSAGE);
		        System.out.println("database updated successfully");
	        }
		}catch(SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null,ex);
		}
		
	}
}
