package Flight_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class UPI_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UPI_1 frame = new UPI_1();
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
	public UPI_1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(10, 25, 566, 66);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("UPI PAYMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Phonepe");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PHONEPE_1 p = new PHONEPE_1();
				p.show();

      	      JButton btnNewButton = (JButton)e.getSource();
            	SwingUtilities.windowForComponent(btnNewButton).dispose();
      		
				
			}
		});
		btnNewButton.setBounds(41, 219, 193, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Googlepay");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 102, 153));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Googlepay g = new Googlepay();
				g.show();

      	      JButton btnNewButton = (JButton)e.getSource();
            	SwingUtilities.windowForComponent(btnNewButton).dispose();
      		
			}
		});
		btnNewButton_1.setBounds(41, 311, 193, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GO BACK ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 153));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flights window = new Flights();
                window.frame.setVisible(true);
        	      JButton btnNewButton_2 = (JButton)e.getSource();
              	SwingUtilities.windowForComponent(btnNewButton_2).dispose();
			}
		});
		btnNewButton_2.setBounds(20, 101, 110, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\MicrosoftTeams-image (3).png"));
		lblNewLabel_1.setBounds(283, 191, 279, 197);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 102, 153), 4));
		panel_1.setBounds(0, 0, 586, 463);
		contentPane.add(panel_1);
	}

}
