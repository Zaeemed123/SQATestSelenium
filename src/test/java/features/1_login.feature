Feature: Login the website
  @successfulLogin @addToCart @removeFromCart @filterItems @checkoutCart @completeCheckout @logout
  Scenario: Successful login to the website
    Given User is on login page
    When he enters the username "standard_user" and password "secret_sauce"
    And clicks on the login button
    Then he should be redirected to home page

    @failedLogin
    Scenario: Unsuccessful login to the website
      Given User is on login page
      When he enters the username "random_user" and password "random_password"
      And clicks on the login button
      Then he should see the error message