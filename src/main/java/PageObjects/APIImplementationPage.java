package PageObjects;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class APIImplementationPage {
    Response response;
    public APIImplementationPage() {
        // Optionally configure base URI if necessary
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users/";
    }

    public void sendGetRequest(String UserId) {
         response = given().when().get(RestAssured.baseURI + UserId);
    }

    public void validateResponseStatusCode(int expectedStatusCode) {
        System.out.println(response.getStatusCode());
        response.then().statusCode(expectedStatusCode);
    }

    public void validateUserInformation() {
        response.prettyPrint();
        response.then()
                .body("id", equalTo(2))
                .body("name", notNullValue())
                .body("email", notNullValue());
    }

    public void SendGetRequest() {
        response = given().when().get(RestAssured.baseURI);
    }


    public void verifyTotalRecordsInTheResponseBody() {
        int totalRecords = response.jsonPath().getList("").size();
        System.out.println("Total number of Records: " + totalRecords);
    }

    public void iSendAPOSTRequestToTheAPI(String JsonBody) {
        System.out.println("adding details:- ");
        response = given().contentType(ContentType.JSON).body(JsonBody).when()
                .post(RestAssured.baseURI).then().extract().response();
        response.prettyPrint();
    }
}



