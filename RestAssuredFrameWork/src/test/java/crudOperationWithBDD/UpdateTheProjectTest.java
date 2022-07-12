package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateTheProjectTest 
{
	@Test
public void UpdateTheProjectTest()
{
		baseURI="http://localhost";
		port = 8084;
		
		
		//Step 1 : Create Required data
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Yatish");
		jobj.put("projectName", "withBDDne");
		jobj.put("status", "OnGoing");
		jobj.put("teamSize", 20);
		
		//Step 2 : Send the request
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/TY_PROJ_414")
		.then().
		assertThat()
		.statusCode(200)
		.log().all();
}
}
