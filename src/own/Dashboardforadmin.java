package own;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import flightApplication.ModifyFlights;
import flightApplication.UpdateFlights;
import flightApplication.ViewDetails;
import Report.PassengerDetails;
import Report.Reportmain;
import Report.Ticket_Details__Verification_for_Admin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

@SuppressWarnings({ "serial", "unused" })
public class Dashboardforadmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboardforadmin frame = new Dashboardforadmin();
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
	public Dashboardforadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 667, 509);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 647, 487);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\admin.png"));
		lblNewLabel.setBounds(10, 11, 104, 125);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN PAGE");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(248, 58, 169, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CODERS AIRLINES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2.setBounds(191, 11, 296, 51);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ADD FLIGHTS");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateFlights uf =new UpdateFlights();
				uf.main(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(198, 180, 239, 51);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW FLIGHTS");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewDetails mf=new ViewDetails();
				mf.main(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(198, 272, 239, 51);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REPORT");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				//Ticket_Details__Verification_for_Admin pd = new Ticket_Details__Verification_for_Admin();
				dispose();
				Reportmain rm =new Reportmain();
				rm.main(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(198, 370, 239, 51);
		panel_1.add(btnNewButton_2);
		
		
	}

}
