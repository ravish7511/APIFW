package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateUser;
import pojo.CreateUserResponse;
import utils.Payload;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class Steps1 {
	RequestSpecification req;
	Response response;
	CreateUserResponse cu;

	@Given("user has CreateUser Api")
	public void user_has_create_user_api() {

		RestAssured.baseURI = "https://reqres.in";
		req = given().log().all().header("Content-Type", "application/json").body(new Payload().createUserPayload());
	}

	@When("user calls Create Api with Post Http request")
	public void user_calls_create_api_with_post_http_request() {
		// response = req.when().post("/api/users").then().extract().response();
		cu = req.when().post("/api/users").as(CreateUserResponse.class, ObjectMapperType.GSON);
		System.out.println(cu.getId());
		System.out.println(cu.getName());

	}

	@Then("user should be created successfully")
	public void user_should_be_created_successfully() {
		// Assert.assertEquals(201, response.getStatusCode());
		// System.out.println(response.asString());

		String JOb = cu.getJob();
		System.out.println(JOb);

	}

}
