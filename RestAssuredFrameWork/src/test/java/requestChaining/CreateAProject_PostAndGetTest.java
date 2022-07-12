package requestChaining;



import static io.restassured.RestAssured.*;
import  io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import projectLibrary.ProjectLibrary;


import java.util.Random;

import org.testng.annotations.Test;

public class CreateAProject_PostAndGetTest 
{
	@Test
	public void createAProject_PostAndGet()
	{
		baseURI = "http://localhost";
		port = 8084;

		Random ran = new Random();
		int random=ran.nextInt(200);
		System.out.println("Random number is "+random);
		//Step 1 : Create the data by Create object of projectlibrary class
		ProjectLibrary plib = new ProjectLibrary("Yateesh", "apple123-"+random, "Completed", 50);


		//Step 2 : Send the request and validate
		  Response response = given().body(plib).contentType(ContentType.JSON)
		.when().post("/addProject");
		
	String pid = response.jsonPath().get("projectId");
	System.out.println(pid);


		//Step 1 : create a post request and capture the response
		//Step 2: using JSON path, retrieve project id from the response
		//Step 3 : use this project id for another request


	given().pathParam("proID", pid)
		.when()
		.get("/projects/{proID}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().
		all();
	}

}
