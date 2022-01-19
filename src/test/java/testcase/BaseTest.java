package testcase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {


	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI="http://localhost:9090";
		RestAssured.basePath="/api/users/";
		
		// new code
		
	}
}
