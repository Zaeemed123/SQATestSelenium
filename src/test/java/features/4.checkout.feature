Feature: Checkout Pages Feature
  @completeCheckout
  Scenario: Checkout Cart to Place order
    Given User is on Checkout Page
    And User enters his first name as "Zaeem", last name as "Ahmed" and zip code as "75210"
    And User clicks on continue button
    Then User is redirected to second page
    And User clicks on finish button
    Then the user is redirected to the checkout complete screen