package own;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Raashi.option;
import flightApplication.UpdateFlights;
import keerthi.CancellationForm;
import src.FlightDetails;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings({ "serial", "unused" })
public class Dashboardforuser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboardforuser frame = new Dashboardforuser();
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
	public Dashboardforuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 603, 621);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 583, 599);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\singamkalyank.reddy\\Downloads\\user1.png"));
		lblNewLabel.setBounds(64, 11, 107, 116);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CODERS AIRLINES");
		lblNewLabel_2.setForeground(new Color(255, 20, 147));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(182, 11, 296, 51);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("USER PAGE");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(259, 65, 169, 33);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("RESERVE TICKETS");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				FlightDetails fd =new FlightDetails();
				fd.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(64, 265, 464, 45);
		panel_1.add(btnNewButton);
		
		JButton btnCancellTickets = new JButton("CANCEL TICKETS");
		btnCancellTickets.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				CancellationForm cf =new CancellationForm();
				cf.main(null);
			}
		});
		btnCancellTickets.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancellTickets.setBounds(64, 416, 464, 45);
		panel_1.add(btnCancellTickets);
		
		JButton btnViewStatus = new JButton("VIEW RESERVATION STATUS");
		btnViewStatus.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				option op =new option();
				op.main(null);
			}
		});
		btnViewStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewStatus.setBounds(64, 343, 464, 45);
		panel_1.add(btnViewStatus);
	}

}
