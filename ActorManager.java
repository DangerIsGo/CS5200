import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class ActorManager {
	
	public static void CreateActor(Actor newActor)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("insert into Actor values ('{0}', '{1}', '{2}', '{3}')", 
					newActor.getId(), newActor.getFirstName(), 
					newActor.getLastName(), newActor.getDateOfBirth());
			
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
	
	public static List<Actor> readAllActors()
	{
		Connection conn = null;
		List<Actor> actors = new ArrayList<Actor>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Actor");
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Actor newUsr = new Actor(results.getString("id"), results.getString("firstName"), 
						results.getString("lastName"), results.getDate("dateOfBirth"));
				actors.add(newUsr);
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
		
		return actors;
	}
	
	public static Actor readActor(String actorId)
	{
		Actor actor = new Actor();		
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Actor where actorId = '{0}'", actorId);
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next())
			{
				actor.setId(result.getString("id"));
				actor.setFirstName(result.getString("firstName"));
				actor.setLastName(result.getString("lastName"));
				actor.setDateOfBirth(result.getDate("dateOfBirth"));
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
		
		return actor;
	}
	
	public static void updateActor(String actorId, Actor Actor)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("update Actor set (actorId = '{0}', firstName = '{1}',"+
			" lastName = '{2}', dateOfBirth = '{3}') where actorId='{4}'", 
					Actor.getId(), 
					Actor.getFirstName(), Actor.getLastName(), 
					Actor.getDateOfBirth(), actorId);
			
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
	
	public static void deleteActor(String actorId)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("delete from Actor where actorId='{0}'", actorId);
			
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
