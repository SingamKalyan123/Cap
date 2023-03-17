package Report;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Reportmain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportmain frame = new Reportmain();
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
	public Reportmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 583, 557);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 563, 535);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CODERS AIRLINES");
		lblNewLabel.setBounds(108, 0, 364, 52);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		
		JLabel lblNewLabel_1 = new JLabel("REPORT");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(220, 49, 124, 35);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("PASSENGER REPORT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PassengerDetails pd=new PassengerDetails();
				pd.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(94, 164, 359, 52);
		panel_1.add(btnNewButton);
		
		JButton btnDailyFlightReport = new JButton("DAILY FLIGHT REPORT");
		btnDailyFlightReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Daily d=new Daily();
				d.main(null);
			}
		});
		btnDailyFlightReport.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDailyFlightReport.setBounds(94, 264, 359, 52);
		panel_1.add(btnDailyFlightReport);
		
		JButton btnWeeklyReport = new JButton("LOCATION REPORT");
		btnWeeklyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LocationReport lr=new LocationReport();
				lr.main(null);
			}
		});
		btnWeeklyReport.setBackground(new Color(240, 240, 240));
		btnWeeklyReport.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnWeeklyReport.setBounds(94, 362, 359, 52);
		panel_1.add(btnWeeklyReport);
	}
}
