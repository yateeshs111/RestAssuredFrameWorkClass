package crudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePerticularProject
{
@Test
public void deletePerticularProject()
{
	baseURI="http://localhost";
	port = 8084;
	
	when()
	.delete("/projects/TY_PROJ_807")
	.then()
	.assertThat().statusCode(204)
	.log().all();	
}
}
