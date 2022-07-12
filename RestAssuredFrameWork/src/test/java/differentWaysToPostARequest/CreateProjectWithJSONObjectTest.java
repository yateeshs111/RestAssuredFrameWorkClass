package differentWaysToPostARequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJSONObjectTest 
{
	@Test
	public void createProjectWithJSONObjectTest()
	{

		baseURI = "http://localhost";
		port = 8084;

		//Step 1 : Create Required data
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Yateesh");
		jobj.put("projectName", "JSONObject");
		jobj.put("status", "Created");
		jobj.put("teamSize", 20);

		//Step 2 : Send the request and validate
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("./addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();



	}
}
