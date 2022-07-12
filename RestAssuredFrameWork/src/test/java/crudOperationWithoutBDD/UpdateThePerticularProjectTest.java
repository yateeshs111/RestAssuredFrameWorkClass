package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateThePerticularProjectTest 
{
@Test
	public void updateThePerticularProjectTest()
	{
	//Step 1 : Create Required data
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Yateesh123");
			jobj.put("projectName", "TYSS123");
			jobj.put("status", "On Going");
			jobj.put("teamSize", 20);
			
			
			//Step 2 : Send the request
			RequestSpecification req = RestAssured.given();
			req.body(jobj);
			req.contentType(ContentType.JSON);
			Response resp = req.put("http://localhost:8084/projects/TY_PROJ_808");
			
			//Step 3 : Validate the Response
			
			System.out.println(resp.prettyPeek());
			System.out.println(resp.getStatusCode());
			System.out.println(resp.getTime());
			
			ValidatableResponse validate = resp.then();
			validate.log().all();	
			
			
	}
}
