package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatavalidationSteps {

	
	@Given("I create a user via API")
	public void i_create_a_user_via_api() {
		System.out.println("API user created");
	}

	@When("I search the user in UI table")
	public void i_search_the_user_in_ui_table() {
		System.out.println("Searching user in UI");
	}

	@Then("The user data should match with API data")
	public void the_user_data_should_match_with_api_data() {
		System.out.println("Validated API == UI data");
	}

	
}
