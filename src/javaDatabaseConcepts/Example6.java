package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Example6 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
				
		try 
		{
			
			Product product = new Product();
			product.setProductId(456);
			
			connection = JDBCConnection.getDatabaseConnection();
					
			//create query statement
			
			
			//String query = "insert into product(product_id, product_name, product_price) values('"+product.getProductId()+"', '"+product.getProductName()+"', '"+product.getProductPrice()+"')";
			
			String deleteQuery = "delete from product where product_id = '"+product.getProductId()+"'";
			
			Statement statement = connection.createStatement();
			
			int status = statement.executeUpdate(deleteQuery);
			
			if(status > 0)
			{
				System.out.println("Product deleted suuccessfully in the database table.");
			}
			else
			{
				System.out.println("Unable to delete Product in the database table.");		
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
