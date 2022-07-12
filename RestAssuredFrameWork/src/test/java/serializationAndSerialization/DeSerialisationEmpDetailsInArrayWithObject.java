package serializationAndSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.EmpDetailsArray;
import pojoForSerializationAndDeSerialization.EmpDetailsArrayWithObject;

public class DeSerialisationEmpDetailsInArrayWithObject 
{

	public static void main(String[] args) throws IOException, IOException, IOException 
	{
		// Step 1 : Create Object for ObjectMapper
		ObjectMapper objAO = new ObjectMapper();

		//Step 2 :  Call the ReadValue method() and store it in the variable
		EmpDetailsArrayWithObject e3=objAO.readValue(new File(".\\EmpdetailsArrayWithObject.json"), EmpDetailsArrayWithObject.class);

		//Step 3 : Use getters and Setters access the variables
		System.out.println(e3.getDesignation());
		System.out.println(e3.getEmail());
		System.out.println(e3.getPhono()[1]);
		System.out.println(e3.getChildren());
		
		
	}

}
