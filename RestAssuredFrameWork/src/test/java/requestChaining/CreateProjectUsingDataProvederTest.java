package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUsingDataProvederTest 
{

	@DataProvider(name="DataForPost")
	public Object[][] dataTest()
	{
		
		Random ran = new Random();
		int random=ran.nextInt(200);
		Object [][] data = new Object[5][4];
		
		data[0][0]="Yateesh" ;
		data[0][1]=" Tyss"+random;
		data[0][2] ="created"	;
		data[0][3] =    10    ;		
		
		data[1][0]=" Rahul " ;
		data[1][1]=" infosys"+random;
		data[1][2] ="On Going "	;
		data[1][3] =   5     ;	
		
		data[2][0]=" Vadiraj  " ;
		data[2][1]="Apple "+random;
		data[2][2] ="Completed "	;
		data[2][3] =    12    ;	
		
		data[3][0]=" Rakesh " ;
		data[3][1]=" goole"+random;
		data[3][2] =" On Going"	;
		data[3][3] =    4    ;	
		
		data[4][0]=" Madhu " ;
		data[4][1]=" Amdocs "+random;
		data[4][2] ="Completed ";
		data[4][3] =   5     ;
				
				return data;
	}
	@Test(dataProvider = "DataForPost")
	public void usingDataProviderTest(String createdBy, String projectName, String status, int teamSize )
	{
			JSONObject js = new JSONObject()	;
			js.put("createdBy", createdBy);
			js.put("projectName", projectName);
			js.put("status", status);
			js.put("teamSize", teamSize);
			
			baseURI = "http://localhost";
			port = 8084;
			
			given().body(js)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
			.assertThat().statusCode(201).log()
			.all();
			
				
				
				
	}
}

