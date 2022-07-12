package serializationAndSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.EmpDetailsArray;
import pojoForSerializationAndDeSerialization.Empdetails;

public class DeSerialisationEmpDetailsInArray 
{

	public static void main(String[] args) throws IOException, JsonMappingException, IOException 
	{
		// Step 1 : Create Object for ObjectMapper
				ObjectMapper obja = new ObjectMapper();

				//Step 2 :  Call the ReadValue method() and store it in the variable
				EmpDetailsArray e2=obja.readValue(new File(".\\EmpdetailsArray.json"), EmpDetailsArray.class);

				//Step 3 : Use getters and Setters access the variables
				System.out.println(e2.getDesignation());
				System.out.println(e2.getEmail());
				System.out.println(e2.getPhono()[1]);
	}

}
