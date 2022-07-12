package requestChaining;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndDeleteTest 
{
@Test
public void createAndDeleteTest()
{
	Random ran = new Random();
	int random=ran.nextInt(200);
	System.out.println("Random number is "+random);
	
	
	baseURI = "http://localhost";
	port = 8084;
	
	//Step 1: create the post request and Response 
	ProjectLibrary plib = new ProjectLibrary("Yateesh", "create"+random, "On Going", 6);
	Response response = given()
	.body(plib)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject");
	
	//Step 2 : get the projectid from json path
	String pid = response.jsonPath().get("projectId");
	System.out.println("Projectid is "+pid);
	Reporter.log(pid, true);
	response.then().log().all();
	
	//Step 3 : Use this project id for validation
	given().pathParam("proid", pid)
	.when().get("/projects/{proid}")
	.then().assertThat().statusCode(200)
	.log().all();
	
	//Step 4 : use this project id for delete the project
	
	given().pathParam("projectid", pid)
	.when().delete("/projects/{projectid}")
	.then().assertThat().statusCode(204)
	
	.log().all();
	
	
	
}
}
