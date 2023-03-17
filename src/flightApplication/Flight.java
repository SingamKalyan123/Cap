package flightApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Flight {

	private JFrame frmFlightSchedules;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flight window = new Flight();
					window.frmFlightSchedules.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Flight() {
		initialize();
	}
	private void initialize() {
		frmFlightSchedules = new JFrame();
		frmFlightSchedules.setFont(new Font("Dialog", Font.BOLD, 30));
		frmFlightSchedules.setTitle("Flight Schedules");
		frmFlightSchedules.setBounds(100, 100, 847, 510);
		frmFlightSchedules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmFlightSchedules.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Flights");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 75));
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.GREEN);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Update Flights");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFlights uf =new UpdateFlights();
				uf.main(null);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 50));
		mntmNewMenuItem.setBackground(Color.ORANGE);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modify Flights");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyFlights mf=new ModifyFlights();
				mf.main(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 50));
		mntmNewMenuItem_1.setBackground(Color.YELLOW);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("View Flights");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDetails vd=new ViewDetails();
				vd.main(null);
			}
		});
		
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 50));
		mntmNewMenuItem_2.setBackground(Color.PINK);
		mnNewMenu.add(mntmNewMenuItem_2);
	}

}
