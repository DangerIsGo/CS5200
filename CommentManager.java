import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CommentManager {
	
	public void CreateComment(Comment newComment)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("insert into Comment values ('{0}', '{1}', '{2}', '{3}', '{4}')", newComment.getCommentId(),
					newComment.getComment(), newComment.getDate(), newComment.getUser().getUsername(), newComment.getMovie().getId());
			
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
	
	public List<Comment> readAllComments()
	{
		Connection conn = null;
		List<Comment> comments = new ArrayList<Comment>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Comment");
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Comment newComment = new Comment(results.getString("commentId"), results.getString("comment"), results.getDate("date"),
						results.getString("username"), results.getString("movieId"));
				comments.add(newComment);
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
		
		return comments;
	}
	
	public List<Comment> readAllCommentsForUsername(String username)
	{
		Connection conn = null;
		List<Comment> comments = new ArrayList<Comment>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Comment where username='{0}", username);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Comment newComment = new Comment(results.getString("commentId"), results.getString("comment"), results.getDate("date"), 
						results.getString("username"), results.getString("movieId"));
				comments.add(newComment);
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
		
		return comments;
	}
	
	public List<Comment> readAllCommentsForMovie(String movieId)
	{
		Connection conn = null;
		List<Comment> comments = new ArrayList<Comment>();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Comment where movieId='{0}", movieId);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				Comment newComment = new Comment(results.getString("commentId"), results.getString("comment"), results.getDate("date"), 
						results.getString("username"), results.getString("movieId"));
				comments.add(newComment);
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
		
		return comments;
	}
	
	public Comment readCommentForId(String commentId)
	{
		Connection conn = null;
		Comment comment = new Comment();
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("select * from Comment where commentId='{0}", commentId);
			
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				comment = new Comment(results.getString("commentId"), results.getString("comment"), results.getDate("date"), 
						results.getString("username"), results.getString("movieId"));
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
		
		return comment;
	}
	
	public static void updateComment(String commentId, String newComment)
	{
		Connection conn = null;
		
		try
		{
			String url = "";
			conn = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = conn.createStatement();
			
			String sql = String.format("update Comment set (comment = '{0}') where commentId='{1}'", 
					newComment, commentId);
			
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
