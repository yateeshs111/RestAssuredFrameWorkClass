package serializationAndSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.EmpDetailsArray;
import pojoForSerializationAndDeSerialization.Empdetails;

public class SerialisationEmpDetailsInArray 
{

	public static void main(String[] args) throws IOException, JsonMappingException, IOException 
	{
		// Step 1 : create Object for Pojo class and Initialise
				int []ar = {1234,7895};
				EmpDetailsArray empa= new EmpDetailsArray ("Yati","ty123", "78@gmail.com", ar, "QA");

				//Step 2 : create object for Object mapper class
				ObjectMapper obja = new ObjectMapper();
				
				//Step 3 : From Object mapper call the method WriteValue()
				obja.writeValue(new File("./EmpdetailsArray.json"), empa);
	}

}
