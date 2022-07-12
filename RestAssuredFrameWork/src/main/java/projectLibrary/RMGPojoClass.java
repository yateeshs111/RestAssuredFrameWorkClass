package projectLibrary;

public class RMGPojoClass 
{

	String createdBy;
	String projectname;
	String status;
	int teamSize;
	
	public RMGPojoClass(String createdBy, String projectname, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectname = projectname;
		this.status = status;
		this.teamSize = teamSize;
		
		
	}

	public String getCreatedBy() 
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getProjectname() 
	{
		return projectname;
	}

	public void setProjectname(String projectname) 
	{
		this.projectname = projectname;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public int getTeamSize() 
	{
		return teamSize;
	}

	public void setTeamSize(int teamSize) 
	{
		this.teamSize = teamSize;
	}
	

}
