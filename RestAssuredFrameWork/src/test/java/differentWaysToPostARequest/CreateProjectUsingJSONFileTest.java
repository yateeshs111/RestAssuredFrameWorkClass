package differentWaysToPostARequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONFileTest 
{
	@Test
public void createPTest()
{
		baseURI = "http://localhost";
		
		port = 8084;
		
	//Step 1 : Create required data
		
		File file = new File(".\\JSONTestData\\jsondata.json");
		
		//Step 2 : Send the request and validate
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
}
}
