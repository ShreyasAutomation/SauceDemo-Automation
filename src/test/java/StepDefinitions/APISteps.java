package StepDefinitions;

import PageObjects.APIImplementationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utils.CommonUtils;
import io.restassured.response.Response;

import java.io.IOException;


public class APISteps {
 //   public String apiEndpoint;
  //  public Response response;
    APIImplementationPage apipage;

    @Given("I have the API endpoint for user {string}")
    public void i_have_the_api_endpoint_for_user(String userId) {
      //  apiEndpoint = "https://jsonplaceholder.typicode.com/users/" + userId;
        apipage = new APIImplementationPage();
    }

    @When("I send a GET request to the API for user {string}")
    public void i_send_a_get_request_to_the_api(String userId) {
        apipage = new APIImplementationPage();
        apipage.sendGetRequest(userId); // Call the page method to send request
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        apipage.validateResponseStatusCode(expectedStatusCode); // Validate status code
    }

    @Then("the response body should contain the user information")
    public void the_response_body_should_contain_the_user_information() {
        apipage.validateUserInformation(); // Validate the response body
    }

    @When("I send a GET request to the API")
    public void iSendAGETRequestToTheAPI() {
        apipage = new APIImplementationPage();
        apipage.SendGetRequest();
    }

    @Then("verify total records in the response body")
    public void verifyTotalRecordsInTheResponseBody() {
        apipage.verifyTotalRecordsInTheResponseBody();
    }

    @When("I send a POST request to the API with request body from file {string}")
    public void iSendAPOSTRequestToTheAPI(String filename) throws IOException {
        String jsonBody = CommonUtils.readJsonFile("src/test/resources/" + filename);
        apipage = new APIImplementationPage();
        apipage.iSendAPOSTRequestToTheAPI(jsonBody);
    }
}
