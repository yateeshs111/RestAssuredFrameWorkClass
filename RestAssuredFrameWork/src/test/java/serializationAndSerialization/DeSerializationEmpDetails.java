package serializationAndSerialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.Empdetails;

public class DeSerializationEmpDetails 
{

	public static void main(String[] args) throws Exception 
	{
		// Step 1 : Create Object for ObjectMapper
		ObjectMapper obj = new ObjectMapper();

		//Step 2 :  Call the ReadValue method() and store it in the variable
		Empdetails e1=obj.readValue(new File(".\\Empdetails.json"), Empdetails.class);

		//Step 3 : Use getters and Setters access the variables
		System.out.println(e1.getDesignation());
		System.out.println(e1.getEmail());
	}

}
