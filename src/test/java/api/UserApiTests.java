package api;

import org.testng.annotations.Test;

import io.restassured.response.Response;   
import static io.restassured.RestAssured.*;

public class UserApiTests {

	
	 String BASE_URL = "https://gorest.co.in/public/v2/users";
	    String TOKEN = "030d14b1c9930362197ee18863efeb0d960256e31ed6e92964f7f19fc6ef6e09";

	    @Test
	    public void createUserTest() {
	        String body = "{\"name\":\"Rani\",\"gender\":\"female\",\"email\":\"rani123@test.com\",\"status\":\"active\"}";

	        Response res = given()
	            .header("Authorization", "Bearer " + TOKEN)
	            .contentType("application/json")
	            .body(body)
	        .when()
	            .post(BASE_URL)
	        .then()
	            .statusCode(201)
	            .extract().response();

	        System.out.println("Created User ID: " + res.jsonPath().getInt("id"));
	    }
	    
}
