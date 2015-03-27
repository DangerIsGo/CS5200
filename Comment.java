import java.util.Date;


public class Comment {
	public Comment() { }
	
	public Comment(String commentId, String comment, Date date, String username, String movieId)
	{
		this.commentId = commentId;
		this.comment = comment;
		this.date = date;
		
		this.user = UserManager.readUser(username);
		this.movie = MovieManager.readMovie(movieId);
	}
	
	private String commentId;
	private String comment;
	private Date date;
	
	private User user;
	private Movie movie;
	
	public String getCommentId()
	{
		return this.commentId;
	}
	
	public void setCommentId(String commentId)
	{
		this.commentId = commentId;
	}
	
	public String getComment()
	{
		return this.comment;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public User getUser()
	{
		return this.user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public Movie getMovie()
	{
		return this.movie;
	}
	
	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}
}
