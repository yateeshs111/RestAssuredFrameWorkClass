package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;



public class CreateAProject_PostAndGet 
{
	@Test
	public void createAProject_PostAndGet()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary plib = new ProjectLibrary("Yateesh101", "qwerty", "On Going", 30);


		//Step 2 : Send the request and validate
		Response response = given()
				.body(plib)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");	

		String pid = response.jsonPath().get("projectId");
		System.out.println(pid);


		//Step 1 : create a post request and capture the response
		//Step 2: using JSON path, retrieve project id from the response
		//Step 3 : use this project id for another request


		given().pathParam("prijectID", pid)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().
		all();
		
		
	}
}
