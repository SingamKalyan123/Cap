package Flight_management_system;



import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;



public class CREDIT extends JFrame {



   private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    JLabel validation4;
    JLabel validation5;
    private JLabel lblNewLabel_3;
    private JButton btnNewButton_1;
    private JPanel panel_1;
    private JLabel lblNewLabel_4;
    private JTextField textField_2;
    private JLabel validation6;



   /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CREDIT frame = new CREDIT();
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
    public CREDIT() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



       setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 153));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 22, 554, 68);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("CREDIT CARD");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("ENTER LAST 4 DIGITS OF CARD NUMBERS:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(53, 163, 361, 28);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("ENTER CVV:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(53, 202, 143, 28);
        contentPane.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                char c = e.getKeyChar();
                if(Character.isAlphabetic(c)) {
                    textField.setEditable(false);
                    validation4.setText("Please enter numbers only");
                    
                }else {
                    textField.setEditable(true);
                }
            }
        });
        textField.setBounds(424, 169, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                char c = e.getKeyChar();
                if(Character.isAlphabetic(c)) {
                    textField_1.setEditable(false);
                    validation5.setText("Please enter numbers only");
                    
                }else {
                    textField_1.setEditable(true);
                }
            }
        });
        textField_1.setBounds(424, 203, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btnNewButton = new JButton("BOOK TICKET");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 102, 153));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() ) {
            		JOptionPane.showMessageDialog(null,"Entering all fileds is mandatory");
            		
            	}else {
                BOOKED1 booked1 = new BOOKED1();
                booked1.show();
                JButton btnNewButton = (JButton)e.getSource();
            	SwingUtilities.windowForComponent(btnNewButton).dispose();
            	try {
        			//Class.forName("com.mysql.jdbc.Driver");
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
        			
        			System.out.println("Inserting records");
        			 PreparedStatement stmt=con.prepareStatement("Insert into paid (Type,cardno,name) values ( ?,?,?)");
        			
        			
        			stmt.setString(1,"credit card");
        			stmt.setString(2,textField.getText());
        			 stmt.setString(3,textField_2.getText());
        			stmt.executeUpdate();
        		}catch(Exception e1) {
        			System.out.println(e1);
        		}
            	}
            }
        });
        btnNewButton.setBounds(229, 305, 185, 48);
        contentPane.add(btnNewButton);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\MicrosoftTeams-image (1).png"));
        lblNewLabel_3.setBounds(10, 271, 209, 169);
        contentPane.add(lblNewLabel_3);
        
        btnNewButton_1 = new JButton("GO BACK ");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 102, 153));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Flights window = new Flights();
                window.frame.setVisible(true);
        	      JButton btnNewButton_1 = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnNewButton_1).dispose();
        	}
        });
        btnNewButton_1.setBounds(20, 95, 107, 19);
        contentPane.add(btnNewButton_1);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4));
        panel_1.setBounds(0, 0, 586, 463);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel_4 = new JLabel("ENTER CARD HOLDER NAME: ");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(53, 244, 298, 14);
        panel_1.add(lblNewLabel_4);
        
        textField_2 = new JTextField();
        textField_2.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		char c = e.getKeyChar();
                if(Character.isDigit(c)) {
                    textField_2.setEditable(false);
                    validation6.setText("Please enter aplabets only");
                    
                }else {
                    textField_2.setEditable(true);
                }
        	}
        });
        textField_2.setBounds(424, 243, 150, 20);
        panel_1.add(textField_2);
        textField_2.setColumns(10);
        
        validation4 = new JLabel();
        validation4.setBounds(400, 188, 164, 13);
        panel_1.add(validation4);
        
        validation5 = new JLabel();
        validation5.setBounds(400, 226, 175, 13);
        panel_1.add(validation5);
        
        validation6 = new JLabel();
        validation6.setBounds(401, 269, 175, 13);
        panel_1.add(validation6);
        
        validation6 = new JLabel();
        validation6.setBounds(400, 274, 175, 13);
        panel_1.add(validation6);
    }
}