package serializationAndSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.Children;
import pojoForSerializationAndDeSerialization.EmpDetailsArrayWithObject;

public class SerialisationEmpDetailsInArrayWithObject {

	public static void main(String[] args) throws IOException, JsonMappingException, IOException 
	{
		int[]arr= {789,456};
		Children chd = new Children("abcd", 5985, "145@gmail.com");
		EmpDetailsArrayWithObject empAO = new EmpDetailsArrayWithObject("rakesh", "ty456", "562@gmail.com", arr, "sr Test", chd);

		ObjectMapper objAO = new ObjectMapper();
		
		objAO.writeValue(new File("./EmpdetailsArrayWithObject.json"), empAO);
	}

}
