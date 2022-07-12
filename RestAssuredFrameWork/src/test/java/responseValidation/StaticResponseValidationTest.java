package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest 
{
	@Test
	public void staticResponseTest()
	{
		baseURI = "http://localhost";
		port = 8084;

		String expectedData ="TY_PROJ_002";
		

		//Step 2 : Send the request and validate

		Response response = when().get("/projects");

		String actualData = response.jsonPath().get("[0].projectId");

		Assert.assertEquals(actualData, expectedData);

		response.then().log().all();

	}
}
