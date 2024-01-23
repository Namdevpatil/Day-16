package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example5 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try 
		{
			connection = JDBCConnection.getDatabaseConnection();
			
			
			//create query statement
			String query = "select product_name, product_price from product";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();		
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getDouble(2));
				System.out.println("==================================================");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//step-3: Database connection closed.
			connection.close();
		}
		
	}

}
