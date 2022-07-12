package serializationAndSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoForSerializationAndDeSerialization.EmpDetailsArray;
import pojoForSerializationAndDeSerialization.Empdetails;

public class SerializationEmpDetails 
{

	public static void main(String[] args) throws Exception 
	{
		// Step 1 : create Object for Pojo class and Initialise
		Empdetails emp = new Empdetails("Yateesh", "123@gmail.com", null, 123456, "SR QA");

		//Step 2 : create object for Object mapper class
		ObjectMapper obj = new ObjectMapper();
		
		//Step 3 : From Object mapper call the method WriteValue()
		obj.writeValue(new File("./EmpdetailsArray.json"), emp);
	}

}
