package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.locals_return;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarerTokenTest 
{
@Test
public void BarerTokenTest()
{
	baseURI = "https://api.github.com";
	
	JSONObject jobj = new JSONObject();
	jobj.put("name", "Yateesh Restful");
	jobj.put("description", "RestFul WebService Yateesh FrameWork");
	
	given()
	.auth()
	.oauth2("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")
	.body(jobj)
	.contentType(ContentType.JSON)
	.when().post("/user/repos")
	.then().assertThat().statusCode(201)
	.log().all();
}
}
