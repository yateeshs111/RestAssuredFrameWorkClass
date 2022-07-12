package differentWaysToPostARequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMapTest 
{
@Test
public void CreateP()
{
	baseURI = "http://localhost";
	port = 8084;
	//Step 1 : create data
	HashMap map = new HashMap();
	map.put("createdBy", "Maps");
	map.put("projectName", "withBDDMaps");
	map.put("status", "Created");
	map.put("teamSize", 300);
	
	//Step 2 : Send the request and validate
	
	given()
	.body(map)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	
	
}
}
