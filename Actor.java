import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Actor {
	public Actor() { }
	
	public Actor(String id, String fName, String lName, Date string)
	{
		this.id = id;
		this.firstName = fName;
		this.lastName = lName;
		this.dateOfBirth = string;
		
		roles = new ArrayList<Cast>();
	}
	
	private String id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	private List<Cast> roles;
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setFirstName(String fName)
	{
		this.firstName = fName;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setLastName(String lName)
	{
		this.lastName = lName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setDateOfBirth(Date DoB)
	{
		this.dateOfBirth = DoB;
	}
	
	public Date getDateOfBirth()
	{
		return this.dateOfBirth;
	}
	
	public void addToRoles(Cast cast)
	{
		this.roles.add(cast);
	}
	
	public List<Cast> getRoles()
	{
		return this.roles;
	}
}
