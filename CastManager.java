import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CastManager {
	
	public void createCast(Cast newCast)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("insert into Cast values ('{0}', '{1}', '{2}')", newCast.getCharacter(),
					newCast.getActor().getId(), newCast.getMovie().getId());
			
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
	
	public List<Cast> readAllCast()
	{
		Connection conn = null;
		List<Cast> casts = new ArrayList<Cast>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Cast");
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Cast newCast = new Cast(results.getString("castId"), results.getString("character"), 
						results.getString("actorId"), results.getString("movieId"));
				casts.add(newCast);
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
		
		return casts;
	}
	
	public List<Cast> readAllCastForActor(String actorId)
	{
		Connection conn = null;
		List<Cast> casts = new ArrayList<Cast>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Cast where actorId='{0}", actorId);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Cast newCast = new Cast(results.getString("castId"), results.getString("character"),
						results.getString("actorId"), results.getString("movieId"));
				casts.add(newCast);
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
		
		return casts;
	}
	
	public List<Cast> readAllCastForMovie(String movieId)
	{
		Connection conn = null;
		List<Cast> casts = new ArrayList<Cast>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Comment where movieId='{0}", movieId);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Cast newCast = new Cast(results.getString("castId"), results.getString("character"),  
						results.getString("actorId"), results.getString("movieId"));
				casts.add(newCast);
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
		
		return casts;
	}
	
	public Cast readCastForId(String castId)
	{
		Connection conn = null;
		Cast cast = new Cast();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Cast where castId='{0}", castId);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				cast = new Cast(results.getString("castId"), results.getString("character"), 
						results.getString("actorId"), results.getString("movieId"));
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
		
		return cast;
	}
	
	public static void updateCast(String castId, Cast newCast)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("update Cast set (castId = '{0}', character = '{1}', actorId = '{2}', movieId = '{3}') where commentId='{4}'", 
					newCast.getId(), newCast.getCharacter(), newCast.getActor().getId(), newCast.getMovie().getId(), castId);
			
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
	
	public static void deleteComment(String commentId)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("delete from Comment where commentId='{0}'", commentId);
			
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
