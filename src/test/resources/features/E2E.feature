Feature: E2E functionality test

  Background: Login to SauceDemo website
    Given user login to SauceDemo website

    @E2EFunc1 @regression
    Scenario: Verify Add To Cart functionality
      Given Home page is displayed
      Then Select the item "Sauce Labs Backpack" for Add To Cart
      Then Select the item "Test.allTheThings() T-Shirt (Red)" for Add To Cart
      Then Select the item "Sauce Labs Bolt T-Shirt" for Add To Cart
      When user clicks on "shopping_cart_link" button
      Then user is able to see "Your Cart" title
      Then verify the cart items
      And user clicks on "CHECKOUT" button
      Then user is able to see "Checkout: Your Information" title
      Then user enters data "TestFirst" in "first-name" field
      Then user enters data "TestLast" in "last-name" field
      Then user enters data "577204" in "postal-code" field
      And user clicks on "CONTINUE" button
      Then user is able to see "Checkout: Overview" title
      And verify the cart items
      And user clicks on "FINISH" button
      Then user is able to see "Finish" title
      Then user is able to see the text "THANK YOU FOR YOUR ORDER"
      Then user is able to see the text "Your order has been dispatched, and will arrive just as fast as the pony can get"