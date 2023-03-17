package Flight_management_system;



import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;



public class Debit extends JFrame {


   private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    JLabel validation;
    JLabel validation1;
    JLabel validation3;
    private JLabel lblNewLabel_2;
    private JButton btnNewButton_1;
    private JPanel panel_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Debit frame = new Debit();
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
    public Debit() {
    	
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



       setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 153));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 25, 566, 65);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("DEBIT CARD");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("ENTER YOUR CARD NO:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(96, 140, 195, 33);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("VALIDITY/ EXPIRY DATE:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(96, 181, 214, 36);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("ENTER CARD HOLDER NAME:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(96, 230, 237, 22);
        contentPane.add(lblNewLabel_1_2);
        
        JButton btnNewButton = new JButton("BOOK TICKET");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 102, 153));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() || textField_2.getText().trim().isEmpty()) {
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
        			
        			
        			stmt.setString(1,"debit card");
        			stmt.setString(2,textField.getText());
        			 stmt.setString(3,textField_2.getText());
        			stmt.executeUpdate();
        		}catch(Exception e1) {
        			System.out.println(e1);
        		}
            	}
            }
        });
        btnNewButton.setBounds(227, 310, 184, 44);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c)) {
                    textField.setEditable(false);
                    validation.setText("Please enter numbers only");
                    
                }else {
                    textField.setEditable(true);
                }
            }
        });
        textField.setBounds(384, 147, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c)) {
                    textField_1.setEditable(false);
                    validation1.setText("Please enter numbers only");
                    
                }else {
                    textField_1.setEditable(true);
                }
                
            }
        });
        textField_1.setBounds(384, 192, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c)) {
                    textField_2.setEditable(false);
                    validation3.setText("Please enter aplabets only");
                    
                }else {
                    textField_2.setEditable(true);
                }
    
            }
        });
        textField_2.setBounds(384, 233, 184, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        validation = new JLabel();
        validation.setBounds(384, 170, 200, 13);
        contentPane.add(validation);
        
        validation1 = new JLabel();
        validation1.setBounds(384, 210, 192, 19);
        contentPane.add(validation1);
        
        validation3 = new JLabel();
        validation3.setBounds(384, 260, 192, 19);
        contentPane.add(validation3);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\MicrosoftTeams-image (1).png"));
        lblNewLabel_2.setBounds(10, 282, 207, 159);
        contentPane.add(lblNewLabel_2);
        
        btnNewButton_1 = new JButton("GO BACK");
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
        btnNewButton_1.setBounds(20, 101, 110, 21);
        contentPane.add(btnNewButton_1);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4));
        panel_1.setBounds(0, 0, 584, 463);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
    }
}