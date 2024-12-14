Feature: Login tests
  Verify the login functionality for SauceDemo website

  Background: Login to SauceDemo website
    Given user login to SauceDemo website

  @DataTableHeaders
  Scenario: Login to Bhinneka.com using valid account that registered in personal and corporate account type
    Given Login page is displayed
    When Input credentials to login with headers table
    | Email             | Password     | Account Type           |
    | your@email.com    | Yourp@ssw0rd | personal and corporate |
    And Click selanjutnya button

  @Test1
  Scenario: Verify Login to SauceDemo website
    Given Home page is displayed

  @Test2
  Scenario Outline: verify Login to SauceDemo website using different credentials
    Given Home page is displayed
    When user clicks on "Open Menu" button
    Then user is able to see "Logout" button
    Then user clicks on "Logout" button
    Then user is able to see "LOGIN" button

    Then user provided username "<username>" and password "<password>"
    Then user clicks on "LOGIN" button
    Then Home page is displayed
    Examples:
      | username | password |
      | problem_user | secret_sauce |
      | performance_glitch_user | secret_sauce |



