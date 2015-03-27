import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	public User() { }
	
	public User(String uName, String pass, String fName, String lName, String Email, Date DoB)
	{
		this.username = uName;
		this.password = pass;
		this.firstName = fName;
		this.lastName = lName;
		this.email = Email;
		this.dateOfBirth = DoB;
		
		this.comments = new ArrayList<Comment>();
	}
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	private List<Comment> comments;
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public Date getDateOfBirth()
	{
		return this.dateOfBirth;
	}
	
	public void addComment(Comment comment)
	{
		this.comments.add(comment);
	}
	
	public List<Comment> getComments()
	{
		return this.comments;
	}
}
