package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class ApiTests {

	
	 String BASE_URL = "https://gorest.co.in/public/v2/users";
	    String TOKEN = "030d14b1c9930362197ee18863efeb0d960256e31ed6e92964f7f19fc6ef6e09";

	    @Test
	    public void createUserTest() {
	        // Request body
	        String body = "{ \"name\": \"Rani Test\", \"gender\": \"female\", \"email\": \"rani" + System.currentTimeMillis() + "@test.com\", \"status\": \"active\" }";

	        // POST request
	        Response res = given()
	                .header("Authorization", "Bearer " + TOKEN)
	                .contentType("application/json")
	                .body(body)
	            .when()
	                .post(BASE_URL)
	            .then()
	                .statusCode(201) // 201 = Created
	                .extract().response();

	        int userId = res.jsonPath().getInt("id");
	        String name = res.jsonPath().getString("name");

	        System.out.println("✅ Created User ID: " + userId);
	        System.out.println("✅ Created User Name: " + name);

	        // Assertion
	        Assert.assertEquals(name, "Rani Test");
	    }

	    @Test
	    public void getUsersTest() {
	        Response res = given()
	                .header("Authorization", "Bearer " + TOKEN)
	            .when()
	                .get(BASE_URL)
	            .then()
	                .statusCode(200) // 200 = Success
	                .extract().response();

	        System.out.println("✅ Users Response: " + res.asPrettyString());
	        Assert.assertTrue(res.asString().contains("id"));
	    }
	    
}
