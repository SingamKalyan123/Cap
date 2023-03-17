package keerthi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Refund extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refund frame = new Refund();
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
	public Refund() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Refund Payment");
		btnNewButton.setBounds(194, 266, 274, 62);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "If tickets are cancelled before 2 days 20% will be refunded, "
						+ "If tickets are cancelled before 5 days 50% will be refunded, "
						+ "If tickets are cancelled before 10 days 100% will be refunded");
				JOptionPane.showMessageDialog(null,"Refund Successfully completed");
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setForeground(new Color(0,0,0));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Account Number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(49, 98, 221, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(361, 98, 234, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IFSC Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(49, 180, 221, 49);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 180, 234, 49);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Refund Form");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnNewButton_1.setBounds(180, 11, 309, 48);
		contentPane.add(btnNewButton_1);
	}
}
