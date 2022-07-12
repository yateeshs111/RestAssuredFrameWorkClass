package differentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import static org.testng.annotations.Test.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

public class CreateProjectUsingPojoClassTest 
{
	
	@Test
	public void createproject()
	{

		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		 int random=ran.nextInt(200);
		//Step 1 : Create the data by Create object of projectlibrary class
		ProjectLibrary plib = new ProjectLibrary("Yateesh08"+random, "abcd-"+random, "On Going", 20+random);
		
		
		//Step 2 : Send the request and validate
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all();
		
		
	}
	
	
}
