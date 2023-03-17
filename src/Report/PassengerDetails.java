package Report;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class PassengerDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtFlightNumber;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable tbflights;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerDetails frame = new PassengerDetails();
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
	public PassengerDetails() {
		setTitle("Ticket Verification For Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ViewPassengerDetails");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 String File_name="C:\\Users\\singamkalyank.reddy\\Documents\\Flightreport.pdf";
						Document doc=new Document();
						PdfWriter.getInstance(doc,new FileOutputStream(File_name));
						doc.open();
	                 //Class.forName("com.mysql.jdbc.Driver");
	                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
	                 Statement stmt=con.createStatement();
	                 DefaultTableModel model=(DefaultTableModel) tbflights.getModel();
	                 ResultSet rs=stmt.executeQuery("Select * from Passenger where Flight_num= '"+txtFlightNumber.getText()+"'");
	                 Paragraph para =new Paragraph("Passenger Details for flightNumber "+txtFlightNumber.getText());
	                 doc.add(para);
	                 PdfPTable table = new PdfPTable(10);
	                 PdfPCell c1=new PdfPCell(new Phrase("Name"));
	                 table.addCell(c1);
	                 PdfPCell c2=new PdfPCell(new Phrase("Gender"));
	                 table.addCell(c2);
	                 PdfPCell c3=new PdfPCell(new Phrase("Source"));
	                 table.addCell(c3);
	                 PdfPCell c4=new PdfPCell(new Phrase("Destination"));
	                 table.addCell(c4);
	                 PdfPCell c5=new PdfPCell(new Phrase("Adress"));
	                 table.addCell(c5);
	                 PdfPCell c6=new PdfPCell(new Phrase("Mobile"));
	                 table.addCell(c6);
	                 PdfPCell c7=new PdfPCell(new Phrase("DOJ"));
	                 table.addCell(c7);
	                 PdfPCell c8=new PdfPCell(new Phrase("Flight_num"));
	                 table.addCell(c8);
	                 PdfPCell c9=new PdfPCell(new Phrase("TicketNumber"));
	                 table.addCell(c9);
	                 PdfPCell c10=new PdfPCell(new Phrase("Status"));
	                 table.addCell(c10);
	                 
	                 int n=0;
	                 while(rs.next())
	                 {
	                     String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
	                     model.addRow(s);
	                     n++;
	                     table.addCell(s[0]);
	                     table.addCell(s[1]);
	                     table.addCell(s[2]);
	                     table.addCell(s[3]);
	                     table.addCell(s[4]);
	                     table.addCell(s[5]);
	                     table.addCell(s[6]);
	                     table.addCell(s[7]);
	                     table.addCell(s[8]);
	                     table.addCell(s[9]);
	                 }
	                 doc.add(table);
	                 JOptionPane.showMessageDialog(null, "Report has downloaded successfully in your documents", "Success", JOptionPane.INFORMATION_MESSAGE);
	                doc.close();
	                System.out.println("Successfully table is added into report pdf");
	                 if(n==0)
	                	 JOptionPane.showMessageDialog(null,"Enter valid Flight Number");
	                
	                }
	                catch(Exception ae)
	            
	                {
	                    System.out.println(ae);
	                }
				
			}
		});
		btnNewButton.setBounds(524, 57, 289, 49);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 531, 821, -441);
		contentPane.add(scrollPane);
		
		tbflights = new JTable();
		 tbflights.setModel(new DefaultTableModel(
		            new Object[][] {
		                {"Name","Gender","Source", "Destination","Adreess","Mobile", "DOJ", "flightNumber", "TicketNumber","Status"},
		            },
		            new String[] {
		                "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column","New column",
		            }
		        ));
		tbflights.setBounds(48, 132, 821, 302);
		contentPane.add(tbflights);
		
		JLabel lblNewLabel = new JLabel("Enter FlightNumber");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 67, 170, 32);
		contentPane.add(lblNewLabel);
		
		txtFlightNumber = new JTextField();
		txtFlightNumber.setBounds(296, 68, 170, 35);
		contentPane.add(txtFlightNumber);
		txtFlightNumber.setColumns(10);
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(511, 167, 147, 23);
		contentPane.add(btnCancel);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reportmain rm=new Reportmain();
				rm.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(397, 445, 112, 32);
		contentPane.add(btnNewButton_1);
	}
}
