package Report;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LocationReport extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationReport frame = new LocationReport();
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
	public LocationReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(10, 11, 1069, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 1049, 642);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOCATION REPORT");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(359, 0, 270, 49);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SOURCE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(32, 64, 120, 39);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DESTINATION");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(485, 64, 144, 39);
		panel_1.add(lblNewLabel_1_1);
		
		JComboBox sourcecb = new JComboBox();
		sourcecb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sourcecb.setModel(new DefaultComboBoxModel(new String[] {"Hyderabad", "Delhi", "Vizag", "Pune", "Tirupati", "Kadapa", "Banglore", "USA"}));
		sourcecb.setBounds(162, 64, 292, 39);
		panel_1.add(sourcecb);
		
		JComboBox destinationcb = new JComboBox();
		destinationcb.setModel(new DefaultComboBoxModel(new String[] {"Hyderabad", "Delhi", "Vizag", "Pune", "Tirupati", "Kadapa", "Banglore", "USA"}));
		destinationcb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		destinationcb.setBounds(672, 64, 292, 39);
		panel_1.add(destinationcb);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reportmain rm=new Reportmain();
				rm.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(818, 147, 146, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Select=sourcecb.getSelectedItem().toString();
				String Sel=destinationcb.getSelectedItem().toString();
				// get the details of flights for the given source and destination
				try {
				String File_name="C:\\Users\\singamkalyank.reddy\\Documents\\Locationreport.pdf";
				Document doc=new Document();
				PdfWriter.getInstance(doc,new FileOutputStream(File_name));
				doc.open();
             //Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
             Statement stmt=con.createStatement();
             DefaultTableModel model=(DefaultTableModel) table.getModel();
             ResultSet rs=stmt.executeQuery("Select FlightName,FlightNumber,Date,ArrivalTime,DestinationTime,Seats from kalyanflight where Source= '"+Select+"' and Destination ='"+Sel+"'");
             Paragraph para =new Paragraph("Flight Details between these location ");
             Paragraph p=new Paragraph("                ");
             doc.add(para);
             doc.add(p);
             PdfPTable table = new PdfPTable(6);
             PdfPCell c1=new PdfPCell(new Phrase("Flight Name"));
             table.addCell(c1);
             PdfPCell c2=new PdfPCell(new Phrase("Flight Number"));
             table.addCell(c2);
             PdfPCell c3=new PdfPCell(new Phrase("Date of Flight"));
             table.addCell(c3);
             PdfPCell c4=new PdfPCell(new Phrase("ArrivalTime"));
             table.addCell(c4);
             PdfPCell c5=new PdfPCell(new Phrase("Departure Time"));
             table.addCell(c5);
             PdfPCell c6=new PdfPCell(new Phrase("Seats"));
             table.addCell(c6);
             
             int n=0;
             while(rs.next())
             {
                 String[] s= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                 model.addRow(s);
                 n++;
                 table.addCell(s[0]);
                 table.addCell(s[1]);
                 table.addCell(s[2]);
                 table.addCell(s[3]);
                 table.addCell(s[4]);
                 table.addCell(s[5]);
             }
             doc.add(table);
             JOptionPane.showMessageDialog(null, "Report has downloaded successfully in your documents", "Success", JOptionPane.INFORMATION_MESSAGE);
            doc.close();
            System.out.println("Successfully table is added into report pdf");
             if(n==0)
            	 JOptionPane.showMessageDialog(null,"Enter Valid Source and Destination");
            
            }
            catch(Exception ae)
        
            {
                System.out.println(ae);
            }
		
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(423, 136, 187, 39);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 1029, 434);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"flightname", "Flightnumber", "Date of flight", "Arrival time", "Departure time", "Seats"},
			},
			new String[] {
					"", "", "", "", "", "",
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(0).setMinWidth(18);
		scrollPane.setViewportView(table);
	}
}
