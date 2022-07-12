package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DynamicValidationForProjectNameTest 
{
@Test
public void DynamicValidationForProjectNameTest()
{
	
	baseURI = "http://localhost";
	port = 8084;
	
	Random ran = new Random();
	 int random=ran.nextInt(200);
	//Step 1 : Create Required data
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Yati");
	jobj.put("projectName", "Name");
	jobj.put("status", "On Going");
	jobj.put("teamSize", 10);
	
	//Step 2 : Send the request
	
	given()
	.body(jobj)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
	
	String Expecteddata = "Name";
	
	Response respsone = when().get("/projects");
	
	boolean flag = false;
	List<String> list = respsone.jsonPath().get("projectName");
	
	
	for (String p : list) 
	{
	if (p.equalsIgnoreCase(Expecteddata)) 
	{
		flag=true;//flag rising
		break;
	}	
	}
	Assert.assertTrue(flag);
	
}
}