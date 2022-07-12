package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
@Test	
 public void createProjectTest()
 {
	//Step 1 : Create Required data
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Yateesh");
			jobj.put("projectName", "withBDD");
			jobj.put("status", "Created");
			jobj.put("teamSize", 20);
			
			//Step 2 : Send the request
			
			given()
			.body(jobj)
			.contentType(ContentType.JSON)
			.when()
			.post("http://localhost:8084/addProject")
			.then().
			assertThat()
			.statusCode(201)
			.log().all();
			
 }
}
