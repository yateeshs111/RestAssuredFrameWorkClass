
package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeletePerticularProjectTest 
{
	@Test
	public void deletePerticularProjectTest()
	{
		//Step 1: Create the required data

				// Step 2 : Send the Request

				Response resp3 = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_806");

				//Step 3 : Validate the response
				ValidatableResponse validate3 = resp3.then();
				validate3.log().all();	
				validate3.assertThat().statusCode(204);
	}
}
