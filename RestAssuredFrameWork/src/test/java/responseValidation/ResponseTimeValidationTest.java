package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationTest 
{
	@Test
	public void responseTimeValidationTest()
	{
		baseURI = "http://localhost";
		port = 8084;

		Response response = when().get("/projects");

		//Hamcrest matchers - Tool which helps to validate the response TIME
		//Hamcrest matchers has a class called Matchers which has method like
		//lessthan().greaterthan()  etc
		// We have to give values like 500, it should be in long(L). it is mandatory

		response.then().assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
		response.then().log().all();



	}
}
