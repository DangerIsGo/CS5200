
public class Cast {
	public Cast() { }
	
	public Cast(String castId, String charName, String actorId, String movieId)
	{
		this.castId = castId;
		this.characterName = charName;
		
		this.actor = ActorManager.readActor(actorId);
		
		this.movie = MovieManager.readMovie(movieId);
	}
	
	private String castId;
	private String characterName;
	
	private Actor actor;
	
	private Movie movie;
	
	public void setId(String castId)
	{
		this.castId = castId;
	}
	
	public String getId()
	{
		return this.castId;
	}
	
	public void setCharacter(String character)
	{
		this.characterName = character;
	}
	
	public String getCharacter()
	{
		return this.characterName;
	}
	
	public void setActor(Actor actor)
	{
		this.actor = actor;
	}
	
	public Actor getActor()
	{
		return this.actor;
	}
	
	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}
	
	public Movie getMovie()
	{
		return this.movie;
	}
}
