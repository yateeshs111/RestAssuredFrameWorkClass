package crudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest 
{
	@Test
public void getSingleProject()
{
		baseURI="http://localhost";
		port = 8084;
		
		when()
		.get("/projects/TY_PROJ_807")
		.then()
		.log().all();	
}
}
