package rough;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstTestcase {


	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/api/users/";
	}
	@Ignore
	@Title("Sending get request test")
	@Test
	public void testGetRequest() {
	
		Response response = SerenityRest.given().when().get("4");
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("firstName", Matchers.equalTo("Chris"));
		
	}
	@Title("Sending post request test")
	@Test
	public void testPostRequest() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("email", "mehul@email.com");
		map.put("firstName", "Mehul");
		map.put("lastName", "Kumar");
		Response response = SerenityRest.given().contentType(ContentType.JSON)
				.body(map).log().all().post();
        response.prettyPrint();
       System.out.println(response.getStatusCode());
	}
}
