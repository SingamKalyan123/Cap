package Flight_management_system;
import java.sql.Connection;
import java.lang.*;
import java.sql.DriverManager;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;



import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



public class Flights {



    
    public JFrame frame;
    private javax.swing.JButton btnNewButton_1;
    private javax.swing.JButton btnNewButton;
    private javax.swing.JButton btnupiPayment;
    private final Action action = new SwingAction();



   /**
     * Launch the application.
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public static void main(String[] args) {
        
    
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Flights window = new Flights();
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
    public Flights() {
        initialize();
    }



   /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setForeground(new Color(0, 128, 192));
        frame.setBounds(0, 0, 900, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton btnCreditCard = new JButton("CREDIT CARD");
        btnCreditCard.setForeground(new Color(255, 255, 255));
        btnCreditCard.setBackground(new Color(0, 102, 153));
        btnCreditCard.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CREDIT credit = new CREDIT();
                credit.show();
               
        	      JButton btnCreditCard = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnCreditCard).dispose();
                	
            }
        });
        btnCreditCard.setBounds(20, 285, 215, 65);
        frame.getContentPane().add(btnCreditCard);
        
        JButton btnNewButton_1 = new JButton("DEBIT CARD");
        btnNewButton_1.setBackground(new Color(0, 102, 153));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.addKeyListener(new KeyAdapter() {
            
            
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                Debit de = new Debit();
                de.show(); //display jframe
                
        	      JButton btnNewButton_1 = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnNewButton_1).dispose();
             
                
            }
        });
        btnNewButton_1.setBounds(20, 182, 210, 65);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("UPI PAYMENT");
        btnNewButton.setBackground(new Color(0, 102, 153));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UPI_1 u = new UPI_1();
        		u.show();
        		
        	
        	      JButton btnNewButton = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnNewButton).dispose();
        		
        		
        	}
        });
      
    
     
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnNewButton.setBounds(20, 392, 215, 65);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\MicrosoftTeams-image.png"));
        lblNewLabel_1.setBounds(386, 181, 453, 264);
        frame.getContentPane().add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 153));
        panel.setBounds(49, 19, 790, 74);
        frame.getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("PAYMENT FOR AIRLINE");
        panel.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 60));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4, true));
        panel_1.setBounds(0, 0, 886, 563);
        frame.getContentPane().add(panel_1);
    }
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
}