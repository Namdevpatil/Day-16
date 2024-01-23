package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.SQLException;

public class Example1 {

	public static void main(String[] args) throws SQLException
	{	
		
		Connection connection = null;
		
		try 
		{
			connection = JDBCConnection.getDatabaseConnection();
			
			if(connection != null)
			{
				System.out.println("Connection success.");
			}
			else
			{
				throw new SQLException("unbale to connect");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			connection.close();
		}

	}

}
