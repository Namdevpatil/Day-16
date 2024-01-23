package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example3 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		Product product = new Product();
		product.setProductId(456);
		product.setProductName("Iphone 15");
		product.setProductPrice(189884.34);
			
		try 
		{
			connection = JDBCConnection.getDatabaseConnection();
			
			
			//create query statement
			String query = "insert into product(product_id, product_name, product_price) values(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getProductPrice());
			
			int status = preparedStatement.executeUpdate();
			
			if(status > 0)
			{
				System.out.println("Product saved suuccessfully in the database table.");
			}
			else
			{
				System.out.println("Unable to save Product in the database table.");		
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
