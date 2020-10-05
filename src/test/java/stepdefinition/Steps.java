package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import static io.restassured.RestAssured.*;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.Payload;
import utils.Utils;

public class Steps extends Utils {
	RequestSpecification request;
	String book_id;

	Response response;

	@Given("user has AddBook Api's'")
	public void user_has_add_book_api_s() throws IOException {

		request = given().spec(requestSpecification()).body(new Payload().addBookPayLoad());

	}

	@When("user calls AddBook Api with POST http request")
	public void user_calls_add_book_api_with_post_http_request() {
		response = request.when().post("/Library/Addbook.php").then().spec(responseSpecification()).extract()
				.response();
	
	}

	@Then("book is added successfully with status code {int}")
	public void book_is_added_successfully_with_status_code(Integer int1) {
		assertEquals(200, response.getStatusCode());
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String actual, String expected) {
		String act = getJSonPath(response, actual);
		System.out.println(act);
		String id = getJSonPath(response, "ID");
		System.out.println(id);
		assertEquals(expected, act);

	}



}
