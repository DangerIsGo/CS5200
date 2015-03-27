import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
	public Movie() { }
	
	public Movie(String id, String title, String poster, Date release)
	{
		this.id = id;
		this.title = title;
		this.posterImage = poster;
		this.releaseDate = release;
		
		this.comments = new ArrayList<Comment>();
		this.cast = new ArrayList<Cast>();
	}
	
	private String id;
	private String title;
	private String posterImage;
	private Date releaseDate;
	
	private List<Comment> comments;
	private List<Cast> cast;
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setPosterImage(String posterImage)
	{
		this.posterImage = posterImage;
	}
	
	public String getPosterImage()
	{
		return this.posterImage;
	}
	
	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	
	public Date getReleaseDate()
	{
		return this.releaseDate;
	}
	
	public void addComment(Comment comment)
	{
		this.comments.add(comment);
	}
	
	public List<Comment> getComments()
	{
		return this.comments;
	}
	
	public void addCastRole(Cast cast)
	{
		this.cast.add(cast);
	}
	
	public List<Cast> getCastList()
	{
		return this.cast;
	}
}
