package flightApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import own.Dashboardforadmin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class ModifyFlights extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFlights frame = new ModifyFlights();
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
	public ModifyFlights() {
		setTitle("MODIFY FLIGHTS");
		setBounds(100, 100, 850, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Click On What Action You Need To Perform");
		lblNewLabel.setForeground(new Color(255, 127, 80));
		lblNewLabel.setBackground(new Color(0, 255, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(193, 104, 513, 83);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Change Flight Details");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangeFlightDetails cf= new ChangeFlightDetails();
				cf.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(54, 253, 337, 99);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Delete Flight.");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteFlight df =new DeleteFlight();
				df.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(475, 253, 337, 99);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboardforadmin dfa= new Dashboardforadmin();
				dfa.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setBounds(368, 410, 136, 41);
		contentPane.add(btnNewButton_2);
	}
}
