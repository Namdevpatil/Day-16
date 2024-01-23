package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Example7 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;		
				
		try 
		{
			
			Product product = new Product();
			
			product.setProductName("Iphone 12");
			product.setProductPrice(120922.99);
			
			product.setProductId(456);
			
			connection = JDBCConnection.getDatabaseConnection();
					
			//create query statement
			String updateQuery = "update product set product_name = '"+product.getProductName()+"', product_price = '"+product.getProductPrice()+"' where product_id = '"+product.getProductId()+"'";
			
			Statement statement = connection.createStatement();			
			
			int status = statement.executeUpdate(updateQuery);
			
			if(status > 0)
			{
				System.out.println("Product updated suuccessfully in the database table.");
			}
			else
			{
				System.out.println("Unable to update Product in the database table.");		
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
