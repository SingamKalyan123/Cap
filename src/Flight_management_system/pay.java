package Flight_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import src.BookTickets;

public class pay extends BookTickets{
	public static void main(String args[])
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","Srkr#$@341");
            String query = "update Passenger set Status='Confirmed' where TicketNumber ='"+tktnum+"' ";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.executeUpdate();
			//System.out.println("Hello i am here");
			/*if(n==0)
				JOptionPane.showMessageDialog(null, "Please Enter Valid Flight Number", "Error", JOptionPane.ERROR_MESSAGE);
			
			else
				JOptionPane.showMessageDialog(null,"");
			//int i=stmt.executeUpdate(); */
	}
		catch(Exception s)
		{
			System.out.println(s);
	}
	
}
}
