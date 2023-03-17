package Flight_management_system;



import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



public class BOOKED1 extends JFrame {



   private JPanel contentPane;



   /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BOOKED1 frame = new BOOKED1();
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
    public BOOKED1() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



       setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 153));
        panel.setBounds(10, 10, 416, 48);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("PAYMENT COMPLETED");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 102, 153));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        panel.add(lblNewLabel);
        pay p= new pay();
        p.main(null);
        
        JButton btnNewButton = new JButton("Show Details");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 102, 153));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		display ds=new display();
        		ds.main(null);
        		//System.exit(0);
        	}
        });
        btnNewButton.setBounds(50, 209, 150, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\rlakshmisaich.nath\\OneDrive - HCL Technologies Ltd\\Desktop\\files\\CAPSTONE\\MicrosoftTeams-image (2).png"));
        lblNewLabel_1.setBounds(214, 69, 212, 163);
        contentPane.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4));
        panel_1.setBounds(0, 0, 436, 263);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("TICKET BOOKED SUCCESSFULLY");
        lblNewLabel_2.setForeground(new Color(0, 102, 153));
        lblNewLabel_2.setBackground(new Color(0, 102, 153));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 92, 244, 90);
        panel_1.add(lblNewLabel_2);
    }
}