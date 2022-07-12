package pojoForSerializationAndDeSerialization;

public class Empdetails 
{
	//Step 1 : declare all necessary variable as global
	String EmployeeName;
	String EmployeeId;
	String Email;
	int Phono;
	String Designation;

	//Step 2 : Create Constructor to initialize these variables

	public Empdetails(String employeeName, String employeeId, String email, int phono, String designation) 
	{

		EmployeeName = employeeName;
		EmployeeId = employeeId;
		Email = email;
		Phono = phono;
		Designation = designation;
	}

	//Create an empty constructor for deserialization
	public Empdetails() 
	{

	}


	//Step 3 : provide the getters and setters to access the variables

	public String getEmployeeName() 
	{
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) 
	{
		EmployeeName = employeeName;
	}

	public String getEmployeeId() 
	{
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) 
	{
		EmployeeId = employeeId;
	}

	public String getEmail() 
	{
		return Email;
	}

	public void setEmail(String email) 
	{
		Email = email;
	}

	public int getPhono() 
	{
		return Phono;
	}

	public void setPhono(int phono) 
	{
		this.Phono = phono;
	}

	public String getDesignation() 
	{
		return Designation;
	}

	public void setDesignation(String designation) 
	{
		Designation = designation;
	}


}

