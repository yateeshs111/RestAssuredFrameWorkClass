package crudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
@Test
public void getAllProjectsTest()
{
	baseURI="http://localhost";
	port = 8084;
	
	when()
	.get("/projects")
	.then()
	.log().all();	
}
}
