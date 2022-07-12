package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest 
{
	@Test
	public void getAllProjectsTest()
	{
		//Step 1: Create the required data
		
		// Step 2 : Send the Request
		
		Response resp2 = RestAssured.get("http://localhost:8084/projects");
		
		//Step 3 : Validate the response
		ValidatableResponse validate2 = resp2.then();
		
		validate2.log().all();
//		validate2.assertThat().statusCode(200);
		
	}
}
