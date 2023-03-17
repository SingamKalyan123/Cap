package Raashi;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class option extends JFrame {

	private JPanel contentPane;
	JFrame frame2;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					option frame = new option();
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
	public option() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 1500, 500));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 10, 814, 53);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("VIEW RESERVATION STATUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("With Ticket Number");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				Pnr p=new Pnr();
				p.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(117, 225, 229, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Without Ticket Number");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				Flight_Manage_System fms=new Flight_Manage_System();
				fms.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(506, 225, 249, 42);
		contentPane.add(btnNewButton_1);
	}
}
