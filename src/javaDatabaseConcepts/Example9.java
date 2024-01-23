package javaDatabaseConcepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Example9 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		Product product = new Product();
		
			
		try 
		{
			connection = JDBCConnection.getDatabaseConnection();
			
			connection.setAutoCommit(false);		
			
			
			//create query statement
			String query = "insert into product(product_id, product_name, product_price) values(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			Scanner scanner = new Scanner(System.in);
			
			
			while(true)
			{
				
				System.out.println("enter product id: ");
				int id = scanner.nextInt();
				product.setProductId(id);
				
				scanner.nextLine();
				
				System.out.println("enter product name: ");
				String name = scanner.nextLine();
				product.setProductName(name);
				
				System.out.println("enter product price: ");
				double price = scanner.nextDouble();
				product.setProductPrice(price);
				
				preparedStatement.setInt(1, product.getProductId());
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setDouble(3, product.getProductPrice());
				
				preparedStatement.executeUpdate();
				
				System.out.println("enter commit/rollback");
				String input = scanner.next().toLowerCase();
				
				if(input.equals("commit"))
				{
					connection.commit();
				}
				
				if(input.equals("rollback"))
				{
					connection.rollback();
				}
				
				System.out.println("want to enter another product..? yes/no");
				String data = scanner.next().toLowerCase();
				
				if(data.equals("no"))
				{
					break;
				}
				
				
			}
			
			connection.commit();
			
			scanner.close();
					
			System.out.println("Product Saved in the Database table.");		
			
			connection.close();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
