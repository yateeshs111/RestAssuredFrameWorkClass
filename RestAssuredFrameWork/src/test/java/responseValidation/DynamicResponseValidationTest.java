package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.response.Response.*;

public class DynamicResponseValidationTest 
{
	@Test
	public void staticResponseTest()
	{

		baseURI = "http://localhost";
		port = 8084;

		String expectedData ="TY_PROJ_002";

		//Step 2 : Send the request and validate

		Response response = when().get("/projects");

		//Validate the response

		boolean flag = false;
		List<String> list = response.jsonPath().get("projectId");
		for (String p : list) 
		{
			if (p.equalsIgnoreCase(expectedData)) 
			{
				flag=true;//flag rising
				break;
			}
		}

		Assert.assertTrue(flag);
		response.then().log().all();



	}
}
