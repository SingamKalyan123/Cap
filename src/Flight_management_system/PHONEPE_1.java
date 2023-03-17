package Flight_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PHONEPE_1 extends JFrame {

	private JPanel contentPane;
	private javax.swing.JComboBox<String> comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PHONEPE_1 frame = new PHONEPE_1();
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
	public PHONEPE_1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(10, 11, 566, 61);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("PHONEPE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER UPI ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(39, 169, 217, 23);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedvalue = comboBox.getSelectedItem().toString();
				textField.setText(selectedvalue);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"@oksbi", "@okicici", "@okhdfc"}));
		comboBox.setBounds(377, 200, 118, 18);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(288, 200, 87, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 200, 118, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("GO BACK ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 102, 153));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UPI_1 frame = new UPI_1();
				frame.setVisible(true);
        	      JButton btnNewButton_1 = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setBounds(20, 83, 118, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4));
		panel_1.setBounds(0, 0, 586, 463);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("VERIFY AND PAY NOW");
		btnNewButton_2.setBounds(259, 328, 302, 33);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 153));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("ENTER PHONE NUMBER:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(41, 237, 175, 33);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
                if(Character.isLetter(c)) {
                    textField.setEditable(false);
                    lblNewLabel_3.setText("Please enter numbers only");
                    
                }else {
                    textField.setEditable(true);
                }
			}
		});
		textField_2.setBounds(259, 245, 219, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(259, 276, 234, 14);
		panel_1.add(lblNewLabel_3);
		
		
		
	    
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty()  ) {
            		JOptionPane.showMessageDialog(null,"Entering all fileds is mandatory");
            		
            	}else {
				
				BOOKED1 booked1 = new BOOKED1();
                booked1.show();
                JButton btnNewButton = (JButton)e.getSource();
            	SwingUtilities.windowForComponent(btnNewButton).dispose();
            	try {
        			Class.forName("com.mysql.jdbc.Driver");
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
        			
        			System.out.println("Inserting records");
        			 PreparedStatement stmt=con.prepareStatement("Insert into paid (Type,cardno,name) values ( ?,?,?)");
        			
        			
        			stmt.setString(1,"Phone pe");
        			stmt.setString(2,textField_2.getText());
        			stmt.setString(3, null);
        			stmt.executeUpdate();
        		}catch(Exception e1) {
        			System.out.println(e1);
        		}
			}}
		});
	}
}
