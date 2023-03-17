package Raashi;
import java.sql.*;

public class database {

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanage","root","UP_add@159");
			Statement stmt=con.createStatement();
			System.out.println("Insert records");
			String sql="Insert into ticket values('TK01','Raashi','7894561230','BLR','PTN','12/11/2022','FL01','11:00 AM','Done','Reserved')";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 
	}

}
