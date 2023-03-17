package src;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Flight_management_system.Flights;
import Flight_management_system.pay;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTickets extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField source;
	private JTextField dest;
	private JTextField textField_3;
	private JTextField mobile_input;
	private JTextField doj;
	private JTextField adress;
	private JTextField textField;
	private JTextField number;
	private JTextField Amount;
	public static int tktnum;
	public static int pri;

	/**
	 * Launch the application.
	 */
	public  void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTickets frame = new BookTickets();
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
	public BookTickets() {
		setTitle("BOOK TICKETS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(77, 77, 146, 51);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c=e.getKeyChar();
				if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
				{
					name.setEditable(true);
				}
				else
				{
					name.setEditable(false);
				}
				
			}
		});
		name.setBounds(198, 90, 182, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(61, 157, 104, 44);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Tahoma", Font.BOLD, 17));
		male.setBounds(198, 169, 97, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female\r\n");
		female.setFont(new Font("Tahoma", Font.BOLD, 17));
		female.setBounds(297, 169, 172, 23);
		contentPane.add(female);
		
		JLabel lblNewLabel_2 = new JLabel("Source :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(68, 217, 155, 51);
		contentPane.add(lblNewLabel_2);
		
		source = new JTextField();
		source.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c=e.getKeyChar();
				if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
				{
					source.setEditable(true);
				}
				else
				{
					source.setEditable(false);
				}
				
			}
		});
		source.setBounds(199, 224, 181, 32);
		contentPane.add(source);
		source.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Destination :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(27, 279, 171, 78);
		contentPane.add(lblNewLabel_3);
		
		dest = new JTextField();
		dest.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c=e.getKeyChar();
				if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
				{
					dest.setEditable(true);
				}
				else
				{
					dest.setEditable(false);
				}
			}
		});
		dest.setBounds(199, 300, 181, 32);
		contentPane.add(dest);
		dest.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adress :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(74, 368, 137, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(77, 416, 88, 64);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(224, 508, 29, -10);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		mobile_input = new JTextField();
		mobile_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String Mobile=mobile_input.getText();
				int length=Mobile.length();
				char c=e.getKeyChar();
				if(c>='0' && c<'9')
				{
					if(length<10)
					{
						mobile_input .setEditable(true);
						
					}else
					{
						mobile_input .setEditable(false);
						
					}
				}else
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||e.getExtendedKeyCode()==KeyEvent.VK_DELETE )
					{
						mobile_input .setEditable(true);
						
					}
					else
					{
						mobile_input .setEditable(false);
						
					}
				}
			}
		});
		mobile_input.setBounds(198, 436, 189, 32);
		contentPane.add(mobile_input);
		mobile_input.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DOJ :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(104, 491, 84, 44);
		contentPane.add(lblNewLabel_6);
		
		doj = new JTextField();
		doj.setBounds(198, 501, 189, 32);
		contentPane.add(doj);
		doj.setColumns(10);
		
		  String s[]= {"Business","Economic","Special Business","Economic Service"};
	        JComboBox comboBox = new JComboBox(s);
	       // String Select=comboBox.getSelectedItem().toString();
	       // System.out.println(Select);
	       /* if(Select=="Business")
	        {
	        	Business b=new Business();
	        	b.Business();
	        }
	        else
	        {
	        	economic e= new economic();
	        }
	        */
	        comboBox.setBounds(531, 32, 182, 31);
	        contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Random r=new java.util.Random();
				int start =1000;
				int end=10000;
				int result=r.nextInt(end-start)+start;
				
				
			    
				
				String Name =name.getText();
				String Gender="male";
				if(female.isSelected())
				{
					Gender="Female";
				}
                String Source =source.getText();
                String Destination =dest.getText();
                String Adress=adress.getText();
                String Mobile=mobile_input.getText();
                String DOJ =doj.getText();
                String Flight_num=textField.getText();
               String Class=comboBox.getSelectedItem().toString();
                
                
                if(Name.equals("") || Gender.equals("") || Source.equals("")|| Destination.equals("")||Adress.equals("")|| Mobile.equals("") || DOJ.equals("") || Flight_num.equals(""))
                {
                	JOptionPane.showMessageDialog(null,"Entering all fileds is mandatory");
                }
                else {
                try
                {
                	
                   // Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
                    PreparedStatement stmt=con.prepareStatement("insert into Passenger (Name,Gender,Source,Destination,Adress,Mobile,DOJ,Flight_num,TicketNumber,Class) values(?,?,?,?,?,?,?,?,?,?)");
                    
                    stmt.setString(1,Name);
                    stmt.setString(2,Gender);
                    stmt.setString(3,Source);
                    stmt.setString(4,Destination);
                    stmt.setString(5,Adress);
                    stmt.setString(6,Mobile);
                    stmt.setString(7,DOJ);
                    stmt.setString(8,Flight_num);
                    stmt.setLong(9,result);
                    stmt.setString(10,Class);
                    stmt.executeUpdate();
                    tktnum=result;
                    JOptionPane.showMessageDialog(null,"check your Ticket Number and Confirm");
                    System.out.println("Records Entered Successfully");
                   // pay p= new pay();
                    //p.main(null);
                    
                    
                } 
                catch(Exception s)
                {
                    System.out.println(s);
                }
                number.setText(String.valueOf(result));
                System.out.println(Flight_num);
                
			}
               
				
			}
		});
		
		btnNewButton.setBackground(new Color(255, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBounds(78, 589, 160, 44);
		contentPane.add(btnNewButton);
		
		JLabel Mobile_validation = new JLabel("");
		Mobile_validation.setBounds(198, 514, 200, 14);
		contentPane.add(Mobile_validation);
		
		adress = new JTextField();
		adress.setBounds(198, 368, 189, 32);
		contentPane.add(adress);
		adress.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("PAYMENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Flights f =new Flights();
				f.main(null);
			}
		});
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_1.setBounds(673, 592, 200, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("FlightNumber:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 31, 165, 32);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(198, 31, 182, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_8 = new JLabel("Your Ticket Number is :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(477, 93, 257, 51);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("Class :");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_10.setBounds(426, 31, 72, 32);
        contentPane.add(lblNewLabel_10);
		
		number = new JTextField();
		number.setBounds(586, 157, 200, 32);
		contentPane.add(number);
		number.setColumns(10);
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				source.setText(null);
			    dest.setText(null);
			    adress.setText(null);
			    mobile_input.setText(null);
			    doj.setText(null);
			    textField.setText(null);
			    number.setText(null);
			}
		});
		btnNewButton_2.setBackground(new Color(128, 0, 64));
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton_2.setBounds(368, 594, 172, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CONFIRM");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
					Statement stmt=con.createStatement();
				    String Str="update kalyanflight  set Seats=Seats-1 where FlightNumber='"+textField.getText()+"'";
					
					stmt.executeUpdate(Str);
                    String sql1="update Passenger set Status='Pending' where TicketNumber='"+number.getText()+"'";
                    
                    //stmt.setString(1,s);
                    
                    stmt.executeUpdate(sql1);
                   
                    String Sql2="Select Price from kalyanflight where FlightNumber='" +textField.getText() +"'";
                    
                    //textField_1.setText(Sql2);
                    
                    //System.out.println(Sql2);
                    ResultSet rs=stmt.executeQuery(Sql2);
                    while(rs.next()) {
                   String price=rs.getString("Price");
                     pri =Integer.parseInt(price);
                     String Select=comboBox.getSelectedItem().toString();
                    System.out.println(Select);
                    if(Select=="Business")
                    {
                    	 String sql="update kalyanflight  set Business=Business-1 where FlightNumber='"+textField.getText()+"'";
     					
     					stmt.executeUpdate(sql);
                    	Business b=new Business();
                    }
                    else if(Select=="Economic")
                    {
                    	 String sql="update kalyanflight  set Economic=Economic-1 where FlightNumber='"+textField.getText()+"'";
      					
      					stmt.executeUpdate(sql);
                    	economic d= new economic();
                    }
                    else if(Select=="Special Business")
                    {
                    	 String sql="update kalyanflight  set Special_Business=Special_Business-1 where FlightNumber='"+textField.getText()+"'";
      					
      					stmt.executeUpdate(sql);
                    	Business d= new Business(900);
                    }
                    else
                    {
                    	 String sql="update kalyanflight  set Economic_Service =Economic_Service-1 where FlightNumber='"+textField.getText()+"'";
      					
      					stmt.executeUpdate(sql);
                    	economic b=new economic(800);
                    }
                    String str=String.valueOf(pri);
                    
                    Amount .setText(str);
                    }
				}
				catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Ticket Confirmed and goto Payment Method");
				/* pay p= new pay();
                 p.main(null); */
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(691, 235, 209, 51);
		contentPane.add(btnNewButton_3);
		JLabel lblNewLabel_9 = new JLabel("Amount to paid :");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_9.setBounds(510, 474, 171, 51);
        contentPane.add(lblNewLabel_9);
        
        Amount = new JTextField();
        Amount.setBounds(704, 474, 169, 37);
        contentPane.add(Amount);
        Amount.setColumns(10);
	}
	class Business extends BookTickets
	{
		public Business()
		{
			pri=pri+700;
		}
		public Business(int a)
		{
			pri=pri+a;
		}
	}
	class economic extends BookTickets
	{
		public economic()
		{
			pri=pri+500;
		}
		public economic(int b)
		{
			pri=pri+b;
		}
		
	}
}
