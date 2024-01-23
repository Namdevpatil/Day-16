package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Example2 {

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		Product product = new Product();
		product.setProductId(112);
		product.setProductName("OPPO A9");
		product.setProductPrice(9884.34);
			
		try 
		{
			connection = JDBCConnection.getDatabaseConnection();
			
			
			//create query statement
			String query = "insert into product(product_id, product_name, product_price) values('"+product.getProductId()+"', '"+product.getProductName()+"', '"+product.getProductPrice()+"')";
			
			Statement statement = connection.createStatement();
			
			int status = statement.executeUpdate(query);
			
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
