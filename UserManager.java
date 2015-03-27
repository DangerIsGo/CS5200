import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class UserManager {
	
	public static void CreateUser(User newUser)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("insert into User values ('{0}', '{1}', '{2}', '{3}', '{4}', '{5}')", 
					newUser.getUsername(), newUser.getPassword(), 
					newUser.getFirstName(), newUser.getLastName(), 
					newUser.getEmail(), newUser.getDateOfBirth());
			
			statement.executeQuery(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static List<User> readAllUsers()
	{
		Connection conn = null;
		List<User> users = new ArrayList<User>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from User");
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				User newUsr = new User(results.getString("username"), results.getString("password"), 
						results.getString("firstName"), results.getString("lastName"), 
						results.getString("email"), results.getDate("dateOfBirth"));
				users.add(newUsr);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	public static User readUser(String username)
	{
		User user = new User();		
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from User where username = '{0}'", username);
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next())
			{
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setFirstName(result.getString("firstName"));
				user.setLastName(result.getString("lastName"));
				user.setEmail(result.getString("email"));
				user.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public static void updateUser(String username, User user)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("update User set (username = '{0}', password = '{1}',"+
			" firstName = '{2}', lastName = '{3}', email = '{4}', dateOfBirth = '{5}') where username='{6}'", 
					user.getUsername(), user.getPassword(), 
					user.getFirstName(), user.getLastName(), 
					user.getEmail(), user.getDateOfBirth(), username);
			
			statement.executeQuery(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteUser(String username)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("delete from User where username='{0}'", username);
			
			statement.executeQuery(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
