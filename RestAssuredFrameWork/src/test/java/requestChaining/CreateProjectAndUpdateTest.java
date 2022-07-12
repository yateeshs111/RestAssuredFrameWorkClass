package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndUpdateTest 
{
	@Test
	public void createProjectAndUpdateTest()
	{
		Random ran = new Random();
		int random=ran.nextInt(200);
		System.out.println("Random number is "+random);
		
		
		baseURI = "http://localhost";
		port = 8084;
		ProjectLibrary plib = new ProjectLibrary("Yateesh", "create"+random, "On Going", 6);
		
		Response response = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		String pid = response.jsonPath().get("projectId");
		System.out.println("Projectid is "+pid);
		
		
		given().pathParam("proid", pid)
		.get("/projects/{proid}")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
		ProjectLibrary plibUpdate1 = new ProjectLibrary("YateeshUpdate", "CreateAndUpdate", "Completed", 10);
		
		given()	.body(plibUpdate1)
		.contentType(ContentType.JSON)
		.pathParam("proid", pid)
		.when()
		.put("/projects/{proid}")
		.then().assertThat()
		.statusCode(200)
		.log().all();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
