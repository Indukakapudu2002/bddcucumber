package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;

public class LoginSteps {

    private Response response;
    String baseUri;
    String invalidCredentials;

    @Given("user provides invalid credentials")
    public void user_provides_invalid_credentials() {
         baseUri = "https://qwikcafedev.fc.qwikcilver.com";
         invalidCredentials = "{ \"user_email\": \"invalidUser\", \"user_password\": \"invalidPass\" }";
    }

    @When("the user makes a POST request to the login endpoint")
    public void the_user_makes_a_post_request_to_the_login_endpoint() {
        String loginPath = "/api/admin/api-login";
        response = RestAssured.given()
                .baseUri(baseUri)
                .contentType("application/json")
                .body(invalidCredentials)
                .when()
                .post(loginPath);
    }

    @Then("the user should receive an error message")
    public void the_user_should_receive_an_error_message() {
        response.then().statusCode(200);
        String errorMessage = response.jsonPath().getString("msg");
        assertEquals("Invalid access", errorMessage);
        String expire = response.jsonPath().getString("expire");
        assertEquals("true", expire);
    }
}
