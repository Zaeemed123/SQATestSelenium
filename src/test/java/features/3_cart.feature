Feature: Cart Page Feature
  @checkoutCart @completeCheckout
  Scenario: Checkout cart
    Given User is on Cart Page
    And User clicks on checkout button
    Then the user is redirected to the checkout screen one