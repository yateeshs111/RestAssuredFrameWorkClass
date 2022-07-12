package authentication;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test 
{
@Test
public void oauth2Test()
{
	baseURI = "http://coop.apps.symfonycasts.com";
	
	//Step 1 : Create a post request with client id and client secret
	Response response = given()
	.formParam("client_id", "TimeC Application")
	.formParam("client_secret", "5017747c3372985787c7e4e3ea390f68")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://timec.com")
	.formParam("code", "authorization_code")
	.when()
	.post("/token");
	
	
	//Step 2: capture the access token in response
	String token = response.jsonPath().get("access_token");
	Reporter.log(token,true);
	
	//Step 3 : use that access token to access any of the APIs
	given()
	.auth()
	.oauth2(token)
	.pathParam("USER_ID", 3531)
	.when()
	.post("/api/{USER_ID}/chickens-feed")
	.then().log().all();
	
}
	
	
	
	
}

