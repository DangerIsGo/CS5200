import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class MovieManager {
	
	public static void CreateMovie(Movie newMovie)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("insert into Movie values ('{0}', '{1}', '{2}', '{3}')", 
					newMovie.getId(), newMovie.getTitle(), 
					newMovie.getPosterImage(), newMovie.getReleaseDate());
			
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
	
	public static List<Movie> readAllMovies()
	{
		Connection conn = null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Movie");
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Movie newMovie = new Movie(results.getString("id"), results.getString("title"), 
						results.getString("posterImage"), results.getDate("releaseDate"));
				movies.add(newMovie);
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
		
		return movies;
	}
	
	public static Movie readMovie(String movieId)
	{
		Movie Movie = new Movie();		
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Movie where id = '{0}'", movieId);
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next())
			{
				Movie.setId(result.getString("id"));
				Movie.setTitle(result.getString("title"));
				Movie.setPosterImage(result.getString("posterImage"));
				Movie.setReleaseDate(result.getDate("releaseDate"));
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
		
		return Movie;
	}
	
	public static void updateMovie(String movieId, Movie movie)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("update Movie set (id = '{0}', title = '{1}',"+
			" posterImage = '{2}', releaseDate = '{3}') where Moviename='{4}'", 
					movie.getId(), movie.getTitle(), 
					movie.getPosterImage(), movie.getReleaseDate(), movieId);
			
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
	
	public static void deleteMovie(String movieId)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("delete from Movie where movieId='{0}'", movieId);
			
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
