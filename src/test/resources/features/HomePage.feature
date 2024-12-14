Feature: Homepage tests
  Verify the Homepage functionality for SauceDemo website

  Background: Login to SauceDemo website
    Given user login to SauceDemo website

  @Test3
  Scenario: verify the list items in Homepage
    Given Home page is displayed
    Then verifying the list items in Homepage