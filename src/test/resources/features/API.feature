@API
Feature: API testing fundamentals

  @API_1
  Scenario: Get user information by ID
 #   Given I have the API endpoint for user "2"
    When I send a GET request to the API for user "2"
    Then the response status code should be 200
    And the response body should contain the user information

  @API_2
  Scenario: Get the total number of users in Json
 #   Given I have the API endpoint for user "2"
    When I send a GET request to the API
    Then the response status code should be 200
    Then verify total records in the response body

  @API_3
  Scenario: Get the total number of users after inserting new record using POST method
 #   Given I have the API endpoint for user "2"
    When I send a POST request to the API with request body from file "requestBody.json"
    Then the response status code should be 201
    When I send a GET request to the API
    Then the response status code should be 200
    Then verify total records in the response body