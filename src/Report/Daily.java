package Report;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Daily extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daily frame = new Daily();
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
	public Daily() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Report on Daily Flights");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(231, 24, 399, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Enter the date for which you want report");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(29, 126, 432, 46);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(553, 122, 304, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String File_name="C:\\Users\\singamkalyank.reddy\\Documents\\DailyReport.pdf";
					Document doc=new Document();
					PdfWriter.getInstance(doc,new FileOutputStream(File_name));
					doc.open();
	             //Class.forName("com.mysql.jdbc.Driver");
	             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
	             Statement stmt=con.createStatement();
	             DefaultTableModel model=(DefaultTableModel) table.getModel();
	             ResultSet rs=stmt.executeQuery("Select FlightName,FlightNumber,Source,Destination,ArrivalTime,DestinationTime,Seats from kalyanflight where Date='"+textField.getText()+"'");
	             Paragraph para =new Paragraph("Flight Details during that date ");
	             Paragraph p=new Paragraph("                ");
	             doc.add(para);
	             doc.add(p);
	             PdfPTable table = new PdfPTable(6);
	             PdfPCell c1=new PdfPCell(new Phrase("Flight Name"));
	             table.addCell(c1);
	             PdfPCell c2=new PdfPCell(new Phrase("Flight Number"));
	             table.addCell(c2);
	             PdfPCell c3=new PdfPCell(new Phrase("Source"));
	             table.addCell(c3);
	             PdfPCell c4=new PdfPCell(new Phrase("Destination"));
	             table.addCell(c4);
	             PdfPCell c5=new PdfPCell(new Phrase("ArrivalTime"));
	             table.addCell(c5);
	             PdfPCell c6=new PdfPCell(new Phrase("Departure Time"));
	             table.addCell(c6);
	             PdfPCell c7=new PdfPCell(new Phrase("Seats"));
	             table.addCell(c7);
	             
	             int n=0;
	             while(rs.next())
	             {
	                 String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
	                 model.addRow(s);
	                 n++;
	                 table.addCell(s[0]);
	                 table.addCell(s[1]);
	                 table.addCell(s[2]);
	                 table.addCell(s[3]);
	                 table.addCell(s[4]);
	                 table.addCell(s[5]);
	                 table.addCell(s[6]);
	             }
	             doc.add(table);
	             JOptionPane.showMessageDialog(null, "Report has downloaded successfully in your documents", "Success", JOptionPane.INFORMATION_MESSAGE);
	            doc.close();
	            System.out.println("Successfully table is added into report pdf");
	             if(n==0)
	            	 JOptionPane.showMessageDialog(null,"Enter Valid date of Journey ");
	            
	            }
	            catch(Exception ae)
	        
	            {
	                System.out.println(ae);
	            }
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(387, 219, 145, 32);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 481, 800, -199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
		            new Object[][] {
		                {"FlightName","FlightNumber","Source", "Destination","ArrivalTime","DepartureTime", "Seats"},
		            },
		            new String[] {
		                "New column", "New column", "New column", "New column", "New column", "New column", "New column",
		            }
		        ));
		table.setBounds(59, 286, 798, 185);
		contentPane.add(table);
		
		btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportmain rm=new Reportmain();
				rm.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(406, 481, 75, 32);
		contentPane.add(btnNewButton_1);
	}
}
